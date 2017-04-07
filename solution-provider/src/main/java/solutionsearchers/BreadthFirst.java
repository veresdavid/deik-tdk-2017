package solutionsearchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BreadthFirstNode;
import nodes.Node;

public class BreadthFirst {

	private List<Node> reachedBreadthFirstNodes;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private BreadthFirstNode actual;
	private LinkedList<BreadthFirstNode> openNodes = new LinkedList<>();
	private LinkedList<BreadthFirstNode> closedNodes = new LinkedList<>();
	private int maxId;
	
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
	
	public BreadthFirst(BreadthFirstNode start, List<OperatorInterface> OPERATORS){
		reachedBreadthFirstNodes = new ArrayList<>();
		steps = new StringBuilder();
		activateNodes = new ArrayList<>();
		inactivateNodes = new ArrayList<>();
		stepOnNodes = new ArrayList<>();
		closeNodes = new ArrayList<>();
		activateEdges = new ArrayList<>();
		inactivateEdges = new ArrayList<>();
		this.OPERATORS = OPERATORS;
		openNodes.add(start);
		activateNodes.add(String.valueOf(start.getId()));
		appendSteps();
		maxId = start.getId();
	}
	
	private boolean isContains(List<BreadthFirstNode> nodes, StateInterface state){
		for(BreadthFirstNode node : nodes){
			if(node.getState().equals(state)){
				return true;
			}
		}
		return false;
	}
	
	private void extend(BreadthFirstNode node){
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				boolean isOpenNodesContains = isContains(openNodes, newState);
				boolean isClosedNodesContains = isContains(closedNodes, newState);
				
				if(!(isOpenNodesContains || isClosedNodesContains)){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBreadthFirstNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BreadthFirstNode newNode = new BreadthFirstNode(newState, node, operator, nodeId, node.getDepth() + 1);
					openNodes.addLast(newNode);
					
					if(!reachedBreadthFirstNodes.contains(newNode)){
						reachedBreadthFirstNodes.add(newNode);
					}
					
					activateNodes.add(String.valueOf(newNode.getId()));
					activateEdges.add(newNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newNode.getOperator()) + "-" + newNode.getId());
					//newOpenNodeIdList.add(newNode.getId());
					//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				}
			}
		}
		openNodes.remove(node);
		closedNodes.add(node);
		appendSteps();
		closeNodes.add(String.valueOf(node.getId()));
		//steps.append(operatorIdList + "|" + newOpenNodeIdList + "|");
	}
	
	public String search(){
		while(true){
			if(openNodes.isEmpty()){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			actual = openNodes.getFirst();
			stepOnNodes.add(String.valueOf(actual.getId()));
			if(!reachedBreadthFirstNodes.contains(actual)){
				reachedBreadthFirstNodes.add(actual);
			}

			
			/*if(actual.getOperator() != null){
				//steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + "|" + actual.getId() + "\n");
			} else {
				//steps.append(actual.getId() + "\n");
			}*/
			
			if(actual.getState().isGoal()){
				appendSteps();
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			extend(actual);
		}
		if(!openNodes.isEmpty()){
			return SolutionHelper.writeOutputForGraphic(getClass(), reachedBreadthFirstNodes, new ArrayList<>(), Arrays.asList(actual), steps.toString(), OPERATORS);
		} else {
			System.out.println("No solution.");
			return null;
		}
	}
}
