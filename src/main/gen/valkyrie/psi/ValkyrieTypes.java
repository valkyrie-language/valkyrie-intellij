// This is a generated file. Not intended for manual editing.
package valkyrie.psi;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import valkyrie.psi.node.*;

public interface ValkyrieTypes {

    IElementType ANNOTATIONS = new ValkyrieAST("ANNOTATIONS");
    IElementType ARGUMENT = new ValkyrieAST("ARGUMENT");
    IElementType ARGUMENT_BODY = new ValkyrieAST("ARGUMENT_BODY");
    IElementType ASSOCIATED_TYPE = new ValkyrieAST("ASSOCIATED_TYPE");
    IElementType ATOMIC = new ValkyrieAST("ATOMIC");
    IElementType ATTRIBUTE_ABOVE = new ValkyrieAST("ATTRIBUTE_ABOVE");
    IElementType ATTRIBUTE_BELOW = new ValkyrieAST("ATTRIBUTE_BELOW");
    IElementType ATTRIBUTE_ITEM = new ValkyrieAST("ATTRIBUTE_ITEM");
    IElementType ATTRIBUTE_LIST = new ValkyrieAST("ATTRIBUTE_LIST");
    IElementType BAD_LL = new ValkyrieAST("BAD_LL");
    IElementType BAD_LLL = new ValkyrieAST("BAD_LLL");
    IElementType BAD_RR = new ValkyrieAST("BAD_RR");
    IElementType BAD_RRR = new ValkyrieAST("BAD_RRR");
    IElementType BARE_PATTERN = new ValkyrieAST("BARE_PATTERN");
    IElementType BARE_PATTERN_ITEM = new ValkyrieAST("BARE_PATTERN_ITEM");
    IElementType BENCHMARK_BODY = new ValkyrieAST("BENCHMARK_BODY");
    IElementType BENCHMARK_UNIT = new ValkyrieAST("BENCHMARK_UNIT");
    IElementType BLOCK_BARE = new ValkyrieAST("BLOCK_BARE");
    IElementType BLOCK_BODY = new ValkyrieAST("BLOCK_BODY");
    IElementType CASE_PATTERN = new ValkyrieAST("CASE_PATTERN");
    IElementType CASE_PATTERN_BIND = new ValkyrieAST("CASE_PATTERN_BIND");
    IElementType CASE_PATTERN_DICT = new ValkyrieAST("CASE_PATTERN_DICT");
    IElementType CASE_PATTERN_ITEM = new ValkyrieAST("CASE_PATTERN_ITEM");
    IElementType CASE_PATTERN_KIND = new ValkyrieAST("CASE_PATTERN_KIND");
    IElementType CASE_PATTERN_LIST = new ValkyrieAST("CASE_PATTERN_LIST");
    IElementType CASE_PATTERN_MAIN = new ValkyrieAST("CASE_PATTERN_MAIN");
    IElementType CASE_PATTERN_PAIR = new ValkyrieAST("CASE_PATTERN_PAIR");
    IElementType CASE_PATTERN_REST = new ValkyrieAST("CASE_PATTERN_REST");
    IElementType CASE_PATTERN_TOP = new ValkyrieAST("CASE_PATTERN_TOP");
    IElementType CLASS_BODY = new ValkyrieAST("CLASS_BODY");
    IElementType CLASS_INHERIT = new ValkyrieAST("CLASS_INHERIT");
    IElementType CONTROL_BREAK = new ValkyrieAST("CONTROL_BREAK");
    IElementType CONTROL_CONTINUE = new ValkyrieAST("CONTROL_CONTINUE");
    IElementType CONTROL_LABEL = new ValkyrieAST("CONTROL_LABEL");
    IElementType CONTROL_RAISE = new ValkyrieAST("CONTROL_RAISE");
    IElementType CONTROL_RESUME = new ValkyrieAST("CONTROL_RESUME");
    IElementType CONTROL_RETURN = new ValkyrieAST("CONTROL_RETURN");
    IElementType CONTROL_STATEMENT = new ValkyrieAST("CONTROL_STATEMENT");
    IElementType CONTROL_THROUGH = new ValkyrieAST("CONTROL_THROUGH");
    IElementType CONTROL_YIELD_FROM = new ValkyrieAST("CONTROL_YIELD_FROM");
    IElementType CONTROL_YIELD_SEND = new ValkyrieAST("CONTROL_YIELD_SEND");
    IElementType CONTROL_YIELD_STOP = new ValkyrieAST("CONTROL_YIELD_STOP");
    IElementType CONTROL_YIELD_TYPE = new ValkyrieAST("CONTROL_YIELD_TYPE");
    IElementType DECLARE_CLASS = new ValkyrieAST("DECLARE_CLASS");
    IElementType DECLARE_COMPONENT = new ValkyrieAST("DECLARE_COMPONENT");
    IElementType DECLARE_DOMAIN = new ValkyrieAST("DECLARE_DOMAIN");
    IElementType DECLARE_ENUMS = new ValkyrieAST("DECLARE_ENUMS");
    IElementType DECLARE_FIELD = new ValkyrieAST("DECLARE_FIELD");
    IElementType DECLARE_FLAGS = new ValkyrieAST("DECLARE_FLAGS");
    IElementType DECLARE_FUNCTION = new ValkyrieAST("DECLARE_FUNCTION");
    IElementType DECLARE_GENERIC = new ValkyrieAST("DECLARE_GENERIC");
    IElementType DECLARE_IMPLY = new ValkyrieAST("DECLARE_IMPLY");
    IElementType DECLARE_INFER = new ValkyrieAST("DECLARE_INFER");
    IElementType DECLARE_MACRO = new ValkyrieAST("DECLARE_MACRO");
    IElementType DECLARE_METHOD = new ValkyrieAST("DECLARE_METHOD");
    IElementType DECLARE_MEZZO = new ValkyrieAST("DECLARE_MEZZO");
    IElementType DECLARE_NAMESPACE = new ValkyrieAST("DECLARE_NAMESPACE");
    IElementType DECLARE_NEURAL = new ValkyrieAST("DECLARE_NEURAL");
    IElementType DECLARE_SEMANTIC = new ValkyrieAST("DECLARE_SEMANTIC");
    IElementType DECLARE_SINGLETON = new ValkyrieAST("DECLARE_SINGLETON");
    IElementType DECLARE_TESTS = new ValkyrieAST("DECLARE_TESTS");
    IElementType DECLARE_TRAIT = new ValkyrieAST("DECLARE_TRAIT");
    IElementType DECLARE_TYPE = new ValkyrieAST("DECLARE_TYPE");
    IElementType DECLARE_UNION = new ValkyrieAST("DECLARE_UNION");
    IElementType DECLARE_UNITE = new ValkyrieAST("DECLARE_UNITE");
    IElementType DECLARE_VARIANT = new ValkyrieAST("DECLARE_VARIANT");
    IElementType DECLARE_WHERE = new ValkyrieAST("DECLARE_WHERE");
    IElementType DEFAULT_TYPE = new ValkyrieAST("DEFAULT_TYPE");
    IElementType DEFAULT_VALUE = new ValkyrieAST("DEFAULT_VALUE");
    IElementType DOT_CALL = new ValkyrieAST("DOT_CALL");
    IElementType DOT_CALL_INLINE = new ValkyrieAST("DOT_CALL_INLINE");
    IElementType DOT_CALL_MACRO = new ValkyrieAST("DOT_CALL_MACRO");
    IElementType DOT_CALL_MACRO_INLINE = new ValkyrieAST("DOT_CALL_MACRO_INLINE");
    IElementType DOT_LOOP_CALL = new ValkyrieAST("DOT_LOOP_CALL");
    IElementType DOT_MATCH_CALL = new ValkyrieAST("DOT_MATCH_CALL");
    IElementType ELSE_IF_STATEMENT = new ValkyrieAST("ELSE_IF_STATEMENT");
    IElementType ELSE_STATEMENT = new ValkyrieAST("ELSE_STATEMENT");
    IElementType ELSE_TEMPLATE = new ValkyrieAST("ELSE_TEMPLATE");
    IElementType EXPRESSION = new ValkyrieAST("EXPRESSION");
    IElementType EXPRESSION_INLINE = new ValkyrieAST("EXPRESSION_INLINE");
    IElementType EXPRESSION_ROOT = new ValkyrieAST("EXPRESSION_ROOT");
    IElementType FLAGS_BODY = new ValkyrieAST("FLAGS_BODY");
    IElementType FUNCTION_CALL = new ValkyrieAST("FUNCTION_CALL");
    IElementType FUNCTION_CALL_INLINE = new ValkyrieAST("FUNCTION_CALL_INLINE");
    IElementType GENERIC_ARGUMENT = new ValkyrieAST("GENERIC_ARGUMENT");
    IElementType GENERIC_CALL = new ValkyrieAST("GENERIC_CALL");
    IElementType GENERIC_CALL_FREE = new ValkyrieAST("GENERIC_CALL_FREE");
    IElementType GENERIC_PARAMETER = new ValkyrieAST("GENERIC_PARAMETER");
    IElementType IDENTIFIER_FREE = new ValkyrieAST("IDENTIFIER_FREE");
    IElementType IDENTIFIER_SAFE = new ValkyrieAST("IDENTIFIER_SAFE");
    IElementType IF_CONDITION = new ValkyrieAST("IF_CONDITION");
    IElementType IF_STATEMENT = new ValkyrieAST("IF_STATEMENT");
    IElementType INFER_BODY = new ValkyrieAST("INFER_BODY");
    IElementType INFIX = new ValkyrieAST("INFIX");
    IElementType INFIX_GREATER = new ValkyrieAST("INFIX_GREATER");
    IElementType INFIX_GREATER_EQUAL = new ValkyrieAST("INFIX_GREATER_EQUAL");
    IElementType INFIX_LESS = new ValkyrieAST("INFIX_LESS");
    IElementType INFIX_LESS_EQUAL = new ValkyrieAST("INFIX_LESS_EQUAL");
    IElementType INFIX_LOGICAL = new ValkyrieAST("INFIX_LOGICAL");
    IElementType INFIX_MULTIPLE = new ValkyrieAST("INFIX_MULTIPLE");
    IElementType INHERIT_ITEM = new ValkyrieAST("INHERIT_ITEM");
    IElementType INLINE_ATOMIC = new ValkyrieAST("INLINE_ATOMIC");
    IElementType INLINE_SUFFIX = new ValkyrieAST("INLINE_SUFFIX");
    IElementType INLINE_TERM = new ValkyrieAST("INLINE_TERM");
    IElementType IS_EXPRESSION = new ValkyrieAST("IS_EXPRESSION");
    IElementType IS_STATEMENT = new ValkyrieAST("IS_STATEMENT");
    IElementType LET_PATTERN = new ValkyrieAST("LET_PATTERN");
    IElementType LET_STATEMENT = new ValkyrieAST("LET_STATEMENT");
    IElementType LOCALIZE_CALL = new ValkyrieAST("LOCALIZE_CALL");
    IElementType LOOP_CONDITION = new ValkyrieAST("LOOP_CONDITION");
    IElementType LOOP_EACH = new ValkyrieAST("LOOP_EACH");
    IElementType LOOP_INLINE = new ValkyrieAST("LOOP_INLINE");
    IElementType LOOP_MATCH = new ValkyrieAST("LOOP_MATCH");
    IElementType LOOP_START = new ValkyrieAST("LOOP_START");
    IElementType LOOP_STATEMENT = new ValkyrieAST("LOOP_STATEMENT");
    IElementType LOOP_TEMPLATE = new ValkyrieAST("LOOP_TEMPLATE");
    IElementType LOOP_TEMPLATE_START = new ValkyrieAST("LOOP_TEMPLATE_START");
    IElementType LOOP_UNTIL = new ValkyrieAST("LOOP_UNTIL");
    IElementType LOOP_UNTIL_NOT = new ValkyrieAST("LOOP_UNTIL_NOT");
    IElementType LOOP_WHILE = new ValkyrieAST("LOOP_WHILE");
    IElementType LOOP_WHILE_LET = new ValkyrieAST("LOOP_WHILE_LET");
    IElementType MACRO_CALL = new ValkyrieAST("MACRO_CALL");
    IElementType MACRO_CALL_INLINE = new ValkyrieAST("MACRO_CALL_INLINE");
    IElementType MACRO_PATH = new ValkyrieAST("MACRO_PATH");
    IElementType MATCH_BIND = new ValkyrieAST("MATCH_BIND");
    IElementType MATCH_BODY = new ValkyrieAST("MATCH_BODY");
    IElementType MATCH_CASE = new ValkyrieAST("MATCH_CASE");
    IElementType MATCH_ELSE = new ValkyrieAST("MATCH_ELSE");
    IElementType MATCH_KIND = new ValkyrieAST("MATCH_KIND");
    IElementType MATCH_STATEMENT = new ValkyrieAST("MATCH_STATEMENT");
    IElementType MATCH_TYPE = new ValkyrieAST("MATCH_TYPE");
    IElementType MATCH_WHEN = new ValkyrieAST("MATCH_WHEN");
    IElementType MATCH_WITH = new ValkyrieAST("MATCH_WITH");
    IElementType MATCH_WITH_CONTROL = new ValkyrieAST("MATCH_WITH_CONTROL");
    IElementType MATCH_WITH_PROVIDE = new ValkyrieAST("MATCH_WITH_PROVIDE");
    IElementType MAY_LET_STATEMENT = new ValkyrieAST("MAY_LET_STATEMENT");
    IElementType MODIFIER = new ValkyrieAST("MODIFIER");
    IElementType NAMEPATH_AUTO = new ValkyrieAST("NAMEPATH_AUTO");
    IElementType NAMEPATH_FREE = new ValkyrieAST("NAMEPATH_FREE");
    IElementType NAMEPATH_SAFE = new ValkyrieAST("NAMEPATH_SAFE");
    IElementType NEW_BIND = new ValkyrieAST("NEW_BIND");
    IElementType NEW_BODY = new ValkyrieAST("NEW_BODY");
    IElementType NEW_LAMBDA = new ValkyrieAST("NEW_LAMBDA");
    IElementType NEW_OBJECT = new ValkyrieAST("NEW_OBJECT");
    IElementType NEW_VALUE = new ValkyrieAST("NEW_VALUE");
    IElementType NUMBER_LITERAL = new ValkyrieAST("NUMBER_LITERAL");
    IElementType OFFSET_RANGE = new ValkyrieAST("OFFSET_RANGE");
    IElementType OFFSET_SLICE = new ValkyrieAST("OFFSET_SLICE");
    IElementType ORDINAL_RANGE = new ValkyrieAST("ORDINAL_RANGE");
    IElementType ORDINAL_SLICE = new ValkyrieAST("ORDINAL_SLICE");
    IElementType PARAMETER_BODY = new ValkyrieAST("PARAMETER_BODY");
    IElementType PARAMETER_DICT = new ValkyrieAST("PARAMETER_DICT");
    IElementType PARAMETER_ITEM = new ValkyrieAST("PARAMETER_ITEM");
    IElementType PARAMETER_KIND = new ValkyrieAST("PARAMETER_KIND");
    IElementType PARAMETER_LIST = new ValkyrieAST("PARAMETER_LIST");
    IElementType PREFIX = new ValkyrieAST("PREFIX");
    IElementType PREFIX_DEREF = new ValkyrieAST("PREFIX_DEREF");
    IElementType PREFIX_NOT = new ValkyrieAST("PREFIX_NOT");
    IElementType PREFIX_REF = new ValkyrieAST("PREFIX_REF");
    IElementType RANGE_INDEX = new ValkyrieAST("RANGE_INDEX");
    IElementType RANGE_ITEM = new ValkyrieAST("RANGE_ITEM");
    IElementType RANGE_LOWER = new ValkyrieAST("RANGE_LOWER");
    IElementType RANGE_STEP = new ValkyrieAST("RANGE_STEP");
    IElementType RANGE_UPPER = new ValkyrieAST("RANGE_UPPER");
    IElementType RETURN_TYPE = new ValkyrieAST("RETURN_TYPE");
    IElementType RUN_BENCHMARK = new ValkyrieAST("RUN_BENCHMARK");
    IElementType RUN_TEST_CAST = new ValkyrieAST("RUN_TEST_CAST");
    IElementType SLOT = new ValkyrieAST("SLOT");
    IElementType SLOT_FIRST = new ValkyrieAST("SLOT_FIRST");
    IElementType SLOT_INDEX = new ValkyrieAST("SLOT_INDEX");
    IElementType SLOT_NAMED = new ValkyrieAST("SLOT_NAMED");
    IElementType SPECIAL = new ValkyrieAST("SPECIAL");
    IElementType STATEMENTS = new ValkyrieAST("STATEMENTS");
    IElementType STRING = new ValkyrieAST("STRING");
    IElementType SUFFIX = new ValkyrieAST("SUFFIX");
    IElementType TEMPLATE_END = new ValkyrieAST("TEMPLATE_END");
    IElementType TERM = new ValkyrieAST("TERM");
    IElementType TESTS_BODY = new ValkyrieAST("TESTS_BODY");
    IElementType THEN_STATEMENT = new ValkyrieAST("THEN_STATEMENT");
    IElementType TRAIT_ALIAS = new ValkyrieAST("TRAIT_ALIAS");
    IElementType TRAIT_DEFINE = new ValkyrieAST("TRAIT_DEFINE");
    IElementType TRY_LET_STATEMENT = new ValkyrieAST("TRY_LET_STATEMENT");
    IElementType TRY_NOT_STATEMENT = new ValkyrieAST("TRY_NOT_STATEMENT");
    IElementType TRY_STATEMENT = new ValkyrieAST("TRY_STATEMENT");
    IElementType TUPLE_ARGUMENT = new ValkyrieAST("TUPLE_ARGUMENT");
    IElementType TYPE_ALIAS = new ValkyrieAST("TYPE_ALIAS");
    IElementType TYPE_ATOMIC = new ValkyrieAST("TYPE_ATOMIC");
    IElementType TYPE_EXPRESSION = new ValkyrieAST("TYPE_EXPRESSION");
    IElementType TYPE_FUNCTION = new ValkyrieAST("TYPE_FUNCTION");
    IElementType TYPE_HINT = new ValkyrieAST("TYPE_HINT");
    IElementType TYPE_INFIX = new ValkyrieAST("TYPE_INFIX");
    IElementType TYPE_PATTERN = new ValkyrieAST("TYPE_PATTERN");
    IElementType TYPE_PATTERN_INLINE = new ValkyrieAST("TYPE_PATTERN_INLINE");
    IElementType TYPE_PATTERN_ITEM = new ValkyrieAST("TYPE_PATTERN_ITEM");
    IElementType TYPE_PATTERN_OBJECT = new ValkyrieAST("TYPE_PATTERN_OBJECT");
    IElementType TYPE_PATTERN_PAIR = new ValkyrieAST("TYPE_PATTERN_PAIR");
    IElementType TYPE_PATTERN_TUPLE = new ValkyrieAST("TYPE_PATTERN_TUPLE");
    IElementType TYPE_PREFIX = new ValkyrieAST("TYPE_PREFIX");
    IElementType TYPE_SUFFIX = new ValkyrieAST("TYPE_SUFFIX");
    IElementType TYPE_TERM = new ValkyrieAST("TYPE_TERM");
    IElementType TYPE_TUPLE = new ValkyrieAST("TYPE_TUPLE");
    IElementType UNITE_BODY = new ValkyrieAST("UNITE_BODY");
    IElementType UNUSED = new ValkyrieAST("UNUSED");
    IElementType USING_ALIAS = new ValkyrieAST("USING_ALIAS");
    IElementType USING_ANY = new ValkyrieAST("USING_ANY");
    IElementType USING_BLOCK = new ValkyrieAST("USING_BLOCK");
    IElementType USING_BODY = new ValkyrieAST("USING_BODY");
    IElementType USING_EXCLUDE = new ValkyrieAST("USING_EXCLUDE");
    IElementType USING_STATEMENT = new ValkyrieAST("USING_STATEMENT");
    IElementType USING_TERM = new ValkyrieAST("USING_TERM");
    IElementType WHERE_CONDITION = new ValkyrieAST("WHERE_CONDITION");
    IElementType WHERE_TERM = new ValkyrieAST("WHERE_TERM");

