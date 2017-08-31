package exceptions;

public class SolutionSearcherNotFoundException extends Exception{

	public SolutionSearcherNotFoundException(){
		this("SolutionSearcher not found between your classes.");
	}
	
	public SolutionSearcherNotFoundException(String exceptionMessage){
		super(exceptionMessage);
	}
}
