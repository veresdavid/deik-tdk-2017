package solutionsearchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackSimpleNode;
import nodes.Node;

public class BackTrackSimple{

	private Map<StateInterface, Integer> stepsOnStates;
	private List<Node> reachedBackTrackSimpleNodes;
	private List<Node> listForTree;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackSimpleNode actual;
	private BackTrackSimpleNode treeActual;
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
	
	public BackTrackSimple(BackTrackSimpleNode start, List<OperatorInterface> OPERATORS){
		stepsOnStates = new HashMap<>();
		reachedBackTrackSimpleNodes = new ArrayList<>();
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
		treeActual = new BackTrackSimpleNode(actual.getState(), (BackTrackSimpleNode) actual.getParent(), actual.getOperator(), treeId, actual.getTried());
		treeId--;
		this.OPERATORS = OPERATORS;
		activateNodes.add(String.valueOf(actual.getId()));
		activateNodes.add(String.valueOf(treeActual.getId()));
		stepOnNodes.add(String.valueOf(actual.getId()));
		stepOnNodes.add(String.valueOf(treeActual.getId()));
		appendSteps();
		//steps.append(actual.getId() + "\n");
		maxId = start.getId();
	}
	
	public String search(){
		while(true){
			if(actual == null){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			if(!reachedBackTrackSimpleNodes.contains(actual)){
				reachedBackTrackSimpleNodes.add(actual);
			}

			if(!stepsOnStates.containsKey(actual.getState())){
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns());
			}
			
			if(!listForTree.contains(treeActual)){
				listForTree.add(treeActual);
			}
			
			if(actual.getState().isGoal()){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : OPERATORS) {

				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {

					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBackTrackSimpleNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackSimpleNode newNode = new BackTrackSimpleNode(newState, actual, operator, nodeId, new ArrayList<>());
					actual = newNode;
					actual.setNumOfNodeStepOns(1);
					
					treeActual = new BackTrackSimpleNode(actual.getState(), treeActual, operator, treeId, actual.getTried());
					listForTree.add(treeActual);
					treeId--;
					
					wasOperatorUsed = true;
					break;

				}

			}
			
			if (!wasOperatorUsed) {
				//OperatorInterface operator = actual.getOperator();
				if(actual.getParent() != null){
					inactivateEdges.add(actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId());
					inactivateEdges.add(treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId());
					//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
				}
				
				if(actual.getNumOfNodeStepOns() == 1){
					inactivateNodes.add(String.valueOf(actual.getId()));
				} else {
					closeNodes.add(String.valueOf(actual.getId()));
				}
				inactivateNodes.add(String.valueOf(treeActual.getId()));
				stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackSimpleNode) actual.getParent();
				treeActual = (BackTrackSimpleNode) treeActual.getParent();
				
				if(actual != null){
					stepOnNodes.add(String.valueOf(actual.getId()));
					stepOnNodes.add(String.valueOf(treeActual.getId()));
					//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
				}
			} else {
				if(stepsOnStates.containsKey(actual.getState())){
					actual.setNumOfNodeStepOns(stepsOnStates.get(actual.getState()) + 1);
					stepsOnStates.put(actual.getState(), actual.getNumOfNodeStepOns());
				}
				
				activateEdges.add(actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId());
				activateEdges.add(treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId());
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
		
		if(actual != null){
			return SolutionHelper.writeOutputForGraphic(getClass(), reachedBackTrackSimpleNodes, listForTree, Arrays.asList(actual, treeActual), steps.toString(), OPERATORS);
		} else {
			System.out.println("No solution.");
			return null;
		}
	}
}
