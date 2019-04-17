// Generated from /Users/philipnguyen/Documents/cs152/project/cs152/FeatherweightJavaScript.g4 by ANTLR 4.7.1
 package edu.sjsu.fwjs.parser; 
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FeatherweightJavaScriptLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, IF=6, ELSE=7, WHILE=8, FUNCTION=9, 
		VAR=10, PRINT=11, INT=12, BOOL=13, NULL=14, MUL=15, DIV=16, SEPARATOR=17, 
		ADD=18, SUB=19, MOD=20, BIGGER=21, SMALLER=22, BIGOREQL=23, SMALLOREQL=24, 
		SAME=25, EQL=26, NEWLINE=27, LINE_COMMENT=28, WS=29, BLOCK_COMMENT=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "IF", "ELSE", "WHILE", "FUNCTION", 
		"VAR", "PRINT", "INT", "BOOL", "NULL", "MUL", "DIV", "SEPARATOR", "ADD", 
		"SUB", "MOD", "BIGGER", "SMALLER", "BIGOREQL", "SMALLOREQL", "SAME", "EQL", 
		"NEWLINE", "LINE_COMMENT", "WS", "BLOCK_COMMENT"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'){'", "'}'", "'{'", "'if'", "'else'", "'while'", 
		"'function'", null, "'print'", null, null, "'null'", "'*'", "'/'", "';'", 
		"'+'", "'-'", "'%'", "'>'", "'<'", "'>='", "'<='", "'=='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "IF", "ELSE", "WHILE", "FUNCTION", 
		"VAR", "PRINT", "INT", "BOOL", "NULL", "MUL", "DIV", "SEPARATOR", "ADD", 
		"SUB", "MOD", "BIGGER", "SMALLER", "BIGOREQL", "SMALLOREQL", "SAME", "EQL", 
		"NEWLINE", "LINE_COMMENT", "WS", "BLOCK_COMMENT"
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


	public FeatherweightJavaScriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FeatherweightJavaScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2 \u00cd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\5\13c\n"+
		"\13\3\13\7\13f\n\13\f\13\16\13i\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r"+
		"\7\rs\n\r\f\r\16\rv\13\r\3\r\5\ry\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u0084\n\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\5\34\u00a8"+
		"\n\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00b2\n\35\f\35\16"+
		"\35\u00b5\13\35\3\35\3\35\3\36\6\36\u00ba\n\36\r\36\16\36\u00bb\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\7\37\u00c4\n\37\f\37\16\37\u00c7\13\37\3\37\3"+
		"\37\3\37\3\37\3\37\2\2 \3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= \3\2\b\5\2C\\aac|\6\2\62;C\\aac|\3\2\63;\3\2"+
		"\62;\4\2\f\f\17\17\4\2\13\13\"\"\2\u00d4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3?\3\2\2\2\5"+
		"A\3\2\2\2\7C\3\2\2\2\tF\3\2\2\2\13H\3\2\2\2\rJ\3\2\2\2\17M\3\2\2\2\21"+
		"R\3\2\2\2\23X\3\2\2\2\25b\3\2\2\2\27j\3\2\2\2\31x\3\2\2\2\33\u0083\3\2"+
		"\2\2\35\u0085\3\2\2\2\37\u008a\3\2\2\2!\u008c\3\2\2\2#\u008e\3\2\2\2%"+
		"\u0090\3\2\2\2\'\u0092\3\2\2\2)\u0094\3\2\2\2+\u0096\3\2\2\2-\u0098\3"+
		"\2\2\2/\u009a\3\2\2\2\61\u009d\3\2\2\2\63\u00a0\3\2\2\2\65\u00a3\3\2\2"+
		"\2\67\u00a7\3\2\2\29\u00ad\3\2\2\2;\u00b9\3\2\2\2=\u00bf\3\2\2\2?@\7*"+
		"\2\2@\4\3\2\2\2AB\7+\2\2B\6\3\2\2\2CD\7+\2\2DE\7}\2\2E\b\3\2\2\2FG\7\177"+
		"\2\2G\n\3\2\2\2HI\7}\2\2I\f\3\2\2\2JK\7k\2\2KL\7h\2\2L\16\3\2\2\2MN\7"+
		"g\2\2NO\7n\2\2OP\7u\2\2PQ\7g\2\2Q\20\3\2\2\2RS\7y\2\2ST\7j\2\2TU\7k\2"+
		"\2UV\7n\2\2VW\7g\2\2W\22\3\2\2\2XY\7h\2\2YZ\7w\2\2Z[\7p\2\2[\\\7e\2\2"+
		"\\]\7v\2\2]^\7k\2\2^_\7q\2\2_`\7p\2\2`\24\3\2\2\2ac\t\2\2\2ba\3\2\2\2"+
		"cg\3\2\2\2df\t\3\2\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\26\3\2\2"+
		"\2ig\3\2\2\2jk\7r\2\2kl\7t\2\2lm\7k\2\2mn\7p\2\2no\7v\2\2o\30\3\2\2\2"+
		"pt\t\4\2\2qs\t\5\2\2rq\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uy\3\2\2\2"+
		"vt\3\2\2\2wy\7\62\2\2xp\3\2\2\2xw\3\2\2\2y\32\3\2\2\2z{\7v\2\2{|\7t\2"+
		"\2|}\7w\2\2}\u0084\7g\2\2~\177\7h\2\2\177\u0080\7c\2\2\u0080\u0081\7n"+
		"\2\2\u0081\u0082\7u\2\2\u0082\u0084\7g\2\2\u0083z\3\2\2\2\u0083~\3\2\2"+
		"\2\u0084\34\3\2\2\2\u0085\u0086\7p\2\2\u0086\u0087\7w\2\2\u0087\u0088"+
		"\7n\2\2\u0088\u0089\7n\2\2\u0089\36\3\2\2\2\u008a\u008b\7,\2\2\u008b "+
		"\3\2\2\2\u008c\u008d\7\61\2\2\u008d\"\3\2\2\2\u008e\u008f\7=\2\2\u008f"+
		"$\3\2\2\2\u0090\u0091\7-\2\2\u0091&\3\2\2\2\u0092\u0093\7/\2\2\u0093("+
		"\3\2\2\2\u0094\u0095\7\'\2\2\u0095*\3\2\2\2\u0096\u0097\7@\2\2\u0097,"+
		"\3\2\2\2\u0098\u0099\7>\2\2\u0099.\3\2\2\2\u009a\u009b\7@\2\2\u009b\u009c"+
		"\7?\2\2\u009c\60\3\2\2\2\u009d\u009e\7>\2\2\u009e\u009f\7?\2\2\u009f\62"+
		"\3\2\2\2\u00a0\u00a1\7?\2\2\u00a1\u00a2\7?\2\2\u00a2\64\3\2\2\2\u00a3"+
		"\u00a4\7?\2\2\u00a4\66\3\2\2\2\u00a5\u00a6\7\17\2\2\u00a6\u00a8\7\f\2"+
		"\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00aa"+
		"\7\f\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\b\34\2\2\u00ac8\3\2\2\2\u00ad"+
		"\u00ae\7\61\2\2\u00ae\u00af\7\61\2\2\u00af\u00b3\3\2\2\2\u00b0\u00b2\n"+
		"\6\2\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\b\35"+
		"\2\2\u00b7:\3\2\2\2\u00b8\u00ba\t\7\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bb"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00be\b\36\2\2\u00be<\3\2\2\2\u00bf\u00c0\7\61\2\2\u00c0\u00c1\7,\2\2"+
		"\u00c1\u00c5\3\2\2\2\u00c2\u00c4\13\2\2\2\u00c3\u00c2\3\2\2\2\u00c4\u00c7"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c8\3\2\2\2\u00c7"+
		"\u00c5\3\2\2\2\u00c8\u00c9\7,\2\2\u00c9\u00ca\7\61\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00cc\b\37\2\2\u00cc>\3\2\2\2\r\2begtx\u0083\u00a7\u00b3\u00bb"+
		"\u00c5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}