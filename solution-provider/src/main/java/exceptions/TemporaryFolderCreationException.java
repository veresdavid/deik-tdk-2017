package exceptions;

public class TemporaryFolderCreationException extends Exception{
	
	public TemporaryFolderCreationException(){
		this("Could not create folder.");
	}
	
	public TemporaryFolderCreationException(String exceptionMessage){
		super(exceptionMessage);
	}
	
	public TemporaryFolderCreationException(Exception exception){
		super(exception);
	}
	
	public TemporaryFolderCreationException(String exceptionMessage, Exception exception){
		super(exceptionMessage, exception);
	}
}
