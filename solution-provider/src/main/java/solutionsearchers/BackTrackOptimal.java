package solutionsearchers;

import java.util.ArrayList;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackOptimalNode;
import solutionsearchers.helpers.SolutionHelper;

public class BackTrackOptimal extends SolutionSearcher {
	
	/**
	 * A állapottér gráf aktuálisan feltárt csomópontja.
	 * /
	 * The actually revealed node of the state space graph.
	 */
	private BackTrackOptimalNode actual;
	
	/**
	 * A fává alakított állapottér gráf aktuálisan feltárt csomópontja. Saját kereső esetén nem kötelező, 
	 * csak ha faként is szeretnéd látni a feltárt gráfot.
	 * /
	 * The acutally revealed node of tree formed state space graph.
	 */
	private BackTrackOptimalNode treeActual;
	
	/**
	 * A keresendő megoldás maximális mélységét szabályozó változó.
	 * /
	 * The depth limit of the searched solution.
	 */
	private int pathLengthLimitation;
	
	/**
	 * Az állapottér gráfból eddig feltárt csomópontok közül az utoljára feltárt csomópont id-je.
	 * /
	 * The id of the last newly revealed node in the state space graph.
	 */
	private int maxId;
	
	/**
	 * A fává alakított állapottér gráfból eddig feltárt csomópontok közül az utoljára feltárt csomópont.
	 * /
	 * The id of the last revealed node in the tree formed state space graph.
	 */
	private int treeId;
	
	/**
	 * A kereső konstruktora.
	 * /
	 * The constructor of the solution searcher.
	 * @param state A komponens inputjaként kapott állapottérreprezentáció kezdeti állapotának kinyeréséhez szükséges állapot példány
	 * /
	 * An instance of the state representation that the component gets as input
	 * @param pathLengthLimitation A keresett megoldás maximális mélysége
	 * /
	 * The depth limit of the searched solution
	 */
	public BackTrackOptimal(StateInterface state, int pathLengthLimitation){
		// A kezdő csomópont létrehozása.
		// The creation of the first node.
		actual = new BackTrackOptimalNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
		// Az aktuális csomópontra léptünk ezért módosítjuk a rálépések számát 1-re. Ezt azért tároljuk,
		// mert a komponens kimenetében azt is jelzi, hogy egy csomópont még aktiv vagy inaktívvá vált,
		// ami visszalépéses keresőnél előfordulhat, hogy ugyan visszalépés történt egy csomópontról, 
		// de korábban többször is ráléptünk, szóval aktív marad.
		// The solution searcher stepped on the actual node, so we modify the step on counter to 1.
		// We store this number to be able to keep track that a node is still in the travelled path to the actual
		// node that we are stepping on right now. If it is still in the path, it stays activeted, else its inactivated.
		actual.setNumOfNodeStepOns(1);
		// A fa csomópontjainak id-ja negatív a jó megkülönböztethetőség és a könnyű feldolgozás érdekében. 
		// A pozitívak a gráf csomópontjaihoz tartoznak.
		// The id of the tree node is a negative number, to be easy to separate a tree node from a graph node.
		treeId = -1;
		// A fává alakított állapottér gráf kezdő csomópontjának feltárása.
		// The reveal of the first node of the tree formed state space graph.
		treeActual = new BackTrackOptimalNode(actual.getState(), (BackTrackOptimalNode) actual.getParent(), actual.getOperator(), treeId, actual.getTried(), actual.getDepth());
		treeId--;
		this.pathLengthLimitation = pathLengthLimitation;
		// A kimenethez szükséges adatok megadása az információ gyűjtőnek, ez esetben a gráfon és a fán is aktívvá
		// vált egy csomópont, majd rájuk is lépett a kereső. Az, hogy aktívvá vált egy csomópont ennek a keresőnek
		// az esetén nem fog látványos kimenetet adni a vizualizálás esetén, a keresőfával keresők esetén azonban
		// nagyon hasznos.
		// The data given to the information collector, this time a node got activated on the graph and the tree too
		// and the solution searcher stepped on them.
		informationCollector.addGraphNodeToActivateNodes(actual);
		informationCollector.addTreeNodeToActivateNodes(treeActual);
		informationCollector.addGraphNodeToStepOnNodes(actual);
		informationCollector.addTreeNodeToStepOnNodes(treeActual);
		informationCollector.appendSteps();
		maxId = actual.getId();
	}
	
