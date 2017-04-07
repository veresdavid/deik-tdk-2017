package model;

public class UserInput {

	private String heuristicFunction;
	private boolean doBackTrackSimple;
	private boolean doBackTrackCircle;
	private boolean doBackTrackPathLengthLimitation;
	private boolean doBackTrackOptimal;
	private boolean doBreadthFirst;
	private boolean doDepthFirst;
	private boolean doOptimal;
	private boolean doBestFirst;
	private boolean doA;

	public UserInput(String heuristicFunction, boolean doBackTrackSimple, boolean doBackTrackCircle,
			boolean doBackTrackPathLengthLimitation, boolean doBackTrackOptimal, boolean doBreadthFirst,
			boolean doDepthFirst, boolean doOptimal, boolean doBestFirst, boolean doA) {
		this.heuristicFunction = heuristicFunction;
		this.doBackTrackSimple = doBackTrackSimple;
		this.doBackTrackCircle = doBackTrackCircle;
		this.doBackTrackPathLengthLimitation = doBackTrackPathLengthLimitation;
		this.doBackTrackOptimal = doBackTrackOptimal;
		this.doBreadthFirst = doBreadthFirst;
		this.doDepthFirst = doDepthFirst;
		this.doOptimal = doOptimal;
		this.doBestFirst = doBestFirst;
		this.doA = doA;
	}

	public String getHeuristicFunction() {
		return heuristicFunction;
	}

	public void setHeuristicFunction(String heuristicFunction) {
		this.heuristicFunction = heuristicFunction;
	}

	public boolean isDoBackTrackSimple() {
		return doBackTrackSimple;
	}

	public void setDoBackTrackSimple(boolean doBackTrackSimple) {
		this.doBackTrackSimple = doBackTrackSimple;
	}

	public boolean isDoBackTrackCircle() {
		return doBackTrackCircle;
	}

	public void setDoBackTrackCircle(boolean doBackTrackCircle) {
		this.doBackTrackCircle = doBackTrackCircle;
	}

	public boolean isDoBackTrackPathLengthLimitation() {
		return doBackTrackPathLengthLimitation;
	}

	public void setDoBackTrackPathLengthLimitation(boolean doBackTrackPathLengthLimitation) {
		this.doBackTrackPathLengthLimitation = doBackTrackPathLengthLimitation;
	}

	public boolean isDoBackTrackOptimal() {
		return doBackTrackOptimal;
	}

	public void setDoBackTrackOptimal(boolean doBackTrackOptimal) {
		this.doBackTrackOptimal = doBackTrackOptimal;
	}

	public boolean isDoBreadthFirst() {
		return doBreadthFirst;
	}

	public void setDoBreadthFirst(boolean doBreadthFirst) {
		this.doBreadthFirst = doBreadthFirst;
	}

	public boolean isDoDepthFirst() {
		return doDepthFirst;
	}

	public void setDoDepthFirst(boolean doDepthFirst) {
		this.doDepthFirst = doDepthFirst;
	}

	public boolean isDoOptimal() {
		return doOptimal;
	}

	public void setDoOptimal(boolean doOptimal) {
		this.doOptimal = doOptimal;
	}

	public boolean isDoBestFirst() {
		return doBestFirst;
	}

	public void setDoBestFirst(boolean doBestFirst) {
		this.doBestFirst = doBestFirst;
	}

	public boolean isDoA() {
		return doA;
	}

	public void setDoA(boolean doA) {
		this.doA = doA;
	}
}
