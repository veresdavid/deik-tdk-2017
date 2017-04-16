package model;

import java.util.Set;

public class UserInput {

	private String heuristicFunction;
	private Set<String> variablesInHeuristicFunction;
	private boolean doBackTrackSimple;
	private boolean doBackTrackCircle;
	private boolean doBackTrackPathLengthLimitation;
	private boolean doBackTrackOptimal;
	private boolean doBreadthFirst;
	private boolean doDepthFirst;
	private boolean doOptimal;
	private boolean doBestFirst;
	private boolean doA;
	private boolean doTree;
	private int backTrackPathLengthLimitationLimit;
	private int backTrackOptimalLimit;

	public UserInput(String heuristicFunction, Set<String> variablesInHeuristicFunction, boolean doBackTrackSimple,
			boolean doBackTrackCircle, boolean doBackTrackPathLengthLimitation, boolean doBackTrackOptimal,
			boolean doBreadthFirst, boolean doDepthFirst, boolean doOptimal, boolean doBestFirst, boolean doA,
			boolean doTree, int backTrackPathLengthLimitationLimit, int backTrackOptimalLimit) {
		this.heuristicFunction = heuristicFunction;
		this.variablesInHeuristicFunction = variablesInHeuristicFunction;
		this.doBackTrackSimple = doBackTrackSimple;
		this.doBackTrackCircle = doBackTrackCircle;
		this.doBackTrackPathLengthLimitation = doBackTrackPathLengthLimitation;
		this.doBackTrackOptimal = doBackTrackOptimal;
		this.doBreadthFirst = doBreadthFirst;
		this.doDepthFirst = doDepthFirst;
		this.doOptimal = doOptimal;
		this.doBestFirst = doBestFirst;
		this.doA = doA;
		this.doTree = doTree;
		this.backTrackPathLengthLimitationLimit = backTrackPathLengthLimitationLimit;
		this.backTrackOptimalLimit = backTrackOptimalLimit;
	}

	public String getHeuristicFunction() {
		return heuristicFunction;
	}

	public void setHeuristicFunction(String heuristicFunction) {
		this.heuristicFunction = heuristicFunction;
	}

	public Set<String> getVariablesInHeuristicFunction() {
		return variablesInHeuristicFunction;
	}

	public void setVariablesInHeuristicFunction(Set<String> variablesInHeuristicFunction) {
		this.variablesInHeuristicFunction = variablesInHeuristicFunction;
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

	public boolean isDoTree() {
		return doTree;
	}

	public void setDoTree(boolean doTree) {
		this.doTree = doTree;
	}

	public int getBackTrackPathLengthLimitationLimit() {
		return backTrackPathLengthLimitationLimit;
	}

	public void setBackTrackPathLengthLimitationLimit(int backTrackPathLengthLimitationLimit) {
		this.backTrackPathLengthLimitationLimit = backTrackPathLengthLimitationLimit;
	}

	public int getBackTrackOptimalLimit() {
		return backTrackOptimalLimit;
	}

	public void setBackTrackOptimalLimit(int backTrackOptimalLimit) {
		this.backTrackOptimalLimit = backTrackOptimalLimit;
	}
}
