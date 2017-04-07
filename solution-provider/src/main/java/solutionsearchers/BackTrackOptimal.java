package solutionsearchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackOptimalNode;
import nodes.Node;

public class BackTrackOptimal {
	
	private Map<StateInterface, Integer> stepsOnStates;
	private Map<String, Integer> stepsOnEdges;
	private List<Node> reachedBackTrackOptimalNodes;
	private List<Node> listForTree;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackOptimalNode actual;
	private BackTrackOptimalNode treeActual;
	private BackTrackOptimalNode solution;
	private BackTrackOptimalNode treeSolution;
	private boolean didFind;
	private int pathLengthLimitation;
	private int maxId;
	private int treeId;
	
	private void appendSteps(){
		steps.append("Activated nodes: " + activateNodes);
		activateNodes.clear();
		steps.append(" Inactivated nodes: " + inactivateNodes);
		inactivateNodes.clear();
		steps.append(" Stepped on nodes: " + stepOnNodes);
		stepOnNodes.clear();
		steps.append(" Closed nodes: " + closeNodes);
		closeNodes.clear();
		steps.append(" Activated edges: " + activateEdges);
		activateEdges.clear();
		steps.append(" Inactivated edges: " + inactivateEdges + "\n");
		inactivateEdges.clear();
	}
	
	public BackTrackOptimal(BackTrackOptimalNode start, int pathLengthLimitation, List<OperatorInterface> OPERATORS){
		stepsOnStates = new HashMap<>();
		stepsOnEdges = new HashMap<>();
		reachedBackTrackOptimalNodes = new ArrayList<>();
		listForTree = new ArrayList<>();
		steps = new StringBuilder();
		activateNodes = new ArrayList<>();
		inactivateNodes = new ArrayList<>();
		stepOnNodes = new ArrayList<>();
		closeNodes = new ArrayList<>();
		activateEdges = new ArrayList<>();
		inactivateEdges = new ArrayList<>();
		actual = start;
		actual.setNumOfNodeStepOns(1);
		treeId = -1;
		treeActual = new BackTrackOptimalNode(actual.getState(), (BackTrackOptimalNode) actual.getParent(), actual.getOperator(), treeId, actual.getTried(), actual.getDepth());
		treeId--;
		this.pathLengthLimitation = pathLengthLimitation;
		this.OPERATORS = OPERATORS;
		activateNodes.add(String.valueOf(actual.getId()));
		activateNodes.add(String.valueOf(treeActual.getId()));
		stepOnNodes.add(String.valueOf(actual.getId()));
		stepOnNodes.add(String.valueOf(treeActual.getId()));
		appendSteps();
		//steps.append(actual.getId() + "\n");
		didFind = false;
		maxId = start.getId();
	}
	
	public String search(){
		while(true){	
			if(actual == null){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			if(!reachedBackTrackOptimalNodes.contains(actual)){
				reachedBackTrackOptimalNodes.add(actual);
			}
			
			if(!stepsOnStates.containsKey(actual.getState())){
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns());
			}
			
			if(!listForTree.contains(treeActual)){
				listForTree.add(treeActual);
			}
			
			if(actual.getOperator() != null){
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				if(!stepsOnEdges.containsKey(operatorId)){
					stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns());
				}
			}

			if(actual.getState().isGoal()){
				didFind = true;
				solution = actual;
				treeSolution = treeActual;
				pathLengthLimitation = actual.getDepth();
			}
			
			if(actual.getDepth() == pathLengthLimitation){
				//OperatorInterface operator = actual.getOperator();
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				String treeOperatorId = treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId();
				if(actual.getNumOfEdgeStepOns() == 1){
					inactivateEdges.add(operatorId);
				}
				inactivateEdges.add(treeOperatorId);
				stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns() - 1);

				if(actual.getNumOfNodeStepOns() == 1){
					inactivateNodes.add(String.valueOf(actual.getId()));
				} else {
					closeNodes.add(String.valueOf(actual.getId()));
				}
				inactivateNodes.add(String.valueOf(treeActual.getId()));
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackOptimalNode) actual.getParent();
				treeActual = (BackTrackOptimalNode) treeActual.getParent();

				stepOnNodes.add(String.valueOf(actual.getId()));
				stepOnNodes.add(String.valueOf(treeActual.getId()));
				appendSteps();
				//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
			}
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : OPERATORS) {

				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {

					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackOptimalNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackOptimalNode newNode = new BackTrackOptimalNode(newState, actual, operator, nodeId, new ArrayList<>(), actual.getDepth() + 1);
					actual = newNode;
					actual.setNumOfNodeStepOns(1);
					actual.setNumOfEdgeStepOns(1);
					
					treeActual = new BackTrackOptimalNode(actual.getState(), treeActual, operator, treeId, actual.getTried(), actual.getDepth());
					listForTree.add(treeActual);
					treeId--;
					
					wasOperatorUsed = true;
					break;

				}

			}
			
			if (!wasOperatorUsed) {
				//OperatorInterface operator = actual.getOperator();
				if(actual.getParent() != null){
					String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
					String treeOperatorId = treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId();
					if(actual.getNumOfEdgeStepOns() == 1){
						inactivateEdges.add(operatorId);
					}
					inactivateEdges.add(treeOperatorId);
					stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns() - 1);
				}
				
				if(actual.getNumOfNodeStepOns() == 1){
					inactivateNodes.add(String.valueOf(actual.getId()));
				} else {
					closeNodes.add(String.valueOf(actual.getId()));
				}
				inactivateNodes.add(String.valueOf(treeActual.getId()));
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackOptimalNode) actual.getParent();
				treeActual = (BackTrackOptimalNode) treeActual.getParent();
				
				if(actual != null){
					stepOnNodes.add(String.valueOf(actual.getId()));
					stepOnNodes.add(String.valueOf(treeActual.getId()));
					//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
				}
			} else {
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				String treeOperatorId = treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId();
				if(stepsOnEdges.containsKey(operatorId)){
					actual.setNumOfEdgeStepOns(stepsOnEdges.get(operatorId) + 1);
					stepsOnEdges.put(operatorId, actual.getNumOfEdgeStepOns());
				}
				
				if(stepsOnStates.containsKey(actual.getState())){
					actual.setNumOfNodeStepOns(stepsOnStates.get(actual.getState()) + 1);
					stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns());
				}
				
				activateEdges.add(operatorId);
				activateEdges.add(treeOperatorId);
				activateNodes.add(String.valueOf(actual.getId()));
				activateNodes.add(String.valueOf(treeActual.getId()));
				stepOnNodes.add(String.valueOf(actual.getId()));
				stepOnNodes.add(String.valueOf(treeActual.getId()));
				closeNodes.add(String.valueOf(actual.getParent().getId()));
				closeNodes.add(String.valueOf(treeActual.getParent().getId()));
				//steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + " " + actual.getId() + "\n");
			}
			appendSteps();
		}
		
		if(didFind){
			return SolutionHelper.writeOutputForGraphic(getClass(), reachedBackTrackOptimalNodes, listForTree, Arrays.asList(solution, treeSolution), steps.toString(), OPERATORS);
		} else {
			System.out.println("Unsuccessfull search.");
			return null;
		}
	}
}
