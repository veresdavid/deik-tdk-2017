package exceptions;


public class InvalidAttributeName extends RuntimeException {

  private static final String BASE_ERROR_MESSAGE = "Incorrect attribute name: ";

  private final int line;

  private final int charPositionInLine;

  private final String attributeName;

  public InvalidAttributeName(int line, int charPositionInLine, String attributeName) {
    this.line = line;
    this.charPositionInLine = charPositionInLine;
    this.attributeName = attributeName;
  }

  @Override
  public String getMessage() {
    return line + " : " + charPositionInLine + " " + BASE_ERROR_MESSAGE + " " + attributeName;
  }
}