    IElementType ANGLE_L = new ValkyrieCST("<");
    IElementType ANGLE_R = new ValkyrieCST(">");
    IElementType ANY_DICT = new ValkyrieCST("…");
    IElementType ANY_LIST = new ValkyrieCST("‥");
    IElementType ASSIGN_L = new ValkyrieCST("ASSIGN_L");
    IElementType ASSIGN_R = new ValkyrieCST("ASSIGN_R");
    IElementType BIND = new ValkyrieCST("BIND");
    IElementType BRACE_L = new ValkyrieCST("{");
    IElementType BRACE_R = new ValkyrieCST("}");
    IElementType BRACKET_L = new ValkyrieCST("[");
    IElementType BRACKET_R = new ValkyrieCST("]");
    IElementType BUILDER_L = new ValkyrieCST("BUILDER_L");
    IElementType BUILDER_R = new ValkyrieCST("BUILDER_R");
    IElementType CEIL_L = new ValkyrieCST("CEIL_L");
    IElementType CEIL_R = new ValkyrieCST("CEIL_R");
    IElementType COLON = new ValkyrieCST(":");
    IElementType COLOR = new ValkyrieCST("COLOR");
    IElementType COMMA = new ValkyrieCST(",");
    IElementType COMMENT_BLOCK = new ValkyrieCST("Comment Block");
    IElementType COMMENT_LINE = new ValkyrieCST("Comment Line");
    IElementType DECIMAL = new ValkyrieCST("DECIMAL");
    IElementType DOLLAR = new ValkyrieCST("$");
    IElementType DOMAIN_L = new ValkyrieCST("DOMAIN_L");
    IElementType DOMAIN_R = new ValkyrieCST("DOMAIN_R");
    IElementType DOT = new ValkyrieCST(".");
    IElementType EQUAL = new ValkyrieCST("=");
    IElementType ESCAPED = new ValkyrieCST("\\escaped");
    IElementType FLOOR_L = new ValkyrieCST("FLOOR_L");
    IElementType FLOOR_R = new ValkyrieCST("FLOOR_R");
    IElementType GENERIC_L = new ValkyrieCST("GENERIC_L");
    IElementType GENERIC_R = new ValkyrieCST("GENERIC_R");
    IElementType INTEGER = new ValkyrieCST("<<INTEGER>>");
    IElementType KW_AS = new ValkyrieCST("KW_AS");
    IElementType KW_BOOLEAN = new ValkyrieCST("KW_BOOLEAN");
    IElementType KW_BREAK = new ValkyrieCST("KW_BREAK");
    IElementType KW_CASE = new ValkyrieCST("KW_CASE");
    IElementType KW_CATCH = new ValkyrieCST("KW_CATCH");
    IElementType KW_CLASS = new ValkyrieCST("KW_CLASS");
    IElementType KW_COMPONENT = new ValkyrieCST("KW_COMPONENT");
    IElementType KW_CONTINUE = new ValkyrieCST("KW_CONTINUE");
    IElementType KW_EACH = new ValkyrieCST("KW_EACH");
    IElementType KW_ELSE = new ValkyrieCST("KW_ELSE");
    IElementType KW_END = new ValkyrieCST("KW_END");
    IElementType KW_ENUMERATE = new ValkyrieCST("KW_ENUMERATE");
    IElementType KW_EXCLUDE = new ValkyrieCST("KW_EXCLUDE");
    IElementType KW_FLAGS = new ValkyrieCST("KW_FLAGS");
    IElementType KW_FOR = new ValkyrieCST("KW_FOR");
    IElementType KW_FROM = new ValkyrieCST("KW_FROM");
    IElementType KW_FUNCTION = new ValkyrieCST("KW_FUNCTION");
    IElementType KW_IF = new ValkyrieCST("KW_IF");
    IElementType KW_IMPLY = new ValkyrieCST("KW_IMPLY");
    IElementType KW_IN = new ValkyrieCST("KW_IN");
    IElementType KW_INFER = new ValkyrieCST("KW_INFER");
    IElementType KW_IS = new ValkyrieCST("KW_IS");
    IElementType KW_LAMBDA = new ValkyrieCST("KW_LAMBDA");
    IElementType KW_LET = new ValkyrieCST("KW_LET");
    IElementType KW_LOOP = new ValkyrieCST("KW_LOOP");
    IElementType KW_MACRO = new ValkyrieCST("KW_MACRO");
    IElementType KW_MATCH = new ValkyrieCST("KW_MATCH");
    IElementType KW_MEZZO = new ValkyrieCST("KW_MEZZO");
    IElementType KW_MICRO = new ValkyrieCST("KW_MICRO");
    IElementType KW_NAMESPACE = new ValkyrieCST("KW_NAMESPACE");
    IElementType KW_NEURAL = new ValkyrieCST("KW_NEURAL");
    IElementType KW_NEW = new ValkyrieCST("KW_NEW");
    IElementType KW_NIL = new ValkyrieCST("KW_NIL");
    IElementType KW_NOT = new ValkyrieCST("KW_NOT");
    IElementType KW_NULL = new ValkyrieCST("KW_NULL");
    IElementType KW_OBJECT = new ValkyrieCST("KW_OBJECT");
    IElementType KW_RAISE = new ValkyrieCST("KW_RAISE");
    IElementType KW_RESUME = new ValkyrieCST("KW_RESUME");
    IElementType KW_RETURN = new ValkyrieCST("KW_RETURN");
    IElementType KW_SINGLETON = new ValkyrieCST("KW_SINGLETON");
    IElementType KW_TESTS = new ValkyrieCST("KW_TESTS");
    IElementType KW_THEN = new ValkyrieCST("KW_THEN");
    IElementType KW_THROUGH = new ValkyrieCST("KW_THROUGH");
    IElementType KW_TRAIT = new ValkyrieCST("KW_TRAIT");
    IElementType KW_TRY = new ValkyrieCST("KW_TRY");
    IElementType KW_TYPE = new ValkyrieCST("KW_TYPE");
    IElementType KW_UNION = new ValkyrieCST("KW_UNION");
    IElementType KW_UNITE = new ValkyrieCST("KW_UNITE");
    IElementType KW_UNTIL = new ValkyrieCST("KW_UNTIL");
    IElementType KW_USING = new ValkyrieCST("KW_USING");
    IElementType KW_WHEN = new ValkyrieCST("KW_WHEN");
    IElementType KW_WHERE = new ValkyrieCST("KW_WHERE");
    IElementType KW_WHILE = new ValkyrieCST("KW_WHILE");
    IElementType KW_WITH = new ValkyrieCST("KW_WITH");
    IElementType KW_YIELD = new ValkyrieCST("KW_YIELD");
    IElementType LOGIC_AND = new ValkyrieCST("LOGIC_AND");
    IElementType LOGIC_NAND = new ValkyrieCST("LOGIC_NAND");
    IElementType LOGIC_NOR = new ValkyrieCST("LOGIC_NOR");
    IElementType LOGIC_OR = new ValkyrieCST("LOGIC_OR");
    IElementType LOGIC_XAND = new ValkyrieCST("LOGIC_XAND");
    IElementType LOGIC_XOR = new ValkyrieCST("LOGIC_XOR");
    IElementType NAME_SCOPE = new ValkyrieCST("NAME_SCOPE");
    IElementType NAME_SPLIT = new ValkyrieCST("∷");
    IElementType NUMBER_BASE = new ValkyrieCST("NUMBER_BASE");
    IElementType NUMBER_EXPONENT = new ValkyrieCST("NUMBER_EXPONENT");
    IElementType NUMBER_SUFFIX = new ValkyrieCST("NUMBER_SUFFIX");
    IElementType OFFSET_L = new ValkyrieCST("OFFSET_L");
    IElementType OFFSET_R = new ValkyrieCST("OFFSET_R");
    IElementType OP_ADD = new ValkyrieCST("OP_ADD");
    IElementType OP_ADD_ASSIGN = new ValkyrieCST("OP_ADD_ASSIGN");
    IElementType OP_AND = new ValkyrieCST("OP_AND");
    IElementType OP_AND_THEN = new ValkyrieCST("OP_AND_THEN");
    IElementType OP_ARROW1 = new ValkyrieCST("OP_ARROW1");
    IElementType OP_ARROW2 = new ValkyrieCST("OP_ARROW2");
    IElementType OP_ARROW3 = new ValkyrieCST("OP_ARROW3");
    IElementType OP_BANG = new ValkyrieCST("OP_BANG");
    IElementType OP_BASE = new ValkyrieCST("OP_BASE");
    IElementType OP_CELSIUS = new ValkyrieCST("OP_CELSIUS");
    IElementType OP_DEREFERENCE = new ValkyrieCST("OP_DEREFERENCE");
    IElementType OP_DIV = new ValkyrieCST("OP_DIV");
    IElementType OP_DIV_ASSIGN = new ValkyrieCST("OP_DIV_ASSIGN");
    IElementType OP_DIV_CEIL = new ValkyrieCST("OP_DIV_CEIL");
    IElementType OP_DIV_FLOOR = new ValkyrieCST("OP_DIV_FLOOR");
    IElementType OP_DIV_REM = new ValkyrieCST("OP_DIV_REM");
    IElementType OP_DIV_ROUND = new ValkyrieCST("OP_DIV_ROUND");
    IElementType OP_EE = new ValkyrieCST("OP_EE");
    IElementType OP_END = new ValkyrieCST("OP_END");
    IElementType OP_EXPONENT = new ValkyrieCST("OP_EXPONENT");
    IElementType OP_FAHRENHEIT = new ValkyrieCST("OP_FAHRENHEIT");
    IElementType OP_GEQ = new ValkyrieCST("OP_GEQ");
    IElementType OP_GG = new ValkyrieCST("≫");
    IElementType OP_GGG = new ValkyrieCST("⋙");
    IElementType OP_L10N = new ValkyrieCST("OP_L10N");
    IElementType OP_LABEL = new ValkyrieCST("OP_LABEL");
    IElementType OP_LEQ = new ValkyrieCST("OP_LEQ");
    IElementType OP_LL = new ValkyrieCST("≪");
    IElementType OP_LLL = new ValkyrieCST("⋘");
    IElementType OP_MACRO = new ValkyrieCST("OP_MACRO");
    IElementType OP_MACRO_LOWER = new ValkyrieCST("OP_MACRO_LOWER");
    IElementType OP_MACRO_UPPER = new ValkyrieCST("OP_MACRO_UPPER");
    IElementType OP_MAP = new ValkyrieCST("OP_MAP");
    IElementType OP_MUL = new ValkyrieCST("OP_MUL");
    IElementType OP_MUL_ASSIGN = new ValkyrieCST("OP_MUL_ASSIGN");
    IElementType OP_NE = new ValkyrieCST("OP_NE");
    IElementType OP_NOT = new ValkyrieCST("OP_NOT");
    IElementType OP_OR = new ValkyrieCST("OP_OR");
    IElementType OP_POW = new ValkyrieCST("OP_POW");
    IElementType OP_REFERENCE = new ValkyrieCST("OP_REFERENCE");
    IElementType OP_REM = new ValkyrieCST("OP_REM");
    IElementType OP_REM_ASSIGN = new ValkyrieCST("OP_REM_ASSIGN");
    IElementType OP_RR = new ValkyrieCST("OP_RR");
    IElementType OP_SET_THEN = new ValkyrieCST("OP_SET_THEN");
    IElementType OP_SQRT = new ValkyrieCST("OP_SQRT");
    IElementType OP_SUB = new ValkyrieCST("OP_SUB");
    IElementType OP_SUB_ASSIGN = new ValkyrieCST("OP_SUB_ASSIGN");
    IElementType OP_SURD3 = new ValkyrieCST("OP_SURD3");
    IElementType OP_SURD4 = new ValkyrieCST("OP_SURD4");
    IElementType OP_UNTIL = new ValkyrieCST("OP_UNTIL");
    IElementType OP_UNWRAP_ELSE = new ValkyrieCST("OP_UNWRAP_ELSE");
    IElementType OP_UNWRAP_OR = new ValkyrieCST("OP_UNWRAP_OR");
    IElementType PARENTHESIS_L = new ValkyrieCST("(");
    IElementType PARENTHESIS_R = new ValkyrieCST(")");
    IElementType REFERENCE = new ValkyrieCST("$Symbol");
    IElementType SELECTION_LINE = new ValkyrieCST("SELECTION_LINE");
    IElementType SEMICOLON = new ValkyrieCST(";");
    IElementType STAR = new ValkyrieCST("STAR");
    IElementType STRING_L = new ValkyrieCST("STRING_L");
    IElementType STRING_R = new ValkyrieCST("STRING_R");
    IElementType STRING_TEXT = new ValkyrieCST("STRING_TEXT");
    IElementType SYMBOL = new ValkyrieCST("Symbol");
    IElementType SYMBOL_RAW = new ValkyrieCST("SYMBOL_RAW");
    IElementType TEMPLATE_L = new ValkyrieCST("TEMPLATE_L");
    IElementType TEMPLATE_R = new ValkyrieCST("TEMPLATE_R");

