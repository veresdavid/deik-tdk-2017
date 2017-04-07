package representation;

import java.util.ArrayList;
import java.util.List;
import representation.operator.OperatorRepresentation;
import representation.state.StateRepresentation;

public class ProjectRepresentation {

  StateRepresentation stateRepresentation;
  List<OperatorRepresentation> operatorRepresentation = new ArrayList<>();

  public ProjectRepresentation(StateRepresentation stateRepresentation,
      List<OperatorRepresentation> operatorRepresentation) {
    this.stateRepresentation = stateRepresentation;
    this.operatorRepresentation = operatorRepresentation;
  }

  public StateRepresentation getStateRepresentation() {
    return stateRepresentation;
  }

  public void setStateRepresentation(StateRepresentation stateRepresentation) {
    this.stateRepresentation = stateRepresentation;
  }

  public List<OperatorRepresentation> getOperatorRepresentation() {
    return operatorRepresentation;
  }

  public void setOperatorRepresentation(
      List<OperatorRepresentation> operatorRepresentation) {
    this.operatorRepresentation = operatorRepresentation;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    ProjectRepresentation that = (ProjectRepresentation) o;

    if (stateRepresentation != null ? !stateRepresentation.equals(that.stateRepresentation)
        : that.stateRepresentation != null) {
      return false;
    }
    return operatorRepresentation != null ? operatorRepresentation
        .equals(that.operatorRepresentation) : that.operatorRepresentation == null;
  }

  @Override
  public int hashCode() {
    int result = stateRepresentation != null ? stateRepresentation.hashCode() : 0;
    result = 31 * result + (operatorRepresentation != null ? operatorRepresentation.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ProjectRepresentation{" +
        "stateRepresentation=" + stateRepresentation +
        ", operatorRepresentation=" + operatorRepresentation +
        '}';
  }
}