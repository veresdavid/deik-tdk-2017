package utils;

import antlr.SMLParser.Parameter_description_lineContext;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.CodeBlock;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import enums.ExpressionType;
import enums.VarStruct;
import enums.VarType;
import interfaces.Expression;
import java.io.File;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.lang.model.element.Modifier;
import representation.ExpressionRepresentation;
import representation.ForExpressionRepresentation;
import representation.ParameterRepresentation;
import representation.VarDefiningExpression;
import representation.state.AttributeRepresentation;

public final class GeneratorUtil {

  //TODO: Refactor set assign method

  public static final Map.Entry<String, Object> hashSetEntry = new SimpleEntry<>("hash_set", HashSet.class);
  public static final Map.Entry<String, Object> arraysEntry = new SimpleEntry<>("arrays", Arrays.class);

  public static List<FieldSpec> generateFieldsFromAttributes(
      List<AttributeRepresentation> attributes) {
    List<FieldSpec> fieldList = new ArrayList<>();

    for (AttributeRepresentation currentAttribute : attributes) {
      String attributeName = currentAttribute.getAttributeName().toLowerCase();
      ParameterizedTypeName attributeType = getAttributeType(currentAttribute);

      FieldSpec currentField = FieldSpec
          .builder(attributeType, attributeName)
          .addModifiers(Modifier.PRIVATE)
          .build();

      fieldList.add(currentField);
    }

    return fieldList;
  }

  public static List<FieldSpec> generateFieldsFromParameters(
      List<ParameterRepresentation> parameters) {

    List<FieldSpec> fieldList = new ArrayList<>();

    for (ParameterRepresentation parameter : parameters) {
      String parameterName = parameter.getParameterName();

      FieldSpec currentField = FieldSpec
          .builder(Integer.class, parameterName)
          .addModifiers(Modifier.PRIVATE)
          .build();

      fieldList.add(currentField);
    }

    return fieldList;
  }

  public static MethodSpec generateEmptyConstructor() {
    MethodSpec.Builder builder = MethodSpec.constructorBuilder()
        .addModifiers(Modifier.PUBLIC);

    return builder.build();
  }

  public static MethodSpec generateConstructor(List<FieldSpec> fields) {
    MethodSpec.Builder builder = MethodSpec.constructorBuilder()
        .addModifiers(Modifier.PUBLIC);

    for (FieldSpec field : fields) {
      builder.addParameter(field.type, field.name)
          .addStatement("this.$1L = $1L", field.name);
    }

    return builder.build();
  }

  public static MethodSpec generateGetter(FieldSpec field) {
    String attributeName = field.name;
    String upperCaseAttributeName =
        attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
    TypeName attributeClass = field.type;

    MethodSpec.Builder builder = MethodSpec.methodBuilder("get" + upperCaseAttributeName)
        .addModifiers(Modifier.PUBLIC)
        .returns(attributeClass)
        .addStatement("return " + attributeName);

    return builder.build();
  }

  public static MethodSpec generateSetter(FieldSpec field) {
    String attributeName = field.name;
    String upperCaseAttributeName =
        attributeName.substring(0, 1).toUpperCase() + attributeName.substring(1);
    TypeName attributeClass = field.type;

    MethodSpec.Builder builder = MethodSpec.methodBuilder("set" + upperCaseAttributeName)
        .addModifiers(Modifier.PUBLIC)
        .returns(TypeName.VOID)
        .addParameter(attributeClass, attributeName)
        .addStatement("this." + attributeName + " = " + attributeName);

    return builder.build();
  }

  public static List<MethodSpec> generateGettersAndSetters(List<FieldSpec> fields,
      boolean keepTogetherGettersAndSetters) {
    List<MethodSpec> gettersAndSetters = new ArrayList<>();
    if (keepTogetherGettersAndSetters) {
      for (FieldSpec currentField : fields) {
        gettersAndSetters.add(generateGetter(currentField));
        gettersAndSetters.add(generateSetter(currentField));
      }
    } else {
      for (FieldSpec currentField : fields) {
        gettersAndSetters.add(generateGetter(currentField));
      }
      for (FieldSpec currentField : fields) {
        gettersAndSetters.add(generateSetter(currentField));
      }
    }
    return gettersAndSetters;
  }

  public static MethodSpec generateEqualsMethod(List<FieldSpec> fields, ClassName className,
      String fieldName) {
    final String parameterName = "o";

    MethodSpec.Builder builder = MethodSpec.methodBuilder("equals")
        .addAnnotation(Override.class)
        .addModifiers(Modifier.PUBLIC)
        .returns(boolean.class)
        .addParameter(TypeName.OBJECT, parameterName);

    builder.beginControlFlow("if (this == $L)", parameterName)
        .addStatement("return $L", true)
        .endControlFlow();

    builder.beginControlFlow("if ($1L == null || getClass() != $1L.getClass())", parameterName)
        .addStatement("return $L", false)
        .endControlFlow();

    builder.addCode("\n");
    builder.addStatement("$1T $2L = ($1T) $3L", className, fieldName, parameterName);
    builder.addCode("\n");

    for (FieldSpec field : fields) {
      String attributeName = field.name;
      if (fields.indexOf(field) != fields.size() - 1) {
        builder.beginControlFlow("if ($1L != null ? !$1L.equals($2L.$1L) : $2L.$1L != null)",
            attributeName, fieldName)
            .addStatement("return $L", false)
            .endControlFlow();
      } else {
        builder.addStatement("return $1L != null ? $1L.equals($2L.$1L) : $2L.$1L == null",
            attributeName, fieldName);
      }
    }
    return builder.build();
  }

