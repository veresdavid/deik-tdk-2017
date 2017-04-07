package utils;

import antlr.SMLParser.Assign_exprContext;
import antlr.SMLParser.Attr_structContext;
import antlr.SMLParser.Attr_typeContext;
import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.For_exprContext;
import antlr.SMLParser.ReferenceContext;
import antlr.SMLVisitor;
import enums.ExpressionType;
import enums.ReferenceType;
import enums.VarStruct;
import enums.VarType;
import exceptions.WrongExpressionTypeException;
import interfaces.Expression;


//TODO handle all error
public final class TypeUtil {

  private TypeUtil() {

  }

  public static VarStruct getVarStruct(Attr_structContext attributeContext) {
    if (isSetAttribute(attributeContext)) {
      return VarStruct.SET;
    } else if (isMatrixAttribute(attributeContext)) {
      return VarStruct.MATRIX;
    } else {
      throw new RuntimeException("Unexpected state description line context :" + attributeContext);
    }
  }

  public static VarType getVarType(Attr_typeContext attributeContext) {
    if (isNumberAttribute(attributeContext)) {
      return VarType.NUMBER;
    } else if (isWordAttribute(attributeContext)) {
      return VarType.WORD;
    } else {
      throw new RuntimeException("Unexpected state description line context :" + attributeContext);
    }
  }


  public static ExpressionType getExpressionType(ExpressionContext expressionContext) {

    if (isSetAssign(expressionContext)) {
      return ExpressionType.SET_ASSIGN_EXPR;
    } else if (isMatrixAssign(expressionContext)) {
      return ExpressionType.MATRIX_ASSIGN_EXPR;
    } else {
      throw new RuntimeException("Unexpected expression context :" + expressionContext);
    }
  }

  public static ReferenceType getReferenceType(ReferenceContext referenceContext) {
    if (isNormalAttrReference(referenceContext)) {
      return ReferenceType.NORMAL_SET_REFERENCE;
    } else if (isNormalMatrixReference(referenceContext)) {
      return ReferenceType.NORMAL_MATRIX_REFERENCE;
    } else if (isParameterizedAttrReference(referenceContext)) {
      return ReferenceType.PARAMETERIZED_SET_REFERENCE;
    } else if (isParameterizedMatrixReference(referenceContext)) {
      return ReferenceType.PARAMETERIZED_MATRIX_REFERENCE;
    } else {
      throw new RuntimeException("Unexpected reference context :" + referenceContext);
    }
  }

  public static void ensureExpressionTypeIs(ExpressionContext expressionContext, SMLVisitor<Expression> visitor,
      ExpressionType... expressionTypes) {
    Expression expression = visitor.visit(expressionContext);

    for (ExpressionType expressionType : expressionTypes) {
      if (expression.getExpressionType().equals(expressionType)) {
        return;
      }
    }

    int line = expressionContext.getStart().getLine();
    int charPosition = expressionContext.getStart().getCharPositionInLine();

    throw new WrongExpressionTypeException(line, charPosition, expression.getExpressionType());
  }

  public static void ensureExpressionTypeIsNot(ExpressionContext expressionContext, SMLVisitor<Expression> visitor,
      ExpressionType... expressionTypes) {

    Expression expression = visitor.visit(expressionContext);

    for (ExpressionType expressionType : expressionTypes) {
      if (expression.getExpressionType().equals(expressionType)) {
        int line = expressionContext.getStart().getLine();
        int charPosition = expressionContext.getStart().getCharPositionInLine();

        throw new WrongExpressionTypeException(line, charPosition, expression.getExpressionType());
      }
    }
  }

  private static boolean isSetAttribute(Attr_structContext attributeContext) {
    return attributeContext.KEYWORD_SET() != null
        && attributeContext.KEYWORD_MATRIX() == null;
  }

  private static boolean isMatrixAttribute(Attr_structContext attributeContext) {
    return attributeContext.KEYWORD_MATRIX() != null
        && attributeContext.KEYWORD_SET() == null;

  }

  private static boolean isNumberAttribute(Attr_typeContext attributeContext) {
    return attributeContext.KEYWORD_NUMBER() != null && attributeContext.KEYWORD_WORD() == null;
  }

  private static boolean isWordAttribute(Attr_typeContext attributeContext) {
    return attributeContext.KEYWORD_WORD() != null && attributeContext.KEYWORD_NUMBER() == null;
  }

  private static boolean isAssignExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Assign_exprContext.class);
  }

  private static boolean isSetAssign(ExpressionContext expressionContext) {
    if (isAssignExpr(expressionContext)) {
      Assign_exprContext assign_exprContext = ((Assign_exprContext) expressionContext);
      return assign_exprContext.reference().normal_reference().attr_reference() != null
          && assign_exprContext.reference().normal_reference().matrix_reference() == null;
    } else {
      return false;
    }
  }

  private static boolean isMatrixAssign(ExpressionContext expressionContext) {
    if (isAssignExpr(expressionContext)) {
      Assign_exprContext assign_exprContext = ((Assign_exprContext) expressionContext);
      return assign_exprContext.reference().normal_reference().matrix_reference() != null
          && assign_exprContext.reference().normal_reference().attr_reference() == null;
    } else {
      return false;
    }
  }

  private static boolean isNormalReference(ReferenceContext referenceContext) {
    return referenceContext.normal_reference() != null && referenceContext.parameterized_reference() == null;
  }

  private static boolean isNormalMatrixReference(ReferenceContext referenceContext) {
    return isNormalReference(referenceContext) && referenceContext.normal_reference().matrix_reference() != null
        && referenceContext.normal_reference().attr_reference() == null;
  }

  private static boolean isNormalAttrReference(ReferenceContext referenceContext) {
    return isNormalReference(referenceContext) && referenceContext.normal_reference().attr_reference() != null
        && referenceContext.normal_reference().matrix_reference() == null;
  }

  private static boolean isParameterizedReference(ReferenceContext referenceContext) {
    return referenceContext.parameterized_reference() != null && referenceContext.normal_reference() == null;
  }

  private static boolean isParameterizedMatrixReference(ReferenceContext referenceContext) {
    return isParameterizedReference(referenceContext) &&
        referenceContext.parameterized_reference().parameterized_matrix_reference() != null &&
        referenceContext.parameterized_reference().parameterized_attr_reference() == null;
  }

  private static boolean isParameterizedAttrReference(ReferenceContext referenceContext) {
    return isParameterizedReference(referenceContext) &&
        referenceContext.parameterized_reference().parameterized_attr_reference() != null &&
        referenceContext.parameterized_reference().parameterized_matrix_reference() == null;

  }

  private static boolean isForExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(For_exprContext.class);
  }

}
