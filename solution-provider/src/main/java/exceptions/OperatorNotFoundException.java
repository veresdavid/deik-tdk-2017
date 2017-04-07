package exceptions;

public class OperatorNotFoundException extends Exception{
	
	public OperatorNotFoundException(){
		this("Operator not found in given file paths.");
	}
	
	public OperatorNotFoundException(String exceptionMessage){
		super(exceptionMessage);
	}
}