  public static MethodSpec generateHashCodeMethod(List<FieldSpec> fields) {
    String fieldName = "result";

    MethodSpec.Builder builder = MethodSpec.methodBuilder("hashCode")
        .addAnnotation(Override.class)
        .returns(int.class)
        .addModifiers(Modifier.PUBLIC);

    for (FieldSpec field : fields) {
      String attributeName = field.name;

      if (fields.indexOf(field) == 0) {
        builder.addStatement("$1T $2L = $3L != null ? $3L.hashCode() : 0", int.class, fieldName,
            attributeName);
      } else {
        builder.addStatement("$1L = 31 * $1L + ($2L != null ? $2L.hashCode() : 0)", fieldName,
            attributeName);
      }
    }

    builder.addStatement("return $L", fieldName);

    return builder.build();
  }

  public static MethodSpec generateToStringMethod(List<FieldSpec> fields, ClassName className) {
    MethodSpec.Builder builder = MethodSpec.methodBuilder("toString")
        .addAnnotation(Override.class)
        .addModifiers(Modifier.PUBLIC)
        .returns(String.class);

    builder.addCode("return $S +\n", className.simpleName() + "{");

    for (FieldSpec field : fields) {
      String attributeName = field.name;
      if (fields.indexOf(field) == 0) {
        builder.addCode("\t$S + $L +\n", attributeName + "=", attributeName);
      } else {
        builder.addCode("\t$S + $L +\n", ", " + attributeName + "=", attributeName);
      }
    }

    builder.addStatement("\t$S", '}');

    return builder.build();
  }

  public static CodeBlock generateForBlock(ForExpressionRepresentation forExpression,
      Map<String, Object> namedArguments) {
    CodeBlock.Builder builder = CodeBlock.builder();

    String variableName = forExpression.getVariable();
    String from = forExpression.getFrom();
    String to = forExpression.getTo();
    String by = forExpression.getBy();

    builder.beginControlFlow(GeneratorUtil
        .generateForStatement(variableName, from, to, by), Double.class)
        .add(generateStatements(forExpression.getExpressions(), namedArguments))
        .endControlFlow();

    return builder.build();
  }

  //TODO: Throws missing argument exception
  public static CodeBlock generateStatements(List<Expression> expressions, Map<String, Object> namedArguments) {
    CodeBlock.Builder builder = CodeBlock.builder();

    for (Expression expression : expressions) {
      ExpressionType expressionType = expression.getExpressionType();

      switch (expressionType) {
        case FOR_EXPR:
          builder.add(generateForBlock(((ForExpressionRepresentation) expression), namedArguments));
          break;

        case VAR_DEFINING_EXPR:
          VarDefiningExpression varDefiningExpression = ((VarDefiningExpression) expression);
          ClassName className = varDefiningExpression.getClassName();
          String varName = varDefiningExpression.getVarName();
          String value = varDefiningExpression.getValue();

          builder.add("$1T $2L = ", className, varName);

          builder.addNamed(value, namedArguments)
              .add(";\n");
          break;

        case COMPARE_EXPR:
        case BOOL_EXPR:
          builder.add("result = result && ");
          //Continue on default

        default:
          ExpressionRepresentation expressionRepresentation = ((ExpressionRepresentation) expression);
          builder.addNamed(expressionRepresentation.getValue(), namedArguments)
              .add(";\n");
          break;
      }
    }
    return builder.build();
  }

  public static ParameterizedTypeName getAttributeType(AttributeRepresentation attribute) {
    TypeName innerType = getInnerAttributeType(attribute);
    return attribute.getVarStruct().equals(VarStruct.SET) ? ParameterizedTypeName
        .get(ClassName.get(Set.class), innerType)
        : ParameterizedTypeName.get(ClassName.get(List.class), innerType);
  }

  public static TypeName getInnerAttributeType(AttributeRepresentation attribute) {
    if (attribute.getVarStruct().equals(VarStruct.SET)) {
      return attribute.getVarType().equals(VarType.NUMBER) ? TypeName.get(Double.class)
          : TypeName.get(String.class);
    } else {
      return attribute.getVarType().equals(VarType.NUMBER) ? ParameterizedTypeName
          .get(List.class, Double.class) : ParameterizedTypeName.get(List.class, String.class);
    }
  }

  public static ParameterRepresentation getParameterRepresentationFromContext(
      Parameter_description_lineContext parameter) {

    String paramName = parameter.PARAM_NAME().getText();
    Integer from = Integer.parseInt(parameter.INT(0).getText());
    Integer to = Integer.parseInt(parameter.INT(1).getText());
    Integer by = parameter.INT(2) == null ? 1 : Integer.parseInt(parameter.INT(2).getText());

    ParameterRepresentation parameterRepresentation = new ParameterRepresentation();
    parameterRepresentation.setParameterName(paramName);
    parameterRepresentation.setFrom(from);
    parameterRepresentation.setTo(to);
    parameterRepresentation.setBy(by);

    return parameterRepresentation;
  }

  public static String generateForStatement(String variable, String from, String to, String by) {
    return "for($1T " + variable + " = " + from + "; " + variable + "<=" + to + "; " + variable + " += " + by + ")";
  }


  public static String getParameterNamesAsString(List<ParameterRepresentation> parameters) {
    return parameters.stream().map(ParameterRepresentation::getParameterName)
        .collect(Collectors.joining(", "));
  }

  public static String getFilePath(String directoryName, String packageName, String fileName) {
    return new File(
        directoryName + "\\" + packageName.replace(".", "\\") + "\\" + fileName + ".java")
        .getAbsolutePath();
  }
}