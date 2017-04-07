package antlr.impl;

import antlr.SMLBaseVisitor;
import antlr.SMLParser.Assign_exprContext;
import antlr.SMLParser.Binary_exprContext;
import antlr.SMLParser.Bool_exprContext;
import antlr.SMLParser.Compare_exprContext;
import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.For_exprContext;
import antlr.SMLParser.Number_exprContext;
import antlr.SMLParser.One_param_unary_exprContext;
import antlr.SMLParser.Param_name_exprContext;
import antlr.SMLParser.Paren_exprContext;
import antlr.SMLParser.ReferenceContext;
import antlr.SMLParser.Reference_exprContext;
import antlr.SMLParser.Set_init_exprContext;
import antlr.SMLParser.Two_param_unary_exprContext;
import antlr.SMLParser.Var_defining_expressionContext;
import antlr.SMLParser.Word_exprContext;
import com.squareup.javapoet.ClassName;
import enums.ExpressionType;
import enums.ReferenceType;
import enums.VarType;
import interfaces.Expression;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import misc.Dimension;
import representation.ExpressionRepresentation;
import representation.ForExpressionRepresentation;
import representation.VarDefiningExpression;
import utils.InputProcessUtil;
import utils.TypeUtil;

public class ExpressionVisitor extends SMLBaseVisitor<Expression> {

  private SimpleVisitor simpleVisitor = new SimpleVisitor();

  @Override
  public ForExpressionRepresentation visitFor_expr(For_exprContext ctx) {
    String variable = ctx.for_statement().variable.getText();
    String from = InputProcessUtil.getExpressionValue(ctx.for_statement().from, this);
    String to = InputProcessUtil.getExpressionValue(ctx.for_statement().to, this);
    String by = InputProcessUtil.getExpressionValue(ctx.for_statement().by, this);

    List<Expression> expressions = new ArrayList<>();

    for (ExpressionContext expression : ctx.expression()) {
      expressions.add(visit(expression));
    }

    return new ForExpressionRepresentation(variable, from, to, by, expressions);
  }

  @Override
  public Expression visitVar_defining_expression(Var_defining_expressionContext ctx) {
    String varName = ctx.PARAM_NAME().getText();
    VarType varType = TypeUtil.getVarType(ctx.attr_type());
    ClassName className;

    String value = InputProcessUtil.getExpressionValue(ctx.expression(), this);

    switch (varType) {
      case NUMBER:
        className = ClassName.get(Double.class);
        break;

      case WORD:
        className = ClassName.get(String.class);
        break;

      default:
        //TODO: error
        throw new RuntimeException();
    }

    return new VarDefiningExpression(varName, className, value);
  }

  @Override
  public Expression visitSet_init_expr(Set_init_exprContext ctx) {
    String value = "new $hash_set:T<>($arrays:T.asList(";

    value += ctx.expression().stream().map(expression -> InputProcessUtil.getExpressionValue(expression, this)).collect(
        Collectors.joining(", "));

    value += "))";

    return new ExpressionRepresentation(ExpressionType.SET_INIT_EXPR, value);
  }

  @Override
  public Expression visitReference(ReferenceContext ctx) {

    ReferenceType referenceType = TypeUtil.getReferenceType(ctx);
    String parameterName;
    Dimension dimension;
    String value;

    switch (referenceType) {
      case NORMAL_SET_REFERENCE:
        value = "$original:L.getAttr" + ctx.normal_reference().attr_reference().INT().getText() + "()";
        break;

      case NORMAL_MATRIX_REFERENCE:
        dimension = InputProcessUtil
            .getDimensionFromContext(ctx.normal_reference().matrix_reference().dimension(), this);

        value = "$original:L.getAttr" + ctx.normal_reference().matrix_reference().attr_reference().INT().getText()
            + "().get(" + dimension.getDimensionN() + ").get(" + dimension.getDimensionM() + ")";
        break;

      case PARAMETERIZED_SET_REFERENCE:
        parameterName = ctx.parameterized_reference().parameterized_attr_reference().PARAM_NAME().getText();
        value = "(($" + parameterName + ":T) $original:L.getAttributeByNumber(" + parameterName + "))";
        break;

      case PARAMETERIZED_MATRIX_REFERENCE:
        parameterName = ctx.parameterized_reference().parameterized_attr_reference().PARAM_NAME().getText();
        dimension = InputProcessUtil.getDimensionFromContext(
            ctx.parameterized_reference().parameterized_matrix_reference().dimension(), this);

        value = "(($" + parameterName + ":T) $original:L.getAttributeByNumber(" + parameterName + "))"
            + ".get(" + dimension.getDimensionN() + ").get(" + dimension.getDimensionM() + ")";
        break;

      default:
        throw new RuntimeException("Unexpected reference type");
    }

    return new ExpressionRepresentation(ExpressionType.REFERENCE, value);
  }

