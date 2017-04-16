package utils;

import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.Parameter_description_lineContext;
import antlr.SMLParser.State_description_lineContext;
import antlr.SMLParser.Var_defining_expressionContext;
import antlr.SMLVisitor;
import enums.ExpressionType;
import exceptions.InvalidAttributeName;
import exceptions.VarNameAlreadyInUseException;
import exceptions.WrongExpressionTypeException;
import interfaces.Expression;
import java.util.List;
import org.antlr.v4.runtime.Token;
import representation.expression.VarDefiningExpressionRepresentation;
import representation.operator.ParameterRepresentation;
import representation.state.AttributeRepresentation;

public class InputValidatorUtil {

  public static void ensureAttributeNameIsCorrect(State_description_lineContext ctx,
      List<AttributeRepresentation> attributes) {
    String attrName = ctx.attr_name().getText();

    if (!isCorrectAttributeName(attrName, attributes)) {
      throw new InvalidAttributeName(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine(), attrName);
    }
  }

  public static void ensureVarNameIsAvailable(List<String> varNames, ExpressionContext ctx,
      SMLVisitor<Expression> visitor) {
    Expression expression = visitor.visit(ctx);

    if (expression.getExpressionType().equals(ExpressionType.VAR_DEFINING_EXPR)) {
      String varName = ((VarDefiningExpressionRepresentation) expression).getVarName();
      if (varNames.stream().anyMatch(name -> name.equals(varName))) {
        Token offendingToken = ((Var_defining_expressionContext) ctx).PARAM_NAME().getSymbol();
        throw new VarNameAlreadyInUseException(offendingToken.getLine(), offendingToken.getCharPositionInLine(),
            varName);
      }
    }

  }

  public static void ensureParameterIsAvailable(List<ParameterRepresentation> parameters,
      Parameter_description_lineContext ctx, SMLVisitor<Expression> visitor) {

    String parameterName = ctx.PARAM_NAME().getText();

    if (parameters.stream().anyMatch(parameter -> parameter.getParameterName().equals(parameterName))) {
      Token offendingToken = ctx.PARAM_NAME().getSymbol();
      throw new VarNameAlreadyInUseException(offendingToken.getLine(), offendingToken.getCharPositionInLine(),
          parameterName);
    }
  }

  public static void ensureExpressionContextTypeIs(ExpressionContext expressionContext, SMLVisitor<Expression> visitor,
      ExpressionType... expressionTypes) {

    if (!checkExpressionContextTypeIs(expressionContext, visitor, expressionTypes)) {

      Expression expression = visitor.visit(expressionContext);
      int line = expressionContext.getStart().getLine();
      int charPosition = expressionContext.getStart().getCharPositionInLine();

      throw new WrongExpressionTypeException(line, charPosition, expression.getExpressionType());
    }
  }

  public static void ensureExpressionContextTypeIsNot(ExpressionContext expressionContext,
      SMLVisitor<Expression> visitor, ExpressionType... expressionTypes) {

    if (!checkExpressionContextTypeIsNot(expressionContext, visitor, expressionTypes)) {
      Expression expression = visitor.visit(expressionContext);
      int line = expressionContext.getStart().getLine();
      int charPosition = expressionContext.getStart().getCharPositionInLine();
      throw new WrongExpressionTypeException(line, charPosition, expression.getExpressionType());
    }
  }

  public static boolean checkExpressionContextTypeIs(ExpressionContext expressionContext,
      SMLVisitor<Expression> visitor, ExpressionType... expressionTypes) {
    Expression expression = visitor.visit(expressionContext);

    for (ExpressionType expressionType : expressionTypes) {
      if (expression.getExpressionType().equals(expressionType)) {
        return true;
      }
    }
    return false;
  }

  public static boolean checkExpressionContextTypeIsNot(ExpressionContext expressionContext,
      SMLVisitor<Expression> visitor,
      ExpressionType... expressionTypes) {

    Expression expression = visitor.visit(expressionContext);

    for (ExpressionType expressionType : expressionTypes) {
      if (expression.getExpressionType().equals(expressionType)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isCorrectAttributeName(String attributeName, List<AttributeRepresentation> attributes) {
    Integer number = Integer.parseInt(attributeName.replace("attr", ""));
    return number.equals(attributes.size());
  }
}
