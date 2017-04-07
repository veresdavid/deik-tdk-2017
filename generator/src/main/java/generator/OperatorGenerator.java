package generator;


import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.lang.model.element.Modifier;
import representation.ClassRepresentation;
import representation.ParameterRepresentation;
import representation.operator.OperatorRepresentation;
import utils.GeneratorUtil;

public class OperatorGenerator {

  private Map<String, Object> namedArguments = new HashMap<>();

  public OperatorGenerator() {
  }

  public ClassRepresentation generate(OperatorRepresentation operatorRepresentation, ClassRepresentation stateClass,
      String directoryName, String packageName, String fileName, boolean keepTogetherGettersAndSetters)
      throws IOException {

    //TODO: Handle error
    if (operatorRepresentation == null || stateClass == null) {
      System.out.println("Error");
    }

    fillNamedArguments(operatorRepresentation, stateClass);

    ClassName className = ClassName.get(packageName, fileName);
    List<ParameterRepresentation> parameters = operatorRepresentation.getParameters();
    List<FieldSpec> fields = GeneratorUtil.generateFieldsFromParameters(parameters);

    TypeSpec operator = TypeSpec.classBuilder(fileName)
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(OperatorInterface.class)
        .addAnnotation(generateSuppressWarningsAnnotation())
        .addFields(fields)
        .addField(generateCostField(operatorRepresentation))
        .addMethod(generateInitOperatorsMethod(parameters, className))
        .addMethod(GeneratorUtil.generateEmptyConstructor())
        .addMethod(GeneratorUtil.generateConstructor(fields))
        .addMethods(
            GeneratorUtil.generateGettersAndSetters(fields, keepTogetherGettersAndSetters))
        .addMethod(GeneratorUtil.generateEqualsMethod(fields, className, fileName.toLowerCase()))
        .addMethod(GeneratorUtil.generateHashCodeMethod(fields))
        .addMethod(GeneratorUtil.generateToStringMethod(fields, className))
        .addMethod(generateIsApplicableMethod(operatorRepresentation, stateClass))
        .addMethod(generateApplyMethod(operatorRepresentation, stateClass))
        .addMethod(generateGetCostMethod())
        .build();

    JavaFile javaFile = JavaFile.builder(packageName, operator)
        .skipJavaLangImports(true)
        .build();

    Path path = Paths.get(directoryName);
    javaFile.writeTo(path);
    String filePath = GeneratorUtil.getFilePath(directoryName, packageName, fileName);

    return new ClassRepresentation(className, fields, filePath);
  }

  private AnnotationSpec generateSuppressWarningsAnnotation() {
    AnnotationSpec.Builder builder = AnnotationSpec.builder(SuppressWarnings.class)
        .addMember("value", "$S", "unchecked");

    return builder.build();
  }

  private MethodSpec generateInitOperatorsMethod(List<ParameterRepresentation> parameters,
      ClassName className) {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("initOperators")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class);

    ParameterizedTypeName returnType = ParameterizedTypeName.get(List.class, OperatorInterface.class);

    builder.returns(returnType);

    String lowerCaseClassName = className.simpleName().toLowerCase();
    String parameterNames = GeneratorUtil.getParameterNamesAsString(parameters);

    builder.addStatement("$1T result = new $2T<>()", returnType, ArrayList.class);

    for (ParameterRepresentation parameter : parameters) {
      String parameterName = parameter.getParameterName();
      String from = parameter.getFrom().toString();
      String to = parameter.getTo().toString();
      String by = parameter.getBy().toString();

      builder
          .beginControlFlow(GeneratorUtil.generateForStatement(parameterName, from, to, by), int.class);
    }

    builder.addStatement("$T $L = new $T($L)", className, lowerCaseClassName,
        className, parameterNames)
        .addStatement("result.add($L)", lowerCaseClassName);

    for (ParameterRepresentation parameter : parameters) {
      builder.endControlFlow();
    }

    builder.addStatement("return result");

    return builder.build();

  }

  private MethodSpec generateIsApplicableMethod(OperatorRepresentation operatorRepresentation,
      ClassRepresentation stateClass) {
    String parameterName = "stateObject";
    MethodSpec.Builder builder = MethodSpec.methodBuilder("isApplicable")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(boolean.class)
        .addParameter(StateInterface.class, parameterName)
        .addStatement("$1T $2L = true", boolean.class, "result")
        .addStatement("$1T $2L = (($1T) $3L)", stateClass.getClassName(), "original", parameterName)
        .addCode(GeneratorUtil.generateStatements(operatorRepresentation.getPreconditionExpressions(), namedArguments))
        .addCode("\n")
        .addStatement("return result");

    return builder.build();
  }


  private MethodSpec generateApplyMethod(OperatorRepresentation operatorRepresentation,
      ClassRepresentation stateClass) {
    String parameterName = "stateObject";
    MethodSpec.Builder builder = MethodSpec.methodBuilder("apply")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(StateInterface.class)
        .addParameter(StateInterface.class, parameterName);

    builder
        .addStatement("$1T $2L = (($1T) $3L)", stateClass.getClassName(), "original", parameterName)
        .addStatement("$1T $2L = original.copy()", stateClass.getClassName(), "state");

//    builder.addStatement("System.out.println(\"before: \" + state)");

    builder.addCode("\n");

    builder.addCode(GeneratorUtil.generateStatements(operatorRepresentation.getEffectExpressions(), namedArguments));

    builder.addCode("\n");

//    builder.addStatement("System.out.println(GeneratedUtils.sum(state))");

    builder.addStatement("return state");

    return builder.build();
  }

  private FieldSpec generateCostField(OperatorRepresentation operatorRepresentation) {
    FieldSpec.Builder builder = FieldSpec.builder(Double.class, "cost")
        .addModifiers(Modifier.PRIVATE)
        .initializer("$L", operatorRepresentation.getCost());

    return builder.build();
  }

  private MethodSpec generateGetCostMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("getCost")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(double.class);

    builder.addStatement("return cost");

    return builder.build();
  }

  private void fillNamedArguments(OperatorRepresentation operatorRepresentation, ClassRepresentation stateClass) {
    namedArguments.clear();

    namedArguments.put(GeneratorUtil.hashSetEntry.getKey(), GeneratorUtil.hashSetEntry.getValue());
    namedArguments.put(GeneratorUtil.arraysEntry.getKey(), GeneratorUtil.arraysEntry.getValue());
    namedArguments.put("result", "state");
    namedArguments.put("original", "original");

    for (ParameterRepresentation parameter : operatorRepresentation.getParameters()) {

      boolean containsError = false;

      Integer from = parameter.getFrom();
      Integer to = parameter.getTo();
      Integer by = parameter.getBy();

      TypeName typeName = stateClass.getFields().get(from).type;

      for (int i = from + by; i <= to; i += by) {
        if (i >= stateClass.getFields().size() || !stateClass.getFields().get(i).type.equals(typeName)) {
          containsError = true;
          break;
        }
      }

      if (containsError) {
        namedArguments.put(parameter.getParameterName(), "error");
      } else {
        namedArguments.put(parameter.getParameterName(), typeName);
      }
    }
  }
}