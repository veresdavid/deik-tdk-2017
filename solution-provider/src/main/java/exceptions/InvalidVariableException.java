package exceptions;

public class InvalidVariableException extends Exception{
	
	public InvalidVariableException(){
		this("Invalid variable name.");
	}
	
	public InvalidVariableException(String exceptionMessage){
		super(exceptionMessage);
	}
}
