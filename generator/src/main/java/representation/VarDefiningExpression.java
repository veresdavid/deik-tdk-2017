package representation;

import com.squareup.javapoet.ClassName;
import enums.ExpressionType;
import interfaces.Expression;

public class VarDefiningExpression implements Expression {

  private static final ExpressionType expressionType = ExpressionType.VAR_DEFINING_EXPR;
  private String varName;
  private ClassName className;
  private String value;

  public VarDefiningExpression(String varName, ClassName className, String value) {
    this.varName = varName;
    this.className = className;
    this.value = value;
  }

  @Override
  public ExpressionType getExpressionType() {
    return expressionType;
  }

  public String getVarName() {
    return varName;
  }

  public void setVarName(String varName) {
    this.varName = varName;
  }

  public ClassName getClassName() {
    return className;
  }

  public void setClassName(ClassName className) {
    this.className = className;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "VarDefiningExpression{" +
        "varName='" + varName + '\'' +
        ", className=" + className +
        ", value='" + value + '\'' +
        '}';
  }
}
