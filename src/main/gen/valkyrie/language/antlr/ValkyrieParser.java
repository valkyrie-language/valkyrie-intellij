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
		LPAREN=1, RPAREN=2, COLON=3, COMMA=4, LBRACK=5, RBRACK=6, LBRACE=7, RBRACE=8, 
		IF=9, ELSE=10, WHILE=11, VAR=12, EQUAL=13, RETURN=14, PRINT=15, FUNC=16, 
		TYPEINT=17, TYPEFLOAT=18, TYPESTRING=19, TYPEBOOLEAN=20, TRUE=21, FALSE=22, 
		SUB=23, BANG=24, MUL=25, DIV=26, ADD=27, LT=28, LE=29, EQUAL_EQUAL=30, 
		NOT_EQUAL=31, GT=32, GE=33, OR=34, AND=35, DOT=36, LINE_COMMENT=37, COMMENT=38, 
		ID=39, INT=40, FLOAT=41, STRING=42, WS=43, ERRCHAR=44;
	public static final int
		RULE_top_statement = 0, RULE_define_function = 1, RULE_function = 2, RULE_formal_args = 3, 
		RULE_formal_arg = 4, RULE_type = 5, RULE_block = 6, RULE_statement = 7, 
		RULE_vardef = 8, RULE_expr = 9, RULE_operator = 10, RULE_call_expr = 11, 
		RULE_expr_list = 12, RULE_primary = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"top_statement", "define_function", "function", "formal_args", "formal_arg", 
			"type", "block", "statement", "vardef", "expr", "operator", "call_expr", 
			"expr_list", "primary"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':'", "','", "'['", "']'", "'{'", "'}'", "'if'", 
			"'else'", "'while'", "'var'", "'='", "'return'", "'print'", "'func'", 
			"'int'", "'float'", "'string'", "'boolean'", "'true'", "'false'", "'-'", 
			"'!'", "'*'", "'/'", "'+'", "'<'", "'<='", "'=='", "'!='", "'>'", "'>='", 
			"'||'", "'&&'", "' . '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "COLON", "COMMA", "LBRACK", "RBRACK", "LBRACE", 
			"RBRACE", "IF", "ELSE", "WHILE", "VAR", "EQUAL", "RETURN", "PRINT", "FUNC", 
			"TYPEINT", "TYPEFLOAT", "TYPESTRING", "TYPEBOOLEAN", "TRUE", "FALSE", 
			"SUB", "BANG", "MUL", "DIV", "ADD", "LT", "LE", "EQUAL_EQUAL", "NOT_EQUAL", 
			"GT", "GE", "OR", "AND", "DOT", "LINE_COMMENT", "COMMENT", "ID", "INT", 
			"FLOAT", "STRING", "WS", "ERRCHAR"
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
	public static class Top_statementContext extends ParserRuleContext {
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
		enterRule(_localctx, 0, RULE_top_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			define_function();
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
		public List<VardefContext> vardef() {
			return getRuleContexts(VardefContext.class);
		}
		public VardefContext vardef(int i) {
			return getRuleContext(VardefContext.class,i);
		}
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 2, RULE_define_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VAR) {
				{
				{
				setState(30);
				vardef();
				}
				}
				setState(35);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FUNC) {
				{
				{
				setState(36);
				function();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549755865728L) != 0)) {
				{
				{
				setState(42);
				statement();
				}
				}
				setState(47);
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
	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode FUNC() { return getToken(ValkyrieParser.FUNC, 0); }
		public TerminalNode ID() { return getToken(ValkyrieParser.ID, 0); }
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
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(FUNC);
			setState(49);
			match(ID);
			setState(50);
			match(LPAREN);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(51);
				formal_args();
				}
			}

			setState(54);
			match(RPAREN);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(55);
				match(COLON);
				setState(56);
				type();
				}
			}

			setState(59);
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
		enterRule(_localctx, 6, RULE_formal_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			formal_arg();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(62);
				match(COMMA);
				setState(63);
				formal_arg();
				}
				}
				setState(68);
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
		public TerminalNode ID() { return getToken(ValkyrieParser.ID, 0); }
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
		enterRule(_localctx, 8, RULE_formal_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(ID);
			setState(70);
			match(COLON);
			setState(71);
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
		public TerminalNode TYPEBOOLEAN() { return getToken(ValkyrieParser.TYPEBOOLEAN, 0); }
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
		public TerminalNode TYPEINT() { return getToken(ValkyrieParser.TYPEINT, 0); }
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
		public TerminalNode TYPESTRING() { return getToken(ValkyrieParser.TYPESTRING, 0); }
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
		public TerminalNode TYPEFLOAT() { return getToken(ValkyrieParser.TYPEFLOAT, 0); }
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
		enterRule(_localctx, 10, RULE_type);
		try {
			setState(79);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPEINT:
				_localctx = new IntTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(TYPEINT);
				}
				break;
			case TYPEFLOAT:
				_localctx = new FloatTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(TYPEFLOAT);
				}
				break;
			case TYPESTRING:
				_localctx = new StringTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(TYPESTRING);
				}
				break;
			case TYPEBOOLEAN:
				_localctx = new BooleanTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				match(TYPEBOOLEAN);
				}
				break;
			case LBRACK:
				_localctx = new VectorTypeSpecContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				match(LBRACK);
				setState(78);
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
		public List<VardefContext> vardef() {
			return getRuleContexts(VardefContext.class);
		}
		public VardefContext vardef(int i) {
			return getRuleContext(VardefContext.class,i);
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
		enterRule(_localctx, 12, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(LBRACE);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 549755869824L) != 0)) {
				{
				setState(84);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LBRACE:
				case IF:
				case WHILE:
				case RETURN:
				case PRINT:
				case ID:
					{
					setState(82);
					statement();
					}
					break;
				case VAR:
					{
					setState(83);
					vardef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
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
		public TerminalNode ID() { return getToken(ValkyrieParser.ID, 0); }
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
		public TerminalNode PRINT() { return getToken(ValkyrieParser.PRINT, 0); }
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
		public TerminalNode ID() { return getToken(ValkyrieParser.ID, 0); }
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
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new IfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(IF);
				setState(92);
				match(LPAREN);
				setState(93);
				expr(0);
				setState(94);
				match(RPAREN);
				setState(95);
				statement();
				setState(98);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(96);
					match(ELSE);
					setState(97);
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
				setState(100);
				match(WHILE);
				setState(101);
				match(LPAREN);
				setState(102);
				expr(0);
				setState(103);
				match(RPAREN);
				setState(104);
				statement();
				}
				break;
			case 3:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(ID);
				setState(107);
				match(EQUAL);
				setState(108);
				expr(0);
				}
				break;
			case 4:
				_localctx = new ElementAssignContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				match(ID);
				setState(110);
				match(LBRACK);
				setState(111);
				expr(0);
				setState(112);
				match(RBRACK);
				setState(113);
				match(EQUAL);
				setState(114);
				expr(0);
				}
				break;
			case 5:
				_localctx = new CallStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(116);
				call_expr();
				}
				break;
			case 6:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(117);
				match(PRINT);
				setState(118);
				match(LPAREN);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246368665634L) != 0)) {
					{
					setState(119);
					expr(0);
					}
				}

				setState(122);
				match(RPAREN);
				}
				break;
			case 7:
				_localctx = new ReturnContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(123);
				match(RETURN);
				setState(124);
				expr(0);
				}
				break;
			case 8:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(125);
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
	public static class VardefContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ValkyrieParser.VAR, 0); }
		public TerminalNode ID() { return getToken(ValkyrieParser.ID, 0); }
		public TerminalNode EQUAL() { return getToken(ValkyrieParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VardefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vardef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterVardef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitVardef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitVardef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VardefContext vardef() throws RecognitionException {
		VardefContext _localctx = new VardefContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_vardef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(VAR);
			setState(129);
			match(ID);
			setState(130);
			match(EQUAL);
			setState(131);
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
		public TerminalNode ID() { return getToken(ValkyrieParser.ID, 0); }
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(134);
				match(SUB);
				setState(135);
				expr(6);
				}
				break;
			case 2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136);
				match(BANG);
				setState(137);
				expr(5);
				}
				break;
			case 3:
				{
				_localctx = new CallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(138);
				call_expr();
				}
				break;
			case 4:
				{
				_localctx = new IndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(139);
				match(ID);
				setState(140);
				match(LBRACK);
				setState(141);
				expr(0);
				setState(142);
				match(RBRACK);
				}
				break;
			case 5:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144);
				match(LPAREN);
				setState(145);
				expr(0);
				setState(146);
				match(RPAREN);
				}
				break;
			case 6:
				{
				_localctx = new AtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148);
				primary();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(157);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OpContext(new ExprContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(151);
					if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
					setState(152);
					operator();
					setState(153);
					expr(8);
					}
					} 
				}
				setState(159);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		enterRule(_localctx, 20, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 137413787648L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Call_exprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ValkyrieParser.ID, 0); }
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
		enterRule(_localctx, 22, RULE_call_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(ID);
			setState(163);
			match(LPAREN);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8246368665634L) != 0)) {
				{
				setState(164);
				expr_list();
				}
			}

			setState(167);
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
		enterRule(_localctx, 24, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			expr(0);
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(170);
				match(COMMA);
				setState(171);
				expr(0);
				}
				}
				setState(176);
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
		public TerminalNode INT() { return getToken(ValkyrieParser.INT, 0); }
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
		public TerminalNode FLOAT() { return getToken(ValkyrieParser.FLOAT, 0); }
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
		public TerminalNode ID() { return getToken(ValkyrieParser.ID, 0); }
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
		enterRule(_localctx, 26, RULE_primary);
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new IdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				match(ID);
				}
				break;
			case INT:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				match(INT);
				}
				break;
			case FLOAT:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				match(FLOAT);
				}
				break;
			case STRING:
				_localctx = new StringContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				match(STRING);
				}
				break;
			case LBRACK:
				_localctx = new VectorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(181);
				match(LBRACK);
				setState(182);
				expr_list();
				setState(183);
				match(RBRACK);
				}
				break;
			case TRUE:
				_localctx = new TrueLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(185);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseLiteralContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(186);
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
		case 9:
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
		"\u0004\u0001,\u00be\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0001\u0001\u0005\u0001"+
		" \b\u0001\n\u0001\f\u0001#\t\u0001\u0001\u0001\u0005\u0001&\b\u0001\n"+
		"\u0001\f\u0001)\t\u0001\u0001\u0001\u0005\u0001,\b\u0001\n\u0001\f\u0001"+
		"/\t\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"5\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002:\b\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0005\u0003A\b"+
		"\u0003\n\u0003\f\u0003D\t\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005P\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006U\b\u0006\n\u0006\f\u0006X\t\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007c\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007y\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u007f"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0096\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u009c\b\t\n\t\f\t\u009f\t\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00a6\b\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u00ad\b\f\n\f\f\f\u00b0\t\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003"+
		"\r\u00bc\b\r\u0001\r\u0000\u0001\u0012\u000e\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0001\u0002\u0000"+
		"\u0017\u0017\u0019$\u00d2\u0000\u001c\u0001\u0000\u0000\u0000\u0002!\u0001"+
		"\u0000\u0000\u0000\u00040\u0001\u0000\u0000\u0000\u0006=\u0001\u0000\u0000"+
		"\u0000\bE\u0001\u0000\u0000\u0000\nO\u0001\u0000\u0000\u0000\fQ\u0001"+
		"\u0000\u0000\u0000\u000e~\u0001\u0000\u0000\u0000\u0010\u0080\u0001\u0000"+
		"\u0000\u0000\u0012\u0095\u0001\u0000\u0000\u0000\u0014\u00a0\u0001\u0000"+
		"\u0000\u0000\u0016\u00a2\u0001\u0000\u0000\u0000\u0018\u00a9\u0001\u0000"+
		"\u0000\u0000\u001a\u00bb\u0001\u0000\u0000\u0000\u001c\u001d\u0003\u0002"+
		"\u0001\u0000\u001d\u0001\u0001\u0000\u0000\u0000\u001e \u0003\u0010\b"+
		"\u0000\u001f\u001e\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000!"+
		"\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\'\u0001\u0000"+
		"\u0000\u0000#!\u0001\u0000\u0000\u0000$&\u0003\u0004\u0002\u0000%$\u0001"+
		"\u0000\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000"+
		"\'(\u0001\u0000\u0000\u0000(-\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000"+
		"\u0000*,\u0003\u000e\u0007\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000"+
		"\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.\u0003"+
		"\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u000001\u0005\u0010\u0000"+
		"\u000012\u0005\'\u0000\u000024\u0005\u0001\u0000\u000035\u0003\u0006\u0003"+
		"\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u000056\u0001\u0000"+
		"\u0000\u000069\u0005\u0002\u0000\u000078\u0005\u0003\u0000\u00008:\u0003"+
		"\n\u0005\u000097\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0001"+
		"\u0000\u0000\u0000;<\u0003\f\u0006\u0000<\u0005\u0001\u0000\u0000\u0000"+
		"=B\u0003\b\u0004\u0000>?\u0005\u0004\u0000\u0000?A\u0003\b\u0004\u0000"+
		"@>\u0001\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000"+
		"\u0000BC\u0001\u0000\u0000\u0000C\u0007\u0001\u0000\u0000\u0000DB\u0001"+
		"\u0000\u0000\u0000EF\u0005\'\u0000\u0000FG\u0005\u0003\u0000\u0000GH\u0003"+
		"\n\u0005\u0000H\t\u0001\u0000\u0000\u0000IP\u0005\u0011\u0000\u0000JP"+
		"\u0005\u0012\u0000\u0000KP\u0005\u0013\u0000\u0000LP\u0005\u0014\u0000"+
		"\u0000MN\u0005\u0005\u0000\u0000NP\u0005\u0006\u0000\u0000OI\u0001\u0000"+
		"\u0000\u0000OJ\u0001\u0000\u0000\u0000OK\u0001\u0000\u0000\u0000OL\u0001"+
		"\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000P\u000b\u0001\u0000\u0000"+
		"\u0000QV\u0005\u0007\u0000\u0000RU\u0003\u000e\u0007\u0000SU\u0003\u0010"+
		"\b\u0000TR\u0001\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000UX\u0001\u0000"+
		"\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WY\u0001"+
		"\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0005\b\u0000\u0000Z\r"+
		"\u0001\u0000\u0000\u0000[\\\u0005\t\u0000\u0000\\]\u0005\u0001\u0000\u0000"+
		"]^\u0003\u0012\t\u0000^_\u0005\u0002\u0000\u0000_b\u0003\u000e\u0007\u0000"+
		"`a\u0005\n\u0000\u0000ac\u0003\u000e\u0007\u0000b`\u0001\u0000\u0000\u0000"+
		"bc\u0001\u0000\u0000\u0000c\u007f\u0001\u0000\u0000\u0000de\u0005\u000b"+
		"\u0000\u0000ef\u0005\u0001\u0000\u0000fg\u0003\u0012\t\u0000gh\u0005\u0002"+
		"\u0000\u0000hi\u0003\u000e\u0007\u0000i\u007f\u0001\u0000\u0000\u0000"+
		"jk\u0005\'\u0000\u0000kl\u0005\r\u0000\u0000l\u007f\u0003\u0012\t\u0000"+
		"mn\u0005\'\u0000\u0000no\u0005\u0005\u0000\u0000op\u0003\u0012\t\u0000"+
		"pq\u0005\u0006\u0000\u0000qr\u0005\r\u0000\u0000rs\u0003\u0012\t\u0000"+
		"s\u007f\u0001\u0000\u0000\u0000t\u007f\u0003\u0016\u000b\u0000uv\u0005"+
		"\u000f\u0000\u0000vx\u0005\u0001\u0000\u0000wy\u0003\u0012\t\u0000xw\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000"+
		"z\u007f\u0005\u0002\u0000\u0000{|\u0005\u000e\u0000\u0000|\u007f\u0003"+
		"\u0012\t\u0000}\u007f\u0003\f\u0006\u0000~[\u0001\u0000\u0000\u0000~d"+
		"\u0001\u0000\u0000\u0000~j\u0001\u0000\u0000\u0000~m\u0001\u0000\u0000"+
		"\u0000~t\u0001\u0000\u0000\u0000~u\u0001\u0000\u0000\u0000~{\u0001\u0000"+
		"\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f\u000f\u0001\u0000\u0000\u0000"+
		"\u0080\u0081\u0005\f\u0000\u0000\u0081\u0082\u0005\'\u0000\u0000\u0082"+
		"\u0083\u0005\r\u0000\u0000\u0083\u0084\u0003\u0012\t\u0000\u0084\u0011"+
		"\u0001\u0000\u0000\u0000\u0085\u0086\u0006\t\uffff\uffff\u0000\u0086\u0087"+
		"\u0005\u0017\u0000\u0000\u0087\u0096\u0003\u0012\t\u0006\u0088\u0089\u0005"+
		"\u0018\u0000\u0000\u0089\u0096\u0003\u0012\t\u0005\u008a\u0096\u0003\u0016"+
		"\u000b\u0000\u008b\u008c\u0005\'\u0000\u0000\u008c\u008d\u0005\u0005\u0000"+
		"\u0000\u008d\u008e\u0003\u0012\t\u0000\u008e\u008f\u0005\u0006\u0000\u0000"+
		"\u008f\u0096\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u0001\u0000\u0000"+
		"\u0091\u0092\u0003\u0012\t\u0000\u0092\u0093\u0005\u0002\u0000\u0000\u0093"+
		"\u0096\u0001\u0000\u0000\u0000\u0094\u0096\u0003\u001a\r\u0000\u0095\u0085"+
		"\u0001\u0000\u0000\u0000\u0095\u0088\u0001\u0000\u0000\u0000\u0095\u008a"+
		"\u0001\u0000\u0000\u0000\u0095\u008b\u0001\u0000\u0000\u0000\u0095\u0090"+
		"\u0001\u0000\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u009d"+
		"\u0001\u0000\u0000\u0000\u0097\u0098\n\u0007\u0000\u0000\u0098\u0099\u0003"+
		"\u0014\n\u0000\u0099\u009a\u0003\u0012\t\b\u009a\u009c\u0001\u0000\u0000"+
		"\u0000\u009b\u0097\u0001\u0000\u0000\u0000\u009c\u009f\u0001\u0000\u0000"+
		"\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009d\u009e\u0001\u0000\u0000"+
		"\u0000\u009e\u0013\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0007\u0000\u0000\u0000\u00a1\u0015\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0005\'\u0000\u0000\u00a3\u00a5\u0005\u0001\u0000\u0000"+
		"\u00a4\u00a6\u0003\u0018\f\u0000\u00a5\u00a4\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0005\u0002\u0000\u0000\u00a8\u0017\u0001\u0000\u0000\u0000\u00a9"+
		"\u00ae\u0003\u0012\t\u0000\u00aa\u00ab\u0005\u0004\u0000\u0000\u00ab\u00ad"+
		"\u0003\u0012\t\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001"+
		"\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001"+
		"\u0000\u0000\u0000\u00af\u0019\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001"+
		"\u0000\u0000\u0000\u00b1\u00bc\u0005\'\u0000\u0000\u00b2\u00bc\u0005("+
		"\u0000\u0000\u00b3\u00bc\u0005)\u0000\u0000\u00b4\u00bc\u0005*\u0000\u0000"+
		"\u00b5\u00b6\u0005\u0005\u0000\u0000\u00b6\u00b7\u0003\u0018\f\u0000\u00b7"+
		"\u00b8\u0005\u0006\u0000\u0000\u00b8\u00bc\u0001\u0000\u0000\u0000\u00b9"+
		"\u00bc\u0005\u0015\u0000\u0000\u00ba\u00bc\u0005\u0016\u0000\u0000\u00bb"+
		"\u00b1\u0001\u0000\u0000\u0000\u00bb\u00b2\u0001\u0000\u0000\u0000\u00bb"+
		"\u00b3\u0001\u0000\u0000\u0000\u00bb\u00b4\u0001\u0000\u0000\u0000\u00bb"+
		"\u00b5\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bc\u001b\u0001\u0000\u0000\u0000\u0011"+
		"!\'-49BOTVbx~\u0095\u009d\u00a5\u00ae\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}