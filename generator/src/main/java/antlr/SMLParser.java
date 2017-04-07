// Generated from D:/Laci/egyetem/szakdolgozat/SML/src/main/java/antlr\SML.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SMLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, STATE_DELIMITER=2, STATE_ATTRIBUTES_DELIMITER=3, STATE_START_DELIMITER=4, 
		STATE_GOAL_DELIMITER=5, OPERATOR_DELIMITER=6, OPERATOR_DESCRIPTION_DELIMITER=7, 
		OPERATOR_PRECONDITION_DELIMITER=8, OPERATOR_EFFECT_DELIMITER=9, KEYWORD_FOR=10, 
		KEYWORD_PARAM=11, KEYWORD_FROM=12, KEYWORD_TO=13, KEYWORD_BY=14, KEYWORD_TIMES=15, 
		KEYWORD_ATTRIBUTE=16, KEYWORD_VAR=17, KEYWORD_COST=18, KEYWORD_NAME=19, 
		KEYWORD_IS=20, KEYWORD_OF=21, KEYWORD_SET=22, KEYWORD_MATRIX=23, KEYWORD_WORD=24, 
		KEYWORD_NUMBER=25, KEYWORD_MINIMUM=26, KEYWORD_MAXIMUM=27, KEYWORD_SUM=28, 
		KEYWORD_AVERAGE=29, KEYWORD_UNION=30, KEYWORD_INTERSECT=31, KEYWORD_DIFFERENCE=32, 
		KEYWORD_ADD=33, KEYWORD_REMOVE=34, KEYWORD_CARDINALITY=35, KEYWORD_AND=36, 
		KEYWORD_OR=37, KEYWORD_NOT=38, KEYWORD_INF=39, SYMBOL_EQUAL=40, SYMBOL_NOT_EQUAL=41, 
		SYMBOL_LESSER=42, SYMBOL_GREATER=43, SYMBOL_LESSER_OR_EQUAL=44, SYMBOL_GREATER_OR_EQUAL=45, 
		SYMBOL_ADDITION=46, SYMBOL_SUBSTRACT=47, SYMBOL_MULTIPLICATION=48, SYMBOL_DIVISION=49, 
		SYMBOL_ASSIGN=50, SYMBOL_REFERENCE=51, SYMBOL_COMMA=52, SYMBOL_QUOTE=53, 
		SYMBOL_SINGLE_QOUTE=54, SYMBOL_LPAREN=55, SYMBOL_RPAREN=56, SYMBOL_LBRACE=57, 
		SYMBOL_RBRACE=58, SYMBOL_LBRACK=59, SYMOBL_RBRACK=60, INT=61, FLOAT=62, 
		SIGN=63, PARAM_NAME=64, CHAR=65, WS=66;
	public static final int
		RULE_expr = 0, RULE_state_expr = 1, RULE_state_description = 2, RULE_state_description_line = 3, 
		RULE_state_start = 4, RULE_state_goal = 5, RULE_operator_expr = 6, RULE_operator_description = 7, 
		RULE_operator_cost = 8, RULE_operator_precondition = 9, RULE_operator_effect = 10, 
		RULE_attr_struct = 11, RULE_attr_type = 12, RULE_comparator = 13, RULE_binary_operator = 14, 
		RULE_unary_operator = 15, RULE_boolean_operator = 16, RULE_expression = 17, 
		RULE_name_defining_expression = 18, RULE_parameter_description_line = 19, 
		RULE_for_statement = 20, RULE_attr_name = 21, RULE_attr_reference = 22, 
		RULE_parameterized_attr_reference = 23, RULE_matrix_reference = 24, RULE_parameterized_matrix_reference = 25, 
		RULE_dimension = 26, RULE_normal_reference = 27, RULE_parameterized_reference = 28, 
		RULE_reference = 29, RULE_number = 30, RULE_word = 31;
	public static final String[] ruleNames = {
		"expr", "state_expr", "state_description", "state_description_line", "state_start", 
		"state_goal", "operator_expr", "operator_description", "operator_cost", 
		"operator_precondition", "operator_effect", "attr_struct", "attr_type", 
		"comparator", "binary_operator", "unary_operator", "boolean_operator", 
		"expression", "name_defining_expression", "parameter_description_line", 
		"for_statement", "attr_name", "attr_reference", "parameterized_attr_reference", 
		"matrix_reference", "parameterized_matrix_reference", "dimension", "normal_reference", 
		"parameterized_reference", "reference", "number", "word"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\'", "'STATE:'", "'STATE_ATTRIBUTES:'", "'STATE_START:'", "'STATE_GOAL:'", 
		"'OPERATORS:'", "'OPERATOR_DESCRIPTION:'", "'OPERATOR_PRECONDITION:'", 
		"'OPERATOR_EFFECT:'", "'for'", "'param'", "'from'", "'to'", "'by'", "'times'", 
		"'Attr'", "'var'", "'cost'", "'name'", "'is'", "'of'", "'set'", "'matrix'", 
		"'word'", "'number'", "'min'", "'max'", "'sum'", "'avg'", "'union'", "'intersect'", 
		"'difference'", "'add'", "'remove'", "'card'", "'and'", "'or'", "'not'", 
		"'inf'", "'=='", "'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", 
		"'/'", "'='", "'$'", "','", "'\"'", "'''", "'('", "')'", "'{'", "'}'", 
		"'['", "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "STATE_DELIMITER", "STATE_ATTRIBUTES_DELIMITER", "STATE_START_DELIMITER", 
		"STATE_GOAL_DELIMITER", "OPERATOR_DELIMITER", "OPERATOR_DESCRIPTION_DELIMITER", 
		"OPERATOR_PRECONDITION_DELIMITER", "OPERATOR_EFFECT_DELIMITER", "KEYWORD_FOR", 
		"KEYWORD_PARAM", "KEYWORD_FROM", "KEYWORD_TO", "KEYWORD_BY", "KEYWORD_TIMES", 
		"KEYWORD_ATTRIBUTE", "KEYWORD_VAR", "KEYWORD_COST", "KEYWORD_NAME", "KEYWORD_IS", 
		"KEYWORD_OF", "KEYWORD_SET", "KEYWORD_MATRIX", "KEYWORD_WORD", "KEYWORD_NUMBER", 
		"KEYWORD_MINIMUM", "KEYWORD_MAXIMUM", "KEYWORD_SUM", "KEYWORD_AVERAGE", 
		"KEYWORD_UNION", "KEYWORD_INTERSECT", "KEYWORD_DIFFERENCE", "KEYWORD_ADD", 
		"KEYWORD_REMOVE", "KEYWORD_CARDINALITY", "KEYWORD_AND", "KEYWORD_OR", 
		"KEYWORD_NOT", "KEYWORD_INF", "SYMBOL_EQUAL", "SYMBOL_NOT_EQUAL", "SYMBOL_LESSER", 
		"SYMBOL_GREATER", "SYMBOL_LESSER_OR_EQUAL", "SYMBOL_GREATER_OR_EQUAL", 
		"SYMBOL_ADDITION", "SYMBOL_SUBSTRACT", "SYMBOL_MULTIPLICATION", "SYMBOL_DIVISION", 
		"SYMBOL_ASSIGN", "SYMBOL_REFERENCE", "SYMBOL_COMMA", "SYMBOL_QUOTE", "SYMBOL_SINGLE_QOUTE", 
		"SYMBOL_LPAREN", "SYMBOL_RPAREN", "SYMBOL_LBRACE", "SYMBOL_RBRACE", "SYMBOL_LBRACK", 
		"SYMOBL_RBRACK", "INT", "FLOAT", "SIGN", "PARAM_NAME", "CHAR", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SMLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ExprContext extends ParserRuleContext {
		public TerminalNode STATE_DELIMITER() { return getToken(SMLParser.STATE_DELIMITER, 0); }
		public State_exprContext state_expr() {
			return getRuleContext(State_exprContext.class,0);
		}
		public TerminalNode OPERATOR_DELIMITER() { return getToken(SMLParser.OPERATOR_DELIMITER, 0); }
		public TerminalNode EOF() { return getToken(SMLParser.EOF, 0); }
		public Name_defining_expressionContext name_defining_expression() {
			return getRuleContext(Name_defining_expressionContext.class,0);
		}
		public List<Operator_exprContext> operator_expr() {
			return getRuleContexts(Operator_exprContext.class);
		}
		public Operator_exprContext operator_expr(int i) {
			return getRuleContext(Operator_exprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(STATE_DELIMITER);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_NAME) {
				{
				setState(65);
				name_defining_expression();
				}
			}

			setState(68);
			state_expr();
			setState(69);
			match(OPERATOR_DELIMITER);
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				operator_expr();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPERATOR_DESCRIPTION_DELIMITER );
			setState(75);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_exprContext extends ParserRuleContext {
		public State_descriptionContext state_description() {
			return getRuleContext(State_descriptionContext.class,0);
		}
		public State_startContext state_start() {
			return getRuleContext(State_startContext.class,0);
		}
		public State_goalContext state_goal() {
			return getRuleContext(State_goalContext.class,0);
		}
		public State_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_exprContext state_expr() throws RecognitionException {
		State_exprContext _localctx = new State_exprContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_state_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			state_description();
			setState(78);
			state_start();
			setState(79);
			state_goal();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_descriptionContext extends ParserRuleContext {
		public TerminalNode STATE_ATTRIBUTES_DELIMITER() { return getToken(SMLParser.STATE_ATTRIBUTES_DELIMITER, 0); }
		public List<State_description_lineContext> state_description_line() {
			return getRuleContexts(State_description_lineContext.class);
		}
		public State_description_lineContext state_description_line(int i) {
			return getRuleContext(State_description_lineContext.class,i);
		}
		public State_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_descriptionContext state_description() throws RecognitionException {
		State_descriptionContext _localctx = new State_descriptionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_state_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(STATE_ATTRIBUTES_DELIMITER);
			setState(83); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(82);
				state_description_line();
				}
				}
				setState(85); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==KEYWORD_ATTRIBUTE );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_description_lineContext extends ParserRuleContext {
		public Attr_nameContext attr_name() {
			return getRuleContext(Attr_nameContext.class,0);
		}
		public TerminalNode KEYWORD_IS() { return getToken(SMLParser.KEYWORD_IS, 0); }
		public Attr_structContext attr_struct() {
			return getRuleContext(Attr_structContext.class,0);
		}
		public TerminalNode KEYWORD_OF() { return getToken(SMLParser.KEYWORD_OF, 0); }
		public Attr_typeContext attr_type() {
			return getRuleContext(Attr_typeContext.class,0);
		}
		public State_description_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_description_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_description_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_description_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_description_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_description_lineContext state_description_line() throws RecognitionException {
		State_description_lineContext _localctx = new State_description_lineContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_state_description_line);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			attr_name();
			setState(88);
			match(KEYWORD_IS);
			setState(89);
			attr_struct();
			setState(90);
			match(KEYWORD_OF);
			setState(91);
			attr_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_startContext extends ParserRuleContext {
		public TerminalNode STATE_START_DELIMITER() { return getToken(SMLParser.STATE_START_DELIMITER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public State_startContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_start(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_start(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_start(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_startContext state_start() throws RecognitionException {
		State_startContext _localctx = new State_startContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_state_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(STATE_START_DELIMITER);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (KEYWORD_FOR - 10)) | (1L << (KEYWORD_VAR - 10)) | (1L << (KEYWORD_MINIMUM - 10)) | (1L << (KEYWORD_MAXIMUM - 10)) | (1L << (KEYWORD_SUM - 10)) | (1L << (KEYWORD_AVERAGE - 10)) | (1L << (KEYWORD_UNION - 10)) | (1L << (KEYWORD_ADD - 10)) | (1L << (KEYWORD_REMOVE - 10)) | (1L << (KEYWORD_CARDINALITY - 10)) | (1L << (KEYWORD_INF - 10)) | (1L << (SYMBOL_REFERENCE - 10)) | (1L << (SYMBOL_QUOTE - 10)) | (1L << (SYMBOL_LPAREN - 10)) | (1L << (SYMBOL_LBRACE - 10)) | (1L << (INT - 10)) | (1L << (FLOAT - 10)) | (1L << (SIGN - 10)) | (1L << (PARAM_NAME - 10)))) != 0)) {
				{
				{
				setState(94);
				expression(0);
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_goalContext extends ParserRuleContext {
		public TerminalNode STATE_GOAL_DELIMITER() { return getToken(SMLParser.STATE_GOAL_DELIMITER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public State_goalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_goal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterState_goal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitState_goal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitState_goal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final State_goalContext state_goal() throws RecognitionException {
		State_goalContext _localctx = new State_goalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_state_goal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(STATE_GOAL_DELIMITER);
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				expression(0);
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (KEYWORD_FOR - 10)) | (1L << (KEYWORD_VAR - 10)) | (1L << (KEYWORD_MINIMUM - 10)) | (1L << (KEYWORD_MAXIMUM - 10)) | (1L << (KEYWORD_SUM - 10)) | (1L << (KEYWORD_AVERAGE - 10)) | (1L << (KEYWORD_UNION - 10)) | (1L << (KEYWORD_ADD - 10)) | (1L << (KEYWORD_REMOVE - 10)) | (1L << (KEYWORD_CARDINALITY - 10)) | (1L << (KEYWORD_INF - 10)) | (1L << (SYMBOL_REFERENCE - 10)) | (1L << (SYMBOL_QUOTE - 10)) | (1L << (SYMBOL_LPAREN - 10)) | (1L << (SYMBOL_LBRACE - 10)) | (1L << (INT - 10)) | (1L << (FLOAT - 10)) | (1L << (SIGN - 10)) | (1L << (PARAM_NAME - 10)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_exprContext extends ParserRuleContext {
		public Operator_descriptionContext operator_description() {
			return getRuleContext(Operator_descriptionContext.class,0);
		}
		public Operator_preconditionContext operator_precondition() {
			return getRuleContext(Operator_preconditionContext.class,0);
		}
		public Operator_effectContext operator_effect() {
			return getRuleContext(Operator_effectContext.class,0);
		}
		public Operator_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_exprContext operator_expr() throws RecognitionException {
		Operator_exprContext _localctx = new Operator_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_operator_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			operator_description();
			setState(107);
			operator_precondition();
			setState(108);
			operator_effect();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_descriptionContext extends ParserRuleContext {
		public TerminalNode OPERATOR_DESCRIPTION_DELIMITER() { return getToken(SMLParser.OPERATOR_DESCRIPTION_DELIMITER, 0); }
		public Name_defining_expressionContext name_defining_expression() {
			return getRuleContext(Name_defining_expressionContext.class,0);
		}
		public Operator_costContext operator_cost() {
			return getRuleContext(Operator_costContext.class,0);
		}
		public List<Parameter_description_lineContext> parameter_description_line() {
			return getRuleContexts(Parameter_description_lineContext.class);
		}
		public Parameter_description_lineContext parameter_description_line(int i) {
			return getRuleContext(Parameter_description_lineContext.class,i);
		}
		public Operator_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_descriptionContext operator_description() throws RecognitionException {
		Operator_descriptionContext _localctx = new Operator_descriptionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_operator_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(OPERATOR_DESCRIPTION_DELIMITER);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_NAME) {
				{
				setState(111);
				name_defining_expression();
				}
			}

			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_COST) {
				{
				setState(114);
				operator_cost();
				}
			}

			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_PARAM) {
				{
				{
				setState(117);
				parameter_description_line();
				}
				}
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_costContext extends ParserRuleContext {
		public TerminalNode KEYWORD_COST() { return getToken(SMLParser.KEYWORD_COST, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Operator_costContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_cost; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_cost(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_cost(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_cost(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_costContext operator_cost() throws RecognitionException {
		Operator_costContext _localctx = new Operator_costContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operator_cost);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(KEYWORD_COST);
			setState(124);
			number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_preconditionContext extends ParserRuleContext {
		public TerminalNode OPERATOR_PRECONDITION_DELIMITER() { return getToken(SMLParser.OPERATOR_PRECONDITION_DELIMITER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Operator_preconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_precondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_precondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_precondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_precondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_preconditionContext operator_precondition() throws RecognitionException {
		Operator_preconditionContext _localctx = new Operator_preconditionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operator_precondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(OPERATOR_PRECONDITION_DELIMITER);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (KEYWORD_FOR - 10)) | (1L << (KEYWORD_VAR - 10)) | (1L << (KEYWORD_MINIMUM - 10)) | (1L << (KEYWORD_MAXIMUM - 10)) | (1L << (KEYWORD_SUM - 10)) | (1L << (KEYWORD_AVERAGE - 10)) | (1L << (KEYWORD_UNION - 10)) | (1L << (KEYWORD_ADD - 10)) | (1L << (KEYWORD_REMOVE - 10)) | (1L << (KEYWORD_CARDINALITY - 10)) | (1L << (KEYWORD_INF - 10)) | (1L << (SYMBOL_REFERENCE - 10)) | (1L << (SYMBOL_QUOTE - 10)) | (1L << (SYMBOL_LPAREN - 10)) | (1L << (SYMBOL_LBRACE - 10)) | (1L << (INT - 10)) | (1L << (FLOAT - 10)) | (1L << (SIGN - 10)) | (1L << (PARAM_NAME - 10)))) != 0)) {
				{
				{
				setState(127);
				expression(0);
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Operator_effectContext extends ParserRuleContext {
		public TerminalNode OPERATOR_EFFECT_DELIMITER() { return getToken(SMLParser.OPERATOR_EFFECT_DELIMITER, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Operator_effectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_effect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOperator_effect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOperator_effect(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOperator_effect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_effectContext operator_effect() throws RecognitionException {
		Operator_effectContext _localctx = new Operator_effectContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_operator_effect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(OPERATOR_EFFECT_DELIMITER);
			setState(135); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(134);
				expression(0);
				}
				}
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (KEYWORD_FOR - 10)) | (1L << (KEYWORD_VAR - 10)) | (1L << (KEYWORD_MINIMUM - 10)) | (1L << (KEYWORD_MAXIMUM - 10)) | (1L << (KEYWORD_SUM - 10)) | (1L << (KEYWORD_AVERAGE - 10)) | (1L << (KEYWORD_UNION - 10)) | (1L << (KEYWORD_ADD - 10)) | (1L << (KEYWORD_REMOVE - 10)) | (1L << (KEYWORD_CARDINALITY - 10)) | (1L << (KEYWORD_INF - 10)) | (1L << (SYMBOL_REFERENCE - 10)) | (1L << (SYMBOL_QUOTE - 10)) | (1L << (SYMBOL_LPAREN - 10)) | (1L << (SYMBOL_LBRACE - 10)) | (1L << (INT - 10)) | (1L << (FLOAT - 10)) | (1L << (SIGN - 10)) | (1L << (PARAM_NAME - 10)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_structContext extends ParserRuleContext {
		public TerminalNode KEYWORD_SET() { return getToken(SMLParser.KEYWORD_SET, 0); }
		public TerminalNode KEYWORD_MATRIX() { return getToken(SMLParser.KEYWORD_MATRIX, 0); }
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public Attr_structContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_struct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAttr_struct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAttr_struct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAttr_struct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_structContext attr_struct() throws RecognitionException {
		Attr_structContext _localctx = new Attr_structContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attr_struct);
		try {
			setState(142);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD_SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				match(KEYWORD_SET);
				}
				break;
			case KEYWORD_MATRIX:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(140);
				match(KEYWORD_MATRIX);
				setState(141);
				dimension();
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_typeContext extends ParserRuleContext {
		public TerminalNode KEYWORD_WORD() { return getToken(SMLParser.KEYWORD_WORD, 0); }
		public TerminalNode KEYWORD_NUMBER() { return getToken(SMLParser.KEYWORD_NUMBER, 0); }
		public Attr_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAttr_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAttr_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAttr_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_typeContext attr_type() throws RecognitionException {
		Attr_typeContext _localctx = new Attr_typeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_la = _input.LA(1);
			if ( !(_la==KEYWORD_WORD || _la==KEYWORD_NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComparatorContext extends ParserRuleContext {
		public TerminalNode SYMBOL_EQUAL() { return getToken(SMLParser.SYMBOL_EQUAL, 0); }
		public TerminalNode SYMBOL_NOT_EQUAL() { return getToken(SMLParser.SYMBOL_NOT_EQUAL, 0); }
		public TerminalNode SYMBOL_GREATER() { return getToken(SMLParser.SYMBOL_GREATER, 0); }
		public TerminalNode SYMBOL_LESSER() { return getToken(SMLParser.SYMBOL_LESSER, 0); }
		public TerminalNode SYMBOL_GREATER_OR_EQUAL() { return getToken(SMLParser.SYMBOL_GREATER_OR_EQUAL, 0); }
		public TerminalNode SYMBOL_LESSER_OR_EQUAL() { return getToken(SMLParser.SYMBOL_LESSER_OR_EQUAL, 0); }
		public ComparatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterComparator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitComparator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitComparator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparatorContext comparator() throws RecognitionException {
		ComparatorContext _localctx = new ComparatorContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYMBOL_EQUAL) | (1L << SYMBOL_NOT_EQUAL) | (1L << SYMBOL_LESSER) | (1L << SYMBOL_GREATER) | (1L << SYMBOL_LESSER_OR_EQUAL) | (1L << SYMBOL_GREATER_OR_EQUAL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Binary_operatorContext extends ParserRuleContext {
		public TerminalNode SYMBOL_ADDITION() { return getToken(SMLParser.SYMBOL_ADDITION, 0); }
		public TerminalNode SYMBOL_SUBSTRACT() { return getToken(SMLParser.SYMBOL_SUBSTRACT, 0); }
		public TerminalNode SYMBOL_MULTIPLICATION() { return getToken(SMLParser.SYMBOL_MULTIPLICATION, 0); }
		public TerminalNode SYMBOL_DIVISION() { return getToken(SMLParser.SYMBOL_DIVISION, 0); }
		public Binary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterBinary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitBinary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitBinary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Binary_operatorContext binary_operator() throws RecognitionException {
		Binary_operatorContext _localctx = new Binary_operatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_binary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYMBOL_ADDITION) | (1L << SYMBOL_SUBSTRACT) | (1L << SYMBOL_MULTIPLICATION) | (1L << SYMBOL_DIVISION))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode KEYWORD_MAXIMUM() { return getToken(SMLParser.KEYWORD_MAXIMUM, 0); }
		public TerminalNode KEYWORD_MINIMUM() { return getToken(SMLParser.KEYWORD_MINIMUM, 0); }
		public TerminalNode KEYWORD_AVERAGE() { return getToken(SMLParser.KEYWORD_AVERAGE, 0); }
		public TerminalNode KEYWORD_CARDINALITY() { return getToken(SMLParser.KEYWORD_CARDINALITY, 0); }
		public TerminalNode KEYWORD_UNION() { return getToken(SMLParser.KEYWORD_UNION, 0); }
		public TerminalNode KEYWORD_ADD() { return getToken(SMLParser.KEYWORD_ADD, 0); }
		public TerminalNode KEYWORD_REMOVE() { return getToken(SMLParser.KEYWORD_REMOVE, 0); }
		public TerminalNode KEYWORD_SUM() { return getToken(SMLParser.KEYWORD_SUM, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD_MINIMUM) | (1L << KEYWORD_MAXIMUM) | (1L << KEYWORD_SUM) | (1L << KEYWORD_AVERAGE) | (1L << KEYWORD_UNION) | (1L << KEYWORD_ADD) | (1L << KEYWORD_REMOVE) | (1L << KEYWORD_CARDINALITY))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Boolean_operatorContext extends ParserRuleContext {
		public TerminalNode KEYWORD_AND() { return getToken(SMLParser.KEYWORD_AND, 0); }
		public TerminalNode KEYWORD_OR() { return getToken(SMLParser.KEYWORD_OR, 0); }
		public Boolean_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterBoolean_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitBoolean_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitBoolean_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Boolean_operatorContext boolean_operator() throws RecognitionException {
		Boolean_operatorContext _localctx = new Boolean_operatorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_boolean_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ( !(_la==KEYWORD_AND || _la==KEYWORD_OR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Paren_exprContext extends ExpressionContext {
		public TerminalNode SYMBOL_LPAREN() { return getToken(SMLParser.SYMBOL_LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SYMBOL_RPAREN() { return getToken(SMLParser.SYMBOL_RPAREN, 0); }
		public Paren_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParen_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParen_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParen_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Param_name_exprContext extends ExpressionContext {
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
		public Param_name_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParam_name_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParam_name_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParam_name_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Compare_exprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public ComparatorContext comparator() {
			return getRuleContext(ComparatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Compare_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterCompare_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitCompare_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitCompare_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Binary_exprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public Binary_operatorContext binary_operator() {
			return getRuleContext(Binary_operatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Binary_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterBinary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitBinary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitBinary_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Assign_exprContext extends ExpressionContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public TerminalNode SYMBOL_ASSIGN() { return getToken(SMLParser.SYMBOL_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assign_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAssign_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAssign_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Two_param_unary_exprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public TerminalNode SYMBOL_LPAREN() { return getToken(SMLParser.SYMBOL_LPAREN, 0); }
		public TerminalNode SYMBOL_RPAREN() { return getToken(SMLParser.SYMBOL_RPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SYMBOL_COMMA() { return getToken(SMLParser.SYMBOL_COMMA, 0); }
		public Two_param_unary_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterTwo_param_unary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitTwo_param_unary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitTwo_param_unary_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Word_exprContext extends ExpressionContext {
		public WordContext word() {
			return getRuleContext(WordContext.class,0);
		}
		public Word_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterWord_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitWord_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitWord_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Reference_exprContext extends ExpressionContext {
		public ReferenceContext reference() {
			return getRuleContext(ReferenceContext.class,0);
		}
		public Reference_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterReference_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitReference_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitReference_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Bool_exprContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public Boolean_operatorContext boolean_operator() {
			return getRuleContext(Boolean_operatorContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Bool_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterBool_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitBool_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitBool_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class For_exprContext extends ExpressionContext {
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public TerminalNode SYMBOL_LBRACE() { return getToken(SMLParser.SYMBOL_LBRACE, 0); }
		public TerminalNode SYMBOL_RBRACE() { return getToken(SMLParser.SYMBOL_RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public For_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterFor_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitFor_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitFor_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Var_defining_expressionContext extends ExpressionContext {
		public TerminalNode KEYWORD_VAR() { return getToken(SMLParser.KEYWORD_VAR, 0); }
		public Attr_typeContext attr_type() {
			return getRuleContext(Attr_typeContext.class,0);
		}
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
		public TerminalNode SYMBOL_ASSIGN() { return getToken(SMLParser.SYMBOL_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Var_defining_expressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterVar_defining_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitVar_defining_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitVar_defining_expression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Set_init_exprContext extends ExpressionContext {
		public TerminalNode SYMBOL_LBRACE() { return getToken(SMLParser.SYMBOL_LBRACE, 0); }
		public TerminalNode SYMBOL_RBRACE() { return getToken(SMLParser.SYMBOL_RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> SYMBOL_COMMA() { return getTokens(SMLParser.SYMBOL_COMMA); }
		public TerminalNode SYMBOL_COMMA(int i) {
			return getToken(SMLParser.SYMBOL_COMMA, i);
		}
		public Set_init_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterSet_init_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitSet_init_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitSet_init_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class One_param_unary_exprContext extends ExpressionContext {
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public TerminalNode SYMBOL_LPAREN() { return getToken(SMLParser.SYMBOL_LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SYMBOL_RPAREN() { return getToken(SMLParser.SYMBOL_RPAREN, 0); }
		public One_param_unary_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterOne_param_unary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitOne_param_unary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitOne_param_unary_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Number_exprContext extends ExpressionContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Number_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterNumber_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitNumber_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitNumber_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(155);
				match(SYMBOL_LPAREN);
				setState(156);
				expression(0);
				setState(157);
				match(SYMBOL_RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new One_param_unary_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(159);
				unary_operator();
				setState(160);
				match(SYMBOL_LPAREN);
				setState(161);
				expression(0);
				setState(162);
				match(SYMBOL_RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new Two_param_unary_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				unary_operator();
				setState(165);
				match(SYMBOL_LPAREN);
				setState(166);
				((Two_param_unary_exprContext)_localctx).left = expression(0);
				setState(169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SYMBOL_COMMA) {
					{
					setState(167);
					match(SYMBOL_COMMA);
					setState(168);
					((Two_param_unary_exprContext)_localctx).right = expression(0);
					}
				}

				setState(171);
				match(SYMBOL_RPAREN);
				}
				break;
			case 4:
				{
				_localctx = new Set_init_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				match(SYMBOL_LBRACE);
				{
				setState(174);
				expression(0);
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL_COMMA) {
					{
					{
					setState(175);
					match(SYMBOL_COMMA);
					setState(176);
					expression(0);
					}
					}
					setState(181);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(182);
				match(SYMBOL_RBRACE);
				}
				break;
			case 5:
				{
				_localctx = new Assign_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184);
				reference();
				setState(185);
				match(SYMBOL_ASSIGN);
				setState(186);
				expression(7);
				}
				break;
			case 6:
				{
				_localctx = new For_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188);
				for_statement();
				setState(189);
				match(SYMBOL_LBRACE);
				setState(191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(190);
					expression(0);
					}
					}
					setState(193); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (KEYWORD_FOR - 10)) | (1L << (KEYWORD_VAR - 10)) | (1L << (KEYWORD_MINIMUM - 10)) | (1L << (KEYWORD_MAXIMUM - 10)) | (1L << (KEYWORD_SUM - 10)) | (1L << (KEYWORD_AVERAGE - 10)) | (1L << (KEYWORD_UNION - 10)) | (1L << (KEYWORD_ADD - 10)) | (1L << (KEYWORD_REMOVE - 10)) | (1L << (KEYWORD_CARDINALITY - 10)) | (1L << (KEYWORD_INF - 10)) | (1L << (SYMBOL_REFERENCE - 10)) | (1L << (SYMBOL_QUOTE - 10)) | (1L << (SYMBOL_LPAREN - 10)) | (1L << (SYMBOL_LBRACE - 10)) | (1L << (INT - 10)) | (1L << (FLOAT - 10)) | (1L << (SIGN - 10)) | (1L << (PARAM_NAME - 10)))) != 0) );
				setState(195);
				match(SYMBOL_RBRACE);
				}
				break;
			case 7:
				{
				_localctx = new Var_defining_expressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(KEYWORD_VAR);
				setState(198);
				attr_type();
				setState(199);
				match(PARAM_NAME);
				setState(200);
				match(SYMBOL_ASSIGN);
				setState(201);
				expression(5);
				}
				break;
			case 8:
				{
				_localctx = new Reference_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(203);
				reference();
				}
				break;
			case 9:
				{
				_localctx = new Word_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204);
				word();
				}
				break;
			case 10:
				{
				_localctx = new Number_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(205);
				number();
				}
				break;
			case 11:
				{
				_localctx = new Param_name_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(206);
				match(PARAM_NAME);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new Compare_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Compare_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(210);
						comparator();
						setState(211);
						((Compare_exprContext)_localctx).right = expression(14);
						}
						break;
					case 2:
						{
						_localctx = new Bool_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Bool_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(214);
						boolean_operator();
						setState(215);
						((Bool_exprContext)_localctx).right = expression(13);
						}
						break;
					case 3:
						{
						_localctx = new Binary_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Binary_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(218);
						binary_operator();
						setState(219);
						((Binary_exprContext)_localctx).right = expression(12);
						}
						break;
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Name_defining_expressionContext extends ParserRuleContext {
		public TerminalNode KEYWORD_NAME() { return getToken(SMLParser.KEYWORD_NAME, 0); }
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
		public Name_defining_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_defining_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterName_defining_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitName_defining_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitName_defining_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Name_defining_expressionContext name_defining_expression() throws RecognitionException {
		Name_defining_expressionContext _localctx = new Name_defining_expressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_name_defining_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(KEYWORD_NAME);
			setState(227);
			match(PARAM_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_description_lineContext extends ParserRuleContext {
		public TerminalNode KEYWORD_PARAM() { return getToken(SMLParser.KEYWORD_PARAM, 0); }
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
		public TerminalNode KEYWORD_FROM() { return getToken(SMLParser.KEYWORD_FROM, 0); }
		public List<TerminalNode> INT() { return getTokens(SMLParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(SMLParser.INT, i);
		}
		public TerminalNode KEYWORD_TO() { return getToken(SMLParser.KEYWORD_TO, 0); }
		public TerminalNode KEYWORD_BY() { return getToken(SMLParser.KEYWORD_BY, 0); }
		public Parameter_description_lineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_description_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParameter_description_line(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParameter_description_line(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParameter_description_line(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_description_lineContext parameter_description_line() throws RecognitionException {
		Parameter_description_lineContext _localctx = new Parameter_description_lineContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_parameter_description_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(KEYWORD_PARAM);
			setState(230);
			match(PARAM_NAME);
			setState(231);
			match(KEYWORD_FROM);
			setState(232);
			match(INT);
			setState(233);
			match(KEYWORD_TO);
			setState(234);
			match(INT);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_BY) {
				{
				setState(235);
				match(KEYWORD_BY);
				setState(236);
				match(INT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_statementContext extends ParserRuleContext {
		public Token variable;
		public ExpressionContext from;
		public ExpressionContext to;
		public ExpressionContext by;
		public TerminalNode KEYWORD_FOR() { return getToken(SMLParser.KEYWORD_FOR, 0); }
		public TerminalNode KEYWORD_FROM() { return getToken(SMLParser.KEYWORD_FROM, 0); }
		public TerminalNode KEYWORD_TO() { return getToken(SMLParser.KEYWORD_TO, 0); }
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode KEYWORD_BY() { return getToken(SMLParser.KEYWORD_BY, 0); }
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitFor_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitFor_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(KEYWORD_FOR);
			setState(240);
			((For_statementContext)_localctx).variable = match(PARAM_NAME);
			setState(241);
			match(KEYWORD_FROM);
			setState(242);
			((For_statementContext)_localctx).from = expression(0);
			setState(243);
			match(KEYWORD_TO);
			setState(244);
			((For_statementContext)_localctx).to = expression(0);
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_BY) {
				{
				setState(245);
				match(KEYWORD_BY);
				setState(246);
				((For_statementContext)_localctx).by = expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_nameContext extends ParserRuleContext {
		public TerminalNode KEYWORD_ATTRIBUTE() { return getToken(SMLParser.KEYWORD_ATTRIBUTE, 0); }
		public TerminalNode INT() { return getToken(SMLParser.INT, 0); }
		public Attr_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAttr_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAttr_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAttr_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_nameContext attr_name() throws RecognitionException {
		Attr_nameContext _localctx = new Attr_nameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_attr_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(KEYWORD_ATTRIBUTE);
			setState(250);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Attr_referenceContext extends ParserRuleContext {
		public TerminalNode SYMBOL_REFERENCE() { return getToken(SMLParser.SYMBOL_REFERENCE, 0); }
		public TerminalNode INT() { return getToken(SMLParser.INT, 0); }
		public Attr_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterAttr_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitAttr_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitAttr_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Attr_referenceContext attr_reference() throws RecognitionException {
		Attr_referenceContext _localctx = new Attr_referenceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_attr_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(SYMBOL_REFERENCE);
			setState(253);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameterized_attr_referenceContext extends ParserRuleContext {
		public TerminalNode SYMBOL_REFERENCE() { return getToken(SMLParser.SYMBOL_REFERENCE, 0); }
		public TerminalNode PARAM_NAME() { return getToken(SMLParser.PARAM_NAME, 0); }
		public Parameterized_attr_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterized_attr_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParameterized_attr_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParameterized_attr_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParameterized_attr_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameterized_attr_referenceContext parameterized_attr_reference() throws RecognitionException {
		Parameterized_attr_referenceContext _localctx = new Parameterized_attr_referenceContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_parameterized_attr_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(SYMBOL_REFERENCE);
			setState(256);
			match(PARAM_NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Matrix_referenceContext extends ParserRuleContext {
		public Attr_referenceContext attr_reference() {
			return getRuleContext(Attr_referenceContext.class,0);
		}
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public Matrix_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterMatrix_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitMatrix_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitMatrix_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matrix_referenceContext matrix_reference() throws RecognitionException {
		Matrix_referenceContext _localctx = new Matrix_referenceContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_matrix_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			attr_reference();
			setState(259);
			dimension();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameterized_matrix_referenceContext extends ParserRuleContext {
		public Parameterized_attr_referenceContext parameterized_attr_reference() {
			return getRuleContext(Parameterized_attr_referenceContext.class,0);
		}
		public DimensionContext dimension() {
			return getRuleContext(DimensionContext.class,0);
		}
		public Parameterized_matrix_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterized_matrix_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParameterized_matrix_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParameterized_matrix_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParameterized_matrix_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameterized_matrix_referenceContext parameterized_matrix_reference() throws RecognitionException {
		Parameterized_matrix_referenceContext _localctx = new Parameterized_matrix_referenceContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_parameterized_matrix_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			parameterized_attr_reference();
			setState(262);
			dimension();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DimensionContext extends ParserRuleContext {
		public ExpressionContext dimensionN;
		public ExpressionContext dimensionM;
		public List<TerminalNode> SYMBOL_LBRACK() { return getTokens(SMLParser.SYMBOL_LBRACK); }
		public TerminalNode SYMBOL_LBRACK(int i) {
			return getToken(SMLParser.SYMBOL_LBRACK, i);
		}
		public List<TerminalNode> SYMOBL_RBRACK() { return getTokens(SMLParser.SYMOBL_RBRACK); }
		public TerminalNode SYMOBL_RBRACK(int i) {
			return getToken(SMLParser.SYMOBL_RBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitDimension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitDimension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(SYMBOL_LBRACK);
			setState(265);
			((DimensionContext)_localctx).dimensionN = expression(0);
			setState(266);
			match(SYMOBL_RBRACK);
			setState(267);
			match(SYMBOL_LBRACK);
			setState(268);
			((DimensionContext)_localctx).dimensionM = expression(0);
			setState(269);
			match(SYMOBL_RBRACK);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Normal_referenceContext extends ParserRuleContext {
		public Attr_referenceContext attr_reference() {
			return getRuleContext(Attr_referenceContext.class,0);
		}
		public Matrix_referenceContext matrix_reference() {
			return getRuleContext(Matrix_referenceContext.class,0);
		}
		public Normal_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normal_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterNormal_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitNormal_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitNormal_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Normal_referenceContext normal_reference() throws RecognitionException {
		Normal_referenceContext _localctx = new Normal_referenceContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_normal_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(271);
				attr_reference();
				}
				break;
			case 2:
				{
				setState(272);
				matrix_reference();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameterized_referenceContext extends ParserRuleContext {
		public Parameterized_attr_referenceContext parameterized_attr_reference() {
			return getRuleContext(Parameterized_attr_referenceContext.class,0);
		}
		public Parameterized_matrix_referenceContext parameterized_matrix_reference() {
			return getRuleContext(Parameterized_matrix_referenceContext.class,0);
		}
		public Parameterized_referenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterized_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterParameterized_reference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitParameterized_reference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitParameterized_reference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameterized_referenceContext parameterized_reference() throws RecognitionException {
		Parameterized_referenceContext _localctx = new Parameterized_referenceContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_parameterized_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(275);
				parameterized_attr_reference();
				}
				break;
			case 2:
				{
				setState(276);
				parameterized_matrix_reference();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReferenceContext extends ParserRuleContext {
		public Normal_referenceContext normal_reference() {
			return getRuleContext(Normal_referenceContext.class,0);
		}
		public Parameterized_referenceContext parameterized_reference() {
			return getRuleContext(Parameterized_referenceContext.class,0);
		}
		public ReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_reference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReferenceContext reference() throws RecognitionException {
		ReferenceContext _localctx = new ReferenceContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(279);
				normal_reference();
				}
				break;
			case 2:
				{
				setState(280);
				parameterized_reference();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SMLParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SMLParser.FLOAT, 0); }
		public TerminalNode KEYWORD_INF() { return getToken(SMLParser.KEYWORD_INF, 0); }
		public TerminalNode SIGN() { return getToken(SMLParser.SIGN, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIGN) {
				{
				setState(283);
				match(SIGN);
				}
			}

			setState(286);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD_INF) | (1L << INT) | (1L << FLOAT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WordContext extends ParserRuleContext {
		public List<TerminalNode> SYMBOL_QUOTE() { return getTokens(SMLParser.SYMBOL_QUOTE); }
		public TerminalNode SYMBOL_QUOTE(int i) {
			return getToken(SMLParser.SYMBOL_QUOTE, i);
		}
		public List<TerminalNode> SYMBOL_REFERENCE() { return getTokens(SMLParser.SYMBOL_REFERENCE); }
		public TerminalNode SYMBOL_REFERENCE(int i) {
			return getToken(SMLParser.SYMBOL_REFERENCE, i);
		}
		public WordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_word; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterWord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitWord(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitWord(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WordContext word() throws RecognitionException {
		WordContext _localctx = new WordContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(SYMBOL_QUOTE);
			setState(290); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(289);
				_la = _input.LA(1);
				if ( _la <= 0 || ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << SYMBOL_REFERENCE) | (1L << SYMBOL_QUOTE))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(292); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STATE_DELIMITER) | (1L << STATE_ATTRIBUTES_DELIMITER) | (1L << STATE_START_DELIMITER) | (1L << STATE_GOAL_DELIMITER) | (1L << OPERATOR_DELIMITER) | (1L << OPERATOR_DESCRIPTION_DELIMITER) | (1L << OPERATOR_PRECONDITION_DELIMITER) | (1L << OPERATOR_EFFECT_DELIMITER) | (1L << KEYWORD_FOR) | (1L << KEYWORD_PARAM) | (1L << KEYWORD_FROM) | (1L << KEYWORD_TO) | (1L << KEYWORD_BY) | (1L << KEYWORD_TIMES) | (1L << KEYWORD_ATTRIBUTE) | (1L << KEYWORD_VAR) | (1L << KEYWORD_COST) | (1L << KEYWORD_NAME) | (1L << KEYWORD_IS) | (1L << KEYWORD_OF) | (1L << KEYWORD_SET) | (1L << KEYWORD_MATRIX) | (1L << KEYWORD_WORD) | (1L << KEYWORD_NUMBER) | (1L << KEYWORD_MINIMUM) | (1L << KEYWORD_MAXIMUM) | (1L << KEYWORD_SUM) | (1L << KEYWORD_AVERAGE) | (1L << KEYWORD_UNION) | (1L << KEYWORD_INTERSECT) | (1L << KEYWORD_DIFFERENCE) | (1L << KEYWORD_ADD) | (1L << KEYWORD_REMOVE) | (1L << KEYWORD_CARDINALITY) | (1L << KEYWORD_AND) | (1L << KEYWORD_OR) | (1L << KEYWORD_NOT) | (1L << KEYWORD_INF) | (1L << SYMBOL_EQUAL) | (1L << SYMBOL_NOT_EQUAL) | (1L << SYMBOL_LESSER) | (1L << SYMBOL_GREATER) | (1L << SYMBOL_LESSER_OR_EQUAL) | (1L << SYMBOL_GREATER_OR_EQUAL) | (1L << SYMBOL_ADDITION) | (1L << SYMBOL_SUBSTRACT) | (1L << SYMBOL_MULTIPLICATION) | (1L << SYMBOL_DIVISION) | (1L << SYMBOL_ASSIGN) | (1L << SYMBOL_COMMA) | (1L << SYMBOL_SINGLE_QOUTE) | (1L << SYMBOL_LPAREN) | (1L << SYMBOL_RPAREN) | (1L << SYMBOL_LBRACE) | (1L << SYMBOL_RBRACE) | (1L << SYMBOL_LBRACK) | (1L << SYMOBL_RBRACK) | (1L << INT) | (1L << FLOAT) | (1L << SIGN))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (PARAM_NAME - 64)) | (1L << (CHAR - 64)) | (1L << (WS - 64)))) != 0) );
			setState(294);
			match(SYMBOL_QUOTE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 17:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3D\u012b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\3\2\3\2\5\2E\n\2\3\2\3\2\3\2\6\2J\n\2\r\2\16\2K\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\4\3\4\6\4V\n\4\r\4\16\4W\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\7\6"+
		"b\n\6\f\6\16\6e\13\6\3\7\3\7\6\7i\n\7\r\7\16\7j\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\5\ts\n\t\3\t\5\tv\n\t\3\t\7\ty\n\t\f\t\16\t|\13\t\3\n\3\n\3\n\3\13"+
		"\3\13\7\13\u0083\n\13\f\13\16\13\u0086\13\13\3\f\3\f\6\f\u008a\n\f\r\f"+
		"\16\f\u008b\3\r\3\r\3\r\5\r\u0091\n\r\3\16\3\16\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\5\23\u00ac\n\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\7\23\u00b4\n\23\f\23\16\23\u00b7\13\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\6\23\u00c2\n\23\r\23\16\23\u00c3\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00d2\n\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00e0\n\23\f\23\16"+
		"\23\u00e3\13\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u00f0\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00fa\n"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\5\35\u0114\n\35"+
		"\3\36\3\36\5\36\u0118\n\36\3\37\3\37\5\37\u011c\n\37\3 \5 \u011f\n \3"+
		" \3 \3!\3!\6!\u0125\n!\r!\16!\u0126\3!\3!\3!\2\3$\"\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@\2\t\3\2\32\33\3\2*/\3"+
		"\2\60\63\4\2\34 #%\3\2&\'\4\2))?@\5\2\3\3\65\65\67\67\u012c\2B\3\2\2\2"+
		"\4O\3\2\2\2\6S\3\2\2\2\bY\3\2\2\2\n_\3\2\2\2\ff\3\2\2\2\16l\3\2\2\2\20"+
		"p\3\2\2\2\22}\3\2\2\2\24\u0080\3\2\2\2\26\u0087\3\2\2\2\30\u0090\3\2\2"+
		"\2\32\u0092\3\2\2\2\34\u0094\3\2\2\2\36\u0096\3\2\2\2 \u0098\3\2\2\2\""+
		"\u009a\3\2\2\2$\u00d1\3\2\2\2&\u00e4\3\2\2\2(\u00e7\3\2\2\2*\u00f1\3\2"+
		"\2\2,\u00fb\3\2\2\2.\u00fe\3\2\2\2\60\u0101\3\2\2\2\62\u0104\3\2\2\2\64"+
		"\u0107\3\2\2\2\66\u010a\3\2\2\28\u0113\3\2\2\2:\u0117\3\2\2\2<\u011b\3"+
		"\2\2\2>\u011e\3\2\2\2@\u0122\3\2\2\2BD\7\4\2\2CE\5&\24\2DC\3\2\2\2DE\3"+
		"\2\2\2EF\3\2\2\2FG\5\4\3\2GI\7\b\2\2HJ\5\16\b\2IH\3\2\2\2JK\3\2\2\2KI"+
		"\3\2\2\2KL\3\2\2\2LM\3\2\2\2MN\7\2\2\3N\3\3\2\2\2OP\5\6\4\2PQ\5\n\6\2"+
		"QR\5\f\7\2R\5\3\2\2\2SU\7\5\2\2TV\5\b\5\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2"+
		"\2WX\3\2\2\2X\7\3\2\2\2YZ\5,\27\2Z[\7\26\2\2[\\\5\30\r\2\\]\7\27\2\2]"+
		"^\5\32\16\2^\t\3\2\2\2_c\7\6\2\2`b\5$\23\2a`\3\2\2\2be\3\2\2\2ca\3\2\2"+
		"\2cd\3\2\2\2d\13\3\2\2\2ec\3\2\2\2fh\7\7\2\2gi\5$\23\2hg\3\2\2\2ij\3\2"+
		"\2\2jh\3\2\2\2jk\3\2\2\2k\r\3\2\2\2lm\5\20\t\2mn\5\24\13\2no\5\26\f\2"+
		"o\17\3\2\2\2pr\7\t\2\2qs\5&\24\2rq\3\2\2\2rs\3\2\2\2su\3\2\2\2tv\5\22"+
		"\n\2ut\3\2\2\2uv\3\2\2\2vz\3\2\2\2wy\5(\25\2xw\3\2\2\2y|\3\2\2\2zx\3\2"+
		"\2\2z{\3\2\2\2{\21\3\2\2\2|z\3\2\2\2}~\7\24\2\2~\177\5> \2\177\23\3\2"+
		"\2\2\u0080\u0084\7\n\2\2\u0081\u0083\5$\23\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\25\3\2\2"+
		"\2\u0086\u0084\3\2\2\2\u0087\u0089\7\13\2\2\u0088\u008a\5$\23\2\u0089"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2"+
		"\2\2\u008c\27\3\2\2\2\u008d\u0091\7\30\2\2\u008e\u008f\7\31\2\2\u008f"+
		"\u0091\5\66\34\2\u0090\u008d\3\2\2\2\u0090\u008e\3\2\2\2\u0091\31\3\2"+
		"\2\2\u0092\u0093\t\2\2\2\u0093\33\3\2\2\2\u0094\u0095\t\3\2\2\u0095\35"+
		"\3\2\2\2\u0096\u0097\t\4\2\2\u0097\37\3\2\2\2\u0098\u0099\t\5\2\2\u0099"+
		"!\3\2\2\2\u009a\u009b\t\6\2\2\u009b#\3\2\2\2\u009c\u009d\b\23\1\2\u009d"+
		"\u009e\79\2\2\u009e\u009f\5$\23\2\u009f\u00a0\7:\2\2\u00a0\u00d2\3\2\2"+
		"\2\u00a1\u00a2\5 \21\2\u00a2\u00a3\79\2\2\u00a3\u00a4\5$\23\2\u00a4\u00a5"+
		"\7:\2\2\u00a5\u00d2\3\2\2\2\u00a6\u00a7\5 \21\2\u00a7\u00a8\79\2\2\u00a8"+
		"\u00ab\5$\23\2\u00a9\u00aa\7\66\2\2\u00aa\u00ac\5$\23\2\u00ab\u00a9\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7:\2\2\u00ae"+
		"\u00d2\3\2\2\2\u00af\u00b0\7;\2\2\u00b0\u00b5\5$\23\2\u00b1\u00b2\7\66"+
		"\2\2\u00b2\u00b4\5$\23\2\u00b3\u00b1\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b8\3\2\2\2\u00b7\u00b5\3\2"+
		"\2\2\u00b8\u00b9\7<\2\2\u00b9\u00d2\3\2\2\2\u00ba\u00bb\5<\37\2\u00bb"+
		"\u00bc\7\64\2\2\u00bc\u00bd\5$\23\t\u00bd\u00d2\3\2\2\2\u00be\u00bf\5"+
		"*\26\2\u00bf\u00c1\7;\2\2\u00c0\u00c2\5$\23\2\u00c1\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\u00c6\7<\2\2\u00c6\u00d2\3\2\2\2\u00c7\u00c8\7\23\2\2\u00c8"+
		"\u00c9\5\32\16\2\u00c9\u00ca\7B\2\2\u00ca\u00cb\7\64\2\2\u00cb\u00cc\5"+
		"$\23\7\u00cc\u00d2\3\2\2\2\u00cd\u00d2\5<\37\2\u00ce\u00d2\5@!\2\u00cf"+
		"\u00d2\5> \2\u00d0\u00d2\7B\2\2\u00d1\u009c\3\2\2\2\u00d1\u00a1\3\2\2"+
		"\2\u00d1\u00a6\3\2\2\2\u00d1\u00af\3\2\2\2\u00d1\u00ba\3\2\2\2\u00d1\u00be"+
		"\3\2\2\2\u00d1\u00c7\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d1"+
		"\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00e1\3\2\2\2\u00d3\u00d4\f\17"+
		"\2\2\u00d4\u00d5\5\34\17\2\u00d5\u00d6\5$\23\20\u00d6\u00e0\3\2\2\2\u00d7"+
		"\u00d8\f\16\2\2\u00d8\u00d9\5\"\22\2\u00d9\u00da\5$\23\17\u00da\u00e0"+
		"\3\2\2\2\u00db\u00dc\f\r\2\2\u00dc\u00dd\5\36\20\2\u00dd\u00de\5$\23\16"+
		"\u00de\u00e0\3\2\2\2\u00df\u00d3\3\2\2\2\u00df\u00d7\3\2\2\2\u00df\u00db"+
		"\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2"+
		"%\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7\25\2\2\u00e5\u00e6\7B\2\2"+
		"\u00e6\'\3\2\2\2\u00e7\u00e8\7\r\2\2\u00e8\u00e9\7B\2\2\u00e9\u00ea\7"+
		"\16\2\2\u00ea\u00eb\7?\2\2\u00eb\u00ec\7\17\2\2\u00ec\u00ef\7?\2\2\u00ed"+
		"\u00ee\7\20\2\2\u00ee\u00f0\7?\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0)\3\2\2\2\u00f1\u00f2\7\f\2\2\u00f2\u00f3\7B\2\2\u00f3\u00f4"+
		"\7\16\2\2\u00f4\u00f5\5$\23\2\u00f5\u00f6\7\17\2\2\u00f6\u00f9\5$\23\2"+
		"\u00f7\u00f8\7\20\2\2\u00f8\u00fa\5$\23\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa+\3\2\2\2\u00fb\u00fc\7\22\2\2\u00fc\u00fd\7?\2\2\u00fd"+
		"-\3\2\2\2\u00fe\u00ff\7\65\2\2\u00ff\u0100\7?\2\2\u0100/\3\2\2\2\u0101"+
		"\u0102\7\65\2\2\u0102\u0103\7B\2\2\u0103\61\3\2\2\2\u0104\u0105\5.\30"+
		"\2\u0105\u0106\5\66\34\2\u0106\63\3\2\2\2\u0107\u0108\5\60\31\2\u0108"+
		"\u0109\5\66\34\2\u0109\65\3\2\2\2\u010a\u010b\7=\2\2\u010b\u010c\5$\23"+
		"\2\u010c\u010d\7>\2\2\u010d\u010e\7=\2\2\u010e\u010f\5$\23\2\u010f\u0110"+
		"\7>\2\2\u0110\67\3\2\2\2\u0111\u0114\5.\30\2\u0112\u0114\5\62\32\2\u0113"+
		"\u0111\3\2\2\2\u0113\u0112\3\2\2\2\u01149\3\2\2\2\u0115\u0118\5\60\31"+
		"\2\u0116\u0118\5\64\33\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0118"+
		";\3\2\2\2\u0119\u011c\58\35\2\u011a\u011c\5:\36\2\u011b\u0119\3\2\2\2"+
		"\u011b\u011a\3\2\2\2\u011c=\3\2\2\2\u011d\u011f\7A\2\2\u011e\u011d\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0121\t\7\2\2\u0121"+
		"?\3\2\2\2\u0122\u0124\7\67\2\2\u0123\u0125\n\b\2\2\u0124\u0123\3\2\2\2"+
		"\u0125\u0126\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128\u0129\7\67\2\2\u0129A\3\2\2\2\32DKWcjruz\u0084\u008b\u0090"+
		"\u00ab\u00b5\u00c3\u00d1\u00df\u00e1\u00ef\u00f9\u0113\u0117\u011b\u011e"+
		"\u0126";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}