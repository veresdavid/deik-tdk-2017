package exceptions;

public class TemporaryFolderDeletionException extends Exception{
	
	public TemporaryFolderDeletionException(){
		this("Could not delete folder.");
	}
	
	public TemporaryFolderDeletionException(String exceptionMessage){
		super(exceptionMessage);
	}
}
