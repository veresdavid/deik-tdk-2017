package solutionsearchers;

import java.util.ArrayList;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackSimpleNode;
import solutionsearchers.helpers.SolutionHelper;

public class BackTrackSimple extends SolutionSearcher{
	
	private BackTrackSimpleNode actual;
	private BackTrackSimpleNode treeActual;
	private int maxId;
	private int treeId;
	
	public BackTrackSimple(StateInterface state){
		actual = new BackTrackSimpleNode(state.getStart(), null, null, 0, new ArrayList<>());
		actual.setNumOfNodeStepOns(1);
		treeId = -1;
		treeActual = new BackTrackSimpleNode(actual.getState(), (BackTrackSimpleNode) actual.getParent(), actual.getOperator(), treeId, actual.getTried());
		treeId--;
		informationCollector.addGraphNodeToActivateNodes(actual);
		informationCollector.addTreeNodeToActivateNodes(treeActual);
		informationCollector.addGraphNodeToStepOnNodes(actual);
		informationCollector.addTreeNodeToStepOnNodes(treeActual);
		informationCollector.appendSteps();
		maxId = actual.getId();
	}
	
	@Override
	public void search(){
		int i = 0;
		while(i < 2500){
			i++;
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
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : operators) {

				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {

					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, informationCollector.getListForGraph());
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackSimpleNode newNode = new BackTrackSimpleNode(newState, actual, operator, nodeId, new ArrayList<>());
					actual = newNode;
					actual.setNumOfNodeStepOns(1);
					
					treeActual = new BackTrackSimpleNode(actual.getState(), treeActual, operator, treeId, actual.getTried());
					informationCollector.getListForTree().add(treeActual);
					treeId--;
					
					wasOperatorUsed = true;
					break;

				}

			}
			
			if (!wasOperatorUsed) {
				if(actual.getParent() != null){
					informationCollector.addGraphEdgeToInactivateEdges(getEdgeId(actual));
					informationCollector.addTreeEdgeToInactivateEdges(getEdgeId(treeActual));
				}
				
				if(actual.getNumOfNodeStepOns() == 1){
					informationCollector.addGraphNodeToInactivateNodes(actual);
				} else {
					informationCollector.addGraphNodeToCloseNodes(actual);
				}
				informationCollector.addTreeNodeToInactivateNodes(treeActual);
				informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackSimpleNode) actual.getParent();
				treeActual = (BackTrackSimpleNode) treeActual.getParent();
				
				if(actual != null){
					informationCollector.addGraphNodeToStepOnNodes(actual);
					informationCollector.addTreeNodeToStepOnNodes(treeActual);
				}
			} else {
				if(informationCollector.getStepsOnStates().containsKey(actual.getState())){
					actual.setNumOfNodeStepOns(informationCollector.getStepsOnStates().get(actual.getState()) + 1);
					informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns());
				}
				
				informationCollector.addGraphEdgeToActivateEdges(getEdgeId(actual));
				informationCollector.addTreeEdgeToActivateEdges(getEdgeId(treeActual));
				informationCollector.addGraphNodeToActivateNodes(actual);
				informationCollector.addTreeNodeToActivateNodes(treeActual);
				informationCollector.addGraphNodeToStepOnNodes(actual);
				informationCollector.addTreeNodeToStepOnNodes(treeActual);
				informationCollector.addGraphNodeToCloseNodes(actual.getParent());
				informationCollector.addTreeNodeToCloseNodes(treeActual.getParent());
			}
			informationCollector.appendSteps();
		}
		
		if(actual != null){
			solution = actual;
			treeSolution = treeActual;
		}
	}
}
