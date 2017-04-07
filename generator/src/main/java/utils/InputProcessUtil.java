package utils;

import antlr.SMLParser.DimensionContext;
import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.Set_init_exprContext;
import antlr.SMLVisitor;
import enums.ExpressionType;
import interfaces.Expression;
import misc.Dimension;
import representation.ExpressionRepresentation;

public final class InputProcessUtil {

  private InputProcessUtil() {
  }

  public static Dimension getDimensionFromContext(DimensionContext dimension, SMLVisitor<Expression> visitor) {
    String dimensionN = getExpressionValue(dimension.dimensionN, visitor);
    dimensionN = "Double.valueOf(" + dimensionN + ").intValue()";

    String dimensionM = getExpressionValue(dimension.dimensionM, visitor);
    dimensionM = "Double.valueOf(" + dimensionM + ").intValue()";

    return new Dimension(dimensionN, dimensionM);
  }

  public static String getSetInitExpressionValue(Set_init_exprContext exprContext, SMLVisitor<Expression> visitor) {
    String result = "new $hash_set:T<>($arrays:T.asList(";

    for (ExpressionContext expression : exprContext.expression()) {
      result += ((ExpressionRepresentation) visitor.visit(expression)).getValue();

      if (exprContext.expression().indexOf(expression) < exprContext.expression().size() - 1) {
        result += ", ";
      }
    }

    result += "))";
    return result;
  }

  public static String getExpressionValue(ExpressionContext expressionContext, SMLVisitor<Expression> visitor) {
    TypeUtil.ensureExpressionTypeIsNot(expressionContext, visitor, ExpressionType.FOR_EXPR,
        ExpressionType.VAR_DEFINING_EXPR);

    return ((ExpressionRepresentation) visitor.visit(expressionContext)).getValue();
  }

}

