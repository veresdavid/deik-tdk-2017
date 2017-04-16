package exceptions;

import com.sun.javafx.binding.StringFormatter;

public class VarNameAlreadyInUseException extends RuntimeException {

  private static final String BASE_ERROR_MESSAGE = "Var name %s already in use";

  private final int line;

  private final int charPositionInLine;

  private final String varName;

  public VarNameAlreadyInUseException(int line, int charPositionInLine, String varName) {
    this.line = line;
    this.charPositionInLine = charPositionInLine;
    this.varName = varName;
  }

  public int getLine() {
    return line;
  }

  public int getCharPositionInLine() {
    return charPositionInLine;
  }

  public String getVarName() {
    return varName;
  }

  @Override
  public String getMessage() {
    return String.format(
        line + " : " + charPositionInLine + " " + StringFormatter.format(BASE_ERROR_MESSAGE, varName).getValue());
  }

}
