package exceptions;

public class UnexpectedContextException extends RuntimeException {

  private static final String BASE_ERROR_MESSAGE = "Unexpected context: ";

  public UnexpectedContextException(String cause) {
    super(BASE_ERROR_MESSAGE + cause);
  }
}
