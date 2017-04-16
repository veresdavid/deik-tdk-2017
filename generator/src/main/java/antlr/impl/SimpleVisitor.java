package antlr.impl;

import antlr.SMLBaseVisitor;
import antlr.SMLParser.Boolean_operatorContext;
import antlr.SMLParser.Number_exprContext;
import antlr.SMLParser.Word_exprContext;
import org.antlr.v4.runtime.misc.Interval;

public class SimpleVisitor extends SMLBaseVisitor<String> {

  @Override
  public String visitNumber_expr(Number_exprContext ctx) {
    if (ctx.number().KEYWORD_INF() != null) {
      if (ctx.number().SYMBOL_SUBSTRACT() != null) {
        return "Double.NEGATIVE_INFINITY";
      } else {
        return "Double.POSITIVE_INFINITY";
      }
    } else {
      return ctx.number().getText() + "d";
    }
  }

  @Override
  public String visitWord_expr(Word_exprContext ctx) {
    return ctx.word().getStart().getInputStream()
        .getText(Interval.of(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));
  }

  @Override
  public String visitBoolean_operator(Boolean_operatorContext ctx) {
    if (ctx.KEYWORD_AND() != null && ctx.KEYWORD_OR() == null) {
      return "&&";
    } else {
      return "||";
    }
  }
}
