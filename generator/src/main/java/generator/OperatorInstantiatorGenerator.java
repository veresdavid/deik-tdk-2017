package generator;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import interfaces.OperatorInstantiatorInterface;
import interfaces.OperatorInterface;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javax.lang.model.element.Modifier;
import representation.ClassRepresentation;
import utils.GeneratorUtil;

public class OperatorInstantiatorGenerator {

  private List<ClassRepresentation> operatorRepresentations = new ArrayList<>();

  public List<ClassRepresentation> getOperatorRepresentations() {
    return operatorRepresentations;
  }

  public void setOperatorRepresentations(
      List<ClassRepresentation> operatorRepresentations) {
    this.operatorRepresentations = operatorRepresentations;
  }

  public ClassRepresentation generate(String directoryName, String packageName,
      String fileName) throws IOException {

    if (operatorRepresentations.isEmpty()) {
      System.out.println("Hiba!");
    }

    ClassName className = ClassName.get(packageName, fileName);

    TypeSpec state = TypeSpec.classBuilder(fileName)
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(OperatorInstantiatorInterface.class)
        .addMethod(generateGetOperatorInstancesMethod())
        .build();

    JavaFile javaFile = JavaFile.builder(packageName, state)
        .skipJavaLangImports(true)
        .build();

    Path path = Paths.get(directoryName);

    javaFile.writeTo(path);

    String filePath = GeneratorUtil.getFilePath(directoryName, packageName, fileName);

    return new ClassRepresentation(className, null, filePath);
  }

  private MethodSpec generateGetOperatorInstancesMethod() {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("getOperatorInstances")
        .addModifiers(Modifier.PUBLIC)
        .addAnnotation(Override.class)
        .returns(ParameterizedTypeName.get(List.class, OperatorInterface.class));

    builder.addStatement("$1T<$2T> result = new $3T<>()", List.class, OperatorInterface.class,
        ArrayList.class);

    builder.addCode("\n");

    for (ClassRepresentation operator : operatorRepresentations) {
      String lowercaseOperatorName = operator.getClassName().simpleName().toLowerCase();
      ClassName operatorClass = operator.getClassName();

      builder.addStatement("$1T $2L = new $1T()", operatorClass, lowercaseOperatorName)
          .addStatement("$L.initOperators()", lowercaseOperatorName)
          .addStatement("result.addAll($T.OPERATORS)", operatorClass);

      builder.addCode("\n");
    }

    builder.addStatement("return result");
    return builder.build();
  }
}