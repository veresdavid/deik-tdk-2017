package exceptions;

public class TypeMismatchException extends Exception{

	public TypeMismatchException(){
		this("The type of the object is not what is required.");
	}
	
	public TypeMismatchException(String exceptionMessage){
		super(exceptionMessage);
	}
}
