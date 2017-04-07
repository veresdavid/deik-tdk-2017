package nodes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class DepthFirstNode extends Node{
	
	private int depth;
	
	public DepthFirstNode(StateInterface state, DepthFirstNode parent, OperatorInterface operator, int id, int depth){
		setState(state);
		setParent(parent);
		setOperator(operator);
		setId(id);
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
