package solutionsearchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BestFirstNode;
import nodes.Node;

public class BestFirst {

	private List<Node> reachedBestFirstNodes;
	private List<Node> listForTree;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private BestFirstNode actual;
	private BestFirstNode treeActual;
	private String heuristicFunction;
	private Set<String> variablesInHeuristicFunction;
	private List<BestFirstNode> openNodes = new ArrayList<>();
	private List<BestFirstNode> closedNodes = new ArrayList<>();
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
	
	public BestFirst(BestFirstNode start, String heuristicFunction, Set<String> variablesInHeuristicFunction, List<OperatorInterface> OPERATORS){
		reachedBestFirstNodes = new ArrayList<>();
		listForTree = new ArrayList<>();
		steps = new StringBuilder();
		activateNodes = new ArrayList<>();
		inactivateNodes = new ArrayList<>();
		stepOnNodes = new ArrayList<>();
		closeNodes = new ArrayList<>();
		activateEdges = new ArrayList<>();
		inactivateEdges = new ArrayList<>();
		treeId = -1;
		this.heuristicFunction = heuristicFunction;
		this.variablesInHeuristicFunction = variablesInHeuristicFunction;
		this.OPERATORS = OPERATORS;
		openNodes.add(start);
		activateNodes.add(String.valueOf(start.getId()));
		activateNodes.add(String.valueOf(treeId));
		appendSteps();
		maxId = start.getId();
	}
	
	private BestFirstNode isContains(List<BestFirstNode> nodes, StateInterface state){
		for(BestFirstNode node : nodes){
			if(node.getState().equals(state)){
				return node;
			}
		}
		return null;
	}
	
	private void extend(BestFirstNode node){
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				BestFirstNode openNodesContains = isContains(openNodes, newState);
				BestFirstNode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedBestFirstNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BestFirstNode newNode = new BestFirstNode(newState, node, operator, nodeId, heuristicFunction, variablesInHeuristicFunction);
					openNodes.add(newNode);
					
					BestFirstNode newTreeNode = new BestFirstNode(newNode.getState(), treeActual, operator, treeId, heuristicFunction, variablesInHeuristicFunction);
					listForTree.add(newTreeNode);
					treeId--;
					
					if(!reachedBestFirstNodes.contains(newNode)){
						reachedBestFirstNodes.add(newNode);
					}
					
					activateNodes.add(String.valueOf(newNode.getId()));
					activateNodes.add(String.valueOf(newTreeNode.getId()));
					activateEdges.add(newNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newNode.getOperator()) + "-" + newNode.getId());
					activateEdges.add(newTreeNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newTreeNode.getOperator()) + "-" + newTreeNode.getId());
					//newOpenNodeIdList.add(newNode.getId());
					//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				}
			}
		}
		openNodes.remove(node);
		closedNodes.add(node);
		appendSteps();
		closeNodes.add(String.valueOf(node.getId()));
		closeNodes.add(String.valueOf(treeActual.getId()));
		//steps.append(operatorIdList + "|" + newOpenNodeIdList + "|");
	}
	
	public String search(){
		while(true){
			if(openNodes.isEmpty()){
				if(steps.charAt(steps.length() - 1) == '\n')
					steps.setLength(steps.length() - 1);
				break;
			}
			
			actual = openNodes.get(0);
			
			for(BestFirstNode openNode : openNodes){
				if(openNode.getHeuristic() < actual.getHeuristic()){
					actual = openNode;
				}
			}
			
			if(!listForTree.contains(actual)){
				treeActual = new BestFirstNode(actual.getState(), (BestFirstNode) actual.getParent(), actual.getOperator(), treeId, heuristicFunction, variablesInHeuristicFunction);
				treeId--;
				listForTree.add(treeActual);
			} else {
				treeActual = (BestFirstNode) listForTree.get(listForTree.indexOf(actual));
			}
			
			stepOnNodes.add(String.valueOf(actual.getId()));
			stepOnNodes.add(String.valueOf(treeActual.getId()));
			
			if(!reachedBestFirstNodes.contains(actual)){
				reachedBestFirstNodes.add(actual);
			}
			
			/*if(actual.getOperator() != null){
				steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + "|" + actual.getId() + "\n");
			} else {
				steps.append(actual.getId() + "\n");
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
			return SolutionHelper.writeOutputForGraphic(getClass(), reachedBestFirstNodes, listForTree, Arrays.asList(actual, treeActual), steps.toString(), OPERATORS);
		} else {
			System.out.println("No solution.");
			return null;
		}
	}
}
