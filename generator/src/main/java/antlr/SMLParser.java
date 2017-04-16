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
		T__0=1, COMMENT=2, STATE_DELIMITER=3, STATE_ATTRIBUTES_DELIMITER=4, STATE_START_DELIMITER=5, 
		STATE_GOAL_DELIMITER=6, OPERATOR_DELIMITER=7, OPERATOR_DESCRIPTION_DELIMITER=8, 
		OPERATOR_PRECONDITION_DELIMITER=9, OPERATOR_EFFECT_DELIMITER=10, KEYWORD_IF=11, 
		KEYWORD_ELSE=12, KEYWORD_FOR=13, KEYWORD_PARAM=14, KEYWORD_FROM=15, KEYWORD_TO=16, 
		KEYWORD_BY=17, KEYWORD_TIMES=18, KEYWORD_ATTRIBUTE=19, KEYWORD_VAR=20, 
		KEYWORD_COST=21, KEYWORD_IS=22, KEYWORD_OF=23, KEYWORD_SET=24, KEYWORD_MATRIX=25, 
		KEYWORD_WORD=26, KEYWORD_NUMBER=27, KEYWORD_MINIMUM=28, KEYWORD_MAXIMUM=29, 
		KEYWORD_SUM=30, KEYWORD_AVERAGE=31, KEYWORD_ABS=32, KEYWORD_UNION=33, 
		KEYWORD_INTERSECT=34, KEYWORD_DIFFERENCE=35, KEYWORD_ADD=36, KEYWORD_REMOVE=37, 
		KEYWORD_CARDINALITY=38, KEYWORD_CHAR_AT=39, KEYWORD_LENGTH=40, KEYWORD_AND=41, 
		KEYWORD_OR=42, KEYWORD_NOT=43, KEYWORD_INF=44, SYMBOL_EQUAL=45, SYMBOL_NOT_EQUAL=46, 
		SYMBOL_LESSER=47, SYMBOL_GREATER=48, SYMBOL_LESSER_OR_EQUAL=49, SYMBOL_GREATER_OR_EQUAL=50, 
		SYMBOL_ADDITION=51, SYMBOL_SUBSTRACT=52, SYMBOL_MULTIPLICATION=53, SYMBOL_DIVISION=54, 
		SYMBOL_POWER=55, SYMBOL_ASSIGN=56, SYMBOL_REFERENCE=57, SYMBOL_COMMA=58, 
		SYMBOL_QUOTE=59, SYMBOL_SINGLE_QOUTE=60, SYMBOL_LPAREN=61, SYMBOL_RPAREN=62, 
		SYMBOL_LBRACE=63, SYMBOL_RBRACE=64, SYMBOL_LBRACK=65, SYMOBL_RBRACK=66, 
		SYMBOL_COMMENT_START=67, SYMBOL_COMMENT_END=68, INT=69, FLOAT=70, PARAM_NAME=71, 
		WS=72;
	public static final int
		RULE_expr = 0, RULE_state_expr = 1, RULE_state_description = 2, RULE_state_description_line = 3, 
		RULE_state_start = 4, RULE_state_goal = 5, RULE_operator_expr = 6, RULE_operator_description = 7, 
		RULE_operator_cost = 8, RULE_operator_precondition = 9, RULE_operator_effect = 10, 
		RULE_attr_name = 11, RULE_attr_reference = 12, RULE_parameterized_attr_reference = 13, 
		RULE_matrix_reference = 14, RULE_parameterized_matrix_reference = 15, 
		RULE_dimension = 16, RULE_normal_reference = 17, RULE_parameterized_reference = 18, 
		RULE_reference = 19, RULE_attr_struct = 20, RULE_attr_type = 21, RULE_comparator = 22, 
		RULE_binary_operator = 23, RULE_unary_operator = 24, RULE_boolean_operator = 25, 
		RULE_expression = 26, RULE_parameter_description_line = 27, RULE_for_statement = 28, 
		RULE_if_statement = 29, RULE_else_statement = 30, RULE_number = 31, RULE_word = 32;
	public static final String[] ruleNames = {
		"expr", "state_expr", "state_description", "state_description_line", "state_start", 
		"state_goal", "operator_expr", "operator_description", "operator_cost", 
		"operator_precondition", "operator_effect", "attr_name", "attr_reference", 
		"parameterized_attr_reference", "matrix_reference", "parameterized_matrix_reference", 
		"dimension", "normal_reference", "parameterized_reference", "reference", 
		"attr_struct", "attr_type", "comparator", "binary_operator", "unary_operator", 
		"boolean_operator", "expression", "parameter_description_line", "for_statement", 
		"if_statement", "else_statement", "number", "word"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'\\'", null, "'STATE:'", "'STATE_ATTRIBUTES:'", "'STATE_START:'", 
		"'STATE_GOAL:'", "'OPERATORS:'", "'OPERATOR_DESCRIPTION:'", "'OPERATOR_PRECONDITION:'", 
		"'OPERATOR_EFFECT:'", "'if'", "'else'", "'for'", "'param'", "'from'", 
		"'to'", "'by'", "'times'", "'attr'", "'var'", "'cost'", "'is'", "'of'", 
		"'set'", "'matrix'", "'word'", "'number'", "'min'", "'max'", "'sum'", 
		"'avg'", "'abs'", "'union'", "'intersect'", "'difference'", "'add'", "'remove'", 
		"'card'", "'charAt'", "'length'", "'and'", "'or'", "'not'", "'inf'", "'=='", 
		"'!='", "'<'", "'>'", "'<='", "'>='", "'+'", "'-'", "'*'", "'/'", "'^'", 
		"'='", "'$'", "','", "'\"'", "'''", "'('", "')'", "'{'", "'}'", "'['", 
		"']'", "'/*'", "'*/'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "COMMENT", "STATE_DELIMITER", "STATE_ATTRIBUTES_DELIMITER", 
		"STATE_START_DELIMITER", "STATE_GOAL_DELIMITER", "OPERATOR_DELIMITER", 
		"OPERATOR_DESCRIPTION_DELIMITER", "OPERATOR_PRECONDITION_DELIMITER", "OPERATOR_EFFECT_DELIMITER", 
		"KEYWORD_IF", "KEYWORD_ELSE", "KEYWORD_FOR", "KEYWORD_PARAM", "KEYWORD_FROM", 
		"KEYWORD_TO", "KEYWORD_BY", "KEYWORD_TIMES", "KEYWORD_ATTRIBUTE", "KEYWORD_VAR", 
		"KEYWORD_COST", "KEYWORD_IS", "KEYWORD_OF", "KEYWORD_SET", "KEYWORD_MATRIX", 
		"KEYWORD_WORD", "KEYWORD_NUMBER", "KEYWORD_MINIMUM", "KEYWORD_MAXIMUM", 
		"KEYWORD_SUM", "KEYWORD_AVERAGE", "KEYWORD_ABS", "KEYWORD_UNION", "KEYWORD_INTERSECT", 
		"KEYWORD_DIFFERENCE", "KEYWORD_ADD", "KEYWORD_REMOVE", "KEYWORD_CARDINALITY", 
		"KEYWORD_CHAR_AT", "KEYWORD_LENGTH", "KEYWORD_AND", "KEYWORD_OR", "KEYWORD_NOT", 
		"KEYWORD_INF", "SYMBOL_EQUAL", "SYMBOL_NOT_EQUAL", "SYMBOL_LESSER", "SYMBOL_GREATER", 
		"SYMBOL_LESSER_OR_EQUAL", "SYMBOL_GREATER_OR_EQUAL", "SYMBOL_ADDITION", 
		"SYMBOL_SUBSTRACT", "SYMBOL_MULTIPLICATION", "SYMBOL_DIVISION", "SYMBOL_POWER", 
		"SYMBOL_ASSIGN", "SYMBOL_REFERENCE", "SYMBOL_COMMA", "SYMBOL_QUOTE", "SYMBOL_SINGLE_QOUTE", 
		"SYMBOL_LPAREN", "SYMBOL_RPAREN", "SYMBOL_LBRACE", "SYMBOL_RBRACE", "SYMBOL_LBRACK", 
		"SYMOBL_RBRACK", "SYMBOL_COMMENT_START", "SYMBOL_COMMENT_END", "INT", 
		"FLOAT", "PARAM_NAME", "WS"
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
			setState(66);
			match(STATE_DELIMITER);
			setState(67);
			state_expr();
			setState(68);
			match(OPERATOR_DELIMITER);
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				operator_expr();
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OPERATOR_DESCRIPTION_DELIMITER );
			setState(74);
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
			setState(76);
			state_description();
			setState(77);
			state_start();
			setState(78);
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
			setState(80);
			match(STATE_ATTRIBUTES_DELIMITER);
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(81);
				state_description_line();
				}
				}
				setState(84); 
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
		public Attr_typeContext attr_type() {
			return getRuleContext(Attr_typeContext.class,0);
		}
		public Attr_structContext attr_struct() {
			return getRuleContext(Attr_structContext.class,0);
		}
		public TerminalNode KEYWORD_OF() { return getToken(SMLParser.KEYWORD_OF, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			attr_name();
			setState(87);
			match(KEYWORD_IS);
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_SET || _la==KEYWORD_MATRIX) {
				{
				setState(88);
				attr_struct();
				setState(89);
				match(KEYWORD_OF);
				}
			}

			setState(93);
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
			setState(95);
			match(STATE_START_DELIMITER);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (KEYWORD_IF - 11)) | (1L << (KEYWORD_FOR - 11)) | (1L << (KEYWORD_VAR - 11)) | (1L << (KEYWORD_MINIMUM - 11)) | (1L << (KEYWORD_MAXIMUM - 11)) | (1L << (KEYWORD_SUM - 11)) | (1L << (KEYWORD_AVERAGE - 11)) | (1L << (KEYWORD_ABS - 11)) | (1L << (KEYWORD_UNION - 11)) | (1L << (KEYWORD_ADD - 11)) | (1L << (KEYWORD_REMOVE - 11)) | (1L << (KEYWORD_CARDINALITY - 11)) | (1L << (KEYWORD_CHAR_AT - 11)) | (1L << (KEYWORD_LENGTH - 11)) | (1L << (KEYWORD_INF - 11)) | (1L << (SYMBOL_ADDITION - 11)) | (1L << (SYMBOL_SUBSTRACT - 11)) | (1L << (SYMBOL_REFERENCE - 11)) | (1L << (SYMBOL_QUOTE - 11)) | (1L << (SYMBOL_LPAREN - 11)) | (1L << (SYMBOL_LBRACE - 11)) | (1L << (INT - 11)) | (1L << (FLOAT - 11)) | (1L << (PARAM_NAME - 11)))) != 0)) {
				{
				{
				setState(96);
				expression(0);
				}
				}
				setState(101);
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
			setState(102);
			match(STATE_GOAL_DELIMITER);
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				expression(0);
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (KEYWORD_IF - 11)) | (1L << (KEYWORD_FOR - 11)) | (1L << (KEYWORD_VAR - 11)) | (1L << (KEYWORD_MINIMUM - 11)) | (1L << (KEYWORD_MAXIMUM - 11)) | (1L << (KEYWORD_SUM - 11)) | (1L << (KEYWORD_AVERAGE - 11)) | (1L << (KEYWORD_ABS - 11)) | (1L << (KEYWORD_UNION - 11)) | (1L << (KEYWORD_ADD - 11)) | (1L << (KEYWORD_REMOVE - 11)) | (1L << (KEYWORD_CARDINALITY - 11)) | (1L << (KEYWORD_CHAR_AT - 11)) | (1L << (KEYWORD_LENGTH - 11)) | (1L << (KEYWORD_INF - 11)) | (1L << (SYMBOL_ADDITION - 11)) | (1L << (SYMBOL_SUBSTRACT - 11)) | (1L << (SYMBOL_REFERENCE - 11)) | (1L << (SYMBOL_QUOTE - 11)) | (1L << (SYMBOL_LPAREN - 11)) | (1L << (SYMBOL_LBRACE - 11)) | (1L << (INT - 11)) | (1L << (FLOAT - 11)) | (1L << (PARAM_NAME - 11)))) != 0) );
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
			setState(108);
			operator_description();
			setState(109);
			operator_precondition();
			setState(110);
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
			setState(112);
			match(OPERATOR_DESCRIPTION_DELIMITER);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_COST) {
				{
				setState(113);
				operator_cost();
				}
			}

			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KEYWORD_PARAM) {
				{
				{
				setState(116);
				parameter_description_line();
				}
				}
				setState(121);
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
			setState(122);
			match(KEYWORD_COST);
			setState(123);
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
			setState(125);
			match(OPERATOR_PRECONDITION_DELIMITER);
			setState(129);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (KEYWORD_IF - 11)) | (1L << (KEYWORD_FOR - 11)) | (1L << (KEYWORD_VAR - 11)) | (1L << (KEYWORD_MINIMUM - 11)) | (1L << (KEYWORD_MAXIMUM - 11)) | (1L << (KEYWORD_SUM - 11)) | (1L << (KEYWORD_AVERAGE - 11)) | (1L << (KEYWORD_ABS - 11)) | (1L << (KEYWORD_UNION - 11)) | (1L << (KEYWORD_ADD - 11)) | (1L << (KEYWORD_REMOVE - 11)) | (1L << (KEYWORD_CARDINALITY - 11)) | (1L << (KEYWORD_CHAR_AT - 11)) | (1L << (KEYWORD_LENGTH - 11)) | (1L << (KEYWORD_INF - 11)) | (1L << (SYMBOL_ADDITION - 11)) | (1L << (SYMBOL_SUBSTRACT - 11)) | (1L << (SYMBOL_REFERENCE - 11)) | (1L << (SYMBOL_QUOTE - 11)) | (1L << (SYMBOL_LPAREN - 11)) | (1L << (SYMBOL_LBRACE - 11)) | (1L << (INT - 11)) | (1L << (FLOAT - 11)) | (1L << (PARAM_NAME - 11)))) != 0)) {
				{
				{
				setState(126);
				expression(0);
				}
				}
				setState(131);
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
			setState(132);
			match(OPERATOR_EFFECT_DELIMITER);
			setState(134); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				expression(0);
				}
				}
				setState(136); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (KEYWORD_IF - 11)) | (1L << (KEYWORD_FOR - 11)) | (1L << (KEYWORD_VAR - 11)) | (1L << (KEYWORD_MINIMUM - 11)) | (1L << (KEYWORD_MAXIMUM - 11)) | (1L << (KEYWORD_SUM - 11)) | (1L << (KEYWORD_AVERAGE - 11)) | (1L << (KEYWORD_ABS - 11)) | (1L << (KEYWORD_UNION - 11)) | (1L << (KEYWORD_ADD - 11)) | (1L << (KEYWORD_REMOVE - 11)) | (1L << (KEYWORD_CARDINALITY - 11)) | (1L << (KEYWORD_CHAR_AT - 11)) | (1L << (KEYWORD_LENGTH - 11)) | (1L << (KEYWORD_INF - 11)) | (1L << (SYMBOL_ADDITION - 11)) | (1L << (SYMBOL_SUBSTRACT - 11)) | (1L << (SYMBOL_REFERENCE - 11)) | (1L << (SYMBOL_QUOTE - 11)) | (1L << (SYMBOL_LPAREN - 11)) | (1L << (SYMBOL_LBRACE - 11)) | (1L << (INT - 11)) | (1L << (FLOAT - 11)) | (1L << (PARAM_NAME - 11)))) != 0) );
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
		enterRule(_localctx, 22, RULE_attr_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(KEYWORD_ATTRIBUTE);
			setState(139);
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
		enterRule(_localctx, 24, RULE_attr_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(SYMBOL_REFERENCE);
			setState(142);
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
		enterRule(_localctx, 26, RULE_parameterized_attr_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(SYMBOL_REFERENCE);
			setState(145);
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
		enterRule(_localctx, 28, RULE_matrix_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			attr_reference();
			setState(148);
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
		enterRule(_localctx, 30, RULE_parameterized_matrix_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			parameterized_attr_reference();
			setState(151);
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
		enterRule(_localctx, 32, RULE_dimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(SYMBOL_LBRACK);
			setState(154);
			((DimensionContext)_localctx).dimensionN = expression(0);
			setState(155);
			match(SYMOBL_RBRACK);
			setState(156);
			match(SYMBOL_LBRACK);
			setState(157);
			((DimensionContext)_localctx).dimensionM = expression(0);
			setState(158);
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
		enterRule(_localctx, 34, RULE_normal_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(160);
				attr_reference();
				}
				break;
			case 2:
				{
				setState(161);
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
		enterRule(_localctx, 36, RULE_parameterized_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(164);
				parameterized_attr_reference();
				}
				break;
			case 2:
				{
				setState(165);
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
		enterRule(_localctx, 38, RULE_reference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(168);
				normal_reference();
				}
				break;
			case 2:
				{
				setState(169);
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
		enterRule(_localctx, 40, RULE_attr_struct);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD_SET:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(KEYWORD_SET);
				}
				break;
			case KEYWORD_MATRIX:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(173);
				match(KEYWORD_MATRIX);
				setState(174);
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
		enterRule(_localctx, 42, RULE_attr_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
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
		enterRule(_localctx, 44, RULE_comparator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
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
		public TerminalNode SYMBOL_POWER() { return getToken(SMLParser.SYMBOL_POWER, 0); }
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
		enterRule(_localctx, 46, RULE_binary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SYMBOL_ADDITION) | (1L << SYMBOL_SUBSTRACT) | (1L << SYMBOL_MULTIPLICATION) | (1L << SYMBOL_DIVISION) | (1L << SYMBOL_POWER))) != 0)) ) {
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
		public TerminalNode KEYWORD_ABS() { return getToken(SMLParser.KEYWORD_ABS, 0); }
		public TerminalNode KEYWORD_CARDINALITY() { return getToken(SMLParser.KEYWORD_CARDINALITY, 0); }
		public TerminalNode KEYWORD_UNION() { return getToken(SMLParser.KEYWORD_UNION, 0); }
		public TerminalNode KEYWORD_ADD() { return getToken(SMLParser.KEYWORD_ADD, 0); }
		public TerminalNode KEYWORD_REMOVE() { return getToken(SMLParser.KEYWORD_REMOVE, 0); }
		public TerminalNode KEYWORD_SUM() { return getToken(SMLParser.KEYWORD_SUM, 0); }
		public TerminalNode KEYWORD_LENGTH() { return getToken(SMLParser.KEYWORD_LENGTH, 0); }
		public TerminalNode KEYWORD_CHAR_AT() { return getToken(SMLParser.KEYWORD_CHAR_AT, 0); }
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
		enterRule(_localctx, 48, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD_MINIMUM) | (1L << KEYWORD_MAXIMUM) | (1L << KEYWORD_SUM) | (1L << KEYWORD_AVERAGE) | (1L << KEYWORD_ABS) | (1L << KEYWORD_UNION) | (1L << KEYWORD_ADD) | (1L << KEYWORD_REMOVE) | (1L << KEYWORD_CARDINALITY) | (1L << KEYWORD_CHAR_AT) | (1L << KEYWORD_LENGTH))) != 0)) ) {
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
		enterRule(_localctx, 50, RULE_boolean_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
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
	public static class Unary_exprContext extends ExpressionContext {
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
		public Unary_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterUnary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitUnary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitUnary_expr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class If_exprContext extends ExpressionContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public TerminalNode SYMBOL_LBRACE() { return getToken(SMLParser.SYMBOL_LBRACE, 0); }
		public TerminalNode SYMBOL_RBRACE() { return getToken(SMLParser.SYMBOL_RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
		public If_exprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterIf_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitIf_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitIf_expr(this);
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
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(188);
				match(SYMBOL_LPAREN);
				setState(189);
				expression(0);
				setState(190);
				match(SYMBOL_RPAREN);
				}
				break;
			case 2:
				{
				_localctx = new Unary_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				unary_operator();
				setState(193);
				match(SYMBOL_LPAREN);
				setState(194);
				((Unary_exprContext)_localctx).left = expression(0);
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SYMBOL_COMMA) {
					{
					setState(195);
					match(SYMBOL_COMMA);
					setState(196);
					((Unary_exprContext)_localctx).right = expression(0);
					}
				}

				setState(199);
				match(SYMBOL_RPAREN);
				}
				break;
			case 3:
				{
				_localctx = new Set_init_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(SYMBOL_LBRACE);
				{
				setState(202);
				expression(0);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==SYMBOL_COMMA) {
					{
					{
					setState(203);
					match(SYMBOL_COMMA);
					setState(204);
					expression(0);
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				setState(210);
				match(SYMBOL_RBRACE);
				}
				break;
			case 4:
				{
				_localctx = new Assign_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212);
				reference();
				setState(213);
				match(SYMBOL_ASSIGN);
				setState(214);
				expression(8);
				}
				break;
			case 5:
				{
				_localctx = new For_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216);
				for_statement();
				setState(217);
				match(SYMBOL_LBRACE);
				setState(219); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(218);
					expression(0);
					}
					}
					setState(221); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (KEYWORD_IF - 11)) | (1L << (KEYWORD_FOR - 11)) | (1L << (KEYWORD_VAR - 11)) | (1L << (KEYWORD_MINIMUM - 11)) | (1L << (KEYWORD_MAXIMUM - 11)) | (1L << (KEYWORD_SUM - 11)) | (1L << (KEYWORD_AVERAGE - 11)) | (1L << (KEYWORD_ABS - 11)) | (1L << (KEYWORD_UNION - 11)) | (1L << (KEYWORD_ADD - 11)) | (1L << (KEYWORD_REMOVE - 11)) | (1L << (KEYWORD_CARDINALITY - 11)) | (1L << (KEYWORD_CHAR_AT - 11)) | (1L << (KEYWORD_LENGTH - 11)) | (1L << (KEYWORD_INF - 11)) | (1L << (SYMBOL_ADDITION - 11)) | (1L << (SYMBOL_SUBSTRACT - 11)) | (1L << (SYMBOL_REFERENCE - 11)) | (1L << (SYMBOL_QUOTE - 11)) | (1L << (SYMBOL_LPAREN - 11)) | (1L << (SYMBOL_LBRACE - 11)) | (1L << (INT - 11)) | (1L << (FLOAT - 11)) | (1L << (PARAM_NAME - 11)))) != 0) );
				setState(223);
				match(SYMBOL_RBRACE);
				}
				break;
			case 6:
				{
				_localctx = new If_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				if_statement();
				setState(226);
				match(SYMBOL_LBRACE);
				setState(228); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(227);
					expression(0);
					}
					}
					setState(230); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (KEYWORD_IF - 11)) | (1L << (KEYWORD_FOR - 11)) | (1L << (KEYWORD_VAR - 11)) | (1L << (KEYWORD_MINIMUM - 11)) | (1L << (KEYWORD_MAXIMUM - 11)) | (1L << (KEYWORD_SUM - 11)) | (1L << (KEYWORD_AVERAGE - 11)) | (1L << (KEYWORD_ABS - 11)) | (1L << (KEYWORD_UNION - 11)) | (1L << (KEYWORD_ADD - 11)) | (1L << (KEYWORD_REMOVE - 11)) | (1L << (KEYWORD_CARDINALITY - 11)) | (1L << (KEYWORD_CHAR_AT - 11)) | (1L << (KEYWORD_LENGTH - 11)) | (1L << (KEYWORD_INF - 11)) | (1L << (SYMBOL_ADDITION - 11)) | (1L << (SYMBOL_SUBSTRACT - 11)) | (1L << (SYMBOL_REFERENCE - 11)) | (1L << (SYMBOL_QUOTE - 11)) | (1L << (SYMBOL_LPAREN - 11)) | (1L << (SYMBOL_LBRACE - 11)) | (1L << (INT - 11)) | (1L << (FLOAT - 11)) | (1L << (PARAM_NAME - 11)))) != 0) );
				setState(232);
				match(SYMBOL_RBRACE);
				setState(234);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(233);
					else_statement();
					}
					break;
				}
				}
				break;
			case 7:
				{
				_localctx = new Var_defining_expressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(236);
				match(KEYWORD_VAR);
				setState(237);
				attr_type();
				setState(238);
				match(PARAM_NAME);
				setState(239);
				match(SYMBOL_ASSIGN);
				setState(240);
				expression(5);
				}
				break;
			case 8:
				{
				_localctx = new Reference_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				reference();
				}
				break;
			case 9:
				{
				_localctx = new Word_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(243);
				word();
				}
				break;
			case 10:
				{
				_localctx = new Number_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(244);
				number();
				}
				break;
			case 11:
				{
				_localctx = new Param_name_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245);
				match(PARAM_NAME);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(262);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(260);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new Compare_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Compare_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(248);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(249);
						comparator();
						setState(250);
						((Compare_exprContext)_localctx).right = expression(14);
						}
						break;
					case 2:
						{
						_localctx = new Bool_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Bool_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(252);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(253);
						boolean_operator();
						setState(254);
						((Bool_exprContext)_localctx).right = expression(13);
						}
						break;
					case 3:
						{
						_localctx = new Binary_exprContext(new ExpressionContext(_parentctx, _parentState));
						((Binary_exprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(256);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(257);
						binary_operator();
						setState(258);
						((Binary_exprContext)_localctx).right = expression(12);
						}
						break;
					}
					} 
				}
				setState(264);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
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
		enterRule(_localctx, 54, RULE_parameter_description_line);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(KEYWORD_PARAM);
			setState(266);
			match(PARAM_NAME);
			setState(267);
			match(KEYWORD_FROM);
			setState(268);
			match(INT);
			setState(269);
			match(KEYWORD_TO);
			setState(270);
			match(INT);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_BY) {
				{
				setState(271);
				match(KEYWORD_BY);
				setState(272);
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
		enterRule(_localctx, 56, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(KEYWORD_FOR);
			setState(276);
			((For_statementContext)_localctx).variable = match(PARAM_NAME);
			setState(277);
			match(KEYWORD_FROM);
			setState(278);
			((For_statementContext)_localctx).from = expression(0);
			setState(279);
			match(KEYWORD_TO);
			setState(280);
			((For_statementContext)_localctx).to = expression(0);
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KEYWORD_BY) {
				{
				setState(281);
				match(KEYWORD_BY);
				setState(282);
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

	public static class If_statementContext extends ParserRuleContext {
		public ExpressionContext condition;
		public TerminalNode KEYWORD_IF() { return getToken(SMLParser.KEYWORD_IF, 0); }
		public TerminalNode SYMBOL_LPAREN() { return getToken(SMLParser.SYMBOL_LPAREN, 0); }
		public TerminalNode SYMBOL_RPAREN() { return getToken(SMLParser.SYMBOL_RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(KEYWORD_IF);
			setState(286);
			match(SYMBOL_LPAREN);
			setState(287);
			((If_statementContext)_localctx).condition = expression(0);
			setState(288);
			match(SYMBOL_RPAREN);
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

	public static class Else_statementContext extends ParserRuleContext {
		public TerminalNode KEYWORD_ELSE() { return getToken(SMLParser.KEYWORD_ELSE, 0); }
		public TerminalNode SYMBOL_LBRACE() { return getToken(SMLParser.SYMBOL_LBRACE, 0); }
		public TerminalNode SYMBOL_RBRACE() { return getToken(SMLParser.SYMBOL_RBRACE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SMLListener ) ((SMLListener)listener).exitElse_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SMLVisitor ) return ((SMLVisitor<? extends T>)visitor).visitElse_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_else_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(KEYWORD_ELSE);
			setState(291);
			match(SYMBOL_LBRACE);
			setState(293); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(292);
				expression(0);
				}
				}
				setState(295); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 11)) & ~0x3f) == 0 && ((1L << (_la - 11)) & ((1L << (KEYWORD_IF - 11)) | (1L << (KEYWORD_FOR - 11)) | (1L << (KEYWORD_VAR - 11)) | (1L << (KEYWORD_MINIMUM - 11)) | (1L << (KEYWORD_MAXIMUM - 11)) | (1L << (KEYWORD_SUM - 11)) | (1L << (KEYWORD_AVERAGE - 11)) | (1L << (KEYWORD_ABS - 11)) | (1L << (KEYWORD_UNION - 11)) | (1L << (KEYWORD_ADD - 11)) | (1L << (KEYWORD_REMOVE - 11)) | (1L << (KEYWORD_CARDINALITY - 11)) | (1L << (KEYWORD_CHAR_AT - 11)) | (1L << (KEYWORD_LENGTH - 11)) | (1L << (KEYWORD_INF - 11)) | (1L << (SYMBOL_ADDITION - 11)) | (1L << (SYMBOL_SUBSTRACT - 11)) | (1L << (SYMBOL_REFERENCE - 11)) | (1L << (SYMBOL_QUOTE - 11)) | (1L << (SYMBOL_LPAREN - 11)) | (1L << (SYMBOL_LBRACE - 11)) | (1L << (INT - 11)) | (1L << (FLOAT - 11)) | (1L << (PARAM_NAME - 11)))) != 0) );
			setState(297);
			match(SYMBOL_RBRACE);
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
		public TerminalNode SYMBOL_ADDITION() { return getToken(SMLParser.SYMBOL_ADDITION, 0); }
		public TerminalNode SYMBOL_SUBSTRACT() { return getToken(SMLParser.SYMBOL_SUBSTRACT, 0); }
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
		enterRule(_localctx, 62, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SYMBOL_ADDITION || _la==SYMBOL_SUBSTRACT) {
				{
				setState(299);
				_la = _input.LA(1);
				if ( !(_la==SYMBOL_ADDITION || _la==SYMBOL_SUBSTRACT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(302);
			_la = _input.LA(1);
			if ( !(((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & ((1L << (KEYWORD_INF - 44)) | (1L << (INT - 44)) | (1L << (FLOAT - 44)))) != 0)) ) {
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
		enterRule(_localctx, 64, RULE_word);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(SYMBOL_QUOTE);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << COMMENT) | (1L << STATE_DELIMITER) | (1L << STATE_ATTRIBUTES_DELIMITER) | (1L << STATE_START_DELIMITER) | (1L << STATE_GOAL_DELIMITER) | (1L << OPERATOR_DELIMITER) | (1L << OPERATOR_DESCRIPTION_DELIMITER) | (1L << OPERATOR_PRECONDITION_DELIMITER) | (1L << OPERATOR_EFFECT_DELIMITER) | (1L << KEYWORD_IF) | (1L << KEYWORD_ELSE) | (1L << KEYWORD_FOR) | (1L << KEYWORD_PARAM) | (1L << KEYWORD_FROM) | (1L << KEYWORD_TO) | (1L << KEYWORD_BY) | (1L << KEYWORD_TIMES) | (1L << KEYWORD_ATTRIBUTE) | (1L << KEYWORD_VAR) | (1L << KEYWORD_COST) | (1L << KEYWORD_IS) | (1L << KEYWORD_OF) | (1L << KEYWORD_SET) | (1L << KEYWORD_MATRIX) | (1L << KEYWORD_WORD) | (1L << KEYWORD_NUMBER) | (1L << KEYWORD_MINIMUM) | (1L << KEYWORD_MAXIMUM) | (1L << KEYWORD_SUM) | (1L << KEYWORD_AVERAGE) | (1L << KEYWORD_ABS) | (1L << KEYWORD_UNION) | (1L << KEYWORD_INTERSECT) | (1L << KEYWORD_DIFFERENCE) | (1L << KEYWORD_ADD) | (1L << KEYWORD_REMOVE) | (1L << KEYWORD_CARDINALITY) | (1L << KEYWORD_CHAR_AT) | (1L << KEYWORD_LENGTH) | (1L << KEYWORD_AND) | (1L << KEYWORD_OR) | (1L << KEYWORD_NOT) | (1L << KEYWORD_INF) | (1L << SYMBOL_EQUAL) | (1L << SYMBOL_NOT_EQUAL) | (1L << SYMBOL_LESSER) | (1L << SYMBOL_GREATER) | (1L << SYMBOL_LESSER_OR_EQUAL) | (1L << SYMBOL_GREATER_OR_EQUAL) | (1L << SYMBOL_ADDITION) | (1L << SYMBOL_SUBSTRACT) | (1L << SYMBOL_MULTIPLICATION) | (1L << SYMBOL_DIVISION) | (1L << SYMBOL_POWER) | (1L << SYMBOL_ASSIGN) | (1L << SYMBOL_COMMA) | (1L << SYMBOL_SINGLE_QOUTE) | (1L << SYMBOL_LPAREN) | (1L << SYMBOL_RPAREN) | (1L << SYMBOL_LBRACE))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (SYMBOL_RBRACE - 64)) | (1L << (SYMBOL_LBRACK - 64)) | (1L << (SYMOBL_RBRACK - 64)) | (1L << (SYMBOL_COMMENT_START - 64)) | (1L << (SYMBOL_COMMENT_END - 64)) | (1L << (INT - 64)) | (1L << (FLOAT - 64)) | (1L << (PARAM_NAME - 64)) | (1L << (WS - 64)))) != 0)) {
				{
				{
				setState(305);
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
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(311);
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
		case 26:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3J\u013c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\3\2\3\2\3\2\6\2I\n\2\r\2\16\2J\3\2\3\2\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\6\4U\n\4\r\4\16\4V\3\5\3\5\3\5\3\5\3\5\5\5^\n\5\3\5\3\5\3\6\3"+
		"\6\7\6d\n\6\f\6\16\6g\13\6\3\7\3\7\6\7k\n\7\r\7\16\7l\3\b\3\b\3\b\3\b"+
		"\3\t\3\t\5\tu\n\t\3\t\7\tx\n\t\f\t\16\t{\13\t\3\n\3\n\3\n\3\13\3\13\7"+
		"\13\u0082\n\13\f\13\16\13\u0085\13\13\3\f\3\f\6\f\u0089\n\f\r\f\16\f\u008a"+
		"\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\5\23\u00a5\n\23\3\24"+
		"\3\24\5\24\u00a9\n\24\3\25\3\25\5\25\u00ad\n\25\3\26\3\26\3\26\5\26\u00b2"+
		"\n\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00c8\n\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\7\34\u00d0\n\34\f\34\16\34\u00d3\13\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\6\34\u00de\n\34\r\34\16\34\u00df\3\34\3\34\3"+
		"\34\3\34\3\34\6\34\u00e7\n\34\r\34\16\34\u00e8\3\34\3\34\5\34\u00ed\n"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u00f9\n\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\7\34\u0107"+
		"\n\34\f\34\16\34\u010a\13\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5"+
		"\35\u0114\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u011e\n\36"+
		"\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \6 \u0128\n \r \16 \u0129\3 \3 \3!\5"+
		"!\u012f\n!\3!\3!\3\"\3\"\7\"\u0135\n\"\f\"\16\"\u0138\13\"\3\"\3\"\3\""+
		"\2\3\66#\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668"+
		":<>@B\2\n\3\2\34\35\3\2/\64\3\2\659\4\2\36#&*\3\2+,\3\2\65\66\4\2..GH"+
		"\5\2\3\3;;==\u013e\2D\3\2\2\2\4N\3\2\2\2\6R\3\2\2\2\bX\3\2\2\2\na\3\2"+
		"\2\2\fh\3\2\2\2\16n\3\2\2\2\20r\3\2\2\2\22|\3\2\2\2\24\177\3\2\2\2\26"+
		"\u0086\3\2\2\2\30\u008c\3\2\2\2\32\u008f\3\2\2\2\34\u0092\3\2\2\2\36\u0095"+
		"\3\2\2\2 \u0098\3\2\2\2\"\u009b\3\2\2\2$\u00a4\3\2\2\2&\u00a8\3\2\2\2"+
		"(\u00ac\3\2\2\2*\u00b1\3\2\2\2,\u00b3\3\2\2\2.\u00b5\3\2\2\2\60\u00b7"+
		"\3\2\2\2\62\u00b9\3\2\2\2\64\u00bb\3\2\2\2\66\u00f8\3\2\2\28\u010b\3\2"+
		"\2\2:\u0115\3\2\2\2<\u011f\3\2\2\2>\u0124\3\2\2\2@\u012e\3\2\2\2B\u0132"+
		"\3\2\2\2DE\7\5\2\2EF\5\4\3\2FH\7\t\2\2GI\5\16\b\2HG\3\2\2\2IJ\3\2\2\2"+
		"JH\3\2\2\2JK\3\2\2\2KL\3\2\2\2LM\7\2\2\3M\3\3\2\2\2NO\5\6\4\2OP\5\n\6"+
		"\2PQ\5\f\7\2Q\5\3\2\2\2RT\7\6\2\2SU\5\b\5\2TS\3\2\2\2UV\3\2\2\2VT\3\2"+
		"\2\2VW\3\2\2\2W\7\3\2\2\2XY\5\30\r\2Y]\7\30\2\2Z[\5*\26\2[\\\7\31\2\2"+
		"\\^\3\2\2\2]Z\3\2\2\2]^\3\2\2\2^_\3\2\2\2_`\5,\27\2`\t\3\2\2\2ae\7\7\2"+
		"\2bd\5\66\34\2cb\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\13\3\2\2\2ge\3"+
		"\2\2\2hj\7\b\2\2ik\5\66\34\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2\2m"+
		"\r\3\2\2\2no\5\20\t\2op\5\24\13\2pq\5\26\f\2q\17\3\2\2\2rt\7\n\2\2su\5"+
		"\22\n\2ts\3\2\2\2tu\3\2\2\2uy\3\2\2\2vx\58\35\2wv\3\2\2\2x{\3\2\2\2yw"+
		"\3\2\2\2yz\3\2\2\2z\21\3\2\2\2{y\3\2\2\2|}\7\27\2\2}~\5@!\2~\23\3\2\2"+
		"\2\177\u0083\7\13\2\2\u0080\u0082\5\66\34\2\u0081\u0080\3\2\2\2\u0082"+
		"\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\25\3\2\2"+
		"\2\u0085\u0083\3\2\2\2\u0086\u0088\7\f\2\2\u0087\u0089\5\66\34\2\u0088"+
		"\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2"+
		"\2\2\u008b\27\3\2\2\2\u008c\u008d\7\25\2\2\u008d\u008e\7G\2\2\u008e\31"+
		"\3\2\2\2\u008f\u0090\7;\2\2\u0090\u0091\7G\2\2\u0091\33\3\2\2\2\u0092"+
		"\u0093\7;\2\2\u0093\u0094\7I\2\2\u0094\35\3\2\2\2\u0095\u0096\5\32\16"+
		"\2\u0096\u0097\5\"\22\2\u0097\37\3\2\2\2\u0098\u0099\5\34\17\2\u0099\u009a"+
		"\5\"\22\2\u009a!\3\2\2\2\u009b\u009c\7C\2\2\u009c\u009d\5\66\34\2\u009d"+
		"\u009e\7D\2\2\u009e\u009f\7C\2\2\u009f\u00a0\5\66\34\2\u00a0\u00a1\7D"+
		"\2\2\u00a1#\3\2\2\2\u00a2\u00a5\5\32\16\2\u00a3\u00a5\5\36\20\2\u00a4"+
		"\u00a2\3\2\2\2\u00a4\u00a3\3\2\2\2\u00a5%\3\2\2\2\u00a6\u00a9\5\34\17"+
		"\2\u00a7\u00a9\5 \21\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\'"+
		"\3\2\2\2\u00aa\u00ad\5$\23\2\u00ab\u00ad\5&\24\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ab\3\2\2\2\u00ad)\3\2\2\2\u00ae\u00b2\7\32\2\2\u00af\u00b0\7\33\2"+
		"\2\u00b0\u00b2\5\"\22\2\u00b1\u00ae\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2"+
		"+\3\2\2\2\u00b3\u00b4\t\2\2\2\u00b4-\3\2\2\2\u00b5\u00b6\t\3\2\2\u00b6"+
		"/\3\2\2\2\u00b7\u00b8\t\4\2\2\u00b8\61\3\2\2\2\u00b9\u00ba\t\5\2\2\u00ba"+
		"\63\3\2\2\2\u00bb\u00bc\t\6\2\2\u00bc\65\3\2\2\2\u00bd\u00be\b\34\1\2"+
		"\u00be\u00bf\7?\2\2\u00bf\u00c0\5\66\34\2\u00c0\u00c1\7@\2\2\u00c1\u00f9"+
		"\3\2\2\2\u00c2\u00c3\5\62\32\2\u00c3\u00c4\7?\2\2\u00c4\u00c7\5\66\34"+
		"\2\u00c5\u00c6\7<\2\2\u00c6\u00c8\5\66\34\2\u00c7\u00c5\3\2\2\2\u00c7"+
		"\u00c8\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00ca\7@\2\2\u00ca\u00f9\3\2"+
		"\2\2\u00cb\u00cc\7A\2\2\u00cc\u00d1\5\66\34\2\u00cd\u00ce\7<\2\2\u00ce"+
		"\u00d0\5\66\34\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3"+
		"\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d4\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4"+
		"\u00d5\7B\2\2\u00d5\u00f9\3\2\2\2\u00d6\u00d7\5(\25\2\u00d7\u00d8\7:\2"+
		"\2\u00d8\u00d9\5\66\34\n\u00d9\u00f9\3\2\2\2\u00da\u00db\5:\36\2\u00db"+
		"\u00dd\7A\2\2\u00dc\u00de\5\66\34\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3"+
		"\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e2\7B\2\2\u00e2\u00f9\3\2\2\2\u00e3\u00e4\5<\37\2\u00e4\u00e6\7A\2"+
		"\2\u00e5\u00e7\5\66\34\2\u00e6\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8"+
		"\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00ec\7B"+
		"\2\2\u00eb\u00ed\5> \2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f9"+
		"\3\2\2\2\u00ee\u00ef\7\26\2\2\u00ef\u00f0\5,\27\2\u00f0\u00f1\7I\2\2\u00f1"+
		"\u00f2\7:\2\2\u00f2\u00f3\5\66\34\7\u00f3\u00f9\3\2\2\2\u00f4\u00f9\5"+
		"(\25\2\u00f5\u00f9\5B\"\2\u00f6\u00f9\5@!\2\u00f7\u00f9\7I\2\2\u00f8\u00bd"+
		"\3\2\2\2\u00f8\u00c2\3\2\2\2\u00f8\u00cb\3\2\2\2\u00f8\u00d6\3\2\2\2\u00f8"+
		"\u00da\3\2\2\2\u00f8\u00e3\3\2\2\2\u00f8\u00ee\3\2\2\2\u00f8\u00f4\3\2"+
		"\2\2\u00f8\u00f5\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9"+
		"\u0108\3\2\2\2\u00fa\u00fb\f\17\2\2\u00fb\u00fc\5.\30\2\u00fc\u00fd\5"+
		"\66\34\20\u00fd\u0107\3\2\2\2\u00fe\u00ff\f\16\2\2\u00ff\u0100\5\64\33"+
		"\2\u0100\u0101\5\66\34\17\u0101\u0107\3\2\2\2\u0102\u0103\f\r\2\2\u0103"+
		"\u0104\5\60\31\2\u0104\u0105\5\66\34\16\u0105\u0107\3\2\2\2\u0106\u00fa"+
		"\3\2\2\2\u0106\u00fe\3\2\2\2\u0106\u0102\3\2\2\2\u0107\u010a\3\2\2\2\u0108"+
		"\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\67\3\2\2\2\u010a\u0108\3\2\2"+
		"\2\u010b\u010c\7\20\2\2\u010c\u010d\7I\2\2\u010d\u010e\7\21\2\2\u010e"+
		"\u010f\7G\2\2\u010f\u0110\7\22\2\2\u0110\u0113\7G\2\2\u0111\u0112\7\23"+
		"\2\2\u0112\u0114\7G\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"9\3\2\2\2\u0115\u0116\7\17\2\2\u0116\u0117\7I\2\2\u0117\u0118\7\21\2\2"+
		"\u0118\u0119\5\66\34\2\u0119\u011a\7\22\2\2\u011a\u011d\5\66\34\2\u011b"+
		"\u011c\7\23\2\2\u011c\u011e\5\66\34\2\u011d\u011b\3\2\2\2\u011d\u011e"+
		"\3\2\2\2\u011e;\3\2\2\2\u011f\u0120\7\r\2\2\u0120\u0121\7?\2\2\u0121\u0122"+
		"\5\66\34\2\u0122\u0123\7@\2\2\u0123=\3\2\2\2\u0124\u0125\7\16\2\2\u0125"+
		"\u0127\7A\2\2\u0126\u0128\5\66\34\2\u0127\u0126\3\2\2\2\u0128\u0129\3"+
		"\2\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012b"+
		"\u012c\7B\2\2\u012c?\3\2\2\2\u012d\u012f\t\7\2\2\u012e\u012d\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\t\b\2\2\u0131A\3\2\2\2"+
		"\u0132\u0136\7=\2\2\u0133\u0135\n\t\2\2\u0134\u0133\3\2\2\2\u0135\u0138"+
		"\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137\u0139\3\2\2\2\u0138"+
		"\u0136\3\2\2\2\u0139\u013a\7=\2\2\u013aC\3\2\2\2\34JV]elty\u0083\u008a"+
		"\u00a4\u00a8\u00ac\u00b1\u00c7\u00d1\u00df\u00e8\u00ec\u00f8\u0106\u0108"+
		"\u0113\u011d\u0129\u012e\u0136";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}