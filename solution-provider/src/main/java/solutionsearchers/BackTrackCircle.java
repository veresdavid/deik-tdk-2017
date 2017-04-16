package solutionsearchers;

import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackCircleNode;
import solutionsearchers.helpers.InformationCollector;
import solutionsearchers.helpers.SolutionHelper;

public class BackTrackCircle {
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackCircleNode actual;
	private BackTrackCircleNode treeActual;
	private List<BackTrackCircleNode> reachedNodes;
	private int maxId;
	private int treeId;
	private InformationCollector informationCollector;
	
	private boolean isReached(BackTrackCircleNode node){
		for(BackTrackCircleNode reachedNode : reachedNodes){
			if(reachedNode.getState().equals(node.getState())){
				return true;
			}
		}
		return false;
	}
	
	public BackTrackCircle(BackTrackCircleNode start, List<OperatorInterface> OPERATORS, InformationCollector informationCollector){
		actual = start;
		actual.setNumOfNodeStepOns(1);
		treeId = -1;
		treeActual = new BackTrackCircleNode(actual.getState(), (BackTrackCircleNode) actual.getParent(), actual.getOperator(), treeId, actual.getTried());
		treeId--;
		this.OPERATORS = OPERATORS;
		this.informationCollector = informationCollector;
		informationCollector.addGraphNodeToActivateNodes(actual);
		informationCollector.addTreeNodeToActivateNodes(treeActual);
		informationCollector.addGraphNodeToStepOnNodes(actual);
		informationCollector.addTreeNodeToStepOnNodes(treeActual);
		informationCollector.appendSteps();
		//steps.append(actual.getId() + "\n");
		reachedNodes = new ArrayList<>();
		maxId = start.getId();
	}
	
	public String search(){
		while(true){		
			if(actual == null){
				break;
			}
			
			if(!informationCollector.getListForGraph().contains(actual)){
				informationCollector.getListForGraph().add(actual);
			}
			
			if(!informationCollector.getStepsOnStates().containsKey(actual.getState())){
				informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns());
			}
			
			if(!informationCollector.getListForTree().contains(treeActual)){
				informationCollector.getListForTree().add(treeActual);
			}
			
			if(actual.getState().isGoal()){
				break;
			}
			
			if(isReached(actual)){
				//OperatorInterface operator = actual.getOperator();
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				String treeOperatorId = treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId();
				informationCollector.addGraphEdgeToInactivateEdges(operatorId);
				informationCollector.addTreeEdgeToInactivateEdges(treeOperatorId);
				if(actual.getNumOfNodeStepOns() == 1){
					informationCollector.addGraphNodeToInactivateNodes(actual);
				} else {
					informationCollector.addGraphNodeToCloseNodes(actual);
				}
				informationCollector.addTreeNodeToInactivateNodes(treeActual);
				informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackCircleNode) actual.getParent();
				treeActual = (BackTrackCircleNode) treeActual.getParent();

				informationCollector.addGraphNodeToStepOnNodes(actual);
				informationCollector.addTreeNodeToStepOnNodes(treeActual);
				informationCollector.appendSteps();
				//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
			} else {
				reachedNodes.add(actual);
			}
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : OPERATORS) {
				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {
					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, informationCollector.getListForGraph());
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackCircleNode newNode = new BackTrackCircleNode(newState, actual, operator, nodeId, new ArrayList<>());
					actual = newNode;
					actual.setNumOfNodeStepOns(1);
					
					treeActual = new BackTrackCircleNode(actual.getState(), treeActual, operator, treeId, actual.getTried());
					informationCollector.getListForTree().add(treeActual);
					treeId--;
					
					wasOperatorUsed = true;
					break;

				}
			}
			
			if (!wasOperatorUsed) {
				//OperatorInterface operator = actual.getOperator();
				if(actual.getParent() != null){
					String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
					String treeOperatorId = treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId();
					informationCollector.addGraphEdgeToInactivateEdges(operatorId);
					informationCollector.addTreeEdgeToInactivateEdges(treeOperatorId);
				}
				
				if(actual.getNumOfNodeStepOns() == 1){
					informationCollector.addGraphNodeToInactivateNodes(actual);
				} else {
					informationCollector.addGraphNodeToCloseNodes(actual);
				}
				informationCollector.addTreeNodeToInactivateNodes(treeActual);
				informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackCircleNode) actual.getParent();
				treeActual = (BackTrackCircleNode) treeActual.getParent();
				
				if(actual != null){
					informationCollector.addGraphNodeToStepOnNodes(actual);
					informationCollector.addTreeNodeToStepOnNodes(treeActual);
					//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
				}
			} else {
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				String treeOperatorId = treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId();
				if(informationCollector.getStepsOnStates().containsKey(actual.getState())){
					actual.setNumOfNodeStepOns(informationCollector.getStepsOnStates().get(actual.getState()) + 1);
					informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns());
				}
				
				informationCollector.addGraphEdgeToActivateEdges(operatorId);
				informationCollector.addTreeEdgeToActivateEdges(treeOperatorId);
				informationCollector.addGraphNodeToActivateNodes(actual);
				informationCollector.addTreeNodeToActivateNodes(treeActual);
				informationCollector.addGraphNodeToStepOnNodes(actual);
				informationCollector.addTreeNodeToStepOnNodes(treeActual);
				informationCollector.addGraphNodeToCloseNodes(actual.getParent());
				informationCollector.addTreeNodeToCloseNodes(treeActual.getParent());
				//steps.append("OP" + OPERATORS.indexOf(actual.getOperator()) + " " + actual.getId() + "\n");
			}
			informationCollector.appendSteps();
		}
		
		if(actual != null){
			return informationCollector.writeOutputSolution(getClass(), actual, treeActual, OPERATORS);
		} else {
			return informationCollector.writeOutputNoSolution(getClass(), OPERATORS);
		}
	}
}