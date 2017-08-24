package solutionsearchers;

import java.util.List;

import interfaces.OperatorInterface;
import nodes.Node;
import solutionsearchers.helpers.InformationCollector;

public class SolutionSearcher {
	
	protected InformationCollector informationCollector;
	protected List<OperatorInterface> operators;
	protected Node solution;
	protected Node treeSolution;
	
	protected SolutionSearcher( ) {
		informationCollector = new InformationCollector();
	}
	
	public InformationCollector getInformationCollector() {
		return informationCollector;
	}

	public void setInformationCollector(InformationCollector informationCollector) {
		this.informationCollector = informationCollector;
	}

	public List<OperatorInterface> getOperators() {
		return operators;
	}

	public void setOperators(List<OperatorInterface> operators) {
		this.operators = operators;
	}
	
	public void search() throws Exception{
		// exception kellesz
		System.out.println("Search not implemented");
	}
	
	public String searchFinished() {
		return informationCollector.writeOutputSolution(getClass(), solution, treeSolution, operators);
	}
	
	protected String getEdgeId(Node actual) {
		return actual.getParent().getId() + "-OP" + operators.indexOf(actual.getOperator()) + "-" + actual.getId();
	}
}
