// Generated from c:\Users\Dell\IdeaProjects\valkyrie-intellij\src\main\antlr\ValkyrieBasic.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ValkyrieOperators extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, COMMA=2, SEMICOLON=3, OP_PROPORTION=4, COLON=5, PARENTHESES_L=6, 
		PARENTHESES_R=7, BRACKET_L=8, BRACKET_R=9, BRACE_L=10, BRACE_R=11, OP_ADD=12, 
		OP_SUB=13, OP_MUL=14, OP_DIV=15, OP_EQ=16, OP_NE=17, OP_LE=18, OP_LL=19, 
		OP_LLL=20, OP_LEQ=21, OP_GE=22, OP_GG=23, OP_GGG=24, OP_GEQ=25, OP_ARROW=26, 
		OP_ARROW2=27, OP_ASSIGN=28, LOGIC_OR=29, OP_OR=30, LOGIC_AND=31, OP_AND=32, 
		AT=33, HASH=34, OP_NOT=35, KW_NOT=36, OP_IN=37, KW_IN=38, OP_NOT_IN=39, 
		KW_IS=40, OP_IS=41, OP_IS_NOT=42, KW_AS=43, OP_UNTIL=44, OP_TEMPERATURE=45, 
		OP_EMPTY=46, KW_NAMESPACE=47, KW_IMPORT=48, KW_EXTENSION=49, KW_EXTENDS=50, 
		KW_CLASS=51, KW_TRAIT=52, KW_UNION=53, KW_BITFLAGS=54, KW_TYPE=55, KW_LET=56, 
		KW_FUNCTION=57, KW_WITCH=58, KW_WHILE=59, KW_FOR=60, INTEGER=61, DECIMAL=62, 
		STRING=63, KW_IF=64, KW_ELSE=65, KW_OTHERWISE=66, FROM=67, RETURN=68, 
		RESUME=69, YIELD=70, BREAK=71, CONTINUE=72, RAISE=73, CATCH=74, SPECIAL=75, 
		LINE_COMMENT=76, BLOCK_COMMENT=77, WHITE_SPACE=78, ERROR_CHARACTAR=79;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"DOT", "COMMA", "SEMICOLON", "OP_PROPORTION", "COLON", "PARENTHESES_L", 
			"PARENTHESES_R", "BRACKET_L", "BRACKET_R", "BRACE_L", "BRACE_R", "OP_ADD", 
			"OP_SUB", "OP_MUL", "OP_DIV", "OP_EQ", "OP_NE", "OP_LE", "OP_LL", "OP_LLL", 
			"OP_LEQ", "OP_GE", "OP_GG", "OP_GGG", "OP_GEQ", "OP_ARROW", "OP_ARROW2", 
			"OP_ASSIGN", "LOGIC_OR", "OP_OR", "LOGIC_AND", "OP_AND", "AT", "HASH", 
			"OP_NOT", "KW_NOT", "OP_IN", "KW_IN", "OP_NOT_IN", "KW_IS", "OP_IS", 
			"OP_IS_NOT", "KW_AS", "OP_UNTIL", "OP_TEMPERATURE", "OP_EMPTY", "KW_NAMESPACE", 
			"KW_IMPORT", "KW_EXTENSION", "KW_EXTENDS", "KW_CLASS", "KW_TRAIT", "KW_UNION", 
			"KW_BITFLAGS", "KW_TYPE", "KW_LET", "KW_FUNCTION", "KW_WITCH", "KW_WHILE", 
			"KW_FOR", "INTEGER", "DECIMAL", "EXP", "STRING", "ESC", "KW_IF", "KW_ELSE", 
			"KW_OTHERWISE", "FROM", "RETURN", "RESUME", "YIELD", "BREAK", "CONTINUE", 
			"RAISE", "CATCH", "NULL", "TRUE", "FALSE", "SPECIAL", "LINE_COMMENT", 
			"BLOCK_COMMENT", "WHITE_SPACE", "ERROR_CHARACTAR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "','", "';'", null, null, "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'<'", null, null, 
			null, "'>'", null, null, null, null, null, "'='", "'||'", "'|'", "'&&'", 
			"'&'", "'@'", null, "'!'", "'not'", null, "'in'", "'\u2209'", "'is'", 
			null, null, null, null, null, "'\u2205'", null, null, "'extension'", 
			null, null, null, "'union'", "'flags'", "'type'", "'let'", "'def'", "'which'", 
			"'while'", "'for'", null, null, null, "'if'", "'else'", "'otherwise'", 
			"'from'", "'return'", "'resume'", "'yield'", "'break'", "'continue'", 
			"'raise'", "'catch'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "COMMA", "SEMICOLON", "OP_PROPORTION", "COLON", "PARENTHESES_L", 
			"PARENTHESES_R", "BRACKET_L", "BRACKET_R", "BRACE_L", "BRACE_R", "OP_ADD", 
			"OP_SUB", "OP_MUL", "OP_DIV", "OP_EQ", "OP_NE", "OP_LE", "OP_LL", "OP_LLL", 
			"OP_LEQ", "OP_GE", "OP_GG", "OP_GGG", "OP_GEQ", "OP_ARROW", "OP_ARROW2", 
			"OP_ASSIGN", "LOGIC_OR", "OP_OR", "LOGIC_AND", "OP_AND", "AT", "HASH", 
			"OP_NOT", "KW_NOT", "OP_IN", "KW_IN", "OP_NOT_IN", "KW_IS", "OP_IS", 
			"OP_IS_NOT", "KW_AS", "OP_UNTIL", "OP_TEMPERATURE", "OP_EMPTY", "KW_NAMESPACE", 
			"KW_IMPORT", "KW_EXTENSION", "KW_EXTENDS", "KW_CLASS", "KW_TRAIT", "KW_UNION", 
			"KW_BITFLAGS", "KW_TYPE", "KW_LET", "KW_FUNCTION", "KW_WITCH", "KW_WHILE", 
			"KW_FOR", "INTEGER", "DECIMAL", "STRING", "KW_IF", "KW_ELSE", "KW_OTHERWISE", 
			"FROM", "RETURN", "RESUME", "YIELD", "BREAK", "CONTINUE", "RAISE", "CATCH", 
			"SPECIAL", "LINE_COMMENT", "BLOCK_COMMENT", "WHITE_SPACE", "ERROR_CHARACTAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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





	public ValkyrieOperators(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ValkyrieBasic.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2Q\u0293\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\5\5\u00b5\n\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3"+
		"\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24\5"+
		"\24\u00d8\n\24\3\25\3\25\3\25\3\25\5\25\u00de\n\25\3\26\3\26\3\26\5\26"+
		"\u00e3\n\26\3\27\3\27\3\30\3\30\3\30\5\30\u00ea\n\30\3\31\3\31\3\31\3"+
		"\31\5\31\u00f0\n\31\3\32\3\32\3\32\5\32\u00f5\n\32\3\33\3\33\3\33\5\33"+
		"\u00fa\n\33\3\34\3\34\3\34\5\34\u00ff\n\34\3\35\3\35\3\36\3\36\3\36\3"+
		"\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\5#\u0114\n#\3$\3$\3%\3"+
		"%\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3)\3)\3)\3*\3*\3*\5*\u0129\n*\3+\3+\3"+
		"+\5+\u012e\n+\3,\3,\3,\3,\3,\3,\3,\3,\5,\u0138\n,\3-\3-\3-\3-\3-\3-\5"+
		"-\u0140\n-\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\5\60\u016d\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61"+
		"\5\61\u0186\n\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\5\63\u019f"+
		"\n\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64"+
		"\3\64\5\64\u01af\n\64\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\3\65\3\65\3\65\5\65\u01bf\n\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\39\39\39\39\3:\3:\3:\3:\3;\3"+
		";\3;\3;\3;\3;\3<\3<\3<\3<\3<\3<\3=\3=\3=\3=\3>\3>\3>\7>\u01ed\n>\f>\16"+
		">\u01f0\13>\5>\u01f2\n>\3?\3?\3?\3?\5?\u01f8\n?\3?\3?\3?\5?\u01fd\n?\3"+
		"@\3@\5@\u0201\n@\3@\3@\3A\3A\3A\7A\u0208\nA\fA\16A\u020b\13A\3A\3A\3B"+
		"\3B\3B\3C\3C\3C\3D\3D\3D\3D\3D\3E\3E\3E\3E\3E\3E\3E\3E\3E\3E\3F\3F\3F"+
		"\3F\3F\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3J"+
		"\3J\3J\3J\3J\3J\3K\3K\3K\3K\3K\3K\3K\3K\3K\3L\3L\3L\3L\3L\3L\3M\3M\3M"+
		"\3M\3M\3M\3N\3N\3N\3N\3N\3O\3O\3O\3O\3O\3P\3P\3P\3P\3P\3P\3Q\3Q\3Q\5Q"+
		"\u026b\nQ\3R\3R\3R\3R\7R\u0271\nR\fR\16R\u0274\13R\3R\5R\u0277\nR\3R\3"+
		"R\3S\3S\3S\3S\7S\u027f\nS\fS\16S\u0282\13S\3S\3S\3S\3S\3S\3T\6T\u028a"+
		"\nT\rT\16T\u028b\3T\3T\3U\3U\3U\3U\4\u0272\u0280\2V\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'"+
		"M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177"+
		"\2\u0081A\u0083\2\u0085B\u0087C\u0089D\u008bE\u008dF\u008fG\u0091H\u0093"+
		"I\u0095J\u0097K\u0099L\u009b\2\u009d\2\u009f\2\u00a1M\u00a3N\u00a5O\u00a7"+
		"P\u00a9Q\3\2\20\4\2<<\u2238\u2238\4\2\u2266\u2266\u2a7f\u2a7f\4\2\u2267"+
		"\u2267\u2a80\u2a80\4\2\u220a\u220a\u220c\u220c\4\2\u2105\u2105\u210b\u210b"+
		"\3\2\62\62\3\2\63;\3\2\62;\4\2GGgg\4\2--//\4\2$$^^\b\2\n\n$$hhppttvv\3"+
		"\3\f\f\5\2\13\f\17\17\"\"\2\u02b2\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2"+
		"\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2"+
		"O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3"+
		"\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2"+
		"\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2"+
		"u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\u0081\3\2\2\2"+
		"\2\u0085\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d"+
		"\3\2\2\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0095\3\2\2"+
		"\2\2\u0097\3\2\2\2\2\u0099\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5"+
		"\3\2\2\2\2\u00a7\3\2\2\2\2\u00a9\3\2\2\2\3\u00ab\3\2\2\2\5\u00ad\3\2\2"+
		"\2\7\u00af\3\2\2\2\t\u00b4\3\2\2\2\13\u00b6\3\2\2\2\r\u00b8\3\2\2\2\17"+
		"\u00ba\3\2\2\2\21\u00bc\3\2\2\2\23\u00be\3\2\2\2\25\u00c0\3\2\2\2\27\u00c2"+
		"\3\2\2\2\31\u00c4\3\2\2\2\33\u00c6\3\2\2\2\35\u00c8\3\2\2\2\37\u00ca\3"+
		"\2\2\2!\u00cc\3\2\2\2#\u00cf\3\2\2\2%\u00d2\3\2\2\2\'\u00d7\3\2\2\2)\u00dd"+
		"\3\2\2\2+\u00e2\3\2\2\2-\u00e4\3\2\2\2/\u00e9\3\2\2\2\61\u00ef\3\2\2\2"+
		"\63\u00f4\3\2\2\2\65\u00f9\3\2\2\2\67\u00fe\3\2\2\29\u0100\3\2\2\2;\u0102"+
		"\3\2\2\2=\u0105\3\2\2\2?\u0107\3\2\2\2A\u010a\3\2\2\2C\u010c\3\2\2\2E"+
		"\u0113\3\2\2\2G\u0115\3\2\2\2I\u0117\3\2\2\2K\u011b\3\2\2\2M\u011d\3\2"+
		"\2\2O\u0120\3\2\2\2Q\u0122\3\2\2\2S\u0128\3\2\2\2U\u012d\3\2\2\2W\u0137"+
		"\3\2\2\2Y\u013f\3\2\2\2[\u0141\3\2\2\2]\u0143\3\2\2\2_\u016c\3\2\2\2a"+
		"\u0185\3\2\2\2c\u0187\3\2\2\2e\u019e\3\2\2\2g\u01ae\3\2\2\2i\u01be\3\2"+
		"\2\2k\u01c0\3\2\2\2m\u01c6\3\2\2\2o\u01cc\3\2\2\2q\u01d1\3\2\2\2s\u01d5"+
		"\3\2\2\2u\u01d9\3\2\2\2w\u01df\3\2\2\2y\u01e5\3\2\2\2{\u01f1\3\2\2\2}"+
		"\u01fc\3\2\2\2\177\u01fe\3\2\2\2\u0081\u0204\3\2\2\2\u0083\u020e\3\2\2"+
		"\2\u0085\u0211\3\2\2\2\u0087\u0214\3\2\2\2\u0089\u0219\3\2\2\2\u008b\u0223"+
		"\3\2\2\2\u008d\u0228\3\2\2\2\u008f\u022f\3\2\2\2\u0091\u0236\3\2\2\2\u0093"+
		"\u023c\3\2\2\2\u0095\u0242\3\2\2\2\u0097\u024b\3\2\2\2\u0099\u0251\3\2"+
		"\2\2\u009b\u0257\3\2\2\2\u009d\u025c\3\2\2\2\u009f\u0261\3\2\2\2\u00a1"+
		"\u026a\3\2\2\2\u00a3\u026c\3\2\2\2\u00a5\u027a\3\2\2\2\u00a7\u0289\3\2"+
		"\2\2\u00a9\u028f\3\2\2\2\u00ab\u00ac\7\60\2\2\u00ac\4\3\2\2\2\u00ad\u00ae"+
		"\7.\2\2\u00ae\6\3\2\2\2\u00af\u00b0\7=\2\2\u00b0\b\3\2\2\2\u00b1\u00b5"+
		"\7\u2239\2\2\u00b2\u00b3\7<\2\2\u00b3\u00b5\7<\2\2\u00b4\u00b1\3\2\2\2"+
		"\u00b4\u00b2\3\2\2\2\u00b5\n\3\2\2\2\u00b6\u00b7\t\2\2\2\u00b7\f\3\2\2"+
		"\2\u00b8\u00b9\7*\2\2\u00b9\16\3\2\2\2\u00ba\u00bb\7+\2\2\u00bb\20\3\2"+
		"\2\2\u00bc\u00bd\7]\2\2\u00bd\22\3\2\2\2\u00be\u00bf\7_\2\2\u00bf\24\3"+
		"\2\2\2\u00c0\u00c1\7}\2\2\u00c1\26\3\2\2\2\u00c2\u00c3\7\177\2\2\u00c3"+
		"\30\3\2\2\2\u00c4\u00c5\7-\2\2\u00c5\32\3\2\2\2\u00c6\u00c7\7/\2\2\u00c7"+
		"\34\3\2\2\2\u00c8\u00c9\7,\2\2\u00c9\36\3\2\2\2\u00ca\u00cb\7\61\2\2\u00cb"+
		" \3\2\2\2\u00cc\u00cd\7?\2\2\u00cd\u00ce\7?\2\2\u00ce\"\3\2\2\2\u00cf"+
		"\u00d0\7#\2\2\u00d0\u00d1\7?\2\2\u00d1$\3\2\2\2\u00d2\u00d3\7>\2\2\u00d3"+
		"&\3\2\2\2\u00d4\u00d8\7\u226c\2\2\u00d5\u00d6\7>\2\2\u00d6\u00d8\7>\2"+
		"\2\u00d7\u00d4\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8(\3\2\2\2\u00d9\u00de"+
		"\7\u22da\2\2\u00da\u00db\7>\2\2\u00db\u00dc\7>\2\2\u00dc\u00de\7>\2\2"+
		"\u00dd\u00d9\3\2\2\2\u00dd\u00da\3\2\2\2\u00de*\3\2\2\2\u00df\u00e3\t"+
		"\3\2\2\u00e0\u00e1\7>\2\2\u00e1\u00e3\7?\2\2\u00e2\u00df\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e3,\3\2\2\2\u00e4\u00e5\7@\2\2\u00e5.\3\2\2\2\u00e6"+
		"\u00ea\7\u226d\2\2\u00e7\u00e8\7@\2\2\u00e8\u00ea\7@\2\2\u00e9\u00e6\3"+
		"\2\2\2\u00e9\u00e7\3\2\2\2\u00ea\60\3\2\2\2\u00eb\u00f0\7\u22db\2\2\u00ec"+
		"\u00ed\7@\2\2\u00ed\u00ee\7@\2\2\u00ee\u00f0\7@\2\2\u00ef\u00eb\3\2\2"+
		"\2\u00ef\u00ec\3\2\2\2\u00f0\62\3\2\2\2\u00f1\u00f5\t\4\2\2\u00f2\u00f3"+
		"\7@\2\2\u00f3\u00f5\7?\2\2\u00f4\u00f1\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5"+
		"\64\3\2\2\2\u00f6\u00fa\7\u27f8\2\2\u00f7\u00f8\7/\2\2\u00f8\u00fa\7@"+
		"\2\2\u00f9\u00f6\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa\66\3\2\2\2\u00fb\u00ff"+
		"\7\u21d4\2\2\u00fc\u00fd\7?\2\2\u00fd\u00ff\7@\2\2\u00fe\u00fb\3\2\2\2"+
		"\u00fe\u00fc\3\2\2\2\u00ff8\3\2\2\2\u0100\u0101\7?\2\2\u0101:\3\2\2\2"+
		"\u0102\u0103\7~\2\2\u0103\u0104\7~\2\2\u0104<\3\2\2\2\u0105\u0106\7~\2"+
		"\2\u0106>\3\2\2\2\u0107\u0108\7(\2\2\u0108\u0109\7(\2\2\u0109@\3\2\2\2"+
		"\u010a\u010b\7(\2\2\u010bB\3\2\2\2\u010c\u010d\7B\2\2\u010dD\3\2\2\2\u010e"+
		"\u0114\7%\2\2\u010f\u0110\7%\2\2\u0110\u0114\7%\2\2\u0111\u0112\7%\2\2"+
		"\u0112\u0114\7#\2\2\u0113\u010e\3\2\2\2\u0113\u010f\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0114F\3\2\2\2\u0115\u0116\7#\2\2\u0116H\3\2\2\2\u0117\u0118"+
		"\7p\2\2\u0118\u0119\7q\2\2\u0119\u011a\7v\2\2\u011aJ\3\2\2\2\u011b\u011c"+
		"\t\5\2\2\u011cL\3\2\2\2\u011d\u011e\7k\2\2\u011e\u011f\7p\2\2\u011fN\3"+
		"\2\2\2\u0120\u0121\7\u220b\2\2\u0121P\3\2\2\2\u0122\u0123\7k\2\2\u0123"+
		"\u0124\7u\2\2\u0124R\3\2\2\2\u0125\u0129\7\u2293\2\2\u0126\u0127\7>\2"+
		"\2\u0127\u0129\7<\2\2\u0128\u0125\3\2\2\2\u0128\u0126\3\2\2\2\u0129T\3"+
		"\2\2\2\u012a\u012e\7\u22e4\2\2\u012b\u012c\7>\2\2\u012c\u012e\7#\2\2\u012d"+
		"\u012a\3\2\2\2\u012d\u012b\3\2\2\2\u012eV\3\2\2\2\u012f\u0130\7c\2\2\u0130"+
		"\u0138\7u\2\2\u0131\u0132\7c\2\2\u0132\u0133\7u\2\2\u0133\u0138\7#\2\2"+
		"\u0134\u0135\7c\2\2\u0135\u0136\7u\2\2\u0136\u0138\7,\2\2\u0137\u012f"+
		"\3\2\2\2\u0137\u0131\3\2\2\2\u0137\u0134\3\2\2\2\u0138X\3\2\2\2\u0139"+
		"\u013a\7\60\2\2\u013a\u013b\7\60\2\2\u013b\u0140\7>\2\2\u013c\u013d\7"+
		"\60\2\2\u013d\u013e\7\60\2\2\u013e\u0140\7?\2\2\u013f\u0139\3\2\2\2\u013f"+
		"\u013c\3\2\2\2\u0140Z\3\2\2\2\u0141\u0142\t\6\2\2\u0142\\\3\2\2\2\u0143"+
		"\u0144\7\u2207\2\2\u0144^\3\2\2\2\u0145\u0146\7p\2\2\u0146\u0147\7c\2"+
		"\2\u0147\u0148\7o\2\2\u0148\u0149\7g\2\2\u0149\u014a\7u\2\2\u014a\u014b"+
		"\7r\2\2\u014b\u014c\7c\2\2\u014c\u014d\7e\2\2\u014d\u016d\7g\2\2\u014e"+
		"\u014f\7p\2\2\u014f\u0150\7c\2\2\u0150\u0151\7o\2\2\u0151\u0152\7g\2\2"+
		"\u0152\u0153\7u\2\2\u0153\u0154\7r\2\2\u0154\u0155\7c\2\2\u0155\u0156"+
		"\7e\2\2\u0156\u0157\7g\2\2\u0157\u016d\7#\2\2\u0158\u0159\7p\2\2\u0159"+
		"\u015a\7c\2\2\u015a\u015b\7o\2\2\u015b\u015c\7g\2\2\u015c\u015d\7u\2\2"+
		"\u015d\u015e\7r\2\2\u015e\u015f\7c\2\2\u015f\u0160\7e\2\2\u0160\u0161"+
		"\7g\2\2\u0161\u016d\7,\2\2\u0162\u0163\7p\2\2\u0163\u0164\7c\2\2\u0164"+
		"\u0165\7o\2\2\u0165\u0166\7g\2\2\u0166\u0167\7u\2\2\u0167\u0168\7r\2\2"+
		"\u0168\u0169\7c\2\2\u0169\u016a\7e\2\2\u016a\u016b\7g\2\2\u016b\u016d"+
		"\7A\2\2\u016c\u0145\3\2\2\2\u016c\u014e\3\2\2\2\u016c\u0158\3\2\2\2\u016c"+
		"\u0162\3\2\2\2\u016d`\3\2\2\2\u016e\u016f\7w\2\2\u016f\u0170\7u\2\2\u0170"+
		"\u0171\7k\2\2\u0171\u0172\7p\2\2\u0172\u0186\7i\2\2\u0173\u0174\7w\2\2"+
		"\u0174\u0175\7u\2\2\u0175\u0176\7k\2\2\u0176\u0177\7p\2\2\u0177\u0178"+
		"\7i\2\2\u0178\u0186\7#\2\2\u0179\u017a\7w\2\2\u017a\u017b\7u\2\2\u017b"+
		"\u017c\7k\2\2\u017c\u017d\7p\2\2\u017d\u017e\7i\2\2\u017e\u0186\7,\2\2"+
		"\u017f\u0180\7w\2\2\u0180\u0181\7u\2\2\u0181\u0182\7k\2\2\u0182\u0183"+
		"\7p\2\2\u0183\u0184\7i\2\2\u0184\u0186\7A\2\2\u0185\u016e\3\2\2\2\u0185"+
		"\u0173\3\2\2\2\u0185\u0179\3\2\2\2\u0185\u017f\3\2\2\2\u0186b\3\2\2\2"+
		"\u0187\u0188\7g\2\2\u0188\u0189\7z\2\2\u0189\u018a\7v\2\2\u018a\u018b"+
		"\7g\2\2\u018b\u018c\7p\2\2\u018c\u018d\7u\2\2\u018d\u018e\7k\2\2\u018e"+
		"\u018f\7q\2\2\u018f\u0190\7p\2\2\u0190d\3\2\2\2\u0191\u0192\7g\2\2\u0192"+
		"\u0193\7z\2\2\u0193\u0194\7v\2\2\u0194\u0195\7g\2\2\u0195\u0196\7p\2\2"+
		"\u0196\u019f\7f\2\2\u0197\u0198\7g\2\2\u0198\u0199\7z\2\2\u0199\u019a"+
		"\7v\2\2\u019a\u019b\7g\2\2\u019b\u019c\7p\2\2\u019c\u019d\7f\2\2\u019d"+
		"\u019f\7u\2\2\u019e\u0191\3\2\2\2\u019e\u0197\3\2\2\2\u019ff\3\2\2\2\u01a0"+
		"\u01a1\7e\2\2\u01a1\u01a2\7n\2\2\u01a2\u01a3\7c\2\2\u01a3\u01a4\7u\2\2"+
		"\u01a4\u01af\7u\2\2\u01a5\u01a6\7u\2\2\u01a6\u01a7\7v\2\2\u01a7\u01a8"+
		"\7t\2\2\u01a8\u01a9\7w\2\2\u01a9\u01aa\7e\2\2\u01aa\u01ab\7v\2\2\u01ab"+
		"\u01ac\7w\2\2\u01ac\u01ad\7t\2\2\u01ad\u01af\7g\2\2\u01ae\u01a0\3\2\2"+
		"\2\u01ae\u01a5\3\2\2\2\u01afh\3\2\2\2\u01b0\u01b1\7v\2\2\u01b1\u01b2\7"+
		"t\2\2\u01b2\u01b3\7c\2\2\u01b3\u01b4\7k\2\2\u01b4\u01bf\7v\2\2\u01b5\u01b6"+
		"\7k\2\2\u01b6\u01b7\7p\2\2\u01b7\u01b8\7v\2\2\u01b8\u01b9\7g\2\2\u01b9"+
		"\u01ba\7t\2\2\u01ba\u01bb\7h\2\2\u01bb\u01bc\7c\2\2\u01bc\u01bd\7e\2\2"+
		"\u01bd\u01bf\7g\2\2\u01be\u01b0\3\2\2\2\u01be\u01b5\3\2\2\2\u01bfj\3\2"+
		"\2\2\u01c0\u01c1\7w\2\2\u01c1\u01c2\7p\2\2\u01c2\u01c3\7k\2\2\u01c3\u01c4"+
		"\7q\2\2\u01c4\u01c5\7p\2\2\u01c5l\3\2\2\2\u01c6\u01c7\7h\2\2\u01c7\u01c8"+
		"\7n\2\2\u01c8\u01c9\7c\2\2\u01c9\u01ca\7i\2\2\u01ca\u01cb\7u\2\2\u01cb"+
		"n\3\2\2\2\u01cc\u01cd\7v\2\2\u01cd\u01ce\7{\2\2\u01ce\u01cf\7r\2\2\u01cf"+
		"\u01d0\7g\2\2\u01d0p\3\2\2\2\u01d1\u01d2\7n\2\2\u01d2\u01d3\7g\2\2\u01d3"+
		"\u01d4\7v\2\2\u01d4r\3\2\2\2\u01d5\u01d6\7f\2\2\u01d6\u01d7\7g\2\2\u01d7"+
		"\u01d8\7h\2\2\u01d8t\3\2\2\2\u01d9\u01da\7y\2\2\u01da\u01db\7j\2\2\u01db"+
		"\u01dc\7k\2\2\u01dc\u01dd\7e\2\2\u01dd\u01de\7j\2\2\u01dev\3\2\2\2\u01df"+
		"\u01e0\7y\2\2\u01e0\u01e1\7j\2\2\u01e1\u01e2\7k\2\2\u01e2\u01e3\7n\2\2"+
		"\u01e3\u01e4\7g\2\2\u01e4x\3\2\2\2\u01e5\u01e6\7h\2\2\u01e6\u01e7\7q\2"+
		"\2\u01e7\u01e8\7t\2\2\u01e8z\3\2\2\2\u01e9\u01f2\t\7\2\2\u01ea\u01ee\t"+
		"\b\2\2\u01eb\u01ed\t\t\2\2\u01ec\u01eb\3\2\2\2\u01ed\u01f0\3\2\2\2\u01ee"+
		"\u01ec\3\2\2\2\u01ee\u01ef\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0\u01ee\3\2"+
		"\2\2\u01f1\u01e9\3\2\2\2\u01f1\u01ea\3\2\2\2\u01f2|\3\2\2\2\u01f3\u01f4"+
		"\5{>\2\u01f4\u01f5\5\3\2\2\u01f5\u01f7\5{>\2\u01f6\u01f8\5\177@\2\u01f7"+
		"\u01f6\3\2\2\2\u01f7\u01f8\3\2\2\2\u01f8\u01fd\3\2\2\2\u01f9\u01fa\5{"+
		">\2\u01fa\u01fb\5\177@\2\u01fb\u01fd\3\2\2\2\u01fc\u01f3\3\2\2\2\u01fc"+
		"\u01f9\3\2\2\2\u01fd~\3\2\2\2\u01fe\u0200\t\n\2\2\u01ff\u0201\t\13\2\2"+
		"\u0200\u01ff\3\2\2\2\u0200\u0201\3\2\2\2\u0201\u0202\3\2\2\2\u0202\u0203"+
		"\5{>\2\u0203\u0080\3\2\2\2\u0204\u0209\7$\2\2\u0205\u0208\5\u0083B\2\u0206"+
		"\u0208\n\f\2\2\u0207\u0205\3\2\2\2\u0207\u0206\3\2\2\2\u0208\u020b\3\2"+
		"\2\2\u0209\u0207\3\2\2\2\u0209\u020a\3\2\2\2\u020a\u020c\3\2\2\2\u020b"+
		"\u0209\3\2\2\2\u020c\u020d\7$\2\2\u020d\u0082\3\2\2\2\u020e\u020f\7^\2"+
		"\2\u020f\u0210\t\r\2\2\u0210\u0084\3\2\2\2\u0211\u0212\7k\2\2\u0212\u0213"+
		"\7h\2\2\u0213\u0086\3\2\2\2\u0214\u0215\7g\2\2\u0215\u0216\7n\2\2\u0216"+
		"\u0217\7u\2\2\u0217\u0218\7g\2\2\u0218\u0088\3\2\2\2\u0219\u021a\7q\2"+
		"\2\u021a\u021b\7v\2\2\u021b\u021c\7j\2\2\u021c\u021d\7g\2\2\u021d\u021e"+
		"\7t\2\2\u021e\u021f\7y\2\2\u021f\u0220\7k\2\2\u0220\u0221\7u\2\2\u0221"+
		"\u0222\7g\2\2\u0222\u008a\3\2\2\2\u0223\u0224\7h\2\2\u0224\u0225\7t\2"+
		"\2\u0225\u0226\7q\2\2\u0226\u0227\7o\2\2\u0227\u008c\3\2\2\2\u0228\u0229"+
		"\7t\2\2\u0229\u022a\7g\2\2\u022a\u022b\7v\2\2\u022b\u022c\7w\2\2\u022c"+
		"\u022d\7t\2\2\u022d\u022e\7p\2\2\u022e\u008e\3\2\2\2\u022f\u0230\7t\2"+
		"\2\u0230\u0231\7g\2\2\u0231\u0232\7u\2\2\u0232\u0233\7w\2\2\u0233\u0234"+
		"\7o\2\2\u0234\u0235\7g\2\2\u0235\u0090\3\2\2\2\u0236\u0237\7{\2\2\u0237"+
		"\u0238\7k\2\2\u0238\u0239\7g\2\2\u0239\u023a\7n\2\2\u023a\u023b\7f\2\2"+
		"\u023b\u0092\3\2\2\2\u023c\u023d\7d\2\2\u023d\u023e\7t\2\2\u023e\u023f"+
		"\7g\2\2\u023f\u0240\7c\2\2\u0240\u0241\7m\2\2\u0241\u0094\3\2\2\2\u0242"+
		"\u0243\7e\2\2\u0243\u0244\7q\2\2\u0244\u0245\7p\2\2\u0245\u0246\7v\2\2"+
		"\u0246\u0247\7k\2\2\u0247\u0248\7p\2\2\u0248\u0249\7w\2\2\u0249\u024a"+
		"\7g\2\2\u024a\u0096\3\2\2\2\u024b\u024c\7t\2\2\u024c\u024d\7c\2\2\u024d"+
		"\u024e\7k\2\2\u024e\u024f\7u\2\2\u024f\u0250\7g\2\2\u0250\u0098\3\2\2"+
		"\2\u0251\u0252\7e\2\2\u0252\u0253\7c\2\2\u0253\u0254\7v\2\2\u0254\u0255"+
		"\7e\2\2\u0255\u0256\7j\2\2\u0256\u009a\3\2\2\2\u0257\u0258\7p\2\2\u0258"+
		"\u0259\7w\2\2\u0259\u025a\7n\2\2\u025a\u025b\7n\2\2\u025b\u009c\3\2\2"+
		"\2\u025c\u025d\7v\2\2\u025d\u025e\7t\2\2\u025e\u025f\7w\2\2\u025f\u0260"+
		"\7g\2\2\u0260\u009e\3\2\2\2\u0261\u0262\7h\2\2\u0262\u0263\7c\2\2\u0263"+
		"\u0264\7n\2\2\u0264\u0265\7u\2\2\u0265\u0266\7g\2\2\u0266\u00a0\3\2\2"+
		"\2\u0267\u026b\5\u009bN\2\u0268\u026b\5\u009dO\2\u0269\u026b\5\u009fP"+
		"\2\u026a\u0267\3\2\2\2\u026a\u0268\3\2\2\2\u026a\u0269\3\2\2\2\u026b\u00a2"+
		"\3\2\2\2\u026c\u026d\7\61\2\2\u026d\u026e\7\61\2\2\u026e\u0272\3\2\2\2"+
		"\u026f\u0271\13\2\2\2\u0270\u026f\3\2\2\2\u0271\u0274\3\2\2\2\u0272\u0273"+
		"\3\2\2\2\u0272\u0270\3\2\2\2\u0273\u0276\3\2\2\2\u0274\u0272\3\2\2\2\u0275"+
		"\u0277\t\16\2\2\u0276\u0275\3\2\2\2\u0277\u0278\3\2\2\2\u0278\u0279\b"+
		"R\2\2\u0279\u00a4\3\2\2\2\u027a\u027b\7\61\2\2\u027b\u027c\7,\2\2\u027c"+
		"\u0280\3\2\2\2\u027d\u027f\13\2\2\2\u027e\u027d\3\2\2\2\u027f\u0282\3"+
		"\2\2\2\u0280\u0281\3\2\2\2\u0280\u027e\3\2\2\2\u0281\u0283\3\2\2\2\u0282"+
		"\u0280\3\2\2\2\u0283\u0284\7,\2\2\u0284\u0285\7\61\2\2\u0285\u0286\3\2"+
		"\2\2\u0286\u0287\bS\2\2\u0287\u00a6\3\2\2\2\u0288\u028a\t\17\2\2\u0289"+
		"\u0288\3\2\2\2\u028a\u028b\3\2\2\2\u028b\u0289\3\2\2\2\u028b\u028c\3\2"+
		"\2\2\u028c\u028d\3\2\2\2\u028d\u028e\bT\2\2\u028e\u00a8\3\2\2\2\u028f"+
		"\u0290\13\2\2\2\u0290\u0291\3\2\2\2\u0291\u0292\bU\2\2\u0292\u00aa\3\2"+
		"\2\2\"\2\u00b4\u00d7\u00dd\u00e2\u00e9\u00ef\u00f4\u00f9\u00fe\u0113\u0128"+
		"\u012d\u0137\u013f\u016c\u0185\u019e\u01ae\u01be\u01ee\u01f1\u01f7\u01fc"+
		"\u0200\u0207\u0209\u026a\u0272\u0276\u0280\u028b\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}