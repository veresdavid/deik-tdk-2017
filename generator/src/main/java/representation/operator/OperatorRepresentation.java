package representation.operator;

import interfaces.Expression;
import java.util.ArrayList;
import java.util.List;
import representation.ParameterRepresentation;


public class OperatorRepresentation {

  private String name;
  private Double cost;
  private List<ParameterRepresentation> parameters = new ArrayList<>();
  private List<Expression> preconditionExpressions = new ArrayList<>();
  private List<Expression> effectExpressions = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getCost() {
    return cost;
  }

  public void setCost(Double cost) {
    this.cost = cost;
  }

  public List<ParameterRepresentation> getParameters() {
    return parameters;
  }

  public void setParameters(List<ParameterRepresentation> parameters) {
    this.parameters = parameters;
  }

  public List<Expression> getPreconditionExpressions() {
    return preconditionExpressions;
  }

  public void setPreconditionExpressions(List<Expression> preconditionExpressions) {
    this.preconditionExpressions = preconditionExpressions;
  }

  public List<Expression> getEffectExpressions() {
    return effectExpressions;
  }

  public void setEffectExpressions(List<Expression> effectExpressions) {
    this.effectExpressions = effectExpressions;
  }

  public void addParameter(ParameterRepresentation parameter) {
    parameters.add(parameter);
  }

  public void addPreconditionExpression(Expression expression) {
    preconditionExpressions.add(expression);
  }

  public void addOperatorEffect(Expression expression) {
    effectExpressions.add(expression);
  }
}