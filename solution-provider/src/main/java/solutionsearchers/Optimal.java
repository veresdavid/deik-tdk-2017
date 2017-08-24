package solutionsearchers;

import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.Node;
import nodes.OptimalNode;
import solutionsearchers.helpers.SolutionHelper;

public class Optimal extends SolutionSearcher {
	
	private OptimalNode actual;
	private OptimalNode treeActual;
	private List<OptimalNode> openNodes = new ArrayList<>();
	private List<OptimalNode> closedNodes = new ArrayList<>();
	private int maxId;
	private int treeId;
	
	public Optimal(StateInterface state){
		OptimalNode start = new OptimalNode(state.getStart(), null, null, 0, 0);
		treeId = -1;
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
		for (OperatorInterface operator : operators) {
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
					informationCollector.addGraphEdgeToActivateEdges(getEdgeId(newNode));
					informationCollector.addTreeEdgeToActivateEdges(getEdgeId(newTreeNode));
				} else if (openNodesContains != null){
					double newPathCost = node.getPathCost() + operator.getCost();
					if(newPathCost < openNodesContains.getPathCost()){
						Node openNodeInTree = informationCollector.getListForTree().get(informationCollector.getListForTree().indexOf(openNodesContains));

						informationCollector.addGraphEdgeToInactivateEdges(getEdgeId(openNodesContains));
						informationCollector.addTreeEdgeToInactivateEdges(getEdgeId(openNodeInTree));
						
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
						informationCollector.addGraphEdgeToActivateEdges(getEdgeId(openNodesContains));
						informationCollector.addTreeEdgeToActivateEdges(getEdgeId(newTreeNode));
					}
				}
			}
		}
		openNodes.remove(node);
		closedNodes.add(node);
		informationCollector.appendSteps();
		informationCollector.addGraphNodeToCloseNodes(node);
		informationCollector.addTreeNodeToCloseNodes(treeActual);
	}
	
	@Override
	public void search(){
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
			
			if(actual.getState().isGoal()){
				informationCollector.appendSteps();
				break;
			}
			
			expand(actual);
		}
		
		if(!openNodes.isEmpty()){
			solution = actual;
			treeSolution = treeActual;
		}
	}
}