  @Override
  public Expression visitAssign_expr(Assign_exprContext ctx) {

    ReferenceType referenceType = TypeUtil.getReferenceType(ctx.reference());
    String attributeName;
    Dimension dimension;
    String value;

    switch (referenceType) {
      case NORMAL_SET_REFERENCE:
        value = "$result:L.setAttr" + ctx.reference().normal_reference().attr_reference().INT()
            + "(" + InputProcessUtil.getExpressionValue(ctx.expression(), this) + ")";
        return new ExpressionRepresentation(ExpressionType.SET_ASSIGN_EXPR, value);

      case NORMAL_MATRIX_REFERENCE:
        dimension = InputProcessUtil
            .getDimensionFromContext(ctx.reference().normal_reference().matrix_reference().dimension(), this);

        value = "$result:L.getAttr" + ctx.reference().normal_reference().matrix_reference().attr_reference().INT()
            + "().get(" + dimension.getDimensionN() + ").set(" + dimension.getDimensionM() + ", "
            + InputProcessUtil.getExpressionValue(ctx.expression(), this) + ")";

        return new ExpressionRepresentation(ExpressionType.MATRIX_ASSIGN_EXPR, value);

      case PARAMETERIZED_SET_REFERENCE:
        attributeName = ctx.reference().parameterized_reference().parameterized_attr_reference().PARAM_NAME().getText();
        value = "$result:L.setAttributeByNumber(" + attributeName + ", "
            + InputProcessUtil.getExpressionValue(ctx.expression(), this) + ")";

        return new ExpressionRepresentation(ExpressionType.PARAMETERIZED_SET_ASSIGN, value);

      case PARAMETERIZED_MATRIX_REFERENCE:
        attributeName = ctx.reference().parameterized_reference().parameterized_matrix_reference()
            .parameterized_attr_reference().PARAM_NAME().getText();

        dimension = InputProcessUtil.getDimensionFromContext(
            ctx.reference().parameterized_reference().parameterized_matrix_reference().dimension(), this);

        value = "(($" + attributeName + ":T) $original:L.getAttributeByNumber(" + attributeName + "))"
            + ".get(" + dimension.getDimensionN() + ").set(" + dimension.getDimensionM() + ")";

        return new ExpressionRepresentation(ExpressionType.PARAMTERIZED_MATRIX_ASSIGN, value);

      default:
        throw new RuntimeException("Unexpexted reference type");
    }
  }

  @Override
  public Expression visitParen_expr(Paren_exprContext ctx) {

    String value = ctx.SYMBOL_LPAREN().getText()
        + InputProcessUtil.getExpressionValue(ctx.expression(), this)
        + ctx.SYMBOL_RPAREN().getText();

    return new ExpressionRepresentation(ExpressionType.PAREN_EXPR, value);
  }

  @Override
  public Expression visitCompare_expr(Compare_exprContext ctx) {

    if (isComparedWithEquals(ctx.left) && isComparedWithEquals(ctx.right)) {
      if (ctx.comparator().SYMBOL_EQUAL() != null) {
        String value = InputProcessUtil.getExpressionValue(ctx.left, this) + ".equals("
            + InputProcessUtil.getExpressionValue(ctx.right, this) + ")";

        return new ExpressionRepresentation(ExpressionType.COMPARE_EXPR, value);
      }
      if (ctx.comparator().SYMBOL_NOT_EQUAL() != null) {
        String value = "!" + InputProcessUtil.getExpressionValue(ctx.left, this) + ".equals("
            + InputProcessUtil.getExpressionValue(ctx.right, this) + ")";

        return new ExpressionRepresentation(ExpressionType.COMPARE_EXPR, value);
      }
    }

    String value = InputProcessUtil.getExpressionValue(ctx.left, this)
        + " " + ctx.comparator().getText()
        + " " + InputProcessUtil.getExpressionValue(ctx.right, this);

    return new ExpressionRepresentation(ExpressionType.COMPARE_EXPR, value);
  }

  @Override
  public Expression visitBool_expr(Bool_exprContext ctx) {
    String value = InputProcessUtil.getExpressionValue(ctx.left, this)
        + " " + simpleVisitor.visit(ctx.boolean_operator())
        + " " + InputProcessUtil.getExpressionValue(ctx.right, this);

    return new ExpressionRepresentation(ExpressionType.BOOL_EXPR, value);
  }

  @Override
  public Expression visitBinary_expr(Binary_exprContext ctx) {
    String value = InputProcessUtil.getExpressionValue(ctx.left, this)
        + " " + ctx.binary_operator().getText()
        + " " + InputProcessUtil.getExpressionValue(ctx.right, this);

    return new ExpressionRepresentation(ExpressionType.BINARY_EXPR, value);
  }

  @Override
  public Expression visitOne_param_unary_expr(One_param_unary_exprContext ctx) {
    String value = "GeneratedUtils" + "." + ctx.unary_operator().getText() + ctx.SYMBOL_LPAREN().getText()
        + InputProcessUtil.getExpressionValue(ctx.expression(), this) + ctx.SYMBOL_RPAREN();

    return new ExpressionRepresentation(ExpressionType.ONE_PARAM_UNARY_EXPRESSION, value);
  }

  @Override
  public Expression visitTwo_param_unary_expr(Two_param_unary_exprContext ctx) {
    String value = "GeneratedUtils" + "." + ctx.unary_operator().getText() + ctx.SYMBOL_LPAREN().getText()
        + InputProcessUtil.getExpressionValue(ctx.left, this)
        + ctx.SYMBOL_COMMA() + " "
        + InputProcessUtil.getExpressionValue(ctx.right, this)
        + ctx.SYMBOL_RPAREN();

    return new ExpressionRepresentation(ExpressionType.TWO_PARAM_UNARY_EXPRESSION, value);
  }

  @Override
  public Expression visitNumber_expr(Number_exprContext ctx) {
    return new ExpressionRepresentation(ExpressionType.SIMPLE, simpleVisitor.visit(ctx));
  }

  @Override
  public Expression visitWord_expr(Word_exprContext ctx) {
    return new ExpressionRepresentation(ExpressionType.SIMPLE, simpleVisitor.visit(ctx));
  }

  @Override
  public Expression visitParam_name_expr(Param_name_exprContext ctx) {
    return new ExpressionRepresentation(ExpressionType.SIMPLE, ctx.PARAM_NAME().getText());
  }

  private Boolean isComparedWithEquals(ExpressionContext expression) {
    return expression.getClass().equals(Reference_exprContext.class) ||
        expression.getClass().equals(Param_name_exprContext.class) ||
        expression.getClass().equals(Set_init_exprContext.class);
  }
}
