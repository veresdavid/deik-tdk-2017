package exceptions;

public class UnexpectedSwitchClauseException extends RuntimeException {

  private static final String BASE_ERROR_MESSAGE = "Unexpected value in switch statement: ";

  public UnexpectedSwitchClauseException(String cause) {
    super(BASE_ERROR_MESSAGE + cause);
  }
}
