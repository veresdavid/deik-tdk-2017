package solutionsearchers;

import java.util.List;

import interfaces.OperatorInterface;
import solutionsearchers.helpers.InformationCollector;

public class SolutionSearcher {
	
	protected InformationCollector informationCollector;
	protected List<OperatorInterface> operators;
	
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
}
