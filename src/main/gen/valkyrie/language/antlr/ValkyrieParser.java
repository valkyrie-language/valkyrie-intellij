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
		LINE_COMMENT=76, BLOCK_COMMENT=77, WHITE_SPACE=78, ERROR_CHARACTAR=79, 
		UNICODE_ID=80;
	public static final int
		RULE_program = 0, RULE_top_statement = 1, RULE_eos = 2, RULE_eos_free = 3, 
		RULE_define_namespace = 4, RULE_import_statement = 5, RULE_define_extension = 6, 
		RULE_define_class = 7, RULE_class_statements = 8, RULE_class_inherit = 9, 
		RULE_class_field = 10, RULE_class_method = 11, RULE_define_trait = 12, 
		RULE_define_extends = 13, RULE_define_union = 14, RULE_union_statements = 15, 
		RULE_define_bitflags = 16, RULE_bitflags_statements = 17, RULE_bitflags_item = 18, 
		RULE_define_variale = 19, RULE_define_function = 20, RULE_function_parameters = 21, 
		RULE_parameter_item = 22, RULE_parameter_default = 23, RULE_function_statements = 24, 
		RULE_define_type = 25, RULE_type_hint = 26, RULE_effect_hint = 27, RULE_if_statement = 28, 
		RULE_while_statement = 29, RULE_for_statement = 30, RULE_expression = 31, 
		RULE_control_expression = 32, RULE_inline_expression = 33, RULE_term = 34, 
		RULE_op_compare = 35, RULE_op_pattern = 36, RULE_op_multiple = 37, RULE_op_plus = 38, 
		RULE_op_logic = 39, RULE_infix_is = 40, RULE_infix_in = 41, RULE_type_expression = 42, 
		RULE_expr_list = 43, RULE_macro_call = 44, RULE_namepath_free = 45, RULE_namepath = 46, 
		RULE_identifier = 47, RULE_number = 48, RULE_number_suffix = 49;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "top_statement", "eos", "eos_free", "define_namespace", "import_statement", 
			"define_extension", "define_class", "class_statements", "class_inherit", 
			"class_field", "class_method", "define_trait", "define_extends", "define_union", 
			"union_statements", "define_bitflags", "bitflags_statements", "bitflags_item", 
			"define_variale", "define_function", "function_parameters", "parameter_item", 
			"parameter_default", "function_statements", "define_type", "type_hint", 
			"effect_hint", "if_statement", "while_statement", "for_statement", "expression", 
			"control_expression", "inline_expression", "term", "op_compare", "op_pattern", 
			"op_multiple", "op_plus", "op_logic", "infix_is", "infix_in", "type_expression", 
			"expr_list", "macro_call", "namepath_free", "namepath", "identifier", 
			"number", "number_suffix"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "','", "';'", null, null, "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'+'", "'-'", "'*'", "'/'", "'=='", "'!='", "'<'", null, null, 
			null, "'>'", null, null, null, null, null, "'='", "'||'", "'|'", "'&&'", 
			"'&'", "'@'", null, "'!'", "'not'", null, "'in'", "'\\u2209'", "'is'", 
			null, null, null, null, null, "'\\u2205'", null, null, "'extension'", 
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
			"SPECIAL", "LINE_COMMENT", "BLOCK_COMMENT", "WHITE_SPACE", "ERROR_CHARACTAR", 
			"UNICODE_ID"
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
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4900057114887585472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 68593L) != 0)) {
				{
				{
				setState(100);
				top_statement();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(106);
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
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
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
		public Define_bitflagsContext define_bitflags() {
			return getRuleContext(Define_bitflagsContext.class,0);
		}
		public Define_traitContext define_trait() {
			return getRuleContext(Define_traitContext.class,0);
		}
		public Define_extendsContext define_extends() {
			return getRuleContext(Define_extendsContext.class,0);
		}
		public Define_functionContext define_function() {
			return getRuleContext(Define_functionContext.class,0);
		}
		public Define_typeContext define_type() {
			return getRuleContext(Define_typeContext.class,0);
		}
		public Define_varialeContext define_variale() {
			return getRuleContext(Define_varialeContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_NAMESPACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				define_namespace();
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(109);
					eos();
					}
				}

				}
				break;
			case KW_IMPORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				import_statement();
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(113);
					eos();
					}
				}

				}
				break;
			case KW_EXTENSION:
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				define_extension();
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(117);
					eos();
					}
				}

				}
				break;
			case HASH:
			case KW_CLASS:
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				define_class();
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(121);
					eos();
					}
				}

				}
				break;
			case KW_UNION:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				define_union();
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(125);
					eos();
					}
				}

				}
				break;
			case KW_BITFLAGS:
				enterOuterAlt(_localctx, 6);
				{
				setState(128);
				define_bitflags();
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(129);
					eos();
					}
				}

				}
				break;
			case KW_TRAIT:
				enterOuterAlt(_localctx, 7);
				{
				setState(132);
				define_trait();
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(133);
					eos();
					}
				}

				}
				break;
			case KW_EXTENDS:
				enterOuterAlt(_localctx, 8);
				{
				setState(136);
				define_extends();
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(137);
					eos();
					}
				}

				}
				break;
			case KW_FUNCTION:
				enterOuterAlt(_localctx, 9);
				{
				setState(140);
				define_function();
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(141);
					eos();
					}
				}

				}
				break;
			case KW_TYPE:
				enterOuterAlt(_localctx, 10);
				{
				setState(144);
				define_type();
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(145);
					eos();
					}
				}

				}
				break;
			case KW_LET:
				enterOuterAlt(_localctx, 11);
				{
				setState(148);
				define_variale();
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(149);
					eos();
					}
				}

				}
				break;
			case KW_IF:
				enterOuterAlt(_localctx, 12);
				{
				setState(152);
				if_statement();
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(153);
					eos();
					}
				}

				}
				break;
			case KW_WHILE:
				enterOuterAlt(_localctx, 13);
				{
				setState(156);
				while_statement();
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(157);
					eos();
					}
				}

				}
				break;
			case KW_FOR:
				enterOuterAlt(_localctx, 14);
				{
				setState(160);
				for_statement();
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(161);
					eos();
					}
				}

				}
				break;
			case PARENTHESES_L:
			case BRACKET_L:
			case INTEGER:
			case STRING:
			case RETURN:
			case RESUME:
			case YIELD:
			case BREAK:
			case CONTINUE:
			case RAISE:
			case SPECIAL:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 15);
				{
				setState(164);
				expression(0);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(165);
					eos();
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
	public static class EosContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(ValkyrieParser.SEMICOLON, 0); }
		public EosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterEos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitEos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitEos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EosContext eos() throws RecognitionException {
		EosContext _localctx = new EosContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(SEMICOLON);
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
	public static class Eos_freeContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(ValkyrieParser.COMMA, 0); }
		public TerminalNode SEMICOLON() { return getToken(ValkyrieParser.SEMICOLON, 0); }
		public Eos_freeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eos_free; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterEos_free(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitEos_free(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitEos_free(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eos_freeContext eos_free() throws RecognitionException {
		Eos_freeContext _localctx = new Eos_freeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_eos_free);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_la = _input.LA(1);
			if ( !(_la==COMMA || _la==SEMICOLON) ) {
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
	public static class Define_namespaceContext extends ParserRuleContext {
		public TerminalNode KW_NAMESPACE() { return getToken(ValkyrieParser.KW_NAMESPACE, 0); }
		public Namepath_freeContext namepath_free() {
			return getRuleContext(Namepath_freeContext.class,0);
		}
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
		enterRule(_localctx, 8, RULE_define_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(KW_NAMESPACE);
			setState(175);
			namepath_free();
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
		public Namepath_freeContext namepath_free() {
			return getRuleContext(Namepath_freeContext.class,0);
		}
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
		enterRule(_localctx, 10, RULE_import_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(KW_IMPORT);
			setState(178);
			namepath_free();
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
		enterRule(_localctx, 12, RULE_define_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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
		public TerminalNode KW_CLASS() { return getToken(ValkyrieParser.KW_CLASS, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public Class_inheritContext class_inherit() {
			return getRuleContext(Class_inheritContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_define_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH) {
				{
				{
				setState(182);
				macro_call();
				}
				}
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(188);
			match(KW_CLASS);
			setState(189);
			namepath();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESES_L) {
				{
				setState(190);
				class_inherit();
				}
			}

			setState(193);
			match(BRACE_L);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17179869196L) != 0) || _la==UNICODE_ID) {
				{
				{
				setState(194);
				class_statements();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
			match(BRACE_R);
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
		public Class_methodContext class_method() {
			return getRuleContext(Class_methodContext.class,0);
		}
		public Class_fieldContext class_field() {
			return getRuleContext(Class_fieldContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
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
		enterRule(_localctx, 16, RULE_class_statements);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				class_method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				class_field();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				eos_free();
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
	public static class Class_inheritContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieParser.PARENTHESES_R, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Class_inheritContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_inherit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterClass_inherit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitClass_inherit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitClass_inherit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_inheritContext class_inherit() throws RecognitionException {
		Class_inheritContext _localctx = new Class_inheritContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_class_inherit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(PARENTHESES_L);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==UNICODE_ID) {
				{
				setState(208);
				namepath();
				}
			}

			setState(211);
			match(PARENTHESES_R);
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
	public static class Class_fieldContext extends ParserRuleContext {
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Parameter_defaultContext parameter_default() {
			return getRuleContext(Parameter_defaultContext.class,0);
		}
		public Class_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterClass_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitClass_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitClass_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_fieldContext class_field() throws RecognitionException {
		Class_fieldContext _localctx = new Class_fieldContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_class_field);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH) {
				{
				{
				setState(213);
				macro_call();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(220); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(219);
					identifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(222); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(225);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(224);
				type_hint();
				}
			}

			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(227);
				parameter_default();
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
	public static class Class_methodContext extends ParserRuleContext {
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Effect_hintContext effect_hint() {
			return getRuleContext(Effect_hintContext.class,0);
		}
		public Class_methodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterClass_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitClass_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitClass_method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_methodContext class_method() throws RecognitionException {
		Class_methodContext _localctx = new Class_methodContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_class_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH) {
				{
				{
				setState(230);
				macro_call();
				}
				}
				setState(235);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(237); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(236);
				identifier();
				}
				}
				setState(239); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==UNICODE_ID );
			setState(241);
			function_parameters();
			setState(243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(242);
				type_hint();
				}
			}

			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_DIV) {
				{
				setState(245);
				effect_hint();
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
		public TerminalNode KW_TRAIT() { return getToken(ValkyrieParser.KW_TRAIT, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Class_statementsContext> class_statements() {
			return getRuleContexts(Class_statementsContext.class);
		}
		public Class_statementsContext class_statements(int i) {
			return getRuleContext(Class_statementsContext.class,i);
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
		enterRule(_localctx, 24, RULE_define_trait);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(KW_TRAIT);
			setState(249);
			namepath();
			setState(250);
			match(BRACE_L);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17179869196L) != 0) || _la==UNICODE_ID) {
				{
				{
				setState(251);
				class_statements();
				}
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(257);
			match(BRACE_R);
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
	public static class Define_extendsContext extends ParserRuleContext {
		public TerminalNode KW_EXTENDS() { return getToken(ValkyrieParser.KW_EXTENDS, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Class_statementsContext> class_statements() {
			return getRuleContexts(Class_statementsContext.class);
		}
		public Class_statementsContext class_statements(int i) {
			return getRuleContext(Class_statementsContext.class,i);
		}
		public Define_extendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_extends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_extends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_extends(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_extends(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_extendsContext define_extends() throws RecognitionException {
		Define_extendsContext _localctx = new Define_extendsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_define_extends);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(KW_EXTENDS);
			setState(260);
			namepath();
			setState(261);
			match(BRACE_L);
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 17179869196L) != 0) || _la==UNICODE_ID) {
				{
				{
				setState(262);
				class_statements();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
			match(BRACE_R);
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
		public TerminalNode KW_UNION() { return getToken(ValkyrieParser.KW_UNION, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
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
		enterRule(_localctx, 28, RULE_define_union);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(KW_UNION);
			setState(271);
			namepath();
			setState(272);
			match(BRACE_L);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==KW_FUNCTION) {
				{
				{
				setState(273);
				union_statements();
				}
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(279);
			match(BRACE_R);
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
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
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
		enterRule(_localctx, 30, RULE_union_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			define_function();
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(282);
				eos();
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
	public static class Define_bitflagsContext extends ParserRuleContext {
		public TerminalNode KW_BITFLAGS() { return getToken(ValkyrieParser.KW_BITFLAGS, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Bitflags_statementsContext> bitflags_statements() {
			return getRuleContexts(Bitflags_statementsContext.class);
		}
		public Bitflags_statementsContext bitflags_statements(int i) {
			return getRuleContext(Bitflags_statementsContext.class,i);
		}
		public Define_bitflagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_bitflags; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_bitflags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_bitflags(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_bitflags(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_bitflagsContext define_bitflags() throws RecognitionException {
		Define_bitflagsContext _localctx = new Define_bitflagsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_define_bitflags);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(KW_BITFLAGS);
			setState(286);
			namepath();
			setState(287);
			match(BRACE_L);
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==SEMICOLON || _la==UNICODE_ID) {
				{
				{
				setState(288);
				bitflags_statements();
				}
				}
				setState(293);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(294);
			match(BRACE_R);
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
	public static class Bitflags_statementsContext extends ParserRuleContext {
		public Bitflags_itemContext bitflags_item() {
			return getRuleContext(Bitflags_itemContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Bitflags_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitflags_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterBitflags_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitBitflags_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitBitflags_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitflags_statementsContext bitflags_statements() throws RecognitionException {
		Bitflags_statementsContext _localctx = new Bitflags_statementsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_bitflags_statements);
		try {
			setState(298);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				bitflags_item();
				}
				break;
			case COMMA:
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				eos_free();
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
	public static class Bitflags_itemContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieParser.OP_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Bitflags_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitflags_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterBitflags_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitBitflags_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitBitflags_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitflags_itemContext bitflags_item() throws RecognitionException {
		Bitflags_itemContext _localctx = new Bitflags_itemContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_bitflags_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			identifier();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(301);
				match(OP_ASSIGN);
				setState(302);
				expression(0);
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
		public TerminalNode KW_LET() { return getToken(ValkyrieParser.KW_LET, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieParser.OP_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
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
		enterRule(_localctx, 38, RULE_define_variale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(KW_LET);
			setState(306);
			identifier();
			setState(307);
			match(OP_ASSIGN);
			setState(308);
			expression(0);
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
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Effect_hintContext effect_hint() {
			return getRuleContext(Effect_hintContext.class,0);
		}
		public List<Function_statementsContext> function_statements() {
			return getRuleContexts(Function_statementsContext.class);
		}
		public Function_statementsContext function_statements(int i) {
			return getRuleContext(Function_statementsContext.class,i);
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
		enterRule(_localctx, 40, RULE_define_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(KW_FUNCTION);
			setState(311);
			namepath();
			setState(312);
			function_parameters();
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(313);
				type_hint();
				}
			}

			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_DIV) {
				{
				setState(316);
				effect_hint();
				}
			}

			setState(319);
			match(BRACE_L);
			setState(323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4900057114887585472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 68593L) != 0)) {
				{
				{
				setState(320);
				function_statements();
				}
				}
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(326);
			match(BRACE_R);
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
	public static class Function_parametersContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieParser.PARENTHESES_L, 0); }
		public List<Parameter_itemContext> parameter_item() {
			return getRuleContexts(Parameter_itemContext.class);
		}
		public Parameter_itemContext parameter_item(int i) {
			return getRuleContext(Parameter_itemContext.class,i);
		}
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieParser.PARENTHESES_R, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieParser.COMMA, i);
		}
		public Function_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFunction_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFunction_parameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFunction_parameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_parametersContext function_parameters() throws RecognitionException {
		Function_parametersContext _localctx = new Function_parametersContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_function_parameters);
		int _la;
		try {
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(328);
				match(PARENTHESES_L);
				setState(329);
				parameter_item();
				setState(334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(330);
					match(COMMA);
					setState(331);
					parameter_item();
					}
					}
					setState(336);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(337);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(339);
				match(PARENTHESES_L);
				setState(340);
				match(PARENTHESES_R);
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
	public static class Parameter_itemContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Parameter_defaultContext parameter_default() {
			return getRuleContext(Parameter_defaultContext.class,0);
		}
		public Parameter_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterParameter_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitParameter_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitParameter_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_itemContext parameter_item() throws RecognitionException {
		Parameter_itemContext _localctx = new Parameter_itemContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_parameter_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			identifier();
			setState(345);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(344);
				type_hint();
				}
			}

			setState(348);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(347);
				parameter_default();
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
	public static class Parameter_defaultContext extends ParserRuleContext {
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieParser.OP_ASSIGN, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Parameter_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterParameter_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitParameter_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitParameter_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_defaultContext parameter_default() throws RecognitionException {
		Parameter_defaultContext _localctx = new Parameter_defaultContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_parameter_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(OP_ASSIGN);
			setState(351);
			inline_expression(0);
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
	public static class Function_statementsContext extends ParserRuleContext {
		public Top_statementContext top_statement() {
			return getRuleContext(Top_statementContext.class,0);
		}
		public Define_varialeContext define_variale() {
			return getRuleContext(Define_varialeContext.class,0);
		}
		public Function_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFunction_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFunction_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFunction_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_statementsContext function_statements() throws RecognitionException {
		Function_statementsContext _localctx = new Function_statementsContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_function_statements);
		try {
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(353);
				top_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(354);
				define_variale();
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
	public static class Define_typeContext extends ParserRuleContext {
		public TerminalNode KW_TYPE() { return getToken(ValkyrieParser.KW_TYPE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieParser.OP_ASSIGN, 0); }
		public Define_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_typeContext define_type() throws RecognitionException {
		Define_typeContext _localctx = new Define_typeContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_define_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(KW_TYPE);
			setState(358);
			identifier();
			setState(359);
			match(OP_ASSIGN);
			setState(360);
			identifier();
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
	public static class Type_hintContext extends ParserRuleContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieParser.COLON, 0); }
		public TerminalNode OP_ARROW() { return getToken(ValkyrieParser.OP_ARROW, 0); }
		public Type_hintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_hint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterType_hint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitType_hint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitType_hint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_hintContext type_hint() throws RecognitionException {
		Type_hintContext _localctx = new Type_hintContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_type_hint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_la = _input.LA(1);
			if ( !(_la==COLON || _la==OP_ARROW) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(363);
			type_expression(0);
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
	public static class Effect_hintContext extends ParserRuleContext {
		public TerminalNode OP_DIV() { return getToken(ValkyrieParser.OP_DIV, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Effect_hintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effect_hint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterEffect_hint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitEffect_hint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitEffect_hint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Effect_hintContext effect_hint() throws RecognitionException {
		Effect_hintContext _localctx = new Effect_hintContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_effect_hint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(OP_DIV);
			setState(366);
			type_expression(0);
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
	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode KW_IF() { return getToken(ValkyrieParser.KW_IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> BRACE_L() { return getTokens(ValkyrieParser.BRACE_L); }
		public TerminalNode BRACE_L(int i) {
			return getToken(ValkyrieParser.BRACE_L, i);
		}
		public List<Top_statementContext> top_statement() {
			return getRuleContexts(Top_statementContext.class);
		}
		public Top_statementContext top_statement(int i) {
			return getRuleContext(Top_statementContext.class,i);
		}
		public List<TerminalNode> BRACE_R() { return getTokens(ValkyrieParser.BRACE_R); }
		public TerminalNode BRACE_R(int i) {
			return getToken(ValkyrieParser.BRACE_R, i);
		}
		public TerminalNode KW_ELSE() { return getToken(ValkyrieParser.KW_ELSE, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_if_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(KW_IF);
			setState(369);
			expression(0);
			setState(370);
			match(BRACE_L);
			setState(371);
			top_statement();
			setState(372);
			match(BRACE_R);
			setState(378);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ELSE) {
				{
				setState(373);
				match(KW_ELSE);
				setState(374);
				match(BRACE_L);
				setState(375);
				top_statement();
				setState(376);
				match(BRACE_R);
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
	public static class While_statementContext extends ParserRuleContext {
		public TerminalNode KW_WHILE() { return getToken(ValkyrieParser.KW_WHILE, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Top_statementContext> top_statement() {
			return getRuleContexts(Top_statementContext.class);
		}
		public Top_statementContext top_statement(int i) {
			return getRuleContext(Top_statementContext.class,i);
		}
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitWhile_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitWhile_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_while_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			match(KW_WHILE);
			setState(381);
			inline_expression(0);
			setState(382);
			match(BRACE_L);
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4900057114887585472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 68593L) != 0)) {
				{
				{
				setState(383);
				top_statement();
				}
				}
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(389);
			match(BRACE_R);
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
	public static class For_statementContext extends ParserRuleContext {
		public TerminalNode KW_FOR() { return getToken(ValkyrieParser.KW_FOR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Infix_inContext infix_in() {
			return getRuleContext(Infix_inContext.class,0);
		}
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Function_statementsContext> function_statements() {
			return getRuleContexts(Function_statementsContext.class);
		}
		public Function_statementsContext function_statements(int i) {
			return getRuleContext(Function_statementsContext.class,i);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFor_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFor_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391);
			match(KW_FOR);
			setState(392);
			identifier();
			setState(393);
			infix_in();
			setState(394);
			inline_expression(0);
			setState(395);
			match(BRACE_L);
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4900057114887585472L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 68593L) != 0)) {
				{
				{
				setState(396);
				function_statements();
				}
				}
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(402);
			match(BRACE_R);
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
	public static class ExpressionContext extends ParserRuleContext {
		public Control_expressionContext control_expression() {
			return getRuleContext(Control_expressionContext.class,0);
		}
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieParser.PARENTHESES_R, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieParser.BRACKET_L, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode BRACKET_R() { return getToken(ValkyrieParser.BRACKET_R, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public Op_multipleContext op_multiple() {
			return getRuleContext(Op_multipleContext.class,0);
		}
		public Op_plusContext op_plus() {
			return getRuleContext(Op_plusContext.class,0);
		}
		public Op_logicContext op_logic() {
			return getRuleContext(Op_logicContext.class,0);
		}
		public Op_compareContext op_compare() {
			return getRuleContext(Op_compareContext.class,0);
		}
		public Infix_isContext infix_is() {
			return getRuleContext(Infix_isContext.class,0);
		}
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(405);
				control_expression();
				}
				break;
			case 2:
				{
				setState(406);
				namepath();
				setState(407);
				match(PARENTHESES_L);
				setState(409);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6917529027641081536L) != 0) || ((((_la - 68)) & ~0x3f) == 0 && ((1L << (_la - 68)) & 4287L) != 0)) {
					{
					setState(408);
					expr_list();
					}
				}

				setState(411);
				match(PARENTHESES_R);
				}
				break;
			case 3:
				{
				setState(413);
				namepath();
				setState(414);
				match(BRACKET_L);
				setState(415);
				expression(0);
				setState(416);
				match(BRACKET_R);
				}
				break;
			case 4:
				{
				setState(418);
				term();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(443);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(441);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(421);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(422);
						op_multiple();
						setState(423);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(425);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(426);
						op_plus();
						setState(427);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(429);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(430);
						op_logic();
						setState(431);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(433);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(434);
						op_compare();
						setState(435);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(437);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(438);
						infix_is();
						setState(439);
						type_expression(0);
						}
						break;
					}
					} 
				}
				setState(445);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
	public static class Control_expressionContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(ValkyrieParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RESUME() { return getToken(ValkyrieParser.RESUME, 0); }
		public TerminalNode BREAK() { return getToken(ValkyrieParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(ValkyrieParser.CONTINUE, 0); }
		public TerminalNode RAISE() { return getToken(ValkyrieParser.RAISE, 0); }
		public TerminalNode YIELD() { return getToken(ValkyrieParser.YIELD, 0); }
		public TerminalNode FROM() { return getToken(ValkyrieParser.FROM, 0); }
		public Control_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterControl_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitControl_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitControl_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Control_expressionContext control_expression() throws RecognitionException {
		Control_expressionContext _localctx = new Control_expressionContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_control_expression);
		try {
			setState(465);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(446);
				match(RETURN);
				setState(447);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(448);
				match(RESUME);
				setState(449);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				match(BREAK);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(451);
				match(CONTINUE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(452);
				match(RAISE);
				setState(453);
				expression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(454);
				match(YIELD);
				setState(456);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
				case 1:
					{
					setState(455);
					match(RETURN);
					}
					break;
				}
				setState(458);
				expression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(459);
				match(YIELD);
				setState(460);
				match(BREAK);
				setState(461);
				expression(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(462);
				match(YIELD);
				setState(463);
				match(FROM);
				setState(464);
				expression(0);
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
	public static class Inline_expressionContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public List<Inline_expressionContext> inline_expression() {
			return getRuleContexts(Inline_expressionContext.class);
		}
		public Inline_expressionContext inline_expression(int i) {
			return getRuleContext(Inline_expressionContext.class,i);
		}
		public Op_multipleContext op_multiple() {
			return getRuleContext(Op_multipleContext.class,0);
		}
		public Op_compareContext op_compare() {
			return getRuleContext(Op_compareContext.class,0);
		}
		public Infix_isContext infix_is() {
			return getRuleContext(Infix_isContext.class,0);
		}
		public Inline_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterInline_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitInline_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitInline_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inline_expressionContext inline_expression() throws RecognitionException {
		return inline_expression(0);
	}

	private Inline_expressionContext inline_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Inline_expressionContext _localctx = new Inline_expressionContext(_ctx, _parentState);
		Inline_expressionContext _prevctx = _localctx;
		int _startState = 66;
		enterRecursionRule(_localctx, 66, RULE_inline_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(468);
			term();
			}
			_ctx.stop = _input.LT(-1);
			setState(492);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(490);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
					case 1:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(470);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(471);
						op_multiple();
						setState(472);
						inline_expression(7);
						}
						break;
					case 2:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(474);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(475);
						op_multiple();
						setState(476);
						inline_expression(6);
						}
						break;
					case 3:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(478);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(479);
						op_multiple();
						setState(480);
						inline_expression(5);
						}
						break;
					case 4:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(482);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(483);
						op_compare();
						setState(484);
						inline_expression(4);
						}
						break;
					case 5:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(486);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(487);
						infix_is();
						setState(488);
						inline_expression(3);
						}
						break;
					}
					} 
				}
				setState(494);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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
	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EIdentifierContext extends TermContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EIdentifierContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterEIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitEIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitEIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EParensContext extends TermContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieParser.PARENTHESES_L, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieParser.PARENTHESES_R, 0); }
		public EParensContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterEParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitEParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitEParens(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EVectorContext extends TermContext {
		public TerminalNode BRACKET_L() { return getToken(ValkyrieParser.BRACKET_L, 0); }
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public TerminalNode BRACKET_R() { return getToken(ValkyrieParser.BRACKET_R, 0); }
		public EVectorContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterEVector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitEVector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitEVector(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ENumberContext extends TermContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ENumberContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterENumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitENumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitENumber(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ESpeicalLiteralContext extends TermContext {
		public TerminalNode SPECIAL() { return getToken(ValkyrieParser.SPECIAL, 0); }
		public ESpeicalLiteralContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterESpeicalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitESpeicalLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitESpeicalLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EStringContext extends TermContext {
		public TerminalNode STRING() { return getToken(ValkyrieParser.STRING, 0); }
		public EStringContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterEString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitEString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitEString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_term);
		try {
			setState(507);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UNICODE_ID:
				_localctx = new EIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(495);
				identifier();
				}
				break;
			case INTEGER:
				_localctx = new ENumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(496);
				number();
				}
				break;
			case STRING:
				_localctx = new EStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(497);
				match(STRING);
				}
				break;
			case PARENTHESES_L:
				_localctx = new EParensContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(498);
				match(PARENTHESES_L);
				setState(499);
				expression(0);
				setState(500);
				match(PARENTHESES_R);
				}
				break;
			case BRACKET_L:
				_localctx = new EVectorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(502);
				match(BRACKET_L);
				setState(503);
				expr_list();
				setState(504);
				match(BRACKET_R);
				}
				break;
			case SPECIAL:
				_localctx = new ESpeicalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(506);
				match(SPECIAL);
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
	public static class Op_compareContext extends ParserRuleContext {
		public TerminalNode OP_LE() { return getToken(ValkyrieParser.OP_LE, 0); }
		public TerminalNode OP_LEQ() { return getToken(ValkyrieParser.OP_LEQ, 0); }
		public TerminalNode OP_GE() { return getToken(ValkyrieParser.OP_GE, 0); }
		public TerminalNode OP_GEQ() { return getToken(ValkyrieParser.OP_GEQ, 0); }
		public Op_compareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterOp_compare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitOp_compare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitOp_compare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_compareContext op_compare() throws RecognitionException {
		Op_compareContext _localctx = new Op_compareContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_op_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 40108032L) != 0)) ) {
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
	public static class Op_patternContext extends ParserRuleContext {
		public TerminalNode OP_AND() { return getToken(ValkyrieParser.OP_AND, 0); }
		public TerminalNode OP_OR() { return getToken(ValkyrieParser.OP_OR, 0); }
		public Op_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterOp_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitOp_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitOp_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_patternContext op_pattern() throws RecognitionException {
		Op_patternContext _localctx = new Op_patternContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_op_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			_la = _input.LA(1);
			if ( !(_la==OP_OR || _la==OP_AND) ) {
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
	public static class Op_multipleContext extends ParserRuleContext {
		public TerminalNode OP_MUL() { return getToken(ValkyrieParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(ValkyrieParser.OP_DIV, 0); }
		public Op_multipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_multiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterOp_multiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitOp_multiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitOp_multiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_multipleContext op_multiple() throws RecognitionException {
		Op_multipleContext _localctx = new Op_multipleContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_op_multiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			_la = _input.LA(1);
			if ( !(_la==OP_MUL || _la==OP_DIV) ) {
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
	public static class Op_plusContext extends ParserRuleContext {
		public TerminalNode OP_ADD() { return getToken(ValkyrieParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(ValkyrieParser.OP_SUB, 0); }
		public Op_plusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_plus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterOp_plus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitOp_plus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitOp_plus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_plusContext op_plus() throws RecognitionException {
		Op_plusContext _localctx = new Op_plusContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_op_plus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			_la = _input.LA(1);
			if ( !(_la==OP_ADD || _la==OP_SUB) ) {
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
	public static class Op_logicContext extends ParserRuleContext {
		public TerminalNode LOGIC_OR() { return getToken(ValkyrieParser.LOGIC_OR, 0); }
		public TerminalNode LOGIC_AND() { return getToken(ValkyrieParser.LOGIC_AND, 0); }
		public Op_logicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_logic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterOp_logic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitOp_logic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitOp_logic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_logicContext op_logic() throws RecognitionException {
		Op_logicContext _localctx = new Op_logicContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_op_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			_la = _input.LA(1);
			if ( !(_la==LOGIC_OR || _la==LOGIC_AND) ) {
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
	public static class Infix_isContext extends ParserRuleContext {
		public TerminalNode KW_IS() { return getToken(ValkyrieParser.KW_IS, 0); }
		public TerminalNode KW_NOT() { return getToken(ValkyrieParser.KW_NOT, 0); }
		public Infix_isContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_is; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterInfix_is(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitInfix_is(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitInfix_is(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Infix_isContext infix_is() throws RecognitionException {
		Infix_isContext _localctx = new Infix_isContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_infix_is);
		try {
			setState(522);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				match(KW_IS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(520);
				match(KW_IS);
				setState(521);
				match(KW_NOT);
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
	public static class Infix_inContext extends ParserRuleContext {
		public TerminalNode KW_IN() { return getToken(ValkyrieParser.KW_IN, 0); }
		public TerminalNode OP_IN() { return getToken(ValkyrieParser.OP_IN, 0); }
		public Infix_inContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_in; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterInfix_in(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitInfix_in(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitInfix_in(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Infix_inContext infix_in() throws RecognitionException {
		Infix_inContext _localctx = new Infix_inContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_infix_in);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(524);
			_la = _input.LA(1);
			if ( !(_la==OP_IN || _la==KW_IN) ) {
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
	public static class Type_expressionContext extends ParserRuleContext {
		public Type_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_expression; }
	 
		public Type_expressionContext() { }
		public void copyFrom(Type_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TParensContext extends Type_expressionContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieParser.PARENTHESES_L, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieParser.PARENTHESES_R, 0); }
		public TParensContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterTParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitTParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitTParens(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TTermContext extends Type_expressionContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TTermContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterTTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitTTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitTTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TPatternContext extends Type_expressionContext {
		public List<Type_expressionContext> type_expression() {
			return getRuleContexts(Type_expressionContext.class);
		}
		public Type_expressionContext type_expression(int i) {
			return getRuleContext(Type_expressionContext.class,i);
		}
		public Op_patternContext op_pattern() {
			return getRuleContext(Op_patternContext.class,0);
		}
		public TPatternContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterTPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitTPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitTPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_expressionContext type_expression() throws RecognitionException {
		return type_expression(0);
	}

	private Type_expressionContext type_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Type_expressionContext _localctx = new Type_expressionContext(_ctx, _parentState);
		Type_expressionContext _prevctx = _localctx;
		int _startState = 84;
		enterRecursionRule(_localctx, 84, RULE_type_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				{
				_localctx = new TParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(527);
				match(PARENTHESES_L);
				setState(528);
				type_expression(0);
				setState(529);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				{
				_localctx = new TTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(531);
				term();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(540);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TPatternContext(new Type_expressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
					setState(534);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(535);
					op_pattern();
					setState(536);
					type_expression(4);
					}
					} 
				}
				setState(542);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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
	public static class Expr_listContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
		enterRule(_localctx, 86, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			expression(0);
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(544);
				match(COMMA);
				setState(545);
				expression(0);
				}
				}
				setState(550);
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
	public static class Macro_callContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(ValkyrieParser.HASH, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Macro_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterMacro_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitMacro_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitMacro_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Macro_callContext macro_call() throws RecognitionException {
		Macro_callContext _localctx = new Macro_callContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_macro_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(551);
			match(HASH);
			setState(552);
			namepath();
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
	public static class Namepath_freeContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> OP_PROPORTION() { return getTokens(ValkyrieParser.OP_PROPORTION); }
		public TerminalNode OP_PROPORTION(int i) {
			return getToken(ValkyrieParser.OP_PROPORTION, i);
		}
		public List<TerminalNode> DOT() { return getTokens(ValkyrieParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ValkyrieParser.DOT, i);
		}
		public Namepath_freeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namepath_free; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterNamepath_free(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitNamepath_free(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitNamepath_free(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Namepath_freeContext namepath_free() throws RecognitionException {
		Namepath_freeContext _localctx = new Namepath_freeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_namepath_free);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			identifier();
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==OP_PROPORTION) {
				{
				{
				setState(555);
				_la = _input.LA(1);
				if ( !(_la==DOT || _la==OP_PROPORTION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(556);
				identifier();
				}
				}
				setState(561);
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
	public static class NamepathContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> OP_PROPORTION() { return getTokens(ValkyrieParser.OP_PROPORTION); }
		public TerminalNode OP_PROPORTION(int i) {
			return getToken(ValkyrieParser.OP_PROPORTION, i);
		}
		public NamepathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namepath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterNamepath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitNamepath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitNamepath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamepathContext namepath() throws RecognitionException {
		NamepathContext _localctx = new NamepathContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_namepath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			identifier();
			setState(567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_PROPORTION) {
				{
				{
				setState(563);
				match(OP_PROPORTION);
				setState(564);
				identifier();
				}
				}
				setState(569);
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
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

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(570);
			match(UNICODE_ID);
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
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(ValkyrieParser.INTEGER, 0); }
		public Number_suffixContext number_suffix() {
			return getRuleContext(Number_suffixContext.class,0);
		}
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			match(INTEGER);
			setState(574);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(573);
				number_suffix();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Number_suffixContext extends ParserRuleContext {
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieParser.UNICODE_ID, 0); }
		public Number_suffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_suffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterNumber_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitNumber_suffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitNumber_suffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Number_suffixContext number_suffix() throws RecognitionException {
		Number_suffixContext _localctx = new Number_suffixContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_number_suffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(576);
			match(UNICODE_ID);
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
		case 31:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 33:
			return inline_expression_sempred((Inline_expressionContext)_localctx, predIndex);
		case 42:
			return type_expression_sempred((Type_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 9);
		case 1:
			return precpred(_ctx, 8);
		case 2:
			return precpred(_ctx, 7);
		case 3:
			return precpred(_ctx, 6);
		case 4:
			return precpred(_ctx, 5);
		}
		return true;
	}
	private boolean inline_expression_sempred(Inline_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean type_expression_sempred(Type_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001P\u0243\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0001"+
		"\u0000\u0005\u0000f\b\u0000\n\u0000\f\u0000i\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0003\u0001o\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001s\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001w\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001{\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u007f\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0083\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0087\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u008b\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u008f"+
		"\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u0093\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u0097\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u009b\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u009f\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u00a3\b\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u00a7\b\u0001\u0003\u0001\u00a9\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0005\u0007"+
		"\u00b8\b\u0007\n\u0007\f\u0007\u00bb\t\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u00c0\b\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00c4"+
		"\b\u0007\n\u0007\f\u0007\u00c7\t\u0007\u0001\u0007\u0001\u0007\u0001\b"+
		"\u0001\b\u0001\b\u0003\b\u00ce\b\b\u0001\t\u0001\t\u0003\t\u00d2\b\t\u0001"+
		"\t\u0001\t\u0001\n\u0005\n\u00d7\b\n\n\n\f\n\u00da\t\n\u0001\n\u0004\n"+
		"\u00dd\b\n\u000b\n\f\n\u00de\u0001\n\u0003\n\u00e2\b\n\u0001\n\u0003\n"+
		"\u00e5\b\n\u0001\u000b\u0005\u000b\u00e8\b\u000b\n\u000b\f\u000b\u00eb"+
		"\t\u000b\u0001\u000b\u0004\u000b\u00ee\b\u000b\u000b\u000b\f\u000b\u00ef"+
		"\u0001\u000b\u0001\u000b\u0003\u000b\u00f4\b\u000b\u0001\u000b\u0003\u000b"+
		"\u00f7\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u00fd\b\f\n\f\f"+
		"\f\u0100\t\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0108"+
		"\b\r\n\r\f\r\u010b\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u0113\b\u000e\n\u000e\f\u000e\u0116\t\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u011c\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0122\b\u0010\n"+
		"\u0010\f\u0010\u0125\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u012b\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u0130\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u013b"+
		"\b\u0014\u0001\u0014\u0003\u0014\u013e\b\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u0142\b\u0014\n\u0014\f\u0014\u0145\t\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u014d"+
		"\b\u0015\n\u0015\f\u0015\u0150\t\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u0156\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u015a\b\u0016\u0001\u0016\u0003\u0016\u015d\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u0164\b\u0018\u0001"+
		"\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u017b\b\u001c\u0001\u001d\u0001"+
		"\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0181\b\u001d\n\u001d\f\u001d"+
		"\u0184\t\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e\u018e\b\u001e\n\u001e"+
		"\f\u001e\u0191\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u019a\b\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0003\u001f\u01a4\b\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0005\u001f"+
		"\u01ba\b\u001f\n\u001f\f\u001f\u01bd\t\u001f\u0001 \u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u01c9\b \u0001 \u0001"+
		" \u0001 \u0001 \u0001 \u0001 \u0001 \u0003 \u01d2\b \u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0005!\u01eb\b!\n!\f!\u01ee\t!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01fc"+
		"\b\"\u0001#\u0001#\u0001$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001\'\u0001"+
		"\'\u0001(\u0001(\u0001(\u0003(\u020b\b(\u0001)\u0001)\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001*\u0003*\u0215\b*\u0001*\u0001*\u0001*\u0001*\u0005"+
		"*\u021b\b*\n*\f*\u021e\t*\u0001+\u0001+\u0001+\u0005+\u0223\b+\n+\f+\u0226"+
		"\t+\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0005-\u022e\b-\n-\f-\u0231"+
		"\t-\u0001.\u0001.\u0001.\u0005.\u0236\b.\n.\f.\u0239\t.\u0001/\u0001/"+
		"\u00010\u00010\u00030\u023f\b0\u00011\u00011\u00011\u0000\u0003>BT2\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`b\u0000\t\u0001\u0000\u0002\u0003"+
		"\u0002\u0000\u0005\u0005\u001a\u001a\u0003\u0000\u0012\u0012\u0015\u0016"+
		"\u0019\u0019\u0002\u0000\u001e\u001e  \u0001\u0000\u000e\u000f\u0001\u0000"+
		"\f\r\u0002\u0000\u001d\u001d\u001f\u001f\u0001\u0000%&\u0002\u0000\u0001"+
		"\u0001\u0004\u0004\u0270\u0000g\u0001\u0000\u0000\u0000\u0002\u00a8\u0001"+
		"\u0000\u0000\u0000\u0004\u00aa\u0001\u0000\u0000\u0000\u0006\u00ac\u0001"+
		"\u0000\u0000\u0000\b\u00ae\u0001\u0000\u0000\u0000\n\u00b1\u0001\u0000"+
		"\u0000\u0000\f\u00b4\u0001\u0000\u0000\u0000\u000e\u00b9\u0001\u0000\u0000"+
		"\u0000\u0010\u00cd\u0001\u0000\u0000\u0000\u0012\u00cf\u0001\u0000\u0000"+
		"\u0000\u0014\u00d8\u0001\u0000\u0000\u0000\u0016\u00e9\u0001\u0000\u0000"+
		"\u0000\u0018\u00f8\u0001\u0000\u0000\u0000\u001a\u0103\u0001\u0000\u0000"+
		"\u0000\u001c\u010e\u0001\u0000\u0000\u0000\u001e\u0119\u0001\u0000\u0000"+
		"\u0000 \u011d\u0001\u0000\u0000\u0000\"\u012a\u0001\u0000\u0000\u0000"+
		"$\u012c\u0001\u0000\u0000\u0000&\u0131\u0001\u0000\u0000\u0000(\u0136"+
		"\u0001\u0000\u0000\u0000*\u0155\u0001\u0000\u0000\u0000,\u0157\u0001\u0000"+
		"\u0000\u0000.\u015e\u0001\u0000\u0000\u00000\u0163\u0001\u0000\u0000\u0000"+
		"2\u0165\u0001\u0000\u0000\u00004\u016a\u0001\u0000\u0000\u00006\u016d"+
		"\u0001\u0000\u0000\u00008\u0170\u0001\u0000\u0000\u0000:\u017c\u0001\u0000"+
		"\u0000\u0000<\u0187\u0001\u0000\u0000\u0000>\u01a3\u0001\u0000\u0000\u0000"+
		"@\u01d1\u0001\u0000\u0000\u0000B\u01d3\u0001\u0000\u0000\u0000D\u01fb"+
		"\u0001\u0000\u0000\u0000F\u01fd\u0001\u0000\u0000\u0000H\u01ff\u0001\u0000"+
		"\u0000\u0000J\u0201\u0001\u0000\u0000\u0000L\u0203\u0001\u0000\u0000\u0000"+
		"N\u0205\u0001\u0000\u0000\u0000P\u020a\u0001\u0000\u0000\u0000R\u020c"+
		"\u0001\u0000\u0000\u0000T\u0214\u0001\u0000\u0000\u0000V\u021f\u0001\u0000"+
		"\u0000\u0000X\u0227\u0001\u0000\u0000\u0000Z\u022a\u0001\u0000\u0000\u0000"+
		"\\\u0232\u0001\u0000\u0000\u0000^\u023a\u0001\u0000\u0000\u0000`\u023c"+
		"\u0001\u0000\u0000\u0000b\u0240\u0001\u0000\u0000\u0000df\u0003\u0002"+
		"\u0001\u0000ed\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hj\u0001\u0000\u0000\u0000"+
		"ig\u0001\u0000\u0000\u0000jk\u0005\u0000\u0000\u0001k\u0001\u0001\u0000"+
		"\u0000\u0000ln\u0003\b\u0004\u0000mo\u0003\u0004\u0002\u0000nm\u0001\u0000"+
		"\u0000\u0000no\u0001\u0000\u0000\u0000o\u00a9\u0001\u0000\u0000\u0000"+
		"pr\u0003\n\u0005\u0000qs\u0003\u0004\u0002\u0000rq\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000s\u00a9\u0001\u0000\u0000\u0000tv\u0003\f\u0006"+
		"\u0000uw\u0003\u0004\u0002\u0000vu\u0001\u0000\u0000\u0000vw\u0001\u0000"+
		"\u0000\u0000w\u00a9\u0001\u0000\u0000\u0000xz\u0003\u000e\u0007\u0000"+
		"y{\u0003\u0004\u0002\u0000zy\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{\u00a9\u0001\u0000\u0000\u0000|~\u0003\u001c\u000e\u0000}\u007f"+
		"\u0003\u0004\u0002\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000"+
		"\u0000\u0000\u007f\u00a9\u0001\u0000\u0000\u0000\u0080\u0082\u0003 \u0010"+
		"\u0000\u0081\u0083\u0003\u0004\u0002\u0000\u0082\u0081\u0001\u0000\u0000"+
		"\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u00a9\u0001\u0000\u0000"+
		"\u0000\u0084\u0086\u0003\u0018\f\u0000\u0085\u0087\u0003\u0004\u0002\u0000"+
		"\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000"+
		"\u0087\u00a9\u0001\u0000\u0000\u0000\u0088\u008a\u0003\u001a\r\u0000\u0089"+
		"\u008b\u0003\u0004\u0002\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0001\u0000\u0000\u0000\u008b\u00a9\u0001\u0000\u0000\u0000\u008c"+
		"\u008e\u0003(\u0014\u0000\u008d\u008f\u0003\u0004\u0002\u0000\u008e\u008d"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u00a9"+
		"\u0001\u0000\u0000\u0000\u0090\u0092\u00032\u0019\u0000\u0091\u0093\u0003"+
		"\u0004\u0002\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u00a9\u0001\u0000\u0000\u0000\u0094\u0096\u0003"+
		"&\u0013\u0000\u0095\u0097\u0003\u0004\u0002\u0000\u0096\u0095\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u00a9\u0001\u0000"+
		"\u0000\u0000\u0098\u009a\u00038\u001c\u0000\u0099\u009b\u0003\u0004\u0002"+
		"\u0000\u009a\u0099\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000"+
		"\u0000\u009b\u00a9\u0001\u0000\u0000\u0000\u009c\u009e\u0003:\u001d\u0000"+
		"\u009d\u009f\u0003\u0004\u0002\u0000\u009e\u009d\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a2\u0003<\u001e\u0000\u00a1\u00a3\u0003\u0004\u0002\u0000\u00a2"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a4\u00a6\u0003>\u001f\u0000\u00a5\u00a7"+
		"\u0003\u0004\u0002\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8l\u0001"+
		"\u0000\u0000\u0000\u00a8p\u0001\u0000\u0000\u0000\u00a8t\u0001\u0000\u0000"+
		"\u0000\u00a8x\u0001\u0000\u0000\u0000\u00a8|\u0001\u0000\u0000\u0000\u00a8"+
		"\u0080\u0001\u0000\u0000\u0000\u00a8\u0084\u0001\u0000\u0000\u0000\u00a8"+
		"\u0088\u0001\u0000\u0000\u0000\u00a8\u008c\u0001\u0000\u0000\u0000\u00a8"+
		"\u0090\u0001\u0000\u0000\u0000\u00a8\u0094\u0001\u0000\u0000\u0000\u00a8"+
		"\u0098\u0001\u0000\u0000\u0000\u00a8\u009c\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a8\u00a4\u0001\u0000\u0000\u0000\u00a9"+
		"\u0003\u0001\u0000\u0000\u0000\u00aa\u00ab\u0005\u0003\u0000\u0000\u00ab"+
		"\u0005\u0001\u0000\u0000\u0000\u00ac\u00ad\u0007\u0000\u0000\u0000\u00ad"+
		"\u0007\u0001\u0000\u0000\u0000\u00ae\u00af\u0005/\u0000\u0000\u00af\u00b0"+
		"\u0003Z-\u0000\u00b0\t\u0001\u0000\u0000\u0000\u00b1\u00b2\u00050\u0000"+
		"\u0000\u00b2\u00b3\u0003Z-\u0000\u00b3\u000b\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u00051\u0000\u0000\u00b5\r\u0001\u0000\u0000\u0000\u00b6\u00b8"+
		"\u0003X,\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001\u0000"+
		"\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000"+
		"\u0000\u0000\u00ba\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bd\u00053\u0000\u0000\u00bd\u00bf\u0003\\.\u0000"+
		"\u00be\u00c0\u0003\u0012\t\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00bf"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u00c5\u0005\n\u0000\u0000\u00c2\u00c4\u0003\u0010\b\u0000\u00c3\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c8\u00c9"+
		"\u0005\u000b\u0000\u0000\u00c9\u000f\u0001\u0000\u0000\u0000\u00ca\u00ce"+
		"\u0003\u0016\u000b\u0000\u00cb\u00ce\u0003\u0014\n\u0000\u00cc\u00ce\u0003"+
		"\u0006\u0003\u0000\u00cd\u00ca\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001"+
		"\u0000\u0000\u0000\u00cd\u00cc\u0001\u0000\u0000\u0000\u00ce\u0011\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d1\u0005\u0006\u0000\u0000\u00d0\u00d2\u0003"+
		"\\.\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d1\u00d2\u0001\u0000"+
		"\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0005\u0007"+
		"\u0000\u0000\u00d4\u0013\u0001\u0000\u0000\u0000\u00d5\u00d7\u0003X,\u0000"+
		"\u00d6\u00d5\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d9\u00dc\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000"+
		"\u00db\u00dd\u0003^/\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dd\u00de"+
		"\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0001\u0000\u0000\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00e2"+
		"\u00034\u001a\u0000\u00e1\u00e0\u0001\u0000\u0000\u0000\u00e1\u00e2\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e4\u0001\u0000\u0000\u0000\u00e3\u00e5\u0003"+
		".\u0017\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e5\u0015\u0001\u0000\u0000\u0000\u00e6\u00e8\u0003X,\u0000"+
		"\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000"+
		"\u00e9\u00e7\u0001\u0000\u0000\u0000\u00e9\u00ea\u0001\u0000\u0000\u0000"+
		"\u00ea\u00ed\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00ec\u00ee\u0003^/\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f3"+
		"\u0003*\u0015\u0000\u00f2\u00f4\u00034\u001a\u0000\u00f3\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4\u00f6\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f7\u00036\u001b\u0000\u00f6\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u0017\u0001\u0000\u0000"+
		"\u0000\u00f8\u00f9\u00054\u0000\u0000\u00f9\u00fa\u0003\\.\u0000\u00fa"+
		"\u00fe\u0005\n\u0000\u0000\u00fb\u00fd\u0003\u0010\b\u0000\u00fc\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fd\u0100\u0001\u0000\u0000\u0000\u00fe\u00fc"+
		"\u0001\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0101"+
		"\u0001\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0101\u0102"+
		"\u0005\u000b\u0000\u0000\u0102\u0019\u0001\u0000\u0000\u0000\u0103\u0104"+
		"\u00052\u0000\u0000\u0104\u0105\u0003\\.\u0000\u0105\u0109\u0005\n\u0000"+
		"\u0000\u0106\u0108\u0003\u0010\b\u0000\u0107\u0106\u0001\u0000\u0000\u0000"+
		"\u0108\u010b\u0001\u0000\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000"+
		"\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010c\u0001\u0000\u0000\u0000"+
		"\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010d\u0005\u000b\u0000\u0000"+
		"\u010d\u001b\u0001\u0000\u0000\u0000\u010e\u010f\u00055\u0000\u0000\u010f"+
		"\u0110\u0003\\.\u0000\u0110\u0114\u0005\n\u0000\u0000\u0111\u0113\u0003"+
		"\u001e\u000f\u0000\u0112\u0111\u0001\u0000\u0000\u0000\u0113\u0116\u0001"+
		"\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0114\u0115\u0001"+
		"\u0000\u0000\u0000\u0115\u0117\u0001\u0000\u0000\u0000\u0116\u0114\u0001"+
		"\u0000\u0000\u0000\u0117\u0118\u0005\u000b\u0000\u0000\u0118\u001d\u0001"+
		"\u0000\u0000\u0000\u0119\u011b\u0003(\u0014\u0000\u011a\u011c\u0003\u0004"+
		"\u0002\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000"+
		"\u0000\u0000\u011c\u001f\u0001\u0000\u0000\u0000\u011d\u011e\u00056\u0000"+
		"\u0000\u011e\u011f\u0003\\.\u0000\u011f\u0123\u0005\n\u0000\u0000\u0120"+
		"\u0122\u0003\"\u0011\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0122\u0125"+
		"\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0001\u0000\u0000\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125\u0123"+
		"\u0001\u0000\u0000\u0000\u0126\u0127\u0005\u000b\u0000\u0000\u0127!\u0001"+
		"\u0000\u0000\u0000\u0128\u012b\u0003$\u0012\u0000\u0129\u012b\u0003\u0006"+
		"\u0003\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012a\u0129\u0001\u0000"+
		"\u0000\u0000\u012b#\u0001\u0000\u0000\u0000\u012c\u012f\u0003^/\u0000"+
		"\u012d\u012e\u0005\u001c\u0000\u0000\u012e\u0130\u0003>\u001f\u0000\u012f"+
		"\u012d\u0001\u0000\u0000\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130"+
		"%\u0001\u0000\u0000\u0000\u0131\u0132\u00058\u0000\u0000\u0132\u0133\u0003"+
		"^/\u0000\u0133\u0134\u0005\u001c\u0000\u0000\u0134\u0135\u0003>\u001f"+
		"\u0000\u0135\'\u0001\u0000\u0000\u0000\u0136\u0137\u00059\u0000\u0000"+
		"\u0137\u0138\u0003\\.\u0000\u0138\u013a\u0003*\u0015\u0000\u0139\u013b"+
		"\u00034\u001a\u0000\u013a\u0139\u0001\u0000\u0000\u0000\u013a\u013b\u0001"+
		"\u0000\u0000\u0000\u013b\u013d\u0001\u0000\u0000\u0000\u013c\u013e\u0003"+
		"6\u001b\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000"+
		"\u0000\u0000\u013e\u013f\u0001\u0000\u0000\u0000\u013f\u0143\u0005\n\u0000"+
		"\u0000\u0140\u0142\u00030\u0018\u0000\u0141\u0140\u0001\u0000\u0000\u0000"+
		"\u0142\u0145\u0001\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000"+
		"\u0143\u0144\u0001\u0000\u0000\u0000\u0144\u0146\u0001\u0000\u0000\u0000"+
		"\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u0147\u0005\u000b\u0000\u0000"+
		"\u0147)\u0001\u0000\u0000\u0000\u0148\u0149\u0005\u0006\u0000\u0000\u0149"+
		"\u014e\u0003,\u0016\u0000\u014a\u014b\u0005\u0002\u0000\u0000\u014b\u014d"+
		"\u0003,\u0016\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014d\u0150\u0001"+
		"\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001"+
		"\u0000\u0000\u0000\u014f\u0151\u0001\u0000\u0000\u0000\u0150\u014e\u0001"+
		"\u0000\u0000\u0000\u0151\u0152\u0005\u0007\u0000\u0000\u0152\u0156\u0001"+
		"\u0000\u0000\u0000\u0153\u0154\u0005\u0006\u0000\u0000\u0154\u0156\u0005"+
		"\u0007\u0000\u0000\u0155\u0148\u0001\u0000\u0000\u0000\u0155\u0153\u0001"+
		"\u0000\u0000\u0000\u0156+\u0001\u0000\u0000\u0000\u0157\u0159\u0003^/"+
		"\u0000\u0158\u015a\u00034\u001a\u0000\u0159\u0158\u0001\u0000\u0000\u0000"+
		"\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015c\u0001\u0000\u0000\u0000"+
		"\u015b\u015d\u0003.\u0017\u0000\u015c\u015b\u0001\u0000\u0000\u0000\u015c"+
		"\u015d\u0001\u0000\u0000\u0000\u015d-\u0001\u0000\u0000\u0000\u015e\u015f"+
		"\u0005\u001c\u0000\u0000\u015f\u0160\u0003B!\u0000\u0160/\u0001\u0000"+
		"\u0000\u0000\u0161\u0164\u0003\u0002\u0001\u0000\u0162\u0164\u0003&\u0013"+
		"\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163\u0162\u0001\u0000\u0000"+
		"\u0000\u01641\u0001\u0000\u0000\u0000\u0165\u0166\u00057\u0000\u0000\u0166"+
		"\u0167\u0003^/\u0000\u0167\u0168\u0005\u001c\u0000\u0000\u0168\u0169\u0003"+
		"^/\u0000\u01693\u0001\u0000\u0000\u0000\u016a\u016b\u0007\u0001\u0000"+
		"\u0000\u016b\u016c\u0003T*\u0000\u016c5\u0001\u0000\u0000\u0000\u016d"+
		"\u016e\u0005\u000f\u0000\u0000\u016e\u016f\u0003T*\u0000\u016f7\u0001"+
		"\u0000\u0000\u0000\u0170\u0171\u0005@\u0000\u0000\u0171\u0172\u0003>\u001f"+
		"\u0000\u0172\u0173\u0005\n\u0000\u0000\u0173\u0174\u0003\u0002\u0001\u0000"+
		"\u0174\u017a\u0005\u000b\u0000\u0000\u0175\u0176\u0005A\u0000\u0000\u0176"+
		"\u0177\u0005\n\u0000\u0000\u0177\u0178\u0003\u0002\u0001\u0000\u0178\u0179"+
		"\u0005\u000b\u0000\u0000\u0179\u017b\u0001\u0000\u0000\u0000\u017a\u0175"+
		"\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000\u0000\u017b9\u0001"+
		"\u0000\u0000\u0000\u017c\u017d\u0005;\u0000\u0000\u017d\u017e\u0003B!"+
		"\u0000\u017e\u0182\u0005\n\u0000\u0000\u017f\u0181\u0003\u0002\u0001\u0000"+
		"\u0180\u017f\u0001\u0000\u0000\u0000\u0181\u0184\u0001\u0000\u0000\u0000"+
		"\u0182\u0180\u0001\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000"+
		"\u0183\u0185\u0001\u0000\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000"+
		"\u0185\u0186\u0005\u000b\u0000\u0000\u0186;\u0001\u0000\u0000\u0000\u0187"+
		"\u0188\u0005<\u0000\u0000\u0188\u0189\u0003^/\u0000\u0189\u018a\u0003"+
		"R)\u0000\u018a\u018b\u0003B!\u0000\u018b\u018f\u0005\n\u0000\u0000\u018c"+
		"\u018e\u00030\u0018\u0000\u018d\u018c\u0001\u0000\u0000\u0000\u018e\u0191"+
		"\u0001\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u018f\u0190"+
		"\u0001\u0000\u0000\u0000\u0190\u0192\u0001\u0000\u0000\u0000\u0191\u018f"+
		"\u0001\u0000\u0000\u0000\u0192\u0193\u0005\u000b\u0000\u0000\u0193=\u0001"+
		"\u0000\u0000\u0000\u0194\u0195\u0006\u001f\uffff\uffff\u0000\u0195\u01a4"+
		"\u0003@ \u0000\u0196\u0197\u0003\\.\u0000\u0197\u0199\u0005\u0006\u0000"+
		"\u0000\u0198\u019a\u0003V+\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u0199"+
		"\u019a\u0001\u0000\u0000\u0000\u019a\u019b\u0001\u0000\u0000\u0000\u019b"+
		"\u019c\u0005\u0007\u0000\u0000\u019c\u01a4\u0001\u0000\u0000\u0000\u019d"+
		"\u019e\u0003\\.\u0000\u019e\u019f\u0005\b\u0000\u0000\u019f\u01a0\u0003"+
		">\u001f\u0000\u01a0\u01a1\u0005\t\u0000\u0000\u01a1\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a4\u0003D\"\u0000\u01a3\u0194\u0001\u0000\u0000"+
		"\u0000\u01a3\u0196\u0001\u0000\u0000\u0000\u01a3\u019d\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a2\u0001\u0000\u0000\u0000\u01a4\u01bb\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a6\n\t\u0000\u0000\u01a6\u01a7\u0003J%\u0000\u01a7\u01a8"+
		"\u0003>\u001f\n\u01a8\u01ba\u0001\u0000\u0000\u0000\u01a9\u01aa\n\b\u0000"+
		"\u0000\u01aa\u01ab\u0003L&\u0000\u01ab\u01ac\u0003>\u001f\t\u01ac\u01ba"+
		"\u0001\u0000\u0000\u0000\u01ad\u01ae\n\u0007\u0000\u0000\u01ae\u01af\u0003"+
		"N\'\u0000\u01af\u01b0\u0003>\u001f\b\u01b0\u01ba\u0001\u0000\u0000\u0000"+
		"\u01b1\u01b2\n\u0006\u0000\u0000\u01b2\u01b3\u0003F#\u0000\u01b3\u01b4"+
		"\u0003>\u001f\u0007\u01b4\u01ba\u0001\u0000\u0000\u0000\u01b5\u01b6\n"+
		"\u0005\u0000\u0000\u01b6\u01b7\u0003P(\u0000\u01b7\u01b8\u0003T*\u0000"+
		"\u01b8\u01ba\u0001\u0000\u0000\u0000\u01b9\u01a5\u0001\u0000\u0000\u0000"+
		"\u01b9\u01a9\u0001\u0000\u0000\u0000\u01b9\u01ad\u0001\u0000\u0000\u0000"+
		"\u01b9\u01b1\u0001\u0000\u0000\u0000\u01b9\u01b5\u0001\u0000\u0000\u0000"+
		"\u01ba\u01bd\u0001\u0000\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000"+
		"\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc?\u0001\u0000\u0000\u0000\u01bd"+
		"\u01bb\u0001\u0000\u0000\u0000\u01be\u01bf\u0005D\u0000\u0000\u01bf\u01d2"+
		"\u0003>\u001f\u0000\u01c0\u01c1\u0005E\u0000\u0000\u01c1\u01d2\u0003>"+
		"\u001f\u0000\u01c2\u01d2\u0005G\u0000\u0000\u01c3\u01d2\u0005H\u0000\u0000"+
		"\u01c4\u01c5\u0005I\u0000\u0000\u01c5\u01d2\u0003>\u001f\u0000\u01c6\u01c8"+
		"\u0005F\u0000\u0000\u01c7\u01c9\u0005D\u0000\u0000\u01c8\u01c7\u0001\u0000"+
		"\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9\u01ca\u0001\u0000"+
		"\u0000\u0000\u01ca\u01d2\u0003>\u001f\u0000\u01cb\u01cc\u0005F\u0000\u0000"+
		"\u01cc\u01cd\u0005G\u0000\u0000\u01cd\u01d2\u0003>\u001f\u0000\u01ce\u01cf"+
		"\u0005F\u0000\u0000\u01cf\u01d0\u0005C\u0000\u0000\u01d0\u01d2\u0003>"+
		"\u001f\u0000\u01d1\u01be\u0001\u0000\u0000\u0000\u01d1\u01c0\u0001\u0000"+
		"\u0000\u0000\u01d1\u01c2\u0001\u0000\u0000\u0000\u01d1\u01c3\u0001\u0000"+
		"\u0000\u0000\u01d1\u01c4\u0001\u0000\u0000\u0000\u01d1\u01c6\u0001\u0000"+
		"\u0000\u0000\u01d1\u01cb\u0001\u0000\u0000\u0000\u01d1\u01ce\u0001\u0000"+
		"\u0000\u0000\u01d2A\u0001\u0000\u0000\u0000\u01d3\u01d4\u0006!\uffff\uffff"+
		"\u0000\u01d4\u01d5\u0003D\"\u0000\u01d5\u01ec\u0001\u0000\u0000\u0000"+
		"\u01d6\u01d7\n\u0006\u0000\u0000\u01d7\u01d8\u0003J%\u0000\u01d8\u01d9"+
		"\u0003B!\u0007\u01d9\u01eb\u0001\u0000\u0000\u0000\u01da\u01db\n\u0005"+
		"\u0000\u0000\u01db\u01dc\u0003J%\u0000\u01dc\u01dd\u0003B!\u0006\u01dd"+
		"\u01eb\u0001\u0000\u0000\u0000\u01de\u01df\n\u0004\u0000\u0000\u01df\u01e0"+
		"\u0003J%\u0000\u01e0\u01e1\u0003B!\u0005\u01e1\u01eb\u0001\u0000\u0000"+
		"\u0000\u01e2\u01e3\n\u0003\u0000\u0000\u01e3\u01e4\u0003F#\u0000\u01e4"+
		"\u01e5\u0003B!\u0004\u01e5\u01eb\u0001\u0000\u0000\u0000\u01e6\u01e7\n"+
		"\u0002\u0000\u0000\u01e7\u01e8\u0003P(\u0000\u01e8\u01e9\u0003B!\u0003"+
		"\u01e9\u01eb\u0001\u0000\u0000\u0000\u01ea\u01d6\u0001\u0000\u0000\u0000"+
		"\u01ea\u01da\u0001\u0000\u0000\u0000\u01ea\u01de\u0001\u0000\u0000\u0000"+
		"\u01ea\u01e2\u0001\u0000\u0000\u0000\u01ea\u01e6\u0001\u0000\u0000\u0000"+
		"\u01eb\u01ee\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ed\u0001\u0000\u0000\u0000\u01edC\u0001\u0000\u0000\u0000\u01ee"+
		"\u01ec\u0001\u0000\u0000\u0000\u01ef\u01fc\u0003^/\u0000\u01f0\u01fc\u0003"+
		"`0\u0000\u01f1\u01fc\u0005?\u0000\u0000\u01f2\u01f3\u0005\u0006\u0000"+
		"\u0000\u01f3\u01f4\u0003>\u001f\u0000\u01f4\u01f5\u0005\u0007\u0000\u0000"+
		"\u01f5\u01fc\u0001\u0000\u0000\u0000\u01f6\u01f7\u0005\b\u0000\u0000\u01f7"+
		"\u01f8\u0003V+\u0000\u01f8\u01f9\u0005\t\u0000\u0000\u01f9\u01fc\u0001"+
		"\u0000\u0000\u0000\u01fa\u01fc\u0005K\u0000\u0000\u01fb\u01ef\u0001\u0000"+
		"\u0000\u0000\u01fb\u01f0\u0001\u0000\u0000\u0000\u01fb\u01f1\u0001\u0000"+
		"\u0000\u0000\u01fb\u01f2\u0001\u0000\u0000\u0000\u01fb\u01f6\u0001\u0000"+
		"\u0000\u0000\u01fb\u01fa\u0001\u0000\u0000\u0000\u01fcE\u0001\u0000\u0000"+
		"\u0000\u01fd\u01fe\u0007\u0002\u0000\u0000\u01feG\u0001\u0000\u0000\u0000"+
		"\u01ff\u0200\u0007\u0003\u0000\u0000\u0200I\u0001\u0000\u0000\u0000\u0201"+
		"\u0202\u0007\u0004\u0000\u0000\u0202K\u0001\u0000\u0000\u0000\u0203\u0204"+
		"\u0007\u0005\u0000\u0000\u0204M\u0001\u0000\u0000\u0000\u0205\u0206\u0007"+
		"\u0006\u0000\u0000\u0206O\u0001\u0000\u0000\u0000\u0207\u020b\u0005(\u0000"+
		"\u0000\u0208\u0209\u0005(\u0000\u0000\u0209\u020b\u0005$\u0000\u0000\u020a"+
		"\u0207\u0001\u0000\u0000\u0000\u020a\u0208\u0001\u0000\u0000\u0000\u020b"+
		"Q\u0001\u0000\u0000\u0000\u020c\u020d\u0007\u0007\u0000\u0000\u020dS\u0001"+
		"\u0000\u0000\u0000\u020e\u020f\u0006*\uffff\uffff\u0000\u020f\u0210\u0005"+
		"\u0006\u0000\u0000\u0210\u0211\u0003T*\u0000\u0211\u0212\u0005\u0007\u0000"+
		"\u0000\u0212\u0215\u0001\u0000\u0000\u0000\u0213\u0215\u0003D\"\u0000"+
		"\u0214\u020e\u0001\u0000\u0000\u0000\u0214\u0213\u0001\u0000\u0000\u0000"+
		"\u0215\u021c\u0001\u0000\u0000\u0000\u0216\u0217\n\u0003\u0000\u0000\u0217"+
		"\u0218\u0003H$\u0000\u0218\u0219\u0003T*\u0004\u0219\u021b\u0001\u0000"+
		"\u0000\u0000\u021a\u0216\u0001\u0000\u0000\u0000\u021b\u021e\u0001\u0000"+
		"\u0000\u0000\u021c\u021a\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000"+
		"\u0000\u0000\u021dU\u0001\u0000\u0000\u0000\u021e\u021c\u0001\u0000\u0000"+
		"\u0000\u021f\u0224\u0003>\u001f\u0000\u0220\u0221\u0005\u0002\u0000\u0000"+
		"\u0221\u0223\u0003>\u001f\u0000\u0222\u0220\u0001\u0000\u0000\u0000\u0223"+
		"\u0226\u0001\u0000\u0000\u0000\u0224\u0222\u0001\u0000\u0000\u0000\u0224"+
		"\u0225\u0001\u0000\u0000\u0000\u0225W\u0001\u0000\u0000\u0000\u0226\u0224"+
		"\u0001\u0000\u0000\u0000\u0227\u0228\u0005\"\u0000\u0000\u0228\u0229\u0003"+
		"\\.\u0000\u0229Y\u0001\u0000\u0000\u0000\u022a\u022f\u0003^/\u0000\u022b"+
		"\u022c\u0007\b\u0000\u0000\u022c\u022e\u0003^/\u0000\u022d\u022b\u0001"+
		"\u0000\u0000\u0000\u022e\u0231\u0001\u0000\u0000\u0000\u022f\u022d\u0001"+
		"\u0000\u0000\u0000\u022f\u0230\u0001\u0000\u0000\u0000\u0230[\u0001\u0000"+
		"\u0000\u0000\u0231\u022f\u0001\u0000\u0000\u0000\u0232\u0237\u0003^/\u0000"+
		"\u0233\u0234\u0005\u0004\u0000\u0000\u0234\u0236\u0003^/\u0000\u0235\u0233"+
		"\u0001\u0000\u0000\u0000\u0236\u0239\u0001\u0000\u0000\u0000\u0237\u0235"+
		"\u0001\u0000\u0000\u0000\u0237\u0238\u0001\u0000\u0000\u0000\u0238]\u0001"+
		"\u0000\u0000\u0000\u0239\u0237\u0001\u0000\u0000\u0000\u023a\u023b\u0005"+
		"P\u0000\u0000\u023b_\u0001\u0000\u0000\u0000\u023c\u023e\u0005=\u0000"+
		"\u0000\u023d\u023f\u0003b1\u0000\u023e\u023d\u0001\u0000\u0000\u0000\u023e"+
		"\u023f\u0001\u0000\u0000\u0000\u023fa\u0001\u0000\u0000\u0000\u0240\u0241"+
		"\u0005P\u0000\u0000\u0241c\u0001\u0000\u0000\u0000@gnrvz~\u0082\u0086"+
		"\u008a\u008e\u0092\u0096\u009a\u009e\u00a2\u00a6\u00a8\u00b9\u00bf\u00c5"+
		"\u00cd\u00d1\u00d8\u00de\u00e1\u00e4\u00e9\u00ef\u00f3\u00f6\u00fe\u0109"+
		"\u0114\u011b\u0123\u012a\u012f\u013a\u013d\u0143\u014e\u0155\u0159\u015c"+
		"\u0163\u017a\u0182\u018f\u0199\u01a3\u01b9\u01bb\u01c8\u01d1\u01ea\u01ec"+
		"\u01fb\u020a\u0214\u021c\u0224\u022f\u0237\u023e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}