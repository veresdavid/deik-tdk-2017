package representation.state;

import interfaces.Expression;
import java.util.ArrayList;
import java.util.List;

public class StateRepresentation {

  private String name;
  private List<AttributeRepresentation> attributes = new ArrayList<>();
  private List<Expression> startExpressions = new ArrayList<>();
  private List<Expression> goalExpressions = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<AttributeRepresentation> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<AttributeRepresentation> attributes) {
    this.attributes = attributes;
  }

  public List<Expression> getStartExpressions() {
    return startExpressions;
  }

  public void setStartExpressions(List<Expression> startExpressions) {
    this.startExpressions = startExpressions;
  }

  public List<Expression> getGoalExpressions() {
    return goalExpressions;
  }

  public void setGoalExpressions(List<Expression> goalExpressions) {
    this.goalExpressions = goalExpressions;
  }

  public void addAttribute(AttributeRepresentation attribute) {
    attributes.add(attribute);
  }

  public void addStartExpression(Expression expression) {
    startExpressions.add(expression);
  }

  public void addGoalExpression(Expression expression) {
    goalExpressions.add(expression);
  }
}