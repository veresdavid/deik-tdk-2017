package solutionsearchers;

import java.util.ArrayList;
import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackOptimalNode;
import solutionsearchers.helpers.InformationCollector;
import solutionsearchers.helpers.SolutionHelper;

public class BackTrackOptimal {
	
	private List<OperatorInterface> OPERATORS;
	private BackTrackOptimalNode actual;
	private BackTrackOptimalNode treeActual;
	private BackTrackOptimalNode solution;
	private BackTrackOptimalNode treeSolution;
	private boolean didFind;
	private int pathLengthLimitation;
	private int maxId;
	private int treeId;
	private InformationCollector informationCollector;
	
	public BackTrackOptimal(BackTrackOptimalNode start, int pathLengthLimitation, List<OperatorInterface> OPERATORS, InformationCollector informationCollector){
		actual = start;
		actual.setNumOfNodeStepOns(1);
		treeId = -1;
		treeActual = new BackTrackOptimalNode(actual.getState(), (BackTrackOptimalNode) actual.getParent(), actual.getOperator(), treeId, actual.getTried(), actual.getDepth());
		treeId--;
		this.pathLengthLimitation = pathLengthLimitation;
		this.OPERATORS = OPERATORS;
		this.informationCollector = informationCollector;
		informationCollector.addGraphNodeToActivateNodes(actual);
		informationCollector.addTreeNodeToActivateNodes(treeActual);
		informationCollector.addGraphNodeToStepOnNodes(actual);
		informationCollector.addTreeNodeToStepOnNodes(treeActual);
		informationCollector.appendSteps();
		//steps.append(actual.getId() + "\n");
		didFind = false;
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
			
			if(actual.getOperator() != null){
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				if(!informationCollector.getStepsOnEdges().containsKey(operatorId)){
					informationCollector.getStepsOnEdges().put(operatorId, actual.getNumOfEdgeStepOns());
				}
			}

			if(actual.getState().isGoal()){
				didFind = true;
				solution = actual;
				treeSolution = treeActual;
				pathLengthLimitation = actual.getDepth();
			}
			
			if(actual.getDepth() == pathLengthLimitation){
				//OperatorInterface operator = actual.getOperator();
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				String treeOperatorId = treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId();
				if(actual.getNumOfEdgeStepOns() == 1){
					informationCollector.addGraphEdgeToInactivateEdges(operatorId);
				}
				informationCollector.addTreeEdgeToInactivateEdges(treeOperatorId);
				informationCollector.getStepsOnEdges().put(operatorId, actual.getNumOfEdgeStepOns() - 1);

				if(actual.getNumOfNodeStepOns() == 1){
					informationCollector.addGraphNodeToInactivateNodes(actual);
				} else {
					informationCollector.addGraphNodeToCloseNodes(actual);
				}
				informationCollector.addTreeNodeToInactivateNodes(treeActual);
				informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackOptimalNode) actual.getParent();
				treeActual = (BackTrackOptimalNode) treeActual.getParent();

				informationCollector.addGraphNodeToStepOnNodes(actual);
				informationCollector.addTreeNodeToStepOnNodes(treeActual);
				informationCollector.appendSteps();
				//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
			}
			
			boolean wasOperatorUsed = false;
			
			for (OperatorInterface operator : OPERATORS) {

				if (operator.isApplicable(actual.getState()) && !actual.getTried().contains(operator)) {

					actual.getTried().add(operator);
					StateInterface newState = operator.apply(actual.getState());
					int nodeId = SolutionHelper.getNodeId(newState, maxId, informationCollector.getListForGraph());
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BackTrackOptimalNode newNode = new BackTrackOptimalNode(newState, actual, operator, nodeId, new ArrayList<>(), actual.getDepth() + 1);
					actual = newNode;
					actual.setNumOfNodeStepOns(1);
					actual.setNumOfEdgeStepOns(1);
					
					treeActual = new BackTrackOptimalNode(actual.getState(), treeActual, operator, treeId, actual.getTried(), actual.getDepth());
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
					if(actual.getNumOfEdgeStepOns() == 1){
						informationCollector.addGraphEdgeToInactivateEdges(operatorId);
					}
					informationCollector.addTreeEdgeToInactivateEdges(treeOperatorId);
					informationCollector.getStepsOnEdges().put(operatorId, actual.getNumOfEdgeStepOns() - 1);
				}
				
				if(actual.getNumOfNodeStepOns() == 1){
					informationCollector.addGraphNodeToInactivateNodes(actual);
				} else {
					informationCollector.addGraphNodeToCloseNodes(actual);
				}
				informationCollector.addTreeNodeToInactivateNodes(treeActual);
				informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns() - 1);
				
				actual = (BackTrackOptimalNode) actual.getParent();
				treeActual = (BackTrackOptimalNode) treeActual.getParent();
				
				if(actual != null){
					informationCollector.addGraphNodeToStepOnNodes(actual);
					informationCollector.addTreeNodeToStepOnNodes(treeActual);
					//steps.append("BACK OP" + OPERATORS.indexOf(operator) + " " + actual.getId() + "\n");
				}
			} else {
				String operatorId = actual.getParent().getId() + "-OP" + OPERATORS.indexOf(actual.getOperator()) + "-" + actual.getId();
				String treeOperatorId = treeActual.getParent().getId() + "-OP" + OPERATORS.indexOf(treeActual.getOperator()) + "-" + treeActual.getId();
				if(informationCollector.getStepsOnEdges().containsKey(operatorId)){
					actual.setNumOfEdgeStepOns(informationCollector.getStepsOnEdges().get(operatorId) + 1);
					informationCollector.getStepsOnEdges().put(operatorId, actual.getNumOfEdgeStepOns());
				}
				
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
		
		if(didFind){
			return informationCollector.writeOutputSolution(getClass(), solution, treeSolution, OPERATORS);
		} else {
			return informationCollector.writeOutputNoSolution(getClass(), OPERATORS);
		}
	}
}
