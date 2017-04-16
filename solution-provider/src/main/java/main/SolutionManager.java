package main;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exceptions.InvalidVariableException;
import exceptions.OperatorInitializationException;
import exceptions.StateInitializationException;
import exceptions.TypeMismatchException;
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
import solutionsearchers.helpers.ExtendedInformationCollector;
import solutionsearchers.helpers.InformationCollector;

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
	
	public String doBackTrackSimple(boolean doTree){
		InformationCollector informationCollector;
		if(doTree){
			informationCollector = new ExtendedInformationCollector();
		} else {
			informationCollector = new InformationCollector();
		}
		BackTrackSimpleNode backTrackSimpleNodeStart = new BackTrackSimpleNode(state.getStart(), null, null, 0, new ArrayList<>());
		BackTrackSimple backTrackSimple = new BackTrackSimple(backTrackSimpleNodeStart, OPERATORS, informationCollector);
		return backTrackSimple.search();
	}
	
	public String doBackTrackCircle(boolean doTree) {
		InformationCollector informationCollector;
		if(doTree){
			informationCollector = new ExtendedInformationCollector();
		} else {
			informationCollector = new InformationCollector();
		}
		BackTrackCircleNode backTrackCircleNodeStart = new BackTrackCircleNode(state.getStart(), null, null, 0, new ArrayList<>());
		BackTrackCircle backTrackCircle = new BackTrackCircle(backTrackCircleNodeStart, OPERATORS, informationCollector);
		return backTrackCircle.search();
	}

	public String doBackTrackPathLengthLimitation(boolean doTree, int backTrackPathLengthLimitationLimit) {
		InformationCollector informationCollector;
		if(doTree){
			informationCollector = new ExtendedInformationCollector();
		} else {
			informationCollector = new InformationCollector();
		}
		BackTrackPathLengthLimitationNode backTrackPathLengthLimitationNode = new BackTrackPathLengthLimitationNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
		BackTrackPathLengthLimitation backTrackPathLengthLimitation = new BackTrackPathLengthLimitation(backTrackPathLengthLimitationNode, backTrackPathLengthLimitationLimit, OPERATORS, informationCollector);
		return backTrackPathLengthLimitation.search();
	}

	public String doBackTrackOptimal(boolean doTree, int backTrackOptimalLimit) {
		InformationCollector informationCollector;
		if(doTree){
			informationCollector = new ExtendedInformationCollector();
		} else {
			informationCollector = new InformationCollector();
		}
		BackTrackOptimalNode backTrackOptimalNode = new BackTrackOptimalNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
		BackTrackOptimal backTrackOptimal = new BackTrackOptimal(backTrackOptimalNode, backTrackOptimalLimit, OPERATORS, informationCollector);
		return backTrackOptimal.search();
	}

	public String doBreadthFirst(boolean doTree) {
		InformationCollector informationCollector;
		if(doTree){
			informationCollector = new ExtendedInformationCollector();
		} else {
			informationCollector = new InformationCollector();
		}
		BreadthFirstNode breadthFirstNode = new BreadthFirstNode(state.getStart(), null, null, 0, 0);
		BreadthFirst breadthFirst = new BreadthFirst(breadthFirstNode, OPERATORS, informationCollector);
		return breadthFirst.search();
	}

	public String doDepthFirst(boolean doTree) {
		InformationCollector informationCollector;
		if(doTree){
			informationCollector = new ExtendedInformationCollector();
		} else {
			informationCollector = new InformationCollector();
		}
		DepthFirstNode depthFirstNode = new DepthFirstNode(state.getStart(), null, null, 0, 0);
		DepthFirst depthFirst = new DepthFirst(depthFirstNode, OPERATORS, informationCollector);
		return depthFirst.search();
	}

	public String doOptimal(boolean doTree) {
		InformationCollector informationCollector;
		if(doTree){
			informationCollector = new ExtendedInformationCollector();
		} else {
			informationCollector = new InformationCollector();
		}
		OptimalNode optimalNode = new OptimalNode(state.getStart(), null, null, 0, 0);
		Optimal optimal = new Optimal(optimalNode, OPERATORS, informationCollector);
		return optimal.search();
	}
	
	
	public String doBestFirst(String heuristicFunction, Set<String> variablesInHeuristicFunction, boolean doTree) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException{
		InformationCollector informationCollector;
		if(doTree){
			informationCollector = new ExtendedInformationCollector();
		} else {
			informationCollector = new InformationCollector();
		}
		BestFirstNode bestFirstNode = new BestFirstNode(state.getStart(), null, null, 0, heuristicFunction, variablesInHeuristicFunction);
		BestFirst bestFirst = new BestFirst(bestFirstNode, heuristicFunction, variablesInHeuristicFunction, OPERATORS, informationCollector);
		return bestFirst.search();
	}
	
	public String doA(String heuristicFunction, Set<String> variablesInHeuristicFunction, boolean doTree) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException {
		InformationCollector informationCollector;
		if(doTree){
			informationCollector = new ExtendedInformationCollector();
		} else {
			informationCollector = new InformationCollector();
		}
		ANode aNode = new ANode(state.getStart(), null, null, 0, 0, heuristicFunction, variablesInHeuristicFunction);
		A a = new A(aNode, heuristicFunction, variablesInHeuristicFunction, OPERATORS, informationCollector);
		return a.search();
	}
}
