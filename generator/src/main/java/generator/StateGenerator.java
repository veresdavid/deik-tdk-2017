package generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import enums.VarStruct;
import enums.VarType;
import interfaces.StateInterface;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import representation.ClassRepresentation;
import representation.state.AttributeRepresentation;
import representation.state.StateRepresentation;
import utils.GeneratorUtil;

//TODO: Review set functions
public class StateGenerator {

  private Map<String, Object> namedArguments = new HashMap<>();

  public StateGenerator() {
  }

  public ClassRepresentation generate(StateRepresentation stateRepresentation, String directoryName, String packageName,
      String fileName, boolean keepTogetherGettersAndSetters) throws IOException {

    //TODO: Handle error
    if (stateRepresentation == null) {
      System.out.println("Error");
    }

    fillNamedArguments(stateRepresentation);

    ClassName className = ClassName.get(packageName, fileName);
    List<AttributeRepresentation> attributes = stateRepresentation.getAttributes();
    List<FieldSpec> fields = GeneratorUtil.generateFieldsFromAttributes(attributes);

    TypeSpec state = TypeSpec.classBuilder(fileName)
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(StateInterface.class)
        .addFields(fields)
        .addMethod(generateConstructWithInitializer(stateRepresentation))
        .addMethods(
            GeneratorUtil.generateGettersAndSetters(fields, keepTogetherGettersAndSetters))
        .addMethod(generateGetStartMethod(stateRepresentation, className))
        .addMethod(generateIsGoalMethod(stateRepresentation))
        .addMethod(GeneratorUtil.generateEqualsMethod(fields, className, fileName.toLowerCase()))
        .addMethod(GeneratorUtil.generateHashCodeMethod(fields))
        .addMethod(GeneratorUtil.generateToStringMethod(fields, className))
        .addMethod(generateCopyMethod(stateRepresentation, className))
        .addMethod(generateGetAttributeByNumberMethod())
        .addMethod(generateSetAttributeByNumberMethod())
        .build();

    JavaFile javaFile = JavaFile.builder(packageName, state)
        .skipJavaLangImports(true)
        .build();

    Path path = Paths.get(directoryName);

    javaFile.writeTo(path);

    String filePath = GeneratorUtil.getFilePath(directoryName, packageName, fileName);

    return new ClassRepresentation(className, fields, filePath);
  }

  private MethodSpec generateConstructWithInitializer(StateRepresentation stateRepresentation) {
    MethodSpec.Builder builder = MethodSpec.constructorBuilder()
        .addModifiers(Modifier.PUBLIC);

    for (AttributeRepresentation currentAttribute : stateRepresentation.getAttributes()) {
      builder.addCode(generateInitializer(currentAttribute));
      builder.addCode("\n");
    }

    return builder.build();
  }

  private CodeBlock generateInitializer(AttributeRepresentation attribute) {
    CodeBlock.Builder builder = CodeBlock.builder();
    String attributeName = attribute.getAttributeName();

    if (attribute.getVarStruct().equals(VarStruct.SET)) {
      builder
          .addStatement("this.set" + attributeName + "(new $T<>())", HashSet.class);
    } else {
      String dimensionN = attribute.getDimension().getDimensionN();
      String dimensionM = attribute.getDimension().getDimensionM();
      TypeName attributeType = GeneratorUtil.getAttributeType(attribute);
      TypeName innerAttributeType = GeneratorUtil.getInnerAttributeType(attribute);

      builder
          .addStatement("$T init" + attributeName + "= new $T<>()", attributeType, ArrayList.class)
          .beginControlFlow("for(int i = 0; i<$L; i++)", dimensionN)
          .addStatement("$1T tmpList = new $2T<>()", innerAttributeType, ArrayList.class)
          .beginControlFlow("for(int j = 0; j<$L; j++)", dimensionM)
          .add(getMatrixStart(attribute))
          .endControlFlow()
          .addStatement("init" + attributeName + ".add(tmpList)")
          .endControlFlow()
          .addStatement("this.set" + attributeName + "(init" + attributeName + ")");
    }

    return builder.build();
  }

