package nodes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class OptimalNode extends Node{

	private double pathCost;

	public OptimalNode(StateInterface state, OptimalNode parent, OperatorInterface operator, int id, double pathCost) {
		setState(state);
		setParent(parent);
		setOperator(operator);
		setId(id);
		this.pathCost = pathCost;
	}

	public double getPathCost() {
		return pathCost;
	}

	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}
}
