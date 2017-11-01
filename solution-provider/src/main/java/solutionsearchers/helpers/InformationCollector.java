package solutionsearchers.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.Node;

/**
 * A komponens kiemenetéért felelős osztály.
 * /
 * This class responsible for the output of the component.
 * @author vecsi
 *
 */
public class InformationCollector {

	/**
	 * A csomópontokra lépések számát tárolja.
	 * /
	 * Counts the steps on nodes.
	 */
	private Map<StateInterface, Integer> stepsOnStates;
	
	/**
	 * Az élekre lépések számát tárolja.
	 * /
	 * Counts the steps on edges
	 */
	private Map<String, Integer> stepsOnEdges;
	
	/**
	 * Az állapottér gráf feltárt csomópontjai.
	 * /
	 * The revealed nodes of the state space graph.
	 */
	protected List<Node> listForGraph;
	
	/**
	 * A fává alakított állapottér gráf feltárt csomópontjai.
	 * /
	 * The revealed nodes of the tree formed state space graph .
	 */
	protected List<Node> listForTree;
	
	/**
	 * A kereső által eddig megtett lépések.
	 * /
	 * The steps of the solution searcher.
	 */
	protected StringBuilder steps;
	
	/**
	 * A kereső adott lépésében aktívvá vált csomópontok listája.
	 * /
	 * The list of the activated nodes in the current step of the solution searcher.
	 */
	private List<String> activateNodes;
	
	/**
	 * A kereső adott lépésében inaktívvá vált csomópontok listája.
	 * /
	 * The list of the inactivated nodes in the current step of the solution searcher.
	 */
	private List<String> inactivateNodes;
	
	/**
	 * A kereső adott lépésében azon csomópontok listája, amelyekre ráléptünk.
	 * /
	 * The list of the nodes that the solution searcher stepped on in the current step.
	 */
	private List<String> stepOnNodes;
	
	/**
	 * A kereső adott lépésében azok csomópontok listája, amiről visszaléptünk és már nincs benne az aktuális
	 * csomóponthoz vezető útban.
	 * /
	 * The list of the nodes that the solution searcher stepped back from in the current step.
	 */
	private List<String> closeNodes;
	
	/**
	 * A kereső adott lépésében aktívvá vált élek listája.
	 * /
	 * The list of the activated edges in the current step of the solution searcher.
	 */
	private List<String> activateEdges;
	
	/**
	 * A kereső adott lépésében inaktívvá vált élek listája.
	 * /
	 * The list of the inactivated edges in the current step of the solution searcher.
	 */
	private List<String> inactivateEdges;
	
	/**
	 * A kimeneti fájl neve.
	 * /
	 * The name of the output file.
	 */
	protected String outputFileName;
	
	/**
	 * A kimeneti fájl mappája.
	 * /
	 * The name of the output folder.
	 */
	protected static String OUTPUTFOLDERNAME = "solutionOutputs";

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
		outputFileName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd-hh-mm-ss")) + UUID.randomUUID().toString() + ".txt";
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

	public void appendSteps() {
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
		SolutionHelper.writeSteps(steps.toString(), OUTPUTFOLDERNAME, outputFileName);
		steps = new StringBuilder();
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
		return SolutionHelper.writeOutput(clazz, listForGraph, new ArrayList<>(), Arrays.asList(solution), OPERATORS, OUTPUTFOLDERNAME, outputFileName);
	}
	
	public String writeOutputNoSolution(Class<?> clazz, List<OperatorInterface> OPERATORS){
		return SolutionHelper.writeOutput(clazz, listForGraph, new ArrayList<>(), Arrays.asList(), OPERATORS, OUTPUTFOLDERNAME, outputFileName);
	}
}