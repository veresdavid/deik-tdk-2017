package solutionsearchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.Node;
import nodes.OptimalNode;

public class Optimal {
	
	private List<Node> reachedOptimalNodes;
	private List<Node> listForTree;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private OptimalNode actual;
	private OptimalNode treeActual;
	private List<OptimalNode> openNodes = new ArrayList<>();
	private List<OptimalNode> closedNodes = new ArrayList<>();
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
	
	public Optimal(OptimalNode start, List<OperatorInterface> OPERATORS){
		reachedOptimalNodes = new ArrayList<>();
		listForTree = new ArrayList<>();
		steps = new StringBuilder();
		activateNodes = new ArrayList<>();
		inactivateNodes = new ArrayList<>();
		stepOnNodes = new ArrayList<>();
		closeNodes = new ArrayList<>();
		activateEdges = new ArrayList<>();
		inactivateEdges = new ArrayList<>();
		treeId = -1;
		this.OPERATORS = OPERATORS;
		openNodes.add(start);
		activateNodes.add(String.valueOf(start.getId()));
		activateNodes.add(String.valueOf(treeId));
		appendSteps();
		maxId = start.getId();
	}
	
	private OptimalNode isContains(List<OptimalNode> nodes, StateInterface state){
		for(OptimalNode node : nodes){
			if(node.getState().equals(state)){
				return node;
			}
		}
		return null;
	}
	
	private void extend(OptimalNode node){
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				OptimalNode openNodesContains = isContains(openNodes, newState);
				OptimalNode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedOptimalNodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					OptimalNode newNode = new OptimalNode(newState, node, operator, nodeId, node.getPathCost() + operator.getCost());
					openNodes.add(newNode);
					
					OptimalNode newTreeNode = new OptimalNode(newNode.getState(), treeActual, operator, treeId, newNode.getPathCost());
					listForTree.add(newTreeNode);
					treeId--;
					
					if(!reachedOptimalNodes.contains(newNode)){
						reachedOptimalNodes.add(newNode);
					}
					
					activateNodes.add(String.valueOf(newNode.getId()));
					activateNodes.add(String.valueOf(newTreeNode.getId()));
					activateEdges.add(newNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newNode.getOperator()) + "-" + newNode.getId());
					activateEdges.add(newTreeNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newTreeNode.getOperator()) + "-" + newTreeNode.getId());
					//newOpenNodeIdList.add(newNode.getId());
					//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				} else if (openNodesContains != null){
					double newPathCost = node.getPathCost() + operator.getCost();
					if(newPathCost < openNodesContains.getPathCost()){
						Node openNodeInTree = listForTree.get(listForTree.indexOf(openNodesContains));

						inactivateEdges.add(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
						inactivateEdges.add(openNodeInTree.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodeInTree.getOperator()) + "-" + openNodeInTree.getId());
						
						openNodesContains.setParent(node);
						openNodesContains.setOperator(operator);
						openNodesContains.setPathCost(newPathCost);
						
						OptimalNode newTreeNode = new OptimalNode(openNodesContains.getState(), treeActual, operator, treeId, openNodesContains.getPathCost());
						listForTree.add(newTreeNode);
						treeId--;
						
						if(!reachedOptimalNodes.contains(openNodesContains)){
							reachedOptimalNodes.add(openNodesContains);
						}
						
						// TODO ez lehet nem kell mert már eddig is nyitott volt
						//activateNodes.add(String.valueOf(openNodesContains.getId()));
						activateNodes.add(String.valueOf(newTreeNode.getId()));
						activateEdges.add(newTreeNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newTreeNode.getOperator()) + "-" + newTreeNode.getId());
						activateEdges.add(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
						//newOpenNodeIdList.add(openNodesContains.getId());
						//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
					}
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
			
			for(OptimalNode openNode : openNodes){
				if(openNode.getPathCost() < actual.getPathCost()){
					actual = openNode;
				}
			}
			
			if(!listForTree.contains(actual)){
				treeActual = new OptimalNode(actual.getState(), (OptimalNode) actual.getParent(), actual.getOperator(), treeId, actual.getPathCost());
				treeId--;
				listForTree.add(treeActual);
			} else {
				treeActual = (OptimalNode) listForTree.get(listForTree.indexOf(actual));
			}
			
			stepOnNodes.add(String.valueOf(actual.getId()));
			stepOnNodes.add(String.valueOf(treeActual.getId()));
			
			if(!reachedOptimalNodes.contains(actual)){
				reachedOptimalNodes.add(actual);
			}
			
			if(!listForTree.contains(treeActual)){
				listForTree.add(treeActual);
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
			return SolutionHelper.writeOutputForGraphic(getClass(), reachedOptimalNodes, listForTree, Arrays.asList(actual, treeActual), steps.toString(), OPERATORS);
		} else {
			System.out.println("No solution.");
			return null;
		}
	}
	
}
