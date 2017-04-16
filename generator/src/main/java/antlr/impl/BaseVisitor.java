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
import representation.operator.ParameterRepresentation;
import representation.state.AttributeRepresentation;
import representation.state.StateRepresentation;
import utils.GeneratorUtil;
import utils.InputProcessUtil;
import utils.InputValidatorUtil;
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
    stateRepresentation.setName("State");
    return super.visitExpr(ctx);
  }

  @Override
  public Object visitState_description(State_descriptionContext ctx) {
    for (State_description_lineContext currentLine : ctx.state_description_line()) {
      String attrName = currentLine.attr_name().getText();

      InputValidatorUtil.ensureAttributeNameIsCorrect(currentLine, stateRepresentation.getAttributes());

      VarType varType = TypeUtil.getVarType(currentLine.attr_type());
      VarStruct varStruct = TypeUtil.getVarStruct(currentLine.attr_struct());
      Dimension dimension;
      AttributeRepresentation attribute;

      switch (varStruct) {
        case MATRIX:
          dimension = InputProcessUtil
              .getDimensionFromContext(currentLine.attr_struct().dimension(), expressionVisitor);
          attribute = new AttributeRepresentation(attrName, varStruct, varType, dimension);
          stateRepresentation.addAttribute(attribute);
          break;

        case SIMPLE:
        case SET:
          attribute = new AttributeRepresentation(attrName, varStruct, varType);
          stateRepresentation.addAttribute(attribute);
          break;
      }
    }
    return super.visitState_description(ctx);
  }

  @Override
  public Object visitState_start(State_startContext ctx) {
    List<Expression> stateStartExpressions = new ArrayList<>();

    for (ExpressionContext expressionContext : ctx.expression()) {
      List<String> varNames = InputProcessUtil.getVarNames(stateStartExpressions);
      InputValidatorUtil.ensureVarNameIsAvailable(varNames, expressionContext, expressionVisitor);
      stateStartExpressions.add(expressionVisitor.visit(expressionContext));
    }

    stateRepresentation.setStartExpressions(stateStartExpressions);

    return super.visitState_start(ctx);
  }

  @Override
  public Object visitState_goal(State_goalContext ctx) {
    List<Expression> stateGoalExpressions = new ArrayList<>();

    for (ExpressionContext expressionContext : ctx.expression()) {
      List<String> varNames = InputProcessUtil.getVarNames(stateGoalExpressions);
      InputValidatorUtil.ensureVarNameIsAvailable(varNames, expressionContext, expressionVisitor);
      stateGoalExpressions.add(expressionVisitor.visit(expressionContext));
    }

    stateRepresentation.setGoalExpressions(stateGoalExpressions);
    return super.visitState_goal(ctx);
  }

  @Override
  public Object visitOperator_description(Operator_descriptionContext ctx) {
    operatorRepresentation.setName("Operator" + (operatorRepresentations.size() + 1));

    Double operatorCost = ctx.operator_cost() == null ? 1d : Double.parseDouble(ctx.operator_cost().number().getText());
    operatorRepresentation.setCost(operatorCost);

    List<ParameterRepresentation> parameters = new ArrayList<>();

    for (Parameter_description_lineContext currentLine : ctx.parameter_description_line()) {
      InputValidatorUtil.ensureParameterIsAvailable(parameters, currentLine, expressionVisitor);
      parameters.add(GeneratorUtil.getParameterRepresentationFromContext(currentLine));
    }

    operatorRepresentation.setParameters(parameters);

    return super.visitOperator_description(ctx);
  }

  @Override
  public Object visitOperator_precondition(Operator_preconditionContext ctx) {
    List<String> parameterNames = new ArrayList<>();
    operatorRepresentation.getParameters().forEach(parameter -> parameterNames.add(parameter.getParameterName()));

    List<Expression> operatorPreconditionExpressions = new ArrayList<>();

    for (ExpressionContext currentExpression : ctx.expression()) {
      List<String> varNames = InputProcessUtil.getVarNames(operatorPreconditionExpressions);
      List<String> allNames = new ArrayList<>();
      allNames.addAll(parameterNames);
      allNames.addAll(varNames);

      InputValidatorUtil.ensureVarNameIsAvailable(allNames, currentExpression, expressionVisitor);
      operatorPreconditionExpressions.add(expressionVisitor.visit(currentExpression));
    }

    operatorRepresentation.setPreconditionExpressions(operatorPreconditionExpressions);
    return super.visitOperator_precondition(ctx);
  }

  @Override
  public Object visitOperator_effect(Operator_effectContext ctx) {
    List<String> parameterNames = new ArrayList<>();
    operatorRepresentation.getParameters().forEach(parameter -> parameterNames.add(parameter.getParameterName()));

    List<Expression> operatorEffectExpressions = new ArrayList<>();

    for (ExpressionContext currentExpression : ctx.expression()) {
      List<String> varNames = InputProcessUtil.getVarNames(operatorEffectExpressions);
      List<String> allNames = new ArrayList<>();
      allNames.addAll(parameterNames);
      allNames.addAll(varNames);

      InputValidatorUtil.ensureVarNameIsAvailable(allNames, currentExpression, expressionVisitor);
      operatorEffectExpressions.add(expressionVisitor.visit(currentExpression));
    }

    operatorRepresentation.setEffectExpressions(operatorEffectExpressions);
    operatorRepresentations.add(operatorRepresentation);
    operatorRepresentation = new OperatorRepresentation();

    return super.visitOperator_effect(ctx);
  }

  public void clear() {
    stateRepresentation = new StateRepresentation();
    operatorRepresentation = new OperatorRepresentation();
    operatorRepresentations = new ArrayList<>();
  }
}