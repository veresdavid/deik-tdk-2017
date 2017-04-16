package solutionsearchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exceptions.InvalidVariableException;
import exceptions.TypeMismatchException;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.ANode;
import nodes.Node;
import solutionsearchers.helpers.InformationCollector;
import solutionsearchers.helpers.SolutionHelper;

public class A {

	private List<OperatorInterface> OPERATORS;
	private ANode actual;
	private ANode treeActual;
	private String heuristicFunction;
	private Set<String> variablesInHeuristicFunction;
	private List<ANode> openNodes = new ArrayList<>();
	private List<ANode> closedNodes = new ArrayList<>();
	private int maxId;
	private int treeId;
	private InformationCollector informationCollector;
	
	public A(ANode start, String heuristicFunction, Set<String> variablesInHeuristicFunction, List<OperatorInterface> OPERATORS, InformationCollector informationCollector) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException{
		treeId = -1;
		this.heuristicFunction = heuristicFunction;
		this.variablesInHeuristicFunction = variablesInHeuristicFunction;
		this.OPERATORS = OPERATORS;
		this.informationCollector = informationCollector;
		openNodes.add(start);
		informationCollector.addGraphNodeToActivateNodes(start);
		informationCollector.addTreeNodeToActivateNodes(new ANode(start.getState(), (ANode) start.getParent(), start.getOperator(), treeId, start.getPathCost(), heuristicFunction, variablesInHeuristicFunction));
		informationCollector.appendSteps();
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
	
	private void expand(ANode node) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException{
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				ANode openNodesContains = isContains(openNodes, newState);
				ANode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, informationCollector.getListForGraph());
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					ANode newNode = new ANode(newState, node, operator, nodeId, node.getPathCost() + operator.getCost(), heuristicFunction, variablesInHeuristicFunction);
					openNodes.add(newNode);
					
					ANode newTreeNode = new ANode(newNode.getState(), treeActual, operator, treeId, newNode.getPathCost(), heuristicFunction, variablesInHeuristicFunction);
					informationCollector.getListForTree().add(newTreeNode);
					treeId--;
					
					if(!informationCollector.getListForGraph().contains(newNode)){
						informationCollector.getListForGraph().add(newNode);
					}
					
					informationCollector.addGraphNodeToActivateNodes(newNode);
					informationCollector.addTreeNodeToActivateNodes(newTreeNode);
					informationCollector.addGraphEdgeToActivateEdges(newNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newNode.getOperator()) + "-" + newNode.getId());
					informationCollector.addTreeEdgeToActivateEdges(newTreeNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newTreeNode.getOperator()) + "-" + newTreeNode.getId());
					//newOpenNodeIdList.add(newNode.getId());
					//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				} else {
					double newPathCost = node.getPathCost() + operator.getCost();
					
					if (openNodesContains != null){
						if(newPathCost < openNodesContains.getPathCost()){
							Node openNodeInTree = informationCollector.getListForTree().get(informationCollector.getListForTree().indexOf(openNodesContains));
							
							informationCollector.addGraphEdgeToInactivateEdges(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
							informationCollector.addTreeEdgeToInactivateEdges(openNodeInTree.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodeInTree.getOperator()) + "-" + openNodeInTree.getId());
							
							openNodesContains.setParent(node);
							openNodesContains.setOperator(operator);
							openNodesContains.setPathCost(newPathCost);
							
							ANode newTreeNode = new ANode(openNodesContains.getState(), treeActual, operator, treeId, openNodesContains.getPathCost(), heuristicFunction, variablesInHeuristicFunction);
							informationCollector.getListForTree().add(newTreeNode);
							treeId--;
							
							if(!informationCollector.getListForGraph().contains(openNodesContains)){
								informationCollector.getListForGraph().add(openNodesContains);
							}
							
							informationCollector.addTreeNodeToActivateNodes(newTreeNode);
							informationCollector.addGraphEdgeToActivateEdges(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
							informationCollector.addTreeEdgeToActivateEdges(newTreeNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newTreeNode.getOperator()) + "-" + newTreeNode.getId());
							//newOpenNodeIdList.add(openNodesContains.getId());
							//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
						}
					} else {
						if(newPathCost < closedNodesContains.getPathCost()){
							Node openNodeInTree = informationCollector.getListForTree().get(informationCollector.getListForTree().indexOf(closedNodesContains));
							
							informationCollector.addGraphEdgeToInactivateEdges(closedNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(closedNodesContains.getOperator()) + "-" + closedNodesContains.getId());
							informationCollector.addTreeEdgeToInactivateEdges(openNodeInTree.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodeInTree.getOperator()) + "-" + openNodeInTree.getId());
							
							closedNodesContains.setParent(node);
							closedNodesContains.setOperator(operator);
							closedNodesContains.setPathCost(newPathCost);
							closedNodes.remove(closedNodesContains);
							openNodes.add(closedNodesContains);
							
							ANode newTreeNode = new ANode(closedNodesContains.getState(), treeActual, operator, treeId, closedNodesContains.getPathCost(), heuristicFunction, variablesInHeuristicFunction);
							informationCollector.getListForTree().add(newTreeNode);
							treeId--;
							
							if(!informationCollector.getListForGraph().contains(closedNodesContains)){
								informationCollector.getListForGraph().add(closedNodesContains);
							}
							
							informationCollector.addGraphNodeToActivateNodes(closedNodesContains);
							informationCollector.addTreeNodeToActivateNodes(newTreeNode);
							informationCollector.addGraphEdgeToActivateEdges(closedNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(closedNodesContains.getOperator()) + "-" + closedNodesContains.getId());
							informationCollector.addTreeEdgeToActivateEdges(newTreeNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newTreeNode.getOperator()) + "-" + newTreeNode.getId());
							//newOpenNodeIdList.add(closedNodesContains.getId());
							//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
						}
					}
				}
			}
		}
		openNodes.remove(node);
		closedNodes.add(node);
		informationCollector.appendSteps();
		informationCollector.addGraphNodeToCloseNodes(node);
		informationCollector.addTreeNodeToCloseNodes(treeActual);
		//steps.append(operatorIdList + "|" + newOpenNodeIdList + "|");
	}
	
	public String search() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException{
		while(true){
			if(openNodes.isEmpty()){
				break;
			}
			
			actual = openNodes.get(0);
			
			for(ANode openNode : openNodes){
				if(openNode.getPathCost() + openNode.getHeuristic() < actual.getPathCost() + actual.getHeuristic()){
					actual = openNode;
				}
			}
			
			if(!informationCollector.getListForTree().contains(actual)){
				treeActual = new ANode(actual.getState(), (ANode) actual.getParent(), actual.getOperator(), treeId, actual.getPathCost(), heuristicFunction, variablesInHeuristicFunction);
				treeId--;
				informationCollector.getListForTree().add(treeActual);
			} else {
				treeActual = (ANode) informationCollector.getListForTree().get(informationCollector.getListForTree().indexOf(actual));
			}
			
			informationCollector.addGraphNodeToStepOnNodes(actual);
			informationCollector.addTreeNodeToStepOnNodes(treeActual);
			
			if(!informationCollector.getListForGraph().contains(actual)){
				informationCollector.getListForGraph().add(actual);
			}
			
			/*if(actual.getOperator() != null){
				steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + "|" + actual.getId() + "\n");
			} else {
				steps.append(actual.getId() + "\n");
			}*/
			
			if(actual.getState().isGoal()){
				informationCollector.appendSteps();
				break;
			}
			
			expand(actual);
		}
		if(!openNodes.isEmpty()){
			return informationCollector.writeOutputSolution(getClass(), actual, treeActual, OPERATORS);
		} else {
			return informationCollector.writeOutputNoSolution(getClass(), OPERATORS);
		}
	}
}
