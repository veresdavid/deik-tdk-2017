package exceptions;

public class OperatorInitializationException extends Exception{

	public OperatorInitializationException(){
		this("Could not initialize Operator class");
	}
	
	public OperatorInitializationException(String exceptionMessage){
		super(exceptionMessage);
	}
	
	public OperatorInitializationException(Exception exception){
		super("Could not initialize Operator class", exception);
	}
	
	public OperatorInitializationException(String exceptionMessage, Exception exception){
		super(exceptionMessage, exception);
	}
}
