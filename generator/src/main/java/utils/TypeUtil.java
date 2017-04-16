package utils;

import antlr.SMLParser.Assign_exprContext;
import antlr.SMLParser.Attr_structContext;
import antlr.SMLParser.Attr_typeContext;
import antlr.SMLParser.Binary_exprContext;
import antlr.SMLParser.Bool_exprContext;
import antlr.SMLParser.Compare_exprContext;
import antlr.SMLParser.ExpressionContext;
import antlr.SMLParser.For_exprContext;
import antlr.SMLParser.If_exprContext;
import antlr.SMLParser.Number_exprContext;
import antlr.SMLParser.Param_name_exprContext;
import antlr.SMLParser.ReferenceContext;
import antlr.SMLParser.Reference_exprContext;
import antlr.SMLParser.Set_init_exprContext;
import antlr.SMLParser.Unary_exprContext;
import antlr.SMLParser.Var_defining_expressionContext;
import antlr.SMLParser.Word_exprContext;
import enums.ExpressionType;
import enums.ReferenceType;
import enums.VarStruct;
import enums.VarType;
import exceptions.UnexpectedContextException;

public final class TypeUtil {

  private TypeUtil() {

  }

  public static VarStruct getVarStruct(Attr_structContext attributeContext) {
    if (attributeContext == null) {
      return VarStruct.SIMPLE;
    } else if (isSetAttribute(attributeContext)) {
      return VarStruct.SET;
    } else if (isMatrixAttribute(attributeContext)) {
      return VarStruct.MATRIX;
    } else {
      throw new UnexpectedContextException(attributeContext.getText());
    }
  }

  public static VarType getVarType(Attr_typeContext attributeContext) {
    if (isNumberAttribute(attributeContext)) {
      return VarType.NUMBER;
    } else if (isWordAttribute(attributeContext)) {
      return VarType.WORD;
    } else {
      throw new UnexpectedContextException(attributeContext.getText());
    }
  }

  public static ExpressionType getExpressionType(ExpressionContext expressionContext) {
    if (isNumberExpr(expressionContext)) {
      return ExpressionType.NUMBER;
    } else if (isWordExpr(expressionContext)) {
      return ExpressionType.WORD;
    } else if (isParamNameExpr(expressionContext)) {
      return ExpressionType.PARAM_NAME;
    } else if (isReferenceExpr(expressionContext)) {
      return ExpressionType.REFERENCE;
    } else if (isCompareExpr(expressionContext)) {
      return ExpressionType.COMPARE_EXPR;
    } else if (isBoolExpr(expressionContext)) {
      return ExpressionType.BOOL_EXPR;
    } else if (isBinaryExpr(expressionContext)) {
      return ExpressionType.BINARY_EXPR;
    } else if (isUnaryExpr(expressionContext)) {
      return ExpressionType.UNARY_EXPRESSION;
    } else if (isSetInitExpr(expressionContext)) {
      return ExpressionType.SET_INIT_EXPR;
    } else if (isSetAssign(expressionContext)) {
      return ExpressionType.SET_ASSIGN_EXPR;
    } else if (isMatrixAssign(expressionContext)) {
      return ExpressionType.MATRIX_ASSIGN_EXPR;
    } else if (isParameterizedSetAssign(expressionContext)) {
      return ExpressionType.PARAMETERIZED_SET_ASSIGN;
    } else if (isParameterizedMatrixAssign(expressionContext)) {
      return ExpressionType.PARAMETERIZED_MATRIX_ASSIGN;
    } else if (isForExpr(expressionContext)) {
      return ExpressionType.FOR_EXPR;
    } else if (isIfExpr(expressionContext)) {
      return ExpressionType.IF_EXPR;
    } else if (isVarDefiningExpr(expressionContext)) {
      return ExpressionType.VAR_DEFINING_EXPR;
    } else {
      throw new UnexpectedContextException(expressionContext.getText());
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
      throw new UnexpectedContextException(referenceContext.getText());
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

  private static boolean isParameterizedSetAssign(ExpressionContext expressionContext) {
    if (isAssignExpr(expressionContext)) {
      Assign_exprContext assign_exprContext = ((Assign_exprContext) expressionContext);
      return assign_exprContext.reference().parameterized_reference().parameterized_attr_reference() != null
          && assign_exprContext.reference().parameterized_reference().parameterized_matrix_reference() == null;
    } else {
      return false;
    }
  }

  private static boolean isParameterizedMatrixAssign(ExpressionContext expressionContext) {
    if (isAssignExpr(expressionContext)) {
      Assign_exprContext assign_exprContext = ((Assign_exprContext) expressionContext);
      return assign_exprContext.reference().parameterized_reference().parameterized_matrix_reference() != null
          && assign_exprContext.reference().parameterized_reference().parameterized_attr_reference() == null;
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

  private static boolean isNumberExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Number_exprContext.class);
  }

  private static boolean isWordExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Word_exprContext.class);
  }

  private static boolean isParamNameExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Param_name_exprContext.class);
  }

  private static boolean isReferenceExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Reference_exprContext.class);
  }

  private static boolean isCompareExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Compare_exprContext.class);
  }

  private static boolean isBoolExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Bool_exprContext.class);
  }

  private static boolean isBinaryExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Binary_exprContext.class);
  }

  private static boolean isUnaryExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Unary_exprContext.class);
  }

  private static boolean isSetInitExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Set_init_exprContext.class);
  }

  private static boolean isForExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(For_exprContext.class);
  }

  private static boolean isIfExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(If_exprContext.class);
  }

  private static boolean isVarDefiningExpr(ExpressionContext expressionContext) {
    return expressionContext.getClass().equals(Var_defining_expressionContext.class);
  }
}
