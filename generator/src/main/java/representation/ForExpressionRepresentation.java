package representation;

import enums.ExpressionType;
import interfaces.Expression;
import java.util.ArrayList;
import java.util.List;

public class ForExpressionRepresentation implements Expression {

  private static final ExpressionType expressionType = ExpressionType.FOR_EXPR;
  private String variable;
  private String from;
  private String to;
  private String by;
  private List<Expression> expressions = new ArrayList<>();

  public ForExpressionRepresentation(String variable, String from, String to, String by,
      List<Expression> expressions) {
    this.variable = variable;
    this.from = from;
    this.to = to;
    this.by = by;
    this.expressions = expressions;
  }

  public String getVariable() {
    return variable;
  }

  public void setVariable(String variable) {
    this.variable = variable;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public String getTo() {
    return to;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public String getBy() {
    return by;
  }

  public void setBy(String by) {
    this.by = by;
  }

  public List<Expression> getExpressions() {
    return expressions;
  }

  public void setExpressions(List<Expression> expressions) {
    this.expressions = expressions;
  }

  @Override
  public ExpressionType getExpressionType() {
    return expressionType;
  }

  public void addExpression(Expression expression) {
    expressions.add(expression);
  }
}