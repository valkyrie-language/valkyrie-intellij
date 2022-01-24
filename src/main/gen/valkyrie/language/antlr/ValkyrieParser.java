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
		PARENTHESES_R=7, BRACKET_L=8, BRACKET_R=9, BRACE_L=10, BRACE_R=11, GENERIC_L=12, 
		GENERIC_R=13, OFFSET_L=14, OFFSET_R=15, OP_ADD=16, OP_INC=17, OP_SUB=18, 
		OP_DEC=19, OP_MUL=20, OP_DIV=21, OP_EQ=22, OP_NE=23, OP_LT=24, OP_LL=25, 
		OP_LLL=26, OP_LEQ=27, OP_GT=28, OP_GG=29, OP_GGG=30, OP_GEQ=31, OP_ARROW=32, 
		OP_ARROW2=33, OP_ASSIGN=34, LOGIC_OR=35, OP_OR=36, LOGIC_AND=37, OP_AND=38, 
		AT=39, HASH=40, LAMBDA_SLOT=41, MACRO_SLOT=42, OP_OR_ELSE=43, OP_THROW=44, 
		OP_NOT=45, KW_NOT=46, OP_IN=47, KW_IN=48, OP_NOT_IN=49, KW_IS=50, OP_IS=51, 
		OP_IS_NOT=52, KW_AS=53, OP_UNTIL=54, OP_POW=55, OP_TEMPERATURE=56, OP_EMPTY=57, 
		KW_NAMESPACE=58, KW_IMPORT=59, KW_EXTENSION=60, KW_EXTENDS=61, KW_CLASS=62, 
		KW_TRAIT=63, KW_UNION=64, KW_BITFLAGS=65, KW_TYPE=66, KW_LET=67, KW_FUNCTION=68, 
		KW_LAMBDA=69, KW_WITCH=70, KW_WHILE=71, KW_FOR=72, KW_NEW=73, KOW_WITH=74, 
		KW_WHEN=75, KW_MATCH=76, INTEGER=77, DECIMAL=78, STRING=79, KW_IF=80, 
		KW_ELSE=81, KW_OTHERWISE=82, FROM=83, RETURN=84, RESUME=85, YIELD=86, 
		BREAK=87, CONTINUE=88, RAISE=89, CATCH=90, SPECIAL=91, RAW_ID=92, UNICODE_ID=93, 
		LINE_COMMENT=94, BLOCK_COMMENT=95, WHITE_SPACE=96, ERROR_CHARACTAR=97;
	public static final int
		RULE_program = 0, RULE_top_statement = 1, RULE_function_statements = 2, 
		RULE_eos = 3, RULE_eos_free = 4, RULE_define_namespace = 5, RULE_import_statement = 6, 
		RULE_define_extension = 7, RULE_define_class = 8, RULE_class_block = 9, 
		RULE_class_statements = 10, RULE_class_inherit = 11, RULE_class_field = 12, 
		RULE_class_method = 13, RULE_define_trait = 14, RULE_define_extends = 15, 
		RULE_define_union = 16, RULE_union_block = 17, RULE_union_statements = 18, 
		RULE_define_variant = 19, RULE_variant_block = 20, RULE_variant_statements = 21, 
		RULE_define_bitflags = 22, RULE_bitflags_block = 23, RULE_bitflags_statements = 24, 
		RULE_bitflags_item = 25, RULE_define_type = 26, RULE_type_hint = 27, RULE_effect_hint = 28, 
		RULE_define_function = 29, RULE_function_parameters = 30, RULE_parameter_item = 31, 
		RULE_parameter_default = 32, RULE_function_call = 33, RULE_define_lambda = 34, 
		RULE_lambda_call = 35, RULE_function_block = 36, RULE_define_variale = 37, 
		RULE_if_statement = 38, RULE_else_if_statement = 39, RULE_else_statement = 40, 
		RULE_while_statement = 41, RULE_for_statement = 42, RULE_for_pattern = 43, 
		RULE_for_parameter = 44, RULE_expression = 45, RULE_inline_expression = 46, 
		RULE_prefix_call = 47, RULE_suffix_call = 48, RULE_control_expression = 49, 
		RULE_term = 50, RULE_op_compare = 51, RULE_op_pattern = 52, RULE_op_multiple = 53, 
		RULE_op_plus = 54, RULE_op_logic = 55, RULE_infix_is = 56, RULE_infix_in = 57, 
		RULE_type_expression = 58, RULE_call_arguments = 59, RULE_define_generic = 60, 
		RULE_generic_call = 61, RULE_dot_call = 62, RULE_slice_call = 63, RULE_offset_call = 64, 
		RULE_macro_call = 65, RULE_macro_call_item = 66, RULE_modifiers = 67, 
		RULE_modified_identifier = 68, RULE_modified_namepath = 69, RULE_namepath_free = 70, 
		RULE_namepath = 71, RULE_identifier = 72, RULE_number = 73;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "top_statement", "function_statements", "eos", "eos_free", 
			"define_namespace", "import_statement", "define_extension", "define_class", 
			"class_block", "class_statements", "class_inherit", "class_field", "class_method", 
			"define_trait", "define_extends", "define_union", "union_block", "union_statements", 
			"define_variant", "variant_block", "variant_statements", "define_bitflags", 
			"bitflags_block", "bitflags_statements", "bitflags_item", "define_type", 
			"type_hint", "effect_hint", "define_function", "function_parameters", 
			"parameter_item", "parameter_default", "function_call", "define_lambda", 
			"lambda_call", "function_block", "define_variale", "if_statement", "else_if_statement", 
			"else_statement", "while_statement", "for_statement", "for_pattern", 
			"for_parameter", "expression", "inline_expression", "prefix_call", "suffix_call", 
			"control_expression", "term", "op_compare", "op_pattern", "op_multiple", 
			"op_plus", "op_logic", "infix_is", "infix_in", "type_expression", "call_arguments", 
			"define_generic", "generic_call", "dot_call", "slice_call", "offset_call", 
			"macro_call", "macro_call_item", "modifiers", "modified_identifier", 
			"modified_namepath", "namepath_free", "namepath", "identifier", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "','", "';'", null, null, "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'\\u2993'", "'\\u2994'", "'\\u2045'", "'\\u2046'", "'+'", "'++'", 
			"'-'", "'--'", "'*'", "'/'", "'=='", "'!='", "'<'", null, null, null, 
			"'>'", null, null, null, null, null, "'='", "'||'", "'|'", "'&&'", "'&'", 
			"'@'", null, null, null, "'??'", "'?'", "'!'", "'not'", null, "'in'", 
			"'\\u2209'", "'is'", null, null, null, null, "'^'", null, "'\\u2205'", 
			null, null, "'extension'", null, null, null, "'union'", "'flags'", "'type'", 
			"'let'", null, "'lambda'", "'which'", "'while'", "'for'", null, "'with'", 
			"'when'", "'match'", null, null, null, "'if'", "'else'", "'otherwise'", 
			"'from'", "'return'", "'resume'", "'yield'", "'break'", "'continue'", 
			"'raise'", "'catch'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "COMMA", "SEMICOLON", "OP_PROPORTION", "COLON", "PARENTHESES_L", 
			"PARENTHESES_R", "BRACKET_L", "BRACKET_R", "BRACE_L", "BRACE_R", "GENERIC_L", 
			"GENERIC_R", "OFFSET_L", "OFFSET_R", "OP_ADD", "OP_INC", "OP_SUB", "OP_DEC", 
			"OP_MUL", "OP_DIV", "OP_EQ", "OP_NE", "OP_LT", "OP_LL", "OP_LLL", "OP_LEQ", 
			"OP_GT", "OP_GG", "OP_GGG", "OP_GEQ", "OP_ARROW", "OP_ARROW2", "OP_ASSIGN", 
			"LOGIC_OR", "OP_OR", "LOGIC_AND", "OP_AND", "AT", "HASH", "LAMBDA_SLOT", 
			"MACRO_SLOT", "OP_OR_ELSE", "OP_THROW", "OP_NOT", "KW_NOT", "OP_IN", 
			"KW_IN", "OP_NOT_IN", "KW_IS", "OP_IS", "OP_IS_NOT", "KW_AS", "OP_UNTIL", 
			"OP_POW", "OP_TEMPERATURE", "OP_EMPTY", "KW_NAMESPACE", "KW_IMPORT", 
			"KW_EXTENSION", "KW_EXTENDS", "KW_CLASS", "KW_TRAIT", "KW_UNION", "KW_BITFLAGS", 
			"KW_TYPE", "KW_LET", "KW_FUNCTION", "KW_LAMBDA", "KW_WITCH", "KW_WHILE", 
			"KW_FOR", "KW_NEW", "KOW_WITH", "KW_WHEN", "KW_MATCH", "INTEGER", "DECIMAL", 
			"STRING", "KW_IF", "KW_ELSE", "KW_OTHERWISE", "FROM", "RETURN", "RESUME", 
			"YIELD", "BREAK", "CONTINUE", "RAISE", "CATCH", "SPECIAL", "RAW_ID", 
			"UNICODE_ID", "LINE_COMMENT", "BLOCK_COMMENT", "WHITE_SPACE", "ERROR_CHARACTAR"
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
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -288229276639755968L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 1005707679L) != 0)) {
				{
				{
				setState(148);
				top_statement();
				}
				}
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(154);
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
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				define_namespace();
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
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				import_statement();
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
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				define_extension();
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
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(168);
				define_class();
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(169);
					eos();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(172);
				define_union();
				setState(174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(173);
					eos();
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				define_bitflags();
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(177);
					eos();
					}
				}

				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(180);
				define_trait();
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(181);
					eos();
					}
				}

				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(184);
				define_extends();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(185);
					eos();
					}
				}

				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(188);
				define_function();
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(189);
					eos();
					}
				}

				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(192);
				define_type();
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(193);
					eos();
					}
				}

				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(196);
				define_variale();
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(197);
					eos();
					}
				}

				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(200);
				if_statement();
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(201);
					eos();
					}
				}

				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(204);
				while_statement();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(205);
					eos();
					}
				}

				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(208);
				for_statement();
				setState(210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(209);
					eos();
					}
				}

				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(212);
				expression(0);
				setState(214);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(213);
					eos();
					}
				}

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
	public static class Function_statementsContext extends ParserRuleContext {
		public Define_lambdaContext define_lambda() {
			return getRuleContext(Define_lambdaContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
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
		enterRule(_localctx, 4, RULE_function_statements);
		int _la;
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
			case KW_LAMBDA:
				enterOuterAlt(_localctx, 1);
				{
				setState(218);
				define_lambda();
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(219);
					eos();
					}
				}

				}
				break;
			case KW_IF:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				if_statement();
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(223);
					eos();
					}
				}

				}
				break;
			case KW_WHILE:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				while_statement();
				setState(228);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(227);
					eos();
					}
				}

				}
				break;
			case KW_FOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(230);
				for_statement();
				setState(232);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(231);
					eos();
					}
				}

				}
				break;
			case PARENTHESES_L:
			case BRACKET_L:
			case OP_ADD:
			case OP_SUB:
			case INTEGER:
			case DECIMAL:
			case STRING:
			case RETURN:
			case RESUME:
			case YIELD:
			case BREAK:
			case CONTINUE:
			case RAISE:
			case SPECIAL:
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				expression(0);
				setState(236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(235);
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
		enterRule(_localctx, 6, RULE_eos);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
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
		enterRule(_localctx, 8, RULE_eos_free);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
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
		enterRule(_localctx, 10, RULE_define_namespace);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(KW_NAMESPACE);
			setState(245);
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
		enterRule(_localctx, 12, RULE_import_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(KW_IMPORT);
			setState(248);
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
		enterRule(_localctx, 14, RULE_define_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
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
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_CLASS() { return getToken(ValkyrieParser.KW_CLASS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Class_blockContext class_block() {
			return getRuleContext(Class_blockContext.class,0);
		}
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public Class_inheritContext class_inherit() {
			return getRuleContext(Class_inheritContext.class,0);
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
		enterRule(_localctx, 16, RULE_define_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH) {
				{
				{
				setState(252);
				macro_call();
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
			modifiers();
			setState(259);
			match(KW_CLASS);
			setState(260);
			identifier();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 16781328L) != 0)) {
				{
				setState(261);
				define_generic();
				}
			}

			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESES_L) {
				{
				setState(264);
				class_inherit();
				}
			}

			setState(267);
			class_block();
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
	public static class Class_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Class_statementsContext> class_statements() {
			return getRuleContexts(Class_statementsContext.class);
		}
		public Class_statementsContext class_statements(int i) {
			return getRuleContext(Class_statementsContext.class,i);
		}
		public Class_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterClass_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitClass_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitClass_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_blockContext class_block() throws RecognitionException {
		Class_blockContext _localctx = new Class_blockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_class_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(BRACE_L);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1099511627788L) != 0) || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(270);
				class_statements();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
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
		enterRule(_localctx, 20, RULE_class_statements);
		try {
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				class_method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				class_field();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
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
		enterRule(_localctx, 22, RULE_class_inherit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(PARENTHESES_L);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RAW_ID || _la==UNICODE_ID) {
				{
				setState(284);
				namepath();
				}
			}

			setState(287);
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
		public Modified_identifierContext modified_identifier() {
			return getRuleContext(Modified_identifierContext.class,0);
		}
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
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
		enterRule(_localctx, 24, RULE_class_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH) {
				{
				{
				setState(289);
				macro_call();
				}
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(295);
			modified_identifier();
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(296);
				type_hint();
				}
			}

			setState(300);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(299);
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
		public Modified_namepathContext modified_namepath() {
			return getRuleContext(Modified_namepathContext.class,0);
		}
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Effect_hintContext effect_hint() {
			return getRuleContext(Effect_hintContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
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
		enterRule(_localctx, 26, RULE_class_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH) {
				{
				{
				setState(302);
				macro_call();
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308);
			modified_namepath();
			setState(309);
			function_parameters();
			setState(311);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(310);
				type_hint();
				}
			}

			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_DIV) {
				{
				setState(313);
				effect_hint();
				}
			}

			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BRACE_L) {
				{
				setState(316);
				function_block();
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Class_blockContext class_block() {
			return getRuleContext(Class_blockContext.class,0);
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
		enterRule(_localctx, 28, RULE_define_trait);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(KW_TRAIT);
			setState(320);
			identifier();
			setState(321);
			class_block();
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
		public Class_blockContext class_block() {
			return getRuleContext(Class_blockContext.class,0);
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
		enterRule(_localctx, 30, RULE_define_extends);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(KW_EXTENDS);
			setState(324);
			namepath();
			setState(325);
			class_block();
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
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Union_blockContext union_block() {
			return getRuleContext(Union_blockContext.class,0);
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
		enterRule(_localctx, 32, RULE_define_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327);
			match(KW_UNION);
			setState(328);
			identifier();
			setState(329);
			union_block();
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
	public static class Union_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Union_statementsContext> union_statements() {
			return getRuleContexts(Union_statementsContext.class);
		}
		public Union_statementsContext union_statements(int i) {
			return getRuleContext(Union_statementsContext.class,i);
		}
		public Union_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_union_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterUnion_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitUnion_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitUnion_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Union_blockContext union_block() throws RecognitionException {
		Union_blockContext _localctx = new Union_blockContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_union_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(BRACE_L);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1099511627788L) != 0) || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(332);
				union_statements();
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(338);
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
		public Class_methodContext class_method() {
			return getRuleContext(Class_methodContext.class,0);
		}
		public Define_variantContext define_variant() {
			return getRuleContext(Define_variantContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
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
		enterRule(_localctx, 36, RULE_union_statements);
		try {
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				class_method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				define_variant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(342);
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
	public static class Define_variantContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Variant_blockContext variant_block() {
			return getRuleContext(Variant_blockContext.class,0);
		}
		public Define_variantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_variant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_variant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_variant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_variant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_variantContext define_variant() throws RecognitionException {
		Define_variantContext _localctx = new Define_variantContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_define_variant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			identifier();
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BRACE_L) {
				{
				setState(346);
				variant_block();
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
	public static class Variant_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Variant_statementsContext> variant_statements() {
			return getRuleContexts(Variant_statementsContext.class);
		}
		public Variant_statementsContext variant_statements(int i) {
			return getRuleContext(Variant_statementsContext.class,i);
		}
		public Variant_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variant_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterVariant_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitVariant_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitVariant_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variant_blockContext variant_block() throws RecognitionException {
		Variant_blockContext _localctx = new Variant_blockContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_variant_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(BRACE_L);
			setState(353);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1099511627788L) != 0) || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(350);
				variant_statements();
				}
				}
				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(356);
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
	public static class Variant_statementsContext extends ParserRuleContext {
		public Class_fieldContext class_field() {
			return getRuleContext(Class_fieldContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Variant_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variant_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterVariant_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitVariant_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitVariant_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variant_statementsContext variant_statements() throws RecognitionException {
		Variant_statementsContext _localctx = new Variant_statementsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variant_statements);
		try {
			setState(360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				class_field();
				}
				break;
			case COMMA:
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(359);
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
	public static class Define_bitflagsContext extends ParserRuleContext {
		public TerminalNode KW_BITFLAGS() { return getToken(ValkyrieParser.KW_BITFLAGS, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Bitflags_blockContext bitflags_block() {
			return getRuleContext(Bitflags_blockContext.class,0);
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
		enterRule(_localctx, 44, RULE_define_bitflags);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(KW_BITFLAGS);
			setState(363);
			namepath();
			setState(364);
			bitflags_block();
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
	public static class Bitflags_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Bitflags_statementsContext> bitflags_statements() {
			return getRuleContexts(Bitflags_statementsContext.class);
		}
		public Bitflags_statementsContext bitflags_statements(int i) {
			return getRuleContext(Bitflags_statementsContext.class,i);
		}
		public Bitflags_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitflags_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterBitflags_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitBitflags_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitBitflags_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitflags_blockContext bitflags_block() throws RecognitionException {
		Bitflags_blockContext _localctx = new Bitflags_blockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_bitflags_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(BRACE_L);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==SEMICOLON || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(367);
				bitflags_statements();
				}
				}
				setState(372);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(373);
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
		enterRule(_localctx, 48, RULE_bitflags_statements);
		try {
			setState(377);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				bitflags_item();
				}
				break;
			case COMMA:
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
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
		enterRule(_localctx, 50, RULE_bitflags_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			identifier();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(380);
				match(OP_ASSIGN);
				setState(381);
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
		enterRule(_localctx, 52, RULE_define_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(KW_TYPE);
			setState(385);
			identifier();
			setState(386);
			match(OP_ASSIGN);
			setState(387);
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
		enterRule(_localctx, 54, RULE_type_hint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			_la = _input.LA(1);
			if ( !(_la==COLON || _la==OP_ARROW) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(390);
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
		enterRule(_localctx, 56, RULE_effect_hint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			match(OP_DIV);
			setState(393);
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
	public static class Define_functionContext extends ParserRuleContext {
		public TerminalNode KW_FUNCTION() { return getToken(ValkyrieParser.KW_FUNCTION, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Effect_hintContext effect_hint() {
			return getRuleContext(Effect_hintContext.class,0);
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
		enterRule(_localctx, 58, RULE_define_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH) {
				{
				{
				setState(395);
				macro_call();
				}
				}
				setState(400);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(401);
			match(KW_FUNCTION);
			setState(402);
			namepath();
			setState(403);
			function_parameters();
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(404);
				type_hint();
				}
			}

			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_DIV) {
				{
				setState(407);
				effect_hint();
				}
			}

			setState(410);
			function_block();
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
		enterRule(_localctx, 60, RULE_function_parameters);
		int _la;
		try {
			setState(425);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(412);
				match(PARENTHESES_L);
				setState(413);
				parameter_item();
				setState(418);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(414);
					match(COMMA);
					setState(415);
					parameter_item();
					}
					}
					setState(420);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(421);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(423);
				match(PARENTHESES_L);
				setState(424);
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
		public Modified_identifierContext modified_identifier() {
			return getRuleContext(Modified_identifierContext.class,0);
		}
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
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
		enterRule(_localctx, 62, RULE_parameter_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH) {
				{
				{
				setState(427);
				macro_call();
				}
				}
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(433);
			modified_identifier();
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(434);
				type_hint();
				}
			}

			setState(438);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(437);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 64, RULE_parameter_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			match(OP_ASSIGN);
			setState(441);
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
	public static class Function_callContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieParser.PARENTHESES_R, 0); }
		public TerminalNode OP_THROW() { return getToken(ValkyrieParser.OP_THROW, 0); }
		public Call_argumentsContext call_arguments() {
			return getRuleContext(Call_argumentsContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_THROW) {
				{
				setState(443);
				match(OP_THROW);
				}
			}

			setState(446);
			match(PARENTHESES_L);
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 328000L) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 122759L) != 0)) {
				{
				setState(447);
				call_arguments();
				}
			}

			setState(450);
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
	public static class Define_lambdaContext extends ParserRuleContext {
		public TerminalNode KW_LAMBDA() { return getToken(ValkyrieParser.KW_LAMBDA, 0); }
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Effect_hintContext effect_hint() {
			return getRuleContext(Effect_hintContext.class,0);
		}
		public Define_lambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_lambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_lambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_lambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_lambdaContext define_lambda() throws RecognitionException {
		Define_lambdaContext _localctx = new Define_lambdaContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_define_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==HASH) {
				{
				{
				setState(452);
				macro_call();
				}
				}
				setState(457);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(458);
			match(KW_LAMBDA);
			setState(459);
			function_parameters();
			setState(461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(460);
				type_hint();
				}
			}

			setState(464);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_DIV) {
				{
				setState(463);
				effect_hint();
				}
			}

			setState(466);
			function_block();
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
	public static class Lambda_callContext extends ParserRuleContext {
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public TerminalNode OP_THROW() { return getToken(ValkyrieParser.OP_THROW, 0); }
		public Lambda_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterLambda_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitLambda_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitLambda_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_callContext lambda_call() throws RecognitionException {
		Lambda_callContext _localctx = new Lambda_callContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_lambda_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_THROW) {
				{
				setState(468);
				match(OP_THROW);
				}
			}

			setState(471);
			function_block();
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
	public static class Function_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieParser.BRACE_R, 0); }
		public List<Function_statementsContext> function_statements() {
			return getRuleContexts(Function_statementsContext.class);
		}
		public Function_statementsContext function_statements(int i) {
			return getRuleContext(Function_statementsContext.class,i);
		}
		public Function_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFunction_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFunction_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFunction_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_blockContext function_block() throws RecognitionException {
		Function_blockContext _localctx = new Function_blockContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_function_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			match(BRACE_L);
			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1099511955776L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 31428365L) != 0)) {
				{
				{
				setState(474);
				function_statements();
				}
				}
				setState(479);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(480);
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
		enterRule(_localctx, 74, RULE_define_variale);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(482);
			match(KW_LET);
			setState(483);
			identifier();
			setState(484);
			match(OP_ASSIGN);
			setState(485);
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
	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode KW_IF() { return getToken(ValkyrieParser.KW_IF, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public List<Else_if_statementContext> else_if_statement() {
			return getRuleContexts(Else_if_statementContext.class);
		}
		public Else_if_statementContext else_if_statement(int i) {
			return getRuleContext(Else_if_statementContext.class,i);
		}
		public Else_statementContext else_statement() {
			return getRuleContext(Else_statementContext.class,0);
		}
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
		enterRule(_localctx, 76, RULE_if_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(487);
			match(KW_IF);
			setState(488);
			inline_expression(0);
			setState(489);
			function_block();
			setState(493);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(490);
					else_if_statement();
					}
					} 
				}
				setState(495);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
			}
			setState(497);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_ELSE) {
				{
				setState(496);
				else_statement();
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
	public static class Else_if_statementContext extends ParserRuleContext {
		public TerminalNode KW_ELSE() { return getToken(ValkyrieParser.KW_ELSE, 0); }
		public TerminalNode KW_IF() { return getToken(ValkyrieParser.KW_IF, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public Else_if_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterElse_if_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitElse_if_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitElse_if_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_if_statementContext else_if_statement() throws RecognitionException {
		Else_if_statementContext _localctx = new Else_if_statementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_else_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			match(KW_ELSE);
			setState(500);
			match(KW_IF);
			setState(501);
			inline_expression(0);
			setState(502);
			function_block();
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
	public static class Else_statementContext extends ParserRuleContext {
		public TerminalNode KW_ELSE() { return getToken(ValkyrieParser.KW_ELSE, 0); }
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitElse_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitElse_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			match(KW_ELSE);
			setState(505);
			function_block();
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
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
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
		enterRule(_localctx, 82, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(507);
			match(KW_WHILE);
			setState(508);
			inline_expression(0);
			setState(509);
			function_block();
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
		public For_patternContext for_pattern() {
			return getRuleContext(For_patternContext.class,0);
		}
		public Infix_inContext infix_in() {
			return getRuleContext(Infix_inContext.class,0);
		}
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
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
		enterRule(_localctx, 84, RULE_for_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(511);
			match(KW_FOR);
			setState(512);
			for_pattern();
			setState(513);
			infix_in();
			setState(514);
			inline_expression(0);
			setState(515);
			function_block();
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
	public static class For_patternContext extends ParserRuleContext {
		public List<For_parameterContext> for_parameter() {
			return getRuleContexts(For_parameterContext.class);
		}
		public For_parameterContext for_parameter(int i) {
			return getRuleContext(For_parameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieParser.COMMA, i);
		}
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieParser.PARENTHESES_R, 0); }
		public For_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFor_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFor_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFor_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_patternContext for_pattern() throws RecognitionException {
		For_patternContext _localctx = new For_patternContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_for_pattern);
		int _la;
		try {
			setState(536);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				for_parameter();
				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(518);
					match(COMMA);
					setState(519);
					for_parameter();
					}
					}
					setState(524);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case PARENTHESES_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(525);
				match(PARENTHESES_L);
				setState(526);
				for_parameter();
				setState(531);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(527);
					match(COMMA);
					setState(528);
					for_parameter();
					}
					}
					setState(533);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(534);
				match(PARENTHESES_R);
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
	public static class For_parameterContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public For_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterFor_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitFor_parameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitFor_parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_parameterContext for_parameter() throws RecognitionException {
		For_parameterContext _localctx = new For_parameterContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_for_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(538);
				identifier();
				}
				}
				setState(541); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RAW_ID || _la==UNICODE_ID );
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
		public Prefix_callContext prefix_call() {
			return getRuleContext(Prefix_callContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
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
		public Suffix_callContext suffix_call() {
			return getRuleContext(Suffix_callContext.class,0);
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
		int _startState = 90;
		enterRecursionRule(_localctx, 90, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(549);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case RESUME:
			case YIELD:
			case BREAK:
			case CONTINUE:
			case RAISE:
				{
				setState(544);
				control_expression();
				}
				break;
			case OP_ADD:
			case OP_SUB:
				{
				setState(545);
				prefix_call();
				setState(546);
				expression(2);
				}
				break;
			case PARENTHESES_L:
			case BRACKET_L:
			case INTEGER:
			case DECIMAL:
			case STRING:
			case SPECIAL:
			case RAW_ID:
			case UNICODE_ID:
				{
				setState(548);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(575);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(573);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(551);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(552);
						op_multiple();
						setState(553);
						expression(9);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(555);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(556);
						op_plus();
						setState(557);
						expression(8);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(559);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(560);
						op_logic();
						setState(561);
						expression(7);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(563);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(564);
						op_compare();
						setState(565);
						expression(6);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(567);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(568);
						suffix_call();
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(569);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(570);
						infix_is();
						setState(571);
						type_expression(0);
						}
						break;
					}
					} 
				}
				setState(577);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,67,_ctx);
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
	public static class Inline_expressionContext extends ParserRuleContext {
		public Prefix_callContext prefix_call() {
			return getRuleContext(Prefix_callContext.class,0);
		}
		public List<Inline_expressionContext> inline_expression() {
			return getRuleContexts(Inline_expressionContext.class);
		}
		public Inline_expressionContext inline_expression(int i) {
			return getRuleContext(Inline_expressionContext.class,i);
		}
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
		int _startState = 92;
		enterRecursionRule(_localctx, 92, RULE_inline_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_ADD:
			case OP_SUB:
				{
				setState(579);
				prefix_call();
				setState(580);
				inline_expression(2);
				}
				break;
			case PARENTHESES_L:
			case BRACKET_L:
			case INTEGER:
			case DECIMAL:
			case STRING:
			case SPECIAL:
			case RAW_ID:
			case UNICODE_ID:
				{
				setState(582);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(607);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(605);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
					case 1:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(585);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(586);
						op_multiple();
						setState(587);
						inline_expression(8);
						}
						break;
					case 2:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(589);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(590);
						op_plus();
						setState(591);
						inline_expression(7);
						}
						break;
					case 3:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(593);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(594);
						op_logic();
						setState(595);
						inline_expression(6);
						}
						break;
					case 4:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(597);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(598);
						op_compare();
						setState(599);
						inline_expression(5);
						}
						break;
					case 5:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(601);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(602);
						infix_is();
						setState(603);
						inline_expression(4);
						}
						break;
					}
					} 
				}
				setState(609);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,70,_ctx);
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
	public static class Prefix_callContext extends ParserRuleContext {
		public TerminalNode OP_ADD() { return getToken(ValkyrieParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(ValkyrieParser.OP_SUB, 0); }
		public Prefix_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterPrefix_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitPrefix_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitPrefix_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_callContext prefix_call() throws RecognitionException {
		Prefix_callContext _localctx = new Prefix_callContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_prefix_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
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
	public static class Suffix_callContext extends ParserRuleContext {
		public TerminalNode OP_NOT() { return getToken(ValkyrieParser.OP_NOT, 0); }
		public TerminalNode OP_TEMPERATURE() { return getToken(ValkyrieParser.OP_TEMPERATURE, 0); }
		public Slice_callContext slice_call() {
			return getRuleContext(Slice_callContext.class,0);
		}
		public Offset_callContext offset_call() {
			return getRuleContext(Offset_callContext.class,0);
		}
		public Generic_callContext generic_call() {
			return getRuleContext(Generic_callContext.class,0);
		}
		public Lambda_callContext lambda_call() {
			return getRuleContext(Lambda_callContext.class,0);
		}
		public Dot_callContext dot_call() {
			return getRuleContext(Dot_callContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Suffix_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterSuffix_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitSuffix_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitSuffix_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Suffix_callContext suffix_call() throws RecognitionException {
		Suffix_callContext _localctx = new Suffix_callContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_suffix_call);
		try {
			setState(620);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(612);
				match(OP_NOT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(613);
				match(OP_TEMPERATURE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(614);
				slice_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(615);
				offset_call();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(616);
				generic_call();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(617);
				lambda_call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(618);
				dot_call();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(619);
				function_call();
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
		enterRule(_localctx, 98, RULE_control_expression);
		try {
			setState(641);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(622);
				match(RETURN);
				setState(623);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(624);
				match(RESUME);
				setState(625);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(626);
				match(BREAK);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(627);
				match(CONTINUE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(628);
				match(RAISE);
				setState(629);
				expression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(630);
				match(YIELD);
				setState(632);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(631);
					match(RETURN);
					}
					break;
				}
				setState(634);
				expression(0);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(635);
				match(YIELD);
				setState(636);
				match(BREAK);
				setState(637);
				expression(0);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(638);
				match(YIELD);
				setState(639);
				match(FROM);
				setState(640);
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
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 100, RULE_term);
		try {
			setState(655);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RAW_ID:
			case UNICODE_ID:
				_localctx = new EIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(643);
				namepath();
				}
				break;
			case INTEGER:
			case DECIMAL:
				_localctx = new ENumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(644);
				number();
				}
				break;
			case STRING:
				_localctx = new EStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(645);
				match(STRING);
				}
				break;
			case PARENTHESES_L:
				_localctx = new EParensContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(646);
				match(PARENTHESES_L);
				setState(647);
				expression(0);
				setState(648);
				match(PARENTHESES_R);
				}
				break;
			case BRACKET_L:
				_localctx = new EVectorContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(650);
				match(BRACKET_L);
				setState(651);
				expression(0);
				setState(652);
				match(BRACKET_R);
				}
				break;
			case SPECIAL:
				_localctx = new ESpeicalLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(654);
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
		public TerminalNode OP_LT() { return getToken(ValkyrieParser.OP_LT, 0); }
		public TerminalNode OP_LEQ() { return getToken(ValkyrieParser.OP_LEQ, 0); }
		public TerminalNode OP_GT() { return getToken(ValkyrieParser.OP_GT, 0); }
		public TerminalNode OP_GEQ() { return getToken(ValkyrieParser.OP_GEQ, 0); }
		public TerminalNode OP_EQ() { return getToken(ValkyrieParser.OP_EQ, 0); }
		public TerminalNode OP_NE() { return getToken(ValkyrieParser.OP_NE, 0); }
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
		enterRule(_localctx, 102, RULE_op_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2579496960L) != 0)) ) {
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
		enterRule(_localctx, 104, RULE_op_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(659);
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
		enterRule(_localctx, 106, RULE_op_multiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
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
		enterRule(_localctx, 108, RULE_op_plus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
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
		enterRule(_localctx, 110, RULE_op_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
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
		enterRule(_localctx, 112, RULE_infix_is);
		try {
			setState(670);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(667);
				match(KW_IS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(668);
				match(KW_IS);
				setState(669);
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
		enterRule(_localctx, 114, RULE_infix_in);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
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
		int _startState = 116;
		enterRecursionRule(_localctx, 116, RULE_type_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,76,_ctx) ) {
			case 1:
				{
				_localctx = new TParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(675);
				match(PARENTHESES_L);
				setState(676);
				type_expression(0);
				setState(677);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				{
				_localctx = new TTermContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(679);
				term();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(688);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TPatternContext(new Type_expressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
					setState(682);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(683);
					op_pattern();
					setState(684);
					type_expression(4);
					}
					} 
				}
				setState(690);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
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
	public static class Call_argumentsContext extends ParserRuleContext {
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
		public Call_argumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterCall_arguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitCall_arguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitCall_arguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_argumentsContext call_arguments() throws RecognitionException {
		Call_argumentsContext _localctx = new Call_argumentsContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_call_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(691);
			expression(0);
			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(692);
				match(COMMA);
				setState(693);
				expression(0);
				}
				}
				setState(698);
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
	public static class Define_genericContext extends ParserRuleContext {
		public TerminalNode OP_LT() { return getToken(ValkyrieParser.OP_LT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(ValkyrieParser.OP_GT, 0); }
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieParser.OP_PROPORTION, 0); }
		public TerminalNode GENERIC_L() { return getToken(ValkyrieParser.GENERIC_L, 0); }
		public TerminalNode GENERIC_R() { return getToken(ValkyrieParser.GENERIC_R, 0); }
		public Define_genericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_generic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDefine_generic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDefine_generic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDefine_generic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_genericContext define_generic() throws RecognitionException {
		Define_genericContext _localctx = new Define_genericContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_define_generic);
		int _la;
		try {
			setState(710);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PROPORTION:
			case OP_LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_PROPORTION) {
					{
					setState(699);
					match(OP_PROPORTION);
					}
				}

				setState(702);
				match(OP_LT);
				setState(703);
				identifier();
				setState(704);
				match(OP_GT);
				}
				break;
			case GENERIC_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(706);
				match(GENERIC_L);
				setState(707);
				identifier();
				setState(708);
				match(GENERIC_R);
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
	public static class Generic_callContext extends ParserRuleContext {
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieParser.OP_PROPORTION, 0); }
		public TerminalNode OP_LT() { return getToken(ValkyrieParser.OP_LT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(ValkyrieParser.OP_GT, 0); }
		public TerminalNode GENERIC_L() { return getToken(ValkyrieParser.GENERIC_L, 0); }
		public TerminalNode GENERIC_R() { return getToken(ValkyrieParser.GENERIC_R, 0); }
		public Generic_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterGeneric_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitGeneric_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitGeneric_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Generic_callContext generic_call() throws RecognitionException {
		Generic_callContext _localctx = new Generic_callContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_generic_call);
		try {
			setState(721);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PROPORTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(712);
				match(OP_PROPORTION);
				setState(713);
				match(OP_LT);
				setState(714);
				identifier();
				setState(715);
				match(OP_GT);
				}
				break;
			case GENERIC_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(717);
				match(GENERIC_L);
				setState(718);
				identifier();
				setState(719);
				match(GENERIC_R);
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
	public static class Dot_callContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ValkyrieParser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_THROW() { return getToken(ValkyrieParser.OP_THROW, 0); }
		public Dot_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterDot_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitDot_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitDot_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dot_callContext dot_call() throws RecognitionException {
		Dot_callContext _localctx = new Dot_callContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_dot_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_THROW) {
				{
				setState(723);
				match(OP_THROW);
				}
			}

			setState(726);
			match(DOT);
			setState(727);
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
	public static class Slice_callContext extends ParserRuleContext {
		public TerminalNode BRACKET_L() { return getToken(ValkyrieParser.BRACKET_L, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BRACKET_R() { return getToken(ValkyrieParser.BRACKET_R, 0); }
		public Slice_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterSlice_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitSlice_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitSlice_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Slice_callContext slice_call() throws RecognitionException {
		Slice_callContext _localctx = new Slice_callContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_slice_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
			match(BRACKET_L);
			setState(730);
			expression(0);
			setState(731);
			match(BRACKET_R);
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
	public static class Offset_callContext extends ParserRuleContext {
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieParser.OP_PROPORTION, 0); }
		public TerminalNode BRACKET_L() { return getToken(ValkyrieParser.BRACKET_L, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BRACKET_R() { return getToken(ValkyrieParser.BRACKET_R, 0); }
		public TerminalNode OFFSET_L() { return getToken(ValkyrieParser.OFFSET_L, 0); }
		public TerminalNode OFFSET_R() { return getToken(ValkyrieParser.OFFSET_R, 0); }
		public Offset_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterOffset_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitOffset_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitOffset_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Offset_callContext offset_call() throws RecognitionException {
		Offset_callContext _localctx = new Offset_callContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_offset_call);
		try {
			setState(742);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PROPORTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(733);
				match(OP_PROPORTION);
				setState(734);
				match(BRACKET_L);
				setState(735);
				expression(0);
				setState(736);
				match(BRACKET_R);
				}
				break;
			case OFFSET_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(738);
				match(OFFSET_L);
				setState(739);
				expression(0);
				setState(740);
				match(OFFSET_R);
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
	public static class Macro_callContext extends ParserRuleContext {
		public TerminalNode HASH() { return getToken(ValkyrieParser.HASH, 0); }
		public List<Macro_call_itemContext> macro_call_item() {
			return getRuleContexts(Macro_call_itemContext.class);
		}
		public Macro_call_itemContext macro_call_item(int i) {
			return getRuleContext(Macro_call_itemContext.class,i);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieParser.BRACKET_R, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieParser.COMMA, i);
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
		enterRule(_localctx, 130, RULE_macro_call);
		int _la;
		try {
			setState(758);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(744);
				match(HASH);
				setState(745);
				macro_call_item();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(746);
				match(HASH);
				setState(747);
				match(BRACKET_L);
				setState(748);
				macro_call_item();
				setState(753);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(749);
					match(COMMA);
					setState(750);
					macro_call_item();
					}
					}
					setState(755);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(756);
				match(BRACKET_R);
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
	public static class Macro_call_itemContext extends ParserRuleContext {
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public Macro_call_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_call_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterMacro_call_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitMacro_call_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitMacro_call_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Macro_call_itemContext macro_call_item() throws RecognitionException {
		Macro_call_itemContext _localctx = new Macro_call_itemContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_macro_call_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(760);
			namepath();
			setState(762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESES_L) {
				{
				setState(761);
				function_parameters();
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
	public static class ModifiersContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_modifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(764);
				identifier();
				}
				}
				setState(769);
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
	public static class Modified_identifierContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Modified_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modified_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterModified_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitModified_identifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitModified_identifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Modified_identifierContext modified_identifier() throws RecognitionException {
		Modified_identifierContext _localctx = new Modified_identifierContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_modified_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(771); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(770);
					identifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(773); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,88,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
	public static class Modified_namepathContext extends ParserRuleContext {
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
		public Modified_namepathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modified_namepath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).enterModified_namepath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieListener ) ((ValkyrieListener)listener).exitModified_namepath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieVisitor ) return ((ValkyrieVisitor<? extends T>)visitor).visitModified_namepath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Modified_namepathContext modified_namepath() throws RecognitionException {
		Modified_namepathContext _localctx = new Modified_namepathContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_modified_namepath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(776); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(775);
				identifier();
				}
				}
				setState(778); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RAW_ID || _la==UNICODE_ID );
			setState(784);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_PROPORTION) {
				{
				{
				setState(780);
				match(OP_PROPORTION);
				setState(781);
				identifier();
				}
				}
				setState(786);
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
		enterRule(_localctx, 140, RULE_namepath_free);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(787);
			identifier();
			setState(792);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==OP_PROPORTION) {
				{
				{
				setState(788);
				_la = _input.LA(1);
				if ( !(_la==DOT || _la==OP_PROPORTION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(789);
				identifier();
				}
				}
				setState(794);
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
		enterRule(_localctx, 142, RULE_namepath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			identifier();
			setState(800);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(796);
					match(OP_PROPORTION);
					setState(797);
					identifier();
					}
					} 
				}
				setState(802);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
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
		public TerminalNode RAW_ID() { return getToken(ValkyrieParser.RAW_ID, 0); }
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
		enterRule(_localctx, 144, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(803);
			_la = _input.LA(1);
			if ( !(_la==RAW_ID || _la==UNICODE_ID) ) {
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
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode DECIMAL() { return getToken(ValkyrieParser.DECIMAL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(ValkyrieParser.INTEGER, 0); }
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
		enterRule(_localctx, 146, RULE_number);
		try {
			setState(813);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(805);
				match(DECIMAL);
				setState(807);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
				case 1:
					{
					setState(806);
					identifier();
					}
					break;
				}
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(809);
				match(INTEGER);
				setState(811);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
				case 1:
					{
					setState(810);
					identifier();
					}
					break;
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 45:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 46:
			return inline_expression_sempred((Inline_expressionContext)_localctx, predIndex);
		case 58:
			return type_expression_sempred((Type_expressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean inline_expression_sempred(Inline_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		}
		return true;
	}
	private boolean type_expression_sempred(Type_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001a\u0330\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0001\u0000\u0005\u0000"+
		"\u0096\b\u0000\n\u0000\f\u0000\u0099\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u009f\b\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u00a3\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00a7\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001\u00ab\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u00af\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00b3\b"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00b7\b\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001\u00bb\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00bf"+
		"\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00c3\b\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001\u00c7\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001"+
		"\u00cb\b\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00cf\b\u0001\u0001"+
		"\u0001\u0001\u0001\u0003\u0001\u00d3\b\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u00d7\b\u0001\u0003\u0001\u00d9\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0003\u0002\u00dd\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00e1\b"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00e5\b\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u00e9\b\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00ed"+
		"\b\u0002\u0003\u0002\u00ef\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0005\b\u00fe\b\b\n\b\f\b"+
		"\u0101\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0107\b\b\u0001\b\u0003"+
		"\b\u010a\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\t\u0110\b\t\n\t\f\t"+
		"\u0113\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n\u011a\b\n\u0001"+
		"\u000b\u0001\u000b\u0003\u000b\u011e\b\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0005\f\u0123\b\f\n\f\f\f\u0126\t\f\u0001\f\u0001\f\u0003\f\u012a\b"+
		"\f\u0001\f\u0003\f\u012d\b\f\u0001\r\u0005\r\u0130\b\r\n\r\f\r\u0133\t"+
		"\r\u0001\r\u0001\r\u0001\r\u0003\r\u0138\b\r\u0001\r\u0003\r\u013b\b\r"+
		"\u0001\r\u0003\r\u013e\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0005\u0011\u014e\b\u0011"+
		"\n\u0011\f\u0011\u0151\t\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0158\b\u0012\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u015c\b\u0013\u0001\u0014\u0001\u0014\u0005\u0014\u0160\b\u0014"+
		"\n\u0014\f\u0014\u0163\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u0169\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0005\u0017\u0171\b\u0017\n\u0017\f\u0017"+
		"\u0174\t\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u017a\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u017f\b"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0005\u001d\u018d\b\u001d\n\u001d\f\u001d\u0190\t\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0196\b\u001d\u0001\u001d"+
		"\u0003\u001d\u0199\b\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0005\u001e\u01a1\b\u001e\n\u001e\f\u001e\u01a4"+
		"\t\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u01aa"+
		"\b\u001e\u0001\u001f\u0005\u001f\u01ad\b\u001f\n\u001f\f\u001f\u01b0\t"+
		"\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u01b4\b\u001f\u0001\u001f\u0003"+
		"\u001f\u01b7\b\u001f\u0001 \u0001 \u0001 \u0001!\u0003!\u01bd\b!\u0001"+
		"!\u0001!\u0003!\u01c1\b!\u0001!\u0001!\u0001\"\u0005\"\u01c6\b\"\n\"\f"+
		"\"\u01c9\t\"\u0001\"\u0001\"\u0001\"\u0003\"\u01ce\b\"\u0001\"\u0003\""+
		"\u01d1\b\"\u0001\"\u0001\"\u0001#\u0003#\u01d6\b#\u0001#\u0001#\u0001"+
		"$\u0001$\u0005$\u01dc\b$\n$\f$\u01df\t$\u0001$\u0001$\u0001%\u0001%\u0001"+
		"%\u0001%\u0001%\u0001&\u0001&\u0001&\u0001&\u0005&\u01ec\b&\n&\f&\u01ef"+
		"\t&\u0001&\u0003&\u01f2\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001"+
		"(\u0001(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001"+
		"*\u0001*\u0001*\u0001+\u0001+\u0001+\u0005+\u0209\b+\n+\f+\u020c\t+\u0001"+
		"+\u0001+\u0001+\u0001+\u0005+\u0212\b+\n+\f+\u0215\t+\u0001+\u0001+\u0003"+
		"+\u0219\b+\u0001,\u0004,\u021c\b,\u000b,\f,\u021d\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0003-\u0226\b-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0005-\u023e\b-\n-"+
		"\f-\u0241\t-\u0001.\u0001.\u0001.\u0001.\u0001.\u0003.\u0248\b.\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001"+
		".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0005"+
		".\u025e\b.\n.\f.\u0261\t.\u0001/\u0001/\u00010\u00010\u00010\u00010\u0001"+
		"0\u00010\u00010\u00010\u00030\u026d\b0\u00011\u00011\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00011\u00031\u0279\b1\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00031\u0282\b1\u00012\u00012\u00012\u0001"+
		"2\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u0290"+
		"\b2\u00013\u00013\u00014\u00014\u00015\u00015\u00016\u00016\u00017\u0001"+
		"7\u00018\u00018\u00018\u00038\u029f\b8\u00019\u00019\u0001:\u0001:\u0001"+
		":\u0001:\u0001:\u0001:\u0003:\u02a9\b:\u0001:\u0001:\u0001:\u0001:\u0005"+
		":\u02af\b:\n:\f:\u02b2\t:\u0001;\u0001;\u0001;\u0005;\u02b7\b;\n;\f;\u02ba"+
		"\t;\u0001<\u0003<\u02bd\b<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0001<\u0003<\u02c7\b<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001"+
		"=\u0001=\u0001=\u0003=\u02d2\b=\u0001>\u0003>\u02d5\b>\u0001>\u0001>\u0001"+
		">\u0001?\u0001?\u0001?\u0001?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001"+
		"@\u0001@\u0001@\u0001@\u0003@\u02e7\b@\u0001A\u0001A\u0001A\u0001A\u0001"+
		"A\u0001A\u0001A\u0005A\u02f0\bA\nA\fA\u02f3\tA\u0001A\u0001A\u0003A\u02f7"+
		"\bA\u0001B\u0001B\u0003B\u02fb\bB\u0001C\u0005C\u02fe\bC\nC\fC\u0301\t"+
		"C\u0001D\u0004D\u0304\bD\u000bD\fD\u0305\u0001E\u0004E\u0309\bE\u000b"+
		"E\fE\u030a\u0001E\u0001E\u0005E\u030f\bE\nE\fE\u0312\tE\u0001F\u0001F"+
		"\u0001F\u0005F\u0317\bF\nF\fF\u031a\tF\u0001G\u0001G\u0001G\u0005G\u031f"+
		"\bG\nG\fG\u0322\tG\u0001H\u0001H\u0001I\u0001I\u0003I\u0328\bI\u0001I"+
		"\u0001I\u0003I\u032c\bI\u0003I\u032e\bI\u0001I\u0000\u0003Z\\tJ\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0000\n\u0001\u0000\u0002\u0003"+
		"\u0002\u0000\u0005\u0005  \u0002\u0000\u0010\u0010\u0012\u0012\u0003\u0000"+
		"\u0016\u0018\u001b\u001c\u001f\u001f\u0002\u0000$$&&\u0001\u0000\u0014"+
		"\u0015\u0002\u0000##%%\u0001\u0000/0\u0002\u0000\u0001\u0001\u0004\u0004"+
		"\u0001\u0000\\]\u036f\u0000\u0097\u0001\u0000\u0000\u0000\u0002\u00d8"+
		"\u0001\u0000\u0000\u0000\u0004\u00ee\u0001\u0000\u0000\u0000\u0006\u00f0"+
		"\u0001\u0000\u0000\u0000\b\u00f2\u0001\u0000\u0000\u0000\n\u00f4\u0001"+
		"\u0000\u0000\u0000\f\u00f7\u0001\u0000\u0000\u0000\u000e\u00fa\u0001\u0000"+
		"\u0000\u0000\u0010\u00ff\u0001\u0000\u0000\u0000\u0012\u010d\u0001\u0000"+
		"\u0000\u0000\u0014\u0119\u0001\u0000\u0000\u0000\u0016\u011b\u0001\u0000"+
		"\u0000\u0000\u0018\u0124\u0001\u0000\u0000\u0000\u001a\u0131\u0001\u0000"+
		"\u0000\u0000\u001c\u013f\u0001\u0000\u0000\u0000\u001e\u0143\u0001\u0000"+
		"\u0000\u0000 \u0147\u0001\u0000\u0000\u0000\"\u014b\u0001\u0000\u0000"+
		"\u0000$\u0157\u0001\u0000\u0000\u0000&\u0159\u0001\u0000\u0000\u0000("+
		"\u015d\u0001\u0000\u0000\u0000*\u0168\u0001\u0000\u0000\u0000,\u016a\u0001"+
		"\u0000\u0000\u0000.\u016e\u0001\u0000\u0000\u00000\u0179\u0001\u0000\u0000"+
		"\u00002\u017b\u0001\u0000\u0000\u00004\u0180\u0001\u0000\u0000\u00006"+
		"\u0185\u0001\u0000\u0000\u00008\u0188\u0001\u0000\u0000\u0000:\u018e\u0001"+
		"\u0000\u0000\u0000<\u01a9\u0001\u0000\u0000\u0000>\u01ae\u0001\u0000\u0000"+
		"\u0000@\u01b8\u0001\u0000\u0000\u0000B\u01bc\u0001\u0000\u0000\u0000D"+
		"\u01c7\u0001\u0000\u0000\u0000F\u01d5\u0001\u0000\u0000\u0000H\u01d9\u0001"+
		"\u0000\u0000\u0000J\u01e2\u0001\u0000\u0000\u0000L\u01e7\u0001\u0000\u0000"+
		"\u0000N\u01f3\u0001\u0000\u0000\u0000P\u01f8\u0001\u0000\u0000\u0000R"+
		"\u01fb\u0001\u0000\u0000\u0000T\u01ff\u0001\u0000\u0000\u0000V\u0218\u0001"+
		"\u0000\u0000\u0000X\u021b\u0001\u0000\u0000\u0000Z\u0225\u0001\u0000\u0000"+
		"\u0000\\\u0247\u0001\u0000\u0000\u0000^\u0262\u0001\u0000\u0000\u0000"+
		"`\u026c\u0001\u0000\u0000\u0000b\u0281\u0001\u0000\u0000\u0000d\u028f"+
		"\u0001\u0000\u0000\u0000f\u0291\u0001\u0000\u0000\u0000h\u0293\u0001\u0000"+
		"\u0000\u0000j\u0295\u0001\u0000\u0000\u0000l\u0297\u0001\u0000\u0000\u0000"+
		"n\u0299\u0001\u0000\u0000\u0000p\u029e\u0001\u0000\u0000\u0000r\u02a0"+
		"\u0001\u0000\u0000\u0000t\u02a8\u0001\u0000\u0000\u0000v\u02b3\u0001\u0000"+
		"\u0000\u0000x\u02c6\u0001\u0000\u0000\u0000z\u02d1\u0001\u0000\u0000\u0000"+
		"|\u02d4\u0001\u0000\u0000\u0000~\u02d9\u0001\u0000\u0000\u0000\u0080\u02e6"+
		"\u0001\u0000\u0000\u0000\u0082\u02f6\u0001\u0000\u0000\u0000\u0084\u02f8"+
		"\u0001\u0000\u0000\u0000\u0086\u02ff\u0001\u0000\u0000\u0000\u0088\u0303"+
		"\u0001\u0000\u0000\u0000\u008a\u0308\u0001\u0000\u0000\u0000\u008c\u0313"+
		"\u0001\u0000\u0000\u0000\u008e\u031b\u0001\u0000\u0000\u0000\u0090\u0323"+
		"\u0001\u0000\u0000\u0000\u0092\u032d\u0001\u0000\u0000\u0000\u0094\u0096"+
		"\u0003\u0002\u0001\u0000\u0095\u0094\u0001\u0000\u0000\u0000\u0096\u0099"+
		"\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0001\u0000\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000\u0099\u0097"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0005\u0000\u0000\u0001\u009b\u0001"+
		"\u0001\u0000\u0000\u0000\u009c\u009e\u0003\n\u0005\u0000\u009d\u009f\u0003"+
		"\u0006\u0003\u0000\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00d9\u0001\u0000\u0000\u0000\u00a0\u00a2\u0003"+
		"\f\u0006\u0000\u00a1\u00a3\u0003\u0006\u0003\u0000\u00a2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00d9\u0001\u0000"+
		"\u0000\u0000\u00a4\u00a6\u0003\u000e\u0007\u0000\u00a5\u00a7\u0003\u0006"+
		"\u0003\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000"+
		"\u0000\u0000\u00a7\u00d9\u0001\u0000\u0000\u0000\u00a8\u00aa\u0003\u0010"+
		"\b\u0000\u00a9\u00ab\u0003\u0006\u0003\u0000\u00aa\u00a9\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00d9\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ae\u0003 \u0010\u0000\u00ad\u00af\u0003\u0006\u0003\u0000"+
		"\u00ae\u00ad\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000"+
		"\u00af\u00d9\u0001\u0000\u0000\u0000\u00b0\u00b2\u0003,\u0016\u0000\u00b1"+
		"\u00b3\u0003\u0006\u0003\u0000\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b2"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b3\u00d9\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b6\u0003\u001c\u000e\u0000\u00b5\u00b7\u0003\u0006\u0003\u0000\u00b6"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7"+
		"\u00d9\u0001\u0000\u0000\u0000\u00b8\u00ba\u0003\u001e\u000f\u0000\u00b9"+
		"\u00bb\u0003\u0006\u0003\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00ba"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bb\u00d9\u0001\u0000\u0000\u0000\u00bc"+
		"\u00be\u0003:\u001d\u0000\u00bd\u00bf\u0003\u0006\u0003\u0000\u00be\u00bd"+
		"\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00d9"+
		"\u0001\u0000\u0000\u0000\u00c0\u00c2\u00034\u001a\u0000\u00c1\u00c3\u0003"+
		"\u0006\u0003\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c3\u00d9\u0001\u0000\u0000\u0000\u00c4\u00c6\u0003"+
		"J%\u0000\u00c5\u00c7\u0003\u0006\u0003\u0000\u00c6\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c7\u00d9\u0001\u0000\u0000"+
		"\u0000\u00c8\u00ca\u0003L&\u0000\u00c9\u00cb\u0003\u0006\u0003\u0000\u00ca"+
		"\u00c9\u0001\u0000\u0000\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb"+
		"\u00d9\u0001\u0000\u0000\u0000\u00cc\u00ce\u0003R)\u0000\u00cd\u00cf\u0003"+
		"\u0006\u0003\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d9\u0001\u0000\u0000\u0000\u00d0\u00d2\u0003"+
		"T*\u0000\u00d1\u00d3\u0003\u0006\u0003\u0000\u00d2\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d9\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d6\u0003Z-\u0000\u00d5\u00d7\u0003\u0006\u0003\u0000\u00d6"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7"+
		"\u00d9\u0001\u0000\u0000\u0000\u00d8\u009c\u0001\u0000\u0000\u0000\u00d8"+
		"\u00a0\u0001\u0000\u0000\u0000\u00d8\u00a4\u0001\u0000\u0000\u0000\u00d8"+
		"\u00a8\u0001\u0000\u0000\u0000\u00d8\u00ac\u0001\u0000\u0000\u0000\u00d8"+
		"\u00b0\u0001\u0000\u0000\u0000\u00d8\u00b4\u0001\u0000\u0000\u0000\u00d8"+
		"\u00b8\u0001\u0000\u0000\u0000\u00d8\u00bc\u0001\u0000\u0000\u0000\u00d8"+
		"\u00c0\u0001\u0000\u0000\u0000\u00d8\u00c4\u0001\u0000\u0000\u0000\u00d8"+
		"\u00c8\u0001\u0000\u0000\u0000\u00d8\u00cc\u0001\u0000\u0000\u0000\u00d8"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d8\u00d4\u0001\u0000\u0000\u0000\u00d9"+
		"\u0003\u0001\u0000\u0000\u0000\u00da\u00dc\u0003D\"\u0000\u00db\u00dd"+
		"\u0003\u0006\u0003\u0000\u00dc\u00db\u0001\u0000\u0000\u0000\u00dc\u00dd"+
		"\u0001\u0000\u0000\u0000\u00dd\u00ef\u0001\u0000\u0000\u0000\u00de\u00e0"+
		"\u0003L&\u0000\u00df\u00e1\u0003\u0006\u0003\u0000\u00e0\u00df\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00ef\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e4\u0003R)\u0000\u00e3\u00e5\u0003\u0006\u0003\u0000"+
		"\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e5\u00ef\u0001\u0000\u0000\u0000\u00e6\u00e8\u0003T*\u0000\u00e7\u00e9"+
		"\u0003\u0006\u0003\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e8\u00e9"+
		"\u0001\u0000\u0000\u0000\u00e9\u00ef\u0001\u0000\u0000\u0000\u00ea\u00ec"+
		"\u0003Z-\u0000\u00eb\u00ed\u0003\u0006\u0003\u0000\u00ec\u00eb\u0001\u0000"+
		"\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ee\u00da\u0001\u0000\u0000\u0000\u00ee\u00de\u0001\u0000"+
		"\u0000\u0000\u00ee\u00e2\u0001\u0000\u0000\u0000\u00ee\u00e6\u0001\u0000"+
		"\u0000\u0000\u00ee\u00ea\u0001\u0000\u0000\u0000\u00ef\u0005\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f1\u0005\u0003\u0000\u0000\u00f1\u0007\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f3\u0007\u0000\u0000\u0000\u00f3\t\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0005:\u0000\u0000\u00f5\u00f6\u0003\u008cF\u0000\u00f6"+
		"\u000b\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005;\u0000\u0000\u00f8\u00f9"+
		"\u0003\u008cF\u0000\u00f9\r\u0001\u0000\u0000\u0000\u00fa\u00fb\u0005"+
		"<\u0000\u0000\u00fb\u000f\u0001\u0000\u0000\u0000\u00fc\u00fe\u0003\u0082"+
		"A\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fe\u0101\u0001\u0000\u0000"+
		"\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000"+
		"\u0000\u0100\u0102\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000"+
		"\u0000\u0102\u0103\u0003\u0086C\u0000\u0103\u0104\u0005>\u0000\u0000\u0104"+
		"\u0106\u0003\u0090H\u0000\u0105\u0107\u0003x<\u0000\u0106\u0105\u0001"+
		"\u0000\u0000\u0000\u0106\u0107\u0001\u0000\u0000\u0000\u0107\u0109\u0001"+
		"\u0000\u0000\u0000\u0108\u010a\u0003\u0016\u000b\u0000\u0109\u0108\u0001"+
		"\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u010b\u0001"+
		"\u0000\u0000\u0000\u010b\u010c\u0003\u0012\t\u0000\u010c\u0011\u0001\u0000"+
		"\u0000\u0000\u010d\u0111\u0005\n\u0000\u0000\u010e\u0110\u0003\u0014\n"+
		"\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u0110\u0113\u0001\u0000\u0000"+
		"\u0000\u0111\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000"+
		"\u0000\u0112\u0114\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000"+
		"\u0000\u0114\u0115\u0005\u000b\u0000\u0000\u0115\u0013\u0001\u0000\u0000"+
		"\u0000\u0116\u011a\u0003\u001a\r\u0000\u0117\u011a\u0003\u0018\f\u0000"+
		"\u0118\u011a\u0003\b\u0004\u0000\u0119\u0116\u0001\u0000\u0000\u0000\u0119"+
		"\u0117\u0001\u0000\u0000\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a"+
		"\u0015\u0001\u0000\u0000\u0000\u011b\u011d\u0005\u0006\u0000\u0000\u011c"+
		"\u011e\u0003\u008eG\u0000\u011d\u011c\u0001\u0000\u0000\u0000\u011d\u011e"+
		"\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000\u0000\u011f\u0120"+
		"\u0005\u0007\u0000\u0000\u0120\u0017\u0001\u0000\u0000\u0000\u0121\u0123"+
		"\u0003\u0082A\u0000\u0122\u0121\u0001\u0000\u0000\u0000\u0123\u0126\u0001"+
		"\u0000\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124\u0125\u0001"+
		"\u0000\u0000\u0000\u0125\u0127\u0001\u0000\u0000\u0000\u0126\u0124\u0001"+
		"\u0000\u0000\u0000\u0127\u0129\u0003\u0088D\u0000\u0128\u012a\u00036\u001b"+
		"\u0000\u0129\u0128\u0001\u0000\u0000\u0000\u0129\u012a\u0001\u0000\u0000"+
		"\u0000\u012a\u012c\u0001\u0000\u0000\u0000\u012b\u012d\u0003@ \u0000\u012c"+
		"\u012b\u0001\u0000\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d"+
		"\u0019\u0001\u0000\u0000\u0000\u012e\u0130\u0003\u0082A\u0000\u012f\u012e"+
		"\u0001\u0000\u0000\u0000\u0130\u0133\u0001\u0000\u0000\u0000\u0131\u012f"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0001\u0000\u0000\u0000\u0132\u0134"+
		"\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0134\u0135"+
		"\u0003\u008aE\u0000\u0135\u0137\u0003<\u001e\u0000\u0136\u0138\u00036"+
		"\u001b\u0000\u0137\u0136\u0001\u0000\u0000\u0000\u0137\u0138\u0001\u0000"+
		"\u0000\u0000\u0138\u013a\u0001\u0000\u0000\u0000\u0139\u013b\u00038\u001c"+
		"\u0000\u013a\u0139\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000\u0000"+
		"\u0000\u013b\u013d\u0001\u0000\u0000\u0000\u013c\u013e\u0003H$\u0000\u013d"+
		"\u013c\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e"+
		"\u001b\u0001\u0000\u0000\u0000\u013f\u0140\u0005?\u0000\u0000\u0140\u0141"+
		"\u0003\u0090H\u0000\u0141\u0142\u0003\u0012\t\u0000\u0142\u001d\u0001"+
		"\u0000\u0000\u0000\u0143\u0144\u0005=\u0000\u0000\u0144\u0145\u0003\u008e"+
		"G\u0000\u0145\u0146\u0003\u0012\t\u0000\u0146\u001f\u0001\u0000\u0000"+
		"\u0000\u0147\u0148\u0005@\u0000\u0000\u0148\u0149\u0003\u0090H\u0000\u0149"+
		"\u014a\u0003\"\u0011\u0000\u014a!\u0001\u0000\u0000\u0000\u014b\u014f"+
		"\u0005\n\u0000\u0000\u014c\u014e\u0003$\u0012\u0000\u014d\u014c\u0001"+
		"\u0000\u0000\u0000\u014e\u0151\u0001\u0000\u0000\u0000\u014f\u014d\u0001"+
		"\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0152\u0001"+
		"\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0152\u0153\u0005"+
		"\u000b\u0000\u0000\u0153#\u0001\u0000\u0000\u0000\u0154\u0158\u0003\u001a"+
		"\r\u0000\u0155\u0158\u0003&\u0013\u0000\u0156\u0158\u0003\b\u0004\u0000"+
		"\u0157\u0154\u0001\u0000\u0000\u0000\u0157\u0155\u0001\u0000\u0000\u0000"+
		"\u0157\u0156\u0001\u0000\u0000\u0000\u0158%\u0001\u0000\u0000\u0000\u0159"+
		"\u015b\u0003\u0090H\u0000\u015a\u015c\u0003(\u0014\u0000\u015b\u015a\u0001"+
		"\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\'\u0001\u0000"+
		"\u0000\u0000\u015d\u0161\u0005\n\u0000\u0000\u015e\u0160\u0003*\u0015"+
		"\u0000\u015f\u015e\u0001\u0000\u0000\u0000\u0160\u0163\u0001\u0000\u0000"+
		"\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000"+
		"\u0000\u0162\u0164\u0001\u0000\u0000\u0000\u0163\u0161\u0001\u0000\u0000"+
		"\u0000\u0164\u0165\u0005\u000b\u0000\u0000\u0165)\u0001\u0000\u0000\u0000"+
		"\u0166\u0169\u0003\u0018\f\u0000\u0167\u0169\u0003\b\u0004\u0000\u0168"+
		"\u0166\u0001\u0000\u0000\u0000\u0168\u0167\u0001\u0000\u0000\u0000\u0169"+
		"+\u0001\u0000\u0000\u0000\u016a\u016b\u0005A\u0000\u0000\u016b\u016c\u0003"+
		"\u008eG\u0000\u016c\u016d\u0003.\u0017\u0000\u016d-\u0001\u0000\u0000"+
		"\u0000\u016e\u0172\u0005\n\u0000\u0000\u016f\u0171\u00030\u0018\u0000"+
		"\u0170\u016f\u0001\u0000\u0000\u0000\u0171\u0174\u0001\u0000\u0000\u0000"+
		"\u0172\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000"+
		"\u0173\u0175\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000"+
		"\u0175\u0176\u0005\u000b\u0000\u0000\u0176/\u0001\u0000\u0000\u0000\u0177"+
		"\u017a\u00032\u0019\u0000\u0178\u017a\u0003\b\u0004\u0000\u0179\u0177"+
		"\u0001\u0000\u0000\u0000\u0179\u0178\u0001\u0000\u0000\u0000\u017a1\u0001"+
		"\u0000\u0000\u0000\u017b\u017e\u0003\u0090H\u0000\u017c\u017d\u0005\""+
		"\u0000\u0000\u017d\u017f\u0003Z-\u0000\u017e\u017c\u0001\u0000\u0000\u0000"+
		"\u017e\u017f\u0001\u0000\u0000\u0000\u017f3\u0001\u0000\u0000\u0000\u0180"+
		"\u0181\u0005B\u0000\u0000\u0181\u0182\u0003\u0090H\u0000\u0182\u0183\u0005"+
		"\"\u0000\u0000\u0183\u0184\u0003\u0090H\u0000\u01845\u0001\u0000\u0000"+
		"\u0000\u0185\u0186\u0007\u0001\u0000\u0000\u0186\u0187\u0003t:\u0000\u0187"+
		"7\u0001\u0000\u0000\u0000\u0188\u0189\u0005\u0015\u0000\u0000\u0189\u018a"+
		"\u0003t:\u0000\u018a9\u0001\u0000\u0000\u0000\u018b\u018d\u0003\u0082"+
		"A\u0000\u018c\u018b\u0001\u0000\u0000\u0000\u018d\u0190\u0001\u0000\u0000"+
		"\u0000\u018e\u018c\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000"+
		"\u0000\u018f\u0191\u0001\u0000\u0000\u0000\u0190\u018e\u0001\u0000\u0000"+
		"\u0000\u0191\u0192\u0005D\u0000\u0000\u0192\u0193\u0003\u008eG\u0000\u0193"+
		"\u0195\u0003<\u001e\u0000\u0194\u0196\u00036\u001b\u0000\u0195\u0194\u0001"+
		"\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196\u0198\u0001"+
		"\u0000\u0000\u0000\u0197\u0199\u00038\u001c\u0000\u0198\u0197\u0001\u0000"+
		"\u0000\u0000\u0198\u0199\u0001\u0000\u0000\u0000\u0199\u019a\u0001\u0000"+
		"\u0000\u0000\u019a\u019b\u0003H$\u0000\u019b;\u0001\u0000\u0000\u0000"+
		"\u019c\u019d\u0005\u0006\u0000\u0000\u019d\u01a2\u0003>\u001f\u0000\u019e"+
		"\u019f\u0005\u0002\u0000\u0000\u019f\u01a1\u0003>\u001f\u0000\u01a0\u019e"+
		"\u0001\u0000\u0000\u0000\u01a1\u01a4\u0001\u0000\u0000\u0000\u01a2\u01a0"+
		"\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a5"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a5\u01a6"+
		"\u0005\u0007\u0000\u0000\u01a6\u01aa\u0001\u0000\u0000\u0000\u01a7\u01a8"+
		"\u0005\u0006\u0000\u0000\u01a8\u01aa\u0005\u0007\u0000\u0000\u01a9\u019c"+
		"\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01aa=\u0001"+
		"\u0000\u0000\u0000\u01ab\u01ad\u0003\u0082A\u0000\u01ac\u01ab\u0001\u0000"+
		"\u0000\u0000\u01ad\u01b0\u0001\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000"+
		"\u0000\u0000\u01ae\u01af\u0001\u0000\u0000\u0000\u01af\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b1\u01b3\u0003\u0088"+
		"D\u0000\u01b2\u01b4\u00036\u001b\u0000\u01b3\u01b2\u0001\u0000\u0000\u0000"+
		"\u01b3\u01b4\u0001\u0000\u0000\u0000\u01b4\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b5\u01b7\u0003@ \u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b6\u01b7"+
		"\u0001\u0000\u0000\u0000\u01b7?\u0001\u0000\u0000\u0000\u01b8\u01b9\u0005"+
		"\"\u0000\u0000\u01b9\u01ba\u0003Z-\u0000\u01baA\u0001\u0000\u0000\u0000"+
		"\u01bb\u01bd\u0005,\u0000\u0000\u01bc\u01bb\u0001\u0000\u0000\u0000\u01bc"+
		"\u01bd\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01be"+
		"\u01c0\u0005\u0006\u0000\u0000\u01bf\u01c1\u0003v;\u0000\u01c0\u01bf\u0001"+
		"\u0000\u0000\u0000\u01c0\u01c1\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001"+
		"\u0000\u0000\u0000\u01c2\u01c3\u0005\u0007\u0000\u0000\u01c3C\u0001\u0000"+
		"\u0000\u0000\u01c4\u01c6\u0003\u0082A\u0000\u01c5\u01c4\u0001\u0000\u0000"+
		"\u0000\u01c6\u01c9\u0001\u0000\u0000\u0000\u01c7\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8\u01ca\u0001\u0000\u0000"+
		"\u0000\u01c9\u01c7\u0001\u0000\u0000\u0000\u01ca\u01cb\u0005E\u0000\u0000"+
		"\u01cb\u01cd\u0003<\u001e\u0000\u01cc\u01ce\u00036\u001b\u0000\u01cd\u01cc"+
		"\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000\u01ce\u01d0"+
		"\u0001\u0000\u0000\u0000\u01cf\u01d1\u00038\u001c\u0000\u01d0\u01cf\u0001"+
		"\u0000\u0000\u0000\u01d0\u01d1\u0001\u0000\u0000\u0000\u01d1\u01d2\u0001"+
		"\u0000\u0000\u0000\u01d2\u01d3\u0003H$\u0000\u01d3E\u0001\u0000\u0000"+
		"\u0000\u01d4\u01d6\u0005,\u0000\u0000\u01d5\u01d4\u0001\u0000\u0000\u0000"+
		"\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000\u0000\u0000"+
		"\u01d7\u01d8\u0003H$\u0000\u01d8G\u0001\u0000\u0000\u0000\u01d9\u01dd"+
		"\u0005\n\u0000\u0000\u01da\u01dc\u0003\u0004\u0002\u0000\u01db\u01da\u0001"+
		"\u0000\u0000\u0000\u01dc\u01df\u0001\u0000\u0000\u0000\u01dd\u01db\u0001"+
		"\u0000\u0000\u0000\u01dd\u01de\u0001\u0000\u0000\u0000\u01de\u01e0\u0001"+
		"\u0000\u0000\u0000\u01df\u01dd\u0001\u0000\u0000\u0000\u01e0\u01e1\u0005"+
		"\u000b\u0000\u0000\u01e1I\u0001\u0000\u0000\u0000\u01e2\u01e3\u0005C\u0000"+
		"\u0000\u01e3\u01e4\u0003\u0090H\u0000\u01e4\u01e5\u0005\"\u0000\u0000"+
		"\u01e5\u01e6\u0003Z-\u0000\u01e6K\u0001\u0000\u0000\u0000\u01e7\u01e8"+
		"\u0005P\u0000\u0000\u01e8\u01e9\u0003\\.\u0000\u01e9\u01ed\u0003H$\u0000"+
		"\u01ea\u01ec\u0003N\'\u0000\u01eb\u01ea\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ef\u0001\u0000\u0000\u0000\u01ed\u01eb\u0001\u0000\u0000\u0000\u01ed"+
		"\u01ee\u0001\u0000\u0000\u0000\u01ee\u01f1\u0001\u0000\u0000\u0000\u01ef"+
		"\u01ed\u0001\u0000\u0000\u0000\u01f0\u01f2\u0003P(\u0000\u01f1\u01f0\u0001"+
		"\u0000\u0000\u0000\u01f1\u01f2\u0001\u0000\u0000\u0000\u01f2M\u0001\u0000"+
		"\u0000\u0000\u01f3\u01f4\u0005Q\u0000\u0000\u01f4\u01f5\u0005P\u0000\u0000"+
		"\u01f5\u01f6\u0003\\.\u0000\u01f6\u01f7\u0003H$\u0000\u01f7O\u0001\u0000"+
		"\u0000\u0000\u01f8\u01f9\u0005Q\u0000\u0000\u01f9\u01fa\u0003H$\u0000"+
		"\u01faQ\u0001\u0000\u0000\u0000\u01fb\u01fc\u0005G\u0000\u0000\u01fc\u01fd"+
		"\u0003\\.\u0000\u01fd\u01fe\u0003H$\u0000\u01feS\u0001\u0000\u0000\u0000"+
		"\u01ff\u0200\u0005H\u0000\u0000\u0200\u0201\u0003V+\u0000\u0201\u0202"+
		"\u0003r9\u0000\u0202\u0203\u0003\\.\u0000\u0203\u0204\u0003H$\u0000\u0204"+
		"U\u0001\u0000\u0000\u0000\u0205\u020a\u0003X,\u0000\u0206\u0207\u0005"+
		"\u0002\u0000\u0000\u0207\u0209\u0003X,\u0000\u0208\u0206\u0001\u0000\u0000"+
		"\u0000\u0209\u020c\u0001\u0000\u0000\u0000\u020a\u0208\u0001\u0000\u0000"+
		"\u0000\u020a\u020b\u0001\u0000\u0000\u0000\u020b\u0219\u0001\u0000\u0000"+
		"\u0000\u020c\u020a\u0001\u0000\u0000\u0000\u020d\u020e\u0005\u0006\u0000"+
		"\u0000\u020e\u0213\u0003X,\u0000\u020f\u0210\u0005\u0002\u0000\u0000\u0210"+
		"\u0212\u0003X,\u0000\u0211\u020f\u0001\u0000\u0000\u0000\u0212\u0215\u0001"+
		"\u0000\u0000\u0000\u0213\u0211\u0001\u0000\u0000\u0000\u0213\u0214\u0001"+
		"\u0000\u0000\u0000\u0214\u0216\u0001\u0000\u0000\u0000\u0215\u0213\u0001"+
		"\u0000\u0000\u0000\u0216\u0217\u0005\u0007\u0000\u0000\u0217\u0219\u0001"+
		"\u0000\u0000\u0000\u0218\u0205\u0001\u0000\u0000\u0000\u0218\u020d\u0001"+
		"\u0000\u0000\u0000\u0219W\u0001\u0000\u0000\u0000\u021a\u021c\u0003\u0090"+
		"H\u0000\u021b\u021a\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000\u0000"+
		"\u0000\u021d\u021b\u0001\u0000\u0000\u0000\u021d\u021e\u0001\u0000\u0000"+
		"\u0000\u021eY\u0001\u0000\u0000\u0000\u021f\u0220\u0006-\uffff\uffff\u0000"+
		"\u0220\u0226\u0003b1\u0000\u0221\u0222\u0003^/\u0000\u0222\u0223\u0003"+
		"Z-\u0002\u0223\u0226\u0001\u0000\u0000\u0000\u0224\u0226\u0003d2\u0000"+
		"\u0225\u021f\u0001\u0000\u0000\u0000\u0225\u0221\u0001\u0000\u0000\u0000"+
		"\u0225\u0224\u0001\u0000\u0000\u0000\u0226\u023f\u0001\u0000\u0000\u0000"+
		"\u0227\u0228\n\b\u0000\u0000\u0228\u0229\u0003j5\u0000\u0229\u022a\u0003"+
		"Z-\t\u022a\u023e\u0001\u0000\u0000\u0000\u022b\u022c\n\u0007\u0000\u0000"+
		"\u022c\u022d\u0003l6\u0000\u022d\u022e\u0003Z-\b\u022e\u023e\u0001\u0000"+
		"\u0000\u0000\u022f\u0230\n\u0006\u0000\u0000\u0230\u0231\u0003n7\u0000"+
		"\u0231\u0232\u0003Z-\u0007\u0232\u023e\u0001\u0000\u0000\u0000\u0233\u0234"+
		"\n\u0005\u0000\u0000\u0234\u0235\u0003f3\u0000\u0235\u0236\u0003Z-\u0006"+
		"\u0236\u023e\u0001\u0000\u0000\u0000\u0237\u0238\n\t\u0000\u0000\u0238"+
		"\u023e\u0003`0\u0000\u0239\u023a\n\u0004\u0000\u0000\u023a\u023b\u0003"+
		"p8\u0000\u023b\u023c\u0003t:\u0000\u023c\u023e\u0001\u0000\u0000\u0000"+
		"\u023d\u0227\u0001\u0000\u0000\u0000\u023d\u022b\u0001\u0000\u0000\u0000"+
		"\u023d\u022f\u0001\u0000\u0000\u0000\u023d\u0233\u0001\u0000\u0000\u0000"+
		"\u023d\u0237\u0001\u0000\u0000\u0000\u023d\u0239\u0001\u0000\u0000\u0000"+
		"\u023e\u0241\u0001\u0000\u0000\u0000\u023f\u023d\u0001\u0000\u0000\u0000"+
		"\u023f\u0240\u0001\u0000\u0000\u0000\u0240[\u0001\u0000\u0000\u0000\u0241"+
		"\u023f\u0001\u0000\u0000\u0000\u0242\u0243\u0006.\uffff\uffff\u0000\u0243"+
		"\u0244\u0003^/\u0000\u0244\u0245\u0003\\.\u0002\u0245\u0248\u0001\u0000"+
		"\u0000\u0000\u0246\u0248\u0003d2\u0000\u0247\u0242\u0001\u0000\u0000\u0000"+
		"\u0247\u0246\u0001\u0000\u0000\u0000\u0248\u025f\u0001\u0000\u0000\u0000"+
		"\u0249\u024a\n\u0007\u0000\u0000\u024a\u024b\u0003j5\u0000\u024b\u024c"+
		"\u0003\\.\b\u024c\u025e\u0001\u0000\u0000\u0000\u024d\u024e\n\u0006\u0000"+
		"\u0000\u024e\u024f\u0003l6\u0000\u024f\u0250\u0003\\.\u0007\u0250\u025e"+
		"\u0001\u0000\u0000\u0000\u0251\u0252\n\u0005\u0000\u0000\u0252\u0253\u0003"+
		"n7\u0000\u0253\u0254\u0003\\.\u0006\u0254\u025e\u0001\u0000\u0000\u0000"+
		"\u0255\u0256\n\u0004\u0000\u0000\u0256\u0257\u0003f3\u0000\u0257\u0258"+
		"\u0003\\.\u0005\u0258\u025e\u0001\u0000\u0000\u0000\u0259\u025a\n\u0003"+
		"\u0000\u0000\u025a\u025b\u0003p8\u0000\u025b\u025c\u0003\\.\u0004\u025c"+
		"\u025e\u0001\u0000\u0000\u0000\u025d\u0249\u0001\u0000\u0000\u0000\u025d"+
		"\u024d\u0001\u0000\u0000\u0000\u025d\u0251\u0001\u0000\u0000\u0000\u025d"+
		"\u0255\u0001\u0000\u0000\u0000\u025d\u0259\u0001\u0000\u0000\u0000\u025e"+
		"\u0261\u0001\u0000\u0000\u0000\u025f\u025d\u0001\u0000\u0000\u0000\u025f"+
		"\u0260\u0001\u0000\u0000\u0000\u0260]\u0001\u0000\u0000\u0000\u0261\u025f"+
		"\u0001\u0000\u0000\u0000\u0262\u0263\u0007\u0002\u0000\u0000\u0263_\u0001"+
		"\u0000\u0000\u0000\u0264\u026d\u0005-\u0000\u0000\u0265\u026d\u00058\u0000"+
		"\u0000\u0266\u026d\u0003~?\u0000\u0267\u026d\u0003\u0080@\u0000\u0268"+
		"\u026d\u0003z=\u0000\u0269\u026d\u0003F#\u0000\u026a\u026d\u0003|>\u0000"+
		"\u026b\u026d\u0003B!\u0000\u026c\u0264\u0001\u0000\u0000\u0000\u026c\u0265"+
		"\u0001\u0000\u0000\u0000\u026c\u0266\u0001\u0000\u0000\u0000\u026c\u0267"+
		"\u0001\u0000\u0000\u0000\u026c\u0268\u0001\u0000\u0000\u0000\u026c\u0269"+
		"\u0001\u0000\u0000\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026c\u026b"+
		"\u0001\u0000\u0000\u0000\u026da\u0001\u0000\u0000\u0000\u026e\u026f\u0005"+
		"T\u0000\u0000\u026f\u0282\u0003Z-\u0000\u0270\u0271\u0005U\u0000\u0000"+
		"\u0271\u0282\u0003Z-\u0000\u0272\u0282\u0005W\u0000\u0000\u0273\u0282"+
		"\u0005X\u0000\u0000\u0274\u0275\u0005Y\u0000\u0000\u0275\u0282\u0003Z"+
		"-\u0000\u0276\u0278\u0005V\u0000\u0000\u0277\u0279\u0005T\u0000\u0000"+
		"\u0278\u0277\u0001\u0000\u0000\u0000\u0278\u0279\u0001\u0000\u0000\u0000"+
		"\u0279\u027a\u0001\u0000\u0000\u0000\u027a\u0282\u0003Z-\u0000\u027b\u027c"+
		"\u0005V\u0000\u0000\u027c\u027d\u0005W\u0000\u0000\u027d\u0282\u0003Z"+
		"-\u0000\u027e\u027f\u0005V\u0000\u0000\u027f\u0280\u0005S\u0000\u0000"+
		"\u0280\u0282\u0003Z-\u0000\u0281\u026e\u0001\u0000\u0000\u0000\u0281\u0270"+
		"\u0001\u0000\u0000\u0000\u0281\u0272\u0001\u0000\u0000\u0000\u0281\u0273"+
		"\u0001\u0000\u0000\u0000\u0281\u0274\u0001\u0000\u0000\u0000\u0281\u0276"+
		"\u0001\u0000\u0000\u0000\u0281\u027b\u0001\u0000\u0000\u0000\u0281\u027e"+
		"\u0001\u0000\u0000\u0000\u0282c\u0001\u0000\u0000\u0000\u0283\u0290\u0003"+
		"\u008eG\u0000\u0284\u0290\u0003\u0092I\u0000\u0285\u0290\u0005O\u0000"+
		"\u0000\u0286\u0287\u0005\u0006\u0000\u0000\u0287\u0288\u0003Z-\u0000\u0288"+
		"\u0289\u0005\u0007\u0000\u0000\u0289\u0290\u0001\u0000\u0000\u0000\u028a"+
		"\u028b\u0005\b\u0000\u0000\u028b\u028c\u0003Z-\u0000\u028c\u028d\u0005"+
		"\t\u0000\u0000\u028d\u0290\u0001\u0000\u0000\u0000\u028e\u0290\u0005["+
		"\u0000\u0000\u028f\u0283\u0001\u0000\u0000\u0000\u028f\u0284\u0001\u0000"+
		"\u0000\u0000\u028f\u0285\u0001\u0000\u0000\u0000\u028f\u0286\u0001\u0000"+
		"\u0000\u0000\u028f\u028a\u0001\u0000\u0000\u0000\u028f\u028e\u0001\u0000"+
		"\u0000\u0000\u0290e\u0001\u0000\u0000\u0000\u0291\u0292\u0007\u0003\u0000"+
		"\u0000\u0292g\u0001\u0000\u0000\u0000\u0293\u0294\u0007\u0004\u0000\u0000"+
		"\u0294i\u0001\u0000\u0000\u0000\u0295\u0296\u0007\u0005\u0000\u0000\u0296"+
		"k\u0001\u0000\u0000\u0000\u0297\u0298\u0007\u0002\u0000\u0000\u0298m\u0001"+
		"\u0000\u0000\u0000\u0299\u029a\u0007\u0006\u0000\u0000\u029ao\u0001\u0000"+
		"\u0000\u0000\u029b\u029f\u00052\u0000\u0000\u029c\u029d\u00052\u0000\u0000"+
		"\u029d\u029f\u0005.\u0000\u0000\u029e\u029b\u0001\u0000\u0000\u0000\u029e"+
		"\u029c\u0001\u0000\u0000\u0000\u029fq\u0001\u0000\u0000\u0000\u02a0\u02a1"+
		"\u0007\u0007\u0000\u0000\u02a1s\u0001\u0000\u0000\u0000\u02a2\u02a3\u0006"+
		":\uffff\uffff\u0000\u02a3\u02a4\u0005\u0006\u0000\u0000\u02a4\u02a5\u0003"+
		"t:\u0000\u02a5\u02a6\u0005\u0007\u0000\u0000\u02a6\u02a9\u0001\u0000\u0000"+
		"\u0000\u02a7\u02a9\u0003d2\u0000\u02a8\u02a2\u0001\u0000\u0000\u0000\u02a8"+
		"\u02a7\u0001\u0000\u0000\u0000\u02a9\u02b0\u0001\u0000\u0000\u0000\u02aa"+
		"\u02ab\n\u0003\u0000\u0000\u02ab\u02ac\u0003h4\u0000\u02ac\u02ad\u0003"+
		"t:\u0004\u02ad\u02af\u0001\u0000\u0000\u0000\u02ae\u02aa\u0001\u0000\u0000"+
		"\u0000\u02af\u02b2\u0001\u0000\u0000\u0000\u02b0\u02ae\u0001\u0000\u0000"+
		"\u0000\u02b0\u02b1\u0001\u0000\u0000\u0000\u02b1u\u0001\u0000\u0000\u0000"+
		"\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b3\u02b8\u0003Z-\u0000\u02b4\u02b5"+
		"\u0005\u0002\u0000\u0000\u02b5\u02b7\u0003Z-\u0000\u02b6\u02b4\u0001\u0000"+
		"\u0000\u0000\u02b7\u02ba\u0001\u0000\u0000\u0000\u02b8\u02b6\u0001\u0000"+
		"\u0000\u0000\u02b8\u02b9\u0001\u0000\u0000\u0000\u02b9w\u0001\u0000\u0000"+
		"\u0000\u02ba\u02b8\u0001\u0000\u0000\u0000\u02bb\u02bd\u0005\u0004\u0000"+
		"\u0000\u02bc\u02bb\u0001\u0000\u0000\u0000\u02bc\u02bd\u0001\u0000\u0000"+
		"\u0000\u02bd\u02be\u0001\u0000\u0000\u0000\u02be\u02bf\u0005\u0018\u0000"+
		"\u0000\u02bf\u02c0\u0003\u0090H\u0000\u02c0\u02c1\u0005\u001c\u0000\u0000"+
		"\u02c1\u02c7\u0001\u0000\u0000\u0000\u02c2\u02c3\u0005\f\u0000\u0000\u02c3"+
		"\u02c4\u0003\u0090H\u0000\u02c4\u02c5\u0005\r\u0000\u0000\u02c5\u02c7"+
		"\u0001\u0000\u0000\u0000\u02c6\u02bc\u0001\u0000\u0000\u0000\u02c6\u02c2"+
		"\u0001\u0000\u0000\u0000\u02c7y\u0001\u0000\u0000\u0000\u02c8\u02c9\u0005"+
		"\u0004\u0000\u0000\u02c9\u02ca\u0005\u0018\u0000\u0000\u02ca\u02cb\u0003"+
		"\u0090H\u0000\u02cb\u02cc\u0005\u001c\u0000\u0000\u02cc\u02d2\u0001\u0000"+
		"\u0000\u0000\u02cd\u02ce\u0005\f\u0000\u0000\u02ce\u02cf\u0003\u0090H"+
		"\u0000\u02cf\u02d0\u0005\r\u0000\u0000\u02d0\u02d2\u0001\u0000\u0000\u0000"+
		"\u02d1\u02c8\u0001\u0000\u0000\u0000\u02d1\u02cd\u0001\u0000\u0000\u0000"+
		"\u02d2{\u0001\u0000\u0000\u0000\u02d3\u02d5\u0005,\u0000\u0000\u02d4\u02d3"+
		"\u0001\u0000\u0000\u0000\u02d4\u02d5\u0001\u0000\u0000\u0000\u02d5\u02d6"+
		"\u0001\u0000\u0000\u0000\u02d6\u02d7\u0005\u0001\u0000\u0000\u02d7\u02d8"+
		"\u0003\u0090H\u0000\u02d8}\u0001\u0000\u0000\u0000\u02d9\u02da\u0005\b"+
		"\u0000\u0000\u02da\u02db\u0003Z-\u0000\u02db\u02dc\u0005\t\u0000\u0000"+
		"\u02dc\u007f\u0001\u0000\u0000\u0000\u02dd\u02de\u0005\u0004\u0000\u0000"+
		"\u02de\u02df\u0005\b\u0000\u0000\u02df\u02e0\u0003Z-\u0000\u02e0\u02e1"+
		"\u0005\t\u0000\u0000\u02e1\u02e7\u0001\u0000\u0000\u0000\u02e2\u02e3\u0005"+
		"\u000e\u0000\u0000\u02e3\u02e4\u0003Z-\u0000\u02e4\u02e5\u0005\u000f\u0000"+
		"\u0000\u02e5\u02e7\u0001\u0000\u0000\u0000\u02e6\u02dd\u0001\u0000\u0000"+
		"\u0000\u02e6\u02e2\u0001\u0000\u0000\u0000\u02e7\u0081\u0001\u0000\u0000"+
		"\u0000\u02e8\u02e9\u0005(\u0000\u0000\u02e9\u02f7\u0003\u0084B\u0000\u02ea"+
		"\u02eb\u0005(\u0000\u0000\u02eb\u02ec\u0005\b\u0000\u0000\u02ec\u02f1"+
		"\u0003\u0084B\u0000\u02ed\u02ee\u0005\u0002\u0000\u0000\u02ee\u02f0\u0003"+
		"\u0084B\u0000\u02ef\u02ed\u0001\u0000\u0000\u0000\u02f0\u02f3\u0001\u0000"+
		"\u0000\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000\u02f1\u02f2\u0001\u0000"+
		"\u0000\u0000\u02f2\u02f4\u0001\u0000\u0000\u0000\u02f3\u02f1\u0001\u0000"+
		"\u0000\u0000\u02f4\u02f5\u0005\t\u0000\u0000\u02f5\u02f7\u0001\u0000\u0000"+
		"\u0000\u02f6\u02e8\u0001\u0000\u0000\u0000\u02f6\u02ea\u0001\u0000\u0000"+
		"\u0000\u02f7\u0083\u0001\u0000\u0000\u0000\u02f8\u02fa\u0003\u008eG\u0000"+
		"\u02f9\u02fb\u0003<\u001e\u0000\u02fa\u02f9\u0001\u0000\u0000\u0000\u02fa"+
		"\u02fb\u0001\u0000\u0000\u0000\u02fb\u0085\u0001\u0000\u0000\u0000\u02fc"+
		"\u02fe\u0003\u0090H\u0000\u02fd\u02fc\u0001\u0000\u0000\u0000\u02fe\u0301"+
		"\u0001\u0000\u0000\u0000\u02ff\u02fd\u0001\u0000\u0000\u0000\u02ff\u0300"+
		"\u0001\u0000\u0000\u0000\u0300\u0087\u0001\u0000\u0000\u0000\u0301\u02ff"+
		"\u0001\u0000\u0000\u0000\u0302\u0304\u0003\u0090H\u0000\u0303\u0302\u0001"+
		"\u0000\u0000\u0000\u0304\u0305\u0001\u0000\u0000\u0000\u0305\u0303\u0001"+
		"\u0000\u0000\u0000\u0305\u0306\u0001\u0000\u0000\u0000\u0306\u0089\u0001"+
		"\u0000\u0000\u0000\u0307\u0309\u0003\u0090H\u0000\u0308\u0307\u0001\u0000"+
		"\u0000\u0000\u0309\u030a\u0001\u0000\u0000\u0000\u030a\u0308\u0001\u0000"+
		"\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000\u030b\u0310\u0001\u0000"+
		"\u0000\u0000\u030c\u030d\u0005\u0004\u0000\u0000\u030d\u030f\u0003\u0090"+
		"H\u0000\u030e\u030c\u0001\u0000\u0000\u0000\u030f\u0312\u0001\u0000\u0000"+
		"\u0000\u0310\u030e\u0001\u0000\u0000\u0000\u0310\u0311\u0001\u0000\u0000"+
		"\u0000\u0311\u008b\u0001\u0000\u0000\u0000\u0312\u0310\u0001\u0000\u0000"+
		"\u0000\u0313\u0318\u0003\u0090H\u0000\u0314\u0315\u0007\b\u0000\u0000"+
		"\u0315\u0317\u0003\u0090H\u0000\u0316\u0314\u0001\u0000\u0000\u0000\u0317"+
		"\u031a\u0001\u0000\u0000\u0000\u0318\u0316\u0001\u0000\u0000\u0000\u0318"+
		"\u0319\u0001\u0000\u0000\u0000\u0319\u008d\u0001\u0000\u0000\u0000\u031a"+
		"\u0318\u0001\u0000\u0000\u0000\u031b\u0320\u0003\u0090H\u0000\u031c\u031d"+
		"\u0005\u0004\u0000\u0000\u031d\u031f\u0003\u0090H\u0000\u031e\u031c\u0001"+
		"\u0000\u0000\u0000\u031f\u0322\u0001\u0000\u0000\u0000\u0320\u031e\u0001"+
		"\u0000\u0000\u0000\u0320\u0321\u0001\u0000\u0000\u0000\u0321\u008f\u0001"+
		"\u0000\u0000\u0000\u0322\u0320\u0001\u0000\u0000\u0000\u0323\u0324\u0007"+
		"\t\u0000\u0000\u0324\u0091\u0001\u0000\u0000\u0000\u0325\u0327\u0005N"+
		"\u0000\u0000\u0326\u0328\u0003\u0090H\u0000\u0327\u0326\u0001\u0000\u0000"+
		"\u0000\u0327\u0328\u0001\u0000\u0000\u0000\u0328\u032e\u0001\u0000\u0000"+
		"\u0000\u0329\u032b\u0005M\u0000\u0000\u032a\u032c\u0003\u0090H\u0000\u032b"+
		"\u032a\u0001\u0000\u0000\u0000\u032b\u032c\u0001\u0000\u0000\u0000\u032c"+
		"\u032e\u0001\u0000\u0000\u0000\u032d\u0325\u0001\u0000\u0000\u0000\u032d"+
		"\u0329\u0001\u0000\u0000\u0000\u032e\u0093\u0001\u0000\u0000\u0000`\u0097"+
		"\u009e\u00a2\u00a6\u00aa\u00ae\u00b2\u00b6\u00ba\u00be\u00c2\u00c6\u00ca"+
		"\u00ce\u00d2\u00d6\u00d8\u00dc\u00e0\u00e4\u00e8\u00ec\u00ee\u00ff\u0106"+
		"\u0109\u0111\u0119\u011d\u0124\u0129\u012c\u0131\u0137\u013a\u013d\u014f"+
		"\u0157\u015b\u0161\u0168\u0172\u0179\u017e\u018e\u0195\u0198\u01a2\u01a9"+
		"\u01ae\u01b3\u01b6\u01bc\u01c0\u01c7\u01cd\u01d0\u01d5\u01dd\u01ed\u01f1"+
		"\u020a\u0213\u0218\u021d\u0225\u023d\u023f\u0247\u025d\u025f\u026c\u0278"+
		"\u0281\u028f\u029e\u02a8\u02b0\u02b8\u02bc\u02c6\u02d1\u02d4\u02e6\u02f1"+
		"\u02f6\u02fa\u02ff\u0305\u030a\u0310\u0318\u0320\u0327\u032b\u032d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}