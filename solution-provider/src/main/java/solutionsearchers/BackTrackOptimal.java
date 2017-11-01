package solutionsearchers;

import java.util.ArrayList;

import interfaces.OperatorInterface;
import interfaces.StateInterface;
import nodes.BackTrackOptimalNode;
import solutionsearchers.helpers.SolutionHelper;

public class BackTrackOptimal extends SolutionSearcher {
	
	/**
	 * A állapottérgráf aktuálisan feltárt csomópontja.
	 */
	private BackTrackOptimalNode actual;
	
	/**
	 * A fává alakított állapottérgráf aktuálisan feltárt csomópontja. Saját kereső esetén nem kötelező, 
	 * csak ha faként is szeretnéd látni a feltárt gráfot.
	 */
	private BackTrackOptimalNode treeActual;
	
	/**
	 * A keresendő megoldás maximális mélységét szabályozó változó.
	 */
	private int pathLengthLimitation;
	
	/**
	 * Az állapottérgráfból eddig feltárt csomópontok közül az utoljára feltárt csomópont.
	 */
	private int maxId;
	
	/**
	 * A fává alakított állapottérgráfból eddig feltárt csomópontok közül az utoljára feltárt csomópont.
	 */
	private int treeId;
	
	/**
	 * A kereső konstruktora.
	 * @param state A komponens inputjaként kapott állapottérreprezentáció kezdeti állapotának kinyeréséhez szükséges állapot példány
	 * @param pathLengthLimitation A keresett megoldás maximális mélysége
	 */
	public BackTrackOptimal(StateInterface state, int pathLengthLimitation){
		// A kezdő csomópont létrehozása.
		actual = new BackTrackOptimalNode(state.getStart(), null, null, 0, new ArrayList<>(), 0);
		// Az aktuális csomópontra léptünk ezért módosítjuk a rálépések számát 1-re. Ezt azért tároljuk,
		// mert a komponens kimenetében azt is jelzi, hogy egy csomópont még aktiv vagy inaktívvá vált,
		// ami visszalépéses keresőnél előfordulhat, hogy ugyan visszalépés történt egy csomópontról, 
		// de korábban többször is ráléptünk, szóval aktív marad.
		actual.setNumOfNodeStepOns(1);
		// A fa csomópontjainak id-ja negatív a jó megkülönböztethetőség és a könnyű feldolgozás érdekében. 
		// A pozitívak a gráf csomópontjaihoz tartoznak.
		treeId = -1;
		// A fává alakított állapottérgráf kezdő csomópontjának feltárása.
		treeActual = new BackTrackOptimalNode(actual.getState(), (BackTrackOptimalNode) actual.getParent(), actual.getOperator(), treeId, actual.getTried(), actual.getDepth());
		treeId--;
		this.pathLengthLimitation = pathLengthLimitation;
		// A kimenethez szükséges adatok megadása az információ gyűjtőnek, ez esetben a gráfon és a fán is aktívvá
		// vált egy csomópont, majd rájuk is lépett a kereső. Az, hogy aktívvá vált egy csomópont ennek a keresőnek
		// az esetén nem fog látványos kimenetet adni a vizualizálás esetén, a keresőfával keresők esetén azonban
		// nagyon hasznos.
		informationCollector.addGraphNodeToActivateNodes(actual);
		informationCollector.addTreeNodeToActivateNodes(treeActual);
		informationCollector.addGraphNodeToStepOnNodes(actual);
		informationCollector.addTreeNodeToStepOnNodes(treeActual);
		informationCollector.appendSteps();
		maxId = actual.getId();
	}
	
	/**
	 * A keresést végrehajtó függvény.
	 */
	@Override
	public void search(){
		while(true){	
			if(actual == null){
				break;
			}
			
			// A kimenethez hozzáadjuk az újonnan feltárt tagját az állapottérgráfnak.
			if(!informationCollector.getListForGraph().contains(actual)){
				informationCollector.getListForGraph().add(actual);
			}
			
			// Az információgyűjtőben tároljuk az egyes állapotokra lépés számát, hogy a már fentebb tárgyalt
			// csomópont aktívvá illetve inaktívvá állítása a kimenetben megfelelően működhessen.
			if(!informationCollector.getStepsOnStates().containsKey(actual.getState())){
				informationCollector.getStepsOnStates().put(actual.getState(), actual.getNumOfNodeStepOns());
			}
			
			// A kimenethez hozzáadjuk az újonnan feltárt tagját a fává alakított állapottérgráfnak.
			if(!informationCollector.getListForTree().contains(treeActual)){
				informationCollector.getListForTree().add(treeActual);
			}
			
			if(actual.getOperator() != null){
				// A gráfban az éleket külön objektumként kezeljük, hasonló tulajdonságokkal, mint egy csomópont
				// az inaktivitás és aktivitás terén.
				String edgeId = getEdgeId(actual);
				if(!informationCollector.getStepsOnEdges().containsKey(edgeId)){
					informationCollector.getStepsOnEdges().put(edgeId, actual.getNumOfEdgeStepOns());
				}
			}

			// Ellenőrzés, hogy célállapotba jutottunk-e.
			if(actual.getState().isGoal()){
				solution = actual;
				treeSolution = treeActual;
				pathLengthLimitation = actual.getDepth();
			}
			
			// Ha elértük a korlátot mélységben, visszalépés fog következni, itt látható a kimenetre milyen adatok
			// kerülnek ki ebben az esetben.
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
				informationCollector.appendSteps();
			}
			
			boolean wasOperatorUsed = false;
			
			// Egy eddig még a csomóponton nem használt operátort kiválasztva továbblépünk az állapottérgráfban.
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
			// Ha sikerült továbblépnünk az állapottérgráfban vizsgálnunk kell, hogy egy új csomópontot sikerült-e
			// feltárnunk vagy egy korábban feltártra léptünk ismét és ennek megfelelően kell a kimenethez szükséges
			// információkat eltárolnunk.
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
			informationCollector.appendSteps();
		}
	}
}
