package solutionsearchers;

import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.Node;
import nodes.OptimalNode;
import solutionsearchers.helpers.InformationCollector;
import solutionsearchers.helpers.SolutionHelper;

public class Optimal {
	
	private List<OperatorInterface> OPERATORS;
	private OptimalNode actual;
	private OptimalNode treeActual;
	private List<OptimalNode> openNodes = new ArrayList<>();
	private List<OptimalNode> closedNodes = new ArrayList<>();
	private int maxId;
	private int treeId;
	private InformationCollector informationCollector;
	
	public Optimal(OptimalNode start, List<OperatorInterface> OPERATORS, InformationCollector informationCollector){
		treeId = -1;
		this.OPERATORS = OPERATORS;
		this.informationCollector = informationCollector;
		openNodes.add(start);
		informationCollector.addGraphNodeToActivateNodes(start);
		informationCollector.addTreeNodeToActivateNodes(new OptimalNode(start.getState(), (OptimalNode) start.getParent(), start.getOperator(), treeId, start.getPathCost()));
		informationCollector.appendSteps();
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
	
	private void expand(OptimalNode node){
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				OptimalNode openNodesContains = isContains(openNodes, newState);
				OptimalNode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, informationCollector.getListForGraph());
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					OptimalNode newNode = new OptimalNode(newState, node, operator, nodeId, node.getPathCost() + operator.getCost());
					openNodes.add(newNode);
					
					OptimalNode newTreeNode = new OptimalNode(newNode.getState(), treeActual, operator, treeId, newNode.getPathCost());
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
				} else if (openNodesContains != null){
					double newPathCost = node.getPathCost() + operator.getCost();
					if(newPathCost < openNodesContains.getPathCost()){
						Node openNodeInTree = informationCollector.getListForTree().get(informationCollector.getListForTree().indexOf(openNodesContains));

						informationCollector.addGraphEdgeToInactivateEdges(openNodesContains.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodesContains.getOperator()) + "-" + openNodesContains.getId());
						informationCollector.addTreeEdgeToInactivateEdges(openNodeInTree.getParent().getId() + "-OP" + OPERATORS.indexOf(openNodeInTree.getOperator()) + "-" + openNodeInTree.getId());
						
						openNodesContains.setParent(node);
						openNodesContains.setOperator(operator);
						openNodesContains.setPathCost(newPathCost);
						
						OptimalNode newTreeNode = new OptimalNode(openNodesContains.getState(), treeActual, operator, treeId, openNodesContains.getPathCost());
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
	
	public String search(){
		while(true){
			if(openNodes.isEmpty()){
				break;
			}
			
			actual = openNodes.get(0);
			
			for(OptimalNode openNode : openNodes){
				if(openNode.getPathCost() < actual.getPathCost()){
					actual = openNode;
				}
			}
			
			if(!informationCollector.getListForTree().contains(actual)){
				treeActual = new OptimalNode(actual.getState(), (OptimalNode) actual.getParent(), actual.getOperator(), treeId, actual.getPathCost());
				treeId--;
				informationCollector.getListForTree().add(treeActual);
			} else {
				treeActual = (OptimalNode) informationCollector.getListForTree().get(informationCollector.getListForTree().indexOf(actual));
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
