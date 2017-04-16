package solutionsearchers.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.Node;

public class InformationCollector {

	private Map<StateInterface, Integer> stepsOnStates;
	private Map<String, Integer> stepsOnEdges;
	protected List<Node> listForGraph;
	protected List<Node> listForTree;
	protected StringBuilder steps;
	private List<String> activateNodes;
	private List<String> inactivateNodes;
	private List<String> stepOnNodes;
	private List<String> closeNodes;
	private List<String> activateEdges;
	private List<String> inactivateEdges;

	public InformationCollector() {
		stepsOnStates = new HashMap<>();
		stepsOnEdges = new HashMap<>();
		listForGraph = new ArrayList<>();
		steps = new StringBuilder();
		activateNodes = new ArrayList<>();
		inactivateNodes = new ArrayList<>();
		stepOnNodes = new ArrayList<>();
		closeNodes = new ArrayList<>();
		activateEdges = new ArrayList<>();
		inactivateEdges = new ArrayList<>();
	}

	public Map<StateInterface, Integer> getStepsOnStates() {
		return stepsOnStates;
	}

	public void setStepsOnStates(Map<StateInterface, Integer> stepsOnStates) {
		this.stepsOnStates = stepsOnStates;
	}

	public Map<String, Integer> getStepsOnEdges() {
		return stepsOnEdges;
	}

	public void setStepsOnEdges(Map<String, Integer> stepsOnEdges) {
		this.stepsOnEdges = stepsOnEdges;
	}

	public List<Node> getListForGraph() {
		return listForGraph;
	}

	public void setListForGraph(List<Node> listForGraph) {
		this.listForGraph = listForGraph;
	}

	public List<Node> getListForTree() {
		return new ArrayList<>();
	}

	public void setListForTree(List<Node> listForTree) {
	}

	public StringBuilder getSteps() {
		return steps;
	}

	public void setSteps(StringBuilder steps) {
		this.steps = steps;
	}

	public void appendSteps(){
		steps.append("Activated nodes: " + activateNodes);
		activateNodes.clear();
		steps.append(" Inactivated nodes: " + inactivateNodes);
		inactivateNodes.clear();
		steps.append(" Stepped on nodes: " + stepOnNodes);
		stepOnNodes.clear();
		steps.append(" Closed nodes: " + closeNodes);
		closeNodes.clear();
		steps.append(" Activated edges: " + activateEdges);
		activateEdges.clear();
		steps.append(" Inactivated edges: " + inactivateEdges + "\n");
		inactivateEdges.clear();
	}
	
	/*ActivateNodes*/
	protected void addNodeToActivateNodes(Node node){
		activateNodes.add(String.valueOf(node.getId()));
	}
	
	public void addGraphNodeToActivateNodes(Node node){
		addNodeToActivateNodes(node);
	}
	
	public void addTreeNodeToActivateNodes(Node node){
	}
	
	/*InactivateNodes*/
	protected void addNodeToInactivateNodes(Node node){
		inactivateNodes.add(String.valueOf(node.getId()));
	}
	
	public void addGraphNodeToInactivateNodes(Node node){
		addNodeToInactivateNodes(node);
	}
	
	public void addTreeNodeToInactivateNodes(Node node){
	}
	
	/*StepOnNodes*/
	protected void addNodeToStepOnNodes(Node node){
		stepOnNodes.add(String.valueOf(node.getId()));
	}
	
	public void addGraphNodeToStepOnNodes(Node node){
		addNodeToStepOnNodes(node);
	}
	
	public void addTreeNodeToStepOnNodes(Node node){
	}
	
	/*CloseNodes*/
	protected void addNodeToCloseNodes(Node node){
		closeNodes.add(String.valueOf(node.getId()));
	}
	
	public void addGraphNodeToCloseNodes(Node node){
		addNodeToCloseNodes(node);
	}
	
	public void addTreeNodeToCloseNodes(Node node){
	}
	
	/*ActivateEdges*/
	protected void addEdgeToActivateEdges(String operatorId){
		activateEdges.add(operatorId);
	}
	
	public void addGraphEdgeToActivateEdges(String operatorId){
		addEdgeToActivateEdges(operatorId);
	}
	
	public void addTreeEdgeToActivateEdges(String operatorId){
	}
	
	/*InactivateEdges*/
	protected void addEdgeToInactivateEdges(String operatorId){
		inactivateEdges.add(operatorId);
	}
	
	public void addGraphEdgeToInactivateEdges(String operatorId){
		addEdgeToInactivateEdges(operatorId);
	}
	
	public void addTreeEdgeToInactivateEdges(String operatorId){
	}
	
	public String writeOutputSolution(Class<?> clazz, Node solution, Node treeSolution, List<OperatorInterface> OPERATORS){
		return SolutionHelper.writeOutput(clazz, listForGraph, new ArrayList<>(), Arrays.asList(solution), steps.toString(), OPERATORS);
	}
	
	public String writeOutputNoSolution(Class<?> clazz, List<OperatorInterface> OPERATORS){
		return SolutionHelper.writeOutput(clazz, listForGraph, new ArrayList<>(), Arrays.asList(), steps.toString(), OPERATORS);
	}
}