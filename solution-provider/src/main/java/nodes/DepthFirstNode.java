package nodes;

import interfaces.OperatorInterface;
import interfaces.StateInterface;

public class DepthFirstNode extends Node{
	
	private int depth;
	
	public DepthFirstNode(StateInterface state, DepthFirstNode parent, OperatorInterface operator, int id, int depth){
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.id = id;
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
