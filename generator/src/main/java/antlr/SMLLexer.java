// Generated from D:/Laci/egyetem/szakdolgozat/SML/src/main/java/antlr\SML.g4 by ANTLR 4.6
package antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SMLLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "STATE_DELIMITER", "STATE_ATTRIBUTES_DELIMITER", "STATE_START_DELIMITER", 
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


	public SMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SML.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2D\u01f0\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!"+
		"\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3"+
		"$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3*\3"+
		"*\3*\3+\3+\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62"+
		"\3\63\3\63\3\64\3\64\3\65\3\65\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3"+
		";\3;\3<\3<\3=\3=\3>\3>\7>\u01ca\n>\f>\16>\u01cd\13>\3?\3?\7?\u01d1\n?"+
		"\f?\16?\u01d4\13?\3?\3?\7?\u01d8\n?\f?\16?\u01db\13?\3@\3@\3A\3A\3A\3"+
		"A\7A\u01e3\nA\fA\16A\u01e6\13A\3B\3B\3C\6C\u01eb\nC\rC\16C\u01ec\3C\3"+
		"C\2\2D\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\35"+
		"9\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66"+
		"k\67m8o9q:s;u<w=y>{?}@\177A\u0081B\u0083C\u0085D\3\2\5\4\2--//\4\2C\\"+
		"c|\5\2\13\f\17\17\"\"\u01f6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i"+
		"\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2"+
		"\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081"+
		"\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\3\u0087\3\2\2\2\5\u0089\3\2\2"+
		"\2\7\u0090\3\2\2\2\t\u00a2\3\2\2\2\13\u00af\3\2\2\2\r\u00bb\3\2\2\2\17"+
		"\u00c6\3\2\2\2\21\u00dc\3\2\2\2\23\u00f3\3\2\2\2\25\u0104\3\2\2\2\27\u0108"+
		"\3\2\2\2\31\u010e\3\2\2\2\33\u0113\3\2\2\2\35\u0116\3\2\2\2\37\u0119\3"+
		"\2\2\2!\u011f\3\2\2\2#\u0124\3\2\2\2%\u0128\3\2\2\2\'\u012d\3\2\2\2)\u0132"+
		"\3\2\2\2+\u0135\3\2\2\2-\u0138\3\2\2\2/\u013c\3\2\2\2\61\u0143\3\2\2\2"+
		"\63\u0148\3\2\2\2\65\u014f\3\2\2\2\67\u0153\3\2\2\29\u0157\3\2\2\2;\u015b"+
		"\3\2\2\2=\u015f\3\2\2\2?\u0165\3\2\2\2A\u016f\3\2\2\2C\u017a\3\2\2\2E"+
		"\u017e\3\2\2\2G\u0185\3\2\2\2I\u018a\3\2\2\2K\u018e\3\2\2\2M\u0191\3\2"+
		"\2\2O\u0195\3\2\2\2Q\u0199\3\2\2\2S\u019c\3\2\2\2U\u019f\3\2\2\2W\u01a1"+
		"\3\2\2\2Y\u01a3\3\2\2\2[\u01a6\3\2\2\2]\u01a9\3\2\2\2_\u01ab\3\2\2\2a"+
		"\u01ad\3\2\2\2c\u01af\3\2\2\2e\u01b1\3\2\2\2g\u01b3\3\2\2\2i\u01b5\3\2"+
		"\2\2k\u01b7\3\2\2\2m\u01b9\3\2\2\2o\u01bb\3\2\2\2q\u01bd\3\2\2\2s\u01bf"+
		"\3\2\2\2u\u01c1\3\2\2\2w\u01c3\3\2\2\2y\u01c5\3\2\2\2{\u01c7\3\2\2\2}"+
		"\u01ce\3\2\2\2\177\u01dc\3\2\2\2\u0081\u01de\3\2\2\2\u0083\u01e7\3\2\2"+
		"\2\u0085\u01ea\3\2\2\2\u0087\u0088\7^\2\2\u0088\4\3\2\2\2\u0089\u008a"+
		"\7U\2\2\u008a\u008b\7V\2\2\u008b\u008c\7C\2\2\u008c\u008d\7V\2\2\u008d"+
		"\u008e\7G\2\2\u008e\u008f\7<\2\2\u008f\6\3\2\2\2\u0090\u0091\7U\2\2\u0091"+
		"\u0092\7V\2\2\u0092\u0093\7C\2\2\u0093\u0094\7V\2\2\u0094\u0095\7G\2\2"+
		"\u0095\u0096\7a\2\2\u0096\u0097\7C\2\2\u0097\u0098\7V\2\2\u0098\u0099"+
		"\7V\2\2\u0099\u009a\7T\2\2\u009a\u009b\7K\2\2\u009b\u009c\7D\2\2\u009c"+
		"\u009d\7W\2\2\u009d\u009e\7V\2\2\u009e\u009f\7G\2\2\u009f\u00a0\7U\2\2"+
		"\u00a0\u00a1\7<\2\2\u00a1\b\3\2\2\2\u00a2\u00a3\7U\2\2\u00a3\u00a4\7V"+
		"\2\2\u00a4\u00a5\7C\2\2\u00a5\u00a6\7V\2\2\u00a6\u00a7\7G\2\2\u00a7\u00a8"+
		"\7a\2\2\u00a8\u00a9\7U\2\2\u00a9\u00aa\7V\2\2\u00aa\u00ab\7C\2\2\u00ab"+
		"\u00ac\7T\2\2\u00ac\u00ad\7V\2\2\u00ad\u00ae\7<\2\2\u00ae\n\3\2\2\2\u00af"+
		"\u00b0\7U\2\2\u00b0\u00b1\7V\2\2\u00b1\u00b2\7C\2\2\u00b2\u00b3\7V\2\2"+
		"\u00b3\u00b4\7G\2\2\u00b4\u00b5\7a\2\2\u00b5\u00b6\7I\2\2\u00b6\u00b7"+
		"\7Q\2\2\u00b7\u00b8\7C\2\2\u00b8\u00b9\7N\2\2\u00b9\u00ba\7<\2\2\u00ba"+
		"\f\3\2\2\2\u00bb\u00bc\7Q\2\2\u00bc\u00bd\7R\2\2\u00bd\u00be\7G\2\2\u00be"+
		"\u00bf\7T\2\2\u00bf\u00c0\7C\2\2\u00c0\u00c1\7V\2\2\u00c1\u00c2\7Q\2\2"+
		"\u00c2\u00c3\7T\2\2\u00c3\u00c4\7U\2\2\u00c4\u00c5\7<\2\2\u00c5\16\3\2"+
		"\2\2\u00c6\u00c7\7Q\2\2\u00c7\u00c8\7R\2\2\u00c8\u00c9\7G\2\2\u00c9\u00ca"+
		"\7T\2\2\u00ca\u00cb\7C\2\2\u00cb\u00cc\7V\2\2\u00cc\u00cd\7Q\2\2\u00cd"+
		"\u00ce\7T\2\2\u00ce\u00cf\7a\2\2\u00cf\u00d0\7F\2\2\u00d0\u00d1\7G\2\2"+
		"\u00d1\u00d2\7U\2\2\u00d2\u00d3\7E\2\2\u00d3\u00d4\7T\2\2\u00d4\u00d5"+
		"\7K\2\2\u00d5\u00d6\7R\2\2\u00d6\u00d7\7V\2\2\u00d7\u00d8\7K\2\2\u00d8"+
		"\u00d9\7Q\2\2\u00d9\u00da\7P\2\2\u00da\u00db\7<\2\2\u00db\20\3\2\2\2\u00dc"+
		"\u00dd\7Q\2\2\u00dd\u00de\7R\2\2\u00de\u00df\7G\2\2\u00df\u00e0\7T\2\2"+
		"\u00e0\u00e1\7C\2\2\u00e1\u00e2\7V\2\2\u00e2\u00e3\7Q\2\2\u00e3\u00e4"+
		"\7T\2\2\u00e4\u00e5\7a\2\2\u00e5\u00e6\7R\2\2\u00e6\u00e7\7T\2\2\u00e7"+
		"\u00e8\7G\2\2\u00e8\u00e9\7E\2\2\u00e9\u00ea\7Q\2\2\u00ea\u00eb\7P\2\2"+
		"\u00eb\u00ec\7F\2\2\u00ec\u00ed\7K\2\2\u00ed\u00ee\7V\2\2\u00ee\u00ef"+
		"\7K\2\2\u00ef\u00f0\7Q\2\2\u00f0\u00f1\7P\2\2\u00f1\u00f2\7<\2\2\u00f2"+
		"\22\3\2\2\2\u00f3\u00f4\7Q\2\2\u00f4\u00f5\7R\2\2\u00f5\u00f6\7G\2\2\u00f6"+
		"\u00f7\7T\2\2\u00f7\u00f8\7C\2\2\u00f8\u00f9\7V\2\2\u00f9\u00fa\7Q\2\2"+
		"\u00fa\u00fb\7T\2\2\u00fb\u00fc\7a\2\2\u00fc\u00fd\7G\2\2\u00fd\u00fe"+
		"\7H\2\2\u00fe\u00ff\7H\2\2\u00ff\u0100\7G\2\2\u0100\u0101\7E\2\2\u0101"+
		"\u0102\7V\2\2\u0102\u0103\7<\2\2\u0103\24\3\2\2\2\u0104\u0105\7h\2\2\u0105"+
		"\u0106\7q\2\2\u0106\u0107\7t\2\2\u0107\26\3\2\2\2\u0108\u0109\7r\2\2\u0109"+
		"\u010a\7c\2\2\u010a\u010b\7t\2\2\u010b\u010c\7c\2\2\u010c\u010d\7o\2\2"+
		"\u010d\30\3\2\2\2\u010e\u010f\7h\2\2\u010f\u0110\7t\2\2\u0110\u0111\7"+
		"q\2\2\u0111\u0112\7o\2\2\u0112\32\3\2\2\2\u0113\u0114\7v\2\2\u0114\u0115"+
		"\7q\2\2\u0115\34\3\2\2\2\u0116\u0117\7d\2\2\u0117\u0118\7{\2\2\u0118\36"+
		"\3\2\2\2\u0119\u011a\7v\2\2\u011a\u011b\7k\2\2\u011b\u011c\7o\2\2\u011c"+
		"\u011d\7g\2\2\u011d\u011e\7u\2\2\u011e \3\2\2\2\u011f\u0120\7C\2\2\u0120"+
		"\u0121\7v\2\2\u0121\u0122\7v\2\2\u0122\u0123\7t\2\2\u0123\"\3\2\2\2\u0124"+
		"\u0125\7x\2\2\u0125\u0126\7c\2\2\u0126\u0127\7t\2\2\u0127$\3\2\2\2\u0128"+
		"\u0129\7e\2\2\u0129\u012a\7q\2\2\u012a\u012b\7u\2\2\u012b\u012c\7v\2\2"+
		"\u012c&\3\2\2\2\u012d\u012e\7p\2\2\u012e\u012f\7c\2\2\u012f\u0130\7o\2"+
		"\2\u0130\u0131\7g\2\2\u0131(\3\2\2\2\u0132\u0133\7k\2\2\u0133\u0134\7"+
		"u\2\2\u0134*\3\2\2\2\u0135\u0136\7q\2\2\u0136\u0137\7h\2\2\u0137,\3\2"+
		"\2\2\u0138\u0139\7u\2\2\u0139\u013a\7g\2\2\u013a\u013b\7v\2\2\u013b.\3"+
		"\2\2\2\u013c\u013d\7o\2\2\u013d\u013e\7c\2\2\u013e\u013f\7v\2\2\u013f"+
		"\u0140\7t\2\2\u0140\u0141\7k\2\2\u0141\u0142\7z\2\2\u0142\60\3\2\2\2\u0143"+
		"\u0144\7y\2\2\u0144\u0145\7q\2\2\u0145\u0146\7t\2\2\u0146\u0147\7f\2\2"+
		"\u0147\62\3\2\2\2\u0148\u0149\7p\2\2\u0149\u014a\7w\2\2\u014a\u014b\7"+
		"o\2\2\u014b\u014c\7d\2\2\u014c\u014d\7g\2\2\u014d\u014e\7t\2\2\u014e\64"+
		"\3\2\2\2\u014f\u0150\7o\2\2\u0150\u0151\7k\2\2\u0151\u0152\7p\2\2\u0152"+
		"\66\3\2\2\2\u0153\u0154\7o\2\2\u0154\u0155\7c\2\2\u0155\u0156\7z\2\2\u0156"+
		"8\3\2\2\2\u0157\u0158\7u\2\2\u0158\u0159\7w\2\2\u0159\u015a\7o\2\2\u015a"+
		":\3\2\2\2\u015b\u015c\7c\2\2\u015c\u015d\7x\2\2\u015d\u015e\7i\2\2\u015e"+
		"<\3\2\2\2\u015f\u0160\7w\2\2\u0160\u0161\7p\2\2\u0161\u0162\7k\2\2\u0162"+
		"\u0163\7q\2\2\u0163\u0164\7p\2\2\u0164>\3\2\2\2\u0165\u0166\7k\2\2\u0166"+
		"\u0167\7p\2\2\u0167\u0168\7v\2\2\u0168\u0169\7g\2\2\u0169\u016a\7t\2\2"+
		"\u016a\u016b\7u\2\2\u016b\u016c\7g\2\2\u016c\u016d\7e\2\2\u016d\u016e"+
		"\7v\2\2\u016e@\3\2\2\2\u016f\u0170\7f\2\2\u0170\u0171\7k\2\2\u0171\u0172"+
		"\7h\2\2\u0172\u0173\7h\2\2\u0173\u0174\7g\2\2\u0174\u0175\7t\2\2\u0175"+
		"\u0176\7g\2\2\u0176\u0177\7p\2\2\u0177\u0178\7e\2\2\u0178\u0179\7g\2\2"+
		"\u0179B\3\2\2\2\u017a\u017b\7c\2\2\u017b\u017c\7f\2\2\u017c\u017d\7f\2"+
		"\2\u017dD\3\2\2\2\u017e\u017f\7t\2\2\u017f\u0180\7g\2\2\u0180\u0181\7"+
		"o\2\2\u0181\u0182\7q\2\2\u0182\u0183\7x\2\2\u0183\u0184\7g\2\2\u0184F"+
		"\3\2\2\2\u0185\u0186\7e\2\2\u0186\u0187\7c\2\2\u0187\u0188\7t\2\2\u0188"+
		"\u0189\7f\2\2\u0189H\3\2\2\2\u018a\u018b\7c\2\2\u018b\u018c\7p\2\2\u018c"+
		"\u018d\7f\2\2\u018dJ\3\2\2\2\u018e\u018f\7q\2\2\u018f\u0190\7t\2\2\u0190"+
		"L\3\2\2\2\u0191\u0192\7p\2\2\u0192\u0193\7q\2\2\u0193\u0194\7v\2\2\u0194"+
		"N\3\2\2\2\u0195\u0196\7k\2\2\u0196\u0197\7p\2\2\u0197\u0198\7h\2\2\u0198"+
		"P\3\2\2\2\u0199\u019a\7?\2\2\u019a\u019b\7?\2\2\u019bR\3\2\2\2\u019c\u019d"+
		"\7#\2\2\u019d\u019e\7?\2\2\u019eT\3\2\2\2\u019f\u01a0\7>\2\2\u01a0V\3"+
		"\2\2\2\u01a1\u01a2\7@\2\2\u01a2X\3\2\2\2\u01a3\u01a4\7>\2\2\u01a4\u01a5"+
		"\7?\2\2\u01a5Z\3\2\2\2\u01a6\u01a7\7@\2\2\u01a7\u01a8\7?\2\2\u01a8\\\3"+
		"\2\2\2\u01a9\u01aa\7-\2\2\u01aa^\3\2\2\2\u01ab\u01ac\7/\2\2\u01ac`\3\2"+
		"\2\2\u01ad\u01ae\7,\2\2\u01aeb\3\2\2\2\u01af\u01b0\7\61\2\2\u01b0d\3\2"+
		"\2\2\u01b1\u01b2\7?\2\2\u01b2f\3\2\2\2\u01b3\u01b4\7&\2\2\u01b4h\3\2\2"+
		"\2\u01b5\u01b6\7.\2\2\u01b6j\3\2\2\2\u01b7\u01b8\7$\2\2\u01b8l\3\2\2\2"+
		"\u01b9\u01ba\7)\2\2\u01ban\3\2\2\2\u01bb\u01bc\7*\2\2\u01bcp\3\2\2\2\u01bd"+
		"\u01be\7+\2\2\u01ber\3\2\2\2\u01bf\u01c0\7}\2\2\u01c0t\3\2\2\2\u01c1\u01c2"+
		"\7\177\2\2\u01c2v\3\2\2\2\u01c3\u01c4\7]\2\2\u01c4x\3\2\2\2\u01c5\u01c6"+
		"\7_\2\2\u01c6z\3\2\2\2\u01c7\u01cb\4\62;\2\u01c8\u01ca\4\62;\2\u01c9\u01c8"+
		"\3\2\2\2\u01ca\u01cd\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cb\u01cc\3\2\2\2\u01cc"+
		"|\3\2\2\2\u01cd\u01cb\3\2\2\2\u01ce\u01d2\4\62;\2\u01cf\u01d1\4\62;\2"+
		"\u01d0\u01cf\3\2\2\2\u01d1\u01d4\3\2\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3"+
		"\3\2\2\2\u01d3\u01d5\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d5\u01d9\7\60\2\2"+
		"\u01d6\u01d8\4\62;\2\u01d7\u01d6\3\2\2\2\u01d8\u01db\3\2\2\2\u01d9\u01d7"+
		"\3\2\2\2\u01d9\u01da\3\2\2\2\u01da~\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc"+
		"\u01dd\t\2\2\2\u01dd\u0080\3\2\2\2\u01de\u01e4\4c|\2\u01df\u01e3\5{>\2"+
		"\u01e0\u01e3\5\u0083B\2\u01e1\u01e3\7a\2\2\u01e2\u01df\3\2\2\2\u01e2\u01e0"+
		"\3\2\2\2\u01e2\u01e1\3\2\2\2\u01e3\u01e6\3\2\2\2\u01e4\u01e2\3\2\2\2\u01e4"+
		"\u01e5\3\2\2\2\u01e5\u0082\3\2\2\2\u01e6\u01e4\3\2\2\2\u01e7\u01e8\t\3"+
		"\2\2\u01e8\u0084\3\2\2\2\u01e9\u01eb\t\4\2\2\u01ea\u01e9\3\2\2\2\u01eb"+
		"\u01ec\3\2\2\2\u01ec\u01ea\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u01ee\3\2"+
		"\2\2\u01ee\u01ef\bC\2\2\u01ef\u0086\3\2\2\2\t\2\u01cb\u01d2\u01d9\u01e2"+
		"\u01e4\u01ec\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}