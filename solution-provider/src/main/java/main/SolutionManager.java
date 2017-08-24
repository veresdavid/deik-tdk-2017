package main;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import exceptions.InvalidVariableException;
import exceptions.OperatorInitializationException;
import exceptions.StateInitializationException;
import exceptions.TypeMismatchException;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
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

public class SolutionManager{
	private List<OperatorInterface> operators;
	private StateInterface state;
	
	public SolutionManager(Class<?> stateClass, List<Class<?>> operatorClasses) throws StateInitializationException, OperatorInitializationException{
		OperatorInstantiator operatorInstantiator = new OperatorInstantiator();
		operators = operatorInstantiator.getOperatorInstances(operatorClasses);
		try {
			state = (StateInterface) stateClass.getConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new StateInitializationException(e);
		}
	}
	
	public String doBackTrackSimple(boolean doTree){
		BackTrackSimple backTrackSimple = new BackTrackSimple(state);
		
		backTrackSimple.setOperators(operators);
		
		if(doTree){
			backTrackSimple.setInformationCollector(new ExtendedInformationCollector());
		
		}
		
		backTrackSimple.search();
		return backTrackSimple.searchFinished();
	}
	
	public String doBackTrackCircle(boolean doTree) {
		BackTrackCircle backTrackCircle = new BackTrackCircle(state);
		
		backTrackCircle.setOperators(operators);
		
		if(doTree){
			backTrackCircle.setInformationCollector(new ExtendedInformationCollector());
		}
		
		backTrackCircle.search();
		return backTrackCircle.searchFinished();
	}

	public String doBackTrackPathLengthLimitation(boolean doTree, int backTrackPathLengthLimitationLimit) {
		BackTrackPathLengthLimitation backTrackPathLengthLimitation = new BackTrackPathLengthLimitation(state, backTrackPathLengthLimitationLimit);
		
		backTrackPathLengthLimitation.setOperators(operators);
		
		if(doTree){
			backTrackPathLengthLimitation.setInformationCollector(new ExtendedInformationCollector());
		}
		
		backTrackPathLengthLimitation.search();
		return backTrackPathLengthLimitation.searchFinished();
	}

	public String doBackTrackOptimal(boolean doTree, int backTrackOptimalLimit) {
		BackTrackOptimal backTrackOptimal = new BackTrackOptimal(state, backTrackOptimalLimit);
		
		backTrackOptimal.setOperators(operators);
		
		if(doTree){
			backTrackOptimal.setInformationCollector(new ExtendedInformationCollector());
		} 
		
		backTrackOptimal.search();
		return backTrackOptimal.searchFinished();
	}

	public String doBreadthFirst(boolean doTree) {
		BreadthFirst breadthFirst = new BreadthFirst(state);
		
		breadthFirst.setOperators(operators);
		
		if(doTree){
			breadthFirst.setInformationCollector(new ExtendedInformationCollector());
		}
		
		breadthFirst.search();
		return breadthFirst.searchFinished();
	}

	public String doDepthFirst(boolean doTree) {
		DepthFirst depthFirst = new DepthFirst(state);
		
		depthFirst.setOperators(operators);
		
		if(doTree){
			depthFirst.setInformationCollector(new ExtendedInformationCollector());
		}
		
		depthFirst.search();
		return depthFirst.searchFinished();
	}

	public String doOptimal(boolean doTree) {
		Optimal optimal = new Optimal(state);
		
		optimal.setOperators(operators);
		
		if(doTree){
			optimal.setInformationCollector(new ExtendedInformationCollector());
		}
		
		optimal.search();
		return optimal.searchFinished();
	}
	
	
	public String doBestFirst(String heuristicFunction, Set<String> variablesInHeuristicFunction, boolean doTree) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException{
		BestFirst bestFirst = new BestFirst(state, heuristicFunction, variablesInHeuristicFunction);
		
		bestFirst.setOperators(operators);
		
		if(doTree){
			bestFirst.setInformationCollector(new ExtendedInformationCollector());
		}
		
		bestFirst.search();
		return bestFirst.searchFinished();
	}
	
	public String doA(String heuristicFunction, Set<String> variablesInHeuristicFunction, boolean doTree) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException {
		A a = new A(state, heuristicFunction, variablesInHeuristicFunction);
		
		a.setOperators(operators);
		
		if(doTree){
			a.setInformationCollector(new ExtendedInformationCollector());
		}
		
		a.search();
		return a.searchFinished();
	}
}