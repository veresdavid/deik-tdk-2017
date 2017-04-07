package exceptions;

import com.sun.javafx.binding.StringFormatter;
import enums.ExpressionType;

public class WrongExpressionTypeException extends RuntimeException {

  private final int line;

  private final int charPositionInLine;

  private final ExpressionType expressionType;

  private final String msg = "Expression type %s not allowed here!";

  public WrongExpressionTypeException(int line, int charPositionInLine, ExpressionType expressionType) {
    this.line = line;
    this.charPositionInLine = charPositionInLine;
    this.expressionType = expressionType;
  }

  public int getLine() {
    return line;
  }

  public int getCharPositionInLine() {
    return charPositionInLine;
  }

  public ExpressionType getExpressionType() {
    return expressionType;
  }

  public String getMsg() {
    return line + " : " + charPositionInLine + " " + StringFormatter.format(msg, expressionType);
  }

}
