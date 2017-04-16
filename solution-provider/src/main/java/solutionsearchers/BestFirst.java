package solutionsearchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import exceptions.InvalidVariableException;
import exceptions.TypeMismatchException;
import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BestFirstNode;
import solutionsearchers.helpers.InformationCollector;
import solutionsearchers.helpers.SolutionHelper;

public class BestFirst {
	
	private List<OperatorInterface> OPERATORS;
	private BestFirstNode actual;
	private BestFirstNode treeActual;
	private String heuristicFunction;
	private Set<String> variablesInHeuristicFunction;
	private List<BestFirstNode> openNodes = new ArrayList<>();
	private List<BestFirstNode> closedNodes = new ArrayList<>();
	private int maxId;
	private int treeId;
	private InformationCollector informationCollector;
	
	public BestFirst(BestFirstNode start, String heuristicFunction, Set<String> variablesInHeuristicFunction, List<OperatorInterface> OPERATORS, InformationCollector informationCollector) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException{
		treeId = -1;
		this.heuristicFunction = heuristicFunction;
		this.variablesInHeuristicFunction = variablesInHeuristicFunction;
		this.OPERATORS = OPERATORS;
		this.informationCollector = informationCollector;
		openNodes.add(start);
		informationCollector.addGraphNodeToActivateNodes(start);
		informationCollector.addTreeNodeToActivateNodes(new BestFirstNode(start.getState(), (BestFirstNode) start.getParent(), start.getOperator(), treeId, heuristicFunction, variablesInHeuristicFunction));
		informationCollector.appendSteps();
		maxId = start.getId();
	}
	
	private BestFirstNode isContains(List<BestFirstNode> nodes, StateInterface state){
		for(BestFirstNode node : nodes){
			if(node.getState().equals(state)){
				return node;
			}
		}
		return null;
	}
	
	private void expand(BestFirstNode node) throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InstantiationException, InvalidVariableException, TypeMismatchException{
		//List<Integer> newOpenNodeIdList = new ArrayList<>();
		//List<String> operatorIdList = new ArrayList<>();
		
		for (OperatorInterface operator : OPERATORS) {
			if(operator.isApplicable(node.getState())){
				StateInterface newState = operator.apply(node.getState());
				
				BestFirstNode openNodesContains = isContains(openNodes, newState);
				BestFirstNode closedNodesContains = isContains(closedNodes, newState);
				
				if(openNodesContains == null && closedNodesContains == null){
					int nodeId = SolutionHelper.getNodeId(newState, maxId, informationCollector.getListForGraph());
					
					if(maxId < nodeId)
						maxId = nodeId;
					
					BestFirstNode newNode = new BestFirstNode(newState, node, operator, nodeId, heuristicFunction, variablesInHeuristicFunction);
					openNodes.add(newNode);
					
					BestFirstNode newTreeNode = new BestFirstNode(newNode.getState(), treeActual, operator, treeId, heuristicFunction, variablesInHeuristicFunction);
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
			
			for(BestFirstNode openNode : openNodes){
				if(openNode.getHeuristic() < actual.getHeuristic()){
					actual = openNode;
				}
			}
			
			if(!informationCollector.getListForTree().contains(actual)){
				treeActual = new BestFirstNode(actual.getState(), (BestFirstNode) actual.getParent(), actual.getOperator(), treeId, heuristicFunction, variablesInHeuristicFunction);
				treeId--;
				informationCollector.getListForTree().add(treeActual);
			} else {
				treeActual = (BestFirstNode) informationCollector.getListForTree().get(informationCollector.getListForTree().indexOf(actual));
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
