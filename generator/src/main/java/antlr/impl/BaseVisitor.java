package antlr.impl;

import antlr.SMLBaseVisitor;
import antlr.SMLParser.ExprContext;
import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.Operator_descriptionContext;
import antlr.SMLParser.Operator_effectContext;
import antlr.SMLParser.Operator_preconditionContext;
import antlr.SMLParser.Parameter_description_lineContext;
import antlr.SMLParser.State_descriptionContext;
import antlr.SMLParser.State_description_lineContext;
import antlr.SMLParser.State_goalContext;
import antlr.SMLParser.State_startContext;
import enums.VarStruct;
import enums.VarType;
import interfaces.Expression;
import java.util.ArrayList;
import java.util.List;
import misc.Dimension;
import representation.operator.OperatorRepresentation;
import representation.state.AttributeRepresentation;
import representation.state.StateRepresentation;
import utils.GeneratorUtil;
import utils.InputProcessUtil;
import utils.TypeUtil;

public class BaseVisitor extends SMLBaseVisitor {

  private StateRepresentation stateRepresentation = new StateRepresentation();
  private OperatorRepresentation operatorRepresentation = new OperatorRepresentation();
  private List<OperatorRepresentation> operatorRepresentations = new ArrayList<>();

  private ExpressionVisitor expressionVisitor = new ExpressionVisitor();

  public StateRepresentation getStateRepresentation() {
    return stateRepresentation;
  }

  public List<OperatorRepresentation> getOperatorRepresentations() {
    return operatorRepresentations;
  }

  @Override
  public Object visitExpr(ExprContext ctx) {
    if (ctx.name_defining_expression() != null) {
      stateRepresentation.setName(ctx.name_defining_expression().PARAM_NAME().getText());
    } else {
      stateRepresentation.setName("State");
    }

    return super.visitExpr(ctx);
  }

  @Override
  public Object visitState_description(State_descriptionContext ctx) {
    for (State_description_lineContext currentLine : ctx.state_description_line()) {
      String varName = currentLine.attr_name().getText();

      // TODO: Handle error!
      if (isAvailableVariable(varName)) {
        VarType varType = TypeUtil.getVarType(currentLine.attr_type());
        VarStruct varStruct = TypeUtil.getVarStruct(currentLine.attr_struct());
        Dimension dimension;
        AttributeRepresentation attribute;

        switch (varStruct) {
          case MATRIX:
            dimension = InputProcessUtil
                .getDimensionFromContext(currentLine.attr_struct().dimension(), expressionVisitor);
            attribute = new AttributeRepresentation(varName, varStruct, varType, dimension);
            stateRepresentation.addAttribute(attribute);
            break;

          case SET:
            attribute = new AttributeRepresentation(varName, varStruct, varType);
            stateRepresentation.addAttribute(attribute);
            break;
        }
      }
    }
    //TODO: Handle error
    return super.visitState_description(ctx);
  }

  @Override
  public Object visitState_start(State_startContext ctx) {

    List<Expression> stateStartExpressions = new ArrayList<>();

    for (ExpressionContext expression : ctx.expression()) {
      stateStartExpressions.add(expressionVisitor.visit(expression));
    }

    stateRepresentation.setStartExpressions(stateStartExpressions);

    return super.visitState_start(ctx);
  }

  @Override
  public Object visitState_goal(State_goalContext ctx) {

    for (ExpressionContext expression : ctx.expression()) {
      stateRepresentation.addGoalExpression(expressionVisitor.visit(expression));
    }

    return super.visitState_goal(ctx);
  }

  @Override
  public Object visitOperator_description(Operator_descriptionContext ctx) {
    if (ctx.name_defining_expression() != null) {
      operatorRepresentation.setName(ctx.name_defining_expression().PARAM_NAME().getText());
    } else {
      operatorRepresentation.setName("Operator" + (operatorRepresentations.size() + 1));
    }

    Double operatorCost = ctx.operator_cost() == null ? 1d : Double.parseDouble(ctx.operator_cost().number().getText());

    operatorRepresentation.setCost(operatorCost);

    for (Parameter_description_lineContext parameter : ctx.parameter_description_line()) {
      operatorRepresentation.addParameter(GeneratorUtil.getParameterRepresentationFromContext(parameter));
    }

    return super.visitOperator_description(ctx);
  }

  @Override
  public Object visitOperator_precondition(Operator_preconditionContext ctx) {
    for (ExpressionContext expression : ctx.expression()) {
      operatorRepresentation.addPreconditionExpression(expressionVisitor.visit(expression));
    }

    return super.visitOperator_precondition(ctx);
  }

  @Override
  public Object visitOperator_effect(Operator_effectContext ctx) {

    for (ExpressionContext expression : ctx.expression()) {
      operatorRepresentation.addOperatorEffect(expressionVisitor.visit(expression));
    }

    operatorRepresentations.add(operatorRepresentation);
    operatorRepresentation = new OperatorRepresentation();

    return super.visitOperator_effect(ctx);
  }

  private boolean isAvailableVariable(String varName) {
    return stateRepresentation.getAttributes().stream()
        .noneMatch(attribute -> attribute.getAttributeName().equals(varName));
  }

  //TODO: Handle error
  //Refactor this
  public AttributeRepresentation getAttributeFromReference(String reference) {
    String attrName = "Attr" + reference.substring(1);

    for (AttributeRepresentation currentAttr : stateRepresentation.getAttributes()) {
      if (currentAttr.getAttributeName().equals(attrName)) {
        return currentAttr;
      }
    }
    return null;
  }

  public void clear() {
    stateRepresentation = new StateRepresentation();
    operatorRepresentation = new OperatorRepresentation();
    operatorRepresentations = new ArrayList<>();
  }
}