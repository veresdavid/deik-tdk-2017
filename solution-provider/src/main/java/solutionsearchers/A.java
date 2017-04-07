package solutionsearchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.ANode;
import nodes.Node;

public class A {

	private List<Node> reachedANodes;
	private List<Node> listForTree;
	private StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;
	
	private List<OperatorInterface> OPERATORS;
	private ANode actual;
	private ANode treeActual;
	private String heuristicFunction;
	private Set<String> variablesInHeuristicFunction;
	private List<ANode> openNodes = new ArrayList<>();
	private List<ANode> closedNodes = new ArrayList<>();
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
	
	public A(ANode start, String heuristicFunction, Set<String> variablesInHeuristicFunction, List<OperatorInterface> OPERATORS){
		reachedANodes = new ArrayList<>();
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
	
	private ANode isContains(List<ANode> nodes, StateInterface state){
		for(ANode node : nodes){
			if(node.getState().equals(state)){
				return node;
			}
		}
		return null;
	}
	
	private void extend(ANode node){
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				ANode openNodesContains = isContains(openNodes, newState);
				ANode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, reachedANodes);
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					ANode newNode = new ANode(newState, node, operator, nodeId, node.getPathCost() + operator.getCost(), heuristicFunction, variablesInHeuristicFunction);
					openNodes.add(newNode);
					
					ANode newTreeNode = new ANode(newNode.getState(), treeActual, operator, treeId, newNode.getPathCost(), heuristicFunction, variablesInHeuristicFunction);
					listForTree.add(newTreeNode);
					treeId--;
					
					if(!reachedANodes.contains(newNode)){
						reachedANodes.add(newNode);
					}
					
					activateNodes.add(String.valueOf(newNode.getId()));
					activateNodes.add(String.valueOf(newTreeNode.getId()));
					activateEdges.add(newNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newNode.getOperator()) + "-" + newNode.getId());
					activateEdges.add(newTreeNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newTreeNode.getOperator()) + "-" + newTreeNode.getId());
					//newOpenNodeIdList.add(newNode.getId());
					//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				} else {
					double newPathCost = node.getPathCost() + operator.getCost();
					
					if (openNodesContains != null){
						if(newPathCost < openNodesContains.getPathCost()){
							Node openNodeInTree = listForTree.get(listForTree.indexOf(openNodesContains));
							
							inactivateEdges.add(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
							inactivateEdges.add(openNodeInTree.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodeInTree.getOperator()) + "-" + openNodeInTree.getId());
							
							openNodesContains.setParent(node);
							openNodesContains.setOperator(operator);
							openNodesContains.setPathCost(newPathCost);
							
							ANode newTreeNode = new ANode(openNodesContains.getState(), treeActual, operator, treeId, openNodesContains.getPathCost(), heuristicFunction, variablesInHeuristicFunction);
							listForTree.add(newTreeNode);
							treeId--;
							
							if(!reachedANodes.contains(openNodesContains)){
								reachedANodes.add(openNodesContains);
							}
							
							//activateNodes.add(String.valueOf(openNodesContains.getId()));
							activateNodes.add(String.valueOf(newTreeNode.getId()));
							activateEdges.add(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
							activateEdges.add(newTreeNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newTreeNode.getOperator()) + "-" + newTreeNode.getId());
							//newOpenNodeIdList.add(openNodesContains.getId());
							//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
						}
					} else {
						if(newPathCost < closedNodesContains.getPathCost()){
							Node openNodeInTree = listForTree.get(listForTree.indexOf(closedNodesContains));
							
							inactivateEdges.add(closedNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(closedNodesContains.getOperator()) + "-" + closedNodesContains.getId());
							inactivateEdges.add(openNodeInTree.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodeInTree.getOperator()) + "-" + openNodeInTree.getId());
							
							closedNodesContains.setParent(node);
							closedNodesContains.setOperator(operator);
							closedNodesContains.setPathCost(newPathCost);
							closedNodes.remove(closedNodesContains);
							openNodes.add(closedNodesContains);
							
							ANode newTreeNode = new ANode(closedNodesContains.getState(), treeActual, operator, treeId, closedNodesContains.getPathCost(), heuristicFunction, variablesInHeuristicFunction);
							listForTree.add(newTreeNode);
							treeId--;
							
							if(!reachedANodes.contains(closedNodesContains)){
								reachedANodes.add(closedNodesContains);
							}
							
							activateNodes.add(String.valueOf(closedNodesContains.getId()));
							activateNodes.add(String.valueOf(newTreeNode.getId()));
							activateEdges.add(closedNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(closedNodesContains.getOperator()) + "-" + closedNodesContains.getId());
							activateEdges.add(newTreeNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newTreeNode.getOperator()) + "-" + newTreeNode.getId());
							//newOpenNodeIdList.add(closedNodesContains.getId());
							//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
						}
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
			
			for(ANode openNode : openNodes){
				if(openNode.getPathCost() + openNode.getHeuristic() < actual.getPathCost() + actual.getHeuristic()){
					actual = openNode;
				}
			}
			
			if(!listForTree.contains(actual)){
				treeActual = new ANode(actual.getState(), (ANode) actual.getParent(), actual.getOperator(), treeId, actual.getPathCost(), heuristicFunction, variablesInHeuristicFunction);
				treeId--;
				listForTree.add(treeActual);
			} else {
				treeActual = (ANode) listForTree.get(listForTree.indexOf(actual));
			}
			
			stepOnNodes.add(String.valueOf(actual.getId()));
			stepOnNodes.add(String.valueOf(treeActual.getId()));
			
			if(!reachedANodes.contains(actual)){
				reachedANodes.add(actual);
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
			return SolutionHelper.writeOutputForGraphic(getClass(), reachedANodes, listForTree, Arrays.asList(actual, treeActual), steps.toString(), OPERATORS);
		} else {
			System.out.println("No solution.");
			// TODO
			return null;
		}
	}
}
