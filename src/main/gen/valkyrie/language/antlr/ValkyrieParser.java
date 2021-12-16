// Generated from C:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr\Valkyrie.g4 by ANTLR 4.12.0
package valkyrie.language.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ValkyrieParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, EOS=6, KW_NAMESPACE=7, KW_IMPORT=8, 
		KW_EXTENSION=9, KW_CLASS=10, KW_TRAIT=11, KW_UNION=12, KW_LET=13, KW_FUNCTION=14, 
		AS=15, IS=16, IN=17, NOT=18, LPAREN=19, RPAREN=20, COLON=21, COMMA=22, 
		LBRACK=23, RBRACK=24, LBRACE=25, RBRACE=26, IF=27, ELSE=28, WHILE=29, 
		EQUAL=30, RETURN=31, RESUME=32, YIELD=33, BREAK=34, CONTINUE=35, RAISE=36, 
		CATCH=37, NULL=38, TRUE=39, FALSE=40, SUB=41, BANG=42, MUL=43, DIV=44, 
		ADD=45, LT=46, LE=47, EQUAL_EQUAL=48, NOT_EQUAL=49, GT=50, GE=51, OR=52, 
		AND=53, DOT=54, LINE_COMMENT=55, COMMENT=56, UNICODE_ID=57, INTEGER=58, 
		DECIMAL=59, STRING=60, WS=61, ERRCHAR=62;
	public static final int
		RULE_program = 0, RULE_top_statement = 1, RULE_define_namespace = 2, RULE_import_statement = 3, 
		RULE_define_extension = 4, RULE_define_class = 5, RULE_class_statements = 6, 
		RULE_define_trait = 7, RULE_trait_statements = 8, RULE_define_union = 9, 
		RULE_union_statements = 10, RULE_define_variale = 11, RULE_define_function = 12, 
		RULE_formal_args = 13, RULE_formal_arg = 14, RULE_type = 15, RULE_block = 16, 
		RULE_statement = 17, RULE_expr = 18, RULE_operator = 19, RULE_call_expr = 20, 
		RULE_expr_list = 21, RULE_primary = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "top_statement", "define_namespace", "import_statement", "define_extension", 
			"define_class", "class_statements", "define_trait", "trait_statements", 
			"define_union", "union_statements", "define_variale", "define_function", 
			"formal_args", "formal_arg", "type", "block", "statement", "expr", "operator", 
			"call_expr", "expr_list", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'float'", "'string'", "'boolean'", "'print'", "';'", 
			null, null, "'extension'", null, null, "'union'", "'let'", "'def'", null, 
			"'is'", "'in'", "'not'", "'('", "')'", "':'", "','", "'['", "']'", "'{'", 
			"'}'", "'if'", "'else'", "'while'", "'='", "'return'", "'resume'", "'yield'", 
			"'break'", "'continue'", "'raise'", "'catch'", "'null'", "'true'", "'false'", 
			"'-'", "'!'", "'*'", "'/'", "'+'", "'<'", "'<='", "'=='", "'!='", "'>'", 
			"'>='", "'||'", "'&&'", "' . '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "EOS", "KW_NAMESPACE", "KW_IMPORT", 
			"KW_EXTENSION", "KW_CLASS", "KW_TRAIT", "KW_UNION", "KW_LET", "KW_FUNCTION", 
			"AS", "IS", "IN", "NOT", "LPAREN", "RPAREN", "COLON", "COMMA", "LBRACK", 
			"RBRACK", "LBRACE", "RBRACE", "IF", "ELSE", "WHILE", "EQUAL", "RETURN", 
			"RESUME", "YIELD", "BREAK", "CONTINUE", "RAISE", "CATCH", "NULL", "TRUE", 
			"FALSE", "SUB", "BANG", "MUL", "DIV", "ADD", "LT", "LE", "EQUAL_EQUAL", 
			"NOT_EQUAL", "GT", "GE", "OR", "AND", "DOT", "LINE_COMMENT", "COMMENT", 
			"UNICODE_ID", "INTEGER", "DECIMAL", "STRING", "WS", "ERRCHAR"
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

	@Override
	public String getGrammarFileName() { return "Valkyrie.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ValkyrieParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ValkyrieParser.EOF, 0); }
		public List<Top_statementContext> top_statement() {
			return getRuleContexts(Top_statementContext.class);
		}
		public Top_statementContext top_statement(int i) {
			return getRuleContext(Top_statementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32640L) != 0)) {
				{
				{
				setState(46);
				top_statement();
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Top_statementContext extends ParserRuleContext {
		public Define_namespaceContext define_namespace() {
			return getRuleContext(Define_namespaceContext.class,0);
		}
		public TerminalNode EOS() { return getToken(ValkyrieParser.EOS, 0); }
		public Import_statementContext import_statement() {
			return getRuleContext(Import_statementContext.class,0);
		}
		public Define_extensionContext define_extension() {
			return getRuleContext(Define_extensionContext.class,0);
		}
		public Define_classContext define_class() {
			return getRuleContext(Define_classContext.class,0);
		}
		public Define_unionContext define_union() {
			return getRuleContext(Define_unionContext.class,0);
		}
		public Define_traitContext define_trait() {
			return getRuleContext(Define_traitContext.class,0);
		}
		public Define_varialeContext define_variale() {
			return getRuleContext(Define_varialeContext.class,0);
		}
		public Define_functionContext define_function() {
			return getRuleContext(Define_functionContext.class,0);
		}
		public Top_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterTop_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitTop_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitTop_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Top_statementContext top_statement() throws RecognitionException {
		Top_statementContext _localctx = new Top_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_top_statement);
		int _la;
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_NAMESPACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				define_namespace();
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOS) {
					{
					setState(55);
					match(EOS);
					}
				}

				}
				break;
			case KW_IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				import_statement();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOS) {
					{
					setState(59);
					match(EOS);
					}
				}

				}
				break;
			case KW_EXTENSION:
				enterOuterAlt(_localctx, 3);
				{
				setState(62);
				define_extension();
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOS) {
					{
					setState(63);
					match(EOS);
					}
				}

				}
				break;
			case KW_CLASS:
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				define_class();
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOS) {
					{
					setState(67);
					match(EOS);
					}
				}

				}
				break;
			case KW_UNION:
				enterOuterAlt(_localctx, 5);
				{
				setState(70);
				define_union();
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOS) {
					{
					setState(71);
					match(EOS);
					}
				}

				}
				break;
			case KW_TRAIT:
				enterOuterAlt(_localctx, 6);
				{
				setState(74);
				define_trait();
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOS) {
					{
					setState(75);
					match(EOS);
					}
				}

				}
				break;
			case KW_LET:
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				define_variale();
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOS) {
					{
					setState(79);
					match(EOS);
					}
				}

				}
				break;
			case KW_FUNCTION:
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				define_function();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EOS) {
					{
					setState(83);
					match(EOS);
					}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Define_namespaceContext extends ParserRuleContext {
		public TerminalNode KW_NAMESPACE() { return getToken(ValkyrieParser.KW_NAMESPACE, 0); }
		public Define_namespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_namespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_namespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_namespace(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_namespaceContext define_namespace() throws RecognitionException {
		Define_namespaceContext _localctx = new Define_namespaceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_define_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(KW_NAMESPACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Import_statementContext extends ParserRuleContext {
		public TerminalNode KW_IMPORT() { return getToken(ValkyrieParser.KW_IMPORT, 0); }
		public Import_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterImport_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitImport_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitImport_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_statementContext import_statement() throws RecognitionException {
		Import_statementContext _localctx = new Import_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_import_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(KW_IMPORT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Define_extensionContext extends ParserRuleContext {
		public TerminalNode KW_EXTENSION() { return getToken(ValkyrieParser.KW_EXTENSION, 0); }
		public Define_extensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_extension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_extension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_extension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_extension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_extensionContext define_extension() throws RecognitionException {
		Define_extensionContext _localctx = new Define_extensionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_define_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(KW_EXTENSION);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Define_classContext extends ParserRuleContext {
		public Token name;
		public TerminalNode KW_CLASS() { return getToken(ValkyrieParser.KW_CLASS, 0); }
		public TerminalNode LBRACE() { return getToken(ValkyrieParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ValkyrieParser.RBRACE, 0); }
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public List<Class_statementsContext> class_statements() {
			return getRuleContexts(Class_statementsContext.class);
		}
		public Class_statementsContext class_statements(int i) {
			return getRuleContext(Class_statementsContext.class,i);
		}
		public Define_classContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_class(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_class(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_classContext define_class() throws RecognitionException {
		Define_classContext _localctx = new Define_classContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_define_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(KW_CLASS);
			setState(95);
			((Define_classContext)_localctx).name = match(UNICODE_ID);
			setState(96);
			match(LBRACE);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_FUNCTION) {
				{
				{
				setState(97);
				class_statements();
				}
				}
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(103);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Class_statementsContext extends ParserRuleContext {
		public Define_functionContext define_function() {
			return getRuleContext(Define_functionContext.class,0);
		}
		public TerminalNode EOS() { return getToken(ValkyrieParser.EOS, 0); }
		public Class_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterClass_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitClass_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitClass_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_statementsContext class_statements() throws RecognitionException {
		Class_statementsContext _localctx = new Class_statementsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_class_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			define_function();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOS) {
				{
				setState(106);
				match(EOS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Define_traitContext extends ParserRuleContext {
		public Token name;
		public TerminalNode KW_TRAIT() { return getToken(ValkyrieParser.KW_TRAIT, 0); }
		public TerminalNode LBRACE() { return getToken(ValkyrieParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ValkyrieParser.RBRACE, 0); }
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public List<Trait_statementsContext> trait_statements() {
			return getRuleContexts(Trait_statementsContext.class);
		}
		public Trait_statementsContext trait_statements(int i) {
			return getRuleContext(Trait_statementsContext.class,i);
		}
		public Define_traitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_trait; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_trait(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_trait(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_trait(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_traitContext define_trait() throws RecognitionException {
		Define_traitContext _localctx = new Define_traitContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_define_trait);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(KW_TRAIT);
			setState(110);
			((Define_traitContext)_localctx).name = match(UNICODE_ID);
			setState(111);
			match(LBRACE);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_FUNCTION) {
				{
				{
				setState(112);
				trait_statements();
				}
				}
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(118);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Trait_statementsContext extends ParserRuleContext {
		public Define_functionContext define_function() {
			return getRuleContext(Define_functionContext.class,0);
		}
		public TerminalNode EOS() { return getToken(ValkyrieParser.EOS, 0); }
		public Trait_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trait_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterTrait_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitTrait_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitTrait_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trait_statementsContext trait_statements() throws RecognitionException {
		Trait_statementsContext _localctx = new Trait_statementsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_trait_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			define_function();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOS) {
				{
				setState(121);
				match(EOS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Define_unionContext extends ParserRuleContext {
		public Token name;
		public TerminalNode KW_UNION() { return getToken(ValkyrieParser.KW_UNION, 0); }
		public TerminalNode LBRACE() { return getToken(ValkyrieParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ValkyrieParser.RBRACE, 0); }
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public List<Union_statementsContext> union_statements() {
			return getRuleContexts(Union_statementsContext.class);
		}
		public Union_statementsContext union_statements(int i) {
			return getRuleContext(Union_statementsContext.class,i);
		}
		public Define_unionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_union; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_union(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_union(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_union(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_unionContext define_union() throws RecognitionException {
		Define_unionContext _localctx = new Define_unionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_define_union);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(KW_UNION);
			setState(125);
			((Define_unionContext)_localctx).name = match(UNICODE_ID);
			setState(126);
			match(LBRACE);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_FUNCTION) {
				{
				{
				setState(127);
				union_statements();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Union_statementsContext extends ParserRuleContext {
		public Define_functionContext define_function() {
			return getRuleContext(Define_functionContext.class,0);
		}
		public TerminalNode EOS() { return getToken(ValkyrieParser.EOS, 0); }
		public Union_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterUnion_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitUnion_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitUnion_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Union_statementsContext union_statements() throws RecognitionException {
		Union_statementsContext _localctx = new Union_statementsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_union_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			define_function();
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EOS) {
				{
				setState(136);
				match(EOS);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Define_varialeContext extends ParserRuleContext {
		public Token name;
		public TerminalNode KW_LET() { return getToken(ValkyrieParser.KW_LET, 0); }
		public TerminalNode EQUAL() { return getToken(ValkyrieParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public Define_varialeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_variale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_variale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_variale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_variale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_varialeContext define_variale() throws RecognitionException {
		Define_varialeContext _localctx = new Define_varialeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_define_variale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(KW_LET);
			setState(140);
			((Define_varialeContext)_localctx).name = match(UNICODE_ID);
			setState(141);
			match(EQUAL);
			setState(142);
			expr(0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Define_functionContext extends ParserRuleContext {
		public TerminalNode KW_FUNCTION() { return getToken(ValkyrieParser.KW_FUNCTION, 0); }
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public TerminalNode LPAREN() { return getToken(ValkyrieParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ValkyrieParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Formal_argsContext formal_args() {
			return getRuleContext(Formal_argsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Define_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_functionContext define_function() throws RecognitionException {
		Define_functionContext _localctx = new Define_functionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_define_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(KW_FUNCTION);
			setState(145);
			match(UNICODE_ID);
			setState(146);
			match(LPAREN);
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNICODE_ID) {
				{
				setState(147);
				formal_args();
				}
			}

			setState(150);
			match(RPAREN);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(151);
				match(COLON);
				setState(152);
				type();
				}
			}

			setState(155);
			block();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Formal_argsContext extends ParserRuleContext {
		public List<Formal_argContext> formal_arg() {
			return getRuleContexts(Formal_argContext.class);
		}
		public Formal_argContext formal_arg(int i) {
			return getRuleContext(Formal_argContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieParser.COMMA, i);
		}
		public Formal_argsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFormal_args(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFormal_args(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFormal_args(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_argsContext formal_args() throws RecognitionException {
		Formal_argsContext _localctx = new Formal_argsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_formal_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			formal_arg();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(158);
				match(COMMA);
				setState(159);
				formal_arg();
				}
				}
				setState(164);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Formal_argContext extends ParserRuleContext {
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public TerminalNode COLON() { return getToken(ValkyrieParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Formal_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFormal_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFormal_arg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFormal_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_argContext formal_arg() throws RecognitionException {
		Formal_argContext _localctx = new Formal_argContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_formal_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(UNICODE_ID);
			setState(166);
			match(COLON);
			setState(167);
			type();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanTypeSpecContext extends TypeContext {
		public BooleanTypeSpecContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterBooleanTypeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitBooleanTypeSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitBooleanTypeSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntTypeSpecContext extends TypeContext {
		public IntTypeSpecContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterIntTypeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitIntTypeSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitIntTypeSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringTypeSpecContext extends TypeContext {
		public StringTypeSpecContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterStringTypeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitStringTypeSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitStringTypeSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorTypeSpecContext extends TypeContext {
		public TerminalNode LBRACK() { return getToken(ValkyrieParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(ValkyrieParser.RBRACK, 0); }
		public VectorTypeSpecContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterVectorTypeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitVectorTypeSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitVectorTypeSpec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatTypeSpecContext extends TypeContext {
		public FloatTypeSpecContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFloatTypeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFloatTypeSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFloatTypeSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				_localctx = new IntTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(169);
				match(T__0);
				}
				break;
			case T__1:
				_localctx = new FloatTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(170);
				match(T__1);
				}
				break;
			case T__2:
				_localctx = new StringTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(171);
				match(T__2);
				}
				break;
			case T__3:
				_localctx = new BooleanTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(172);
				match(T__3);
				}
				break;
			case LBRACK:
				_localctx = new VectorTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				match(LBRACK);
				setState(174);
				match(RBRACK);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(ValkyrieParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(ValkyrieParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<Define_varialeContext> define_variale() {
			return getRuleContexts(Define_varialeContext.class);
		}
		public Define_varialeContext define_variale(int i) {
			return getRuleContext(Define_varialeContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(LBRACE);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 144115190927990816L) != 0)) {
				{
				setState(180);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
				case LBRACE:
				case IF:
				case WHILE:
				case RETURN:
				case UNICODE_ID:
					{
					setState(178);
					statement();
					}
					break;
				case KW_LET:
					{
					setState(179);
					define_variale();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(185);
			match(RBRACE);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElementAssignContext extends StatementContext {
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public TerminalNode LBRACK() { return getToken(ValkyrieParser.LBRACK, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(ValkyrieParser.RBRACK, 0); }
		public TerminalNode EQUAL() { return getToken(ValkyrieParser.EQUAL, 0); }
		public ElementAssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterElementAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitElementAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitElementAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends StatementContext {
		public TerminalNode LPAREN() { return getToken(ValkyrieParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ValkyrieParser.RPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrintContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(ValkyrieParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends StatementContext {
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public TerminalNode EQUAL() { return getToken(ValkyrieParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(ValkyrieParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(ValkyrieParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ValkyrieParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallStatementContext extends StatementContext {
		public Call_exprContext call_expr() {
			return getRuleContext(Call_exprContext.class,0);
		}
		public CallStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterCallStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitCallStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitCallStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfContext extends StatementContext {
		public TerminalNode IF() { return getToken(ValkyrieParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(ValkyrieParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ValkyrieParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(ValkyrieParser.ELSE, 0); }
		public IfContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_statement);
		int _la;
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(IF);
				setState(188);
				match(LPAREN);
				setState(189);
				expr(0);
				setState(190);
				match(RPAREN);
				setState(191);
				statement();
				setState(194);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(192);
					match(ELSE);
					setState(193);
					statement();
					}
					break;
				}
				}
				break;
			case 2:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(WHILE);
				setState(197);
				match(LPAREN);
				setState(198);
				expr(0);
				setState(199);
				match(RPAREN);
				setState(200);
				statement();
				}
				break;
			case 3:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				match(UNICODE_ID);
				setState(203);
				match(EQUAL);
				setState(204);
				expr(0);
				}
				break;
			case 4:
				_localctx = new ElementAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(205);
				match(UNICODE_ID);
				setState(206);
				match(LBRACK);
				setState(207);
				expr(0);
				setState(208);
				match(RBRACK);
				setState(209);
				match(EQUAL);
				setState(210);
				expr(0);
				}
				break;
			case 5:
				_localctx = new CallStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				call_expr();
				}
				break;
			case 6:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(213);
				match(T__4);
				setState(214);
				match(LPAREN);
				setState(216);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2161736067483959296L) != 0)) {
					{
					setState(215);
					expr(0);
					}
				}

				setState(218);
				match(RPAREN);
				}
				break;
			case 7:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(219);
				match(RETURN);
				setState(220);
				expr(0);
				}
				break;
			case 8:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(221);
				block();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CallContext extends ExprContext {
		public Call_exprContext call_expr() {
			return getRuleContext(Call_exprContext.class,0);
		}
		public CallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OpContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public OpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExprContext {
		public TerminalNode BANG() { return getToken(ValkyrieParser.BANG, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExprContext {
		public TerminalNode LPAREN() { return getToken(ValkyrieParser.LPAREN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(ValkyrieParser.RPAREN, 0); }
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexContext extends ExprContext {
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public TerminalNode LBRACK() { return getToken(ValkyrieParser.LBRACK, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ValkyrieParser.RBRACK, 0); }
		public IndexContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitIndex(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitIndex(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateContext extends ExprContext {
		public TerminalNode SUB() { return getToken(ValkyrieParser.SUB, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterNegate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitNegate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitNegate(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ExprContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public AtomContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(225);
				match(SUB);
				setState(226);
				expr(6);
				}
				break;
			case 2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(BANG);
				setState(228);
				expr(5);
				}
				break;
			case 3:
				{
				_localctx = new CallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				call_expr();
				}
				break;
			case 4:
				{
				_localctx = new IndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(230);
				match(UNICODE_ID);
				setState(231);
				match(LBRACK);
				setState(232);
				expr(0);
				setState(233);
				match(RBRACK);
				}
				break;
			case 5:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				match(LPAREN);
				setState(236);
				expr(0);
				setState(237);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new AtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(239);
				primary();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(242);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(243);
					operator();
					setState(244);
					expr(8);
					}
					} 
				}
				setState(250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode MUL() { return getToken(ValkyrieParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(ValkyrieParser.DIV, 0); }
		public TerminalNode ADD() { return getToken(ValkyrieParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(ValkyrieParser.SUB, 0); }
		public TerminalNode GT() { return getToken(ValkyrieParser.GT, 0); }
		public TerminalNode GE() { return getToken(ValkyrieParser.GE, 0); }
		public TerminalNode LT() { return getToken(ValkyrieParser.LT, 0); }
		public TerminalNode LE() { return getToken(ValkyrieParser.LE, 0); }
		public TerminalNode EQUAL_EQUAL() { return getToken(ValkyrieParser.EQUAL_EQUAL, 0); }
		public TerminalNode NOT_EQUAL() { return getToken(ValkyrieParser.NOT_EQUAL, 0); }
		public TerminalNode OR() { return getToken(ValkyrieParser.OR, 0); }
		public TerminalNode AND() { return getToken(ValkyrieParser.AND, 0); }
		public TerminalNode DOT() { return getToken(ValkyrieParser.DOT, 0); }
		public TerminalNode IS() { return getToken(ValkyrieParser.IS, 0); }
		public TerminalNode NOT() { return getToken(ValkyrieParser.NOT, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_operator);
		try {
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(251);
				match(MUL);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252);
				match(DIV);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(253);
				match(ADD);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(254);
				match(SUB);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(255);
				match(GT);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(256);
				match(GE);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(257);
				match(LT);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(258);
				match(LE);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(259);
				match(EQUAL_EQUAL);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(260);
				match(NOT_EQUAL);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(261);
				match(OR);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(262);
				match(AND);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(263);
				match(DOT);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(264);
				match(IS);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(265);
				match(IS);
				setState(266);
				match(NOT);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Call_exprContext extends ParserRuleContext {
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public TerminalNode LPAREN() { return getToken(ValkyrieParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(ValkyrieParser.RPAREN, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public Call_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterCall_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitCall_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitCall_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_exprContext call_expr() throws RecognitionException {
		Call_exprContext _localctx = new Call_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_call_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(UNICODE_ID);
			setState(270);
			match(LPAREN);
			setState(272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2161736067483959296L) != 0)) {
				{
				setState(271);
				expr_list();
				}
			}

			setState(274);
			match(RPAREN);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieParser.COMMA, i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterExpr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitExpr_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitExpr_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			expr(0);
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(277);
				match(COMMA);
				setState(278);
				expr(0);
				}
				}
				setState(283);
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

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	 
		public PrimaryContext() { }
		public void copyFrom(PrimaryContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends PrimaryContext {
		public TerminalNode INTEGER() { return getToken(ValkyrieParser.INTEGER, 0); }
		public IntegerContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends PrimaryContext {
		public TerminalNode DECIMAL() { return getToken(ValkyrieParser.DECIMAL, 0); }
		public FloatContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends PrimaryContext {
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public IdentifierContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueLiteralContext extends PrimaryContext {
		public TerminalNode TRUE() { return getToken(ValkyrieParser.TRUE, 0); }
		public TrueLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterTrueLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitTrueLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitTrueLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends PrimaryContext {
		public TerminalNode STRING() { return getToken(ValkyrieParser.STRING, 0); }
		public StringContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VectorContext extends PrimaryContext {
		public TerminalNode LBRACK() { return getToken(ValkyrieParser.LBRACK, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(ValkyrieParser.RBRACK, 0); }
		public VectorContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitVector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseLiteralContext extends PrimaryContext {
		public TerminalNode FALSE() { return getToken(ValkyrieParser.FALSE, 0); }
		public FalseLiteralContext(PrimaryContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFalseLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFalseLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFalseLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_primary);
		try {
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNICODE_ID:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(UNICODE_ID);
				}
				break;
			case INTEGER:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(285);
				match(INTEGER);
				}
				break;
			case DECIMAL:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(286);
				match(DECIMAL);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(287);
				match(STRING);
				}
				break;
			case LBRACK:
				_localctx = new VectorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(288);
				match(LBRACK);
				setState(289);
				expr_list();
				setState(290);
				match(RBRACK);
				}
				break;
			case TRUE:
				_localctx = new TrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(292);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(293);
				match(FALSE);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 18:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001>\u0129\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0001\u0000\u0005\u00000\b\u0000\n\u0000\f\u0000"+
		"3\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0003\u0001"+
		"9\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001=\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001A\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001E\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001I\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001M\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001Q\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001U\b\u0001\u0003\u0001W\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005c\b\u0005\n\u0005\f\u0005"+
		"f\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006"+
		"l\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"r\b\u0007\n\u0007\f\u0007u\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0003\b{\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0081\b\t\n\t"+
		"\f\t\u0084\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u008a\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0003\f\u0095\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u009a"+
		"\b\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0005\r\u00a1\b\r\n\r\f\r"+
		"\u00a4\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00b0\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00b5\b"+
		"\u0010\n\u0010\f\u0010\u00b8\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00c3\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00d9\b\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00df\b\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00f1\b\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00f7\b\u0012"+
		"\n\u0012\f\u0012\u00fa\t\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u010c\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0003"+
		"\u0014\u0111\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u0118\b\u0015\n\u0015\f\u0015\u011b\t\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0127\b\u0016\u0001\u0016"+
		"\u0000\u0001$\u0017\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,\u0000\u0000\u0155\u00001\u0001"+
		"\u0000\u0000\u0000\u0002V\u0001\u0000\u0000\u0000\u0004X\u0001\u0000\u0000"+
		"\u0000\u0006Z\u0001\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000\n^\u0001"+
		"\u0000\u0000\u0000\fi\u0001\u0000\u0000\u0000\u000em\u0001\u0000\u0000"+
		"\u0000\u0010x\u0001\u0000\u0000\u0000\u0012|\u0001\u0000\u0000\u0000\u0014"+
		"\u0087\u0001\u0000\u0000\u0000\u0016\u008b\u0001\u0000\u0000\u0000\u0018"+
		"\u0090\u0001\u0000\u0000\u0000\u001a\u009d\u0001\u0000\u0000\u0000\u001c"+
		"\u00a5\u0001\u0000\u0000\u0000\u001e\u00af\u0001\u0000\u0000\u0000 \u00b1"+
		"\u0001\u0000\u0000\u0000\"\u00de\u0001\u0000\u0000\u0000$\u00f0\u0001"+
		"\u0000\u0000\u0000&\u010b\u0001\u0000\u0000\u0000(\u010d\u0001\u0000\u0000"+
		"\u0000*\u0114\u0001\u0000\u0000\u0000,\u0126\u0001\u0000\u0000\u0000."+
		"0\u0003\u0002\u0001\u0000/.\u0001\u0000\u0000\u000003\u0001\u0000\u0000"+
		"\u00001/\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u000024\u0001\u0000"+
		"\u0000\u000031\u0001\u0000\u0000\u000045\u0005\u0000\u0000\u00015\u0001"+
		"\u0001\u0000\u0000\u000068\u0003\u0004\u0002\u000079\u0005\u0006\u0000"+
		"\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009W\u0001\u0000"+
		"\u0000\u0000:<\u0003\u0006\u0003\u0000;=\u0005\u0006\u0000\u0000<;\u0001"+
		"\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=W\u0001\u0000\u0000\u0000"+
		">@\u0003\b\u0004\u0000?A\u0005\u0006\u0000\u0000@?\u0001\u0000\u0000\u0000"+
		"@A\u0001\u0000\u0000\u0000AW\u0001\u0000\u0000\u0000BD\u0003\n\u0005\u0000"+
		"CE\u0005\u0006\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EW\u0001\u0000\u0000\u0000FH\u0003\u0012\t\u0000GI\u0005\u0006\u0000"+
		"\u0000HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IW\u0001\u0000"+
		"\u0000\u0000JL\u0003\u000e\u0007\u0000KM\u0005\u0006\u0000\u0000LK\u0001"+
		"\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MW\u0001\u0000\u0000\u0000"+
		"NP\u0003\u0016\u000b\u0000OQ\u0005\u0006\u0000\u0000PO\u0001\u0000\u0000"+
		"\u0000PQ\u0001\u0000\u0000\u0000QW\u0001\u0000\u0000\u0000RT\u0003\u0018"+
		"\f\u0000SU\u0005\u0006\u0000\u0000TS\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000UW\u0001\u0000\u0000\u0000V6\u0001\u0000\u0000\u0000V:\u0001"+
		"\u0000\u0000\u0000V>\u0001\u0000\u0000\u0000VB\u0001\u0000\u0000\u0000"+
		"VF\u0001\u0000\u0000\u0000VJ\u0001\u0000\u0000\u0000VN\u0001\u0000\u0000"+
		"\u0000VR\u0001\u0000\u0000\u0000W\u0003\u0001\u0000\u0000\u0000XY\u0005"+
		"\u0007\u0000\u0000Y\u0005\u0001\u0000\u0000\u0000Z[\u0005\b\u0000\u0000"+
		"[\u0007\u0001\u0000\u0000\u0000\\]\u0005\t\u0000\u0000]\t\u0001\u0000"+
		"\u0000\u0000^_\u0005\n\u0000\u0000_`\u00059\u0000\u0000`d\u0005\u0019"+
		"\u0000\u0000ac\u0003\f\u0006\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000\u0000eg\u0001"+
		"\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gh\u0005\u001a\u0000\u0000"+
		"h\u000b\u0001\u0000\u0000\u0000ik\u0003\u0018\f\u0000jl\u0005\u0006\u0000"+
		"\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000l\r\u0001\u0000"+
		"\u0000\u0000mn\u0005\u000b\u0000\u0000no\u00059\u0000\u0000os\u0005\u0019"+
		"\u0000\u0000pr\u0003\u0010\b\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000tv\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vw\u0005\u001a\u0000\u0000"+
		"w\u000f\u0001\u0000\u0000\u0000xz\u0003\u0018\f\u0000y{\u0005\u0006\u0000"+
		"\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u0011\u0001"+
		"\u0000\u0000\u0000|}\u0005\f\u0000\u0000}~\u00059\u0000\u0000~\u0082\u0005"+
		"\u0019\u0000\u0000\u007f\u0081\u0003\u0014\n\u0000\u0080\u007f\u0001\u0000"+
		"\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u0085\u0001\u0000"+
		"\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0085\u0086\u0005\u001a"+
		"\u0000\u0000\u0086\u0013\u0001\u0000\u0000\u0000\u0087\u0089\u0003\u0018"+
		"\f\u0000\u0088\u008a\u0005\u0006\u0000\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u0015\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0005\r\u0000\u0000\u008c\u008d\u00059\u0000\u0000"+
		"\u008d\u008e\u0005\u001e\u0000\u0000\u008e\u008f\u0003$\u0012\u0000\u008f"+
		"\u0017\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u000e\u0000\u0000\u0091"+
		"\u0092\u00059\u0000\u0000\u0092\u0094\u0005\u0013\u0000\u0000\u0093\u0095"+
		"\u0003\u001a\r\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001"+
		"\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0099\u0005"+
		"\u0014\u0000\u0000\u0097\u0098\u0005\u0015\u0000\u0000\u0098\u009a\u0003"+
		"\u001e\u000f\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u009c\u0003"+
		" \u0010\u0000\u009c\u0019\u0001\u0000\u0000\u0000\u009d\u00a2\u0003\u001c"+
		"\u000e\u0000\u009e\u009f\u0005\u0016\u0000\u0000\u009f\u00a1\u0003\u001c"+
		"\u000e\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a3\u001b\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a6\u00059\u0000\u0000\u00a6\u00a7\u0005\u0015\u0000"+
		"\u0000\u00a7\u00a8\u0003\u001e\u000f\u0000\u00a8\u001d\u0001\u0000\u0000"+
		"\u0000\u00a9\u00b0\u0005\u0001\u0000\u0000\u00aa\u00b0\u0005\u0002\u0000"+
		"\u0000\u00ab\u00b0\u0005\u0003\u0000\u0000\u00ac\u00b0\u0005\u0004\u0000"+
		"\u0000\u00ad\u00ae\u0005\u0017\u0000\u0000\u00ae\u00b0\u0005\u0018\u0000"+
		"\u0000\u00af\u00a9\u0001\u0000\u0000\u0000\u00af\u00aa\u0001\u0000\u0000"+
		"\u0000\u00af\u00ab\u0001\u0000\u0000\u0000\u00af\u00ac\u0001\u0000\u0000"+
		"\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u001f\u0001\u0000\u0000"+
		"\u0000\u00b1\u00b6\u0005\u0019\u0000\u0000\u00b2\u00b5\u0003\"\u0011\u0000"+
		"\u00b3\u00b5\u0003\u0016\u000b\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b9\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b9\u00ba\u0005\u001a\u0000\u0000\u00ba!\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0005\u001b\u0000\u0000\u00bc\u00bd\u0005\u0013\u0000\u0000\u00bd"+
		"\u00be\u0003$\u0012\u0000\u00be\u00bf\u0005\u0014\u0000\u0000\u00bf\u00c2"+
		"\u0003\"\u0011\u0000\u00c0\u00c1\u0005\u001c\u0000\u0000\u00c1\u00c3\u0003"+
		"\"\u0011\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000"+
		"\u0000\u0000\u00c3\u00df\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u001d"+
		"\u0000\u0000\u00c5\u00c6\u0005\u0013\u0000\u0000\u00c6\u00c7\u0003$\u0012"+
		"\u0000\u00c7\u00c8\u0005\u0014\u0000\u0000\u00c8\u00c9\u0003\"\u0011\u0000"+
		"\u00c9\u00df\u0001\u0000\u0000\u0000\u00ca\u00cb\u00059\u0000\u0000\u00cb"+
		"\u00cc\u0005\u001e\u0000\u0000\u00cc\u00df\u0003$\u0012\u0000\u00cd\u00ce"+
		"\u00059\u0000\u0000\u00ce\u00cf\u0005\u0017\u0000\u0000\u00cf\u00d0\u0003"+
		"$\u0012\u0000\u00d0\u00d1\u0005\u0018\u0000\u0000\u00d1\u00d2\u0005\u001e"+
		"\u0000\u0000\u00d2\u00d3\u0003$\u0012\u0000\u00d3\u00df\u0001\u0000\u0000"+
		"\u0000\u00d4\u00df\u0003(\u0014\u0000\u00d5\u00d6\u0005\u0005\u0000\u0000"+
		"\u00d6\u00d8\u0005\u0013\u0000\u0000\u00d7\u00d9\u0003$\u0012\u0000\u00d8"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00da\u00df\u0005\u0014\u0000\u0000\u00db"+
		"\u00dc\u0005\u001f\u0000\u0000\u00dc\u00df\u0003$\u0012\u0000\u00dd\u00df"+
		"\u0003 \u0010\u0000\u00de\u00bb\u0001\u0000\u0000\u0000\u00de\u00c4\u0001"+
		"\u0000\u0000\u0000\u00de\u00ca\u0001\u0000\u0000\u0000\u00de\u00cd\u0001"+
		"\u0000\u0000\u0000\u00de\u00d4\u0001\u0000\u0000\u0000\u00de\u00d5\u0001"+
		"\u0000\u0000\u0000\u00de\u00db\u0001\u0000\u0000\u0000\u00de\u00dd\u0001"+
		"\u0000\u0000\u0000\u00df#\u0001\u0000\u0000\u0000\u00e0\u00e1\u0006\u0012"+
		"\uffff\uffff\u0000\u00e1\u00e2\u0005)\u0000\u0000\u00e2\u00f1\u0003$\u0012"+
		"\u0006\u00e3\u00e4\u0005*\u0000\u0000\u00e4\u00f1\u0003$\u0012\u0005\u00e5"+
		"\u00f1\u0003(\u0014\u0000\u00e6\u00e7\u00059\u0000\u0000\u00e7\u00e8\u0005"+
		"\u0017\u0000\u0000\u00e8\u00e9\u0003$\u0012\u0000\u00e9\u00ea\u0005\u0018"+
		"\u0000\u0000\u00ea\u00f1\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\u0013"+
		"\u0000\u0000\u00ec\u00ed\u0003$\u0012\u0000\u00ed\u00ee\u0005\u0014\u0000"+
		"\u0000\u00ee\u00f1\u0001\u0000\u0000\u0000\u00ef\u00f1\u0003,\u0016\u0000"+
		"\u00f0\u00e0\u0001\u0000\u0000\u0000\u00f0\u00e3\u0001\u0000\u0000\u0000"+
		"\u00f0\u00e5\u0001\u0000\u0000\u0000\u00f0\u00e6\u0001\u0000\u0000\u0000"+
		"\u00f0\u00eb\u0001\u0000\u0000\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000"+
		"\u00f1\u00f8\u0001\u0000\u0000\u0000\u00f2\u00f3\n\u0007\u0000\u0000\u00f3"+
		"\u00f4\u0003&\u0013\u0000\u00f4\u00f5\u0003$\u0012\b\u00f5\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f6\u00f2\u0001\u0000\u0000\u0000\u00f7\u00fa\u0001"+
		"\u0000\u0000\u0000\u00f8\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001"+
		"\u0000\u0000\u0000\u00f9%\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000"+
		"\u0000\u0000\u00fb\u010c\u0005+\u0000\u0000\u00fc\u010c\u0005,\u0000\u0000"+
		"\u00fd\u010c\u0005-\u0000\u0000\u00fe\u010c\u0005)\u0000\u0000\u00ff\u010c"+
		"\u00052\u0000\u0000\u0100\u010c\u00053\u0000\u0000\u0101\u010c\u0005."+
		"\u0000\u0000\u0102\u010c\u0005/\u0000\u0000\u0103\u010c\u00050\u0000\u0000"+
		"\u0104\u010c\u00051\u0000\u0000\u0105\u010c\u00054\u0000\u0000\u0106\u010c"+
		"\u00055\u0000\u0000\u0107\u010c\u00056\u0000\u0000\u0108\u010c\u0005\u0010"+
		"\u0000\u0000\u0109\u010a\u0005\u0010\u0000\u0000\u010a\u010c\u0005\u0012"+
		"\u0000\u0000\u010b\u00fb\u0001\u0000\u0000\u0000\u010b\u00fc\u0001\u0000"+
		"\u0000\u0000\u010b\u00fd\u0001\u0000\u0000\u0000\u010b\u00fe\u0001\u0000"+
		"\u0000\u0000\u010b\u00ff\u0001\u0000\u0000\u0000\u010b\u0100\u0001\u0000"+
		"\u0000\u0000\u010b\u0101\u0001\u0000\u0000\u0000\u010b\u0102\u0001\u0000"+
		"\u0000\u0000\u010b\u0103\u0001\u0000\u0000\u0000\u010b\u0104\u0001\u0000"+
		"\u0000\u0000\u010b\u0105\u0001\u0000\u0000\u0000\u010b\u0106\u0001\u0000"+
		"\u0000\u0000\u010b\u0107\u0001\u0000\u0000\u0000\u010b\u0108\u0001\u0000"+
		"\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\'\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\u00059\u0000\u0000\u010e\u0110\u0005\u0013\u0000\u0000"+
		"\u010f\u0111\u0003*\u0015\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000\u0112"+
		"\u0113\u0005\u0014\u0000\u0000\u0113)\u0001\u0000\u0000\u0000\u0114\u0119"+
		"\u0003$\u0012\u0000\u0115\u0116\u0005\u0016\u0000\u0000\u0116\u0118\u0003"+
		"$\u0012\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u011b\u0001\u0000"+
		"\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000"+
		"\u0000\u0000\u011a+\u0001\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000"+
		"\u0000\u011c\u0127\u00059\u0000\u0000\u011d\u0127\u0005:\u0000\u0000\u011e"+
		"\u0127\u0005;\u0000\u0000\u011f\u0127\u0005<\u0000\u0000\u0120\u0121\u0005"+
		"\u0017\u0000\u0000\u0121\u0122\u0003*\u0015\u0000\u0122\u0123\u0005\u0018"+
		"\u0000\u0000\u0123\u0127\u0001\u0000\u0000\u0000\u0124\u0127\u0005\'\u0000"+
		"\u0000\u0125\u0127\u0005(\u0000\u0000\u0126\u011c\u0001\u0000\u0000\u0000"+
		"\u0126\u011d\u0001\u0000\u0000\u0000\u0126\u011e\u0001\u0000\u0000\u0000"+
		"\u0126\u011f\u0001\u0000\u0000\u0000\u0126\u0120\u0001\u0000\u0000\u0000"+
		"\u0126\u0124\u0001\u0000\u0000\u0000\u0126\u0125\u0001\u0000\u0000\u0000"+
		"\u0127-\u0001\u0000\u0000\u0000\u001f18<@DHLPTVdksz\u0082\u0089\u0094"+
		"\u0099\u00a2\u00af\u00b4\u00b6\u00c2\u00d8\u00de\u00f0\u00f8\u010b\u0110"+
		"\u0119\u0126";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}