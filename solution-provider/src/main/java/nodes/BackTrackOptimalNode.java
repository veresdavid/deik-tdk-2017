package nodes;

import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class BackTrackOptimalNode extends Node{
	
	/**
	 * A csomópontra már alkalmazott operátorok listája.
	 */
	private List<OperatorInterface> tried;
	
	/**
	 * A csomópont mélységét jelző mező.
	 */
	private int depth;

	/**
	 * A csomópont konstruktora.
	 * @param state A csomópont állapotát tároló változó
	 * @param parent A csomópont szülőcsomópontja
	 * @param operator A csomópontot a szülőcsomópontból létrehozó operátor
	 * @param id A csomópont id-je, amely a kimenet létrehozásakor szükséges, hogy egyszerűen megkülönböztethetők legyenek a különböző csomópontok
	 * @param tried A csomópontra már alkalmazott operátorok listája
	 * @param depth A csomópont mélységét adja meg
	 */
	public BackTrackOptimalNode(StateInterface state, BackTrackOptimalNode parent, OperatorInterface operator, int id, List<OperatorInterface> tried, int depth) {
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.id = id;
		this.tried = tried;
		this.depth = depth;
	}
	
	public List<OperatorInterface> getTried() {
		return tried;
	}

	public void setTried(List<OperatorInterface> tried) {
		this.tried = tried;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
