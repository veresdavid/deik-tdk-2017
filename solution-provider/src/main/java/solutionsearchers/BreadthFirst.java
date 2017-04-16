package solutionsearchers;

import java.util.LinkedList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BreadthFirstNode;
import solutionsearchers.helpers.InformationCollector;
import solutionsearchers.helpers.SolutionHelper;

public class BreadthFirst {
	
	private List<OperatorInterface> OPERATORS;
	private BreadthFirstNode actual;
	private LinkedList<BreadthFirstNode> openNodes = new LinkedList<>();
	private LinkedList<BreadthFirstNode> closedNodes = new LinkedList<>();
	private int maxId;
	private InformationCollector informationCollector;
	
	public BreadthFirst(BreadthFirstNode start, List<OperatorInterface> OPERATORS, InformationCollector informationCollector){
		this.OPERATORS = OPERATORS;
		this.informationCollector = informationCollector;
		openNodes.add(start);
		informationCollector.addGraphNodeToActivateNodes(start);
		informationCollector.appendSteps();
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
	
	private void expand(BreadthFirstNode node){
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				boolean isOpenNodesContains = isContains(openNodes, newState);
				boolean isClosedNodesContains = isContains(closedNodes, newState);
				
				if(!(isOpenNodesContains || isClosedNodesContains)){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, informationCollector.getListForGraph());
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BreadthFirstNode newNode = new BreadthFirstNode(newState, node, operator, nodeId, node.getDepth() + 1);
					openNodes.addLast(newNode);
					
					if(!informationCollector.getListForGraph().contains(newNode)){
						informationCollector.getListForGraph().add(newNode);
					}
					
					informationCollector.addGraphNodeToActivateNodes(newNode);
					informationCollector.addGraphEdgeToActivateEdges(newNode.getParent().getId() + "-OP" + OPERATORS.indexOf(newNode.getOperator()) + "-" + newNode.getId());
					//newOpenNodeIdList.add(newNode.getId());
					//operatorIdList.add("OP" + OPERATORS.indexOf(operator));
				}
			}
		}
		openNodes.remove(node);
		closedNodes.add(node);
		informationCollector.appendSteps();
		informationCollector.addGraphNodeToCloseNodes(node);
		//steps.append(operatorIdList + "|" + newOpenNodeIdList + "|");
	}
	
	public String search(){
		while(true){
			if(openNodes.isEmpty()){
				break;
			}
			
			actual = openNodes.getFirst();
			informationCollector.addGraphNodeToStepOnNodes(actual);
			if(!informationCollector.getListForGraph().contains(actual)){
				informationCollector.getListForGraph().add(actual);
			}

			
			/*if(actual.getOperator() != null){
				//steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + "|" + actual.getId() + "\n");
			} else {
				//steps.append(actual.getId() + "\n");
			}*/
			
			if(actual.getState().isGoal()){
				informationCollector.appendSteps();
				break;
			}
			
			expand(actual);
		}
		if(!openNodes.isEmpty()){
			return informationCollector.writeOutputSolution(getClass(), actual, null, OPERATORS);
		} else {
			return informationCollector.writeOutputNoSolution(getClass(), OPERATORS);
		}
	}
}
