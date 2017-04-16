package exceptions;

import com.sun.javafx.binding.StringFormatter;

public class WrongNumberOfArgumentsException extends RuntimeException {

  private static final String BASE_ERROR_MESSAGE = "Method %s can not be called with %d arguments!";

  private final int line;

  private final int charPositionInLine;

  private final int numberOfArguments;

  private final String methodName;

  public WrongNumberOfArgumentsException(int line, int charPositionInLine, int numberOfArguments,
      String methodName) {
    this.line = line;
    this.charPositionInLine = charPositionInLine;
    this.numberOfArguments = numberOfArguments;
    this.methodName = methodName;
  }

  @Override
  public String getMessage() {
    return line + " : " + charPositionInLine + " " + StringFormatter
        .format(BASE_ERROR_MESSAGE, methodName, numberOfArguments).getValue();
  }
}
