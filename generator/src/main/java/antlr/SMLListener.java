// Generated from D:/Laci/egyetem/szakdolgozat/SML/src/main/java/antlr\SML.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SMLParser}.
 */
public interface SMLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SMLParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(SMLParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(SMLParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_expr}.
	 * @param ctx the parse tree
	 */
	void enterState_expr(SMLParser.State_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_expr}.
	 * @param ctx the parse tree
	 */
	void exitState_expr(SMLParser.State_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_description}.
	 * @param ctx the parse tree
	 */
	void enterState_description(SMLParser.State_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_description}.
	 * @param ctx the parse tree
	 */
	void exitState_description(SMLParser.State_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_description_line}.
	 * @param ctx the parse tree
	 */
	void enterState_description_line(SMLParser.State_description_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_description_line}.
	 * @param ctx the parse tree
	 */
	void exitState_description_line(SMLParser.State_description_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_start}.
	 * @param ctx the parse tree
	 */
	void enterState_start(SMLParser.State_startContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_start}.
	 * @param ctx the parse tree
	 */
	void exitState_start(SMLParser.State_startContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#state_goal}.
	 * @param ctx the parse tree
	 */
	void enterState_goal(SMLParser.State_goalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#state_goal}.
	 * @param ctx the parse tree
	 */
	void exitState_goal(SMLParser.State_goalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operator_expr}.
	 * @param ctx the parse tree
	 */
	void enterOperator_expr(SMLParser.Operator_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operator_expr}.
	 * @param ctx the parse tree
	 */
	void exitOperator_expr(SMLParser.Operator_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operator_description}.
	 * @param ctx the parse tree
	 */
	void enterOperator_description(SMLParser.Operator_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operator_description}.
	 * @param ctx the parse tree
	 */
	void exitOperator_description(SMLParser.Operator_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operator_cost}.
	 * @param ctx the parse tree
	 */
	void enterOperator_cost(SMLParser.Operator_costContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operator_cost}.
	 * @param ctx the parse tree
	 */
	void exitOperator_cost(SMLParser.Operator_costContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operator_precondition}.
	 * @param ctx the parse tree
	 */
	void enterOperator_precondition(SMLParser.Operator_preconditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operator_precondition}.
	 * @param ctx the parse tree
	 */
	void exitOperator_precondition(SMLParser.Operator_preconditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#operator_effect}.
	 * @param ctx the parse tree
	 */
	void enterOperator_effect(SMLParser.Operator_effectContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#operator_effect}.
	 * @param ctx the parse tree
	 */
	void exitOperator_effect(SMLParser.Operator_effectContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void enterAttr_name(SMLParser.Attr_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#attr_name}.
	 * @param ctx the parse tree
	 */
	void exitAttr_name(SMLParser.Attr_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#attr_reference}.
	 * @param ctx the parse tree
	 */
	void enterAttr_reference(SMLParser.Attr_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#attr_reference}.
	 * @param ctx the parse tree
	 */
	void exitAttr_reference(SMLParser.Attr_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#parameterized_attr_reference}.
	 * @param ctx the parse tree
	 */
	void enterParameterized_attr_reference(SMLParser.Parameterized_attr_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#parameterized_attr_reference}.
	 * @param ctx the parse tree
	 */
	void exitParameterized_attr_reference(SMLParser.Parameterized_attr_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#matrix_reference}.
	 * @param ctx the parse tree
	 */
	void enterMatrix_reference(SMLParser.Matrix_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#matrix_reference}.
	 * @param ctx the parse tree
	 */
	void exitMatrix_reference(SMLParser.Matrix_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#parameterized_matrix_reference}.
	 * @param ctx the parse tree
	 */
	void enterParameterized_matrix_reference(SMLParser.Parameterized_matrix_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#parameterized_matrix_reference}.
	 * @param ctx the parse tree
	 */
	void exitParameterized_matrix_reference(SMLParser.Parameterized_matrix_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#dimension}.
	 * @param ctx the parse tree
	 */
	void enterDimension(SMLParser.DimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#dimension}.
	 * @param ctx the parse tree
	 */
	void exitDimension(SMLParser.DimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#normal_reference}.
	 * @param ctx the parse tree
	 */
	void enterNormal_reference(SMLParser.Normal_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#normal_reference}.
	 * @param ctx the parse tree
	 */
	void exitNormal_reference(SMLParser.Normal_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#parameterized_reference}.
	 * @param ctx the parse tree
	 */
	void enterParameterized_reference(SMLParser.Parameterized_referenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#parameterized_reference}.
	 * @param ctx the parse tree
	 */
	void exitParameterized_reference(SMLParser.Parameterized_referenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void enterReference(SMLParser.ReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#reference}.
	 * @param ctx the parse tree
	 */
	void exitReference(SMLParser.ReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#attr_struct}.
	 * @param ctx the parse tree
	 */
	void enterAttr_struct(SMLParser.Attr_structContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#attr_struct}.
	 * @param ctx the parse tree
	 */
	void exitAttr_struct(SMLParser.Attr_structContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void enterAttr_type(SMLParser.Attr_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#attr_type}.
	 * @param ctx the parse tree
	 */
	void exitAttr_type(SMLParser.Attr_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#comparator}.
	 * @param ctx the parse tree
	 */
	void enterComparator(SMLParser.ComparatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#comparator}.
	 * @param ctx the parse tree
	 */
	void exitComparator(SMLParser.ComparatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void enterBinary_operator(SMLParser.Binary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#binary_operator}.
	 * @param ctx the parse tree
	 */
	void exitBinary_operator(SMLParser.Binary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(SMLParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(SMLParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#boolean_operator}.
	 * @param ctx the parse tree
	 */
	void enterBoolean_operator(SMLParser.Boolean_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#boolean_operator}.
	 * @param ctx the parse tree
	 */
	void exitBoolean_operator(SMLParser.Boolean_operatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen_expr(SMLParser.Paren_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen_expr(SMLParser.Paren_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code param_name_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParam_name_expr(SMLParser.Param_name_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code param_name_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParam_name_expr(SMLParser.Param_name_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code compare_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCompare_expr(SMLParser.Compare_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code compare_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCompare_expr(SMLParser.Compare_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binary_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinary_expr(SMLParser.Binary_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binary_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinary_expr(SMLParser.Binary_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assign_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(SMLParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assign_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(SMLParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code word_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterWord_expr(SMLParser.Word_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code word_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitWord_expr(SMLParser.Word_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unary_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(SMLParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unary_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(SMLParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code if_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIf_expr(SMLParser.If_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code if_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIf_expr(SMLParser.If_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code reference_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterReference_expr(SMLParser.Reference_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code reference_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitReference_expr(SMLParser.Reference_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBool_expr(SMLParser.Bool_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBool_expr(SMLParser.Bool_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFor_expr(SMLParser.For_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFor_expr(SMLParser.For_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var_defining_expression}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVar_defining_expression(SMLParser.Var_defining_expressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var_defining_expression}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVar_defining_expression(SMLParser.Var_defining_expressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code set_init_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSet_init_expr(SMLParser.Set_init_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code set_init_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSet_init_expr(SMLParser.Set_init_exprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code number_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumber_expr(SMLParser.Number_exprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code number_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumber_expr(SMLParser.Number_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#parameter_description_line}.
	 * @param ctx the parse tree
	 */
	void enterParameter_description_line(SMLParser.Parameter_description_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#parameter_description_line}.
	 * @param ctx the parse tree
	 */
	void exitParameter_description_line(SMLParser.Parameter_description_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void enterFor_statement(SMLParser.For_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#for_statement}.
	 * @param ctx the parse tree
	 */
	void exitFor_statement(SMLParser.For_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void enterIf_statement(SMLParser.If_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#if_statement}.
	 * @param ctx the parse tree
	 */
	void exitIf_statement(SMLParser.If_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void enterElse_statement(SMLParser.Else_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#else_statement}.
	 * @param ctx the parse tree
	 */
	void exitElse_statement(SMLParser.Else_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(SMLParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(SMLParser.NumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SMLParser#word}.
	 * @param ctx the parse tree
	 */
	void enterWord(SMLParser.WordContext ctx);
	/**
	 * Exit a parse tree produced by {@link SMLParser#word}.
	 * @param ctx the parse tree
	 */
	void exitWord(SMLParser.WordContext ctx);
}