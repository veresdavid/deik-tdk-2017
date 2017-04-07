package exceptions;

public class StateInitializationException extends Exception{

	public StateInitializationException(){
		this("Could not initialize State class");
	}
	
	public StateInitializationException(String exceptionMessage){
		super(exceptionMessage);
	}
	
	public StateInitializationException(Exception exception){
		super("Could not initialize State class", exception);
	}
	
	public StateInitializationException(String exceptionMessage, Exception exception){
		super(exceptionMessage, exception);
	}
}
