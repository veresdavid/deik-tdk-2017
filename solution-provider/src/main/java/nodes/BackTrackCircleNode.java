package nodes;

import java.util.List;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class BackTrackCircleNode extends Node{
	
	private List<OperatorInterface> tried;

	public BackTrackCircleNode(StateInterface state, BackTrackCircleNode parent, OperatorInterface operator, int id, List<OperatorInterface> tried) {
		setState(state);
		setParent(parent);
		setOperator(operator);
		setId(id);
		this.tried = tried;
	}
	
	public List<OperatorInterface> getTried() {
		return tried;
	}

	public void setTried(List<OperatorInterface> tried) {
		this.tried = tried;
	}

}
