package solutionsearchers.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import interfaces.OperatorInterface;
import nodes.Node;

/**
 * Az alap információgyűjtő osztály kiegészítése a fához szükséges információgyűjtőkkel.
 * /
 * The standard informationcollector extended with the collectors for tree.
 * @author vecsi
 *
 */
public class ExtendedInformationCollector extends InformationCollector{

	public ExtendedInformationCollector() {
		super();
		listForTree = new ArrayList<>();
	}

	@Override
	public List<Node> getListForTree() {
		return listForTree;
	}

	@Override
	public void setListForTree(List<Node> listForTree) {
		this.listForTree = listForTree;
	}
	
	@Override
	public void addTreeNodeToActivateNodes(Node node){
		addNodeToActivateNodes(node);
	}
	
	@Override
	public void addTreeNodeToInactivateNodes(Node node){
		addNodeToInactivateNodes(node);
	}
	
	@Override
	public void addTreeNodeToStepOnNodes(Node node){
		addNodeToStepOnNodes(node);
	}
	
	@Override
	public void addTreeNodeToCloseNodes(Node node){
		addNodeToCloseNodes(node);
	}
	
	@Override
	public void addTreeEdgeToActivateEdges(String operatorId){
		addEdgeToActivateEdges(operatorId);
	}
	
	@Override
	public void addTreeEdgeToInactivateEdges(String operatorId){
		addEdgeToInactivateEdges(operatorId);
	}
	
	@Override
	public String writeOutputSolution(Class<?> clazz, Node solution, Node treeSolution, List<OperatorInterface> OPERATORS){
		return SolutionHelper.writeOutput(clazz, listForGraph, listForTree, Arrays.asList(solution, treeSolution), OPERATORS, OUTPUTFOLDERNAME, outputFileName);
	}
	
	@Override
	public String writeOutputNoSolution(Class<?> clazz, List<OperatorInterface> OPERATORS){
		return SolutionHelper.writeOutput(clazz, listForGraph, listForTree, Arrays.asList(), OPERATORS, OUTPUTFOLDERNAME, outputFileName);
	}
}
