// Generated from D:/Java/valkyrie-intellij/src/main/antlr/ValkyrieAntlr.g4 by ANTLR 4.13.1
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
public class ValkyrieAntlrParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DOT=1, COMMA=2, SEMICOLON=3, OP_PROPORTION=4, COLON=5, PARENTHESES_L=6, 
		PARENTHESES_R=7, BRACKET_L=8, BRACKET_R=9, BRACE_L=10, BRACE_R=11, GENERIC_L=12, 
		GENERIC_R=13, OFFSET_L=14, OFFSET_R=15, RANGE_L=16, RANGE_R=17, CEILING_L=18, 
		CEILING_R=19, FLOOR_L=20, FLOOR_R=21, COLLECTION_L=22, COLLECTION_R=23, 
		OP_ADD=24, OP_INC=25, OP_SUB=26, OP_DEC=27, OP_MUL=28, OP_DIV=29, OP_EQ=30, 
		OP_NE=31, OP_LT=32, OP_LL=33, OP_LLL=34, OP_LEQ=35, OP_GT=36, OP_GG=37, 
		OP_GGG=38, OP_GEQ=39, OP_ARROW=40, OP_ARROW2=41, OP_ASSIGN=42, OP_ADD_ASSIGN=43, 
		OP_SUB_ASSIGN=44, OP_MUL_ASSIGN=45, OP_DIV_ASSIGN=46, LOGIC_OR=47, OP_OR=48, 
		LOGIC_AND=49, OP_AND=50, OP_AT=51, OP_HASH=52, LAMBDA_SLOT=53, MACRO_SLOT=54, 
		OP_UNIMPLEMENTED=55, OP_OR_ELSE=56, OP_THROW=57, OP_NOT=58, KW_NOT=59, 
		OP_IN=60, KW_IN=61, OP_NOT_IN=62, KW_IS=63, OP_IS=64, OP_IS_NOT=65, KW_AS=66, 
		OP_UNTIL=67, OP_POW=68, OP_TEMPERATURE=69, KW_NAMESPACE=70, KW_IMPORT=71, 
		KW_EXTENSION=72, KW_EXTENDS=73, KW_IMPLEMENTS=74, KW_CLASS=75, KW_TRAIT=76, 
		KW_UNION=77, KW_BITFLAGS=78, KW_TYPE=79, KW_LET=80, KW_FUNCTION=81, KW_LAMBDA=82, 
		KW_WITCH=83, KW_WHILE=84, KW_FOR=85, KW_NEW=86, KW_TRY=87, KW_MATCH=88, 
		KW_CATCH=89, KW_WITH=90, KW_CASE=91, KW_WHEN=92, INTEGER=93, DECIMAL=94, 
		STRING_SINGLE=95, STRING_DOUBLE=96, KW_IF=97, KW_ELSE=98, KW_OTHERWISE=99, 
		RETURN=100, RESUME=101, YIELD=102, BREAK=103, CONTINUE=104, RAISE=105, 
		SPECIAL=106, RAW_ID=107, UNICODE_ID=108, LINE_COMMENT=109, BLOCK_COMMENT=110, 
		WHITE_SPACE=111, ERROR_CHARACTAR=112;
	public static final int
		RULE_program = 0, RULE_top_statement = 1, RULE_function_statements = 2, 
		RULE_eos = 3, RULE_eos_free = 4, RULE_define_namespace = 5, RULE_import_statement = 6, 
		RULE_define_extension = 7, RULE_define_class = 8, RULE_class_block = 9, 
		RULE_class_statements = 10, RULE_class_inherit = 11, RULE_class_field = 12, 
		RULE_class_method = 13, RULE_define_trait = 14, RULE_trait_block = 15, 
		RULE_trait_statements = 16, RULE_define_trait_type = 17, RULE_define_extends = 18, 
		RULE_impliments = 19, RULE_define_union = 20, RULE_union_block = 21, RULE_union_statements = 22, 
		RULE_define_variant = 23, RULE_variant_block = 24, RULE_variant_statements = 25, 
		RULE_define_bitflags = 26, RULE_bitflags_block = 27, RULE_bitflags_statements = 28, 
		RULE_bitflags_item = 29, RULE_define_function = 30, RULE_function_parameters = 31, 
		RULE_parameter_item = 32, RULE_parameter_default = 33, RULE_function_call = 34, 
		RULE_dot_call = 35, RULE_tuple_call_body = 36, RULE_tuple_call_item = 37, 
		RULE_define_lambda = 38, RULE_lambda_call = 39, RULE_function_block = 40, 
		RULE_define_variale = 41, RULE_define_variale_lhs = 42, RULE_let_parameter = 43, 
		RULE_define_type = 44, RULE_type_hint = 45, RULE_effect_hint = 46, RULE_if_statement = 47, 
		RULE_else_if_statement = 48, RULE_else_statement = 49, RULE_while_statement = 50, 
		RULE_for_statement = 51, RULE_for_pattern = 52, RULE_if_guard = 53, RULE_expression = 54, 
		RULE_inline_expression = 55, RULE_type_expression = 56, RULE_prefix_call = 57, 
		RULE_suffix_call = 58, RULE_control_expression = 59, RULE_term = 60, RULE_op_compare = 61, 
		RULE_op_pattern = 62, RULE_op_multiple = 63, RULE_op_plus = 64, RULE_op_logic = 65, 
		RULE_op_assign = 66, RULE_infix_is = 67, RULE_infix_in = 68, RULE_define_generic = 69, 
		RULE_generic_call = 70, RULE_generic_call_in_type = 71, RULE_slice_call = 72, 
		RULE_offset_call = 73, RULE_macro_call = 74, RULE_macro_call_item = 75, 
		RULE_try_statement = 76, RULE_match_statement = 77, RULE_catch_statement = 78, 
		RULE_match_call = 79, RULE_catch_call = 80, RULE_match_block = 81, RULE_match_terms = 82, 
		RULE_with_block = 83, RULE_when_block = 84, RULE_else_pattern = 85, RULE_case_pattern = 86, 
		RULE_case_tuple = 87, RULE_case_term = 88, RULE_new_call = 89, RULE_new_body = 90, 
		RULE_new_block = 91, RULE_new_statement = 92, RULE_modifiers = 93, RULE_modified_identifier = 94, 
		RULE_modified_namepath = 95, RULE_namepath_free = 96, RULE_namepath = 97, 
		RULE_identifier = 98, RULE_number = 99, RULE_number_literal = 100, RULE_string = 101, 
		RULE_string_literal = 102;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "top_statement", "function_statements", "eos", "eos_free", 
			"define_namespace", "import_statement", "define_extension", "define_class", 
			"class_block", "class_statements", "class_inherit", "class_field", "class_method", 
			"define_trait", "trait_block", "trait_statements", "define_trait_type", 
			"define_extends", "impliments", "define_union", "union_block", "union_statements", 
			"define_variant", "variant_block", "variant_statements", "define_bitflags", 
			"bitflags_block", "bitflags_statements", "bitflags_item", "define_function", 
			"function_parameters", "parameter_item", "parameter_default", "function_call", 
			"dot_call", "tuple_call_body", "tuple_call_item", "define_lambda", "lambda_call", 
			"function_block", "define_variale", "define_variale_lhs", "let_parameter", 
			"define_type", "type_hint", "effect_hint", "if_statement", "else_if_statement", 
			"else_statement", "while_statement", "for_statement", "for_pattern", 
			"if_guard", "expression", "inline_expression", "type_expression", "prefix_call", 
			"suffix_call", "control_expression", "term", "op_compare", "op_pattern", 
			"op_multiple", "op_plus", "op_logic", "op_assign", "infix_is", "infix_in", 
			"define_generic", "generic_call", "generic_call_in_type", "slice_call", 
			"offset_call", "macro_call", "macro_call_item", "try_statement", "match_statement", 
			"catch_statement", "match_call", "catch_call", "match_block", "match_terms", 
			"with_block", "when_block", "else_pattern", "case_pattern", "case_tuple", 
			"case_term", "new_call", "new_body", "new_block", "new_statement", "modifiers", 
			"modified_identifier", "modified_namepath", "namepath_free", "namepath", 
			"identifier", "number", "number_literal", "string", "string_literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", "','", "';'", null, null, "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'\\u27E8'", "'\\u27E9'", "'\\u2045'", "'\\u2046'", "'\\u27E6'", 
			"'\\u27E7'", "'\\u2308'", "'\\u2309'", "'\\u230A'", "'\\u230B'", "'\\u2983'", 
			"'\\u2984'", "'+'", "'++'", "'-'", "'--'", "'*'", "'/'", "'=='", "'!='", 
			"'<'", null, null, null, "'>'", null, null, null, null, null, "'='", 
			"'+='", "'-='", "'*='", "'/='", "'||'", "'|'", "'&&'", "'&'", "'@'", 
			null, null, null, null, "'??'", "'?'", "'!'", "'not'", null, "'in'", 
			"'\\u2209'", "'is'", null, null, null, null, "'^'", null, null, null, 
			"'extension'", null, null, null, null, "'union'", "'flags'", "'type'", 
			"'let'", null, "'lambda'", "'which'", "'while'", "'for'", null, "'try'", 
			"'match'", "'catch'", "'with'", "'case'", "'when'", null, null, null, 
			null, "'if'", "'else'", "'otherwise'", "'return'", "'resume'", "'yield'", 
			"'break'", "'continue'", "'raise'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "COMMA", "SEMICOLON", "OP_PROPORTION", "COLON", "PARENTHESES_L", 
			"PARENTHESES_R", "BRACKET_L", "BRACKET_R", "BRACE_L", "BRACE_R", "GENERIC_L", 
			"GENERIC_R", "OFFSET_L", "OFFSET_R", "RANGE_L", "RANGE_R", "CEILING_L", 
			"CEILING_R", "FLOOR_L", "FLOOR_R", "COLLECTION_L", "COLLECTION_R", "OP_ADD", 
			"OP_INC", "OP_SUB", "OP_DEC", "OP_MUL", "OP_DIV", "OP_EQ", "OP_NE", "OP_LT", 
			"OP_LL", "OP_LLL", "OP_LEQ", "OP_GT", "OP_GG", "OP_GGG", "OP_GEQ", "OP_ARROW", 
			"OP_ARROW2", "OP_ASSIGN", "OP_ADD_ASSIGN", "OP_SUB_ASSIGN", "OP_MUL_ASSIGN", 
			"OP_DIV_ASSIGN", "LOGIC_OR", "OP_OR", "LOGIC_AND", "OP_AND", "OP_AT", 
			"OP_HASH", "LAMBDA_SLOT", "MACRO_SLOT", "OP_UNIMPLEMENTED", "OP_OR_ELSE", 
			"OP_THROW", "OP_NOT", "KW_NOT", "OP_IN", "KW_IN", "OP_NOT_IN", "KW_IS", 
			"OP_IS", "OP_IS_NOT", "KW_AS", "OP_UNTIL", "OP_POW", "OP_TEMPERATURE", 
			"KW_NAMESPACE", "KW_IMPORT", "KW_EXTENSION", "KW_EXTENDS", "KW_IMPLEMENTS", 
			"KW_CLASS", "KW_TRAIT", "KW_UNION", "KW_BITFLAGS", "KW_TYPE", "KW_LET", 
			"KW_FUNCTION", "KW_LAMBDA", "KW_WITCH", "KW_WHILE", "KW_FOR", "KW_NEW", 
			"KW_TRY", "KW_MATCH", "KW_CATCH", "KW_WITH", "KW_CASE", "KW_WHEN", "INTEGER", 
			"DECIMAL", "STRING_SINGLE", "STRING_DOUBLE", "KW_IF", "KW_ELSE", "KW_OTHERWISE", 
			"RETURN", "RESUME", "YIELD", "BREAK", "CONTINUE", "RAISE", "SPECIAL", 
			"RAW_ID", "UNICODE_ID", "LINE_COMMENT", "BLOCK_COMMENT", "WHITE_SPACE", 
			"ERROR_CHARACTAR"
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
	public String getGrammarFileName() { return "ValkyrieAntlr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ValkyrieAntlrParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ValkyrieAntlrParser.EOF, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitProgram(this);
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
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 436849163938824520L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 548943155183L) != 0)) {
				{
				{
				setState(206);
				top_statement();
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
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
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public Top_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTop_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTop_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTop_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Top_statementContext top_statement() throws RecognitionException {
		Top_statementContext _localctx = new Top_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_top_statement);
		try {
			setState(230);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				define_namespace();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				import_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
				define_extension();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(217);
				define_class();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(218);
				define_union();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(219);
				define_bitflags();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(220);
				define_trait();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(221);
				define_extends();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(222);
				define_function();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(223);
				define_type();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(224);
				define_variale();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(225);
				if_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(226);
				while_statement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(227);
				for_statement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(228);
				expression(0);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(229);
				eos();
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
		public Define_varialeContext define_variale() {
			return getRuleContext(Define_varialeContext.class,0);
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
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public Function_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFunction_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFunction_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitFunction_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_statementsContext function_statements() throws RecognitionException {
		Function_statementsContext _localctx = new Function_statementsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_function_statements);
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(232);
				define_lambda();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
				define_variale();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(234);
				while_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(235);
				for_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(236);
				expression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(237);
				eos();
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
	public static class EosContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(ValkyrieAntlrParser.SEMICOLON, 0); }
		public EosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitEos(this);
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
		public TerminalNode COMMA() { return getToken(ValkyrieAntlrParser.COMMA, 0); }
		public TerminalNode SEMICOLON() { return getToken(ValkyrieAntlrParser.SEMICOLON, 0); }
		public Eos_freeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eos_free; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEos_free(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEos_free(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitEos_free(this);
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
		public TerminalNode KW_NAMESPACE() { return getToken(ValkyrieAntlrParser.KW_NAMESPACE, 0); }
		public Namepath_freeContext namepath_free() {
			return getRuleContext(Namepath_freeContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public Define_namespaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_namespace; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_namespace(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_namespace(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_namespace(this);
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
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(246);
				eos();
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
	public static class Import_statementContext extends ParserRuleContext {
		public TerminalNode KW_IMPORT() { return getToken(ValkyrieAntlrParser.KW_IMPORT, 0); }
		public Namepath_freeContext namepath_free() {
			return getRuleContext(Namepath_freeContext.class,0);
		}
		public Import_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImport_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImport_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitImport_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_statementContext import_statement() throws RecognitionException {
		Import_statementContext _localctx = new Import_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_import_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(KW_IMPORT);
			setState(250);
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
		public TerminalNode KW_EXTENSION() { return getToken(ValkyrieAntlrParser.KW_EXTENSION, 0); }
		public Define_extensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_extension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_extension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_extension(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_extension(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_extensionContext define_extension() throws RecognitionException {
		Define_extensionContext _localctx = new Define_extensionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_define_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
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
		public TerminalNode KW_CLASS() { return getToken(ValkyrieAntlrParser.KW_CLASS, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_class(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_class(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_class(this);
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
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(254);
				macro_call();
				}
				}
				setState(259);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(260);
			modifiers();
			setState(261);
			match(KW_CLASS);
			setState(262);
			identifier();
			setState(264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4294971408L) != 0)) {
				{
				setState(263);
				define_generic();
				}
			}

			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESES_L) {
				{
				setState(266);
				class_inherit();
				}
			}

			setState(269);
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
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterClass_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitClass_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitClass_block(this);
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
			setState(271);
			match(BRACE_L);
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599627370508L) != 0) || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(272);
				class_statements();
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(278);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterClass_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitClass_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitClass_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_statementsContext class_statements() throws RecognitionException {
		Class_statementsContext _localctx = new Class_statementsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_class_statements);
		try {
			setState(283);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				class_method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(281);
				class_field();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282);
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
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Class_inheritContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_inherit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterClass_inherit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitClass_inherit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitClass_inherit(this);
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
			setState(285);
			match(PARENTHESES_L);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RAW_ID || _la==UNICODE_ID) {
				{
				setState(286);
				namepath();
				}
			}

			setState(289);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterClass_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitClass_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitClass_field(this);
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
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(291);
				macro_call();
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(297);
			modified_identifier();
			setState(299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(298);
				type_hint();
				}
			}

			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(301);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterClass_method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitClass_method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitClass_method(this);
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
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(304);
				macro_call();
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(310);
			modified_namepath();
			setState(311);
			function_parameters();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(312);
				type_hint();
				}
			}

			setState(316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_DIV) {
				{
				setState(315);
				effect_hint();
				}
			}

			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BRACE_L) {
				{
				setState(318);
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
		public TerminalNode KW_TRAIT() { return getToken(ValkyrieAntlrParser.KW_TRAIT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Trait_blockContext trait_block() {
			return getRuleContext(Trait_blockContext.class,0);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public ImplimentsContext impliments() {
			return getRuleContext(ImplimentsContext.class,0);
		}
		public Define_traitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_trait; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_trait(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_trait(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_trait(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_traitContext define_trait() throws RecognitionException {
		Define_traitContext _localctx = new Define_traitContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_define_trait);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
			match(KW_TRAIT);
			setState(322);
			identifier();
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4294971408L) != 0)) {
				{
				setState(323);
				define_generic();
				}
			}

			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==KW_IMPLEMENTS) {
				{
				setState(326);
				impliments();
				}
			}

			setState(329);
			trait_block();
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
	public static class Trait_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Trait_statementsContext> trait_statements() {
			return getRuleContexts(Trait_statementsContext.class);
		}
		public Trait_statementsContext trait_statements(int i) {
			return getRuleContext(Trait_statementsContext.class,i);
		}
		public Trait_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trait_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTrait_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTrait_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTrait_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trait_blockContext trait_block() throws RecognitionException {
		Trait_blockContext _localctx = new Trait_blockContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_trait_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(BRACE_L);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599627370508L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 805306369L) != 0)) {
				{
				{
				setState(332);
				trait_statements();
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
	public static class Trait_statementsContext extends ParserRuleContext {
		public Define_trait_typeContext define_trait_type() {
			return getRuleContext(Define_trait_typeContext.class,0);
		}
		public Class_methodContext class_method() {
			return getRuleContext(Class_methodContext.class,0);
		}
		public Class_fieldContext class_field() {
			return getRuleContext(Class_fieldContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Trait_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trait_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTrait_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTrait_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTrait_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Trait_statementsContext trait_statements() throws RecognitionException {
		Trait_statementsContext _localctx = new Trait_statementsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_trait_statements);
		try {
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340);
				define_trait_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(341);
				class_method();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(342);
				class_field();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(343);
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
	public static class Define_trait_typeContext extends ParserRuleContext {
		public TerminalNode KW_TYPE() { return getToken(ValkyrieAntlrParser.KW_TYPE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Define_trait_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_trait_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_trait_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_trait_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_trait_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_trait_typeContext define_trait_type() throws RecognitionException {
		Define_trait_typeContext _localctx = new Define_trait_typeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_define_trait_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			match(KW_TYPE);
			setState(347);
			identifier();
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(348);
				match(OP_ASSIGN);
				setState(349);
				type_expression(0);
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
	public static class Define_extendsContext extends ParserRuleContext {
		public TerminalNode KW_EXTENDS() { return getToken(ValkyrieAntlrParser.KW_EXTENDS, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Trait_blockContext trait_block() {
			return getRuleContext(Trait_blockContext.class,0);
		}
		public ImplimentsContext impliments() {
			return getRuleContext(ImplimentsContext.class,0);
		}
		public Define_extendsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_extends; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_extends(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_extends(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_extends(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_extendsContext define_extends() throws RecognitionException {
		Define_extendsContext _localctx = new Define_extendsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_define_extends);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(KW_EXTENDS);
			setState(353);
			namepath();
			setState(355);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==KW_IMPLEMENTS) {
				{
				setState(354);
				impliments();
				}
			}

			setState(357);
			trait_block();
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
	public static class ImplimentsContext extends ParserRuleContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public TerminalNode KW_IMPLEMENTS() { return getToken(ValkyrieAntlrParser.KW_IMPLEMENTS, 0); }
		public ImplimentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impliments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImpliments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImpliments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitImpliments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplimentsContext impliments() throws RecognitionException {
		ImplimentsContext _localctx = new ImplimentsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_impliments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			_la = _input.LA(1);
			if ( !(_la==COLON || _la==KW_IMPLEMENTS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(360);
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
	public static class Define_unionContext extends ParserRuleContext {
		public TerminalNode KW_UNION() { return getToken(ValkyrieAntlrParser.KW_UNION, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_union(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_union(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_union(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_unionContext define_union() throws RecognitionException {
		Define_unionContext _localctx = new Define_unionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_define_union);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(KW_UNION);
			setState(363);
			identifier();
			setState(364);
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
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterUnion_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitUnion_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitUnion_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Union_blockContext union_block() throws RecognitionException {
		Union_blockContext _localctx = new Union_blockContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_union_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
			match(BRACE_L);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599627370508L) != 0) || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(367);
				union_statements();
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterUnion_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitUnion_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitUnion_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Union_statementsContext union_statements() throws RecognitionException {
		Union_statementsContext _localctx = new Union_statementsContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_union_statements);
		try {
			setState(378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(375);
				class_method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(376);
				define_variant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(377);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_variant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_variant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_variant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_variantContext define_variant() throws RecognitionException {
		Define_variantContext _localctx = new Define_variantContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_define_variant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			identifier();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BRACE_L) {
				{
				setState(381);
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
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterVariant_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitVariant_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitVariant_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variant_blockContext variant_block() throws RecognitionException {
		Variant_blockContext _localctx = new Variant_blockContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_variant_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(BRACE_L);
			setState(388);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599627370508L) != 0) || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(385);
				variant_statements();
				}
				}
				setState(390);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(391);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterVariant_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitVariant_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitVariant_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Variant_statementsContext variant_statements() throws RecognitionException {
		Variant_statementsContext _localctx = new Variant_statementsContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_variant_statements);
		try {
			setState(395);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_HASH:
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				class_field();
				}
				break;
			case COMMA:
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
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
		public TerminalNode KW_BITFLAGS() { return getToken(ValkyrieAntlrParser.KW_BITFLAGS, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_bitflags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_bitflags(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_bitflags(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_bitflagsContext define_bitflags() throws RecognitionException {
		Define_bitflagsContext _localctx = new Define_bitflagsContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_define_bitflags);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
			match(KW_BITFLAGS);
			setState(398);
			namepath();
			setState(399);
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
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterBitflags_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitBitflags_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitBitflags_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitflags_blockContext bitflags_block() throws RecognitionException {
		Bitflags_blockContext _localctx = new Bitflags_blockContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_bitflags_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(BRACE_L);
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA || _la==SEMICOLON || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(402);
				bitflags_statements();
				}
				}
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(408);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterBitflags_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitBitflags_statements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitBitflags_statements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitflags_statementsContext bitflags_statements() throws RecognitionException {
		Bitflags_statementsContext _localctx = new Bitflags_statementsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_bitflags_statements);
		try {
			setState(412);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				bitflags_item();
				}
				break;
			case COMMA:
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(411);
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
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Bitflags_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitflags_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterBitflags_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitBitflags_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitBitflags_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitflags_itemContext bitflags_item() throws RecognitionException {
		Bitflags_itemContext _localctx = new Bitflags_itemContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_bitflags_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			identifier();
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(415);
				match(OP_ASSIGN);
				setState(416);
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
	public static class Define_functionContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_FUNCTION() { return getToken(ValkyrieAntlrParser.KW_FUNCTION, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_function(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_function(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_functionContext define_function() throws RecognitionException {
		Define_functionContext _localctx = new Define_functionContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_define_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(419);
				macro_call();
				}
				}
				setState(424);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(425);
			modifiers();
			setState(426);
			match(KW_FUNCTION);
			setState(427);
			namepath();
			setState(428);
			function_parameters();
			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(429);
				type_hint();
				}
			}

			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_DIV) {
				{
				setState(432);
				effect_hint();
				}
			}

			setState(435);
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
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public List<Parameter_itemContext> parameter_item() {
			return getRuleContexts(Parameter_itemContext.class);
		}
		public Parameter_itemContext parameter_item(int i) {
			return getRuleContext(Parameter_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public Function_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFunction_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFunction_parameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitFunction_parameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_parametersContext function_parameters() throws RecognitionException {
		Function_parametersContext _localctx = new Function_parametersContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_function_parameters);
		int _la;
		try {
			setState(450);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(437);
				match(PARENTHESES_L);
				setState(438);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(439);
				match(PARENTHESES_L);
				setState(440);
				parameter_item();
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(441);
					match(COMMA);
					setState(442);
					parameter_item();
					}
					}
					setState(447);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(448);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterParameter_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitParameter_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitParameter_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_itemContext parameter_item() throws RecognitionException {
		Parameter_itemContext _localctx = new Parameter_itemContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_parameter_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
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
			modified_identifier();
			setState(460);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(459);
				type_hint();
				}
			}

			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(462);
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
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Parameter_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterParameter_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitParameter_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitParameter_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_defaultContext parameter_default() throws RecognitionException {
		Parameter_defaultContext _localctx = new Parameter_defaultContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_parameter_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			match(OP_ASSIGN);
			setState(466);
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
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
		}
		public TerminalNode OP_THROW() { return getToken(ValkyrieAntlrParser.OP_THROW, 0); }
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFunction_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitFunction_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_function_call);
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
			tuple_call_body();
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
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_THROW() { return getToken(ValkyrieAntlrParser.OP_THROW, 0); }
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
		}
		public Dot_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDot_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDot_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDot_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dot_callContext dot_call() throws RecognitionException {
		Dot_callContext _localctx = new Dot_callContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_dot_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_THROW) {
				{
				setState(473);
				match(OP_THROW);
				}
			}

			setState(476);
			match(DOT);
			setState(477);
			identifier();
			setState(479);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(478);
				tuple_call_body();
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
	public static class Tuple_call_bodyContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public List<Tuple_call_itemContext> tuple_call_item() {
			return getRuleContexts(Tuple_call_itemContext.class);
		}
		public Tuple_call_itemContext tuple_call_item(int i) {
			return getRuleContext(Tuple_call_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public Tuple_call_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple_call_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTuple_call_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTuple_call_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTuple_call_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tuple_call_bodyContext tuple_call_body() throws RecognitionException {
		Tuple_call_bodyContext _localctx = new Tuple_call_bodyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_tuple_call_body);
		int _la;
		try {
			int _alt;
			setState(497);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(481);
				match(PARENTHESES_L);
				setState(482);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(483);
				match(PARENTHESES_L);
				setState(484);
				tuple_call_item();
				setState(489);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(485);
						match(COMMA);
						setState(486);
						tuple_call_item();
						}
						} 
					}
					setState(491);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
				}
				setState(493);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(492);
					match(COMMA);
					}
				}

				setState(495);
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
	public static class Tuple_call_itemContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Tuple_call_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple_call_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTuple_call_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTuple_call_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTuple_call_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tuple_call_itemContext tuple_call_item() throws RecognitionException {
		Tuple_call_itemContext _localctx = new Tuple_call_itemContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_tuple_call_item);
		try {
			setState(504);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(499);
				identifier();
				setState(500);
				match(COLON);
				setState(501);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(503);
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
	public static class Define_lambdaContext extends ParserRuleContext {
		public TerminalNode KW_LAMBDA() { return getToken(ValkyrieAntlrParser.KW_LAMBDA, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_lambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_lambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_lambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_lambdaContext define_lambda() throws RecognitionException {
		Define_lambdaContext _localctx = new Define_lambdaContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_define_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(506);
				macro_call();
				}
				}
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(512);
			match(KW_LAMBDA);
			setState(513);
			function_parameters();
			setState(515);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(514);
				type_hint();
				}
			}

			setState(518);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_DIV) {
				{
				setState(517);
				effect_hint();
				}
			}

			setState(520);
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
		public TerminalNode OP_THROW() { return getToken(ValkyrieAntlrParser.OP_THROW, 0); }
		public Lambda_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLambda_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLambda_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitLambda_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_callContext lambda_call() throws RecognitionException {
		Lambda_callContext _localctx = new Lambda_callContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_lambda_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_THROW) {
				{
				setState(522);
				match(OP_THROW);
				}
			}

			setState(525);
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
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFunction_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFunction_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitFunction_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_blockContext function_block() throws RecognitionException {
		Function_blockContext _localctx = new Function_blockContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_function_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(BRACE_L);
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 436849163938824520L) != 0) || ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & 536077301L) != 0)) {
				{
				{
				setState(528);
				function_statements();
				}
				}
				setState(533);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(534);
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
		public TerminalNode KW_LET() { return getToken(ValkyrieAntlrParser.KW_LET, 0); }
		public Define_variale_lhsContext define_variale_lhs() {
			return getRuleContext(Define_variale_lhsContext.class,0);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Define_varialeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_variale; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_variale(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_variale(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_variale(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_varialeContext define_variale() throws RecognitionException {
		Define_varialeContext _localctx = new Define_varialeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_define_variale);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(536);
			match(KW_LET);
			setState(537);
			define_variale_lhs();
			setState(539);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(538);
				type_hint();
				}
			}

			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(541);
				match(OP_ASSIGN);
				setState(542);
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
	public static class Define_variale_lhsContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public List<Let_parameterContext> let_parameter() {
			return getRuleContexts(Let_parameterContext.class);
		}
		public Let_parameterContext let_parameter(int i) {
			return getRuleContext(Let_parameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public Case_tupleContext case_tuple() {
			return getRuleContext(Case_tupleContext.class,0);
		}
		public TerminalNode KW_CASE() { return getToken(ValkyrieAntlrParser.KW_CASE, 0); }
		public Define_variale_lhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_variale_lhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_variale_lhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_variale_lhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_variale_lhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_variale_lhsContext define_variale_lhs() throws RecognitionException {
		Define_variale_lhsContext _localctx = new Define_variale_lhsContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_define_variale_lhs);
		int _la;
		try {
			int _alt;
			setState(582);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(545);
				match(PARENTHESES_L);
				setState(546);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(547);
				match(PARENTHESES_L);
				setState(548);
				let_parameter();
				setState(553);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(549);
						match(COMMA);
						setState(550);
						let_parameter();
						}
						} 
					}
					setState(555);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				}
				setState(557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(556);
					match(COMMA);
					}
				}

				setState(559);
				match(PARENTHESES_R);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(561);
				match(BRACKET_L);
				setState(562);
				match(BRACKET_R);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(563);
				match(BRACKET_L);
				setState(564);
				let_parameter();
				setState(569);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(565);
						match(COMMA);
						setState(566);
						let_parameter();
						}
						} 
					}
					setState(571);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
				}
				setState(573);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(572);
					match(COMMA);
					}
				}

				setState(575);
				match(BRACKET_R);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(577);
				let_parameter();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_CASE) {
					{
					setState(578);
					match(KW_CASE);
					}
				}

				setState(581);
				case_tuple();
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
	public static class Let_parameterContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Let_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLet_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLet_parameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitLet_parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_parameterContext let_parameter() throws RecognitionException {
		Let_parameterContext _localctx = new Let_parameterContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_let_parameter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(585); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(584);
					identifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(587); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,59,_ctx);
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
	public static class Define_typeContext extends ParserRuleContext {
		public TerminalNode KW_TYPE() { return getToken(ValkyrieAntlrParser.KW_TYPE, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public Define_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_typeContext define_type() throws RecognitionException {
		Define_typeContext _localctx = new Define_typeContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_define_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(KW_TYPE);
			setState(590);
			identifier();
			setState(591);
			match(OP_ASSIGN);
			setState(592);
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
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public TerminalNode OP_ARROW() { return getToken(ValkyrieAntlrParser.OP_ARROW, 0); }
		public Type_hintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_hint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterType_hint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitType_hint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitType_hint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_hintContext type_hint() throws RecognitionException {
		Type_hintContext _localctx = new Type_hintContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_type_hint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(594);
			_la = _input.LA(1);
			if ( !(_la==COLON || _la==OP_ARROW) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(595);
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
		public TerminalNode OP_DIV() { return getToken(ValkyrieAntlrParser.OP_DIV, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Effect_hintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effect_hint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEffect_hint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEffect_hint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitEffect_hint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Effect_hintContext effect_hint() throws RecognitionException {
		Effect_hintContext _localctx = new Effect_hintContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_effect_hint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(597);
			match(OP_DIV);
			setState(598);
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
		public TerminalNode KW_IF() { return getToken(ValkyrieAntlrParser.KW_IF, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_if_statement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			match(KW_IF);
			setState(601);
			inline_expression(0);
			setState(602);
			function_block();
			setState(606);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(603);
					else_if_statement();
					}
					} 
				}
				setState(608);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
			}
			setState(610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				{
				setState(609);
				else_statement();
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
	public static class Else_if_statementContext extends ParserRuleContext {
		public TerminalNode KW_ELSE() { return getToken(ValkyrieAntlrParser.KW_ELSE, 0); }
		public TerminalNode KW_IF() { return getToken(ValkyrieAntlrParser.KW_IF, 0); }
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterElse_if_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitElse_if_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitElse_if_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_if_statementContext else_if_statement() throws RecognitionException {
		Else_if_statementContext _localctx = new Else_if_statementContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_else_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			match(KW_ELSE);
			setState(613);
			match(KW_IF);
			setState(614);
			inline_expression(0);
			setState(615);
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
		public TerminalNode KW_ELSE() { return getToken(ValkyrieAntlrParser.KW_ELSE, 0); }
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public Else_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterElse_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitElse_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitElse_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_statementContext else_statement() throws RecognitionException {
		Else_statementContext _localctx = new Else_statementContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_else_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			match(KW_ELSE);
			setState(618);
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
		public TerminalNode KW_WHILE() { return getToken(ValkyrieAntlrParser.KW_WHILE, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
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
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterWhile_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitWhile_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitWhile_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_while_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(623);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(620);
				macro_call();
				}
				}
				setState(625);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(626);
			match(KW_WHILE);
			setState(627);
			inline_expression(0);
			setState(628);
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
		public TerminalNode KW_FOR() { return getToken(ValkyrieAntlrParser.KW_FOR, 0); }
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
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public If_guardContext if_guard() {
			return getRuleContext(If_guardContext.class,0);
		}
		public For_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFor_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFor_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitFor_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(630);
				macro_call();
				}
				}
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(636);
			match(KW_FOR);
			setState(637);
			for_pattern();
			setState(638);
			infix_in();
			setState(639);
			inline_expression(0);
			setState(641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_IF) {
				{
				setState(640);
				if_guard();
				}
			}

			setState(643);
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
		public Case_tupleContext case_tuple() {
			return getRuleContext(Case_tupleContext.class,0);
		}
		public TerminalNode KW_CASE() { return getToken(ValkyrieAntlrParser.KW_CASE, 0); }
		public List<Let_parameterContext> let_parameter() {
			return getRuleContexts(Let_parameterContext.class);
		}
		public Let_parameterContext let_parameter(int i) {
			return getRuleContext(Let_parameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public For_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFor_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFor_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitFor_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_patternContext for_pattern() throws RecognitionException {
		For_patternContext _localctx = new For_patternContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_for_pattern);
		int _la;
		try {
			int _alt;
			setState(674);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_CASE) {
					{
					setState(645);
					match(KW_CASE);
					}
				}

				setState(648);
				case_tuple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(649);
				let_parameter();
				setState(654);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(650);
						match(COMMA);
						setState(651);
						let_parameter();
						}
						} 
					}
					setState(656);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
				}
				setState(658);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(657);
					match(COMMA);
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(660);
				match(PARENTHESES_L);
				setState(661);
				let_parameter();
				setState(666);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(662);
						match(COMMA);
						setState(663);
						let_parameter();
						}
						} 
					}
					setState(668);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,68,_ctx);
				}
				setState(670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(669);
					match(COMMA);
					}
				}

				setState(672);
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
	public static class If_guardContext extends ParserRuleContext {
		public TerminalNode KW_IF() { return getToken(ValkyrieAntlrParser.KW_IF, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public If_guardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_guard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIf_guard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIf_guard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitIf_guard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_guardContext if_guard() throws RecognitionException {
		If_guardContext _localctx = new If_guardContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_if_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(676);
			match(KW_IF);
			setState(677);
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
		public Op_assignContext op_assign() {
			return getRuleContext(Op_assignContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitExpression(this);
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
		int _startState = 108;
		enterRecursionRule(_localctx, 108, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
			case RESUME:
			case YIELD:
			case BREAK:
			case CONTINUE:
			case RAISE:
				{
				setState(680);
				control_expression();
				}
				break;
			case OP_ADD:
			case OP_SUB:
			case OP_NOT:
				{
				setState(681);
				prefix_call();
				setState(682);
				expression(2);
				}
				break;
			case PARENTHESES_L:
			case BRACKET_L:
			case OP_HASH:
			case OP_THROW:
			case KW_NEW:
			case KW_TRY:
			case KW_MATCH:
			case KW_CATCH:
			case INTEGER:
			case DECIMAL:
			case STRING_SINGLE:
			case STRING_DOUBLE:
			case KW_IF:
			case SPECIAL:
			case RAW_ID:
			case UNICODE_ID:
				{
				setState(684);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(715);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(713);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(687);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(688);
						op_multiple();
						setState(689);
						expression(10);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(691);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(692);
						op_plus();
						setState(693);
						expression(9);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(695);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(696);
						op_logic();
						setState(697);
						expression(8);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(699);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(700);
						op_compare();
						setState(701);
						expression(7);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(703);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(704);
						suffix_call();
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(705);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(706);
						infix_is();
						setState(707);
						type_expression(0);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(709);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(710);
						op_assign();
						setState(711);
						type_expression(0);
						}
						break;
					}
					} 
				}
				setState(717);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,73,_ctx);
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
		public Dot_callContext dot_call() {
			return getRuleContext(Dot_callContext.class,0);
		}
		public Inline_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInline_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInline_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitInline_expression(this);
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
		int _startState = 110;
		enterRecursionRule(_localctx, 110, RULE_inline_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(723);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_ADD:
			case OP_SUB:
			case OP_NOT:
				{
				setState(719);
				prefix_call();
				setState(720);
				inline_expression(2);
				}
				break;
			case PARENTHESES_L:
			case BRACKET_L:
			case OP_HASH:
			case OP_THROW:
			case KW_NEW:
			case KW_TRY:
			case KW_MATCH:
			case KW_CATCH:
			case INTEGER:
			case DECIMAL:
			case STRING_SINGLE:
			case STRING_DOUBLE:
			case KW_IF:
			case SPECIAL:
			case RAW_ID:
			case UNICODE_ID:
				{
				setState(722);
				term();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(749);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(747);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
					case 1:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(725);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(726);
						op_multiple();
						setState(727);
						inline_expression(8);
						}
						break;
					case 2:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(729);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(730);
						op_plus();
						setState(731);
						inline_expression(7);
						}
						break;
					case 3:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(733);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(734);
						op_logic();
						setState(735);
						inline_expression(6);
						}
						break;
					case 4:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(737);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(738);
						op_compare();
						setState(739);
						inline_expression(5);
						}
						break;
					case 5:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(741);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(742);
						infix_is();
						setState(743);
						inline_expression(4);
						}
						break;
					case 6:
						{
						_localctx = new Inline_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(745);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(746);
						dot_call();
						}
						break;
					}
					} 
				}
				setState(751);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
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
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Generic_call_in_typeContext generic_call_in_type() {
			return getRuleContext(Generic_call_in_typeContext.class,0);
		}
		public TParensContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTParens(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTParens(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTParens(this);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTTerm(this);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTPattern(this);
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
		int _startState = 112;
		enterRecursionRule(_localctx, 112, RULE_type_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TTermContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(753);
			term();
			}
			_ctx.stop = _input.LT(-1);
			setState(763);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(761);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
					case 1:
						{
						_localctx = new TPatternContext(new Type_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
						setState(755);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(756);
						op_pattern();
						setState(757);
						type_expression(4);
						}
						break;
					case 2:
						{
						_localctx = new TParensContext(new Type_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
						setState(759);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(760);
						generic_call_in_type();
						}
						break;
					}
					} 
				}
				setState(765);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,78,_ctx);
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
		public TerminalNode OP_NOT() { return getToken(ValkyrieAntlrParser.OP_NOT, 0); }
		public TerminalNode OP_ADD() { return getToken(ValkyrieAntlrParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(ValkyrieAntlrParser.OP_SUB, 0); }
		public Prefix_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterPrefix_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitPrefix_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitPrefix_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Prefix_callContext prefix_call() throws RecognitionException {
		Prefix_callContext _localctx = new Prefix_callContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_prefix_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(766);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 288230376235597824L) != 0)) ) {
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
		public TerminalNode OP_NOT() { return getToken(ValkyrieAntlrParser.OP_NOT, 0); }
		public TerminalNode OP_TEMPERATURE() { return getToken(ValkyrieAntlrParser.OP_TEMPERATURE, 0); }
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
		public Match_callContext match_call() {
			return getRuleContext(Match_callContext.class,0);
		}
		public Catch_callContext catch_call() {
			return getRuleContext(Catch_callContext.class,0);
		}
		public Dot_callContext dot_call() {
			return getRuleContext(Dot_callContext.class,0);
		}
		public Suffix_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_suffix_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterSuffix_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitSuffix_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitSuffix_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Suffix_callContext suffix_call() throws RecognitionException {
		Suffix_callContext _localctx = new Suffix_callContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_suffix_call);
		try {
			setState(778);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,79,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(768);
				match(OP_NOT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(769);
				match(OP_TEMPERATURE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(770);
				slice_call();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(771);
				offset_call();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(772);
				generic_call();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(773);
				lambda_call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(774);
				match_call();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(775);
				catch_call();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(776);
				dot_call();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(777);
				dot_call();
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
		public TerminalNode RETURN() { return getToken(ValkyrieAntlrParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RESUME() { return getToken(ValkyrieAntlrParser.RESUME, 0); }
		public TerminalNode BREAK() { return getToken(ValkyrieAntlrParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(ValkyrieAntlrParser.CONTINUE, 0); }
		public TerminalNode RAISE() { return getToken(ValkyrieAntlrParser.RAISE, 0); }
		public TerminalNode YIELD() { return getToken(ValkyrieAntlrParser.YIELD, 0); }
		public TerminalNode KW_WITH() { return getToken(ValkyrieAntlrParser.KW_WITH, 0); }
		public Control_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterControl_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitControl_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitControl_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Control_expressionContext control_expression() throws RecognitionException {
		Control_expressionContext _localctx = new Control_expressionContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_control_expression);
		try {
			setState(802);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,83,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(780);
				match(RETURN);
				setState(782);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
				case 1:
					{
					setState(781);
					expression(0);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(784);
				match(RESUME);
				setState(785);
				expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(786);
				match(BREAK);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(787);
				match(CONTINUE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(788);
				match(RAISE);
				setState(789);
				expression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(790);
				match(YIELD);
				setState(792);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,81,_ctx) ) {
				case 1:
					{
					setState(791);
					match(RETURN);
					}
					break;
				}
				setState(795);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
				case 1:
					{
					setState(794);
					expression(0);
					}
					break;
				}
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(797);
				match(YIELD);
				setState(798);
				match(BREAK);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(799);
				match(YIELD);
				setState(800);
				match(KW_WITH);
				setState(801);
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
		public Try_statementContext try_statement() {
			return getRuleContext(Try_statementContext.class,0);
		}
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public Match_statementContext match_statement() {
			return getRuleContext(Match_statementContext.class,0);
		}
		public Catch_statementContext catch_statement() {
			return getRuleContext(Catch_statementContext.class,0);
		}
		public New_callContext new_call() {
			return getRuleContext(New_callContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public Number_literalContext number_literal() {
			return getRuleContext(Number_literalContext.class,0);
		}
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public TerminalNode SPECIAL() { return getToken(ValkyrieAntlrParser.SPECIAL, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_term);
		try {
			setState(822);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,84,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(804);
				try_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(805);
				if_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(806);
				match_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(807);
				catch_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(808);
				new_call();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(809);
				function_call();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(810);
				string_literal();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(811);
				number_literal();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(812);
				namepath();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(813);
				match(PARENTHESES_L);
				setState(814);
				expression(0);
				setState(815);
				match(PARENTHESES_R);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(817);
				match(BRACKET_L);
				setState(818);
				expression(0);
				setState(819);
				match(BRACKET_R);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(821);
				match(SPECIAL);
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
	public static class Op_compareContext extends ParserRuleContext {
		public TerminalNode OP_LT() { return getToken(ValkyrieAntlrParser.OP_LT, 0); }
		public TerminalNode OP_LEQ() { return getToken(ValkyrieAntlrParser.OP_LEQ, 0); }
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
		public TerminalNode OP_GEQ() { return getToken(ValkyrieAntlrParser.OP_GEQ, 0); }
		public TerminalNode OP_EQ() { return getToken(ValkyrieAntlrParser.OP_EQ, 0); }
		public TerminalNode OP_NE() { return getToken(ValkyrieAntlrParser.OP_NE, 0); }
		public Op_compareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_compare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_compare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_compare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitOp_compare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_compareContext op_compare() throws RecognitionException {
		Op_compareContext _localctx = new Op_compareContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_op_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(824);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 660351221760L) != 0)) ) {
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
		public TerminalNode OP_AND() { return getToken(ValkyrieAntlrParser.OP_AND, 0); }
		public TerminalNode OP_OR() { return getToken(ValkyrieAntlrParser.OP_OR, 0); }
		public Op_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitOp_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_patternContext op_pattern() throws RecognitionException {
		Op_patternContext _localctx = new Op_patternContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_op_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(826);
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
		public TerminalNode OP_MUL() { return getToken(ValkyrieAntlrParser.OP_MUL, 0); }
		public TerminalNode OP_DIV() { return getToken(ValkyrieAntlrParser.OP_DIV, 0); }
		public Op_multipleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_multiple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_multiple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_multiple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitOp_multiple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_multipleContext op_multiple() throws RecognitionException {
		Op_multipleContext _localctx = new Op_multipleContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_op_multiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(828);
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
		public TerminalNode OP_ADD() { return getToken(ValkyrieAntlrParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(ValkyrieAntlrParser.OP_SUB, 0); }
		public Op_plusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_plus; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_plus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_plus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitOp_plus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_plusContext op_plus() throws RecognitionException {
		Op_plusContext _localctx = new Op_plusContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_op_plus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(830);
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
		public TerminalNode LOGIC_OR() { return getToken(ValkyrieAntlrParser.LOGIC_OR, 0); }
		public TerminalNode LOGIC_AND() { return getToken(ValkyrieAntlrParser.LOGIC_AND, 0); }
		public Op_logicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_logic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_logic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_logic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitOp_logic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_logicContext op_logic() throws RecognitionException {
		Op_logicContext _localctx = new Op_logicContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_op_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(832);
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
	public static class Op_assignContext extends ParserRuleContext {
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public TerminalNode OP_ADD_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ADD_ASSIGN, 0); }
		public TerminalNode OP_SUB_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_SUB_ASSIGN, 0); }
		public TerminalNode OP_MUL_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_MUL_ASSIGN, 0); }
		public TerminalNode OP_DIV_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_DIV_ASSIGN, 0); }
		public Op_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_assign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitOp_assign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_assignContext op_assign() throws RecognitionException {
		Op_assignContext _localctx = new Op_assignContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_op_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(834);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 136339441844224L) != 0)) ) {
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
		public TerminalNode KW_IS() { return getToken(ValkyrieAntlrParser.KW_IS, 0); }
		public TerminalNode KW_NOT() { return getToken(ValkyrieAntlrParser.KW_NOT, 0); }
		public Infix_isContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_is; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInfix_is(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInfix_is(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitInfix_is(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Infix_isContext infix_is() throws RecognitionException {
		Infix_isContext _localctx = new Infix_isContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_infix_is);
		try {
			setState(839);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(836);
				match(KW_IS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(837);
				match(KW_IS);
				setState(838);
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
		public TerminalNode KW_IN() { return getToken(ValkyrieAntlrParser.KW_IN, 0); }
		public TerminalNode OP_IN() { return getToken(ValkyrieAntlrParser.OP_IN, 0); }
		public Infix_inContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_in; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInfix_in(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInfix_in(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitInfix_in(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Infix_inContext infix_in() throws RecognitionException {
		Infix_inContext _localctx = new Infix_inContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_infix_in);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
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
	public static class Define_genericContext extends ParserRuleContext {
		public TerminalNode OP_LT() { return getToken(ValkyrieAntlrParser.OP_LT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
		public TerminalNode GENERIC_L() { return getToken(ValkyrieAntlrParser.GENERIC_L, 0); }
		public TerminalNode GENERIC_R() { return getToken(ValkyrieAntlrParser.GENERIC_R, 0); }
		public Define_genericContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_generic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_generic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_generic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitDefine_generic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Define_genericContext define_generic() throws RecognitionException {
		Define_genericContext _localctx = new Define_genericContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_define_generic);
		int _la;
		try {
			setState(854);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PROPORTION:
			case OP_LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(844);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_PROPORTION) {
					{
					setState(843);
					match(OP_PROPORTION);
					}
				}

				setState(846);
				match(OP_LT);
				setState(847);
				identifier();
				setState(848);
				match(OP_GT);
				}
				break;
			case GENERIC_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(850);
				match(GENERIC_L);
				setState(851);
				identifier();
				setState(852);
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
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
		public TerminalNode OP_LT() { return getToken(ValkyrieAntlrParser.OP_LT, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
		public TerminalNode GENERIC_L() { return getToken(ValkyrieAntlrParser.GENERIC_L, 0); }
		public TerminalNode GENERIC_R() { return getToken(ValkyrieAntlrParser.GENERIC_R, 0); }
		public Generic_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterGeneric_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitGeneric_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitGeneric_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Generic_callContext generic_call() throws RecognitionException {
		Generic_callContext _localctx = new Generic_callContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_generic_call);
		try {
			setState(865);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PROPORTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(856);
				match(OP_PROPORTION);
				setState(857);
				match(OP_LT);
				setState(858);
				type_expression(0);
				setState(859);
				match(OP_GT);
				}
				break;
			case GENERIC_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(861);
				match(GENERIC_L);
				setState(862);
				type_expression(0);
				setState(863);
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
	public static class Generic_call_in_typeContext extends ParserRuleContext {
		public TerminalNode OP_LT() { return getToken(ValkyrieAntlrParser.OP_LT, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
		public TerminalNode GENERIC_L() { return getToken(ValkyrieAntlrParser.GENERIC_L, 0); }
		public TerminalNode GENERIC_R() { return getToken(ValkyrieAntlrParser.GENERIC_R, 0); }
		public Generic_call_in_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_call_in_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterGeneric_call_in_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitGeneric_call_in_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitGeneric_call_in_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Generic_call_in_typeContext generic_call_in_type() throws RecognitionException {
		Generic_call_in_typeContext _localctx = new Generic_call_in_typeContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_generic_call_in_type);
		int _la;
		try {
			setState(878);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PROPORTION:
			case OP_LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(868);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_PROPORTION) {
					{
					setState(867);
					match(OP_PROPORTION);
					}
				}

				setState(870);
				match(OP_LT);
				setState(871);
				type_expression(0);
				setState(872);
				match(OP_GT);
				}
				break;
			case GENERIC_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(874);
				match(GENERIC_L);
				setState(875);
				type_expression(0);
				setState(876);
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
	public static class Slice_callContext extends ParserRuleContext {
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public Slice_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterSlice_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitSlice_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitSlice_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Slice_callContext slice_call() throws RecognitionException {
		Slice_callContext _localctx = new Slice_callContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_slice_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(880);
			match(BRACKET_L);
			setState(881);
			expression(0);
			setState(882);
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
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public TerminalNode OFFSET_L() { return getToken(ValkyrieAntlrParser.OFFSET_L, 0); }
		public TerminalNode OFFSET_R() { return getToken(ValkyrieAntlrParser.OFFSET_R, 0); }
		public Offset_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOffset_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOffset_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitOffset_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Offset_callContext offset_call() throws RecognitionException {
		Offset_callContext _localctx = new Offset_callContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_offset_call);
		try {
			setState(893);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PROPORTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(884);
				match(OP_PROPORTION);
				setState(885);
				match(BRACKET_L);
				setState(886);
				expression(0);
				setState(887);
				match(BRACKET_R);
				}
				break;
			case OFFSET_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(889);
				match(OFFSET_L);
				setState(890);
				expression(0);
				setState(891);
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
		public TerminalNode OP_HASH() { return getToken(ValkyrieAntlrParser.OP_HASH, 0); }
		public List<Macro_call_itemContext> macro_call_item() {
			return getRuleContexts(Macro_call_itemContext.class);
		}
		public Macro_call_itemContext macro_call_item(int i) {
			return getRuleContext(Macro_call_itemContext.class,i);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public Macro_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMacro_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMacro_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitMacro_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Macro_callContext macro_call() throws RecognitionException {
		Macro_callContext _localctx = new Macro_callContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_macro_call);
		int _la;
		try {
			setState(909);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(895);
				match(OP_HASH);
				setState(896);
				macro_call_item();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(897);
				match(OP_HASH);
				setState(898);
				match(BRACKET_L);
				setState(899);
				macro_call_item();
				setState(904);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(900);
					match(COMMA);
					setState(901);
					macro_call_item();
					}
					}
					setState(906);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(907);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMacro_call_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMacro_call_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitMacro_call_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Macro_call_itemContext macro_call_item() throws RecognitionException {
		Macro_call_itemContext _localctx = new Macro_call_itemContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_macro_call_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(911);
			namepath();
			setState(913);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESES_L) {
				{
				setState(912);
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
	public static class Try_statementContext extends ParserRuleContext {
		public TerminalNode KW_TRY() { return getToken(ValkyrieAntlrParser.KW_TRY, 0); }
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Try_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_try_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTry_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTry_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitTry_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Try_statementContext try_statement() throws RecognitionException {
		Try_statementContext _localctx = new Try_statementContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_try_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(915);
			match(KW_TRY);
			setState(917);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 148618787703226688L) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 7344015L) != 0)) {
				{
				setState(916);
				type_expression(0);
				}
			}

			setState(919);
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
	public static class Match_statementContext extends ParserRuleContext {
		public TerminalNode KW_MATCH() { return getToken(ValkyrieAntlrParser.KW_MATCH, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Match_blockContext match_block() {
			return getRuleContext(Match_blockContext.class,0);
		}
		public Match_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatch_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitMatch_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Match_statementContext match_statement() throws RecognitionException {
		Match_statementContext _localctx = new Match_statementContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_match_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(921);
			match(KW_MATCH);
			setState(922);
			inline_expression(0);
			setState(923);
			match_block();
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
	public static class Catch_statementContext extends ParserRuleContext {
		public TerminalNode KW_CATCH() { return getToken(ValkyrieAntlrParser.KW_CATCH, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Match_blockContext match_block() {
			return getRuleContext(Match_blockContext.class,0);
		}
		public Catch_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCatch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCatch_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitCatch_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Catch_statementContext catch_statement() throws RecognitionException {
		Catch_statementContext _localctx = new Catch_statementContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_catch_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925);
			match(KW_CATCH);
			setState(926);
			inline_expression(0);
			setState(927);
			match_block();
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
	public static class Match_callContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public TerminalNode KW_MATCH() { return getToken(ValkyrieAntlrParser.KW_MATCH, 0); }
		public Match_blockContext match_block() {
			return getRuleContext(Match_blockContext.class,0);
		}
		public TerminalNode OP_THROW() { return getToken(ValkyrieAntlrParser.OP_THROW, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Match_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatch_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatch_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitMatch_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Match_callContext match_call() throws RecognitionException {
		Match_callContext _localctx = new Match_callContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_match_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(930);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_THROW) {
				{
				setState(929);
				match(OP_THROW);
				}
			}

			setState(932);
			match(DOT);
			setState(933);
			match(KW_MATCH);
			setState(935);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 148618787703226688L) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 7344015L) != 0)) {
				{
				setState(934);
				type_expression(0);
				}
			}

			setState(937);
			match_block();
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
	public static class Catch_callContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public TerminalNode KW_CATCH() { return getToken(ValkyrieAntlrParser.KW_CATCH, 0); }
		public Match_blockContext match_block() {
			return getRuleContext(Match_blockContext.class,0);
		}
		public TerminalNode OP_THROW() { return getToken(ValkyrieAntlrParser.OP_THROW, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Catch_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catch_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCatch_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCatch_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitCatch_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Catch_callContext catch_call() throws RecognitionException {
		Catch_callContext _localctx = new Catch_callContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_catch_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(940);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_THROW) {
				{
				setState(939);
				match(OP_THROW);
				}
			}

			setState(942);
			match(DOT);
			setState(943);
			match(KW_CATCH);
			setState(945);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 148618787703226688L) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 7344015L) != 0)) {
				{
				setState(944);
				type_expression(0);
				}
			}

			setState(947);
			match_block();
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
	public static class Match_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Match_termsContext> match_terms() {
			return getRuleContexts(Match_termsContext.class);
		}
		public Match_termsContext match_terms(int i) {
			return getRuleContext(Match_termsContext.class,i);
		}
		public Match_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatch_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatch_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitMatch_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Match_blockContext match_block() throws RecognitionException {
		Match_blockContext _localctx = new Match_blockContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_match_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949);
			match(BRACE_L);
			setState(953);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599627370508L) != 0) || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 131L) != 0)) {
				{
				{
				setState(950);
				match_terms();
				}
				}
				setState(955);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(956);
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
	public static class Match_termsContext extends ParserRuleContext {
		public When_blockContext when_block() {
			return getRuleContext(When_blockContext.class,0);
		}
		public Else_patternContext else_pattern() {
			return getRuleContext(Else_patternContext.class,0);
		}
		public Case_patternContext case_pattern() {
			return getRuleContext(Case_patternContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Match_termsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatch_terms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatch_terms(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitMatch_terms(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Match_termsContext match_terms() throws RecognitionException {
		Match_termsContext _localctx = new Match_termsContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_match_terms);
		try {
			setState(962);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(958);
				when_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(959);
				else_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(960);
				case_pattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(961);
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
	public static class With_blockContext extends ParserRuleContext {
		public TerminalNode KW_WITH() { return getToken(ValkyrieAntlrParser.KW_WITH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public With_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterWith_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitWith_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitWith_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final With_blockContext with_block() throws RecognitionException {
		With_blockContext _localctx = new With_blockContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_with_block);
		int _la;
		try {
			setState(978);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,104,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(967);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(964);
					macro_call();
					}
					}
					setState(969);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(970);
				match(KW_WITH);
				setState(971);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(972);
				match(KW_WITH);
				setState(973);
				match(BRACKET_L);
				setState(975);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(974);
					identifier();
					}
				}

				setState(977);
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
	public static class When_blockContext extends ParserRuleContext {
		public TerminalNode KW_WHEN() { return getToken(ValkyrieAntlrParser.KW_WHEN, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public When_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_when_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterWhen_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitWhen_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitWhen_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final When_blockContext when_block() throws RecognitionException {
		When_blockContext _localctx = new When_blockContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_when_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(983);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(980);
				macro_call();
				}
				}
				setState(985);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(986);
			match(KW_WHEN);
			setState(987);
			inline_expression(0);
			setState(988);
			match(COLON);
			setState(992);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(989);
					expression(0);
					}
					} 
				}
				setState(994);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
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
	public static class Else_patternContext extends ParserRuleContext {
		public TerminalNode KW_ELSE() { return getToken(ValkyrieAntlrParser.KW_ELSE, 0); }
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Else_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterElse_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitElse_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitElse_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_patternContext else_pattern() throws RecognitionException {
		Else_patternContext _localctx = new Else_patternContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_else_pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(998);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(995);
				macro_call();
				}
				}
				setState(1000);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1001);
			match(KW_ELSE);
			setState(1002);
			match(COLON);
			setState(1006);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1003);
					expression(0);
					}
					} 
				}
				setState(1008);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
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
	public static class Case_patternContext extends ParserRuleContext {
		public TerminalNode KW_CASE() { return getToken(ValkyrieAntlrParser.KW_CASE, 0); }
		public Case_tupleContext case_tuple() {
			return getRuleContext(Case_tupleContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public If_guardContext if_guard() {
			return getRuleContext(If_guardContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Case_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCase_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCase_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitCase_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_patternContext case_pattern() throws RecognitionException {
		Case_patternContext _localctx = new Case_patternContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_case_pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1012);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1009);
				macro_call();
				}
				}
				setState(1014);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1015);
			match(KW_CASE);
			setState(1016);
			case_tuple();
			setState(1018);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_IF) {
				{
				setState(1017);
				if_guard();
				}
			}

			setState(1020);
			match(COLON);
			setState(1024);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1021);
					expression(0);
					}
					} 
				}
				setState(1026);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,111,_ctx);
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
	public static class Case_tupleContext extends ParserRuleContext {
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public List<Case_termContext> case_term() {
			return getRuleContexts(Case_termContext.class);
		}
		public Case_termContext case_term(int i) {
			return getRuleContext(Case_termContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public Case_tupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCase_tuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCase_tuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitCase_tuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_tupleContext case_tuple() throws RecognitionException {
		Case_tupleContext _localctx = new Case_tupleContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_case_tuple);
		int _la;
		try {
			int _alt;
			setState(1046);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1027);
				namepath();
				setState(1028);
				match(PARENTHESES_L);
				setState(1029);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1031);
				namepath();
				setState(1032);
				match(PARENTHESES_L);
				setState(1033);
				case_term();
				setState(1038);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1034);
						match(COMMA);
						setState(1035);
						case_term();
						}
						} 
					}
					setState(1040);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,112,_ctx);
				}
				setState(1042);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1041);
					match(COMMA);
					}
				}

				setState(1044);
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
	public static class Case_termContext extends ParserRuleContext {
		public Case_tupleContext case_tuple() {
			return getRuleContext(Case_tupleContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Case_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCase_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCase_term(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitCase_term(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_termContext case_term() throws RecognitionException {
		Case_termContext _localctx = new Case_termContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_case_term);
		try {
			setState(1050);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1048);
				case_tuple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1049);
				identifier();
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
	public static class New_callContext extends ParserRuleContext {
		public TerminalNode KW_NEW() { return getToken(ValkyrieAntlrParser.KW_NEW, 0); }
		public Modified_namepathContext modified_namepath() {
			return getRuleContext(Modified_namepathContext.class,0);
		}
		public New_bodyContext new_body() {
			return getRuleContext(New_bodyContext.class,0);
		}
		public List<Macro_callContext> macro_call() {
			return getRuleContexts(Macro_callContext.class);
		}
		public Macro_callContext macro_call(int i) {
			return getRuleContext(Macro_callContext.class,i);
		}
		public Generic_call_in_typeContext generic_call_in_type() {
			return getRuleContext(Generic_call_in_typeContext.class,0);
		}
		public New_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNew_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNew_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitNew_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_callContext new_call() throws RecognitionException {
		New_callContext _localctx = new New_callContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_new_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1055);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1052);
				macro_call();
				}
				}
				setState(1057);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1058);
			match(KW_NEW);
			setState(1059);
			modified_namepath();
			setState(1061);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4294971408L) != 0)) {
				{
				setState(1060);
				generic_call_in_type();
				}
			}

			setState(1063);
			new_body();
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
	public static class New_bodyContext extends ParserRuleContext {
		public New_blockContext new_block() {
			return getRuleContext(New_blockContext.class,0);
		}
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
		}
		public New_bodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNew_body(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNew_body(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitNew_body(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_bodyContext new_body() throws RecognitionException {
		New_bodyContext _localctx = new New_bodyContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_new_body);
		int _la;
		try {
			setState(1070);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1066);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARENTHESES_L) {
					{
					setState(1065);
					tuple_call_body();
					}
				}

				setState(1068);
				new_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1069);
				tuple_call_body();
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
	public static class New_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<New_statementContext> new_statement() {
			return getRuleContexts(New_statementContext.class);
		}
		public New_statementContext new_statement(int i) {
			return getRuleContext(New_statementContext.class,i);
		}
		public New_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNew_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNew_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitNew_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_blockContext new_block() throws RecognitionException {
		New_blockContext _localctx = new New_blockContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_new_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1072);
			match(BRACE_L);
			setState(1076);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 436849163938824524L) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 8376207L) != 0)) {
				{
				{
				setState(1073);
				new_statement();
				}
				}
				setState(1078);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1079);
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
	public static class New_statementContext extends ParserRuleContext {
		public Tuple_call_itemContext tuple_call_item() {
			return getRuleContext(Tuple_call_itemContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public New_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNew_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNew_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitNew_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final New_statementContext new_statement() throws RecognitionException {
		New_statementContext _localctx = new New_statementContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_new_statement);
		try {
			setState(1083);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARENTHESES_L:
			case BRACKET_L:
			case OP_ADD:
			case OP_SUB:
			case OP_HASH:
			case OP_THROW:
			case OP_NOT:
			case KW_NEW:
			case KW_TRY:
			case KW_MATCH:
			case KW_CATCH:
			case INTEGER:
			case DECIMAL:
			case STRING_SINGLE:
			case STRING_DOUBLE:
			case KW_IF:
			case RETURN:
			case RESUME:
			case YIELD:
			case BREAK:
			case CONTINUE:
			case RAISE:
			case SPECIAL:
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1081);
				tuple_call_item();
				}
				break;
			case COMMA:
			case SEMICOLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(1082);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitModifiers(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_modifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1088);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(1085);
				identifier();
				}
				}
				setState(1090);
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
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterModified_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitModified_identifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitModified_identifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Modified_identifierContext modified_identifier() throws RecognitionException {
		Modified_identifierContext _localctx = new Modified_identifierContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_modified_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1092); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1091);
					identifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1094); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
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
		public List<TerminalNode> OP_PROPORTION() { return getTokens(ValkyrieAntlrParser.OP_PROPORTION); }
		public TerminalNode OP_PROPORTION(int i) {
			return getToken(ValkyrieAntlrParser.OP_PROPORTION, i);
		}
		public Modified_namepathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modified_namepath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterModified_namepath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitModified_namepath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitModified_namepath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Modified_namepathContext modified_namepath() throws RecognitionException {
		Modified_namepathContext _localctx = new Modified_namepathContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_modified_namepath);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1097); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1096);
				identifier();
				}
				}
				setState(1099); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RAW_ID || _la==UNICODE_ID );
			setState(1105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1101);
					match(OP_PROPORTION);
					setState(1102);
					identifier();
					}
					} 
				}
				setState(1107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,125,_ctx);
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
		public List<TerminalNode> OP_PROPORTION() { return getTokens(ValkyrieAntlrParser.OP_PROPORTION); }
		public TerminalNode OP_PROPORTION(int i) {
			return getToken(ValkyrieAntlrParser.OP_PROPORTION, i);
		}
		public List<TerminalNode> DOT() { return getTokens(ValkyrieAntlrParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ValkyrieAntlrParser.DOT, i);
		}
		public Namepath_freeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namepath_free; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNamepath_free(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNamepath_free(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitNamepath_free(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Namepath_freeContext namepath_free() throws RecognitionException {
		Namepath_freeContext _localctx = new Namepath_freeContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_namepath_free);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1108);
			identifier();
			setState(1113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==OP_PROPORTION) {
				{
				{
				setState(1109);
				_la = _input.LA(1);
				if ( !(_la==DOT || _la==OP_PROPORTION) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1110);
				identifier();
				}
				}
				setState(1115);
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
		public List<TerminalNode> OP_PROPORTION() { return getTokens(ValkyrieAntlrParser.OP_PROPORTION); }
		public TerminalNode OP_PROPORTION(int i) {
			return getToken(ValkyrieAntlrParser.OP_PROPORTION, i);
		}
		public NamepathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namepath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNamepath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNamepath(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitNamepath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamepathContext namepath() throws RecognitionException {
		NamepathContext _localctx = new NamepathContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_namepath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1116);
			identifier();
			setState(1121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1117);
					match(OP_PROPORTION);
					setState(1118);
					identifier();
					}
					} 
				}
				setState(1123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,127,_ctx);
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
		public TerminalNode UNICODE_ID() { return getToken(ValkyrieAntlrParser.UNICODE_ID, 0); }
		public TerminalNode RAW_ID() { return getToken(ValkyrieAntlrParser.RAW_ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1124);
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
		public TerminalNode DECIMAL() { return getToken(ValkyrieAntlrParser.DECIMAL, 0); }
		public TerminalNode INTEGER() { return getToken(ValkyrieAntlrParser.INTEGER, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1126);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==DECIMAL) ) {
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
	public static class Number_literalContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Number_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNumber_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNumber_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitNumber_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Number_literalContext number_literal() throws RecognitionException {
		Number_literalContext _localctx = new Number_literalContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_number_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1128);
			number();
			setState(1130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				{
				setState(1129);
				identifier();
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
	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING_SINGLE() { return getToken(ValkyrieAntlrParser.STRING_SINGLE, 0); }
		public TerminalNode STRING_DOUBLE() { return getToken(ValkyrieAntlrParser.STRING_DOUBLE, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1132);
			_la = _input.LA(1);
			if ( !(_la==STRING_SINGLE || _la==STRING_DOUBLE) ) {
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
	public static class String_literalContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public String_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterString_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitString_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ValkyrieAntlrVisitor ) return ((ValkyrieAntlrVisitor<? extends T>)visitor).visitString_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_string_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RAW_ID || _la==UNICODE_ID) {
				{
				setState(1134);
				identifier();
				}
			}

			setState(1137);
			string();
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
		case 54:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 55:
			return inline_expression_sempred((Inline_expressionContext)_localctx, predIndex);
		case 56:
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
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 5);
		case 6:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean inline_expression_sempred(Inline_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean type_expression_sempred(Type_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 3);
		case 14:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001p\u0474\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"+
		"_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007c\u0002"+
		"d\u0007d\u0002e\u0007e\u0002f\u0007f\u0001\u0000\u0005\u0000\u00d0\b\u0000"+
		"\n\u0000\f\u0000\u00d3\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u00e7\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u00ef"+
		"\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u00f8\b\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\b\u0005\b\u0100\b\b\n\b\f\b\u0103"+
		"\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0109\b\b\u0001\b\u0003\b"+
		"\u010c\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0005\t\u0112\b\t\n\t\f\t\u0115"+
		"\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0003\n\u011c\b\n\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0120\b\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0005\f\u0125\b\f\n\f\f\f\u0128\t\f\u0001\f\u0001\f\u0003\f\u012c\b\f"+
		"\u0001\f\u0003\f\u012f\b\f\u0001\r\u0005\r\u0132\b\r\n\r\f\r\u0135\t\r"+
		"\u0001\r\u0001\r\u0001\r\u0003\r\u013a\b\r\u0001\r\u0003\r\u013d\b\r\u0001"+
		"\r\u0003\r\u0140\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0145"+
		"\b\u000e\u0001\u000e\u0003\u000e\u0148\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u014e\b\u000f\n\u000f\f\u000f\u0151"+
		"\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0003\u0010\u0159\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0003\u0011\u015f\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u0164\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u0171\b\u0015\n\u0015\f\u0015\u0174\t\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u017b\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0003\u0017\u017f\b\u0017\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u0183\b\u0018\n\u0018\f\u0018\u0186\t\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u018c\b\u0019\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0005\u001b\u0194"+
		"\b\u001b\n\u001b\f\u001b\u0197\t\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u019d\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0003\u001d\u01a2\b\u001d\u0001\u001e\u0005\u001e\u01a5\b\u001e\n\u001e"+
		"\f\u001e\u01a8\t\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0003\u001e\u01af\b\u001e\u0001\u001e\u0003\u001e\u01b2\b"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u01bc\b\u001f\n\u001f\f\u001f"+
		"\u01bf\t\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u01c3\b\u001f\u0001"+
		" \u0005 \u01c6\b \n \f \u01c9\t \u0001 \u0001 \u0003 \u01cd\b \u0001 "+
		"\u0003 \u01d0\b \u0001!\u0001!\u0001!\u0001\"\u0003\"\u01d6\b\"\u0001"+
		"\"\u0001\"\u0001#\u0003#\u01db\b#\u0001#\u0001#\u0001#\u0003#\u01e0\b"+
		"#\u0001$\u0001$\u0001$\u0001$\u0001$\u0001$\u0005$\u01e8\b$\n$\f$\u01eb"+
		"\t$\u0001$\u0003$\u01ee\b$\u0001$\u0001$\u0003$\u01f2\b$\u0001%\u0001"+
		"%\u0001%\u0001%\u0001%\u0003%\u01f9\b%\u0001&\u0005&\u01fc\b&\n&\f&\u01ff"+
		"\t&\u0001&\u0001&\u0001&\u0003&\u0204\b&\u0001&\u0003&\u0207\b&\u0001"+
		"&\u0001&\u0001\'\u0003\'\u020c\b\'\u0001\'\u0001\'\u0001(\u0001(\u0005"+
		"(\u0212\b(\n(\f(\u0215\t(\u0001(\u0001(\u0001)\u0001)\u0001)\u0003)\u021c"+
		"\b)\u0001)\u0001)\u0003)\u0220\b)\u0001*\u0001*\u0001*\u0001*\u0001*\u0001"+
		"*\u0005*\u0228\b*\n*\f*\u022b\t*\u0001*\u0003*\u022e\b*\u0001*\u0001*"+
		"\u0001*\u0001*\u0001*\u0001*\u0001*\u0001*\u0005*\u0238\b*\n*\f*\u023b"+
		"\t*\u0001*\u0003*\u023e\b*\u0001*\u0001*\u0001*\u0001*\u0003*\u0244\b"+
		"*\u0001*\u0003*\u0247\b*\u0001+\u0004+\u024a\b+\u000b+\f+\u024b\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001.\u0001.\u0001"+
		".\u0001/\u0001/\u0001/\u0001/\u0005/\u025d\b/\n/\f/\u0260\t/\u0001/\u0003"+
		"/\u0263\b/\u00010\u00010\u00010\u00010\u00010\u00011\u00011\u00011\u0001"+
		"2\u00052\u026e\b2\n2\f2\u0271\t2\u00012\u00012\u00012\u00012\u00013\u0005"+
		"3\u0278\b3\n3\f3\u027b\t3\u00013\u00013\u00013\u00013\u00013\u00033\u0282"+
		"\b3\u00013\u00013\u00014\u00034\u0287\b4\u00014\u00014\u00014\u00014\u0005"+
		"4\u028d\b4\n4\f4\u0290\t4\u00014\u00034\u0293\b4\u00014\u00014\u00014"+
		"\u00014\u00054\u0299\b4\n4\f4\u029c\t4\u00014\u00034\u029f\b4\u00014\u0001"+
		"4\u00034\u02a3\b4\u00015\u00015\u00015\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00036\u02ae\b6\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0005"+
		"6\u02ca\b6\n6\f6\u02cd\t6\u00017\u00017\u00017\u00017\u00017\u00037\u02d4"+
		"\b7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00057\u02ec\b7\n7\f7\u02ef\t7\u00018\u00018\u00018\u0001"+
		"8\u00018\u00018\u00018\u00018\u00018\u00058\u02fa\b8\n8\f8\u02fd\t8\u0001"+
		"9\u00019\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001"+
		":\u0001:\u0003:\u030b\b:\u0001;\u0001;\u0003;\u030f\b;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0001;\u0001;\u0001;\u0003;\u0319\b;\u0001;\u0003;\u031c"+
		"\b;\u0001;\u0001;\u0001;\u0001;\u0001;\u0003;\u0323\b;\u0001<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0001"+
		"<\u0001<\u0001<\u0001<\u0001<\u0001<\u0003<\u0337\b<\u0001=\u0001=\u0001"+
		">\u0001>\u0001?\u0001?\u0001@\u0001@\u0001A\u0001A\u0001B\u0001B\u0001"+
		"C\u0001C\u0001C\u0003C\u0348\bC\u0001D\u0001D\u0001E\u0003E\u034d\bE\u0001"+
		"E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0003E\u0357\bE\u0001"+
		"F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0003F\u0362"+
		"\bF\u0001G\u0003G\u0365\bG\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001"+
		"G\u0001G\u0003G\u036f\bG\u0001H\u0001H\u0001H\u0001H\u0001I\u0001I\u0001"+
		"I\u0001I\u0001I\u0001I\u0001I\u0001I\u0001I\u0003I\u037e\bI\u0001J\u0001"+
		"J\u0001J\u0001J\u0001J\u0001J\u0001J\u0005J\u0387\bJ\nJ\fJ\u038a\tJ\u0001"+
		"J\u0001J\u0003J\u038e\bJ\u0001K\u0001K\u0003K\u0392\bK\u0001L\u0001L\u0003"+
		"L\u0396\bL\u0001L\u0001L\u0001M\u0001M\u0001M\u0001M\u0001N\u0001N\u0001"+
		"N\u0001N\u0001O\u0003O\u03a3\bO\u0001O\u0001O\u0001O\u0003O\u03a8\bO\u0001"+
		"O\u0001O\u0001P\u0003P\u03ad\bP\u0001P\u0001P\u0001P\u0003P\u03b2\bP\u0001"+
		"P\u0001P\u0001Q\u0001Q\u0005Q\u03b8\bQ\nQ\fQ\u03bb\tQ\u0001Q\u0001Q\u0001"+
		"R\u0001R\u0001R\u0001R\u0003R\u03c3\bR\u0001S\u0005S\u03c6\bS\nS\fS\u03c9"+
		"\tS\u0001S\u0001S\u0001S\u0001S\u0001S\u0003S\u03d0\bS\u0001S\u0003S\u03d3"+
		"\bS\u0001T\u0005T\u03d6\bT\nT\fT\u03d9\tT\u0001T\u0001T\u0001T\u0001T"+
		"\u0005T\u03df\bT\nT\fT\u03e2\tT\u0001U\u0005U\u03e5\bU\nU\fU\u03e8\tU"+
		"\u0001U\u0001U\u0001U\u0005U\u03ed\bU\nU\fU\u03f0\tU\u0001V\u0005V\u03f3"+
		"\bV\nV\fV\u03f6\tV\u0001V\u0001V\u0001V\u0003V\u03fb\bV\u0001V\u0001V"+
		"\u0005V\u03ff\bV\nV\fV\u0402\tV\u0001W\u0001W\u0001W\u0001W\u0001W\u0001"+
		"W\u0001W\u0001W\u0001W\u0005W\u040d\bW\nW\fW\u0410\tW\u0001W\u0003W\u0413"+
		"\bW\u0001W\u0001W\u0003W\u0417\bW\u0001X\u0001X\u0003X\u041b\bX\u0001"+
		"Y\u0005Y\u041e\bY\nY\fY\u0421\tY\u0001Y\u0001Y\u0001Y\u0003Y\u0426\bY"+
		"\u0001Y\u0001Y\u0001Z\u0003Z\u042b\bZ\u0001Z\u0001Z\u0003Z\u042f\bZ\u0001"+
		"[\u0001[\u0005[\u0433\b[\n[\f[\u0436\t[\u0001[\u0001[\u0001\\\u0001\\"+
		"\u0003\\\u043c\b\\\u0001]\u0005]\u043f\b]\n]\f]\u0442\t]\u0001^\u0004"+
		"^\u0445\b^\u000b^\f^\u0446\u0001_\u0004_\u044a\b_\u000b_\f_\u044b\u0001"+
		"_\u0001_\u0005_\u0450\b_\n_\f_\u0453\t_\u0001`\u0001`\u0001`\u0005`\u0458"+
		"\b`\n`\f`\u045b\t`\u0001a\u0001a\u0001a\u0005a\u0460\ba\na\fa\u0463\t"+
		"a\u0001b\u0001b\u0001c\u0001c\u0001d\u0001d\u0003d\u046b\bd\u0001e\u0001"+
		"e\u0001f\u0003f\u0470\bf\u0001f\u0001f\u0001f\u0000\u0003lnpg\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u0000"+
		"\u000f\u0001\u0000\u0002\u0003\u0002\u0000\u0005\u0005JJ\u0002\u0000\u0005"+
		"\u0005((\u0003\u0000\u0018\u0018\u001a\u001a::\u0003\u0000\u001e #$\'"+
		"\'\u0002\u00000022\u0001\u0000\u001c\u001d\u0002\u0000\u0018\u0018\u001a"+
		"\u001a\u0002\u0000//11\u0001\u0000*.\u0001\u0000<=\u0002\u0000\u0001\u0001"+
		"\u0004\u0004\u0001\u0000kl\u0001\u0000]^\u0001\u0000_`\u04cd\u0000\u00d1"+
		"\u0001\u0000\u0000\u0000\u0002\u00e6\u0001\u0000\u0000\u0000\u0004\u00ee"+
		"\u0001\u0000\u0000\u0000\u0006\u00f0\u0001\u0000\u0000\u0000\b\u00f2\u0001"+
		"\u0000\u0000\u0000\n\u00f4\u0001\u0000\u0000\u0000\f\u00f9\u0001\u0000"+
		"\u0000\u0000\u000e\u00fc\u0001\u0000\u0000\u0000\u0010\u0101\u0001\u0000"+
		"\u0000\u0000\u0012\u010f\u0001\u0000\u0000\u0000\u0014\u011b\u0001\u0000"+
		"\u0000\u0000\u0016\u011d\u0001\u0000\u0000\u0000\u0018\u0126\u0001\u0000"+
		"\u0000\u0000\u001a\u0133\u0001\u0000\u0000\u0000\u001c\u0141\u0001\u0000"+
		"\u0000\u0000\u001e\u014b\u0001\u0000\u0000\u0000 \u0158\u0001\u0000\u0000"+
		"\u0000\"\u015a\u0001\u0000\u0000\u0000$\u0160\u0001\u0000\u0000\u0000"+
		"&\u0167\u0001\u0000\u0000\u0000(\u016a\u0001\u0000\u0000\u0000*\u016e"+
		"\u0001\u0000\u0000\u0000,\u017a\u0001\u0000\u0000\u0000.\u017c\u0001\u0000"+
		"\u0000\u00000\u0180\u0001\u0000\u0000\u00002\u018b\u0001\u0000\u0000\u0000"+
		"4\u018d\u0001\u0000\u0000\u00006\u0191\u0001\u0000\u0000\u00008\u019c"+
		"\u0001\u0000\u0000\u0000:\u019e\u0001\u0000\u0000\u0000<\u01a6\u0001\u0000"+
		"\u0000\u0000>\u01c2\u0001\u0000\u0000\u0000@\u01c7\u0001\u0000\u0000\u0000"+
		"B\u01d1\u0001\u0000\u0000\u0000D\u01d5\u0001\u0000\u0000\u0000F\u01da"+
		"\u0001\u0000\u0000\u0000H\u01f1\u0001\u0000\u0000\u0000J\u01f8\u0001\u0000"+
		"\u0000\u0000L\u01fd\u0001\u0000\u0000\u0000N\u020b\u0001\u0000\u0000\u0000"+
		"P\u020f\u0001\u0000\u0000\u0000R\u0218\u0001\u0000\u0000\u0000T\u0246"+
		"\u0001\u0000\u0000\u0000V\u0249\u0001\u0000\u0000\u0000X\u024d\u0001\u0000"+
		"\u0000\u0000Z\u0252\u0001\u0000\u0000\u0000\\\u0255\u0001\u0000\u0000"+
		"\u0000^\u0258\u0001\u0000\u0000\u0000`\u0264\u0001\u0000\u0000\u0000b"+
		"\u0269\u0001\u0000\u0000\u0000d\u026f\u0001\u0000\u0000\u0000f\u0279\u0001"+
		"\u0000\u0000\u0000h\u02a2\u0001\u0000\u0000\u0000j\u02a4\u0001\u0000\u0000"+
		"\u0000l\u02ad\u0001\u0000\u0000\u0000n\u02d3\u0001\u0000\u0000\u0000p"+
		"\u02f0\u0001\u0000\u0000\u0000r\u02fe\u0001\u0000\u0000\u0000t\u030a\u0001"+
		"\u0000\u0000\u0000v\u0322\u0001\u0000\u0000\u0000x\u0336\u0001\u0000\u0000"+
		"\u0000z\u0338\u0001\u0000\u0000\u0000|\u033a\u0001\u0000\u0000\u0000~"+
		"\u033c\u0001\u0000\u0000\u0000\u0080\u033e\u0001\u0000\u0000\u0000\u0082"+
		"\u0340\u0001\u0000\u0000\u0000\u0084\u0342\u0001\u0000\u0000\u0000\u0086"+
		"\u0347\u0001\u0000\u0000\u0000\u0088\u0349\u0001\u0000\u0000\u0000\u008a"+
		"\u0356\u0001\u0000\u0000\u0000\u008c\u0361\u0001\u0000\u0000\u0000\u008e"+
		"\u036e\u0001\u0000\u0000\u0000\u0090\u0370\u0001\u0000\u0000\u0000\u0092"+
		"\u037d\u0001\u0000\u0000\u0000\u0094\u038d\u0001\u0000\u0000\u0000\u0096"+
		"\u038f\u0001\u0000\u0000\u0000\u0098\u0393\u0001\u0000\u0000\u0000\u009a"+
		"\u0399\u0001\u0000\u0000\u0000\u009c\u039d\u0001\u0000\u0000\u0000\u009e"+
		"\u03a2\u0001\u0000\u0000\u0000\u00a0\u03ac\u0001\u0000\u0000\u0000\u00a2"+
		"\u03b5\u0001\u0000\u0000\u0000\u00a4\u03c2\u0001\u0000\u0000\u0000\u00a6"+
		"\u03d2\u0001\u0000\u0000\u0000\u00a8\u03d7\u0001\u0000\u0000\u0000\u00aa"+
		"\u03e6\u0001\u0000\u0000\u0000\u00ac\u03f4\u0001\u0000\u0000\u0000\u00ae"+
		"\u0416\u0001\u0000\u0000\u0000\u00b0\u041a\u0001\u0000\u0000\u0000\u00b2"+
		"\u041f\u0001\u0000\u0000\u0000\u00b4\u042e\u0001\u0000\u0000\u0000\u00b6"+
		"\u0430\u0001\u0000\u0000\u0000\u00b8\u043b\u0001\u0000\u0000\u0000\u00ba"+
		"\u0440\u0001\u0000\u0000\u0000\u00bc\u0444\u0001\u0000\u0000\u0000\u00be"+
		"\u0449\u0001\u0000\u0000\u0000\u00c0\u0454\u0001\u0000\u0000\u0000\u00c2"+
		"\u045c\u0001\u0000\u0000\u0000\u00c4\u0464\u0001\u0000\u0000\u0000\u00c6"+
		"\u0466\u0001\u0000\u0000\u0000\u00c8\u0468\u0001\u0000\u0000\u0000\u00ca"+
		"\u046c\u0001\u0000\u0000\u0000\u00cc\u046f\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d0\u0003\u0002\u0001\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d1"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d4\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d5\u0005\u0000\u0000\u0001\u00d5"+
		"\u0001\u0001\u0000\u0000\u0000\u00d6\u00e7\u0003\n\u0005\u0000\u00d7\u00e7"+
		"\u0003\f\u0006\u0000\u00d8\u00e7\u0003\u000e\u0007\u0000\u00d9\u00e7\u0003"+
		"\u0010\b\u0000\u00da\u00e7\u0003(\u0014\u0000\u00db\u00e7\u00034\u001a"+
		"\u0000\u00dc\u00e7\u0003\u001c\u000e\u0000\u00dd\u00e7\u0003$\u0012\u0000"+
		"\u00de\u00e7\u0003<\u001e\u0000\u00df\u00e7\u0003X,\u0000\u00e0\u00e7"+
		"\u0003R)\u0000\u00e1\u00e7\u0003^/\u0000\u00e2\u00e7\u0003d2\u0000\u00e3"+
		"\u00e7\u0003f3\u0000\u00e4\u00e7\u0003l6\u0000\u00e5\u00e7\u0003\u0006"+
		"\u0003\u0000\u00e6\u00d6\u0001\u0000\u0000\u0000\u00e6\u00d7\u0001\u0000"+
		"\u0000\u0000\u00e6\u00d8\u0001\u0000\u0000\u0000\u00e6\u00d9\u0001\u0000"+
		"\u0000\u0000\u00e6\u00da\u0001\u0000\u0000\u0000\u00e6\u00db\u0001\u0000"+
		"\u0000\u0000\u00e6\u00dc\u0001\u0000\u0000\u0000\u00e6\u00dd\u0001\u0000"+
		"\u0000\u0000\u00e6\u00de\u0001\u0000\u0000\u0000\u00e6\u00df\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e0\u0001\u0000\u0000\u0000\u00e6\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e2\u0001\u0000\u0000\u0000\u00e6\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e5\u0001\u0000"+
		"\u0000\u0000\u00e7\u0003\u0001\u0000\u0000\u0000\u00e8\u00ef\u0003L&\u0000"+
		"\u00e9\u00ef\u0003R)\u0000\u00ea\u00ef\u0003d2\u0000\u00eb\u00ef\u0003"+
		"f3\u0000\u00ec\u00ef\u0003l6\u0000\u00ed\u00ef\u0003\u0006\u0003\u0000"+
		"\u00ee\u00e8\u0001\u0000\u0000\u0000\u00ee\u00e9\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ea\u0001\u0000\u0000\u0000\u00ee\u00eb\u0001\u0000\u0000\u0000"+
		"\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ee\u00ed\u0001\u0000\u0000\u0000"+
		"\u00ef\u0005\u0001\u0000\u0000\u0000\u00f0\u00f1\u0005\u0003\u0000\u0000"+
		"\u00f1\u0007\u0001\u0000\u0000\u0000\u00f2\u00f3\u0007\u0000\u0000\u0000"+
		"\u00f3\t\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005F\u0000\u0000\u00f5"+
		"\u00f7\u0003\u00c0`\u0000\u00f6\u00f8\u0003\u0006\u0003\u0000\u00f7\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000\u0000\u0000\u00f8\u000b"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005G\u0000\u0000\u00fa\u00fb\u0003"+
		"\u00c0`\u0000\u00fb\r\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005H\u0000"+
		"\u0000\u00fd\u000f\u0001\u0000\u0000\u0000\u00fe\u0100\u0003\u0094J\u0000"+
		"\u00ff\u00fe\u0001\u0000\u0000\u0000\u0100\u0103\u0001\u0000\u0000\u0000"+
		"\u0101\u00ff\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000"+
		"\u0102\u0104\u0001\u0000\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0003\u00ba]\u0000\u0105\u0106\u0005K\u0000\u0000\u0106\u0108"+
		"\u0003\u00c4b\u0000\u0107\u0109\u0003\u008aE\u0000\u0108\u0107\u0001\u0000"+
		"\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010b\u0001\u0000"+
		"\u0000\u0000\u010a\u010c\u0003\u0016\u000b\u0000\u010b\u010a\u0001\u0000"+
		"\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u0003\u0012\t\u0000\u010e\u0011\u0001\u0000\u0000"+
		"\u0000\u010f\u0113\u0005\n\u0000\u0000\u0110\u0112\u0003\u0014\n\u0000"+
		"\u0111\u0110\u0001\u0000\u0000\u0000\u0112\u0115\u0001\u0000\u0000\u0000"+
		"\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000"+
		"\u0114\u0116\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000"+
		"\u0116\u0117\u0005\u000b\u0000\u0000\u0117\u0013\u0001\u0000\u0000\u0000"+
		"\u0118\u011c\u0003\u001a\r\u0000\u0119\u011c\u0003\u0018\f\u0000\u011a"+
		"\u011c\u0003\b\u0004\u0000\u011b\u0118\u0001\u0000\u0000\u0000\u011b\u0119"+
		"\u0001\u0000\u0000\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c\u0015"+
		"\u0001\u0000\u0000\u0000\u011d\u011f\u0005\u0006\u0000\u0000\u011e\u0120"+
		"\u0003\u00c2a\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u011f\u0120\u0001"+
		"\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0122\u0005"+
		"\u0007\u0000\u0000\u0122\u0017\u0001\u0000\u0000\u0000\u0123\u0125\u0003"+
		"\u0094J\u0000\u0124\u0123\u0001\u0000\u0000\u0000\u0125\u0128\u0001\u0000"+
		"\u0000\u0000\u0126\u0124\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000"+
		"\u0000\u0000\u0127\u0129\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000"+
		"\u0000\u0000\u0129\u012b\u0003\u00bc^\u0000\u012a\u012c\u0003Z-\u0000"+
		"\u012b\u012a\u0001\u0000\u0000\u0000\u012b\u012c\u0001\u0000\u0000\u0000"+
		"\u012c\u012e\u0001\u0000\u0000\u0000\u012d\u012f\u0003B!\u0000\u012e\u012d"+
		"\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012f\u0019"+
		"\u0001\u0000\u0000\u0000\u0130\u0132\u0003\u0094J\u0000\u0131\u0130\u0001"+
		"\u0000\u0000\u0000\u0132\u0135\u0001\u0000\u0000\u0000\u0133\u0131\u0001"+
		"\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\u0136\u0001"+
		"\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0136\u0137\u0003"+
		"\u00be_\u0000\u0137\u0139\u0003>\u001f\u0000\u0138\u013a\u0003Z-\u0000"+
		"\u0139\u0138\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000"+
		"\u013a\u013c\u0001\u0000\u0000\u0000\u013b\u013d\u0003\\.\u0000\u013c"+
		"\u013b\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d"+
		"\u013f\u0001\u0000\u0000\u0000\u013e\u0140\u0003P(\u0000\u013f\u013e\u0001"+
		"\u0000\u0000\u0000\u013f\u0140\u0001\u0000\u0000\u0000\u0140\u001b\u0001"+
		"\u0000\u0000\u0000\u0141\u0142\u0005L\u0000\u0000\u0142\u0144\u0003\u00c4"+
		"b\u0000\u0143\u0145\u0003\u008aE\u0000\u0144\u0143\u0001\u0000\u0000\u0000"+
		"\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0147\u0001\u0000\u0000\u0000"+
		"\u0146\u0148\u0003&\u0013\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0147"+
		"\u0148\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000\u0000\u0000\u0149"+
		"\u014a\u0003\u001e\u000f\u0000\u014a\u001d\u0001\u0000\u0000\u0000\u014b"+
		"\u014f\u0005\n\u0000\u0000\u014c\u014e\u0003 \u0010\u0000\u014d\u014c"+
		"\u0001\u0000\u0000\u0000\u014e\u0151\u0001\u0000\u0000\u0000\u014f\u014d"+
		"\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0152"+
		"\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0152\u0153"+
		"\u0005\u000b\u0000\u0000\u0153\u001f\u0001\u0000\u0000\u0000\u0154\u0159"+
		"\u0003\"\u0011\u0000\u0155\u0159\u0003\u001a\r\u0000\u0156\u0159\u0003"+
		"\u0018\f\u0000\u0157\u0159\u0003\b\u0004\u0000\u0158\u0154\u0001\u0000"+
		"\u0000\u0000\u0158\u0155\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000"+
		"\u0000\u0000\u0158\u0157\u0001\u0000\u0000\u0000\u0159!\u0001\u0000\u0000"+
		"\u0000\u015a\u015b\u0005O\u0000\u0000\u015b\u015e\u0003\u00c4b\u0000\u015c"+
		"\u015d\u0005*\u0000\u0000\u015d\u015f\u0003p8\u0000\u015e\u015c\u0001"+
		"\u0000\u0000\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f#\u0001\u0000"+
		"\u0000\u0000\u0160\u0161\u0005I\u0000\u0000\u0161\u0163\u0003\u00c2a\u0000"+
		"\u0162\u0164\u0003&\u0013\u0000\u0163\u0162\u0001\u0000\u0000\u0000\u0163"+
		"\u0164\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165"+
		"\u0166\u0003\u001e\u000f\u0000\u0166%\u0001\u0000\u0000\u0000\u0167\u0168"+
		"\u0007\u0001\u0000\u0000\u0168\u0169\u0003p8\u0000\u0169\'\u0001\u0000"+
		"\u0000\u0000\u016a\u016b\u0005M\u0000\u0000\u016b\u016c\u0003\u00c4b\u0000"+
		"\u016c\u016d\u0003*\u0015\u0000\u016d)\u0001\u0000\u0000\u0000\u016e\u0172"+
		"\u0005\n\u0000\u0000\u016f\u0171\u0003,\u0016\u0000\u0170\u016f\u0001"+
		"\u0000\u0000\u0000\u0171\u0174\u0001\u0000\u0000\u0000\u0172\u0170\u0001"+
		"\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173\u0175\u0001"+
		"\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0175\u0176\u0005"+
		"\u000b\u0000\u0000\u0176+\u0001\u0000\u0000\u0000\u0177\u017b\u0003\u001a"+
		"\r\u0000\u0178\u017b\u0003.\u0017\u0000\u0179\u017b\u0003\b\u0004\u0000"+
		"\u017a\u0177\u0001\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000"+
		"\u017a\u0179\u0001\u0000\u0000\u0000\u017b-\u0001\u0000\u0000\u0000\u017c"+
		"\u017e\u0003\u00c4b\u0000\u017d\u017f\u00030\u0018\u0000\u017e\u017d\u0001"+
		"\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f/\u0001\u0000"+
		"\u0000\u0000\u0180\u0184\u0005\n\u0000\u0000\u0181\u0183\u00032\u0019"+
		"\u0000\u0182\u0181\u0001\u0000\u0000\u0000\u0183\u0186\u0001\u0000\u0000"+
		"\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0184\u0185\u0001\u0000\u0000"+
		"\u0000\u0185\u0187\u0001\u0000\u0000\u0000\u0186\u0184\u0001\u0000\u0000"+
		"\u0000\u0187\u0188\u0005\u000b\u0000\u0000\u01881\u0001\u0000\u0000\u0000"+
		"\u0189\u018c\u0003\u0018\f\u0000\u018a\u018c\u0003\b\u0004\u0000\u018b"+
		"\u0189\u0001\u0000\u0000\u0000\u018b\u018a\u0001\u0000\u0000\u0000\u018c"+
		"3\u0001\u0000\u0000\u0000\u018d\u018e\u0005N\u0000\u0000\u018e\u018f\u0003"+
		"\u00c2a\u0000\u018f\u0190\u00036\u001b\u0000\u01905\u0001\u0000\u0000"+
		"\u0000\u0191\u0195\u0005\n\u0000\u0000\u0192\u0194\u00038\u001c\u0000"+
		"\u0193\u0192\u0001\u0000\u0000\u0000\u0194\u0197\u0001\u0000\u0000\u0000"+
		"\u0195\u0193\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000"+
		"\u0196\u0198\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000"+
		"\u0198\u0199\u0005\u000b\u0000\u0000\u01997\u0001\u0000\u0000\u0000\u019a"+
		"\u019d\u0003:\u001d\u0000\u019b\u019d\u0003\b\u0004\u0000\u019c\u019a"+
		"\u0001\u0000\u0000\u0000\u019c\u019b\u0001\u0000\u0000\u0000\u019d9\u0001"+
		"\u0000\u0000\u0000\u019e\u01a1\u0003\u00c4b\u0000\u019f\u01a0\u0005*\u0000"+
		"\u0000\u01a0\u01a2\u0003l6\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a1"+
		"\u01a2\u0001\u0000\u0000\u0000\u01a2;\u0001\u0000\u0000\u0000\u01a3\u01a5"+
		"\u0003\u0094J\u0000\u01a4\u01a3\u0001\u0000\u0000\u0000\u01a5\u01a8\u0001"+
		"\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000\u0000\u0000\u01a6\u01a7\u0001"+
		"\u0000\u0000\u0000\u01a7\u01a9\u0001\u0000\u0000\u0000\u01a8\u01a6\u0001"+
		"\u0000\u0000\u0000\u01a9\u01aa\u0003\u00ba]\u0000\u01aa\u01ab\u0005Q\u0000"+
		"\u0000\u01ab\u01ac\u0003\u00c2a\u0000\u01ac\u01ae\u0003>\u001f\u0000\u01ad"+
		"\u01af\u0003Z-\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01ae\u01af\u0001"+
		"\u0000\u0000\u0000\u01af\u01b1\u0001\u0000\u0000\u0000\u01b0\u01b2\u0003"+
		"\\.\u0000\u01b1\u01b0\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01b4\u0003P(\u0000"+
		"\u01b4=\u0001\u0000\u0000\u0000\u01b5\u01b6\u0005\u0006\u0000\u0000\u01b6"+
		"\u01c3\u0005\u0007\u0000\u0000\u01b7\u01b8\u0005\u0006\u0000\u0000\u01b8"+
		"\u01bd\u0003@ \u0000\u01b9\u01ba\u0005\u0002\u0000\u0000\u01ba\u01bc\u0003"+
		"@ \u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bc\u01bf\u0001\u0000\u0000"+
		"\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000"+
		"\u0000\u01be\u01c0\u0001\u0000\u0000\u0000\u01bf\u01bd\u0001\u0000\u0000"+
		"\u0000\u01c0\u01c1\u0005\u0007\u0000\u0000\u01c1\u01c3\u0001\u0000\u0000"+
		"\u0000\u01c2\u01b5\u0001\u0000\u0000\u0000\u01c2\u01b7\u0001\u0000\u0000"+
		"\u0000\u01c3?\u0001\u0000\u0000\u0000\u01c4\u01c6\u0003\u0094J\u0000\u01c5"+
		"\u01c4\u0001\u0000\u0000\u0000\u01c6\u01c9\u0001\u0000\u0000\u0000\u01c7"+
		"\u01c5\u0001\u0000\u0000\u0000\u01c7\u01c8\u0001\u0000\u0000\u0000\u01c8"+
		"\u01ca\u0001\u0000\u0000\u0000\u01c9\u01c7\u0001\u0000\u0000\u0000\u01ca"+
		"\u01cc\u0003\u00bc^\u0000\u01cb\u01cd\u0003Z-\u0000\u01cc\u01cb\u0001"+
		"\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000\u0000\u01cd\u01cf\u0001"+
		"\u0000\u0000\u0000\u01ce\u01d0\u0003B!\u0000\u01cf\u01ce\u0001\u0000\u0000"+
		"\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0A\u0001\u0000\u0000\u0000"+
		"\u01d1\u01d2\u0005*\u0000\u0000\u01d2\u01d3\u0003l6\u0000\u01d3C\u0001"+
		"\u0000\u0000\u0000\u01d4\u01d6\u00059\u0000\u0000\u01d5\u01d4\u0001\u0000"+
		"\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d7\u0001\u0000"+
		"\u0000\u0000\u01d7\u01d8\u0003H$\u0000\u01d8E\u0001\u0000\u0000\u0000"+
		"\u01d9\u01db\u00059\u0000\u0000\u01da\u01d9\u0001\u0000\u0000\u0000\u01da"+
		"\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0001\u0000\u0000\u0000\u01dc"+
		"\u01dd\u0005\u0001\u0000\u0000\u01dd\u01df\u0003\u00c4b\u0000\u01de\u01e0"+
		"\u0003H$\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e0G\u0001\u0000\u0000\u0000\u01e1\u01e2\u0005\u0006\u0000"+
		"\u0000\u01e2\u01f2\u0005\u0007\u0000\u0000\u01e3\u01e4\u0005\u0006\u0000"+
		"\u0000\u01e4\u01e9\u0003J%\u0000\u01e5\u01e6\u0005\u0002\u0000\u0000\u01e6"+
		"\u01e8\u0003J%\u0000\u01e7\u01e5\u0001\u0000\u0000\u0000\u01e8\u01eb\u0001"+
		"\u0000\u0000\u0000\u01e9\u01e7\u0001\u0000\u0000\u0000\u01e9\u01ea\u0001"+
		"\u0000\u0000\u0000\u01ea\u01ed\u0001\u0000\u0000\u0000\u01eb\u01e9\u0001"+
		"\u0000\u0000\u0000\u01ec\u01ee\u0005\u0002\u0000\u0000\u01ed\u01ec\u0001"+
		"\u0000\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee\u01ef\u0001"+
		"\u0000\u0000\u0000\u01ef\u01f0\u0005\u0007\u0000\u0000\u01f0\u01f2\u0001"+
		"\u0000\u0000\u0000\u01f1\u01e1\u0001\u0000\u0000\u0000\u01f1\u01e3\u0001"+
		"\u0000\u0000\u0000\u01f2I\u0001\u0000\u0000\u0000\u01f3\u01f4\u0003\u00c4"+
		"b\u0000\u01f4\u01f5\u0005\u0005\u0000\u0000\u01f5\u01f6\u0003l6\u0000"+
		"\u01f6\u01f9\u0001\u0000\u0000\u0000\u01f7\u01f9\u0003l6\u0000\u01f8\u01f3"+
		"\u0001\u0000\u0000\u0000\u01f8\u01f7\u0001\u0000\u0000\u0000\u01f9K\u0001"+
		"\u0000\u0000\u0000\u01fa\u01fc\u0003\u0094J\u0000\u01fb\u01fa\u0001\u0000"+
		"\u0000\u0000\u01fc\u01ff\u0001\u0000\u0000\u0000\u01fd\u01fb\u0001\u0000"+
		"\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000\u01fe\u0200\u0001\u0000"+
		"\u0000\u0000\u01ff\u01fd\u0001\u0000\u0000\u0000\u0200\u0201\u0005R\u0000"+
		"\u0000\u0201\u0203\u0003>\u001f\u0000\u0202\u0204\u0003Z-\u0000\u0203"+
		"\u0202\u0001\u0000\u0000\u0000\u0203\u0204\u0001\u0000\u0000\u0000\u0204"+
		"\u0206\u0001\u0000\u0000\u0000\u0205\u0207\u0003\\.\u0000\u0206\u0205"+
		"\u0001\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000\u0207\u0208"+
		"\u0001\u0000\u0000\u0000\u0208\u0209\u0003P(\u0000\u0209M\u0001\u0000"+
		"\u0000\u0000\u020a\u020c\u00059\u0000\u0000\u020b\u020a\u0001\u0000\u0000"+
		"\u0000\u020b\u020c\u0001\u0000\u0000\u0000\u020c\u020d\u0001\u0000\u0000"+
		"\u0000\u020d\u020e\u0003P(\u0000\u020eO\u0001\u0000\u0000\u0000\u020f"+
		"\u0213\u0005\n\u0000\u0000\u0210\u0212\u0003\u0004\u0002\u0000\u0211\u0210"+
		"\u0001\u0000\u0000\u0000\u0212\u0215\u0001\u0000\u0000\u0000\u0213\u0211"+
		"\u0001\u0000\u0000\u0000\u0213\u0214\u0001\u0000\u0000\u0000\u0214\u0216"+
		"\u0001\u0000\u0000\u0000\u0215\u0213\u0001\u0000\u0000\u0000\u0216\u0217"+
		"\u0005\u000b\u0000\u0000\u0217Q\u0001\u0000\u0000\u0000\u0218\u0219\u0005"+
		"P\u0000\u0000\u0219\u021b\u0003T*\u0000\u021a\u021c\u0003Z-\u0000\u021b"+
		"\u021a\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000\u0000\u0000\u021c"+
		"\u021f\u0001\u0000\u0000\u0000\u021d\u021e\u0005*\u0000\u0000\u021e\u0220"+
		"\u0003l6\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u021f\u0220\u0001\u0000"+
		"\u0000\u0000\u0220S\u0001\u0000\u0000\u0000\u0221\u0222\u0005\u0006\u0000"+
		"\u0000\u0222\u0247\u0005\u0007\u0000\u0000\u0223\u0224\u0005\u0006\u0000"+
		"\u0000\u0224\u0229\u0003V+\u0000\u0225\u0226\u0005\u0002\u0000\u0000\u0226"+
		"\u0228\u0003V+\u0000\u0227\u0225\u0001\u0000\u0000\u0000\u0228\u022b\u0001"+
		"\u0000\u0000\u0000\u0229\u0227\u0001\u0000\u0000\u0000\u0229\u022a\u0001"+
		"\u0000\u0000\u0000\u022a\u022d\u0001\u0000\u0000\u0000\u022b\u0229\u0001"+
		"\u0000\u0000\u0000\u022c\u022e\u0005\u0002\u0000\u0000\u022d\u022c\u0001"+
		"\u0000\u0000\u0000\u022d\u022e\u0001\u0000\u0000\u0000\u022e\u022f\u0001"+
		"\u0000\u0000\u0000\u022f\u0230\u0005\u0007\u0000\u0000\u0230\u0247\u0001"+
		"\u0000\u0000\u0000\u0231\u0232\u0005\b\u0000\u0000\u0232\u0247\u0005\t"+
		"\u0000\u0000\u0233\u0234\u0005\b\u0000\u0000\u0234\u0239\u0003V+\u0000"+
		"\u0235\u0236\u0005\u0002\u0000\u0000\u0236\u0238\u0003V+\u0000\u0237\u0235"+
		"\u0001\u0000\u0000\u0000\u0238\u023b\u0001\u0000\u0000\u0000\u0239\u0237"+
		"\u0001\u0000\u0000\u0000\u0239\u023a\u0001\u0000\u0000\u0000\u023a\u023d"+
		"\u0001\u0000\u0000\u0000\u023b\u0239\u0001\u0000\u0000\u0000\u023c\u023e"+
		"\u0005\u0002\u0000\u0000\u023d\u023c\u0001\u0000\u0000\u0000\u023d\u023e"+
		"\u0001\u0000\u0000\u0000\u023e\u023f\u0001\u0000\u0000\u0000\u023f\u0240"+
		"\u0005\t\u0000\u0000\u0240\u0247\u0001\u0000\u0000\u0000\u0241\u0247\u0003"+
		"V+\u0000\u0242\u0244\u0005[\u0000\u0000\u0243\u0242\u0001\u0000\u0000"+
		"\u0000\u0243\u0244\u0001\u0000\u0000\u0000\u0244\u0245\u0001\u0000\u0000"+
		"\u0000\u0245\u0247\u0003\u00aeW\u0000\u0246\u0221\u0001\u0000\u0000\u0000"+
		"\u0246\u0223\u0001\u0000\u0000\u0000\u0246\u0231\u0001\u0000\u0000\u0000"+
		"\u0246\u0233\u0001\u0000\u0000\u0000\u0246\u0241\u0001\u0000\u0000\u0000"+
		"\u0246\u0243\u0001\u0000\u0000\u0000\u0247U\u0001\u0000\u0000\u0000\u0248"+
		"\u024a\u0003\u00c4b\u0000\u0249\u0248\u0001\u0000\u0000\u0000\u024a\u024b"+
		"\u0001\u0000\u0000\u0000\u024b\u0249\u0001\u0000\u0000\u0000\u024b\u024c"+
		"\u0001\u0000\u0000\u0000\u024cW\u0001\u0000\u0000\u0000\u024d\u024e\u0005"+
		"O\u0000\u0000\u024e\u024f\u0003\u00c4b\u0000\u024f\u0250\u0005*\u0000"+
		"\u0000\u0250\u0251\u0003\u00c4b\u0000\u0251Y\u0001\u0000\u0000\u0000\u0252"+
		"\u0253\u0007\u0002\u0000\u0000\u0253\u0254\u0003p8\u0000\u0254[\u0001"+
		"\u0000\u0000\u0000\u0255\u0256\u0005\u001d\u0000\u0000\u0256\u0257\u0003"+
		"p8\u0000\u0257]\u0001\u0000\u0000\u0000\u0258\u0259\u0005a\u0000\u0000"+
		"\u0259\u025a\u0003n7\u0000\u025a\u025e\u0003P(\u0000\u025b\u025d\u0003"+
		"`0\u0000\u025c\u025b\u0001\u0000\u0000\u0000\u025d\u0260\u0001\u0000\u0000"+
		"\u0000\u025e\u025c\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000\u0000"+
		"\u0000\u025f\u0262\u0001\u0000\u0000\u0000\u0260\u025e\u0001\u0000\u0000"+
		"\u0000\u0261\u0263\u0003b1\u0000\u0262\u0261\u0001\u0000\u0000\u0000\u0262"+
		"\u0263\u0001\u0000\u0000\u0000\u0263_\u0001\u0000\u0000\u0000\u0264\u0265"+
		"\u0005b\u0000\u0000\u0265\u0266\u0005a\u0000\u0000\u0266\u0267\u0003n"+
		"7\u0000\u0267\u0268\u0003P(\u0000\u0268a\u0001\u0000\u0000\u0000\u0269"+
		"\u026a\u0005b\u0000\u0000\u026a\u026b\u0003P(\u0000\u026bc\u0001\u0000"+
		"\u0000\u0000\u026c\u026e\u0003\u0094J\u0000\u026d\u026c\u0001\u0000\u0000"+
		"\u0000\u026e\u0271\u0001\u0000\u0000\u0000\u026f\u026d\u0001\u0000\u0000"+
		"\u0000\u026f\u0270\u0001\u0000\u0000\u0000\u0270\u0272\u0001\u0000\u0000"+
		"\u0000\u0271\u026f\u0001\u0000\u0000\u0000\u0272\u0273\u0005T\u0000\u0000"+
		"\u0273\u0274\u0003n7\u0000\u0274\u0275\u0003P(\u0000\u0275e\u0001\u0000"+
		"\u0000\u0000\u0276\u0278\u0003\u0094J\u0000\u0277\u0276\u0001\u0000\u0000"+
		"\u0000\u0278\u027b\u0001\u0000\u0000\u0000\u0279\u0277\u0001\u0000\u0000"+
		"\u0000\u0279\u027a\u0001\u0000\u0000\u0000\u027a\u027c\u0001\u0000\u0000"+
		"\u0000\u027b\u0279\u0001\u0000\u0000\u0000\u027c\u027d\u0005U\u0000\u0000"+
		"\u027d\u027e\u0003h4\u0000\u027e\u027f\u0003\u0088D\u0000\u027f\u0281"+
		"\u0003n7\u0000\u0280\u0282\u0003j5\u0000\u0281\u0280\u0001\u0000\u0000"+
		"\u0000\u0281\u0282\u0001\u0000\u0000\u0000\u0282\u0283\u0001\u0000\u0000"+
		"\u0000\u0283\u0284\u0003P(\u0000\u0284g\u0001\u0000\u0000\u0000\u0285"+
		"\u0287\u0005[\u0000\u0000\u0286\u0285\u0001\u0000\u0000\u0000\u0286\u0287"+
		"\u0001\u0000\u0000\u0000\u0287\u0288\u0001\u0000\u0000\u0000\u0288\u02a3"+
		"\u0003\u00aeW\u0000\u0289\u028e\u0003V+\u0000\u028a\u028b\u0005\u0002"+
		"\u0000\u0000\u028b\u028d\u0003V+\u0000\u028c\u028a\u0001\u0000\u0000\u0000"+
		"\u028d\u0290\u0001\u0000\u0000\u0000\u028e\u028c\u0001\u0000\u0000\u0000"+
		"\u028e\u028f\u0001\u0000\u0000\u0000\u028f\u0292\u0001\u0000\u0000\u0000"+
		"\u0290\u028e\u0001\u0000\u0000\u0000\u0291\u0293\u0005\u0002\u0000\u0000"+
		"\u0292\u0291\u0001\u0000\u0000\u0000\u0292\u0293\u0001\u0000\u0000\u0000"+
		"\u0293\u02a3\u0001\u0000\u0000\u0000\u0294\u0295\u0005\u0006\u0000\u0000"+
		"\u0295\u029a\u0003V+\u0000\u0296\u0297\u0005\u0002\u0000\u0000\u0297\u0299"+
		"\u0003V+\u0000\u0298\u0296\u0001\u0000\u0000\u0000\u0299\u029c\u0001\u0000"+
		"\u0000\u0000\u029a\u0298\u0001\u0000\u0000\u0000\u029a\u029b\u0001\u0000"+
		"\u0000\u0000\u029b\u029e\u0001\u0000\u0000\u0000\u029c\u029a\u0001\u0000"+
		"\u0000\u0000\u029d\u029f\u0005\u0002\u0000\u0000\u029e\u029d\u0001\u0000"+
		"\u0000\u0000\u029e\u029f\u0001\u0000\u0000\u0000\u029f\u02a0\u0001\u0000"+
		"\u0000\u0000\u02a0\u02a1\u0005\u0007\u0000\u0000\u02a1\u02a3\u0001\u0000"+
		"\u0000\u0000\u02a2\u0286\u0001\u0000\u0000\u0000\u02a2\u0289\u0001\u0000"+
		"\u0000\u0000\u02a2\u0294\u0001\u0000\u0000\u0000\u02a3i\u0001\u0000\u0000"+
		"\u0000\u02a4\u02a5\u0005a\u0000\u0000\u02a5\u02a6\u0003n7\u0000\u02a6"+
		"k\u0001\u0000\u0000\u0000\u02a7\u02a8\u00066\uffff\uffff\u0000\u02a8\u02ae"+
		"\u0003v;\u0000\u02a9\u02aa\u0003r9\u0000\u02aa\u02ab\u0003l6\u0002\u02ab"+
		"\u02ae\u0001\u0000\u0000\u0000\u02ac\u02ae\u0003x<\u0000\u02ad\u02a7\u0001"+
		"\u0000\u0000\u0000\u02ad\u02a9\u0001\u0000\u0000\u0000\u02ad\u02ac\u0001"+
		"\u0000\u0000\u0000\u02ae\u02cb\u0001\u0000\u0000\u0000\u02af\u02b0\n\t"+
		"\u0000\u0000\u02b0\u02b1\u0003~?\u0000\u02b1\u02b2\u0003l6\n\u02b2\u02ca"+
		"\u0001\u0000\u0000\u0000\u02b3\u02b4\n\b\u0000\u0000\u02b4\u02b5\u0003"+
		"\u0080@\u0000\u02b5\u02b6\u0003l6\t\u02b6\u02ca\u0001\u0000\u0000\u0000"+
		"\u02b7\u02b8\n\u0007\u0000\u0000\u02b8\u02b9\u0003\u0082A\u0000\u02b9"+
		"\u02ba\u0003l6\b\u02ba\u02ca\u0001\u0000\u0000\u0000\u02bb\u02bc\n\u0006"+
		"\u0000\u0000\u02bc\u02bd\u0003z=\u0000\u02bd\u02be\u0003l6\u0007\u02be"+
		"\u02ca\u0001\u0000\u0000\u0000\u02bf\u02c0\n\n\u0000\u0000\u02c0\u02ca"+
		"\u0003t:\u0000\u02c1\u02c2\n\u0005\u0000\u0000\u02c2\u02c3\u0003\u0086"+
		"C\u0000\u02c3\u02c4\u0003p8\u0000\u02c4\u02ca\u0001\u0000\u0000\u0000"+
		"\u02c5\u02c6\n\u0004\u0000\u0000\u02c6\u02c7\u0003\u0084B\u0000\u02c7"+
		"\u02c8\u0003p8\u0000\u02c8\u02ca\u0001\u0000\u0000\u0000\u02c9\u02af\u0001"+
		"\u0000\u0000\u0000\u02c9\u02b3\u0001\u0000\u0000\u0000\u02c9\u02b7\u0001"+
		"\u0000\u0000\u0000\u02c9\u02bb\u0001\u0000\u0000\u0000\u02c9\u02bf\u0001"+
		"\u0000\u0000\u0000\u02c9\u02c1\u0001\u0000\u0000\u0000\u02c9\u02c5\u0001"+
		"\u0000\u0000\u0000\u02ca\u02cd\u0001\u0000\u0000\u0000\u02cb\u02c9\u0001"+
		"\u0000\u0000\u0000\u02cb\u02cc\u0001\u0000\u0000\u0000\u02ccm\u0001\u0000"+
		"\u0000\u0000\u02cd\u02cb\u0001\u0000\u0000\u0000\u02ce\u02cf\u00067\uffff"+
		"\uffff\u0000\u02cf\u02d0\u0003r9\u0000\u02d0\u02d1\u0003n7\u0002\u02d1"+
		"\u02d4\u0001\u0000\u0000\u0000\u02d2\u02d4\u0003x<\u0000\u02d3\u02ce\u0001"+
		"\u0000\u0000\u0000\u02d3\u02d2\u0001\u0000\u0000\u0000\u02d4\u02ed\u0001"+
		"\u0000\u0000\u0000\u02d5\u02d6\n\u0007\u0000\u0000\u02d6\u02d7\u0003~"+
		"?\u0000\u02d7\u02d8\u0003n7\b\u02d8\u02ec\u0001\u0000\u0000\u0000\u02d9"+
		"\u02da\n\u0006\u0000\u0000\u02da\u02db\u0003\u0080@\u0000\u02db\u02dc"+
		"\u0003n7\u0007\u02dc\u02ec\u0001\u0000\u0000\u0000\u02dd\u02de\n\u0005"+
		"\u0000\u0000\u02de\u02df\u0003\u0082A\u0000\u02df\u02e0\u0003n7\u0006"+
		"\u02e0\u02ec\u0001\u0000\u0000\u0000\u02e1\u02e2\n\u0004\u0000\u0000\u02e2"+
		"\u02e3\u0003z=\u0000\u02e3\u02e4\u0003n7\u0005\u02e4\u02ec\u0001\u0000"+
		"\u0000\u0000\u02e5\u02e6\n\u0003\u0000\u0000\u02e6\u02e7\u0003\u0086C"+
		"\u0000\u02e7\u02e8\u0003n7\u0004\u02e8\u02ec\u0001\u0000\u0000\u0000\u02e9"+
		"\u02ea\n\b\u0000\u0000\u02ea\u02ec\u0003F#\u0000\u02eb\u02d5\u0001\u0000"+
		"\u0000\u0000\u02eb\u02d9\u0001\u0000\u0000\u0000\u02eb\u02dd\u0001\u0000"+
		"\u0000\u0000\u02eb\u02e1\u0001\u0000\u0000\u0000\u02eb\u02e5\u0001\u0000"+
		"\u0000\u0000\u02eb\u02e9\u0001\u0000\u0000\u0000\u02ec\u02ef\u0001\u0000"+
		"\u0000\u0000\u02ed\u02eb\u0001\u0000\u0000\u0000\u02ed\u02ee\u0001\u0000"+
		"\u0000\u0000\u02eeo\u0001\u0000\u0000\u0000\u02ef\u02ed\u0001\u0000\u0000"+
		"\u0000\u02f0\u02f1\u00068\uffff\uffff\u0000\u02f1\u02f2\u0003x<\u0000"+
		"\u02f2\u02fb\u0001\u0000\u0000\u0000\u02f3\u02f4\n\u0003\u0000\u0000\u02f4"+
		"\u02f5\u0003|>\u0000\u02f5\u02f6\u0003p8\u0004\u02f6\u02fa\u0001\u0000"+
		"\u0000\u0000\u02f7\u02f8\n\u0002\u0000\u0000\u02f8\u02fa\u0003\u008eG"+
		"\u0000\u02f9\u02f3\u0001\u0000\u0000\u0000\u02f9\u02f7\u0001\u0000\u0000"+
		"\u0000\u02fa\u02fd\u0001\u0000\u0000\u0000\u02fb\u02f9\u0001\u0000\u0000"+
		"\u0000\u02fb\u02fc\u0001\u0000\u0000\u0000\u02fcq\u0001\u0000\u0000\u0000"+
		"\u02fd\u02fb\u0001\u0000\u0000\u0000\u02fe\u02ff\u0007\u0003\u0000\u0000"+
		"\u02ffs\u0001\u0000\u0000\u0000\u0300\u030b\u0005:\u0000\u0000\u0301\u030b"+
		"\u0005E\u0000\u0000\u0302\u030b\u0003\u0090H\u0000\u0303\u030b\u0003\u0092"+
		"I\u0000\u0304\u030b\u0003\u008cF\u0000\u0305\u030b\u0003N\'\u0000\u0306"+
		"\u030b\u0003\u009eO\u0000\u0307\u030b\u0003\u00a0P\u0000\u0308\u030b\u0003"+
		"F#\u0000\u0309\u030b\u0003F#\u0000\u030a\u0300\u0001\u0000\u0000\u0000"+
		"\u030a\u0301\u0001\u0000\u0000\u0000\u030a\u0302\u0001\u0000\u0000\u0000"+
		"\u030a\u0303\u0001\u0000\u0000\u0000\u030a\u0304\u0001\u0000\u0000\u0000"+
		"\u030a\u0305\u0001\u0000\u0000\u0000\u030a\u0306\u0001\u0000\u0000\u0000"+
		"\u030a\u0307\u0001\u0000\u0000\u0000\u030a\u0308\u0001\u0000\u0000\u0000"+
		"\u030a\u0309\u0001\u0000\u0000\u0000\u030bu\u0001\u0000\u0000\u0000\u030c"+
		"\u030e\u0005d\u0000\u0000\u030d\u030f\u0003l6\u0000\u030e\u030d\u0001"+
		"\u0000\u0000\u0000\u030e\u030f\u0001\u0000\u0000\u0000\u030f\u0323\u0001"+
		"\u0000\u0000\u0000\u0310\u0311\u0005e\u0000\u0000\u0311\u0323\u0003l6"+
		"\u0000\u0312\u0323\u0005g\u0000\u0000\u0313\u0323\u0005h\u0000\u0000\u0314"+
		"\u0315\u0005i\u0000\u0000\u0315\u0323\u0003l6\u0000\u0316\u0318\u0005"+
		"f\u0000\u0000\u0317\u0319\u0005d\u0000\u0000\u0318\u0317\u0001\u0000\u0000"+
		"\u0000\u0318\u0319\u0001\u0000\u0000\u0000\u0319\u031b\u0001\u0000\u0000"+
		"\u0000\u031a\u031c\u0003l6\u0000\u031b\u031a\u0001\u0000\u0000\u0000\u031b"+
		"\u031c\u0001\u0000\u0000\u0000\u031c\u0323\u0001\u0000\u0000\u0000\u031d"+
		"\u031e\u0005f\u0000\u0000\u031e\u0323\u0005g\u0000\u0000\u031f\u0320\u0005"+
		"f\u0000\u0000\u0320\u0321\u0005Z\u0000\u0000\u0321\u0323\u0003l6\u0000"+
		"\u0322\u030c\u0001\u0000\u0000\u0000\u0322\u0310\u0001\u0000\u0000\u0000"+
		"\u0322\u0312\u0001\u0000\u0000\u0000\u0322\u0313\u0001\u0000\u0000\u0000"+
		"\u0322\u0314\u0001\u0000\u0000\u0000\u0322\u0316\u0001\u0000\u0000\u0000"+
		"\u0322\u031d\u0001\u0000\u0000\u0000\u0322\u031f\u0001\u0000\u0000\u0000"+
		"\u0323w\u0001\u0000\u0000\u0000\u0324\u0337\u0003\u0098L\u0000\u0325\u0337"+
		"\u0003^/\u0000\u0326\u0337\u0003\u009aM\u0000\u0327\u0337\u0003\u009c"+
		"N\u0000\u0328\u0337\u0003\u00b2Y\u0000\u0329\u0337\u0003D\"\u0000\u032a"+
		"\u0337\u0003\u00ccf\u0000\u032b\u0337\u0003\u00c8d\u0000\u032c\u0337\u0003"+
		"\u00c2a\u0000\u032d\u032e\u0005\u0006\u0000\u0000\u032e\u032f\u0003l6"+
		"\u0000\u032f\u0330\u0005\u0007\u0000\u0000\u0330\u0337\u0001\u0000\u0000"+
		"\u0000\u0331\u0332\u0005\b\u0000\u0000\u0332\u0333\u0003l6\u0000\u0333"+
		"\u0334\u0005\t\u0000\u0000\u0334\u0337\u0001\u0000\u0000\u0000\u0335\u0337"+
		"\u0005j\u0000\u0000\u0336\u0324\u0001\u0000\u0000\u0000\u0336\u0325\u0001"+
		"\u0000\u0000\u0000\u0336\u0326\u0001\u0000\u0000\u0000\u0336\u0327\u0001"+
		"\u0000\u0000\u0000\u0336\u0328\u0001\u0000\u0000\u0000\u0336\u0329\u0001"+
		"\u0000\u0000\u0000\u0336\u032a\u0001\u0000\u0000\u0000\u0336\u032b\u0001"+
		"\u0000\u0000\u0000\u0336\u032c\u0001\u0000\u0000\u0000\u0336\u032d\u0001"+
		"\u0000\u0000\u0000\u0336\u0331\u0001\u0000\u0000\u0000\u0336\u0335\u0001"+
		"\u0000\u0000\u0000\u0337y\u0001\u0000\u0000\u0000\u0338\u0339\u0007\u0004"+
		"\u0000\u0000\u0339{\u0001\u0000\u0000\u0000\u033a\u033b\u0007\u0005\u0000"+
		"\u0000\u033b}\u0001\u0000\u0000\u0000\u033c\u033d\u0007\u0006\u0000\u0000"+
		"\u033d\u007f\u0001\u0000\u0000\u0000\u033e\u033f\u0007\u0007\u0000\u0000"+
		"\u033f\u0081\u0001\u0000\u0000\u0000\u0340\u0341\u0007\b\u0000\u0000\u0341"+
		"\u0083\u0001\u0000\u0000\u0000\u0342\u0343\u0007\t\u0000\u0000\u0343\u0085"+
		"\u0001\u0000\u0000\u0000\u0344\u0348\u0005?\u0000\u0000\u0345\u0346\u0005"+
		"?\u0000\u0000\u0346\u0348\u0005;\u0000\u0000\u0347\u0344\u0001\u0000\u0000"+
		"\u0000\u0347\u0345\u0001\u0000\u0000\u0000\u0348\u0087\u0001\u0000\u0000"+
		"\u0000\u0349\u034a\u0007\n\u0000\u0000\u034a\u0089\u0001\u0000\u0000\u0000"+
		"\u034b\u034d\u0005\u0004\u0000\u0000\u034c\u034b\u0001\u0000\u0000\u0000"+
		"\u034c\u034d\u0001\u0000\u0000\u0000\u034d\u034e\u0001\u0000\u0000\u0000"+
		"\u034e\u034f\u0005 \u0000\u0000\u034f\u0350\u0003\u00c4b\u0000\u0350\u0351"+
		"\u0005$\u0000\u0000\u0351\u0357\u0001\u0000\u0000\u0000\u0352\u0353\u0005"+
		"\f\u0000\u0000\u0353\u0354\u0003\u00c4b\u0000\u0354\u0355\u0005\r\u0000"+
		"\u0000\u0355\u0357\u0001\u0000\u0000\u0000\u0356\u034c\u0001\u0000\u0000"+
		"\u0000\u0356\u0352\u0001\u0000\u0000\u0000\u0357\u008b\u0001\u0000\u0000"+
		"\u0000\u0358\u0359\u0005\u0004\u0000\u0000\u0359\u035a\u0005 \u0000\u0000"+
		"\u035a\u035b\u0003p8\u0000\u035b\u035c\u0005$\u0000\u0000\u035c\u0362"+
		"\u0001\u0000\u0000\u0000\u035d\u035e\u0005\f\u0000\u0000\u035e\u035f\u0003"+
		"p8\u0000\u035f\u0360\u0005\r\u0000\u0000\u0360\u0362\u0001\u0000\u0000"+
		"\u0000\u0361\u0358\u0001\u0000\u0000\u0000\u0361\u035d\u0001\u0000\u0000"+
		"\u0000\u0362\u008d\u0001\u0000\u0000\u0000\u0363\u0365\u0005\u0004\u0000"+
		"\u0000\u0364\u0363\u0001\u0000\u0000\u0000\u0364\u0365\u0001\u0000\u0000"+
		"\u0000\u0365\u0366\u0001\u0000\u0000\u0000\u0366\u0367\u0005 \u0000\u0000"+
		"\u0367\u0368\u0003p8\u0000\u0368\u0369\u0005$\u0000\u0000\u0369\u036f"+
		"\u0001\u0000\u0000\u0000\u036a\u036b\u0005\f\u0000\u0000\u036b\u036c\u0003"+
		"p8\u0000\u036c\u036d\u0005\r\u0000\u0000\u036d\u036f\u0001\u0000\u0000"+
		"\u0000\u036e\u0364\u0001\u0000\u0000\u0000\u036e\u036a\u0001\u0000\u0000"+
		"\u0000\u036f\u008f\u0001\u0000\u0000\u0000\u0370\u0371\u0005\b\u0000\u0000"+
		"\u0371\u0372\u0003l6\u0000\u0372\u0373\u0005\t\u0000\u0000\u0373\u0091"+
		"\u0001\u0000\u0000\u0000\u0374\u0375\u0005\u0004\u0000\u0000\u0375\u0376"+
		"\u0005\b\u0000\u0000\u0376\u0377\u0003l6\u0000\u0377\u0378\u0005\t\u0000"+
		"\u0000\u0378\u037e\u0001\u0000\u0000\u0000\u0379\u037a\u0005\u000e\u0000"+
		"\u0000\u037a\u037b\u0003l6\u0000\u037b\u037c\u0005\u000f\u0000\u0000\u037c"+
		"\u037e\u0001\u0000\u0000\u0000\u037d\u0374\u0001\u0000\u0000\u0000\u037d"+
		"\u0379\u0001\u0000\u0000\u0000\u037e\u0093\u0001\u0000\u0000\u0000\u037f"+
		"\u0380\u00054\u0000\u0000\u0380\u038e\u0003\u0096K\u0000\u0381\u0382\u0005"+
		"4\u0000\u0000\u0382\u0383\u0005\b\u0000\u0000\u0383\u0388\u0003\u0096"+
		"K\u0000\u0384\u0385\u0005\u0002\u0000\u0000\u0385\u0387\u0003\u0096K\u0000"+
		"\u0386\u0384\u0001\u0000\u0000\u0000\u0387\u038a\u0001\u0000\u0000\u0000"+
		"\u0388\u0386\u0001\u0000\u0000\u0000\u0388\u0389\u0001\u0000\u0000\u0000"+
		"\u0389\u038b\u0001\u0000\u0000\u0000\u038a\u0388\u0001\u0000\u0000\u0000"+
		"\u038b\u038c\u0005\t\u0000\u0000\u038c\u038e\u0001\u0000\u0000\u0000\u038d"+
		"\u037f\u0001\u0000\u0000\u0000\u038d\u0381\u0001\u0000\u0000\u0000\u038e"+
		"\u0095\u0001\u0000\u0000\u0000\u038f\u0391\u0003\u00c2a\u0000\u0390\u0392"+
		"\u0003>\u001f\u0000\u0391\u0390\u0001\u0000\u0000\u0000\u0391\u0392\u0001"+
		"\u0000\u0000\u0000\u0392\u0097\u0001\u0000\u0000\u0000\u0393\u0395\u0005"+
		"W\u0000\u0000\u0394\u0396\u0003p8\u0000\u0395\u0394\u0001\u0000\u0000"+
		"\u0000\u0395\u0396\u0001\u0000\u0000\u0000\u0396\u0397\u0001\u0000\u0000"+
		"\u0000\u0397\u0398\u0003P(\u0000\u0398\u0099\u0001\u0000\u0000\u0000\u0399"+
		"\u039a\u0005X\u0000\u0000\u039a\u039b\u0003n7\u0000\u039b\u039c\u0003"+
		"\u00a2Q\u0000\u039c\u009b\u0001\u0000\u0000\u0000\u039d\u039e\u0005Y\u0000"+
		"\u0000\u039e\u039f\u0003n7\u0000\u039f\u03a0\u0003\u00a2Q\u0000\u03a0"+
		"\u009d\u0001\u0000\u0000\u0000\u03a1\u03a3\u00059\u0000\u0000\u03a2\u03a1"+
		"\u0001\u0000\u0000\u0000\u03a2\u03a3\u0001\u0000\u0000\u0000\u03a3\u03a4"+
		"\u0001\u0000\u0000\u0000\u03a4\u03a5\u0005\u0001\u0000\u0000\u03a5\u03a7"+
		"\u0005X\u0000\u0000\u03a6\u03a8\u0003p8\u0000\u03a7\u03a6\u0001\u0000"+
		"\u0000\u0000\u03a7\u03a8\u0001\u0000\u0000\u0000\u03a8\u03a9\u0001\u0000"+
		"\u0000\u0000\u03a9\u03aa\u0003\u00a2Q\u0000\u03aa\u009f\u0001\u0000\u0000"+
		"\u0000\u03ab\u03ad\u00059\u0000\u0000\u03ac\u03ab\u0001\u0000\u0000\u0000"+
		"\u03ac\u03ad\u0001\u0000\u0000\u0000\u03ad\u03ae\u0001\u0000\u0000\u0000"+
		"\u03ae\u03af\u0005\u0001\u0000\u0000\u03af\u03b1\u0005Y\u0000\u0000\u03b0"+
		"\u03b2\u0003p8\u0000\u03b1\u03b0\u0001\u0000\u0000\u0000\u03b1\u03b2\u0001"+
		"\u0000\u0000\u0000\u03b2\u03b3\u0001\u0000\u0000\u0000\u03b3\u03b4\u0003"+
		"\u00a2Q\u0000\u03b4\u00a1\u0001\u0000\u0000\u0000\u03b5\u03b9\u0005\n"+
		"\u0000\u0000\u03b6\u03b8\u0003\u00a4R\u0000\u03b7\u03b6\u0001\u0000\u0000"+
		"\u0000\u03b8\u03bb\u0001\u0000\u0000\u0000\u03b9\u03b7\u0001\u0000\u0000"+
		"\u0000\u03b9\u03ba\u0001\u0000\u0000\u0000\u03ba\u03bc\u0001\u0000\u0000"+
		"\u0000\u03bb\u03b9\u0001\u0000\u0000\u0000\u03bc\u03bd\u0005\u000b\u0000"+
		"\u0000\u03bd\u00a3\u0001\u0000\u0000\u0000\u03be\u03c3\u0003\u00a8T\u0000"+
		"\u03bf\u03c3\u0003\u00aaU\u0000\u03c0\u03c3\u0003\u00acV\u0000\u03c1\u03c3"+
		"\u0003\b\u0004\u0000\u03c2\u03be\u0001\u0000\u0000\u0000\u03c2\u03bf\u0001"+
		"\u0000\u0000\u0000\u03c2\u03c0\u0001\u0000\u0000\u0000\u03c2\u03c1\u0001"+
		"\u0000\u0000\u0000\u03c3\u00a5\u0001\u0000\u0000\u0000\u03c4\u03c6\u0003"+
		"\u0094J\u0000\u03c5\u03c4\u0001\u0000\u0000\u0000\u03c6\u03c9\u0001\u0000"+
		"\u0000\u0000\u03c7\u03c5\u0001\u0000\u0000\u0000\u03c7\u03c8\u0001\u0000"+
		"\u0000\u0000\u03c8\u03ca\u0001\u0000\u0000\u0000\u03c9\u03c7\u0001\u0000"+
		"\u0000\u0000\u03ca\u03cb\u0005Z\u0000\u0000\u03cb\u03d3\u0003\u00c4b\u0000"+
		"\u03cc\u03cd\u0005Z\u0000\u0000\u03cd\u03cf\u0005\b\u0000\u0000\u03ce"+
		"\u03d0\u0003\u00c4b\u0000\u03cf\u03ce\u0001\u0000\u0000\u0000\u03cf\u03d0"+
		"\u0001\u0000\u0000\u0000\u03d0\u03d1\u0001\u0000\u0000\u0000\u03d1\u03d3"+
		"\u0005\t\u0000\u0000\u03d2\u03c7\u0001\u0000\u0000\u0000\u03d2\u03cc\u0001"+
		"\u0000\u0000\u0000\u03d3\u00a7\u0001\u0000\u0000\u0000\u03d4\u03d6\u0003"+
		"\u0094J\u0000\u03d5\u03d4\u0001\u0000\u0000\u0000\u03d6\u03d9\u0001\u0000"+
		"\u0000\u0000\u03d7\u03d5\u0001\u0000\u0000\u0000\u03d7\u03d8\u0001\u0000"+
		"\u0000\u0000\u03d8\u03da\u0001\u0000\u0000\u0000\u03d9\u03d7\u0001\u0000"+
		"\u0000\u0000\u03da\u03db\u0005\\\u0000\u0000\u03db\u03dc\u0003n7\u0000"+
		"\u03dc\u03e0\u0005\u0005\u0000\u0000\u03dd\u03df\u0003l6\u0000\u03de\u03dd"+
		"\u0001\u0000\u0000\u0000\u03df\u03e2\u0001\u0000\u0000\u0000\u03e0\u03de"+
		"\u0001\u0000\u0000\u0000\u03e0\u03e1\u0001\u0000\u0000\u0000\u03e1\u00a9"+
		"\u0001\u0000\u0000\u0000\u03e2\u03e0\u0001\u0000\u0000\u0000\u03e3\u03e5"+
		"\u0003\u0094J\u0000\u03e4\u03e3\u0001\u0000\u0000\u0000\u03e5\u03e8\u0001"+
		"\u0000\u0000\u0000\u03e6\u03e4\u0001\u0000\u0000\u0000\u03e6\u03e7\u0001"+
		"\u0000\u0000\u0000\u03e7\u03e9\u0001\u0000\u0000\u0000\u03e8\u03e6\u0001"+
		"\u0000\u0000\u0000\u03e9\u03ea\u0005b\u0000\u0000\u03ea\u03ee\u0005\u0005"+
		"\u0000\u0000\u03eb\u03ed\u0003l6\u0000\u03ec\u03eb\u0001\u0000\u0000\u0000"+
		"\u03ed\u03f0\u0001\u0000\u0000\u0000\u03ee\u03ec\u0001\u0000\u0000\u0000"+
		"\u03ee\u03ef\u0001\u0000\u0000\u0000\u03ef\u00ab\u0001\u0000\u0000\u0000"+
		"\u03f0\u03ee\u0001\u0000\u0000\u0000\u03f1\u03f3\u0003\u0094J\u0000\u03f2"+
		"\u03f1\u0001\u0000\u0000\u0000\u03f3\u03f6\u0001\u0000\u0000\u0000\u03f4"+
		"\u03f2\u0001\u0000\u0000\u0000\u03f4\u03f5\u0001\u0000\u0000\u0000\u03f5"+
		"\u03f7\u0001\u0000\u0000\u0000\u03f6\u03f4\u0001\u0000\u0000\u0000\u03f7"+
		"\u03f8\u0005[\u0000\u0000\u03f8\u03fa\u0003\u00aeW\u0000\u03f9\u03fb\u0003"+
		"j5\u0000\u03fa\u03f9\u0001\u0000\u0000\u0000\u03fa\u03fb\u0001\u0000\u0000"+
		"\u0000\u03fb\u03fc\u0001\u0000\u0000\u0000\u03fc\u0400\u0005\u0005\u0000"+
		"\u0000\u03fd\u03ff\u0003l6\u0000\u03fe\u03fd\u0001\u0000\u0000\u0000\u03ff"+
		"\u0402\u0001\u0000\u0000\u0000\u0400\u03fe\u0001\u0000\u0000\u0000\u0400"+
		"\u0401\u0001\u0000\u0000\u0000\u0401\u00ad\u0001\u0000\u0000\u0000\u0402"+
		"\u0400\u0001\u0000\u0000\u0000\u0403\u0404\u0003\u00c2a\u0000\u0404\u0405"+
		"\u0005\u0006\u0000\u0000\u0405\u0406\u0005\u0007\u0000\u0000\u0406\u0417"+
		"\u0001\u0000\u0000\u0000\u0407\u0408\u0003\u00c2a\u0000\u0408\u0409\u0005"+
		"\u0006\u0000\u0000\u0409\u040e\u0003\u00b0X\u0000\u040a\u040b\u0005\u0002"+
		"\u0000\u0000\u040b\u040d\u0003\u00b0X\u0000\u040c\u040a\u0001\u0000\u0000"+
		"\u0000\u040d\u0410\u0001\u0000\u0000\u0000\u040e\u040c\u0001\u0000\u0000"+
		"\u0000\u040e\u040f\u0001\u0000\u0000\u0000\u040f\u0412\u0001\u0000\u0000"+
		"\u0000\u0410\u040e\u0001\u0000\u0000\u0000\u0411\u0413\u0005\u0002\u0000"+
		"\u0000\u0412\u0411\u0001\u0000\u0000\u0000\u0412\u0413\u0001\u0000\u0000"+
		"\u0000\u0413\u0414\u0001\u0000\u0000\u0000\u0414\u0415\u0005\u0007\u0000"+
		"\u0000\u0415\u0417\u0001\u0000\u0000\u0000\u0416\u0403\u0001\u0000\u0000"+
		"\u0000\u0416\u0407\u0001\u0000\u0000\u0000\u0417\u00af\u0001\u0000\u0000"+
		"\u0000\u0418\u041b\u0003\u00aeW\u0000\u0419\u041b\u0003\u00c4b\u0000\u041a"+
		"\u0418\u0001\u0000\u0000\u0000\u041a\u0419\u0001\u0000\u0000\u0000\u041b"+
		"\u00b1\u0001\u0000\u0000\u0000\u041c\u041e\u0003\u0094J\u0000\u041d\u041c"+
		"\u0001\u0000\u0000\u0000\u041e\u0421\u0001\u0000\u0000\u0000\u041f\u041d"+
		"\u0001\u0000\u0000\u0000\u041f\u0420\u0001\u0000\u0000\u0000\u0420\u0422"+
		"\u0001\u0000\u0000\u0000\u0421\u041f\u0001\u0000\u0000\u0000\u0422\u0423"+
		"\u0005V\u0000\u0000\u0423\u0425\u0003\u00be_\u0000\u0424\u0426\u0003\u008e"+
		"G\u0000\u0425\u0424\u0001\u0000\u0000\u0000\u0425\u0426\u0001\u0000\u0000"+
		"\u0000\u0426\u0427\u0001\u0000\u0000\u0000\u0427\u0428\u0003\u00b4Z\u0000"+
		"\u0428\u00b3\u0001\u0000\u0000\u0000\u0429\u042b\u0003H$\u0000\u042a\u0429"+
		"\u0001\u0000\u0000\u0000\u042a\u042b\u0001\u0000\u0000\u0000\u042b\u042c"+
		"\u0001\u0000\u0000\u0000\u042c\u042f\u0003\u00b6[\u0000\u042d\u042f\u0003"+
		"H$\u0000\u042e\u042a\u0001\u0000\u0000\u0000\u042e\u042d\u0001\u0000\u0000"+
		"\u0000\u042f\u00b5\u0001\u0000\u0000\u0000\u0430\u0434\u0005\n\u0000\u0000"+
		"\u0431\u0433\u0003\u00b8\\\u0000\u0432\u0431\u0001\u0000\u0000\u0000\u0433"+
		"\u0436\u0001\u0000\u0000\u0000\u0434\u0432\u0001\u0000\u0000\u0000\u0434"+
		"\u0435\u0001\u0000\u0000\u0000\u0435\u0437\u0001\u0000\u0000\u0000\u0436"+
		"\u0434\u0001\u0000\u0000\u0000\u0437\u0438\u0005\u000b\u0000\u0000\u0438"+
		"\u00b7\u0001\u0000\u0000\u0000\u0439\u043c\u0003J%\u0000\u043a\u043c\u0003"+
		"\b\u0004\u0000\u043b\u0439\u0001\u0000\u0000\u0000\u043b\u043a\u0001\u0000"+
		"\u0000\u0000\u043c\u00b9\u0001\u0000\u0000\u0000\u043d\u043f\u0003\u00c4"+
		"b\u0000\u043e\u043d\u0001\u0000\u0000\u0000\u043f\u0442\u0001\u0000\u0000"+
		"\u0000\u0440\u043e\u0001\u0000\u0000\u0000\u0440\u0441\u0001\u0000\u0000"+
		"\u0000\u0441\u00bb\u0001\u0000\u0000\u0000\u0442\u0440\u0001\u0000\u0000"+
		"\u0000\u0443\u0445\u0003\u00c4b\u0000\u0444\u0443\u0001\u0000\u0000\u0000"+
		"\u0445\u0446\u0001\u0000\u0000\u0000\u0446\u0444\u0001\u0000\u0000\u0000"+
		"\u0446\u0447\u0001\u0000\u0000\u0000\u0447\u00bd\u0001\u0000\u0000\u0000"+
		"\u0448\u044a\u0003\u00c4b\u0000\u0449\u0448\u0001\u0000\u0000\u0000\u044a"+
		"\u044b\u0001\u0000\u0000\u0000\u044b\u0449\u0001\u0000\u0000\u0000\u044b"+
		"\u044c\u0001\u0000\u0000\u0000\u044c\u0451\u0001\u0000\u0000\u0000\u044d"+
		"\u044e\u0005\u0004\u0000\u0000\u044e\u0450\u0003\u00c4b\u0000\u044f\u044d"+
		"\u0001\u0000\u0000\u0000\u0450\u0453\u0001\u0000\u0000\u0000\u0451\u044f"+
		"\u0001\u0000\u0000\u0000\u0451\u0452\u0001\u0000\u0000\u0000\u0452\u00bf"+
		"\u0001\u0000\u0000\u0000\u0453\u0451\u0001\u0000\u0000\u0000\u0454\u0459"+
		"\u0003\u00c4b\u0000\u0455\u0456\u0007\u000b\u0000\u0000\u0456\u0458\u0003"+
		"\u00c4b\u0000\u0457\u0455\u0001\u0000\u0000\u0000\u0458\u045b\u0001\u0000"+
		"\u0000\u0000\u0459\u0457\u0001\u0000\u0000\u0000\u0459\u045a\u0001\u0000"+
		"\u0000\u0000\u045a\u00c1\u0001\u0000\u0000\u0000\u045b\u0459\u0001\u0000"+
		"\u0000\u0000\u045c\u0461\u0003\u00c4b\u0000\u045d\u045e\u0005\u0004\u0000"+
		"\u0000\u045e\u0460\u0003\u00c4b\u0000\u045f\u045d\u0001\u0000\u0000\u0000"+
		"\u0460\u0463\u0001\u0000\u0000\u0000\u0461\u045f\u0001\u0000\u0000\u0000"+
		"\u0461\u0462\u0001\u0000\u0000\u0000\u0462\u00c3\u0001\u0000\u0000\u0000"+
		"\u0463\u0461\u0001\u0000\u0000\u0000\u0464\u0465\u0007\f\u0000\u0000\u0465"+
		"\u00c5\u0001\u0000\u0000\u0000\u0466\u0467\u0007\r\u0000\u0000\u0467\u00c7"+
		"\u0001\u0000\u0000\u0000\u0468\u046a\u0003\u00c6c\u0000\u0469\u046b\u0003"+
		"\u00c4b\u0000\u046a\u0469\u0001\u0000\u0000\u0000\u046a\u046b\u0001\u0000"+
		"\u0000\u0000\u046b\u00c9\u0001\u0000\u0000\u0000\u046c\u046d\u0007\u000e"+
		"\u0000\u0000\u046d\u00cb\u0001\u0000\u0000\u0000\u046e\u0470\u0003\u00c4"+
		"b\u0000\u046f\u046e\u0001\u0000\u0000\u0000\u046f\u0470\u0001\u0000\u0000"+
		"\u0000\u0470\u0471\u0001\u0000\u0000\u0000\u0471\u0472\u0003\u00cae\u0000"+
		"\u0472\u00cd\u0001\u0000\u0000\u0000\u0082\u00d1\u00e6\u00ee\u00f7\u0101"+
		"\u0108\u010b\u0113\u011b\u011f\u0126\u012b\u012e\u0133\u0139\u013c\u013f"+
		"\u0144\u0147\u014f\u0158\u015e\u0163\u0172\u017a\u017e\u0184\u018b\u0195"+
		"\u019c\u01a1\u01a6\u01ae\u01b1\u01bd\u01c2\u01c7\u01cc\u01cf\u01d5\u01da"+
		"\u01df\u01e9\u01ed\u01f1\u01f8\u01fd\u0203\u0206\u020b\u0213\u021b\u021f"+
		"\u0229\u022d\u0239\u023d\u0243\u0246\u024b\u025e\u0262\u026f\u0279\u0281"+
		"\u0286\u028e\u0292\u029a\u029e\u02a2\u02ad\u02c9\u02cb\u02d3\u02eb\u02ed"+
		"\u02f9\u02fb\u030a\u030e\u0318\u031b\u0322\u0336\u0347\u034c\u0356\u0361"+
		"\u0364\u036e\u037d\u0388\u038d\u0391\u0395\u03a2\u03a7\u03ac\u03b1\u03b9"+
		"\u03c2\u03c7\u03cf\u03d2\u03d7\u03e0\u03e6\u03ee\u03f4\u03fa\u0400\u040e"+
		"\u0412\u0416\u041a\u041f\u0425\u042a\u042e\u0434\u043b\u0440\u0446\u044b"+
		"\u0451\u0459\u0461\u046a\u046f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}