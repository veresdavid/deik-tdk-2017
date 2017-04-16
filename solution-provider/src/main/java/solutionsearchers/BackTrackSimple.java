package solutionsearchers;

import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackSimpleNode;
import solutionsearchers.helpers.InformationCollector;
import solutionsearchers.helpers.SolutionHelper;

public class BackTrackSimple{
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackSimpleNode actual;
	private BackTrackSimpleNode treeActual;
	private int maxId;
	private int treeId;
	private InformationCollector informationCollector;
	
	public BackTrackSimple(BackTrackSimpleNode start, List<OperatorInterface> OPERATORS, InformationCollector informationCollector){
		actual = start;
		actual.setNumOfNodeStepOns(1);
		treeId = -1;
		treeActual = new BackTrackSimpleNode(actual.getState(), (BackTrackSimpleNode) actual.getParent(), actual.getOperator(), treeId, actual.getTried());
		treeId--;
		this.OPERATORS = OPERATORS;
		this.informationCollector = informationCollector;
		informationCollector.addGraphNodeToActivateNodes(actual);
		informationCollector.addTreeNodeToActivateNodes(treeActual);
		informationCollector.addGraphNodeToStepOnNodes(actual);
		informationCollector.addTreeNodeToStepOnNodes(treeActual);
		informationCollector.appendSteps();
		//steps.append(actual.getId() + "\n");
		maxId = start.getId();
	}
	
	public String search(){
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
			
			for (OperatorInterface operator : OPERATORS) {

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
				//OperatorInterface operator = actual.getOperator();
				if(actual.getParent() != null){
					String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
					String treeOperatorId = treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId();
					informationCollector.addGraphEdgeToInactivateEdges(operatorId);
					informationCollector.addTreeEdgeToInactivateEdges(treeOperatorId);
					//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
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
