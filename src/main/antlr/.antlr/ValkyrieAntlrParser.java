// Generated from c:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr/ValkyrieAntlr.g4 by ANTLR 4.13.1
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
		DOT=1, COMMA=2, SEMICOLON=3, FAKE_COLON=4, OP_PROPORTION=5, COLON=6, PARENTHESES_L=7, 
		PARENTHESES_R=8, BRACKET_L=9, BRACKET_R=10, BRACE_L=11, BRACE_R=12, GENERIC_L=13, 
		GENERIC_R=14, OFFSET_L=15, OFFSET_R=16, RANGE_L=17, RANGE_R=18, CEILING_L=19, 
		CEILING_R=20, FLOOR_L=21, FLOOR_R=22, COLLECTION_L=23, COLLECTION_R=24, 
		OP_ADD=25, OP_SUB=26, OP_INC=27, OP_DEC=28, OP_MUL=29, OP_DIV=30, OP_REM=31, 
		OP_DIV_REM=32, OP_EQ=33, OP_NE=34, OP_NEE=35, OP_EEE=36, OP_LEQ=37, OP_LLE=38, 
		OP_LLL=39, OP_LL=40, OP_LT=41, OP_GEQ=42, OP_GGE=43, OP_GGG=44, OP_GG=45, 
		OP_GT=46, OP_LEFT=47, OP_ARROW=48, OP_ARROW2=49, OP_ARROW3=50, OP_ASSIGN=51, 
		OP_BIND=52, OP_MAY_ASSIGN=53, OP_ADD_ASSIGN=54, OP_SUB_ASSIGN=55, OP_MUL_ASSIGN=56, 
		OP_DIV_ASSIGN=57, OP_BANG=58, OP_NOT=59, KW_NOT=60, LOGIC_AND=61, LOGIC_XAND=62, 
		LOGIC_NAND=63, LOGIC_OR=64, LOGIC_XOR=65, LOGIC_NOR=66, SET_INTERSECTION=67, 
		SET_UNION=68, OP_AND=69, OP_OR=70, OP_IMPL=71, OP_IFF=72, OP_MAP=73, OP_APPLY2=74, 
		OP_APPLY3=75, OP_AT=76, OP_HASH=77, LAMBDA_SLOT=78, MACRO_SLOT=79, OP_UNIMPLEMENTED=80, 
		OP_OR_DEFAULT=81, OP_OR_ELSE=82, OP_AND_THEN=83, OP_IN=84, KW_IN=85, OP_NOT_IN=86, 
		OP_CONTINUES=87, KW_IS=88, OP_SUP_TYPE=89, OP_IS=90, OP_IS_NOT=91, KW_AS=92, 
		OP_DOT3=93, OP_DOT2=94, OP_UNTIL=95, OP_POW=96, MAIN_PREFIX=97, OP_ROOT2=98, 
		MAIN_SUFFIX=99, OP_TRANSPOSE=100, OP_PERCENT=101, OP_REFERENCE=102, OP_LABEL=103, 
		OP_OUTPUT=104, OP_LAST=105, KW_NAMESPACE=106, KW_IMPORT=107, KW_EXTENSION=108, 
		KW_CLASS=109, KW_TRAIT=110, KW_UNION=111, KW_FLAGS=112, KW_TYPE=113, KW_TEMPLATE=114, 
		KW_EXTENDS=115, KW_IMPLEMENTS=116, KW_WHILE=117, KW_FOR=118, KW_LET=119, 
		KW_NEW=120, KW_OBJECT=121, KW_LAMBDA=122, KW_FUNCTION=123, KW_TRY=124, 
		KW_MATCH=125, KW_WITH=126, KW_CASE=127, KW_WHEN=128, KW_WHERE=129, INTEGER=130, 
		DECIMAL=131, STRING_START=132, KW_IF=133, KW_ELSE=134, KW_OTHERWISE=135, 
		RETURN=136, RESUME=137, YIELD=138, BREAK=139, CONTINUE=140, FALL_THROUGH=141, 
		RAISE=142, SPECIAL=143, RAW_ID=144, UNICODE_ID=145, LINE_COMMENT=146, 
		BLOCK_COMMENT=147, WHITE_SPACE=148, ERROR_CHARACTAR=149, STRING_TEXT=150, 
		STRING_END=151, STRING_OUT2=152, STRING_OUT3=153, STRING_OUT6=154, KW_SWITCH=155;
	public static final int
		RULE_program = 0, RULE_program_block = 1, RULE_program_term = 2, RULE_eos = 3, 
		RULE_eos_free = 4, RULE_define_namespace = 5, RULE_import_statement = 6, 
		RULE_import_term = 7, RULE_import_all = 8, RULE_import_space = 9, RULE_import_name = 10, 
		RULE_import_name_item = 11, RULE_import_block = 12, RULE_import_join = 13, 
		RULE_define_extension = 14, RULE_define_class = 15, RULE_class_block = 16, 
		RULE_class_statemnts = 17, RULE_class_inherit = 18, RULE_class_inherit_item = 19, 
		RULE_class_field = 20, RULE_class_method = 21, RULE_class_domain = 22, 
		RULE_define_trait = 23, RULE_trait_block = 24, RULE_trait_statement = 25, 
		RULE_define_trait_type = 26, RULE_define_extends = 27, RULE_extends_block = 28, 
		RULE_extends_statement = 29, RULE_with_implements = 30, RULE_define_union = 31, 
		RULE_base_layout = 32, RULE_union_block = 33, RULE_union_statements = 34, 
		RULE_define_variant = 35, RULE_variant_block = 36, RULE_define_flags = 37, 
		RULE_flags_block = 38, RULE_flags_statement = 39, RULE_flags_item = 40, 
		RULE_define_function = 41, RULE_function_parameters = 42, RULE_parameter_item = 43, 
		RULE_parameter_special = 44, RULE_return_part = 45, RULE_return_type = 46, 
		RULE_effect_type = 47, RULE_parameter_default = 48, RULE_dot_function_call = 49, 
		RULE_dot_closure_call = 50, RULE_tuple_call_body = 51, RULE_tuple_call_item = 52, 
		RULE_define_lambda = 53, RULE_function_block = 54, RULE_function_statement = 55, 
		RULE_let_binding = 56, RULE_let_pattern = 57, RULE_let_pattern_plain = 58, 
		RULE_let_pattern_tuple = 59, RULE_let_pattern_item = 60, RULE_define_type = 61, 
		RULE_type_hint = 62, RULE_type_pair = 63, RULE_if_statement = 64, RULE_guard_statement = 65, 
		RULE_else_if_statement = 66, RULE_loop_statement = 67, RULE_while_statement = 68, 
		RULE_while_let_statement = 69, RULE_for_statement = 70, RULE_for_dot_call = 71, 
		RULE_if_guard = 72, RULE_mark_label = 73, RULE_expression_root = 74, RULE_main_expression = 75, 
		RULE_main_dot_call = 76, RULE_inline_expression = 77, RULE_type_expression = 78, 
		RULE_leading_expression = 79, RULE_control_expression = 80, RULE_op_prefix = 81, 
		RULE_op_suffix = 82, RULE_op_compare = 83, RULE_op_pattern = 84, RULE_op_bitwise = 85, 
		RULE_infix_map = 86, RULE_infix_pow = 87, RULE_infix_range = 88, RULE_infix_arrows = 89, 
		RULE_op_multiple = 90, RULE_op_plus = 91, RULE_op_logic = 92, RULE_op_pipeline = 93, 
		RULE_infix_assign = 94, RULE_infix_is = 95, RULE_infix_as = 96, RULE_infix_in = 97, 
		RULE_define_generic = 98, RULE_generic_item = 99, RULE_generic_call = 100, 
		RULE_generic_call_in_type = 101, RULE_generic_pair = 102, RULE_define_label = 103, 
		RULE_template_call = 104, RULE_template_block = 105, RULE_template_statements = 106, 
		RULE_template_term = 107, RULE_template_implements = 108, RULE_where_block = 109, 
		RULE_where_bound = 110, RULE_require_block = 111, RULE_macro_call = 112, 
		RULE_macro_item = 113, RULE_attribute = 114, RULE_attribute_item = 115, 
		RULE_try_statement = 116, RULE_match_statement = 117, RULE_switch_statement = 118, 
		RULE_match_block = 119, RULE_dot_match_call = 120, RULE_match_terms = 121, 
		RULE_match_case_block = 122, RULE_case_pattern = 123, RULE_case_pattern_item = 124, 
		RULE_case_pattern_tuple = 125, RULE_object_statement = 126, RULE_new_statement = 127, 
		RULE_new_block = 128, RULE_new_call_item = 129, RULE_new_call_key = 130, 
		RULE_tuple_literal = 131, RULE_collection_pair = 132, RULE_collection_key = 133, 
		RULE_slice_call = 134, RULE_range_literal = 135, RULE_range_axis = 136, 
		RULE_modifiers = 137, RULE_modified_identifier = 138, RULE_modified_namepath = 139, 
		RULE_lambda_name = 140, RULE_output_name = 141, RULE_range_join = 142, 
		RULE_namepath_free = 143, RULE_namejoin_free = 144, RULE_namepath = 145, 
		RULE_namejoin = 146, RULE_identifier = 147, RULE_number = 148, RULE_number_literal = 149, 
		RULE_string = 150, RULE_string_literal = 151;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "program_block", "program_term", "eos", "eos_free", "define_namespace", 
			"import_statement", "import_term", "import_all", "import_space", "import_name", 
			"import_name_item", "import_block", "import_join", "define_extension", 
			"define_class", "class_block", "class_statemnts", "class_inherit", "class_inherit_item", 
			"class_field", "class_method", "class_domain", "define_trait", "trait_block", 
			"trait_statement", "define_trait_type", "define_extends", "extends_block", 
			"extends_statement", "with_implements", "define_union", "base_layout", 
			"union_block", "union_statements", "define_variant", "variant_block", 
			"define_flags", "flags_block", "flags_statement", "flags_item", "define_function", 
			"function_parameters", "parameter_item", "parameter_special", "return_part", 
			"return_type", "effect_type", "parameter_default", "dot_function_call", 
			"dot_closure_call", "tuple_call_body", "tuple_call_item", "define_lambda", 
			"function_block", "function_statement", "let_binding", "let_pattern", 
			"let_pattern_plain", "let_pattern_tuple", "let_pattern_item", "define_type", 
			"type_hint", "type_pair", "if_statement", "guard_statement", "else_if_statement", 
			"loop_statement", "while_statement", "while_let_statement", "for_statement", 
			"for_dot_call", "if_guard", "mark_label", "expression_root", "main_expression", 
			"main_dot_call", "inline_expression", "type_expression", "leading_expression", 
			"control_expression", "op_prefix", "op_suffix", "op_compare", "op_pattern", 
			"op_bitwise", "infix_map", "infix_pow", "infix_range", "infix_arrows", 
			"op_multiple", "op_plus", "op_logic", "op_pipeline", "infix_assign", 
			"infix_is", "infix_as", "infix_in", "define_generic", "generic_item", 
			"generic_call", "generic_call_in_type", "generic_pair", "define_label", 
			"template_call", "template_block", "template_statements", "template_term", 
			"template_implements", "where_block", "where_bound", "require_block", 
			"macro_call", "macro_item", "attribute", "attribute_item", "try_statement", 
			"match_statement", "switch_statement", "match_block", "dot_match_call", 
			"match_terms", "match_case_block", "case_pattern", "case_pattern_item", 
			"case_pattern_tuple", "object_statement", "new_statement", "new_block", 
			"new_call_item", "new_call_key", "tuple_literal", "collection_pair", 
			"collection_key", "slice_call", "range_literal", "range_axis", "modifiers", 
			"modified_identifier", "modified_namepath", "lambda_name", "output_name", 
			"range_join", "namepath_free", "namejoin_free", "namepath", "namejoin", 
			"identifier", "number", "number_literal", "string", "string_literal"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.'", null, "';'", null, null, null, "'('", "')'", "'['", "']'", 
			"'{'", "'}'", "'\\u27E8'", "'\\u27E9'", "'\\u2045'", "'\\u2046'", "'\\u27E6'", 
			"'\\u27E7'", "'\\u2308'", "'\\u2309'", "'\\u230A'", "'\\u230B'", "'\\u2983'", 
			"'\\u2984'", "'+'", "'-'", "'++'", "'--'", "'*'", null, "'\\u2052'", 
			null, "'=='", null, null, null, null, "'<<='", null, null, "'<'", null, 
			"'>>='", null, null, "'>'", null, null, null, "'==>'", "'='", null, "'?='", 
			"'+='", "'-='", "'*='", "'/='", "'!'", "'\\u00AC'", "'not'", null, "'\\u2A5F'", 
			"'\\u22BC'", null, "'\\u22BB'", "'\\u22BD'", "'\\u2229'", "'\\u222A'", 
			"'&'", "'|'", "'\\u203D'", "'\\u21D4'", null, null, null, "'@'", null, 
			null, null, null, "'??'", "'?:'", "'?'", null, "'in'", "'\\u2209'", null, 
			"'is'", "':>'", null, null, null, null, null, null, "'^'", null, "'\\u221A'", 
			null, null, "'%'", "'\\u203B'", "'\\u00B6'", null, null, null, null, 
			"'extension'", null, null, "'union'", null, "'type'", null, "'extends'", 
			"'implements'", null, "'for'", "'let'", "'new'", "'object'", "'lambda'", 
			null, "'try'", null, "'with'", "'case'", "'when'", "'where'", null, null, 
			null, "'if'", "'else'", "'otherwise'", "'return'", "'resume'", "'yield'", 
			"'break'", "'continue'", "'fallthrough'", "'raise'", null, null, null, 
			null, null, null, null, null, null, null, "'''''", "'\"\"\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DOT", "COMMA", "SEMICOLON", "FAKE_COLON", "OP_PROPORTION", "COLON", 
			"PARENTHESES_L", "PARENTHESES_R", "BRACKET_L", "BRACKET_R", "BRACE_L", 
			"BRACE_R", "GENERIC_L", "GENERIC_R", "OFFSET_L", "OFFSET_R", "RANGE_L", 
			"RANGE_R", "CEILING_L", "CEILING_R", "FLOOR_L", "FLOOR_R", "COLLECTION_L", 
			"COLLECTION_R", "OP_ADD", "OP_SUB", "OP_INC", "OP_DEC", "OP_MUL", "OP_DIV", 
			"OP_REM", "OP_DIV_REM", "OP_EQ", "OP_NE", "OP_NEE", "OP_EEE", "OP_LEQ", 
			"OP_LLE", "OP_LLL", "OP_LL", "OP_LT", "OP_GEQ", "OP_GGE", "OP_GGG", "OP_GG", 
			"OP_GT", "OP_LEFT", "OP_ARROW", "OP_ARROW2", "OP_ARROW3", "OP_ASSIGN", 
			"OP_BIND", "OP_MAY_ASSIGN", "OP_ADD_ASSIGN", "OP_SUB_ASSIGN", "OP_MUL_ASSIGN", 
			"OP_DIV_ASSIGN", "OP_BANG", "OP_NOT", "KW_NOT", "LOGIC_AND", "LOGIC_XAND", 
			"LOGIC_NAND", "LOGIC_OR", "LOGIC_XOR", "LOGIC_NOR", "SET_INTERSECTION", 
			"SET_UNION", "OP_AND", "OP_OR", "OP_IMPL", "OP_IFF", "OP_MAP", "OP_APPLY2", 
			"OP_APPLY3", "OP_AT", "OP_HASH", "LAMBDA_SLOT", "MACRO_SLOT", "OP_UNIMPLEMENTED", 
			"OP_OR_DEFAULT", "OP_OR_ELSE", "OP_AND_THEN", "OP_IN", "KW_IN", "OP_NOT_IN", 
			"OP_CONTINUES", "KW_IS", "OP_SUP_TYPE", "OP_IS", "OP_IS_NOT", "KW_AS", 
			"OP_DOT3", "OP_DOT2", "OP_UNTIL", "OP_POW", "MAIN_PREFIX", "OP_ROOT2", 
			"MAIN_SUFFIX", "OP_TRANSPOSE", "OP_PERCENT", "OP_REFERENCE", "OP_LABEL", 
			"OP_OUTPUT", "OP_LAST", "KW_NAMESPACE", "KW_IMPORT", "KW_EXTENSION", 
			"KW_CLASS", "KW_TRAIT", "KW_UNION", "KW_FLAGS", "KW_TYPE", "KW_TEMPLATE", 
			"KW_EXTENDS", "KW_IMPLEMENTS", "KW_WHILE", "KW_FOR", "KW_LET", "KW_NEW", 
			"KW_OBJECT", "KW_LAMBDA", "KW_FUNCTION", "KW_TRY", "KW_MATCH", "KW_WITH", 
			"KW_CASE", "KW_WHEN", "KW_WHERE", "INTEGER", "DECIMAL", "STRING_START", 
			"KW_IF", "KW_ELSE", "KW_OTHERWISE", "RETURN", "RESUME", "YIELD", "BREAK", 
			"CONTINUE", "FALL_THROUGH", "RAISE", "SPECIAL", "RAW_ID", "UNICODE_ID", 
			"LINE_COMMENT", "BLOCK_COMMENT", "WHITE_SPACE", "ERROR_CHARACTAR", "STRING_TEXT", 
			"STRING_END", "STRING_OUT2", "STRING_OUT3", "STRING_OUT6", "KW_SWITCH"
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
		public List<Program_termContext> program_term() {
			return getRuleContexts(Program_termContext.class);
		}
		public Program_termContext program_term(int i) {
			return getRuleContext(Program_termContext.class,i);
		}
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
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
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129095326360L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2161868596425258111L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 4202489L) != 0)) {
				{
				setState(306);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PARENTHESES_L:
				case BRACKET_L:
				case BRACE_L:
				case OFFSET_L:
				case CEILING_L:
				case FLOOR_L:
				case OP_ADD:
				case OP_SUB:
				case OP_MUL:
				case OP_BANG:
				case OP_NOT:
				case OP_AND:
				case OP_AT:
				case OP_HASH:
				case LAMBDA_SLOT:
				case OP_UNIMPLEMENTED:
				case OP_DOT3:
				case OP_DOT2:
				case MAIN_PREFIX:
				case OP_ROOT2:
				case OP_PERCENT:
				case OP_REFERENCE:
				case OP_LABEL:
				case OP_LAST:
				case KW_NAMESPACE:
				case KW_IMPORT:
				case KW_EXTENSION:
				case KW_CLASS:
				case KW_TRAIT:
				case KW_UNION:
				case KW_FLAGS:
				case KW_TYPE:
				case KW_TEMPLATE:
				case KW_EXTENDS:
				case KW_WHILE:
				case KW_FOR:
				case KW_LET:
				case KW_NEW:
				case KW_OBJECT:
				case KW_LAMBDA:
				case KW_FUNCTION:
				case KW_TRY:
				case KW_MATCH:
				case INTEGER:
				case DECIMAL:
				case STRING_START:
				case KW_IF:
				case RETURN:
				case RESUME:
				case YIELD:
				case BREAK:
				case CONTINUE:
				case FALL_THROUGH:
				case RAISE:
				case SPECIAL:
				case RAW_ID:
				case UNICODE_ID:
				case KW_SWITCH:
					{
					setState(304);
					program_term();
					}
					break;
				case SEMICOLON:
				case FAKE_COLON:
					{
					setState(305);
					eos();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(311);
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
	public static class Program_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Program_termContext> program_term() {
			return getRuleContexts(Program_termContext.class);
		}
		public Program_termContext program_term(int i) {
			return getRuleContext(Program_termContext.class,i);
		}
		public List<EosContext> eos() {
			return getRuleContexts(EosContext.class);
		}
		public EosContext eos(int i) {
			return getRuleContext(EosContext.class,i);
		}
		public Program_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterProgram_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitProgram_block(this);
		}
	}

	public final Program_blockContext program_block() throws RecognitionException {
		Program_blockContext _localctx = new Program_blockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(BRACE_L);
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129095326360L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2161868596425258111L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 4202489L) != 0)) {
				{
				setState(316);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PARENTHESES_L:
				case BRACKET_L:
				case BRACE_L:
				case OFFSET_L:
				case CEILING_L:
				case FLOOR_L:
				case OP_ADD:
				case OP_SUB:
				case OP_MUL:
				case OP_BANG:
				case OP_NOT:
				case OP_AND:
				case OP_AT:
				case OP_HASH:
				case LAMBDA_SLOT:
				case OP_UNIMPLEMENTED:
				case OP_DOT3:
				case OP_DOT2:
				case MAIN_PREFIX:
				case OP_ROOT2:
				case OP_PERCENT:
				case OP_REFERENCE:
				case OP_LABEL:
				case OP_LAST:
				case KW_NAMESPACE:
				case KW_IMPORT:
				case KW_EXTENSION:
				case KW_CLASS:
				case KW_TRAIT:
				case KW_UNION:
				case KW_FLAGS:
				case KW_TYPE:
				case KW_TEMPLATE:
				case KW_EXTENDS:
				case KW_WHILE:
				case KW_FOR:
				case KW_LET:
				case KW_NEW:
				case KW_OBJECT:
				case KW_LAMBDA:
				case KW_FUNCTION:
				case KW_TRY:
				case KW_MATCH:
				case INTEGER:
				case DECIMAL:
				case STRING_START:
				case KW_IF:
				case RETURN:
				case RESUME:
				case YIELD:
				case BREAK:
				case CONTINUE:
				case FALL_THROUGH:
				case RAISE:
				case SPECIAL:
				case RAW_ID:
				case UNICODE_ID:
				case KW_SWITCH:
					{
					setState(314);
					program_term();
					}
					break;
				case SEMICOLON:
				case FAKE_COLON:
					{
					setState(315);
					eos();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(321);
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
	public static class Program_termContext extends ParserRuleContext {
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
		public Define_flagsContext define_flags() {
			return getRuleContext(Define_flagsContext.class,0);
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
		public Let_bindingContext let_binding() {
			return getRuleContext(Let_bindingContext.class,0);
		}
		public Loop_statementContext loop_statement() {
			return getRuleContext(Loop_statementContext.class,0);
		}
		public Guard_statementContext guard_statement() {
			return getRuleContext(Guard_statementContext.class,0);
		}
		public Expression_rootContext expression_root() {
			return getRuleContext(Expression_rootContext.class,0);
		}
		public Program_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterProgram_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitProgram_term(this);
		}
	}

	public final Program_termContext program_term() throws RecognitionException {
		Program_termContext _localctx = new Program_termContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_program_term);
		try {
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				define_namespace();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				import_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(325);
				define_extension();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(326);
				define_class();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(327);
				define_union();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(328);
				define_flags();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(329);
				define_trait();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(330);
				define_extends();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(331);
				define_function();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(332);
				define_type();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(333);
				let_binding();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(334);
				loop_statement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(335);
				guard_statement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(336);
				expression_root();
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
		public TerminalNode FAKE_COLON() { return getToken(ValkyrieAntlrParser.FAKE_COLON, 0); }
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
	}

	public final EosContext eos() throws RecognitionException {
		EosContext _localctx = new EosContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_eos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			_la = _input.LA(1);
			if ( !(_la==SEMICOLON || _la==FAKE_COLON) ) {
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
	public static class Eos_freeContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(ValkyrieAntlrParser.COMMA, 0); }
		public TerminalNode SEMICOLON() { return getToken(ValkyrieAntlrParser.SEMICOLON, 0); }
		public TerminalNode FAKE_COLON() { return getToken(ValkyrieAntlrParser.FAKE_COLON, 0); }
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
	}

	public final Eos_freeContext eos_free() throws RecognitionException {
		Eos_freeContext _localctx = new Eos_freeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_eos_free);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0)) ) {
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
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_NAMESPACE() { return getToken(ValkyrieAntlrParser.KW_NAMESPACE, 0); }
		public Namepath_freeContext namepath_free() {
			return getRuleContext(Namepath_freeContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
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
	}

	public final Define_namespaceContext define_namespace() throws RecognitionException {
		Define_namespaceContext _localctx = new Define_namespaceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_define_namespace);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(343);
				attribute();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(349);
			modifiers();
			setState(350);
			match(KW_NAMESPACE);
			setState(351);
			namepath_free();
			setState(353);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(352);
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
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Import_blockContext import_block() {
			return getRuleContext(Import_blockContext.class,0);
		}
		public Import_termContext import_term() {
			return getRuleContext(Import_termContext.class,0);
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
	}

	public final Import_statementContext import_statement() throws RecognitionException {
		Import_statementContext _localctx = new Import_statementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_import_statement);
		int _la;
		try {
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(358);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(355);
					attribute();
					}
					}
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(361);
				match(KW_IMPORT);
				setState(362);
				eos_free();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(363);
					attribute();
					}
					}
					setState(368);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(369);
				match(KW_IMPORT);
				setState(370);
				import_block();
				setState(372);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(371);
					eos_free();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(377);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(374);
					attribute();
					}
					}
					setState(379);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(380);
				match(KW_IMPORT);
				setState(381);
				import_term();
				setState(383);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
				case 1:
					{
					setState(382);
					eos_free();
					}
					break;
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
	public static class Import_termContext extends ParserRuleContext {
		public Import_allContext import_all() {
			return getRuleContext(Import_allContext.class,0);
		}
		public Import_spaceContext import_space() {
			return getRuleContext(Import_spaceContext.class,0);
		}
		public Import_nameContext import_name() {
			return getRuleContext(Import_nameContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Import_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImport_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImport_term(this);
		}
	}

	public final Import_termContext import_term() throws RecognitionException {
		Import_termContext _localctx = new Import_termContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_import_term);
		try {
			setState(391);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				import_all();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				import_space();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(389);
				import_name();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
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
	public static class Import_allContext extends ParserRuleContext {
		public IdentifierContext path;
		public TerminalNode OP_MUL() { return getToken(ValkyrieAntlrParser.OP_MUL, 0); }
		public List<Import_joinContext> import_join() {
			return getRuleContexts(Import_joinContext.class);
		}
		public Import_joinContext import_join(int i) {
			return getRuleContext(Import_joinContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Import_allContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_all; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImport_all(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImport_all(this);
		}
	}

	public final Import_allContext import_all() throws RecognitionException {
		Import_allContext _localctx = new Import_allContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_import_all);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(393);
				((Import_allContext)_localctx).path = identifier();
				setState(394);
				import_join();
				}
				}
				setState(398); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==RAW_ID || _la==UNICODE_ID );
			{
			setState(400);
			match(OP_MUL);
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
	public static class Import_spaceContext extends ParserRuleContext {
		public IdentifierContext path;
		public Import_blockContext import_block() {
			return getRuleContext(Import_blockContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<Import_joinContext> import_join() {
			return getRuleContexts(Import_joinContext.class);
		}
		public Import_joinContext import_join(int i) {
			return getRuleContext(Import_joinContext.class,i);
		}
		public Import_spaceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_space; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImport_space(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImport_space(this);
		}
	}

	public final Import_spaceContext import_space() throws RecognitionException {
		Import_spaceContext _localctx = new Import_spaceContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_import_space);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			((Import_spaceContext)_localctx).path = identifier();
			setState(408);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(403);
					import_join();
					setState(404);
					((Import_spaceContext)_localctx).path = identifier();
					}
					} 
				}
				setState(410);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1073741858L) != 0)) {
				{
				setState(411);
				import_join();
				}
			}

			setState(414);
			import_block();
			}
		}
		catch (RecognitionException re) {
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
	public static class Import_nameContext extends ParserRuleContext {
		public IdentifierContext path;
		public Import_name_itemContext name;
		public Import_name_itemContext alias;
		public List<Import_name_itemContext> import_name_item() {
			return getRuleContexts(Import_name_itemContext.class);
		}
		public Import_name_itemContext import_name_item(int i) {
			return getRuleContext(Import_name_itemContext.class,i);
		}
		public List<Import_joinContext> import_join() {
			return getRuleContexts(Import_joinContext.class);
		}
		public Import_joinContext import_join(int i) {
			return getRuleContext(Import_joinContext.class,i);
		}
		public TerminalNode KW_AS() { return getToken(ValkyrieAntlrParser.KW_AS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Import_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImport_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImport_name(this);
		}
	}

	public final Import_nameContext import_name() throws RecognitionException {
		Import_nameContext _localctx = new Import_nameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_import_name);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(416);
					((Import_nameContext)_localctx).path = identifier();
					setState(417);
					import_join();
					}
					} 
				}
				setState(423);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(424);
			((Import_nameContext)_localctx).name = import_name_item();
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_AS) {
				{
				setState(425);
				match(KW_AS);
				setState(426);
				((Import_nameContext)_localctx).alias = import_name_item();
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
	public static class Import_name_itemContext extends ParserRuleContext {
		public Import_name_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_name_item; }
	 
		public Import_name_itemContext() { }
		public void copyFrom(Import_name_itemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportMacroContext extends Import_name_itemContext {
		public IdentifierContext item;
		public TerminalNode OP_AT() { return getToken(ValkyrieAntlrParser.OP_AT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ImportMacroContext(Import_name_itemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImportMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImportMacro(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportAttributeContext extends Import_name_itemContext {
		public IdentifierContext item;
		public TerminalNode OP_HASH() { return getToken(ValkyrieAntlrParser.OP_HASH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ImportAttributeContext(Import_name_itemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImportAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImportAttribute(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImportIdentifierContext extends Import_name_itemContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ImportIdentifierContext(Import_name_itemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImportIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImportIdentifier(this);
		}
	}

	public final Import_name_itemContext import_name_item() throws RecognitionException {
		Import_name_itemContext _localctx = new Import_name_itemContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_import_name_item);
		try {
			setState(434);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_AT:
				_localctx = new ImportMacroContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(429);
				match(OP_AT);
				setState(430);
				((ImportMacroContext)_localctx).item = identifier();
				}
				break;
			case OP_HASH:
				_localctx = new ImportAttributeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(431);
				match(OP_HASH);
				setState(432);
				((ImportAttributeContext)_localctx).item = identifier();
				}
				break;
			case RAW_ID:
			case UNICODE_ID:
				_localctx = new ImportIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(433);
				identifier();
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
	public static class Import_blockContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public List<Import_termContext> import_term() {
			return getRuleContexts(Import_termContext.class);
		}
		public Import_termContext import_term(int i) {
			return getRuleContext(Import_termContext.class,i);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public Import_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImport_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImport_block(this);
		}
	}

	public final Import_blockContext import_block() throws RecognitionException {
		Import_blockContext _localctx = new Import_blockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_import_block);
		int _la;
		try {
			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PARENTHESES_L:
				enterOuterAlt(_localctx, 1);
				{
				setState(436);
				match(PARENTHESES_L);
				setState(440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==OP_AT || _la==OP_HASH || _la==RAW_ID || _la==UNICODE_ID) {
					{
					{
					setState(437);
					import_term();
					}
					}
					setState(442);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(443);
				match(PARENTHESES_R);
				}
				break;
			case BRACKET_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(444);
				match(BRACKET_L);
				setState(448);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==OP_AT || _la==OP_HASH || _la==RAW_ID || _la==UNICODE_ID) {
					{
					{
					setState(445);
					import_term();
					}
					}
					setState(450);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(451);
				match(BRACKET_R);
				}
				break;
			case BRACE_L:
				enterOuterAlt(_localctx, 3);
				{
				setState(452);
				match(BRACE_L);
				setState(456);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==OP_AT || _la==OP_HASH || _la==RAW_ID || _la==UNICODE_ID) {
					{
					{
					setState(453);
					import_term();
					}
					}
					setState(458);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(459);
				match(BRACE_R);
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
	public static class Import_joinContext extends ParserRuleContext {
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public TerminalNode OP_DIV() { return getToken(ValkyrieAntlrParser.OP_DIV, 0); }
		public Import_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterImport_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitImport_join(this);
		}
	}

	public final Import_joinContext import_join() throws RecognitionException {
		Import_joinContext _localctx = new Import_joinContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_import_join);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1073741858L) != 0)) ) {
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
	}

	public final Define_extensionContext define_extension() throws RecognitionException {
		Define_extensionContext _localctx = new Define_extensionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_define_extension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(464);
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
		public Template_callContext template_call() {
			return getRuleContext(Template_callContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public Class_inheritContext class_inherit() {
			return getRuleContext(Class_inheritContext.class,0);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
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
	}

	public final Define_classContext define_class() throws RecognitionException {
		Define_classContext _localctx = new Define_classContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_define_class);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				{
				setState(466);
				template_call();
				}
				break;
			}
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(469);
				attribute();
				}
				}
				setState(474);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(475);
			modifiers();
			setState(476);
			match(KW_CLASS);
			setState(477);
			identifier();
			setState(479);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
				{
				setState(478);
				define_generic();
				}
			}

			setState(482);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESES_L) {
				{
				setState(481);
				class_inherit();
				}
			}

			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(484);
				type_hint();
				}
			}

			setState(487);
			class_block();
			setState(489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				setState(488);
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
	public static class Class_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Class_statemntsContext> class_statemnts() {
			return getRuleContexts(Class_statemntsContext.class);
		}
		public Class_statemntsContext class_statemnts(int i) {
			return getRuleContext(Class_statemntsContext.class,i);
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
	}

	public final Class_blockContext class_block() throws RecognitionException {
		Class_blockContext _localctx = new Class_blockContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_class_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(491);
			match(BRACE_L);
			setState(495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==OP_AT || _la==OP_HASH || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(492);
				class_statemnts();
				}
				}
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(498);
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
	public static class Class_statemntsContext extends ParserRuleContext {
		public Class_domainContext class_domain() {
			return getRuleContext(Class_domainContext.class,0);
		}
		public Class_methodContext class_method() {
			return getRuleContext(Class_methodContext.class,0);
		}
		public Class_fieldContext class_field() {
			return getRuleContext(Class_fieldContext.class,0);
		}
		public Macro_callContext macro_call() {
			return getRuleContext(Macro_callContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Class_statemntsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_statemnts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterClass_statemnts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitClass_statemnts(this);
		}
	}

	public final Class_statemntsContext class_statemnts() throws RecognitionException {
		Class_statemntsContext _localctx = new Class_statemntsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_class_statemnts);
		try {
			setState(505);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(500);
				class_domain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(501);
				class_method();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(502);
				class_field();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(503);
				macro_call();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(504);
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
		public List<Class_inherit_itemContext> class_inherit_item() {
			return getRuleContexts(Class_inherit_itemContext.class);
		}
		public Class_inherit_itemContext class_inherit_item(int i) {
			return getRuleContext(Class_inherit_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
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
	}

	public final Class_inheritContext class_inherit() throws RecognitionException {
		Class_inheritContext _localctx = new Class_inheritContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_class_inherit);
		int _la;
		try {
			int _alt;
			setState(523);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(507);
				match(PARENTHESES_L);
				setState(508);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(509);
				match(PARENTHESES_L);
				setState(510);
				class_inherit_item();
				setState(515);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(511);
						match(COMMA);
						setState(512);
						class_inherit_item();
						}
						} 
					}
					setState(517);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(518);
					match(COMMA);
					}
				}

				setState(521);
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
	public static class Class_inherit_itemContext extends ParserRuleContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public Class_inherit_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_inherit_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterClass_inherit_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitClass_inherit_item(this);
		}
	}

	public final Class_inherit_itemContext class_inherit_item() throws RecognitionException {
		Class_inherit_itemContext _localctx = new Class_inherit_itemContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_class_inherit_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				{
				setState(525);
				identifier();
				setState(526);
				match(COLON);
				}
				break;
			}
			setState(530);
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
	public static class Class_fieldContext extends ParserRuleContext {
		public Modified_identifierContext modified_identifier() {
			return getRuleContext(Modified_identifierContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
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
	}

	public final Class_fieldContext class_field() throws RecognitionException {
		Class_fieldContext _localctx = new Class_fieldContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_class_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(532);
				attribute();
				}
				}
				setState(537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(538);
			modified_identifier();
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(539);
				type_hint();
				}
			}

			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(542);
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
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public Return_partContext return_part() {
			return getRuleContext(Return_partContext.class,0);
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
	}

	public final Class_methodContext class_method() throws RecognitionException {
		Class_methodContext _localctx = new Class_methodContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_class_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(545);
				attribute();
				}
				}
				setState(550);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(551);
			modified_namepath();
			setState(553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
				{
				setState(552);
				define_generic();
				}
			}

			setState(555);
			function_parameters();
			setState(557);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(556);
				return_part();
				}
				break;
			}
			setState(560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BRACE_L) {
				{
				setState(559);
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
	public static class Class_domainContext extends ParserRuleContext {
		public Modified_identifierContext modified_identifier() {
			return getRuleContext(Modified_identifierContext.class,0);
		}
		public Program_blockContext program_block() {
			return getRuleContext(Program_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Class_domainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_domain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterClass_domain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitClass_domain(this);
		}
	}

	public final Class_domainContext class_domain() throws RecognitionException {
		Class_domainContext _localctx = new Class_domainContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_class_domain);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(562);
				attribute();
				}
				}
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(568);
			modified_identifier();
			setState(569);
			program_block();
			}
		}
		catch (RecognitionException re) {
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
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_TRAIT() { return getToken(ValkyrieAntlrParser.KW_TRAIT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Trait_blockContext trait_block() {
			return getRuleContext(Trait_blockContext.class,0);
		}
		public Template_callContext template_call() {
			return getRuleContext(Template_callContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public With_implementsContext with_implements() {
			return getRuleContext(With_implementsContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
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
	}

	public final Define_traitContext define_trait() throws RecognitionException {
		Define_traitContext _localctx = new Define_traitContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_define_trait);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(571);
				template_call();
				}
				break;
			}
			setState(577);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(574);
				attribute();
				}
				}
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(580);
			modifiers();
			setState(581);
			match(KW_TRAIT);
			setState(582);
			identifier();
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
				{
				setState(583);
				define_generic();
				}
			}

			setState(587);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==KW_IMPLEMENTS) {
				{
				setState(586);
				with_implements();
				}
			}

			setState(589);
			trait_block();
			setState(591);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(590);
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
	public static class Trait_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Trait_statementContext> trait_statement() {
			return getRuleContexts(Trait_statementContext.class);
		}
		public Trait_statementContext trait_statement(int i) {
			return getRuleContext(Trait_statementContext.class,i);
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
	}

	public final Trait_blockContext trait_block() throws RecognitionException {
		Trait_blockContext _localctx = new Trait_blockContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_trait_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			match(BRACE_L);
			setState(597);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==OP_HASH || _la==KW_TYPE || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(594);
				trait_statement();
				}
				}
				setState(599);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(600);
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
	public static class Trait_statementContext extends ParserRuleContext {
		public Define_trait_typeContext define_trait_type() {
			return getRuleContext(Define_trait_typeContext.class,0);
		}
		public Class_methodContext class_method() {
			return getRuleContext(Class_methodContext.class,0);
		}
		public Class_fieldContext class_field() {
			return getRuleContext(Class_fieldContext.class,0);
		}
		public Class_domainContext class_domain() {
			return getRuleContext(Class_domainContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Trait_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_trait_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTrait_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTrait_statement(this);
		}
	}

	public final Trait_statementContext trait_statement() throws RecognitionException {
		Trait_statementContext _localctx = new Trait_statementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_trait_statement);
		try {
			setState(607);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(602);
				define_trait_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(603);
				class_method();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(604);
				class_field();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(605);
				class_domain();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(606);
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
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_TYPE() { return getToken(ValkyrieAntlrParser.KW_TYPE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public List<Type_expressionContext> type_expression() {
			return getRuleContexts(Type_expressionContext.class);
		}
		public Type_expressionContext type_expression(int i) {
			return getRuleContext(Type_expressionContext.class,i);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
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
	}

	public final Define_trait_typeContext define_trait_type() throws RecognitionException {
		Define_trait_typeContext _localctx = new Define_trait_typeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_define_trait_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			modifiers();
			setState(610);
			match(KW_TYPE);
			setState(611);
			identifier();
			setState(614);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(612);
				match(COLON);
				setState(613);
				type_expression(0);
				}
			}

			setState(618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(616);
				match(OP_ASSIGN);
				setState(617);
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
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_EXTENDS() { return getToken(ValkyrieAntlrParser.KW_EXTENDS, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Extends_blockContext extends_block() {
			return getRuleContext(Extends_blockContext.class,0);
		}
		public Template_callContext template_call() {
			return getRuleContext(Template_callContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public With_implementsContext with_implements() {
			return getRuleContext(With_implementsContext.class,0);
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
	}

	public final Define_extendsContext define_extends() throws RecognitionException {
		Define_extendsContext _localctx = new Define_extendsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_define_extends);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,53,_ctx) ) {
			case 1:
				{
				setState(620);
				template_call();
				}
				break;
			}
			setState(626);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(623);
				attribute();
				}
				}
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(629);
			modifiers();
			setState(630);
			match(KW_EXTENDS);
			setState(631);
			namepath();
			setState(633);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
				{
				setState(632);
				define_generic();
				}
			}

			setState(636);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==KW_IMPLEMENTS) {
				{
				setState(635);
				with_implements();
				}
			}

			setState(638);
			extends_block();
			}
		}
		catch (RecognitionException re) {
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
	public static class Extends_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Extends_statementContext> extends_statement() {
			return getRuleContexts(Extends_statementContext.class);
		}
		public Extends_statementContext extends_statement(int i) {
			return getRuleContext(Extends_statementContext.class,i);
		}
		public Extends_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extends_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterExtends_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitExtends_block(this);
		}
	}

	public final Extends_blockContext extends_block() throws RecognitionException {
		Extends_blockContext _localctx = new Extends_blockContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_extends_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(BRACE_L);
			setState(644);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==OP_HASH || _la==KW_TYPE || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(641);
				extends_statement();
				}
				}
				setState(646);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(647);
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
	public static class Extends_statementContext extends ParserRuleContext {
		public Define_trait_typeContext define_trait_type() {
			return getRuleContext(Define_trait_typeContext.class,0);
		}
		public Class_methodContext class_method() {
			return getRuleContext(Class_methodContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Extends_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extends_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterExtends_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitExtends_statement(this);
		}
	}

	public final Extends_statementContext extends_statement() throws RecognitionException {
		Extends_statementContext _localctx = new Extends_statementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_extends_statement);
		try {
			setState(652);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(649);
				define_trait_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(650);
				class_method();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(651);
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
	public static class With_implementsContext extends ParserRuleContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public TerminalNode KW_IMPLEMENTS() { return getToken(ValkyrieAntlrParser.KW_IMPLEMENTS, 0); }
		public With_implementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_implements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterWith_implements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitWith_implements(this);
		}
	}

	public final With_implementsContext with_implements() throws RecognitionException {
		With_implementsContext _localctx = new With_implementsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_with_implements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(654);
			_la = _input.LA(1);
			if ( !(_la==COLON || _la==KW_IMPLEMENTS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(655);
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
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_UNION() { return getToken(ValkyrieAntlrParser.KW_UNION, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Union_blockContext union_block() {
			return getRuleContext(Union_blockContext.class,0);
		}
		public Template_callContext template_call() {
			return getRuleContext(Template_callContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public Base_layoutContext base_layout() {
			return getRuleContext(Base_layoutContext.class,0);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
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
	}

	public final Define_unionContext define_union() throws RecognitionException {
		Define_unionContext _localctx = new Define_unionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_define_union);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(658);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,59,_ctx) ) {
			case 1:
				{
				setState(657);
				template_call();
				}
				break;
			}
			setState(663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(660);
				attribute();
				}
				}
				setState(665);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(666);
			modifiers();
			setState(667);
			match(KW_UNION);
			setState(668);
			identifier();
			setState(670);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
				{
				setState(669);
				define_generic();
				}
			}

			setState(673);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESES_L) {
				{
				setState(672);
				base_layout();
				}
			}

			setState(676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(675);
				type_hint();
				}
			}

			setState(678);
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
	public static class Base_layoutContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Base_layoutContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_layout; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterBase_layout(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitBase_layout(this);
		}
	}

	public final Base_layoutContext base_layout() throws RecognitionException {
		Base_layoutContext _localctx = new Base_layoutContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_base_layout);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(680);
			match(PARENTHESES_L);
			setState(682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129092671616L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2305842926753674751L) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & 7L) != 0)) {
				{
				setState(681);
				type_expression(0);
				}
			}

			setState(684);
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
	}

	public final Union_blockContext union_block() throws RecognitionException {
		Union_blockContext _localctx = new Union_blockContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_union_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			match(BRACE_L);
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==OP_HASH || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(687);
				union_statements();
				}
				}
				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(693);
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
	}

	public final Union_statementsContext union_statements() throws RecognitionException {
		Union_statementsContext _localctx = new Union_statementsContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_union_statements);
		try {
			setState(698);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(695);
				class_method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(696);
				define_variant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(697);
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
	}

	public final Define_variantContext define_variant() throws RecognitionException {
		Define_variantContext _localctx = new Define_variantContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_define_variant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(700);
			identifier();
			setState(702);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BRACE_L) {
				{
				setState(701);
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
		public List<Class_fieldContext> class_field() {
			return getRuleContexts(Class_fieldContext.class);
		}
		public Class_fieldContext class_field(int i) {
			return getRuleContext(Class_fieldContext.class,i);
		}
		public List<Class_methodContext> class_method() {
			return getRuleContexts(Class_methodContext.class);
		}
		public Class_methodContext class_method(int i) {
			return getRuleContext(Class_methodContext.class,i);
		}
		public List<Eos_freeContext> eos_free() {
			return getRuleContexts(Eos_freeContext.class);
		}
		public Eos_freeContext eos_free(int i) {
			return getRuleContext(Eos_freeContext.class,i);
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
	}

	public final Variant_blockContext variant_block() throws RecognitionException {
		Variant_blockContext _localctx = new Variant_blockContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_variant_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			match(BRACE_L);
			setState(710);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==OP_HASH || _la==RAW_ID || _la==UNICODE_ID) {
				{
				setState(708);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,68,_ctx) ) {
				case 1:
					{
					setState(705);
					class_field();
					}
					break;
				case 2:
					{
					setState(706);
					class_method();
					}
					break;
				case 3:
					{
					setState(707);
					eos_free();
					}
					break;
				}
				}
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(713);
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
	public static class Define_flagsContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_FLAGS() { return getToken(ValkyrieAntlrParser.KW_FLAGS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Flags_blockContext flags_block() {
			return getRuleContext(Flags_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Base_layoutContext base_layout() {
			return getRuleContext(Base_layoutContext.class,0);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Define_flagsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_flags; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_flags(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_flags(this);
		}
	}

	public final Define_flagsContext define_flags() throws RecognitionException {
		Define_flagsContext _localctx = new Define_flagsContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_define_flags);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(715);
				attribute();
				}
				}
				setState(720);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(721);
			modifiers();
			setState(722);
			match(KW_FLAGS);
			setState(723);
			identifier();
			setState(725);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESES_L) {
				{
				setState(724);
				base_layout();
				}
			}

			setState(728);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(727);
				type_hint();
				}
			}

			setState(730);
			flags_block();
			}
		}
		catch (RecognitionException re) {
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
	public static class Flags_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Flags_statementContext> flags_statement() {
			return getRuleContexts(Flags_statementContext.class);
		}
		public Flags_statementContext flags_statement(int i) {
			return getRuleContext(Flags_statementContext.class,i);
		}
		public Flags_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flags_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFlags_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFlags_block(this);
		}
	}

	public final Flags_blockContext flags_block() throws RecognitionException {
		Flags_blockContext _localctx = new Flags_blockContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_flags_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(732);
			match(BRACE_L);
			setState(736);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==OP_HASH || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(733);
				flags_statement();
				}
				}
				setState(738);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(739);
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
	public static class Flags_statementContext extends ParserRuleContext {
		public Class_methodContext class_method() {
			return getRuleContext(Class_methodContext.class,0);
		}
		public Flags_itemContext flags_item() {
			return getRuleContext(Flags_itemContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Flags_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flags_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFlags_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFlags_statement(this);
		}
	}

	public final Flags_statementContext flags_statement() throws RecognitionException {
		Flags_statementContext _localctx = new Flags_statementContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_flags_statement);
		try {
			setState(744);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(741);
				class_method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(742);
				flags_item();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(743);
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
	public static class Flags_itemContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public Flags_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flags_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFlags_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFlags_item(this);
		}
	}

	public final Flags_itemContext flags_item() throws RecognitionException {
		Flags_itemContext _localctx = new Flags_itemContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_flags_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(749);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(746);
				attribute();
				}
				}
				setState(751);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(752);
			identifier();
			setState(755);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(753);
				match(OP_ASSIGN);
				setState(754);
				main_expression(0);
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
		public Template_callContext template_call() {
			return getRuleContext(Template_callContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public Return_partContext return_part() {
			return getRuleContext(Return_partContext.class,0);
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
	}

	public final Define_functionContext define_function() throws RecognitionException {
		Define_functionContext _localctx = new Define_functionContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_define_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,77,_ctx) ) {
			case 1:
				{
				setState(757);
				template_call();
				}
				break;
			}
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(760);
				attribute();
				}
				}
				setState(765);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(766);
			modifiers();
			setState(767);
			match(KW_FUNCTION);
			setState(768);
			namepath();
			setState(770);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
				{
				setState(769);
				define_generic();
				}
			}

			setState(772);
			function_parameters();
			setState(774);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				{
				setState(773);
				return_part();
				}
				break;
			}
			setState(776);
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
	}

	public final Function_parametersContext function_parameters() throws RecognitionException {
		Function_parametersContext _localctx = new Function_parametersContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_function_parameters);
		int _la;
		try {
			setState(791);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(778);
				match(PARENTHESES_L);
				setState(779);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(780);
				match(PARENTHESES_L);
				setState(781);
				parameter_item();
				setState(786);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(782);
					match(COMMA);
					setState(783);
					parameter_item();
					}
					}
					setState(788);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(789);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> mods = new ArrayList<IdentifierContext>();
		public IdentifierContext id;
		public Parameter_specialContext parameter_special() {
			return getRuleContext(Parameter_specialContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Parameter_defaultContext parameter_default() {
			return getRuleContext(Parameter_defaultContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OP_LT() { return getToken(ValkyrieAntlrParser.OP_LT, 0); }
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
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
	}

	public final Parameter_itemContext parameter_item() throws RecognitionException {
		Parameter_itemContext _localctx = new Parameter_itemContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_parameter_item);
		int _la;
		try {
			int _alt;
			setState(836);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,92,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(796);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(793);
					attribute();
					}
					}
					setState(798);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(802);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==RAW_ID || _la==UNICODE_ID) {
					{
					{
					setState(799);
					((Parameter_itemContext)_localctx).identifier = identifier();
					((Parameter_itemContext)_localctx).mods.add(((Parameter_itemContext)_localctx).identifier);
					}
					}
					setState(804);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(805);
				parameter_special();
				setState(807);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(806);
					((Parameter_itemContext)_localctx).id = identifier();
					}
				}

				setState(810);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(809);
					type_hint();
					}
				}

				setState(813);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_ASSIGN) {
					{
					setState(812);
					parameter_default();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(818);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(815);
					attribute();
					}
					}
					setState(820);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(824);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(821);
						((Parameter_itemContext)_localctx).identifier = identifier();
						((Parameter_itemContext)_localctx).mods.add(((Parameter_itemContext)_localctx).identifier);
						}
						} 
					}
					setState(826);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
				}
				setState(827);
				((Parameter_itemContext)_localctx).id = identifier();
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(828);
					type_hint();
					}
				}

				setState(832);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_ASSIGN) {
					{
					setState(831);
					parameter_default();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(834);
				match(OP_LT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(835);
				match(OP_GT);
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
	public static class Parameter_specialContext extends ParserRuleContext {
		public Parameter_specialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_special; }
	 
		public Parameter_specialContext() { }
		public void copyFrom(Parameter_specialContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DictParametersContext extends Parameter_specialContext {
		public TerminalNode OP_DOT3() { return getToken(ValkyrieAntlrParser.OP_DOT3, 0); }
		public DictParametersContext(Parameter_specialContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDictParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDictParameters(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ListParametersContext extends Parameter_specialContext {
		public TerminalNode OP_DOT2() { return getToken(ValkyrieAntlrParser.OP_DOT2, 0); }
		public ListParametersContext(Parameter_specialContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterListParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitListParameters(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContextParameterContext extends Parameter_specialContext {
		public TerminalNode OP_POW() { return getToken(ValkyrieAntlrParser.OP_POW, 0); }
		public ContextParameterContext(Parameter_specialContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterContextParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitContextParameter(this);
		}
	}

	public final Parameter_specialContext parameter_special() throws RecognitionException {
		Parameter_specialContext _localctx = new Parameter_specialContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_parameter_special);
		try {
			setState(841);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_DOT3:
				_localctx = new DictParametersContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(838);
				match(OP_DOT3);
				}
				break;
			case OP_DOT2:
				_localctx = new ListParametersContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(839);
				match(OP_DOT2);
				}
				break;
			case OP_POW:
				_localctx = new ContextParameterContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(840);
				match(OP_POW);
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
	public static class Return_partContext extends ParserRuleContext {
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Effect_typeContext effect_type() {
			return getRuleContext(Effect_typeContext.class,0);
		}
		public Return_partContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_part; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterReturn_part(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitReturn_part(this);
		}
	}

	public final Return_partContext return_part() throws RecognitionException {
		Return_partContext _localctx = new Return_partContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_return_part);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON || _la==OP_ARROW) {
				{
				setState(843);
				return_type();
				}
			}

			setState(847);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_DIV) {
				{
				setState(846);
				effect_type();
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
	public static class Return_typeContext extends ParserRuleContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public TerminalNode OP_ARROW() { return getToken(ValkyrieAntlrParser.OP_ARROW, 0); }
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitReturn_type(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			_la = _input.LA(1);
			if ( !(_la==COLON || _la==OP_ARROW) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(850);
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
	public static class Effect_typeContext extends ParserRuleContext {
		public TerminalNode OP_DIV() { return getToken(ValkyrieAntlrParser.OP_DIV, 0); }
		public List<Type_expressionContext> type_expression() {
			return getRuleContexts(Type_expressionContext.class);
		}
		public Type_expressionContext type_expression(int i) {
			return getRuleContext(Type_expressionContext.class,i);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public Effect_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_effect_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEffect_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEffect_type(this);
		}
	}

	public final Effect_typeContext effect_type() throws RecognitionException {
		Effect_typeContext _localctx = new Effect_typeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_effect_type);
		int _la;
		try {
			int _alt;
			setState(870);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(852);
				match(OP_DIV);
				setState(853);
				type_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(854);
				match(OP_DIV);
				setState(855);
				match(BRACKET_L);
				setState(867);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129092671616L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2305842926753674751L) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & 7L) != 0)) {
					{
					setState(856);
					type_expression(0);
					setState(861);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(857);
							match(COMMA);
							setState(858);
							type_expression(0);
							}
							} 
						}
						setState(863);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
					}
					setState(865);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(864);
						match(COMMA);
						}
					}

					}
				}

				setState(869);
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
	public static class Parameter_defaultContext extends ParserRuleContext {
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
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
	}

	public final Parameter_defaultContext parameter_default() throws RecognitionException {
		Parameter_defaultContext _localctx = new Parameter_defaultContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_parameter_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(872);
			match(OP_ASSIGN);
			setState(873);
			main_expression(0);
			}
		}
		catch (RecognitionException re) {
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
	public static class Dot_function_callContext extends ParserRuleContext {
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
		}
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public TerminalNode INTEGER() { return getToken(ValkyrieAntlrParser.INTEGER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_AT() { return getToken(ValkyrieAntlrParser.OP_AT, 0); }
		public Dot_function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDot_function_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDot_function_call(this);
		}
	}

	public final Dot_function_callContext dot_function_call() throws RecognitionException {
		Dot_function_callContext _localctx = new Dot_function_callContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_dot_function_call);
		int _la;
		try {
			setState(898);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(876);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_AND_THEN) {
					{
					setState(875);
					match(OP_AND_THEN);
					}
				}

				setState(878);
				tuple_call_body();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(880);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_AND_THEN) {
					{
					setState(879);
					match(OP_AND_THEN);
					}
				}

				setState(882);
				match(DOT);
				setState(883);
				match(INTEGER);
				setState(885);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
				case 1:
					{
					setState(884);
					tuple_call_body();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_AND_THEN) {
					{
					setState(887);
					match(OP_AND_THEN);
					}
				}

				setState(890);
				match(DOT);
				setState(892);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_AT) {
					{
					setState(891);
					match(OP_AT);
					}
				}

				setState(894);
				identifier();
				setState(896);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,105,_ctx) ) {
				case 1:
					{
					setState(895);
					tuple_call_body();
					}
					break;
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
	public static class Dot_closure_callContext extends ParserRuleContext {
		public Dot_closure_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_closure_call; }
	 
		public Dot_closure_callContext() { }
		public void copyFrom(Dot_closure_callContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SlotClosureContext extends Dot_closure_callContext {
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public SlotClosureContext(Dot_closure_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterSlotClosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitSlotClosure(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerClosureContext extends Dot_closure_callContext {
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public TerminalNode INTEGER() { return getToken(ValkyrieAntlrParser.INTEGER, 0); }
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public IntegerClosureContext(Dot_closure_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIntegerClosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIntegerClosure(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InternalClosureContext extends Dot_closure_callContext {
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public TerminalNode OP_AT() { return getToken(ValkyrieAntlrParser.OP_AT, 0); }
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public InternalClosureContext(Dot_closure_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInternalClosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInternalClosure(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NormalClosureContext extends Dot_closure_callContext {
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
		}
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public NormalClosureContext(Dot_closure_callContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNormalClosure(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNormalClosure(this);
		}
	}

	public final Dot_closure_callContext dot_closure_call() throws RecognitionException {
		Dot_closure_callContext _localctx = new Dot_closure_callContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_dot_closure_call);
		int _la;
		try {
			setState(940);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				_localctx = new NormalClosureContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(901);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_AND_THEN) {
					{
					setState(900);
					match(OP_AND_THEN);
					}
				}

				setState(908);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case BRACE_L:
					{
					setState(903);
					function_block();
					}
					break;
				case PARENTHESES_L:
					{
					setState(904);
					tuple_call_body();
					setState(906);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,108,_ctx) ) {
					case 1:
						{
						setState(905);
						function_block();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				_localctx = new SlotClosureContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(911);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_AND_THEN) {
					{
					setState(910);
					match(OP_AND_THEN);
					}
				}

				setState(913);
				match(DOT);
				setState(914);
				function_block();
				}
				break;
			case 3:
				_localctx = new IntegerClosureContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(916);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_AND_THEN) {
					{
					setState(915);
					match(OP_AND_THEN);
					}
				}

				setState(918);
				match(DOT);
				setState(919);
				match(INTEGER);
				setState(921);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(920);
					tuple_call_body();
					}
					break;
				}
				setState(924);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,113,_ctx) ) {
				case 1:
					{
					setState(923);
					function_block();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new InternalClosureContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(927);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_AND_THEN) {
					{
					setState(926);
					match(OP_AND_THEN);
					}
				}

				setState(929);
				match(DOT);
				setState(931);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_AT) {
					{
					setState(930);
					match(OP_AT);
					}
				}

				setState(933);
				identifier();
				setState(935);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
				case 1:
					{
					setState(934);
					tuple_call_body();
					}
					break;
				}
				setState(938);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
				case 1:
					{
					setState(937);
					function_block();
					}
					break;
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
	}

	public final Tuple_call_bodyContext tuple_call_body() throws RecognitionException {
		Tuple_call_bodyContext _localctx = new Tuple_call_bodyContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_tuple_call_body);
		int _la;
		try {
			int _alt;
			setState(958);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(942);
				match(PARENTHESES_L);
				setState(943);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(944);
				match(PARENTHESES_L);
				setState(945);
				tuple_call_item();
				setState(950);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(946);
						match(COMMA);
						setState(947);
						tuple_call_item();
						}
						} 
					}
					setState(952);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,119,_ctx);
				}
				setState(954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(953);
					match(COMMA);
					}
				}

				setState(956);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> mods = new ArrayList<IdentifierContext>();
		public IdentifierContext field;
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
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
	}

	public final Tuple_call_itemContext tuple_call_item() throws RecognitionException {
		Tuple_call_itemContext _localctx = new Tuple_call_itemContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_tuple_call_item);
		int _la;
		try {
			int _alt;
			setState(983);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(963);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(960);
					attribute();
					}
					}
					setState(965);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(969);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(966);
						((Tuple_call_itemContext)_localctx).identifier = identifier();
						((Tuple_call_itemContext)_localctx).mods.add(((Tuple_call_itemContext)_localctx).identifier);
						}
						} 
					}
					setState(971);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,123,_ctx);
				}
				setState(972);
				((Tuple_call_itemContext)_localctx).field = identifier();
				setState(973);
				match(COLON);
				setState(974);
				main_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(979);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(976);
						attribute();
						}
						} 
					}
					setState(981);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
				}
				setState(982);
				main_expression(0);
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
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Return_partContext return_part() {
			return getRuleContext(Return_partContext.class,0);
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
	}

	public final Define_lambdaContext define_lambda() throws RecognitionException {
		Define_lambdaContext _localctx = new Define_lambdaContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_define_lambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(988);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(985);
				attribute();
				}
				}
				setState(990);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(991);
			match(KW_LAMBDA);
			setState(992);
			function_parameters();
			setState(994);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				{
				setState(993);
				return_part();
				}
				break;
			}
			setState(996);
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
		public List<Function_statementContext> function_statement() {
			return getRuleContexts(Function_statementContext.class);
		}
		public Function_statementContext function_statement(int i) {
			return getRuleContext(Function_statementContext.class,i);
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
	}

	public final Function_blockContext function_block() throws RecognitionException {
		Function_blockContext _localctx = new Function_blockContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_function_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(998);
			match(BRACE_L);
			setState(1002);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129095326360L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2180006002798097535L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 4202489L) != 0)) {
				{
				{
				setState(999);
				function_statement();
				}
				}
				setState(1004);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1005);
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
	public static class Function_statementContext extends ParserRuleContext {
		public Define_typeContext define_type() {
			return getRuleContext(Define_typeContext.class,0);
		}
		public Let_bindingContext let_binding() {
			return getRuleContext(Let_bindingContext.class,0);
		}
		public Loop_statementContext loop_statement() {
			return getRuleContext(Loop_statementContext.class,0);
		}
		public Guard_statementContext guard_statement() {
			return getRuleContext(Guard_statementContext.class,0);
		}
		public Expression_rootContext expression_root() {
			return getRuleContext(Expression_rootContext.class,0);
		}
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public Function_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFunction_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFunction_statement(this);
		}
	}

	public final Function_statementContext function_statement() throws RecognitionException {
		Function_statementContext _localctx = new Function_statementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_function_statement);
		try {
			setState(1013);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1007);
				define_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1008);
				let_binding();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1009);
				loop_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1010);
				guard_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1011);
				expression_root();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1012);
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
	public static class Let_bindingContext extends ParserRuleContext {
		public TerminalNode KW_LET() { return getToken(ValkyrieAntlrParser.KW_LET, 0); }
		public Let_patternContext let_pattern() {
			return getRuleContext(Let_patternContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public Expression_rootContext expression_root() {
			return getRuleContext(Expression_rootContext.class,0);
		}
		public Let_bindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLet_binding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLet_binding(this);
		}
	}

	public final Let_bindingContext let_binding() throws RecognitionException {
		Let_bindingContext _localctx = new Let_bindingContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_let_binding);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1018);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1015);
				attribute();
				}
				}
				setState(1020);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1021);
			match(KW_LET);
			setState(1022);
			let_pattern();
			setState(1024);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1023);
				type_hint();
				}
			}

			setState(1028);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_ASSIGN) {
				{
				setState(1026);
				match(OP_ASSIGN);
				setState(1027);
				expression_root();
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
	public static class Let_patternContext extends ParserRuleContext {
		public Let_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_pattern; }
	 
		public Let_patternContext() { }
		public void copyFrom(Let_patternContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LP1Context extends Let_patternContext {
		public Let_pattern_tupleContext let_pattern_tuple() {
			return getRuleContext(Let_pattern_tupleContext.class,0);
		}
		public LP1Context(Let_patternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLP1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLP1(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LP2Context extends Let_patternContext {
		public Let_pattern_plainContext let_pattern_plain() {
			return getRuleContext(Let_pattern_plainContext.class,0);
		}
		public LP2Context(Let_patternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLP2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLP2(this);
		}
	}

	public final Let_patternContext let_pattern() throws RecognitionException {
		Let_patternContext _localctx = new Let_patternContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_let_pattern);
		try {
			setState(1032);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,133,_ctx) ) {
			case 1:
				_localctx = new LP1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1030);
				let_pattern_tuple();
				}
				break;
			case 2:
				_localctx = new LP2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1031);
				let_pattern_plain();
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
	public static class Let_pattern_plainContext extends ParserRuleContext {
		public List<Modified_identifierContext> modified_identifier() {
			return getRuleContexts(Modified_identifierContext.class);
		}
		public Modified_identifierContext modified_identifier(int i) {
			return getRuleContext(Modified_identifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public Let_pattern_plainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_pattern_plain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLet_pattern_plain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLet_pattern_plain(this);
		}
	}

	public final Let_pattern_plainContext let_pattern_plain() throws RecognitionException {
		Let_pattern_plainContext _localctx = new Let_pattern_plainContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_let_pattern_plain);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1034);
			modified_identifier();
			setState(1039);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1035);
					match(COMMA);
					setState(1036);
					modified_identifier();
					}
					} 
				}
				setState(1041);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			}
			setState(1043);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1042);
				match(COMMA);
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
	public static class Let_pattern_tupleContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public List<Let_pattern_itemContext> let_pattern_item() {
			return getRuleContexts(Let_pattern_itemContext.class);
		}
		public Let_pattern_itemContext let_pattern_item(int i) {
			return getRuleContext(Let_pattern_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public Let_pattern_tupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_pattern_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLet_pattern_tuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLet_pattern_tuple(this);
		}
	}

	public final Let_pattern_tupleContext let_pattern_tuple() throws RecognitionException {
		Let_pattern_tupleContext _localctx = new Let_pattern_tupleContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_let_pattern_tuple);
		int _la;
		try {
			int _alt;
			setState(1115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1045);
				match(PARENTHESES_L);
				setState(1059);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
				case 1:
					{
					setState(1046);
					let_pattern_item();
					setState(1047);
					match(COMMA);
					}
					break;
				case 2:
					{
					setState(1049);
					let_pattern_item();
					setState(1052); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1050);
							match(COMMA);
							setState(1051);
							let_pattern_item();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1054); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(1057);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1056);
						match(COMMA);
						}
					}

					}
					break;
				}
				setState(1061);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1062);
				namepath();
				setState(1063);
				match(PARENTHESES_L);
				setState(1075);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2688L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 6755399441055747L) != 0)) {
					{
					setState(1064);
					let_pattern_item();
					setState(1069);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1065);
							match(COMMA);
							setState(1066);
							let_pattern_item();
							}
							} 
						}
						setState(1071);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
					}
					setState(1073);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1072);
						match(COMMA);
						}
					}

					}
				}

				setState(1077);
				match(PARENTHESES_R);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1080);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(1079);
					namepath();
					}
				}

				setState(1082);
				match(BRACKET_L);
				setState(1094);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2688L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 6755399441055747L) != 0)) {
					{
					setState(1083);
					let_pattern_item();
					setState(1088);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1084);
							match(COMMA);
							setState(1085);
							let_pattern_item();
							}
							} 
						}
						setState(1090);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
					}
					setState(1092);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1091);
						match(COMMA);
						}
					}

					}
				}

				setState(1096);
				match(BRACKET_R);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1098);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(1097);
					namepath();
					}
				}

				setState(1100);
				match(BRACE_L);
				setState(1112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2688L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 6755399441055747L) != 0)) {
					{
					setState(1101);
					let_pattern_item();
					setState(1106);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1102);
							match(COMMA);
							setState(1103);
							let_pattern_item();
							}
							} 
						}
						setState(1108);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
					}
					setState(1110);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1109);
						match(COMMA);
						}
					}

					}
				}

				setState(1114);
				match(BRACE_R);
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
	public static class Let_pattern_itemContext extends ParserRuleContext {
		public IdentifierContext bind;
		public Let_pattern_tupleContext let_pattern_tuple() {
			return getRuleContext(Let_pattern_tupleContext.class,0);
		}
		public Modified_identifierContext modified_identifier() {
			return getRuleContext(Modified_identifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public TerminalNode OP_BIND() { return getToken(ValkyrieAntlrParser.OP_BIND, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OP_DOT2() { return getToken(ValkyrieAntlrParser.OP_DOT2, 0); }
		public TerminalNode OP_DOT3() { return getToken(ValkyrieAntlrParser.OP_DOT3, 0); }
		public Let_pattern_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_pattern_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLet_pattern_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLet_pattern_item(this);
		}
	}

	public final Let_pattern_itemContext let_pattern_item() throws RecognitionException {
		Let_pattern_itemContext _localctx = new Let_pattern_itemContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_let_pattern_item);
		int _la;
		try {
			setState(1154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1120);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
				case 1:
					{
					setState(1117);
					modified_identifier();
					setState(1118);
					match(COLON);
					}
					break;
				}
				setState(1125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,152,_ctx) ) {
				case 1:
					{
					setState(1122);
					((Let_pattern_itemContext)_localctx).bind = identifier();
					setState(1123);
					match(OP_BIND);
					}
					break;
				}
				setState(1127);
				let_pattern_tuple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1131);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,153,_ctx) ) {
				case 1:
					{
					setState(1128);
					modified_identifier();
					setState(1129);
					match(COLON);
					}
					break;
				}
				setState(1136);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,154,_ctx) ) {
				case 1:
					{
					setState(1133);
					((Let_pattern_itemContext)_localctx).bind = identifier();
					setState(1134);
					match(OP_BIND);
					}
					break;
				}
				setState(1138);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(1139);
					modified_identifier();
					}
				}

				setState(1142);
				match(OP_DOT2);
				setState(1144);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(1143);
					((Let_pattern_itemContext)_localctx).bind = identifier();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(1146);
					modified_identifier();
					}
				}

				setState(1149);
				match(OP_DOT3);
				setState(1151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(1150);
					((Let_pattern_itemContext)_localctx).bind = identifier();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1153);
				modified_identifier();
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
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_TYPE() { return getToken(ValkyrieAntlrParser.KW_TYPE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public Template_blockContext template_block() {
			return getRuleContext(Template_blockContext.class,0);
		}
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
	}

	public final Define_typeContext define_type() throws RecognitionException {
		Define_typeContext _localctx = new Define_typeContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_define_type);
		int _la;
		try {
			setState(1185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(1156);
					attribute();
					}
					}
					setState(1161);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1162);
				modifiers();
				setState(1163);
				match(KW_TYPE);
				setState(1164);
				identifier();
				setState(1166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
					{
					setState(1165);
					define_generic();
					}
				}

				setState(1168);
				match(OP_ASSIGN);
				setState(1169);
				type_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1174);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(1171);
					attribute();
					}
					}
					setState(1176);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1177);
				modifiers();
				setState(1178);
				match(KW_TYPE);
				setState(1179);
				identifier();
				setState(1181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
					{
					setState(1180);
					define_generic();
					}
				}

				setState(1183);
				template_block();
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
	public static class Type_hintContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
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
	}

	public final Type_hintContext type_hint() throws RecognitionException {
		Type_hintContext _localctx = new Type_hintContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_type_hint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1187);
			match(COLON);
			setState(1188);
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
	public static class Type_pairContext extends ParserRuleContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Collection_keyContext collection_key() {
			return getRuleContext(Collection_keyContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public Type_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterType_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitType_pair(this);
		}
	}

	public final Type_pairContext type_pair() throws RecognitionException {
		Type_pairContext _localctx = new Type_pairContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_type_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1193);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
			case 1:
				{
				setState(1190);
				collection_key();
				setState(1191);
				match(COLON);
				}
				break;
			}
			setState(1195);
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
		public Function_blockContext then_block;
		public Function_blockContext else_block;
		public TerminalNode KW_IF() { return getToken(ValkyrieAntlrParser.KW_IF, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public List<Function_blockContext> function_block() {
			return getRuleContexts(Function_blockContext.class);
		}
		public Function_blockContext function_block(int i) {
			return getRuleContext(Function_blockContext.class,i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<Else_if_statementContext> else_if_statement() {
			return getRuleContexts(Else_if_statementContext.class);
		}
		public Else_if_statementContext else_if_statement(int i) {
			return getRuleContext(Else_if_statementContext.class,i);
		}
		public TerminalNode KW_ELSE() { return getToken(ValkyrieAntlrParser.KW_ELSE, 0); }
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
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_if_statement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1197);
				attribute();
				}
				}
				setState(1202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1203);
			match(KW_IF);
			setState(1204);
			inline_expression(0);
			setState(1205);
			((If_statementContext)_localctx).then_block = function_block();
			setState(1209);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,167,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1206);
					else_if_statement();
					}
					} 
				}
				setState(1211);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,167,_ctx);
			}
			setState(1214);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				{
				setState(1212);
				match(KW_ELSE);
				setState(1213);
				((If_statementContext)_localctx).else_block = function_block();
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
	public static class Guard_statementContext extends ParserRuleContext {
		public Function_blockContext then;
		public TerminalNode KW_IF() { return getToken(ValkyrieAntlrParser.KW_IF, 0); }
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public TerminalNode KW_LET() { return getToken(ValkyrieAntlrParser.KW_LET, 0); }
		public TerminalNode KW_NOT() { return getToken(ValkyrieAntlrParser.KW_NOT, 0); }
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public Let_pattern_tupleContext let_pattern_tuple() {
			return getRuleContext(Let_pattern_tupleContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SPECIAL() { return getToken(ValkyrieAntlrParser.SPECIAL, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Guard_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterGuard_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitGuard_statement(this);
		}
	}

	public final Guard_statementContext guard_statement() throws RecognitionException {
		Guard_statementContext _localctx = new Guard_statementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_guard_statement);
		int _la;
		try {
			setState(1244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(1216);
					attribute();
					}
					}
					setState(1221);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1222);
				match(KW_IF);
				setState(1223);
				_la = _input.LA(1);
				if ( !(_la==KW_NOT || _la==KW_LET) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1227);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
				case 1:
					{
					setState(1224);
					let_pattern_tuple();
					}
					break;
				case 2:
					{
					setState(1225);
					identifier();
					}
					break;
				case 3:
					{
					setState(1226);
					match(SPECIAL);
					}
					break;
				}
				setState(1229);
				match(OP_ASSIGN);
				setState(1230);
				inline_expression(0);
				setState(1231);
				((Guard_statementContext)_localctx).then = function_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(1233);
					attribute();
					}
					}
					setState(1238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1239);
				match(KW_IF);
				setState(1240);
				_la = _input.LA(1);
				if ( !(_la==KW_NOT || _la==KW_LET) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1241);
				inline_expression(0);
				setState(1242);
				((Guard_statementContext)_localctx).then = function_block();
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
	}

	public final Else_if_statementContext else_if_statement() throws RecognitionException {
		Else_if_statementContext _localctx = new Else_if_statementContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_else_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1246);
			match(KW_ELSE);
			setState(1247);
			match(KW_IF);
			setState(1248);
			inline_expression(0);
			setState(1249);
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
	public static class Loop_statementContext extends ParserRuleContext {
		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class,0);
		}
		public While_let_statementContext while_let_statement() {
			return getRuleContext(While_let_statementContext.class,0);
		}
		public For_statementContext for_statement() {
			return getRuleContext(For_statementContext.class,0);
		}
		public Loop_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLoop_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLoop_statement(this);
		}
	}

	public final Loop_statementContext loop_statement() throws RecognitionException {
		Loop_statementContext _localctx = new Loop_statementContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_loop_statement);
		try {
			setState(1254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1251);
				while_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1252);
				while_let_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1253);
				for_statement();
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
	public static class While_statementContext extends ParserRuleContext {
		public TerminalNode KW_WHILE() { return getToken(ValkyrieAntlrParser.KW_WHILE, 0); }
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Mark_labelContext mark_label() {
			return getRuleContext(Mark_labelContext.class,0);
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
	}

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_while_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1256);
				attribute();
				}
				}
				setState(1261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1262);
			match(KW_WHILE);
			setState(1264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129095324288L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2305842926753674751L) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & 7L) != 0)) {
				{
				setState(1263);
				inline_expression(0);
				}
			}

			setState(1267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_HASH) {
				{
				setState(1266);
				mark_label();
				}
			}

			setState(1269);
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
	public static class While_let_statementContext extends ParserRuleContext {
		public TerminalNode KW_WHILE() { return getToken(ValkyrieAntlrParser.KW_WHILE, 0); }
		public TerminalNode KW_LET() { return getToken(ValkyrieAntlrParser.KW_LET, 0); }
		public Let_patternContext let_pattern() {
			return getRuleContext(Let_patternContext.class,0);
		}
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Mark_labelContext mark_label() {
			return getRuleContext(Mark_labelContext.class,0);
		}
		public While_let_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_let_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterWhile_let_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitWhile_let_statement(this);
		}
	}

	public final While_let_statementContext while_let_statement() throws RecognitionException {
		While_let_statementContext _localctx = new While_let_statementContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_while_let_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1271);
				attribute();
				}
				}
				setState(1276);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1277);
			match(KW_WHILE);
			setState(1278);
			match(KW_LET);
			setState(1279);
			let_pattern();
			setState(1280);
			match(OP_ASSIGN);
			setState(1281);
			inline_expression(0);
			setState(1283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_HASH) {
				{
				setState(1282);
				mark_label();
				}
			}

			setState(1285);
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
		public Inline_expressionContext cond;
		public TerminalNode KW_FOR() { return getToken(ValkyrieAntlrParser.KW_FOR, 0); }
		public Let_patternContext let_pattern() {
			return getRuleContext(Let_patternContext.class,0);
		}
		public Infix_inContext infix_in() {
			return getRuleContext(Infix_inContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public If_guardContext if_guard() {
			return getRuleContext(If_guardContext.class,0);
		}
		public Mark_labelContext mark_label() {
			return getRuleContext(Mark_labelContext.class,0);
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
	}

	public final For_statementContext for_statement() throws RecognitionException {
		For_statementContext _localctx = new For_statementContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_for_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1287);
				attribute();
				}
				}
				setState(1292);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1293);
			match(KW_FOR);
			setState(1294);
			let_pattern();
			setState(1295);
			infix_in();
			setState(1296);
			((For_statementContext)_localctx).cond = inline_expression(0);
			setState(1298);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_IF) {
				{
				setState(1297);
				if_guard();
				}
			}

			setState(1301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_HASH) {
				{
				setState(1300);
				mark_label();
				}
			}

			setState(1303);
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
	public static class For_dot_callContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public TerminalNode KW_FOR() { return getToken(ValkyrieAntlrParser.KW_FOR, 0); }
		public Let_patternContext let_pattern() {
			return getRuleContext(Let_patternContext.class,0);
		}
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public If_guardContext if_guard() {
			return getRuleContext(If_guardContext.class,0);
		}
		public Mark_labelContext mark_label() {
			return getRuleContext(Mark_labelContext.class,0);
		}
		public For_dot_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_dot_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterFor_dot_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitFor_dot_call(this);
		}
	}

	public final For_dot_callContext for_dot_call() throws RecognitionException {
		For_dot_callContext _localctx = new For_dot_callContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_for_dot_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_AND_THEN) {
				{
				setState(1305);
				match(OP_AND_THEN);
				}
			}

			setState(1308);
			match(DOT);
			setState(1309);
			match(KW_FOR);
			setState(1310);
			let_pattern();
			setState(1312);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_IF) {
				{
				setState(1311);
				if_guard();
				}
			}

			setState(1315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_HASH) {
				{
				setState(1314);
				mark_label();
				}
			}

			setState(1317);
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
	}

	public final If_guardContext if_guard() throws RecognitionException {
		If_guardContext _localctx = new If_guardContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_if_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1319);
			match(KW_IF);
			setState(1320);
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
	public static class Mark_labelContext extends ParserRuleContext {
		public TerminalNode OP_HASH() { return getToken(ValkyrieAntlrParser.OP_HASH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Mark_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mark_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMark_label(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMark_label(this);
		}
	}

	public final Mark_labelContext mark_label() throws RecognitionException {
		Mark_labelContext _localctx = new Mark_labelContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_mark_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1322);
			match(OP_HASH);
			setState(1323);
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
	public static class Expression_rootContext extends ParserRuleContext {
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public EosContext eos() {
			return getRuleContext(EosContext.class,0);
		}
		public Expression_rootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterExpression_root(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitExpression_root(this);
		}
	}

	public final Expression_rootContext expression_root() throws RecognitionException {
		Expression_rootContext _localctx = new Expression_rootContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_expression_root);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1328);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1325);
					attribute();
					}
					} 
				}
				setState(1330);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,185,_ctx);
			}
			setState(1331);
			main_expression(0);
			setState(1333);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_AND_THEN) {
				{
				setState(1332);
				match(OP_AND_THEN);
				}
			}

			setState(1336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
			case 1:
				{
				setState(1335);
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
	public static class Main_expressionContext extends ParserRuleContext {
		public Main_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_expression; }
	 
		public Main_expressionContext() { }
		public void copyFrom(Main_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EIfContext extends Main_expressionContext {
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public EIfContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEIf(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EUntilContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Infix_rangeContext infix_range() {
			return getRuleContext(Infix_rangeContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EUntilContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEUntil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEUntil(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EDotCallContext extends Main_expressionContext {
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public Main_dot_callContext main_dot_call() {
			return getRuleContext(Main_dot_callContext.class,0);
		}
		public EDotCallContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEDotCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEDotCall(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EInContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Infix_inContext infix_in() {
			return getRuleContext(Infix_inContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EInContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEIn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEIn(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EFloorContext extends Main_expressionContext {
		public TerminalNode FLOOR_L() { return getToken(ValkyrieAntlrParser.FLOOR_L, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public TerminalNode FLOOR_R() { return getToken(ValkyrieAntlrParser.FLOOR_R, 0); }
		public EFloorContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEFloor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEFloor(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EPlusContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Op_plusContext op_plus() {
			return getRuleContext(Op_plusContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EPlusContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEPlus(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ESliceContext extends Main_expressionContext {
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public Slice_callContext slice_call() {
			return getRuleContext(Slice_callContext.class,0);
		}
		public ESliceContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterESlice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitESlice(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ETryContext extends Main_expressionContext {
		public Try_statementContext try_statement() {
			return getRuleContext(Try_statementContext.class,0);
		}
		public ETryContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterETry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitETry(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EAsContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Type_expressionContext rhs;
		public Infix_asContext infix_as() {
			return getRuleContext(Infix_asContext.class,0);
		}
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public EAsContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEAs(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EObjectContext extends Main_expressionContext {
		public Object_statementContext object_statement() {
			return getRuleContext(Object_statementContext.class,0);
		}
		public EObjectContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEObject(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEObject(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ETupleContext extends Main_expressionContext {
		public Tuple_literalContext tuple_literal() {
			return getRuleContext(Tuple_literalContext.class,0);
		}
		public ETupleContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterETuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitETuple(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ERangeContext extends Main_expressionContext {
		public Range_literalContext range_literal() {
			return getRuleContext(Range_literalContext.class,0);
		}
		public ERangeContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterERange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitERange(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EAssignContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Infix_assignContext infix_assign() {
			return getRuleContext(Infix_assignContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EAssignContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEAssign(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EAtomContext extends Main_expressionContext {
		public Leading_expressionContext leading_expression() {
			return getRuleContext(Leading_expressionContext.class,0);
		}
		public EAtomContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEAtom(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EMulContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Op_multipleContext op_multiple() {
			return getRuleContext(Op_multipleContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EMulContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEMul(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EPipeContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Op_pipelineContext op_pipeline() {
			return getRuleContext(Op_pipelineContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EPipeContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEPipe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEPipe(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ELambdaContext extends Main_expressionContext {
		public Define_lambdaContext define_lambda() {
			return getRuleContext(Define_lambdaContext.class,0);
		}
		public ELambdaContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterELambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitELambda(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EOrElseContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public TerminalNode OP_OR_ELSE() { return getToken(ValkyrieAntlrParser.OP_OR_ELSE, 0); }
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EOrElseContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEOrElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEOrElse(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EGroupContext extends Main_expressionContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public EGroupContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEGroup(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EFunctionContext extends Main_expressionContext {
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public EFunctionContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEFunction(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ESuffixContext extends Main_expressionContext {
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public Op_suffixContext op_suffix() {
			return getRuleContext(Op_suffixContext.class,0);
		}
		public ESuffixContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterESuffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitESuffix(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EMatchContext extends Main_expressionContext {
		public Match_statementContext match_statement() {
			return getRuleContext(Match_statementContext.class,0);
		}
		public EMatchContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEMatch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEMatch(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EMacroContext extends Main_expressionContext {
		public Macro_callContext macro_call() {
			return getRuleContext(Macro_callContext.class,0);
		}
		public EMacroContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEMacro(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EPrefixContext extends Main_expressionContext {
		public Op_prefixContext op_prefix() {
			return getRuleContext(Op_prefixContext.class,0);
		}
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public EPrefixContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEPrefix(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ECompareContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Op_compareContext op_compare() {
			return getRuleContext(Op_compareContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public ECompareContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterECompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitECompare(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EGenericContext extends Main_expressionContext {
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public Generic_callContext generic_call() {
			return getRuleContext(Generic_callContext.class,0);
		}
		public EGenericContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEGeneric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEGeneric(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EIsAContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Type_expressionContext rhs;
		public Infix_isContext infix_is() {
			return getRuleContext(Infix_isContext.class,0);
		}
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public EIsAContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEIsA(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEIsA(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EPowContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Infix_powContext infix_pow() {
			return getRuleContext(Infix_powContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EPowContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEPow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEPow(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EDefineContext extends Main_expressionContext {
		public Define_labelContext define_label() {
			return getRuleContext(Define_labelContext.class,0);
		}
		public EDefineContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEDefine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEDefine(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ESwitchContext extends Main_expressionContext {
		public Switch_statementContext switch_statement() {
			return getRuleContext(Switch_statementContext.class,0);
		}
		public ESwitchContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterESwitch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitESwitch(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EMapContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Infix_mapContext infix_map() {
			return getRuleContext(Infix_mapContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EMapContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEMap(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ELogicContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Op_logicContext op_logic() {
			return getRuleContext(Op_logicContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public ELogicContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterELogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitELogic(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ELoopContext extends Main_expressionContext {
		public Loop_statementContext loop_statement() {
			return getRuleContext(Loop_statementContext.class,0);
		}
		public ELoopContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterELoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitELoop(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EControlContext extends Main_expressionContext {
		public Control_expressionContext control_expression() {
			return getRuleContext(Control_expressionContext.class,0);
		}
		public EControlContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEControl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEControl(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ENewContext extends Main_expressionContext {
		public New_statementContext new_statement() {
			return getRuleContext(New_statementContext.class,0);
		}
		public ENewContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterENew(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitENew(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ECeilingContext extends Main_expressionContext {
		public TerminalNode CEILING_L() { return getToken(ValkyrieAntlrParser.CEILING_L, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public TerminalNode CEILING_R() { return getToken(ValkyrieAntlrParser.CEILING_R, 0); }
		public ECeilingContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterECeiling(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitECeiling(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EBitwiseContext extends Main_expressionContext {
		public Main_expressionContext lhs;
		public Main_expressionContext rhs;
		public Op_bitwiseContext op_bitwise() {
			return getRuleContext(Op_bitwiseContext.class,0);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public EBitwiseContext(Main_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterEBitwise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitEBitwise(this);
		}
	}

	public final Main_expressionContext main_expression() throws RecognitionException {
		return main_expression(0);
	}

	private Main_expressionContext main_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Main_expressionContext _localctx = new Main_expressionContext(_ctx, _parentState);
		Main_expressionContext _prevctx = _localctx;
		int _startState = 150;
		enterRecursionRule(_localctx, 150, RULE_main_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1369);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,188,_ctx) ) {
			case 1:
				{
				_localctx = new EPrefixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1339);
				op_prefix();
				setState(1340);
				main_expression(33);
				}
				break;
			case 2:
				{
				_localctx = new EGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1342);
				match(PARENTHESES_L);
				setState(1343);
				main_expression(0);
				setState(1344);
				match(PARENTHESES_R);
				}
				break;
			case 3:
				{
				_localctx = new EFloorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1346);
				match(FLOOR_L);
				setState(1347);
				main_expression(0);
				setState(1348);
				match(FLOOR_R);
				}
				break;
			case 4:
				{
				_localctx = new ECeilingContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1350);
				match(CEILING_L);
				setState(1351);
				main_expression(0);
				setState(1352);
				match(CEILING_R);
				}
				break;
			case 5:
				{
				_localctx = new ELoopContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1354);
				loop_statement();
				}
				break;
			case 6:
				{
				_localctx = new EControlContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1355);
				control_expression();
				}
				break;
			case 7:
				{
				_localctx = new EIfContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1356);
				if_statement();
				}
				break;
			case 8:
				{
				_localctx = new ENewContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1357);
				new_statement();
				}
				break;
			case 9:
				{
				_localctx = new ETryContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1358);
				try_statement();
				}
				break;
			case 10:
				{
				_localctx = new ESwitchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1359);
				switch_statement();
				}
				break;
			case 11:
				{
				_localctx = new EMatchContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1360);
				match_statement();
				}
				break;
			case 12:
				{
				_localctx = new EObjectContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1361);
				object_statement();
				}
				break;
			case 13:
				{
				_localctx = new EMacroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1362);
				macro_call();
				}
				break;
			case 14:
				{
				_localctx = new ELambdaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1363);
				define_lambda();
				}
				break;
			case 15:
				{
				_localctx = new EFunctionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1364);
				function_block();
				}
				break;
			case 16:
				{
				_localctx = new EDefineContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1365);
				define_label();
				}
				break;
			case 17:
				{
				_localctx = new ETupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1366);
				tuple_literal();
				}
				break;
			case 18:
				{
				_localctx = new ERangeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1367);
				range_literal();
				}
				break;
			case 19:
				{
				_localctx = new EAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1368);
				leading_expression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1436);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1434);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
					case 1:
						{
						_localctx = new EPowContext(new Main_expressionContext(_parentctx, _parentState));
						((EPowContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1371);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(1372);
						infix_pow();
						setState(1373);
						((EPowContext)_localctx).rhs = main_expression(32);
						}
						break;
					case 2:
						{
						_localctx = new EMulContext(new Main_expressionContext(_parentctx, _parentState));
						((EMulContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1375);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(1376);
						op_multiple();
						setState(1377);
						((EMulContext)_localctx).rhs = main_expression(32);
						}
						break;
					case 3:
						{
						_localctx = new EPlusContext(new Main_expressionContext(_parentctx, _parentState));
						((EPlusContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1379);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(1380);
						op_plus();
						setState(1381);
						((EPlusContext)_localctx).rhs = main_expression(31);
						}
						break;
					case 4:
						{
						_localctx = new ECompareContext(new Main_expressionContext(_parentctx, _parentState));
						((ECompareContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1383);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(1384);
						op_compare();
						setState(1385);
						((ECompareContext)_localctx).rhs = main_expression(30);
						}
						break;
					case 5:
						{
						_localctx = new ELogicContext(new Main_expressionContext(_parentctx, _parentState));
						((ELogicContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1387);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(1388);
						op_logic();
						setState(1389);
						((ELogicContext)_localctx).rhs = main_expression(29);
						}
						break;
					case 6:
						{
						_localctx = new EBitwiseContext(new Main_expressionContext(_parentctx, _parentState));
						((EBitwiseContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1391);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(1392);
						op_bitwise();
						setState(1393);
						((EBitwiseContext)_localctx).rhs = main_expression(28);
						}
						break;
					case 7:
						{
						_localctx = new EUntilContext(new Main_expressionContext(_parentctx, _parentState));
						((EUntilContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1395);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(1396);
						infix_range();
						setState(1397);
						((EUntilContext)_localctx).rhs = main_expression(27);
						}
						break;
					case 8:
						{
						_localctx = new EMapContext(new Main_expressionContext(_parentctx, _parentState));
						((EMapContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1399);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(1400);
						infix_map();
						setState(1401);
						((EMapContext)_localctx).rhs = main_expression(26);
						}
						break;
					case 9:
						{
						_localctx = new EInContext(new Main_expressionContext(_parentctx, _parentState));
						((EInContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1403);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(1404);
						infix_in();
						setState(1405);
						((EInContext)_localctx).rhs = main_expression(23);
						}
						break;
					case 10:
						{
						_localctx = new EOrElseContext(new Main_expressionContext(_parentctx, _parentState));
						((EOrElseContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1407);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(1408);
						match(OP_OR_ELSE);
						setState(1409);
						((EOrElseContext)_localctx).rhs = main_expression(22);
						}
						break;
					case 11:
						{
						_localctx = new EPipeContext(new Main_expressionContext(_parentctx, _parentState));
						((EPipeContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1410);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(1411);
						op_pipeline();
						setState(1412);
						((EPipeContext)_localctx).rhs = main_expression(21);
						}
						break;
					case 12:
						{
						_localctx = new EAssignContext(new Main_expressionContext(_parentctx, _parentState));
						((EAssignContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1414);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(1415);
						infix_assign();
						setState(1416);
						((EAssignContext)_localctx).rhs = main_expression(19);
						}
						break;
					case 13:
						{
						_localctx = new ESuffixContext(new Main_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1418);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(1419);
						op_suffix();
						}
						break;
					case 14:
						{
						_localctx = new ESliceContext(new Main_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1420);
						if (!(precpred(_ctx, 36))) throw new FailedPredicateException(this, "precpred(_ctx, 36)");
						setState(1421);
						slice_call();
						}
						break;
					case 15:
						{
						_localctx = new EGenericContext(new Main_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1422);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(1423);
						generic_call();
						}
						break;
					case 16:
						{
						_localctx = new EDotCallContext(new Main_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1424);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(1425);
						main_dot_call();
						}
						break;
					case 17:
						{
						_localctx = new EIsAContext(new Main_expressionContext(_parentctx, _parentState));
						((EIsAContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1426);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(1427);
						infix_is();
						setState(1428);
						((EIsAContext)_localctx).rhs = type_expression(0);
						}
						break;
					case 18:
						{
						_localctx = new EAsContext(new Main_expressionContext(_parentctx, _parentState));
						((EAsContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_main_expression);
						setState(1430);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(1431);
						infix_as();
						setState(1432);
						((EAsContext)_localctx).rhs = type_expression(0);
						}
						break;
					}
					} 
				}
				setState(1438);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,190,_ctx);
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
	public static class Main_dot_callContext extends ParserRuleContext {
		public Dot_match_callContext dot_match_call() {
			return getRuleContext(Dot_match_callContext.class,0);
		}
		public For_dot_callContext for_dot_call() {
			return getRuleContext(For_dot_callContext.class,0);
		}
		public Dot_closure_callContext dot_closure_call() {
			return getRuleContext(Dot_closure_callContext.class,0);
		}
		public Main_dot_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main_dot_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMain_dot_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMain_dot_call(this);
		}
	}

	public final Main_dot_callContext main_dot_call() throws RecognitionException {
		Main_dot_callContext _localctx = new Main_dot_callContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_main_dot_call);
		try {
			setState(1442);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1439);
				dot_match_call();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1440);
				for_dot_call();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1441);
				dot_closure_call();
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
		public Inline_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inline_expression; }
	 
		public Inline_expressionContext() { }
		public void copyFrom(Inline_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ILogicContext extends Inline_expressionContext {
		public Inline_expressionContext lhs;
		public Inline_expressionContext rhs;
		public Op_logicContext op_logic() {
			return getRuleContext(Op_logicContext.class,0);
		}
		public List<Inline_expressionContext> inline_expression() {
			return getRuleContexts(Inline_expressionContext.class);
		}
		public Inline_expressionContext inline_expression(int i) {
			return getRuleContext(Inline_expressionContext.class,i);
		}
		public ILogicContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterILogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitILogic(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IPlusContext extends Inline_expressionContext {
		public Inline_expressionContext lhs;
		public Inline_expressionContext rhs;
		public Op_plusContext op_plus() {
			return getRuleContext(Op_plusContext.class,0);
		}
		public List<Inline_expressionContext> inline_expression() {
			return getRuleContexts(Inline_expressionContext.class);
		}
		public Inline_expressionContext inline_expression(int i) {
			return getRuleContext(Inline_expressionContext.class,i);
		}
		public IPlusContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIPlus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIPlus(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ICompareContext extends Inline_expressionContext {
		public Inline_expressionContext lhs;
		public Inline_expressionContext rhs;
		public Op_compareContext op_compare() {
			return getRuleContext(Op_compareContext.class,0);
		}
		public List<Inline_expressionContext> inline_expression() {
			return getRuleContexts(Inline_expressionContext.class);
		}
		public Inline_expressionContext inline_expression(int i) {
			return getRuleContext(Inline_expressionContext.class,i);
		}
		public ICompareContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterICompare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitICompare(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IGenericContext extends Inline_expressionContext {
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Generic_callContext generic_call() {
			return getRuleContext(Generic_callContext.class,0);
		}
		public IGenericContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIGeneric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIGeneric(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IFunctionContext extends Inline_expressionContext {
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Dot_function_callContext dot_function_call() {
			return getRuleContext(Dot_function_callContext.class,0);
		}
		public IFunctionContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIFunction(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IBitwiseContext extends Inline_expressionContext {
		public Inline_expressionContext lhs;
		public Inline_expressionContext rhs;
		public Op_bitwiseContext op_bitwise() {
			return getRuleContext(Op_bitwiseContext.class,0);
		}
		public List<Inline_expressionContext> inline_expression() {
			return getRuleContexts(Inline_expressionContext.class);
		}
		public Inline_expressionContext inline_expression(int i) {
			return getRuleContext(Inline_expressionContext.class,i);
		}
		public IBitwiseContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIBitwise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIBitwise(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IMapContext extends Inline_expressionContext {
		public Inline_expressionContext lhs;
		public Inline_expressionContext rhs;
		public Infix_mapContext infix_map() {
			return getRuleContext(Infix_mapContext.class,0);
		}
		public List<Inline_expressionContext> inline_expression() {
			return getRuleContexts(Inline_expressionContext.class);
		}
		public Inline_expressionContext inline_expression(int i) {
			return getRuleContext(Inline_expressionContext.class,i);
		}
		public IMapContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIMap(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IIsContext extends Inline_expressionContext {
		public Inline_expressionContext lhs;
		public Type_expressionContext rhs;
		public Infix_isContext infix_is() {
			return getRuleContext(Infix_isContext.class,0);
		}
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public IIsContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIIs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIIs(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ITupleContext extends Inline_expressionContext {
		public Tuple_literalContext tuple_literal() {
			return getRuleContext(Tuple_literalContext.class,0);
		}
		public ITupleContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterITuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitITuple(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IRangeContext extends Inline_expressionContext {
		public Inline_expressionContext lhs;
		public Inline_expressionContext rhs;
		public Range_literalContext range_literal() {
			return getRuleContext(Range_literalContext.class,0);
		}
		public Infix_rangeContext infix_range() {
			return getRuleContext(Infix_rangeContext.class,0);
		}
		public List<Inline_expressionContext> inline_expression() {
			return getRuleContexts(Inline_expressionContext.class);
		}
		public Inline_expressionContext inline_expression(int i) {
			return getRuleContext(Inline_expressionContext.class,i);
		}
		public IRangeContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIRange(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IGroupContext extends Inline_expressionContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public IGroupContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIGroup(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IMulContext extends Inline_expressionContext {
		public Inline_expressionContext lhs;
		public Inline_expressionContext rhs;
		public Op_multipleContext op_multiple() {
			return getRuleContext(Op_multipleContext.class,0);
		}
		public List<Inline_expressionContext> inline_expression() {
			return getRuleContexts(Inline_expressionContext.class);
		}
		public Inline_expressionContext inline_expression(int i) {
			return getRuleContext(Inline_expressionContext.class,i);
		}
		public IMulContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIMul(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIMul(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IAsContext extends Inline_expressionContext {
		public Inline_expressionContext lhs;
		public Type_expressionContext rhs;
		public Infix_asContext infix_as() {
			return getRuleContext(Infix_asContext.class,0);
		}
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public IAsContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIAs(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IPrefixContext extends Inline_expressionContext {
		public Op_prefixContext op_prefix() {
			return getRuleContext(Op_prefixContext.class,0);
		}
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public IPrefixContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIPrefix(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IFloorContext extends Inline_expressionContext {
		public TerminalNode FLOOR_L() { return getToken(ValkyrieAntlrParser.FLOOR_L, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public TerminalNode FLOOR_R() { return getToken(ValkyrieAntlrParser.FLOOR_R, 0); }
		public IFloorContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIFloor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIFloor(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IAtomContext extends Inline_expressionContext {
		public Leading_expressionContext leading_expression() {
			return getRuleContext(Leading_expressionContext.class,0);
		}
		public IAtomContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterIAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitIAtom(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ICeilingContext extends Inline_expressionContext {
		public TerminalNode CEILING_L() { return getToken(ValkyrieAntlrParser.CEILING_L, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public TerminalNode CEILING_R() { return getToken(ValkyrieAntlrParser.CEILING_R, 0); }
		public ICeilingContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterICeiling(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitICeiling(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ISliceContext extends Inline_expressionContext {
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Slice_callContext slice_call() {
			return getRuleContext(Slice_callContext.class,0);
		}
		public ISliceContext(Inline_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterISlice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitISlice(this);
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
		int _startState = 154;
		enterRecursionRule(_localctx, 154, RULE_inline_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1463);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,192,_ctx) ) {
			case 1:
				{
				_localctx = new IPrefixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1445);
				op_prefix();
				setState(1446);
				inline_expression(19);
				}
				break;
			case 2:
				{
				_localctx = new IGroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1448);
				match(PARENTHESES_L);
				setState(1449);
				main_expression(0);
				setState(1450);
				match(PARENTHESES_R);
				}
				break;
			case 3:
				{
				_localctx = new IFloorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1452);
				match(FLOOR_L);
				setState(1453);
				main_expression(0);
				setState(1454);
				match(FLOOR_R);
				}
				break;
			case 4:
				{
				_localctx = new ICeilingContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1456);
				match(CEILING_L);
				setState(1457);
				main_expression(0);
				setState(1458);
				match(CEILING_R);
				}
				break;
			case 5:
				{
				_localctx = new ITupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1460);
				tuple_literal();
				}
				break;
			case 6:
				{
				_localctx = new IRangeContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1461);
				range_literal();
				}
				break;
			case 7:
				{
				_localctx = new IAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1462);
				leading_expression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1509);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1507);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
					case 1:
						{
						_localctx = new IMulContext(new Inline_expressionContext(_parentctx, _parentState));
						((IMulContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1465);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1466);
						op_multiple();
						setState(1467);
						((IMulContext)_localctx).rhs = inline_expression(16);
						}
						break;
					case 2:
						{
						_localctx = new IPlusContext(new Inline_expressionContext(_parentctx, _parentState));
						((IPlusContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1469);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1470);
						op_plus();
						setState(1471);
						((IPlusContext)_localctx).rhs = inline_expression(15);
						}
						break;
					case 3:
						{
						_localctx = new ILogicContext(new Inline_expressionContext(_parentctx, _parentState));
						((ILogicContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1473);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1474);
						op_logic();
						setState(1475);
						((ILogicContext)_localctx).rhs = inline_expression(14);
						}
						break;
					case 4:
						{
						_localctx = new IBitwiseContext(new Inline_expressionContext(_parentctx, _parentState));
						((IBitwiseContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1477);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1478);
						op_bitwise();
						setState(1479);
						((IBitwiseContext)_localctx).rhs = inline_expression(13);
						}
						break;
					case 5:
						{
						_localctx = new IMapContext(new Inline_expressionContext(_parentctx, _parentState));
						((IMapContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1481);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1482);
						infix_map();
						setState(1483);
						((IMapContext)_localctx).rhs = inline_expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ICompareContext(new Inline_expressionContext(_parentctx, _parentState));
						((ICompareContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1485);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1486);
						op_compare();
						setState(1487);
						((ICompareContext)_localctx).rhs = inline_expression(11);
						}
						break;
					case 7:
						{
						_localctx = new IRangeContext(new Inline_expressionContext(_parentctx, _parentState));
						((IRangeContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1489);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1490);
						infix_range();
						setState(1491);
						((IRangeContext)_localctx).rhs = inline_expression(8);
						}
						break;
					case 8:
						{
						_localctx = new IFunctionContext(new Inline_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1493);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1494);
						dot_function_call();
						}
						break;
					case 9:
						{
						_localctx = new IGenericContext(new Inline_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1495);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(1496);
						generic_call();
						}
						break;
					case 10:
						{
						_localctx = new ISliceContext(new Inline_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1497);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1498);
						slice_call();
						}
						break;
					case 11:
						{
						_localctx = new IIsContext(new Inline_expressionContext(_parentctx, _parentState));
						((IIsContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1499);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1500);
						infix_is();
						setState(1501);
						((IIsContext)_localctx).rhs = type_expression(0);
						}
						break;
					case 12:
						{
						_localctx = new IAsContext(new Inline_expressionContext(_parentctx, _parentState));
						((IAsContext)_localctx).lhs = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
						setState(1503);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1504);
						infix_as();
						setState(1505);
						((IAsContext)_localctx).rhs = type_expression(0);
						}
						break;
					}
					} 
				}
				setState(1511);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
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
	public static class TBlockContext extends Type_expressionContext {
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public TBlockContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTBlock(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TPrefixContext extends Type_expressionContext {
		public Op_prefixContext op_prefix() {
			return getRuleContext(Op_prefixContext.class,0);
		}
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TPrefixContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTPrefix(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TGenericContext extends Type_expressionContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Generic_call_in_typeContext generic_call_in_type() {
			return getRuleContext(Generic_call_in_typeContext.class,0);
		}
		public TGenericContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTGeneric(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTGeneric(this);
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
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TTupleContext extends Type_expressionContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public List<Type_pairContext> type_pair() {
			return getRuleContexts(Type_pairContext.class);
		}
		public Type_pairContext type_pair(int i) {
			return getRuleContext(Type_pairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public TTupleContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTTuple(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TMustContext extends Type_expressionContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode OP_BANG() { return getToken(ValkyrieAntlrParser.OP_BANG, 0); }
		public TMustContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTMust(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTMust(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TAtomContext extends Type_expressionContext {
		public Leading_expressionContext leading_expression() {
			return getRuleContext(Leading_expressionContext.class,0);
		}
		public TAtomContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTAtom(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TAddContext extends Type_expressionContext {
		public List<Type_expressionContext> type_expression() {
			return getRuleContexts(Type_expressionContext.class);
		}
		public Type_expressionContext type_expression(int i) {
			return getRuleContext(Type_expressionContext.class,i);
		}
		public TerminalNode OP_ADD() { return getToken(ValkyrieAntlrParser.OP_ADD, 0); }
		public TAddContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTAdd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTAdd(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TKindContext extends Type_expressionContext {
		public TerminalNode OP_MUL() { return getToken(ValkyrieAntlrParser.OP_MUL, 0); }
		public TKindContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTKind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTKind(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TArrowsContext extends Type_expressionContext {
		public List<Type_expressionContext> type_expression() {
			return getRuleContexts(Type_expressionContext.class);
		}
		public Type_expressionContext type_expression(int i) {
			return getRuleContext(Type_expressionContext.class,i);
		}
		public Infix_arrowsContext infix_arrows() {
			return getRuleContext(Infix_arrowsContext.class,0);
		}
		public TArrowsContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTArrows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTArrows(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TOptionalContext extends Type_expressionContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public TOptionalContext(Type_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTOptional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTOptional(this);
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
		int _startState = 156;
		enterRecursionRule(_localctx, 156, RULE_type_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1536);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				{
				_localctx = new TPrefixContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1513);
				op_prefix();
				setState(1514);
				type_expression(11);
				}
				break;
			case 2:
				{
				_localctx = new TTupleContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1516);
				match(PARENTHESES_L);
				setState(1530);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
				case 1:
					{
					setState(1517);
					type_pair();
					setState(1518);
					match(COMMA);
					}
					break;
				case 2:
					{
					setState(1520);
					type_pair();
					setState(1523); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(1521);
							match(COMMA);
							setState(1522);
							type_pair();
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(1525); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(1528);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1527);
						match(COMMA);
						}
					}

					}
					break;
				}
				setState(1532);
				match(PARENTHESES_R);
				}
				break;
			case 3:
				{
				_localctx = new TBlockContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1533);
				function_block();
				}
				break;
			case 4:
				{
				_localctx = new TKindContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1534);
				match(OP_MUL);
				}
				break;
			case 5:
				{
				_localctx = new TAtomContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1535);
				leading_expression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1557);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1555);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
					case 1:
						{
						_localctx = new TPatternContext(new Type_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
						setState(1538);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1539);
						op_pattern();
						setState(1540);
						type_expression(8);
						}
						break;
					case 2:
						{
						_localctx = new TArrowsContext(new Type_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
						setState(1542);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1543);
						infix_arrows();
						setState(1544);
						type_expression(7);
						}
						break;
					case 3:
						{
						_localctx = new TAddContext(new Type_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
						setState(1546);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1547);
						match(OP_ADD);
						setState(1548);
						type_expression(6);
						}
						break;
					case 4:
						{
						_localctx = new TOptionalContext(new Type_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
						setState(1549);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1550);
						match(OP_AND_THEN);
						}
						break;
					case 5:
						{
						_localctx = new TMustContext(new Type_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
						setState(1551);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1552);
						match(OP_BANG);
						}
						break;
					case 6:
						{
						_localctx = new TGenericContext(new Type_expressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
						setState(1553);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1554);
						generic_call_in_type();
						}
						break;
					}
					} 
				}
				setState(1559);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,200,_ctx);
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
	public static class Leading_expressionContext extends ParserRuleContext {
		public Leading_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leading_expression; }
	 
		public Leading_expressionContext() { }
		public void copyFrom(Leading_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ASpecialContext extends Leading_expressionContext {
		public TerminalNode SPECIAL() { return getToken(ValkyrieAntlrParser.SPECIAL, 0); }
		public ASpecialContext(Leading_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterASpecial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitASpecial(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ALambdaContext extends Leading_expressionContext {
		public Lambda_nameContext lambda_name() {
			return getRuleContext(Lambda_nameContext.class,0);
		}
		public ALambdaContext(Leading_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterALambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitALambda(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AUNIMPLEMENTEDContext extends Leading_expressionContext {
		public TerminalNode OP_UNIMPLEMENTED() { return getToken(ValkyrieAntlrParser.OP_UNIMPLEMENTED, 0); }
		public AUNIMPLEMENTEDContext(Leading_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterAUNIMPLEMENTED(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitAUNIMPLEMENTED(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ANumberContext extends Leading_expressionContext {
		public Number_literalContext number_literal() {
			return getRuleContext(Number_literalContext.class,0);
		}
		public ANumberContext(Leading_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterANumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitANumber(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AOutputContext extends Leading_expressionContext {
		public Output_nameContext output_name() {
			return getRuleContext(Output_nameContext.class,0);
		}
		public AOutputContext(Leading_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterAOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitAOutput(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AStringContext extends Leading_expressionContext {
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public AStringContext(Leading_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterAString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitAString(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ANamepathContext extends Leading_expressionContext {
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public ANamepathContext(Leading_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterANamepath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitANamepath(this);
		}
	}

	public final Leading_expressionContext leading_expression() throws RecognitionException {
		Leading_expressionContext _localctx = new Leading_expressionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_leading_expression);
		try {
			setState(1567);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,201,_ctx) ) {
			case 1:
				_localctx = new AStringContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1560);
				string_literal();
				}
				break;
			case 2:
				_localctx = new ANumberContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1561);
				number_literal();
				}
				break;
			case 3:
				_localctx = new ALambdaContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1562);
				lambda_name();
				}
				break;
			case 4:
				_localctx = new AOutputContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1563);
				output_name();
				}
				break;
			case 5:
				_localctx = new ANamepathContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1564);
				namepath();
				}
				break;
			case 6:
				_localctx = new ASpecialContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(1565);
				match(SPECIAL);
				}
				break;
			case 7:
				_localctx = new AUNIMPLEMENTEDContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(1566);
				match(OP_UNIMPLEMENTED);
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
		public Control_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_control_expression; }
	 
		public Control_expressionContext() { }
		public void copyFrom(Control_expressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CBreakContext extends Control_expressionContext {
		public TerminalNode BREAK() { return getToken(ValkyrieAntlrParser.BREAK, 0); }
		public TerminalNode OP_LABEL() { return getToken(ValkyrieAntlrParser.OP_LABEL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode YIELD() { return getToken(ValkyrieAntlrParser.YIELD, 0); }
		public CBreakContext(Control_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCBreak(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCBreak(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CWithContext extends Control_expressionContext {
		public TerminalNode YIELD() { return getToken(ValkyrieAntlrParser.YIELD, 0); }
		public TerminalNode KW_WITH() { return getToken(ValkyrieAntlrParser.KW_WITH, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public CWithContext(Control_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCWith(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CYieldContext extends Control_expressionContext {
		public TerminalNode YIELD() { return getToken(ValkyrieAntlrParser.YIELD, 0); }
		public TerminalNode OP_LABEL() { return getToken(ValkyrieAntlrParser.OP_LABEL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public CYieldContext(Control_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCYield(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCYield(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CReturnContext extends Control_expressionContext {
		public TerminalNode RETURN() { return getToken(ValkyrieAntlrParser.RETURN, 0); }
		public TerminalNode RESUME() { return getToken(ValkyrieAntlrParser.RESUME, 0); }
		public Mark_labelContext mark_label() {
			return getRuleContext(Mark_labelContext.class,0);
		}
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public CReturnContext(Control_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCReturn(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CRaiseContext extends Control_expressionContext {
		public TerminalNode RAISE() { return getToken(ValkyrieAntlrParser.RAISE, 0); }
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public CRaiseContext(Control_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCRaise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCRaise(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CContinueContext extends Control_expressionContext {
		public TerminalNode CONTINUE() { return getToken(ValkyrieAntlrParser.CONTINUE, 0); }
		public TerminalNode OP_LABEL() { return getToken(ValkyrieAntlrParser.OP_LABEL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public CContinueContext(Control_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCContinue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCContinue(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CFallContext extends Control_expressionContext {
		public TerminalNode FALL_THROUGH() { return getToken(ValkyrieAntlrParser.FALL_THROUGH, 0); }
		public TerminalNode OP_LABEL() { return getToken(ValkyrieAntlrParser.OP_LABEL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public CFallContext(Control_expressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCFall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCFall(this);
		}
	}

	public final Control_expressionContext control_expression() throws RecognitionException {
		Control_expressionContext _localctx = new Control_expressionContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_control_expression);
		int _la;
		try {
			setState(1608);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,210,_ctx) ) {
			case 1:
				_localctx = new CReturnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(1569);
				_la = _input.LA(1);
				if ( !(_la==RETURN || _la==RESUME) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1571);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,202,_ctx) ) {
				case 1:
					{
					setState(1570);
					mark_label();
					}
					break;
				}
				setState(1574);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
				case 1:
					{
					setState(1573);
					main_expression(0);
					}
					break;
				}
				}
				}
				break;
			case 2:
				_localctx = new CBreakContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1576);
				match(BREAK);
				setState(1579);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
				case 1:
					{
					setState(1577);
					match(OP_LABEL);
					setState(1578);
					identifier();
					}
					break;
				}
				}
				break;
			case 3:
				_localctx = new CContinueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1581);
				match(CONTINUE);
				setState(1584);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,205,_ctx) ) {
				case 1:
					{
					setState(1582);
					match(OP_LABEL);
					setState(1583);
					identifier();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new CRaiseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1586);
				match(RAISE);
				setState(1588);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
				case 1:
					{
					setState(1587);
					main_expression(0);
					}
					break;
				}
				}
				break;
			case 5:
				_localctx = new CYieldContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(1590);
				match(YIELD);
				setState(1593);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
				case 1:
					{
					setState(1591);
					match(OP_LABEL);
					setState(1592);
					identifier();
					}
					break;
				}
				setState(1596);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
				case 1:
					{
					setState(1595);
					main_expression(0);
					}
					break;
				}
				}
				break;
			case 6:
				_localctx = new CBreakContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(1598);
				match(YIELD);
				setState(1599);
				match(BREAK);
				}
				break;
			case 7:
				_localctx = new CWithContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(1600);
				match(YIELD);
				setState(1601);
				match(KW_WITH);
				setState(1602);
				main_expression(0);
				}
				break;
			case 8:
				_localctx = new CFallContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(1603);
				match(FALL_THROUGH);
				setState(1606);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,209,_ctx) ) {
				case 1:
					{
					setState(1604);
					match(OP_LABEL);
					setState(1605);
					identifier();
					}
					break;
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
	public static class Op_prefixContext extends ParserRuleContext {
		public TerminalNode MAIN_PREFIX() { return getToken(ValkyrieAntlrParser.MAIN_PREFIX, 0); }
		public TerminalNode OP_NOT() { return getToken(ValkyrieAntlrParser.OP_NOT, 0); }
		public TerminalNode OP_BANG() { return getToken(ValkyrieAntlrParser.OP_BANG, 0); }
		public TerminalNode OP_ADD() { return getToken(ValkyrieAntlrParser.OP_ADD, 0); }
		public TerminalNode OP_SUB() { return getToken(ValkyrieAntlrParser.OP_SUB, 0); }
		public TerminalNode OP_AND() { return getToken(ValkyrieAntlrParser.OP_AND, 0); }
		public TerminalNode OP_REFERENCE() { return getToken(ValkyrieAntlrParser.OP_REFERENCE, 0); }
		public TerminalNode OP_DOT2() { return getToken(ValkyrieAntlrParser.OP_DOT2, 0); }
		public TerminalNode OP_DOT3() { return getToken(ValkyrieAntlrParser.OP_DOT3, 0); }
		public TerminalNode OP_ROOT2() { return getToken(ValkyrieAntlrParser.OP_ROOT2, 0); }
		public TerminalNode OP_MUL() { return getToken(ValkyrieAntlrParser.OP_MUL, 0); }
		public Op_prefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_prefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_prefix(this);
		}
	}

	public final Op_prefixContext op_prefix() throws RecognitionException {
		Op_prefixContext _localctx = new Op_prefixContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_op_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1610);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129092669440L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 9445572609L) != 0)) ) {
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
	public static class Op_suffixContext extends ParserRuleContext {
		public TerminalNode OP_BANG() { return getToken(ValkyrieAntlrParser.OP_BANG, 0); }
		public TerminalNode MAIN_SUFFIX() { return getToken(ValkyrieAntlrParser.MAIN_SUFFIX, 0); }
		public TerminalNode OP_TRANSPOSE() { return getToken(ValkyrieAntlrParser.OP_TRANSPOSE, 0); }
		public TerminalNode OP_PERCENT() { return getToken(ValkyrieAntlrParser.OP_PERCENT, 0); }
		public TerminalNode OP_REM() { return getToken(ValkyrieAntlrParser.OP_REM, 0); }
		public TerminalNode OP_OR_DEFAULT() { return getToken(ValkyrieAntlrParser.OP_OR_DEFAULT, 0); }
		public Op_suffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_suffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_suffix(this);
		}
	}

	public final Op_suffixContext op_suffix() throws RecognitionException {
		Op_suffixContext _localctx = new Op_suffixContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_op_suffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1612);
			_la = _input.LA(1);
			if ( !(_la==OP_REM || _la==OP_BANG || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 1835009L) != 0)) ) {
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
	public static class Op_compareContext extends ParserRuleContext {
		public TerminalNode OP_LT() { return getToken(ValkyrieAntlrParser.OP_LT, 0); }
		public TerminalNode OP_LEQ() { return getToken(ValkyrieAntlrParser.OP_LEQ, 0); }
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
		public TerminalNode OP_GEQ() { return getToken(ValkyrieAntlrParser.OP_GEQ, 0); }
		public TerminalNode OP_EQ() { return getToken(ValkyrieAntlrParser.OP_EQ, 0); }
		public TerminalNode OP_NE() { return getToken(ValkyrieAntlrParser.OP_NE, 0); }
		public TerminalNode OP_EEE() { return getToken(ValkyrieAntlrParser.OP_EEE, 0); }
		public TerminalNode OP_NEE() { return getToken(ValkyrieAntlrParser.OP_NEE, 0); }
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
	}

	public final Op_compareContext op_compare() throws RecognitionException {
		Op_compareContext _localctx = new Op_compareContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_op_compare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1614);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 77232101916672L) != 0)) ) {
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
	}

	public final Op_patternContext op_pattern() throws RecognitionException {
		Op_patternContext _localctx = new Op_patternContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_op_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1616);
			_la = _input.LA(1);
			if ( !(_la==OP_AND || _la==OP_OR) ) {
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
	public static class Op_bitwiseContext extends ParserRuleContext {
		public TerminalNode OP_AND() { return getToken(ValkyrieAntlrParser.OP_AND, 0); }
		public TerminalNode OP_OR() { return getToken(ValkyrieAntlrParser.OP_OR, 0); }
		public Op_bitwiseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_bitwise; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_bitwise(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_bitwise(this);
		}
	}

	public final Op_bitwiseContext op_bitwise() throws RecognitionException {
		Op_bitwiseContext _localctx = new Op_bitwiseContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_op_bitwise);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1618);
			_la = _input.LA(1);
			if ( !(_la==OP_AND || _la==OP_OR) ) {
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
	public static class Infix_mapContext extends ParserRuleContext {
		public TerminalNode OP_MAP() { return getToken(ValkyrieAntlrParser.OP_MAP, 0); }
		public TerminalNode OP_APPLY2() { return getToken(ValkyrieAntlrParser.OP_APPLY2, 0); }
		public TerminalNode OP_APPLY3() { return getToken(ValkyrieAntlrParser.OP_APPLY3, 0); }
		public Infix_mapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_map; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInfix_map(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInfix_map(this);
		}
	}

	public final Infix_mapContext infix_map() throws RecognitionException {
		Infix_mapContext _localctx = new Infix_mapContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_infix_map);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1620);
			_la = _input.LA(1);
			if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 7L) != 0)) ) {
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
	public static class Infix_powContext extends ParserRuleContext {
		public TerminalNode OP_POW() { return getToken(ValkyrieAntlrParser.OP_POW, 0); }
		public TerminalNode OP_ROOT2() { return getToken(ValkyrieAntlrParser.OP_ROOT2, 0); }
		public Infix_powContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_pow; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInfix_pow(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInfix_pow(this);
		}
	}

	public final Infix_powContext infix_pow() throws RecognitionException {
		Infix_powContext _localctx = new Infix_powContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_infix_pow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1622);
			_la = _input.LA(1);
			if ( !(_la==OP_POW || _la==OP_ROOT2) ) {
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
	public static class Infix_rangeContext extends ParserRuleContext {
		public TerminalNode OP_UNTIL() { return getToken(ValkyrieAntlrParser.OP_UNTIL, 0); }
		public Infix_rangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInfix_range(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInfix_range(this);
		}
	}

	public final Infix_rangeContext infix_range() throws RecognitionException {
		Infix_rangeContext _localctx = new Infix_rangeContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_infix_range);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1624);
			match(OP_UNTIL);
			}
		}
		catch (RecognitionException re) {
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
	public static class Infix_arrowsContext extends ParserRuleContext {
		public TerminalNode OP_ARROW() { return getToken(ValkyrieAntlrParser.OP_ARROW, 0); }
		public TerminalNode OP_ARROW2() { return getToken(ValkyrieAntlrParser.OP_ARROW2, 0); }
		public Infix_arrowsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_arrows; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInfix_arrows(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInfix_arrows(this);
		}
	}

	public final Infix_arrowsContext infix_arrows() throws RecognitionException {
		Infix_arrowsContext _localctx = new Infix_arrowsContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_infix_arrows);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1626);
			_la = _input.LA(1);
			if ( !(_la==OP_ARROW || _la==OP_ARROW2) ) {
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
		public TerminalNode OP_REM() { return getToken(ValkyrieAntlrParser.OP_REM, 0); }
		public TerminalNode OP_DIV_REM() { return getToken(ValkyrieAntlrParser.OP_DIV_REM, 0); }
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
	}

	public final Op_multipleContext op_multiple() throws RecognitionException {
		Op_multipleContext _localctx = new Op_multipleContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_op_multiple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1628);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8053063680L) != 0)) ) {
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
	}

	public final Op_plusContext op_plus() throws RecognitionException {
		Op_plusContext _localctx = new Op_plusContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_op_plus);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1630);
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
		public TerminalNode LOGIC_XOR() { return getToken(ValkyrieAntlrParser.LOGIC_XOR, 0); }
		public TerminalNode LOGIC_NOR() { return getToken(ValkyrieAntlrParser.LOGIC_NOR, 0); }
		public TerminalNode LOGIC_NAND() { return getToken(ValkyrieAntlrParser.LOGIC_NAND, 0); }
		public TerminalNode LOGIC_XAND() { return getToken(ValkyrieAntlrParser.LOGIC_XAND, 0); }
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
	}

	public final Op_logicContext op_logic() throws RecognitionException {
		Op_logicContext _localctx = new Op_logicContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_op_logic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1632);
			_la = _input.LA(1);
			if ( !(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 63L) != 0)) ) {
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
	public static class Op_pipelineContext extends ParserRuleContext {
		public TerminalNode OP_LL() { return getToken(ValkyrieAntlrParser.OP_LL, 0); }
		public TerminalNode OP_LLE() { return getToken(ValkyrieAntlrParser.OP_LLE, 0); }
		public TerminalNode OP_LLL() { return getToken(ValkyrieAntlrParser.OP_LLL, 0); }
		public TerminalNode OP_GG() { return getToken(ValkyrieAntlrParser.OP_GG, 0); }
		public TerminalNode OP_GGG() { return getToken(ValkyrieAntlrParser.OP_GGG, 0); }
		public TerminalNode OP_ARROW3() { return getToken(ValkyrieAntlrParser.OP_ARROW3, 0); }
		public Op_pipelineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_pipeline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterOp_pipeline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitOp_pipeline(this);
		}
	}

	public final Op_pipelineContext op_pipeline() throws RecognitionException {
		Op_pipelineContext _localctx = new Op_pipelineContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_op_pipeline);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1634);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1180600610324480L) != 0)) ) {
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
	public static class Infix_assignContext extends ParserRuleContext {
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public TerminalNode OP_ADD_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ADD_ASSIGN, 0); }
		public TerminalNode OP_SUB_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_SUB_ASSIGN, 0); }
		public TerminalNode OP_MUL_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_MUL_ASSIGN, 0); }
		public TerminalNode OP_DIV_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_DIV_ASSIGN, 0); }
		public TerminalNode OP_MAY_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_MAY_ASSIGN, 0); }
		public TerminalNode OP_GGE() { return getToken(ValkyrieAntlrParser.OP_GGE, 0); }
		public Infix_assignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInfix_assign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInfix_assign(this);
		}
	}

	public final Infix_assignContext infix_assign() throws RecognitionException {
		Infix_assignContext _localctx = new Infix_assignContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_infix_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1636);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 281483772803678208L) != 0)) ) {
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
		public TerminalNode OP_IS() { return getToken(ValkyrieAntlrParser.OP_IS, 0); }
		public TerminalNode OP_IS_NOT() { return getToken(ValkyrieAntlrParser.OP_IS_NOT, 0); }
		public TerminalNode OP_CONTINUES() { return getToken(ValkyrieAntlrParser.OP_CONTINUES, 0); }
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
	}

	public final Infix_isContext infix_is() throws RecognitionException {
		Infix_isContext _localctx = new Infix_isContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_infix_is);
		try {
			setState(1644);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1638);
				match(KW_IS);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1639);
				match(KW_IS);
				setState(1640);
				match(KW_NOT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1641);
				match(OP_IS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1642);
				match(OP_IS_NOT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1643);
				match(OP_CONTINUES);
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
	public static class Infix_asContext extends ParserRuleContext {
		public TerminalNode KW_AS() { return getToken(ValkyrieAntlrParser.KW_AS, 0); }
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public Infix_asContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infix_as; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterInfix_as(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitInfix_as(this);
		}
	}

	public final Infix_asContext infix_as() throws RecognitionException {
		Infix_asContext _localctx = new Infix_asContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_infix_as);
		try {
			setState(1649);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1646);
				match(KW_AS);
				setState(1647);
				match(OP_AND_THEN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1648);
				match(KW_AS);
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
		public TerminalNode KW_NOT() { return getToken(ValkyrieAntlrParser.KW_NOT, 0); }
		public TerminalNode OP_IN() { return getToken(ValkyrieAntlrParser.OP_IN, 0); }
		public TerminalNode OP_NOT_IN() { return getToken(ValkyrieAntlrParser.OP_NOT_IN, 0); }
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
	}

	public final Infix_inContext infix_in() throws RecognitionException {
		Infix_inContext _localctx = new Infix_inContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_infix_in);
		try {
			setState(1656);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_IN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1651);
				match(KW_IN);
				}
				break;
			case KW_NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1652);
				match(KW_NOT);
				setState(1653);
				match(KW_IN);
				}
				break;
			case OP_IN:
				enterOuterAlt(_localctx, 3);
				{
				setState(1654);
				match(OP_IN);
				}
				break;
			case OP_NOT_IN:
				enterOuterAlt(_localctx, 4);
				{
				setState(1655);
				match(OP_NOT_IN);
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
	public static class Define_genericContext extends ParserRuleContext {
		public TerminalNode GENERIC_L() { return getToken(ValkyrieAntlrParser.GENERIC_L, 0); }
		public TerminalNode GENERIC_R() { return getToken(ValkyrieAntlrParser.GENERIC_R, 0); }
		public List<Generic_itemContext> generic_item() {
			return getRuleContexts(Generic_itemContext.class);
		}
		public Generic_itemContext generic_item(int i) {
			return getRuleContext(Generic_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public TerminalNode OP_LT() { return getToken(ValkyrieAntlrParser.OP_LT, 0); }
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
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
	}

	public final Define_genericContext define_generic() throws RecognitionException {
		Define_genericContext _localctx = new Define_genericContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_define_generic);
		int _la;
		try {
			int _alt;
			setState(1696);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1658);
				match(GENERIC_L);
				setState(1659);
				match(GENERIC_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1660);
				match(GENERIC_L);
				setState(1661);
				generic_item();
				setState(1666);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1662);
						match(COMMA);
						setState(1663);
						generic_item();
						}
						} 
					}
					setState(1668);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
				}
				setState(1670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1669);
					match(COMMA);
					}
				}

				setState(1672);
				match(GENERIC_R);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1675);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_PROPORTION) {
					{
					setState(1674);
					match(OP_PROPORTION);
					}
				}

				setState(1677);
				match(OP_LT);
				setState(1678);
				match(OP_GT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1680);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_PROPORTION) {
					{
					setState(1679);
					match(OP_PROPORTION);
					}
				}

				setState(1682);
				match(OP_LT);
				setState(1683);
				generic_item();
				setState(1688);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,218,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1684);
						match(COMMA);
						setState(1685);
						generic_item();
						}
						} 
					}
					setState(1690);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,218,_ctx);
				}
				setState(1692);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1691);
					match(COMMA);
					}
				}

				setState(1694);
				match(OP_GT);
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
	public static class Generic_itemContext extends ParserRuleContext {
		public Type_expressionContext bound;
		public Type_expressionContext default_;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public TerminalNode OP_ASSIGN() { return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0); }
		public List<Type_expressionContext> type_expression() {
			return getRuleContexts(Type_expressionContext.class);
		}
		public Type_expressionContext type_expression(int i) {
			return getRuleContext(Type_expressionContext.class,i);
		}
		public TerminalNode LAMBDA_SLOT() { return getToken(ValkyrieAntlrParser.LAMBDA_SLOT, 0); }
		public Generic_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterGeneric_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitGeneric_item(this);
		}
	}

	public final Generic_itemContext generic_item() throws RecognitionException {
		Generic_itemContext _localctx = new Generic_itemContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_generic_item);
		int _la;
		try {
			setState(1708);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1698);
				identifier();
				setState(1701);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1699);
					match(COLON);
					setState(1700);
					((Generic_itemContext)_localctx).bound = type_expression(0);
					}
				}

				setState(1705);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_ASSIGN) {
					{
					setState(1703);
					match(OP_ASSIGN);
					setState(1704);
					((Generic_itemContext)_localctx).default_ = type_expression(0);
					}
				}

				}
				break;
			case LAMBDA_SLOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1707);
				match(LAMBDA_SLOT);
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
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
		public List<Generic_pairContext> generic_pair() {
			return getRuleContexts(Generic_pairContext.class);
		}
		public Generic_pairContext generic_pair(int i) {
			return getRuleContext(Generic_pairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
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
	}

	public final Generic_callContext generic_call() throws RecognitionException {
		Generic_callContext _localctx = new Generic_callContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_generic_call);
		int _la;
		try {
			int _alt;
			setState(1744);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,228,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1710);
				match(OP_PROPORTION);
				setState(1711);
				match(OP_LT);
				setState(1712);
				match(OP_GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1713);
				match(OP_PROPORTION);
				setState(1714);
				match(OP_LT);
				setState(1715);
				generic_pair();
				setState(1720);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,224,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1716);
						match(COMMA);
						setState(1717);
						generic_pair();
						}
						} 
					}
					setState(1722);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,224,_ctx);
				}
				setState(1724);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1723);
					match(COMMA);
					}
				}

				setState(1726);
				match(OP_GT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1728);
				match(GENERIC_L);
				setState(1729);
				match(GENERIC_R);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1730);
				match(GENERIC_L);
				setState(1731);
				generic_pair();
				setState(1736);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,226,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1732);
						match(COMMA);
						setState(1733);
						generic_pair();
						}
						} 
					}
					setState(1738);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,226,_ctx);
				}
				setState(1740);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1739);
					match(COMMA);
					}
				}

				setState(1742);
				match(GENERIC_R);
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
	public static class Generic_call_in_typeContext extends ParserRuleContext {
		public TerminalNode OP_LT() { return getToken(ValkyrieAntlrParser.OP_LT, 0); }
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
		public List<Generic_pairContext> generic_pair() {
			return getRuleContexts(Generic_pairContext.class);
		}
		public Generic_pairContext generic_pair(int i) {
			return getRuleContext(Generic_pairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
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
	}

	public final Generic_call_in_typeContext generic_call_in_type() throws RecognitionException {
		Generic_call_in_typeContext _localctx = new Generic_call_in_typeContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_generic_call_in_type);
		int _la;
		try {
			int _alt;
			setState(1779);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PROPORTION:
			case OP_LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1747);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OP_PROPORTION) {
					{
					setState(1746);
					match(OP_PROPORTION);
					}
				}

				setState(1749);
				match(OP_LT);
				setState(1761);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129092671616L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2305842926753674751L) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & 7L) != 0)) {
					{
					setState(1750);
					generic_pair();
					setState(1755);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,230,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1751);
							match(COMMA);
							setState(1752);
							generic_pair();
							}
							} 
						}
						setState(1757);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,230,_ctx);
					}
					setState(1759);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1758);
						match(COMMA);
						}
					}

					}
				}

				setState(1763);
				match(OP_GT);
				}
				break;
			case GENERIC_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(1764);
				match(GENERIC_L);
				setState(1776);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129092671616L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2305842926753674751L) != 0) || ((((_la - 143)) & ~0x3f) == 0 && ((1L << (_la - 143)) & 7L) != 0)) {
					{
					setState(1765);
					generic_pair();
					setState(1770);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,233,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1766);
							match(COMMA);
							setState(1767);
							generic_pair();
							}
							} 
						}
						setState(1772);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,233,_ctx);
					}
					setState(1774);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1773);
						match(COMMA);
						}
					}

					}
				}

				setState(1778);
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
	public static class Generic_pairContext extends ParserRuleContext {
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public Generic_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterGeneric_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitGeneric_pair(this);
		}
	}

	public final Generic_pairContext generic_pair() throws RecognitionException {
		Generic_pairContext _localctx = new Generic_pairContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_generic_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1784);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
			case 1:
				{
				setState(1781);
				identifier();
				setState(1782);
				match(COLON);
				}
				break;
			}
			setState(1786);
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
	public static class Define_labelContext extends ParserRuleContext {
		public TerminalNode OP_LABEL() { return getToken(ValkyrieAntlrParser.OP_LABEL, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Define_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_define_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDefine_label(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDefine_label(this);
		}
	}

	public final Define_labelContext define_label() throws RecognitionException {
		Define_labelContext _localctx = new Define_labelContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_define_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1788);
			match(OP_LABEL);
			setState(1789);
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
	public static class Template_callContext extends ParserRuleContext {
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode KW_TEMPLATE() { return getToken(ValkyrieAntlrParser.KW_TEMPLATE, 0); }
		public Template_blockContext template_block() {
			return getRuleContext(Template_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode OP_LT() { return getToken(ValkyrieAntlrParser.OP_LT, 0); }
		public TerminalNode OP_GT() { return getToken(ValkyrieAntlrParser.OP_GT, 0); }
		public TerminalNode GENERIC_L() { return getToken(ValkyrieAntlrParser.GENERIC_L, 0); }
		public TerminalNode GENERIC_R() { return getToken(ValkyrieAntlrParser.GENERIC_R, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public Template_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTemplate_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTemplate_call(this);
		}
	}

	public final Template_callContext template_call() throws RecognitionException {
		Template_callContext _localctx = new Template_callContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_template_call);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1794);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1791);
				attribute();
				}
				}
				setState(1796);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1797);
			modifiers();
			setState(1798);
			match(KW_TEMPLATE);
			setState(1838);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RAW_ID:
			case UNICODE_ID:
				{
				setState(1799);
				identifier();
				setState(1804);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1800);
						match(COMMA);
						setState(1801);
						identifier();
						}
						} 
					}
					setState(1806);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
				}
				setState(1808);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1807);
					match(COMMA);
					}
				}

				}
				break;
			case OP_LT:
				{
				setState(1810);
				match(OP_LT);
				setState(1811);
				identifier();
				setState(1816);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,241,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1812);
						match(COMMA);
						setState(1813);
						identifier();
						}
						} 
					}
					setState(1818);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,241,_ctx);
				}
				setState(1820);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1819);
					match(COMMA);
					}
				}

				setState(1822);
				match(OP_GT);
				}
				break;
			case GENERIC_L:
				{
				setState(1824);
				match(GENERIC_L);
				setState(1825);
				identifier();
				setState(1830);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,243,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1826);
						match(COMMA);
						setState(1827);
						identifier();
						}
						} 
					}
					setState(1832);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,243,_ctx);
				}
				setState(1834);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1833);
					match(COMMA);
					}
				}

				setState(1836);
				match(GENERIC_R);
				}
				break;
			case BRACE_L:
				break;
			default:
				break;
			}
			setState(1840);
			template_block();
			}
		}
		catch (RecognitionException re) {
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
	public static class Template_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Template_statementsContext> template_statements() {
			return getRuleContexts(Template_statementsContext.class);
		}
		public Template_statementsContext template_statements(int i) {
			return getRuleContext(Template_statementsContext.class,i);
		}
		public Template_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTemplate_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTemplate_block(this);
		}
	}

	public final Template_blockContext template_block() throws RecognitionException {
		Template_blockContext _localctx = new Template_blockContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_template_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1842);
			match(BRACE_L);
			setState(1846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || ((((_la - 116)) & ~0x3f) == 0 && ((1L << (_la - 116)) & 806363137L) != 0)) {
				{
				{
				setState(1843);
				template_statements();
				}
				}
				setState(1848);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1849);
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
	public static class Template_statementsContext extends ParserRuleContext {
		public Template_termContext template_term() {
			return getRuleContext(Template_termContext.class,0);
		}
		public Template_implementsContext template_implements() {
			return getRuleContext(Template_implementsContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Template_statementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTemplate_statements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTemplate_statements(this);
		}
	}

	public final Template_statementsContext template_statements() throws RecognitionException {
		Template_statementsContext _localctx = new Template_statementsContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_template_statements);
		try {
			setState(1854);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_WHERE:
			case RETURN:
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1851);
				template_term();
				}
				break;
			case KW_IMPLEMENTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1852);
				template_implements();
				}
				break;
			case COMMA:
			case SEMICOLON:
			case FAKE_COLON:
				enterOuterAlt(_localctx, 3);
				{
				setState(1853);
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
	public static class Template_termContext extends ParserRuleContext {
		public TerminalNode KW_WHERE() { return getToken(ValkyrieAntlrParser.KW_WHERE, 0); }
		public Where_blockContext where_block() {
			return getRuleContext(Where_blockContext.class,0);
		}
		public TerminalNode RETURN() { return getToken(ValkyrieAntlrParser.RETURN, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Require_blockContext require_block() {
			return getRuleContext(Require_blockContext.class,0);
		}
		public Template_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTemplate_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTemplate_term(this);
		}
	}

	public final Template_termContext template_term() throws RecognitionException {
		Template_termContext _localctx = new Template_termContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_template_term);
		try {
			setState(1863);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KW_WHERE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1856);
				match(KW_WHERE);
				setState(1857);
				where_block();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1858);
				match(RETURN);
				setState(1859);
				type_expression(0);
				}
				break;
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(1860);
				identifier();
				setState(1861);
				require_block();
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
	public static class Template_implementsContext extends ParserRuleContext {
		public TerminalNode KW_IMPLEMENTS() { return getToken(ValkyrieAntlrParser.KW_IMPLEMENTS, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Template_implementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_implements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTemplate_implements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTemplate_implements(this);
		}
	}

	public final Template_implementsContext template_implements() throws RecognitionException {
		Template_implementsContext _localctx = new Template_implementsContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_template_implements);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1865);
			match(KW_IMPLEMENTS);
			setState(1866);
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
	public static class Where_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Where_boundContext> where_bound() {
			return getRuleContexts(Where_boundContext.class);
		}
		public Where_boundContext where_bound(int i) {
			return getRuleContext(Where_boundContext.class,i);
		}
		public Where_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterWhere_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitWhere_block(this);
		}
	}

	public final Where_blockContext where_block() throws RecognitionException {
		Where_blockContext _localctx = new Where_blockContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_where_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1868);
			match(BRACE_L);
			setState(1872);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || _la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(1869);
				where_bound();
				}
				}
				setState(1874);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1875);
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
	public static class Where_boundContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Eos_freeContext eos_free() {
			return getRuleContext(Eos_freeContext.class,0);
		}
		public Where_boundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where_bound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterWhere_bound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitWhere_bound(this);
		}
	}

	public final Where_boundContext where_bound() throws RecognitionException {
		Where_boundContext _localctx = new Where_boundContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_where_bound);
		try {
			setState(1882);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RAW_ID:
			case UNICODE_ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(1877);
				identifier();
				setState(1878);
				match(COLON);
				setState(1879);
				type_expression(0);
				}
				break;
			case COMMA:
			case SEMICOLON:
			case FAKE_COLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(1881);
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
	public static class Require_blockContext extends ParserRuleContext {
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Expression_rootContext> expression_root() {
			return getRuleContexts(Expression_rootContext.class);
		}
		public Expression_rootContext expression_root(int i) {
			return getRuleContext(Expression_rootContext.class,i);
		}
		public List<Eos_freeContext> eos_free() {
			return getRuleContexts(Eos_freeContext.class);
		}
		public Eos_freeContext eos_free(int i) {
			return getRuleContext(Eos_freeContext.class,i);
		}
		public Require_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_require_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterRequire_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitRequire_block(this);
		}
	}

	public final Require_blockContext require_block() throws RecognitionException {
		Require_blockContext _localctx = new Require_blockContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_require_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1884);
			match(BRACE_L);
			setState(1889);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129095326364L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2181149494890984575L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 4202489L) != 0)) {
				{
				setState(1887);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PARENTHESES_L:
				case BRACKET_L:
				case BRACE_L:
				case OFFSET_L:
				case CEILING_L:
				case FLOOR_L:
				case OP_ADD:
				case OP_SUB:
				case OP_MUL:
				case OP_BANG:
				case OP_NOT:
				case OP_AND:
				case OP_AT:
				case OP_HASH:
				case LAMBDA_SLOT:
				case OP_UNIMPLEMENTED:
				case OP_DOT3:
				case OP_DOT2:
				case MAIN_PREFIX:
				case OP_ROOT2:
				case OP_PERCENT:
				case OP_REFERENCE:
				case OP_LABEL:
				case OP_LAST:
				case KW_WHILE:
				case KW_FOR:
				case KW_NEW:
				case KW_OBJECT:
				case KW_LAMBDA:
				case KW_TRY:
				case KW_MATCH:
				case INTEGER:
				case DECIMAL:
				case STRING_START:
				case KW_IF:
				case RETURN:
				case RESUME:
				case YIELD:
				case BREAK:
				case CONTINUE:
				case FALL_THROUGH:
				case RAISE:
				case SPECIAL:
				case RAW_ID:
				case UNICODE_ID:
				case KW_SWITCH:
					{
					setState(1885);
					expression_root();
					}
					break;
				case COMMA:
				case SEMICOLON:
				case FAKE_COLON:
					{
					setState(1886);
					eos_free();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1891);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1892);
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
	public static class Macro_callContext extends ParserRuleContext {
		public TerminalNode OP_AT() { return getToken(ValkyrieAntlrParser.OP_AT, 0); }
		public Macro_itemContext macro_item() {
			return getRuleContext(Macro_itemContext.class,0);
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
	}

	public final Macro_callContext macro_call() throws RecognitionException {
		Macro_callContext _localctx = new Macro_callContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_macro_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1894);
			match(OP_AT);
			setState(1895);
			macro_item();
			}
		}
		catch (RecognitionException re) {
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
	public static class Macro_itemContext extends ParserRuleContext {
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
		}
		public Class_blockContext class_block() {
			return getRuleContext(Class_blockContext.class,0);
		}
		public Macro_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMacro_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMacro_item(this);
		}
	}

	public final Macro_itemContext macro_item() throws RecognitionException {
		Macro_itemContext _localctx = new Macro_itemContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_macro_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1897);
			namepath();
			setState(1899);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				{
				setState(1898);
				tuple_call_body();
				}
				break;
			}
			setState(1902);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,254,_ctx) ) {
			case 1:
				{
				setState(1901);
				class_block();
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
	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode OP_HASH() { return getToken(ValkyrieAntlrParser.OP_HASH, 0); }
		public List<Attribute_itemContext> attribute_item() {
			return getRuleContexts(Attribute_itemContext.class);
		}
		public Attribute_itemContext attribute_item(int i) {
			return getRuleContext(Attribute_itemContext.class,i);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_attribute);
		int _la;
		try {
			int _alt;
			setState(1922);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1904);
				match(OP_HASH);
				setState(1905);
				attribute_item();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1906);
				match(OP_HASH);
				setState(1907);
				match(BRACKET_L);
				setState(1919);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(1908);
					attribute_item();
					setState(1913);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,255,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1909);
							match(COMMA);
							setState(1910);
							attribute_item();
							}
							} 
						}
						setState(1915);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,255,_ctx);
					}
					setState(1917);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(1916);
						match(COMMA);
						}
					}

					}
				}

				setState(1921);
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
	public static class Attribute_itemContext extends ParserRuleContext {
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(ValkyrieAntlrParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(ValkyrieAntlrParser.DOT, i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
		}
		public Class_blockContext class_block() {
			return getRuleContext(Class_blockContext.class,0);
		}
		public Attribute_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterAttribute_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitAttribute_item(this);
		}
	}

	public final Attribute_itemContext attribute_item() throws RecognitionException {
		Attribute_itemContext _localctx = new Attribute_itemContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_attribute_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1924);
			namepath();
			setState(1929);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(1925);
				match(DOT);
				setState(1926);
				identifier();
				}
				}
				setState(1931);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1933);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,260,_ctx) ) {
			case 1:
				{
				setState(1932);
				tuple_call_body();
				}
				break;
			}
			setState(1936);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,261,_ctx) ) {
			case 1:
				{
				setState(1935);
				class_block();
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
	public static class Try_statementContext extends ParserRuleContext {
		public TerminalNode KW_TRY() { return getToken(ValkyrieAntlrParser.KW_TRY, 0); }
		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
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
	}

	public final Try_statementContext try_statement() throws RecognitionException {
		Try_statementContext _localctx = new Try_statementContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_try_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1941);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1938);
				attribute();
				}
				}
				setState(1943);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1944);
			match(KW_TRY);
			setState(1946);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,263,_ctx) ) {
			case 1:
				{
				setState(1945);
				type_expression(0);
				}
				break;
			}
			setState(1948);
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
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OP_BIND() { return getToken(ValkyrieAntlrParser.OP_BIND, 0); }
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
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
	}

	public final Match_statementContext match_statement() throws RecognitionException {
		Match_statementContext _localctx = new Match_statementContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_match_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1953);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1950);
				attribute();
				}
				}
				setState(1955);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1956);
			match(KW_MATCH);
			setState(1960);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,265,_ctx) ) {
			case 1:
				{
				setState(1957);
				identifier();
				setState(1958);
				match(OP_BIND);
				}
				break;
			}
			setState(1962);
			inline_expression(0);
			setState(1964);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_AND_THEN) {
				{
				setState(1963);
				match(OP_AND_THEN);
				}
			}

			setState(1966);
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
	public static class Switch_statementContext extends ParserRuleContext {
		public TerminalNode KW_SWITCH() { return getToken(ValkyrieAntlrParser.KW_SWITCH, 0); }
		public Match_blockContext match_block() {
			return getRuleContext(Match_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public Switch_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterSwitch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitSwitch_statement(this);
		}
	}

	public final Switch_statementContext switch_statement() throws RecognitionException {
		Switch_statementContext _localctx = new Switch_statementContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_switch_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1971);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_HASH) {
				{
				{
				setState(1968);
				attribute();
				}
				}
				setState(1973);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1974);
			match(KW_SWITCH);
			setState(1975);
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
		public List<Eos_freeContext> eos_free() {
			return getRuleContexts(Eos_freeContext.class);
		}
		public Eos_freeContext eos_free(int i) {
			return getRuleContext(Eos_freeContext.class,i);
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
	}

	public final Match_blockContext match_block() throws RecognitionException {
		Match_blockContext _localctx = new Match_blockContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_match_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1977);
			match(BRACE_L);
			setState(1982);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 28L) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 148055906469281793L) != 0)) {
				{
				setState(1980);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OP_HASH:
				case KW_TYPE:
				case KW_WITH:
				case KW_CASE:
				case KW_WHEN:
				case KW_ELSE:
					{
					setState(1978);
					match_terms();
					}
					break;
				case COMMA:
				case SEMICOLON:
				case FAKE_COLON:
					{
					setState(1979);
					eos_free();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1984);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1985);
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
	public static class Dot_match_callContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public TerminalNode KW_MATCH() { return getToken(ValkyrieAntlrParser.KW_MATCH, 0); }
		public Match_blockContext match_block() {
			return getRuleContext(Match_blockContext.class,0);
		}
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
		public TerminalNode KW_AS() { return getToken(ValkyrieAntlrParser.KW_AS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Dot_match_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dot_match_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterDot_match_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitDot_match_call(this);
		}
	}

	public final Dot_match_callContext dot_match_call() throws RecognitionException {
		Dot_match_callContext _localctx = new Dot_match_callContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_dot_match_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1988);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_AND_THEN) {
				{
				setState(1987);
				match(OP_AND_THEN);
				}
			}

			setState(1990);
			match(DOT);
			setState(1991);
			match(KW_MATCH);
			setState(1997);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==KW_AS) {
				{
				setState(1992);
				match(KW_AS);
				setState(1993);
				identifier();
				setState(1995);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1994);
					type_hint();
					}
				}

				}
			}

			setState(1999);
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
	public static class Match_termsContext extends ParserRuleContext {
		public Match_termsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_terms; }
	 
		public Match_termsContext() { }
		public void copyFrom(Match_termsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchWhenContext extends Match_termsContext {
		public TerminalNode KW_WHEN() { return getToken(ValkyrieAntlrParser.KW_WHEN, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public Match_case_blockContext match_case_block() {
			return getRuleContext(Match_case_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public MatchWhenContext(Match_termsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatchWhen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatchWhen(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchTypeContext extends Match_termsContext {
		public TerminalNode KW_TYPE() { return getToken(ValkyrieAntlrParser.KW_TYPE, 0); }
		public Type_expressionContext type_expression() {
			return getRuleContext(Type_expressionContext.class,0);
		}
		public Match_case_blockContext match_case_block() {
			return getRuleContext(Match_case_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode KW_IF() { return getToken(ValkyrieAntlrParser.KW_IF, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public MatchTypeContext(Match_termsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatchType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatchType(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchCaseContext extends Match_termsContext {
		public TerminalNode KW_CASE() { return getToken(ValkyrieAntlrParser.KW_CASE, 0); }
		public Case_patternContext case_pattern() {
			return getRuleContext(Case_patternContext.class,0);
		}
		public Match_case_blockContext match_case_block() {
			return getRuleContext(Match_case_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode KW_IF() { return getToken(ValkyrieAntlrParser.KW_IF, 0); }
		public Inline_expressionContext inline_expression() {
			return getRuleContext(Inline_expressionContext.class,0);
		}
		public MatchCaseContext(Match_termsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatchCase(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchWithContext extends Match_termsContext {
		public TerminalNode KW_WITH() { return getToken(ValkyrieAntlrParser.KW_WITH, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public MatchWithContext(Match_termsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatchWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatchWith(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchWithManyContext extends Match_termsContext {
		public TerminalNode KW_WITH() { return getToken(ValkyrieAntlrParser.KW_WITH, 0); }
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public MatchWithManyContext(Match_termsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatchWithMany(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatchWithMany(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchElseContext extends Match_termsContext {
		public TerminalNode KW_ELSE() { return getToken(ValkyrieAntlrParser.KW_ELSE, 0); }
		public Match_case_blockContext match_case_block() {
			return getRuleContext(Match_case_blockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public MatchElseContext(Match_termsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatchElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatchElse(this);
		}
	}

	public final Match_termsContext match_terms() throws RecognitionException {
		Match_termsContext _localctx = new Match_termsContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_match_terms);
		int _la;
		try {
			int _alt;
			setState(2077);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,284,_ctx) ) {
			case 1:
				_localctx = new MatchWithContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2004);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(2001);
					attribute();
					}
					}
					setState(2006);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2007);
				match(KW_WITH);
				setState(2008);
				identifier();
				}
				break;
			case 2:
				_localctx = new MatchWithManyContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2012);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(2009);
					attribute();
					}
					}
					setState(2014);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2015);
				match(KW_WITH);
				setState(2016);
				match(BRACKET_L);
				setState(2028);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(2017);
					identifier();
					setState(2022);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,275,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(2018);
							match(COMMA);
							setState(2019);
							identifier();
							}
							} 
						}
						setState(2024);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,275,_ctx);
					}
					setState(2026);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2025);
						match(COMMA);
						}
					}

					}
				}

				setState(2030);
				match(BRACKET_R);
				}
				break;
			case 3:
				_localctx = new MatchTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2034);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(2031);
					attribute();
					}
					}
					setState(2036);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2037);
				match(KW_TYPE);
				setState(2038);
				type_expression(0);
				setState(2041);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_IF) {
					{
					setState(2039);
					match(KW_IF);
					setState(2040);
					inline_expression(0);
					}
				}

				setState(2043);
				match_case_block();
				}
				break;
			case 4:
				_localctx = new MatchWhenContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2048);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(2045);
					attribute();
					}
					}
					setState(2050);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2051);
				match(KW_WHEN);
				setState(2052);
				inline_expression(0);
				setState(2053);
				match_case_block();
				}
				break;
			case 5:
				_localctx = new MatchElseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(2058);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(2055);
					attribute();
					}
					}
					setState(2060);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2061);
				match(KW_ELSE);
				setState(2062);
				match_case_block();
				}
				break;
			case 6:
				_localctx = new MatchCaseContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(2066);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OP_HASH) {
					{
					{
					setState(2063);
					attribute();
					}
					}
					setState(2068);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2069);
				match(KW_CASE);
				setState(2070);
				case_pattern(0);
				setState(2073);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==KW_IF) {
					{
					setState(2071);
					match(KW_IF);
					setState(2072);
					inline_expression(0);
					}
				}

				setState(2075);
				match_case_block();
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
	public static class Match_case_blockContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public TerminalNode OP_ARROW2() { return getToken(ValkyrieAntlrParser.OP_ARROW2, 0); }
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public Match_case_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_case_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterMatch_case_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitMatch_case_block(this);
		}
	}

	public final Match_case_blockContext match_case_block() throws RecognitionException {
		Match_case_blockContext _localctx = new Match_case_blockContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_match_case_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2079);
			_la = _input.LA(1);
			if ( !(_la==COLON || _la==OP_ARROW2) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(2083);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,285,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2080);
					main_expression(0);
					}
					} 
				}
				setState(2085);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,285,_ctx);
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
		public Case_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_pattern; }
	 
		public Case_patternContext() { }
		public void copyFrom(Case_patternContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseORContext extends Case_patternContext {
		public List<Case_patternContext> case_pattern() {
			return getRuleContexts(Case_patternContext.class);
		}
		public Case_patternContext case_pattern(int i) {
			return getRuleContext(Case_patternContext.class,i);
		}
		public TerminalNode OP_OR() { return getToken(ValkyrieAntlrParser.OP_OR, 0); }
		public TerminalNode OP_ADD() { return getToken(ValkyrieAntlrParser.OP_ADD, 0); }
		public CaseORContext(Case_patternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCaseOR(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCaseOR(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseAtomContext extends Case_patternContext {
		public Case_pattern_itemContext case_pattern_item() {
			return getRuleContext(Case_pattern_itemContext.class,0);
		}
		public CaseAtomContext(Case_patternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCaseAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCaseAtom(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CaseUntilContext extends Case_patternContext {
		public List<Case_patternContext> case_pattern() {
			return getRuleContexts(Case_patternContext.class);
		}
		public Case_patternContext case_pattern(int i) {
			return getRuleContext(Case_patternContext.class,i);
		}
		public TerminalNode OP_UNTIL() { return getToken(ValkyrieAntlrParser.OP_UNTIL, 0); }
		public CaseUntilContext(Case_patternContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCaseUntil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCaseUntil(this);
		}
	}

	public final Case_patternContext case_pattern() throws RecognitionException {
		return case_pattern(0);
	}

	private Case_patternContext case_pattern(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Case_patternContext _localctx = new Case_patternContext(_ctx, _parentState);
		Case_patternContext _prevctx = _localctx;
		int _startState = 246;
		enterRecursionRule(_localctx, 246, RULE_case_pattern, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new CaseAtomContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(2087);
			case_pattern_item();
			}
			_ctx.stop = _input.LT(-1);
			setState(2097);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,287,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2095);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,286,_ctx) ) {
					case 1:
						{
						_localctx = new CaseORContext(new Case_patternContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_case_pattern);
						setState(2089);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2090);
						_la = _input.LA(1);
						if ( !(_la==OP_ADD || _la==OP_OR) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(2091);
						case_pattern(4);
						}
						break;
					case 2:
						{
						_localctx = new CaseUntilContext(new Case_patternContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_case_pattern);
						setState(2092);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(2093);
						match(OP_UNTIL);
						}
						setState(2094);
						case_pattern(3);
						}
						break;
					}
					} 
				}
				setState(2099);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,287,_ctx);
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
	public static class Case_pattern_itemContext extends ParserRuleContext {
		public IdentifierContext bind;
		public Case_pattern_tupleContext case_pattern_tuple() {
			return getRuleContext(Case_pattern_tupleContext.class,0);
		}
		public TerminalNode OP_BIND() { return getToken(ValkyrieAntlrParser.OP_BIND, 0); }
		public Case_pattern_itemContext case_pattern_item() {
			return getRuleContext(Case_pattern_itemContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public Modified_identifierContext modified_identifier() {
			return getRuleContext(Modified_identifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public TerminalNode OP_DOT2() { return getToken(ValkyrieAntlrParser.OP_DOT2, 0); }
		public TerminalNode OP_DOT3() { return getToken(ValkyrieAntlrParser.OP_DOT3, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public Number_literalContext number_literal() {
			return getRuleContext(Number_literalContext.class,0);
		}
		public String_literalContext string_literal() {
			return getRuleContext(String_literalContext.class,0);
		}
		public TerminalNode SPECIAL() { return getToken(ValkyrieAntlrParser.SPECIAL, 0); }
		public Case_pattern_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_pattern_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCase_pattern_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCase_pattern_item(this);
		}
	}

	public final Case_pattern_itemContext case_pattern_item() throws RecognitionException {
		Case_pattern_itemContext _localctx = new Case_pattern_itemContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_case_pattern_item);
		int _la;
		try {
			setState(2122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,290,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2100);
				case_pattern_tuple();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2101);
				((Case_pattern_itemContext)_localctx).bind = identifier();
				setState(2102);
				match(OP_BIND);
				setState(2103);
				case_pattern_item();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2105);
				modified_identifier();
				setState(2106);
				match(COLON);
				setState(2110);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,288,_ctx) ) {
				case 1:
					{
					setState(2107);
					((Case_pattern_itemContext)_localctx).bind = identifier();
					setState(2108);
					match(OP_BIND);
					}
					break;
				}
				setState(2112);
				case_pattern_item();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2114);
				_la = _input.LA(1);
				if ( !(_la==OP_DOT3 || _la==OP_DOT2) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(2116);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,289,_ctx) ) {
				case 1:
					{
					setState(2115);
					identifier();
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2118);
				namepath();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2119);
				number_literal();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2120);
				string_literal();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2121);
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
	public static class Case_pattern_tupleContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public NamepathContext namepath() {
			return getRuleContext(NamepathContext.class,0);
		}
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public TerminalNode BRACE_L() { return getToken(ValkyrieAntlrParser.BRACE_L, 0); }
		public TerminalNode BRACE_R() { return getToken(ValkyrieAntlrParser.BRACE_R, 0); }
		public List<Case_pattern_itemContext> case_pattern_item() {
			return getRuleContexts(Case_pattern_itemContext.class);
		}
		public Case_pattern_itemContext case_pattern_item(int i) {
			return getRuleContext(Case_pattern_itemContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public Case_pattern_tupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_pattern_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCase_pattern_tuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCase_pattern_tuple(this);
		}
	}

	public final Case_pattern_tupleContext case_pattern_tuple() throws RecognitionException {
		Case_pattern_tupleContext _localctx = new Case_pattern_tupleContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_case_pattern_tuple);
		int _la;
		try {
			int _alt;
			setState(2206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(2124);
					namepath();
					}
				}

				setState(2127);
				match(PARENTHESES_L);
				setState(2128);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(2129);
					namepath();
					}
				}

				setState(2132);
				match(BRACKET_L);
				setState(2133);
				match(BRACKET_R);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(2134);
					namepath();
					}
				}

				setState(2137);
				match(BRACE_L);
				setState(2138);
				match(BRACE_R);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2139);
				match(PARENTHESES_L);
				setState(2140);
				case_pattern_item();
				setState(2141);
				match(COMMA);
				setState(2142);
				match(PARENTHESES_R);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2144);
				match(PARENTHESES_L);
				setState(2145);
				case_pattern_item();
				setState(2148); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2146);
						match(COMMA);
						setState(2147);
						case_pattern_item();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2150); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,294,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(2153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2152);
					match(COMMA);
					}
				}

				setState(2155);
				match(PARENTHESES_R);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2157);
				namepath();
				setState(2158);
				match(PARENTHESES_L);
				setState(2159);
				case_pattern_item();
				setState(2164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,296,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2160);
						match(COMMA);
						setState(2161);
						case_pattern_item();
						}
						} 
					}
					setState(2166);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,296,_ctx);
				}
				setState(2168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2167);
					match(COMMA);
					}
				}

				setState(2170);
				match(PARENTHESES_R);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2173);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(2172);
					namepath();
					}
				}

				setState(2175);
				match(BRACKET_L);
				setState(2176);
				case_pattern_item();
				setState(2181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,299,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2177);
						match(COMMA);
						setState(2178);
						case_pattern_item();
						}
						} 
					}
					setState(2183);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,299,_ctx);
				}
				setState(2185);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2184);
					match(COMMA);
					}
				}

				setState(2187);
				match(BRACKET_R);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2190);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RAW_ID || _la==UNICODE_ID) {
					{
					setState(2189);
					namepath();
					}
				}

				setState(2192);
				match(BRACE_L);
				setState(2193);
				case_pattern_item();
				setState(2198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,302,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2194);
						match(COMMA);
						setState(2195);
						case_pattern_item();
						}
						} 
					}
					setState(2200);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,302,_ctx);
				}
				setState(2202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2201);
					match(COMMA);
					}
				}

				setState(2204);
				match(BRACE_R);
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
	public static class Object_statementContext extends ParserRuleContext {
		public TerminalNode KW_OBJECT() { return getToken(ValkyrieAntlrParser.KW_OBJECT, 0); }
		public Class_blockContext class_block() {
			return getRuleContext(Class_blockContext.class,0);
		}
		public Define_genericContext define_generic() {
			return getRuleContext(Define_genericContext.class,0);
		}
		public Class_inheritContext class_inherit() {
			return getRuleContext(Class_inheritContext.class,0);
		}
		public Type_hintContext type_hint() {
			return getRuleContext(Type_hintContext.class,0);
		}
		public Object_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_object_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterObject_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitObject_statement(this);
		}
	}

	public final Object_statementContext object_statement() throws RecognitionException {
		Object_statementContext _localctx = new Object_statementContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_object_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2208);
			match(KW_OBJECT);
			setState(2210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
				{
				setState(2209);
				define_generic();
				}
			}

			setState(2213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PARENTHESES_L) {
				{
				setState(2212);
				class_inherit();
				}
			}

			setState(2216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(2215);
				type_hint();
				}
			}

			setState(2218);
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
	public static class New_statementContext extends ParserRuleContext {
		public TerminalNode KW_NEW() { return getToken(ValkyrieAntlrParser.KW_NEW, 0); }
		public Modified_namepathContext modified_namepath() {
			return getRuleContext(Modified_namepathContext.class,0);
		}
		public New_blockContext new_block() {
			return getRuleContext(New_blockContext.class,0);
		}
		public Generic_call_in_typeContext generic_call_in_type() {
			return getRuleContext(Generic_call_in_typeContext.class,0);
		}
		public Tuple_call_bodyContext tuple_call_body() {
			return getRuleContext(Tuple_call_bodyContext.class,0);
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
	}

	public final New_statementContext new_statement() throws RecognitionException {
		New_statementContext _localctx = new New_statementContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_new_statement);
		int _la;
		try {
			setState(2239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,311,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2220);
				match(KW_NEW);
				setState(2221);
				modified_namepath();
				setState(2223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
					{
					setState(2222);
					generic_call_in_type();
					}
				}

				setState(2226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PARENTHESES_L) {
					{
					setState(2225);
					tuple_call_body();
					}
				}

				setState(2228);
				new_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2230);
				match(KW_NEW);
				setState(2231);
				modified_namepath();
				setState(2233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2199023263776L) != 0)) {
					{
					setState(2232);
					generic_call_in_type();
					}
				}

				setState(2235);
				tuple_call_body();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2237);
				match(KW_NEW);
				setState(2238);
				modified_namepath();
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
		public List<New_call_itemContext> new_call_item() {
			return getRuleContexts(New_call_itemContext.class);
		}
		public New_call_itemContext new_call_item(int i) {
			return getRuleContext(New_call_itemContext.class,i);
		}
		public List<Eos_freeContext> eos_free() {
			return getRuleContexts(Eos_freeContext.class);
		}
		public Eos_freeContext eos_free(int i) {
			return getRuleContext(Eos_freeContext.class,i);
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
	}

	public final New_blockContext new_block() throws RecognitionException {
		New_blockContext _localctx = new New_blockContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_new_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2241);
			match(BRACE_L);
			setState(2246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129095326364L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2181149494890984575L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 4202489L) != 0)) {
				{
				setState(2244);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PARENTHESES_L:
				case BRACKET_L:
				case BRACE_L:
				case OFFSET_L:
				case CEILING_L:
				case FLOOR_L:
				case OP_ADD:
				case OP_SUB:
				case OP_MUL:
				case OP_BANG:
				case OP_NOT:
				case OP_AND:
				case OP_AT:
				case OP_HASH:
				case LAMBDA_SLOT:
				case OP_UNIMPLEMENTED:
				case OP_DOT3:
				case OP_DOT2:
				case MAIN_PREFIX:
				case OP_ROOT2:
				case OP_PERCENT:
				case OP_REFERENCE:
				case OP_LABEL:
				case OP_LAST:
				case KW_WHILE:
				case KW_FOR:
				case KW_NEW:
				case KW_OBJECT:
				case KW_LAMBDA:
				case KW_TRY:
				case KW_MATCH:
				case INTEGER:
				case DECIMAL:
				case STRING_START:
				case KW_IF:
				case RETURN:
				case RESUME:
				case YIELD:
				case BREAK:
				case CONTINUE:
				case FALL_THROUGH:
				case RAISE:
				case SPECIAL:
				case RAW_ID:
				case UNICODE_ID:
				case KW_SWITCH:
					{
					setState(2242);
					new_call_item();
					}
					break;
				case COMMA:
				case SEMICOLON:
				case FAKE_COLON:
					{
					setState(2243);
					eos_free();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(2248);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2249);
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
	public static class New_call_itemContext extends ParserRuleContext {
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public New_call_keyContext new_call_key() {
			return getRuleContext(New_call_keyContext.class,0);
		}
		public New_call_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_call_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNew_call_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNew_call_item(this);
		}
	}

	public final New_call_itemContext new_call_item() throws RecognitionException {
		New_call_itemContext _localctx = new New_call_itemContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_new_call_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,314,_ctx) ) {
			case 1:
				{
				setState(2251);
				new_call_key();
				}
				break;
			}
			setState(2254);
			main_expression(0);
			}
		}
		catch (RecognitionException re) {
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
	public static class New_call_keyContext extends ParserRuleContext {
		public New_call_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_call_key; }
	 
		public New_call_keyContext() { }
		public void copyFrom(New_call_keyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NK2Context extends New_call_keyContext {
		public TerminalNode INTEGER() { return getToken(ValkyrieAntlrParser.INTEGER, 0); }
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public NK2Context(New_call_keyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNK2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNK2(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NK1Context extends New_call_keyContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public NK1Context(New_call_keyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNK1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNK1(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NK4Context extends New_call_keyContext {
		public Range_literalContext range_literal() {
			return getRuleContext(Range_literalContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public NK4Context(New_call_keyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNK4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNK4(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NK3Context extends New_call_keyContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public NK3Context(New_call_keyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNK3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNK3(this);
		}
	}

	public final New_call_keyContext new_call_key() throws RecognitionException {
		New_call_keyContext _localctx = new New_call_keyContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_new_call_key);
		try {
			setState(2267);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RAW_ID:
			case UNICODE_ID:
				_localctx = new NK1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2256);
				identifier();
				setState(2257);
				match(COLON);
				}
				break;
			case INTEGER:
				_localctx = new NK2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2259);
				match(INTEGER);
				setState(2260);
				match(COLON);
				}
				break;
			case STRING_START:
				_localctx = new NK3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2261);
				string();
				setState(2262);
				match(COLON);
				}
				break;
			case BRACKET_L:
			case OFFSET_L:
				_localctx = new NK4Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(2264);
				range_literal();
				setState(2265);
				match(COLON);
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
	public static class Tuple_literalContext extends ParserRuleContext {
		public TerminalNode PARENTHESES_L() { return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0); }
		public TerminalNode PARENTHESES_R() { return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0); }
		public List<Collection_pairContext> collection_pair() {
			return getRuleContexts(Collection_pairContext.class);
		}
		public Collection_pairContext collection_pair(int i) {
			return getRuleContext(Collection_pairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public Tuple_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterTuple_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitTuple_literal(this);
		}
	}

	public final Tuple_literalContext tuple_literal() throws RecognitionException {
		Tuple_literalContext _localctx = new Tuple_literalContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_tuple_literal);
		int _la;
		try {
			int _alt;
			setState(2289);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,318,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2269);
				match(PARENTHESES_L);
				setState(2270);
				match(PARENTHESES_R);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2271);
				match(PARENTHESES_L);
				setState(2272);
				collection_pair();
				setState(2275); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2273);
						match(COMMA);
						setState(2274);
						collection_pair();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2277); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,316,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(2280);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2279);
					match(COMMA);
					}
				}

				setState(2282);
				match(PARENTHESES_R);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2284);
				match(PARENTHESES_L);
				setState(2285);
				collection_pair();
				setState(2286);
				match(COMMA);
				setState(2287);
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
	public static class Collection_pairContext extends ParserRuleContext {
		public Main_expressionContext main_expression() {
			return getRuleContext(Main_expressionContext.class,0);
		}
		public Collection_keyContext collection_key() {
			return getRuleContext(Collection_keyContext.class,0);
		}
		public Collection_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCollection_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCollection_pair(this);
		}
	}

	public final Collection_pairContext collection_pair() throws RecognitionException {
		Collection_pairContext _localctx = new Collection_pairContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_collection_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2292);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,319,_ctx) ) {
			case 1:
				{
				setState(2291);
				collection_key();
				}
				break;
			}
			setState(2294);
			main_expression(0);
			}
		}
		catch (RecognitionException re) {
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
	public static class Collection_keyContext extends ParserRuleContext {
		public Collection_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collection_key; }
	 
		public Collection_keyContext() { }
		public void copyFrom(Collection_keyContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CK1Context extends Collection_keyContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public CK1Context(Collection_keyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCK1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCK1(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CK3Context extends Collection_keyContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public CK3Context(Collection_keyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCK3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCK3(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CK2Context extends Collection_keyContext {
		public TerminalNode INTEGER() { return getToken(ValkyrieAntlrParser.INTEGER, 0); }
		public TerminalNode COLON() { return getToken(ValkyrieAntlrParser.COLON, 0); }
		public CK2Context(Collection_keyContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterCK2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitCK2(this);
		}
	}

	public final Collection_keyContext collection_key() throws RecognitionException {
		Collection_keyContext _localctx = new Collection_keyContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_collection_key);
		try {
			setState(2304);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RAW_ID:
			case UNICODE_ID:
				_localctx = new CK1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2296);
				identifier();
				setState(2297);
				match(COLON);
				}
				break;
			case INTEGER:
				_localctx = new CK2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2299);
				match(INTEGER);
				setState(2300);
				match(COLON);
				}
				break;
			case STRING_START:
				_localctx = new CK3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(2301);
				string();
				setState(2302);
				match(COLON);
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
		public Range_literalContext range_literal() {
			return getRuleContext(Range_literalContext.class,0);
		}
		public TerminalNode OP_AND_THEN() { return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0); }
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
	}

	public final Slice_callContext slice_call() throws RecognitionException {
		Slice_callContext _localctx = new Slice_callContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_slice_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OP_AND_THEN) {
				{
				setState(2306);
				match(OP_AND_THEN);
				}
			}

			setState(2309);
			range_literal();
			}
		}
		catch (RecognitionException re) {
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
	public static class Range_literalContext extends ParserRuleContext {
		public TerminalNode BRACKET_L() { return getToken(ValkyrieAntlrParser.BRACKET_L, 0); }
		public TerminalNode BRACKET_R() { return getToken(ValkyrieAntlrParser.BRACKET_R, 0); }
		public List<Range_axisContext> range_axis() {
			return getRuleContexts(Range_axisContext.class);
		}
		public Range_axisContext range_axis(int i) {
			return getRuleContext(Range_axisContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(ValkyrieAntlrParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(ValkyrieAntlrParser.COMMA, i);
		}
		public TerminalNode OFFSET_L() { return getToken(ValkyrieAntlrParser.OFFSET_L, 0); }
		public TerminalNode OFFSET_R() { return getToken(ValkyrieAntlrParser.OFFSET_R, 0); }
		public Range_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterRange_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitRange_literal(this);
		}
	}

	public final Range_literalContext range_literal() throws RecognitionException {
		Range_literalContext _localctx = new Range_literalContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_range_literal);
		int _la;
		try {
			int _alt;
			setState(2341);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BRACKET_L:
				enterOuterAlt(_localctx, 1);
				{
				setState(2311);
				match(BRACKET_L);
				setState(2323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129095326432L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2181149494890984575L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 4202489L) != 0)) {
					{
					setState(2312);
					range_axis();
					setState(2317);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,322,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(2313);
							match(COMMA);
							setState(2314);
							range_axis();
							}
							} 
						}
						setState(2319);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,322,_ctx);
					}
					setState(2321);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2320);
						match(COMMA);
						}
					}

					}
				}

				setState(2325);
				match(BRACKET_R);
				}
				break;
			case OFFSET_L:
				enterOuterAlt(_localctx, 2);
				{
				setState(2326);
				match(OFFSET_L);
				setState(2338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 864691129095326432L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -2181149494890984575L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 4202489L) != 0)) {
					{
					setState(2327);
					range_axis();
					setState(2332);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,325,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(2328);
							match(COMMA);
							setState(2329);
							range_axis();
							}
							} 
						}
						setState(2334);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,325,_ctx);
					}
					setState(2336);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==COMMA) {
						{
						setState(2335);
						match(COMMA);
						}
					}

					}
				}

				setState(2340);
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
	public static class Range_axisContext extends ParserRuleContext {
		public Main_expressionContext index;
		public Main_expressionContext head;
		public Main_expressionContext tail;
		public Main_expressionContext step;
		public Main_expressionContext setp;
		public List<TerminalNode> COLON() { return getTokens(ValkyrieAntlrParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ValkyrieAntlrParser.COLON, i);
		}
		public List<Main_expressionContext> main_expression() {
			return getRuleContexts(Main_expressionContext.class);
		}
		public Main_expressionContext main_expression(int i) {
			return getRuleContext(Main_expressionContext.class,i);
		}
		public Range_joinContext range_join() {
			return getRuleContext(Range_joinContext.class,0);
		}
		public Range_axisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_axis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterRange_axis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitRange_axis(this);
		}
	}

	public final Range_axisContext range_axis() throws RecognitionException {
		Range_axisContext _localctx = new Range_axisContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_range_axis);
		try {
			setState(2385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,329,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2343);
				match(COLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2344);
				((Range_axisContext)_localctx).index = main_expression(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2345);
				((Range_axisContext)_localctx).head = main_expression(0);
				setState(2346);
				match(COLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2348);
				match(COLON);
				setState(2349);
				((Range_axisContext)_localctx).tail = main_expression(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2350);
				((Range_axisContext)_localctx).head = main_expression(0);
				setState(2351);
				match(COLON);
				setState(2352);
				((Range_axisContext)_localctx).tail = main_expression(0);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2354);
				range_join();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2355);
				((Range_axisContext)_localctx).head = main_expression(0);
				setState(2356);
				range_join();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(2358);
				match(COLON);
				setState(2359);
				((Range_axisContext)_localctx).tail = main_expression(0);
				setState(2360);
				match(COLON);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(2362);
				range_join();
				setState(2363);
				((Range_axisContext)_localctx).step = main_expression(0);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(2365);
				((Range_axisContext)_localctx).head = main_expression(0);
				setState(2366);
				match(COLON);
				setState(2367);
				((Range_axisContext)_localctx).tail = main_expression(0);
				setState(2368);
				match(COLON);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(2370);
				match(COLON);
				setState(2371);
				((Range_axisContext)_localctx).tail = main_expression(0);
				setState(2372);
				match(COLON);
				setState(2373);
				((Range_axisContext)_localctx).step = main_expression(0);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(2375);
				((Range_axisContext)_localctx).head = main_expression(0);
				setState(2376);
				range_join();
				setState(2377);
				((Range_axisContext)_localctx).setp = main_expression(0);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(2379);
				((Range_axisContext)_localctx).head = main_expression(0);
				setState(2380);
				match(COLON);
				setState(2381);
				((Range_axisContext)_localctx).tail = main_expression(0);
				setState(2382);
				match(COLON);
				setState(2383);
				((Range_axisContext)_localctx).step = main_expression(0);
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
	public static class ModifiersContext extends ParserRuleContext {
		public IdentifierContext identifier;
		public List<IdentifierContext> mods = new ArrayList<IdentifierContext>();
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
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_modifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==RAW_ID || _la==UNICODE_ID) {
				{
				{
				setState(2387);
				((ModifiersContext)_localctx).identifier = identifier();
				((ModifiersContext)_localctx).mods.add(((ModifiersContext)_localctx).identifier);
				}
				}
				setState(2392);
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
		public IdentifierContext identifier;
		public List<IdentifierContext> mods = new ArrayList<IdentifierContext>();
		public IdentifierContext id;
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
	}

	public final Modified_identifierContext modified_identifier() throws RecognitionException {
		Modified_identifierContext _localctx = new Modified_identifierContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_modified_identifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2396);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,331,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2393);
					((Modified_identifierContext)_localctx).identifier = identifier();
					((Modified_identifierContext)_localctx).mods.add(((Modified_identifierContext)_localctx).identifier);
					}
					} 
				}
				setState(2398);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,331,_ctx);
			}
			setState(2399);
			((Modified_identifierContext)_localctx).id = identifier();
			}
		}
		catch (RecognitionException re) {
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
		public IdentifierContext identifier;
		public List<IdentifierContext> mods = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> path = new ArrayList<IdentifierContext>();
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<NamejoinContext> namejoin() {
			return getRuleContexts(NamejoinContext.class);
		}
		public NamejoinContext namejoin(int i) {
			return getRuleContext(NamejoinContext.class,i);
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
	}

	public final Modified_namepathContext modified_namepath() throws RecognitionException {
		Modified_namepathContext _localctx = new Modified_namepathContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_modified_namepath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2404);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,332,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2401);
					((Modified_namepathContext)_localctx).identifier = identifier();
					((Modified_namepathContext)_localctx).mods.add(((Modified_namepathContext)_localctx).identifier);
					}
					} 
				}
				setState(2406);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,332,_ctx);
			}
			setState(2407);
			((Modified_namepathContext)_localctx).identifier = identifier();
			((Modified_namepathContext)_localctx).path.add(((Modified_namepathContext)_localctx).identifier);
			setState(2413);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,333,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2408);
					namejoin();
					setState(2409);
					((Modified_namepathContext)_localctx).identifier = identifier();
					((Modified_namepathContext)_localctx).path.add(((Modified_namepathContext)_localctx).identifier);
					}
					} 
				}
				setState(2415);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,333,_ctx);
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
	public static class Lambda_nameContext extends ParserRuleContext {
		public TerminalNode LAMBDA_SLOT() { return getToken(ValkyrieAntlrParser.LAMBDA_SLOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public Lambda_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterLambda_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitLambda_name(this);
		}
	}

	public final Lambda_nameContext lambda_name() throws RecognitionException {
		Lambda_nameContext _localctx = new Lambda_nameContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_lambda_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2416);
			match(LAMBDA_SLOT);
			setState(2419);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,334,_ctx) ) {
			case 1:
				{
				setState(2417);
				identifier();
				}
				break;
			case 2:
				{
				setState(2418);
				number();
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
	public static class Output_nameContext extends ParserRuleContext {
		public Output_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_output_name; }
	 
		public Output_nameContext() { }
		public void copyFrom(Output_nameContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PositiveOutputContext extends Output_nameContext {
		public TerminalNode INTEGER() { return getToken(ValkyrieAntlrParser.INTEGER, 0); }
		public TerminalNode OP_PERCENT() { return getToken(ValkyrieAntlrParser.OP_PERCENT, 0); }
		public TerminalNode OP_LAST() { return getToken(ValkyrieAntlrParser.OP_LAST, 0); }
		public PositiveOutputContext(Output_nameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterPositiveOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitPositiveOutput(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegativeOutputContext extends Output_nameContext {
		public TerminalNode OP_LAST() { return getToken(ValkyrieAntlrParser.OP_LAST, 0); }
		public TerminalNode INTEGER() { return getToken(ValkyrieAntlrParser.INTEGER, 0); }
		public NegativeOutputContext(Output_nameContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNegativeOutput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNegativeOutput(this);
		}
	}

	public final Output_nameContext output_name() throws RecognitionException {
		Output_nameContext _localctx = new Output_nameContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_output_name);
		int _la;
		try {
			setState(2427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,336,_ctx) ) {
			case 1:
				_localctx = new PositiveOutputContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(2421);
				_la = _input.LA(1);
				if ( !(_la==OP_PERCENT || _la==OP_LAST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(2422);
				match(INTEGER);
				}
				break;
			case 2:
				_localctx = new NegativeOutputContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(2423);
				match(OP_LAST);
				setState(2425);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,335,_ctx) ) {
				case 1:
					{
					setState(2424);
					match(INTEGER);
					}
					break;
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
	public static class Range_joinContext extends ParserRuleContext {
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
		public List<TerminalNode> COLON() { return getTokens(ValkyrieAntlrParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(ValkyrieAntlrParser.COLON, i);
		}
		public Range_joinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range_join; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterRange_join(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitRange_join(this);
		}
	}

	public final Range_joinContext range_join() throws RecognitionException {
		Range_joinContext _localctx = new Range_joinContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_range_join);
		try {
			setState(2432);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OP_PROPORTION:
				enterOuterAlt(_localctx, 1);
				{
				setState(2429);
				match(OP_PROPORTION);
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 2);
				{
				setState(2430);
				match(COLON);
				setState(2431);
				match(COLON);
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
	public static class Namepath_freeContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<Namejoin_freeContext> namejoin_free() {
			return getRuleContexts(Namejoin_freeContext.class);
		}
		public Namejoin_freeContext namejoin_free(int i) {
			return getRuleContext(Namejoin_freeContext.class,i);
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
	}

	public final Namepath_freeContext namepath_free() throws RecognitionException {
		Namepath_freeContext _localctx = new Namepath_freeContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_namepath_free);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2434);
			identifier();
			setState(2440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT || _la==OP_PROPORTION) {
				{
				{
				setState(2435);
				namejoin_free();
				setState(2436);
				identifier();
				}
				}
				setState(2442);
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
	public static class Namejoin_freeContext extends ParserRuleContext {
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
		public TerminalNode DOT() { return getToken(ValkyrieAntlrParser.DOT, 0); }
		public Namejoin_freeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namejoin_free; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNamejoin_free(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNamejoin_free(this);
		}
	}

	public final Namejoin_freeContext namejoin_free() throws RecognitionException {
		Namejoin_freeContext _localctx = new Namejoin_freeContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_namejoin_free);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2443);
			_la = _input.LA(1);
			if ( !(_la==DOT || _la==OP_PROPORTION) ) {
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
	public static class NamepathContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<NamejoinContext> namejoin() {
			return getRuleContexts(NamejoinContext.class);
		}
		public NamejoinContext namejoin(int i) {
			return getRuleContext(NamejoinContext.class,i);
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
	}

	public final NamepathContext namepath() throws RecognitionException {
		NamepathContext _localctx = new NamepathContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_namepath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2445);
			identifier();
			setState(2451);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,339,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2446);
					namejoin();
					setState(2447);
					identifier();
					}
					} 
				}
				setState(2453);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,339,_ctx);
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
	public static class NamejoinContext extends ParserRuleContext {
		public TerminalNode OP_PROPORTION() { return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0); }
		public NamejoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namejoin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).enterNamejoin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ValkyrieAntlrListener ) ((ValkyrieAntlrListener)listener).exitNamejoin(this);
		}
	}

	public final NamejoinContext namejoin() throws RecognitionException {
		NamejoinContext _localctx = new NamejoinContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_namejoin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2454);
			match(OP_PROPORTION);
			}
		}
		catch (RecognitionException re) {
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
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2456);
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
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2458);
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
	}

	public final Number_literalContext number_literal() throws RecognitionException {
		Number_literalContext _localctx = new Number_literalContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_number_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2460);
			number();
			setState(2462);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,340,_ctx) ) {
			case 1:
				{
				setState(2461);
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
		public TerminalNode STRING_START() { return getToken(ValkyrieAntlrParser.STRING_START, 0); }
		public TerminalNode STRING_END() { return getToken(ValkyrieAntlrParser.STRING_END, 0); }
		public List<TerminalNode> STRING_TEXT() { return getTokens(ValkyrieAntlrParser.STRING_TEXT); }
		public TerminalNode STRING_TEXT(int i) {
			return getToken(ValkyrieAntlrParser.STRING_TEXT, i);
		}
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
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2464);
			match(STRING_START);
			setState(2468);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==STRING_TEXT) {
				{
				{
				setState(2465);
				match(STRING_TEXT);
				}
				}
				setState(2470);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2471);
			match(STRING_END);
			}
		}
		catch (RecognitionException re) {
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
	}

	public final String_literalContext string_literal() throws RecognitionException {
		String_literalContext _localctx = new String_literalContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_string_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==RAW_ID || _la==UNICODE_ID) {
				{
				setState(2473);
				identifier();
				}
			}

			setState(2476);
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
		case 75:
			return main_expression_sempred((Main_expressionContext)_localctx, predIndex);
		case 77:
			return inline_expression_sempred((Inline_expressionContext)_localctx, predIndex);
		case 78:
			return type_expression_sempred((Type_expressionContext)_localctx, predIndex);
		case 123:
			return case_pattern_sempred((Case_patternContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean main_expression_sempred(Main_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 32);
		case 1:
			return precpred(_ctx, 31);
		case 2:
			return precpred(_ctx, 30);
		case 3:
			return precpred(_ctx, 29);
		case 4:
			return precpred(_ctx, 28);
		case 5:
			return precpred(_ctx, 27);
		case 6:
			return precpred(_ctx, 26);
		case 7:
			return precpred(_ctx, 25);
		case 8:
			return precpred(_ctx, 22);
		case 9:
			return precpred(_ctx, 21);
		case 10:
			return precpred(_ctx, 20);
		case 11:
			return precpred(_ctx, 19);
		case 12:
			return precpred(_ctx, 37);
		case 13:
			return precpred(_ctx, 36);
		case 14:
			return precpred(_ctx, 35);
		case 15:
			return precpred(_ctx, 34);
		case 16:
			return precpred(_ctx, 24);
		case 17:
			return precpred(_ctx, 23);
		}
		return true;
	}
	private boolean inline_expression_sempred(Inline_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 18:
			return precpred(_ctx, 15);
		case 19:
			return precpred(_ctx, 14);
		case 20:
			return precpred(_ctx, 13);
		case 21:
			return precpred(_ctx, 12);
		case 22:
			return precpred(_ctx, 11);
		case 23:
			return precpred(_ctx, 10);
		case 24:
			return precpred(_ctx, 7);
		case 25:
			return precpred(_ctx, 18);
		case 26:
			return precpred(_ctx, 17);
		case 27:
			return precpred(_ctx, 16);
		case 28:
			return precpred(_ctx, 9);
		case 29:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean type_expression_sempred(Type_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 30:
			return precpred(_ctx, 7);
		case 31:
			return precpred(_ctx, 6);
		case 32:
			return precpred(_ctx, 5);
		case 33:
			return precpred(_ctx, 10);
		case 34:
			return precpred(_ctx, 9);
		case 35:
			return precpred(_ctx, 8);
		}
		return true;
	}
	private boolean case_pattern_sempred(Case_patternContext _localctx, int predIndex) {
		switch (predIndex) {
		case 36:
			return precpred(_ctx, 3);
		case 37:
			return precpred(_ctx, 2);
		}
		return true;
	}

	private static final String _serializedATNSegment0 =
		"\u0004\u0001\u009b\u09af\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"+
		"r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"+
		"w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007"+
		"|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007"+
		"\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007"+
		"\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007"+
		"\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007"+
		"\u0089\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b\u0002\u008c\u0007"+
		"\u008c\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e\u0002\u008f\u0007"+
		"\u008f\u0002\u0090\u0007\u0090\u0002\u0091\u0007\u0091\u0002\u0092\u0007"+
		"\u0092\u0002\u0093\u0007\u0093\u0002\u0094\u0007\u0094\u0002\u0095\u0007"+
		"\u0095\u0002\u0096\u0007\u0096\u0002\u0097\u0007\u0097\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u0133\b\u0000\n\u0000\f\u0000\u0136\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\u013d\b\u0001"+
		"\n\u0001\f\u0001\u0140\t\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0003\u0002\u0152\b\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0005\u0005\u0159\b\u0005\n\u0005\f\u0005\u015c\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0162\b\u0005"+
		"\u0001\u0006\u0005\u0006\u0165\b\u0006\n\u0006\f\u0006\u0168\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u016d\b\u0006\n\u0006\f\u0006"+
		"\u0170\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0175\b"+
		"\u0006\u0001\u0006\u0005\u0006\u0178\b\u0006\n\u0006\f\u0006\u017b\t\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0180\b\u0006\u0003\u0006"+
		"\u0182\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"\u0188\b\u0007\u0001\b\u0001\b\u0001\b\u0004\b\u018d\b\b\u000b\b\f\b\u018e"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u0197\b\t\n\t"+
		"\f\t\u019a\t\t\u0001\t\u0003\t\u019d\b\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u01a4\b\n\n\n\f\n\u01a7\t\n\u0001\n\u0001\n\u0001\n"+
		"\u0003\n\u01ac\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u01b3\b\u000b\u0001\f\u0001\f\u0005\f\u01b7\b\f\n\f"+
		"\f\f\u01ba\t\f\u0001\f\u0001\f\u0001\f\u0005\f\u01bf\b\f\n\f\f\f\u01c2"+
		"\t\f\u0001\f\u0001\f\u0001\f\u0005\f\u01c7\b\f\n\f\f\f\u01ca\t\f\u0001"+
		"\f\u0003\f\u01cd\b\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0003\u000f\u01d4\b\u000f\u0001\u000f\u0005\u000f\u01d7\b\u000f\n\u000f"+
		"\f\u000f\u01da\t\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u01e0\b\u000f\u0001\u000f\u0003\u000f\u01e3\b\u000f\u0001"+
		"\u000f\u0003\u000f\u01e6\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01ea"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u01ee\b\u0010\n\u0010\f\u0010"+
		"\u01f1\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u01fa\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u0202\b\u0012"+
		"\n\u0012\f\u0012\u0205\t\u0012\u0001\u0012\u0003\u0012\u0208\b\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u020c\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0003\u0013\u0211\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0005"+
		"\u0014\u0216\b\u0014\n\u0014\f\u0014\u0219\t\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u021d\b\u0014\u0001\u0014\u0003\u0014\u0220\b\u0014\u0001"+
		"\u0015\u0005\u0015\u0223\b\u0015\n\u0015\f\u0015\u0226\t\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u022a\b\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u022e\b\u0015\u0001\u0015\u0003\u0015\u0231\b\u0015\u0001\u0016\u0005"+
		"\u0016\u0234\b\u0016\n\u0016\f\u0016\u0237\t\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0017\u0003\u0017\u023d\b\u0017\u0001\u0017\u0005\u0017"+
		"\u0240\b\u0017\n\u0017\f\u0017\u0243\t\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u0249\b\u0017\u0001\u0017\u0003\u0017\u024c"+
		"\b\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0250\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0005\u0018\u0254\b\u0018\n\u0018\f\u0018\u0257\t\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001"+
		"\u0019\u0003\u0019\u0260\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u0267\b\u001a\u0001\u001a\u0001\u001a\u0003"+
		"\u001a\u026b\b\u001a\u0001\u001b\u0003\u001b\u026e\b\u001b\u0001\u001b"+
		"\u0005\u001b\u0271\b\u001b\n\u001b\f\u001b\u0274\t\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u027a\b\u001b\u0001\u001b\u0003"+
		"\u001b\u027d\b\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0005"+
		"\u001c\u0283\b\u001c\n\u001c\f\u001c\u0286\t\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u028d\b\u001d\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001f\u0003\u001f\u0293\b\u001f\u0001\u001f"+
		"\u0005\u001f\u0296\b\u001f\n\u001f\f\u001f\u0299\t\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u029f\b\u001f\u0001\u001f\u0003"+
		"\u001f\u02a2\b\u001f\u0001\u001f\u0003\u001f\u02a5\b\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0001 \u0003 \u02ab\b \u0001 \u0001 \u0001!\u0001"+
		"!\u0005!\u02b1\b!\n!\f!\u02b4\t!\u0001!\u0001!\u0001\"\u0001\"\u0001\""+
		"\u0003\"\u02bb\b\"\u0001#\u0001#\u0003#\u02bf\b#\u0001$\u0001$\u0001$"+
		"\u0001$\u0005$\u02c5\b$\n$\f$\u02c8\t$\u0001$\u0001$\u0001%\u0005%\u02cd"+
		"\b%\n%\f%\u02d0\t%\u0001%\u0001%\u0001%\u0001%\u0003%\u02d6\b%\u0001%"+
		"\u0003%\u02d9\b%\u0001%\u0001%\u0001&\u0001&\u0005&\u02df\b&\n&\f&\u02e2"+
		"\t&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0003\'\u02e9\b\'\u0001(\u0005"+
		"(\u02ec\b(\n(\f(\u02ef\t(\u0001(\u0001(\u0001(\u0003(\u02f4\b(\u0001)"+
		"\u0003)\u02f7\b)\u0001)\u0005)\u02fa\b)\n)\f)\u02fd\t)\u0001)\u0001)\u0001"+
		")\u0001)\u0003)\u0303\b)\u0001)\u0001)\u0003)\u0307\b)\u0001)\u0001)\u0001"+
		"*\u0001*\u0001*\u0001*\u0001*\u0001*\u0005*\u0311\b*\n*\f*\u0314\t*\u0001"+
		"*\u0001*\u0003*\u0318\b*\u0001+\u0005+\u031b\b+\n+\f+\u031e\t+\u0001+"+
		"\u0005+\u0321\b+\n+\f+\u0324\t+\u0001+\u0001+\u0003+\u0328\b+\u0001+\u0003"+
		"+\u032b\b+\u0001+\u0003+\u032e\b+\u0001+\u0005+\u0331\b+\n+\f+\u0334\t"+
		"+\u0001+\u0005+\u0337\b+\n+\f+\u033a\t+\u0001+\u0001+\u0003+\u033e\b+"+
		"\u0001+\u0003+\u0341\b+\u0001+\u0001+\u0003+\u0345\b+\u0001,\u0001,\u0001"+
		",\u0003,\u034a\b,\u0001-\u0003-\u034d\b-\u0001-\u0003-\u0350\b-\u0001"+
		".\u0001.\u0001.\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0005"+
		"/\u035c\b/\n/\f/\u035f\t/\u0001/\u0003/\u0362\b/\u0003/\u0364\b/\u0001"+
		"/\u0003/\u0367\b/\u00010\u00010\u00010\u00011\u00031\u036d\b1\u00011\u0001"+
		"1\u00031\u0371\b1\u00011\u00011\u00011\u00031\u0376\b1\u00011\u00031\u0379"+
		"\b1\u00011\u00011\u00031\u037d\b1\u00011\u00011\u00031\u0381\b1\u0003"+
		"1\u0383\b1\u00012\u00032\u0386\b2\u00012\u00012\u00012\u00032\u038b\b"+
		"2\u00032\u038d\b2\u00012\u00032\u0390\b2\u00012\u00012\u00012\u00032\u0395"+
		"\b2\u00012\u00012\u00012\u00032\u039a\b2\u00012\u00032\u039d\b2\u0001"+
		"2\u00032\u03a0\b2\u00012\u00012\u00032\u03a4\b2\u00012\u00012\u00032\u03a8"+
		"\b2\u00012\u00032\u03ab\b2\u00032\u03ad\b2\u00013\u00013\u00013\u0001"+
		"3\u00013\u00013\u00053\u03b5\b3\n3\f3\u03b8\t3\u00013\u00033\u03bb\b3"+
		"\u00013\u00013\u00033\u03bf\b3\u00014\u00054\u03c2\b4\n4\f4\u03c5\t4\u0001"+
		"4\u00054\u03c8\b4\n4\f4\u03cb\t4\u00014\u00014\u00014\u00014\u00014\u0005"+
		"4\u03d2\b4\n4\f4\u03d5\t4\u00014\u00034\u03d8\b4\u00015\u00055\u03db\b"+
		"5\n5\f5\u03de\t5\u00015\u00015\u00015\u00035\u03e3\b5\u00015\u00015\u0001"+
		"6\u00016\u00056\u03e9\b6\n6\f6\u03ec\t6\u00016\u00016\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00037\u03f6\b7\u00018\u00058\u03f9\b8\n8\f8\u03fc"+
		"\t8\u00018\u00018\u00018\u00038\u0401\b8\u00018\u00018\u00038\u0405\b"+
		"8\u00019\u00019\u00039\u0409\b9\u0001:\u0001:\u0001:\u0005:\u040e\b:\n"+
		":\f:\u0411\t:\u0001:\u0003:\u0414\b:\u0001;\u0001;\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0004;\u041d\b;\u000b;\f;\u041e\u0001;\u0003;\u0422\b"+
		";\u0003;\u0424\b;\u0001;\u0001;\u0001;\u0001;\u0001;\u0001;\u0005;\u042c"+
		"\b;\n;\f;\u042f\t;\u0001;\u0003;\u0432\b;\u0003;\u0434\b;\u0001;\u0001"+
		";\u0001;\u0003;\u0439\b;\u0001;\u0001;\u0001;\u0001;\u0005;\u043f\b;\n"+
		";\f;\u0442\t;\u0001;\u0003;\u0445\b;\u0003;\u0447\b;\u0001;\u0001;\u0003"+
		";\u044b\b;\u0001;\u0001;\u0001;\u0001;\u0005;\u0451\b;\n;\f;\u0454\t;"+
		"\u0001;\u0003;\u0457\b;\u0003;\u0459\b;\u0001;\u0003;\u045c\b;\u0001<"+
		"\u0001<\u0001<\u0003<\u0461\b<\u0001<\u0001<\u0001<\u0003<\u0466\b<\u0001"+
		"<\u0001<\u0001<\u0001<\u0003<\u046c\b<\u0001<\u0001<\u0001<\u0003<\u0471"+
		"\b<\u0001<\u0001<\u0003<\u0475\b<\u0001<\u0001<\u0003<\u0479\b<\u0001"+
		"<\u0003<\u047c\b<\u0001<\u0001<\u0003<\u0480\b<\u0001<\u0003<\u0483\b"+
		"<\u0001=\u0005=\u0486\b=\n=\f=\u0489\t=\u0001=\u0001=\u0001=\u0001=\u0003"+
		"=\u048f\b=\u0001=\u0001=\u0001=\u0001=\u0005=\u0495\b=\n=\f=\u0498\t="+
		"\u0001=\u0001=\u0001=\u0001=\u0003=\u049e\b=\u0001=\u0001=\u0003=\u04a2"+
		"\b=\u0001>\u0001>\u0001>\u0001?\u0001?\u0001?\u0003?\u04aa\b?\u0001?\u0001"+
		"?\u0001@\u0005@\u04af\b@\n@\f@\u04b2\t@\u0001@\u0001@\u0001@\u0001@\u0005"+
		"@\u04b8\b@\n@\f@\u04bb\t@\u0001@\u0001@\u0003@\u04bf\b@\u0001A\u0005A"+
		"\u04c2\bA\nA\fA\u04c5\tA\u0001A\u0001A\u0001A\u0001A\u0001A\u0003A\u04cc"+
		"\bA\u0001A\u0001A\u0001A\u0001A\u0001A\u0005A\u04d3\bA\nA\fA\u04d6\tA"+
		"\u0001A\u0001A\u0001A\u0001A\u0001A\u0003A\u04dd\bA\u0001B\u0001B\u0001"+
		"B\u0001B\u0001B\u0001C\u0001C\u0001C\u0003C\u04e7\bC\u0001D\u0005D\u04ea"+
		"\bD\nD\fD\u04ed\tD\u0001D\u0001D\u0003D\u04f1\bD\u0001D\u0003D\u04f4\b"+
		"D\u0001D\u0001D\u0001E\u0005E\u04f9\bE\nE\fE\u04fc\tE\u0001E\u0001E\u0001"+
		"E\u0001E\u0001E\u0001E\u0003E\u0504\bE\u0001E\u0001E\u0001F\u0005F\u0509"+
		"\bF\nF\fF\u050c\tF\u0001F\u0001F\u0001F\u0001F\u0001F\u0003F\u0513\bF"+
		"\u0001F\u0003F\u0516\bF\u0001F\u0001F\u0001G\u0003G\u051b\bG\u0001G\u0001"+
		"G\u0001G\u0001G\u0003G\u0521\bG\u0001G\u0003G\u0524\bG\u0001G\u0001G\u0001"+
		"H\u0001H\u0001H\u0001I\u0001I\u0001I\u0001J\u0005J\u052f\bJ\nJ\fJ\u0532"+
		"\tJ\u0001J\u0001J\u0003J\u0536\bJ\u0001J\u0003J\u0539\bJ\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0003"+
		"K\u055a\bK\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0001K\u0001K\u0001K\u0001K\u0005K\u059b\bK\nK\fK\u059e\tK\u0001L\u0001"+
		"L\u0001L\u0003L\u05a3\bL\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0003M\u05b8\bM\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001"+
		"M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0005M\u05e4\bM\nM\fM\u05e7"+
		"\tM\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001"+
		"N\u0001N\u0004N\u05f4\bN\u000bN\fN\u05f5\u0001N\u0003N\u05f9\bN\u0003"+
		"N\u05fb\bN\u0001N\u0001N\u0001N\u0001N\u0003N\u0601\bN\u0001N\u0001N\u0001"+
		"N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001"+
		"N\u0001N\u0001N\u0001N\u0001N\u0005N\u0614\bN\nN\fN\u0617\tN\u0001O\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u0620\bO\u0001P\u0001P\u0003"+
		"P\u0624\bP\u0001P\u0003P\u0627\bP\u0001P\u0001P\u0001P\u0003P\u062c\b"+
		"P\u0001P\u0001P\u0001P\u0003P\u0631\bP\u0001P\u0001P\u0003P\u0635\bP\u0001"+
		"P\u0001P\u0001P\u0003P\u063a\bP\u0001P\u0003P\u063d\bP\u0001P\u0001P\u0001"+
		"P\u0001P\u0001P\u0001P\u0001P\u0001P\u0003P\u0647\bP\u0003P\u0649\bP\u0001"+
		"Q\u0001Q\u0001R\u0001R\u0001S\u0001S\u0001T\u0001T\u0001U\u0001U\u0001"+
		"V\u0001V\u0001W\u0001W\u0001X\u0001X\u0001Y\u0001Y\u0001Z\u0001Z\u0001"+
		"[\u0001[\u0001\\\u0001\\\u0001]\u0001]\u0001^\u0001^\u0001_\u0001_\u0001"+
		"_\u0001_\u0001_\u0001_\u0003_\u066d\b_\u0001`\u0001`\u0001`\u0003`\u0672"+
		"\b`\u0001a\u0001a\u0001a\u0001a\u0001a\u0003a\u0679\ba\u0001b\u0001b\u0001"+
		"b\u0001b\u0001b\u0001b\u0005b\u0681\bb\nb\fb\u0684\tb\u0001b\u0003b\u0687"+
		"\bb\u0001b\u0001b\u0001b\u0003b\u068c\bb\u0001b\u0001b\u0001b\u0003b\u0691"+
		"\bb\u0001b\u0001b\u0001b\u0001b\u0005b\u0697\bb\nb\fb\u069a\tb\u0001b"+
		"\u0003b\u069d\bb\u0001b\u0001b\u0003b\u06a1\bb\u0001c\u0001c\u0001c\u0003"+
		"c\u06a6\bc\u0001c\u0001c\u0003c\u06aa\bc\u0001c\u0003c\u06ad\bc\u0001"+
		"d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0001d\u0005d\u06b7\bd\nd"+
		"\fd\u06ba\td\u0001d\u0003d\u06bd\bd\u0001d\u0001d\u0001d\u0001d\u0001"+
		"d\u0001d\u0001d\u0001d\u0005d\u06c7\bd\nd\fd\u06ca\td\u0001d\u0003d\u06cd"+
		"\bd\u0001d\u0001d\u0003d\u06d1\bd\u0001e\u0003e\u06d4\be\u0001e\u0001"+
		"e\u0001e\u0001e\u0005e\u06da\be\ne\fe\u06dd\te\u0001e\u0003e\u06e0\be"+
		"\u0003e\u06e2\be\u0001e\u0001e\u0001e\u0001e\u0001e\u0005e\u06e9\be\n"+
		"e\fe\u06ec\te\u0001e\u0003e\u06ef\be\u0003e\u06f1\be\u0001e\u0003e\u06f4"+
		"\be\u0001f\u0001f\u0001f\u0003f\u06f9\bf\u0001f\u0001f\u0001g\u0001g\u0001"+
		"g\u0001h\u0005h\u0701\bh\nh\fh\u0704\th\u0001h\u0001h\u0001h\u0001h\u0001"+
		"h\u0005h\u070b\bh\nh\fh\u070e\th\u0001h\u0003h\u0711\bh\u0001h\u0001h"+
		"\u0001h\u0001h\u0005h\u0717\bh\nh\fh\u071a\th\u0001h\u0003h\u071d\bh\u0001"+
		"h\u0001h\u0001h\u0001h\u0001h\u0001h\u0005h\u0725\bh\nh\fh\u0728\th\u0001"+
		"h\u0003h\u072b\bh\u0001h\u0001h\u0003h\u072f\bh\u0001h\u0001h\u0001i\u0001"+
		"i\u0005i\u0735\bi\ni\fi\u0738\ti\u0001i\u0001i\u0001j\u0001j\u0001j\u0003"+
		"j\u073f\bj\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0001k\u0003k\u0748"+
		"\bk\u0001l\u0001l\u0001l\u0001m\u0001m\u0005m\u074f\bm\nm\fm\u0752\tm"+
		"\u0001m\u0001m\u0001n\u0001n\u0001n\u0001n\u0001n\u0003n\u075b\bn\u0001"+
		"o\u0001o\u0001o\u0005o\u0760\bo\no\fo\u0763\to\u0001o\u0001o\u0001p\u0001"+
		"p\u0001p\u0001q\u0001q\u0003q\u076c\bq\u0001q\u0003q\u076f\bq\u0001r\u0001"+
		"r\u0001r\u0001r\u0001r\u0001r\u0001r\u0005r\u0778\br\nr\fr\u077b\tr\u0001"+
		"r\u0003r\u077e\br\u0003r\u0780\br\u0001r\u0003r\u0783\br\u0001s\u0001"+
		"s\u0001s\u0005s\u0788\bs\ns\fs\u078b\ts\u0001s\u0003s\u078e\bs\u0001s"+
		"\u0003s\u0791\bs\u0001t\u0005t\u0794\bt\nt\ft\u0797\tt\u0001t\u0001t\u0003"+
		"t\u079b\bt\u0001t\u0001t\u0001u\u0005u\u07a0\bu\nu\fu\u07a3\tu\u0001u"+
		"\u0001u\u0001u\u0001u\u0003u\u07a9\bu\u0001u\u0001u\u0003u\u07ad\bu\u0001"+
		"u\u0001u\u0001v\u0005v\u07b2\bv\nv\fv\u07b5\tv\u0001v\u0001v\u0001v\u0001"+
		"w\u0001w\u0001w\u0005w\u07bd\bw\nw\fw\u07c0\tw\u0001w\u0001w\u0001x\u0003"+
		"x\u07c5\bx\u0001x\u0001x\u0001x\u0001x\u0001x\u0003x\u07cc\bx\u0003x\u07ce"+
		"\bx\u0001x\u0001x\u0001y\u0005y\u07d3\by\ny\fy\u07d6\ty\u0001y\u0001y"+
		"\u0001y\u0005y\u07db\by\ny\fy\u07de\ty\u0001y\u0001y\u0001y\u0001y\u0001"+
		"y\u0005y\u07e5\by\ny\fy\u07e8\ty\u0001y\u0003y\u07eb\by\u0003y\u07ed\b"+
		"y\u0001y\u0001y\u0005y\u07f1\by\ny\fy\u07f4\ty\u0001y\u0001y\u0001y\u0001"+
		"y\u0003y\u07fa\by\u0001y\u0001y\u0001y\u0005y\u07ff\by\ny\fy\u0802\ty"+
		"\u0001y\u0001y\u0001y\u0001y\u0001y\u0005y\u0809\by\ny\fy\u080c\ty\u0001"+
		"y\u0001y\u0001y\u0005y\u0811\by\ny\fy\u0814\ty\u0001y\u0001y\u0001y\u0001"+
		"y\u0003y\u081a\by\u0001y\u0001y\u0003y\u081e\by\u0001z\u0001z\u0005z\u0822"+
		"\bz\nz\fz\u0825\tz\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001"+
		"{\u0001{\u0005{\u0830\b{\n{\f{\u0833\t{\u0001|\u0001|\u0001|\u0001|\u0001"+
		"|\u0001|\u0001|\u0001|\u0001|\u0001|\u0003|\u083f\b|\u0001|\u0001|\u0001"+
		"|\u0001|\u0003|\u0845\b|\u0001|\u0001|\u0001|\u0001|\u0003|\u084b\b|\u0001"+
		"}\u0003}\u084e\b}\u0001}\u0001}\u0001}\u0003}\u0853\b}\u0001}\u0001}\u0001"+
		"}\u0003}\u0858\b}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001"+
		"}\u0001}\u0001}\u0001}\u0004}\u0865\b}\u000b}\f}\u0866\u0001}\u0003}\u086a"+
		"\b}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0005}\u0873\b}\n"+
		"}\f}\u0876\t}\u0001}\u0003}\u0879\b}\u0001}\u0001}\u0001}\u0003}\u087e"+
		"\b}\u0001}\u0001}\u0001}\u0001}\u0005}\u0884\b}\n}\f}\u0887\t}\u0001}"+
		"\u0003}\u088a\b}\u0001}\u0001}\u0001}\u0003}\u088f\b}\u0001}\u0001}\u0001"+
		"}\u0001}\u0005}\u0895\b}\n}\f}\u0898\t}\u0001}\u0003}\u089b\b}\u0001}"+
		"\u0001}\u0003}\u089f\b}\u0001~\u0001~\u0003~\u08a3\b~\u0001~\u0003~\u08a6"+
		"\b~\u0001~\u0003~\u08a9\b~\u0001~\u0001~\u0001\u007f\u0001\u007f\u0001"+
		"\u007f\u0003\u007f\u08b0\b\u007f\u0001\u007f\u0003\u007f\u08b3\b\u007f"+
		"\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0003\u007f"+
		"\u08ba\b\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0003\u007f"+
		"\u08c0\b\u007f\u0001\u0080\u0001\u0080\u0001\u0080\u0005\u0080\u08c5\b"+
		"\u0080\n\u0080\f\u0080\u08c8\t\u0080\u0001\u0080\u0001\u0080\u0001\u0081"+
		"\u0003\u0081\u08cd\b\u0081\u0001\u0081\u0001\u0081\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0001\u0082\u0001\u0082\u0003\u0082\u08dc\b\u0082\u0001\u0083"+
		"\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0004\u0083"+
		"\u08e4\b\u0083\u000b\u0083\f\u0083\u08e5\u0001\u0083\u0003\u0083\u08e9"+
		"\b\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001"+
		"\u0083\u0001\u0083\u0003\u0083\u08f2\b\u0083\u0001\u0084\u0003\u0084\u08f5"+
		"\b\u0084\u0001\u0084\u0001\u0084\u0001\u0085\u0001\u0085\u0001\u0085\u0001"+
		"\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0003\u0085\u0901"+
		"\b\u0085\u0001\u0086\u0003\u0086\u0904\b\u0086\u0001\u0086\u0001\u0086"+
		"\u0001\u0087\u0001\u0087\u0001\u0087\u0001\u0087\u0005\u0087\u090c\b\u0087"+
		"\n\u0087\f\u0087\u090f\t\u0087\u0001\u0087\u0003\u0087\u0912\b\u0087\u0003"+
		"\u0087\u0914\b\u0087\u0001\u0087\u0001\u0087\u0001\u0087\u0001\u0087\u0001"+
		"\u0087\u0005\u0087\u091b\b\u0087\n\u0087\f\u0087\u091e\t\u0087\u0001\u0087"+
		"\u0003\u0087\u0921\b\u0087\u0003\u0087\u0923\b\u0087\u0001\u0087\u0003"+
		"\u0087\u0926\b\u0087\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0003\u0088\u0952\b\u0088\u0001\u0089\u0005\u0089\u0955"+
		"\b\u0089\n\u0089\f\u0089\u0958\t\u0089\u0001\u008a\u0005\u008a\u095b\b"+
		"\u008a\n\u008a\f\u008a\u095e\t\u008a\u0001\u008a\u0001\u008a\u0001\u008b"+
		"\u0005\u008b\u0963\b\u008b\n\u008b\f\u008b\u0966\t\u008b\u0001\u008b\u0001"+
		"\u008b\u0001\u008b\u0001\u008b\u0005\u008b\u096c\b\u008b\n\u008b\f\u008b"+
		"\u096f\t\u008b\u0001\u008c\u0001\u008c\u0001\u008c\u0003\u008c\u0974\b"+
		"\u008c\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0003\u008d\u097a"+
		"\b\u008d\u0003\u008d\u097c\b\u008d\u0001\u008e\u0001\u008e\u0001\u008e"+
		"\u0003\u008e\u0981\b\u008e\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f"+
		"\u0005\u008f\u0987\b\u008f\n\u008f\f\u008f\u098a\t\u008f\u0001\u0090\u0001"+
		"\u0090\u0001\u0091\u0001\u0091\u0001\u0091\u0001\u0091\u0005\u0091\u0992"+
		"\b\u0091\n\u0091\f\u0091\u0995\t\u0091\u0001\u0092\u0001\u0092\u0001\u0093"+
		"\u0001\u0093\u0001\u0094\u0001\u0094\u0001\u0095\u0001\u0095\u0003\u0095"+
		"\u099f\b\u0095\u0001\u0096\u0001\u0096\u0005\u0096\u09a3\b\u0096\n\u0096"+
		"\f\u0096\u09a6\t\u0096\u0001\u0096\u0001\u0096\u0001\u0097\u0003\u0097"+
		"\u09ab\b\u0097\u0001\u0097\u0001\u0097\u0001\u0097\u0000\u0004\u0096\u009a"+
		"\u009c\u00f6\u0098\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfh"+
		"jlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092"+
		"\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa"+
		"\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2"+
		"\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da"+
		"\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2"+
		"\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a"+
		"\u010c\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122"+
		"\u0124\u0126\u0128\u012a\u012c\u012e\u0000\u001a\u0001\u0000\u0003\u0004"+
		"\u0001\u0000\u0002\u0004\u0003\u0000\u0001\u0001\u0005\u0005\u001e\u001e"+
		"\u0002\u0000\u0006\u0006tt\u0002\u0000\u0006\u000600\u0002\u0000<<ww\u0001"+
		"\u0000\u0088\u0089\u0007\u0000\u0019\u001a\u001d\u001d:;EE]^abff\u0004"+
		"\u0000\u001f\u001f::QQce\u0003\u0000!%)*..\u0001\u0000EF\u0001\u0000I"+
		"K\u0002\u0000``bb\u0001\u000001\u0001\u0000\u001d \u0001\u0000\u0019\u001a"+
		"\u0001\u0000=B\u0003\u0000&(,-22\u0003\u0000++3359\u0002\u0000\u0006\u0006"+
		"11\u0002\u0000\u0019\u0019FF\u0001\u0000]^\u0002\u0000eeii\u0002\u0000"+
		"\u0001\u0001\u0005\u0005\u0001\u0000\u0090\u0091\u0001\u0000\u0082\u0083"+
		"\u0b0c\u0000\u0134\u0001\u0000\u0000\u0000\u0002\u0139\u0001\u0000\u0000"+
		"\u0000\u0004\u0151\u0001\u0000\u0000\u0000\u0006\u0153\u0001\u0000\u0000"+
		"\u0000\b\u0155\u0001\u0000\u0000\u0000\n\u015a\u0001\u0000\u0000\u0000"+
		"\f\u0181\u0001\u0000\u0000\u0000\u000e\u0187\u0001\u0000\u0000\u0000\u0010"+
		"\u018c\u0001\u0000\u0000\u0000\u0012\u0192\u0001\u0000\u0000\u0000\u0014"+
		"\u01a5\u0001\u0000\u0000\u0000\u0016\u01b2\u0001\u0000\u0000\u0000\u0018"+
		"\u01cc\u0001\u0000\u0000\u0000\u001a\u01ce\u0001\u0000\u0000\u0000\u001c"+
		"\u01d0\u0001\u0000\u0000\u0000\u001e\u01d3\u0001\u0000\u0000\u0000 \u01eb"+
		"\u0001\u0000\u0000\u0000\"\u01f9\u0001\u0000\u0000\u0000$\u020b\u0001"+
		"\u0000\u0000\u0000&\u0210\u0001\u0000\u0000\u0000(\u0217\u0001\u0000\u0000"+
		"\u0000*\u0224\u0001\u0000\u0000\u0000,\u0235\u0001\u0000\u0000\u0000."+
		"\u023c\u0001\u0000\u0000\u00000\u0251\u0001\u0000\u0000\u00002\u025f\u0001"+
		"\u0000\u0000\u00004\u0261\u0001\u0000\u0000\u00006\u026d\u0001\u0000\u0000"+
		"\u00008\u0280\u0001\u0000\u0000\u0000:\u028c\u0001\u0000\u0000\u0000<"+
		"\u028e\u0001\u0000\u0000\u0000>\u0292\u0001\u0000\u0000\u0000@\u02a8\u0001"+
		"\u0000\u0000\u0000B\u02ae\u0001\u0000\u0000\u0000D\u02ba\u0001\u0000\u0000"+
		"\u0000F\u02bc\u0001\u0000\u0000\u0000H\u02c0\u0001\u0000\u0000\u0000J"+
		"\u02ce\u0001\u0000\u0000\u0000L\u02dc\u0001\u0000\u0000\u0000N\u02e8\u0001"+
		"\u0000\u0000\u0000P\u02ed\u0001\u0000\u0000\u0000R\u02f6\u0001\u0000\u0000"+
		"\u0000T\u0317\u0001\u0000\u0000\u0000V\u0344\u0001\u0000\u0000\u0000X"+
		"\u0349\u0001\u0000\u0000\u0000Z\u034c\u0001\u0000\u0000\u0000\\\u0351"+
		"\u0001\u0000\u0000\u0000^\u0366\u0001\u0000\u0000\u0000`\u0368\u0001\u0000"+
		"\u0000\u0000b\u0382\u0001\u0000\u0000\u0000d\u03ac\u0001\u0000\u0000\u0000"+
		"f\u03be\u0001\u0000\u0000\u0000h\u03d7\u0001\u0000\u0000\u0000j\u03dc"+
		"\u0001\u0000\u0000\u0000l\u03e6\u0001\u0000\u0000\u0000n\u03f5\u0001\u0000"+
		"\u0000\u0000p\u03fa\u0001\u0000\u0000\u0000r\u0408\u0001\u0000\u0000\u0000"+
		"t\u040a\u0001\u0000\u0000\u0000v\u045b\u0001\u0000\u0000\u0000x\u0482"+
		"\u0001\u0000\u0000\u0000z\u04a1\u0001\u0000\u0000\u0000|\u04a3\u0001\u0000"+
		"\u0000\u0000~\u04a9\u0001\u0000\u0000\u0000\u0080\u04b0\u0001\u0000\u0000"+
		"\u0000\u0082\u04dc\u0001\u0000\u0000\u0000\u0084\u04de\u0001\u0000\u0000"+
		"\u0000\u0086\u04e6\u0001\u0000\u0000\u0000\u0088\u04eb\u0001\u0000\u0000"+
		"\u0000\u008a\u04fa\u0001\u0000\u0000\u0000\u008c\u050a\u0001\u0000\u0000"+
		"\u0000\u008e\u051a\u0001\u0000\u0000\u0000\u0090\u0527\u0001\u0000\u0000"+
		"\u0000\u0092\u052a\u0001\u0000\u0000\u0000\u0094\u0530\u0001\u0000\u0000"+
		"\u0000\u0096\u0559\u0001\u0000\u0000\u0000\u0098\u05a2\u0001\u0000\u0000"+
		"\u0000\u009a\u05b7\u0001\u0000\u0000\u0000\u009c\u0600\u0001\u0000\u0000"+
		"\u0000\u009e\u061f\u0001\u0000\u0000\u0000\u00a0\u0648\u0001\u0000\u0000"+
		"\u0000\u00a2\u064a\u0001\u0000\u0000\u0000\u00a4\u064c\u0001\u0000\u0000"+
		"\u0000\u00a6\u064e\u0001\u0000\u0000\u0000\u00a8\u0650\u0001\u0000\u0000"+
		"\u0000\u00aa\u0652\u0001\u0000\u0000\u0000\u00ac\u0654\u0001\u0000\u0000"+
		"\u0000\u00ae\u0656\u0001\u0000\u0000\u0000\u00b0\u0658\u0001\u0000\u0000"+
		"\u0000\u00b2\u065a\u0001\u0000\u0000\u0000\u00b4\u065c\u0001\u0000\u0000"+
		"\u0000\u00b6\u065e\u0001\u0000\u0000\u0000\u00b8\u0660\u0001\u0000\u0000"+
		"\u0000\u00ba\u0662\u0001\u0000\u0000\u0000\u00bc\u0664\u0001\u0000\u0000"+
		"\u0000\u00be\u066c\u0001\u0000\u0000\u0000\u00c0\u0671\u0001\u0000\u0000"+
		"\u0000\u00c2\u0678\u0001\u0000\u0000\u0000\u00c4\u06a0\u0001\u0000\u0000"+
		"\u0000\u00c6\u06ac\u0001\u0000\u0000\u0000\u00c8\u06d0\u0001\u0000\u0000"+
		"\u0000\u00ca\u06f3\u0001\u0000\u0000\u0000\u00cc\u06f8\u0001\u0000\u0000"+
		"\u0000\u00ce\u06fc\u0001\u0000\u0000\u0000\u00d0\u0702\u0001\u0000\u0000"+
		"\u0000\u00d2\u0732\u0001\u0000\u0000\u0000\u00d4\u073e\u0001\u0000\u0000"+
		"\u0000\u00d6\u0747\u0001\u0000\u0000\u0000\u00d8\u0749\u0001\u0000\u0000"+
		"\u0000\u00da\u074c\u0001\u0000\u0000\u0000\u00dc\u075a\u0001\u0000\u0000"+
		"\u0000\u00de\u075c\u0001\u0000\u0000\u0000\u00e0\u0766\u0001\u0000\u0000"+
		"\u0000\u00e2\u0769\u0001\u0000\u0000\u0000\u00e4\u0782\u0001\u0000\u0000"+
		"\u0000\u00e6\u0784\u0001\u0000\u0000\u0000\u00e8\u0795\u0001\u0000\u0000"+
		"\u0000\u00ea\u07a1\u0001\u0000\u0000\u0000\u00ec\u07b3\u0001\u0000\u0000"+
		"\u0000\u00ee\u07b9\u0001\u0000\u0000\u0000\u00f0\u07c4\u0001\u0000\u0000"+
		"\u0000\u00f2\u081d\u0001\u0000\u0000\u0000\u00f4\u081f\u0001\u0000\u0000"+
		"\u0000\u00f6\u0826\u0001\u0000\u0000\u0000\u00f8\u084a\u0001\u0000\u0000"+
		"\u0000\u00fa\u089e\u0001\u0000\u0000\u0000\u00fc\u08a0\u0001\u0000\u0000"+
		"\u0000\u00fe\u08bf\u0001\u0000\u0000\u0000\u0100\u08c1\u0001\u0000\u0000"+
		"\u0000\u0102\u08cc\u0001\u0000\u0000\u0000\u0104\u08db\u0001\u0000\u0000"+
		"\u0000\u0106\u08f1\u0001\u0000\u0000\u0000\u0108\u08f4\u0001\u0000\u0000"+
		"\u0000\u010a\u0900\u0001\u0000\u0000\u0000\u010c\u0903\u0001\u0000\u0000"+
		"\u0000\u010e\u0925\u0001\u0000\u0000\u0000\u0110\u0951\u0001\u0000\u0000"+
		"\u0000\u0112\u0956\u0001\u0000\u0000\u0000\u0114\u095c\u0001\u0000\u0000"+
		"\u0000\u0116\u0964\u0001\u0000\u0000\u0000\u0118\u0970\u0001\u0000\u0000"+
		"\u0000\u011a\u097b\u0001\u0000\u0000\u0000\u011c\u0980\u0001\u0000\u0000"+
		"\u0000\u011e\u0982\u0001\u0000\u0000\u0000\u0120\u098b\u0001\u0000\u0000"+
		"\u0000\u0122\u098d\u0001\u0000\u0000\u0000\u0124\u0996\u0001\u0000\u0000"+
		"\u0000\u0126\u0998\u0001\u0000\u0000\u0000\u0128\u099a\u0001\u0000\u0000"+
		"\u0000\u012a\u099c\u0001\u0000\u0000\u0000\u012c\u09a0\u0001\u0000\u0000"+
		"\u0000\u012e\u09aa\u0001\u0000\u0000\u0000\u0130\u0133\u0003\u0004\u0002"+
		"\u0000\u0131\u0133\u0003\u0006\u0003\u0000\u0132\u0130\u0001\u0000\u0000"+
		"\u0000\u0132\u0131\u0001\u0000\u0000\u0000\u0133\u0136\u0001\u0000\u0000"+
		"\u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0134\u0135\u0001\u0000\u0000"+
		"\u0000\u0135\u0137\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000"+
		"\u0000\u0137\u0138\u0005\u0000\u0000\u0001\u0138\u0001\u0001\u0000\u0000"+
		"\u0000\u0139\u013e\u0005\u000b\u0000\u0000\u013a\u013d\u0003\u0004\u0002"+
		"\u0000\u013b\u013d\u0003\u0006\u0003\u0000\u013c\u013a\u0001\u0000\u0000"+
		"\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013d\u0140\u0001\u0000\u0000"+
		"\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e\u013f\u0001\u0000\u0000"+
		"\u0000\u013f\u0141\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000"+
		"\u0000\u0141\u0142\u0005\f\u0000\u0000\u0142\u0003\u0001\u0000\u0000\u0000"+
		"\u0143\u0152\u0003\n\u0005\u0000\u0144\u0152\u0003\f\u0006\u0000\u0145"+
		"\u0152\u0003\u001c\u000e\u0000\u0146\u0152\u0003\u001e\u000f\u0000\u0147"+
		"\u0152\u0003>\u001f\u0000\u0148\u0152\u0003J%\u0000\u0149\u0152\u0003"+
		".\u0017\u0000\u014a\u0152\u00036\u001b\u0000\u014b\u0152\u0003R)\u0000"+
		"\u014c\u0152\u0003z=\u0000\u014d\u0152\u0003p8\u0000\u014e\u0152\u0003"+
		"\u0086C\u0000\u014f\u0152\u0003\u0082A\u0000\u0150\u0152\u0003\u0094J"+
		"\u0000\u0151\u0143\u0001\u0000\u0000\u0000\u0151\u0144\u0001\u0000\u0000"+
		"\u0000\u0151\u0145\u0001\u0000\u0000\u0000\u0151\u0146\u0001\u0000\u0000"+
		"\u0000\u0151\u0147\u0001\u0000\u0000\u0000\u0151\u0148\u0001\u0000\u0000"+
		"\u0000\u0151\u0149\u0001\u0000\u0000\u0000\u0151\u014a\u0001\u0000\u0000"+
		"\u0000\u0151\u014b\u0001\u0000\u0000\u0000\u0151\u014c\u0001\u0000\u0000"+
		"\u0000\u0151\u014d\u0001\u0000\u0000\u0000\u0151\u014e\u0001\u0000\u0000"+
		"\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0151\u0150\u0001\u0000\u0000"+
		"\u0000\u0152\u0005\u0001\u0000\u0000\u0000\u0153\u0154\u0007\u0000\u0000"+
		"\u0000\u0154\u0007\u0001\u0000\u0000\u0000\u0155\u0156\u0007\u0001\u0000"+
		"\u0000\u0156\t\u0001\u0000\u0000\u0000\u0157\u0159\u0003\u00e4r\u0000"+
		"\u0158\u0157\u0001\u0000\u0000\u0000\u0159\u015c\u0001\u0000\u0000\u0000"+
		"\u015a\u0158\u0001\u0000\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000"+
		"\u015b\u015d\u0001\u0000\u0000\u0000\u015c\u015a\u0001\u0000\u0000\u0000"+
		"\u015d\u015e\u0003\u0112\u0089\u0000\u015e\u015f\u0005j\u0000\u0000\u015f"+
		"\u0161\u0003\u011e\u008f\u0000\u0160\u0162\u0003\u0006\u0003\u0000\u0161"+
		"\u0160\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000\u0000\u0162"+
		"\u000b\u0001\u0000\u0000\u0000\u0163\u0165\u0003\u00e4r\u0000\u0164\u0163"+
		"\u0001\u0000\u0000\u0000\u0165\u0168\u0001\u0000\u0000\u0000\u0166\u0164"+
		"\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\u0169"+
		"\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0169\u016a"+
		"\u0005k\u0000\u0000\u016a\u0182\u0003\b\u0004\u0000\u016b\u016d\u0003"+
		"\u00e4r\u0000\u016c\u016b\u0001\u0000\u0000\u0000\u016d\u0170\u0001\u0000"+
		"\u0000\u0000\u016e\u016c\u0001\u0000\u0000\u0000\u016e\u016f\u0001\u0000"+
		"\u0000\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170\u016e\u0001\u0000"+
		"\u0000\u0000\u0171\u0172\u0005k\u0000\u0000\u0172\u0174\u0003\u0018\f"+
		"\u0000\u0173\u0175\u0003\b\u0004\u0000\u0174\u0173\u0001\u0000\u0000\u0000"+
		"\u0174\u0175\u0001\u0000\u0000\u0000\u0175\u0182\u0001\u0000\u0000\u0000"+
		"\u0176\u0178\u0003\u00e4r\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0178"+
		"\u017b\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u0179"+
		"\u017a\u0001\u0000\u0000\u0000\u017a\u017c\u0001\u0000\u0000\u0000\u017b"+
		"\u0179\u0001\u0000\u0000\u0000\u017c\u017d\u0005k\u0000\u0000\u017d\u017f"+
		"\u0003\u000e\u0007\u0000\u017e\u0180\u0003\b\u0004\u0000\u017f\u017e\u0001"+
		"\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0182\u0001"+
		"\u0000\u0000\u0000\u0181\u0166\u0001\u0000\u0000\u0000\u0181\u016e\u0001"+
		"\u0000\u0000\u0000\u0181\u0179\u0001\u0000\u0000\u0000\u0182\r\u0001\u0000"+
		"\u0000\u0000\u0183\u0188\u0003\u0010\b\u0000\u0184\u0188\u0003\u0012\t"+
		"\u0000\u0185\u0188\u0003\u0014\n\u0000\u0186\u0188\u0003\b\u0004\u0000"+
		"\u0187\u0183\u0001\u0000\u0000\u0000\u0187\u0184\u0001\u0000\u0000\u0000"+
		"\u0187\u0185\u0001\u0000\u0000\u0000\u0187\u0186\u0001\u0000\u0000\u0000"+
		"\u0188\u000f\u0001\u0000\u0000\u0000\u0189\u018a\u0003\u0126\u0093\u0000"+
		"\u018a\u018b\u0003\u001a\r\u0000\u018b\u018d\u0001\u0000\u0000\u0000\u018c"+
		"\u0189\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e"+
		"\u018c\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018f"+
		"\u0190\u0001\u0000\u0000\u0000\u0190\u0191\u0005\u001d\u0000\u0000\u0191"+
		"\u0011\u0001\u0000\u0000\u0000\u0192\u0198\u0003\u0126\u0093\u0000\u0193"+
		"\u0194\u0003\u001a\r\u0000\u0194\u0195\u0003\u0126\u0093\u0000\u0195\u0197"+
		"\u0001\u0000\u0000\u0000\u0196\u0193\u0001\u0000\u0000\u0000\u0197\u019a"+
		"\u0001\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198\u0199"+
		"\u0001\u0000\u0000\u0000\u0199\u019c\u0001\u0000\u0000\u0000\u019a\u0198"+
		"\u0001\u0000\u0000\u0000\u019b\u019d\u0003\u001a\r\u0000\u019c\u019b\u0001"+
		"\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d\u019e\u0001"+
		"\u0000\u0000\u0000\u019e\u019f\u0003\u0018\f\u0000\u019f\u0013\u0001\u0000"+
		"\u0000\u0000\u01a0\u01a1\u0003\u0126\u0093\u0000\u01a1\u01a2\u0003\u001a"+
		"\r\u0000\u01a2\u01a4\u0001\u0000\u0000\u0000\u01a3\u01a0\u0001\u0000\u0000"+
		"\u0000\u01a4\u01a7\u0001\u0000\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a6\u0001\u0000\u0000\u0000\u01a6\u01a8\u0001\u0000\u0000"+
		"\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a8\u01ab\u0003\u0016\u000b"+
		"\u0000\u01a9\u01aa\u0005\\\u0000\u0000\u01aa\u01ac\u0003\u0016\u000b\u0000"+
		"\u01ab\u01a9\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001\u0000\u0000\u0000"+
		"\u01ac\u0015\u0001\u0000\u0000\u0000\u01ad\u01ae\u0005L\u0000\u0000\u01ae"+
		"\u01b3\u0003\u0126\u0093\u0000\u01af\u01b0\u0005M\u0000\u0000\u01b0\u01b3"+
		"\u0003\u0126\u0093\u0000\u01b1\u01b3\u0003\u0126\u0093\u0000\u01b2\u01ad"+
		"\u0001\u0000\u0000\u0000\u01b2\u01af\u0001\u0000\u0000\u0000\u01b2\u01b1"+
		"\u0001\u0000\u0000\u0000\u01b3\u0017\u0001\u0000\u0000\u0000\u01b4\u01b8"+
		"\u0005\u0007\u0000\u0000\u01b5\u01b7\u0003\u000e\u0007\u0000\u01b6\u01b5"+
		"\u0001\u0000\u0000\u0000\u01b7\u01ba\u0001\u0000\u0000\u0000\u01b8\u01b6"+
		"\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01bb"+
		"\u0001\u0000\u0000\u0000\u01ba\u01b8\u0001\u0000\u0000\u0000\u01bb\u01cd"+
		"\u0005\b\u0000\u0000\u01bc\u01c0\u0005\t\u0000\u0000\u01bd\u01bf\u0003"+
		"\u000e\u0007\u0000\u01be\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c2\u0001"+
		"\u0000\u0000\u0000\u01c0\u01be\u0001\u0000\u0000\u0000\u01c0\u01c1\u0001"+
		"\u0000\u0000\u0000\u01c1\u01c3\u0001\u0000\u0000\u0000\u01c2\u01c0\u0001"+
		"\u0000\u0000\u0000\u01c3\u01cd\u0005\n\u0000\u0000\u01c4\u01c8\u0005\u000b"+
		"\u0000\u0000\u01c5\u01c7\u0003\u000e\u0007\u0000\u01c6\u01c5\u0001\u0000"+
		"\u0000\u0000\u01c7\u01ca\u0001\u0000\u0000\u0000\u01c8\u01c6\u0001\u0000"+
		"\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9\u01cb\u0001\u0000"+
		"\u0000\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000\u01cb\u01cd\u0005\f\u0000"+
		"\u0000\u01cc\u01b4\u0001\u0000\u0000\u0000\u01cc\u01bc\u0001\u0000\u0000"+
		"\u0000\u01cc\u01c4\u0001\u0000\u0000\u0000\u01cd\u0019\u0001\u0000\u0000"+
		"\u0000\u01ce\u01cf\u0007\u0002\u0000\u0000\u01cf\u001b\u0001\u0000\u0000"+
		"\u0000\u01d0\u01d1\u0005l\u0000\u0000\u01d1\u001d\u0001\u0000\u0000\u0000"+
		"\u01d2\u01d4\u0003\u00d0h\u0000\u01d3\u01d2\u0001\u0000\u0000\u0000\u01d3"+
		"\u01d4\u0001\u0000\u0000\u0000\u01d4\u01d8\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d7\u0003\u00e4r\u0000\u01d6\u01d5\u0001\u0000\u0000\u0000\u01d7\u01da"+
		"\u0001\u0000\u0000\u0000\u01d8\u01d6\u0001\u0000\u0000\u0000\u01d8\u01d9"+
		"\u0001\u0000\u0000\u0000\u01d9\u01db\u0001\u0000\u0000\u0000\u01da\u01d8"+
		"\u0001\u0000\u0000\u0000\u01db\u01dc\u0003\u0112\u0089\u0000\u01dc\u01dd"+
		"\u0005m\u0000\u0000\u01dd\u01df\u0003\u0126\u0093\u0000\u01de\u01e0\u0003"+
		"\u00c4b\u0000\u01df\u01de\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000"+
		"\u0000\u0000\u01e0\u01e2\u0001\u0000\u0000\u0000\u01e1\u01e3\u0003$\u0012"+
		"\u0000\u01e2\u01e1\u0001\u0000\u0000\u0000\u01e2\u01e3\u0001\u0000\u0000"+
		"\u0000\u01e3\u01e5\u0001\u0000\u0000\u0000\u01e4\u01e6\u0003|>\u0000\u01e5"+
		"\u01e4\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6"+
		"\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e9\u0003 \u0010\u0000\u01e8\u01ea"+
		"\u0003\u0006\u0003\u0000\u01e9\u01e8\u0001\u0000\u0000\u0000\u01e9\u01ea"+
		"\u0001\u0000\u0000\u0000\u01ea\u001f\u0001\u0000\u0000\u0000\u01eb\u01ef"+
		"\u0005\u000b\u0000\u0000\u01ec\u01ee\u0003\"\u0011\u0000\u01ed\u01ec\u0001"+
		"\u0000\u0000\u0000\u01ee\u01f1\u0001\u0000\u0000\u0000\u01ef\u01ed\u0001"+
		"\u0000\u0000\u0000\u01ef\u01f0\u0001\u0000\u0000\u0000\u01f0\u01f2\u0001"+
		"\u0000\u0000\u0000\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f2\u01f3\u0005"+
		"\f\u0000\u0000\u01f3!\u0001\u0000\u0000\u0000\u01f4\u01fa\u0003,\u0016"+
		"\u0000\u01f5\u01fa\u0003*\u0015\u0000\u01f6\u01fa\u0003(\u0014\u0000\u01f7"+
		"\u01fa\u0003\u00e0p\u0000\u01f8\u01fa\u0003\b\u0004\u0000\u01f9\u01f4"+
		"\u0001\u0000\u0000\u0000\u01f9\u01f5\u0001\u0000\u0000\u0000\u01f9\u01f6"+
		"\u0001\u0000\u0000\u0000\u01f9\u01f7\u0001\u0000\u0000\u0000\u01f9\u01f8"+
		"\u0001\u0000\u0000\u0000\u01fa#\u0001\u0000\u0000\u0000\u01fb\u01fc\u0005"+
		"\u0007\u0000\u0000\u01fc\u020c\u0005\b\u0000\u0000\u01fd\u01fe\u0005\u0007"+
		"\u0000\u0000\u01fe\u0203\u0003&\u0013\u0000\u01ff\u0200\u0005\u0002\u0000"+
		"\u0000\u0200\u0202\u0003&\u0013\u0000\u0201\u01ff\u0001\u0000\u0000\u0000"+
		"\u0202\u0205\u0001\u0000\u0000\u0000\u0203\u0201\u0001\u0000\u0000\u0000"+
		"\u0203\u0204\u0001\u0000\u0000\u0000\u0204\u0207\u0001\u0000\u0000\u0000"+
		"\u0205\u0203\u0001\u0000\u0000\u0000\u0206\u0208\u0005\u0002\u0000\u0000"+
		"\u0207\u0206\u0001\u0000\u0000\u0000\u0207\u0208\u0001\u0000\u0000\u0000"+
		"\u0208\u0209\u0001\u0000\u0000\u0000\u0209\u020a\u0005\b\u0000\u0000\u020a"+
		"\u020c\u0001\u0000\u0000\u0000\u020b\u01fb\u0001\u0000\u0000\u0000\u020b"+
		"\u01fd\u0001\u0000\u0000\u0000\u020c%\u0001\u0000\u0000\u0000\u020d\u020e"+
		"\u0003\u0126\u0093\u0000\u020e\u020f\u0005\u0006\u0000\u0000\u020f\u0211"+
		"\u0001\u0000\u0000\u0000\u0210\u020d\u0001\u0000\u0000\u0000\u0210\u0211"+
		"\u0001\u0000\u0000\u0000\u0211\u0212\u0001\u0000\u0000\u0000\u0212\u0213"+
		"\u0003\u009cN\u0000\u0213\'\u0001\u0000\u0000\u0000\u0214\u0216\u0003"+
		"\u00e4r\u0000\u0215\u0214\u0001\u0000\u0000\u0000\u0216\u0219\u0001\u0000"+
		"\u0000\u0000\u0217\u0215\u0001\u0000\u0000\u0000\u0217\u0218\u0001\u0000"+
		"\u0000\u0000\u0218\u021a\u0001\u0000\u0000\u0000\u0219\u0217\u0001\u0000"+
		"\u0000\u0000\u021a\u021c\u0003\u0114\u008a\u0000\u021b\u021d\u0003|>\u0000"+
		"\u021c\u021b\u0001\u0000\u0000\u0000\u021c\u021d\u0001\u0000\u0000\u0000"+
		"\u021d\u021f\u0001\u0000\u0000\u0000\u021e\u0220\u0003`0\u0000\u021f\u021e"+
		"\u0001\u0000\u0000\u0000\u021f\u0220\u0001\u0000\u0000\u0000\u0220)\u0001"+
		"\u0000\u0000\u0000\u0221\u0223\u0003\u00e4r\u0000\u0222\u0221\u0001\u0000"+
		"\u0000\u0000\u0223\u0226\u0001\u0000\u0000\u0000\u0224\u0222\u0001\u0000"+
		"\u0000\u0000\u0224\u0225\u0001\u0000\u0000\u0000\u0225\u0227\u0001\u0000"+
		"\u0000\u0000\u0226\u0224\u0001\u0000\u0000\u0000\u0227\u0229\u0003\u0116"+
		"\u008b\u0000\u0228\u022a\u0003\u00c4b\u0000\u0229\u0228\u0001\u0000\u0000"+
		"\u0000\u0229\u022a\u0001\u0000\u0000\u0000\u022a\u022b\u0001\u0000\u0000"+
		"\u0000\u022b\u022d\u0003T*\u0000\u022c\u022e\u0003Z-\u0000\u022d\u022c"+
		"\u0001\u0000\u0000\u0000\u022d\u022e\u0001\u0000\u0000\u0000\u022e\u0230"+
		"\u0001\u0000\u0000\u0000\u022f\u0231\u0003l6\u0000\u0230\u022f\u0001\u0000"+
		"\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231+\u0001\u0000\u0000"+
		"\u0000\u0232\u0234\u0003\u00e4r\u0000\u0233\u0232\u0001\u0000\u0000\u0000"+
		"\u0234\u0237\u0001\u0000\u0000\u0000\u0235\u0233\u0001\u0000\u0000\u0000"+
		"\u0235\u0236\u0001\u0000\u0000\u0000\u0236\u0238\u0001\u0000\u0000\u0000"+
		"\u0237\u0235\u0001\u0000\u0000\u0000\u0238\u0239\u0003\u0114\u008a\u0000"+
		"\u0239\u023a\u0003\u0002\u0001\u0000\u023a-\u0001\u0000\u0000\u0000\u023b"+
		"\u023d\u0003\u00d0h\u0000\u023c\u023b\u0001\u0000\u0000\u0000\u023c\u023d"+
		"\u0001\u0000\u0000\u0000\u023d\u0241\u0001\u0000\u0000\u0000\u023e\u0240"+
		"\u0003\u00e4r\u0000\u023f\u023e\u0001\u0000\u0000\u0000\u0240\u0243\u0001"+
		"\u0000\u0000\u0000\u0241\u023f\u0001\u0000\u0000\u0000\u0241\u0242\u0001"+
		"\u0000\u0000\u0000\u0242\u0244\u0001\u0000\u0000\u0000\u0243\u0241\u0001"+
		"\u0000\u0000\u0000\u0244\u0245\u0003\u0112\u0089\u0000\u0245\u0246\u0005"+
		"n\u0000\u0000\u0246\u0248\u0003\u0126\u0093\u0000\u0247\u0249\u0003\u00c4"+
		"b\u0000\u0248\u0247\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000\u0000"+
		"\u0000\u0249\u024b\u0001\u0000\u0000\u0000\u024a\u024c\u0003<\u001e\u0000"+
		"\u024b\u024a\u0001\u0000\u0000\u0000\u024b\u024c\u0001\u0000\u0000\u0000"+
		"\u024c\u024d\u0001\u0000\u0000\u0000\u024d\u024f\u00030\u0018\u0000\u024e"+
		"\u0250\u0003\u0006\u0003\u0000\u024f\u024e\u0001\u0000\u0000\u0000\u024f"+
		"\u0250\u0001\u0000\u0000\u0000\u0250/\u0001\u0000\u0000\u0000\u0251\u0255"+
		"\u0005\u000b\u0000\u0000\u0252\u0254\u00032\u0019\u0000\u0253\u0252\u0001"+
		"\u0000\u0000\u0000\u0254\u0257\u0001\u0000\u0000\u0000\u0255\u0253\u0001"+
		"\u0000\u0000\u0000\u0255\u0256\u0001\u0000\u0000\u0000\u0256\u0258\u0001"+
		"\u0000\u0000\u0000\u0257\u0255\u0001\u0000\u0000\u0000\u0258\u0259\u0005"+
		"\f\u0000\u0000\u02591\u0001\u0000\u0000\u0000\u025a\u0260\u00034\u001a"+
		"\u0000\u025b\u0260\u0003*\u0015\u0000\u025c\u0260\u0003(\u0014\u0000\u025d"+
		"\u0260\u0003,\u0016\u0000\u025e\u0260\u0003\b\u0004\u0000\u025f\u025a"+
		"\u0001\u0000\u0000\u0000\u025f\u025b\u0001\u0000\u0000\u0000\u025f\u025c"+
		"\u0001\u0000\u0000\u0000\u025f\u025d\u0001\u0000\u0000\u0000\u025f\u025e"+
		"\u0001\u0000\u0000\u0000\u02603\u0001\u0000\u0000\u0000\u0261\u0262\u0003"+
		"\u0112\u0089\u0000\u0262\u0263\u0005q\u0000\u0000\u0263\u0266\u0003\u0126"+
		"\u0093\u0000\u0264\u0265\u0005\u0006\u0000\u0000\u0265\u0267\u0003\u009c"+
		"N\u0000\u0266\u0264\u0001\u0000\u0000\u0000\u0266\u0267\u0001\u0000\u0000"+
		"\u0000\u0267\u026a\u0001\u0000\u0000\u0000\u0268\u0269\u00053\u0000\u0000"+
		"\u0269\u026b\u0003\u009cN\u0000\u026a\u0268\u0001\u0000\u0000\u0000\u026a"+
		"\u026b\u0001\u0000\u0000\u0000\u026b5\u0001\u0000\u0000\u0000\u026c\u026e"+
		"\u0003\u00d0h\u0000\u026d\u026c\u0001\u0000\u0000\u0000\u026d\u026e\u0001"+
		"\u0000\u0000\u0000\u026e\u0272\u0001\u0000\u0000\u0000\u026f\u0271\u0003"+
		"\u00e4r\u0000\u0270\u026f\u0001\u0000\u0000\u0000\u0271\u0274\u0001\u0000"+
		"\u0000\u0000\u0272\u0270\u0001\u0000\u0000\u0000\u0272\u0273\u0001\u0000"+
		"\u0000\u0000\u0273\u0275\u0001\u0000\u0000\u0000\u0274\u0272\u0001\u0000"+
		"\u0000\u0000\u0275\u0276\u0003\u0112\u0089\u0000\u0276\u0277\u0005s\u0000"+
		"\u0000\u0277\u0279\u0003\u0122\u0091\u0000\u0278\u027a\u0003\u00c4b\u0000"+
		"\u0279\u0278\u0001\u0000\u0000\u0000\u0279\u027a\u0001\u0000\u0000\u0000"+
		"\u027a\u027c\u0001\u0000\u0000\u0000\u027b\u027d\u0003<\u001e\u0000\u027c"+
		"\u027b\u0001\u0000\u0000\u0000\u027c\u027d\u0001\u0000\u0000\u0000\u027d"+
		"\u027e\u0001\u0000\u0000\u0000\u027e\u027f\u00038\u001c\u0000\u027f7\u0001"+
		"\u0000\u0000\u0000\u0280\u0284\u0005\u000b\u0000\u0000\u0281\u0283\u0003"+
		":\u001d\u0000\u0282\u0281\u0001\u0000\u0000\u0000\u0283\u0286\u0001\u0000"+
		"\u0000\u0000\u0284\u0282\u0001\u0000\u0000\u0000\u0284\u0285\u0001\u0000"+
		"\u0000\u0000\u0285\u0287\u0001\u0000\u0000\u0000\u0286\u0284\u0001\u0000"+
		"\u0000\u0000\u0287\u0288\u0005\f\u0000\u0000\u02889\u0001\u0000\u0000"+
		"\u0000\u0289\u028d\u00034\u001a\u0000\u028a\u028d\u0003*\u0015\u0000\u028b"+
		"\u028d\u0003\b\u0004\u0000\u028c\u0289\u0001\u0000\u0000\u0000\u028c\u028a"+
		"\u0001\u0000\u0000\u0000\u028c\u028b\u0001\u0000\u0000\u0000\u028d;\u0001"+
		"\u0000\u0000\u0000\u028e\u028f\u0007\u0003\u0000\u0000\u028f\u0290\u0003"+
		"\u009cN\u0000\u0290=\u0001\u0000\u0000\u0000\u0291\u0293\u0003\u00d0h"+
		"\u0000\u0292\u0291\u0001\u0000\u0000\u0000\u0292\u0293\u0001\u0000\u0000"+
		"\u0000\u0293\u0297\u0001\u0000\u0000\u0000\u0294\u0296\u0003\u00e4r\u0000"+
		"\u0295\u0294\u0001\u0000\u0000\u0000\u0296\u0299\u0001\u0000\u0000\u0000"+
		"\u0297\u0295\u0001\u0000\u0000\u0000\u0297\u0298\u0001\u0000\u0000\u0000"+
		"\u0298\u029a\u0001\u0000\u0000\u0000\u0299\u0297\u0001\u0000\u0000\u0000"+
		"\u029a\u029b\u0003\u0112\u0089\u0000\u029b\u029c\u0005o\u0000\u0000\u029c"+
		"\u029e\u0003\u0126\u0093\u0000\u029d\u029f\u0003\u00c4b\u0000\u029e\u029d"+
		"\u0001\u0000\u0000\u0000\u029e\u029f\u0001\u0000\u0000\u0000\u029f\u02a1"+
		"\u0001\u0000\u0000\u0000\u02a0\u02a2\u0003@ \u0000\u02a1\u02a0\u0001\u0000"+
		"\u0000\u0000\u02a1\u02a2\u0001\u0000\u0000\u0000\u02a2\u02a4\u0001\u0000"+
		"\u0000\u0000\u02a3\u02a5\u0003|>\u0000\u02a4\u02a3\u0001\u0000\u0000\u0000"+
		"\u02a4\u02a5\u0001\u0000\u0000\u0000\u02a5\u02a6\u0001\u0000\u0000\u0000"+
		"\u02a6\u02a7\u0003B!\u0000\u02a7?\u0001\u0000\u0000\u0000\u02a8\u02aa"+
		"\u0005\u0007\u0000\u0000\u02a9\u02ab\u0003\u009cN\u0000\u02aa\u02a9\u0001"+
		"\u0000\u0000\u0000\u02aa\u02ab\u0001\u0000\u0000\u0000\u02ab\u02ac\u0001"+
		"\u0000\u0000\u0000\u02ac\u02ad\u0005\b\u0000\u0000\u02adA\u0001\u0000"+
		"\u0000\u0000\u02ae\u02b2\u0005\u000b\u0000\u0000\u02af\u02b1\u0003D\""+
		"\u0000\u02b0\u02af\u0001\u0000\u0000\u0000\u02b1\u02b4\u0001\u0000\u0000"+
		"\u0000\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000"+
		"\u0000\u02b3\u02b5\u0001\u0000\u0000\u0000\u02b4\u02b2\u0001\u0000\u0000"+
		"\u0000\u02b5\u02b6\u0005\f\u0000\u0000\u02b6C\u0001\u0000\u0000\u0000"+
		"\u02b7\u02bb\u0003*\u0015\u0000\u02b8\u02bb\u0003F#\u0000\u02b9\u02bb"+
		"\u0003\b\u0004\u0000\u02ba\u02b7\u0001\u0000\u0000\u0000\u02ba\u02b8\u0001"+
		"\u0000\u0000\u0000\u02ba\u02b9\u0001\u0000\u0000\u0000\u02bbE\u0001\u0000"+
		"\u0000\u0000\u02bc\u02be\u0003\u0126\u0093\u0000\u02bd\u02bf\u0003H$\u0000"+
		"\u02be\u02bd\u0001\u0000\u0000\u0000\u02be\u02bf\u0001\u0000\u0000\u0000"+
		"\u02bfG\u0001\u0000\u0000\u0000\u02c0\u02c6\u0005\u000b\u0000\u0000\u02c1"+
		"\u02c5\u0003(\u0014\u0000\u02c2\u02c5\u0003*\u0015\u0000\u02c3\u02c5\u0003"+
		"\b\u0004\u0000\u02c4\u02c1\u0001\u0000\u0000\u0000\u02c4\u02c2\u0001\u0000"+
		"\u0000\u0000\u02c4\u02c3\u0001\u0000\u0000\u0000\u02c5\u02c8\u0001\u0000"+
		"\u0000\u0000\u02c6\u02c4\u0001\u0000\u0000\u0000\u02c6\u02c7\u0001\u0000"+
		"\u0000\u0000\u02c7\u02c9\u0001\u0000\u0000\u0000\u02c8\u02c6\u0001\u0000"+
		"\u0000\u0000\u02c9\u02ca\u0005\f\u0000\u0000\u02caI\u0001\u0000\u0000"+
		"\u0000\u02cb\u02cd\u0003\u00e4r\u0000\u02cc\u02cb\u0001\u0000\u0000\u0000"+
		"\u02cd\u02d0\u0001\u0000\u0000\u0000\u02ce\u02cc\u0001\u0000\u0000\u0000"+
		"\u02ce\u02cf\u0001\u0000\u0000\u0000\u02cf\u02d1\u0001\u0000\u0000\u0000"+
		"\u02d0\u02ce\u0001\u0000\u0000\u0000\u02d1\u02d2\u0003\u0112\u0089\u0000"+
		"\u02d2\u02d3\u0005p\u0000\u0000\u02d3\u02d5\u0003\u0126\u0093\u0000\u02d4"+
		"\u02d6\u0003@ \u0000\u02d5\u02d4\u0001\u0000\u0000\u0000\u02d5\u02d6\u0001"+
		"\u0000\u0000\u0000\u02d6\u02d8\u0001\u0000\u0000\u0000\u02d7\u02d9\u0003"+
		"|>\u0000\u02d8\u02d7\u0001\u0000\u0000\u0000\u02d8\u02d9\u0001\u0000\u0000"+
		"\u0000\u02d9\u02da\u0001\u0000\u0000\u0000\u02da\u02db\u0003L&\u0000\u02db"+
		"K\u0001\u0000\u0000\u0000\u02dc\u02e0\u0005\u000b\u0000\u0000\u02dd\u02df"+
		"\u0003N\'\u0000\u02de\u02dd\u0001\u0000\u0000\u0000\u02df\u02e2\u0001"+
		"\u0000\u0000\u0000\u02e0\u02de\u0001\u0000\u0000\u0000\u02e0\u02e1\u0001"+
		"\u0000\u0000\u0000\u02e1\u02e3\u0001\u0000\u0000\u0000\u02e2\u02e0\u0001"+
		"\u0000\u0000\u0000\u02e3\u02e4\u0005\f\u0000\u0000\u02e4M\u0001\u0000"+
		"\u0000\u0000\u02e5\u02e9\u0003*\u0015\u0000\u02e6\u02e9\u0003P(\u0000"+
		"\u02e7\u02e9\u0003\b\u0004\u0000\u02e8\u02e5\u0001\u0000\u0000\u0000\u02e8"+
		"\u02e6\u0001\u0000\u0000\u0000\u02e8\u02e7\u0001\u0000\u0000\u0000\u02e9"+
		"O\u0001\u0000\u0000\u0000\u02ea\u02ec\u0003\u00e4r\u0000\u02eb\u02ea\u0001"+
		"\u0000\u0000\u0000\u02ec\u02ef\u0001\u0000\u0000\u0000\u02ed\u02eb\u0001"+
		"\u0000\u0000\u0000\u02ed\u02ee\u0001\u0000\u0000\u0000\u02ee\u02f0\u0001"+
		"\u0000\u0000\u0000\u02ef\u02ed\u0001\u0000\u0000\u0000\u02f0\u02f3\u0003"+
		"\u0126\u0093\u0000\u02f1\u02f2\u00053\u0000\u0000\u02f2\u02f4\u0003\u0096"+
		"K\u0000\u02f3\u02f1\u0001\u0000\u0000\u0000\u02f3\u02f4\u0001\u0000\u0000"+
		"\u0000\u02f4Q\u0001\u0000\u0000\u0000\u02f5\u02f7\u0003\u00d0h\u0000\u02f6"+
		"\u02f5\u0001\u0000\u0000\u0000\u02f6\u02f7\u0001\u0000\u0000\u0000\u02f7"+
		"\u02fb\u0001\u0000\u0000\u0000\u02f8\u02fa\u0003\u00e4r\u0000\u02f9\u02f8"+
		"\u0001\u0000\u0000\u0000\u02fa\u02fd\u0001\u0000\u0000\u0000\u02fb\u02f9"+
		"\u0001\u0000\u0000\u0000\u02fb\u02fc\u0001\u0000\u0000\u0000\u02fc\u02fe"+
		"\u0001\u0000\u0000\u0000\u02fd\u02fb\u0001\u0000\u0000\u0000\u02fe\u02ff"+
		"\u0003\u0112\u0089\u0000\u02ff\u0300\u0005{\u0000\u0000\u0300\u0302\u0003"+
		"\u0122\u0091\u0000\u0301\u0303\u0003\u00c4b\u0000\u0302\u0301\u0001\u0000"+
		"\u0000\u0000\u0302\u0303\u0001\u0000\u0000\u0000\u0303\u0304\u0001\u0000"+
		"\u0000\u0000\u0304\u0306\u0003T*\u0000\u0305\u0307\u0003Z-\u0000\u0306"+
		"\u0305\u0001\u0000\u0000\u0000\u0306\u0307\u0001\u0000\u0000\u0000\u0307"+
		"\u0308\u0001\u0000\u0000\u0000\u0308\u0309\u0003l6\u0000\u0309S\u0001"+
		"\u0000\u0000\u0000\u030a\u030b\u0005\u0007\u0000\u0000\u030b\u0318\u0005"+
		"\b\u0000\u0000\u030c\u030d\u0005\u0007\u0000\u0000\u030d\u0312\u0003V"+
		"+\u0000\u030e\u030f\u0005\u0002\u0000\u0000\u030f\u0311\u0003V+\u0000"+
		"\u0310\u030e\u0001\u0000\u0000\u0000\u0311\u0314\u0001\u0000\u0000\u0000"+
		"\u0312\u0310\u0001\u0000\u0000\u0000\u0312\u0313\u0001\u0000\u0000\u0000"+
		"\u0313\u0315\u0001\u0000\u0000\u0000\u0314\u0312\u0001\u0000\u0000\u0000"+
		"\u0315\u0316\u0005\b\u0000\u0000\u0316\u0318\u0001\u0000\u0000\u0000\u0317"+
		"\u030a\u0001\u0000\u0000\u0000\u0317\u030c\u0001\u0000\u0000\u0000\u0318"+
		"U\u0001\u0000\u0000\u0000\u0319\u031b\u0003\u00e4r\u0000\u031a\u0319\u0001"+
		"\u0000\u0000\u0000\u031b\u031e\u0001\u0000\u0000\u0000\u031c\u031a\u0001"+
		"\u0000\u0000\u0000\u031c\u031d\u0001\u0000\u0000\u0000\u031d\u0322\u0001"+
		"\u0000\u0000\u0000\u031e\u031c\u0001\u0000\u0000\u0000\u031f\u0321\u0003"+
		"\u0126\u0093\u0000\u0320\u031f\u0001\u0000\u0000\u0000\u0321\u0324\u0001"+
		"\u0000\u0000\u0000\u0322\u0320\u0001\u0000\u0000\u0000\u0322\u0323\u0001"+
		"\u0000\u0000\u0000\u0323\u0325\u0001\u0000\u0000\u0000\u0324\u0322\u0001"+
		"\u0000\u0000\u0000\u0325\u0327\u0003X,\u0000\u0326\u0328\u0003\u0126\u0093"+
		"\u0000\u0327\u0326\u0001\u0000\u0000\u0000\u0327\u0328\u0001\u0000\u0000"+
		"\u0000\u0328\u032a\u0001\u0000\u0000\u0000\u0329\u032b\u0003|>\u0000\u032a"+
		"\u0329\u0001\u0000\u0000\u0000\u032a\u032b\u0001\u0000\u0000\u0000\u032b"+
		"\u032d\u0001\u0000\u0000\u0000\u032c\u032e\u0003`0\u0000\u032d\u032c\u0001"+
		"\u0000\u0000\u0000\u032d\u032e\u0001\u0000\u0000\u0000\u032e\u0345\u0001"+
		"\u0000\u0000\u0000\u032f\u0331\u0003\u00e4r\u0000\u0330\u032f\u0001\u0000"+
		"\u0000\u0000\u0331\u0334\u0001\u0000\u0000\u0000\u0332\u0330\u0001\u0000"+
		"\u0000\u0000\u0332\u0333\u0001\u0000\u0000\u0000\u0333\u0338\u0001\u0000"+
		"\u0000\u0000\u0334\u0332\u0001\u0000\u0000\u0000\u0335\u0337\u0003\u0126"+
		"\u0093\u0000\u0336\u0335\u0001\u0000\u0000\u0000\u0337\u033a\u0001\u0000"+
		"\u0000\u0000\u0338\u0336\u0001\u0000\u0000\u0000\u0338\u0339\u0001\u0000"+
		"\u0000\u0000\u0339\u033b\u0001\u0000\u0000\u0000\u033a\u0338\u0001\u0000"+
		"\u0000\u0000\u033b\u033d\u0003\u0126\u0093\u0000\u033c\u033e\u0003|>\u0000"+
		"\u033d\u033c\u0001\u0000\u0000\u0000\u033d\u033e\u0001\u0000\u0000\u0000"+
		"\u033e\u0340\u0001\u0000\u0000\u0000\u033f\u0341\u0003`0\u0000\u0340\u033f"+
		"\u0001\u0000\u0000\u0000\u0340\u0341\u0001\u0000\u0000\u0000\u0341\u0345"+
		"\u0001\u0000\u0000\u0000\u0342\u0345\u0005)\u0000\u0000\u0343\u0345\u0005"+
		".\u0000\u0000\u0344\u031c\u0001\u0000\u0000\u0000\u0344\u0332\u0001\u0000"+
		"\u0000\u0000\u0344\u0342\u0001\u0000\u0000\u0000\u0344\u0343\u0001\u0000"+
		"\u0000\u0000\u0345W\u0001\u0000\u0000\u0000\u0346\u034a\u0005]\u0000\u0000"+
		"\u0347\u034a\u0005^\u0000\u0000\u0348\u034a\u0005`\u0000\u0000\u0349\u0346"+
		"\u0001\u0000\u0000\u0000\u0349\u0347\u0001\u0000\u0000\u0000\u0349\u0348"+
		"\u0001\u0000\u0000\u0000\u034aY\u0001\u0000\u0000\u0000\u034b\u034d\u0003"+
		"\\.\u0000\u034c\u034b\u0001\u0000\u0000\u0000\u034c\u034d\u0001\u0000"+
		"\u0000\u0000\u034d\u034f\u0001\u0000\u0000\u0000\u034e\u0350\u0003^/\u0000"+
		"\u034f\u034e\u0001\u0000\u0000\u0000\u034f\u0350\u0001\u0000\u0000\u0000"+
		"\u0350[\u0001\u0000\u0000\u0000\u0351\u0352\u0007\u0004\u0000\u0000\u0352"+
		"\u0353\u0003\u009cN\u0000\u0353]\u0001\u0000\u0000\u0000\u0354\u0355\u0005"+
		"\u001e\u0000\u0000\u0355\u0367\u0003\u009cN\u0000\u0356\u0357\u0005\u001e"+
		"\u0000\u0000\u0357\u0363\u0005\t\u0000\u0000\u0358\u035d\u0003\u009cN"+
		"\u0000\u0359\u035a\u0005\u0002\u0000\u0000\u035a\u035c\u0003\u009cN\u0000"+
		"\u035b\u0359\u0001\u0000\u0000\u0000\u035c\u035f\u0001\u0000\u0000\u0000"+
		"\u035d\u035b\u0001\u0000\u0000\u0000\u035d\u035e\u0001\u0000\u0000\u0000"+
		"\u035e\u0361\u0001\u0000\u0000\u0000\u035f\u035d\u0001\u0000\u0000\u0000"+
		"\u0360\u0362\u0005\u0002\u0000\u0000\u0361\u0360\u0001\u0000\u0000\u0000"+
		"\u0361\u0362\u0001\u0000\u0000\u0000\u0362\u0364\u0001\u0000\u0000\u0000"+
		"\u0363\u0358\u0001\u0000\u0000\u0000\u0363\u0364\u0001\u0000\u0000\u0000"+
		"\u0364\u0365\u0001\u0000\u0000\u0000\u0365\u0367\u0005\n\u0000\u0000\u0366"+
		"\u0354\u0001\u0000\u0000\u0000\u0366\u0356\u0001\u0000\u0000\u0000\u0367"+
		"_\u0001\u0000\u0000\u0000\u0368\u0369\u00053\u0000\u0000\u0369\u036a\u0003"+
		"\u0096K\u0000\u036aa\u0001\u0000\u0000\u0000\u036b\u036d\u0005S\u0000"+
		"\u0000\u036c\u036b\u0001\u0000\u0000\u0000\u036c\u036d\u0001\u0000\u0000"+
		"\u0000\u036d\u036e\u0001\u0000\u0000\u0000\u036e\u0383\u0003f3\u0000\u036f"+
		"\u0371\u0005S\u0000\u0000\u0370\u036f\u0001\u0000\u0000\u0000\u0370\u0371"+
		"\u0001\u0000\u0000\u0000\u0371\u0372\u0001\u0000\u0000\u0000\u0372\u0373"+
		"\u0005\u0001\u0000\u0000\u0373\u0375\u0005\u0082\u0000\u0000\u0374\u0376"+
		"\u0003f3\u0000\u0375\u0374\u0001\u0000\u0000\u0000\u0375\u0376\u0001\u0000"+
		"\u0000\u0000\u0376\u0383\u0001\u0000\u0000\u0000\u0377\u0379\u0005S\u0000"+
		"\u0000\u0378\u0377\u0001\u0000\u0000\u0000\u0378\u0379\u0001\u0000\u0000"+
		"\u0000\u0379\u037a\u0001\u0000\u0000\u0000\u037a\u037c\u0005\u0001\u0000"+
		"\u0000\u037b\u037d\u0005L\u0000\u0000\u037c\u037b\u0001\u0000\u0000\u0000"+
		"\u037c\u037d\u0001\u0000\u0000\u0000\u037d\u037e\u0001\u0000\u0000\u0000"+
		"\u037e\u0380\u0003\u0126\u0093\u0000\u037f\u0381\u0003f3\u0000\u0380\u037f"+
		"\u0001\u0000\u0000\u0000\u0380\u0381\u0001\u0000\u0000\u0000\u0381\u0383"+
		"\u0001\u0000\u0000\u0000\u0382\u036c\u0001\u0000\u0000\u0000\u0382\u0370"+
		"\u0001\u0000\u0000\u0000\u0382\u0378\u0001\u0000\u0000\u0000\u0383c\u0001"+
		"\u0000\u0000\u0000\u0384\u0386\u0005S\u0000\u0000\u0385\u0384\u0001\u0000"+
		"\u0000\u0000\u0385\u0386\u0001\u0000\u0000\u0000\u0386\u038c\u0001\u0000"+
		"\u0000\u0000\u0387\u038d\u0003l6\u0000\u0388\u038a\u0003f3\u0000\u0389"+
		"\u038b\u0003l6\u0000\u038a\u0389\u0001\u0000\u0000\u0000\u038a\u038b\u0001"+
		"\u0000\u0000\u0000\u038b\u038d\u0001\u0000\u0000\u0000\u038c\u0387\u0001"+
		"\u0000\u0000\u0000\u038c\u0388\u0001\u0000\u0000\u0000\u038d\u03ad\u0001"+
		"\u0000\u0000\u0000\u038e\u0390\u0005S\u0000\u0000\u038f\u038e\u0001\u0000"+
		"\u0000\u0000\u038f\u0390\u0001\u0000\u0000\u0000\u0390\u0391\u0001\u0000"+
		"\u0000\u0000\u0391\u0392\u0005\u0001\u0000\u0000\u0392\u03ad\u0003l6\u0000"+
		"\u0393\u0395\u0005S\u0000\u0000\u0394\u0393\u0001\u0000\u0000\u0000\u0394"+
		"\u0395\u0001\u0000\u0000\u0000\u0395\u0396\u0001\u0000\u0000\u0000\u0396"+
		"\u0397\u0005\u0001\u0000\u0000\u0397\u0399\u0005\u0082\u0000\u0000\u0398"+
		"\u039a\u0003f3\u0000\u0399\u0398\u0001\u0000\u0000\u0000\u0399\u039a\u0001"+
		"\u0000\u0000\u0000\u039a\u039c\u0001\u0000\u0000\u0000\u039b\u039d\u0003"+
		"l6\u0000\u039c\u039b\u0001\u0000\u0000\u0000\u039c\u039d\u0001\u0000\u0000"+
		"\u0000\u039d\u03ad\u0001\u0000\u0000\u0000\u039e\u03a0\u0005S\u0000\u0000"+
		"\u039f\u039e\u0001\u0000\u0000\u0000\u039f\u03a0\u0001\u0000\u0000\u0000"+
		"\u03a0\u03a1\u0001\u0000\u0000\u0000\u03a1\u03a3\u0005\u0001\u0000\u0000"+
		"\u03a2\u03a4\u0005L\u0000\u0000\u03a3\u03a2\u0001\u0000\u0000\u0000\u03a3"+
		"\u03a4\u0001\u0000\u0000\u0000\u03a4\u03a5\u0001\u0000\u0000\u0000\u03a5"+
		"\u03a7\u0003\u0126\u0093\u0000\u03a6\u03a8\u0003f3\u0000\u03a7\u03a6\u0001"+
		"\u0000\u0000\u0000\u03a7\u03a8\u0001\u0000\u0000\u0000\u03a8\u03aa\u0001"+
		"\u0000\u0000\u0000\u03a9\u03ab\u0003l6\u0000\u03aa\u03a9\u0001\u0000\u0000"+
		"\u0000\u03aa\u03ab\u0001\u0000\u0000\u0000\u03ab\u03ad\u0001\u0000\u0000"+
		"\u0000\u03ac\u0385\u0001\u0000\u0000\u0000\u03ac\u038f\u0001\u0000\u0000"+
		"\u0000\u03ac\u0394\u0001\u0000\u0000\u0000\u03ac\u039f\u0001\u0000\u0000"+
		"\u0000\u03ade\u0001\u0000\u0000\u0000\u03ae\u03af\u0005\u0007\u0000\u0000"+
		"\u03af\u03bf\u0005\b\u0000\u0000\u03b0\u03b1\u0005\u0007\u0000\u0000\u03b1"+
		"\u03b6\u0003h4\u0000\u03b2\u03b3\u0005\u0002\u0000\u0000\u03b3\u03b5\u0003"+
		"h4\u0000\u03b4\u03b2\u0001\u0000\u0000\u0000\u03b5\u03b8\u0001\u0000\u0000"+
		"\u0000\u03b6\u03b4\u0001\u0000\u0000\u0000\u03b6\u03b7\u0001\u0000\u0000"+
		"\u0000\u03b7\u03ba\u0001\u0000\u0000\u0000\u03b8\u03b6\u0001\u0000\u0000"+
		"\u0000\u03b9\u03bb\u0005\u0002\u0000\u0000\u03ba\u03b9\u0001\u0000\u0000"+
		"\u0000\u03ba\u03bb\u0001\u0000\u0000\u0000\u03bb\u03bc\u0001\u0000\u0000"+
		"\u0000\u03bc\u03bd\u0005\b\u0000\u0000\u03bd\u03bf\u0001\u0000\u0000\u0000"+
		"\u03be\u03ae\u0001\u0000\u0000\u0000\u03be\u03b0\u0001\u0000\u0000\u0000"+
		"\u03bfg\u0001\u0000\u0000\u0000\u03c0\u03c2\u0003\u00e4r\u0000\u03c1\u03c0"+
		"\u0001\u0000\u0000\u0000\u03c2\u03c5\u0001\u0000\u0000\u0000\u03c3\u03c1"+
		"\u0001\u0000\u0000\u0000\u03c3\u03c4\u0001\u0000\u0000\u0000\u03c4\u03c9"+
		"\u0001\u0000\u0000\u0000\u03c5\u03c3\u0001\u0000\u0000\u0000\u03c6\u03c8"+
		"\u0003\u0126\u0093\u0000\u03c7\u03c6\u0001\u0000\u0000\u0000\u03c8\u03cb"+
		"\u0001\u0000\u0000\u0000\u03c9\u03c7\u0001\u0000\u0000\u0000\u03c9\u03ca"+
		"\u0001\u0000\u0000\u0000\u03ca\u03cc\u0001\u0000\u0000\u0000\u03cb\u03c9"+
		"\u0001\u0000\u0000\u0000\u03cc\u03cd\u0003\u0126\u0093\u0000\u03cd\u03ce"+
		"\u0005\u0006\u0000\u0000\u03ce\u03cf\u0003\u0096K\u0000\u03cf\u03d8\u0001"+
		"\u0000\u0000\u0000\u03d0\u03d2\u0003\u00e4r\u0000\u03d1\u03d0\u0001\u0000"+
		"\u0000\u0000\u03d2\u03d5\u0001\u0000\u0000\u0000\u03d3\u03d1\u0001\u0000"+
		"\u0000\u0000\u03d3\u03d4\u0001\u0000\u0000\u0000\u03d4\u03d6\u0001\u0000"+
		"\u0000\u0000\u03d5\u03d3\u0001\u0000\u0000\u0000\u03d6\u03d8\u0003\u0096"+
		"K\u0000\u03d7\u03c3\u0001\u0000\u0000\u0000\u03d7\u03d3\u0001\u0000\u0000"+
		"\u0000\u03d8i\u0001\u0000\u0000\u0000\u03d9\u03db\u0003\u00e4r\u0000\u03da"+
		"\u03d9\u0001\u0000\u0000\u0000\u03db\u03de\u0001\u0000\u0000\u0000\u03dc"+
		"\u03da\u0001\u0000\u0000\u0000\u03dc\u03dd\u0001\u0000\u0000\u0000\u03dd"+
		"\u03df\u0001\u0000\u0000\u0000\u03de\u03dc\u0001\u0000\u0000\u0000\u03df"+
		"\u03e0\u0005z\u0000\u0000\u03e0\u03e2\u0003T*\u0000\u03e1\u03e3\u0003"+
		"Z-\u0000\u03e2\u03e1\u0001\u0000\u0000\u0000\u03e2\u03e3\u0001\u0000\u0000"+
		"\u0000\u03e3\u03e4\u0001\u0000\u0000\u0000\u03e4\u03e5\u0003l6\u0000\u03e5"+
		"k\u0001\u0000\u0000\u0000\u03e6\u03ea\u0005\u000b\u0000\u0000\u03e7\u03e9"+
		"\u0003n7\u0000\u03e8\u03e7\u0001\u0000\u0000\u0000\u03e9\u03ec\u0001\u0000"+
		"\u0000\u0000\u03ea\u03e8\u0001\u0000\u0000\u0000\u03ea\u03eb\u0001\u0000"+
		"\u0000\u0000\u03eb\u03ed\u0001\u0000\u0000\u0000\u03ec\u03ea\u0001\u0000"+
		"\u0000\u0000\u03ed\u03ee\u0005\f\u0000\u0000\u03eem\u0001\u0000\u0000"+
		"\u0000\u03ef\u03f6\u0003z=\u0000\u03f0\u03f6\u0003p8\u0000\u03f1\u03f6"+
		"\u0003\u0086C\u0000\u03f2\u03f6\u0003\u0082A\u0000\u03f3\u03f6\u0003\u0094"+
		"J\u0000\u03f4\u03f6\u0003\u0006\u0003\u0000\u03f5\u03ef\u0001\u0000\u0000"+
		"\u0000\u03f5\u03f0\u0001\u0000\u0000\u0000\u03f5\u03f1\u0001\u0000\u0000"+
		"\u0000\u03f5\u03f2\u0001\u0000\u0000\u0000\u03f5\u03f3\u0001\u0000\u0000"+
		"\u0000\u03f5\u03f4\u0001\u0000\u0000\u0000\u03f6o\u0001\u0000\u0000\u0000"+
		"\u03f7\u03f9\u0003\u00e4r\u0000\u03f8\u03f7\u0001\u0000\u0000\u0000\u03f9"+
		"\u03fc\u0001\u0000\u0000\u0000\u03fa\u03f8\u0001\u0000\u0000\u0000\u03fa"+
		"\u03fb\u0001\u0000\u0000\u0000\u03fb\u03fd\u0001\u0000\u0000\u0000\u03fc"+
		"\u03fa\u0001\u0000\u0000\u0000\u03fd\u03fe\u0005w\u0000\u0000\u03fe\u0400"+
		"\u0003r9\u0000\u03ff\u0401\u0003|>\u0000\u0400\u03ff\u0001\u0000\u0000"+
		"\u0000\u0400\u0401\u0001\u0000\u0000\u0000\u0401\u0404\u0001\u0000\u0000"+
		"\u0000\u0402\u0403\u00053\u0000\u0000\u0403\u0405\u0003\u0094J\u0000\u0404"+
		"\u0402\u0001\u0000\u0000\u0000\u0404\u0405\u0001\u0000\u0000\u0000\u0405"+
		"q\u0001\u0000\u0000\u0000\u0406\u0409\u0003v;\u0000\u0407\u0409\u0003"+
		"t:\u0000\u0408\u0406\u0001\u0000\u0000\u0000\u0408\u0407\u0001\u0000\u0000"+
		"\u0000\u0409s\u0001\u0000\u0000\u0000\u040a\u040f\u0003\u0114\u008a\u0000"+
		"\u040b\u040c\u0005\u0002\u0000\u0000\u040c\u040e\u0003\u0114\u008a\u0000"+
		"\u040d\u040b\u0001\u0000\u0000\u0000\u040e\u0411\u0001\u0000\u0000\u0000"+
		"\u040f\u040d\u0001\u0000\u0000\u0000\u040f\u0410\u0001\u0000\u0000\u0000"+
		"\u0410\u0413\u0001\u0000\u0000\u0000\u0411\u040f\u0001\u0000\u0000\u0000"+
		"\u0412\u0414\u0005\u0002\u0000\u0000\u0413\u0412\u0001\u0000\u0000\u0000"+
		"\u0413\u0414\u0001\u0000\u0000\u0000\u0414u\u0001\u0000\u0000\u0000\u0415"+
		"\u0423\u0005\u0007\u0000\u0000\u0416\u0417\u0003x<\u0000\u0417\u0418\u0005"+
		"\u0002\u0000\u0000\u0418\u0424\u0001\u0000\u0000\u0000\u0419\u041c\u0003"+
		"x<\u0000\u041a\u041b\u0005\u0002\u0000\u0000\u041b\u041d\u0003x<\u0000"+
		"\u041c\u041a\u0001\u0000\u0000\u0000\u041d\u041e\u0001\u0000\u0000\u0000"+
		"\u041e\u041c\u0001\u0000\u0000\u0000\u041e\u041f\u0001\u0000\u0000\u0000"+
		"\u041f\u0421\u0001\u0000\u0000\u0000\u0420\u0422\u0005\u0002\u0000\u0000"+
		"\u0421\u0420\u0001\u0000\u0000\u0000\u0421\u0422\u0001\u0000\u0000\u0000"+
		"\u0422\u0424\u0001\u0000\u0000\u0000\u0423\u0416\u0001\u0000\u0000\u0000"+
		"\u0423\u0419\u0001\u0000\u0000\u0000\u0423\u0424\u0001\u0000\u0000\u0000"+
		"\u0424\u0425\u0001\u0000\u0000\u0000\u0425\u045c\u0005\b\u0000\u0000\u0426"+
		"\u0427\u0003\u0122\u0091\u0000\u0427\u0433\u0005\u0007\u0000\u0000\u0428"+
		"\u042d\u0003x<\u0000\u0429\u042a\u0005\u0002\u0000\u0000\u042a\u042c\u0003"+
		"x<\u0000\u042b\u0429\u0001\u0000\u0000\u0000\u042c\u042f\u0001\u0000\u0000"+
		"\u0000\u042d\u042b\u0001\u0000\u0000\u0000\u042d\u042e\u0001\u0000\u0000"+
		"\u0000\u042e\u0431\u0001\u0000\u0000\u0000\u042f\u042d\u0001\u0000\u0000"+
		"\u0000\u0430\u0432\u0005\u0002\u0000\u0000\u0431\u0430\u0001\u0000\u0000"+
		"\u0000\u0431\u0432\u0001\u0000\u0000\u0000\u0432\u0434\u0001\u0000\u0000"+
		"\u0000\u0433\u0428\u0001\u0000\u0000\u0000\u0433\u0434\u0001\u0000\u0000"+
		"\u0000\u0434\u0435\u0001\u0000\u0000\u0000\u0435\u0436\u0005\b\u0000\u0000"+
		"\u0436\u045c\u0001\u0000\u0000\u0000\u0437\u0439\u0003\u0122\u0091\u0000"+
		"\u0438\u0437\u0001\u0000\u0000\u0000\u0438\u0439\u0001\u0000\u0000\u0000"+
		"\u0439\u043a\u0001\u0000\u0000\u0000\u043a\u0446\u0005\t\u0000\u0000\u043b"+
		"\u0440\u0003x<\u0000\u043c\u043d\u0005\u0002\u0000\u0000\u043d\u043f\u0003"+
		"x<\u0000\u043e\u043c\u0001\u0000\u0000\u0000\u043f\u0442\u0001\u0000\u0000"+
		"\u0000\u0440\u043e\u0001\u0000\u0000\u0000\u0440\u0441\u0001\u0000\u0000"+
		"\u0000\u0441\u0444\u0001\u0000\u0000\u0000\u0442\u0440\u0001\u0000\u0000"+
		"\u0000\u0443\u0445\u0005\u0002\u0000\u0000\u0444\u0443\u0001\u0000\u0000"+
		"\u0000\u0444\u0445\u0001\u0000\u0000\u0000\u0445\u0447\u0001\u0000\u0000"+
		"\u0000\u0446\u043b\u0001\u0000\u0000\u0000\u0446\u0447\u0001\u0000\u0000"+
		"\u0000\u0447\u0448\u0001\u0000\u0000\u0000\u0448\u045c\u0005\n\u0000\u0000"+
		"\u0449\u044b\u0003\u0122\u0091\u0000\u044a\u0449\u0001\u0000\u0000\u0000"+
		"\u044a\u044b\u0001\u0000\u0000\u0000\u044b\u044c\u0001\u0000\u0000\u0000"+
		"\u044c\u0458\u0005\u000b\u0000\u0000\u044d\u0452\u0003x<\u0000\u044e\u044f"+
		"\u0005\u0002\u0000\u0000\u044f\u0451\u0003x<\u0000\u0450\u044e\u0001\u0000"+
		"\u0000\u0000\u0451\u0454\u0001\u0000\u0000\u0000\u0452\u0450\u0001\u0000"+
		"\u0000\u0000\u0452\u0453\u0001\u0000\u0000\u0000\u0453\u0456\u0001\u0000"+
		"\u0000\u0000\u0454\u0452\u0001\u0000\u0000\u0000\u0455\u0457\u0005\u0002"+
		"\u0000\u0000\u0456\u0455\u0001\u0000\u0000\u0000\u0456\u0457\u0001\u0000"+
		"\u0000\u0000\u0457\u0459\u0001\u0000\u0000\u0000\u0458\u044d\u0001\u0000"+
		"\u0000\u0000\u0458\u0459\u0001\u0000\u0000\u0000\u0459\u045a\u0001\u0000"+
		"\u0000\u0000\u045a\u045c\u0005\f\u0000\u0000\u045b\u0415\u0001\u0000\u0000"+
		"\u0000\u045b\u0426\u0001\u0000\u0000\u0000\u045b\u0438\u0001\u0000\u0000"+
		"\u0000\u045b\u044a\u0001\u0000\u0000\u0000\u045cw\u0001\u0000\u0000\u0000"+
		"\u045d\u045e\u0003\u0114\u008a\u0000\u045e\u045f\u0005\u0006\u0000\u0000"+
		"\u045f\u0461\u0001\u0000\u0000\u0000\u0460\u045d\u0001\u0000\u0000\u0000"+
		"\u0460\u0461\u0001\u0000\u0000\u0000\u0461\u0465\u0001\u0000\u0000\u0000"+
		"\u0462\u0463\u0003\u0126\u0093\u0000\u0463\u0464\u00054\u0000\u0000\u0464"+
		"\u0466\u0001\u0000\u0000\u0000\u0465\u0462\u0001\u0000\u0000\u0000\u0465"+
		"\u0466\u0001\u0000\u0000\u0000\u0466\u0467\u0001\u0000\u0000\u0000\u0467"+
		"\u0483\u0003v;\u0000\u0468\u0469\u0003\u0114\u008a\u0000\u0469\u046a\u0005"+
		"\u0006\u0000\u0000\u046a\u046c\u0001\u0000\u0000\u0000\u046b\u0468\u0001"+
		"\u0000\u0000\u0000\u046b\u046c\u0001\u0000\u0000\u0000\u046c\u0470\u0001"+
		"\u0000\u0000\u0000\u046d\u046e\u0003\u0126\u0093\u0000\u046e\u046f\u0005"+
		"4\u0000\u0000\u046f\u0471\u0001\u0000\u0000\u0000\u0470\u046d\u0001\u0000"+
		"\u0000\u0000\u0470\u0471\u0001\u0000\u0000\u0000\u0471\u0472\u0001\u0000"+
		"\u0000\u0000\u0472\u0483\u0003\u0126\u0093\u0000\u0473\u0475\u0003\u0114"+
		"\u008a\u0000\u0474\u0473\u0001\u0000\u0000\u0000\u0474\u0475\u0001\u0000"+
		"\u0000\u0000\u0475\u0476\u0001\u0000\u0000\u0000\u0476\u0478\u0005^\u0000"+
		"\u0000\u0477\u0479\u0003\u0126\u0093\u0000\u0478\u0477\u0001\u0000\u0000"+
		"\u0000\u0478\u0479\u0001\u0000\u0000\u0000\u0479\u0483\u0001\u0000\u0000"+
		"\u0000\u047a\u047c\u0003\u0114\u008a\u0000\u047b\u047a\u0001\u0000\u0000"+
		"\u0000\u047b\u047c\u0001\u0000\u0000\u0000\u047c\u047d\u0001\u0000\u0000"+
		"\u0000\u047d\u047f\u0005]\u0000\u0000\u047e\u0480\u0003\u0126\u0093\u0000"+
		"\u047f\u047e\u0001\u0000\u0000\u0000\u047f\u0480\u0001\u0000\u0000\u0000"+
		"\u0480\u0483\u0001\u0000\u0000\u0000\u0481\u0483\u0003\u0114\u008a\u0000"+
		"\u0482\u0460\u0001\u0000\u0000\u0000\u0482\u046b\u0001\u0000\u0000\u0000"+
		"\u0482\u0474\u0001\u0000\u0000\u0000\u0482\u047b\u0001\u0000\u0000\u0000"+
		"\u0482\u0481\u0001\u0000\u0000\u0000\u0483y\u0001\u0000\u0000\u0000\u0484"+
		"\u0486\u0003\u00e4r\u0000\u0485\u0484\u0001\u0000\u0000\u0000\u0486\u0489"+
		"\u0001\u0000\u0000\u0000\u0487\u0485\u0001\u0000\u0000\u0000\u0487\u0488"+
		"\u0001\u0000\u0000\u0000\u0488\u048a\u0001\u0000\u0000\u0000\u0489\u0487"+
		"\u0001\u0000\u0000\u0000\u048a\u048b\u0003\u0112\u0089\u0000\u048b\u048c"+
		"\u0005q\u0000\u0000\u048c\u048e\u0003\u0126\u0093\u0000\u048d\u048f\u0003"+
		"\u00c4b\u0000\u048e\u048d\u0001\u0000\u0000\u0000\u048e\u048f\u0001\u0000"+
		"\u0000\u0000\u048f\u0490\u0001\u0000\u0000\u0000\u0490\u0491\u00053\u0000"+
		"\u0000\u0491\u0492\u0003\u009cN\u0000\u0492\u04a2\u0001\u0000\u0000\u0000"+
		"\u0493\u0495\u0003\u00e4r\u0000\u0494\u0493\u0001\u0000\u0000\u0000\u0495"+
		"\u0498\u0001\u0000\u0000\u0000\u0496\u0494\u0001\u0000\u0000\u0000\u0496"+
		"\u0497\u0001\u0000\u0000\u0000\u0497\u0499\u0001\u0000\u0000\u0000\u0498"+
		"\u0496\u0001\u0000\u0000\u0000\u0499\u049a\u0003\u0112\u0089\u0000\u049a"+
		"\u049b\u0005q\u0000\u0000\u049b\u049d\u0003\u0126\u0093\u0000\u049c\u049e"+
		"\u0003\u00c4b\u0000\u049d\u049c\u0001\u0000\u0000\u0000\u049d\u049e\u0001"+
		"\u0000\u0000\u0000\u049e\u049f\u0001\u0000\u0000\u0000\u049f\u04a0\u0003"+
		"\u00d2i\u0000\u04a0\u04a2\u0001\u0000\u0000\u0000\u04a1\u0487\u0001\u0000"+
		"\u0000\u0000\u04a1\u0496\u0001\u0000\u0000\u0000\u04a2{\u0001\u0000\u0000"+
		"\u0000\u04a3\u04a4\u0005\u0006\u0000\u0000\u04a4\u04a5\u0003\u009cN\u0000"+
		"\u04a5}\u0001\u0000\u0000\u0000\u04a6\u04a7\u0003\u010a\u0085\u0000\u04a7"+
		"\u04a8\u0005\u0006\u0000\u0000\u04a8\u04aa\u0001\u0000\u0000\u0000\u04a9"+
		"\u04a6\u0001\u0000\u0000\u0000\u04a9\u04aa\u0001\u0000\u0000\u0000\u04aa"+
		"\u04ab\u0001\u0000\u0000\u0000\u04ab\u04ac\u0003\u009cN\u0000\u04ac\u007f"+
		"\u0001\u0000\u0000\u0000\u04ad\u04af\u0003\u00e4r\u0000\u04ae\u04ad\u0001"+
		"\u0000\u0000\u0000\u04af\u04b2\u0001\u0000\u0000\u0000\u04b0\u04ae\u0001"+
		"\u0000\u0000\u0000\u04b0\u04b1\u0001\u0000\u0000\u0000\u04b1\u04b3\u0001"+
		"\u0000\u0000\u0000\u04b2\u04b0\u0001\u0000\u0000\u0000\u04b3\u04b4\u0005"+
		"\u0085\u0000\u0000\u04b4\u04b5\u0003\u009aM\u0000\u04b5\u04b9\u0003l6"+
		"\u0000\u04b6\u04b8\u0003\u0084B\u0000\u04b7\u04b6\u0001\u0000\u0000\u0000"+
		"\u04b8\u04bb\u0001\u0000\u0000\u0000\u04b9\u04b7\u0001\u0000\u0000\u0000"+
		"\u04b9\u04ba\u0001\u0000\u0000\u0000\u04ba\u04be\u0001\u0000\u0000\u0000"+
		"\u04bb\u04b9\u0001\u0000\u0000\u0000\u04bc\u04bd\u0005\u0086\u0000\u0000"+
		"\u04bd\u04bf\u0003l6\u0000\u04be\u04bc\u0001\u0000\u0000\u0000\u04be\u04bf"+
		"\u0001\u0000\u0000\u0000\u04bf\u0081\u0001\u0000\u0000\u0000\u04c0\u04c2"+
		"\u0003\u00e4r\u0000\u04c1\u04c0\u0001\u0000\u0000\u0000\u04c2\u04c5\u0001"+
		"\u0000\u0000\u0000\u04c3\u04c1\u0001\u0000\u0000\u0000\u04c3\u04c4\u0001"+
		"\u0000\u0000\u0000\u04c4\u04c6\u0001\u0000\u0000\u0000\u04c5\u04c3\u0001"+
		"\u0000\u0000\u0000\u04c6\u04c7\u0005\u0085\u0000\u0000\u04c7\u04cb\u0007"+
		"\u0005\u0000\u0000\u04c8\u04cc\u0003v;\u0000\u04c9\u04cc\u0003\u0126\u0093"+
		"\u0000\u04ca\u04cc\u0005\u008f\u0000\u0000\u04cb\u04c8\u0001\u0000\u0000"+
		"\u0000\u04cb\u04c9\u0001\u0000\u0000\u0000\u04cb\u04ca\u0001\u0000\u0000"+
		"\u0000\u04cc\u04cd\u0001\u0000\u0000\u0000\u04cd\u04ce\u00053\u0000\u0000"+
		"\u04ce\u04cf\u0003\u009aM\u0000\u04cf\u04d0\u0003l6\u0000\u04d0\u04dd"+
		"\u0001\u0000\u0000\u0000\u04d1\u04d3\u0003\u00e4r\u0000\u04d2\u04d1\u0001"+
		"\u0000\u0000\u0000\u04d3\u04d6\u0001\u0000\u0000\u0000\u04d4\u04d2\u0001"+
		"\u0000\u0000\u0000\u04d4\u04d5\u0001\u0000\u0000\u0000\u04d5\u04d7\u0001"+
		"\u0000\u0000\u0000\u04d6\u04d4\u0001\u0000\u0000\u0000\u04d7\u04d8\u0005"+
		"\u0085\u0000\u0000\u04d8\u04d9\u0007\u0005\u0000\u0000\u04d9\u04da\u0003"+
		"\u009aM\u0000\u04da\u04db\u0003l6\u0000\u04db\u04dd\u0001\u0000\u0000"+
		"\u0000\u04dc\u04c3\u0001\u0000\u0000\u0000\u04dc\u04d4\u0001\u0000\u0000"+
		"\u0000\u04dd\u0083\u0001\u0000\u0000\u0000\u04de\u04df\u0005\u0086\u0000"+
		"\u0000\u04df\u04e0\u0005\u0085\u0000\u0000\u04e0\u04e1\u0003\u009aM\u0000"+
		"\u04e1\u04e2\u0003l6\u0000\u04e2\u0085\u0001\u0000\u0000\u0000\u04e3\u04e7"+
		"\u0003\u0088D\u0000\u04e4\u04e7\u0003\u008aE\u0000\u04e5\u04e7\u0003\u008c"+
		"F\u0000\u04e6\u04e3\u0001\u0000\u0000\u0000\u04e6\u04e4\u0001\u0000\u0000"+
		"\u0000\u04e6\u04e5\u0001\u0000\u0000\u0000\u04e7\u0087\u0001\u0000\u0000"+
		"\u0000\u04e8\u04ea\u0003\u00e4r\u0000\u04e9\u04e8\u0001\u0000\u0000\u0000"+
		"\u04ea\u04ed\u0001\u0000\u0000\u0000\u04eb\u04e9\u0001\u0000\u0000\u0000"+
		"\u04eb\u04ec\u0001\u0000\u0000\u0000\u04ec\u04ee\u0001\u0000\u0000\u0000"+
		"\u04ed\u04eb\u0001\u0000\u0000\u0000\u04ee\u04f0\u0005u\u0000\u0000\u04ef"+
		"\u04f1\u0003\u009aM\u0000\u04f0\u04ef\u0001\u0000\u0000\u0000\u04f0\u04f1"+
		"\u0001\u0000\u0000\u0000\u04f1\u04f3\u0001\u0000\u0000\u0000\u04f2\u04f4"+
		"\u0003\u0092I\u0000\u04f3\u04f2\u0001\u0000\u0000\u0000\u04f3\u04f4\u0001"+
		"\u0000\u0000\u0000\u04f4\u04f5\u0001\u0000\u0000\u0000\u04f5\u04f6\u0003"+
		"l6\u0000\u04f6\u0089\u0001\u0000\u0000\u0000\u04f7\u04f9\u0003\u00e4r"+
		"\u0000\u04f8\u04f7\u0001\u0000\u0000\u0000\u04f9\u04fc\u0001\u0000\u0000"+
		"\u0000\u04fa\u04f8\u0001\u0000\u0000\u0000\u04fa\u04fb\u0001\u0000\u0000"+
		"\u0000\u04fb\u04fd\u0001\u0000\u0000\u0000\u04fc\u04fa\u0001\u0000\u0000"+
		"\u0000\u04fd\u04fe\u0005u\u0000\u0000\u04fe\u04ff\u0005w\u0000\u0000\u04ff"+
		"\u0500\u0003r9\u0000\u0500\u0501\u00053\u0000\u0000\u0501\u0503\u0003"+
		"\u009aM\u0000\u0502\u0504\u0003\u0092I\u0000\u0503\u0502\u0001\u0000\u0000"+
		"\u0000\u0503\u0504\u0001\u0000\u0000\u0000\u0504\u0505\u0001\u0000\u0000"+
		"\u0000\u0505\u0506\u0003l6\u0000\u0506\u008b\u0001\u0000\u0000\u0000\u0507"+
		"\u0509\u0003\u00e4r\u0000\u0508\u0507\u0001\u0000\u0000\u0000\u0509\u050c"+
		"\u0001\u0000\u0000\u0000\u050a\u0508\u0001\u0000\u0000\u0000\u050a\u050b"+
		"\u0001\u0000\u0000\u0000\u050b\u050d\u0001\u0000\u0000\u0000\u050c\u050a"+
		"\u0001\u0000\u0000\u0000\u050d\u050e\u0005v\u0000\u0000\u050e\u050f\u0003"+
		"r9\u0000\u050f\u0510\u0003\u00c2a\u0000\u0510\u0512\u0003\u009aM\u0000"+
		"\u0511\u0513\u0003\u0090H\u0000\u0512\u0511\u0001\u0000\u0000\u0000\u0512"+
		"\u0513\u0001\u0000\u0000\u0000\u0513\u0515\u0001\u0000\u0000\u0000\u0514"+
		"\u0516\u0003\u0092I\u0000\u0515\u0514\u0001\u0000\u0000\u0000\u0515\u0516"+
		"\u0001\u0000\u0000\u0000\u0516\u0517\u0001\u0000\u0000\u0000\u0517\u0518"+
		"\u0003l6\u0000\u0518\u008d\u0001\u0000\u0000\u0000\u0519\u051b\u0005S"+
		"\u0000\u0000\u051a\u0519\u0001\u0000\u0000\u0000\u051a\u051b\u0001\u0000"+
		"\u0000\u0000\u051b\u051c\u0001\u0000\u0000\u0000\u051c\u051d\u0005\u0001"+
		"\u0000\u0000\u051d\u051e\u0005v\u0000\u0000\u051e\u0520\u0003r9\u0000"+
		"\u051f\u0521\u0003\u0090H\u0000\u0520\u051f\u0001\u0000\u0000\u0000\u0520"+
		"\u0521\u0001\u0000\u0000\u0000\u0521\u0523\u0001\u0000\u0000\u0000\u0522"+
		"\u0524\u0003\u0092I\u0000\u0523\u0522\u0001\u0000\u0000\u0000\u0523\u0524"+
		"\u0001\u0000\u0000\u0000\u0524\u0525\u0001\u0000\u0000\u0000\u0525\u0526"+
		"\u0003l6\u0000\u0526\u008f\u0001\u0000\u0000\u0000\u0527\u0528\u0005\u0085"+
		"\u0000\u0000\u0528\u0529\u0003\u009aM\u0000\u0529\u0091\u0001\u0000\u0000"+
		"\u0000\u052a\u052b\u0005M\u0000\u0000\u052b\u052c\u0003\u0126\u0093\u0000"+
		"\u052c\u0093\u0001\u0000\u0000\u0000\u052d\u052f\u0003\u00e4r\u0000\u052e"+
		"\u052d\u0001\u0000\u0000\u0000\u052f\u0532\u0001\u0000\u0000\u0000\u0530"+
		"\u052e\u0001\u0000\u0000\u0000\u0530\u0531\u0001\u0000\u0000\u0000\u0531"+
		"\u0533\u0001\u0000\u0000\u0000\u0532\u0530\u0001\u0000\u0000\u0000\u0533"+
		"\u0535\u0003\u0096K\u0000\u0534\u0536\u0005S\u0000\u0000\u0535\u0534\u0001"+
		"\u0000\u0000\u0000\u0535\u0536\u0001\u0000\u0000\u0000\u0536\u0538\u0001"+
		"\u0000\u0000\u0000\u0537\u0539\u0003\u0006\u0003\u0000\u0538\u0537\u0001"+
		"\u0000\u0000\u0000\u0538\u0539\u0001\u0000\u0000\u0000\u0539\u0095\u0001"+
		"\u0000\u0000\u0000\u053a\u053b\u0006K\uffff\uffff\u0000\u053b\u053c\u0003"+
		"\u00a2Q\u0000\u053c\u053d\u0003\u0096K!\u053d\u055a\u0001\u0000\u0000"+
		"\u0000\u053e\u053f\u0005\u0007\u0000\u0000\u053f\u0540\u0003\u0096K\u0000"+
		"\u0540\u0541\u0005\b\u0000\u0000\u0541\u055a\u0001\u0000\u0000\u0000\u0542"+
		"\u0543\u0005\u0015\u0000\u0000\u0543\u0544\u0003\u0096K\u0000\u0544\u0545"+
		"\u0005\u0016\u0000\u0000\u0545\u055a\u0001\u0000\u0000\u0000\u0546\u0547"+
		"\u0005\u0013\u0000\u0000\u0547\u0548\u0003\u0096K\u0000\u0548\u0549\u0005"+
		"\u0014\u0000\u0000\u0549\u055a\u0001\u0000\u0000\u0000\u054a\u055a\u0003"+
		"\u0086C\u0000\u054b\u055a\u0003\u00a0P\u0000\u054c\u055a\u0003\u0080@"+
		"\u0000\u054d\u055a\u0003\u00fe\u007f\u0000\u054e\u055a\u0003\u00e8t\u0000"+
		"\u054f\u055a\u0003\u00ecv\u0000\u0550\u055a\u0003\u00eau\u0000\u0551\u055a"+
		"\u0003\u00fc~\u0000\u0552\u055a\u0003\u00e0p\u0000\u0553\u055a\u0003j"+
		"5\u0000\u0554\u055a\u0003l6\u0000\u0555\u055a\u0003\u00ceg\u0000\u0556"+
		"\u055a\u0003\u0106\u0083\u0000\u0557\u055a\u0003\u010e\u0087\u0000\u0558"+
		"\u055a\u0003\u009eO\u0000\u0559\u053a\u0001\u0000\u0000\u0000\u0559\u053e"+
		"\u0001\u0000\u0000\u0000\u0559\u0542\u0001\u0000\u0000\u0000\u0559\u0546"+
		"\u0001\u0000\u0000\u0000\u0559\u054a\u0001\u0000\u0000\u0000\u0559\u054b"+
		"\u0001\u0000\u0000\u0000\u0559\u054c\u0001\u0000\u0000\u0000\u0559\u054d"+
		"\u0001\u0000\u0000\u0000\u0559\u054e\u0001\u0000\u0000\u0000\u0559\u054f"+
		"\u0001\u0000\u0000\u0000\u0559\u0550\u0001\u0000\u0000\u0000\u0559\u0551"+
		"\u0001\u0000\u0000\u0000\u0559\u0552\u0001\u0000\u0000\u0000\u0559\u0553"+
		"\u0001\u0000\u0000\u0000\u0559\u0554\u0001\u0000\u0000\u0000\u0559\u0555"+
		"\u0001\u0000\u0000\u0000\u0559\u0556\u0001\u0000\u0000\u0000\u0559\u0557"+
		"\u0001\u0000\u0000\u0000\u0559\u0558\u0001\u0000\u0000\u0000\u055a\u059c"+
		"\u0001\u0000\u0000\u0000\u055b\u055c\n \u0000\u0000\u055c\u055d\u0003"+
		"\u00aeW\u0000\u055d\u055e\u0003\u0096K \u055e\u059b\u0001\u0000\u0000"+
		"\u0000\u055f\u0560\n\u001f\u0000\u0000\u0560\u0561\u0003\u00b4Z\u0000"+
		"\u0561\u0562\u0003\u0096K \u0562\u059b\u0001\u0000\u0000\u0000\u0563\u0564"+
		"\n\u001e\u0000\u0000\u0564\u0565\u0003\u00b6[\u0000\u0565\u0566\u0003"+
		"\u0096K\u001f\u0566\u059b\u0001\u0000\u0000\u0000\u0567\u0568\n\u001d"+
		"\u0000\u0000\u0568\u0569\u0003\u00a6S\u0000\u0569\u056a\u0003\u0096K\u001e"+
		"\u056a\u059b\u0001\u0000\u0000\u0000\u056b\u056c\n\u001c\u0000\u0000\u056c"+
		"\u056d\u0003\u00b8\\\u0000\u056d\u056e\u0003\u0096K\u001d\u056e\u059b"+
		"\u0001\u0000\u0000\u0000\u056f\u0570\n\u001b\u0000\u0000\u0570\u0571\u0003"+
		"\u00aaU\u0000\u0571\u0572\u0003\u0096K\u001c\u0572\u059b\u0001\u0000\u0000"+
		"\u0000\u0573\u0574\n\u001a\u0000\u0000\u0574\u0575\u0003\u00b0X\u0000"+
		"\u0575\u0576\u0003\u0096K\u001b\u0576\u059b\u0001\u0000\u0000\u0000\u0577"+
		"\u0578\n\u0019\u0000\u0000\u0578\u0579\u0003\u00acV\u0000\u0579\u057a"+
		"\u0003\u0096K\u001a\u057a\u059b\u0001\u0000\u0000\u0000\u057b\u057c\n"+
		"\u0016\u0000\u0000\u057c\u057d\u0003\u00c2a\u0000\u057d\u057e\u0003\u0096"+
		"K\u0017\u057e\u059b\u0001\u0000\u0000\u0000\u057f\u0580\n\u0015\u0000"+
		"\u0000\u0580\u0581\u0005R\u0000\u0000\u0581\u059b\u0003\u0096K\u0016\u0582"+
		"\u0583\n\u0014\u0000\u0000\u0583\u0584\u0003\u00ba]\u0000\u0584\u0585"+
		"\u0003\u0096K\u0015\u0585\u059b\u0001\u0000\u0000\u0000\u0586\u0587\n"+
		"\u0013\u0000\u0000\u0587\u0588\u0003\u00bc^\u0000\u0588\u0589\u0003\u0096"+
		"K\u0013\u0589\u059b\u0001\u0000\u0000\u0000\u058a\u058b\n%\u0000\u0000"+
		"\u058b\u059b\u0003\u00a4R\u0000\u058c\u058d\n$\u0000\u0000\u058d\u059b"+
		"\u0003\u010c\u0086\u0000\u058e\u058f\n#\u0000\u0000\u058f\u059b\u0003"+
		"\u00c8d\u0000\u0590\u0591\n\"\u0000\u0000\u0591\u059b\u0003\u0098L\u0000"+
		"\u0592\u0593\n\u0018\u0000\u0000\u0593\u0594\u0003\u00be_\u0000\u0594"+
		"\u0595\u0003\u009cN\u0000\u0595\u059b\u0001\u0000\u0000\u0000\u0596\u0597"+
		"\n\u0017\u0000\u0000\u0597\u0598\u0003\u00c0`\u0000\u0598\u0599\u0003"+
		"\u009cN\u0000\u0599\u059b\u0001\u0000\u0000\u0000\u059a\u055b\u0001\u0000"+
		"\u0000\u0000\u059a\u055f\u0001\u0000\u0000\u0000\u059a\u0563\u0001\u0000"+
		"\u0000\u0000\u059a\u0567\u0001\u0000\u0000\u0000\u059a\u056b\u0001\u0000"+
		"\u0000\u0000\u059a\u056f\u0001\u0000\u0000\u0000\u059a\u0573\u0001\u0000"+
		"\u0000\u0000\u059a\u0577\u0001\u0000\u0000\u0000\u059a\u057b\u0001\u0000"+
		"\u0000\u0000\u059a\u057f\u0001\u0000\u0000\u0000\u059a\u0582\u0001\u0000"+
		"\u0000\u0000\u059a\u0586\u0001\u0000\u0000\u0000\u059a\u058a\u0001\u0000"+
		"\u0000\u0000\u059a\u058c\u0001\u0000\u0000\u0000\u059a\u058e\u0001\u0000"+
		"\u0000\u0000\u059a\u0590\u0001\u0000\u0000\u0000\u059a\u0592\u0001\u0000"+
		"\u0000\u0000\u059a\u0596\u0001\u0000\u0000\u0000\u059b\u059e\u0001\u0000"+
		"\u0000\u0000\u059c\u059a\u0001\u0000\u0000\u0000\u059c\u059d\u0001\u0000"+
		"\u0000\u0000\u059d\u0097\u0001\u0000\u0000\u0000\u059e\u059c\u0001\u0000"+
		"\u0000\u0000\u059f\u05a3\u0003\u00f0x\u0000\u05a0\u05a3\u0003\u008eG\u0000"+
		"\u05a1\u05a3\u0003d2\u0000\u05a2\u059f\u0001\u0000\u0000\u0000\u05a2\u05a0"+
		"\u0001\u0000\u0000\u0000\u05a2\u05a1\u0001\u0000\u0000\u0000\u05a3\u0099"+
		"\u0001\u0000\u0000\u0000\u05a4\u05a5\u0006M\uffff\uffff\u0000\u05a5\u05a6"+
		"\u0003\u00a2Q\u0000\u05a6\u05a7\u0003\u009aM\u0013\u05a7\u05b8\u0001\u0000"+
		"\u0000\u0000\u05a8\u05a9\u0005\u0007\u0000\u0000\u05a9\u05aa\u0003\u0096"+
		"K\u0000\u05aa\u05ab\u0005\b\u0000\u0000\u05ab\u05b8\u0001\u0000\u0000"+
		"\u0000\u05ac\u05ad\u0005\u0015\u0000\u0000\u05ad\u05ae\u0003\u0096K\u0000"+
		"\u05ae\u05af\u0005\u0016\u0000\u0000\u05af\u05b8\u0001\u0000\u0000\u0000"+
		"\u05b0\u05b1\u0005\u0013\u0000\u0000\u05b1\u05b2\u0003\u0096K\u0000\u05b2"+
		"\u05b3\u0005\u0014\u0000\u0000\u05b3\u05b8\u0001\u0000\u0000\u0000\u05b4"+
		"\u05b8\u0003\u0106\u0083\u0000\u05b5\u05b8\u0003\u010e\u0087\u0000\u05b6"+
		"\u05b8\u0003\u009eO\u0000\u05b7\u05a4\u0001\u0000\u0000\u0000\u05b7\u05a8"+
		"\u0001\u0000\u0000\u0000\u05b7\u05ac\u0001\u0000\u0000\u0000\u05b7\u05b0"+
		"\u0001\u0000\u0000\u0000\u05b7\u05b4\u0001\u0000\u0000\u0000\u05b7\u05b5"+
		"\u0001\u0000\u0000\u0000\u05b7\u05b6\u0001\u0000\u0000\u0000\u05b8\u05e5"+
		"\u0001\u0000\u0000\u0000\u05b9\u05ba\n\u000f\u0000\u0000\u05ba\u05bb\u0003"+
		"\u00b4Z\u0000\u05bb\u05bc\u0003\u009aM\u0010\u05bc\u05e4\u0001\u0000\u0000"+
		"\u0000\u05bd\u05be\n\u000e\u0000\u0000\u05be\u05bf\u0003\u00b6[\u0000"+
		"\u05bf\u05c0\u0003\u009aM\u000f\u05c0\u05e4\u0001\u0000\u0000\u0000\u05c1"+
		"\u05c2\n\r\u0000\u0000\u05c2\u05c3\u0003\u00b8\\\u0000\u05c3\u05c4\u0003"+
		"\u009aM\u000e\u05c4\u05e4\u0001\u0000\u0000\u0000\u05c5\u05c6\n\f\u0000"+
		"\u0000\u05c6\u05c7\u0003\u00aaU\u0000\u05c7\u05c8\u0003\u009aM\r\u05c8"+
		"\u05e4\u0001\u0000\u0000\u0000\u05c9\u05ca\n\u000b\u0000\u0000\u05ca\u05cb"+
		"\u0003\u00acV\u0000\u05cb\u05cc\u0003\u009aM\f\u05cc\u05e4\u0001\u0000"+
		"\u0000\u0000\u05cd\u05ce\n\n\u0000\u0000\u05ce\u05cf\u0003\u00a6S\u0000"+
		"\u05cf\u05d0\u0003\u009aM\u000b\u05d0\u05e4\u0001\u0000\u0000\u0000\u05d1"+
		"\u05d2\n\u0007\u0000\u0000\u05d2\u05d3\u0003\u00b0X\u0000\u05d3\u05d4"+
		"\u0003\u009aM\b\u05d4\u05e4\u0001\u0000\u0000\u0000\u05d5\u05d6\n\u0012"+
		"\u0000\u0000\u05d6\u05e4\u0003b1\u0000\u05d7\u05d8\n\u0011\u0000\u0000"+
		"\u05d8\u05e4\u0003\u00c8d\u0000\u05d9\u05da\n\u0010\u0000\u0000\u05da"+
		"\u05e4\u0003\u010c\u0086\u0000\u05db\u05dc\n\t\u0000\u0000\u05dc\u05dd"+
		"\u0003\u00be_\u0000\u05dd\u05de\u0003\u009cN\u0000\u05de\u05e4\u0001\u0000"+
		"\u0000\u0000\u05df\u05e0\n\b\u0000\u0000\u05e0\u05e1\u0003\u00c0`\u0000"+
		"\u05e1\u05e2\u0003\u009cN\u0000\u05e2\u05e4\u0001\u0000\u0000\u0000\u05e3"+
		"\u05b9\u0001\u0000\u0000\u0000\u05e3\u05bd\u0001\u0000\u0000\u0000\u05e3"+
		"\u05c1\u0001\u0000\u0000\u0000\u05e3\u05c5\u0001\u0000\u0000\u0000\u05e3"+
		"\u05c9\u0001\u0000\u0000\u0000\u05e3\u05cd\u0001\u0000\u0000\u0000\u05e3"+
		"\u05d1\u0001\u0000\u0000\u0000\u05e3\u05d5\u0001\u0000\u0000\u0000\u05e3"+
		"\u05d7\u0001\u0000\u0000\u0000\u05e3\u05d9\u0001\u0000\u0000\u0000\u05e3"+
		"\u05db\u0001\u0000\u0000\u0000\u05e3\u05df\u0001\u0000\u0000\u0000\u05e4"+
		"\u05e7\u0001\u0000\u0000\u0000\u05e5\u05e3\u0001\u0000\u0000\u0000\u05e5"+
		"\u05e6\u0001\u0000\u0000\u0000\u05e6\u009b\u0001\u0000\u0000\u0000\u05e7"+
		"\u05e5\u0001\u0000\u0000\u0000\u05e8\u05e9\u0006N\uffff\uffff\u0000\u05e9"+
		"\u05ea\u0003\u00a2Q\u0000\u05ea\u05eb\u0003\u009cN\u000b\u05eb\u0601\u0001"+
		"\u0000\u0000\u0000\u05ec\u05fa\u0005\u0007\u0000\u0000\u05ed\u05ee\u0003"+
		"~?\u0000\u05ee\u05ef\u0005\u0002\u0000\u0000\u05ef\u05fb\u0001\u0000\u0000"+
		"\u0000\u05f0\u05f3\u0003~?\u0000\u05f1\u05f2\u0005\u0002\u0000\u0000\u05f2"+
		"\u05f4\u0003~?\u0000\u05f3\u05f1\u0001\u0000\u0000\u0000\u05f4\u05f5\u0001"+
		"\u0000\u0000\u0000\u05f5\u05f3\u0001\u0000\u0000\u0000\u05f5\u05f6\u0001"+
		"\u0000\u0000\u0000\u05f6\u05f8\u0001\u0000\u0000\u0000\u05f7\u05f9\u0005"+
		"\u0002\u0000\u0000\u05f8\u05f7\u0001\u0000\u0000\u0000\u05f8\u05f9\u0001"+
		"\u0000\u0000\u0000\u05f9\u05fb\u0001\u0000\u0000\u0000\u05fa\u05ed\u0001"+
		"\u0000\u0000\u0000\u05fa\u05f0\u0001\u0000\u0000\u0000\u05fa\u05fb\u0001"+
		"\u0000\u0000\u0000\u05fb\u05fc\u0001\u0000\u0000\u0000\u05fc\u0601\u0005"+
		"\b\u0000\u0000\u05fd\u0601\u0003l6\u0000\u05fe\u0601\u0005\u001d\u0000"+
		"\u0000\u05ff\u0601\u0003\u009eO\u0000\u0600\u05e8\u0001\u0000\u0000\u0000"+
		"\u0600\u05ec\u0001\u0000\u0000\u0000\u0600\u05fd\u0001\u0000\u0000\u0000"+
		"\u0600\u05fe\u0001\u0000\u0000\u0000\u0600\u05ff\u0001\u0000\u0000\u0000"+
		"\u0601\u0615\u0001\u0000\u0000\u0000\u0602\u0603\n\u0007\u0000\u0000\u0603"+
		"\u0604\u0003\u00a8T\u0000\u0604\u0605\u0003\u009cN\b\u0605\u0614\u0001"+
		"\u0000\u0000\u0000\u0606\u0607\n\u0006\u0000\u0000\u0607\u0608\u0003\u00b2"+
		"Y\u0000\u0608\u0609\u0003\u009cN\u0007\u0609\u0614\u0001\u0000\u0000\u0000"+
		"\u060a\u060b\n\u0005\u0000\u0000\u060b\u060c\u0005\u0019\u0000\u0000\u060c"+
		"\u0614\u0003\u009cN\u0006\u060d\u060e\n\n\u0000\u0000\u060e\u0614\u0005"+
		"S\u0000\u0000\u060f\u0610\n\t\u0000\u0000\u0610\u0614\u0005:\u0000\u0000"+
		"\u0611\u0612\n\b\u0000\u0000\u0612\u0614\u0003\u00cae\u0000\u0613\u0602"+
		"\u0001\u0000\u0000\u0000\u0613\u0606\u0001\u0000\u0000\u0000\u0613\u060a"+
		"\u0001\u0000\u0000\u0000\u0613\u060d\u0001\u0000\u0000\u0000\u0613\u060f"+
		"\u0001\u0000\u0000\u0000\u0613\u0611\u0001\u0000\u0000\u0000\u0614\u0617"+
		"\u0001\u0000\u0000\u0000\u0615\u0613\u0001\u0000\u0000\u0000\u0615\u0616"+
		"\u0001\u0000\u0000\u0000\u0616\u009d\u0001\u0000\u0000\u0000\u0617\u0615"+
		"\u0001\u0000\u0000\u0000\u0618\u0620\u0003\u012e\u0097\u0000\u0619\u0620"+
		"\u0003\u012a\u0095\u0000\u061a\u0620\u0003\u0118\u008c\u0000\u061b\u0620"+
		"\u0003\u011a\u008d\u0000\u061c\u0620\u0003\u0122\u0091\u0000\u061d\u0620"+
		"\u0005\u008f\u0000\u0000\u061e\u0620\u0005P\u0000\u0000\u061f\u0618\u0001"+
		"\u0000\u0000\u0000\u061f\u0619\u0001\u0000\u0000\u0000\u061f\u061a\u0001"+
		"\u0000\u0000\u0000\u061f\u061b\u0001\u0000\u0000\u0000\u061f\u061c\u0001"+
		"\u0000\u0000\u0000\u061f\u061d\u0001\u0000\u0000\u0000\u061f\u061e\u0001"+
		"\u0000\u0000\u0000\u0620\u009f\u0001\u0000\u0000\u0000\u0621\u0623\u0007"+
		"\u0006\u0000\u0000\u0622\u0624\u0003\u0092I\u0000\u0623\u0622\u0001\u0000"+
		"\u0000\u0000\u0623\u0624\u0001\u0000\u0000\u0000\u0624\u0626\u0001\u0000"+
		"\u0000\u0000\u0625\u0627\u0003\u0096K\u0000\u0626\u0625\u0001\u0000\u0000"+
		"\u0000\u0626\u0627\u0001\u0000\u0000\u0000\u0627\u0649\u0001\u0000\u0000"+
		"\u0000\u0628\u062b\u0005\u008b\u0000\u0000\u0629\u062a\u0005g\u0000\u0000"+
		"\u062a\u062c\u0003\u0126\u0093\u0000\u062b\u0629\u0001\u0000\u0000\u0000"+
		"\u062b\u062c\u0001\u0000\u0000\u0000\u062c\u0649\u0001\u0000\u0000\u0000"+
		"\u062d\u0630\u0005\u008c\u0000\u0000\u062e\u062f\u0005g\u0000\u0000\u062f"+
		"\u0631\u0003\u0126\u0093\u0000\u0630\u062e\u0001\u0000\u0000\u0000\u0630"+
		"\u0631\u0001\u0000\u0000\u0000\u0631\u0649\u0001\u0000\u0000\u0000\u0632"+
		"\u0634\u0005\u008e\u0000\u0000\u0633\u0635\u0003\u0096K\u0000\u0634\u0633"+
		"\u0001\u0000\u0000\u0000\u0634\u0635\u0001\u0000\u0000\u0000\u0635\u0649"+
		"\u0001\u0000\u0000\u0000\u0636\u0639\u0005\u008a\u0000\u0000\u0637\u0638"+
		"\u0005g\u0000\u0000\u0638\u063a\u0003\u0126\u0093\u0000\u0639\u0637\u0001"+
		"\u0000\u0000\u0000\u0639\u063a\u0001\u0000\u0000\u0000\u063a\u063c\u0001"+
		"\u0000\u0000\u0000\u063b\u063d\u0003\u0096K\u0000\u063c\u063b\u0001\u0000"+
		"\u0000\u0000\u063c\u063d\u0001\u0000\u0000\u0000\u063d\u0649\u0001\u0000"+
		"\u0000\u0000\u063e\u063f\u0005\u008a\u0000\u0000\u063f\u0649\u0005\u008b"+
		"\u0000\u0000\u0640\u0641\u0005\u008a\u0000\u0000\u0641\u0642\u0005~\u0000"+
		"\u0000\u0642\u0649\u0003\u0096K\u0000\u0643\u0646\u0005\u008d\u0000\u0000"+
		"\u0644\u0645\u0005g\u0000\u0000\u0645\u0647\u0003\u0126\u0093\u0000\u0646"+
		"\u0644\u0001\u0000\u0000\u0000\u0646\u0647\u0001\u0000\u0000\u0000\u0647"+
		"\u0649\u0001\u0000\u0000\u0000\u0648\u0621\u0001\u0000\u0000\u0000\u0648"+
		"\u0628\u0001\u0000\u0000\u0000\u0648\u062d\u0001\u0000\u0000\u0000\u0648"+
		"\u0632\u0001\u0000\u0000\u0000\u0648\u0636\u0001\u0000\u0000\u0000\u0648"+
		"\u063e\u0001\u0000\u0000\u0000\u0648\u0640\u0001\u0000\u0000\u0000\u0648"+
		"\u0643\u0001\u0000\u0000\u0000\u0649\u00a1\u0001\u0000\u0000\u0000\u064a"+
		"\u064b\u0007\u0007\u0000\u0000\u064b\u00a3\u0001\u0000\u0000\u0000\u064c"+
		"\u064d\u0007\b\u0000\u0000\u064d\u00a5\u0001\u0000\u0000\u0000\u064e\u064f"+
		"\u0007\t\u0000\u0000\u064f\u00a7\u0001\u0000\u0000\u0000\u0650\u0651\u0007"+
		"\n\u0000\u0000\u0651\u00a9\u0001\u0000\u0000\u0000\u0652\u0653\u0007\n"+
		"\u0000\u0000\u0653\u00ab\u0001\u0000\u0000\u0000\u0654\u0655\u0007\u000b"+
		"\u0000\u0000\u0655\u00ad\u0001\u0000\u0000\u0000\u0656\u0657\u0007\f\u0000"+
		"\u0000\u0657\u00af\u0001\u0000\u0000\u0000\u0658\u0659\u0005_\u0000\u0000"+
		"\u0659\u00b1\u0001\u0000\u0000\u0000\u065a\u065b\u0007\r\u0000\u0000\u065b"+
		"\u00b3\u0001\u0000\u0000\u0000\u065c\u065d\u0007\u000e\u0000\u0000\u065d"+
		"\u00b5\u0001\u0000\u0000\u0000\u065e\u065f\u0007\u000f\u0000\u0000\u065f"+
		"\u00b7\u0001\u0000\u0000\u0000\u0660\u0661\u0007\u0010\u0000\u0000\u0661"+
		"\u00b9\u0001\u0000\u0000\u0000\u0662\u0663\u0007\u0011\u0000\u0000\u0663"+
		"\u00bb\u0001\u0000\u0000\u0000\u0664\u0665\u0007\u0012\u0000\u0000\u0665"+
		"\u00bd\u0001\u0000\u0000\u0000\u0666\u066d\u0005X\u0000\u0000\u0667\u0668"+
		"\u0005X\u0000\u0000\u0668\u066d\u0005<\u0000\u0000\u0669\u066d\u0005Z"+
		"\u0000\u0000\u066a\u066d\u0005[\u0000\u0000\u066b\u066d\u0005W\u0000\u0000"+
		"\u066c\u0666\u0001\u0000\u0000\u0000\u066c\u0667\u0001\u0000\u0000\u0000"+
		"\u066c\u0669\u0001\u0000\u0000\u0000\u066c\u066a\u0001\u0000\u0000\u0000"+
		"\u066c\u066b\u0001\u0000\u0000\u0000\u066d\u00bf\u0001\u0000\u0000\u0000"+
		"\u066e\u066f\u0005\\\u0000\u0000\u066f\u0672\u0005S\u0000\u0000\u0670"+
		"\u0672\u0005\\\u0000\u0000\u0671\u066e\u0001\u0000\u0000\u0000\u0671\u0670"+
		"\u0001\u0000\u0000\u0000\u0672\u00c1\u0001\u0000\u0000\u0000\u0673\u0679"+
		"\u0005U\u0000\u0000\u0674\u0675\u0005<\u0000\u0000\u0675\u0679\u0005U"+
		"\u0000\u0000\u0676\u0679\u0005T\u0000\u0000\u0677\u0679\u0005V\u0000\u0000"+
		"\u0678\u0673\u0001\u0000\u0000\u0000\u0678\u0674\u0001\u0000\u0000\u0000"+
		"\u0678\u0676\u0001\u0000\u0000\u0000\u0678\u0677\u0001\u0000\u0000\u0000"+
		"\u0679\u00c3\u0001\u0000\u0000\u0000\u067a\u067b\u0005\r\u0000\u0000\u067b"+
		"\u06a1\u0005\u000e\u0000\u0000\u067c\u067d\u0005\r\u0000\u0000\u067d\u0682"+
		"\u0003\u00c6c\u0000\u067e\u067f\u0005\u0002\u0000\u0000\u067f\u0681\u0003"+
		"\u00c6c\u0000\u0680\u067e\u0001\u0000\u0000\u0000\u0681\u0684\u0001\u0000"+
		"\u0000\u0000\u0682\u0680\u0001\u0000\u0000\u0000\u0682\u0683\u0001\u0000"+
		"\u0000\u0000\u0683\u0686\u0001\u0000\u0000\u0000\u0684\u0682\u0001\u0000"+
		"\u0000\u0000\u0685\u0687\u0005\u0002\u0000\u0000\u0686\u0685\u0001\u0000"+
		"\u0000\u0000\u0686\u0687\u0001\u0000\u0000\u0000\u0687\u0688\u0001\u0000"+
		"\u0000\u0000\u0688\u0689\u0005\u000e\u0000\u0000\u0689\u06a1\u0001\u0000"+
		"\u0000\u0000\u068a\u068c\u0005\u0005\u0000\u0000\u068b\u068a\u0001\u0000"+
		"\u0000\u0000\u068b\u068c\u0001\u0000\u0000\u0000\u068c\u068d\u0001\u0000"+
		"\u0000\u0000\u068d\u068e\u0005)\u0000\u0000\u068e\u06a1\u0005.\u0000\u0000"+
		"\u068f\u0691\u0005\u0005\u0000\u0000\u0690\u068f\u0001\u0000\u0000\u0000"+
		"\u0690\u0691\u0001\u0000\u0000\u0000\u0691\u0692\u0001\u0000\u0000\u0000"+
		"\u0692\u0693\u0005)\u0000\u0000\u0693\u0698\u0003\u00c6c\u0000\u0694\u0695"+
		"\u0005\u0002\u0000\u0000\u0695\u0697\u0003\u00c6c\u0000\u0696\u0694\u0001"+
		"\u0000\u0000\u0000\u0697\u069a\u0001\u0000\u0000\u0000\u0698\u0696\u0001"+
		"\u0000\u0000\u0000\u0698\u0699\u0001\u0000\u0000\u0000\u0699\u069c\u0001"+
		"\u0000\u0000\u0000\u069a\u0698\u0001\u0000\u0000\u0000\u069b\u069d\u0005"+
		"\u0002\u0000\u0000\u069c\u069b\u0001\u0000\u0000\u0000\u069c\u069d\u0001"+
		"\u0000\u0000\u0000\u069d\u069e\u0001\u0000\u0000\u0000\u069e\u069f\u0005"+
		".\u0000\u0000\u069f\u06a1\u0001\u0000\u0000\u0000\u06a0\u067a\u0001\u0000"+
		"\u0000\u0000\u06a0\u067c\u0001\u0000\u0000\u0000\u06a0\u068b\u0001\u0000"+
		"\u0000\u0000\u06a0\u0690\u0001\u0000\u0000\u0000\u06a1\u00c5\u0001\u0000"+
		"\u0000\u0000\u06a2\u06a5\u0003\u0126\u0093\u0000\u06a3\u06a4\u0005\u0006"+
		"\u0000\u0000\u06a4\u06a6\u0003\u009cN\u0000\u06a5\u06a3\u0001\u0000\u0000"+
		"\u0000\u06a5\u06a6\u0001\u0000\u0000\u0000\u06a6\u06a9\u0001\u0000\u0000"+
		"\u0000\u06a7\u06a8\u00053\u0000\u0000\u06a8\u06aa\u0003\u009cN\u0000\u06a9"+
		"\u06a7\u0001\u0000\u0000\u0000\u06a9\u06aa\u0001\u0000\u0000\u0000\u06aa"+
		"\u06ad\u0001\u0000\u0000\u0000\u06ab\u06ad\u0005N\u0000\u0000\u06ac\u06a2"+
		"\u0001\u0000\u0000\u0000\u06ac\u06ab\u0001\u0000\u0000\u0000\u06ad\u00c7"+
		"\u0001\u0000\u0000\u0000\u06ae\u06af\u0005\u0005\u0000\u0000\u06af\u06b0"+
		"\u0005)\u0000\u0000\u06b0\u06d1\u0005.\u0000\u0000\u06b1\u06b2\u0005\u0005"+
		"\u0000\u0000\u06b2\u06b3\u0005)\u0000\u0000\u06b3\u06b8\u0003\u00ccf\u0000"+
		"\u06b4\u06b5\u0005\u0002\u0000\u0000\u06b5\u06b7\u0003\u00ccf\u0000\u06b6"+
		"\u06b4\u0001\u0000\u0000\u0000\u06b7\u06ba\u0001\u0000\u0000\u0000\u06b8"+
		"\u06b6\u0001\u0000\u0000\u0000\u06b8\u06b9\u0001\u0000\u0000\u0000\u06b9"+
		"\u06bc\u0001\u0000\u0000\u0000\u06ba\u06b8\u0001\u0000\u0000\u0000\u06bb"+
		"\u06bd\u0005\u0002\u0000\u0000\u06bc\u06bb\u0001\u0000\u0000\u0000\u06bc"+
		"\u06bd\u0001\u0000\u0000\u0000\u06bd\u06be\u0001\u0000\u0000\u0000\u06be"+
		"\u06bf\u0005.\u0000\u0000\u06bf\u06d1\u0001\u0000\u0000\u0000\u06c0\u06c1"+
		"\u0005\r\u0000\u0000\u06c1\u06d1\u0005\u000e\u0000\u0000\u06c2\u06c3\u0005"+
		"\r\u0000\u0000\u06c3\u06c8\u0003\u00ccf\u0000\u06c4\u06c5\u0005\u0002"+
		"\u0000\u0000\u06c5\u06c7\u0003\u00ccf\u0000\u06c6\u06c4\u0001\u0000\u0000"+
		"\u0000\u06c7\u06ca\u0001\u0000\u0000\u0000\u06c8\u06c6\u0001\u0000\u0000"+
		"\u0000\u06c8\u06c9\u0001\u0000\u0000\u0000\u06c9\u06cc\u0001\u0000\u0000"+
		"\u0000\u06ca\u06c8\u0001\u0000\u0000\u0000\u06cb\u06cd\u0005\u0002\u0000"+
		"\u0000\u06cc\u06cb\u0001\u0000\u0000\u0000\u06cc\u06cd\u0001\u0000\u0000"+
		"\u0000\u06cd\u06ce\u0001\u0000\u0000\u0000\u06ce\u06cf\u0005\u000e\u0000"+
		"\u0000\u06cf\u06d1\u0001\u0000\u0000\u0000\u06d0\u06ae\u0001\u0000\u0000"+
		"\u0000\u06d0\u06b1\u0001\u0000\u0000\u0000\u06d0\u06c0\u0001\u0000\u0000"+
		"\u0000\u06d0\u06c2\u0001\u0000\u0000\u0000\u06d1\u00c9\u0001\u0000\u0000"+
		"\u0000\u06d2\u06d4\u0005\u0005\u0000\u0000\u06d3\u06d2\u0001\u0000\u0000"+
		"\u0000\u06d3\u06d4\u0001\u0000\u0000\u0000\u06d4\u06d5\u0001\u0000\u0000"+
		"\u0000\u06d5\u06e1\u0005)\u0000\u0000\u06d6\u06db\u0003\u00ccf\u0000\u06d7"+
		"\u06d8\u0005\u0002\u0000\u0000\u06d8\u06da\u0003\u00ccf\u0000\u06d9\u06d7"+
		"\u0001\u0000\u0000\u0000\u06da\u06dd\u0001\u0000\u0000\u0000\u06db\u06d9"+
		"\u0001\u0000\u0000\u0000\u06db\u06dc\u0001\u0000\u0000\u0000\u06dc\u06df"+
		"\u0001\u0000\u0000\u0000\u06dd\u06db\u0001\u0000\u0000\u0000\u06de\u06e0"+
		"\u0005\u0002\u0000\u0000\u06df\u06de\u0001\u0000\u0000\u0000\u06df\u06e0"+
		"\u0001\u0000\u0000\u0000\u06e0\u06e2\u0001\u0000\u0000\u0000\u06e1\u06d6"+
		"\u0001\u0000\u0000\u0000\u06e1\u06e2\u0001\u0000\u0000\u0000\u06e2\u06e3"+
		"\u0001\u0000\u0000\u0000\u06e3\u06f4\u0005.\u0000\u0000\u06e4\u06f0\u0005"+
		"\r\u0000\u0000\u06e5\u06ea\u0003\u00ccf\u0000\u06e6\u06e7\u0005\u0002"+
		"\u0000\u0000\u06e7\u06e9\u0003\u00ccf\u0000\u06e8\u06e6\u0001\u0000\u0000"+
		"\u0000\u06e9\u06ec\u0001\u0000\u0000\u0000\u06ea\u06e8\u0001\u0000\u0000"+
		"\u0000\u06ea\u06eb\u0001\u0000\u0000\u0000\u06eb\u06ee\u0001\u0000\u0000"+
		"\u0000\u06ec\u06ea\u0001\u0000\u0000\u0000\u06ed\u06ef\u0005\u0002\u0000"+
		"\u0000\u06ee\u06ed\u0001\u0000\u0000\u0000\u06ee\u06ef\u0001\u0000\u0000"+
		"\u0000\u06ef\u06f1\u0001\u0000\u0000\u0000\u06f0\u06e5\u0001\u0000\u0000"+
		"\u0000\u06f0\u06f1\u0001\u0000\u0000\u0000\u06f1\u06f2\u0001\u0000\u0000"+
		"\u0000\u06f2\u06f4\u0005\u000e\u0000\u0000\u06f3\u06d3\u0001\u0000\u0000"+
		"\u0000\u06f3\u06e4\u0001\u0000\u0000\u0000\u06f4\u00cb\u0001\u0000\u0000"+
		"\u0000\u06f5\u06f6\u0003\u0126\u0093\u0000\u06f6\u06f7\u0005\u0006\u0000"+
		"\u0000\u06f7\u06f9\u0001\u0000\u0000\u0000\u06f8\u06f5\u0001\u0000\u0000"+
		"\u0000\u06f8\u06f9\u0001\u0000\u0000\u0000\u06f9\u06fa\u0001\u0000\u0000"+
		"\u0000\u06fa\u06fb\u0003\u009cN\u0000\u06fb\u00cd\u0001\u0000\u0000\u0000"+
		"\u06fc\u06fd\u0005g\u0000\u0000\u06fd\u06fe\u0003\u0126\u0093\u0000\u06fe"+
		"\u00cf\u0001\u0000\u0000\u0000\u06ff\u0701\u0003\u00e4r\u0000\u0700\u06ff"+
		"\u0001\u0000\u0000\u0000\u0701\u0704\u0001\u0000\u0000\u0000\u0702\u0700"+
		"\u0001\u0000\u0000\u0000\u0702\u0703\u0001\u0000\u0000\u0000\u0703\u0705"+
		"\u0001\u0000\u0000\u0000\u0704\u0702\u0001\u0000\u0000\u0000\u0705\u0706"+
		"\u0003\u0112\u0089\u0000\u0706\u072e\u0005r\u0000\u0000\u0707\u070c\u0003"+
		"\u0126\u0093\u0000\u0708\u0709\u0005\u0002\u0000\u0000\u0709\u070b\u0003"+
		"\u0126\u0093\u0000\u070a\u0708\u0001\u0000\u0000\u0000\u070b\u070e\u0001"+
		"\u0000\u0000\u0000\u070c\u070a\u0001\u0000\u0000\u0000\u070c\u070d\u0001"+
		"\u0000\u0000\u0000\u070d\u0710\u0001\u0000\u0000\u0000\u070e\u070c\u0001"+
		"\u0000\u0000\u0000\u070f\u0711\u0005\u0002\u0000\u0000\u0710\u070f\u0001"+
		"\u0000\u0000\u0000\u0710\u0711\u0001\u0000\u0000\u0000\u0711\u072f\u0001"+
		"\u0000\u0000\u0000\u0712\u0713\u0005)\u0000\u0000\u0713\u0718\u0003\u0126"+
		"\u0093\u0000\u0714\u0715\u0005\u0002\u0000\u0000\u0715\u0717\u0003\u0126"+
		"\u0093\u0000\u0716\u0714\u0001\u0000\u0000\u0000\u0717\u071a\u0001\u0000"+
		"\u0000\u0000\u0718\u0716\u0001\u0000\u0000\u0000\u0718\u0719\u0001\u0000"+
		"\u0000\u0000\u0719\u071c\u0001\u0000\u0000\u0000\u071a\u0718\u0001\u0000"+
		"\u0000\u0000\u071b\u071d\u0005\u0002\u0000\u0000\u071c\u071b\u0001\u0000"+
		"\u0000\u0000\u071c\u071d\u0001\u0000\u0000\u0000\u071d\u071e\u0001\u0000"+
		"\u0000\u0000\u071e\u071f\u0005.\u0000\u0000\u071f\u072f\u0001\u0000\u0000"+
		"\u0000\u0720\u0721\u0005\r\u0000\u0000\u0721\u0726\u0003\u0126\u0093\u0000"+
		"\u0722\u0723\u0005\u0002\u0000\u0000\u0723\u0725\u0003\u0126\u0093\u0000"+
		"\u0724\u0722\u0001\u0000\u0000\u0000\u0725\u0728\u0001\u0000\u0000\u0000"+
		"\u0726\u0724\u0001\u0000\u0000\u0000\u0726\u0727\u0001\u0000\u0000\u0000"+
		"\u0727\u072a\u0001\u0000\u0000\u0000\u0728\u0726\u0001\u0000\u0000\u0000"+
		"\u0729\u072b\u0005\u0002\u0000\u0000\u072a\u0729\u0001\u0000\u0000\u0000"+
		"\u072a\u072b\u0001\u0000\u0000\u0000\u072b\u072c\u0001\u0000\u0000\u0000"+
		"\u072c\u072d\u0005\u000e\u0000\u0000\u072d\u072f\u0001\u0000\u0000\u0000"+
		"\u072e\u0707\u0001\u0000\u0000\u0000\u072e\u0712\u0001\u0000\u0000\u0000"+
		"\u072e\u0720\u0001\u0000\u0000\u0000\u072e\u072f\u0001\u0000\u0000\u0000"+
		"\u072f\u0730\u0001\u0000\u0000\u0000\u0730\u0731\u0003\u00d2i\u0000\u0731"+
		"\u00d1\u0001\u0000\u0000\u0000\u0732\u0736\u0005\u000b\u0000\u0000\u0733"+
		"\u0735\u0003\u00d4j\u0000\u0734\u0733\u0001\u0000\u0000\u0000\u0735\u0738"+
		"\u0001\u0000\u0000\u0000\u0736\u0734\u0001\u0000\u0000\u0000\u0736\u0737"+
		"\u0001\u0000\u0000\u0000\u0737\u0739\u0001\u0000\u0000\u0000\u0738\u0736"+
		"\u0001\u0000\u0000\u0000\u0739\u073a\u0005\f\u0000\u0000\u073a\u00d3\u0001"+
		"\u0000\u0000\u0000\u073b\u073f\u0003\u00d6k\u0000\u073c\u073f\u0003\u00d8"+
		"l\u0000\u073d\u073f\u0003\b\u0004\u0000\u073e\u073b\u0001\u0000\u0000"+
		"\u0000\u073e\u073c\u0001\u0000\u0000\u0000\u073e\u073d\u0001\u0000\u0000"+
		"\u0000\u073f\u00d5\u0001\u0000\u0000\u0000\u0740\u0741\u0005\u0081\u0000"+
		"\u0000\u0741\u0748\u0003\u00dam\u0000\u0742\u0743\u0005\u0088\u0000\u0000"+
		"\u0743\u0748\u0003\u009cN\u0000\u0744\u0745\u0003\u0126\u0093\u0000\u0745"+
		"\u0746\u0003\u00deo\u0000\u0746\u0748\u0001\u0000\u0000\u0000\u0747\u0740"+
		"\u0001\u0000\u0000\u0000\u0747\u0742\u0001\u0000\u0000\u0000\u0747\u0744"+
		"\u0001\u0000\u0000\u0000\u0748\u00d7\u0001\u0000\u0000\u0000\u0749\u074a"+
		"\u0005t\u0000\u0000\u074a\u074b\u0003\u009cN\u0000\u074b\u00d9\u0001\u0000"+
		"\u0000\u0000\u074c\u0750\u0005\u000b\u0000\u0000\u074d\u074f\u0003\u00dc"+
		"n\u0000\u074e\u074d\u0001\u0000\u0000\u0000\u074f\u0752\u0001\u0000\u0000"+
		"\u0000\u0750\u074e\u0001\u0000\u0000\u0000\u0750\u0751\u0001\u0000\u0000"+
		"\u0000\u0751\u0753\u0001\u0000\u0000\u0000\u0752\u0750\u0001\u0000\u0000"+
		"\u0000\u0753\u0754\u0005\f\u0000\u0000\u0754\u00db\u0001\u0000\u0000\u0000"+
		"\u0755\u0756\u0003\u0126\u0093\u0000\u0756\u0757\u0005\u0006\u0000\u0000"+
		"\u0757\u0758\u0003\u009cN\u0000\u0758\u075b\u0001\u0000\u0000\u0000\u0759"+
		"\u075b\u0003\b\u0004\u0000\u075a\u0755\u0001\u0000\u0000\u0000\u075a\u0759"+
		"\u0001\u0000\u0000\u0000\u075b\u00dd\u0001\u0000\u0000\u0000\u075c\u0761"+
		"\u0005\u000b\u0000\u0000\u075d\u0760\u0003\u0094J\u0000\u075e\u0760\u0003"+
		"\b\u0004\u0000\u075f\u075d\u0001\u0000\u0000\u0000\u075f\u075e\u0001\u0000"+
		"\u0000\u0000\u0760\u0763\u0001\u0000\u0000\u0000\u0761\u075f\u0001\u0000"+
		"\u0000\u0000\u0761\u0762\u0001\u0000\u0000\u0000\u0762\u0764\u0001\u0000"+
		"\u0000\u0000\u0763\u0761\u0001\u0000\u0000\u0000\u0764\u0765\u0005\f\u0000"+
		"\u0000\u0765\u00df\u0001\u0000\u0000\u0000\u0766\u0767\u0005L\u0000\u0000"+
		"\u0767\u0768\u0003\u00e2q\u0000\u0768\u00e1\u0001\u0000\u0000\u0000\u0769"+
		"\u076b\u0003\u0122\u0091\u0000\u076a\u076c\u0003f3\u0000\u076b\u076a\u0001"+
		"\u0000\u0000\u0000\u076b\u076c\u0001\u0000\u0000\u0000\u076c\u076e\u0001"+
		"\u0000\u0000\u0000\u076d\u076f\u0003 \u0010\u0000\u076e\u076d\u0001\u0000"+
		"\u0000\u0000\u076e\u076f\u0001\u0000\u0000\u0000\u076f\u00e3\u0001\u0000"+
		"\u0000\u0000\u0770\u0771\u0005M\u0000\u0000\u0771\u0783\u0003\u00e6s\u0000"+
		"\u0772\u0773\u0005M\u0000\u0000\u0773\u077f\u0005\t\u0000\u0000\u0774"+
		"\u0779\u0003\u00e6s\u0000\u0775\u0776\u0005\u0002\u0000\u0000\u0776\u0778"+
		"\u0003\u00e6s\u0000\u0777\u0775\u0001\u0000\u0000\u0000\u0778\u077b\u0001"+
		"\u0000\u0000\u0000\u0779\u0777\u0001\u0000\u0000\u0000\u0779\u077a\u0001"+
		"\u0000\u0000\u0000\u077a\u077d\u0001\u0000\u0000\u0000\u077b\u0779\u0001"+
		"\u0000\u0000\u0000\u077c\u077e\u0005\u0002\u0000\u0000\u077d\u077c\u0001"+
		"\u0000\u0000\u0000\u077d\u077e\u0001\u0000\u0000\u0000\u077e\u0780\u0001"+
		"\u0000\u0000\u0000\u077f\u0774\u0001\u0000\u0000\u0000\u077f\u0780\u0001"+
		"\u0000\u0000\u0000\u0780\u0781\u0001\u0000\u0000\u0000\u0781\u0783\u0005"+
		"\n\u0000\u0000\u0782\u0770\u0001\u0000\u0000\u0000\u0782\u0772\u0001\u0000"+
		"\u0000\u0000\u0783\u00e5\u0001\u0000\u0000\u0000\u0784\u0789\u0003\u0122"+
		"\u0091\u0000\u0785\u0786\u0005\u0001\u0000\u0000\u0786\u0788\u0003\u0126"+
		"\u0093\u0000\u0787\u0785\u0001\u0000\u0000\u0000\u0788\u078b\u0001\u0000"+
		"\u0000\u0000\u0789\u0787\u0001\u0000\u0000\u0000\u0789\u078a\u0001\u0000"+
		"\u0000\u0000\u078a\u078d\u0001\u0000\u0000\u0000\u078b\u0789\u0001\u0000"+
		"\u0000\u0000\u078c\u078e\u0003f3\u0000\u078d\u078c\u0001\u0000\u0000\u0000"+
		"\u078d\u078e\u0001\u0000\u0000\u0000\u078e\u0790\u0001\u0000\u0000\u0000"+
		"\u078f\u0791\u0003 \u0010\u0000\u0790\u078f\u0001\u0000\u0000\u0000\u0790"+
		"\u0791\u0001\u0000\u0000\u0000\u0791\u00e7\u0001\u0000\u0000\u0000\u0792"+
		"\u0794\u0003\u00e4r\u0000\u0793\u0792\u0001\u0000\u0000\u0000\u0794\u0797"+
		"\u0001\u0000\u0000\u0000\u0795\u0793\u0001\u0000\u0000\u0000\u0795\u0796"+
		"\u0001\u0000\u0000\u0000\u0796\u0798\u0001\u0000\u0000\u0000\u0797\u0795"+
		"\u0001\u0000\u0000\u0000\u0798\u079a\u0005|\u0000\u0000\u0799\u079b\u0003"+
		"\u009cN\u0000\u079a\u0799\u0001\u0000\u0000\u0000\u079a\u079b\u0001\u0000"+
		"\u0000\u0000\u079b\u079c\u0001\u0000\u0000\u0000\u079c\u079d\u0003l6\u0000"+
		"\u079d\u00e9\u0001\u0000\u0000\u0000\u079e\u07a0\u0003\u00e4r\u0000\u079f"+
		"\u079e\u0001\u0000\u0000\u0000\u07a0\u07a3\u0001\u0000\u0000\u0000\u07a1"+
		"\u079f\u0001\u0000\u0000\u0000\u07a1\u07a2\u0001\u0000\u0000\u0000\u07a2"+
		"\u07a4\u0001\u0000\u0000\u0000\u07a3\u07a1\u0001\u0000\u0000\u0000\u07a4"+
		"\u07a8\u0005}\u0000\u0000\u07a5\u07a6\u0003\u0126\u0093\u0000\u07a6\u07a7"+
		"\u00054\u0000\u0000\u07a7\u07a9\u0001\u0000\u0000\u0000\u07a8\u07a5\u0001"+
		"\u0000\u0000\u0000\u07a8\u07a9\u0001\u0000\u0000\u0000\u07a9\u07aa\u0001"+
		"\u0000\u0000\u0000\u07aa\u07ac\u0003\u009aM\u0000\u07ab\u07ad\u0005S\u0000"+
		"\u0000\u07ac\u07ab\u0001\u0000\u0000\u0000\u07ac\u07ad\u0001\u0000\u0000"+
		"\u0000\u07ad\u07ae\u0001\u0000\u0000\u0000\u07ae\u07af\u0003\u00eew\u0000"+
		"\u07af\u00eb\u0001\u0000\u0000\u0000\u07b0\u07b2\u0003\u00e4r\u0000\u07b1"+
		"\u07b0\u0001\u0000\u0000\u0000\u07b2\u07b5\u0001\u0000\u0000\u0000\u07b3"+
		"\u07b1\u0001\u0000\u0000\u0000\u07b3\u07b4\u0001\u0000\u0000\u0000\u07b4"+
		"\u07b6\u0001\u0000\u0000\u0000\u07b5\u07b3\u0001\u0000\u0000\u0000\u07b6"+
		"\u07b7\u0005\u009b\u0000\u0000\u07b7\u07b8\u0003\u00eew\u0000\u07b8\u00ed"+
		"\u0001\u0000\u0000\u0000\u07b9\u07be\u0005\u000b\u0000\u0000\u07ba\u07bd"+
		"\u0003\u00f2y\u0000\u07bb\u07bd\u0003\b\u0004\u0000\u07bc\u07ba\u0001"+
		"\u0000\u0000\u0000\u07bc\u07bb\u0001\u0000\u0000\u0000\u07bd\u07c0\u0001"+
		"\u0000\u0000\u0000\u07be\u07bc\u0001\u0000\u0000\u0000\u07be\u07bf\u0001"+
		"\u0000\u0000\u0000\u07bf\u07c1\u0001\u0000\u0000\u0000\u07c0\u07be\u0001"+
		"\u0000\u0000\u0000\u07c1\u07c2\u0005\f\u0000\u0000\u07c2\u00ef\u0001\u0000"+
		"\u0000\u0000\u07c3\u07c5\u0005S\u0000\u0000\u07c4\u07c3\u0001\u0000\u0000"+
		"\u0000\u07c4\u07c5\u0001\u0000\u0000\u0000\u07c5\u07c6\u0001\u0000\u0000"+
		"\u0000\u07c6\u07c7\u0005\u0001\u0000\u0000\u07c7\u07cd\u0005}\u0000\u0000"+
		"\u07c8\u07c9\u0005\\\u0000\u0000\u07c9\u07cb\u0003\u0126\u0093\u0000\u07ca"+
		"\u07cc\u0003|>\u0000\u07cb\u07ca\u0001\u0000\u0000\u0000\u07cb\u07cc\u0001"+
		"\u0000\u0000\u0000\u07cc\u07ce\u0001\u0000\u0000\u0000\u07cd\u07c8\u0001"+
		"\u0000\u0000\u0000\u07cd\u07ce\u0001\u0000\u0000\u0000\u07ce\u07cf\u0001"+
		"\u0000\u0000\u0000\u07cf\u07d0\u0003\u00eew\u0000\u07d0\u00f1\u0001\u0000"+
		"\u0000\u0000\u07d1\u07d3\u0003\u00e4r\u0000\u07d2\u07d1\u0001\u0000\u0000"+
		"\u0000\u07d3\u07d6\u0001\u0000\u0000\u0000\u07d4\u07d2\u0001\u0000\u0000"+
		"\u0000\u07d4\u07d5\u0001\u0000\u0000\u0000\u07d5\u07d7\u0001\u0000\u0000"+
		"\u0000\u07d6\u07d4\u0001\u0000\u0000\u0000\u07d7\u07d8\u0005~\u0000\u0000"+
		"\u07d8\u081e\u0003\u0126\u0093\u0000\u07d9\u07db\u0003\u00e4r\u0000\u07da"+
		"\u07d9\u0001\u0000\u0000\u0000\u07db\u07de\u0001\u0000\u0000\u0000\u07dc"+
		"\u07da\u0001\u0000\u0000\u0000\u07dc\u07dd\u0001\u0000\u0000\u0000\u07dd"+
		"\u07df\u0001\u0000\u0000\u0000\u07de\u07dc\u0001\u0000\u0000\u0000\u07df"+
		"\u07e0\u0005~\u0000\u0000\u07e0\u07ec\u0005\t\u0000\u0000\u07e1\u07e6"+
		"\u0003\u0126\u0093\u0000\u07e2\u07e3\u0005\u0002\u0000\u0000\u07e3\u07e5"+
		"\u0003\u0126\u0093\u0000\u07e4\u07e2\u0001\u0000\u0000\u0000\u07e5\u07e8"+
		"\u0001\u0000\u0000\u0000\u07e6\u07e4\u0001\u0000\u0000\u0000\u07e6\u07e7"+
		"\u0001\u0000\u0000\u0000\u07e7\u07ea\u0001\u0000\u0000\u0000\u07e8\u07e6"+
		"\u0001\u0000\u0000\u0000\u07e9\u07eb\u0005\u0002\u0000\u0000\u07ea\u07e9"+
		"\u0001\u0000\u0000\u0000\u07ea\u07eb\u0001\u0000\u0000\u0000\u07eb\u07ed"+
		"\u0001\u0000\u0000\u0000\u07ec\u07e1\u0001\u0000\u0000\u0000\u07ec\u07ed"+
		"\u0001\u0000\u0000\u0000\u07ed\u07ee\u0001\u0000\u0000\u0000\u07ee\u081e"+
		"\u0005\n\u0000\u0000\u07ef\u07f1\u0003\u00e4r\u0000\u07f0\u07ef\u0001"+
		"\u0000\u0000\u0000\u07f1\u07f4\u0001\u0000\u0000\u0000\u07f2\u07f0\u0001"+
		"\u0000\u0000\u0000\u07f2\u07f3\u0001\u0000\u0000\u0000\u07f3\u07f5\u0001"+
		"\u0000\u0000\u0000\u07f4\u07f2\u0001\u0000\u0000\u0000\u07f5\u07f6\u0005"+
		"q\u0000\u0000\u07f6\u07f9\u0003\u009cN\u0000\u07f7\u07f8\u0005\u0085\u0000"+
		"\u0000\u07f8\u07fa\u0003\u009aM\u0000\u07f9\u07f7\u0001\u0000\u0000\u0000"+
		"\u07f9\u07fa\u0001\u0000\u0000\u0000\u07fa\u07fb\u0001\u0000\u0000\u0000"+
		"\u07fb\u07fc\u0003\u00f4z\u0000\u07fc\u081e\u0001\u0000\u0000\u0000\u07fd"+
		"\u07ff\u0003\u00e4r\u0000\u07fe\u07fd\u0001\u0000\u0000\u0000\u07ff\u0802"+
		"\u0001\u0000\u0000\u0000\u0800\u07fe\u0001\u0000\u0000\u0000\u0800\u0801"+
		"\u0001\u0000\u0000\u0000\u0801\u0803\u0001\u0000\u0000\u0000\u0802\u0800"+
		"\u0001\u0000\u0000\u0000\u0803\u0804\u0005\u0080\u0000\u0000\u0804\u0805"+
		"\u0003\u009aM\u0000\u0805\u0806\u0003\u00f4z\u0000\u0806\u081e\u0001\u0000"+
		"\u0000\u0000\u0807\u0809\u0003\u00e4r\u0000\u0808\u0807\u0001\u0000\u0000"+
		"\u0000\u0809\u080c\u0001\u0000\u0000\u0000\u080a\u0808\u0001\u0000\u0000"+
		"\u0000\u080a\u080b\u0001\u0000\u0000\u0000\u080b\u080d\u0001\u0000\u0000"+
		"\u0000\u080c\u080a\u0001\u0000\u0000\u0000\u080d\u080e\u0005\u0086\u0000"+
		"\u0000\u080e\u081e\u0003\u00f4z\u0000\u080f\u0811\u0003\u00e4r\u0000\u0810"+
		"\u080f\u0001\u0000\u0000\u0000\u0811\u0814\u0001\u0000\u0000\u0000\u0812"+
		"\u0810\u0001\u0000\u0000\u0000\u0812\u0813\u0001\u0000\u0000\u0000\u0813"+
		"\u0815\u0001\u0000\u0000\u0000\u0814\u0812\u0001\u0000\u0000\u0000\u0815"+
		"\u0816\u0005\u007f\u0000\u0000\u0816\u0819\u0003\u00f6{\u0000\u0817\u0818"+
		"\u0005\u0085\u0000\u0000\u0818\u081a\u0003\u009aM\u0000\u0819\u0817\u0001"+
		"\u0000\u0000\u0000\u0819\u081a\u0001\u0000\u0000\u0000\u081a\u081b\u0001"+
		"\u0000\u0000\u0000\u081b\u081c\u0003\u00f4z\u0000\u081c\u081e\u0001\u0000"+
		"\u0000\u0000\u081d\u07d4\u0001\u0000\u0000\u0000\u081d\u07dc\u0001\u0000"+
		"\u0000\u0000\u081d\u07f2\u0001\u0000\u0000\u0000\u081d\u0800\u0001\u0000"+
		"\u0000\u0000\u081d\u080a\u0001\u0000\u0000\u0000\u081d\u0812\u0001\u0000"+
		"\u0000\u0000\u081e\u00f3\u0001\u0000\u0000\u0000\u081f\u0823\u0007\u0013"+
		"\u0000\u0000\u0820\u0822\u0003\u0096K\u0000\u0821\u0820\u0001\u0000\u0000"+
		"\u0000\u0822\u0825\u0001\u0000\u0000\u0000\u0823\u0821\u0001\u0000\u0000"+
		"\u0000\u0823\u0824\u0001\u0000\u0000\u0000\u0824\u00f5\u0001\u0000\u0000"+
		"\u0000\u0825\u0823\u0001\u0000\u0000\u0000\u0826\u0827\u0006{\uffff\uffff"+
		"\u0000\u0827\u0828\u0003\u00f8|\u0000\u0828\u0831\u0001\u0000\u0000\u0000"+
		"\u0829\u082a\n\u0003\u0000\u0000\u082a\u082b\u0007\u0014\u0000\u0000\u082b"+
		"\u0830\u0003\u00f6{\u0004\u082c\u082d\n\u0002\u0000\u0000\u082d\u082e"+
		"\u0005_\u0000\u0000\u082e\u0830\u0003\u00f6{\u0003\u082f\u0829\u0001\u0000"+
		"\u0000\u0000\u082f\u082c\u0001\u0000\u0000\u0000\u0830\u0833\u0001\u0000"+
		"\u0000\u0000\u0831\u082f\u0001\u0000\u0000\u0000\u0831\u0832\u0001\u0000"+
		"\u0000\u0000\u0832\u00f7\u0001\u0000\u0000\u0000\u0833\u0831\u0001\u0000"+
		"\u0000\u0000\u0834\u084b\u0003\u00fa}\u0000\u0835\u0836\u0003\u0126\u0093"+
		"\u0000\u0836\u0837\u00054\u0000\u0000\u0837\u0838\u0003\u00f8|\u0000\u0838"+
		"\u084b\u0001\u0000\u0000\u0000\u0839\u083a\u0003\u0114\u008a\u0000\u083a"+
		"\u083e\u0005\u0006\u0000\u0000\u083b\u083c\u0003\u0126\u0093\u0000\u083c"+
		"\u083d\u00054\u0000\u0000\u083d\u083f\u0001\u0000\u0000\u0000\u083e\u083b"+
		"\u0001\u0000\u0000\u0000\u083e\u083f\u0001\u0000\u0000\u0000\u083f\u0840"+
		"\u0001\u0000\u0000\u0000\u0840\u0841\u0003\u00f8|\u0000\u0841\u084b\u0001"+
		"\u0000\u0000\u0000\u0842\u0844\u0007\u0015\u0000\u0000\u0843\u0845\u0003"+
		"\u0126\u0093\u0000\u0844\u0843\u0001\u0000\u0000\u0000\u0844\u0845\u0001"+
		"\u0000\u0000\u0000\u0845\u084b\u0001\u0000\u0000\u0000\u0846\u084b\u0003"+
		"\u0122\u0091\u0000\u0847\u084b\u0003\u012a\u0095\u0000\u0848\u084b\u0003"+
		"\u012e\u0097\u0000\u0849\u084b\u0005\u008f\u0000\u0000\u084a\u0834\u0001"+
		"\u0000\u0000\u0000\u084a\u0835\u0001\u0000\u0000\u0000\u084a\u0839\u0001"+
		"\u0000\u0000\u0000\u084a\u0842\u0001\u0000\u0000\u0000\u084a\u0846\u0001"+
		"\u0000\u0000\u0000\u084a\u0847\u0001\u0000\u0000\u0000\u084a\u0848\u0001"+
		"\u0000\u0000\u0000\u084a\u0849\u0001\u0000\u0000\u0000\u084b\u00f9\u0001"+
		"\u0000\u0000\u0000\u084c\u084e\u0003\u0122\u0091\u0000\u084d\u084c\u0001"+
		"\u0000\u0000\u0000\u084d\u084e\u0001\u0000\u0000\u0000\u084e\u084f\u0001"+
		"\u0000\u0000\u0000\u084f\u0850\u0005\u0007\u0000\u0000\u0850\u089f\u0005"+
		"\b\u0000\u0000\u0851\u0853\u0003\u0122\u0091\u0000\u0852\u0851\u0001\u0000"+
		"\u0000\u0000\u0852\u0853\u0001\u0000\u0000\u0000\u0853\u0854\u0001\u0000"+
		"\u0000\u0000\u0854\u0855\u0005\t\u0000\u0000\u0855\u089f\u0005\n\u0000"+
		"\u0000\u0856\u0858\u0003\u0122\u0091\u0000\u0857\u0856\u0001\u0000\u0000"+
		"\u0000\u0857\u0858\u0001\u0000\u0000\u0000\u0858\u0859\u0001\u0000\u0000"+
		"\u0000\u0859\u085a\u0005\u000b\u0000\u0000\u085a\u089f\u0005\f\u0000\u0000"+
		"\u085b\u085c\u0005\u0007\u0000\u0000\u085c\u085d\u0003\u00f8|\u0000\u085d"+
		"\u085e\u0005\u0002\u0000\u0000\u085e\u085f\u0005\b\u0000\u0000\u085f\u089f"+
		"\u0001\u0000\u0000\u0000\u0860\u0861\u0005\u0007\u0000\u0000\u0861\u0864"+
		"\u0003\u00f8|\u0000\u0862\u0863\u0005\u0002\u0000\u0000\u0863\u0865\u0003"+
		"\u00f8|\u0000\u0864\u0862\u0001\u0000\u0000\u0000\u0865\u0866\u0001\u0000"+
		"\u0000\u0000\u0866\u0864\u0001\u0000\u0000\u0000\u0866\u0867\u0001\u0000"+
		"\u0000\u0000\u0867\u0869\u0001\u0000\u0000\u0000\u0868\u086a\u0005\u0002"+
		"\u0000\u0000\u0869\u0868\u0001\u0000\u0000\u0000\u0869\u086a\u0001\u0000"+
		"\u0000\u0000\u086a\u086b\u0001\u0000\u0000\u0000\u086b\u086c\u0005\b\u0000"+
		"\u0000\u086c\u089f\u0001\u0000\u0000\u0000\u086d\u086e\u0003\u0122\u0091"+
		"\u0000\u086e\u086f\u0005\u0007\u0000\u0000\u086f\u0874\u0003\u00f8|\u0000"+
		"\u0870\u0871\u0005\u0002\u0000\u0000\u0871\u0873\u0003\u00f8|\u0000\u0872"+
		"\u0870\u0001\u0000\u0000\u0000\u0873\u0876\u0001\u0000\u0000\u0000\u0874"+
		"\u0872\u0001\u0000\u0000\u0000\u0874\u0875\u0001\u0000\u0000\u0000\u0875"+
		"\u0878\u0001\u0000\u0000\u0000\u0876\u0874\u0001\u0000\u0000\u0000\u0877"+
		"\u0879\u0005\u0002\u0000\u0000\u0878\u0877\u0001\u0000\u0000\u0000\u0878"+
		"\u0879\u0001\u0000\u0000\u0000\u0879\u087a\u0001\u0000\u0000\u0000\u087a"+
		"\u087b\u0005\b\u0000\u0000\u087b\u089f\u0001\u0000\u0000\u0000\u087c\u087e"+
		"\u0003\u0122\u0091\u0000\u087d\u087c\u0001\u0000\u0000\u0000\u087d\u087e"+
		"\u0001\u0000\u0000\u0000\u087e\u087f\u0001\u0000\u0000\u0000\u087f\u0880"+
		"\u0005\t\u0000\u0000\u0880\u0885\u0003\u00f8|\u0000\u0881\u0882\u0005"+
		"\u0002\u0000\u0000\u0882\u0884\u0003\u00f8|\u0000\u0883\u0881\u0001\u0000"+
		"\u0000\u0000\u0884\u0887\u0001\u0000\u0000\u0000\u0885\u0883\u0001\u0000"+
		"\u0000\u0000\u0885\u0886\u0001\u0000\u0000\u0000\u0886\u0889\u0001\u0000"+
		"\u0000\u0000\u0887\u0885\u0001\u0000\u0000\u0000\u0888\u088a\u0005\u0002"+
		"\u0000\u0000\u0889\u0888\u0001\u0000\u0000\u0000\u0889\u088a\u0001\u0000"+
		"\u0000\u0000\u088a\u088b\u0001\u0000\u0000\u0000\u088b\u088c\u0005\n\u0000"+
		"\u0000\u088c\u089f\u0001\u0000\u0000\u0000\u088d\u088f\u0003\u0122\u0091"+
		"\u0000\u088e\u088d\u0001\u0000\u0000\u0000\u088e\u088f\u0001\u0000\u0000"+
		"\u0000\u088f\u0890\u0001\u0000\u0000\u0000\u0890\u0891\u0005\u000b\u0000"+
		"\u0000\u0891\u0896\u0003\u00f8|\u0000\u0892\u0893\u0005\u0002\u0000\u0000"+
		"\u0893\u0895\u0003\u00f8|\u0000\u0894\u0892\u0001\u0000\u0000\u0000\u0895"+
		"\u0898\u0001\u0000\u0000\u0000\u0896\u0894\u0001\u0000\u0000\u0000\u0896"+
		"\u0897\u0001\u0000\u0000\u0000\u0897\u089a\u0001\u0000\u0000\u0000\u0898"+
		"\u0896\u0001\u0000\u0000\u0000\u0899\u089b\u0005\u0002\u0000\u0000\u089a"+
		"\u0899\u0001\u0000\u0000\u0000\u089a\u089b\u0001\u0000\u0000\u0000\u089b"+
		"\u089c\u0001\u0000\u0000\u0000\u089c\u089d\u0005\f\u0000\u0000\u089d\u089f"+
		"\u0001\u0000\u0000\u0000\u089e\u084d\u0001\u0000\u0000\u0000\u089e\u0852"+
		"\u0001\u0000\u0000\u0000\u089e\u0857\u0001\u0000\u0000\u0000\u089e\u085b"+
		"\u0001\u0000\u0000\u0000\u089e\u0860\u0001\u0000\u0000\u0000\u089e\u086d"+
		"\u0001\u0000\u0000\u0000\u089e\u087d\u0001\u0000\u0000\u0000\u089e\u088e"+
		"\u0001\u0000\u0000\u0000\u089f\u00fb\u0001\u0000\u0000\u0000\u08a0\u08a2"+
		"\u0005y\u0000\u0000\u08a1\u08a3\u0003\u00c4b\u0000\u08a2\u08a1\u0001\u0000"+
		"\u0000\u0000\u08a2\u08a3\u0001\u0000\u0000\u0000\u08a3\u08a5\u0001\u0000"+
		"\u0000\u0000\u08a4\u08a6\u0003$\u0012\u0000\u08a5\u08a4\u0001\u0000\u0000"+
		"\u0000\u08a5\u08a6\u0001\u0000\u0000\u0000\u08a6\u08a8\u0001\u0000\u0000"+
		"\u0000\u08a7\u08a9\u0003|>\u0000\u08a8\u08a7\u0001\u0000\u0000\u0000\u08a8"+
		"\u08a9\u0001\u0000\u0000\u0000\u08a9\u08aa\u0001\u0000\u0000\u0000\u08aa"+
		"\u08ab\u0003 \u0010\u0000\u08ab\u00fd\u0001\u0000\u0000\u0000\u08ac\u08ad"+
		"\u0005x\u0000\u0000\u08ad\u08af\u0003\u0116\u008b\u0000\u08ae\u08b0\u0003"+
		"\u00cae\u0000\u08af\u08ae\u0001\u0000\u0000\u0000\u08af\u08b0\u0001\u0000"+
		"\u0000\u0000\u08b0\u08b2\u0001\u0000\u0000\u0000\u08b1\u08b3\u0003f3\u0000"+
		"\u08b2\u08b1\u0001\u0000\u0000\u0000\u08b2\u08b3\u0001\u0000\u0000\u0000"+
		"\u08b3\u08b4\u0001\u0000\u0000\u0000\u08b4\u08b5\u0003\u0100\u0080\u0000"+
		"\u08b5\u08c0\u0001\u0000\u0000\u0000\u08b6\u08b7\u0005x\u0000\u0000\u08b7"+
		"\u08b9\u0003\u0116\u008b\u0000\u08b8\u08ba\u0003\u00cae\u0000\u08b9\u08b8"+
		"\u0001\u0000\u0000\u0000\u08b9\u08ba\u0001\u0000\u0000\u0000\u08ba\u08bb"+
		"\u0001\u0000\u0000\u0000\u08bb\u08bc\u0003f3\u0000\u08bc\u08c0\u0001\u0000"+
		"\u0000\u0000\u08bd\u08be\u0005x\u0000\u0000\u08be\u08c0\u0003\u0116\u008b"+
		"\u0000\u08bf\u08ac\u0001\u0000\u0000\u0000\u08bf\u08b6\u0001\u0000\u0000"+
		"\u0000\u08bf\u08bd\u0001\u0000\u0000\u0000\u08c0\u00ff\u0001\u0000\u0000"+
		"\u0000\u08c1\u08c6\u0005\u000b\u0000\u0000\u08c2\u08c5\u0003\u0102\u0081"+
		"\u0000\u08c3\u08c5\u0003\b\u0004\u0000\u08c4\u08c2\u0001\u0000\u0000\u0000"+
		"\u08c4\u08c3\u0001\u0000\u0000\u0000\u08c5\u08c8\u0001\u0000\u0000\u0000"+
		"\u08c6\u08c4\u0001\u0000\u0000\u0000\u08c6\u08c7\u0001\u0000\u0000\u0000"+
		"\u08c7\u08c9\u0001\u0000\u0000\u0000\u08c8\u08c6\u0001\u0000\u0000\u0000"+
		"\u08c9\u08ca\u0005\f\u0000\u0000\u08ca\u0101\u0001\u0000\u0000\u0000\u08cb"+
		"\u08cd\u0003\u0104\u0082\u0000\u08cc\u08cb\u0001\u0000\u0000\u0000\u08cc"+
		"\u08cd\u0001\u0000\u0000\u0000\u08cd\u08ce\u0001\u0000\u0000\u0000\u08ce"+
		"\u08cf\u0003\u0096K\u0000\u08cf\u0103\u0001\u0000\u0000\u0000\u08d0\u08d1"+
		"\u0003\u0126\u0093\u0000\u08d1\u08d2\u0005\u0006\u0000\u0000\u08d2\u08dc"+
		"\u0001\u0000\u0000\u0000\u08d3\u08d4\u0005\u0082\u0000\u0000\u08d4\u08dc"+
		"\u0005\u0006\u0000\u0000\u08d5\u08d6\u0003\u012c\u0096\u0000\u08d6\u08d7"+
		"\u0005\u0006\u0000\u0000\u08d7\u08dc\u0001\u0000\u0000\u0000\u08d8\u08d9"+
		"\u0003\u010e\u0087\u0000\u08d9\u08da\u0005\u0006\u0000\u0000\u08da\u08dc"+
		"\u0001\u0000\u0000\u0000\u08db\u08d0\u0001\u0000\u0000\u0000\u08db\u08d3"+
		"\u0001\u0000\u0000\u0000\u08db\u08d5\u0001\u0000\u0000\u0000\u08db\u08d8"+
		"\u0001\u0000\u0000\u0000\u08dc\u0105\u0001\u0000\u0000\u0000\u08dd\u08de"+
		"\u0005\u0007\u0000\u0000\u08de\u08f2\u0005\b\u0000\u0000\u08df\u08e0\u0005"+
		"\u0007\u0000\u0000\u08e0\u08e3\u0003\u0108\u0084\u0000\u08e1\u08e2\u0005"+
		"\u0002\u0000\u0000\u08e2\u08e4\u0003\u0108\u0084\u0000\u08e3\u08e1\u0001"+
		"\u0000\u0000\u0000\u08e4\u08e5\u0001\u0000\u0000\u0000\u08e5\u08e3\u0001"+
		"\u0000\u0000\u0000\u08e5\u08e6\u0001\u0000\u0000\u0000\u08e6\u08e8\u0001"+
		"\u0000\u0000\u0000\u08e7\u08e9\u0005\u0002\u0000\u0000\u08e8\u08e7\u0001"+
		"\u0000\u0000\u0000\u08e8\u08e9\u0001\u0000\u0000\u0000\u08e9\u08ea\u0001"+
		"\u0000\u0000\u0000\u08ea\u08eb\u0005\b\u0000\u0000\u08eb\u08f2\u0001\u0000"+
		"\u0000\u0000\u08ec\u08ed\u0005\u0007\u0000\u0000\u08ed\u08ee\u0003\u0108"+
		"\u0084\u0000\u08ee\u08ef\u0005\u0002\u0000\u0000\u08ef\u08f0\u0005\b\u0000"+
		"\u0000\u08f0\u08f2\u0001\u0000\u0000\u0000\u08f1\u08dd\u0001\u0000\u0000"+
		"\u0000\u08f1\u08df\u0001\u0000\u0000\u0000\u08f1\u08ec\u0001\u0000\u0000"+
		"\u0000\u08f2\u0107\u0001\u0000\u0000\u0000\u08f3\u08f5\u0003\u010a\u0085"+
		"\u0000\u08f4\u08f3\u0001\u0000\u0000\u0000\u08f4\u08f5\u0001\u0000\u0000"+
		"\u0000\u08f5\u08f6\u0001\u0000\u0000\u0000\u08f6\u08f7\u0003\u0096K\u0000"+
		"\u08f7\u0109\u0001\u0000\u0000\u0000\u08f8\u08f9\u0003\u0126\u0093\u0000"+
		"\u08f9\u08fa\u0005\u0006\u0000\u0000\u08fa\u0901\u0001\u0000\u0000\u0000"+
		"\u08fb\u08fc\u0005\u0082\u0000\u0000\u08fc\u0901\u0005\u0006\u0000\u0000"+
		"\u08fd\u08fe\u0003\u012c\u0096\u0000\u08fe\u08ff\u0005\u0006\u0000\u0000"+
		"\u08ff\u0901\u0001\u0000\u0000\u0000\u0900\u08f8\u0001\u0000\u0000\u0000"+
		"\u0900\u08fb\u0001\u0000\u0000\u0000\u0900\u08fd\u0001\u0000\u0000\u0000"+
		"\u0901\u010b\u0001\u0000\u0000\u0000\u0902\u0904\u0005S\u0000\u0000\u0903"+
		"\u0902\u0001\u0000\u0000\u0000\u0903\u0904\u0001\u0000\u0000\u0000\u0904"+
		"\u0905\u0001\u0000\u0000\u0000\u0905\u0906\u0003\u010e\u0087\u0000\u0906"+
		"\u010d\u0001\u0000\u0000\u0000\u0907\u0913\u0005\t\u0000\u0000\u0908\u090d"+
		"\u0003\u0110\u0088\u0000\u0909\u090a\u0005\u0002\u0000\u0000\u090a\u090c"+
		"\u0003\u0110\u0088\u0000\u090b\u0909\u0001\u0000\u0000\u0000\u090c\u090f"+
		"\u0001\u0000\u0000\u0000\u090d\u090b\u0001\u0000\u0000\u0000\u090d\u090e"+
		"\u0001\u0000\u0000\u0000\u090e\u0911\u0001\u0000\u0000\u0000\u090f\u090d"+
		"\u0001\u0000\u0000\u0000\u0910\u0912\u0005\u0002\u0000\u0000\u0911\u0910"+
		"\u0001\u0000\u0000\u0000\u0911\u0912\u0001\u0000\u0000\u0000\u0912\u0914"+
		"\u0001\u0000\u0000\u0000\u0913\u0908\u0001\u0000\u0000\u0000\u0913\u0914"+
		"\u0001\u0000\u0000\u0000\u0914\u0915\u0001\u0000\u0000\u0000\u0915\u0926"+
		"\u0005\n\u0000\u0000\u0916\u0922\u0005\u000f\u0000\u0000\u0917\u091c\u0003"+
		"\u0110\u0088\u0000\u0918\u0919\u0005\u0002\u0000\u0000\u0919\u091b\u0003"+
		"\u0110\u0088\u0000\u091a\u0918\u0001\u0000\u0000\u0000\u091b\u091e\u0001"+
		"\u0000\u0000\u0000\u091c\u091a\u0001\u0000\u0000\u0000\u091c\u091d\u0001"+
		"\u0000\u0000\u0000\u091d\u0920\u0001\u0000\u0000\u0000\u091e\u091c\u0001"+
		"\u0000\u0000\u0000\u091f\u0921\u0005\u0002\u0000\u0000\u0920\u091f\u0001"+
		"\u0000\u0000\u0000\u0920\u0921\u0001\u0000\u0000\u0000\u0921\u0923\u0001"+
		"\u0000\u0000\u0000\u0922\u0917\u0001\u0000\u0000\u0000\u0922\u0923\u0001"+
		"\u0000\u0000\u0000\u0923\u0924\u0001\u0000\u0000\u0000\u0924\u0926\u0005"+
		"\u0010\u0000\u0000\u0925\u0907\u0001\u0000\u0000\u0000\u0925\u0916\u0001"+
		"\u0000\u0000\u0000\u0926\u010f\u0001\u0000\u0000\u0000\u0927\u0952\u0005"+
		"\u0006\u0000\u0000\u0928\u0952\u0003\u0096K\u0000\u0929\u092a\u0003\u0096"+
		"K\u0000\u092a\u092b\u0005\u0006\u0000\u0000\u092b\u0952\u0001\u0000\u0000"+
		"\u0000\u092c\u092d\u0005\u0006\u0000\u0000\u092d\u0952\u0003\u0096K\u0000"+
		"\u092e\u092f\u0003\u0096K\u0000\u092f\u0930\u0005\u0006\u0000\u0000\u0930"+
		"\u0931\u0003\u0096K\u0000\u0931\u0952\u0001\u0000\u0000\u0000\u0932\u0952"+
		"\u0003\u011c\u008e\u0000\u0933\u0934\u0003\u0096K\u0000\u0934\u0935\u0003"+
		"\u011c\u008e\u0000\u0935\u0952\u0001\u0000\u0000\u0000\u0936\u0937\u0005"+
		"\u0006\u0000\u0000\u0937\u0938\u0003\u0096K\u0000\u0938\u0939\u0005\u0006"+
		"\u0000\u0000\u0939\u0952\u0001\u0000\u0000\u0000\u093a\u093b\u0003\u011c"+
		"\u008e\u0000\u093b\u093c\u0003\u0096";
	private static final String _serializedATNSegment1 =
		"K\u0000\u093c\u0952\u0001\u0000\u0000\u0000\u093d\u093e\u0003\u0096K\u0000"+
		"\u093e\u093f\u0005\u0006\u0000\u0000\u093f\u0940\u0003\u0096K\u0000\u0940"+
		"\u0941\u0005\u0006\u0000\u0000\u0941\u0952\u0001\u0000\u0000\u0000\u0942"+
		"\u0943\u0005\u0006\u0000\u0000\u0943\u0944\u0003\u0096K\u0000\u0944\u0945"+
		"\u0005\u0006\u0000\u0000\u0945\u0946\u0003\u0096K\u0000\u0946\u0952\u0001"+
		"\u0000\u0000\u0000\u0947\u0948\u0003\u0096K\u0000\u0948\u0949\u0003\u011c"+
		"\u008e\u0000\u0949\u094a\u0003\u0096K\u0000\u094a\u0952\u0001\u0000\u0000"+
		"\u0000\u094b\u094c\u0003\u0096K\u0000\u094c\u094d\u0005\u0006\u0000\u0000"+
		"\u094d\u094e\u0003\u0096K\u0000\u094e\u094f\u0005\u0006\u0000\u0000\u094f"+
		"\u0950\u0003\u0096K\u0000\u0950\u0952\u0001\u0000\u0000\u0000\u0951\u0927"+
		"\u0001\u0000\u0000\u0000\u0951\u0928\u0001\u0000\u0000\u0000\u0951\u0929"+
		"\u0001\u0000\u0000\u0000\u0951\u092c\u0001\u0000\u0000\u0000\u0951\u092e"+
		"\u0001\u0000\u0000\u0000\u0951\u0932\u0001\u0000\u0000\u0000\u0951\u0933"+
		"\u0001\u0000\u0000\u0000\u0951\u0936\u0001\u0000\u0000\u0000\u0951\u093a"+
		"\u0001\u0000\u0000\u0000\u0951\u093d\u0001\u0000\u0000\u0000\u0951\u0942"+
		"\u0001\u0000\u0000\u0000\u0951\u0947\u0001\u0000\u0000\u0000\u0951\u094b"+
		"\u0001\u0000\u0000\u0000\u0952\u0111\u0001\u0000\u0000\u0000\u0953\u0955"+
		"\u0003\u0126\u0093\u0000\u0954\u0953\u0001\u0000\u0000\u0000\u0955\u0958"+
		"\u0001\u0000\u0000\u0000\u0956\u0954\u0001\u0000\u0000\u0000\u0956\u0957"+
		"\u0001\u0000\u0000\u0000\u0957\u0113\u0001\u0000\u0000\u0000\u0958\u0956"+
		"\u0001\u0000\u0000\u0000\u0959\u095b\u0003\u0126\u0093\u0000\u095a\u0959"+
		"\u0001\u0000\u0000\u0000\u095b\u095e\u0001\u0000\u0000\u0000\u095c\u095a"+
		"\u0001\u0000\u0000\u0000\u095c\u095d\u0001\u0000\u0000\u0000\u095d\u095f"+
		"\u0001\u0000\u0000\u0000\u095e\u095c\u0001\u0000\u0000\u0000\u095f\u0960"+
		"\u0003\u0126\u0093\u0000\u0960\u0115\u0001\u0000\u0000\u0000\u0961\u0963"+
		"\u0003\u0126\u0093\u0000\u0962\u0961\u0001\u0000\u0000\u0000\u0963\u0966"+
		"\u0001\u0000\u0000\u0000\u0964\u0962\u0001\u0000\u0000\u0000\u0964\u0965"+
		"\u0001\u0000\u0000\u0000\u0965\u0967\u0001\u0000\u0000\u0000\u0966\u0964"+
		"\u0001\u0000\u0000\u0000\u0967\u096d\u0003\u0126\u0093\u0000\u0968\u0969"+
		"\u0003\u0124\u0092\u0000\u0969\u096a\u0003\u0126\u0093\u0000\u096a\u096c"+
		"\u0001\u0000\u0000\u0000\u096b\u0968\u0001\u0000\u0000\u0000\u096c\u096f"+
		"\u0001\u0000\u0000\u0000\u096d\u096b\u0001\u0000\u0000\u0000\u096d\u096e"+
		"\u0001\u0000\u0000\u0000\u096e\u0117\u0001\u0000\u0000\u0000\u096f\u096d"+
		"\u0001\u0000\u0000\u0000\u0970\u0973\u0005N\u0000\u0000\u0971\u0974\u0003"+
		"\u0126\u0093\u0000\u0972\u0974\u0003\u0128\u0094\u0000\u0973\u0971\u0001"+
		"\u0000\u0000\u0000\u0973\u0972\u0001\u0000\u0000\u0000\u0973\u0974\u0001"+
		"\u0000\u0000\u0000\u0974\u0119\u0001\u0000\u0000\u0000\u0975\u0976\u0007"+
		"\u0016\u0000\u0000\u0976\u097c\u0005\u0082\u0000\u0000\u0977\u0979\u0005"+
		"i\u0000\u0000\u0978\u097a\u0005\u0082\u0000\u0000\u0979\u0978\u0001\u0000"+
		"\u0000\u0000\u0979\u097a\u0001\u0000\u0000\u0000\u097a\u097c\u0001\u0000"+
		"\u0000\u0000\u097b\u0975\u0001\u0000\u0000\u0000\u097b\u0977\u0001\u0000"+
		"\u0000\u0000\u097c\u011b\u0001\u0000\u0000\u0000\u097d\u0981\u0005\u0005"+
		"\u0000\u0000\u097e\u097f\u0005\u0006\u0000\u0000\u097f\u0981\u0005\u0006"+
		"\u0000\u0000\u0980\u097d\u0001\u0000\u0000\u0000\u0980\u097e\u0001\u0000"+
		"\u0000\u0000\u0981\u011d\u0001\u0000\u0000\u0000\u0982\u0988\u0003\u0126"+
		"\u0093\u0000\u0983\u0984\u0003\u0120\u0090\u0000\u0984\u0985\u0003\u0126"+
		"\u0093\u0000\u0985\u0987\u0001\u0000\u0000\u0000\u0986\u0983\u0001\u0000"+
		"\u0000\u0000\u0987\u098a\u0001\u0000\u0000\u0000\u0988\u0986\u0001\u0000"+
		"\u0000\u0000\u0988\u0989\u0001\u0000\u0000\u0000\u0989\u011f\u0001\u0000"+
		"\u0000\u0000\u098a\u0988\u0001\u0000\u0000\u0000\u098b\u098c\u0007\u0017"+
		"\u0000\u0000\u098c\u0121\u0001\u0000\u0000\u0000\u098d\u0993\u0003\u0126"+
		"\u0093\u0000\u098e\u098f\u0003\u0124\u0092\u0000\u098f\u0990\u0003\u0126"+
		"\u0093\u0000\u0990\u0992\u0001\u0000\u0000\u0000\u0991\u098e\u0001\u0000"+
		"\u0000\u0000\u0992\u0995\u0001\u0000\u0000\u0000\u0993\u0991\u0001\u0000"+
		"\u0000\u0000\u0993\u0994\u0001\u0000\u0000\u0000\u0994\u0123\u0001\u0000"+
		"\u0000\u0000\u0995\u0993\u0001\u0000\u0000\u0000\u0996\u0997\u0005\u0005"+
		"\u0000\u0000\u0997\u0125\u0001\u0000\u0000\u0000\u0998\u0999\u0007\u0018"+
		"\u0000\u0000\u0999\u0127\u0001\u0000\u0000\u0000\u099a\u099b\u0007\u0019"+
		"\u0000\u0000\u099b\u0129\u0001\u0000\u0000\u0000\u099c\u099e\u0003\u0128"+
		"\u0094\u0000\u099d\u099f\u0003\u0126\u0093\u0000\u099e\u099d\u0001\u0000"+
		"\u0000\u0000\u099e\u099f\u0001\u0000\u0000\u0000\u099f\u012b\u0001\u0000"+
		"\u0000\u0000\u09a0\u09a4\u0005\u0084\u0000\u0000\u09a1\u09a3\u0005\u0096"+
		"\u0000\u0000\u09a2\u09a1\u0001\u0000\u0000\u0000\u09a3\u09a6\u0001\u0000"+
		"\u0000\u0000\u09a4\u09a2\u0001\u0000\u0000\u0000\u09a4\u09a5\u0001\u0000"+
		"\u0000\u0000\u09a5\u09a7\u0001\u0000\u0000\u0000\u09a6\u09a4\u0001\u0000"+
		"\u0000\u0000\u09a7\u09a8\u0005\u0097\u0000\u0000\u09a8\u012d\u0001\u0000"+
		"\u0000\u0000\u09a9\u09ab\u0003\u0126\u0093\u0000\u09aa\u09a9\u0001\u0000"+
		"\u0000\u0000\u09aa\u09ab\u0001\u0000\u0000\u0000\u09ab\u09ac\u0001\u0000"+
		"\u0000\u0000\u09ac\u09ad\u0003\u012c\u0096\u0000\u09ad\u012f\u0001\u0000"+
		"\u0000\u0000\u0157\u0132\u0134\u013c\u013e\u0151\u015a\u0161\u0166\u016e"+
		"\u0174\u0179\u017f\u0181\u0187\u018e\u0198\u019c\u01a5\u01ab\u01b2\u01b8"+
		"\u01c0\u01c8\u01cc\u01d3\u01d8\u01df\u01e2\u01e5\u01e9\u01ef\u01f9\u0203"+
		"\u0207\u020b\u0210\u0217\u021c\u021f\u0224\u0229\u022d\u0230\u0235\u023c"+
		"\u0241\u0248\u024b\u024f\u0255\u025f\u0266\u026a\u026d\u0272\u0279\u027c"+
		"\u0284\u028c\u0292\u0297\u029e\u02a1\u02a4\u02aa\u02b2\u02ba\u02be\u02c4"+
		"\u02c6\u02ce\u02d5\u02d8\u02e0\u02e8\u02ed\u02f3\u02f6\u02fb\u0302\u0306"+
		"\u0312\u0317\u031c\u0322\u0327\u032a\u032d\u0332\u0338\u033d\u0340\u0344"+
		"\u0349\u034c\u034f\u035d\u0361\u0363\u0366\u036c\u0370\u0375\u0378\u037c"+
		"\u0380\u0382\u0385\u038a\u038c\u038f\u0394\u0399\u039c\u039f\u03a3\u03a7"+
		"\u03aa\u03ac\u03b6\u03ba\u03be\u03c3\u03c9\u03d3\u03d7\u03dc\u03e2\u03ea"+
		"\u03f5\u03fa\u0400\u0404\u0408\u040f\u0413\u041e\u0421\u0423\u042d\u0431"+
		"\u0433\u0438\u0440\u0444\u0446\u044a\u0452\u0456\u0458\u045b\u0460\u0465"+
		"\u046b\u0470\u0474\u0478\u047b\u047f\u0482\u0487\u048e\u0496\u049d\u04a1"+
		"\u04a9\u04b0\u04b9\u04be\u04c3\u04cb\u04d4\u04dc\u04e6\u04eb\u04f0\u04f3"+
		"\u04fa\u0503\u050a\u0512\u0515\u051a\u0520\u0523\u0530\u0535\u0538\u0559"+
		"\u059a\u059c\u05a2\u05b7\u05e3\u05e5\u05f5\u05f8\u05fa\u0600\u0613\u0615"+
		"\u061f\u0623\u0626\u062b\u0630\u0634\u0639\u063c\u0646\u0648\u066c\u0671"+
		"\u0678\u0682\u0686\u068b\u0690\u0698\u069c\u06a0\u06a5\u06a9\u06ac\u06b8"+
		"\u06bc\u06c8\u06cc\u06d0\u06d3\u06db\u06df\u06e1\u06ea\u06ee\u06f0\u06f3"+
		"\u06f8\u0702\u070c\u0710\u0718\u071c\u0726\u072a\u072e\u0736\u073e\u0747"+
		"\u0750\u075a\u075f\u0761\u076b\u076e\u0779\u077d\u077f\u0782\u0789\u078d"+
		"\u0790\u0795\u079a\u07a1\u07a8\u07ac\u07b3\u07bc\u07be\u07c4\u07cb\u07cd"+
		"\u07d4\u07dc\u07e6\u07ea\u07ec\u07f2\u07f9\u0800\u080a\u0812\u0819\u081d"+
		"\u0823\u082f\u0831\u083e\u0844\u084a\u084d\u0852\u0857\u0866\u0869\u0874"+
		"\u0878\u087d\u0885\u0889\u088e\u0896\u089a\u089e\u08a2\u08a5\u08a8\u08af"+
		"\u08b2\u08b9\u08bf\u08c4\u08c6\u08cc\u08db\u08e5\u08e8\u08f1\u08f4\u0900"+
		"\u0903\u090d\u0911\u0913\u091c\u0920\u0922\u0925\u0951\u0956\u095c\u0964"+
		"\u096d\u0973\u0979\u097b\u0980\u0988\u0993\u099e\u09a4\u09aa";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}