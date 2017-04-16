// Generated from D:/Laci/egyetem/szakdolgozat/SML/src/main/java/antlr\SML.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SMLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SMLParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SMLParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#state_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_expr(SMLParser.State_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#state_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_description(SMLParser.State_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#state_description_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_description_line(SMLParser.State_description_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#state_start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_start(SMLParser.State_startContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#state_goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_goal(SMLParser.State_goalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#operator_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator_expr(SMLParser.Operator_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#operator_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator_description(SMLParser.Operator_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#operator_cost}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator_cost(SMLParser.Operator_costContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#operator_precondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator_precondition(SMLParser.Operator_preconditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#operator_effect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator_effect(SMLParser.Operator_effectContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#attr_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_name(SMLParser.Attr_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#attr_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_reference(SMLParser.Attr_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#parameterized_attr_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterized_attr_reference(SMLParser.Parameterized_attr_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#matrix_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatrix_reference(SMLParser.Matrix_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#parameterized_matrix_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterized_matrix_reference(SMLParser.Parameterized_matrix_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#dimension}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimension(SMLParser.DimensionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#normal_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_reference(SMLParser.Normal_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#parameterized_reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterized_reference(SMLParser.Parameterized_referenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#reference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference(SMLParser.ReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#attr_struct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_struct(SMLParser.Attr_structContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#attr_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttr_type(SMLParser.Attr_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#comparator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparator(SMLParser.ComparatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#binary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_operator(SMLParser.Binary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(SMLParser.Unary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#boolean_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean_operator(SMLParser.Boolean_operatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paren_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen_expr(SMLParser.Paren_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code param_name_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_name_expr(SMLParser.Param_name_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code compare_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompare_expr(SMLParser.Compare_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binary_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary_expr(SMLParser.Binary_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_expr(SMLParser.Assign_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code word_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord_expr(SMLParser.Word_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unary_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expr(SMLParser.Unary_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_expr(SMLParser.If_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code reference_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReference_expr(SMLParser.Reference_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_expr(SMLParser.Bool_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_expr(SMLParser.For_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code var_defining_expression}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_defining_expression(SMLParser.Var_defining_expressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code set_init_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_init_expr(SMLParser.Set_init_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code number_expr}
	 * labeled alternative in {@link SMLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber_expr(SMLParser.Number_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#parameter_description_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_description_line(SMLParser.Parameter_description_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#for_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_statement(SMLParser.For_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#if_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_statement(SMLParser.If_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#else_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_statement(SMLParser.Else_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(SMLParser.NumberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SMLParser#word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWord(SMLParser.WordContext ctx);
}