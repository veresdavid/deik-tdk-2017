package main;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import exceptions.OperatorInitializationException;
import exceptions.StateInitializationException;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.ANode;
import nodes.BackTrackCircleNode;
import nodes.BackTrackOptimalNode;
import nodes.BackTrackPathLengthLimitationNode;
import nodes.BackTrackSimpleNode;
import nodes.BestFirstNode;
import nodes.BreadthFirstNode;
import nodes.DepthFirstNode;
import nodes.OptimalNode;
import solutionsearchers.A;
import solutionsearchers.BackTrackCircle;
import solutionsearchers.BackTrackOptimal;
import solutionsearchers.BackTrackPathLengthLimitation;
import solutionsearchers.BackTrackSimple;
import solutionsearchers.BestFirst;
import solutionsearchers.BreadthFirst;
import solutionsearchers.DepthFirst;
import solutionsearchers.Optimal;

public class SolutionManager{
	private List<OperatorInterface> OPERATORS;
	private StateInterface state;
	
	public SolutionManager(Class<?> stateClass, List<Class<?>> operatorClasses) throws StateInitializationException, OperatorInitializationException{
		OperatorInstantiator operatorInstantiator = new OperatorInstantiator();
		OPERATORS = operatorInstantiator.getOperatorInstances(operatorClasses);
		try {
			state = (StateInterface) stateClass.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new StateInitializationException(e);
		}
	}
	
	public String doBackTrackSimple(String heuristicFunction){
		BackTrackSimpleNode backTrackSimpleNodeStart = new BackTrackSimpleNode(state.getStart(), null, null, 0, new ArrayList<>());
		BackTrackSimple backTrackSimple = new BackTrackSimple(backTrackSimpleNodeStart, OPERATORS);
		return backTrackSimple.search();
	}
	
	public String doBackTrackCircle(String heuristicFunction) {
		BackTrackCircleNode backTrackCircleNodeStart = new BackTrackCircleNode(state.getStart(), null, null, 0, new ArrayList<>());
		BackTrackCircle backTrackCircle = new BackTrackCircle(backTrackCircleNodeStart, OPERATORS);
		return backTrackCircle.search();
	}

	public String doBackTrackPathLengthLimitation(String heuristicFunction) {
		BackTrackPathLengthLimitationNode backTrackPathLengthLimitationNode = new BackTrackPathLengthLimitationNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
		BackTrackPathLengthLimitation backTrackPathLengthLimitation = new BackTrackPathLengthLimitation(backTrackPathLengthLimitationNode, 10, OPERATORS);
		return backTrackPathLengthLimitation.search();
	}

	public String doBackTrackOptimal(String heuristicFunction) {
		BackTrackOptimalNode backTrackOptimalNode = new BackTrackOptimalNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
		BackTrackOptimal backTrackOptimal = new BackTrackOptimal(backTrackOptimalNode, 10, OPERATORS);
		return backTrackOptimal.search();
	}

	public String doBreadthFirst(String heuristicFunction) {
		BreadthFirstNode breadthFirstNode = new BreadthFirstNode(state.getStart(), null, null, 0, 0);
		BreadthFirst breadthFirst = new BreadthFirst(breadthFirstNode, OPERATORS);
		return breadthFirst.search();
	}

	public String doDepthFirst(String heuristicFunction) {
		DepthFirstNode depthFirstNode = new DepthFirstNode(state.getStart(), null, null, 0, 0);
		DepthFirst depthFirst = new DepthFirst(depthFirstNode, OPERATORS);
		return depthFirst.search();
	}

	public String doOptimal(String heuristicFunction) {
		OptimalNode optimalNode = new OptimalNode(state.getStart(), null, null, 0, 0);
		Optimal optimal = new Optimal(optimalNode, OPERATORS);
		return optimal.search();
	}
	
	
	public String doBestFirst(String heuristicFunction){
		BestFirstNode bestFirstNode = new BestFirstNode(state.getStart(), null, null, 0, "", null);
		BestFirst bestFirst = new BestFirst(bestFirstNode, "", null, OPERATORS);
		return bestFirst.search();
	}
	
	public String doA(String heuristicFunction) {
		ANode aNode = new ANode(state.getStart(), null, null, 0, 0, "", null);
		A a = new A(aNode, "", null, OPERATORS);
		return a.search();
	}
}
