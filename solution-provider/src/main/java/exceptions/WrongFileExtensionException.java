package exceptions;

public class WrongFileExtensionException extends Exception{

	public WrongFileExtensionException(){
		this("Wrong file extension.");
	}
	
	public WrongFileExtensionException(String exceptionMessage){
		super(exceptionMessage);
	}
}
