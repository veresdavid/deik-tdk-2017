package interfaces;

import java.util.List;

public interface OperatorInterface {

  public List<OperatorInterface> initOperators();

  public boolean isApplicable(StateInterface stateObject);

  public StateInterface apply(StateInterface stateObject);

  public default double getCost() {
    return 1;
  }
}