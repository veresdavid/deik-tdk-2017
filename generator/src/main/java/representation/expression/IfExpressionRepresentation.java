package representation.expression;

import enums.ExpressionType;
import interfaces.Expression;
import java.util.ArrayList;
import java.util.List;

public class IfExpressionRepresentation implements Expression {

  private static final ExpressionType expressionType = ExpressionType.IF_EXPR;

  private Expression condition;
  private List<Expression> ifExpressions = new ArrayList<>();
  private List<Expression> elseExpressions = new ArrayList<>();

  public IfExpressionRepresentation(Expression condition, List<Expression> ifExpressions,
      List<Expression> elseExpressions) {
    this.condition = condition;
    this.ifExpressions = ifExpressions;
    this.elseExpressions = elseExpressions;
  }

  public Expression getCondition() {
    return condition;
  }

  public void setCondition(Expression condition) {
    this.condition = condition;
  }

  public List<Expression> getIfExpressions() {
    return ifExpressions;
  }

  public void setIfExpressions(List<Expression> ifExpressions) {
    this.ifExpressions = ifExpressions;
  }

  public List<Expression> getElseExpressions() {
    return elseExpressions;
  }

  public void setElseExpressions(List<Expression> elseExpressions) {
    this.elseExpressions = elseExpressions;
  }

  @Override
  public ExpressionType getExpressionType() {
    return expressionType;
  }

  public void addIfExpression(Expression expression) {
    ifExpressions.add(expression);
  }

  public void addElseExpression(Expression expression) {
    elseExpressions.add(expression);
  }

  public boolean containsElse() {
    return !elseExpressions.isEmpty();
  }
}
