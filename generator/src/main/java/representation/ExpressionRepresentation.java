package representation;

import enums.ExpressionType;
import interfaces.Expression;

public class ExpressionRepresentation implements Expression {

  private ExpressionType expressionType;
  private String value;

  public ExpressionRepresentation(ExpressionType expressionType, String value) {
    this.expressionType = expressionType;
    this.value = value;
  }

  @Override
  public ExpressionType getExpressionType() {
    return expressionType;
  }

  @Override
  public String toString() {
    return "ExpressionRepresentation{" +
        "expressionType=" + expressionType +
        ", value='" + value + '\'' +
        '}';
  }

  public void setExpressionType(ExpressionType expressionType) {
    this.expressionType = expressionType;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
