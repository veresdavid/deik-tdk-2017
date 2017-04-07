package exceptions;

public class CompilationException extends Exception{

	public CompilationException(){
		this("Could not compile the file");
	}
	
	public CompilationException(String exceptionMessage){
		super(exceptionMessage);
	}
	
}