    class Factory {
        public static PsiElement createElement(ASTNode node) {
            IElementType type = node.getElementType();
            if (type == ANNOTATIONS) {
                return new ValkyrieAnnotationsNode(node);
            } else if (type == ARGUMENT) {
                return new ValkyrieArgumentNode(node);
            } else if (type == ARGUMENT_BODY) {
                return new ValkyrieArgumentBodyNode(node);
            } else if (type == ASSOCIATED_TYPE) {
                return new ValkyrieAssociatedTypeNode(node);
            } else if (type == ATOMIC) {
                return new ValkyrieAtomicNode(node);
            } else if (type == ATTRIBUTE_ABOVE) {
                return new ValkyrieAttributeAboveNode(node);
            } else if (type == ATTRIBUTE_BELOW) {
                return new ValkyrieAttributeBelowNode(node);
            } else if (type == ATTRIBUTE_ITEM) {
                return new ValkyrieAttributeItemNode(node);
            } else if (type == ATTRIBUTE_LIST) {
                return new ValkyrieAttributeListNode(node);
            } else if (type == BAD_LL) {
                return new ValkyrieBadLlNode(node);
            } else if (type == BAD_LLL) {
                return new ValkyrieBadLllNode(node);
            } else if (type == BAD_RR) {
                return new ValkyrieBadRrNode(node);
            } else if (type == BAD_RRR) {
                return new ValkyrieBadRrrNode(node);
            } else if (type == BARE_PATTERN) {
                return new ValkyrieBarePatternNode(node);
            } else if (type == BARE_PATTERN_ITEM) {
                return new ValkyrieBarePatternItemNode(node);
            } else if (type == BENCHMARK_BODY) {
                return new ValkyrieBenchmarkBodyNode(node);
            } else if (type == BENCHMARK_UNIT) {
                return new ValkyrieBenchmarkUnitNode(node);
            } else if (type == BLOCK_BARE) {
                return new ValkyrieBlockBareNode(node);
            } else if (type == BLOCK_BODY) {
                return new ValkyrieBlockBodyNode(node);
            } else if (type == CASE_PATTERN) {
                return new ValkyrieCasePatternNode(node);
            } else if (type == CASE_PATTERN_BIND) {
                return new ValkyrieCasePatternBindNode(node);
            } else if (type == CASE_PATTERN_DICT) {
                return new ValkyrieCasePatternDictNode(node);
            } else if (type == CASE_PATTERN_ITEM) {
                return new ValkyrieCasePatternItemNode(node);
            } else if (type == CASE_PATTERN_KIND) {
                return new ValkyrieCasePatternKindNode(node);
            } else if (type == CASE_PATTERN_LIST) {
                return new ValkyrieCasePatternListNode(node);
            } else if (type == CASE_PATTERN_MAIN) {
                return new ValkyrieCasePatternMainNode(node);
            } else if (type == CASE_PATTERN_PAIR) {
                return new ValkyrieCasePatternPairNode(node);
            } else if (type == CASE_PATTERN_REST) {
                return new ValkyrieCasePatternRestNode(node);
            } else if (type == CASE_PATTERN_TOP) {
                return new ValkyrieCasePatternTopNode(node);
            } else if (type == CLASS_BODY) {
                return new ValkyrieClassBodyNode(node);
            } else if (type == CLASS_INHERIT) {
                return new ValkyrieClassInheritNode(node);
            } else if (type == CONTROL_BREAK) {
                return new ValkyrieControlBreakNode(node);
            } else if (type == CONTROL_CONTINUE) {
                return new ValkyrieControlContinueNode(node);
            } else if (type == CONTROL_LABEL) {
                return new ValkyrieControlLabelNode(node);
            } else if (type == CONTROL_RAISE) {
                return new ValkyrieControlRaiseNode(node);
            } else if (type == CONTROL_RESUME) {
                return new ValkyrieControlResumeNode(node);
            } else if (type == CONTROL_RETURN) {
                return new ValkyrieControlReturnNode(node);
            } else if (type == CONTROL_STATEMENT) {
                return new ValkyrieControlStatementNode(node);
            } else if (type == CONTROL_THROUGH) {
                return new ValkyrieControlThroughNode(node);
            } else if (type == CONTROL_YIELD_FROM) {
                return new ValkyrieControlYieldFromNode(node);
            } else if (type == CONTROL_YIELD_SEND) {
                return new ValkyrieControlYieldSendNode(node);
            } else if (type == CONTROL_YIELD_STOP) {
                return new ValkyrieControlYieldStopNode(node);
            } else if (type == CONTROL_YIELD_TYPE) {
                return new ValkyrieControlYieldTypeNode(node);
            } else if (type == DECLARE_CLASS) {
                return new ValkyrieDeclareClassNode(node);
            } else if (type == DECLARE_COMPONENT) {
                return new ValkyrieDeclareComponentNode(node);
            } else if (type == DECLARE_DOMAIN) {
                return new ValkyrieDeclareDomainNode(node);
            } else if (type == DECLARE_ENUMS) {
                return new ValkyrieDeclareEnumsNode(node);
            } else if (type == DECLARE_FIELD) {
                return new ValkyrieDeclareFieldNode(node);
            } else if (type == DECLARE_FLAGS) {
                return new ValkyrieDeclareFlagsNode(node);
            } else if (type == DECLARE_FUNCTION) {
                return new ValkyrieDeclareFunctionNode(node);
            } else if (type == DECLARE_GENERIC) {
                return new ValkyrieDeclareGenericNode(node);
            } else if (type == DECLARE_IMPLY) {
                return new ValkyrieDeclareImplyNode(node);
            } else if (type == DECLARE_INFER) {
                return new ValkyrieDeclareInferNode(node);
            } else if (type == DECLARE_MACRO) {
                return new ValkyrieDeclareMacroNode(node);
            } else if (type == DECLARE_METHOD) {
                return new ValkyrieDeclareMethodNode(node);
            } else if (type == DECLARE_MEZZO) {
                return new ValkyrieDeclareMezzoNode(node);
            } else if (type == DECLARE_NAMESPACE) {
                return new ValkyrieDeclareNamespaceNode(node);
            } else if (type == DECLARE_NEURAL) {
                return new ValkyrieDeclareNeuralNode(node);
            } else if (type == DECLARE_SEMANTIC) {
                return new ValkyrieDeclareSemanticNode(node);
            } else if (type == DECLARE_SINGLETON) {
                return new ValkyrieDeclareSingletonNode(node);
            } else if (type == DECLARE_TESTS) {
                return new ValkyrieDeclareTestsNode(node);
            } else if (type == DECLARE_TRAIT) {
                return new ValkyrieDeclareTraitNode(node);
            } else if (type == DECLARE_TYPE) {
                return new ValkyrieDeclareTypeNode(node);
            } else if (type == DECLARE_UNION) {
                return new ValkyrieDeclareUnionNode(node);
            } else if (type == DECLARE_UNITE) {
                return new ValkyrieDeclareUniteNode(node);
            } else if (type == DECLARE_VARIANT) {
                return new ValkyrieDeclareVariantNode(node);
            } else if (type == DECLARE_WHERE) {
                return new ValkyrieDeclareWhereNode(node);
            } else if (type == DEFAULT_TYPE) {
                return new ValkyrieDefaultTypeNode(node);
            } else if (type == DEFAULT_VALUE) {
                return new ValkyrieDefaultValueNode(node);
            } else if (type == DOT_CALL) {
                return new ValkyrieDotCallNode(node);
            } else if (type == DOT_CALL_INLINE) {
                return new ValkyrieDotCallInlineNode(node);
            } else if (type == DOT_CALL_MACRO) {
                return new ValkyrieDotCallMacroNode(node);
            } else if (type == DOT_CALL_MACRO_INLINE) {
                return new ValkyrieDotCallMacroInlineNode(node);
            } else if (type == DOT_LOOP_CALL) {
                return new ValkyrieDotLoopCallNode(node);
            } else if (type == DOT_MATCH_CALL) {
                return new ValkyrieDotMatchCallNode(node);
            } else if (type == ELSE_IF_STATEMENT) {
                return new ValkyrieElseIfStatementNode(node);
            } else if (type == ELSE_STATEMENT) {
                return new ValkyrieElseStatementNode(node);
            } else if (type == ELSE_TEMPLATE) {
                return new ValkyrieElseTemplateNode(node);
            } else if (type == EXPRESSION) {
                return new ValkyrieExpressionNode(node);
            } else if (type == EXPRESSION_INLINE) {
                return new ValkyrieExpressionInlineNode(node);
            } else if (type == EXPRESSION_ROOT) {
                return new ValkyrieExpressionRootNode(node);
            } else if (type == FLAGS_BODY) {
                return new ValkyrieFlagsBodyNode(node);
            } else if (type == FUNCTION_CALL) {
                return new ValkyrieFunctionCallNode(node);
            } else if (type == FUNCTION_CALL_INLINE) {
                return new ValkyrieFunctionCallInlineNode(node);
            } else if (type == GENERIC_ARGUMENT) {
                return new ValkyrieGenericArgumentNode(node);
            } else if (type == GENERIC_CALL) {
                return new ValkyrieGenericCallNode(node);
            } else if (type == GENERIC_CALL_FREE) {
                return new ValkyrieGenericCallFreeNode(node);
            } else if (type == GENERIC_PARAMETER) {
                return new ValkyrieGenericParameterNode(node);
            } else if (type == IDENTIFIER_FREE) {
                return new ValkyrieIdentifierFreeNode(node);
            } else if (type == IDENTIFIER_SAFE) {
                return new ValkyrieIdentifierSafeNode(node);
            } else if (type == IF_CONDITION) {
                return new ValkyrieIfConditionNode(node);
            } else if (type == IF_STATEMENT) {
                return new ValkyrieIfStatementNode(node);
            } else if (type == INFER_BODY) {
                return new ValkyrieInferBodyNode(node);
            } else if (type == INFIX) {
                return new ValkyrieInfixNode(node);
            } else if (type == INFIX_GREATER) {
                return new ValkyrieInfixGreaterNode(node);
            } else if (type == INFIX_GREATER_EQUAL) {
                return new ValkyrieInfixGreaterEqualNode(node);
            } else if (type == INFIX_LESS) {
                return new ValkyrieInfixLessNode(node);
            } else if (type == INFIX_LESS_EQUAL) {
                return new ValkyrieInfixLessEqualNode(node);
            } else if (type == INFIX_LOGICAL) {
                return new ValkyrieInfixLogicalNode(node);
            } else if (type == INFIX_MULTIPLE) {
                return new ValkyrieInfixMultipleNode(node);
            } else if (type == INHERIT_ITEM) {
                return new ValkyrieInheritItemNode(node);
            } else if (type == INLINE_ATOMIC) {
                return new ValkyrieInlineAtomicNode(node);
            } else if (type == INLINE_SUFFIX) {
                return new ValkyrieInlineSuffixNode(node);
            } else if (type == INLINE_TERM) {
                return new ValkyrieInlineTermNode(node);
            } else if (type == IS_EXPRESSION) {
                return new ValkyrieIsExpressionNode(node);
            } else if (type == IS_STATEMENT) {
                return new ValkyrieIsStatementNode(node);
            } else if (type == LET_PATTERN) {
                return new ValkyrieLetPatternNode(node);
            } else if (type == LET_STATEMENT) {
                return new ValkyrieLetStatementNode(node);
            } else if (type == LOCALIZE_CALL) {
                return new ValkyrieLocalizeCallNode(node);
            } else if (type == LOOP_CONDITION) {
                return new ValkyrieLoopConditionNode(node);
            } else if (type == LOOP_EACH) {
                return new ValkyrieLoopEachNode(node);
            } else if (type == LOOP_INLINE) {
                return new ValkyrieLoopInlineNode(node);
            } else if (type == LOOP_MATCH) {
                return new ValkyrieLoopMatchNode(node);
            } else if (type == LOOP_START) {
                return new ValkyrieLoopStartNode(node);
            } else if (type == LOOP_STATEMENT) {
                return new ValkyrieLoopStatementNode(node);
            } else if (type == LOOP_TEMPLATE) {
                return new ValkyrieLoopTemplateNode(node);
            } else if (type == LOOP_TEMPLATE_START) {
                return new ValkyrieLoopTemplateStartNode(node);
            } else if (type == LOOP_UNTIL) {
                return new ValkyrieLoopUntilNode(node);
            } else if (type == LOOP_UNTIL_NOT) {
                return new ValkyrieLoopUntilNotNode(node);
            } else if (type == LOOP_WHILE) {
                return new ValkyrieLoopWhileNode(node);
            } else if (type == LOOP_WHILE_LET) {
                return new ValkyrieLoopWhileLetNode(node);
            } else if (type == MACRO_CALL) {
                return new ValkyrieMacroCallNode(node);
            } else if (type == MACRO_CALL_INLINE) {
                return new ValkyrieMacroCallInlineNode(node);
            } else if (type == MACRO_PATH) {
                return new ValkyrieMacroPathNode(node);
            } else if (type == MATCH_BIND) {
                return new ValkyrieMatchBindNode(node);
            } else if (type == MATCH_BODY) {
                return new ValkyrieMatchBodyNode(node);
            } else if (type == MATCH_CASE) {
                return new ValkyrieMatchCaseNode(node);
            } else if (type == MATCH_ELSE) {
                return new ValkyrieMatchElseNode(node);
            } else if (type == MATCH_KIND) {
                return new ValkyrieMatchKindNode(node);
            } else if (type == MATCH_STATEMENT) {
                return new ValkyrieMatchStatementNode(node);
            } else if (type == MATCH_TYPE) {
                return new ValkyrieMatchTypeNode(node);
            } else if (type == MATCH_WHEN) {
                return new ValkyrieMatchWhenNode(node);
            } else if (type == MATCH_WITH) {
                return new ValkyrieMatchWithNode(node);
            } else if (type == MATCH_WITH_CONTROL) {
                return new ValkyrieMatchWithControlNode(node);
            } else if (type == MATCH_WITH_PROVIDE) {
                return new ValkyrieMatchWithProvideNode(node);
            } else if (type == MAY_LET_STATEMENT) {
                return new ValkyrieMayLetStatementNode(node);
            } else if (type == MODIFIER) {
                return new ValkyrieModifierNode(node);
            } else if (type == NAMEPATH_AUTO) {
                return new ValkyrieNamepathAutoNode(node);
            } else if (type == NAMEPATH_FREE) {
                return new ValkyrieNamepathFreeNode(node);
            } else if (type == NAMEPATH_SAFE) {
                return new ValkyrieNamepathSafeNode(node);
            } else if (type == NEW_BIND) {
                return new ValkyrieNewBindNode(node);
            } else if (type == NEW_BODY) {
                return new ValkyrieNewBodyNode(node);
            } else if (type == NEW_LAMBDA) {
                return new ValkyrieNewLambdaNode(node);
            } else if (type == NEW_OBJECT) {
                return new ValkyrieNewObjectNode(node);
            } else if (type == NEW_VALUE) {
                return new ValkyrieNewValueNode(node);
            } else if (type == NUMBER_LITERAL) {
                return new ValkyrieNumberLiteralNode(node);
            } else if (type == OFFSET_RANGE) {
                return new ValkyrieOffsetRangeNode(node);
            } else if (type == OFFSET_SLICE) {
                return new ValkyrieOffsetSliceNode(node);
            } else if (type == ORDINAL_RANGE) {
                return new ValkyrieOrdinalRangeNode(node);
            } else if (type == ORDINAL_SLICE) {
                return new ValkyrieOrdinalSliceNode(node);
            } else if (type == PARAMETER_BODY) {
                return new ValkyrieParameterBodyNode(node);
            } else if (type == PARAMETER_DICT) {
                return new ValkyrieParameterDictNode(node);
            } else if (type == PARAMETER_ITEM) {
                return new ValkyrieParameterItemNode(node);
            } else if (type == PARAMETER_KIND) {
                return new ValkyrieParameterKindNode(node);
            } else if (type == PARAMETER_LIST) {
                return new ValkyrieParameterListNode(node);
            } else if (type == PREFIX) {
                return new ValkyriePrefixNode(node);
            } else if (type == PREFIX_DEREF) {
                return new ValkyriePrefixDerefNode(node);
            } else if (type == PREFIX_NOT) {
                return new ValkyriePrefixNotNode(node);
            } else if (type == PREFIX_REF) {
                return new ValkyriePrefixRefNode(node);
            } else if (type == RANGE_INDEX) {
                return new ValkyrieRangeIndexNode(node);
            } else if (type == RANGE_ITEM) {
                return new ValkyrieRangeItemNode(node);
            } else if (type == RANGE_LOWER) {
                return new ValkyrieRangeLowerNode(node);
            } else if (type == RANGE_STEP) {
                return new ValkyrieRangeStepNode(node);
            } else if (type == RANGE_UPPER) {
                return new ValkyrieRangeUpperNode(node);
            } else if (type == RETURN_TYPE) {
                return new ValkyrieReturnTypeNode(node);
            } else if (type == RUN_BENCHMARK) {
                return new ValkyrieRunBenchmarkNode(node);
            } else if (type == RUN_TEST_CAST) {
                return new ValkyrieRunTestCastNode(node);
            } else if (type == SLOT) {
                return new ValkyrieSlotNode(node);
            } else if (type == SLOT_FIRST) {
                return new ValkyrieSlotFirstNode(node);
            } else if (type == SLOT_INDEX) {
                return new ValkyrieSlotIndexNode(node);
            } else if (type == SLOT_NAMED) {
                return new ValkyrieSlotNamedNode(node);
            } else if (type == SPECIAL) {
                return new ValkyrieSpecialNode(node);
            } else if (type == STATEMENTS) {
                return new ValkyrieStatementsNode(node);
            } else if (type == STRING) {
                return new ValkyrieStringNode(node);
            } else if (type == SUFFIX) {
                return new ValkyrieSuffixNode(node);
            } else if (type == TEMPLATE_END) {
                return new ValkyrieTemplateEndNode(node);
            } else if (type == TERM) {
                return new ValkyrieTermNode(node);
            } else if (type == TESTS_BODY) {
                return new ValkyrieTestsBodyNode(node);
            } else if (type == THEN_STATEMENT) {
                return new ValkyrieThenStatementNode(node);
            } else if (type == TRAIT_ALIAS) {
                return new ValkyrieTraitAliasNode(node);
            } else if (type == TRAIT_DEFINE) {
                return new ValkyrieTraitDefineNode(node);
            } else if (type == TRY_LET_STATEMENT) {
                return new ValkyrieTryLetStatementNode(node);
            } else if (type == TRY_NOT_STATEMENT) {
                return new ValkyrieTryNotStatementNode(node);
            } else if (type == TRY_STATEMENT) {
                return new ValkyrieTryStatementNode(node);
            } else if (type == TUPLE_ARGUMENT) {
                return new ValkyrieTupleArgumentNode(node);
            } else if (type == TYPE_ALIAS) {
                return new ValkyrieTypeAliasNode(node);
            } else if (type == TYPE_ATOMIC) {
                return new ValkyrieTypeAtomicNode(node);
            } else if (type == TYPE_EXPRESSION) {
                return new ValkyrieTypeExpressionNode(node);
            } else if (type == TYPE_FUNCTION) {
                return new ValkyrieTypeFunctionNode(node);
            } else if (type == TYPE_HINT) {
                return new ValkyrieTypeHintNode(node);
            } else if (type == TYPE_INFIX) {
                return new ValkyrieTypeInfixNode(node);
            } else if (type == TYPE_PATTERN) {
                return new ValkyrieTypePatternNode(node);
            } else if (type == TYPE_PATTERN_INLINE) {
                return new ValkyrieTypePatternInlineNode(node);
            } else if (type == TYPE_PATTERN_ITEM) {
                return new ValkyrieTypePatternItemNode(node);
            } else if (type == TYPE_PATTERN_OBJECT) {
                return new ValkyrieTypePatternObjectNode(node);
            } else if (type == TYPE_PATTERN_PAIR) {
                return new ValkyrieTypePatternPairNode(node);
            } else if (type == TYPE_PATTERN_TUPLE) {
                return new ValkyrieTypePatternTupleNode(node);
            } else if (type == TYPE_PREFIX) {
                return new ValkyrieTypePrefixNode(node);
            } else if (type == TYPE_SUFFIX) {
                return new ValkyrieTypeSuffixNode(node);
            } else if (type == TYPE_TERM) {
                return new ValkyrieTypeTermNode(node);
            } else if (type == TYPE_TUPLE) {
                return new ValkyrieTypeTupleNode(node);
            } else if (type == UNITE_BODY) {
                return new ValkyrieUniteBodyNode(node);
            } else if (type == UNUSED) {
                return new ValkyrieUnusedNode(node);
            } else if (type == USING_ALIAS) {
                return new ValkyrieUsingAliasNode(node);
            } else if (type == USING_ANY) {
                return new ValkyrieUsingAnyNode(node);
            } else if (type == USING_BLOCK) {
                return new ValkyrieUsingBlockNode(node);
            } else if (type == USING_BODY) {
                return new ValkyrieUsingBodyNode(node);
            } else if (type == USING_EXCLUDE) {
                return new ValkyrieUsingExcludeNode(node);
            } else if (type == USING_STATEMENT) {
                return new ValkyrieUsingStatementNode(node);
            } else if (type == USING_TERM) {
                return new ValkyrieUsingTermNode(node);
            } else if (type == WHERE_CONDITION) {
                return new ValkyrieWhereConditionNode(node);
            } else if (type == WHERE_TERM) {
                return new ValkyrieWhereTermNode(node);
            }
            throw new AssertionError("Unknown element type: " + type);
        }
    }
}
