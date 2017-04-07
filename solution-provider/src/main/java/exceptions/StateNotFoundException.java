package exceptions;

public class StateNotFoundException extends Exception{

	public StateNotFoundException(){
		this("State not found in given file paths.");
	}
	
	public StateNotFoundException(String exceptionMessage){
		super(exceptionMessage);
	}
}
