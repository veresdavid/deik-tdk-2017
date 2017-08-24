package solutionsearchers;

import java.util.LinkedList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.DepthFirstNode;
import solutionsearchers.helpers.SolutionHelper;

public class DepthFirst extends SolutionSearcher {
	
	private DepthFirstNode actual;
	private LinkedList<DepthFirstNode> openNodes = new LinkedList<>();
	private LinkedList<DepthFirstNode> closedNodes = new LinkedList<>();
	private int maxId;
	
	public DepthFirst(StateInterface state){
		DepthFirstNode start = new DepthFirstNode(state.getStart(), null, null, 0, 0);
		openNodes.add(start);
		informationCollector.addGraphNodeToActivateNodes(start);
		informationCollector.appendSteps();
		maxId = start.getId();
	}
	
	private boolean isContains(List<DepthFirstNode> nodes, StateInterface state){
		for(DepthFirstNode node : nodes){
			if(node.getState().equals(state)){
				return true;
			}
		}
		return false;
	}
	
	private void expand(DepthFirstNode node){
		for (OperatorInterface operator : operators) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				boolean isOpenNodesContains = isContains(openNodes, newState);
				boolean isClosedNodesContains = isContains(closedNodes, newState);
				
				if(!(isOpenNodesContains || isClosedNodesContains)){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, informationCollector.getListForGraph());
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					DepthFirstNode newNode = new DepthFirstNode(newState, node, operator, nodeId, node.getDepth() + 1);
					openNodes.addFirst(newNode);
					
					if(!informationCollector.getListForGraph().contains(newNode)){
						informationCollector.getListForGraph().add(newNode);
					}
					
					informationCollector.addGraphNodeToActivateNodes(newNode);
					informationCollector.addGraphEdgeToActivateEdges(getEdgeId(newNode));
				}
			}
		}
		openNodes.remove(node);
		closedNodes.add(node);
		informationCollector.appendSteps();
		informationCollector.addGraphNodeToCloseNodes(node);
	}
	
	@Override
	public void search(){
		while(true){
			if(openNodes.isEmpty()){
				break;
			}
			
			actual = openNodes.getFirst();
			informationCollector.addGraphNodeToStepOnNodes(actual);
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
			treeSolution = null;
		}
	}
}
