package nodes;

import java.util.Set;

import exceptions.InvalidVariableException;
import exceptions.TypeMismatchException;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.heuristicparser.HeuristicParser;

public class ANode extends Node{
	private double pathCost;
	private double heuristic;

	public ANode(StateInterface state, ANode parent, OperatorInterface operator, int id, double pathCost, String heuristicFunction, Set<String> variablesInHeuristicFunction) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException {
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.id = id;
		this.pathCost = pathCost;
		if(heuristicFunction.isEmpty()){
			this.heuristic = 1;
		} else {
			HeuristicParser heuristicParser = new HeuristicParser(heuristicFunction, variablesInHeuristicFunction, this);
			this.heuristic = heuristicParser.Parse();
		}
	}

	public double getPathCost() {
		return pathCost;
	}

	public void setPathCost(double pathCost) {
		this.pathCost = pathCost;
	}

	public double getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(double heuristic) {
		this.heuristic = heuristic;
	}
}