  private CodeBlock getMatrixStart(AttributeRepresentation attribute) {
    CodeBlock.Builder builder = CodeBlock.builder();

    if (attribute.getVarType().equals(VarType.NUMBER)) {
      builder.addStatement("tmpList.add($L)", 0d);
    } else {
      builder.addStatement("tmpList.add(new $T())", String.class);
    }

    return builder.build();
  }

  private MethodSpec generateGetStartMethod(StateRepresentation stateRepresentation, ClassName className) {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("getStart")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(className)
        .addStatement("$1T state = new $1T()", className);

    builder.addCode(GeneratorUtil.generateStatements(stateRepresentation.getStartExpressions(), namedArguments));

    builder.addStatement("return state");

    return builder.build();
  }

  private MethodSpec generateIsGoalMethod(StateRepresentation stateRepresentation) {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("isGoal")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(boolean.class)
        .addStatement("$1T $2L = true", boolean.class, "result");

    builder.addCode(GeneratorUtil.generateStatements(stateRepresentation.getGoalExpressions(), namedArguments));

    builder.addStatement("return result");

    return builder.build();
  }

  private MethodSpec generateCopyMethod(StateRepresentation stateRepresentation, ClassName className) {
    String resultName = "result";

    MethodSpec.Builder builder = MethodSpec.methodBuilder("copy")
        .addModifiers(Modifier.PUBLIC)
        .returns(className);

    builder.addStatement("$1T $2L = new $1T()", className, resultName);

    for (AttributeRepresentation attribute : stateRepresentation.getAttributes()) {
      Class typeClass =
          attribute.getVarType().equals(VarType.NUMBER) ? Double.class : String.class;
      String lowerCaseAttributeName = attribute.getAttributeName().toLowerCase();

      if (attribute.getVarStruct().equals(VarStruct.SET)) {
        builder.beginControlFlow("for ($1T element : $2L)", typeClass, lowerCaseAttributeName)
            .addStatement("$1L.get$2L().add(element)", resultName, attribute.getAttributeName())
            .endControlFlow();

      } else {
        builder.beginControlFlow("for ($1T i=0; i < $2L.size(); i++)", Integer.class, lowerCaseAttributeName)
            .addStatement("$1T<$2T> tmpList = new $3T<>()", List.class, typeClass, ArrayList.class)
            .beginControlFlow("for ($1T element : $2L.get(i))", typeClass, lowerCaseAttributeName)
            .addStatement("tmpList.add(element)")
            .endControlFlow()
            .addStatement("$1L.get$2L().set(i, tmpList)", resultName,
                attribute.getAttributeName())
            .endControlFlow();
      }
    }

    builder.addStatement("return $L", resultName);

    return builder.build();
  }

  private MethodSpec generateGetAttributeByNumberMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("getAttributeByNumber")
        .returns(Object.class)
        .addModifiers(Modifier.PUBLIC)
        .addParameter(Integer.class, "number");

    builder.beginControlFlow("try")
        .addStatement("return this.getClass().getDeclaredFields()[number].get(this)")
        .endControlFlow()
        .beginControlFlow("catch($T e)", IllegalAccessException.class)
        .addStatement("e.printStackTrace()")
        .endControlFlow();

    builder.addStatement("return null");

    return builder.build();
  }

  private MethodSpec generateSetAttributeByNumberMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("setAttributeByNumber")
        .returns(void.class)
        .addModifiers(Modifier.PUBLIC)
        .addParameter(Integer.class, "number")
        .addParameter(Object.class, "value");

    builder.beginControlFlow("try")
        .addStatement("this.getClass().getDeclaredFields()[number].set(this, value)")
        .endControlFlow()
        .beginControlFlow("catch($T e)", IllegalAccessException.class)
        .addStatement("e.printStackTrace()")
        .endControlFlow();

    return builder.build();
  }

  private void fillNamedArguments(StateRepresentation stateRepresentation) {
    namedArguments.clear();

    namedArguments.put(GeneratorUtil.hashSetEntry.getKey(), GeneratorUtil.hashSetEntry.getValue());
    namedArguments.put(GeneratorUtil.arraysEntry.getKey(), GeneratorUtil.arraysEntry.getValue());
    namedArguments.put("result", "state");
    namedArguments.put("original", "this");
  }
}