package nodes;

import java.util.Set;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.heuristicparser.HeuristicParser;

public class BestFirstNode extends Node{
	
	private double heuristic;

	public BestFirstNode(StateInterface state, BestFirstNode parent, OperatorInterface operator, int id, String heuristicFunction, Set<String> variablesInHeuristicFunction) {
		setState(state);
		setParent(parent);
		setOperator(operator);
		setId(id);
		if(heuristicFunction.isEmpty()){
			this.heuristic = 1;
		} else {
			HeuristicParser heuristicParser = new HeuristicParser(heuristicFunction, variablesInHeuristicFunction, this);
			this.heuristic = heuristicParser.Parse();
		}
	}

	public double getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(double heuristic) {
		this.heuristic = heuristic;
	}
}