	/**
	 * A keresést végrehajtó függvény.
	 * /
	 * The function that does the solution searching.
	 */
	@Override
	public void search(){
		while(true){	
			if(actual == null){
				break;
			}
			
			// A kimenethez hozzáadjuk az újonnan feltárt tagját az állapottér gráfnak.
			// We insert the newly revealed node to the output.
			if(!informationCollector.getListForGraph().contains(actual)){
				informationCollector.getListForGraph().add(actual);
			}
			
			// Az információgyűjtőben tároljuk az egyes állapotokra lépés számát, hogy a már fentebb tárgyalt
			// csomópont aktívvá illetve inaktívvá állítása a kimenetben megfelelően működhessen.
			// We store the number of steps on a node, to make it easy to know when a node stays active or becomes inactivated.
			if(!informationCollector.getStepsOnStates().containsKey(actual.getState())){
				informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns());
			}
			
			// A kimenethez hozzáadjuk az újonnan feltárt tagját a fává alakított állapottér gráfnak.
			// Insert to the collector the newly revealed node of the tree.
			if(!informationCollector.getListForTree().contains(treeActual)){
				informationCollector.getListForTree().add(treeActual);
			}
			
			if(actual.getOperator() != null){
				// A gráfban az éleket külön objektumként kezeljük, hasonló tulajdonságokkal, mint egy csomópont
				// az inaktivitás és aktivitás terén.
				// In the graph the edges are objects too with similar attributes as a node, becomes active or inactive.
				String edgeId = getEdgeId(actual);
				if(!informationCollector.getStepsOnEdges().containsKey(edgeId)){
					informationCollector.getStepsOnEdges().put(edgeId, actual.getNumOfEdgeStepOns());
				}
			}

			// Ellenőrzés, hogy célállapotba jutottunk-e.
			// Check if the actual node is goal or not.
			if(actual.getState().isGoal()){
				solution = actual;
				treeSolution = treeActual;
				pathLengthLimitation = actual.getDepth();
			}
			
			// Ha elértük a korlátot mélységben, visszalépés fog következni, itt látható a kimenetre milyen adatok
			// kerülnek ki ebben az esetben.
			// If the solution searcher reached the depth limit, it has to step back. In this case these informations
			// have to be collected for the output.
			if(actual.getDepth() == pathLengthLimitation){
				String edgeId = getEdgeId(actual);
				if(actual.getNumOfEdgeStepOns() == 1){
					informationCollector.addGraphEdgeToInactivateEdges(edgeId);
				}
				informationCollector.addTreeEdgeToInactivateEdges(getEdgeId(treeActual));
				informationCollector.getStepsOnEdges().put(edgeId, actual.getNumOfEdgeStepOns() - 1);

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
				// Minden továbblépés és visszalépés egy lépésnek számít, hogy a feldolgozott kimeneten ez jól
				// látszon le kell futtatni ezt a függvényt.
				// If a solution searcher makes a step, you habe to call this function.
				informationCollector.appendSteps();
			}
			
			boolean wasOperatorUsed = false;
			
			// Egy eddig még a csomóponton nem használt operátort kiválasztva továbblépünk az állapottér gráfban.
			// The solution searcher tries to use an operator to make a step.
			for (OperatorInterface operator : operators) {

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
			
			// Ha már minden lehetséges operátort használtunk egy csomópontra, akkor visszalépés következik.
			// If there was not appliable operator, the solution searcher steps back.
			if (!wasOperatorUsed) {
				if(actual.getParent() != null){
					String edgeId = getEdgeId(actual);
					if(actual.getNumOfEdgeStepOns() == 1){
						informationCollector.addGraphEdgeToInactivateEdges(edgeId);
					}
					informationCollector.addTreeEdgeToInactivateEdges(getEdgeId(treeActual));
					informationCollector.getStepsOnEdges().put(edgeId, actual.getNumOfEdgeStepOns() - 1);
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
				}
			} 
			// Ha sikerült továbblépnünk az állapottér gráfban vizsgálnunk kell, hogy egy új csomópontot sikerült-e
			// feltárnunk vagy egy korábban feltártra léptünk ismét és ennek megfelelően kell a kimenethez szükséges
			// információkat eltárolnunk.
			// If the solution searcher could make a step forward, we have to check if it is a newly revealed node or not
			// and we collect the data the way it is needed.
			else {
				String edgeId = getEdgeId(actual);
				if(informationCollector.getStepsOnEdges().containsKey(edgeId)){
					actual.setNumOfEdgeStepOns(informationCollector.getStepsOnEdges().get(edgeId) + 1);
					informationCollector.getStepsOnEdges().put(edgeId, actual.getNumOfEdgeStepOns());
				}
				
				if(informationCollector.getStepsOnStates().containsKey(actual.getState())){
					actual.setNumOfNodeStepOns(informationCollector.getStepsOnStates().get(actual.getState()) + 1);
					informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns());
				}
				
				informationCollector.addGraphEdgeToActivateEdges(edgeId);
				informationCollector.addTreeEdgeToActivateEdges(getEdgeId(treeActual));
				informationCollector.addGraphNodeToActivateNodes(actual);
				informationCollector.addTreeNodeToActivateNodes(treeActual);
				informationCollector.addGraphNodeToStepOnNodes(actual);
				informationCollector.addTreeNodeToStepOnNodes(treeActual);
				informationCollector.addGraphNodeToCloseNodes(actual.getParent());
				informationCollector.addTreeNodeToCloseNodes(treeActual.getParent());
			}
			// Minden továbblépés és visszalépés egy lépésnek számít, hogy a feldolgozott kimeneten ez jól
			// látszon le kell futtatni ezt a függvényt.
			// If a solution searcher makes a step, you habe to call this function.
			informationCollector.appendSteps();
		}
	}
}
