// Generated from C:/Users/Dell/IdeaProjects/valkyrie-intellij/src/main/antlr/ValkyrieAntlr.g4 by ANTLR 4.13.1
package valkyrie.language.antlr;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ValkyrieAntlrParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    public static final int
            T__0 = 1, DOT = 2, COMMA = 3, SEMICOLON = 4, FAKE_COLON = 5, OP_PROPORTION = 6, COLON = 7,
            PARENTHESES_L = 8, PARENTHESES_R = 9, BRACKET_L = 10, BRACKET_R = 11, BRACE_L = 12,
            BRACE_R = 13, GENERIC_L = 14, GENERIC_R = 15, OFFSET_L = 16, OFFSET_R = 17, RANGE_L = 18,
            RANGE_R = 19, CEILING_L = 20, CEILING_R = 21, FLOOR_L = 22, FLOOR_R = 23, COLLECTION_L = 24,
            COLLECTION_R = 25, OP_ADD = 26, OP_SUB = 27, OP_INC = 28, OP_DEC = 29, OP_MUL = 30,
            OP_DIV = 31, OP_REM = 32, OP_DIV_REM = 33, OP_LAST = 34, OP_EQ = 35, OP_NE = 36, OP_NEE = 37,
            OP_EEE = 38, OP_LEQ = 39, OP_LLE = 40, OP_LLL = 41, OP_LL = 42, OP_LT = 43, OP_GEQ = 44,
            OP_GGE = 45, OP_GGG = 46, OP_GG = 47, OP_GT = 48, OP_LEFT = 49, OP_ARROW = 50, OP_ARROW2 = 51,
            OP_ARROW3 = 52, OP_ASSIGN = 53, OP_BIND = 54, OP_MAY_ASSIGN = 55, OP_ADD_ASSIGN = 56,
            OP_SUB_ASSIGN = 57, OP_MUL_ASSIGN = 58, OP_DIV_ASSIGN = 59, LOGIC_NOT = 60, LOGIC_AND = 61,
            LOGIC_XAND = 62, LOGIC_NAND = 63, LOGIC_OR = 64, LOGIC_XOR = 65, LOGIC_NOR = 66,
            SET_INTERSECTION = 67, SET_UNION = 68, OP_AND = 69, OP_OR = 70, OP_IMPL = 71, OP_IFF = 72,
            OP_MAP = 73, OP_APPLY2 = 74, OP_APPLY3 = 75, OP_AT = 76, OP_HASH = 77, LAMBDA_SLOT = 78,
            MACRO_SLOT = 79, OP_UNIMPLEMENTED = 80, OP_OR_DEFAULT = 81, OP_OR_ELSE = 82, OP_AND_THEN = 83,
            OP_NOT = 84, KW_NOT = 85, OP_IN = 86, KW_IN = 87, OP_NOT_IN = 88, OP_CONTINUES = 89,
            KW_IS = 90, OP_IS = 91, OP_IS_NOT = 92, KW_AS = 93, OP_DOT3 = 94, OP_DOT2 = 95, OP_UNTIL = 96,
            OP_POW = 97, OP_INVERSE = 98, OP_ROOT2 = 99, OP_ROOT3 = 100, OP_ROOT4 = 101, OP_TEMPERATURE = 102,
            OP_TRANSPOSE = 103, OP_PERCENT = 104, OP_REFERENCE = 105, OP_LABEL = 106, KW_NAMESPACE = 107,
            KW_IMPORT = 108, KW_EXTENSION = 109, KW_CLASS = 110, KW_TRAIT = 111, KW_UNION = 112,
            KW_BITFLAGS = 113, KW_TYPE = 114, KW_TEMPLATE = 115, KW_EXTENDS = 116, KW_IMPLEMENTS = 117,
            KW_WHILE = 118, KW_FOR = 119, KW_LET = 120, KW_WITCH = 121, KW_NEW = 122, KW_OBJECT = 123,
            KW_LAMBDA = 124, KW_FUNCTION = 125, KW_TRY = 126, KW_MATCH = 127, KW_CATCH = 128,
            KW_WITH = 129, KW_CASE = 130, KW_WHEN = 131, INTEGER = 132, DECIMAL = 133, STRING_SINGLE = 134,
            STRING_DOUBLE = 135, STRING_BLOCK = 136, KW_IF = 137, KW_ELSE = 138, KW_OTHERWISE = 139,
            RETURN = 140, RESUME = 141, YIELD = 142, BREAK = 143, CONTINUE = 144, RAISE = 145,
            SPECIAL = 146, RAW_ID = 147, UNICODE_ID = 148, LINE_COMMENT = 149, BLOCK_COMMENT = 150,
            WHITE_SPACE = 151, ERROR_CHARACTAR = 152;
    public static final int
            RULE_program = 0, RULE_eos = 1, RULE_eos_free = 2, RULE_define_namespace = 3,
            RULE_import_statement = 4, RULE_import_as = 5, RULE_import_term = 6, RULE_import_name = 7,
            RULE_import_block = 8, RULE_define_extension = 9, RULE_define_class = 10,
            RULE_class_block = 11, RULE_class_inherit = 12, RULE_class_inherit_item = 13,
            RULE_class_field = 14, RULE_class_method = 15, RULE_class_dsl = 16, RULE_define_trait = 17,
            RULE_trait_block = 18, RULE_define_trait_type = 19, RULE_define_extends = 20,
            RULE_extends_block = 21, RULE_with_implements = 22, RULE_define_union = 23,
            RULE_base_layout = 24, RULE_union_block = 25, RULE_define_variant = 26,
            RULE_variant_block = 27, RULE_define_bitflags = 28, RULE_bitflags_block = 29,
            RULE_bitflags_item = 30, RULE_define_function = 31, RULE_function_parameters = 32,
            RULE_parameter_item = 33, RULE_return_type = 34, RULE_parameter_default = 35,
            RULE_function_call = 36, RULE_tuple_call_body = 37, RULE_tuple_call_item = 38,
            RULE_define_lambda = 39, RULE_function_block = 40, RULE_let_binding = 41,
            RULE_let_pattern = 42, RULE_let_pattern_plain = 43, RULE_let_pattern_tuple = 44,
            RULE_let_pattern_item = 45, RULE_define_type = 46, RULE_type_hint = 47,
            RULE_if_statement = 48, RULE_guard_statement = 49, RULE_else_if_statement = 50,
            RULE_loop_statement = 51, RULE_if_guard = 52, RULE_expression_root = 53,
            RULE_expression = 54, RULE_inline_expression = 55, RULE_type_expression = 56,
            RULE_atomic = 57, RULE_control_expression = 58, RULE_op_prefix = 59, RULE_op_suffix = 60,
            RULE_op_compare = 61, RULE_op_pattern = 62, RULE_infix_map = 63, RULE_infix_pow = 64,
            RULE_infix_range = 65, RULE_infix_arrows = 66, RULE_op_multiple = 67,
            RULE_op_plus = 68, RULE_op_logic = 69, RULE_op_pipeline = 70, RULE_op_assign = 71,
            RULE_infix_is = 72, RULE_infix_as = 73, RULE_infix_in = 74, RULE_define_generic = 75,
            RULE_generic_item = 76, RULE_generic_call = 77, RULE_generic_call_in_type = 78,
            RULE_generic_pair = 79, RULE_define_label = 80, RULE_template_call = 81,
            RULE_template_block = 82, RULE_template_statements = 83, RULE_where_block = 84,
            RULE_where_bound = 85, RULE_require_block = 86, RULE_macro_call = 87,
            RULE_annotation = 88, RULE_annotation_call_item = 89, RULE_try_statement = 90,
            RULE_match_statement = 91, RULE_match_block = 92, RULE_match_terms = 93,
            RULE_match_case_block = 94, RULE_case_pattern = 95, RULE_case_pattern_item = 96,
            RULE_case_pattern_tuple = 97, RULE_object_statement = 98, RULE_new_statement = 99,
            RULE_new_body = 100, RULE_new_block = 101, RULE_tuple_literal = 102, RULE_collection_pair = 103,
            RULE_slice_call = 104, RULE_range_literal = 105, RULE_range_axis = 106,
            RULE_modifiers = 107, RULE_modified_identifier = 108, RULE_modified_namepath = 109,
            RULE_lambda_name = 110, RULE_output_name = 111, RULE_namepath_free = 112,
            RULE_namepath = 113, RULE_identifier = 114, RULE_number = 115, RULE_number_literal = 116,
            RULE_string = 117, RULE_string_literal = 118;

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "eos", "eos_free", "define_namespace", "import_statement",
                "import_as", "import_term", "import_name", "import_block", "define_extension",
                "define_class", "class_block", "class_inherit", "class_inherit_item",
                "class_field", "class_method", "class_dsl", "define_trait", "trait_block",
                "define_trait_type", "define_extends", "extends_block", "with_implements",
                "define_union", "base_layout", "union_block", "define_variant", "variant_block",
                "define_bitflags", "bitflags_block", "bitflags_item", "define_function",
                "function_parameters", "parameter_item", "return_type", "parameter_default",
                "function_call", "tuple_call_body", "tuple_call_item", "define_lambda",
                "function_block", "let_binding", "let_pattern", "let_pattern_plain",
                "let_pattern_tuple", "let_pattern_item", "define_type", "type_hint",
                "if_statement", "guard_statement", "else_if_statement", "loop_statement",
                "if_guard", "expression_root", "expression", "inline_expression", "type_expression",
                "atomic", "control_expression", "op_prefix", "op_suffix", "op_compare",
                "op_pattern", "infix_map", "infix_pow", "infix_range", "infix_arrows",
                "op_multiple", "op_plus", "op_logic", "op_pipeline", "op_assign", "infix_is",
                "infix_as", "infix_in", "define_generic", "generic_item", "generic_call",
                "generic_call_in_type", "generic_pair", "define_label", "template_call",
                "template_block", "template_statements", "where_block", "where_bound",
                "require_block", "macro_call", "annotation", "annotation_call_item",
                "try_statement", "match_statement", "match_block", "match_terms", "match_case_block",
                "case_pattern", "case_pattern_item", "case_pattern_tuple", "object_statement",
                "new_statement", "new_body", "new_block", "tuple_literal", "collection_pair",
                "slice_call", "range_literal", "range_axis", "modifiers", "modified_identifier",
                "modified_namepath", "lambda_name", "output_name", "namepath_free", "namepath",
                "identifier", "number", "number_literal", "string", "string_literal"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'where'", "'.'", null, "';'", null, null, null, "'('", "')'",
                "'['", "']'", "'{'", "'}'", "'\\u27E8'", "'\\u27E9'", "'\\u2045'", "'\\u2046'",
                "'\\u27E6'", "'\\u27E7'", "'\\u2308'", "'\\u2309'", "'\\u230A'", "'\\u230B'",
                "'\\u2983'", "'\\u2984'", "'+'", "'-'", "'++'", "'--'", "'*'", null,
                null, null, "'%%'", "'=='", null, null, null, null, "'<<='", null, null,
                "'<'", null, "'>>='", null, null, "'>'", null, null, null, "'==>'", "'='",
                null, "'?='", "'+='", "'-='", "'*='", "'/='", "'\\u00AC'", null, "'\\u2A5F'",
                "'\\u22BC'", null, "'\\u22BB'", "'\\u22BD'", "'\\u2229'", "'\\u222A'",
                "'&'", "'|'", "'\\u203D'", "'\\u21D4'", null, null, null, "'@'", null,
                null, null, null, "'??'", "'?:'", "'?'", "'!'", "'not'", null, "'in'",
                "'\\u2209'", null, "'is'", null, null, null, null, null, null, "'^'",
                "'\\u215F'", "'\\u221A'", "'\\u221B'", "'\\u221C'", null, null, null,
                "'\\u203B'", "'\\u00B6'", null, null, "'extension'", null, null, "'union'",
                "'flags'", "'type'", "'template'", "'extends'", "'implements'", null,
                "'for'", "'let'", "'which'", "'new'", "'object'", "'lambda'", null, "'try'",
                "'match'", "'catch'", "'with'", "'case'", "'when'", null, null, null,
                null, null, "'if'", "'else'", "'otherwise'", "'return'", "'resume'",
                "'yield'", "'break'", "'continue'", "'raise'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, null, "DOT", "COMMA", "SEMICOLON", "FAKE_COLON", "OP_PROPORTION",
                "COLON", "PARENTHESES_L", "PARENTHESES_R", "BRACKET_L", "BRACKET_R",
                "BRACE_L", "BRACE_R", "GENERIC_L", "GENERIC_R", "OFFSET_L", "OFFSET_R",
                "RANGE_L", "RANGE_R", "CEILING_L", "CEILING_R", "FLOOR_L", "FLOOR_R",
                "COLLECTION_L", "COLLECTION_R", "OP_ADD", "OP_SUB", "OP_INC", "OP_DEC",
                "OP_MUL", "OP_DIV", "OP_REM", "OP_DIV_REM", "OP_LAST", "OP_EQ", "OP_NE",
                "OP_NEE", "OP_EEE", "OP_LEQ", "OP_LLE", "OP_LLL", "OP_LL", "OP_LT", "OP_GEQ",
                "OP_GGE", "OP_GGG", "OP_GG", "OP_GT", "OP_LEFT", "OP_ARROW", "OP_ARROW2",
                "OP_ARROW3", "OP_ASSIGN", "OP_BIND", "OP_MAY_ASSIGN", "OP_ADD_ASSIGN",
                "OP_SUB_ASSIGN", "OP_MUL_ASSIGN", "OP_DIV_ASSIGN", "LOGIC_NOT", "LOGIC_AND",
                "LOGIC_XAND", "LOGIC_NAND", "LOGIC_OR", "LOGIC_XOR", "LOGIC_NOR", "SET_INTERSECTION",
                "SET_UNION", "OP_AND", "OP_OR", "OP_IMPL", "OP_IFF", "OP_MAP", "OP_APPLY2",
                "OP_APPLY3", "OP_AT", "OP_HASH", "LAMBDA_SLOT", "MACRO_SLOT", "OP_UNIMPLEMENTED",
                "OP_OR_DEFAULT", "OP_OR_ELSE", "OP_AND_THEN", "OP_NOT", "KW_NOT", "OP_IN",
                "KW_IN", "OP_NOT_IN", "OP_CONTINUES", "KW_IS", "OP_IS", "OP_IS_NOT",
                "KW_AS", "OP_DOT3", "OP_DOT2", "OP_UNTIL", "OP_POW", "OP_INVERSE", "OP_ROOT2",
                "OP_ROOT3", "OP_ROOT4", "OP_TEMPERATURE", "OP_TRANSPOSE", "OP_PERCENT",
                "OP_REFERENCE", "OP_LABEL", "KW_NAMESPACE", "KW_IMPORT", "KW_EXTENSION",
                "KW_CLASS", "KW_TRAIT", "KW_UNION", "KW_BITFLAGS", "KW_TYPE", "KW_TEMPLATE",
                "KW_EXTENDS", "KW_IMPLEMENTS", "KW_WHILE", "KW_FOR", "KW_LET", "KW_WITCH",
                "KW_NEW", "KW_OBJECT", "KW_LAMBDA", "KW_FUNCTION", "KW_TRY", "KW_MATCH",
                "KW_CATCH", "KW_WITH", "KW_CASE", "KW_WHEN", "INTEGER", "DECIMAL", "STRING_SINGLE",
                "STRING_DOUBLE", "STRING_BLOCK", "KW_IF", "KW_ELSE", "KW_OTHERWISE",
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
    public String getGrammarFileName() {
        return "ValkyrieAntlr.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public ValkyrieAntlrParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ProgramContext extends ParserRuleContext {
        public TerminalNode EOF() {
            return getToken(ValkyrieAntlrParser.EOF, 0);
        }

        public List<Define_namespaceContext> define_namespace() {
            return getRuleContexts(Define_namespaceContext.class);
        }

        public Define_namespaceContext define_namespace(int i) {
            return getRuleContext(Define_namespaceContext.class, i);
        }

        public List<Import_statementContext> import_statement() {
            return getRuleContexts(Import_statementContext.class);
        }

        public Import_statementContext import_statement(int i) {
            return getRuleContext(Import_statementContext.class, i);
        }

        public List<Define_extensionContext> define_extension() {
            return getRuleContexts(Define_extensionContext.class);
        }

        public Define_extensionContext define_extension(int i) {
            return getRuleContext(Define_extensionContext.class, i);
        }

        public List<Define_classContext> define_class() {
            return getRuleContexts(Define_classContext.class);
        }

        public Define_classContext define_class(int i) {
            return getRuleContext(Define_classContext.class, i);
        }

        public List<Define_unionContext> define_union() {
            return getRuleContexts(Define_unionContext.class);
        }

        public Define_unionContext define_union(int i) {
            return getRuleContext(Define_unionContext.class, i);
        }

        public List<Define_bitflagsContext> define_bitflags() {
            return getRuleContexts(Define_bitflagsContext.class);
        }

        public Define_bitflagsContext define_bitflags(int i) {
            return getRuleContext(Define_bitflagsContext.class, i);
        }

        public List<Define_traitContext> define_trait() {
            return getRuleContexts(Define_traitContext.class);
        }

        public Define_traitContext define_trait(int i) {
            return getRuleContext(Define_traitContext.class, i);
        }

        public List<Define_extendsContext> define_extends() {
            return getRuleContexts(Define_extendsContext.class);
        }

        public Define_extendsContext define_extends(int i) {
            return getRuleContext(Define_extendsContext.class, i);
        }

        public List<Define_functionContext> define_function() {
            return getRuleContexts(Define_functionContext.class);
        }

        public Define_functionContext define_function(int i) {
            return getRuleContext(Define_functionContext.class, i);
        }

        public List<Define_typeContext> define_type() {
            return getRuleContexts(Define_typeContext.class);
        }

        public Define_typeContext define_type(int i) {
            return getRuleContext(Define_typeContext.class, i);
        }

        public List<Let_bindingContext> let_binding() {
            return getRuleContexts(Let_bindingContext.class);
        }

        public Let_bindingContext let_binding(int i) {
            return getRuleContext(Let_bindingContext.class, i);
        }

        public List<Loop_statementContext> loop_statement() {
            return getRuleContexts(Loop_statementContext.class);
        }

        public Loop_statementContext loop_statement(int i) {
            return getRuleContext(Loop_statementContext.class, i);
        }

        public List<Guard_statementContext> guard_statement() {
            return getRuleContexts(Guard_statementContext.class);
        }

        public Guard_statementContext guard_statement(int i) {
            return getRuleContext(Guard_statementContext.class, i);
        }

        public List<Expression_rootContext> expression_root() {
            return getRuleContexts(Expression_rootContext.class);
        }

        public Expression_rootContext expression_root(int i) {
            return getRuleContext(Expression_rootContext.class, i);
        }

        public List<EosContext> eos() {
            return getRuleContexts(EosContext.class);
        }

        public EosContext eos(int i) {
            return getRuleContext(EosContext.class, i);
        }

        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterProgram(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitProgram(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitProgram(this);
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
                setState(255);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22755218736L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -8075235667417726079L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 65439L) != 0)) {
                    {
                        setState(253);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                            case 1: {
                                setState(238);
                                define_namespace();
                            }
                            break;
                            case 2: {
                                setState(239);
                                import_statement();
                            }
                            break;
                            case 3: {
                                setState(240);
                                define_extension();
                            }
                            break;
                            case 4: {
                                setState(241);
                                define_class();
                            }
                            break;
                            case 5: {
                                setState(242);
                                define_union();
                            }
                            break;
                            case 6: {
                                setState(243);
                                define_bitflags();
                            }
                            break;
                            case 7: {
                                setState(244);
                                define_trait();
                            }
                            break;
                            case 8: {
                                setState(245);
                                define_extends();
                            }
                            break;
                            case 9: {
                                setState(246);
                                define_function();
                            }
                            break;
                            case 10: {
                                setState(247);
                                define_type();
                            }
                            break;
                            case 11: {
                                setState(248);
                                let_binding();
                            }
                            break;
                            case 12: {
                                setState(249);
                                loop_statement();
                            }
                            break;
                            case 13: {
                                setState(250);
                                guard_statement();
                            }
                            break;
                            case 14: {
                                setState(251);
                                expression_root();
                            }
                            break;
                            case 15: {
                                setState(252);
                                eos();
                            }
                            break;
                        }
                    }
                    setState(257);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(258);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EosContext extends ParserRuleContext {
        public TerminalNode SEMICOLON() {
            return getToken(ValkyrieAntlrParser.SEMICOLON, 0);
        }

        public TerminalNode FAKE_COLON() {
            return getToken(ValkyrieAntlrParser.FAKE_COLON, 0);
        }

        public EosContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_eos;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEos(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEos(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEos(this);
            else return visitor.visitChildren(this);
        }
    }

    public final EosContext eos() throws RecognitionException {
        EosContext _localctx = new EosContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_eos);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(260);
                _la = _input.LA(1);
                if (!(_la == SEMICOLON || _la == FAKE_COLON)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Eos_freeContext extends ParserRuleContext {
        public TerminalNode COMMA() {
            return getToken(ValkyrieAntlrParser.COMMA, 0);
        }

        public TerminalNode SEMICOLON() {
            return getToken(ValkyrieAntlrParser.SEMICOLON, 0);
        }

        public TerminalNode FAKE_COLON() {
            return getToken(ValkyrieAntlrParser.FAKE_COLON, 0);
        }

        public Eos_freeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_eos_free;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEos_free(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEos_free(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEos_free(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Eos_freeContext eos_free() throws RecognitionException {
        Eos_freeContext _localctx = new Eos_freeContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_eos_free);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(262);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_namespaceContext extends ParserRuleContext {
        public TerminalNode KW_NAMESPACE() {
            return getToken(ValkyrieAntlrParser.KW_NAMESPACE, 0);
        }

        public Namepath_freeContext namepath_free() {
            return getRuleContext(Namepath_freeContext.class, 0);
        }

        public EosContext eos() {
            return getRuleContext(EosContext.class, 0);
        }

        public Define_namespaceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_namespace;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterDefine_namespace(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitDefine_namespace(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_namespace(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_namespaceContext define_namespace() throws RecognitionException {
        Define_namespaceContext _localctx = new Define_namespaceContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_define_namespace);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(264);
                match(KW_NAMESPACE);
                setState(265);
                namepath_free();
                setState(267);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                    case 1: {
                        setState(266);
                        eos();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Import_statementContext extends ParserRuleContext {
        public TerminalNode KW_IMPORT() {
            return getToken(ValkyrieAntlrParser.KW_IMPORT, 0);
        }

        public Import_termContext import_term() {
            return getRuleContext(Import_termContext.class, 0);
        }

        public Import_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_import_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterImport_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitImport_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitImport_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Import_statementContext import_statement() throws RecognitionException {
        Import_statementContext _localctx = new Import_statementContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_import_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(269);
                match(KW_IMPORT);
                setState(270);
                import_term();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Import_asContext extends ParserRuleContext {
        public TerminalNode KW_AS() {
            return getToken(ValkyrieAntlrParser.KW_AS, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode OP_AT() {
            return getToken(ValkyrieAntlrParser.OP_AT, 0);
        }

        public TerminalNode OP_HASH() {
            return getToken(ValkyrieAntlrParser.OP_HASH, 0);
        }

        public Import_asContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_import_as;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterImport_as(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitImport_as(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitImport_as(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Import_asContext import_as() throws RecognitionException {
        Import_asContext _localctx = new Import_asContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_import_as);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(272);
                match(KW_AS);
                setState(274);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OP_AT || _la == OP_HASH) {
                    {
                        setState(273);
                        _la = _input.LA(1);
                        if (!(_la == OP_AT || _la == OP_HASH)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                }

                setState(276);
                identifier();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Import_termContext extends ParserRuleContext {
        public Import_blockContext import_block() {
            return getRuleContext(Import_blockContext.class, 0);
        }

        public TerminalNode OP_AT() {
            return getToken(ValkyrieAntlrParser.OP_AT, 0);
        }

        public Import_nameContext import_name() {
            return getRuleContext(Import_nameContext.class, 0);
        }

        public Import_asContext import_as() {
            return getRuleContext(Import_asContext.class, 0);
        }

        public TerminalNode OP_PROPORTION() {
            return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0);
        }

        public TerminalNode DOT() {
            return getToken(ValkyrieAntlrParser.DOT, 0);
        }

        public TerminalNode OP_HASH() {
            return getToken(ValkyrieAntlrParser.OP_HASH, 0);
        }

        public Eos_freeContext eos_free() {
            return getRuleContext(Eos_freeContext.class, 0);
        }

        public Import_termContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_import_term;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterImport_term(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitImport_term(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitImport_term(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Import_termContext import_term() throws RecognitionException {
        Import_termContext _localctx = new Import_termContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_import_term);
        int _la;
        try {
            setState(317);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(278);
                    import_block();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(279);
                    match(OP_AT);
                    setState(280);
                    import_name();
                    setState(282);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == KW_AS) {
                        {
                            setState(281);
                            import_as();
                        }
                    }

                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(284);
                    match(OP_AT);
                    setState(285);
                    import_name();
                    setState(290);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                        case 1: {
                            setState(287);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == DOT || _la == OP_PROPORTION) {
                                {
                                    setState(286);
                                    _la = _input.LA(1);
                                    if (!(_la == DOT || _la == OP_PROPORTION)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                }
                            }

                            setState(289);
                            import_block();
                        }
                        break;
                    }
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(292);
                    match(OP_HASH);
                    setState(293);
                    import_name();
                    setState(295);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == KW_AS) {
                        {
                            setState(294);
                            import_as();
                        }
                    }

                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(297);
                    match(OP_HASH);
                    setState(298);
                    import_name();
                    setState(303);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
                        case 1: {
                            setState(300);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == DOT || _la == OP_PROPORTION) {
                                {
                                    setState(299);
                                    _la = _input.LA(1);
                                    if (!(_la == DOT || _la == OP_PROPORTION)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                }
                            }

                            setState(302);
                            import_block();
                        }
                        break;
                    }
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(305);
                    import_name();
                    setState(307);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == KW_AS) {
                        {
                            setState(306);
                            import_as();
                        }
                    }

                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(309);
                    import_name();
                    setState(314);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 12, _ctx)) {
                        case 1: {
                            setState(311);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == DOT || _la == OP_PROPORTION) {
                                {
                                    setState(310);
                                    _la = _input.LA(1);
                                    if (!(_la == DOT || _la == OP_PROPORTION)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                }
                            }

                            setState(313);
                            import_block();
                        }
                        break;
                    }
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(316);
                    eos_free();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Import_nameContext extends ParserRuleContext {
        public List<IdentifierContext> identifier() {
            return getRuleContexts(IdentifierContext.class);
        }

        public IdentifierContext identifier(int i) {
            return getRuleContext(IdentifierContext.class, i);
        }

        public List<TerminalNode> OP_PROPORTION() {
            return getTokens(ValkyrieAntlrParser.OP_PROPORTION);
        }

        public TerminalNode OP_PROPORTION(int i) {
            return getToken(ValkyrieAntlrParser.OP_PROPORTION, i);
        }

        public List<TerminalNode> DOT() {
            return getTokens(ValkyrieAntlrParser.DOT);
        }

        public TerminalNode DOT(int i) {
            return getToken(ValkyrieAntlrParser.DOT, i);
        }

        public TerminalNode OP_MUL() {
            return getToken(ValkyrieAntlrParser.OP_MUL, 0);
        }

        public Import_nameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_import_name;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterImport_name(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitImport_name(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitImport_name(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Import_nameContext import_name() throws RecognitionException {
        Import_nameContext _localctx = new Import_nameContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_import_name);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(319);
                identifier();
                setState(324);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(320);
                                _la = _input.LA(1);
                                if (!(_la == DOT || _la == OP_PROPORTION)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                    _errHandler.reportMatch(this);
                                    consume();
                                }
                                setState(321);
                                identifier();
                            }
                        }
                    }
                    setState(326);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 14, _ctx);
                }
                {
                    setState(327);
                    _la = _input.LA(1);
                    if (!(_la == DOT || _la == OP_PROPORTION)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    {
                        setState(328);
                        match(OP_MUL);
                    }
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Import_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Import_termContext> import_term() {
            return getRuleContexts(Import_termContext.class);
        }

        public Import_termContext import_term(int i) {
            return getRuleContext(Import_termContext.class, i);
        }

        public Import_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_import_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterImport_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitImport_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitImport_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Import_blockContext import_block() throws RecognitionException {
        Import_blockContext _localctx = new Import_blockContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_import_block);
        int _la;
        try {
            setState(340);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(330);
                    match(BRACE_L);
                    setState(331);
                    match(BRACE_R);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(332);
                    match(BRACE_L);
                    setState(336);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4152L) != 0) || _la == OP_AT || _la == OP_HASH || _la == RAW_ID || _la == UNICODE_ID) {
                        {
                            {
                                setState(333);
                                import_term();
                            }
                        }
                        setState(338);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(339);
                    match(BRACE_R);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_extensionContext extends ParserRuleContext {
        public TerminalNode KW_EXTENSION() {
            return getToken(ValkyrieAntlrParser.KW_EXTENSION, 0);
        }

        public Define_extensionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_extension;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterDefine_extension(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitDefine_extension(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_extension(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_extensionContext define_extension() throws RecognitionException {
        Define_extensionContext _localctx = new Define_extensionContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_define_extension);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(342);
                match(KW_EXTENSION);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_classContext extends ParserRuleContext {
        public ModifiersContext modifiers() {
            return getRuleContext(ModifiersContext.class, 0);
        }

        public TerminalNode KW_CLASS() {
            return getToken(ValkyrieAntlrParser.KW_CLASS, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Class_blockContext class_block() {
            return getRuleContext(Class_blockContext.class, 0);
        }

        public Template_callContext template_call() {
            return getRuleContext(Template_callContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Define_genericContext define_generic() {
            return getRuleContext(Define_genericContext.class, 0);
        }

        public Class_inheritContext class_inherit() {
            return getRuleContext(Class_inheritContext.class, 0);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public EosContext eos() {
            return getRuleContext(EosContext.class, 0);
        }

        public Define_classContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_class;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterDefine_class(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_class(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_class(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_classContext define_class() throws RecognitionException {
        Define_classContext _localctx = new Define_classContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_define_class);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(345);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
                    case 1: {
                        setState(344);
                        template_call();
                    }
                    break;
                }
                setState(350);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(347);
                            annotation();
                        }
                    }
                    setState(352);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(353);
                modifiers();
                setState(354);
                match(KW_CLASS);
                setState(355);
                identifier();
                setState(357);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                    {
                        setState(356);
                        define_generic();
                    }
                }

                setState(360);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PARENTHESES_L) {
                    {
                        setState(359);
                        class_inherit();
                    }
                }

                setState(363);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(362);
                        type_hint();
                    }
                }

                setState(365);
                class_block();
                setState(367);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 22, _ctx)) {
                    case 1: {
                        setState(366);
                        eos();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Class_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Class_dslContext> class_dsl() {
            return getRuleContexts(Class_dslContext.class);
        }

        public Class_dslContext class_dsl(int i) {
            return getRuleContext(Class_dslContext.class, i);
        }

        public List<Class_methodContext> class_method() {
            return getRuleContexts(Class_methodContext.class);
        }

        public Class_methodContext class_method(int i) {
            return getRuleContext(Class_methodContext.class, i);
        }

        public List<Class_fieldContext> class_field() {
            return getRuleContexts(Class_fieldContext.class);
        }

        public Class_fieldContext class_field(int i) {
            return getRuleContext(Class_fieldContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public Class_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_class_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterClass_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitClass_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitClass_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Class_blockContext class_block() throws RecognitionException {
        Class_blockContext _localctx = new Class_blockContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_class_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(369);
                match(BRACE_L);
                setState(376);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0) || _la == OP_HASH || _la == RAW_ID || _la == UNICODE_ID) {
                    {
                        setState(374);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 23, _ctx)) {
                            case 1: {
                                setState(370);
                                class_dsl();
                            }
                            break;
                            case 2: {
                                setState(371);
                                class_method();
                            }
                            break;
                            case 3: {
                                setState(372);
                                class_field();
                            }
                            break;
                            case 4: {
                                setState(373);
                                eos_free();
                            }
                            break;
                        }
                    }
                    setState(378);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(379);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Class_inheritContext extends ParserRuleContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public List<Class_inherit_itemContext> class_inherit_item() {
            return getRuleContexts(Class_inherit_itemContext.class);
        }

        public Class_inherit_itemContext class_inherit_item(int i) {
            return getRuleContext(Class_inherit_itemContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public Class_inheritContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_class_inherit;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterClass_inherit(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitClass_inherit(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitClass_inherit(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Class_inheritContext class_inherit() throws RecognitionException {
        Class_inheritContext _localctx = new Class_inheritContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_class_inherit);
        int _la;
        try {
            int _alt;
            setState(397);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 27, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(381);
                    match(PARENTHESES_L);
                    setState(382);
                    match(PARENTHESES_R);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(383);
                    match(PARENTHESES_L);
                    setState(384);
                    class_inherit_item();
                    setState(389);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 25, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(385);
                                    match(COMMA);
                                    setState(386);
                                    class_inherit_item();
                                }
                            }
                        }
                        setState(391);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 25, _ctx);
                    }
                    setState(393);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(392);
                            match(COMMA);
                        }
                    }

                    setState(395);
                    match(PARENTHESES_R);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Class_inherit_itemContext extends ParserRuleContext {
        public Modified_namepathContext modified_namepath() {
            return getRuleContext(Modified_namepathContext.class, 0);
        }

        public Class_inherit_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_class_inherit_item;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterClass_inherit_item(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitClass_inherit_item(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitClass_inherit_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Class_inherit_itemContext class_inherit_item() throws RecognitionException {
        Class_inherit_itemContext _localctx = new Class_inherit_itemContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_class_inherit_item);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(399);
                modified_namepath();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Class_fieldContext extends ParserRuleContext {
        public Modified_identifierContext modified_identifier() {
            return getRuleContext(Modified_identifierContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public Parameter_defaultContext parameter_default() {
            return getRuleContext(Parameter_defaultContext.class, 0);
        }

        public Class_fieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_class_field;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterClass_field(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitClass_field(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitClass_field(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Class_fieldContext class_field() throws RecognitionException {
        Class_fieldContext _localctx = new Class_fieldContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_class_field);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(404);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(401);
                            annotation();
                        }
                    }
                    setState(406);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(407);
                modified_identifier();
                setState(409);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(408);
                        type_hint();
                    }
                }

                setState(412);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OP_ASSIGN) {
                    {
                        setState(411);
                        parameter_default();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Class_methodContext extends ParserRuleContext {
        public Modified_namepathContext modified_namepath() {
            return getRuleContext(Modified_namepathContext.class, 0);
        }

        public Function_parametersContext function_parameters() {
            return getRuleContext(Function_parametersContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Define_genericContext define_generic() {
            return getRuleContext(Define_genericContext.class, 0);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public Class_methodContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_class_method;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterClass_method(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitClass_method(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitClass_method(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Class_methodContext class_method() throws RecognitionException {
        Class_methodContext _localctx = new Class_methodContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_class_method);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(417);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(414);
                            annotation();
                        }
                    }
                    setState(419);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(420);
                modified_namepath();
                setState(422);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                    {
                        setState(421);
                        define_generic();
                    }
                }

                setState(424);
                function_parameters();
                setState(426);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(425);
                        type_hint();
                    }
                }

                setState(429);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == BRACE_L) {
                    {
                        setState(428);
                        function_block();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Class_dslContext extends ParserRuleContext {
        public Modified_identifierContext modified_identifier() {
            return getRuleContext(Modified_identifierContext.class, 0);
        }

        public Class_blockContext class_block() {
            return getRuleContext(Class_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Class_dslContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_class_dsl;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterClass_dsl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitClass_dsl(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitClass_dsl(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Class_dslContext class_dsl() throws RecognitionException {
        Class_dslContext _localctx = new Class_dslContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_class_dsl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(434);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(431);
                            annotation();
                        }
                    }
                    setState(436);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(437);
                modified_identifier();
                setState(438);
                class_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_traitContext extends ParserRuleContext {
        public ModifiersContext modifiers() {
            return getRuleContext(ModifiersContext.class, 0);
        }

        public TerminalNode KW_TRAIT() {
            return getToken(ValkyrieAntlrParser.KW_TRAIT, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Trait_blockContext trait_block() {
            return getRuleContext(Trait_blockContext.class, 0);
        }

        public Template_callContext template_call() {
            return getRuleContext(Template_callContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Define_genericContext define_generic() {
            return getRuleContext(Define_genericContext.class, 0);
        }

        public With_implementsContext with_implements() {
            return getRuleContext(With_implementsContext.class, 0);
        }

        public EosContext eos() {
            return getRuleContext(EosContext.class, 0);
        }

        public Define_traitContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_trait;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterDefine_trait(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_trait(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_trait(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_traitContext define_trait() throws RecognitionException {
        Define_traitContext _localctx = new Define_traitContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_define_trait);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(441);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 36, _ctx)) {
                    case 1: {
                        setState(440);
                        template_call();
                    }
                    break;
                }
                setState(446);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(443);
                            annotation();
                        }
                    }
                    setState(448);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(449);
                modifiers();
                setState(450);
                match(KW_TRAIT);
                setState(451);
                identifier();
                setState(453);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                    {
                        setState(452);
                        define_generic();
                    }
                }

                setState(456);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON || _la == KW_IMPLEMENTS) {
                    {
                        setState(455);
                        with_implements();
                    }
                }

                setState(458);
                trait_block();
                setState(460);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 40, _ctx)) {
                    case 1: {
                        setState(459);
                        eos();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Trait_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Define_trait_typeContext> define_trait_type() {
            return getRuleContexts(Define_trait_typeContext.class);
        }

        public Define_trait_typeContext define_trait_type(int i) {
            return getRuleContext(Define_trait_typeContext.class, i);
        }

        public List<Class_methodContext> class_method() {
            return getRuleContexts(Class_methodContext.class);
        }

        public Class_methodContext class_method(int i) {
            return getRuleContext(Class_methodContext.class, i);
        }

        public List<Class_fieldContext> class_field() {
            return getRuleContexts(Class_fieldContext.class);
        }

        public Class_fieldContext class_field(int i) {
            return getRuleContext(Class_fieldContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public Trait_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_trait_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTrait_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTrait_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTrait_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Trait_blockContext trait_block() throws RecognitionException {
        Trait_blockContext _localctx = new Trait_blockContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_trait_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(462);
                match(BRACE_L);
                setState(469);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0) || _la == OP_HASH || _la == KW_TYPE || _la == RAW_ID || _la == UNICODE_ID) {
                    {
                        setState(467);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 41, _ctx)) {
                            case 1: {
                                setState(463);
                                define_trait_type();
                            }
                            break;
                            case 2: {
                                setState(464);
                                class_method();
                            }
                            break;
                            case 3: {
                                setState(465);
                                class_field();
                            }
                            break;
                            case 4: {
                                setState(466);
                                eos_free();
                            }
                            break;
                        }
                    }
                    setState(471);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(472);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_trait_typeContext extends ParserRuleContext {
        public TerminalNode KW_TYPE() {
            return getToken(ValkyrieAntlrParser.KW_TYPE, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode OP_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public Define_trait_typeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_trait_type;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterDefine_trait_type(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitDefine_trait_type(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_trait_type(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_trait_typeContext define_trait_type() throws RecognitionException {
        Define_trait_typeContext _localctx = new Define_trait_typeContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_define_trait_type);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(474);
                match(KW_TYPE);
                setState(475);
                identifier();
                setState(478);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OP_ASSIGN) {
                    {
                        setState(476);
                        match(OP_ASSIGN);
                        setState(477);
                        type_expression(0);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_extendsContext extends ParserRuleContext {
        public ModifiersContext modifiers() {
            return getRuleContext(ModifiersContext.class, 0);
        }

        public TerminalNode KW_EXTENDS() {
            return getToken(ValkyrieAntlrParser.KW_EXTENDS, 0);
        }

        public NamepathContext namepath() {
            return getRuleContext(NamepathContext.class, 0);
        }

        public Extends_blockContext extends_block() {
            return getRuleContext(Extends_blockContext.class, 0);
        }

        public Template_callContext template_call() {
            return getRuleContext(Template_callContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Define_genericContext define_generic() {
            return getRuleContext(Define_genericContext.class, 0);
        }

        public With_implementsContext with_implements() {
            return getRuleContext(With_implementsContext.class, 0);
        }

        public Define_extendsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_extends;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterDefine_extends(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_extends(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_extends(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_extendsContext define_extends() throws RecognitionException {
        Define_extendsContext _localctx = new Define_extendsContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_define_extends);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(481);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 44, _ctx)) {
                    case 1: {
                        setState(480);
                        template_call();
                    }
                    break;
                }
                setState(486);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(483);
                            annotation();
                        }
                    }
                    setState(488);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(489);
                modifiers();
                setState(490);
                match(KW_EXTENDS);
                setState(491);
                namepath();
                setState(493);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                    {
                        setState(492);
                        define_generic();
                    }
                }

                setState(496);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON || _la == KW_IMPLEMENTS) {
                    {
                        setState(495);
                        with_implements();
                    }
                }

                setState(498);
                extends_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Extends_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Define_trait_typeContext> define_trait_type() {
            return getRuleContexts(Define_trait_typeContext.class);
        }

        public Define_trait_typeContext define_trait_type(int i) {
            return getRuleContext(Define_trait_typeContext.class, i);
        }

        public List<Class_methodContext> class_method() {
            return getRuleContexts(Class_methodContext.class);
        }

        public Class_methodContext class_method(int i) {
            return getRuleContext(Class_methodContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public Extends_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_extends_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterExtends_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitExtends_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitExtends_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Extends_blockContext extends_block() throws RecognitionException {
        Extends_blockContext _localctx = new Extends_blockContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_extends_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(500);
                match(BRACE_L);
                setState(506);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0) || _la == OP_HASH || _la == KW_TYPE || _la == RAW_ID || _la == UNICODE_ID) {
                    {
                        setState(504);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case KW_TYPE: {
                                setState(501);
                                define_trait_type();
                            }
                            break;
                            case OP_HASH:
                            case RAW_ID:
                            case UNICODE_ID: {
                                setState(502);
                                class_method();
                            }
                            break;
                            case COMMA:
                            case SEMICOLON:
                            case FAKE_COLON: {
                                setState(503);
                                eos_free();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(508);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(509);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class With_implementsContext extends ParserRuleContext {
        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public TerminalNode KW_IMPLEMENTS() {
            return getToken(ValkyrieAntlrParser.KW_IMPLEMENTS, 0);
        }

        public With_implementsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_with_implements;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterWith_implements(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitWith_implements(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitWith_implements(this);
            else return visitor.visitChildren(this);
        }
    }

    public final With_implementsContext with_implements() throws RecognitionException {
        With_implementsContext _localctx = new With_implementsContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_with_implements);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(511);
                _la = _input.LA(1);
                if (!(_la == COLON || _la == KW_IMPLEMENTS)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(512);
                type_expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_unionContext extends ParserRuleContext {
        public ModifiersContext modifiers() {
            return getRuleContext(ModifiersContext.class, 0);
        }

        public TerminalNode KW_UNION() {
            return getToken(ValkyrieAntlrParser.KW_UNION, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Union_blockContext union_block() {
            return getRuleContext(Union_blockContext.class, 0);
        }

        public Template_callContext template_call() {
            return getRuleContext(Template_callContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Define_genericContext define_generic() {
            return getRuleContext(Define_genericContext.class, 0);
        }

        public Base_layoutContext base_layout() {
            return getRuleContext(Base_layoutContext.class, 0);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public Define_unionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_union;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterDefine_union(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_union(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_union(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_unionContext define_union() throws RecognitionException {
        Define_unionContext _localctx = new Define_unionContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_define_union);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(515);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 50, _ctx)) {
                    case 1: {
                        setState(514);
                        template_call();
                    }
                    break;
                }
                setState(520);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(517);
                            annotation();
                        }
                    }
                    setState(522);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(523);
                modifiers();
                setState(524);
                match(KW_UNION);
                setState(525);
                identifier();
                setState(527);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                    {
                        setState(526);
                        define_generic();
                    }
                }

                setState(530);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PARENTHESES_L) {
                    {
                        setState(529);
                        base_layout();
                    }
                }

                setState(533);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(532);
                        type_hint();
                    }
                }

                setState(535);
                union_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Base_layoutContext extends ParserRuleContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public Base_layoutContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_base_layout;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterBase_layout(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitBase_layout(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitBase_layout(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Base_layoutContext base_layout() throws RecognitionException {
        Base_layoutContext _localctx = new Base_layoutContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_base_layout);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(537);
                match(PARENTHESES_L);
                setState(539);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22749905152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -9223371959981538815L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 57359L) != 0)) {
                    {
                        setState(538);
                        type_expression(0);
                    }
                }

                setState(541);
                match(PARENTHESES_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Union_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Class_methodContext> class_method() {
            return getRuleContexts(Class_methodContext.class);
        }

        public Class_methodContext class_method(int i) {
            return getRuleContext(Class_methodContext.class, i);
        }

        public List<Define_variantContext> define_variant() {
            return getRuleContexts(Define_variantContext.class);
        }

        public Define_variantContext define_variant(int i) {
            return getRuleContext(Define_variantContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public Union_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_union_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterUnion_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitUnion_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitUnion_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Union_blockContext union_block() throws RecognitionException {
        Union_blockContext _localctx = new Union_blockContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_union_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(543);
                match(BRACE_L);
                setState(549);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0) || _la == OP_HASH || _la == RAW_ID || _la == UNICODE_ID) {
                    {
                        setState(547);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 56, _ctx)) {
                            case 1: {
                                setState(544);
                                class_method();
                            }
                            break;
                            case 2: {
                                setState(545);
                                define_variant();
                            }
                            break;
                            case 3: {
                                setState(546);
                                eos_free();
                            }
                            break;
                        }
                    }
                    setState(551);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(552);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_variantContext extends ParserRuleContext {
        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Variant_blockContext variant_block() {
            return getRuleContext(Variant_blockContext.class, 0);
        }

        public Define_variantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_variant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterDefine_variant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_variant(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_variant(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_variantContext define_variant() throws RecognitionException {
        Define_variantContext _localctx = new Define_variantContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_define_variant);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(554);
                identifier();
                setState(556);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == BRACE_L) {
                    {
                        setState(555);
                        variant_block();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Variant_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Class_fieldContext> class_field() {
            return getRuleContexts(Class_fieldContext.class);
        }

        public Class_fieldContext class_field(int i) {
            return getRuleContext(Class_fieldContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public Variant_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variant_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterVariant_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitVariant_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitVariant_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Variant_blockContext variant_block() throws RecognitionException {
        Variant_blockContext _localctx = new Variant_blockContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_variant_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(558);
                match(BRACE_L);
                setState(563);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0) || _la == OP_HASH || _la == RAW_ID || _la == UNICODE_ID) {
                    {
                        setState(561);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case OP_HASH:
                            case RAW_ID:
                            case UNICODE_ID: {
                                setState(559);
                                class_field();
                            }
                            break;
                            case COMMA:
                            case SEMICOLON:
                            case FAKE_COLON: {
                                setState(560);
                                eos_free();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(565);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(566);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_bitflagsContext extends ParserRuleContext {
        public ModifiersContext modifiers() {
            return getRuleContext(ModifiersContext.class, 0);
        }

        public TerminalNode KW_BITFLAGS() {
            return getToken(ValkyrieAntlrParser.KW_BITFLAGS, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Bitflags_blockContext bitflags_block() {
            return getRuleContext(Bitflags_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Base_layoutContext base_layout() {
            return getRuleContext(Base_layoutContext.class, 0);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public Define_bitflagsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_bitflags;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterDefine_bitflags(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_bitflags(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_bitflags(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_bitflagsContext define_bitflags() throws RecognitionException {
        Define_bitflagsContext _localctx = new Define_bitflagsContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_define_bitflags);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(571);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(568);
                            annotation();
                        }
                    }
                    setState(573);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(574);
                modifiers();
                setState(575);
                match(KW_BITFLAGS);
                setState(576);
                identifier();
                setState(578);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PARENTHESES_L) {
                    {
                        setState(577);
                        base_layout();
                    }
                }

                setState(581);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(580);
                        type_hint();
                    }
                }

                setState(583);
                bitflags_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Bitflags_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Class_methodContext> class_method() {
            return getRuleContexts(Class_methodContext.class);
        }

        public Class_methodContext class_method(int i) {
            return getRuleContext(Class_methodContext.class, i);
        }

        public List<Bitflags_itemContext> bitflags_item() {
            return getRuleContexts(Bitflags_itemContext.class);
        }

        public Bitflags_itemContext bitflags_item(int i) {
            return getRuleContext(Bitflags_itemContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public Bitflags_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_bitflags_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterBitflags_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitBitflags_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitBitflags_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Bitflags_blockContext bitflags_block() throws RecognitionException {
        Bitflags_blockContext _localctx = new Bitflags_blockContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_bitflags_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(585);
                match(BRACE_L);
                setState(591);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0) || _la == OP_HASH || _la == RAW_ID || _la == UNICODE_ID) {
                    {
                        setState(589);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 64, _ctx)) {
                            case 1: {
                                setState(586);
                                class_method();
                            }
                            break;
                            case 2: {
                                setState(587);
                                bitflags_item();
                            }
                            break;
                            case 3: {
                                setState(588);
                                eos_free();
                            }
                            break;
                        }
                    }
                    setState(593);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(594);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Bitflags_itemContext extends ParserRuleContext {
        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public TerminalNode OP_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Bitflags_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_bitflags_item;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterBitflags_item(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitBitflags_item(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitBitflags_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Bitflags_itemContext bitflags_item() throws RecognitionException {
        Bitflags_itemContext _localctx = new Bitflags_itemContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_bitflags_item);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(599);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(596);
                            annotation();
                        }
                    }
                    setState(601);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(602);
                identifier();
                setState(605);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OP_ASSIGN) {
                    {
                        setState(603);
                        match(OP_ASSIGN);
                        setState(604);
                        expression(0);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_functionContext extends ParserRuleContext {
        public ModifiersContext modifiers() {
            return getRuleContext(ModifiersContext.class, 0);
        }

        public TerminalNode KW_FUNCTION() {
            return getToken(ValkyrieAntlrParser.KW_FUNCTION, 0);
        }

        public NamepathContext namepath() {
            return getRuleContext(NamepathContext.class, 0);
        }

        public Function_parametersContext function_parameters() {
            return getRuleContext(Function_parametersContext.class, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public Template_callContext template_call() {
            return getRuleContext(Template_callContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Define_genericContext define_generic() {
            return getRuleContext(Define_genericContext.class, 0);
        }

        public Return_typeContext return_type() {
            return getRuleContext(Return_typeContext.class, 0);
        }

        public Define_functionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_function;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterDefine_function(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_function(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_function(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_functionContext define_function() throws RecognitionException {
        Define_functionContext _localctx = new Define_functionContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_define_function);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(608);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 68, _ctx)) {
                    case 1: {
                        setState(607);
                        template_call();
                    }
                    break;
                }
                setState(613);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(610);
                            annotation();
                        }
                    }
                    setState(615);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(616);
                modifiers();
                setState(617);
                match(KW_FUNCTION);
                setState(618);
                namepath();
                setState(620);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                    {
                        setState(619);
                        define_generic();
                    }
                }

                setState(622);
                function_parameters();
                setState(624);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON || _la == OP_ARROW) {
                    {
                        setState(623);
                        return_type();
                    }
                }

                setState(626);
                function_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Function_parametersContext extends ParserRuleContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public List<Parameter_itemContext> parameter_item() {
            return getRuleContexts(Parameter_itemContext.class);
        }

        public Parameter_itemContext parameter_item(int i) {
            return getRuleContext(Parameter_itemContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public Function_parametersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function_parameters;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterFunction_parameters(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitFunction_parameters(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitFunction_parameters(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Function_parametersContext function_parameters() throws RecognitionException {
        Function_parametersContext _localctx = new Function_parametersContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_function_parameters);
        int _la;
        try {
            setState(641);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 73, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(628);
                    match(PARENTHESES_L);
                    setState(629);
                    match(PARENTHESES_R);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(630);
                    match(PARENTHESES_L);
                    setState(631);
                    parameter_item();
                    setState(636);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == COMMA) {
                        {
                            {
                                setState(632);
                                match(COMMA);
                                setState(633);
                                parameter_item();
                            }
                        }
                        setState(638);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(639);
                    match(PARENTHESES_R);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Parameter_itemContext extends ParserRuleContext {
        public IdentifierContext identifier;
        public List<IdentifierContext> mods = new ArrayList<IdentifierContext>();
        public IdentifierContext id;

        public TerminalNode OP_DOT3() {
            return getToken(ValkyrieAntlrParser.OP_DOT3, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public Parameter_defaultContext parameter_default() {
            return getRuleContext(Parameter_defaultContext.class, 0);
        }

        public List<IdentifierContext> identifier() {
            return getRuleContexts(IdentifierContext.class);
        }

        public IdentifierContext identifier(int i) {
            return getRuleContext(IdentifierContext.class, i);
        }

        public TerminalNode OP_DOT2() {
            return getToken(ValkyrieAntlrParser.OP_DOT2, 0);
        }

        public TerminalNode OP_LT() {
            return getToken(ValkyrieAntlrParser.OP_LT, 0);
        }

        public TerminalNode OP_GT() {
            return getToken(ValkyrieAntlrParser.OP_GT, 0);
        }

        public Parameter_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameter_item;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterParameter_item(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitParameter_item(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitParameter_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Parameter_itemContext parameter_item() throws RecognitionException {
        Parameter_itemContext _localctx = new Parameter_itemContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_parameter_item);
        int _la;
        try {
            int _alt;
            setState(708);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 88, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(646);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(643);
                                annotation();
                            }
                        }
                        setState(648);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(652);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            {
                                setState(649);
                                ((Parameter_itemContext) _localctx).identifier = identifier();
                                ((Parameter_itemContext) _localctx).mods.add(((Parameter_itemContext) _localctx).identifier);
                            }
                        }
                        setState(654);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(655);
                    match(OP_DOT3);
                    setState(657);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(656);
                            ((Parameter_itemContext) _localctx).id = identifier();
                        }
                    }

                    setState(660);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COLON) {
                        {
                            setState(659);
                            type_hint();
                        }
                    }

                    setState(663);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_ASSIGN) {
                        {
                            setState(662);
                            parameter_default();
                        }
                    }

                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(668);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(665);
                                annotation();
                            }
                        }
                        setState(670);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(674);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            {
                                setState(671);
                                ((Parameter_itemContext) _localctx).identifier = identifier();
                                ((Parameter_itemContext) _localctx).mods.add(((Parameter_itemContext) _localctx).identifier);
                            }
                        }
                        setState(676);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(677);
                    match(OP_DOT2);
                    setState(679);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(678);
                            ((Parameter_itemContext) _localctx).id = identifier();
                        }
                    }

                    setState(682);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COLON) {
                        {
                            setState(681);
                            type_hint();
                        }
                    }

                    setState(685);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_ASSIGN) {
                        {
                            setState(684);
                            parameter_default();
                        }
                    }

                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(690);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(687);
                                annotation();
                            }
                        }
                        setState(692);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(696);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 85, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(693);
                                    ((Parameter_itemContext) _localctx).identifier = identifier();
                                    ((Parameter_itemContext) _localctx).mods.add(((Parameter_itemContext) _localctx).identifier);
                                }
                            }
                        }
                        setState(698);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 85, _ctx);
                    }
                    setState(699);
                    ((Parameter_itemContext) _localctx).id = identifier();
                    setState(701);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COLON) {
                        {
                            setState(700);
                            type_hint();
                        }
                    }

                    setState(704);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_ASSIGN) {
                        {
                            setState(703);
                            parameter_default();
                        }
                    }

                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(706);
                    match(OP_LT);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(707);
                    match(OP_GT);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Return_typeContext extends ParserRuleContext {
        public Type_expressionContext ret;
        public Type_expressionContext eff;

        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public TerminalNode OP_ARROW() {
            return getToken(ValkyrieAntlrParser.OP_ARROW, 0);
        }

        public List<Type_expressionContext> type_expression() {
            return getRuleContexts(Type_expressionContext.class);
        }

        public Type_expressionContext type_expression(int i) {
            return getRuleContext(Type_expressionContext.class, i);
        }

        public TerminalNode OP_DIV() {
            return getToken(ValkyrieAntlrParser.OP_DIV, 0);
        }

        public Return_typeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_return_type;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterReturn_type(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitReturn_type(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitReturn_type(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Return_typeContext return_type() throws RecognitionException {
        Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_return_type);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(710);
                _la = _input.LA(1);
                if (!(_la == COLON || _la == OP_ARROW)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(711);
                ((Return_typeContext) _localctx).ret = type_expression(0);
                setState(714);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OP_DIV) {
                    {
                        setState(712);
                        match(OP_DIV);
                        setState(713);
                        ((Return_typeContext) _localctx).eff = type_expression(0);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Parameter_defaultContext extends ParserRuleContext {
        public TerminalNode OP_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Parameter_defaultContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameter_default;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterParameter_default(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitParameter_default(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitParameter_default(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Parameter_defaultContext parameter_default() throws RecognitionException {
        Parameter_defaultContext _localctx = new Parameter_defaultContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_parameter_default);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(716);
                match(OP_ASSIGN);
                setState(717);
                expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Function_callContext extends ParserRuleContext {
        public Tuple_call_bodyContext tuple_call_body() {
            return getRuleContext(Tuple_call_bodyContext.class, 0);
        }

        public TerminalNode OP_AND_THEN() {
            return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0);
        }

        public TerminalNode DOT() {
            return getToken(ValkyrieAntlrParser.DOT, 0);
        }

        public TerminalNode INTEGER() {
            return getToken(ValkyrieAntlrParser.INTEGER, 0);
        }

        public NamepathContext namepath() {
            return getRuleContext(NamepathContext.class, 0);
        }

        public TerminalNode OP_AT() {
            return getToken(ValkyrieAntlrParser.OP_AT, 0);
        }

        public Function_callContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function_call;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterFunction_call(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitFunction_call(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitFunction_call(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Function_callContext function_call() throws RecognitionException {
        Function_callContext _localctx = new Function_callContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_function_call);
        int _la;
        try {
            setState(742);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 96, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(720);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_AND_THEN) {
                        {
                            setState(719);
                            match(OP_AND_THEN);
                        }
                    }

                    setState(722);
                    tuple_call_body();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(724);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_AND_THEN) {
                        {
                            setState(723);
                            match(OP_AND_THEN);
                        }
                    }

                    setState(726);
                    match(DOT);
                    setState(727);
                    match(INTEGER);
                    setState(729);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 92, _ctx)) {
                        case 1: {
                            setState(728);
                            tuple_call_body();
                        }
                        break;
                    }
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(732);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_AND_THEN) {
                        {
                            setState(731);
                            match(OP_AND_THEN);
                        }
                    }

                    setState(734);
                    match(DOT);
                    setState(736);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_AT) {
                        {
                            setState(735);
                            match(OP_AT);
                        }
                    }

                    setState(738);
                    namepath();
                    setState(740);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 95, _ctx)) {
                        case 1: {
                            setState(739);
                            tuple_call_body();
                        }
                        break;
                    }
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Tuple_call_bodyContext extends ParserRuleContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public List<Tuple_call_itemContext> tuple_call_item() {
            return getRuleContexts(Tuple_call_itemContext.class);
        }

        public Tuple_call_itemContext tuple_call_item(int i) {
            return getRuleContext(Tuple_call_itemContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public Tuple_call_bodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tuple_call_body;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterTuple_call_body(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTuple_call_body(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTuple_call_body(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Tuple_call_bodyContext tuple_call_body() throws RecognitionException {
        Tuple_call_bodyContext _localctx = new Tuple_call_bodyContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_tuple_call_body);
        int _la;
        try {
            int _alt;
            setState(760);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 99, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(744);
                    match(PARENTHESES_L);
                    setState(745);
                    match(PARENTHESES_R);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(746);
                    match(PARENTHESES_L);
                    setState(747);
                    tuple_call_item();
                    setState(752);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 97, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(748);
                                    match(COMMA);
                                    setState(749);
                                    tuple_call_item();
                                }
                            }
                        }
                        setState(754);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 97, _ctx);
                    }
                    setState(756);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(755);
                            match(COMMA);
                        }
                    }

                    setState(758);
                    match(PARENTHESES_R);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Tuple_call_itemContext extends ParserRuleContext {
        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Tuple_call_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tuple_call_item;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterTuple_call_item(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTuple_call_item(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTuple_call_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Tuple_call_itemContext tuple_call_item() throws RecognitionException {
        Tuple_call_itemContext _localctx = new Tuple_call_itemContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_tuple_call_item);
        try {
            setState(767);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 100, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(762);
                    identifier();
                    setState(763);
                    match(COLON);
                    setState(764);
                    expression(0);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(766);
                    expression(0);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_lambdaContext extends ParserRuleContext {
        public TerminalNode KW_LAMBDA() {
            return getToken(ValkyrieAntlrParser.KW_LAMBDA, 0);
        }

        public Function_parametersContext function_parameters() {
            return getRuleContext(Function_parametersContext.class, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public Define_lambdaContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_lambda;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterDefine_lambda(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_lambda(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_lambda(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_lambdaContext define_lambda() throws RecognitionException {
        Define_lambdaContext _localctx = new Define_lambdaContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_define_lambda);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(772);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(769);
                            annotation();
                        }
                    }
                    setState(774);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(775);
                match(KW_LAMBDA);
                setState(776);
                function_parameters();
                setState(778);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(777);
                        type_hint();
                    }
                }

                setState(780);
                function_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Function_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Define_typeContext> define_type() {
            return getRuleContexts(Define_typeContext.class);
        }

        public Define_typeContext define_type(int i) {
            return getRuleContext(Define_typeContext.class, i);
        }

        public List<Let_bindingContext> let_binding() {
            return getRuleContexts(Let_bindingContext.class);
        }

        public Let_bindingContext let_binding(int i) {
            return getRuleContext(Let_bindingContext.class, i);
        }

        public List<Loop_statementContext> loop_statement() {
            return getRuleContexts(Loop_statementContext.class);
        }

        public Loop_statementContext loop_statement(int i) {
            return getRuleContext(Loop_statementContext.class, i);
        }

        public List<Guard_statementContext> guard_statement() {
            return getRuleContexts(Guard_statementContext.class);
        }

        public Guard_statementContext guard_statement(int i) {
            return getRuleContext(Guard_statementContext.class, i);
        }

        public List<Expression_rootContext> expression_root() {
            return getRuleContexts(Expression_rootContext.class);
        }

        public Expression_rootContext expression_root(int i) {
            return getRuleContext(Expression_rootContext.class, i);
        }

        public List<EosContext> eos() {
            return getRuleContexts(EosContext.class);
        }

        public EosContext eos(int i) {
            return getRuleContext(EosContext.class, i);
        }

        public Function_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterFunction_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitFunction_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitFunction_block(this);
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
                setState(782);
                match(BRACE_L);
                setState(791);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22755218736L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -8147539277182368895L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 65439L) != 0)) {
                    {
                        setState(789);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 103, _ctx)) {
                            case 1: {
                                setState(783);
                                define_type();
                            }
                            break;
                            case 2: {
                                setState(784);
                                let_binding();
                            }
                            break;
                            case 3: {
                                setState(785);
                                loop_statement();
                            }
                            break;
                            case 4: {
                                setState(786);
                                guard_statement();
                            }
                            break;
                            case 5: {
                                setState(787);
                                expression_root();
                            }
                            break;
                            case 6: {
                                setState(788);
                                eos();
                            }
                            break;
                        }
                    }
                    setState(793);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(794);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Let_bindingContext extends ParserRuleContext {
        public TerminalNode KW_LET() {
            return getToken(ValkyrieAntlrParser.KW_LET, 0);
        }

        public Let_patternContext let_pattern() {
            return getRuleContext(Let_patternContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public TerminalNode OP_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0);
        }

        public Expression_rootContext expression_root() {
            return getRuleContext(Expression_rootContext.class, 0);
        }

        public Let_bindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_let_binding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterLet_binding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitLet_binding(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitLet_binding(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Let_bindingContext let_binding() throws RecognitionException {
        Let_bindingContext _localctx = new Let_bindingContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_let_binding);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(799);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(796);
                            annotation();
                        }
                    }
                    setState(801);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(802);
                match(KW_LET);
                setState(803);
                let_pattern();
                setState(805);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(804);
                        type_hint();
                    }
                }

                setState(809);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OP_ASSIGN) {
                    {
                        setState(807);
                        match(OP_ASSIGN);
                        setState(808);
                        expression_root();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Let_patternContext extends ParserRuleContext {
        public Let_pattern_tupleContext let_pattern_tuple() {
            return getRuleContext(Let_pattern_tupleContext.class, 0);
        }

        public Let_pattern_plainContext let_pattern_plain() {
            return getRuleContext(Let_pattern_plainContext.class, 0);
        }

        public Let_patternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_let_pattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterLet_pattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitLet_pattern(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitLet_pattern(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Let_patternContext let_pattern() throws RecognitionException {
        Let_patternContext _localctx = new Let_patternContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_let_pattern);
        try {
            setState(813);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 108, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(811);
                    let_pattern_tuple();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(812);
                    let_pattern_plain();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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
            return getRuleContext(Modified_identifierContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public Let_pattern_plainContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_let_pattern_plain;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterLet_pattern_plain(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitLet_pattern_plain(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitLet_pattern_plain(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Let_pattern_plainContext let_pattern_plain() throws RecognitionException {
        Let_pattern_plainContext _localctx = new Let_pattern_plainContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_let_pattern_plain);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(815);
                modified_identifier();
                setState(820);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 109, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(816);
                                match(COMMA);
                                setState(817);
                                modified_identifier();
                            }
                        }
                    }
                    setState(822);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 109, _ctx);
                }
                setState(824);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COMMA) {
                    {
                        setState(823);
                        match(COMMA);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Let_pattern_tupleContext extends ParserRuleContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public List<Let_pattern_itemContext> let_pattern_item() {
            return getRuleContexts(Let_pattern_itemContext.class);
        }

        public Let_pattern_itemContext let_pattern_item(int i) {
            return getRuleContext(Let_pattern_itemContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public NamepathContext namepath() {
            return getRuleContext(NamepathContext.class, 0);
        }

        public TerminalNode BRACKET_L() {
            return getToken(ValkyrieAntlrParser.BRACKET_L, 0);
        }

        public TerminalNode BRACKET_R() {
            return getToken(ValkyrieAntlrParser.BRACKET_R, 0);
        }

        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public Let_pattern_tupleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_let_pattern_tuple;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterLet_pattern_tuple(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitLet_pattern_tuple(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitLet_pattern_tuple(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Let_pattern_tupleContext let_pattern_tuple() throws RecognitionException {
        Let_pattern_tupleContext _localctx = new Let_pattern_tupleContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_let_pattern_tuple);
        int _la;
        try {
            int _alt;
            setState(896);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 125, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(826);
                    match(PARENTHESES_L);
                    setState(840);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 113, _ctx)) {
                        case 1: {
                            setState(827);
                            let_pattern_item();
                            setState(828);
                            match(COMMA);
                        }
                        break;
                        case 2: {
                            setState(830);
                            let_pattern_item();
                            setState(833);
                            _errHandler.sync(this);
                            _alt = 1;
                            do {
                                switch (_alt) {
                                    case 1: {
                                        {
                                            setState(831);
                                            match(COMMA);
                                            setState(832);
                                            let_pattern_item();
                                        }
                                    }
                                    break;
                                    default:
                                        throw new NoViableAltException(this);
                                }
                                setState(835);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 111, _ctx);
                            } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                            setState(838);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == COMMA) {
                                {
                                    setState(837);
                                    match(COMMA);
                                }
                            }

                        }
                        break;
                    }
                    setState(842);
                    match(PARENTHESES_R);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(843);
                    namepath();
                    setState(844);
                    match(PARENTHESES_L);
                    setState(856);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5376L) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & 13510798882111489L) != 0)) {
                        {
                            setState(845);
                            let_pattern_item();
                            setState(850);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 114, _ctx);
                            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                                if (_alt == 1) {
                                    {
                                        {
                                            setState(846);
                                            match(COMMA);
                                            setState(847);
                                            let_pattern_item();
                                        }
                                    }
                                }
                                setState(852);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 114, _ctx);
                            }
                            setState(854);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == COMMA) {
                                {
                                    setState(853);
                                    match(COMMA);
                                }
                            }

                        }
                    }

                    setState(858);
                    match(PARENTHESES_R);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(861);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(860);
                            namepath();
                        }
                    }

                    setState(863);
                    match(BRACKET_L);
                    setState(875);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5376L) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & 13510798882111489L) != 0)) {
                        {
                            setState(864);
                            let_pattern_item();
                            setState(869);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 118, _ctx);
                            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                                if (_alt == 1) {
                                    {
                                        {
                                            setState(865);
                                            match(COMMA);
                                            setState(866);
                                            let_pattern_item();
                                        }
                                    }
                                }
                                setState(871);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 118, _ctx);
                            }
                            setState(873);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == COMMA) {
                                {
                                    setState(872);
                                    match(COMMA);
                                }
                            }

                        }
                    }

                    setState(877);
                    match(BRACKET_R);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(879);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(878);
                            namepath();
                        }
                    }

                    setState(881);
                    match(BRACE_L);
                    setState(893);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5376L) != 0) || ((((_la - 95)) & ~0x3f) == 0 && ((1L << (_la - 95)) & 13510798882111489L) != 0)) {
                        {
                            setState(882);
                            let_pattern_item();
                            setState(887);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 122, _ctx);
                            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                                if (_alt == 1) {
                                    {
                                        {
                                            setState(883);
                                            match(COMMA);
                                            setState(884);
                                            let_pattern_item();
                                        }
                                    }
                                }
                                setState(889);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 122, _ctx);
                            }
                            setState(891);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == COMMA) {
                                {
                                    setState(890);
                                    match(COMMA);
                                }
                            }

                        }
                    }

                    setState(895);
                    match(BRACE_R);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Let_pattern_itemContext extends ParserRuleContext {
        public IdentifierContext bind;

        public Let_pattern_tupleContext let_pattern_tuple() {
            return getRuleContext(Let_pattern_tupleContext.class, 0);
        }

        public Modified_identifierContext modified_identifier() {
            return getRuleContext(Modified_identifierContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public TerminalNode OP_BIND() {
            return getToken(ValkyrieAntlrParser.OP_BIND, 0);
        }

        public List<IdentifierContext> identifier() {
            return getRuleContexts(IdentifierContext.class);
        }

        public IdentifierContext identifier(int i) {
            return getRuleContext(IdentifierContext.class, i);
        }

        public TerminalNode OP_DOT2() {
            return getToken(ValkyrieAntlrParser.OP_DOT2, 0);
        }

        public Let_pattern_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_let_pattern_item;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterLet_pattern_item(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitLet_pattern_item(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitLet_pattern_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Let_pattern_itemContext let_pattern_item() throws RecognitionException {
        Let_pattern_itemContext _localctx = new Let_pattern_itemContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_let_pattern_item);
        int _la;
        try {
            setState(928);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 132, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(901);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 126, _ctx)) {
                        case 1: {
                            setState(898);
                            modified_identifier();
                            setState(899);
                            match(COLON);
                        }
                        break;
                    }
                    setState(906);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 127, _ctx)) {
                        case 1: {
                            setState(903);
                            ((Let_pattern_itemContext) _localctx).bind = identifier();
                            setState(904);
                            match(OP_BIND);
                        }
                        break;
                    }
                    setState(908);
                    let_pattern_tuple();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(912);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 128, _ctx)) {
                        case 1: {
                            setState(909);
                            modified_identifier();
                            setState(910);
                            match(COLON);
                        }
                        break;
                    }
                    setState(917);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 129, _ctx)) {
                        case 1: {
                            setState(914);
                            ((Let_pattern_itemContext) _localctx).bind = identifier();
                            setState(915);
                            match(OP_BIND);
                        }
                        break;
                    }
                    setState(919);
                    identifier();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(921);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(920);
                            modified_identifier();
                        }
                    }

                    setState(923);
                    match(OP_DOT2);
                    setState(925);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(924);
                            ((Let_pattern_itemContext) _localctx).bind = identifier();
                        }
                    }

                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(927);
                    modified_identifier();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_typeContext extends ParserRuleContext {
        public ModifiersContext modifiers() {
            return getRuleContext(ModifiersContext.class, 0);
        }

        public TerminalNode KW_TYPE() {
            return getToken(ValkyrieAntlrParser.KW_TYPE, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode OP_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Define_genericContext define_generic() {
            return getRuleContext(Define_genericContext.class, 0);
        }

        public Template_blockContext template_block() {
            return getRuleContext(Template_blockContext.class, 0);
        }

        public Define_typeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_type;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterDefine_type(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_type(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_type(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_typeContext define_type() throws RecognitionException {
        Define_typeContext _localctx = new Define_typeContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_define_type);
        int _la;
        try {
            setState(959);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 137, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(933);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(930);
                                annotation();
                            }
                        }
                        setState(935);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(936);
                    modifiers();
                    setState(937);
                    match(KW_TYPE);
                    setState(938);
                    identifier();
                    setState(940);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                        {
                            setState(939);
                            define_generic();
                        }
                    }

                    setState(942);
                    match(OP_ASSIGN);
                    setState(943);
                    type_expression(0);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(948);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(945);
                                annotation();
                            }
                        }
                        setState(950);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(951);
                    modifiers();
                    setState(952);
                    match(KW_TYPE);
                    setState(953);
                    identifier();
                    setState(955);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                        {
                            setState(954);
                            define_generic();
                        }
                    }

                    setState(957);
                    template_block();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Type_hintContext extends ParserRuleContext {
        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public Type_hintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type_hint;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterType_hint(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitType_hint(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitType_hint(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Type_hintContext type_hint() throws RecognitionException {
        Type_hintContext _localctx = new Type_hintContext(_ctx, getState());
        enterRule(_localctx, 94, RULE_type_hint);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(961);
                match(COLON);
                setState(962);
                type_expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class If_statementContext extends ParserRuleContext {
        public Function_blockContext then_block;
        public Function_blockContext else_block;

        public TerminalNode KW_IF() {
            return getToken(ValkyrieAntlrParser.KW_IF, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public List<Function_blockContext> function_block() {
            return getRuleContexts(Function_blockContext.class);
        }

        public Function_blockContext function_block(int i) {
            return getRuleContext(Function_blockContext.class, i);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public List<Else_if_statementContext> else_if_statement() {
            return getRuleContexts(Else_if_statementContext.class);
        }

        public Else_if_statementContext else_if_statement(int i) {
            return getRuleContext(Else_if_statementContext.class, i);
        }

        public TerminalNode KW_ELSE() {
            return getToken(ValkyrieAntlrParser.KW_ELSE, 0);
        }

        public If_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_if_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIf_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIf_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIf_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final If_statementContext if_statement() throws RecognitionException {
        If_statementContext _localctx = new If_statementContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_if_statement);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(967);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(964);
                            annotation();
                        }
                    }
                    setState(969);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(970);
                match(KW_IF);
                setState(971);
                inline_expression(0);
                setState(972);
                ((If_statementContext) _localctx).then_block = function_block();
                setState(976);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 139, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(973);
                                else_if_statement();
                            }
                        }
                    }
                    setState(978);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 139, _ctx);
                }
                setState(981);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 140, _ctx)) {
                    case 1: {
                        setState(979);
                        match(KW_ELSE);
                        setState(980);
                        ((If_statementContext) _localctx).else_block = function_block();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Guard_statementContext extends ParserRuleContext {
        public Function_blockContext then;

        public TerminalNode KW_IF() {
            return getToken(ValkyrieAntlrParser.KW_IF, 0);
        }

        public TerminalNode OP_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public TerminalNode KW_LET() {
            return getToken(ValkyrieAntlrParser.KW_LET, 0);
        }

        public TerminalNode KW_NOT() {
            return getToken(ValkyrieAntlrParser.KW_NOT, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public Let_pattern_tupleContext let_pattern_tuple() {
            return getRuleContext(Let_pattern_tupleContext.class, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode SPECIAL() {
            return getToken(ValkyrieAntlrParser.SPECIAL, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Guard_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_guard_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterGuard_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitGuard_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitGuard_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Guard_statementContext guard_statement() throws RecognitionException {
        Guard_statementContext _localctx = new Guard_statementContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_guard_statement);
        int _la;
        try {
            setState(1011);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 144, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(986);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(983);
                                annotation();
                            }
                        }
                        setState(988);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(989);
                    match(KW_IF);
                    setState(990);
                    _la = _input.LA(1);
                    if (!(_la == KW_NOT || _la == KW_LET)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(994);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 142, _ctx)) {
                        case 1: {
                            setState(991);
                            let_pattern_tuple();
                        }
                        break;
                        case 2: {
                            setState(992);
                            identifier();
                        }
                        break;
                        case 3: {
                            setState(993);
                            match(SPECIAL);
                        }
                        break;
                    }
                    setState(996);
                    match(OP_ASSIGN);
                    setState(997);
                    inline_expression(0);
                    setState(998);
                    ((Guard_statementContext) _localctx).then = function_block();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1003);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1000);
                                annotation();
                            }
                        }
                        setState(1005);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1006);
                    match(KW_IF);
                    setState(1007);
                    _la = _input.LA(1);
                    if (!(_la == KW_NOT || _la == KW_LET)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(1008);
                    inline_expression(0);
                    setState(1009);
                    ((Guard_statementContext) _localctx).then = function_block();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Else_if_statementContext extends ParserRuleContext {
        public TerminalNode KW_ELSE() {
            return getToken(ValkyrieAntlrParser.KW_ELSE, 0);
        }

        public TerminalNode KW_IF() {
            return getToken(ValkyrieAntlrParser.KW_IF, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public Else_if_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_else_if_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterElse_if_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitElse_if_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitElse_if_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Else_if_statementContext else_if_statement() throws RecognitionException {
        Else_if_statementContext _localctx = new Else_if_statementContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_else_if_statement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1013);
                match(KW_ELSE);
                setState(1014);
                match(KW_IF);
                setState(1015);
                inline_expression(0);
                setState(1016);
                function_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Loop_statementContext extends ParserRuleContext {
        public Loop_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_loop_statement;
        }

        public Loop_statementContext() {
        }

        public void copyFrom(Loop_statementContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ForLoopContext extends Loop_statementContext {
        public Inline_expressionContext cond;
        public Inline_expressionContext guard;

        public TerminalNode KW_FOR() {
            return getToken(ValkyrieAntlrParser.KW_FOR, 0);
        }

        public Let_patternContext let_pattern() {
            return getRuleContext(Let_patternContext.class, 0);
        }

        public Infix_inContext infix_in() {
            return getRuleContext(Infix_inContext.class, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public List<Inline_expressionContext> inline_expression() {
            return getRuleContexts(Inline_expressionContext.class);
        }

        public Inline_expressionContext inline_expression(int i) {
            return getRuleContext(Inline_expressionContext.class, i);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public TerminalNode KW_IF() {
            return getToken(ValkyrieAntlrParser.KW_IF, 0);
        }

        public ForLoopContext(Loop_statementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterForLoop(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitForLoop(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitForLoop(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class WhileLetContext extends Loop_statementContext {
        public TerminalNode KW_WHILE() {
            return getToken(ValkyrieAntlrParser.KW_WHILE, 0);
        }

        public TerminalNode KW_LET() {
            return getToken(ValkyrieAntlrParser.KW_LET, 0);
        }

        public Let_patternContext let_pattern() {
            return getRuleContext(Let_patternContext.class, 0);
        }

        public TerminalNode OP_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public WhileLetContext(Loop_statementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterWhileLet(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitWhileLet(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitWhileLet(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class WhileLoopContext extends Loop_statementContext {
        public Inline_expressionContext cond;

        public TerminalNode KW_WHILE() {
            return getToken(ValkyrieAntlrParser.KW_WHILE, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public WhileLoopContext(Loop_statementContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterWhileLoop(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitWhileLoop(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitWhileLoop(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Loop_statementContext loop_statement() throws RecognitionException {
        Loop_statementContext _localctx = new Loop_statementContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_loop_statement);
        int _la;
        try {
            setState(1057);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 149, _ctx)) {
                case 1:
                    _localctx = new WhileLoopContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1021);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1018);
                                annotation();
                            }
                        }
                        setState(1023);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1024);
                    match(KW_WHILE);
                    setState(1025);
                    ((WhileLoopContext) _localctx).cond = inline_expression(0);
                    setState(1026);
                    function_block();
                }
                break;
                case 2:
                    _localctx = new WhileLetContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1031);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1028);
                                annotation();
                            }
                        }
                        setState(1033);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1034);
                    match(KW_WHILE);
                    setState(1035);
                    match(KW_LET);
                    setState(1036);
                    let_pattern();
                    setState(1037);
                    match(OP_ASSIGN);
                    setState(1038);
                    inline_expression(0);
                    setState(1039);
                    function_block();
                }
                break;
                case 3:
                    _localctx = new ForLoopContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1044);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1041);
                                annotation();
                            }
                        }
                        setState(1046);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1047);
                    match(KW_FOR);
                    setState(1048);
                    let_pattern();
                    setState(1049);
                    infix_in();
                    setState(1050);
                    ((ForLoopContext) _localctx).cond = inline_expression(0);
                    setState(1053);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == KW_IF) {
                        {
                            setState(1051);
                            match(KW_IF);
                            setState(1052);
                            ((ForLoopContext) _localctx).guard = inline_expression(0);
                        }
                    }

                    setState(1055);
                    function_block();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class If_guardContext extends ParserRuleContext {
        public TerminalNode KW_IF() {
            return getToken(ValkyrieAntlrParser.KW_IF, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public If_guardContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_if_guard;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIf_guard(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIf_guard(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIf_guard(this);
            else return visitor.visitChildren(this);
        }
    }

    public final If_guardContext if_guard() throws RecognitionException {
        If_guardContext _localctx = new If_guardContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_if_guard);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1059);
                match(KW_IF);
                setState(1060);
                inline_expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Expression_rootContext extends ParserRuleContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public TerminalNode OP_AND_THEN() {
            return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0);
        }

        public EosContext eos() {
            return getRuleContext(EosContext.class, 0);
        }

        public Expression_rootContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression_root;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterExpression_root(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitExpression_root(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitExpression_root(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Expression_rootContext expression_root() throws RecognitionException {
        Expression_rootContext _localctx = new Expression_rootContext(_ctx, getState());
        enterRule(_localctx, 106, RULE_expression_root);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1065);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 150, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1062);
                                annotation();
                            }
                        }
                    }
                    setState(1067);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 150, _ctx);
                }
                setState(1068);
                expression(0);
                setState(1070);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OP_AND_THEN) {
                    {
                        setState(1069);
                        match(OP_AND_THEN);
                    }
                }

                setState(1073);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 152, _ctx)) {
                    case 1: {
                        setState(1072);
                        eos();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        public ExpressionContext() {
        }

        public void copyFrom(ExpressionContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EIfContext extends ExpressionContext {
        public If_statementContext if_statement() {
            return getRuleContext(If_statementContext.class, 0);
        }

        public EIfContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEIf(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEIf(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEIf(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EUntilContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Infix_rangeContext infix_range() {
            return getRuleContext(Infix_rangeContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public EUntilContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEUntil(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEUntil(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEUntil(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EInContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Infix_inContext infix_in() {
            return getRuleContext(Infix_inContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public EInContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEIn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEIn(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEIn(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EFloorContext extends ExpressionContext {
        public TerminalNode FLOOR_L() {
            return getToken(ValkyrieAntlrParser.FLOOR_L, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode FLOOR_R() {
            return getToken(ValkyrieAntlrParser.FLOOR_R, 0);
        }

        public EFloorContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEFloor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEFloor(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEFloor(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EPlusContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Op_plusContext op_plus() {
            return getRuleContext(Op_plusContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public EPlusContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEPlus(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEPlus(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEPlus(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ESliceContext extends ExpressionContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Slice_callContext slice_call() {
            return getRuleContext(Slice_callContext.class, 0);
        }

        public ESliceContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterESlice(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitESlice(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitESlice(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EDotMatchContext extends ExpressionContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode DOT() {
            return getToken(ValkyrieAntlrParser.DOT, 0);
        }

        public Match_blockContext match_block() {
            return getRuleContext(Match_blockContext.class, 0);
        }

        public TerminalNode KW_MATCH() {
            return getToken(ValkyrieAntlrParser.KW_MATCH, 0);
        }

        public TerminalNode KW_CATCH() {
            return getToken(ValkyrieAntlrParser.KW_CATCH, 0);
        }

        public TerminalNode OP_AND_THEN() {
            return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0);
        }

        public TerminalNode KW_AS() {
            return getToken(ValkyrieAntlrParser.KW_AS, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public EDotMatchContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEDotMatch(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEDotMatch(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEDotMatch(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ETryContext extends ExpressionContext {
        public Try_statementContext try_statement() {
            return getRuleContext(Try_statementContext.class, 0);
        }

        public ETryContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterETry(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitETry(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitETry(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EAsContext extends ExpressionContext {
        public ExpressionContext lhs;
        public Type_expressionContext rhs;

        public Infix_asContext infix_as() {
            return getRuleContext(Infix_asContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public EAsContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEAs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEAs(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEAs(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EObjectContext extends ExpressionContext {
        public Object_statementContext object_statement() {
            return getRuleContext(Object_statementContext.class, 0);
        }

        public EObjectContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEObject(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEObject(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEObject(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ETupleContext extends ExpressionContext {
        public Tuple_literalContext tuple_literal() {
            return getRuleContext(Tuple_literalContext.class, 0);
        }

        public ETupleContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterETuple(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitETuple(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitETuple(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ERangeContext extends ExpressionContext {
        public Range_literalContext range_literal() {
            return getRuleContext(Range_literalContext.class, 0);
        }

        public ERangeContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterERange(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitERange(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitERange(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EAssignContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Op_assignContext op_assign() {
            return getRuleContext(Op_assignContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public EAssignContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEAssign(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEAssign(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEAssign(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EAtomContext extends ExpressionContext {
        public AtomicContext atomic() {
            return getRuleContext(AtomicContext.class, 0);
        }

        public EAtomContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEAtom(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEAtom(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EMulContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Op_multipleContext op_multiple() {
            return getRuleContext(Op_multipleContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public EMulContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEMul(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEMul(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEMul(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EPipeContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Op_pipelineContext op_pipeline() {
            return getRuleContext(Op_pipelineContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public EPipeContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEPipe(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEPipe(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEPipe(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ELambdaContext extends ExpressionContext {
        public Define_lambdaContext define_lambda() {
            return getRuleContext(Define_lambdaContext.class, 0);
        }

        public ELambdaContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterELambda(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitELambda(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitELambda(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EOrElseContext extends ExpressionContext {
        public ExpressionContext lhs;
        public Op_assignContext rhs;

        public TerminalNode OP_OR_ELSE() {
            return getToken(ValkyrieAntlrParser.OP_OR_ELSE, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Op_assignContext op_assign() {
            return getRuleContext(Op_assignContext.class, 0);
        }

        public EOrElseContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEOrElse(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEOrElse(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEOrElse(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EGroupContext extends ExpressionContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public EGroupContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEGroup(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEGroup(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEGroup(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EFunctionContext extends ExpressionContext {
        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Function_callContext function_call() {
            return getRuleContext(Function_callContext.class, 0);
        }

        public EFunctionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEFunction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEFunction(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEFunction(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ESuffixContext extends ExpressionContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Op_suffixContext op_suffix() {
            return getRuleContext(Op_suffixContext.class, 0);
        }

        public ESuffixContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterESuffix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitESuffix(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitESuffix(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EClosureContext extends ExpressionContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public TerminalNode OP_AND_THEN() {
            return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0);
        }

        public TerminalNode DOT() {
            return getToken(ValkyrieAntlrParser.DOT, 0);
        }

        public EClosureContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEClosure(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEClosure(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEClosure(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EMatchContext extends ExpressionContext {
        public Match_statementContext match_statement() {
            return getRuleContext(Match_statementContext.class, 0);
        }

        public EMatchContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEMatch(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEMatch(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEMatch(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EMacroContext extends ExpressionContext {
        public Macro_callContext macro_call() {
            return getRuleContext(Macro_callContext.class, 0);
        }

        public EMacroContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEMacro(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEMacro(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEMacro(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EPrefixContext extends ExpressionContext {
        public Op_prefixContext op_prefix() {
            return getRuleContext(Op_prefixContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public EPrefixContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEPrefix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEPrefix(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEPrefix(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ECompareContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Op_compareContext op_compare() {
            return getRuleContext(Op_compareContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public ECompareContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterECompare(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitECompare(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitECompare(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EGenericContext extends ExpressionContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Generic_callContext generic_call() {
            return getRuleContext(Generic_callContext.class, 0);
        }

        public EGenericContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEGeneric(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEGeneric(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEGeneric(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EIsAContext extends ExpressionContext {
        public ExpressionContext lhs;
        public Type_expressionContext rhs;

        public Infix_isContext infix_is() {
            return getRuleContext(Infix_isContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public EIsAContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEIsA(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEIsA(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEIsA(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EPowContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Infix_powContext infix_pow() {
            return getRuleContext(Infix_powContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public EPowContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEPow(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEPow(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEPow(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EDefineContext extends ExpressionContext {
        public Define_labelContext define_label() {
            return getRuleContext(Define_labelContext.class, 0);
        }

        public EDefineContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEDefine(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEDefine(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEDefine(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EMapContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Infix_mapContext infix_map() {
            return getRuleContext(Infix_mapContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public EMapContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEMap(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEMap(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEMap(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ELogicContext extends ExpressionContext {
        public ExpressionContext lhs;
        public ExpressionContext rhs;

        public Op_logicContext op_logic() {
            return getRuleContext(Op_logicContext.class, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public ELogicContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterELogic(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitELogic(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitELogic(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EControlContext extends ExpressionContext {
        public Control_expressionContext control_expression() {
            return getRuleContext(Control_expressionContext.class, 0);
        }

        public EControlContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterEControl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitEControl(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitEControl(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ENewContext extends ExpressionContext {
        public New_statementContext new_statement() {
            return getRuleContext(New_statementContext.class, 0);
        }

        public ENewContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterENew(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitENew(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitENew(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ECeilingContext extends ExpressionContext {
        public TerminalNode CEILING_L() {
            return getToken(ValkyrieAntlrParser.CEILING_L, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode CEILING_R() {
            return getToken(ValkyrieAntlrParser.CEILING_R, 0);
        }

        public ECeilingContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterECeiling(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitECeiling(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitECeiling(this);
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
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1104);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 153, _ctx)) {
                    case 1: {
                        _localctx = new EPrefixContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(1076);
                        op_prefix();
                        setState(1077);
                        expression(30);
                    }
                    break;
                    case 2: {
                        _localctx = new EGroupContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1079);
                        match(PARENTHESES_L);
                        setState(1080);
                        expression(0);
                        setState(1081);
                        match(PARENTHESES_R);
                    }
                    break;
                    case 3: {
                        _localctx = new EFloorContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1083);
                        match(FLOOR_L);
                        setState(1084);
                        expression(0);
                        setState(1085);
                        match(FLOOR_R);
                    }
                    break;
                    case 4: {
                        _localctx = new ECeilingContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1087);
                        match(CEILING_L);
                        setState(1088);
                        expression(0);
                        setState(1089);
                        match(CEILING_R);
                    }
                    break;
                    case 5: {
                        _localctx = new EControlContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1091);
                        control_expression();
                    }
                    break;
                    case 6: {
                        _localctx = new EIfContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1092);
                        if_statement();
                    }
                    break;
                    case 7: {
                        _localctx = new ENewContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1093);
                        new_statement();
                    }
                    break;
                    case 8: {
                        _localctx = new ETryContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1094);
                        try_statement();
                    }
                    break;
                    case 9: {
                        _localctx = new EMatchContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1095);
                        match_statement();
                    }
                    break;
                    case 10: {
                        _localctx = new EObjectContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1096);
                        object_statement();
                    }
                    break;
                    case 11: {
                        _localctx = new EMacroContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1097);
                        macro_call();
                    }
                    break;
                    case 12: {
                        _localctx = new ELambdaContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1098);
                        define_lambda();
                    }
                    break;
                    case 13: {
                        _localctx = new EFunctionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1099);
                        function_block();
                    }
                    break;
                    case 14: {
                        _localctx = new EDefineContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1100);
                        define_label();
                    }
                    break;
                    case 15: {
                        _localctx = new ETupleContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1101);
                        tuple_literal();
                    }
                    break;
                    case 16: {
                        _localctx = new ERangeContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1102);
                        range_literal();
                    }
                    break;
                    case 17: {
                        _localctx = new EAtomContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1103);
                        atomic();
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(1189);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 160, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(1187);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 159, _ctx)) {
                                case 1: {
                                    _localctx = new EPowContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EPowContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1106);
                                    if (!(precpred(_ctx, 29)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 29)");
                                    setState(1107);
                                    infix_pow();
                                    setState(1108);
                                    ((EPowContext) _localctx).rhs = expression(29);
                                }
                                break;
                                case 2: {
                                    _localctx = new EMulContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EMulContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1110);
                                    if (!(precpred(_ctx, 28)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 28)");
                                    setState(1111);
                                    op_multiple();
                                    setState(1112);
                                    ((EMulContext) _localctx).rhs = expression(29);
                                }
                                break;
                                case 3: {
                                    _localctx = new EPlusContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EPlusContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1114);
                                    if (!(precpred(_ctx, 27)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 27)");
                                    setState(1115);
                                    op_plus();
                                    setState(1116);
                                    ((EPlusContext) _localctx).rhs = expression(28);
                                }
                                break;
                                case 4: {
                                    _localctx = new ELogicContext(new ExpressionContext(_parentctx, _parentState));
                                    ((ELogicContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1118);
                                    if (!(precpred(_ctx, 26)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 26)");
                                    setState(1119);
                                    op_logic();
                                    setState(1120);
                                    ((ELogicContext) _localctx).rhs = expression(27);
                                }
                                break;
                                case 5: {
                                    _localctx = new ECompareContext(new ExpressionContext(_parentctx, _parentState));
                                    ((ECompareContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1122);
                                    if (!(precpred(_ctx, 25)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 25)");
                                    setState(1123);
                                    op_compare();
                                    setState(1124);
                                    ((ECompareContext) _localctx).rhs = expression(26);
                                }
                                break;
                                case 6: {
                                    _localctx = new EUntilContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EUntilContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1126);
                                    if (!(precpred(_ctx, 24)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 24)");
                                    setState(1127);
                                    infix_range();
                                    setState(1128);
                                    ((EUntilContext) _localctx).rhs = expression(25);
                                }
                                break;
                                case 7: {
                                    _localctx = new EMapContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EMapContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1130);
                                    if (!(precpred(_ctx, 23)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 23)");
                                    setState(1131);
                                    infix_map();
                                    setState(1132);
                                    ((EMapContext) _localctx).rhs = expression(24);
                                }
                                break;
                                case 8: {
                                    _localctx = new EInContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EInContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1134);
                                    if (!(precpred(_ctx, 20)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 20)");
                                    setState(1135);
                                    infix_in();
                                    setState(1136);
                                    ((EInContext) _localctx).rhs = expression(21);
                                }
                                break;
                                case 9: {
                                    _localctx = new EPipeContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EPipeContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1138);
                                    if (!(precpred(_ctx, 18)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 18)");
                                    setState(1139);
                                    op_pipeline();
                                    setState(1140);
                                    ((EPipeContext) _localctx).rhs = expression(19);
                                }
                                break;
                                case 10: {
                                    _localctx = new EAssignContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EAssignContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1142);
                                    if (!(precpred(_ctx, 17)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 17)");
                                    setState(1143);
                                    op_assign();
                                    setState(1144);
                                    ((EAssignContext) _localctx).rhs = expression(18);
                                }
                                break;
                                case 11: {
                                    _localctx = new ESuffixContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1146);
                                    if (!(precpred(_ctx, 36)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 36)");
                                    setState(1147);
                                    op_suffix();
                                }
                                break;
                                case 12: {
                                    _localctx = new ESliceContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1148);
                                    if (!(precpred(_ctx, 35)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 35)");
                                    setState(1149);
                                    slice_call();
                                }
                                break;
                                case 13: {
                                    _localctx = new EGenericContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1150);
                                    if (!(precpred(_ctx, 34)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 34)");
                                    setState(1151);
                                    generic_call();
                                }
                                break;
                                case 14: {
                                    _localctx = new EFunctionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1152);
                                    if (!(precpred(_ctx, 33)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 33)");
                                    setState(1153);
                                    function_call();
                                }
                                break;
                                case 15: {
                                    _localctx = new EClosureContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1154);
                                    if (!(precpred(_ctx, 32)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 32)");
                                    setState(1156);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    if (_la == OP_AND_THEN) {
                                        {
                                            setState(1155);
                                            match(OP_AND_THEN);
                                        }
                                    }

                                    setState(1159);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    if (_la == DOT) {
                                        {
                                            setState(1158);
                                            match(DOT);
                                        }
                                    }

                                    setState(1161);
                                    function_block();
                                }
                                break;
                                case 16: {
                                    _localctx = new EDotMatchContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1162);
                                    if (!(precpred(_ctx, 31)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 31)");
                                    setState(1164);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    if (_la == OP_AND_THEN) {
                                        {
                                            setState(1163);
                                            match(OP_AND_THEN);
                                        }
                                    }

                                    setState(1166);
                                    match(DOT);
                                    setState(1167);
                                    _la = _input.LA(1);
                                    if (!(_la == KW_MATCH || _la == KW_CATCH)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(1173);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    if (_la == KW_AS) {
                                        {
                                            setState(1168);
                                            match(KW_AS);
                                            setState(1169);
                                            identifier();
                                            setState(1171);
                                            _errHandler.sync(this);
                                            _la = _input.LA(1);
                                            if (_la == COLON) {
                                                {
                                                    setState(1170);
                                                    type_hint();
                                                }
                                            }

                                        }
                                    }

                                    setState(1175);
                                    match_block();
                                }
                                break;
                                case 17: {
                                    _localctx = new EIsAContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EIsAContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1176);
                                    if (!(precpred(_ctx, 22)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 22)");
                                    setState(1177);
                                    infix_is();
                                    setState(1178);
                                    ((EIsAContext) _localctx).rhs = type_expression(0);
                                }
                                break;
                                case 18: {
                                    _localctx = new EAsContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EAsContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1180);
                                    if (!(precpred(_ctx, 21)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 21)");
                                    setState(1181);
                                    infix_as();
                                    setState(1182);
                                    ((EAsContext) _localctx).rhs = type_expression(0);
                                }
                                break;
                                case 19: {
                                    _localctx = new EOrElseContext(new ExpressionContext(_parentctx, _parentState));
                                    ((EOrElseContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1184);
                                    if (!(precpred(_ctx, 19)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 19)");
                                    setState(1185);
                                    match(OP_OR_ELSE);
                                    setState(1186);
                                    ((EOrElseContext) _localctx).rhs = op_assign();
                                }
                                break;
                            }
                        }
                    }
                    setState(1191);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 160, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Inline_expressionContext extends ParserRuleContext {
        public Inline_expressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inline_expression;
        }

        public Inline_expressionContext() {
        }

        public void copyFrom(Inline_expressionContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ILogicContext extends Inline_expressionContext {
        public Inline_expressionContext lhs;
        public Inline_expressionContext rhs;

        public Op_logicContext op_logic() {
            return getRuleContext(Op_logicContext.class, 0);
        }

        public List<Inline_expressionContext> inline_expression() {
            return getRuleContexts(Inline_expressionContext.class);
        }

        public Inline_expressionContext inline_expression(int i) {
            return getRuleContext(Inline_expressionContext.class, i);
        }

        public ILogicContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterILogic(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitILogic(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitILogic(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IPlusContext extends Inline_expressionContext {
        public Inline_expressionContext lhs;
        public Inline_expressionContext rhs;

        public Op_plusContext op_plus() {
            return getRuleContext(Op_plusContext.class, 0);
        }

        public List<Inline_expressionContext> inline_expression() {
            return getRuleContexts(Inline_expressionContext.class);
        }

        public Inline_expressionContext inline_expression(int i) {
            return getRuleContext(Inline_expressionContext.class, i);
        }

        public IPlusContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIPlus(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIPlus(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIPlus(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ICompareContext extends Inline_expressionContext {
        public Inline_expressionContext lhs;
        public Inline_expressionContext rhs;

        public Op_compareContext op_compare() {
            return getRuleContext(Op_compareContext.class, 0);
        }

        public List<Inline_expressionContext> inline_expression() {
            return getRuleContexts(Inline_expressionContext.class);
        }

        public Inline_expressionContext inline_expression(int i) {
            return getRuleContext(Inline_expressionContext.class, i);
        }

        public ICompareContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterICompare(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitICompare(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitICompare(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IGenericContext extends Inline_expressionContext {
        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public Generic_callContext generic_call() {
            return getRuleContext(Generic_callContext.class, 0);
        }

        public IGenericContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIGeneric(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIGeneric(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIGeneric(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IFunctionContext extends Inline_expressionContext {
        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public Function_callContext function_call() {
            return getRuleContext(Function_callContext.class, 0);
        }

        public IFunctionContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIFunction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIFunction(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIFunction(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IMapContext extends Inline_expressionContext {
        public Inline_expressionContext lhs;
        public Inline_expressionContext rhs;

        public Infix_mapContext infix_map() {
            return getRuleContext(Infix_mapContext.class, 0);
        }

        public List<Inline_expressionContext> inline_expression() {
            return getRuleContexts(Inline_expressionContext.class);
        }

        public Inline_expressionContext inline_expression(int i) {
            return getRuleContext(Inline_expressionContext.class, i);
        }

        public IMapContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIMap(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIMap(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIMap(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IIsContext extends Inline_expressionContext {
        public Inline_expressionContext lhs;
        public Type_expressionContext rhs;

        public Infix_isContext infix_is() {
            return getRuleContext(Infix_isContext.class, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public IIsContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIIs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIIs(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIIs(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ITupleContext extends Inline_expressionContext {
        public Tuple_literalContext tuple_literal() {
            return getRuleContext(Tuple_literalContext.class, 0);
        }

        public ITupleContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterITuple(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitITuple(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitITuple(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IRangeContext extends Inline_expressionContext {
        public Inline_expressionContext lhs;
        public Inline_expressionContext rhs;

        public Range_literalContext range_literal() {
            return getRuleContext(Range_literalContext.class, 0);
        }

        public Infix_rangeContext infix_range() {
            return getRuleContext(Infix_rangeContext.class, 0);
        }

        public List<Inline_expressionContext> inline_expression() {
            return getRuleContexts(Inline_expressionContext.class);
        }

        public Inline_expressionContext inline_expression(int i) {
            return getRuleContext(Inline_expressionContext.class, i);
        }

        public IRangeContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIRange(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIRange(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIRange(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IGroupContext extends Inline_expressionContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public IGroupContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIGroup(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIGroup(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIGroup(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IMulContext extends Inline_expressionContext {
        public Inline_expressionContext lhs;
        public Inline_expressionContext rhs;

        public Op_multipleContext op_multiple() {
            return getRuleContext(Op_multipleContext.class, 0);
        }

        public List<Inline_expressionContext> inline_expression() {
            return getRuleContexts(Inline_expressionContext.class);
        }

        public Inline_expressionContext inline_expression(int i) {
            return getRuleContext(Inline_expressionContext.class, i);
        }

        public IMulContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIMul(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIMul(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIMul(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IAsContext extends Inline_expressionContext {
        public Inline_expressionContext lhs;
        public Type_expressionContext rhs;

        public Infix_asContext infix_as() {
            return getRuleContext(Infix_asContext.class, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public IAsContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIAs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIAs(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIAs(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IPrefixContext extends Inline_expressionContext {
        public Op_prefixContext op_prefix() {
            return getRuleContext(Op_prefixContext.class, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public IPrefixContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIPrefix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIPrefix(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIPrefix(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IFloorContext extends Inline_expressionContext {
        public TerminalNode FLOOR_L() {
            return getToken(ValkyrieAntlrParser.FLOOR_L, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode FLOOR_R() {
            return getToken(ValkyrieAntlrParser.FLOOR_R, 0);
        }

        public IFloorContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIFloor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIFloor(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIFloor(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IAtomContext extends Inline_expressionContext {
        public AtomicContext atomic() {
            return getRuleContext(AtomicContext.class, 0);
        }

        public IAtomContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIAtom(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIAtom(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ICeilingContext extends Inline_expressionContext {
        public TerminalNode CEILING_L() {
            return getToken(ValkyrieAntlrParser.CEILING_L, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode CEILING_R() {
            return getToken(ValkyrieAntlrParser.CEILING_R, 0);
        }

        public ICeilingContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterICeiling(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitICeiling(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitICeiling(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ISliceContext extends Inline_expressionContext {
        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public Slice_callContext slice_call() {
            return getRuleContext(Slice_callContext.class, 0);
        }

        public ISliceContext(Inline_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterISlice(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitISlice(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitISlice(this);
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
                setState(1211);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 161, _ctx)) {
                    case 1: {
                        _localctx = new IPrefixContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(1193);
                        op_prefix();
                        setState(1194);
                        inline_expression(18);
                    }
                    break;
                    case 2: {
                        _localctx = new IGroupContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1196);
                        match(PARENTHESES_L);
                        setState(1197);
                        expression(0);
                        setState(1198);
                        match(PARENTHESES_R);
                    }
                    break;
                    case 3: {
                        _localctx = new IFloorContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1200);
                        match(FLOOR_L);
                        setState(1201);
                        expression(0);
                        setState(1202);
                        match(FLOOR_R);
                    }
                    break;
                    case 4: {
                        _localctx = new ICeilingContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1204);
                        match(CEILING_L);
                        setState(1205);
                        expression(0);
                        setState(1206);
                        match(CEILING_R);
                    }
                    break;
                    case 5: {
                        _localctx = new ITupleContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1208);
                        tuple_literal();
                    }
                    break;
                    case 6: {
                        _localctx = new IRangeContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1209);
                        range_literal();
                    }
                    break;
                    case 7: {
                        _localctx = new IAtomContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1210);
                        atomic();
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(1253);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 163, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(1251);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 162, _ctx)) {
                                case 1: {
                                    _localctx = new IMulContext(new Inline_expressionContext(_parentctx, _parentState));
                                    ((IMulContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1213);
                                    if (!(precpred(_ctx, 14)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 14)");
                                    setState(1214);
                                    op_multiple();
                                    setState(1215);
                                    ((IMulContext) _localctx).rhs = inline_expression(15);
                                }
                                break;
                                case 2: {
                                    _localctx = new IPlusContext(new Inline_expressionContext(_parentctx, _parentState));
                                    ((IPlusContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1217);
                                    if (!(precpred(_ctx, 13)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 13)");
                                    setState(1218);
                                    op_plus();
                                    setState(1219);
                                    ((IPlusContext) _localctx).rhs = inline_expression(14);
                                }
                                break;
                                case 3: {
                                    _localctx = new ILogicContext(new Inline_expressionContext(_parentctx, _parentState));
                                    ((ILogicContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1221);
                                    if (!(precpred(_ctx, 12)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                                    setState(1222);
                                    op_logic();
                                    setState(1223);
                                    ((ILogicContext) _localctx).rhs = inline_expression(13);
                                }
                                break;
                                case 4: {
                                    _localctx = new IMapContext(new Inline_expressionContext(_parentctx, _parentState));
                                    ((IMapContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1225);
                                    if (!(precpred(_ctx, 11)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                                    setState(1226);
                                    infix_map();
                                    setState(1227);
                                    ((IMapContext) _localctx).rhs = inline_expression(12);
                                }
                                break;
                                case 5: {
                                    _localctx = new ICompareContext(new Inline_expressionContext(_parentctx, _parentState));
                                    ((ICompareContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1229);
                                    if (!(precpred(_ctx, 10)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                                    setState(1230);
                                    op_compare();
                                    setState(1231);
                                    ((ICompareContext) _localctx).rhs = inline_expression(11);
                                }
                                break;
                                case 6: {
                                    _localctx = new IRangeContext(new Inline_expressionContext(_parentctx, _parentState));
                                    ((IRangeContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1233);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(1234);
                                    infix_range();
                                    setState(1235);
                                    ((IRangeContext) _localctx).rhs = inline_expression(8);
                                }
                                break;
                                case 7: {
                                    _localctx = new IFunctionContext(new Inline_expressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1237);
                                    if (!(precpred(_ctx, 17)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 17)");
                                    setState(1238);
                                    function_call();
                                }
                                break;
                                case 8: {
                                    _localctx = new IGenericContext(new Inline_expressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1239);
                                    if (!(precpred(_ctx, 16)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 16)");
                                    setState(1240);
                                    generic_call();
                                }
                                break;
                                case 9: {
                                    _localctx = new ISliceContext(new Inline_expressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1241);
                                    if (!(precpred(_ctx, 15)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 15)");
                                    setState(1242);
                                    slice_call();
                                }
                                break;
                                case 10: {
                                    _localctx = new IIsContext(new Inline_expressionContext(_parentctx, _parentState));
                                    ((IIsContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1243);
                                    if (!(precpred(_ctx, 9)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                    setState(1244);
                                    infix_is();
                                    setState(1245);
                                    ((IIsContext) _localctx).rhs = type_expression(0);
                                }
                                break;
                                case 11: {
                                    _localctx = new IAsContext(new Inline_expressionContext(_parentctx, _parentState));
                                    ((IAsContext) _localctx).lhs = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_inline_expression);
                                    setState(1247);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(1248);
                                    infix_as();
                                    setState(1249);
                                    ((IAsContext) _localctx).rhs = type_expression(0);
                                }
                                break;
                            }
                        }
                    }
                    setState(1255);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 163, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Type_expressionContext extends ParserRuleContext {
        public Type_expressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type_expression;
        }

        public Type_expressionContext() {
        }

        public void copyFrom(Type_expressionContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TPrefixContext extends Type_expressionContext {
        public Op_prefixContext op_prefix() {
            return getRuleContext(Op_prefixContext.class, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public TPrefixContext(Type_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTPrefix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTPrefix(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTPrefix(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TGenericContext extends Type_expressionContext {
        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public Generic_call_in_typeContext generic_call_in_type() {
            return getRuleContext(Generic_call_in_typeContext.class, 0);
        }

        public TGenericContext(Type_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTGeneric(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTGeneric(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTGeneric(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TPatternContext extends Type_expressionContext {
        public List<Type_expressionContext> type_expression() {
            return getRuleContexts(Type_expressionContext.class);
        }

        public Type_expressionContext type_expression(int i) {
            return getRuleContext(Type_expressionContext.class, i);
        }

        public Op_patternContext op_pattern() {
            return getRuleContext(Op_patternContext.class, 0);
        }

        public TPatternContext(Type_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTPattern(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTPattern(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TTupleContext extends Type_expressionContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public List<Type_expressionContext> type_expression() {
            return getRuleContexts(Type_expressionContext.class);
        }

        public Type_expressionContext type_expression(int i) {
            return getRuleContext(Type_expressionContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public TTupleContext(Type_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTTuple(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTTuple(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTTuple(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TAtomContext extends Type_expressionContext {
        public AtomicContext atomic() {
            return getRuleContext(AtomicContext.class, 0);
        }

        public TAtomContext(Type_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTAtom(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTAtom(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TAddContext extends Type_expressionContext {
        public List<Type_expressionContext> type_expression() {
            return getRuleContexts(Type_expressionContext.class);
        }

        public Type_expressionContext type_expression(int i) {
            return getRuleContext(Type_expressionContext.class, i);
        }

        public TerminalNode OP_ADD() {
            return getToken(ValkyrieAntlrParser.OP_ADD, 0);
        }

        public TAddContext(Type_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTAdd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTAdd(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTAdd(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TArrowsContext extends Type_expressionContext {
        public List<Type_expressionContext> type_expression() {
            return getRuleContexts(Type_expressionContext.class);
        }

        public Type_expressionContext type_expression(int i) {
            return getRuleContext(Type_expressionContext.class, i);
        }

        public Infix_arrowsContext infix_arrows() {
            return getRuleContext(Infix_arrowsContext.class, 0);
        }

        public TArrowsContext(Type_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTArrows(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTArrows(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTArrows(this);
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
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1278);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case OP_ADD:
                    case OP_SUB:
                    case OP_MUL:
                    case OP_AND:
                    case OP_NOT:
                    case OP_DOT3:
                    case OP_DOT2:
                    case OP_INVERSE:
                    case OP_ROOT2:
                    case OP_ROOT3:
                    case OP_ROOT4:
                    case OP_REFERENCE: {
                        _localctx = new TPrefixContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(1257);
                        op_prefix();
                        setState(1258);
                        type_expression(8);
                    }
                    break;
                    case PARENTHESES_L: {
                        _localctx = new TTupleContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1260);
                        match(PARENTHESES_L);
                        setState(1274);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 166, _ctx)) {
                            case 1: {
                                setState(1261);
                                type_expression(0);
                                setState(1262);
                                match(COMMA);
                            }
                            break;
                            case 2: {
                                setState(1264);
                                type_expression(0);
                                setState(1267);
                                _errHandler.sync(this);
                                _alt = 1;
                                do {
                                    switch (_alt) {
                                        case 1: {
                                            {
                                                setState(1265);
                                                match(COMMA);
                                                setState(1266);
                                                type_expression(0);
                                            }
                                        }
                                        break;
                                        default:
                                            throw new NoViableAltException(this);
                                    }
                                    setState(1269);
                                    _errHandler.sync(this);
                                    _alt = getInterpreter().adaptivePredict(_input, 164, _ctx);
                                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                                setState(1272);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                if (_la == COMMA) {
                                    {
                                        setState(1271);
                                        match(COMMA);
                                    }
                                }

                            }
                            break;
                        }
                        setState(1276);
                        match(PARENTHESES_R);
                    }
                    break;
                    case OP_REM:
                    case OP_LAST:
                    case LAMBDA_SLOT:
                    case INTEGER:
                    case DECIMAL:
                    case STRING_SINGLE:
                    case STRING_DOUBLE:
                    case STRING_BLOCK:
                    case SPECIAL:
                    case RAW_ID:
                    case UNICODE_ID: {
                        _localctx = new TAtomContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1277);
                        atomic();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(1297);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 169, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(1295);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 168, _ctx)) {
                                case 1: {
                                    _localctx = new TPatternContext(new Type_expressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
                                    setState(1280);
                                    if (!(precpred(_ctx, 6)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                    setState(1281);
                                    op_pattern();
                                    setState(1282);
                                    type_expression(7);
                                }
                                break;
                                case 2: {
                                    _localctx = new TArrowsContext(new Type_expressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
                                    setState(1284);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(1285);
                                    infix_arrows();
                                    setState(1286);
                                    type_expression(6);
                                }
                                break;
                                case 3: {
                                    _localctx = new TAddContext(new Type_expressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
                                    setState(1288);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(1289);
                                    match(OP_ADD);
                                    setState(1290);
                                    type_expression(5);
                                }
                                break;
                                case 4: {
                                    _localctx = new TGenericContext(new Type_expressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
                                    setState(1291);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(1292);
                                    generic_call_in_type();
                                }
                                break;
                                case 5: {
                                    _localctx = new TGenericContext(new Type_expressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_type_expression);
                                    setState(1293);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(1294);
                                    generic_call_in_type();
                                }
                                break;
                            }
                        }
                    }
                    setState(1299);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 169, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AtomicContext extends ParserRuleContext {
        public AtomicContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_atomic;
        }

        public AtomicContext() {
        }

        public void copyFrom(AtomicContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ASpecialContext extends AtomicContext {
        public TerminalNode SPECIAL() {
            return getToken(ValkyrieAntlrParser.SPECIAL, 0);
        }

        public ASpecialContext(AtomicContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterASpecial(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitASpecial(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitASpecial(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ALambdaContext extends AtomicContext {
        public Lambda_nameContext lambda_name() {
            return getRuleContext(Lambda_nameContext.class, 0);
        }

        public ALambdaContext(AtomicContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterALambda(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitALambda(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitALambda(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ANumberContext extends AtomicContext {
        public Number_literalContext number_literal() {
            return getRuleContext(Number_literalContext.class, 0);
        }

        public ANumberContext(AtomicContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterANumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitANumber(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitANumber(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AOutputContext extends AtomicContext {
        public Output_nameContext output_name() {
            return getRuleContext(Output_nameContext.class, 0);
        }

        public AOutputContext(AtomicContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterAOutput(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitAOutput(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitAOutput(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AStringContext extends AtomicContext {
        public String_literalContext string_literal() {
            return getRuleContext(String_literalContext.class, 0);
        }

        public AStringContext(AtomicContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterAString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitAString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitAString(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ANamepathContext extends AtomicContext {
        public NamepathContext namepath() {
            return getRuleContext(NamepathContext.class, 0);
        }

        public ANamepathContext(AtomicContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterANamepath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitANamepath(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitANamepath(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AtomicContext atomic() throws RecognitionException {
        AtomicContext _localctx = new AtomicContext(_ctx, getState());
        enterRule(_localctx, 114, RULE_atomic);
        try {
            setState(1306);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 170, _ctx)) {
                case 1:
                    _localctx = new AStringContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1300);
                    string_literal();
                }
                break;
                case 2:
                    _localctx = new ANumberContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1301);
                    number_literal();
                }
                break;
                case 3:
                    _localctx = new ALambdaContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1302);
                    lambda_name();
                }
                break;
                case 4:
                    _localctx = new AOutputContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1303);
                    output_name();
                }
                break;
                case 5:
                    _localctx = new ANamepathContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(1304);
                    namepath();
                }
                break;
                case 6:
                    _localctx = new ASpecialContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(1305);
                    match(SPECIAL);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Control_expressionContext extends ParserRuleContext {
        public Control_expressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_control_expression;
        }

        public Control_expressionContext() {
        }

        public void copyFrom(Control_expressionContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CBreakContext extends Control_expressionContext {
        public TerminalNode BREAK() {
            return getToken(ValkyrieAntlrParser.BREAK, 0);
        }

        public TerminalNode OP_LABEL() {
            return getToken(ValkyrieAntlrParser.OP_LABEL, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode YIELD() {
            return getToken(ValkyrieAntlrParser.YIELD, 0);
        }

        public CBreakContext(Control_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterCBreak(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCBreak(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCBreak(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CWithContext extends Control_expressionContext {
        public TerminalNode YIELD() {
            return getToken(ValkyrieAntlrParser.YIELD, 0);
        }

        public TerminalNode KW_WITH() {
            return getToken(ValkyrieAntlrParser.KW_WITH, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public CWithContext(Control_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterCWith(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCWith(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCWith(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CYieldContext extends Control_expressionContext {
        public TerminalNode YIELD() {
            return getToken(ValkyrieAntlrParser.YIELD, 0);
        }

        public TerminalNode OP_LABEL() {
            return getToken(ValkyrieAntlrParser.OP_LABEL, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public CYieldContext(Control_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterCYield(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCYield(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCYield(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CReturnContext extends Control_expressionContext {
        public TerminalNode RETURN() {
            return getToken(ValkyrieAntlrParser.RETURN, 0);
        }

        public TerminalNode RESUME() {
            return getToken(ValkyrieAntlrParser.RESUME, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public CReturnContext(Control_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterCReturn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCReturn(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCReturn(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CRaiseContext extends Control_expressionContext {
        public TerminalNode RAISE() {
            return getToken(ValkyrieAntlrParser.RAISE, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public CRaiseContext(Control_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterCRaise(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCRaise(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCRaise(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CContinueContext extends Control_expressionContext {
        public TerminalNode CONTINUE() {
            return getToken(ValkyrieAntlrParser.CONTINUE, 0);
        }

        public TerminalNode OP_LABEL() {
            return getToken(ValkyrieAntlrParser.OP_LABEL, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public CContinueContext(Control_expressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterCContinue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCContinue(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCContinue(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Control_expressionContext control_expression() throws RecognitionException {
        Control_expressionContext _localctx = new Control_expressionContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_control_expression);
        try {
            setState(1340);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 177, _ctx)) {
                case 1:
                    _localctx = new CReturnContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1313);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case RETURN: {
                            setState(1308);
                            match(RETURN);
                        }
                        break;
                        case RESUME: {
                            setState(1309);
                            match(RESUME);
                            setState(1311);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 171, _ctx)) {
                                case 1: {
                                    setState(1310);
                                    expression(0);
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
                    _localctx = new CBreakContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1315);
                    match(BREAK);
                    setState(1318);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 173, _ctx)) {
                        case 1: {
                            setState(1316);
                            match(OP_LABEL);
                            setState(1317);
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
                    setState(1320);
                    match(CONTINUE);
                    setState(1323);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 174, _ctx)) {
                        case 1: {
                            setState(1321);
                            match(OP_LABEL);
                            setState(1322);
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
                    setState(1325);
                    match(RAISE);
                    setState(1326);
                    expression(0);
                }
                break;
                case 5:
                    _localctx = new CYieldContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(1327);
                    match(YIELD);
                    setState(1330);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 175, _ctx)) {
                        case 1: {
                            setState(1328);
                            match(OP_LABEL);
                            setState(1329);
                            identifier();
                        }
                        break;
                    }
                    setState(1333);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 176, _ctx)) {
                        case 1: {
                            setState(1332);
                            expression(0);
                        }
                        break;
                    }
                }
                break;
                case 6:
                    _localctx = new CBreakContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(1335);
                    match(YIELD);
                    setState(1336);
                    match(BREAK);
                }
                break;
                case 7:
                    _localctx = new CWithContext(_localctx);
                    enterOuterAlt(_localctx, 7);
                {
                    setState(1337);
                    match(YIELD);
                    setState(1338);
                    match(KW_WITH);
                    setState(1339);
                    expression(0);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Op_prefixContext extends ParserRuleContext {
        public TerminalNode OP_NOT() {
            return getToken(ValkyrieAntlrParser.OP_NOT, 0);
        }

        public TerminalNode OP_ADD() {
            return getToken(ValkyrieAntlrParser.OP_ADD, 0);
        }

        public TerminalNode OP_SUB() {
            return getToken(ValkyrieAntlrParser.OP_SUB, 0);
        }

        public TerminalNode OP_AND() {
            return getToken(ValkyrieAntlrParser.OP_AND, 0);
        }

        public TerminalNode OP_REFERENCE() {
            return getToken(ValkyrieAntlrParser.OP_REFERENCE, 0);
        }

        public TerminalNode OP_DOT2() {
            return getToken(ValkyrieAntlrParser.OP_DOT2, 0);
        }

        public TerminalNode OP_DOT3() {
            return getToken(ValkyrieAntlrParser.OP_DOT3, 0);
        }

        public TerminalNode OP_INVERSE() {
            return getToken(ValkyrieAntlrParser.OP_INVERSE, 0);
        }

        public TerminalNode OP_ROOT2() {
            return getToken(ValkyrieAntlrParser.OP_ROOT2, 0);
        }

        public TerminalNode OP_ROOT3() {
            return getToken(ValkyrieAntlrParser.OP_ROOT3, 0);
        }

        public TerminalNode OP_ROOT4() {
            return getToken(ValkyrieAntlrParser.OP_ROOT4, 0);
        }

        public TerminalNode OP_MUL() {
            return getToken(ValkyrieAntlrParser.OP_MUL, 0);
        }

        public Op_prefixContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op_prefix;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOp_prefix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOp_prefix(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOp_prefix(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Op_prefixContext op_prefix() throws RecognitionException {
        Op_prefixContext _localctx = new Op_prefixContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_op_prefix);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1342);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 1275068416L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 76873236481L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Op_suffixContext extends ParserRuleContext {
        public TerminalNode OP_NOT() {
            return getToken(ValkyrieAntlrParser.OP_NOT, 0);
        }

        public TerminalNode OP_TEMPERATURE() {
            return getToken(ValkyrieAntlrParser.OP_TEMPERATURE, 0);
        }

        public TerminalNode OP_TRANSPOSE() {
            return getToken(ValkyrieAntlrParser.OP_TRANSPOSE, 0);
        }

        public TerminalNode OP_PERCENT() {
            return getToken(ValkyrieAntlrParser.OP_PERCENT, 0);
        }

        public TerminalNode OP_REM() {
            return getToken(ValkyrieAntlrParser.OP_REM, 0);
        }

        public TerminalNode OP_OR_DEFAULT() {
            return getToken(ValkyrieAntlrParser.OP_OR_DEFAULT, 0);
        }

        public TerminalNode OP_INC() {
            return getToken(ValkyrieAntlrParser.OP_INC, 0);
        }

        public TerminalNode OP_DEC() {
            return getToken(ValkyrieAntlrParser.OP_DEC, 0);
        }

        public Op_suffixContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op_suffix;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOp_suffix(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOp_suffix(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOp_suffix(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Op_suffixContext op_suffix() throws RecognitionException {
        Op_suffixContext _localctx = new Op_suffixContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_op_suffix);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1344);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 5100273664L) != 0) || ((((_la - 81)) & ~0x3f) == 0 && ((1L << (_la - 81)) & 14680073L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Op_compareContext extends ParserRuleContext {
        public TerminalNode OP_LT() {
            return getToken(ValkyrieAntlrParser.OP_LT, 0);
        }

        public TerminalNode OP_LEQ() {
            return getToken(ValkyrieAntlrParser.OP_LEQ, 0);
        }

        public TerminalNode OP_GT() {
            return getToken(ValkyrieAntlrParser.OP_GT, 0);
        }

        public TerminalNode OP_GEQ() {
            return getToken(ValkyrieAntlrParser.OP_GEQ, 0);
        }

        public TerminalNode OP_EQ() {
            return getToken(ValkyrieAntlrParser.OP_EQ, 0);
        }

        public TerminalNode OP_NE() {
            return getToken(ValkyrieAntlrParser.OP_NE, 0);
        }

        public TerminalNode OP_EEE() {
            return getToken(ValkyrieAntlrParser.OP_EEE, 0);
        }

        public TerminalNode OP_NEE() {
            return getToken(ValkyrieAntlrParser.OP_NEE, 0);
        }

        public Op_compareContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op_compare;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOp_compare(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOp_compare(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOp_compare(this);
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
                setState(1346);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 308928407666688L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Op_patternContext extends ParserRuleContext {
        public TerminalNode OP_AND() {
            return getToken(ValkyrieAntlrParser.OP_AND, 0);
        }

        public TerminalNode OP_OR() {
            return getToken(ValkyrieAntlrParser.OP_OR, 0);
        }

        public Op_patternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op_pattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOp_pattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOp_pattern(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOp_pattern(this);
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
                setState(1348);
                _la = _input.LA(1);
                if (!(_la == OP_AND || _la == OP_OR)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Infix_mapContext extends ParserRuleContext {
        public TerminalNode OP_MAP() {
            return getToken(ValkyrieAntlrParser.OP_MAP, 0);
        }

        public TerminalNode OP_APPLY2() {
            return getToken(ValkyrieAntlrParser.OP_APPLY2, 0);
        }

        public TerminalNode OP_APPLY3() {
            return getToken(ValkyrieAntlrParser.OP_APPLY3, 0);
        }

        public Infix_mapContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_infix_map;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterInfix_map(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitInfix_map(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitInfix_map(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Infix_mapContext infix_map() throws RecognitionException {
        Infix_mapContext _localctx = new Infix_mapContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_infix_map);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1350);
                _la = _input.LA(1);
                if (!(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 7L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Infix_powContext extends ParserRuleContext {
        public TerminalNode OP_POW() {
            return getToken(ValkyrieAntlrParser.OP_POW, 0);
        }

        public TerminalNode OP_ROOT2() {
            return getToken(ValkyrieAntlrParser.OP_ROOT2, 0);
        }

        public Infix_powContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_infix_pow;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterInfix_pow(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitInfix_pow(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitInfix_pow(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Infix_powContext infix_pow() throws RecognitionException {
        Infix_powContext _localctx = new Infix_powContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_infix_pow);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1352);
                _la = _input.LA(1);
                if (!(_la == OP_POW || _la == OP_ROOT2)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Infix_rangeContext extends ParserRuleContext {
        public TerminalNode OP_UNTIL() {
            return getToken(ValkyrieAntlrParser.OP_UNTIL, 0);
        }

        public Infix_rangeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_infix_range;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterInfix_range(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitInfix_range(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitInfix_range(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Infix_rangeContext infix_range() throws RecognitionException {
        Infix_rangeContext _localctx = new Infix_rangeContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_infix_range);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1354);
                match(OP_UNTIL);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Infix_arrowsContext extends ParserRuleContext {
        public TerminalNode OP_ARROW() {
            return getToken(ValkyrieAntlrParser.OP_ARROW, 0);
        }

        public TerminalNode OP_ARROW2() {
            return getToken(ValkyrieAntlrParser.OP_ARROW2, 0);
        }

        public Infix_arrowsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_infix_arrows;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterInfix_arrows(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitInfix_arrows(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitInfix_arrows(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Infix_arrowsContext infix_arrows() throws RecognitionException {
        Infix_arrowsContext _localctx = new Infix_arrowsContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_infix_arrows);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1356);
                _la = _input.LA(1);
                if (!(_la == OP_ARROW || _la == OP_ARROW2)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Op_multipleContext extends ParserRuleContext {
        public TerminalNode OP_MUL() {
            return getToken(ValkyrieAntlrParser.OP_MUL, 0);
        }

        public TerminalNode OP_DIV() {
            return getToken(ValkyrieAntlrParser.OP_DIV, 0);
        }

        public TerminalNode OP_REM() {
            return getToken(ValkyrieAntlrParser.OP_REM, 0);
        }

        public TerminalNode OP_DIV_REM() {
            return getToken(ValkyrieAntlrParser.OP_DIV_REM, 0);
        }

        public Op_multipleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op_multiple;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOp_multiple(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOp_multiple(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOp_multiple(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Op_multipleContext op_multiple() throws RecognitionException {
        Op_multipleContext _localctx = new Op_multipleContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_op_multiple);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1358);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 16106127360L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Op_plusContext extends ParserRuleContext {
        public TerminalNode OP_ADD() {
            return getToken(ValkyrieAntlrParser.OP_ADD, 0);
        }

        public TerminalNode OP_SUB() {
            return getToken(ValkyrieAntlrParser.OP_SUB, 0);
        }

        public Op_plusContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op_plus;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOp_plus(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOp_plus(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOp_plus(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Op_plusContext op_plus() throws RecognitionException {
        Op_plusContext _localctx = new Op_plusContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_op_plus);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1360);
                _la = _input.LA(1);
                if (!(_la == OP_ADD || _la == OP_SUB)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Op_logicContext extends ParserRuleContext {
        public TerminalNode LOGIC_OR() {
            return getToken(ValkyrieAntlrParser.LOGIC_OR, 0);
        }

        public TerminalNode LOGIC_AND() {
            return getToken(ValkyrieAntlrParser.LOGIC_AND, 0);
        }

        public TerminalNode LOGIC_XOR() {
            return getToken(ValkyrieAntlrParser.LOGIC_XOR, 0);
        }

        public TerminalNode LOGIC_NOR() {
            return getToken(ValkyrieAntlrParser.LOGIC_NOR, 0);
        }

        public TerminalNode LOGIC_NAND() {
            return getToken(ValkyrieAntlrParser.LOGIC_NAND, 0);
        }

        public TerminalNode LOGIC_XAND() {
            return getToken(ValkyrieAntlrParser.LOGIC_XAND, 0);
        }

        public Op_logicContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op_logic;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOp_logic(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOp_logic(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOp_logic(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Op_logicContext op_logic() throws RecognitionException {
        Op_logicContext _localctx = new Op_logicContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_op_logic);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1362);
                _la = _input.LA(1);
                if (!(((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 63L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Op_pipelineContext extends ParserRuleContext {
        public TerminalNode OP_LL() {
            return getToken(ValkyrieAntlrParser.OP_LL, 0);
        }

        public TerminalNode OP_LLE() {
            return getToken(ValkyrieAntlrParser.OP_LLE, 0);
        }

        public TerminalNode OP_LLL() {
            return getToken(ValkyrieAntlrParser.OP_LLL, 0);
        }

        public TerminalNode OP_GG() {
            return getToken(ValkyrieAntlrParser.OP_GG, 0);
        }

        public TerminalNode OP_GGG() {
            return getToken(ValkyrieAntlrParser.OP_GGG, 0);
        }

        public TerminalNode OP_ARROW3() {
            return getToken(ValkyrieAntlrParser.OP_ARROW3, 0);
        }

        public Op_pipelineContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op_pipeline;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOp_pipeline(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOp_pipeline(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOp_pipeline(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Op_pipelineContext op_pipeline() throws RecognitionException {
        Op_pipelineContext _localctx = new Op_pipelineContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_op_pipeline);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1364);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 4722402441297920L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Op_assignContext extends ParserRuleContext {
        public TerminalNode OP_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_ASSIGN, 0);
        }

        public TerminalNode OP_ADD_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_ADD_ASSIGN, 0);
        }

        public TerminalNode OP_SUB_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_SUB_ASSIGN, 0);
        }

        public TerminalNode OP_MUL_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_MUL_ASSIGN, 0);
        }

        public TerminalNode OP_DIV_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_DIV_ASSIGN, 0);
        }

        public TerminalNode OP_MAY_ASSIGN() {
            return getToken(ValkyrieAntlrParser.OP_MAY_ASSIGN, 0);
        }

        public TerminalNode OP_GGE() {
            return getToken(ValkyrieAntlrParser.OP_GGE, 0);
        }

        public Op_assignContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_op_assign;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOp_assign(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOp_assign(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOp_assign(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Op_assignContext op_assign() throws RecognitionException {
        Op_assignContext _localctx = new Op_assignContext(_ctx, getState());
        enterRule(_localctx, 142, RULE_op_assign);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1366);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 1125935091214712832L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Infix_isContext extends ParserRuleContext {
        public TerminalNode KW_IS() {
            return getToken(ValkyrieAntlrParser.KW_IS, 0);
        }

        public TerminalNode KW_NOT() {
            return getToken(ValkyrieAntlrParser.KW_NOT, 0);
        }

        public TerminalNode OP_IS() {
            return getToken(ValkyrieAntlrParser.OP_IS, 0);
        }

        public TerminalNode OP_IS_NOT() {
            return getToken(ValkyrieAntlrParser.OP_IS_NOT, 0);
        }

        public TerminalNode OP_CONTINUES() {
            return getToken(ValkyrieAntlrParser.OP_CONTINUES, 0);
        }

        public Infix_isContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_infix_is;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterInfix_is(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitInfix_is(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitInfix_is(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Infix_isContext infix_is() throws RecognitionException {
        Infix_isContext _localctx = new Infix_isContext(_ctx, getState());
        enterRule(_localctx, 144, RULE_infix_is);
        try {
            setState(1374);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 178, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1368);
                    match(KW_IS);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1369);
                    match(KW_IS);
                    setState(1370);
                    match(KW_NOT);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1371);
                    match(OP_IS);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1372);
                    match(OP_IS_NOT);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(1373);
                    match(OP_CONTINUES);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Infix_asContext extends ParserRuleContext {
        public TerminalNode KW_AS() {
            return getToken(ValkyrieAntlrParser.KW_AS, 0);
        }

        public Infix_asContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_infix_as;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterInfix_as(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitInfix_as(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitInfix_as(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Infix_asContext infix_as() throws RecognitionException {
        Infix_asContext _localctx = new Infix_asContext(_ctx, getState());
        enterRule(_localctx, 146, RULE_infix_as);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1376);
                match(KW_AS);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Infix_inContext extends ParserRuleContext {
        public TerminalNode KW_IN() {
            return getToken(ValkyrieAntlrParser.KW_IN, 0);
        }

        public TerminalNode KW_NOT() {
            return getToken(ValkyrieAntlrParser.KW_NOT, 0);
        }

        public TerminalNode OP_IN() {
            return getToken(ValkyrieAntlrParser.OP_IN, 0);
        }

        public TerminalNode OP_NOT_IN() {
            return getToken(ValkyrieAntlrParser.OP_NOT_IN, 0);
        }

        public Infix_inContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_infix_in;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterInfix_in(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitInfix_in(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitInfix_in(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Infix_inContext infix_in() throws RecognitionException {
        Infix_inContext _localctx = new Infix_inContext(_ctx, getState());
        enterRule(_localctx, 148, RULE_infix_in);
        try {
            setState(1383);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case KW_IN:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1378);
                    match(KW_IN);
                }
                break;
                case KW_NOT:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1379);
                    match(KW_NOT);
                    setState(1380);
                    match(KW_IN);
                }
                break;
                case OP_IN:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1381);
                    match(OP_IN);
                }
                break;
                case OP_NOT_IN:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1382);
                    match(OP_NOT_IN);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_genericContext extends ParserRuleContext {
        public TerminalNode GENERIC_L() {
            return getToken(ValkyrieAntlrParser.GENERIC_L, 0);
        }

        public TerminalNode GENERIC_R() {
            return getToken(ValkyrieAntlrParser.GENERIC_R, 0);
        }

        public List<Generic_itemContext> generic_item() {
            return getRuleContexts(Generic_itemContext.class);
        }

        public Generic_itemContext generic_item(int i) {
            return getRuleContext(Generic_itemContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public TerminalNode OP_LT() {
            return getToken(ValkyrieAntlrParser.OP_LT, 0);
        }

        public TerminalNode OP_GT() {
            return getToken(ValkyrieAntlrParser.OP_GT, 0);
        }

        public TerminalNode OP_PROPORTION() {
            return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0);
        }

        public Define_genericContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_generic;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterDefine_generic(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_generic(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_generic(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_genericContext define_generic() throws RecognitionException {
        Define_genericContext _localctx = new Define_genericContext(_ctx, getState());
        enterRule(_localctx, 150, RULE_define_generic);
        int _la;
        try {
            int _alt;
            setState(1423);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 186, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1385);
                    match(GENERIC_L);
                    setState(1386);
                    match(GENERIC_R);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1387);
                    match(GENERIC_L);
                    setState(1388);
                    generic_item();
                    setState(1393);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 180, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1389);
                                    match(COMMA);
                                    setState(1390);
                                    generic_item();
                                }
                            }
                        }
                        setState(1395);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 180, _ctx);
                    }
                    setState(1397);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1396);
                            match(COMMA);
                        }
                    }

                    setState(1399);
                    match(GENERIC_R);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1402);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_PROPORTION) {
                        {
                            setState(1401);
                            match(OP_PROPORTION);
                        }
                    }

                    setState(1404);
                    match(OP_LT);
                    setState(1405);
                    match(OP_GT);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1407);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_PROPORTION) {
                        {
                            setState(1406);
                            match(OP_PROPORTION);
                        }
                    }

                    setState(1409);
                    match(OP_LT);
                    setState(1410);
                    generic_item();
                    setState(1415);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 184, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1411);
                                    match(COMMA);
                                    setState(1412);
                                    generic_item();
                                }
                            }
                        }
                        setState(1417);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 184, _ctx);
                    }
                    setState(1419);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1418);
                            match(COMMA);
                        }
                    }

                    setState(1421);
                    match(OP_GT);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Generic_itemContext extends ParserRuleContext {
        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public Generic_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_generic_item;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterGeneric_item(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitGeneric_item(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitGeneric_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Generic_itemContext generic_item() throws RecognitionException {
        Generic_itemContext _localctx = new Generic_itemContext(_ctx, getState());
        enterRule(_localctx, 152, RULE_generic_item);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1428);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 187, _ctx)) {
                    case 1: {
                        setState(1425);
                        identifier();
                        setState(1426);
                        match(COLON);
                    }
                    break;
                }
                setState(1430);
                type_expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Generic_callContext extends ParserRuleContext {
        public TerminalNode OP_PROPORTION() {
            return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0);
        }

        public TerminalNode OP_LT() {
            return getToken(ValkyrieAntlrParser.OP_LT, 0);
        }

        public TerminalNode OP_GT() {
            return getToken(ValkyrieAntlrParser.OP_GT, 0);
        }

        public List<Generic_pairContext> generic_pair() {
            return getRuleContexts(Generic_pairContext.class);
        }

        public Generic_pairContext generic_pair(int i) {
            return getRuleContext(Generic_pairContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public TerminalNode GENERIC_L() {
            return getToken(ValkyrieAntlrParser.GENERIC_L, 0);
        }

        public TerminalNode GENERIC_R() {
            return getToken(ValkyrieAntlrParser.GENERIC_R, 0);
        }

        public Generic_callContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_generic_call;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterGeneric_call(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitGeneric_call(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitGeneric_call(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Generic_callContext generic_call() throws RecognitionException {
        Generic_callContext _localctx = new Generic_callContext(_ctx, getState());
        enterRule(_localctx, 154, RULE_generic_call);
        int _la;
        try {
            int _alt;
            setState(1466);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 192, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1432);
                    match(OP_PROPORTION);
                    setState(1433);
                    match(OP_LT);
                    setState(1434);
                    match(OP_GT);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1435);
                    match(OP_PROPORTION);
                    setState(1436);
                    match(OP_LT);
                    setState(1437);
                    generic_pair();
                    setState(1442);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 188, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1438);
                                    match(COMMA);
                                    setState(1439);
                                    generic_pair();
                                }
                            }
                        }
                        setState(1444);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 188, _ctx);
                    }
                    setState(1446);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1445);
                            match(COMMA);
                        }
                    }

                    setState(1448);
                    match(OP_GT);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1450);
                    match(GENERIC_L);
                    setState(1451);
                    match(GENERIC_R);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1452);
                    match(GENERIC_L);
                    setState(1453);
                    generic_pair();
                    setState(1458);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 190, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1454);
                                    match(COMMA);
                                    setState(1455);
                                    generic_pair();
                                }
                            }
                        }
                        setState(1460);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 190, _ctx);
                    }
                    setState(1462);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1461);
                            match(COMMA);
                        }
                    }

                    setState(1464);
                    match(GENERIC_R);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Generic_call_in_typeContext extends ParserRuleContext {
        public TerminalNode OP_LT() {
            return getToken(ValkyrieAntlrParser.OP_LT, 0);
        }

        public List<Generic_pairContext> generic_pair() {
            return getRuleContexts(Generic_pairContext.class);
        }

        public Generic_pairContext generic_pair(int i) {
            return getRuleContext(Generic_pairContext.class, i);
        }

        public TerminalNode OP_GT() {
            return getToken(ValkyrieAntlrParser.OP_GT, 0);
        }

        public TerminalNode OP_PROPORTION() {
            return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public TerminalNode GENERIC_L() {
            return getToken(ValkyrieAntlrParser.GENERIC_L, 0);
        }

        public TerminalNode GENERIC_R() {
            return getToken(ValkyrieAntlrParser.GENERIC_R, 0);
        }

        public Generic_call_in_typeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_generic_call_in_type;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterGeneric_call_in_type(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitGeneric_call_in_type(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitGeneric_call_in_type(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Generic_call_in_typeContext generic_call_in_type() throws RecognitionException {
        Generic_call_in_typeContext _localctx = new Generic_call_in_typeContext(_ctx, getState());
        enterRule(_localctx, 156, RULE_generic_call_in_type);
        int _la;
        try {
            setState(1493);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OP_PROPORTION:
                case OP_LT:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1469);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == OP_PROPORTION) {
                        {
                            setState(1468);
                            match(OP_PROPORTION);
                        }
                    }

                    setState(1471);
                    match(OP_LT);
                    setState(1472);
                    generic_pair();
                    setState(1477);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == COMMA) {
                        {
                            {
                                setState(1473);
                                match(COMMA);
                                setState(1474);
                                generic_pair();
                            }
                        }
                        setState(1479);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1480);
                    match(OP_GT);
                }
                break;
                case GENERIC_L:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1482);
                    match(GENERIC_L);
                    setState(1483);
                    generic_pair();
                    setState(1488);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == COMMA) {
                        {
                            {
                                setState(1484);
                                match(COMMA);
                                setState(1485);
                                generic_pair();
                            }
                        }
                        setState(1490);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1491);
                    match(GENERIC_R);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Generic_pairContext extends ParserRuleContext {
        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public Generic_pairContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_generic_pair;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterGeneric_pair(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitGeneric_pair(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitGeneric_pair(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Generic_pairContext generic_pair() throws RecognitionException {
        Generic_pairContext _localctx = new Generic_pairContext(_ctx, getState());
        enterRule(_localctx, 158, RULE_generic_pair);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1498);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 197, _ctx)) {
                    case 1: {
                        setState(1495);
                        identifier();
                        setState(1496);
                        match(COLON);
                    }
                    break;
                }
                setState(1500);
                type_expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Define_labelContext extends ParserRuleContext {
        public TerminalNode OP_LABEL() {
            return getToken(ValkyrieAntlrParser.OP_LABEL, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Define_labelContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_define_label;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterDefine_label(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitDefine_label(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitDefine_label(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Define_labelContext define_label() throws RecognitionException {
        Define_labelContext _localctx = new Define_labelContext(_ctx, getState());
        enterRule(_localctx, 160, RULE_define_label);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1502);
                match(OP_LABEL);
                setState(1503);
                identifier();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Template_callContext extends ParserRuleContext {
        public ModifiersContext modifiers() {
            return getRuleContext(ModifiersContext.class, 0);
        }

        public TerminalNode KW_TEMPLATE() {
            return getToken(ValkyrieAntlrParser.KW_TEMPLATE, 0);
        }

        public Template_blockContext template_block() {
            return getRuleContext(Template_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public List<IdentifierContext> identifier() {
            return getRuleContexts(IdentifierContext.class);
        }

        public IdentifierContext identifier(int i) {
            return getRuleContext(IdentifierContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public Template_callContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_template_call;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTemplate_call(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTemplate_call(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTemplate_call(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Template_callContext template_call() throws RecognitionException {
        Template_callContext _localctx = new Template_callContext(_ctx, getState());
        enterRule(_localctx, 162, RULE_template_call);
        int _la;
        try {
            int _alt;
            setState(1536);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 202, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1508);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1505);
                                annotation();
                            }
                        }
                        setState(1510);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1511);
                    modifiers();
                    setState(1512);
                    match(KW_TEMPLATE);
                    setState(1513);
                    template_block();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1518);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1515);
                                annotation();
                            }
                        }
                        setState(1520);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1521);
                    modifiers();
                    setState(1522);
                    match(KW_TEMPLATE);
                    setState(1523);
                    identifier();
                    setState(1528);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 200, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1524);
                                    match(COMMA);
                                    setState(1525);
                                    identifier();
                                }
                            }
                        }
                        setState(1530);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 200, _ctx);
                    }
                    setState(1532);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1531);
                            match(COMMA);
                        }
                    }

                    setState(1534);
                    template_block();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Template_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Template_statementsContext> template_statements() {
            return getRuleContexts(Template_statementsContext.class);
        }

        public Template_statementsContext template_statements(int i) {
            return getRuleContext(Template_statementsContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public Template_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_template_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTemplate_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTemplate_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTemplate_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Template_blockContext template_block() throws RecognitionException {
        Template_blockContext _localctx = new Template_blockContext(_ctx, getState());
        enterRule(_localctx, 164, RULE_template_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1538);
                match(BRACE_L);
                setState(1543);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 58L) != 0) || ((((_la - 140)) & ~0x3f) == 0 && ((1L << (_la - 140)) & 385L) != 0)) {
                    {
                        setState(1541);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case T__0:
                            case RETURN:
                            case RAW_ID:
                            case UNICODE_ID: {
                                setState(1539);
                                template_statements();
                            }
                            break;
                            case COMMA:
                            case SEMICOLON:
                            case FAKE_COLON: {
                                setState(1540);
                                eos_free();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(1545);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1546);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Template_statementsContext extends ParserRuleContext {
        public Where_blockContext where_block() {
            return getRuleContext(Where_blockContext.class, 0);
        }

        public TerminalNode RETURN() {
            return getToken(ValkyrieAntlrParser.RETURN, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Require_blockContext require_block() {
            return getRuleContext(Require_blockContext.class, 0);
        }

        public Template_statementsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_template_statements;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterTemplate_statements(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitTemplate_statements(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTemplate_statements(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Template_statementsContext template_statements() throws RecognitionException {
        Template_statementsContext _localctx = new Template_statementsContext(_ctx, getState());
        enterRule(_localctx, 166, RULE_template_statements);
        try {
            setState(1555);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__0:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1548);
                    match(T__0);
                    setState(1549);
                    where_block();
                }
                break;
                case RETURN:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1550);
                    match(RETURN);
                    setState(1551);
                    type_expression(0);
                }
                break;
                case RAW_ID:
                case UNICODE_ID:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1552);
                    identifier();
                    setState(1553);
                    require_block();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Where_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Where_boundContext> where_bound() {
            return getRuleContexts(Where_boundContext.class);
        }

        public Where_boundContext where_bound(int i) {
            return getRuleContext(Where_boundContext.class, i);
        }

        public Where_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_where_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterWhere_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitWhere_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitWhere_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Where_blockContext where_block() throws RecognitionException {
        Where_blockContext _localctx = new Where_blockContext(_ctx, getState());
        enterRule(_localctx, 168, RULE_where_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1557);
                match(BRACE_L);
                setState(1561);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0) || _la == RAW_ID || _la == UNICODE_ID) {
                    {
                        {
                            setState(1558);
                            where_bound();
                        }
                    }
                    setState(1563);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1564);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Where_boundContext extends ParserRuleContext {
        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public Eos_freeContext eos_free() {
            return getRuleContext(Eos_freeContext.class, 0);
        }

        public Where_boundContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_where_bound;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterWhere_bound(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitWhere_bound(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitWhere_bound(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Where_boundContext where_bound() throws RecognitionException {
        Where_boundContext _localctx = new Where_boundContext(_ctx, getState());
        enterRule(_localctx, 170, RULE_where_bound);
        try {
            setState(1571);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case RAW_ID:
                case UNICODE_ID:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1566);
                    identifier();
                    setState(1567);
                    match(COLON);
                    setState(1568);
                    type_expression(0);
                }
                break;
                case COMMA:
                case SEMICOLON:
                case FAKE_COLON:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1570);
                    eos_free();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Require_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Expression_rootContext> expression_root() {
            return getRuleContexts(Expression_rootContext.class);
        }

        public Expression_rootContext expression_root(int i) {
            return getRuleContext(Expression_rootContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public Require_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_require_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterRequire_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitRequire_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitRequire_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Require_blockContext require_block() throws RecognitionException {
        Require_blockContext _localctx = new Require_blockContext(_ctx, getState());
        enterRule(_localctx, 172, RULE_require_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1573);
                match(BRACE_L);
                setState(1578);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22755218744L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -8151515111228406911L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 65439L) != 0)) {
                    {
                        setState(1576);
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
                            case OP_REM:
                            case OP_LAST:
                            case OP_AND:
                            case OP_AT:
                            case OP_HASH:
                            case LAMBDA_SLOT:
                            case OP_NOT:
                            case OP_DOT3:
                            case OP_DOT2:
                            case OP_INVERSE:
                            case OP_ROOT2:
                            case OP_ROOT3:
                            case OP_ROOT4:
                            case OP_REFERENCE:
                            case OP_LABEL:
                            case KW_NEW:
                            case KW_OBJECT:
                            case KW_LAMBDA:
                            case KW_TRY:
                            case KW_MATCH:
                            case KW_CATCH:
                            case INTEGER:
                            case DECIMAL:
                            case STRING_SINGLE:
                            case STRING_DOUBLE:
                            case STRING_BLOCK:
                            case KW_IF:
                            case RETURN:
                            case RESUME:
                            case YIELD:
                            case BREAK:
                            case CONTINUE:
                            case RAISE:
                            case SPECIAL:
                            case RAW_ID:
                            case UNICODE_ID: {
                                setState(1574);
                                expression_root();
                            }
                            break;
                            case COMMA:
                            case SEMICOLON:
                            case FAKE_COLON: {
                                setState(1575);
                                eos_free();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(1580);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1581);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Macro_callContext extends ParserRuleContext {
        public TerminalNode OP_AT() {
            return getToken(ValkyrieAntlrParser.OP_AT, 0);
        }

        public List<Annotation_call_itemContext> annotation_call_item() {
            return getRuleContexts(Annotation_call_itemContext.class);
        }

        public Annotation_call_itemContext annotation_call_item(int i) {
            return getRuleContext(Annotation_call_itemContext.class, i);
        }

        public Class_blockContext class_block() {
            return getRuleContext(Class_blockContext.class, 0);
        }

        public TerminalNode BRACKET_L() {
            return getToken(ValkyrieAntlrParser.BRACKET_L, 0);
        }

        public TerminalNode BRACKET_R() {
            return getToken(ValkyrieAntlrParser.BRACKET_R, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public Macro_callContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_macro_call;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterMacro_call(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitMacro_call(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMacro_call(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Macro_callContext macro_call() throws RecognitionException {
        Macro_callContext _localctx = new Macro_callContext(_ctx, getState());
        enterRule(_localctx, 174, RULE_macro_call);
        int _la;
        try {
            setState(1602);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 213, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1583);
                    match(OP_AT);
                    setState(1584);
                    annotation_call_item();
                    setState(1586);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 210, _ctx)) {
                        case 1: {
                            setState(1585);
                            class_block();
                        }
                        break;
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1588);
                    match(OP_AT);
                    setState(1589);
                    match(BRACKET_L);
                    setState(1590);
                    annotation_call_item();
                    setState(1595);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == COMMA) {
                        {
                            {
                                setState(1591);
                                match(COMMA);
                                setState(1592);
                                annotation_call_item();
                            }
                        }
                        setState(1597);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1598);
                    match(BRACKET_R);
                    setState(1600);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 212, _ctx)) {
                        case 1: {
                            setState(1599);
                            class_block();
                        }
                        break;
                    }
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AnnotationContext extends ParserRuleContext {
        public TerminalNode OP_HASH() {
            return getToken(ValkyrieAntlrParser.OP_HASH, 0);
        }

        public List<Annotation_call_itemContext> annotation_call_item() {
            return getRuleContexts(Annotation_call_itemContext.class);
        }

        public Annotation_call_itemContext annotation_call_item(int i) {
            return getRuleContext(Annotation_call_itemContext.class, i);
        }

        public Class_blockContext class_block() {
            return getRuleContext(Class_blockContext.class, 0);
        }

        public TerminalNode BRACKET_L() {
            return getToken(ValkyrieAntlrParser.BRACKET_L, 0);
        }

        public TerminalNode BRACKET_R() {
            return getToken(ValkyrieAntlrParser.BRACKET_R, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public AnnotationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_annotation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterAnnotation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitAnnotation(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitAnnotation(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AnnotationContext annotation() throws RecognitionException {
        AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
        enterRule(_localctx, 176, RULE_annotation);
        int _la;
        try {
            setState(1623);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 217, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1604);
                    match(OP_HASH);
                    setState(1605);
                    annotation_call_item();
                    setState(1607);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 214, _ctx)) {
                        case 1: {
                            setState(1606);
                            class_block();
                        }
                        break;
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1609);
                    match(OP_HASH);
                    setState(1610);
                    match(BRACKET_L);
                    setState(1611);
                    annotation_call_item();
                    setState(1616);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == COMMA) {
                        {
                            {
                                setState(1612);
                                match(COMMA);
                                setState(1613);
                                annotation_call_item();
                            }
                        }
                        setState(1618);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1619);
                    match(BRACKET_R);
                    setState(1621);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 216, _ctx)) {
                        case 1: {
                            setState(1620);
                            class_block();
                        }
                        break;
                    }
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Annotation_call_itemContext extends ParserRuleContext {
        public NamepathContext namepath() {
            return getRuleContext(NamepathContext.class, 0);
        }

        public Tuple_call_bodyContext tuple_call_body() {
            return getRuleContext(Tuple_call_bodyContext.class, 0);
        }

        public Class_blockContext class_block() {
            return getRuleContext(Class_blockContext.class, 0);
        }

        public Annotation_call_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_annotation_call_item;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterAnnotation_call_item(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitAnnotation_call_item(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitAnnotation_call_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Annotation_call_itemContext annotation_call_item() throws RecognitionException {
        Annotation_call_itemContext _localctx = new Annotation_call_itemContext(_ctx, getState());
        enterRule(_localctx, 178, RULE_annotation_call_item);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1625);
                namepath();
                setState(1627);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 218, _ctx)) {
                    case 1: {
                        setState(1626);
                        tuple_call_body();
                    }
                    break;
                }
                setState(1630);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 219, _ctx)) {
                    case 1: {
                        setState(1629);
                        class_block();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Try_statementContext extends ParserRuleContext {
        public TerminalNode KW_TRY() {
            return getToken(ValkyrieAntlrParser.KW_TRY, 0);
        }

        public Function_blockContext function_block() {
            return getRuleContext(Function_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public Try_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_try_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTry_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTry_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTry_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Try_statementContext try_statement() throws RecognitionException {
        Try_statementContext _localctx = new Try_statementContext(_ctx, getState());
        enterRule(_localctx, 180, RULE_try_statement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1635);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(1632);
                            annotation();
                        }
                    }
                    setState(1637);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1638);
                match(KW_TRY);
                setState(1640);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22749905152L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -9223371959981538815L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 57359L) != 0)) {
                    {
                        setState(1639);
                        type_expression(0);
                    }
                }

                setState(1642);
                function_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Match_statementContext extends ParserRuleContext {
        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public Match_blockContext match_block() {
            return getRuleContext(Match_blockContext.class, 0);
        }

        public TerminalNode KW_MATCH() {
            return getToken(ValkyrieAntlrParser.KW_MATCH, 0);
        }

        public TerminalNode KW_CATCH() {
            return getToken(ValkyrieAntlrParser.KW_CATCH, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode OP_BIND() {
            return getToken(ValkyrieAntlrParser.OP_BIND, 0);
        }

        public Match_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_match_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterMatch_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitMatch_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMatch_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Match_statementContext match_statement() throws RecognitionException {
        Match_statementContext _localctx = new Match_statementContext(_ctx, getState());
        enterRule(_localctx, 182, RULE_match_statement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1647);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == OP_HASH) {
                    {
                        {
                            setState(1644);
                            annotation();
                        }
                    }
                    setState(1649);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1650);
                _la = _input.LA(1);
                if (!(_la == KW_MATCH || _la == KW_CATCH)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
                setState(1654);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 223, _ctx)) {
                    case 1: {
                        setState(1651);
                        identifier();
                        setState(1652);
                        match(OP_BIND);
                    }
                    break;
                }
                setState(1656);
                inline_expression(0);
                setState(1657);
                match_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Match_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Match_termsContext> match_terms() {
            return getRuleContexts(Match_termsContext.class);
        }

        public Match_termsContext match_terms(int i) {
            return getRuleContext(Match_termsContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public Match_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_match_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterMatch_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitMatch_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMatch_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Match_blockContext match_block() throws RecognitionException {
        Match_blockContext _localctx = new Match_blockContext(_ctx, getState());
        enterRule(_localctx, 184, RULE_match_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1659);
                match(BRACE_L);
                setState(1664);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 56L) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 2337368344044240897L) != 0)) {
                    {
                        setState(1662);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case OP_HASH:
                            case KW_TYPE:
                            case KW_WITH:
                            case KW_CASE:
                            case KW_WHEN:
                            case KW_ELSE: {
                                setState(1660);
                                match_terms();
                            }
                            break;
                            case COMMA:
                            case SEMICOLON:
                            case FAKE_COLON: {
                                setState(1661);
                                eos_free();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(1666);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1667);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Match_termsContext extends ParserRuleContext {
        public Match_termsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_match_terms;
        }

        public Match_termsContext() {
        }

        public void copyFrom(Match_termsContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MatchWhenContext extends Match_termsContext {
        public TerminalNode KW_WHEN() {
            return getToken(ValkyrieAntlrParser.KW_WHEN, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public Match_case_blockContext match_case_block() {
            return getRuleContext(Match_case_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public MatchWhenContext(Match_termsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterMatchWhen(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitMatchWhen(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMatchWhen(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MatchTypeContext extends Match_termsContext {
        public TerminalNode KW_TYPE() {
            return getToken(ValkyrieAntlrParser.KW_TYPE, 0);
        }

        public Type_expressionContext type_expression() {
            return getRuleContext(Type_expressionContext.class, 0);
        }

        public Match_case_blockContext match_case_block() {
            return getRuleContext(Match_case_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public TerminalNode KW_IF() {
            return getToken(ValkyrieAntlrParser.KW_IF, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public MatchTypeContext(Match_termsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterMatchType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitMatchType(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMatchType(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MatchCaseContext extends Match_termsContext {
        public TerminalNode KW_CASE() {
            return getToken(ValkyrieAntlrParser.KW_CASE, 0);
        }

        public Case_patternContext case_pattern() {
            return getRuleContext(Case_patternContext.class, 0);
        }

        public Match_case_blockContext match_case_block() {
            return getRuleContext(Match_case_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public TerminalNode KW_IF() {
            return getToken(ValkyrieAntlrParser.KW_IF, 0);
        }

        public Inline_expressionContext inline_expression() {
            return getRuleContext(Inline_expressionContext.class, 0);
        }

        public MatchCaseContext(Match_termsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterMatchCase(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitMatchCase(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMatchCase(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MatchWithContext extends Match_termsContext {
        public TerminalNode KW_WITH() {
            return getToken(ValkyrieAntlrParser.KW_WITH, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public MatchWithContext(Match_termsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterMatchWith(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitMatchWith(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMatchWith(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MatchWithManyContext extends Match_termsContext {
        public TerminalNode KW_WITH() {
            return getToken(ValkyrieAntlrParser.KW_WITH, 0);
        }

        public TerminalNode BRACKET_L() {
            return getToken(ValkyrieAntlrParser.BRACKET_L, 0);
        }

        public TerminalNode BRACKET_R() {
            return getToken(ValkyrieAntlrParser.BRACKET_R, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public List<IdentifierContext> identifier() {
            return getRuleContexts(IdentifierContext.class);
        }

        public IdentifierContext identifier(int i) {
            return getRuleContext(IdentifierContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public MatchWithManyContext(Match_termsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterMatchWithMany(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitMatchWithMany(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMatchWithMany(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MatchElseContext extends Match_termsContext {
        public TerminalNode KW_ELSE() {
            return getToken(ValkyrieAntlrParser.KW_ELSE, 0);
        }

        public Match_case_blockContext match_case_block() {
            return getRuleContext(Match_case_blockContext.class, 0);
        }

        public List<AnnotationContext> annotation() {
            return getRuleContexts(AnnotationContext.class);
        }

        public AnnotationContext annotation(int i) {
            return getRuleContext(AnnotationContext.class, i);
        }

        public MatchElseContext(Match_termsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterMatchElse(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitMatchElse(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMatchElse(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Match_termsContext match_terms() throws RecognitionException {
        Match_termsContext _localctx = new Match_termsContext(_ctx, getState());
        enterRule(_localctx, 186, RULE_match_terms);
        int _la;
        try {
            int _alt;
            setState(1745);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 237, _ctx)) {
                case 1:
                    _localctx = new MatchWithContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1672);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1669);
                                annotation();
                            }
                        }
                        setState(1674);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1675);
                    match(KW_WITH);
                    setState(1676);
                    identifier();
                }
                break;
                case 2:
                    _localctx = new MatchWithManyContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1680);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1677);
                                annotation();
                            }
                        }
                        setState(1682);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1683);
                    match(KW_WITH);
                    setState(1684);
                    match(BRACKET_L);
                    setState(1696);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(1685);
                            identifier();
                            setState(1690);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 228, _ctx);
                            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                                if (_alt == 1) {
                                    {
                                        {
                                            setState(1686);
                                            match(COMMA);
                                            setState(1687);
                                            identifier();
                                        }
                                    }
                                }
                                setState(1692);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 228, _ctx);
                            }
                            setState(1694);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == COMMA) {
                                {
                                    setState(1693);
                                    match(COMMA);
                                }
                            }

                        }
                    }

                    setState(1698);
                    match(BRACKET_R);
                }
                break;
                case 3:
                    _localctx = new MatchTypeContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1702);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1699);
                                annotation();
                            }
                        }
                        setState(1704);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1705);
                    match(KW_TYPE);
                    setState(1706);
                    type_expression(0);
                    setState(1709);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == KW_IF) {
                        {
                            setState(1707);
                            match(KW_IF);
                            setState(1708);
                            inline_expression(0);
                        }
                    }

                    setState(1711);
                    match_case_block();
                }
                break;
                case 4:
                    _localctx = new MatchWhenContext(_localctx);
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1716);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1713);
                                annotation();
                            }
                        }
                        setState(1718);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1719);
                    match(KW_WHEN);
                    setState(1720);
                    inline_expression(0);
                    setState(1721);
                    match_case_block();
                }
                break;
                case 5:
                    _localctx = new MatchElseContext(_localctx);
                    enterOuterAlt(_localctx, 5);
                {
                    setState(1726);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1723);
                                annotation();
                            }
                        }
                        setState(1728);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1729);
                    match(KW_ELSE);
                    setState(1730);
                    match_case_block();
                }
                break;
                case 6:
                    _localctx = new MatchCaseContext(_localctx);
                    enterOuterAlt(_localctx, 6);
                {
                    setState(1734);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == OP_HASH) {
                        {
                            {
                                setState(1731);
                                annotation();
                            }
                        }
                        setState(1736);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1737);
                    match(KW_CASE);
                    setState(1738);
                    case_pattern(0);
                    setState(1741);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == KW_IF) {
                        {
                            setState(1739);
                            match(KW_IF);
                            setState(1740);
                            inline_expression(0);
                        }
                    }

                    setState(1743);
                    match_case_block();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Match_case_blockContext extends ParserRuleContext {
        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public Match_case_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_match_case_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterMatch_case_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitMatch_case_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitMatch_case_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Match_case_blockContext match_case_block() throws RecognitionException {
        Match_case_blockContext _localctx = new Match_case_blockContext(_ctx, getState());
        enterRule(_localctx, 188, RULE_match_case_block);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1747);
                match(COLON);
                setState(1751);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 238, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1748);
                                expression(0);
                            }
                        }
                    }
                    setState(1753);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 238, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Case_patternContext extends ParserRuleContext {
        public Case_patternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_case_pattern;
        }

        public Case_patternContext() {
        }

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
            return getRuleContext(Case_patternContext.class, i);
        }

        public TerminalNode OP_OR() {
            return getToken(ValkyrieAntlrParser.OP_OR, 0);
        }

        public TerminalNode OP_ADD() {
            return getToken(ValkyrieAntlrParser.OP_ADD, 0);
        }

        public CaseORContext(Case_patternContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterCaseOR(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCaseOR(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCaseOR(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CaseAtomContext extends Case_patternContext {
        public Case_pattern_itemContext case_pattern_item() {
            return getRuleContext(Case_pattern_itemContext.class, 0);
        }

        public CaseAtomContext(Case_patternContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterCaseAtom(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCaseAtom(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCaseAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CaseUntilContext extends Case_patternContext {
        public List<Case_patternContext> case_pattern() {
            return getRuleContexts(Case_patternContext.class);
        }

        public Case_patternContext case_pattern(int i) {
            return getRuleContext(Case_patternContext.class, i);
        }

        public TerminalNode OP_UNTIL() {
            return getToken(ValkyrieAntlrParser.OP_UNTIL, 0);
        }

        public CaseUntilContext(Case_patternContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterCaseUntil(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCaseUntil(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCaseUntil(this);
            else return visitor.visitChildren(this);
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
        int _startState = 190;
        enterRecursionRule(_localctx, 190, RULE_case_pattern, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                {
                    _localctx = new CaseAtomContext(_localctx);
                    _ctx = _localctx;
                    _prevctx = _localctx;

                    setState(1755);
                    case_pattern_item();
                }
                _ctx.stop = _input.LT(-1);
                setState(1765);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 240, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(1763);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 239, _ctx)) {
                                case 1: {
                                    _localctx = new CaseORContext(new Case_patternContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_case_pattern);
                                    setState(1757);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(1758);
                                    _la = _input.LA(1);
                                    if (!(_la == OP_ADD || _la == OP_OR)) {
                                        _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(1759);
                                    case_pattern(4);
                                }
                                break;
                                case 2: {
                                    _localctx = new CaseUntilContext(new Case_patternContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_case_pattern);
                                    setState(1760);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    {
                                        setState(1761);
                                        match(OP_UNTIL);
                                    }
                                    setState(1762);
                                    case_pattern(3);
                                }
                                break;
                            }
                        }
                    }
                    setState(1767);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 240, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Case_pattern_itemContext extends ParserRuleContext {
        public IdentifierContext bind;

        public Case_pattern_tupleContext case_pattern_tuple() {
            return getRuleContext(Case_pattern_tupleContext.class, 0);
        }

        public TerminalNode OP_BIND() {
            return getToken(ValkyrieAntlrParser.OP_BIND, 0);
        }

        public Case_pattern_itemContext case_pattern_item() {
            return getRuleContext(Case_pattern_itemContext.class, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Modified_identifierContext modified_identifier() {
            return getRuleContext(Modified_identifierContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public NamepathContext namepath() {
            return getRuleContext(NamepathContext.class, 0);
        }

        public Number_literalContext number_literal() {
            return getRuleContext(Number_literalContext.class, 0);
        }

        public String_literalContext string_literal() {
            return getRuleContext(String_literalContext.class, 0);
        }

        public TerminalNode SPECIAL() {
            return getToken(ValkyrieAntlrParser.SPECIAL, 0);
        }

        public Case_pattern_itemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_case_pattern_item;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterCase_pattern_item(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitCase_pattern_item(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCase_pattern_item(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Case_pattern_itemContext case_pattern_item() throws RecognitionException {
        Case_pattern_itemContext _localctx = new Case_pattern_itemContext(_ctx, getState());
        enterRule(_localctx, 192, RULE_case_pattern_item);
        try {
            setState(1787);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 242, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1768);
                    case_pattern_tuple();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1769);
                    ((Case_pattern_itemContext) _localctx).bind = identifier();
                    setState(1770);
                    match(OP_BIND);
                    setState(1771);
                    case_pattern_item();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1773);
                    modified_identifier();
                    setState(1774);
                    match(COLON);
                    setState(1778);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 241, _ctx)) {
                        case 1: {
                            setState(1775);
                            ((Case_pattern_itemContext) _localctx).bind = identifier();
                            setState(1776);
                            match(OP_BIND);
                        }
                        break;
                    }
                    setState(1780);
                    case_pattern_item();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1782);
                    modified_identifier();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(1783);
                    namepath();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(1784);
                    number_literal();
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(1785);
                    string_literal();
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(1786);
                    match(SPECIAL);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Case_pattern_tupleContext extends ParserRuleContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public NamepathContext namepath() {
            return getRuleContext(NamepathContext.class, 0);
        }

        public TerminalNode BRACKET_L() {
            return getToken(ValkyrieAntlrParser.BRACKET_L, 0);
        }

        public TerminalNode BRACKET_R() {
            return getToken(ValkyrieAntlrParser.BRACKET_R, 0);
        }

        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Case_pattern_itemContext> case_pattern_item() {
            return getRuleContexts(Case_pattern_itemContext.class);
        }

        public Case_pattern_itemContext case_pattern_item(int i) {
            return getRuleContext(Case_pattern_itemContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public Case_pattern_tupleContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_case_pattern_tuple;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterCase_pattern_tuple(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitCase_pattern_tuple(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCase_pattern_tuple(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Case_pattern_tupleContext case_pattern_tuple() throws RecognitionException {
        Case_pattern_tupleContext _localctx = new Case_pattern_tupleContext(_ctx, getState());
        enterRule(_localctx, 194, RULE_case_pattern_tuple);
        int _la;
        try {
            int _alt;
            setState(1871);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 256, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1790);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(1789);
                            namepath();
                        }
                    }

                    setState(1792);
                    match(PARENTHESES_L);
                    setState(1793);
                    match(PARENTHESES_R);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1795);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(1794);
                            namepath();
                        }
                    }

                    setState(1797);
                    match(BRACKET_L);
                    setState(1798);
                    match(BRACKET_R);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1800);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(1799);
                            namepath();
                        }
                    }

                    setState(1802);
                    match(BRACE_L);
                    setState(1803);
                    match(BRACE_R);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1804);
                    match(PARENTHESES_L);
                    setState(1805);
                    case_pattern_item();
                    setState(1806);
                    match(COMMA);
                    setState(1807);
                    match(PARENTHESES_R);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(1809);
                    match(PARENTHESES_L);
                    setState(1810);
                    case_pattern_item();
                    setState(1813);
                    _errHandler.sync(this);
                    _alt = 1;
                    do {
                        switch (_alt) {
                            case 1: {
                                {
                                    setState(1811);
                                    match(COMMA);
                                    setState(1812);
                                    case_pattern_item();
                                }
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1815);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 246, _ctx);
                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                    setState(1818);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1817);
                            match(COMMA);
                        }
                    }

                    setState(1820);
                    match(PARENTHESES_R);
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(1822);
                    namepath();
                    setState(1823);
                    match(PARENTHESES_L);
                    setState(1824);
                    case_pattern_item();
                    setState(1829);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 248, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1825);
                                    match(COMMA);
                                    setState(1826);
                                    case_pattern_item();
                                }
                            }
                        }
                        setState(1831);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 248, _ctx);
                    }
                    setState(1833);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1832);
                            match(COMMA);
                        }
                    }

                    setState(1835);
                    match(PARENTHESES_R);
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(1838);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(1837);
                            namepath();
                        }
                    }

                    setState(1840);
                    match(BRACKET_L);
                    setState(1841);
                    case_pattern_item();
                    setState(1846);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 251, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1842);
                                    match(COMMA);
                                    setState(1843);
                                    case_pattern_item();
                                }
                            }
                        }
                        setState(1848);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 251, _ctx);
                    }
                    setState(1850);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1849);
                            match(COMMA);
                        }
                    }

                    setState(1852);
                    match(BRACKET_R);
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(1855);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(1854);
                            namepath();
                        }
                    }

                    setState(1857);
                    match(BRACE_L);
                    setState(1858);
                    case_pattern_item();
                    setState(1863);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 254, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1859);
                                    match(COMMA);
                                    setState(1860);
                                    case_pattern_item();
                                }
                            }
                        }
                        setState(1865);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 254, _ctx);
                    }
                    setState(1867);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1866);
                            match(COMMA);
                        }
                    }

                    setState(1869);
                    match(BRACE_R);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Object_statementContext extends ParserRuleContext {
        public TerminalNode KW_OBJECT() {
            return getToken(ValkyrieAntlrParser.KW_OBJECT, 0);
        }

        public Class_blockContext class_block() {
            return getRuleContext(Class_blockContext.class, 0);
        }

        public Define_genericContext define_generic() {
            return getRuleContext(Define_genericContext.class, 0);
        }

        public Class_inheritContext class_inherit() {
            return getRuleContext(Class_inheritContext.class, 0);
        }

        public Type_hintContext type_hint() {
            return getRuleContext(Type_hintContext.class, 0);
        }

        public Object_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_object_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterObject_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitObject_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitObject_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Object_statementContext object_statement() throws RecognitionException {
        Object_statementContext _localctx = new Object_statementContext(_ctx, getState());
        enterRule(_localctx, 196, RULE_object_statement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1873);
                match(KW_OBJECT);
                setState(1875);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                    {
                        setState(1874);
                        define_generic();
                    }
                }

                setState(1878);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == PARENTHESES_L) {
                    {
                        setState(1877);
                        class_inherit();
                    }
                }

                setState(1881);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(1880);
                        type_hint();
                    }
                }

                setState(1883);
                class_block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class New_statementContext extends ParserRuleContext {
        public TerminalNode KW_NEW() {
            return getToken(ValkyrieAntlrParser.KW_NEW, 0);
        }

        public Modified_namepathContext modified_namepath() {
            return getRuleContext(Modified_namepathContext.class, 0);
        }

        public New_blockContext new_block() {
            return getRuleContext(New_blockContext.class, 0);
        }

        public Generic_call_in_typeContext generic_call_in_type() {
            return getRuleContext(Generic_call_in_typeContext.class, 0);
        }

        public Tuple_call_bodyContext tuple_call_body() {
            return getRuleContext(Tuple_call_bodyContext.class, 0);
        }

        public New_statementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_new_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterNew_statement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitNew_statement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitNew_statement(this);
            else return visitor.visitChildren(this);
        }
    }

    public final New_statementContext new_statement() throws RecognitionException {
        New_statementContext _localctx = new New_statementContext(_ctx, getState());
        enterRule(_localctx, 198, RULE_new_statement);
        int _la;
        try {
            setState(1902);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 263, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1885);
                    match(KW_NEW);
                    setState(1886);
                    modified_namepath();
                    setState(1888);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                        {
                            setState(1887);
                            generic_call_in_type();
                        }
                    }

                    setState(1891);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == PARENTHESES_L) {
                        {
                            setState(1890);
                            tuple_call_body();
                        }
                    }

                    setState(1893);
                    new_block();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1895);
                    match(KW_NEW);
                    setState(1896);
                    modified_namepath();
                    setState(1898);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8796093038656L) != 0)) {
                        {
                            setState(1897);
                            generic_call_in_type();
                        }
                    }

                    setState(1900);
                    tuple_call_body();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class New_bodyContext extends ParserRuleContext {
        public New_blockContext new_block() {
            return getRuleContext(New_blockContext.class, 0);
        }

        public Tuple_call_bodyContext tuple_call_body() {
            return getRuleContext(Tuple_call_bodyContext.class, 0);
        }

        public New_bodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_new_body;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterNew_body(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitNew_body(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitNew_body(this);
            else return visitor.visitChildren(this);
        }
    }

    public final New_bodyContext new_body() throws RecognitionException {
        New_bodyContext _localctx = new New_bodyContext(_ctx, getState());
        enterRule(_localctx, 200, RULE_new_body);
        int _la;
        try {
            setState(1909);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 265, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1905);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == PARENTHESES_L) {
                        {
                            setState(1904);
                            tuple_call_body();
                        }
                    }

                    setState(1907);
                    new_block();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1908);
                    tuple_call_body();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class New_blockContext extends ParserRuleContext {
        public TerminalNode BRACE_L() {
            return getToken(ValkyrieAntlrParser.BRACE_L, 0);
        }

        public TerminalNode BRACE_R() {
            return getToken(ValkyrieAntlrParser.BRACE_R, 0);
        }

        public List<Tuple_call_itemContext> tuple_call_item() {
            return getRuleContexts(Tuple_call_itemContext.class);
        }

        public Tuple_call_itemContext tuple_call_item(int i) {
            return getRuleContext(Tuple_call_itemContext.class, i);
        }

        public List<Eos_freeContext> eos_free() {
            return getRuleContexts(Eos_freeContext.class);
        }

        public Eos_freeContext eos_free(int i) {
            return getRuleContext(Eos_freeContext.class, i);
        }

        public New_blockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_new_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterNew_block(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitNew_block(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitNew_block(this);
            else return visitor.visitChildren(this);
        }
    }

    public final New_blockContext new_block() throws RecognitionException {
        New_blockContext _localctx = new New_blockContext(_ctx, getState());
        enterRule(_localctx, 202, RULE_new_block);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1911);
                match(BRACE_L);
                setState(1916);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22755218744L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -8151515111228406911L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 65439L) != 0)) {
                    {
                        setState(1914);
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
                            case OP_REM:
                            case OP_LAST:
                            case OP_AND:
                            case OP_AT:
                            case OP_HASH:
                            case LAMBDA_SLOT:
                            case OP_NOT:
                            case OP_DOT3:
                            case OP_DOT2:
                            case OP_INVERSE:
                            case OP_ROOT2:
                            case OP_ROOT3:
                            case OP_ROOT4:
                            case OP_REFERENCE:
                            case OP_LABEL:
                            case KW_NEW:
                            case KW_OBJECT:
                            case KW_LAMBDA:
                            case KW_TRY:
                            case KW_MATCH:
                            case KW_CATCH:
                            case INTEGER:
                            case DECIMAL:
                            case STRING_SINGLE:
                            case STRING_DOUBLE:
                            case STRING_BLOCK:
                            case KW_IF:
                            case RETURN:
                            case RESUME:
                            case YIELD:
                            case BREAK:
                            case CONTINUE:
                            case RAISE:
                            case SPECIAL:
                            case RAW_ID:
                            case UNICODE_ID: {
                                setState(1912);
                                tuple_call_item();
                            }
                            break;
                            case COMMA:
                            case SEMICOLON:
                            case FAKE_COLON: {
                                setState(1913);
                                eos_free();
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(1918);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1919);
                match(BRACE_R);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Tuple_literalContext extends ParserRuleContext {
        public TerminalNode PARENTHESES_L() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_L, 0);
        }

        public TerminalNode PARENTHESES_R() {
            return getToken(ValkyrieAntlrParser.PARENTHESES_R, 0);
        }

        public List<Collection_pairContext> collection_pair() {
            return getRuleContexts(Collection_pairContext.class);
        }

        public Collection_pairContext collection_pair(int i) {
            return getRuleContext(Collection_pairContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public Tuple_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tuple_literal;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterTuple_literal(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitTuple_literal(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitTuple_literal(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Tuple_literalContext tuple_literal() throws RecognitionException {
        Tuple_literalContext _localctx = new Tuple_literalContext(_ctx, getState());
        enterRule(_localctx, 204, RULE_tuple_literal);
        int _la;
        try {
            int _alt;
            setState(1941);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 270, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1921);
                    match(PARENTHESES_L);
                    setState(1922);
                    match(PARENTHESES_R);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1923);
                    match(PARENTHESES_L);
                    setState(1924);
                    collection_pair();
                    setState(1927);
                    _errHandler.sync(this);
                    _alt = 1;
                    do {
                        switch (_alt) {
                            case 1: {
                                {
                                    setState(1925);
                                    match(COMMA);
                                    setState(1926);
                                    collection_pair();
                                }
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1929);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 268, _ctx);
                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                    setState(1932);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == COMMA) {
                        {
                            setState(1931);
                            match(COMMA);
                        }
                    }

                    setState(1934);
                    match(PARENTHESES_R);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1936);
                    match(PARENTHESES_L);
                    setState(1937);
                    collection_pair();
                    setState(1938);
                    match(COMMA);
                    setState(1939);
                    match(PARENTHESES_R);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Collection_pairContext extends ParserRuleContext {
        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode COLON() {
            return getToken(ValkyrieAntlrParser.COLON, 0);
        }

        public Collection_pairContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_collection_pair;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterCollection_pair(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitCollection_pair(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitCollection_pair(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Collection_pairContext collection_pair() throws RecognitionException {
        Collection_pairContext _localctx = new Collection_pairContext(_ctx, getState());
        enterRule(_localctx, 206, RULE_collection_pair);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1946);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 271, _ctx)) {
                    case 1: {
                        setState(1943);
                        identifier();
                        setState(1944);
                        match(COLON);
                    }
                    break;
                }
                setState(1948);
                expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Slice_callContext extends ParserRuleContext {
        public Range_literalContext range_literal() {
            return getRuleContext(Range_literalContext.class, 0);
        }

        public TerminalNode OP_AND_THEN() {
            return getToken(ValkyrieAntlrParser.OP_AND_THEN, 0);
        }

        public Slice_callContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_slice_call;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterSlice_call(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitSlice_call(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitSlice_call(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Slice_callContext slice_call() throws RecognitionException {
        Slice_callContext _localctx = new Slice_callContext(_ctx, getState());
        enterRule(_localctx, 208, RULE_slice_call);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1951);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OP_AND_THEN) {
                    {
                        setState(1950);
                        match(OP_AND_THEN);
                    }
                }

                setState(1953);
                range_literal();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Range_literalContext extends ParserRuleContext {
        public Range_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_range_literal;
        }

        public Range_literalContext() {
        }

        public void copyFrom(Range_literalContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class OrdinalContext extends Range_literalContext {
        public TerminalNode BRACKET_L() {
            return getToken(ValkyrieAntlrParser.BRACKET_L, 0);
        }

        public TerminalNode BRACKET_R() {
            return getToken(ValkyrieAntlrParser.BRACKET_R, 0);
        }

        public List<Range_axisContext> range_axis() {
            return getRuleContexts(Range_axisContext.class);
        }

        public Range_axisContext range_axis(int i) {
            return getRuleContext(Range_axisContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public OrdinalContext(Range_literalContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOrdinal(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOrdinal(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOrdinal(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class OffsetContext extends Range_literalContext {
        public TerminalNode OFFSET_L() {
            return getToken(ValkyrieAntlrParser.OFFSET_L, 0);
        }

        public TerminalNode OFFSET_R() {
            return getToken(ValkyrieAntlrParser.OFFSET_R, 0);
        }

        public List<Range_axisContext> range_axis() {
            return getRuleContexts(Range_axisContext.class);
        }

        public Range_axisContext range_axis(int i) {
            return getRuleContext(Range_axisContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(ValkyrieAntlrParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(ValkyrieAntlrParser.COMMA, i);
        }

        public OffsetContext(Range_literalContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterOffset(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitOffset(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitOffset(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Range_literalContext range_literal() throws RecognitionException {
        Range_literalContext _localctx = new Range_literalContext(_ctx, getState());
        enterRule(_localctx, 210, RULE_range_literal);
        int _la;
        try {
            int _alt;
            setState(1985);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case BRACKET_L:
                    _localctx = new OrdinalContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1955);
                    match(BRACKET_L);
                    setState(1967);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22755218880L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -8151515111228406911L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 65439L) != 0)) {
                        {
                            setState(1956);
                            range_axis();
                            setState(1961);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 273, _ctx);
                            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                                if (_alt == 1) {
                                    {
                                        {
                                            setState(1957);
                                            match(COMMA);
                                            setState(1958);
                                            range_axis();
                                        }
                                    }
                                }
                                setState(1963);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 273, _ctx);
                            }
                            setState(1965);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == COMMA) {
                                {
                                    setState(1964);
                                    match(COMMA);
                                }
                            }

                        }
                    }

                    setState(1969);
                    match(BRACKET_R);
                }
                break;
                case OFFSET_L:
                    _localctx = new OffsetContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1970);
                    match(OFFSET_L);
                    setState(1982);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 22755218880L) != 0) || ((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & -8151515111228406911L) != 0) || ((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 65439L) != 0)) {
                        {
                            setState(1971);
                            range_axis();
                            setState(1976);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 276, _ctx);
                            while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                                if (_alt == 1) {
                                    {
                                        {
                                            setState(1972);
                                            match(COMMA);
                                            setState(1973);
                                            range_axis();
                                        }
                                    }
                                }
                                setState(1978);
                                _errHandler.sync(this);
                                _alt = getInterpreter().adaptivePredict(_input, 276, _ctx);
                            }
                            setState(1980);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == COMMA) {
                                {
                                    setState(1979);
                                    match(COMMA);
                                }
                            }

                        }
                    }

                    setState(1984);
                    match(OFFSET_R);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Range_axisContext extends ParserRuleContext {
        public ExpressionContext index;
        public ExpressionContext head;
        public ExpressionContext tail;
        public ExpressionContext step;
        public ExpressionContext setp;

        public List<TerminalNode> COLON() {
            return getTokens(ValkyrieAntlrParser.COLON);
        }

        public TerminalNode COLON(int i) {
            return getToken(ValkyrieAntlrParser.COLON, i);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode OP_PROPORTION() {
            return getToken(ValkyrieAntlrParser.OP_PROPORTION, 0);
        }

        public Range_axisContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_range_axis;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterRange_axis(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitRange_axis(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitRange_axis(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Range_axisContext range_axis() throws RecognitionException {
        Range_axisContext _localctx = new Range_axisContext(_ctx, getState());
        enterRule(_localctx, 212, RULE_range_axis);
        try {
            setState(2043);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 284, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1987);
                    match(COLON);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1988);
                    ((Range_axisContext) _localctx).index = expression(0);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1989);
                    ((Range_axisContext) _localctx).head = expression(0);
                    setState(1990);
                    match(COLON);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1992);
                    match(COLON);
                    setState(1993);
                    ((Range_axisContext) _localctx).tail = expression(0);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(1994);
                    ((Range_axisContext) _localctx).head = expression(0);
                    setState(1995);
                    match(COLON);
                    setState(1996);
                    ((Range_axisContext) _localctx).tail = expression(0);
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(2001);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case OP_PROPORTION: {
                            setState(1998);
                            match(OP_PROPORTION);
                        }
                        break;
                        case COLON: {
                            setState(1999);
                            match(COLON);
                            setState(2000);
                            match(COLON);
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(2003);
                    ((Range_axisContext) _localctx).head = expression(0);
                    setState(2007);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case OP_PROPORTION: {
                            setState(2004);
                            match(OP_PROPORTION);
                        }
                        break;
                        case COLON: {
                            setState(2005);
                            match(COLON);
                            setState(2006);
                            match(COLON);
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(2009);
                    match(COLON);
                    setState(2010);
                    ((Range_axisContext) _localctx).tail = expression(0);
                    setState(2011);
                    match(COLON);
                }
                break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(2016);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case OP_PROPORTION: {
                            setState(2013);
                            match(OP_PROPORTION);
                        }
                        break;
                        case COLON: {
                            setState(2014);
                            match(COLON);
                            setState(2015);
                            match(COLON);
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(2018);
                    ((Range_axisContext) _localctx).step = expression(0);
                }
                break;
                case 10:
                    enterOuterAlt(_localctx, 10);
                {
                    setState(2019);
                    ((Range_axisContext) _localctx).head = expression(0);
                    setState(2020);
                    match(COLON);
                    setState(2021);
                    ((Range_axisContext) _localctx).tail = expression(0);
                    setState(2022);
                    match(COLON);
                }
                break;
                case 11:
                    enterOuterAlt(_localctx, 11);
                {
                    setState(2024);
                    match(COLON);
                    setState(2025);
                    ((Range_axisContext) _localctx).tail = expression(0);
                    setState(2026);
                    match(COLON);
                    setState(2027);
                    ((Range_axisContext) _localctx).step = expression(0);
                }
                break;
                case 12:
                    enterOuterAlt(_localctx, 12);
                {
                    setState(2029);
                    ((Range_axisContext) _localctx).head = expression(0);
                    setState(2033);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case OP_PROPORTION: {
                            setState(2030);
                            match(OP_PROPORTION);
                        }
                        break;
                        case COLON: {
                            setState(2031);
                            match(COLON);
                            setState(2032);
                            match(COLON);
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(2035);
                    ((Range_axisContext) _localctx).setp = expression(0);
                }
                break;
                case 13:
                    enterOuterAlt(_localctx, 13);
                {
                    setState(2037);
                    ((Range_axisContext) _localctx).head = expression(0);
                    setState(2038);
                    match(COLON);
                    setState(2039);
                    ((Range_axisContext) _localctx).tail = expression(0);
                    setState(2040);
                    match(COLON);
                    setState(2041);
                    ((Range_axisContext) _localctx).step = expression(0);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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
            return getRuleContext(IdentifierContext.class, i);
        }

        public ModifiersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_modifiers;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterModifiers(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitModifiers(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitModifiers(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ModifiersContext modifiers() throws RecognitionException {
        ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
        enterRule(_localctx, 214, RULE_modifiers);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(2048);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == RAW_ID || _la == UNICODE_ID) {
                    {
                        {
                            setState(2045);
                            ((ModifiersContext) _localctx).identifier = identifier();
                            ((ModifiersContext) _localctx).mods.add(((ModifiersContext) _localctx).identifier);
                        }
                    }
                    setState(2050);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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
            return getRuleContext(IdentifierContext.class, i);
        }

        public Modified_identifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_modified_identifier;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterModified_identifier(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitModified_identifier(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitModified_identifier(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Modified_identifierContext modified_identifier() throws RecognitionException {
        Modified_identifierContext _localctx = new Modified_identifierContext(_ctx, getState());
        enterRule(_localctx, 216, RULE_modified_identifier);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(2054);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 286, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(2051);
                                ((Modified_identifierContext) _localctx).identifier = identifier();
                                ((Modified_identifierContext) _localctx).mods.add(((Modified_identifierContext) _localctx).identifier);
                            }
                        }
                    }
                    setState(2056);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 286, _ctx);
                }
                setState(2057);
                ((Modified_identifierContext) _localctx).id = identifier();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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
            return getRuleContext(IdentifierContext.class, i);
        }

        public List<TerminalNode> OP_PROPORTION() {
            return getTokens(ValkyrieAntlrParser.OP_PROPORTION);
        }

        public TerminalNode OP_PROPORTION(int i) {
            return getToken(ValkyrieAntlrParser.OP_PROPORTION, i);
        }

        public Modified_namepathContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_modified_namepath;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).enterModified_namepath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener)
                ((ValkyrieAntlrListener) listener).exitModified_namepath(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitModified_namepath(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Modified_namepathContext modified_namepath() throws RecognitionException {
        Modified_namepathContext _localctx = new Modified_namepathContext(_ctx, getState());
        enterRule(_localctx, 218, RULE_modified_namepath);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(2062);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 287, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(2059);
                                ((Modified_namepathContext) _localctx).identifier = identifier();
                                ((Modified_namepathContext) _localctx).mods.add(((Modified_namepathContext) _localctx).identifier);
                            }
                        }
                    }
                    setState(2064);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 287, _ctx);
                }
                setState(2065);
                ((Modified_namepathContext) _localctx).identifier = identifier();
                ((Modified_namepathContext) _localctx).path.add(((Modified_namepathContext) _localctx).identifier);
                setState(2070);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 288, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(2066);
                                match(OP_PROPORTION);
                                setState(2067);
                                ((Modified_namepathContext) _localctx).identifier = identifier();
                                ((Modified_namepathContext) _localctx).path.add(((Modified_namepathContext) _localctx).identifier);
                            }
                        }
                    }
                    setState(2072);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 288, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Lambda_nameContext extends ParserRuleContext {
        public TerminalNode LAMBDA_SLOT() {
            return getToken(ValkyrieAntlrParser.LAMBDA_SLOT, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public NumberContext number() {
            return getRuleContext(NumberContext.class, 0);
        }

        public Lambda_nameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lambda_name;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterLambda_name(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitLambda_name(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitLambda_name(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Lambda_nameContext lambda_name() throws RecognitionException {
        Lambda_nameContext _localctx = new Lambda_nameContext(_ctx, getState());
        enterRule(_localctx, 220, RULE_lambda_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(2073);
                match(LAMBDA_SLOT);
                setState(2076);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 289, _ctx)) {
                    case 1: {
                        setState(2074);
                        identifier();
                    }
                    break;
                    case 2: {
                        setState(2075);
                        number();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Output_nameContext extends ParserRuleContext {
        public Output_nameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_output_name;
        }

        public Output_nameContext() {
        }

        public void copyFrom(Output_nameContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PositiveOutputContext extends Output_nameContext {
        public TerminalNode OP_REM() {
            return getToken(ValkyrieAntlrParser.OP_REM, 0);
        }

        public TerminalNode INTEGER() {
            return getToken(ValkyrieAntlrParser.INTEGER, 0);
        }

        public PositiveOutputContext(Output_nameContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterPositiveOutput(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitPositiveOutput(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitPositiveOutput(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NegativeOutputContext extends Output_nameContext {
        public TerminalNode OP_LAST() {
            return getToken(ValkyrieAntlrParser.OP_LAST, 0);
        }

        public TerminalNode INTEGER() {
            return getToken(ValkyrieAntlrParser.INTEGER, 0);
        }

        public NegativeOutputContext(Output_nameContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterNegativeOutput(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitNegativeOutput(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitNegativeOutput(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Output_nameContext output_name() throws RecognitionException {
        Output_nameContext _localctx = new Output_nameContext(_ctx, getState());
        enterRule(_localctx, 222, RULE_output_name);
        try {
            setState(2084);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OP_REM:
                    _localctx = new PositiveOutputContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                {
                    setState(2078);
                    match(OP_REM);
                    setState(2079);
                    match(INTEGER);
                }
                break;
                case OP_LAST:
                    _localctx = new NegativeOutputContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                {
                    setState(2080);
                    match(OP_LAST);
                    setState(2082);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 290, _ctx)) {
                        case 1: {
                            setState(2081);
                            match(INTEGER);
                        }
                        break;
                    }
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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
            return getRuleContext(IdentifierContext.class, i);
        }

        public List<TerminalNode> OP_PROPORTION() {
            return getTokens(ValkyrieAntlrParser.OP_PROPORTION);
        }

        public TerminalNode OP_PROPORTION(int i) {
            return getToken(ValkyrieAntlrParser.OP_PROPORTION, i);
        }

        public List<TerminalNode> DOT() {
            return getTokens(ValkyrieAntlrParser.DOT);
        }

        public TerminalNode DOT(int i) {
            return getToken(ValkyrieAntlrParser.DOT, i);
        }

        public Namepath_freeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namepath_free;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterNamepath_free(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitNamepath_free(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitNamepath_free(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Namepath_freeContext namepath_free() throws RecognitionException {
        Namepath_freeContext _localctx = new Namepath_freeContext(_ctx, getState());
        enterRule(_localctx, 224, RULE_namepath_free);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(2086);
                identifier();
                setState(2091);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == DOT || _la == OP_PROPORTION) {
                    {
                        {
                            setState(2087);
                            _la = _input.LA(1);
                            if (!(_la == DOT || _la == OP_PROPORTION)) {
                                _errHandler.recoverInline(this);
                            } else {
                                if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                _errHandler.reportMatch(this);
                                consume();
                            }
                            setState(2088);
                            identifier();
                        }
                    }
                    setState(2093);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
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
            return getRuleContext(IdentifierContext.class, i);
        }

        public List<TerminalNode> OP_PROPORTION() {
            return getTokens(ValkyrieAntlrParser.OP_PROPORTION);
        }

        public TerminalNode OP_PROPORTION(int i) {
            return getToken(ValkyrieAntlrParser.OP_PROPORTION, i);
        }

        public NamepathContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namepath;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterNamepath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitNamepath(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitNamepath(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NamepathContext namepath() throws RecognitionException {
        NamepathContext _localctx = new NamepathContext(_ctx, getState());
        enterRule(_localctx, 226, RULE_namepath);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(2094);
                identifier();
                setState(2099);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 293, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(2095);
                                match(OP_PROPORTION);
                                setState(2096);
                                identifier();
                            }
                        }
                    }
                    setState(2101);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 293, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IdentifierContext extends ParserRuleContext {
        public TerminalNode UNICODE_ID() {
            return getToken(ValkyrieAntlrParser.UNICODE_ID, 0);
        }

        public TerminalNode RAW_ID() {
            return getToken(ValkyrieAntlrParser.RAW_ID, 0);
        }

        public IdentifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_identifier;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterIdentifier(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitIdentifier(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitIdentifier(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IdentifierContext identifier() throws RecognitionException {
        IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
        enterRule(_localctx, 228, RULE_identifier);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(2102);
                _la = _input.LA(1);
                if (!(_la == RAW_ID || _la == UNICODE_ID)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NumberContext extends ParserRuleContext {
        public TerminalNode DECIMAL() {
            return getToken(ValkyrieAntlrParser.DECIMAL, 0);
        }

        public TerminalNode INTEGER() {
            return getToken(ValkyrieAntlrParser.INTEGER, 0);
        }

        public NumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_number;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitNumber(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NumberContext number() throws RecognitionException {
        NumberContext _localctx = new NumberContext(_ctx, getState());
        enterRule(_localctx, 230, RULE_number);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(2104);
                _la = _input.LA(1);
                if (!(_la == INTEGER || _la == DECIMAL)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Number_literalContext extends ParserRuleContext {
        public NumberContext number() {
            return getRuleContext(NumberContext.class, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public Number_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_number_literal;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterNumber_literal(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitNumber_literal(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitNumber_literal(this);
            else return visitor.visitChildren(this);
        }
    }

    public final Number_literalContext number_literal() throws RecognitionException {
        Number_literalContext _localctx = new Number_literalContext(_ctx, getState());
        enterRule(_localctx, 232, RULE_number_literal);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(2106);
                number();
                setState(2108);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 294, _ctx)) {
                    case 1: {
                        setState(2107);
                        identifier();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StringContext extends ParserRuleContext {
        public TerminalNode STRING_SINGLE() {
            return getToken(ValkyrieAntlrParser.STRING_SINGLE, 0);
        }

        public TerminalNode STRING_DOUBLE() {
            return getToken(ValkyrieAntlrParser.STRING_DOUBLE, 0);
        }

        public StringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitString(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StringContext string() throws RecognitionException {
        StringContext _localctx = new StringContext(_ctx, getState());
        enterRule(_localctx, 234, RULE_string);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(2110);
                _la = _input.LA(1);
                if (!(_la == STRING_SINGLE || _la == STRING_DOUBLE)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class String_literalContext extends ParserRuleContext {
        public TerminalNode STRING_SINGLE() {
            return getToken(ValkyrieAntlrParser.STRING_SINGLE, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode STRING_DOUBLE() {
            return getToken(ValkyrieAntlrParser.STRING_DOUBLE, 0);
        }

        public TerminalNode STRING_BLOCK() {
            return getToken(ValkyrieAntlrParser.STRING_BLOCK, 0);
        }

        public String_literalContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string_literal;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).enterString_literal(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ValkyrieAntlrListener) ((ValkyrieAntlrListener) listener).exitString_literal(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ValkyrieAntlrVisitor)
                return ((ValkyrieAntlrVisitor<? extends T>) visitor).visitString_literal(this);
            else return visitor.visitChildren(this);
        }
    }

    public final String_literalContext string_literal() throws RecognitionException {
        String_literalContext _localctx = new String_literalContext(_ctx, getState());
        enterRule(_localctx, 236, RULE_string_literal);
        int _la;
        try {
            setState(2124);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 298, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(2113);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(2112);
                            identifier();
                        }
                    }

                    setState(2115);
                    match(STRING_SINGLE);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(2117);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(2116);
                            identifier();
                        }
                    }

                    setState(2119);
                    match(STRING_DOUBLE);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(2121);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == RAW_ID || _la == UNICODE_ID) {
                        {
                            setState(2120);
                            identifier();
                        }
                    }

                    setState(2123);
                    match(STRING_BLOCK);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 54:
                return expression_sempred((ExpressionContext) _localctx, predIndex);
            case 55:
                return inline_expression_sempred((Inline_expressionContext) _localctx, predIndex);
            case 56:
                return type_expression_sempred((Type_expressionContext) _localctx, predIndex);
            case 95:
                return case_pattern_sempred((Case_patternContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 29);
            case 1:
                return precpred(_ctx, 28);
            case 2:
                return precpred(_ctx, 27);
            case 3:
                return precpred(_ctx, 26);
            case 4:
                return precpred(_ctx, 25);
            case 5:
                return precpred(_ctx, 24);
            case 6:
                return precpred(_ctx, 23);
            case 7:
                return precpred(_ctx, 20);
            case 8:
                return precpred(_ctx, 18);
            case 9:
                return precpred(_ctx, 17);
            case 10:
                return precpred(_ctx, 36);
            case 11:
                return precpred(_ctx, 35);
            case 12:
                return precpred(_ctx, 34);
            case 13:
                return precpred(_ctx, 33);
            case 14:
                return precpred(_ctx, 32);
            case 15:
                return precpred(_ctx, 31);
            case 16:
                return precpred(_ctx, 22);
            case 17:
                return precpred(_ctx, 21);
            case 18:
                return precpred(_ctx, 19);
        }
        return true;
    }

    private boolean inline_expression_sempred(Inline_expressionContext _localctx, int predIndex) {
        switch (predIndex) {
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
                return precpred(_ctx, 17);
            case 26:
                return precpred(_ctx, 16);
            case 27:
                return precpred(_ctx, 15);
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
                return precpred(_ctx, 6);
            case 31:
                return precpred(_ctx, 5);
            case 32:
                return precpred(_ctx, 4);
            case 33:
                return precpred(_ctx, 7);
            case 34:
                return precpred(_ctx, 3);
        }
        return true;
    }

    private boolean case_pattern_sempred(Case_patternContext _localctx, int predIndex) {
        switch (predIndex) {
            case 35:
                return precpred(_ctx, 3);
            case 36:
                return precpred(_ctx, 2);
        }
        return true;
    }

    public static final String _serializedATN =
            "\u0004\u0001\u0098\u084f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001" +
                    "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004" +
                    "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007" +
                    "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b" +
                    "\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007" +
                    "\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007" +
                    "\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007" +
                    "\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007" +
                    "\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007" +
                    "\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007" +
                    "\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007" +
                    "\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007" +
                    "\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007" +
                    ",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007" +
                    "1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007" +
                    "6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007" +
                    ";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007" +
                    "@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007" +
                    "E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007" +
                    "J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007" +
                    "O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007" +
                    "T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007" +
                    "Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007" +
                    "^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007" +
                    "c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007" +
                    "h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007" +
                    "m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007" +
                    "r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0001\u0000" +
                    "\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000" +
                    "\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000" +
                    "\u0001\u0000\u0001\u0000\u0005\u0000\u00fe\b\u0000\n\u0000\f\u0000\u0101" +
                    "\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001" +
                    "\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u010c\b\u0003\u0001" +
                    "\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0003\u0005\u0113" +
                    "\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001" +
                    "\u0006\u0003\u0006\u011b\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003" +
                    "\u0006\u0120\b\u0006\u0001\u0006\u0003\u0006\u0123\b\u0006\u0001\u0006" +
                    "\u0001\u0006\u0001\u0006\u0003\u0006\u0128\b\u0006\u0001\u0006\u0001\u0006" +
                    "\u0001\u0006\u0003\u0006\u012d\b\u0006\u0001\u0006\u0003\u0006\u0130\b" +
                    "\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0134\b\u0006\u0001\u0006\u0001" +
                    "\u0006\u0003\u0006\u0138\b\u0006\u0001\u0006\u0003\u0006\u013b\b\u0006" +
                    "\u0001\u0006\u0003\u0006\u013e\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007" +
                    "\u0005\u0007\u0143\b\u0007\n\u0007\f\u0007\u0146\t\u0007\u0001\u0007\u0001" +
                    "\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u014f\b\b\n" +
                    "\b\f\b\u0152\t\b\u0001\b\u0003\b\u0155\b\b\u0001\t\u0001\t\u0001\n\u0003" +
                    "\n\u015a\b\n\u0001\n\u0005\n\u015d\b\n\n\n\f\n\u0160\t\n\u0001\n\u0001" +
                    "\n\u0001\n\u0001\n\u0003\n\u0166\b\n\u0001\n\u0003\n\u0169\b\n\u0001\n" +
                    "\u0003\n\u016c\b\n\u0001\n\u0001\n\u0003\n\u0170\b\n\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0177\b\u000b\n" +
                    "\u000b\f\u000b\u017a\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001" +
                    "\f\u0001\f\u0001\f\u0001\f\u0005\f\u0184\b\f\n\f\f\f\u0187\t\f\u0001\f" +
                    "\u0003\f\u018a\b\f\u0001\f\u0001\f\u0003\f\u018e\b\f\u0001\r\u0001\r\u0001" +
                    "\u000e\u0005\u000e\u0193\b\u000e\n\u000e\f\u000e\u0196\t\u000e\u0001\u000e" +
                    "\u0001\u000e\u0003\u000e\u019a\b\u000e\u0001\u000e\u0003\u000e\u019d\b" +
                    "\u000e\u0001\u000f\u0005\u000f\u01a0\b\u000f\n\u000f\f\u000f\u01a3\t\u000f" +
                    "\u0001\u000f\u0001\u000f\u0003\u000f\u01a7\b\u000f\u0001\u000f\u0001\u000f" +
                    "\u0003\u000f\u01ab\b\u000f\u0001\u000f\u0003\u000f\u01ae\b\u000f\u0001" +
                    "\u0010\u0005\u0010\u01b1\b\u0010\n\u0010\f\u0010\u01b4\t\u0010\u0001\u0010" +
                    "\u0001\u0010\u0001\u0010\u0001\u0011\u0003\u0011\u01ba\b\u0011\u0001\u0011" +
                    "\u0005\u0011\u01bd\b\u0011\n\u0011\f\u0011\u01c0\t\u0011\u0001\u0011\u0001" +
                    "\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01c6\b\u0011\u0001\u0011\u0003" +
                    "\u0011\u01c9\b\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u01cd\b\u0011" +
                    "\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012" +
                    "\u01d4\b\u0012\n\u0012\f\u0012\u01d7\t\u0012\u0001\u0012\u0001\u0012\u0001" +
                    "\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u01df\b\u0013\u0001" +
                    "\u0014\u0003\u0014\u01e2\b\u0014\u0001\u0014\u0005\u0014\u01e5\b\u0014" +
                    "\n\u0014\f\u0014\u01e8\t\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001" +
                    "\u0014\u0003\u0014\u01ee\b\u0014\u0001\u0014\u0003\u0014\u01f1\b\u0014" +
                    "\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015" +
                    "\u0005\u0015\u01f9\b\u0015\n\u0015\f\u0015\u01fc\t\u0015\u0001\u0015\u0001" +
                    "\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0003\u0017\u0204" +
                    "\b\u0017\u0001\u0017\u0005\u0017\u0207\b\u0017\n\u0017\f\u0017\u020a\t" +
                    "\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0210" +
                    "\b\u0017\u0001\u0017\u0003\u0017\u0213\b\u0017\u0001\u0017\u0003\u0017" +
                    "\u0216\b\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0003\u0018" +
                    "\u021c\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019" +
                    "\u0001\u0019\u0005\u0019\u0224\b\u0019\n\u0019\f\u0019\u0227\t\u0019\u0001" +
                    "\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0003\u001a\u022d\b\u001a\u0001" +
                    "\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u0232\b\u001b\n\u001b\f\u001b" +
                    "\u0235\t\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0005\u001c\u023a\b" +
                    "\u001c\n\u001c\f\u001c\u023d\t\u001c\u0001\u001c\u0001\u001c\u0001\u001c" +
                    "\u0001\u001c\u0003\u001c\u0243\b\u001c\u0001\u001c\u0003\u001c\u0246\b" +
                    "\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001" +
                    "\u001d\u0005\u001d\u024e\b\u001d\n\u001d\f\u001d\u0251\t\u001d\u0001\u001d" +
                    "\u0001\u001d\u0001\u001e\u0005\u001e\u0256\b\u001e\n\u001e\f\u001e\u0259" +
                    "\t\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u025e\b\u001e" +
                    "\u0001\u001f\u0003\u001f\u0261\b\u001f\u0001\u001f\u0005\u001f\u0264\b" +
                    "\u001f\n\u001f\f\u001f\u0267\t\u001f\u0001\u001f\u0001\u001f\u0001\u001f" +
                    "\u0001\u001f\u0003\u001f\u026d\b\u001f\u0001\u001f\u0001\u001f\u0003\u001f" +
                    "\u0271\b\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001 \u0001 \u0001" +
                    " \u0001 \u0005 \u027b\b \n \f \u027e\t \u0001 \u0001 \u0003 \u0282\b " +
                    "\u0001!\u0005!\u0285\b!\n!\f!\u0288\t!\u0001!\u0005!\u028b\b!\n!\f!\u028e" +
                    "\t!\u0001!\u0001!\u0003!\u0292\b!\u0001!\u0003!\u0295\b!\u0001!\u0003" +
                    "!\u0298\b!\u0001!\u0005!\u029b\b!\n!\f!\u029e\t!\u0001!\u0005!\u02a1\b" +
                    "!\n!\f!\u02a4\t!\u0001!\u0001!\u0003!\u02a8\b!\u0001!\u0003!\u02ab\b!" +
                    "\u0001!\u0003!\u02ae\b!\u0001!\u0005!\u02b1\b!\n!\f!\u02b4\t!\u0001!\u0005" +
                    "!\u02b7\b!\n!\f!\u02ba\t!\u0001!\u0001!\u0003!\u02be\b!\u0001!\u0003!" +
                    "\u02c1\b!\u0001!\u0001!\u0003!\u02c5\b!\u0001\"\u0001\"\u0001\"\u0001" +
                    "\"\u0003\"\u02cb\b\"\u0001#\u0001#\u0001#\u0001$\u0003$\u02d1\b$\u0001" +
                    "$\u0001$\u0003$\u02d5\b$\u0001$\u0001$\u0001$\u0003$\u02da\b$\u0001$\u0003" +
                    "$\u02dd\b$\u0001$\u0001$\u0003$\u02e1\b$\u0001$\u0001$\u0003$\u02e5\b" +
                    "$\u0003$\u02e7\b$\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0005%\u02ef" +
                    "\b%\n%\f%\u02f2\t%\u0001%\u0003%\u02f5\b%\u0001%\u0001%\u0003%\u02f9\b" +
                    "%\u0001&\u0001&\u0001&\u0001&\u0001&\u0003&\u0300\b&\u0001\'\u0005\'\u0303" +
                    "\b\'\n\'\f\'\u0306\t\'\u0001\'\u0001\'\u0001\'\u0003\'\u030b\b\'\u0001" +
                    "\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0005(\u0316" +
                    "\b(\n(\f(\u0319\t(\u0001(\u0001(\u0001)\u0005)\u031e\b)\n)\f)\u0321\t" +
                    ")\u0001)\u0001)\u0001)\u0003)\u0326\b)\u0001)\u0001)\u0003)\u032a\b)\u0001" +
                    "*\u0001*\u0003*\u032e\b*\u0001+\u0001+\u0001+\u0005+\u0333\b+\n+\f+\u0336" +
                    "\t+\u0001+\u0003+\u0339\b+\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001" +
                    ",\u0004,\u0342\b,\u000b,\f,\u0343\u0001,\u0003,\u0347\b,\u0003,\u0349" +
                    "\b,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0005,\u0351\b,\n,\f,\u0354" +
                    "\t,\u0001,\u0003,\u0357\b,\u0003,\u0359\b,\u0001,\u0001,\u0001,\u0003" +
                    ",\u035e\b,\u0001,\u0001,\u0001,\u0001,\u0005,\u0364\b,\n,\f,\u0367\t," +
                    "\u0001,\u0003,\u036a\b,\u0003,\u036c\b,\u0001,\u0001,\u0003,\u0370\b," +
                    "\u0001,\u0001,\u0001,\u0001,\u0005,\u0376\b,\n,\f,\u0379\t,\u0001,\u0003" +
                    ",\u037c\b,\u0003,\u037e\b,\u0001,\u0003,\u0381\b,\u0001-\u0001-\u0001" +
                    "-\u0003-\u0386\b-\u0001-\u0001-\u0001-\u0003-\u038b\b-\u0001-\u0001-\u0001" +
                    "-\u0001-\u0003-\u0391\b-\u0001-\u0001-\u0001-\u0003-\u0396\b-\u0001-\u0001" +
                    "-\u0003-\u039a\b-\u0001-\u0001-\u0003-\u039e\b-\u0001-\u0003-\u03a1\b" +
                    "-\u0001.\u0005.\u03a4\b.\n.\f.\u03a7\t.\u0001.\u0001.\u0001.\u0001.\u0003" +
                    ".\u03ad\b.\u0001.\u0001.\u0001.\u0001.\u0005.\u03b3\b.\n.\f.\u03b6\t." +
                    "\u0001.\u0001.\u0001.\u0001.\u0003.\u03bc\b.\u0001.\u0001.\u0003.\u03c0" +
                    "\b.\u0001/\u0001/\u0001/\u00010\u00050\u03c6\b0\n0\f0\u03c9\t0\u00010" +
                    "\u00010\u00010\u00010\u00050\u03cf\b0\n0\f0\u03d2\t0\u00010\u00010\u0003" +
                    "0\u03d6\b0\u00011\u00051\u03d9\b1\n1\f1\u03dc\t1\u00011\u00011\u00011" +
                    "\u00011\u00011\u00031\u03e3\b1\u00011\u00011\u00011\u00011\u00011\u0005" +
                    "1\u03ea\b1\n1\f1\u03ed\t1\u00011\u00011\u00011\u00011\u00011\u00031\u03f4" +
                    "\b1\u00012\u00012\u00012\u00012\u00012\u00013\u00053\u03fc\b3\n3\f3\u03ff" +
                    "\t3\u00013\u00013\u00013\u00013\u00013\u00053\u0406\b3\n3\f3\u0409\t3" +
                    "\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00013\u00053\u0413" +
                    "\b3\n3\f3\u0416\t3\u00013\u00013\u00013\u00013\u00013\u00013\u00033\u041e" +
                    "\b3\u00013\u00013\u00033\u0422\b3\u00014\u00014\u00014\u00015\u00055\u0428" +
                    "\b5\n5\f5\u042b\t5\u00015\u00015\u00035\u042f\b5\u00015\u00035\u0432\b" +
                    "5\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001" +
                    "6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001" +
                    "6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0003" +
                    "6\u0451\b6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001" +
                    "6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001" +
                    "6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001" +
                    "6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001" +
                    "6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001" +
                    "6\u00016\u00036\u0485\b6\u00016\u00036\u0488\b6\u00016\u00016\u00016\u0003" +
                    "6\u048d\b6\u00016\u00016\u00016\u00016\u00016\u00036\u0494\b6\u00036\u0496" +
                    "\b6\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u00016\u0001" +
                    "6\u00016\u00016\u00056\u04a4\b6\n6\f6\u04a7\t6\u00017\u00017\u00017\u0001" +
                    "7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001" +
                    "7\u00017\u00017\u00017\u00017\u00017\u00037\u04bc\b7\u00017\u00017\u0001" +
                    "7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001" +
                    "7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001" +
                    "7\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u00017\u0001" +
                    "7\u00017\u00017\u00017\u00017\u00017\u00057\u04e4\b7\n7\f7\u04e7\t7\u0001" +
                    "8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0001" +
                    "8\u00048\u04f4\b8\u000b8\f8\u04f5\u00018\u00038\u04f9\b8\u00038\u04fb" +
                    "\b8\u00018\u00018\u00038\u04ff\b8\u00018\u00018\u00018\u00018\u00018\u0001" +
                    "8\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u00018\u0005" +
                    "8\u0510\b8\n8\f8\u0513\t8\u00019\u00019\u00019\u00019\u00019\u00019\u0003" +
                    "9\u051b\b9\u0001:\u0001:\u0001:\u0003:\u0520\b:\u0003:\u0522\b:\u0001" +
                    ":\u0001:\u0001:\u0003:\u0527\b:\u0001:\u0001:\u0001:\u0003:\u052c\b:\u0001" +
                    ":\u0001:\u0001:\u0001:\u0001:\u0003:\u0533\b:\u0001:\u0003:\u0536\b:\u0001" +
                    ":\u0001:\u0001:\u0001:\u0001:\u0003:\u053d\b:\u0001;\u0001;\u0001<\u0001" +
                    "<\u0001=\u0001=\u0001>\u0001>\u0001?\u0001?\u0001@\u0001@\u0001A\u0001" +
                    "A\u0001B\u0001B\u0001C\u0001C\u0001D\u0001D\u0001E\u0001E\u0001F\u0001" +
                    "F\u0001G\u0001G\u0001H\u0001H\u0001H\u0001H\u0001H\u0001H\u0003H\u055f" +
                    "\bH\u0001I\u0001I\u0001J\u0001J\u0001J\u0001J\u0001J\u0003J\u0568\bJ\u0001" +
                    "K\u0001K\u0001K\u0001K\u0001K\u0001K\u0005K\u0570\bK\nK\fK\u0573\tK\u0001" +
                    "K\u0003K\u0576\bK\u0001K\u0001K\u0001K\u0003K\u057b\bK\u0001K\u0001K\u0001" +
                    "K\u0003K\u0580\bK\u0001K\u0001K\u0001K\u0001K\u0005K\u0586\bK\nK\fK\u0589" +
                    "\tK\u0001K\u0003K\u058c\bK\u0001K\u0001K\u0003K\u0590\bK\u0001L\u0001" +
                    "L\u0001L\u0003L\u0595\bL\u0001L\u0001L\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0005M\u05a1\bM\nM\fM\u05a4\tM\u0001M\u0003M\u05a7" +
                    "\bM\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0005M\u05b1" +
                    "\bM\nM\fM\u05b4\tM\u0001M\u0003M\u05b7\bM\u0001M\u0001M\u0003M\u05bb\b" +
                    "M\u0001N\u0003N\u05be\bN\u0001N\u0001N\u0001N\u0001N\u0005N\u05c4\bN\n" +
                    "N\fN\u05c7\tN\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0005N\u05cf\b" +
                    "N\nN\fN\u05d2\tN\u0001N\u0001N\u0003N\u05d6\bN\u0001O\u0001O\u0001O\u0003" +
                    "O\u05db\bO\u0001O\u0001O\u0001P\u0001P\u0001P\u0001Q\u0005Q\u05e3\bQ\n" +
                    "Q\fQ\u05e6\tQ\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0005Q\u05ed\bQ\nQ\f" +
                    "Q\u05f0\tQ\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0005Q\u05f7\bQ\nQ\fQ\u05fa" +
                    "\tQ\u0001Q\u0003Q\u05fd\bQ\u0001Q\u0001Q\u0003Q\u0601\bQ\u0001R\u0001" +
                    "R\u0001R\u0005R\u0606\bR\nR\fR\u0609\tR\u0001R\u0001R\u0001S\u0001S\u0001" +
                    "S\u0001S\u0001S\u0001S\u0001S\u0003S\u0614\bS\u0001T\u0001T\u0005T\u0618" +
                    "\bT\nT\fT\u061b\tT\u0001T\u0001T\u0001U\u0001U\u0001U\u0001U\u0001U\u0003" +
                    "U\u0624\bU\u0001V\u0001V\u0001V\u0005V\u0629\bV\nV\fV\u062c\tV\u0001V" +
                    "\u0001V\u0001W\u0001W\u0001W\u0003W\u0633\bW\u0001W\u0001W\u0001W\u0001" +
                    "W\u0001W\u0005W\u063a\bW\nW\fW\u063d\tW\u0001W\u0001W\u0003W\u0641\bW" +
                    "\u0003W\u0643\bW\u0001X\u0001X\u0001X\u0003X\u0648\bX\u0001X\u0001X\u0001" +
                    "X\u0001X\u0001X\u0005X\u064f\bX\nX\fX\u0652\tX\u0001X\u0001X\u0003X\u0656" +
                    "\bX\u0003X\u0658\bX\u0001Y\u0001Y\u0003Y\u065c\bY\u0001Y\u0003Y\u065f" +
                    "\bY\u0001Z\u0005Z\u0662\bZ\nZ\fZ\u0665\tZ\u0001Z\u0001Z\u0003Z\u0669\b" +
                    "Z\u0001Z\u0001Z\u0001[\u0005[\u066e\b[\n[\f[\u0671\t[\u0001[\u0001[\u0001" +
                    "[\u0001[\u0003[\u0677\b[\u0001[\u0001[\u0001[\u0001\\\u0001\\\u0001\\" +
                    "\u0005\\\u067f\b\\\n\\\f\\\u0682\t\\\u0001\\\u0001\\\u0001]\u0005]\u0687" +
                    "\b]\n]\f]\u068a\t]\u0001]\u0001]\u0001]\u0005]\u068f\b]\n]\f]\u0692\t" +
                    "]\u0001]\u0001]\u0001]\u0001]\u0001]\u0005]\u0699\b]\n]\f]\u069c\t]\u0001" +
                    "]\u0003]\u069f\b]\u0003]\u06a1\b]\u0001]\u0001]\u0005]\u06a5\b]\n]\f]" +
                    "\u06a8\t]\u0001]\u0001]\u0001]\u0001]\u0003]\u06ae\b]\u0001]\u0001]\u0001" +
                    "]\u0005]\u06b3\b]\n]\f]\u06b6\t]\u0001]\u0001]\u0001]\u0001]\u0001]\u0005" +
                    "]\u06bd\b]\n]\f]\u06c0\t]\u0001]\u0001]\u0001]\u0005]\u06c5\b]\n]\f]\u06c8" +
                    "\t]\u0001]\u0001]\u0001]\u0001]\u0003]\u06ce\b]\u0001]\u0001]\u0003]\u06d2" +
                    "\b]\u0001^\u0001^\u0005^\u06d6\b^\n^\f^\u06d9\t^\u0001_\u0001_\u0001_" +
                    "\u0001_\u0001_\u0001_\u0001_\u0001_\u0001_\u0005_\u06e4\b_\n_\f_\u06e7" +
                    "\t_\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001" +
                    "`\u0003`\u06f3\b`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0001`\u0003" +
                    "`\u06fc\b`\u0001a\u0003a\u06ff\ba\u0001a\u0001a\u0001a\u0003a\u0704\b" +
                    "a\u0001a\u0001a\u0001a\u0003a\u0709\ba\u0001a\u0001a\u0001a\u0001a\u0001" +
                    "a\u0001a\u0001a\u0001a\u0001a\u0001a\u0001a\u0004a\u0716\ba\u000ba\fa" +
                    "\u0717\u0001a\u0003a\u071b\ba\u0001a\u0001a\u0001a\u0001a\u0001a\u0001" +
                    "a\u0001a\u0005a\u0724\ba\na\fa\u0727\ta\u0001a\u0003a\u072a\ba\u0001a" +
                    "\u0001a\u0001a\u0003a\u072f\ba\u0001a\u0001a\u0001a\u0001a\u0005a\u0735" +
                    "\ba\na\fa\u0738\ta\u0001a\u0003a\u073b\ba\u0001a\u0001a\u0001a\u0003a" +
                    "\u0740\ba\u0001a\u0001a\u0001a\u0001a\u0005a\u0746\ba\na\fa\u0749\ta\u0001" +
                    "a\u0003a\u074c\ba\u0001a\u0001a\u0003a\u0750\ba\u0001b\u0001b\u0003b\u0754" +
                    "\bb\u0001b\u0003b\u0757\bb\u0001b\u0003b\u075a\bb\u0001b\u0001b\u0001" +
                    "c\u0001c\u0001c\u0003c\u0761\bc\u0001c\u0003c\u0764\bc\u0001c\u0001c\u0001" +
                    "c\u0001c\u0001c\u0003c\u076b\bc\u0001c\u0001c\u0003c\u076f\bc\u0001d\u0003" +
                    "d\u0772\bd\u0001d\u0001d\u0003d\u0776\bd\u0001e\u0001e\u0001e\u0005e\u077b" +
                    "\be\ne\fe\u077e\te\u0001e\u0001e\u0001f\u0001f\u0001f\u0001f\u0001f\u0001" +
                    "f\u0004f\u0788\bf\u000bf\ff\u0789\u0001f\u0003f\u078d\bf\u0001f\u0001" +
                    "f\u0001f\u0001f\u0001f\u0001f\u0001f\u0003f\u0796\bf\u0001g\u0001g\u0001" +
                    "g\u0003g\u079b\bg\u0001g\u0001g\u0001h\u0003h\u07a0\bh\u0001h\u0001h\u0001" +
                    "i\u0001i\u0001i\u0001i\u0005i\u07a8\bi\ni\fi\u07ab\ti\u0001i\u0003i\u07ae" +
                    "\bi\u0003i\u07b0\bi\u0001i\u0001i\u0001i\u0001i\u0001i\u0005i\u07b7\b" +
                    "i\ni\fi\u07ba\ti\u0001i\u0003i\u07bd\bi\u0003i\u07bf\bi\u0001i\u0003i" +
                    "\u07c2\bi\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001" +
                    "j\u0001j\u0001j\u0001j\u0001j\u0001j\u0003j\u07d2\bj\u0001j\u0001j\u0001" +
                    "j\u0001j\u0003j\u07d8\bj\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001" +
                    "j\u0003j\u07e1\bj\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001" +
                    "j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0003j\u07f2\bj\u0001" +
                    "j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0001j\u0003j\u07fc\bj\u0001" +
                    "k\u0005k\u07ff\bk\nk\fk\u0802\tk\u0001l\u0005l\u0805\bl\nl\fl\u0808\t" +
                    "l\u0001l\u0001l\u0001m\u0005m\u080d\bm\nm\fm\u0810\tm\u0001m\u0001m\u0001" +
                    "m\u0005m\u0815\bm\nm\fm\u0818\tm\u0001n\u0001n\u0001n\u0003n\u081d\bn" +
                    "\u0001o\u0001o\u0001o\u0001o\u0003o\u0823\bo\u0003o\u0825\bo\u0001p\u0001" +
                    "p\u0001p\u0005p\u082a\bp\np\fp\u082d\tp\u0001q\u0001q\u0001q\u0005q\u0832" +
                    "\bq\nq\fq\u0835\tq\u0001r\u0001r\u0001s\u0001s\u0001t\u0001t\u0003t\u083d" +
                    "\bt\u0001u\u0001u\u0001v\u0003v\u0842\bv\u0001v\u0001v\u0003v\u0846\b" +
                    "v\u0001v\u0001v\u0003v\u084a\bv\u0001v\u0003v\u084d\bv\u0001v\u0000\u0004" +
                    "lnp\u00bew\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016" +
                    "\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt" +
                    "vxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094" +
                    "\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac" +
                    "\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4" +
                    "\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc" +
                    "\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u0000\u0018\u0001\u0000" +
                    "\u0004\u0005\u0001\u0000\u0003\u0005\u0001\u0000LM\u0002\u0000\u0002\u0002" +
                    "\u0006\u0006\u0002\u0000\u0007\u0007uu\u0002\u0000\u0007\u000722\u0002" +
                    "\u0000UUxx\u0001\u0000\u007f\u0080\u0007\u0000\u001a\u001b\u001e\u001e" +
                    "EETT^_beii\u0005\u0000\u001c\u001d  QQTTfh\u0003\u0000#\'+,00\u0001\u0000" +
                    "EF\u0001\u0000IK\u0002\u0000aacc\u0001\u000023\u0001\u0000\u001e!\u0001" +
                    "\u0000\u001a\u001b\u0001\u0000=B\u0003\u0000(*./44\u0003\u0000--557;\u0002" +
                    "\u0000\u001a\u001aFF\u0001\u0000\u0093\u0094\u0001\u0000\u0084\u0085\u0001" +
                    "\u0000\u0086\u0087\u098f\u0000\u00ff\u0001\u0000\u0000\u0000\u0002\u0104" +
                    "\u0001\u0000\u0000\u0000\u0004\u0106\u0001\u0000\u0000\u0000\u0006\u0108" +
                    "\u0001\u0000\u0000\u0000\b\u010d\u0001\u0000\u0000\u0000\n\u0110\u0001" +
                    "\u0000\u0000\u0000\f\u013d\u0001\u0000\u0000\u0000\u000e\u013f\u0001\u0000" +
                    "\u0000\u0000\u0010\u0154\u0001\u0000\u0000\u0000\u0012\u0156\u0001\u0000" +
                    "\u0000\u0000\u0014\u0159\u0001\u0000\u0000\u0000\u0016\u0171\u0001\u0000" +
                    "\u0000\u0000\u0018\u018d\u0001\u0000\u0000\u0000\u001a\u018f\u0001\u0000" +
                    "\u0000\u0000\u001c\u0194\u0001\u0000\u0000\u0000\u001e\u01a1\u0001\u0000" +
                    "\u0000\u0000 \u01b2\u0001\u0000\u0000\u0000\"\u01b9\u0001\u0000\u0000" +
                    "\u0000$\u01ce\u0001\u0000\u0000\u0000&\u01da\u0001\u0000\u0000\u0000(" +
                    "\u01e1\u0001\u0000\u0000\u0000*\u01f4\u0001\u0000\u0000\u0000,\u01ff\u0001" +
                    "\u0000\u0000\u0000.\u0203\u0001\u0000\u0000\u00000\u0219\u0001\u0000\u0000" +
                    "\u00002\u021f\u0001\u0000\u0000\u00004\u022a\u0001\u0000\u0000\u00006" +
                    "\u022e\u0001\u0000\u0000\u00008\u023b\u0001\u0000\u0000\u0000:\u0249\u0001" +
                    "\u0000\u0000\u0000<\u0257\u0001\u0000\u0000\u0000>\u0260\u0001\u0000\u0000" +
                    "\u0000@\u0281\u0001\u0000\u0000\u0000B\u02c4\u0001\u0000\u0000\u0000D" +
                    "\u02c6\u0001\u0000\u0000\u0000F\u02cc\u0001\u0000\u0000\u0000H\u02e6\u0001" +
                    "\u0000\u0000\u0000J\u02f8\u0001\u0000\u0000\u0000L\u02ff\u0001\u0000\u0000" +
                    "\u0000N\u0304\u0001\u0000\u0000\u0000P\u030e\u0001\u0000\u0000\u0000R" +
                    "\u031f\u0001\u0000\u0000\u0000T\u032d\u0001\u0000\u0000\u0000V\u032f\u0001" +
                    "\u0000\u0000\u0000X\u0380\u0001\u0000\u0000\u0000Z\u03a0\u0001\u0000\u0000" +
                    "\u0000\\\u03bf\u0001\u0000\u0000\u0000^\u03c1\u0001\u0000\u0000\u0000" +
                    "`\u03c7\u0001\u0000\u0000\u0000b\u03f3\u0001\u0000\u0000\u0000d\u03f5" +
                    "\u0001\u0000\u0000\u0000f\u0421\u0001\u0000\u0000\u0000h\u0423\u0001\u0000" +
                    "\u0000\u0000j\u0429\u0001\u0000\u0000\u0000l\u0450\u0001\u0000\u0000\u0000" +
                    "n\u04bb\u0001\u0000\u0000\u0000p\u04fe\u0001\u0000\u0000\u0000r\u051a" +
                    "\u0001\u0000\u0000\u0000t\u053c\u0001\u0000\u0000\u0000v\u053e\u0001\u0000" +
                    "\u0000\u0000x\u0540\u0001\u0000\u0000\u0000z\u0542\u0001\u0000\u0000\u0000" +
                    "|\u0544\u0001\u0000\u0000\u0000~\u0546\u0001\u0000\u0000\u0000\u0080\u0548" +
                    "\u0001\u0000\u0000\u0000\u0082\u054a\u0001\u0000\u0000\u0000\u0084\u054c" +
                    "\u0001\u0000\u0000\u0000\u0086\u054e\u0001\u0000\u0000\u0000\u0088\u0550" +
                    "\u0001\u0000\u0000\u0000\u008a\u0552\u0001\u0000\u0000\u0000\u008c\u0554" +
                    "\u0001\u0000\u0000\u0000\u008e\u0556\u0001\u0000\u0000\u0000\u0090\u055e" +
                    "\u0001\u0000\u0000\u0000\u0092\u0560\u0001\u0000\u0000\u0000\u0094\u0567" +
                    "\u0001\u0000\u0000\u0000\u0096\u058f\u0001\u0000\u0000\u0000\u0098\u0594" +
                    "\u0001\u0000\u0000\u0000\u009a\u05ba\u0001\u0000\u0000\u0000\u009c\u05d5" +
                    "\u0001\u0000\u0000\u0000\u009e\u05da\u0001\u0000\u0000\u0000\u00a0\u05de" +
                    "\u0001\u0000\u0000\u0000\u00a2\u0600\u0001\u0000\u0000\u0000\u00a4\u0602" +
                    "\u0001\u0000\u0000\u0000\u00a6\u0613\u0001\u0000\u0000\u0000\u00a8\u0615" +
                    "\u0001\u0000\u0000\u0000\u00aa\u0623\u0001\u0000\u0000\u0000\u00ac\u0625" +
                    "\u0001\u0000\u0000\u0000\u00ae\u0642\u0001\u0000\u0000\u0000\u00b0\u0657" +
                    "\u0001\u0000\u0000\u0000\u00b2\u0659\u0001\u0000\u0000\u0000\u00b4\u0663" +
                    "\u0001\u0000\u0000\u0000\u00b6\u066f\u0001\u0000\u0000\u0000\u00b8\u067b" +
                    "\u0001\u0000\u0000\u0000\u00ba\u06d1\u0001\u0000\u0000\u0000\u00bc\u06d3" +
                    "\u0001\u0000\u0000\u0000\u00be\u06da\u0001\u0000\u0000\u0000\u00c0\u06fb" +
                    "\u0001\u0000\u0000\u0000\u00c2\u074f\u0001\u0000\u0000\u0000\u00c4\u0751" +
                    "\u0001\u0000\u0000\u0000\u00c6\u076e\u0001\u0000\u0000\u0000\u00c8\u0775" +
                    "\u0001\u0000\u0000\u0000\u00ca\u0777\u0001\u0000\u0000\u0000\u00cc\u0795" +
                    "\u0001\u0000\u0000\u0000\u00ce\u079a\u0001\u0000\u0000\u0000\u00d0\u079f" +
                    "\u0001\u0000\u0000\u0000\u00d2\u07c1\u0001\u0000\u0000\u0000\u00d4\u07fb" +
                    "\u0001\u0000\u0000\u0000\u00d6\u0800\u0001\u0000\u0000\u0000\u00d8\u0806" +
                    "\u0001\u0000\u0000\u0000\u00da\u080e\u0001\u0000\u0000\u0000\u00dc\u0819" +
                    "\u0001\u0000\u0000\u0000\u00de\u0824\u0001\u0000\u0000\u0000\u00e0\u0826" +
                    "\u0001\u0000\u0000\u0000\u00e2\u082e\u0001\u0000\u0000\u0000\u00e4\u0836" +
                    "\u0001\u0000\u0000\u0000\u00e6\u0838\u0001\u0000\u0000\u0000\u00e8\u083a" +
                    "\u0001\u0000\u0000\u0000\u00ea\u083e\u0001\u0000\u0000\u0000\u00ec\u084c" +
                    "\u0001\u0000\u0000\u0000\u00ee\u00fe\u0003\u0006\u0003\u0000\u00ef\u00fe" +
                    "\u0003\b\u0004\u0000\u00f0\u00fe\u0003\u0012\t\u0000\u00f1\u00fe\u0003" +
                    "\u0014\n\u0000\u00f2\u00fe\u0003.\u0017\u0000\u00f3\u00fe\u00038\u001c" +
                    "\u0000\u00f4\u00fe\u0003\"\u0011\u0000\u00f5\u00fe\u0003(\u0014\u0000" +
                    "\u00f6\u00fe\u0003>\u001f\u0000\u00f7\u00fe\u0003\\.\u0000\u00f8\u00fe" +
                    "\u0003R)\u0000\u00f9\u00fe\u0003f3\u0000\u00fa\u00fe\u0003b1\u0000\u00fb" +
                    "\u00fe\u0003j5\u0000\u00fc\u00fe\u0003\u0002\u0001\u0000\u00fd\u00ee\u0001" +
                    "\u0000\u0000\u0000\u00fd\u00ef\u0001\u0000\u0000\u0000\u00fd\u00f0\u0001" +
                    "\u0000\u0000\u0000\u00fd\u00f1\u0001\u0000\u0000\u0000\u00fd\u00f2\u0001" +
                    "\u0000\u0000\u0000\u00fd\u00f3\u0001\u0000\u0000\u0000\u00fd\u00f4\u0001" +
                    "\u0000\u0000\u0000\u00fd\u00f5\u0001\u0000\u0000\u0000\u00fd\u00f6\u0001" +
                    "\u0000\u0000\u0000\u00fd\u00f7\u0001\u0000\u0000\u0000\u00fd\u00f8\u0001" +
                    "\u0000\u0000\u0000\u00fd\u00f9\u0001\u0000\u0000\u0000\u00fd\u00fa\u0001" +
                    "\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fc\u0001" +
                    "\u0000\u0000\u0000\u00fe\u0101\u0001\u0000\u0000\u0000\u00ff\u00fd\u0001" +
                    "\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100\u0102\u0001" +
                    "\u0000\u0000\u0000\u0101\u00ff\u0001\u0000\u0000\u0000\u0102\u0103\u0005" +
                    "\u0000\u0000\u0001\u0103\u0001\u0001\u0000\u0000\u0000\u0104\u0105\u0007" +
                    "\u0000\u0000\u0000\u0105\u0003\u0001\u0000\u0000\u0000\u0106\u0107\u0007" +
                    "\u0001\u0000\u0000\u0107\u0005\u0001\u0000\u0000\u0000\u0108\u0109\u0005" +
                    "k\u0000\u0000\u0109\u010b\u0003\u00e0p\u0000\u010a\u010c\u0003\u0002\u0001" +
                    "\u0000\u010b\u010a\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000" +
                    "\u0000\u010c\u0007\u0001\u0000\u0000\u0000\u010d\u010e\u0005l\u0000\u0000" +
                    "\u010e\u010f\u0003\f\u0006\u0000\u010f\t\u0001\u0000\u0000\u0000\u0110" +
                    "\u0112\u0005]\u0000\u0000\u0111\u0113\u0007\u0002\u0000\u0000\u0112\u0111" +
                    "\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113\u0114" +
                    "\u0001\u0000\u0000\u0000\u0114\u0115\u0003\u00e4r\u0000\u0115\u000b\u0001" +
                    "\u0000\u0000\u0000\u0116\u013e\u0003\u0010\b\u0000\u0117\u0118\u0005L" +
                    "\u0000\u0000\u0118\u011a\u0003\u000e\u0007\u0000\u0119\u011b\u0003\n\u0005" +
                    "\u0000\u011a\u0119\u0001\u0000\u0000\u0000\u011a\u011b\u0001\u0000\u0000" +
                    "\u0000\u011b\u013e\u0001\u0000\u0000\u0000\u011c\u011d\u0005L\u0000\u0000" +
                    "\u011d\u0122\u0003\u000e\u0007\u0000\u011e\u0120\u0007\u0003\u0000\u0000" +
                    "\u011f\u011e\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000" +
                    "\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0123\u0003\u0010\b\u0000\u0122" +
                    "\u011f\u0001\u0000\u0000\u0000\u0122\u0123\u0001\u0000\u0000\u0000\u0123" +
                    "\u013e\u0001\u0000\u0000\u0000\u0124\u0125\u0005M\u0000\u0000\u0125\u0127" +
                    "\u0003\u000e\u0007\u0000\u0126\u0128\u0003\n\u0005\u0000\u0127\u0126\u0001" +
                    "\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0128\u013e\u0001" +
                    "\u0000\u0000\u0000\u0129\u012a\u0005M\u0000\u0000\u012a\u012f\u0003\u000e" +
                    "\u0007\u0000\u012b\u012d\u0007\u0003\u0000\u0000\u012c\u012b\u0001\u0000" +
                    "\u0000\u0000\u012c\u012d\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000" +
                    "\u0000\u0000\u012e\u0130\u0003\u0010\b\u0000\u012f\u012c\u0001\u0000\u0000" +
                    "\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u013e\u0001\u0000\u0000" +
                    "\u0000\u0131\u0133\u0003\u000e\u0007\u0000\u0132\u0134\u0003\n\u0005\u0000" +
                    "\u0133\u0132\u0001\u0000\u0000\u0000\u0133\u0134\u0001\u0000\u0000\u0000" +
                    "\u0134\u013e\u0001\u0000\u0000\u0000\u0135\u013a\u0003\u000e\u0007\u0000" +
                    "\u0136\u0138\u0007\u0003\u0000\u0000\u0137\u0136\u0001\u0000\u0000\u0000" +
                    "\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000" +
                    "\u0139\u013b\u0003\u0010\b\u0000\u013a\u0137\u0001\u0000\u0000\u0000\u013a" +
                    "\u013b\u0001\u0000\u0000\u0000\u013b\u013e\u0001\u0000\u0000\u0000\u013c" +
                    "\u013e\u0003\u0004\u0002\u0000\u013d\u0116\u0001\u0000\u0000\u0000\u013d" +
                    "\u0117\u0001\u0000\u0000\u0000\u013d\u011c\u0001\u0000\u0000\u0000\u013d" +
                    "\u0124\u0001\u0000\u0000\u0000\u013d\u0129\u0001\u0000\u0000\u0000\u013d" +
                    "\u0131\u0001\u0000\u0000\u0000\u013d\u0135\u0001\u0000\u0000\u0000\u013d" +
                    "\u013c\u0001\u0000\u0000\u0000\u013e\r\u0001\u0000\u0000\u0000\u013f\u0144" +
                    "\u0003\u00e4r\u0000\u0140\u0141\u0007\u0003\u0000\u0000\u0141\u0143\u0003" +
                    "\u00e4r\u0000\u0142\u0140\u0001\u0000\u0000\u0000\u0143\u0146\u0001\u0000" +
                    "\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000" +
                    "\u0000\u0000\u0145\u0147\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000" +
                    "\u0000\u0000\u0147\u0148\u0007\u0003\u0000\u0000\u0148\u0149\u0005\u001e" +
                    "\u0000\u0000\u0149\u000f\u0001\u0000\u0000\u0000\u014a\u014b\u0005\f\u0000" +
                    "\u0000\u014b\u0155\u0005\r\u0000\u0000\u014c\u0150\u0005\f\u0000\u0000" +
                    "\u014d\u014f\u0003\f\u0006\u0000\u014e\u014d\u0001\u0000\u0000\u0000\u014f" +
                    "\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0150" +
                    "\u0151\u0001\u0000\u0000\u0000\u0151\u0153\u0001\u0000\u0000\u0000\u0152" +
                    "\u0150\u0001\u0000\u0000\u0000\u0153\u0155\u0005\r\u0000\u0000\u0154\u014a" +
                    "\u0001\u0000\u0000\u0000\u0154\u014c\u0001\u0000\u0000\u0000\u0155\u0011" +
                    "\u0001\u0000\u0000\u0000\u0156\u0157\u0005m\u0000\u0000\u0157\u0013\u0001" +
                    "\u0000\u0000\u0000\u0158\u015a\u0003\u00a2Q\u0000\u0159\u0158\u0001\u0000" +
                    "\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015e\u0001\u0000" +
                    "\u0000\u0000\u015b\u015d\u0003\u00b0X\u0000\u015c\u015b\u0001\u0000\u0000" +
                    "\u0000\u015d\u0160\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000\u0000" +
                    "\u0000\u015e\u015f\u0001\u0000\u0000\u0000\u015f\u0161\u0001\u0000\u0000" +
                    "\u0000\u0160\u015e\u0001\u0000\u0000\u0000\u0161\u0162\u0003\u00d6k\u0000" +
                    "\u0162\u0163\u0005n\u0000\u0000\u0163\u0165\u0003\u00e4r\u0000\u0164\u0166" +
                    "\u0003\u0096K\u0000\u0165\u0164\u0001\u0000\u0000\u0000\u0165\u0166\u0001" +
                    "\u0000\u0000\u0000\u0166\u0168\u0001\u0000\u0000\u0000\u0167\u0169\u0003" +
                    "\u0018\f\u0000\u0168\u0167\u0001\u0000\u0000\u0000\u0168\u0169\u0001\u0000" +
                    "\u0000\u0000\u0169\u016b\u0001\u0000\u0000\u0000\u016a\u016c\u0003^/\u0000" +
                    "\u016b\u016a\u0001\u0000\u0000\u0000\u016b\u016c\u0001\u0000\u0000\u0000" +
                    "\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016f\u0003\u0016\u000b\u0000" +
                    "\u016e\u0170\u0003\u0002\u0001\u0000\u016f\u016e\u0001\u0000\u0000\u0000" +
                    "\u016f\u0170\u0001\u0000\u0000\u0000\u0170\u0015\u0001\u0000\u0000\u0000" +
                    "\u0171\u0178\u0005\f\u0000\u0000\u0172\u0177\u0003 \u0010\u0000\u0173" +
                    "\u0177\u0003\u001e\u000f\u0000\u0174\u0177\u0003\u001c\u000e\u0000\u0175" +
                    "\u0177\u0003\u0004\u0002\u0000\u0176\u0172\u0001\u0000\u0000\u0000\u0176" +
                    "\u0173\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0176" +
                    "\u0175\u0001\u0000\u0000\u0000\u0177\u017a\u0001\u0000\u0000\u0000\u0178" +
                    "\u0176\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179" +
                    "\u017b\u0001\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000\u017b" +
                    "\u017c\u0005\r\u0000\u0000\u017c\u0017\u0001\u0000\u0000\u0000\u017d\u017e" +
                    "\u0005\b\u0000\u0000\u017e\u018e\u0005\t\u0000\u0000\u017f\u0180\u0005" +
                    "\b\u0000\u0000\u0180\u0185\u0003\u001a\r\u0000\u0181\u0182\u0005\u0003" +
                    "\u0000\u0000\u0182\u0184\u0003\u001a\r\u0000\u0183\u0181\u0001\u0000\u0000" +
                    "\u0000\u0184\u0187\u0001\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000" +
                    "\u0000\u0185\u0186\u0001\u0000\u0000\u0000\u0186\u0189\u0001\u0000\u0000" +
                    "\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0188\u018a\u0005\u0003\u0000" +
                    "\u0000\u0189\u0188\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000" +
                    "\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018c\u0005\t\u0000\u0000" +
                    "\u018c\u018e\u0001\u0000\u0000\u0000\u018d\u017d\u0001\u0000\u0000\u0000" +
                    "\u018d\u017f\u0001\u0000\u0000\u0000\u018e\u0019\u0001\u0000\u0000\u0000" +
                    "\u018f\u0190\u0003\u00dam\u0000\u0190\u001b\u0001\u0000\u0000\u0000\u0191" +
                    "\u0193\u0003\u00b0X\u0000\u0192\u0191\u0001\u0000\u0000\u0000\u0193\u0196" +
                    "\u0001\u0000\u0000\u0000\u0194\u0192\u0001\u0000\u0000\u0000\u0194\u0195" +
                    "\u0001\u0000\u0000\u0000\u0195\u0197\u0001\u0000\u0000\u0000\u0196\u0194" +
                    "\u0001\u0000\u0000\u0000\u0197\u0199\u0003\u00d8l\u0000\u0198\u019a\u0003" +
                    "^/\u0000\u0199\u0198\u0001\u0000\u0000\u0000\u0199\u019a\u0001\u0000\u0000" +
                    "\u0000\u019a\u019c\u0001\u0000\u0000\u0000\u019b\u019d\u0003F#\u0000\u019c" +
                    "\u019b\u0001\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d" +
                    "\u001d\u0001\u0000\u0000\u0000\u019e\u01a0\u0003\u00b0X\u0000\u019f\u019e" +
                    "\u0001\u0000\u0000\u0000\u01a0\u01a3\u0001\u0000\u0000\u0000\u01a1\u019f" +
                    "\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2\u01a4" +
                    "\u0001\u0000\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000\u0000\u01a4\u01a6" +
                    "\u0003\u00dam\u0000\u01a5\u01a7\u0003\u0096K\u0000\u01a6\u01a5\u0001\u0000" +
                    "\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000" +
                    "\u0000\u0000\u01a8\u01aa\u0003@ \u0000\u01a9\u01ab\u0003^/\u0000\u01aa" +
                    "\u01a9\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000\u0000\u0000\u01ab" +
                    "\u01ad\u0001\u0000\u0000\u0000\u01ac\u01ae\u0003P(\u0000\u01ad\u01ac\u0001" +
                    "\u0000\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u001f\u0001" +
                    "\u0000\u0000\u0000\u01af\u01b1\u0003\u00b0X\u0000\u01b0\u01af\u0001\u0000" +
                    "\u0000\u0000\u01b1\u01b4\u0001\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000" +
                    "\u0000\u0000\u01b2\u01b3\u0001\u0000\u0000\u0000\u01b3\u01b5\u0001\u0000" +
                    "\u0000\u0000\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b5\u01b6\u0003\u00d8" +
                    "l\u0000\u01b6\u01b7\u0003\u0016\u000b\u0000\u01b7!\u0001\u0000\u0000\u0000" +
                    "\u01b8\u01ba\u0003\u00a2Q\u0000\u01b9\u01b8\u0001\u0000\u0000\u0000\u01b9" +
                    "\u01ba\u0001\u0000\u0000\u0000\u01ba\u01be\u0001\u0000\u0000\u0000\u01bb" +
                    "\u01bd\u0003\u00b0X\u0000\u01bc\u01bb\u0001\u0000\u0000\u0000\u01bd\u01c0" +
                    "\u0001\u0000\u0000\u0000\u01be\u01bc\u0001\u0000\u0000\u0000\u01be\u01bf" +
                    "\u0001\u0000\u0000\u0000\u01bf\u01c1\u0001\u0000\u0000\u0000\u01c0\u01be" +
                    "\u0001\u0000\u0000\u0000\u01c1\u01c2\u0003\u00d6k\u0000\u01c2\u01c3\u0005" +
                    "o\u0000\u0000\u01c3\u01c5\u0003\u00e4r\u0000\u01c4\u01c6\u0003\u0096K" +
                    "\u0000\u01c5\u01c4\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000" +
                    "\u0000\u01c6\u01c8\u0001\u0000\u0000\u0000\u01c7\u01c9\u0003,\u0016\u0000" +
                    "\u01c8\u01c7\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000" +
                    "\u01c9\u01ca\u0001\u0000\u0000\u0000\u01ca\u01cc\u0003$\u0012\u0000\u01cb" +
                    "\u01cd\u0003\u0002\u0001\u0000\u01cc\u01cb\u0001\u0000\u0000\u0000\u01cc" +
                    "\u01cd\u0001\u0000\u0000\u0000\u01cd#\u0001\u0000\u0000\u0000\u01ce\u01d5" +
                    "\u0005\f\u0000\u0000\u01cf\u01d4\u0003&\u0013\u0000\u01d0\u01d4\u0003" +
                    "\u001e\u000f\u0000\u01d1\u01d4\u0003\u001c\u000e\u0000\u01d2\u01d4\u0003" +
                    "\u0004\u0002\u0000\u01d3\u01cf\u0001\u0000\u0000\u0000\u01d3\u01d0\u0001" +
                    "\u0000\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d2\u0001" +
                    "\u0000\u0000\u0000\u01d4\u01d7\u0001\u0000\u0000\u0000\u01d5\u01d3\u0001" +
                    "\u0000\u0000\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d8\u0001" +
                    "\u0000\u0000\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d8\u01d9\u0005" +
                    "\r\u0000\u0000\u01d9%\u0001\u0000\u0000\u0000\u01da\u01db\u0005r\u0000" +
                    "\u0000\u01db\u01de\u0003\u00e4r\u0000\u01dc\u01dd\u00055\u0000\u0000\u01dd" +
                    "\u01df\u0003p8\u0000\u01de\u01dc\u0001\u0000\u0000\u0000\u01de\u01df\u0001" +
                    "\u0000\u0000\u0000\u01df\'\u0001\u0000\u0000\u0000\u01e0\u01e2\u0003\u00a2" +
                    "Q\u0000\u01e1\u01e0\u0001\u0000\u0000\u0000\u01e1\u01e2\u0001\u0000\u0000" +
                    "\u0000\u01e2\u01e6\u0001\u0000\u0000\u0000\u01e3\u01e5\u0003\u00b0X\u0000" +
                    "\u01e4\u01e3\u0001\u0000\u0000\u0000\u01e5\u01e8\u0001\u0000\u0000\u0000" +
                    "\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000" +
                    "\u01e7\u01e9\u0001\u0000\u0000\u0000\u01e8\u01e6\u0001\u0000\u0000\u0000" +
                    "\u01e9\u01ea\u0003\u00d6k\u0000\u01ea\u01eb\u0005t\u0000\u0000\u01eb\u01ed" +
                    "\u0003\u00e2q\u0000\u01ec\u01ee\u0003\u0096K\u0000\u01ed\u01ec\u0001\u0000" +
                    "\u0000\u0000\u01ed\u01ee\u0001\u0000\u0000\u0000\u01ee\u01f0\u0001\u0000" +
                    "\u0000\u0000\u01ef\u01f1\u0003,\u0016\u0000\u01f0\u01ef\u0001\u0000\u0000" +
                    "\u0000\u01f0\u01f1\u0001\u0000\u0000\u0000\u01f1\u01f2\u0001\u0000\u0000" +
                    "\u0000\u01f2\u01f3\u0003*\u0015\u0000\u01f3)\u0001\u0000\u0000\u0000\u01f4" +
                    "\u01fa\u0005\f\u0000\u0000\u01f5\u01f9\u0003&\u0013\u0000\u01f6\u01f9" +
                    "\u0003\u001e\u000f\u0000\u01f7\u01f9\u0003\u0004\u0002\u0000\u01f8\u01f5" +
                    "\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f8\u01f7" +
                    "\u0001\u0000\u0000\u0000\u01f9\u01fc\u0001\u0000\u0000\u0000\u01fa\u01f8" +
                    "\u0001\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb\u01fd" +
                    "\u0001\u0000\u0000\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fd\u01fe" +
                    "\u0005\r\u0000\u0000\u01fe+\u0001\u0000\u0000\u0000\u01ff\u0200\u0007" +
                    "\u0004\u0000\u0000\u0200\u0201\u0003p8\u0000\u0201-\u0001\u0000\u0000" +
                    "\u0000\u0202\u0204\u0003\u00a2Q\u0000\u0203\u0202\u0001\u0000\u0000\u0000" +
                    "\u0203\u0204\u0001\u0000\u0000\u0000\u0204\u0208\u0001\u0000\u0000\u0000" +
                    "\u0205\u0207\u0003\u00b0X\u0000\u0206\u0205\u0001\u0000\u0000\u0000\u0207" +
                    "\u020a\u0001\u0000\u0000\u0000\u0208\u0206\u0001\u0000\u0000\u0000\u0208" +
                    "\u0209\u0001\u0000\u0000\u0000\u0209\u020b\u0001\u0000\u0000\u0000\u020a" +
                    "\u0208\u0001\u0000\u0000\u0000\u020b\u020c\u0003\u00d6k\u0000\u020c\u020d" +
                    "\u0005p\u0000\u0000\u020d\u020f\u0003\u00e4r\u0000\u020e\u0210\u0003\u0096" +
                    "K\u0000\u020f\u020e\u0001\u0000\u0000\u0000\u020f\u0210\u0001\u0000\u0000" +
                    "\u0000\u0210\u0212\u0001\u0000\u0000\u0000\u0211\u0213\u00030\u0018\u0000" +
                    "\u0212\u0211\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000\u0000\u0000" +
                    "\u0213\u0215\u0001\u0000\u0000\u0000\u0214\u0216\u0003^/\u0000\u0215\u0214" +
                    "\u0001\u0000\u0000\u0000\u0215\u0216\u0001\u0000\u0000\u0000\u0216\u0217" +
                    "\u0001\u0000\u0000\u0000\u0217\u0218\u00032\u0019\u0000\u0218/\u0001\u0000" +
                    "\u0000\u0000\u0219\u021b\u0005\b\u0000\u0000\u021a\u021c\u0003p8\u0000" +
                    "\u021b\u021a\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000\u0000\u0000" +
                    "\u021c\u021d\u0001\u0000\u0000\u0000\u021d\u021e\u0005\t\u0000\u0000\u021e" +
                    "1\u0001\u0000\u0000\u0000\u021f\u0225\u0005\f\u0000\u0000\u0220\u0224" +
                    "\u0003\u001e\u000f\u0000\u0221\u0224\u00034\u001a\u0000\u0222\u0224\u0003" +
                    "\u0004\u0002\u0000\u0223\u0220\u0001\u0000\u0000\u0000\u0223\u0221\u0001" +
                    "\u0000\u0000\u0000\u0223\u0222\u0001\u0000\u0000\u0000\u0224\u0227\u0001" +
                    "\u0000\u0000\u0000\u0225\u0223\u0001\u0000\u0000\u0000\u0225\u0226\u0001" +
                    "\u0000\u0000\u0000\u0226\u0228\u0001\u0000\u0000\u0000\u0227\u0225\u0001" +
                    "\u0000\u0000\u0000\u0228\u0229\u0005\r\u0000\u0000\u02293\u0001\u0000" +
                    "\u0000\u0000\u022a\u022c\u0003\u00e4r\u0000\u022b\u022d\u00036\u001b\u0000" +
                    "\u022c\u022b\u0001\u0000\u0000\u0000\u022c\u022d\u0001\u0000\u0000\u0000" +
                    "\u022d5\u0001\u0000\u0000\u0000\u022e\u0233\u0005\f\u0000\u0000\u022f" +
                    "\u0232\u0003\u001c\u000e\u0000\u0230\u0232\u0003\u0004\u0002\u0000\u0231" +
                    "\u022f\u0001\u0000\u0000\u0000\u0231\u0230\u0001\u0000\u0000\u0000\u0232" +
                    "\u0235\u0001\u0000\u0000\u0000\u0233\u0231\u0001\u0000\u0000\u0000\u0233" +
                    "\u0234\u0001\u0000\u0000\u0000\u0234\u0236\u0001\u0000\u0000\u0000\u0235" +
                    "\u0233\u0001\u0000\u0000\u0000\u0236\u0237\u0005\r\u0000\u0000\u02377" +
                    "\u0001\u0000\u0000\u0000\u0238\u023a\u0003\u00b0X\u0000\u0239\u0238\u0001" +
                    "\u0000\u0000\u0000\u023a\u023d\u0001\u0000\u0000\u0000\u023b\u0239\u0001" +
                    "\u0000\u0000\u0000\u023b\u023c\u0001\u0000\u0000\u0000\u023c\u023e\u0001" +
                    "\u0000\u0000\u0000\u023d\u023b\u0001\u0000\u0000\u0000\u023e\u023f\u0003" +
                    "\u00d6k\u0000\u023f\u0240\u0005q\u0000\u0000\u0240\u0242\u0003\u00e4r" +
                    "\u0000\u0241\u0243\u00030\u0018\u0000\u0242\u0241\u0001\u0000\u0000\u0000" +
                    "\u0242\u0243\u0001\u0000\u0000\u0000\u0243\u0245\u0001\u0000\u0000\u0000" +
                    "\u0244\u0246\u0003^/\u0000\u0245\u0244\u0001\u0000\u0000\u0000\u0245\u0246" +
                    "\u0001\u0000\u0000\u0000\u0246\u0247\u0001\u0000\u0000\u0000\u0247\u0248" +
                    "\u0003:\u001d\u0000\u02489\u0001\u0000\u0000\u0000\u0249\u024f\u0005\f" +
                    "\u0000\u0000\u024a\u024e\u0003\u001e\u000f\u0000\u024b\u024e\u0003<\u001e" +
                    "\u0000\u024c\u024e\u0003\u0004\u0002\u0000\u024d\u024a\u0001\u0000\u0000" +
                    "\u0000\u024d\u024b\u0001\u0000\u0000\u0000\u024d\u024c\u0001\u0000\u0000" +
                    "\u0000\u024e\u0251\u0001\u0000\u0000\u0000\u024f\u024d\u0001\u0000\u0000" +
                    "\u0000\u024f\u0250\u0001\u0000\u0000\u0000\u0250\u0252\u0001\u0000\u0000" +
                    "\u0000\u0251\u024f\u0001\u0000\u0000\u0000\u0252\u0253\u0005\r\u0000\u0000" +
                    "\u0253;\u0001\u0000\u0000\u0000\u0254\u0256\u0003\u00b0X\u0000\u0255\u0254" +
                    "\u0001\u0000\u0000\u0000\u0256\u0259\u0001\u0000\u0000\u0000\u0257\u0255" +
                    "\u0001\u0000\u0000\u0000\u0257\u0258\u0001\u0000\u0000\u0000\u0258\u025a" +
                    "\u0001\u0000\u0000\u0000\u0259\u0257\u0001\u0000\u0000\u0000\u025a\u025d" +
                    "\u0003\u00e4r\u0000\u025b\u025c\u00055\u0000\u0000\u025c\u025e\u0003l" +
                    "6\u0000\u025d\u025b\u0001\u0000\u0000\u0000\u025d\u025e\u0001\u0000\u0000" +
                    "\u0000\u025e=\u0001\u0000\u0000\u0000\u025f\u0261\u0003\u00a2Q\u0000\u0260" +
                    "\u025f\u0001\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261" +
                    "\u0265\u0001\u0000\u0000\u0000\u0262\u0264\u0003\u00b0X\u0000\u0263\u0262" +
                    "\u0001\u0000\u0000\u0000\u0264\u0267\u0001\u0000\u0000\u0000\u0265\u0263" +
                    "\u0001\u0000\u0000\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266\u0268" +
                    "\u0001\u0000\u0000\u0000\u0267\u0265\u0001\u0000\u0000\u0000\u0268\u0269" +
                    "\u0003\u00d6k\u0000\u0269\u026a\u0005}\u0000\u0000\u026a\u026c\u0003\u00e2" +
                    "q\u0000\u026b\u026d\u0003\u0096K\u0000\u026c\u026b\u0001\u0000\u0000\u0000" +
                    "\u026c\u026d\u0001\u0000\u0000\u0000\u026d\u026e\u0001\u0000\u0000\u0000" +
                    "\u026e\u0270\u0003@ \u0000\u026f\u0271\u0003D\"\u0000\u0270\u026f\u0001" +
                    "\u0000\u0000\u0000\u0270\u0271\u0001\u0000\u0000\u0000\u0271\u0272\u0001" +
                    "\u0000\u0000\u0000\u0272\u0273\u0003P(\u0000\u0273?\u0001\u0000\u0000" +
                    "\u0000\u0274\u0275\u0005\b\u0000\u0000\u0275\u0282\u0005\t\u0000\u0000" +
                    "\u0276\u0277\u0005\b\u0000\u0000\u0277\u027c\u0003B!\u0000\u0278\u0279" +
                    "\u0005\u0003\u0000\u0000\u0279\u027b\u0003B!\u0000\u027a\u0278\u0001\u0000" +
                    "\u0000\u0000\u027b\u027e\u0001\u0000\u0000\u0000\u027c\u027a\u0001\u0000" +
                    "\u0000\u0000\u027c\u027d\u0001\u0000\u0000\u0000\u027d\u027f\u0001\u0000" +
                    "\u0000\u0000\u027e\u027c\u0001\u0000\u0000\u0000\u027f\u0280\u0005\t\u0000" +
                    "\u0000\u0280\u0282\u0001\u0000\u0000\u0000\u0281\u0274\u0001\u0000\u0000" +
                    "\u0000\u0281\u0276\u0001\u0000\u0000\u0000\u0282A\u0001\u0000\u0000\u0000" +
                    "\u0283\u0285\u0003\u00b0X\u0000\u0284\u0283\u0001\u0000\u0000\u0000\u0285" +
                    "\u0288\u0001\u0000\u0000\u0000\u0286\u0284\u0001\u0000\u0000\u0000\u0286" +
                    "\u0287\u0001\u0000\u0000\u0000\u0287\u028c\u0001\u0000\u0000\u0000\u0288" +
                    "\u0286\u0001\u0000\u0000\u0000\u0289\u028b\u0003\u00e4r\u0000\u028a\u0289" +
                    "\u0001\u0000\u0000\u0000\u028b\u028e\u0001\u0000\u0000\u0000\u028c\u028a" +
                    "\u0001\u0000\u0000\u0000\u028c\u028d\u0001\u0000\u0000\u0000\u028d\u028f" +
                    "\u0001\u0000\u0000\u0000\u028e\u028c\u0001\u0000\u0000\u0000\u028f\u0291" +
                    "\u0005^\u0000\u0000\u0290\u0292\u0003\u00e4r\u0000\u0291\u0290\u0001\u0000" +
                    "\u0000\u0000\u0291\u0292\u0001\u0000\u0000\u0000\u0292\u0294\u0001\u0000" +
                    "\u0000\u0000\u0293\u0295\u0003^/\u0000\u0294\u0293\u0001\u0000\u0000\u0000" +
                    "\u0294\u0295\u0001\u0000\u0000\u0000\u0295\u0297\u0001\u0000\u0000\u0000" +
                    "\u0296\u0298\u0003F#\u0000\u0297\u0296\u0001\u0000\u0000\u0000\u0297\u0298" +
                    "\u0001\u0000\u0000\u0000\u0298\u02c5\u0001\u0000\u0000\u0000\u0299\u029b" +
                    "\u0003\u00b0X\u0000\u029a\u0299\u0001\u0000\u0000\u0000\u029b\u029e\u0001" +
                    "\u0000\u0000\u0000\u029c\u029a\u0001\u0000\u0000\u0000\u029c\u029d\u0001" +
                    "\u0000\u0000\u0000\u029d\u02a2\u0001\u0000\u0000\u0000\u029e\u029c\u0001" +
                    "\u0000\u0000\u0000\u029f\u02a1\u0003\u00e4r\u0000\u02a0\u029f\u0001\u0000" +
                    "\u0000\u0000\u02a1\u02a4\u0001\u0000\u0000\u0000\u02a2\u02a0\u0001\u0000" +
                    "\u0000\u0000\u02a2\u02a3\u0001\u0000\u0000\u0000\u02a3\u02a5\u0001\u0000" +
                    "\u0000\u0000\u02a4\u02a2\u0001\u0000\u0000\u0000\u02a5\u02a7\u0005_\u0000" +
                    "\u0000\u02a6\u02a8\u0003\u00e4r\u0000\u02a7\u02a6\u0001\u0000\u0000\u0000" +
                    "\u02a7\u02a8\u0001\u0000\u0000\u0000\u02a8\u02aa\u0001\u0000\u0000\u0000" +
                    "\u02a9\u02ab\u0003^/\u0000\u02aa\u02a9\u0001\u0000\u0000\u0000\u02aa\u02ab" +
                    "\u0001\u0000\u0000\u0000\u02ab\u02ad\u0001\u0000\u0000\u0000\u02ac\u02ae" +
                    "\u0003F#\u0000\u02ad\u02ac\u0001\u0000\u0000\u0000\u02ad\u02ae\u0001\u0000" +
                    "\u0000\u0000\u02ae\u02c5\u0001\u0000\u0000\u0000\u02af\u02b1\u0003\u00b0" +
                    "X\u0000\u02b0\u02af\u0001\u0000\u0000\u0000\u02b1\u02b4\u0001\u0000\u0000" +
                    "\u0000\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000" +
                    "\u0000\u02b3\u02b8\u0001\u0000\u0000\u0000\u02b4\u02b2\u0001\u0000\u0000" +
                    "\u0000\u02b5\u02b7\u0003\u00e4r\u0000\u02b6\u02b5\u0001\u0000\u0000\u0000" +
                    "\u02b7\u02ba\u0001\u0000\u0000\u0000\u02b8\u02b6\u0001\u0000\u0000\u0000" +
                    "\u02b8\u02b9\u0001\u0000\u0000\u0000\u02b9\u02bb\u0001\u0000\u0000\u0000" +
                    "\u02ba\u02b8\u0001\u0000\u0000\u0000\u02bb\u02bd\u0003\u00e4r\u0000\u02bc" +
                    "\u02be\u0003^/\u0000\u02bd\u02bc\u0001\u0000\u0000\u0000\u02bd\u02be\u0001" +
                    "\u0000\u0000\u0000\u02be\u02c0\u0001\u0000\u0000\u0000\u02bf\u02c1\u0003" +
                    "F#\u0000\u02c0\u02bf\u0001\u0000\u0000\u0000\u02c0\u02c1\u0001\u0000\u0000" +
                    "\u0000\u02c1\u02c5\u0001\u0000\u0000\u0000\u02c2\u02c5\u0005+\u0000\u0000" +
                    "\u02c3\u02c5\u00050\u0000\u0000\u02c4\u0286\u0001\u0000\u0000\u0000\u02c4" +
                    "\u029c\u0001\u0000\u0000\u0000\u02c4\u02b2\u0001\u0000\u0000\u0000\u02c4" +
                    "\u02c2\u0001\u0000\u0000\u0000\u02c4\u02c3\u0001\u0000\u0000\u0000\u02c5" +
                    "C\u0001\u0000\u0000\u0000\u02c6\u02c7\u0007\u0005\u0000\u0000\u02c7\u02ca" +
                    "\u0003p8\u0000\u02c8\u02c9\u0005\u001f\u0000\u0000\u02c9\u02cb\u0003p" +
                    "8\u0000\u02ca\u02c8\u0001\u0000\u0000\u0000\u02ca\u02cb\u0001\u0000\u0000" +
                    "\u0000\u02cbE\u0001\u0000\u0000\u0000\u02cc\u02cd\u00055\u0000\u0000\u02cd" +
                    "\u02ce\u0003l6\u0000\u02ceG\u0001\u0000\u0000\u0000\u02cf\u02d1\u0005" +
                    "S\u0000\u0000\u02d0\u02cf\u0001\u0000\u0000\u0000\u02d0\u02d1\u0001\u0000" +
                    "\u0000\u0000\u02d1\u02d2\u0001\u0000\u0000\u0000\u02d2\u02e7\u0003J%\u0000" +
                    "\u02d3\u02d5\u0005S\u0000\u0000\u02d4\u02d3\u0001\u0000\u0000\u0000\u02d4" +
                    "\u02d5\u0001\u0000\u0000\u0000\u02d5\u02d6\u0001\u0000\u0000\u0000\u02d6" +
                    "\u02d7\u0005\u0002\u0000\u0000\u02d7\u02d9\u0005\u0084\u0000\u0000\u02d8" +
                    "\u02da\u0003J%\u0000\u02d9\u02d8\u0001\u0000\u0000\u0000\u02d9\u02da\u0001" +
                    "\u0000\u0000\u0000\u02da\u02e7\u0001\u0000\u0000\u0000\u02db\u02dd\u0005" +
                    "S\u0000\u0000\u02dc\u02db\u0001\u0000\u0000\u0000\u02dc\u02dd\u0001\u0000" +
                    "\u0000\u0000\u02dd\u02de\u0001\u0000\u0000\u0000\u02de\u02e0\u0005\u0002" +
                    "\u0000\u0000\u02df\u02e1\u0005L\u0000\u0000\u02e0\u02df\u0001\u0000\u0000" +
                    "\u0000\u02e0\u02e1\u0001\u0000\u0000\u0000\u02e1\u02e2\u0001\u0000\u0000" +
                    "\u0000\u02e2\u02e4\u0003\u00e2q\u0000\u02e3\u02e5\u0003J%\u0000\u02e4" +
                    "\u02e3\u0001\u0000\u0000\u0000\u02e4\u02e5\u0001\u0000\u0000\u0000\u02e5" +
                    "\u02e7\u0001\u0000\u0000\u0000\u02e6\u02d0\u0001\u0000\u0000\u0000\u02e6" +
                    "\u02d4\u0001\u0000\u0000\u0000\u02e6\u02dc\u0001\u0000\u0000\u0000\u02e7" +
                    "I\u0001\u0000\u0000\u0000\u02e8\u02e9\u0005\b\u0000\u0000\u02e9\u02f9" +
                    "\u0005\t\u0000\u0000\u02ea\u02eb\u0005\b\u0000\u0000\u02eb\u02f0\u0003" +
                    "L&\u0000\u02ec\u02ed\u0005\u0003\u0000\u0000\u02ed\u02ef\u0003L&\u0000" +
                    "\u02ee\u02ec\u0001\u0000\u0000\u0000\u02ef\u02f2\u0001\u0000\u0000\u0000" +
                    "\u02f0\u02ee\u0001\u0000\u0000\u0000\u02f0\u02f1\u0001\u0000\u0000\u0000" +
                    "\u02f1\u02f4\u0001\u0000\u0000\u0000\u02f2\u02f0\u0001\u0000\u0000\u0000" +
                    "\u02f3\u02f5\u0005\u0003\u0000\u0000\u02f4\u02f3\u0001\u0000\u0000\u0000" +
                    "\u02f4\u02f5\u0001\u0000\u0000\u0000\u02f5\u02f6\u0001\u0000\u0000\u0000" +
                    "\u02f6\u02f7\u0005\t\u0000\u0000\u02f7\u02f9\u0001\u0000\u0000\u0000\u02f8" +
                    "\u02e8\u0001\u0000\u0000\u0000\u02f8\u02ea\u0001\u0000\u0000\u0000\u02f9" +
                    "K\u0001\u0000\u0000\u0000\u02fa\u02fb\u0003\u00e4r\u0000\u02fb\u02fc\u0005" +
                    "\u0007\u0000\u0000\u02fc\u02fd\u0003l6\u0000\u02fd\u0300\u0001\u0000\u0000" +
                    "\u0000\u02fe\u0300\u0003l6\u0000\u02ff\u02fa\u0001\u0000\u0000\u0000\u02ff" +
                    "\u02fe\u0001\u0000\u0000\u0000\u0300M\u0001\u0000\u0000\u0000\u0301\u0303" +
                    "\u0003\u00b0X\u0000\u0302\u0301\u0001\u0000\u0000\u0000\u0303\u0306\u0001" +
                    "\u0000\u0000\u0000\u0304\u0302\u0001\u0000\u0000\u0000\u0304\u0305\u0001" +
                    "\u0000\u0000\u0000\u0305\u0307\u0001\u0000\u0000\u0000\u0306\u0304\u0001" +
                    "\u0000\u0000\u0000\u0307\u0308\u0005|\u0000\u0000\u0308\u030a\u0003@ " +
                    "\u0000\u0309\u030b\u0003^/\u0000\u030a\u0309\u0001\u0000\u0000\u0000\u030a" +
                    "\u030b\u0001\u0000\u0000\u0000\u030b\u030c\u0001\u0000\u0000\u0000\u030c" +
                    "\u030d\u0003P(\u0000\u030dO\u0001\u0000\u0000\u0000\u030e\u0317\u0005" +
                    "\f\u0000\u0000\u030f\u0316\u0003\\.\u0000\u0310\u0316\u0003R)\u0000\u0311" +
                    "\u0316\u0003f3\u0000\u0312\u0316\u0003b1\u0000\u0313\u0316\u0003j5\u0000" +
                    "\u0314\u0316\u0003\u0002\u0001\u0000\u0315\u030f\u0001\u0000\u0000\u0000" +
                    "\u0315\u0310\u0001\u0000\u0000\u0000\u0315\u0311\u0001\u0000\u0000\u0000" +
                    "\u0315\u0312\u0001\u0000\u0000\u0000\u0315\u0313\u0001\u0000\u0000\u0000" +
                    "\u0315\u0314\u0001\u0000\u0000\u0000\u0316\u0319\u0001\u0000\u0000\u0000" +
                    "\u0317\u0315\u0001\u0000\u0000\u0000\u0317\u0318\u0001\u0000\u0000\u0000" +
                    "\u0318\u031a\u0001\u0000\u0000\u0000\u0319\u0317\u0001\u0000\u0000\u0000" +
                    "\u031a\u031b\u0005\r\u0000\u0000\u031bQ\u0001\u0000\u0000\u0000\u031c" +
                    "\u031e\u0003\u00b0X\u0000\u031d\u031c\u0001\u0000\u0000\u0000\u031e\u0321" +
                    "\u0001\u0000\u0000\u0000\u031f\u031d\u0001\u0000\u0000\u0000\u031f\u0320" +
                    "\u0001\u0000\u0000\u0000\u0320\u0322\u0001\u0000\u0000\u0000\u0321\u031f" +
                    "\u0001\u0000\u0000\u0000\u0322\u0323\u0005x\u0000\u0000\u0323\u0325\u0003" +
                    "T*\u0000\u0324\u0326\u0003^/\u0000\u0325\u0324\u0001\u0000\u0000\u0000" +
                    "\u0325\u0326\u0001\u0000\u0000\u0000\u0326\u0329\u0001\u0000\u0000\u0000" +
                    "\u0327\u0328\u00055\u0000\u0000\u0328\u032a\u0003j5\u0000\u0329\u0327" +
                    "\u0001\u0000\u0000\u0000\u0329\u032a\u0001\u0000\u0000\u0000\u032aS\u0001" +
                    "\u0000\u0000\u0000\u032b\u032e\u0003X,\u0000\u032c\u032e\u0003V+\u0000" +
                    "\u032d\u032b\u0001\u0000\u0000\u0000\u032d\u032c\u0001\u0000\u0000\u0000" +
                    "\u032eU\u0001\u0000\u0000\u0000\u032f\u0334\u0003\u00d8l\u0000\u0330\u0331" +
                    "\u0005\u0003\u0000\u0000\u0331\u0333\u0003\u00d8l\u0000\u0332\u0330\u0001" +
                    "\u0000\u0000\u0000\u0333\u0336\u0001\u0000\u0000\u0000\u0334\u0332\u0001" +
                    "\u0000\u0000\u0000\u0334\u0335\u0001\u0000\u0000\u0000\u0335\u0338\u0001" +
                    "\u0000\u0000\u0000\u0336\u0334\u0001\u0000\u0000\u0000\u0337\u0339\u0005" +
                    "\u0003\u0000\u0000\u0338\u0337\u0001\u0000\u0000\u0000\u0338\u0339\u0001" +
                    "\u0000\u0000\u0000\u0339W\u0001\u0000\u0000\u0000\u033a\u0348\u0005\b" +
                    "\u0000\u0000\u033b\u033c\u0003Z-\u0000\u033c\u033d\u0005\u0003\u0000\u0000" +
                    "\u033d\u0349\u0001\u0000\u0000\u0000\u033e\u0341\u0003Z-\u0000\u033f\u0340" +
                    "\u0005\u0003\u0000\u0000\u0340\u0342\u0003Z-\u0000\u0341\u033f\u0001\u0000" +
                    "\u0000\u0000\u0342\u0343\u0001\u0000\u0000\u0000\u0343\u0341\u0001\u0000" +
                    "\u0000\u0000\u0343\u0344\u0001\u0000\u0000\u0000\u0344\u0346\u0001\u0000" +
                    "\u0000\u0000\u0345\u0347\u0005\u0003\u0000\u0000\u0346\u0345\u0001\u0000" +
                    "\u0000\u0000\u0346\u0347\u0001\u0000\u0000\u0000\u0347\u0349\u0001\u0000" +
                    "\u0000\u0000\u0348\u033b\u0001\u0000\u0000\u0000\u0348\u033e\u0001\u0000" +
                    "\u0000\u0000\u0348\u0349\u0001\u0000\u0000\u0000\u0349\u034a\u0001\u0000" +
                    "\u0000\u0000\u034a\u0381\u0005\t\u0000\u0000\u034b\u034c\u0003\u00e2q" +
                    "\u0000\u034c\u0358\u0005\b\u0000\u0000\u034d\u0352\u0003Z-\u0000\u034e" +
                    "\u034f\u0005\u0003\u0000\u0000\u034f\u0351\u0003Z-\u0000\u0350\u034e\u0001" +
                    "\u0000\u0000\u0000\u0351\u0354\u0001\u0000\u0000\u0000\u0352\u0350\u0001" +
                    "\u0000\u0000\u0000\u0352\u0353\u0001\u0000\u0000\u0000\u0353\u0356\u0001" +
                    "\u0000\u0000\u0000\u0354\u0352\u0001\u0000\u0000\u0000\u0355\u0357\u0005" +
                    "\u0003\u0000\u0000\u0356\u0355\u0001\u0000\u0000\u0000\u0356\u0357\u0001" +
                    "\u0000\u0000\u0000\u0357\u0359\u0001\u0000\u0000\u0000\u0358\u034d\u0001" +
                    "\u0000\u0000\u0000\u0358\u0359\u0001\u0000\u0000\u0000\u0359\u035a\u0001" +
                    "\u0000\u0000\u0000\u035a\u035b\u0005\t\u0000\u0000\u035b\u0381\u0001\u0000" +
                    "\u0000\u0000\u035c\u035e\u0003\u00e2q\u0000\u035d\u035c\u0001\u0000\u0000" +
                    "\u0000\u035d\u035e\u0001\u0000\u0000\u0000\u035e\u035f\u0001\u0000\u0000" +
                    "\u0000\u035f\u036b\u0005\n\u0000\u0000\u0360\u0365\u0003Z-\u0000\u0361" +
                    "\u0362\u0005\u0003\u0000\u0000\u0362\u0364\u0003Z-\u0000\u0363\u0361\u0001" +
                    "\u0000\u0000\u0000\u0364\u0367\u0001\u0000\u0000\u0000\u0365\u0363\u0001" +
                    "\u0000\u0000\u0000\u0365\u0366\u0001\u0000\u0000\u0000\u0366\u0369\u0001" +
                    "\u0000\u0000\u0000\u0367\u0365\u0001\u0000\u0000\u0000\u0368\u036a\u0005" +
                    "\u0003\u0000\u0000\u0369\u0368\u0001\u0000\u0000\u0000\u0369\u036a\u0001" +
                    "\u0000\u0000\u0000\u036a\u036c\u0001\u0000\u0000\u0000\u036b\u0360\u0001" +
                    "\u0000\u0000\u0000\u036b\u036c\u0001\u0000\u0000\u0000\u036c\u036d\u0001" +
                    "\u0000\u0000\u0000\u036d\u0381\u0005\u000b\u0000\u0000\u036e\u0370\u0003" +
                    "\u00e2q\u0000\u036f\u036e\u0001\u0000\u0000\u0000\u036f\u0370\u0001\u0000" +
                    "\u0000\u0000\u0370\u0371\u0001\u0000\u0000\u0000\u0371\u037d\u0005\f\u0000" +
                    "\u0000\u0372\u0377\u0003Z-\u0000\u0373\u0374\u0005\u0003\u0000\u0000\u0374" +
                    "\u0376\u0003Z-\u0000\u0375\u0373\u0001\u0000\u0000\u0000\u0376\u0379\u0001" +
                    "\u0000\u0000\u0000\u0377\u0375\u0001\u0000\u0000\u0000\u0377\u0378\u0001" +
                    "\u0000\u0000\u0000\u0378\u037b\u0001\u0000\u0000\u0000\u0379\u0377\u0001" +
                    "\u0000\u0000\u0000\u037a\u037c\u0005\u0003\u0000\u0000\u037b\u037a\u0001" +
                    "\u0000\u0000\u0000\u037b\u037c\u0001\u0000\u0000\u0000\u037c\u037e\u0001" +
                    "\u0000\u0000\u0000\u037d\u0372\u0001\u0000\u0000\u0000\u037d\u037e\u0001" +
                    "\u0000\u0000\u0000\u037e\u037f\u0001\u0000\u0000\u0000\u037f\u0381\u0005" +
                    "\r\u0000\u0000\u0380\u033a\u0001\u0000\u0000\u0000\u0380\u034b\u0001\u0000" +
                    "\u0000\u0000\u0380\u035d\u0001\u0000\u0000\u0000\u0380\u036f\u0001\u0000" +
                    "\u0000\u0000\u0381Y\u0001\u0000\u0000\u0000\u0382\u0383\u0003\u00d8l\u0000" +
                    "\u0383\u0384\u0005\u0007\u0000\u0000\u0384\u0386\u0001\u0000\u0000\u0000" +
                    "\u0385\u0382\u0001\u0000\u0000\u0000\u0385\u0386\u0001\u0000\u0000\u0000" +
                    "\u0386\u038a\u0001\u0000\u0000\u0000\u0387\u0388\u0003\u00e4r\u0000\u0388" +
                    "\u0389\u00056\u0000\u0000\u0389\u038b\u0001\u0000\u0000\u0000\u038a\u0387" +
                    "\u0001\u0000\u0000\u0000\u038a\u038b\u0001\u0000\u0000\u0000\u038b\u038c" +
                    "\u0001\u0000\u0000\u0000\u038c\u03a1\u0003X,\u0000\u038d\u038e\u0003\u00d8" +
                    "l\u0000\u038e\u038f\u0005\u0007\u0000\u0000\u038f\u0391\u0001\u0000\u0000" +
                    "\u0000\u0390\u038d\u0001\u0000\u0000\u0000\u0390\u0391\u0001\u0000\u0000" +
                    "\u0000\u0391\u0395\u0001\u0000\u0000\u0000\u0392\u0393\u0003\u00e4r\u0000" +
                    "\u0393\u0394\u00056\u0000\u0000\u0394\u0396\u0001\u0000\u0000\u0000\u0395" +
                    "\u0392\u0001\u0000\u0000\u0000\u0395\u0396\u0001\u0000\u0000\u0000\u0396" +
                    "\u0397\u0001\u0000\u0000\u0000\u0397\u03a1\u0003\u00e4r\u0000\u0398\u039a" +
                    "\u0003\u00d8l\u0000\u0399\u0398\u0001\u0000\u0000\u0000\u0399\u039a\u0001" +
                    "\u0000\u0000\u0000\u039a\u039b\u0001\u0000\u0000\u0000\u039b\u039d\u0005" +
                    "_\u0000\u0000\u039c\u039e\u0003\u00e4r\u0000\u039d\u039c\u0001\u0000\u0000" +
                    "\u0000\u039d\u039e\u0001\u0000\u0000\u0000\u039e\u03a1\u0001\u0000\u0000" +
                    "\u0000\u039f\u03a1\u0003\u00d8l\u0000\u03a0\u0385\u0001\u0000\u0000\u0000" +
                    "\u03a0\u0390\u0001\u0000\u0000\u0000\u03a0\u0399\u0001\u0000\u0000\u0000" +
                    "\u03a0\u039f\u0001\u0000\u0000\u0000\u03a1[\u0001\u0000\u0000\u0000\u03a2" +
                    "\u03a4\u0003\u00b0X\u0000\u03a3\u03a2\u0001\u0000\u0000\u0000\u03a4\u03a7" +
                    "\u0001\u0000\u0000\u0000\u03a5\u03a3\u0001\u0000\u0000\u0000\u03a5\u03a6" +
                    "\u0001\u0000\u0000\u0000\u03a6\u03a8\u0001\u0000\u0000\u0000\u03a7\u03a5" +
                    "\u0001\u0000\u0000\u0000\u03a8\u03a9\u0003\u00d6k\u0000\u03a9\u03aa\u0005" +
                    "r\u0000\u0000\u03aa\u03ac\u0003\u00e4r\u0000\u03ab\u03ad\u0003\u0096K" +
                    "\u0000\u03ac\u03ab\u0001\u0000\u0000\u0000\u03ac\u03ad\u0001\u0000\u0000" +
                    "\u0000\u03ad\u03ae\u0001\u0000\u0000\u0000\u03ae\u03af\u00055\u0000\u0000" +
                    "\u03af\u03b0\u0003p8\u0000\u03b0\u03c0\u0001\u0000\u0000\u0000\u03b1\u03b3" +
                    "\u0003\u00b0X\u0000\u03b2\u03b1\u0001\u0000\u0000\u0000\u03b3\u03b6\u0001" +
                    "\u0000\u0000\u0000\u03b4\u03b2\u0001\u0000\u0000\u0000\u03b4\u03b5\u0001" +
                    "\u0000\u0000\u0000\u03b5\u03b7\u0001\u0000\u0000\u0000\u03b6\u03b4\u0001" +
                    "\u0000\u0000\u0000\u03b7\u03b8\u0003\u00d6k\u0000\u03b8\u03b9\u0005r\u0000" +
                    "\u0000\u03b9\u03bb\u0003\u00e4r\u0000\u03ba\u03bc\u0003\u0096K\u0000\u03bb" +
                    "\u03ba\u0001\u0000\u0000\u0000\u03bb\u03bc\u0001\u0000\u0000\u0000\u03bc" +
                    "\u03bd\u0001\u0000\u0000\u0000\u03bd\u03be\u0003\u00a4R\u0000\u03be\u03c0" +
                    "\u0001\u0000\u0000\u0000\u03bf\u03a5\u0001\u0000\u0000\u0000\u03bf\u03b4" +
                    "\u0001\u0000\u0000\u0000\u03c0]\u0001\u0000\u0000\u0000\u03c1\u03c2\u0005" +
                    "\u0007\u0000\u0000\u03c2\u03c3\u0003p8\u0000\u03c3_\u0001\u0000\u0000" +
                    "\u0000\u03c4\u03c6\u0003\u00b0X\u0000\u03c5\u03c4\u0001\u0000\u0000\u0000" +
                    "\u03c6\u03c9\u0001\u0000\u0000\u0000\u03c7\u03c5\u0001\u0000\u0000\u0000" +
                    "\u03c7\u03c8\u0001\u0000\u0000\u0000\u03c8\u03ca\u0001\u0000\u0000\u0000" +
                    "\u03c9\u03c7\u0001\u0000\u0000\u0000\u03ca\u03cb\u0005\u0089\u0000\u0000" +
                    "\u03cb\u03cc\u0003n7\u0000\u03cc\u03d0\u0003P(\u0000\u03cd\u03cf\u0003" +
                    "d2\u0000\u03ce\u03cd\u0001\u0000\u0000\u0000\u03cf\u03d2\u0001\u0000\u0000" +
                    "\u0000\u03d0\u03ce\u0001\u0000\u0000\u0000\u03d0\u03d1\u0001\u0000\u0000" +
                    "\u0000\u03d1\u03d5\u0001\u0000\u0000\u0000\u03d2\u03d0\u0001\u0000\u0000" +
                    "\u0000\u03d3\u03d4\u0005\u008a\u0000\u0000\u03d4\u03d6\u0003P(\u0000\u03d5" +
                    "\u03d3\u0001\u0000\u0000\u0000\u03d5\u03d6\u0001\u0000\u0000\u0000\u03d6" +
                    "a\u0001\u0000\u0000\u0000\u03d7\u03d9\u0003\u00b0X\u0000\u03d8\u03d7\u0001" +
                    "\u0000\u0000\u0000\u03d9\u03dc\u0001\u0000\u0000\u0000\u03da\u03d8\u0001" +
                    "\u0000\u0000\u0000\u03da\u03db\u0001\u0000\u0000\u0000\u03db\u03dd\u0001" +
                    "\u0000\u0000\u0000\u03dc\u03da\u0001\u0000\u0000\u0000\u03dd\u03de\u0005" +
                    "\u0089\u0000\u0000\u03de\u03e2\u0007\u0006\u0000\u0000\u03df\u03e3\u0003" +
                    "X,\u0000\u03e0\u03e3\u0003\u00e4r\u0000\u03e1\u03e3\u0005\u0092\u0000" +
                    "\u0000\u03e2\u03df\u0001\u0000\u0000\u0000\u03e2\u03e0\u0001\u0000\u0000" +
                    "\u0000\u03e2\u03e1\u0001\u0000\u0000\u0000\u03e3\u03e4\u0001\u0000\u0000" +
                    "\u0000\u03e4\u03e5\u00055\u0000\u0000\u03e5\u03e6\u0003n7\u0000\u03e6" +
                    "\u03e7\u0003P(\u0000\u03e7\u03f4\u0001\u0000\u0000\u0000\u03e8\u03ea\u0003" +
                    "\u00b0X\u0000\u03e9\u03e8\u0001\u0000\u0000\u0000\u03ea\u03ed\u0001\u0000" +
                    "\u0000\u0000\u03eb\u03e9\u0001\u0000\u0000\u0000\u03eb\u03ec\u0001\u0000" +
                    "\u0000\u0000\u03ec\u03ee\u0001\u0000\u0000\u0000\u03ed\u03eb\u0001\u0000" +
                    "\u0000\u0000\u03ee\u03ef\u0005\u0089\u0000\u0000\u03ef\u03f0\u0007\u0006" +
                    "\u0000\u0000\u03f0\u03f1\u0003n7\u0000\u03f1\u03f2\u0003P(\u0000\u03f2" +
                    "\u03f4\u0001\u0000\u0000\u0000\u03f3\u03da\u0001\u0000\u0000\u0000\u03f3" +
                    "\u03eb\u0001\u0000\u0000\u0000\u03f4c\u0001\u0000\u0000\u0000\u03f5\u03f6" +
                    "\u0005\u008a\u0000\u0000\u03f6\u03f7\u0005\u0089\u0000\u0000\u03f7\u03f8" +
                    "\u0003n7\u0000\u03f8\u03f9\u0003P(\u0000\u03f9e\u0001\u0000\u0000\u0000" +
                    "\u03fa\u03fc\u0003\u00b0X\u0000\u03fb\u03fa\u0001\u0000\u0000\u0000\u03fc" +
                    "\u03ff\u0001\u0000\u0000\u0000\u03fd\u03fb\u0001\u0000\u0000\u0000\u03fd" +
                    "\u03fe\u0001\u0000\u0000\u0000\u03fe\u0400\u0001\u0000\u0000\u0000\u03ff" +
                    "\u03fd\u0001\u0000\u0000\u0000\u0400\u0401\u0005v\u0000\u0000\u0401\u0402" +
                    "\u0003n7\u0000\u0402\u0403\u0003P(\u0000\u0403\u0422\u0001\u0000\u0000" +
                    "\u0000\u0404\u0406\u0003\u00b0X\u0000\u0405\u0404\u0001\u0000\u0000\u0000" +
                    "\u0406\u0409\u0001\u0000\u0000\u0000\u0407\u0405\u0001\u0000\u0000\u0000" +
                    "\u0407\u0408\u0001\u0000\u0000\u0000\u0408\u040a\u0001\u0000\u0000\u0000" +
                    "\u0409\u0407\u0001\u0000\u0000\u0000\u040a\u040b\u0005v\u0000\u0000\u040b" +
                    "\u040c\u0005x\u0000\u0000\u040c\u040d\u0003T*\u0000\u040d\u040e\u0005" +
                    "5\u0000\u0000\u040e\u040f\u0003n7\u0000\u040f\u0410\u0003P(\u0000\u0410" +
                    "\u0422\u0001\u0000\u0000\u0000\u0411\u0413\u0003\u00b0X\u0000\u0412\u0411" +
                    "\u0001\u0000\u0000\u0000\u0413\u0416\u0001\u0000\u0000\u0000\u0414\u0412" +
                    "\u0001\u0000\u0000\u0000\u0414\u0415\u0001\u0000\u0000\u0000\u0415\u0417" +
                    "\u0001\u0000\u0000\u0000\u0416\u0414\u0001\u0000\u0000\u0000\u0417\u0418" +
                    "\u0005w\u0000\u0000\u0418\u0419\u0003T*\u0000\u0419\u041a\u0003\u0094" +
                    "J\u0000\u041a\u041d\u0003n7\u0000\u041b\u041c\u0005\u0089\u0000\u0000" +
                    "\u041c\u041e\u0003n7\u0000\u041d\u041b\u0001\u0000\u0000\u0000\u041d\u041e" +
                    "\u0001\u0000\u0000\u0000\u041e\u041f\u0001\u0000\u0000\u0000\u041f\u0420" +
                    "\u0003P(\u0000\u0420\u0422\u0001\u0000\u0000\u0000\u0421\u03fd\u0001\u0000" +
                    "\u0000\u0000\u0421\u0407\u0001\u0000\u0000\u0000\u0421\u0414\u0001\u0000" +
                    "\u0000\u0000\u0422g\u0001\u0000\u0000\u0000\u0423\u0424\u0005\u0089\u0000" +
                    "\u0000\u0424\u0425\u0003n7\u0000\u0425i\u0001\u0000\u0000\u0000\u0426" +
                    "\u0428\u0003\u00b0X\u0000\u0427\u0426\u0001\u0000\u0000\u0000\u0428\u042b" +
                    "\u0001\u0000\u0000\u0000\u0429\u0427\u0001\u0000\u0000\u0000\u0429\u042a" +
                    "\u0001\u0000\u0000\u0000\u042a\u042c\u0001\u0000\u0000\u0000\u042b\u0429" +
                    "\u0001\u0000\u0000\u0000\u042c\u042e\u0003l6\u0000\u042d\u042f\u0005S" +
                    "\u0000\u0000\u042e\u042d\u0001\u0000\u0000\u0000\u042e\u042f\u0001\u0000" +
                    "\u0000\u0000\u042f\u0431\u0001\u0000\u0000\u0000\u0430\u0432\u0003\u0002" +
                    "\u0001\u0000\u0431\u0430\u0001\u0000\u0000\u0000\u0431\u0432\u0001\u0000" +
                    "\u0000\u0000\u0432k\u0001\u0000\u0000\u0000\u0433\u0434\u00066\uffff\uffff" +
                    "\u0000\u0434\u0435\u0003v;\u0000\u0435\u0436\u0003l6\u001e\u0436\u0451" +
                    "\u0001\u0000\u0000\u0000\u0437\u0438\u0005\b\u0000\u0000\u0438\u0439\u0003" +
                    "l6\u0000\u0439\u043a\u0005\t\u0000\u0000\u043a\u0451\u0001\u0000\u0000" +
                    "\u0000\u043b\u043c\u0005\u0016\u0000\u0000\u043c\u043d\u0003l6\u0000\u043d" +
                    "\u043e\u0005\u0017\u0000\u0000\u043e\u0451\u0001\u0000\u0000\u0000\u043f" +
                    "\u0440\u0005\u0014\u0000\u0000\u0440\u0441\u0003l6\u0000\u0441\u0442\u0005" +
                    "\u0015\u0000\u0000\u0442\u0451\u0001\u0000\u0000\u0000\u0443\u0451\u0003" +
                    "t:\u0000\u0444\u0451\u0003`0\u0000\u0445\u0451\u0003\u00c6c\u0000\u0446" +
                    "\u0451\u0003\u00b4Z\u0000\u0447\u0451\u0003\u00b6[\u0000\u0448\u0451\u0003" +
                    "\u00c4b\u0000\u0449\u0451\u0003\u00aeW\u0000\u044a\u0451\u0003N\'\u0000" +
                    "\u044b\u0451\u0003P(\u0000\u044c\u0451\u0003\u00a0P\u0000\u044d\u0451" +
                    "\u0003\u00ccf\u0000\u044e\u0451\u0003\u00d2i\u0000\u044f\u0451\u0003r" +
                    "9\u0000\u0450\u0433\u0001\u0000\u0000\u0000\u0450\u0437\u0001\u0000\u0000" +
                    "\u0000\u0450\u043b\u0001\u0000\u0000\u0000\u0450\u043f\u0001\u0000\u0000" +
                    "\u0000\u0450\u0443\u0001\u0000\u0000\u0000\u0450\u0444\u0001\u0000\u0000" +
                    "\u0000\u0450\u0445\u0001\u0000\u0000\u0000\u0450\u0446\u0001\u0000\u0000" +
                    "\u0000\u0450\u0447\u0001\u0000\u0000\u0000\u0450\u0448\u0001\u0000\u0000" +
                    "\u0000\u0450\u0449\u0001\u0000\u0000\u0000\u0450\u044a\u0001\u0000\u0000" +
                    "\u0000\u0450\u044b\u0001\u0000\u0000\u0000\u0450\u044c\u0001\u0000\u0000" +
                    "\u0000\u0450\u044d\u0001\u0000\u0000\u0000\u0450\u044e\u0001\u0000\u0000" +
                    "\u0000\u0450\u044f\u0001\u0000\u0000\u0000\u0451\u04a5\u0001\u0000\u0000" +
                    "\u0000\u0452\u0453\n\u001d\u0000\u0000\u0453\u0454\u0003\u0080@\u0000" +
                    "\u0454\u0455\u0003l6\u001d\u0455\u04a4\u0001\u0000\u0000\u0000\u0456\u0457" +
                    "\n\u001c\u0000\u0000\u0457\u0458\u0003\u0086C\u0000\u0458\u0459\u0003" +
                    "l6\u001d\u0459\u04a4\u0001\u0000\u0000\u0000\u045a\u045b\n\u001b\u0000" +
                    "\u0000\u045b\u045c\u0003\u0088D\u0000\u045c\u045d\u0003l6\u001c\u045d" +
                    "\u04a4\u0001\u0000\u0000\u0000\u045e\u045f\n\u001a\u0000\u0000\u045f\u0460" +
                    "\u0003\u008aE\u0000\u0460\u0461\u0003l6\u001b\u0461\u04a4\u0001\u0000" +
                    "\u0000\u0000\u0462\u0463\n\u0019\u0000\u0000\u0463\u0464\u0003z=\u0000" +
                    "\u0464\u0465\u0003l6\u001a\u0465\u04a4\u0001\u0000\u0000\u0000\u0466\u0467" +
                    "\n\u0018\u0000\u0000\u0467\u0468\u0003\u0082A\u0000\u0468\u0469\u0003" +
                    "l6\u0019\u0469\u04a4\u0001\u0000\u0000\u0000\u046a\u046b\n\u0017\u0000" +
                    "\u0000\u046b\u046c\u0003~?\u0000\u046c\u046d\u0003l6\u0018\u046d\u04a4" +
                    "\u0001\u0000\u0000\u0000\u046e\u046f\n\u0014\u0000\u0000\u046f\u0470\u0003" +
                    "\u0094J\u0000\u0470\u0471\u0003l6\u0015\u0471\u04a4\u0001\u0000\u0000" +
                    "\u0000\u0472\u0473\n\u0012\u0000\u0000\u0473\u0474\u0003\u008cF\u0000" +
                    "\u0474\u0475\u0003l6\u0013\u0475\u04a4\u0001\u0000\u0000\u0000\u0476\u0477" +
                    "\n\u0011\u0000\u0000\u0477\u0478\u0003\u008eG\u0000\u0478\u0479\u0003" +
                    "l6\u0012\u0479\u04a4\u0001\u0000\u0000\u0000\u047a\u047b\n$\u0000\u0000" +
                    "\u047b\u04a4\u0003x<\u0000\u047c\u047d\n#\u0000\u0000\u047d\u04a4\u0003" +
                    "\u00d0h\u0000\u047e\u047f\n\"\u0000\u0000\u047f\u04a4\u0003\u009aM\u0000" +
                    "\u0480\u0481\n!\u0000\u0000\u0481\u04a4\u0003H$\u0000\u0482\u0484\n \u0000" +
                    "\u0000\u0483\u0485\u0005S\u0000\u0000\u0484\u0483\u0001\u0000\u0000\u0000" +
                    "\u0484\u0485\u0001\u0000\u0000\u0000\u0485\u0487\u0001\u0000\u0000\u0000" +
                    "\u0486\u0488\u0005\u0002\u0000\u0000\u0487\u0486\u0001\u0000\u0000\u0000" +
                    "\u0487\u0488\u0001\u0000\u0000\u0000\u0488\u0489\u0001\u0000\u0000\u0000" +
                    "\u0489\u04a4\u0003P(\u0000\u048a\u048c\n\u001f\u0000\u0000\u048b\u048d" +
                    "\u0005S\u0000\u0000\u048c\u048b\u0001\u0000\u0000\u0000\u048c\u048d\u0001" +
                    "\u0000\u0000\u0000\u048d\u048e\u0001\u0000\u0000\u0000\u048e\u048f\u0005" +
                    "\u0002\u0000\u0000\u048f\u0495\u0007\u0007\u0000\u0000\u0490\u0491\u0005" +
                    "]\u0000\u0000\u0491\u0493\u0003\u00e4r\u0000\u0492\u0494\u0003^/\u0000" +
                    "\u0493\u0492\u0001\u0000\u0000\u0000\u0493\u0494\u0001\u0000\u0000\u0000" +
                    "\u0494\u0496\u0001\u0000\u0000\u0000\u0495\u0490\u0001\u0000\u0000\u0000" +
                    "\u0495\u0496\u0001\u0000\u0000\u0000\u0496\u0497\u0001\u0000\u0000\u0000" +
                    "\u0497\u04a4\u0003\u00b8\\\u0000\u0498\u0499\n\u0016\u0000\u0000\u0499" +
                    "\u049a\u0003\u0090H\u0000\u049a\u049b\u0003p8\u0000\u049b\u04a4\u0001" +
                    "\u0000\u0000\u0000\u049c\u049d\n\u0015\u0000\u0000\u049d\u049e\u0003\u0092" +
                    "I\u0000\u049e\u049f\u0003p8\u0000\u049f\u04a4\u0001\u0000\u0000\u0000" +
                    "\u04a0\u04a1\n\u0013\u0000\u0000\u04a1\u04a2\u0005R\u0000\u0000\u04a2" +
                    "\u04a4\u0003\u008eG\u0000\u04a3\u0452\u0001\u0000\u0000\u0000\u04a3\u0456" +
                    "\u0001\u0000\u0000\u0000\u04a3\u045a\u0001\u0000\u0000\u0000\u04a3\u045e" +
                    "\u0001\u0000\u0000\u0000\u04a3\u0462\u0001\u0000\u0000\u0000\u04a3\u0466" +
                    "\u0001\u0000\u0000\u0000\u04a3\u046a\u0001\u0000\u0000\u0000\u04a3\u046e" +
                    "\u0001\u0000\u0000\u0000\u04a3\u0472\u0001\u0000\u0000\u0000\u04a3\u0476" +
                    "\u0001\u0000\u0000\u0000\u04a3\u047a\u0001\u0000\u0000\u0000\u04a3\u047c" +
                    "\u0001\u0000\u0000\u0000\u04a3\u047e\u0001\u0000\u0000\u0000\u04a3\u0480" +
                    "\u0001\u0000\u0000\u0000\u04a3\u0482\u0001\u0000\u0000\u0000\u04a3\u048a" +
                    "\u0001\u0000\u0000\u0000\u04a3\u0498\u0001\u0000\u0000\u0000\u04a3\u049c" +
                    "\u0001\u0000\u0000\u0000\u04a3\u04a0\u0001\u0000\u0000\u0000\u04a4\u04a7" +
                    "\u0001\u0000\u0000\u0000\u04a5\u04a3\u0001\u0000\u0000\u0000\u04a5\u04a6" +
                    "\u0001\u0000\u0000\u0000\u04a6m\u0001\u0000\u0000\u0000\u04a7\u04a5\u0001" +
                    "\u0000\u0000\u0000\u04a8\u04a9\u00067\uffff\uffff\u0000\u04a9\u04aa\u0003" +
                    "v;\u0000\u04aa\u04ab\u0003n7\u0012\u04ab\u04bc\u0001\u0000\u0000\u0000" +
                    "\u04ac\u04ad\u0005\b\u0000\u0000\u04ad\u04ae\u0003l6\u0000\u04ae\u04af" +
                    "\u0005\t\u0000\u0000\u04af\u04bc\u0001\u0000\u0000\u0000\u04b0\u04b1\u0005" +
                    "\u0016\u0000\u0000\u04b1\u04b2\u0003l6\u0000\u04b2\u04b3\u0005\u0017\u0000" +
                    "\u0000\u04b3\u04bc\u0001\u0000\u0000\u0000\u04b4\u04b5\u0005\u0014\u0000" +
                    "\u0000\u04b5\u04b6\u0003l6\u0000\u04b6\u04b7\u0005\u0015\u0000\u0000\u04b7" +
                    "\u04bc\u0001\u0000\u0000\u0000\u04b8\u04bc\u0003\u00ccf\u0000\u04b9\u04bc" +
                    "\u0003\u00d2i\u0000\u04ba\u04bc\u0003r9\u0000\u04bb\u04a8\u0001\u0000" +
                    "\u0000\u0000\u04bb\u04ac\u0001\u0000\u0000\u0000\u04bb\u04b0\u0001\u0000" +
                    "\u0000\u0000\u04bb\u04b4\u0001\u0000\u0000\u0000\u04bb\u04b8\u0001\u0000" +
                    "\u0000\u0000\u04bb\u04b9\u0001\u0000\u0000\u0000\u04bb\u04ba\u0001\u0000" +
                    "\u0000\u0000\u04bc\u04e5\u0001\u0000\u0000\u0000\u04bd\u04be\n\u000e\u0000" +
                    "\u0000\u04be\u04bf\u0003\u0086C\u0000\u04bf\u04c0\u0003n7\u000f\u04c0" +
                    "\u04e4\u0001\u0000\u0000\u0000\u04c1\u04c2\n\r\u0000\u0000\u04c2\u04c3" +
                    "\u0003\u0088D\u0000\u04c3\u04c4\u0003n7\u000e\u04c4\u04e4\u0001\u0000" +
                    "\u0000\u0000\u04c5\u04c6\n\f\u0000\u0000\u04c6\u04c7\u0003\u008aE\u0000" +
                    "\u04c7\u04c8\u0003n7\r\u04c8\u04e4\u0001\u0000\u0000\u0000\u04c9\u04ca" +
                    "\n\u000b\u0000\u0000\u04ca\u04cb\u0003~?\u0000\u04cb\u04cc\u0003n7\f\u04cc" +
                    "\u04e4\u0001\u0000\u0000\u0000\u04cd\u04ce\n\n\u0000\u0000\u04ce\u04cf" +
                    "\u0003z=\u0000\u04cf\u04d0\u0003n7\u000b\u04d0\u04e4\u0001\u0000\u0000" +
                    "\u0000\u04d1\u04d2\n\u0007\u0000\u0000\u04d2\u04d3\u0003\u0082A\u0000" +
                    "\u04d3\u04d4\u0003n7\b\u04d4\u04e4\u0001\u0000\u0000\u0000\u04d5\u04d6" +
                    "\n\u0011\u0000\u0000\u04d6\u04e4\u0003H$\u0000\u04d7\u04d8\n\u0010\u0000" +
                    "\u0000\u04d8\u04e4\u0003\u009aM\u0000\u04d9\u04da\n\u000f\u0000\u0000" +
                    "\u04da\u04e4\u0003\u00d0h\u0000\u04db\u04dc\n\t\u0000\u0000\u04dc\u04dd" +
                    "\u0003\u0090H\u0000\u04dd\u04de\u0003p8\u0000\u04de\u04e4\u0001\u0000" +
                    "\u0000\u0000\u04df\u04e0\n\b\u0000\u0000\u04e0\u04e1\u0003\u0092I\u0000" +
                    "\u04e1\u04e2\u0003p8\u0000\u04e2\u04e4\u0001\u0000\u0000\u0000\u04e3\u04bd" +
                    "\u0001\u0000\u0000\u0000\u04e3\u04c1\u0001\u0000\u0000\u0000\u04e3\u04c5" +
                    "\u0001\u0000\u0000\u0000\u04e3\u04c9\u0001\u0000\u0000\u0000\u04e3\u04cd" +
                    "\u0001\u0000\u0000\u0000\u04e3\u04d1\u0001\u0000\u0000\u0000\u04e3\u04d5" +
                    "\u0001\u0000\u0000\u0000\u04e3\u04d7\u0001\u0000\u0000\u0000\u04e3\u04d9" +
                    "\u0001\u0000\u0000\u0000\u04e3\u04db\u0001\u0000\u0000\u0000\u04e3\u04df" +
                    "\u0001\u0000\u0000\u0000\u04e4\u04e7\u0001\u0000\u0000\u0000\u04e5\u04e3" +
                    "\u0001\u0000\u0000\u0000\u04e5\u04e6\u0001\u0000\u0000\u0000\u04e6o\u0001" +
                    "\u0000\u0000\u0000\u04e7\u04e5\u0001\u0000\u0000\u0000\u04e8\u04e9\u0006" +
                    "8\uffff\uffff\u0000\u04e9\u04ea\u0003v;\u0000\u04ea\u04eb\u0003p8\b\u04eb" +
                    "\u04ff\u0001\u0000\u0000\u0000\u04ec\u04fa\u0005\b\u0000\u0000\u04ed\u04ee" +
                    "\u0003p8\u0000\u04ee\u04ef\u0005\u0003\u0000\u0000\u04ef\u04fb\u0001\u0000" +
                    "\u0000\u0000\u04f0\u04f3\u0003p8\u0000\u04f1\u04f2\u0005\u0003\u0000\u0000" +
                    "\u04f2\u04f4\u0003p8\u0000\u04f3\u04f1\u0001\u0000\u0000\u0000\u04f4\u04f5" +
                    "\u0001\u0000\u0000\u0000\u04f5\u04f3\u0001\u0000\u0000\u0000\u04f5\u04f6" +
                    "\u0001\u0000\u0000\u0000\u04f6\u04f8\u0001\u0000\u0000\u0000\u04f7\u04f9" +
                    "\u0005\u0003\u0000\u0000\u04f8\u04f7\u0001\u0000\u0000\u0000\u04f8\u04f9" +
                    "\u0001\u0000\u0000\u0000\u04f9\u04fb\u0001\u0000\u0000\u0000\u04fa\u04ed" +
                    "\u0001\u0000\u0000\u0000\u04fa\u04f0\u0001\u0000\u0000\u0000\u04fa\u04fb" +
                    "\u0001\u0000\u0000\u0000\u04fb\u04fc\u0001\u0000\u0000\u0000\u04fc\u04ff" +
                    "\u0005\t\u0000\u0000\u04fd\u04ff\u0003r9\u0000\u04fe\u04e8\u0001\u0000" +
                    "\u0000\u0000\u04fe\u04ec\u0001\u0000\u0000\u0000\u04fe\u04fd\u0001\u0000" +
                    "\u0000\u0000\u04ff\u0511\u0001\u0000\u0000\u0000\u0500\u0501\n\u0006\u0000" +
                    "\u0000\u0501\u0502\u0003|>\u0000\u0502\u0503\u0003p8\u0007\u0503\u0510" +
                    "\u0001\u0000\u0000\u0000\u0504\u0505\n\u0005\u0000\u0000\u0505\u0506\u0003" +
                    "\u0084B\u0000\u0506\u0507\u0003p8\u0006\u0507\u0510\u0001\u0000\u0000" +
                    "\u0000\u0508\u0509\n\u0004\u0000\u0000\u0509\u050a\u0005\u001a\u0000\u0000" +
                    "\u050a\u0510\u0003p8\u0005\u050b\u050c\n\u0007\u0000\u0000\u050c\u0510" +
                    "\u0003\u009cN\u0000\u050d\u050e\n\u0003\u0000\u0000\u050e\u0510\u0003" +
                    "\u009cN\u0000\u050f\u0500\u0001\u0000\u0000\u0000\u050f\u0504\u0001\u0000" +
                    "\u0000\u0000\u050f\u0508\u0001\u0000\u0000\u0000\u050f\u050b\u0001\u0000" +
                    "\u0000\u0000\u050f\u050d\u0001\u0000\u0000\u0000\u0510\u0513\u0001\u0000" +
                    "\u0000\u0000\u0511\u050f\u0001\u0000\u0000\u0000\u0511\u0512\u0001\u0000" +
                    "\u0000\u0000\u0512q\u0001\u0000\u0000\u0000\u0513\u0511\u0001\u0000\u0000" +
                    "\u0000\u0514\u051b\u0003\u00ecv\u0000\u0515\u051b\u0003\u00e8t\u0000\u0516" +
                    "\u051b\u0003\u00dcn\u0000\u0517\u051b\u0003\u00deo\u0000\u0518\u051b\u0003" +
                    "\u00e2q\u0000\u0519\u051b\u0005\u0092\u0000\u0000\u051a\u0514\u0001\u0000" +
                    "\u0000\u0000\u051a\u0515\u0001\u0000\u0000\u0000\u051a\u0516\u0001\u0000" +
                    "\u0000\u0000\u051a\u0517\u0001\u0000\u0000\u0000\u051a\u0518\u0001\u0000" +
                    "\u0000\u0000\u051a\u0519\u0001\u0000\u0000\u0000\u051bs\u0001\u0000\u0000" +
                    "\u0000\u051c\u0522\u0005\u008c\u0000\u0000\u051d\u051f\u0005\u008d\u0000" +
                    "\u0000\u051e\u0520\u0003l6\u0000\u051f\u051e\u0001\u0000\u0000\u0000\u051f" +
                    "\u0520\u0001\u0000\u0000\u0000\u0520\u0522\u0001\u0000\u0000\u0000\u0521" +
                    "\u051c\u0001\u0000\u0000\u0000\u0521\u051d\u0001\u0000\u0000\u0000\u0522" +
                    "\u053d\u0001\u0000\u0000\u0000\u0523\u0526\u0005\u008f\u0000\u0000\u0524" +
                    "\u0525\u0005j\u0000\u0000\u0525\u0527\u0003\u00e4r\u0000\u0526\u0524\u0001" +
                    "\u0000\u0000\u0000\u0526\u0527\u0001\u0000\u0000\u0000\u0527\u053d\u0001" +
                    "\u0000\u0000\u0000\u0528\u052b\u0005\u0090\u0000\u0000\u0529\u052a\u0005" +
                    "j\u0000\u0000\u052a\u052c\u0003\u00e4r\u0000\u052b\u0529\u0001\u0000\u0000" +
                    "\u0000\u052b\u052c\u0001\u0000\u0000\u0000\u052c\u053d\u0001\u0000\u0000" +
                    "\u0000\u052d\u052e\u0005\u0091\u0000\u0000\u052e\u053d\u0003l6\u0000\u052f" +
                    "\u0532\u0005\u008e\u0000\u0000\u0530\u0531\u0005j\u0000\u0000\u0531\u0533" +
                    "\u0003\u00e4r\u0000\u0532\u0530\u0001\u0000\u0000\u0000\u0532\u0533\u0001" +
                    "\u0000\u0000\u0000\u0533\u0535\u0001\u0000\u0000\u0000\u0534\u0536\u0003" +
                    "l6\u0000\u0535\u0534\u0001\u0000\u0000\u0000\u0535\u0536\u0001\u0000\u0000" +
                    "\u0000\u0536\u053d\u0001\u0000\u0000\u0000\u0537\u0538\u0005\u008e\u0000" +
                    "\u0000\u0538\u053d\u0005\u008f\u0000\u0000\u0539\u053a\u0005\u008e\u0000" +
                    "\u0000\u053a\u053b\u0005\u0081\u0000\u0000\u053b\u053d\u0003l6\u0000\u053c" +
                    "\u0521\u0001\u0000\u0000\u0000\u053c\u0523\u0001\u0000\u0000\u0000\u053c" +
                    "\u0528\u0001\u0000\u0000\u0000\u053c\u052d\u0001\u0000\u0000\u0000\u053c" +
                    "\u052f\u0001\u0000\u0000\u0000\u053c\u0537\u0001\u0000\u0000\u0000\u053c" +
                    "\u0539\u0001\u0000\u0000\u0000\u053du\u0001\u0000\u0000\u0000\u053e\u053f" +
                    "\u0007\b\u0000\u0000\u053fw\u0001\u0000\u0000\u0000\u0540\u0541\u0007" +
                    "\t\u0000\u0000\u0541y\u0001\u0000\u0000\u0000\u0542\u0543\u0007\n\u0000" +
                    "\u0000\u0543{\u0001\u0000\u0000\u0000\u0544\u0545\u0007\u000b\u0000\u0000" +
                    "\u0545}\u0001\u0000\u0000\u0000\u0546\u0547\u0007\f\u0000\u0000\u0547" +
                    "\u007f\u0001\u0000\u0000\u0000\u0548\u0549\u0007\r\u0000\u0000\u0549\u0081" +
                    "\u0001\u0000\u0000\u0000\u054a\u054b\u0005`\u0000\u0000\u054b\u0083\u0001" +
                    "\u0000\u0000\u0000\u054c\u054d\u0007\u000e\u0000\u0000\u054d\u0085\u0001" +
                    "\u0000\u0000\u0000\u054e\u054f\u0007\u000f\u0000\u0000\u054f\u0087\u0001" +
                    "\u0000\u0000\u0000\u0550\u0551\u0007\u0010\u0000\u0000\u0551\u0089\u0001" +
                    "\u0000\u0000\u0000\u0552\u0553\u0007\u0011\u0000\u0000\u0553\u008b\u0001" +
                    "\u0000\u0000\u0000\u0554\u0555\u0007\u0012\u0000\u0000\u0555\u008d\u0001" +
                    "\u0000\u0000\u0000\u0556\u0557\u0007\u0013\u0000\u0000\u0557\u008f\u0001" +
                    "\u0000\u0000\u0000\u0558\u055f\u0005Z\u0000\u0000\u0559\u055a\u0005Z\u0000" +
                    "\u0000\u055a\u055f\u0005U\u0000\u0000\u055b\u055f\u0005[\u0000\u0000\u055c" +
                    "\u055f\u0005\\\u0000\u0000\u055d\u055f\u0005Y\u0000\u0000\u055e\u0558" +
                    "\u0001\u0000\u0000\u0000\u055e\u0559\u0001\u0000\u0000\u0000\u055e\u055b" +
                    "\u0001\u0000\u0000\u0000\u055e\u055c\u0001\u0000\u0000\u0000\u055e\u055d" +
                    "\u0001\u0000\u0000\u0000\u055f\u0091\u0001\u0000\u0000\u0000\u0560\u0561" +
                    "\u0005]\u0000\u0000\u0561\u0093\u0001\u0000\u0000\u0000\u0562\u0568\u0005" +
                    "W\u0000\u0000\u0563\u0564\u0005U\u0000\u0000\u0564\u0568\u0005W\u0000" +
                    "\u0000\u0565\u0568\u0005V\u0000\u0000\u0566\u0568\u0005X\u0000\u0000\u0567" +
                    "\u0562\u0001\u0000\u0000\u0000\u0567\u0563\u0001\u0000\u0000\u0000\u0567" +
                    "\u0565\u0001\u0000\u0000\u0000\u0567\u0566\u0001\u0000\u0000\u0000\u0568" +
                    "\u0095\u0001\u0000\u0000\u0000\u0569\u056a\u0005\u000e\u0000\u0000\u056a" +
                    "\u0590\u0005\u000f\u0000\u0000\u056b\u056c\u0005\u000e\u0000\u0000\u056c" +
                    "\u0571\u0003\u0098L\u0000\u056d\u056e\u0005\u0003\u0000\u0000\u056e\u0570" +
                    "\u0003\u0098L\u0000\u056f\u056d\u0001\u0000\u0000\u0000\u0570\u0573\u0001" +
                    "\u0000\u0000\u0000\u0571\u056f\u0001\u0000\u0000\u0000\u0571\u0572\u0001" +
                    "\u0000\u0000\u0000\u0572\u0575\u0001\u0000\u0000\u0000\u0573\u0571\u0001" +
                    "\u0000\u0000\u0000\u0574\u0576\u0005\u0003\u0000\u0000\u0575\u0574\u0001" +
                    "\u0000\u0000\u0000\u0575\u0576\u0001\u0000\u0000\u0000\u0576\u0577\u0001" +
                    "\u0000\u0000\u0000\u0577\u0578\u0005\u000f\u0000\u0000\u0578\u0590\u0001" +
                    "\u0000\u0000\u0000\u0579\u057b\u0005\u0006\u0000\u0000\u057a\u0579\u0001" +
                    "\u0000\u0000\u0000\u057a\u057b\u0001\u0000\u0000\u0000\u057b\u057c\u0001" +
                    "\u0000\u0000\u0000\u057c\u057d\u0005+\u0000\u0000\u057d\u0590\u00050\u0000" +
                    "\u0000\u057e\u0580\u0005\u0006\u0000\u0000\u057f\u057e\u0001\u0000\u0000" +
                    "\u0000\u057f\u0580\u0001\u0000\u0000\u0000\u0580\u0581\u0001\u0000\u0000" +
                    "\u0000\u0581\u0582\u0005+\u0000\u0000\u0582\u0587\u0003\u0098L\u0000\u0583" +
                    "\u0584\u0005\u0003\u0000\u0000\u0584\u0586\u0003\u0098L\u0000\u0585\u0583" +
                    "\u0001\u0000\u0000\u0000\u0586\u0589\u0001\u0000\u0000\u0000\u0587\u0585" +
                    "\u0001\u0000\u0000\u0000\u0587\u0588\u0001\u0000\u0000\u0000\u0588\u058b" +
                    "\u0001\u0000\u0000\u0000\u0589\u0587\u0001\u0000\u0000\u0000\u058a\u058c" +
                    "\u0005\u0003\u0000\u0000\u058b\u058a\u0001\u0000\u0000\u0000\u058b\u058c" +
                    "\u0001\u0000\u0000\u0000\u058c\u058d\u0001\u0000\u0000\u0000\u058d\u058e" +
                    "\u00050\u0000\u0000\u058e\u0590\u0001\u0000\u0000\u0000\u058f\u0569\u0001" +
                    "\u0000\u0000\u0000\u058f\u056b\u0001\u0000\u0000\u0000\u058f\u057a\u0001" +
                    "\u0000\u0000\u0000\u058f\u057f\u0001\u0000\u0000\u0000\u0590\u0097\u0001" +
                    "\u0000\u0000\u0000\u0591\u0592\u0003\u00e4r\u0000\u0592\u0593\u0005\u0007" +
                    "\u0000\u0000\u0593\u0595\u0001\u0000\u0000\u0000\u0594\u0591\u0001\u0000" +
                    "\u0000\u0000\u0594\u0595\u0001\u0000\u0000\u0000\u0595\u0596\u0001\u0000" +
                    "\u0000\u0000\u0596\u0597\u0003p8\u0000\u0597\u0099\u0001\u0000\u0000\u0000" +
                    "\u0598\u0599\u0005\u0006\u0000\u0000\u0599\u059a\u0005+\u0000\u0000\u059a" +
                    "\u05bb\u00050\u0000\u0000\u059b\u059c\u0005\u0006\u0000\u0000\u059c\u059d" +
                    "\u0005+\u0000\u0000\u059d\u05a2\u0003\u009eO\u0000\u059e\u059f\u0005\u0003" +
                    "\u0000\u0000\u059f\u05a1\u0003\u009eO\u0000\u05a0\u059e\u0001\u0000\u0000" +
                    "\u0000\u05a1\u05a4\u0001\u0000\u0000\u0000\u05a2\u05a0\u0001\u0000\u0000" +
                    "\u0000\u05a2\u05a3\u0001\u0000\u0000\u0000\u05a3\u05a6\u0001\u0000\u0000" +
                    "\u0000\u05a4\u05a2\u0001\u0000\u0000\u0000\u05a5\u05a7\u0005\u0003\u0000" +
                    "\u0000\u05a6\u05a5\u0001\u0000\u0000\u0000\u05a6\u05a7\u0001\u0000\u0000" +
                    "\u0000\u05a7\u05a8\u0001\u0000\u0000\u0000\u05a8\u05a9\u00050\u0000\u0000" +
                    "\u05a9\u05bb\u0001\u0000\u0000\u0000\u05aa\u05ab\u0005\u000e\u0000\u0000" +
                    "\u05ab\u05bb\u0005\u000f\u0000\u0000\u05ac\u05ad\u0005\u000e\u0000\u0000" +
                    "\u05ad\u05b2\u0003\u009eO\u0000\u05ae\u05af\u0005\u0003\u0000\u0000\u05af" +
                    "\u05b1\u0003\u009eO\u0000\u05b0\u05ae\u0001\u0000\u0000\u0000\u05b1\u05b4" +
                    "\u0001\u0000\u0000\u0000\u05b2\u05b0\u0001\u0000\u0000\u0000\u05b2\u05b3" +
                    "\u0001\u0000\u0000\u0000\u05b3\u05b6\u0001\u0000\u0000\u0000\u05b4\u05b2" +
                    "\u0001\u0000\u0000\u0000\u05b5\u05b7\u0005\u0003\u0000\u0000\u05b6\u05b5" +
                    "\u0001\u0000\u0000\u0000\u05b6\u05b7\u0001\u0000\u0000\u0000\u05b7\u05b8" +
                    "\u0001\u0000\u0000\u0000\u05b8\u05b9\u0005\u000f\u0000\u0000\u05b9\u05bb" +
                    "\u0001\u0000\u0000\u0000\u05ba\u0598\u0001\u0000\u0000\u0000\u05ba\u059b" +
                    "\u0001\u0000\u0000\u0000\u05ba\u05aa\u0001\u0000\u0000\u0000\u05ba\u05ac" +
                    "\u0001\u0000\u0000\u0000\u05bb\u009b\u0001\u0000\u0000\u0000\u05bc\u05be" +
                    "\u0005\u0006\u0000\u0000\u05bd\u05bc\u0001\u0000\u0000\u0000\u05bd\u05be" +
                    "\u0001\u0000\u0000\u0000\u05be\u05bf\u0001\u0000\u0000\u0000\u05bf\u05c0" +
                    "\u0005+\u0000\u0000\u05c0\u05c5\u0003\u009eO\u0000\u05c1\u05c2\u0005\u0003" +
                    "\u0000\u0000\u05c2\u05c4\u0003\u009eO\u0000\u05c3\u05c1\u0001\u0000\u0000" +
                    "\u0000\u05c4\u05c7\u0001\u0000\u0000\u0000\u05c5\u05c3\u0001\u0000\u0000" +
                    "\u0000\u05c5\u05c6\u0001\u0000\u0000\u0000\u05c6\u05c8\u0001\u0000\u0000" +
                    "\u0000\u05c7\u05c5\u0001\u0000\u0000\u0000\u05c8\u05c9\u00050\u0000\u0000" +
                    "\u05c9\u05d6\u0001\u0000\u0000\u0000\u05ca\u05cb\u0005\u000e\u0000\u0000" +
                    "\u05cb\u05d0\u0003\u009eO\u0000\u05cc\u05cd\u0005\u0003\u0000\u0000\u05cd" +
                    "\u05cf\u0003\u009eO\u0000\u05ce\u05cc\u0001\u0000\u0000\u0000\u05cf\u05d2" +
                    "\u0001\u0000\u0000\u0000\u05d0\u05ce\u0001\u0000\u0000\u0000\u05d0\u05d1" +
                    "\u0001\u0000\u0000\u0000\u05d1\u05d3\u0001\u0000\u0000\u0000\u05d2\u05d0" +
                    "\u0001\u0000\u0000\u0000\u05d3\u05d4\u0005\u000f\u0000\u0000\u05d4\u05d6" +
                    "\u0001\u0000\u0000\u0000\u05d5\u05bd\u0001\u0000\u0000\u0000\u05d5\u05ca" +
                    "\u0001\u0000\u0000\u0000\u05d6\u009d\u0001\u0000\u0000\u0000\u05d7\u05d8" +
                    "\u0003\u00e4r\u0000\u05d8\u05d9\u0005\u0007\u0000\u0000\u05d9\u05db\u0001" +
                    "\u0000\u0000\u0000\u05da\u05d7\u0001\u0000\u0000\u0000\u05da\u05db\u0001" +
                    "\u0000\u0000\u0000\u05db\u05dc\u0001\u0000\u0000\u0000\u05dc\u05dd\u0003" +
                    "p8\u0000\u05dd\u009f\u0001\u0000\u0000\u0000\u05de\u05df\u0005j\u0000" +
                    "\u0000\u05df\u05e0\u0003\u00e4r\u0000\u05e0\u00a1\u0001\u0000\u0000\u0000" +
                    "\u05e1\u05e3\u0003\u00b0X\u0000\u05e2\u05e1\u0001\u0000\u0000\u0000\u05e3" +
                    "\u05e6\u0001\u0000\u0000\u0000\u05e4\u05e2\u0001\u0000\u0000\u0000\u05e4" +
                    "\u05e5\u0001\u0000\u0000\u0000\u05e5\u05e7\u0001\u0000\u0000\u0000\u05e6" +
                    "\u05e4\u0001\u0000\u0000\u0000\u05e7\u05e8\u0003\u00d6k\u0000\u05e8\u05e9" +
                    "\u0005s\u0000\u0000\u05e9\u05ea\u0003\u00a4R\u0000\u05ea\u0601\u0001\u0000" +
                    "\u0000\u0000\u05eb\u05ed\u0003\u00b0X\u0000\u05ec\u05eb\u0001\u0000\u0000" +
                    "\u0000\u05ed\u05f0\u0001\u0000\u0000\u0000\u05ee\u05ec\u0001\u0000\u0000" +
                    "\u0000\u05ee\u05ef\u0001\u0000\u0000\u0000\u05ef\u05f1\u0001\u0000\u0000" +
                    "\u0000\u05f0\u05ee\u0001\u0000\u0000\u0000\u05f1\u05f2\u0003\u00d6k\u0000" +
                    "\u05f2\u05f3\u0005s\u0000\u0000\u05f3\u05f8\u0003\u00e4r\u0000\u05f4\u05f5" +
                    "\u0005\u0003\u0000\u0000\u05f5\u05f7\u0003\u00e4r\u0000\u05f6\u05f4\u0001" +
                    "\u0000\u0000\u0000\u05f7\u05fa\u0001\u0000\u0000\u0000\u05f8\u05f6\u0001" +
                    "\u0000\u0000\u0000\u05f8\u05f9\u0001\u0000\u0000\u0000\u05f9\u05fc\u0001" +
                    "\u0000\u0000\u0000\u05fa\u05f8\u0001\u0000\u0000\u0000\u05fb\u05fd\u0005" +
                    "\u0003\u0000\u0000\u05fc\u05fb\u0001\u0000\u0000\u0000\u05fc\u05fd\u0001" +
                    "\u0000\u0000\u0000\u05fd\u05fe\u0001\u0000\u0000\u0000\u05fe\u05ff\u0003" +
                    "\u00a4R\u0000\u05ff\u0601\u0001\u0000\u0000\u0000\u0600\u05e4\u0001\u0000" +
                    "\u0000\u0000\u0600\u05ee\u0001\u0000\u0000\u0000\u0601\u00a3\u0001\u0000" +
                    "\u0000\u0000\u0602\u0607\u0005\f\u0000\u0000\u0603\u0606\u0003\u00a6S" +
                    "\u0000\u0604\u0606\u0003\u0004\u0002\u0000\u0605\u0603\u0001\u0000\u0000" +
                    "\u0000\u0605\u0604\u0001\u0000\u0000\u0000\u0606\u0609\u0001\u0000\u0000" +
                    "\u0000\u0607\u0605\u0001\u0000\u0000\u0000\u0607\u0608\u0001\u0000\u0000" +
                    "\u0000\u0608\u060a\u0001\u0000\u0000\u0000\u0609\u0607\u0001\u0000\u0000" +
                    "\u0000\u060a\u060b\u0005\r\u0000\u0000\u060b\u00a5\u0001\u0000\u0000\u0000" +
                    "\u060c\u060d\u0005\u0001\u0000\u0000\u060d\u0614\u0003\u00a8T\u0000\u060e" +
                    "\u060f\u0005\u008c\u0000\u0000\u060f\u0614\u0003p8\u0000\u0610\u0611\u0003" +
                    "\u00e4r\u0000\u0611\u0612\u0003\u00acV\u0000\u0612\u0614\u0001\u0000\u0000" +
                    "\u0000\u0613\u060c\u0001\u0000\u0000\u0000\u0613\u060e\u0001\u0000\u0000" +
                    "\u0000\u0613\u0610\u0001\u0000\u0000\u0000\u0614\u00a7\u0001\u0000\u0000" +
                    "\u0000\u0615\u0619\u0005\f\u0000\u0000\u0616\u0618\u0003\u00aaU\u0000" +
                    "\u0617\u0616\u0001\u0000\u0000\u0000\u0618\u061b\u0001\u0000\u0000\u0000" +
                    "\u0619\u0617\u0001\u0000\u0000\u0000\u0619\u061a\u0001\u0000\u0000\u0000" +
                    "\u061a\u061c\u0001\u0000\u0000\u0000\u061b\u0619\u0001\u0000\u0000\u0000" +
                    "\u061c\u061d\u0005\r\u0000\u0000\u061d\u00a9\u0001\u0000\u0000\u0000\u061e" +
                    "\u061f\u0003\u00e4r\u0000\u061f\u0620\u0005\u0007\u0000\u0000\u0620\u0621" +
                    "\u0003p8\u0000\u0621\u0624\u0001\u0000\u0000\u0000\u0622\u0624\u0003\u0004" +
                    "\u0002\u0000\u0623\u061e\u0001\u0000\u0000\u0000\u0623\u0622\u0001\u0000" +
                    "\u0000\u0000\u0624\u00ab\u0001\u0000\u0000\u0000\u0625\u062a\u0005\f\u0000" +
                    "\u0000\u0626\u0629\u0003j5\u0000\u0627\u0629\u0003\u0004\u0002\u0000\u0628" +
                    "\u0626\u0001\u0000\u0000\u0000\u0628\u0627\u0001\u0000\u0000\u0000\u0629" +
                    "\u062c\u0001\u0000\u0000\u0000\u062a\u0628\u0001\u0000\u0000\u0000\u062a" +
                    "\u062b\u0001\u0000\u0000\u0000\u062b\u062d\u0001\u0000\u0000\u0000\u062c" +
                    "\u062a\u0001\u0000\u0000\u0000\u062d\u062e\u0005\r\u0000\u0000\u062e\u00ad" +
                    "\u0001\u0000\u0000\u0000\u062f\u0630\u0005L\u0000\u0000\u0630\u0632\u0003" +
                    "\u00b2Y\u0000\u0631\u0633\u0003\u0016\u000b\u0000\u0632\u0631\u0001\u0000" +
                    "\u0000\u0000\u0632\u0633\u0001\u0000\u0000\u0000\u0633\u0643\u0001\u0000" +
                    "\u0000\u0000\u0634\u0635\u0005L\u0000\u0000\u0635\u0636\u0005\n\u0000" +
                    "\u0000\u0636\u063b\u0003\u00b2Y\u0000\u0637\u0638\u0005\u0003\u0000\u0000" +
                    "\u0638\u063a\u0003\u00b2Y\u0000\u0639\u0637\u0001\u0000\u0000\u0000\u063a" +
                    "\u063d\u0001\u0000\u0000\u0000\u063b\u0639\u0001\u0000\u0000\u0000\u063b" +
                    "\u063c\u0001\u0000\u0000\u0000\u063c\u063e\u0001\u0000\u0000\u0000\u063d" +
                    "\u063b\u0001\u0000\u0000\u0000\u063e\u0640\u0005\u000b\u0000\u0000\u063f" +
                    "\u0641\u0003\u0016\u000b\u0000\u0640\u063f\u0001\u0000\u0000\u0000\u0640" +
                    "\u0641\u0001\u0000\u0000\u0000\u0641\u0643\u0001\u0000\u0000\u0000\u0642" +
                    "\u062f\u0001\u0000\u0000\u0000\u0642\u0634\u0001\u0000\u0000\u0000\u0643" +
                    "\u00af\u0001\u0000\u0000\u0000\u0644\u0645\u0005M\u0000\u0000\u0645\u0647" +
                    "\u0003\u00b2Y\u0000\u0646\u0648\u0003\u0016\u000b\u0000\u0647\u0646\u0001" +
                    "\u0000\u0000\u0000\u0647\u0648\u0001\u0000\u0000\u0000\u0648\u0658\u0001" +
                    "\u0000\u0000\u0000\u0649\u064a\u0005M\u0000\u0000\u064a\u064b\u0005\n" +
                    "\u0000\u0000\u064b\u0650\u0003\u00b2Y\u0000\u064c\u064d\u0005\u0003\u0000" +
                    "\u0000\u064d\u064f\u0003\u00b2Y\u0000\u064e\u064c\u0001\u0000\u0000\u0000" +
                    "\u064f\u0652\u0001\u0000\u0000\u0000\u0650\u064e\u0001\u0000\u0000\u0000" +
                    "\u0650\u0651\u0001\u0000\u0000\u0000\u0651\u0653\u0001\u0000\u0000\u0000" +
                    "\u0652\u0650\u0001\u0000\u0000\u0000\u0653\u0655\u0005\u000b\u0000\u0000" +
                    "\u0654\u0656\u0003\u0016\u000b\u0000\u0655\u0654\u0001\u0000\u0000\u0000" +
                    "\u0655\u0656\u0001\u0000\u0000\u0000\u0656\u0658\u0001\u0000\u0000\u0000" +
                    "\u0657\u0644\u0001\u0000\u0000\u0000\u0657\u0649\u0001\u0000\u0000\u0000" +
                    "\u0658\u00b1\u0001\u0000\u0000\u0000\u0659\u065b\u0003\u00e2q\u0000\u065a" +
                    "\u065c\u0003J%\u0000\u065b\u065a\u0001\u0000\u0000\u0000\u065b\u065c\u0001" +
                    "\u0000\u0000\u0000\u065c\u065e\u0001\u0000\u0000\u0000\u065d\u065f\u0003" +
                    "\u0016\u000b\u0000\u065e\u065d\u0001\u0000\u0000\u0000\u065e\u065f\u0001" +
                    "\u0000\u0000\u0000\u065f\u00b3\u0001\u0000\u0000\u0000\u0660\u0662\u0003" +
                    "\u00b0X\u0000\u0661\u0660\u0001\u0000\u0000\u0000\u0662\u0665\u0001\u0000" +
                    "\u0000\u0000\u0663\u0661\u0001\u0000\u0000\u0000\u0663\u0664\u0001\u0000" +
                    "\u0000\u0000\u0664\u0666\u0001\u0000\u0000\u0000\u0665\u0663\u0001\u0000" +
                    "\u0000\u0000\u0666\u0668\u0005~\u0000\u0000\u0667\u0669\u0003p8\u0000" +
                    "\u0668\u0667\u0001\u0000\u0000\u0000\u0668\u0669\u0001\u0000\u0000\u0000" +
                    "\u0669\u066a\u0001\u0000\u0000\u0000\u066a\u066b\u0003P(\u0000\u066b\u00b5" +
                    "\u0001\u0000\u0000\u0000\u066c\u066e\u0003\u00b0X\u0000\u066d\u066c\u0001" +
                    "\u0000\u0000\u0000\u066e\u0671\u0001\u0000\u0000\u0000\u066f\u066d\u0001" +
                    "\u0000\u0000\u0000\u066f\u0670\u0001\u0000\u0000\u0000\u0670\u0672\u0001" +
                    "\u0000\u0000\u0000\u0671\u066f\u0001\u0000\u0000\u0000\u0672\u0676\u0007" +
                    "\u0007\u0000\u0000\u0673\u0674\u0003\u00e4r\u0000\u0674\u0675\u00056\u0000" +
                    "\u0000\u0675\u0677\u0001\u0000\u0000\u0000\u0676\u0673\u0001\u0000\u0000" +
                    "\u0000\u0676\u0677\u0001\u0000\u0000\u0000\u0677\u0678\u0001\u0000\u0000" +
                    "\u0000\u0678\u0679\u0003n7\u0000\u0679\u067a\u0003\u00b8\\\u0000\u067a" +
                    "\u00b7\u0001\u0000\u0000\u0000\u067b\u0680\u0005\f\u0000\u0000\u067c\u067f" +
                    "\u0003\u00ba]\u0000\u067d\u067f\u0003\u0004\u0002\u0000\u067e\u067c\u0001" +
                    "\u0000\u0000\u0000\u067e\u067d\u0001\u0000\u0000\u0000\u067f\u0682\u0001" +
                    "\u0000\u0000\u0000\u0680\u067e\u0001\u0000\u0000\u0000\u0680\u0681\u0001" +
                    "\u0000\u0000\u0000\u0681\u0683\u0001\u0000\u0000\u0000\u0682\u0680\u0001" +
                    "\u0000\u0000\u0000\u0683\u0684\u0005\r\u0000\u0000\u0684\u00b9\u0001\u0000" +
                    "\u0000\u0000\u0685\u0687\u0003\u00b0X\u0000\u0686\u0685\u0001\u0000\u0000" +
                    "\u0000\u0687\u068a\u0001\u0000\u0000\u0000\u0688\u0686\u0001\u0000\u0000" +
                    "\u0000\u0688\u0689\u0001\u0000\u0000\u0000\u0689\u068b\u0001\u0000\u0000" +
                    "\u0000\u068a\u0688\u0001\u0000\u0000\u0000\u068b\u068c\u0005\u0081\u0000" +
                    "\u0000\u068c\u06d2\u0003\u00e4r\u0000\u068d\u068f\u0003\u00b0X\u0000\u068e" +
                    "\u068d\u0001\u0000\u0000\u0000\u068f\u0692\u0001\u0000\u0000\u0000\u0690" +
                    "\u068e\u0001\u0000\u0000\u0000\u0690\u0691\u0001\u0000\u0000\u0000\u0691" +
                    "\u0693\u0001\u0000\u0000\u0000\u0692\u0690\u0001\u0000\u0000\u0000\u0693" +
                    "\u0694\u0005\u0081\u0000\u0000\u0694\u06a0\u0005\n\u0000\u0000\u0695\u069a" +
                    "\u0003\u00e4r\u0000\u0696\u0697\u0005\u0003\u0000\u0000\u0697\u0699\u0003" +
                    "\u00e4r\u0000\u0698\u0696\u0001\u0000\u0000\u0000\u0699\u069c\u0001\u0000" +
                    "\u0000\u0000\u069a\u0698\u0001\u0000\u0000\u0000\u069a\u069b\u0001\u0000" +
                    "\u0000\u0000\u069b\u069e\u0001\u0000\u0000\u0000\u069c\u069a\u0001\u0000" +
                    "\u0000\u0000\u069d\u069f\u0005\u0003\u0000\u0000\u069e\u069d\u0001\u0000" +
                    "\u0000\u0000\u069e\u069f\u0001\u0000\u0000\u0000\u069f\u06a1\u0001\u0000" +
                    "\u0000\u0000\u06a0\u0695\u0001\u0000\u0000\u0000\u06a0\u06a1\u0001\u0000" +
                    "\u0000\u0000\u06a1\u06a2\u0001\u0000\u0000\u0000\u06a2\u06d2\u0005\u000b" +
                    "\u0000\u0000\u06a3\u06a5\u0003\u00b0X\u0000\u06a4\u06a3\u0001\u0000\u0000" +
                    "\u0000\u06a5\u06a8\u0001\u0000\u0000\u0000\u06a6\u06a4\u0001\u0000\u0000" +
                    "\u0000\u06a6\u06a7\u0001\u0000\u0000\u0000\u06a7\u06a9\u0001\u0000\u0000" +
                    "\u0000\u06a8\u06a6\u0001\u0000\u0000\u0000\u06a9\u06aa\u0005r\u0000\u0000" +
                    "\u06aa\u06ad\u0003p8\u0000\u06ab\u06ac\u0005\u0089\u0000\u0000\u06ac\u06ae" +
                    "\u0003n7\u0000\u06ad\u06ab\u0001\u0000\u0000\u0000\u06ad\u06ae\u0001\u0000" +
                    "\u0000\u0000\u06ae\u06af\u0001\u0000\u0000\u0000\u06af\u06b0\u0003\u00bc" +
                    "^\u0000\u06b0\u06d2\u0001\u0000\u0000\u0000\u06b1\u06b3\u0003\u00b0X\u0000" +
                    "\u06b2\u06b1\u0001\u0000\u0000\u0000\u06b3\u06b6\u0001\u0000\u0000\u0000" +
                    "\u06b4\u06b2\u0001\u0000\u0000\u0000\u06b4\u06b5\u0001\u0000\u0000\u0000" +
                    "\u06b5\u06b7\u0001\u0000\u0000\u0000\u06b6\u06b4\u0001\u0000\u0000\u0000" +
                    "\u06b7\u06b8\u0005\u0083\u0000\u0000\u06b8\u06b9\u0003n7\u0000\u06b9\u06ba" +
                    "\u0003\u00bc^\u0000\u06ba\u06d2\u0001\u0000\u0000\u0000\u06bb\u06bd\u0003" +
                    "\u00b0X\u0000\u06bc\u06bb\u0001\u0000\u0000\u0000\u06bd\u06c0\u0001\u0000" +
                    "\u0000\u0000\u06be\u06bc\u0001\u0000\u0000\u0000\u06be\u06bf\u0001\u0000" +
                    "\u0000\u0000\u06bf\u06c1\u0001\u0000\u0000\u0000\u06c0\u06be\u0001\u0000" +
                    "\u0000\u0000\u06c1\u06c2\u0005\u008a\u0000\u0000\u06c2\u06d2\u0003\u00bc" +
                    "^\u0000\u06c3\u06c5\u0003\u00b0X\u0000\u06c4\u06c3\u0001\u0000\u0000\u0000" +
                    "\u06c5\u06c8\u0001\u0000\u0000\u0000\u06c6\u06c4\u0001\u0000\u0000\u0000" +
                    "\u06c6\u06c7\u0001\u0000\u0000\u0000\u06c7\u06c9\u0001\u0000\u0000\u0000" +
                    "\u06c8\u06c6\u0001\u0000\u0000\u0000\u06c9\u06ca\u0005\u0082\u0000\u0000" +
                    "\u06ca\u06cd\u0003\u00be_\u0000\u06cb\u06cc\u0005\u0089\u0000\u0000\u06cc" +
                    "\u06ce\u0003n7\u0000\u06cd\u06cb\u0001\u0000\u0000\u0000\u06cd\u06ce\u0001" +
                    "\u0000\u0000\u0000\u06ce\u06cf\u0001\u0000\u0000\u0000\u06cf\u06d0\u0003" +
                    "\u00bc^\u0000\u06d0\u06d2\u0001\u0000\u0000\u0000\u06d1\u0688\u0001\u0000" +
                    "\u0000\u0000\u06d1\u0690\u0001\u0000\u0000\u0000\u06d1\u06a6\u0001\u0000" +
                    "\u0000\u0000\u06d1\u06b4\u0001\u0000\u0000\u0000\u06d1\u06be\u0001\u0000" +
                    "\u0000\u0000\u06d1\u06c6\u0001\u0000\u0000\u0000\u06d2\u00bb\u0001\u0000" +
                    "\u0000\u0000\u06d3\u06d7\u0005\u0007\u0000\u0000\u06d4\u06d6\u0003l6\u0000" +
                    "\u06d5\u06d4\u0001\u0000\u0000\u0000\u06d6\u06d9\u0001\u0000\u0000\u0000" +
                    "\u06d7\u06d5\u0001\u0000\u0000\u0000\u06d7\u06d8\u0001\u0000\u0000\u0000" +
                    "\u06d8\u00bd\u0001\u0000\u0000\u0000\u06d9\u06d7\u0001\u0000\u0000\u0000" +
                    "\u06da\u06db\u0006_\uffff\uffff\u0000\u06db\u06dc\u0003\u00c0`\u0000\u06dc" +
                    "\u06e5\u0001\u0000\u0000\u0000\u06dd\u06de\n\u0003\u0000\u0000\u06de\u06df" +
                    "\u0007\u0014\u0000\u0000\u06df\u06e4\u0003\u00be_\u0004\u06e0\u06e1\n" +
                    "\u0002\u0000\u0000\u06e1\u06e2\u0005`\u0000\u0000\u06e2\u06e4\u0003\u00be" +
                    "_\u0003\u06e3\u06dd\u0001\u0000\u0000\u0000\u06e3\u06e0\u0001\u0000\u0000" +
                    "\u0000\u06e4\u06e7\u0001\u0000\u0000\u0000\u06e5\u06e3\u0001\u0000\u0000" +
                    "\u0000\u06e5\u06e6\u0001\u0000\u0000\u0000\u06e6\u00bf\u0001\u0000\u0000" +
                    "\u0000\u06e7\u06e5\u0001\u0000\u0000\u0000\u06e8\u06fc\u0003\u00c2a\u0000" +
                    "\u06e9\u06ea\u0003\u00e4r\u0000\u06ea\u06eb\u00056\u0000\u0000\u06eb\u06ec" +
                    "\u0003\u00c0`\u0000\u06ec\u06fc\u0001\u0000\u0000\u0000\u06ed\u06ee\u0003" +
                    "\u00d8l\u0000\u06ee\u06f2\u0005\u0007\u0000\u0000\u06ef\u06f0\u0003\u00e4" +
                    "r\u0000\u06f0\u06f1\u00056\u0000\u0000\u06f1\u06f3\u0001\u0000\u0000\u0000" +
                    "\u06f2\u06ef\u0001\u0000\u0000\u0000\u06f2\u06f3\u0001\u0000\u0000\u0000" +
                    "\u06f3\u06f4\u0001\u0000\u0000\u0000\u06f4\u06f5\u0003\u00c0`\u0000\u06f5" +
                    "\u06fc\u0001\u0000\u0000\u0000\u06f6\u06fc\u0003\u00d8l\u0000\u06f7\u06fc" +
                    "\u0003\u00e2q\u0000\u06f8\u06fc\u0003\u00e8t\u0000\u06f9\u06fc\u0003\u00ec" +
                    "v\u0000\u06fa\u06fc\u0005\u0092\u0000\u0000\u06fb\u06e8\u0001\u0000\u0000" +
                    "\u0000\u06fb\u06e9\u0001\u0000\u0000\u0000\u06fb\u06ed\u0001\u0000\u0000" +
                    "\u0000\u06fb\u06f6\u0001\u0000\u0000\u0000\u06fb\u06f7\u0001\u0000\u0000" +
                    "\u0000\u06fb\u06f8\u0001\u0000\u0000\u0000\u06fb\u06f9\u0001\u0000\u0000" +
                    "\u0000\u06fb\u06fa\u0001\u0000\u0000\u0000\u06fc\u00c1\u0001\u0000\u0000" +
                    "\u0000\u06fd\u06ff\u0003\u00e2q\u0000\u06fe\u06fd\u0001\u0000\u0000\u0000" +
                    "\u06fe\u06ff\u0001\u0000\u0000\u0000\u06ff\u0700\u0001\u0000\u0000\u0000" +
                    "\u0700\u0701\u0005\b\u0000\u0000\u0701\u0750\u0005\t\u0000\u0000\u0702" +
                    "\u0704\u0003\u00e2q\u0000\u0703\u0702\u0001\u0000\u0000\u0000\u0703\u0704" +
                    "\u0001\u0000\u0000\u0000\u0704\u0705\u0001\u0000\u0000\u0000\u0705\u0706" +
                    "\u0005\n\u0000\u0000\u0706\u0750\u0005\u000b\u0000\u0000\u0707\u0709\u0003" +
                    "\u00e2q\u0000\u0708\u0707\u0001\u0000\u0000\u0000\u0708\u0709\u0001\u0000" +
                    "\u0000\u0000\u0709\u070a\u0001\u0000\u0000\u0000\u070a\u070b\u0005\f\u0000" +
                    "\u0000\u070b\u0750\u0005\r\u0000\u0000\u070c\u070d\u0005\b\u0000\u0000" +
                    "\u070d\u070e\u0003\u00c0`\u0000\u070e\u070f\u0005\u0003\u0000\u0000\u070f" +
                    "\u0710\u0005\t\u0000\u0000\u0710\u0750\u0001\u0000\u0000\u0000\u0711\u0712" +
                    "\u0005\b\u0000\u0000\u0712\u0715\u0003\u00c0`\u0000\u0713\u0714\u0005" +
                    "\u0003\u0000\u0000\u0714\u0716\u0003\u00c0`\u0000\u0715\u0713\u0001\u0000" +
                    "\u0000\u0000\u0716\u0717\u0001\u0000\u0000\u0000\u0717\u0715\u0001\u0000" +
                    "\u0000\u0000\u0717\u0718\u0001\u0000\u0000\u0000\u0718\u071a\u0001\u0000" +
                    "\u0000\u0000\u0719\u071b\u0005\u0003\u0000\u0000\u071a\u0719\u0001\u0000" +
                    "\u0000\u0000\u071a\u071b\u0001\u0000\u0000\u0000\u071b\u071c\u0001\u0000" +
                    "\u0000\u0000\u071c\u071d\u0005\t\u0000\u0000\u071d\u0750\u0001\u0000\u0000" +
                    "\u0000\u071e\u071f\u0003\u00e2q\u0000\u071f\u0720\u0005\b\u0000\u0000" +
                    "\u0720\u0725\u0003\u00c0`\u0000\u0721\u0722\u0005\u0003\u0000\u0000\u0722" +
                    "\u0724\u0003\u00c0`\u0000\u0723\u0721\u0001\u0000\u0000\u0000\u0724\u0727" +
                    "\u0001\u0000\u0000\u0000\u0725\u0723\u0001\u0000\u0000\u0000\u0725\u0726" +
                    "\u0001\u0000\u0000\u0000\u0726\u0729\u0001\u0000\u0000\u0000\u0727\u0725" +
                    "\u0001\u0000\u0000\u0000\u0728\u072a\u0005\u0003\u0000\u0000\u0729\u0728" +
                    "\u0001\u0000\u0000\u0000\u0729\u072a\u0001\u0000\u0000\u0000\u072a\u072b" +
                    "\u0001\u0000\u0000\u0000\u072b\u072c\u0005\t\u0000\u0000\u072c\u0750\u0001" +
                    "\u0000\u0000\u0000\u072d\u072f\u0003\u00e2q\u0000\u072e\u072d\u0001\u0000" +
                    "\u0000\u0000\u072e\u072f\u0001\u0000\u0000\u0000\u072f\u0730\u0001\u0000" +
                    "\u0000\u0000\u0730\u0731\u0005\n\u0000\u0000\u0731\u0736\u0003\u00c0`" +
                    "\u0000\u0732\u0733\u0005\u0003\u0000\u0000\u0733\u0735\u0003\u00c0`\u0000" +
                    "\u0734\u0732\u0001\u0000\u0000\u0000\u0735\u0738\u0001\u0000\u0000\u0000" +
                    "\u0736\u0734\u0001\u0000\u0000\u0000\u0736\u0737\u0001\u0000\u0000\u0000" +
                    "\u0737\u073a\u0001\u0000\u0000\u0000\u0738\u0736\u0001\u0000\u0000\u0000" +
                    "\u0739\u073b\u0005\u0003\u0000\u0000\u073a\u0739\u0001\u0000\u0000\u0000" +
                    "\u073a\u073b\u0001\u0000\u0000\u0000\u073b\u073c\u0001\u0000\u0000\u0000" +
                    "\u073c\u073d\u0005\u000b\u0000\u0000\u073d\u0750\u0001\u0000\u0000\u0000" +
                    "\u073e\u0740\u0003\u00e2q\u0000\u073f\u073e\u0001\u0000\u0000\u0000\u073f" +
                    "\u0740\u0001\u0000\u0000\u0000\u0740\u0741\u0001\u0000\u0000\u0000\u0741" +
                    "\u0742\u0005\f\u0000\u0000\u0742\u0747\u0003\u00c0`\u0000\u0743\u0744" +
                    "\u0005\u0003\u0000\u0000\u0744\u0746\u0003\u00c0`\u0000\u0745\u0743\u0001" +
                    "\u0000\u0000\u0000\u0746\u0749\u0001\u0000\u0000\u0000\u0747\u0745\u0001" +
                    "\u0000\u0000\u0000\u0747\u0748\u0001\u0000\u0000\u0000\u0748\u074b\u0001" +
                    "\u0000\u0000\u0000\u0749\u0747\u0001\u0000\u0000\u0000\u074a\u074c\u0005" +
                    "\u0003\u0000\u0000\u074b\u074a\u0001\u0000\u0000\u0000\u074b\u074c\u0001" +
                    "\u0000\u0000\u0000\u074c\u074d\u0001\u0000\u0000\u0000\u074d\u074e\u0005" +
                    "\r\u0000\u0000\u074e\u0750\u0001\u0000\u0000\u0000\u074f\u06fe\u0001\u0000" +
                    "\u0000\u0000\u074f\u0703\u0001\u0000\u0000\u0000\u074f\u0708\u0001\u0000" +
                    "\u0000\u0000\u074f\u070c\u0001\u0000\u0000\u0000\u074f\u0711\u0001\u0000" +
                    "\u0000\u0000\u074f\u071e\u0001\u0000\u0000\u0000\u074f\u072e\u0001\u0000" +
                    "\u0000\u0000\u074f\u073f\u0001\u0000\u0000\u0000\u0750\u00c3\u0001\u0000" +
                    "\u0000\u0000\u0751\u0753\u0005{\u0000\u0000\u0752\u0754\u0003\u0096K\u0000" +
                    "\u0753\u0752\u0001\u0000\u0000\u0000\u0753\u0754\u0001\u0000\u0000\u0000" +
                    "\u0754\u0756\u0001\u0000\u0000\u0000\u0755\u0757\u0003\u0018\f\u0000\u0756" +
                    "\u0755\u0001\u0000\u0000\u0000\u0756\u0757\u0001\u0000\u0000\u0000\u0757" +
                    "\u0759\u0001\u0000\u0000\u0000\u0758\u075a\u0003^/\u0000\u0759\u0758\u0001" +
                    "\u0000\u0000\u0000\u0759\u075a\u0001\u0000\u0000\u0000\u075a\u075b\u0001" +
                    "\u0000\u0000\u0000\u075b\u075c\u0003\u0016\u000b\u0000\u075c\u00c5\u0001" +
                    "\u0000\u0000\u0000\u075d\u075e\u0005z\u0000\u0000\u075e\u0760\u0003\u00da" +
                    "m\u0000\u075f\u0761\u0003\u009cN\u0000\u0760\u075f\u0001\u0000\u0000\u0000" +
                    "\u0760\u0761\u0001\u0000\u0000\u0000\u0761\u0763\u0001\u0000\u0000\u0000" +
                    "\u0762\u0764\u0003J%\u0000\u0763\u0762\u0001\u0000\u0000\u0000\u0763\u0764" +
                    "\u0001\u0000\u0000\u0000\u0764\u0765\u0001\u0000\u0000\u0000\u0765\u0766" +
                    "\u0003\u00cae\u0000\u0766\u076f\u0001\u0000\u0000\u0000\u0767\u0768\u0005" +
                    "z\u0000\u0000\u0768\u076a\u0003\u00dam\u0000\u0769\u076b\u0003\u009cN" +
                    "\u0000\u076a\u0769\u0001\u0000\u0000\u0000\u076a\u076b\u0001\u0000\u0000" +
                    "\u0000\u076b\u076c\u0001\u0000\u0000\u0000\u076c\u076d\u0003J%\u0000\u076d" +
                    "\u076f\u0001\u0000\u0000\u0000\u076e\u075d\u0001\u0000\u0000\u0000\u076e" +
                    "\u0767\u0001\u0000\u0000\u0000\u076f\u00c7\u0001\u0000\u0000\u0000\u0770" +
                    "\u0772\u0003J%\u0000\u0771\u0770\u0001\u0000\u0000\u0000\u0771\u0772\u0001" +
                    "\u0000\u0000\u0000\u0772\u0773\u0001\u0000\u0000\u0000\u0773\u0776\u0003" +
                    "\u00cae\u0000\u0774\u0776\u0003J%\u0000\u0775\u0771\u0001\u0000\u0000" +
                    "\u0000\u0775\u0774\u0001\u0000\u0000\u0000\u0776\u00c9\u0001\u0000\u0000" +
                    "\u0000\u0777\u077c\u0005\f\u0000\u0000\u0778\u077b\u0003L&\u0000\u0779" +
                    "\u077b\u0003\u0004\u0002\u0000\u077a\u0778\u0001\u0000\u0000\u0000\u077a" +
                    "\u0779\u0001\u0000\u0000\u0000\u077b\u077e\u0001\u0000\u0000\u0000\u077c" +
                    "\u077a\u0001\u0000\u0000\u0000\u077c\u077d\u0001\u0000\u0000\u0000\u077d" +
                    "\u077f\u0001\u0000\u0000\u0000\u077e\u077c\u0001\u0000\u0000\u0000\u077f" +
                    "\u0780\u0005\r\u0000\u0000\u0780\u00cb\u0001\u0000\u0000\u0000\u0781\u0782" +
                    "\u0005\b\u0000\u0000\u0782\u0796\u0005\t\u0000\u0000\u0783\u0784\u0005" +
                    "\b\u0000\u0000\u0784\u0787\u0003\u00ceg\u0000\u0785\u0786\u0005\u0003" +
                    "\u0000\u0000\u0786\u0788\u0003\u00ceg\u0000\u0787\u0785\u0001\u0000\u0000" +
                    "\u0000\u0788\u0789\u0001\u0000\u0000\u0000\u0789\u0787\u0001\u0000\u0000" +
                    "\u0000\u0789\u078a\u0001\u0000\u0000\u0000\u078a\u078c\u0001\u0000\u0000" +
                    "\u0000\u078b\u078d\u0005\u0003\u0000\u0000\u078c\u078b\u0001\u0000\u0000" +
                    "\u0000\u078c\u078d\u0001\u0000\u0000\u0000\u078d\u078e\u0001\u0000\u0000" +
                    "\u0000\u078e\u078f\u0005\t\u0000\u0000\u078f\u0796\u0001\u0000\u0000\u0000" +
                    "\u0790\u0791\u0005\b\u0000\u0000\u0791\u0792\u0003\u00ceg\u0000\u0792" +
                    "\u0793\u0005\u0003\u0000\u0000\u0793\u0794\u0005\t\u0000\u0000\u0794\u0796" +
                    "\u0001\u0000\u0000\u0000\u0795\u0781\u0001\u0000\u0000\u0000\u0795\u0783" +
                    "\u0001\u0000\u0000\u0000\u0795\u0790\u0001\u0000\u0000\u0000\u0796\u00cd" +
                    "\u0001\u0000\u0000\u0000\u0797\u0798\u0003\u00e4r\u0000\u0798\u0799\u0005" +
                    "\u0007\u0000\u0000\u0799\u079b\u0001\u0000\u0000\u0000\u079a\u0797\u0001" +
                    "\u0000\u0000\u0000\u079a\u079b\u0001\u0000\u0000\u0000\u079b\u079c\u0001" +
                    "\u0000\u0000\u0000\u079c\u079d\u0003l6\u0000\u079d\u00cf\u0001\u0000\u0000" +
                    "\u0000\u079e\u07a0\u0005S\u0000\u0000\u079f\u079e\u0001\u0000\u0000\u0000" +
                    "\u079f\u07a0\u0001\u0000\u0000\u0000\u07a0\u07a1\u0001\u0000\u0000\u0000" +
                    "\u07a1\u07a2\u0003\u00d2i\u0000\u07a2\u00d1\u0001\u0000\u0000\u0000\u07a3" +
                    "\u07af\u0005\n\u0000\u0000\u07a4\u07a9\u0003\u00d4j\u0000\u07a5\u07a6" +
                    "\u0005\u0003\u0000\u0000\u07a6\u07a8\u0003\u00d4j\u0000\u07a7\u07a5\u0001" +
                    "\u0000\u0000\u0000\u07a8\u07ab\u0001\u0000\u0000\u0000\u07a9\u07a7\u0001" +
                    "\u0000\u0000\u0000\u07a9\u07aa\u0001\u0000\u0000\u0000\u07aa\u07ad\u0001" +
                    "\u0000\u0000\u0000\u07ab\u07a9\u0001\u0000\u0000\u0000\u07ac\u07ae\u0005" +
                    "\u0003\u0000\u0000\u07ad\u07ac\u0001\u0000\u0000\u0000\u07ad\u07ae\u0001" +
                    "\u0000\u0000\u0000\u07ae\u07b0\u0001\u0000\u0000\u0000\u07af\u07a4\u0001" +
                    "\u0000\u0000\u0000\u07af\u07b0\u0001\u0000\u0000\u0000\u07b0\u07b1\u0001" +
                    "\u0000\u0000\u0000\u07b1\u07c2\u0005\u000b\u0000\u0000\u07b2\u07be\u0005" +
                    "\u0010\u0000\u0000\u07b3\u07b8\u0003\u00d4j\u0000\u07b4\u07b5\u0005\u0003" +
                    "\u0000\u0000\u07b5\u07b7\u0003\u00d4j\u0000\u07b6\u07b4\u0001\u0000\u0000" +
                    "\u0000\u07b7\u07ba\u0001\u0000\u0000\u0000\u07b8\u07b6\u0001\u0000\u0000" +
                    "\u0000\u07b8\u07b9\u0001\u0000\u0000\u0000\u07b9\u07bc\u0001\u0000\u0000" +
                    "\u0000\u07ba\u07b8\u0001\u0000\u0000\u0000\u07bb\u07bd\u0005\u0003\u0000" +
                    "\u0000\u07bc\u07bb\u0001\u0000\u0000\u0000\u07bc\u07bd\u0001\u0000\u0000" +
                    "\u0000\u07bd\u07bf\u0001\u0000\u0000\u0000\u07be\u07b3\u0001\u0000\u0000" +
                    "\u0000\u07be\u07bf\u0001\u0000\u0000\u0000\u07bf\u07c0\u0001\u0000\u0000" +
                    "\u0000\u07c0\u07c2\u0005\u0011\u0000\u0000\u07c1\u07a3\u0001\u0000\u0000" +
                    "\u0000\u07c1\u07b2\u0001\u0000\u0000\u0000\u07c2\u00d3\u0001\u0000\u0000" +
                    "\u0000\u07c3\u07fc\u0005\u0007\u0000\u0000\u07c4\u07fc\u0003l6\u0000\u07c5" +
                    "\u07c6\u0003l6\u0000\u07c6\u07c7\u0005\u0007\u0000\u0000\u07c7\u07fc\u0001" +
                    "\u0000\u0000\u0000\u07c8\u07c9\u0005\u0007\u0000\u0000\u07c9\u07fc\u0003" +
                    "l6\u0000\u07ca\u07cb\u0003l6\u0000\u07cb\u07cc\u0005\u0007\u0000\u0000" +
                    "\u07cc\u07cd\u0003l6\u0000\u07cd\u07fc\u0001\u0000\u0000\u0000\u07ce\u07d2" +
                    "\u0005\u0006\u0000\u0000\u07cf\u07d0\u0005\u0007\u0000\u0000\u07d0\u07d2" +
                    "\u0005\u0007\u0000\u0000\u07d1\u07ce\u0001\u0000\u0000\u0000\u07d1\u07cf" +
                    "\u0001\u0000\u0000\u0000\u07d2\u07fc\u0001\u0000\u0000\u0000\u07d3\u07d7" +
                    "\u0003l6\u0000\u07d4\u07d8\u0005\u0006\u0000\u0000\u07d5\u07d6\u0005\u0007" +
                    "\u0000\u0000\u07d6\u07d8\u0005\u0007\u0000\u0000\u07d7\u07d4\u0001\u0000" +
                    "\u0000\u0000\u07d7\u07d5\u0001\u0000\u0000\u0000\u07d8\u07fc\u0001\u0000" +
                    "\u0000\u0000\u07d9\u07da\u0005\u0007\u0000\u0000\u07da\u07db\u0003l6\u0000" +
                    "\u07db\u07dc\u0005\u0007\u0000\u0000\u07dc\u07fc\u0001\u0000\u0000\u0000" +
                    "\u07dd\u07e1\u0005\u0006\u0000\u0000\u07de\u07df\u0005\u0007\u0000\u0000" +
                    "\u07df\u07e1\u0005\u0007\u0000\u0000\u07e0\u07dd\u0001\u0000\u0000\u0000" +
                    "\u07e0\u07de\u0001\u0000\u0000\u0000\u07e1\u07e2\u0001\u0000\u0000\u0000" +
                    "\u07e2\u07fc\u0003l6\u0000\u07e3\u07e4\u0003l6\u0000\u07e4\u07e5\u0005" +
                    "\u0007\u0000\u0000\u07e5\u07e6\u0003l6\u0000\u07e6\u07e7\u0005\u0007\u0000" +
                    "\u0000\u07e7\u07fc\u0001\u0000\u0000\u0000\u07e8\u07e9\u0005\u0007\u0000" +
                    "\u0000\u07e9\u07ea\u0003l6\u0000\u07ea\u07eb\u0005\u0007\u0000\u0000\u07eb" +
                    "\u07ec\u0003l6\u0000\u07ec\u07fc\u0001\u0000\u0000\u0000\u07ed\u07f1\u0003" +
                    "l6\u0000\u07ee\u07f2\u0005\u0006\u0000\u0000\u07ef\u07f0\u0005\u0007\u0000" +
                    "\u0000\u07f0\u07f2\u0005\u0007\u0000\u0000\u07f1\u07ee\u0001\u0000\u0000" +
                    "\u0000\u07f1\u07ef\u0001\u0000\u0000\u0000\u07f2\u07f3\u0001\u0000\u0000" +
                    "\u0000\u07f3\u07f4\u0003l6\u0000\u07f4\u07fc\u0001\u0000\u0000\u0000\u07f5" +
                    "\u07f6\u0003l6\u0000\u07f6\u07f7\u0005\u0007\u0000\u0000\u07f7\u07f8\u0003" +
                    "l6\u0000\u07f8\u07f9\u0005\u0007\u0000\u0000\u07f9\u07fa\u0003l6\u0000" +
                    "\u07fa\u07fc\u0001\u0000\u0000\u0000\u07fb\u07c3\u0001\u0000\u0000\u0000" +
                    "\u07fb\u07c4\u0001\u0000\u0000\u0000\u07fb\u07c5\u0001\u0000\u0000\u0000" +
                    "\u07fb\u07c8\u0001\u0000\u0000\u0000\u07fb\u07ca\u0001\u0000\u0000\u0000" +
                    "\u07fb\u07d1\u0001\u0000\u0000\u0000\u07fb\u07d3\u0001\u0000\u0000\u0000" +
                    "\u07fb\u07d9\u0001\u0000\u0000\u0000\u07fb\u07e0\u0001\u0000\u0000\u0000" +
                    "\u07fb\u07e3\u0001\u0000\u0000\u0000\u07fb\u07e8\u0001\u0000\u0000\u0000" +
                    "\u07fb\u07ed\u0001\u0000\u0000\u0000\u07fb\u07f5\u0001\u0000\u0000\u0000" +
                    "\u07fc\u00d5\u0001\u0000\u0000\u0000\u07fd\u07ff\u0003\u00e4r\u0000\u07fe" +
                    "\u07fd\u0001\u0000\u0000\u0000\u07ff\u0802\u0001\u0000\u0000\u0000\u0800" +
                    "\u07fe\u0001\u0000\u0000\u0000\u0800\u0801\u0001\u0000\u0000\u0000\u0801" +
                    "\u00d7\u0001\u0000\u0000\u0000\u0802\u0800\u0001\u0000\u0000\u0000\u0803" +
                    "\u0805\u0003\u00e4r\u0000\u0804\u0803\u0001\u0000\u0000\u0000\u0805\u0808" +
                    "\u0001\u0000\u0000\u0000\u0806\u0804\u0001\u0000\u0000\u0000\u0806\u0807" +
                    "\u0001\u0000\u0000\u0000\u0807\u0809\u0001\u0000\u0000\u0000\u0808\u0806" +
                    "\u0001\u0000\u0000\u0000\u0809\u080a\u0003\u00e4r\u0000\u080a\u00d9\u0001" +
                    "\u0000\u0000\u0000\u080b\u080d\u0003\u00e4r\u0000\u080c\u080b\u0001\u0000" +
                    "\u0000\u0000\u080d\u0810\u0001\u0000\u0000\u0000\u080e\u080c\u0001\u0000" +
                    "\u0000\u0000\u080e\u080f\u0001\u0000\u0000\u0000\u080f\u0811\u0001\u0000" +
                    "\u0000\u0000\u0810\u080e\u0001\u0000\u0000\u0000\u0811\u0816\u0003\u00e4" +
                    "r\u0000\u0812\u0813\u0005\u0006\u0000\u0000\u0813\u0815\u0003\u00e4r\u0000" +
                    "\u0814\u0812\u0001\u0000\u0000\u0000\u0815\u0818\u0001\u0000\u0000\u0000" +
                    "\u0816\u0814\u0001\u0000\u0000\u0000\u0816\u0817\u0001\u0000\u0000\u0000" +
                    "\u0817\u00db\u0001\u0000\u0000\u0000\u0818\u0816\u0001\u0000\u0000\u0000" +
                    "\u0819\u081c\u0005N\u0000\u0000\u081a\u081d\u0003\u00e4r\u0000\u081b\u081d" +
                    "\u0003\u00e6s\u0000\u081c\u081a\u0001\u0000\u0000\u0000\u081c\u081b\u0001" +
                    "\u0000\u0000\u0000\u081c\u081d\u0001\u0000\u0000\u0000\u081d\u00dd\u0001" +
                    "\u0000\u0000\u0000\u081e\u081f\u0005 \u0000\u0000\u081f\u0825\u0005\u0084" +
                    "\u0000\u0000\u0820\u0822\u0005\"\u0000\u0000\u0821\u0823\u0005\u0084\u0000" +
                    "\u0000\u0822\u0821\u0001\u0000\u0000\u0000\u0822\u0823\u0001\u0000\u0000" +
                    "\u0000\u0823\u0825\u0001\u0000\u0000\u0000\u0824\u081e\u0001\u0000\u0000" +
                    "\u0000\u0824\u0820\u0001\u0000\u0000\u0000\u0825\u00df\u0001\u0000\u0000" +
                    "\u0000\u0826\u082b\u0003\u00e4r\u0000\u0827\u0828\u0007\u0003\u0000\u0000" +
                    "\u0828\u082a\u0003\u00e4r\u0000\u0829\u0827\u0001\u0000\u0000\u0000\u082a" +
                    "\u082d\u0001\u0000\u0000\u0000\u082b\u0829\u0001\u0000\u0000\u0000\u082b" +
                    "\u082c\u0001\u0000\u0000\u0000\u082c\u00e1\u0001\u0000\u0000\u0000\u082d" +
                    "\u082b\u0001\u0000\u0000\u0000\u082e\u0833\u0003\u00e4r\u0000\u082f\u0830" +
                    "\u0005\u0006\u0000\u0000\u0830\u0832\u0003\u00e4r\u0000\u0831\u082f\u0001" +
                    "\u0000\u0000\u0000\u0832\u0835\u0001\u0000\u0000\u0000\u0833\u0831\u0001" +
                    "\u0000\u0000\u0000\u0833\u0834\u0001\u0000\u0000\u0000\u0834\u00e3\u0001" +
                    "\u0000\u0000\u0000\u0835\u0833\u0001\u0000\u0000\u0000\u0836\u0837\u0007" +
                    "\u0015\u0000\u0000\u0837\u00e5\u0001\u0000\u0000\u0000\u0838\u0839\u0007" +
                    "\u0016\u0000\u0000\u0839\u00e7\u0001\u0000\u0000\u0000\u083a\u083c\u0003" +
                    "\u00e6s\u0000\u083b\u083d\u0003\u00e4r\u0000\u083c\u083b\u0001\u0000\u0000" +
                    "\u0000\u083c\u083d\u0001\u0000\u0000\u0000\u083d\u00e9\u0001\u0000\u0000" +
                    "\u0000\u083e\u083f\u0007\u0017\u0000\u0000\u083f\u00eb\u0001\u0000\u0000" +
                    "\u0000\u0840\u0842\u0003\u00e4r\u0000\u0841\u0840\u0001\u0000\u0000\u0000" +
                    "\u0841\u0842\u0001\u0000\u0000\u0000\u0842\u0843\u0001\u0000\u0000\u0000" +
                    "\u0843\u084d\u0005\u0086\u0000\u0000\u0844\u0846\u0003\u00e4r\u0000\u0845" +
                    "\u0844\u0001\u0000\u0000\u0000\u0845\u0846\u0001\u0000\u0000\u0000\u0846" +
                    "\u0847\u0001\u0000\u0000\u0000\u0847\u084d\u0005\u0087\u0000\u0000\u0848" +
                    "\u084a\u0003\u00e4r\u0000\u0849\u0848\u0001\u0000\u0000\u0000\u0849\u084a" +
                    "\u0001\u0000\u0000\u0000\u084a\u084b\u0001\u0000\u0000\u0000\u084b\u084d" +
                    "\u0005\u0088\u0000\u0000\u084c\u0841\u0001\u0000\u0000\u0000\u084c\u0845" +
                    "\u0001\u0000\u0000\u0000\u084c\u0849\u0001\u0000\u0000\u0000\u084d\u00ed" +
                    "\u0001\u0000\u0000\u0000\u012b\u00fd\u00ff\u010b\u0112\u011a\u011f\u0122" +
                    "\u0127\u012c\u012f\u0133\u0137\u013a\u013d\u0144\u0150\u0154\u0159\u015e" +
                    "\u0165\u0168\u016b\u016f\u0176\u0178\u0185\u0189\u018d\u0194\u0199\u019c" +
                    "\u01a1\u01a6\u01aa\u01ad\u01b2\u01b9\u01be\u01c5\u01c8\u01cc\u01d3\u01d5" +
                    "\u01de\u01e1\u01e6\u01ed\u01f0\u01f8\u01fa\u0203\u0208\u020f\u0212\u0215" +
                    "\u021b\u0223\u0225\u022c\u0231\u0233\u023b\u0242\u0245\u024d\u024f\u0257" +
                    "\u025d\u0260\u0265\u026c\u0270\u027c\u0281\u0286\u028c\u0291\u0294\u0297" +
                    "\u029c\u02a2\u02a7\u02aa\u02ad\u02b2\u02b8\u02bd\u02c0\u02c4\u02ca\u02d0" +
                    "\u02d4\u02d9\u02dc\u02e0\u02e4\u02e6\u02f0\u02f4\u02f8\u02ff\u0304\u030a" +
                    "\u0315\u0317\u031f\u0325\u0329\u032d\u0334\u0338\u0343\u0346\u0348\u0352" +
                    "\u0356\u0358\u035d\u0365\u0369\u036b\u036f\u0377\u037b\u037d\u0380\u0385" +
                    "\u038a\u0390\u0395\u0399\u039d\u03a0\u03a5\u03ac\u03b4\u03bb\u03bf\u03c7" +
                    "\u03d0\u03d5\u03da\u03e2\u03eb\u03f3\u03fd\u0407\u0414\u041d\u0421\u0429" +
                    "\u042e\u0431\u0450\u0484\u0487\u048c\u0493\u0495\u04a3\u04a5\u04bb\u04e3" +
                    "\u04e5\u04f5\u04f8\u04fa\u04fe\u050f\u0511\u051a\u051f\u0521\u0526\u052b" +
                    "\u0532\u0535\u053c\u055e\u0567\u0571\u0575\u057a\u057f\u0587\u058b\u058f" +
                    "\u0594\u05a2\u05a6\u05b2\u05b6\u05ba\u05bd\u05c5\u05d0\u05d5\u05da\u05e4" +
                    "\u05ee\u05f8\u05fc\u0600\u0605\u0607\u0613\u0619\u0623\u0628\u062a\u0632" +
                    "\u063b\u0640\u0642\u0647\u0650\u0655\u0657\u065b\u065e\u0663\u0668\u066f" +
                    "\u0676\u067e\u0680\u0688\u0690\u069a\u069e\u06a0\u06a6\u06ad\u06b4\u06be" +
                    "\u06c6\u06cd\u06d1\u06d7\u06e3\u06e5\u06f2\u06fb\u06fe\u0703\u0708\u0717" +
                    "\u071a\u0725\u0729\u072e\u0736\u073a\u073f\u0747\u074b\u074f\u0753\u0756" +
                    "\u0759\u0760\u0763\u076a\u076e\u0771\u0775\u077a\u077c\u0789\u078c\u0795" +
                    "\u079a\u079f\u07a9\u07ad\u07af\u07b8\u07bc\u07be\u07c1\u07d1\u07d7\u07e0" +
                    "\u07f1\u07fb\u0800\u0806\u080e\u0816\u081c\u0822\u0824\u082b\u0833\u083c" +
                    "\u0841\u0845\u0849\u084c";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}