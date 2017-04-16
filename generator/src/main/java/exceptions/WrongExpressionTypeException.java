package exceptions;

import com.sun.javafx.binding.StringFormatter;
import enums.ExpressionType;

public class WrongExpressionTypeException extends RuntimeException {

  private static final String BASE_ERROR_MESSAGE = "Expression type %s not allowed here!";

  private final int line;

  private final int charPositionInLine;

  private final ExpressionType expressionType;

  public WrongExpressionTypeException(int line, int charPositionInLine, ExpressionType expressionType) {
    this.line = line;
    this.charPositionInLine = charPositionInLine;
    this.expressionType = expressionType;
  }

  @Override
  public String getMessage() {
    return line + " : " + charPositionInLine + " " + StringFormatter.format(BASE_ERROR_MESSAGE, expressionType).getValue();
  }
}
