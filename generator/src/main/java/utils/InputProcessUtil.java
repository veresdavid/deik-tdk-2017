package utils;

import antlr.SMLParser.DimensionContext;
import antlr.SMLParser.ExpressionContext;
import antlr.SMLVisitor;
import enums.ExpressionType;
import interfaces.Expression;
import java.util.ArrayList;
import java.util.List;
import misc.Dimension;
import representation.expression.ExpressionRepresentation;
import representation.expression.VarDefiningExpressionRepresentation;

public final class InputProcessUtil {

  private InputProcessUtil() {
  }

  public static Dimension getDimensionFromContext(DimensionContext dimension, SMLVisitor<Expression> visitor) {
    String dimensionN = getExpressionContextValue(dimension.dimensionN, visitor);
    dimensionN = "Double.valueOf(" + dimensionN + ").intValue()";

    String dimensionM = getExpressionContextValue(dimension.dimensionM, visitor);
    dimensionM = "Double.valueOf(" + dimensionM + ").intValue()";

    return new Dimension(dimensionN, dimensionM);
  }

  public static String getExpressionContextValue(ExpressionContext expressionContext, SMLVisitor<Expression> visitor) {
    InputValidatorUtil.ensureExpressionContextTypeIsNot(expressionContext, visitor,
        ExpressionType.FOR_EXPR, ExpressionType.IF_EXPR, ExpressionType.VAR_DEFINING_EXPR);

    return ((ExpressionRepresentation) visitor.visit(expressionContext)).getValue();
  }


  public static List<String> getVarNames(List<Expression> expressions) {
    List<String> result = new ArrayList<>();

    for (Expression expression : expressions) {
      if (expression.getExpressionType().equals(ExpressionType.VAR_DEFINING_EXPR)) {
        String varName = ((VarDefiningExpressionRepresentation) expression).getVarName();
        result.add(varName);
      }
    }

    return result;
  }
}
