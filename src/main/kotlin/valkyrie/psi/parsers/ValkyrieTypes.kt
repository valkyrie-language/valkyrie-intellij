package valkyrie.psi.parsers

import com.intellij.psi.tree.TokenSet
import valkyrie.psi.parsers.ValkyrieElementType
import valkyrie.psi.lexers.ValkyrieTokenType

/**
 * Valkyrie 所有 Token 类型
 */
object ValkyrieTypes {
    @JvmField
    val NAMESPACE = ValkyrieTokenType("namespace")

    @JvmField
    val USING = ValkyrieTokenType("using")

    // 关键字
    @JvmField
    val LET = ValkyrieTokenType("let")

    @JvmField
    val IF = ValkyrieTokenType("if")

    @JvmField
    val ELSE = ValkyrieTokenType("else")

    @JvmField
    val WHILE = ValkyrieTokenType("while")

    @JvmField
    val UNTIL = ValkyrieTokenType("until")

    @JvmField
    val LOOP = ValkyrieTokenType("loop")

    val MICRO = ValkyrieTokenType("micro")
    val MEZZO = ValkyrieTokenType("mezzo")
    val MACRO = ValkyrieTokenType("macro")
    val CLASS = ValkyrieTokenType("class")
    val NEURAL = ValkyrieTokenType("neural")
    val WIDGET = ValkyrieTokenType("widget")

    @JvmField
    val SINGLETON = ValkyrieTokenType("singleton")

    @JvmField
    val UNION = ValkyrieTokenType("union")

    @JvmField
    val UNITY = ValkyrieTokenType("unity")

    @JvmField
    val FLAGS = ValkyrieTokenType("flags")

    @JvmField
    val EIDOS = ValkyrieTokenType("eidos")

    @JvmField
    val TRAIT = ValkyrieTokenType("trait")

    @JvmField
    val IMPLY = ValkyrieTokenType("imply")

    @JvmField
    val CONSTRUCTOR = ValkyrieTokenType("constructor")

    @JvmField
    val STRUCTURE = ValkyrieTokenType("structure")

    @JvmField
    val BREAK = ValkyrieTokenType("break")

    @JvmField
    val CONTINUE = ValkyrieTokenType("continue")

    @JvmField
    val YIELD = ValkyrieTokenType("yield")

    @JvmField
    val RAISE = ValkyrieTokenType("raise")

    @JvmField
    val RESUME = ValkyrieTokenType("resume")

    @JvmField
    val SCOPE = ValkyrieTokenType("scope")

    @JvmField
    val RETURN = ValkyrieTokenType("return")

    @JvmField
    val ASSERT = ValkyrieTokenType("assert")

    @JvmField
    val DEBUG = ValkyrieTokenType("debug")

    @JvmField
    val TESTS = ValkyrieTokenType("tests")

    @JvmField
    val TRY = ValkyrieTokenType("try")

    @JvmField
    val MATCH = ValkyrieTokenType("match")

    @JvmField
    val CATCH = ValkyrieTokenType("catch")

    @JvmField
    val CASE = ValkyrieTokenType("case")
    val WHEN = ValkyrieTokenType("when")
    val TYPE = ValkyrieTokenType("type")

    @JvmField
    val FALLTHROUGH = ValkyrieTokenType("fallthrough")

    // 中缀运算符
    @JvmField
    val IN = ValkyrieTokenType("in")

    @JvmField
    val IS = ValkyrieTokenType("is")

    @JvmField
    val AS = ValkyrieTokenType("as")

    val SYMBOL by lazy { TokenSet.create(SYMBOL_XID, SYMBOL_RAW) }

    // 标识符和字面量
    @JvmField
    val SYMBOL_XID = ValkyrieTokenType("SYMBOL.XID")

    @JvmField
    val SYMBOL_RAW = ValkyrieTokenType("SYMBOL.RAW")

    @JvmField
    val BOOLEAN = ValkyrieTokenType("BOOLEAN")

    @JvmField
    val KW_SOME = ValkyrieTokenType("Some")

    @JvmField
    val KW_NONE = ValkyrieTokenType("None")

    @JvmField
    val KW_SELF = ValkyrieTokenType("self")

    @JvmField
    val KW_SELF_TYPE = ValkyrieTokenType("Self")

    @JvmField
    val KW_VALUE = ValkyrieTokenType("value")

    @JvmField
    val KW_V = ValkyrieTokenType("V")

    @JvmField
    val INTEGER = ValkyrieTokenType("INTEGER")

    @JvmField
    val DECIMAL = ValkyrieTokenType("DECIMAL")


    val MACRO_NUMBER = ValkyrieTokenType("MACRO.NUMBER")

    @JvmField
    val STRING_DQ = ValkyrieTokenType("STRING")

    @JvmField
    val STRING_MQ = ValkyrieTokenType("MULTI_QUOTE_STRING")

    @JvmField
    val STRING_L = ValkyrieTokenType("STRING_L")

    val STRING_START = ValkyrieTokenType("STRING.START")
    val STRING_END = ValkyrieTokenType("STRING.END")
    val STRING_TEXT = ValkyrieTokenType("STRING.TEXT")
    val MACRO_STRING = ValkyrieTokenType("MACRO.STRING")

    // 特殊值
    @JvmField
    val NIL = ValkyrieTokenType("nil")

    @JvmField
    val NULL = ValkyrieTokenType("null")

    // 操作符
    @JvmField
    val ASSIGN = ValkyrieTokenType("=")  // =

    @JvmField
    val PLUS = ValkyrieTokenType("+")    // +

    @JvmField
    val MINUS = ValkyrieTokenType("-")  // -

    @JvmField
    val STAR = ValkyrieTokenType("*") // *

    @JvmField
    val MULTIPLY = ValkyrieTokenType("×") // ×

    @JvmField
    val SLASH = ValkyrieTokenType("DIVIDE") // /

    @JvmField
    val RECIPROCAL = ValkyrieTokenType("⅟") // ⅟

    @JvmField
    val INTEGER_DIVIDE = ValkyrieTokenType("//")

    // 后缀运算符
    @JvmField
    val CELSIUS = ValkyrieTokenType("℃")

    @JvmField
    val FAHRENHEIT = ValkyrieTokenType("℉")

    @JvmField
    val PERCENT = ValkyrieTokenType("%")

    @JvmField
    val PERMILLE = ValkyrieTokenType("‰")

    @JvmField
    val PERMYRIAD = ValkyrieTokenType("‱")

    @JvmField
    val POWER = ValkyrieTokenType("^")

    @JvmField
    val EQUAL = ValkyrieTokenType("==")

    @JvmField
    val NOT_EQUAL = ValkyrieTokenType("!=")

    @JvmField
    val NOT = ValkyrieTokenType("not")

    @JvmField
    val LESS_EQUAL = ValkyrieTokenType("LESS_EQUAL") // <=

    @JvmField
    val GREATER_EQUAL = ValkyrieTokenType("GREATER_EQUAL") // >=

    // 复合赋值运算符
    @JvmField
    val PLUS_ASSIGN = ValkyrieTokenType("PLUS_ASSIGN") // +=

    @JvmField
    val MINUS_ASSIGN = ValkyrieTokenType("MINUS_ASSIGN") // -=

    @JvmField
    val MULTIPLY_ASSIGN = ValkyrieTokenType("MULTIPLY_ASSIGN") // ×=

    @JvmField
    val DIVIDE_ASSIGN = ValkyrieTokenType("DIVIDE_ASSIGN") // /=

    @JvmField
    val MODULO_ASSIGN = ValkyrieTokenType("MODULO_ASSIGN") // %=

    @JvmField
    val POWER_ASSIGN = ValkyrieTokenType("POWER_ASSIGN") // ^=

    // alias = &&
    @JvmField
    val LOGIC_AND = ValkyrieTokenType("∧")

    // alias = ||
    @JvmField
    val LOGIC_OR = ValkyrieTokenType("∨")

    @JvmField
    val LOGIC_XAND = ValkyrieTokenType("⩟")

    @JvmField
    val LOGIC_NAND = ValkyrieTokenType("⊼")

    @JvmField
    val LOGIC_XOR = ValkyrieTokenType("⊻")

    @JvmField
    val LOGIC_NOR = ValkyrieTokenType("⊽")

    @JvmField
    val PIPE = ValkyrieTokenType("|")

    @JvmField
    val AMPERSAND = ValkyrieTokenType("&")

    @JvmField
    val WOW = ValkyrieTokenType("!")

    @JvmField
    val WHAT = ValkyrieTokenType("?")

    @JvmField
    val UNDERSCORE = ValkyrieTokenType("_")

    // 分隔符
    @JvmField
    val SEMICOLON = ValkyrieTokenType(";")

    @JvmField
    val DOUBLE_SEMICOLON = ValkyrieTokenType(";;")

    @JvmField
    val COMMA = ValkyrieTokenType(",")

    @JvmField
    val DOT = ValkyrieTokenType(".")

    @JvmField
    val DOT_CIRCLE = ValkyrieTokenType("⸬")

    @JvmField
    val DOT_DOT = ValkyrieTokenType("..")

    @JvmField
    val ELLIPSIS = ValkyrieTokenType("...")

    @JvmField
    val DOT_DOT_EQUAL = ValkyrieTokenType("..=")

    @JvmField
    val DOT_DOT_LESS = ValkyrieTokenType("..<")

    @JvmField
    val COLON = ValkyrieTokenType(":")

    @JvmField
    val DOUBLE_COLON = ValkyrieTokenType("::")

    @JvmField
    val ARROW = ValkyrieTokenType("->")

    @JvmField
    val DOUBLE_ARROW = ValkyrieTokenType("=>")

    // 括号
    @JvmField
    val PARENTHESIS_L = ValkyrieTokenType("(")

    @JvmField
    val PARENTHESIS_R = ValkyrieTokenType(")")

    @JvmField
    val BRACE_L = ValkyrieTokenType("{")

    @JvmField
    val BRACE_R = ValkyrieTokenType("}")

    @JvmField
    val BRACKET_L = ValkyrieTokenType("[")

    @JvmField
    val BRACKET_R = ValkyrieTokenType("]")

    @JvmField
    val ANGLE_L = ValkyrieTokenType("<")

    @JvmField
    val ANGLE_R = ValkyrieTokenType(">")

    /** 泛型符号 ⟨T⟩ */
    @JvmField
    val GENERIC_L = ValkyrieTokenType("⟨")

    @JvmField
    val GENERIC_R = ValkyrieTokenType("⟩")

    // 注释
    @JvmField
    val COMMENT_LINE = ValkyrieTokenType("#")

    // alias = #?
    @JvmField
    val COMMENT_DOCUMENT = ValkyrieTokenType("⍝")

    @JvmField
    val COMMENT_RANGE = ValkyrieTokenType("<# #>")

    // Attributes 和 Macro 调用
    @JvmField
    val AT = ValkyrieTokenType("@")

    // alias = @^
    @JvmField
    val ATTRIBUTE_UPPER = ValkyrieTokenType("◤")

    // alias = @.
    @JvmField
    val ATTRIBUTE_LOWER = ValkyrieTokenType("↯")

    // alias = @$
    @JvmField
    val INTERNATIONAL_MARK = ValkyrieTokenType("⸿")

    // alias = @*
    @JvmField
    val LABEL_MARK = ValkyrieTokenType("※")

    @JvmField
    val TEMPLATE_L = ValkyrieTokenType("<$")

    @JvmField
    val TEMPLATE_R = ValkyrieTokenType("$>")

    @JvmField
    val TEMPLATE_START = ValkyrieTokenType("TEMPLATE_START")

    @JvmField
    val TEMPLATE_END = ValkyrieTokenType("TEMPLATE_END")

    @JvmField
    val EJS_END = ValkyrieTokenType("end")
    val VECTOR_TYPE = ValkyrieElementType("VECTOR_TYPE")
    val TABLE_ITEM = ValkyrieElementType("TABLE_ITEM")
    val TYPE_GROUP = ValkyrieElementType("GROUP_TYPE")
    val TYPE_TUPLE_ITEM = ValkyrieElementType("TUPLE_ITEM")
    val TYPE_EXPRESSION = ValkyrieElementType("TYPE_EXPRESSION")
    val PREFIX_TYPE_EXPRESSION = ValkyrieElementType("PREFIX_TYPE_EXPRESSION")
    val POSTFIX_TYPE_EXPRESSION = ValkyrieElementType("POSTFIX_TYPE_EXPRESSION")
    val GENERIC_APPLICATION_TYPE = ValkyrieElementType("GENERIC_APPLICATION_TYPE")
    val INFIX_TYPE = ValkyrieElementType("INFIX_TYPE")
    val SUBTRACTION_TYPE = ValkyrieElementType("SUBTRACTION_TYPE")
    val SUM_TYPE = ValkyrieElementType("SUM_TYPE")

    // 文件根节点
    @JvmField
    val STRING_LITERAL = ValkyrieElementType("STRING_LITERAL")

    @JvmField
    val FILE = ValkyrieElementType("FILE")

    // 通用类型
    @JvmField
    val STATEMENT = ValkyrieElementType("STATEMENT")

    @JvmField
    val EXPRESSION = ValkyrieElementType("EXPRESSION")

    @JvmField
    val PATTERN = ValkyrieElementType("PATTERN")

    @JvmField
    val BARE_PATTERN = ValkyrieElementType("BARE_PATTERN")

    @JvmField
    val TUPLE_PATTERN = ValkyrieElementType("TUPLE_PATTERN")

    @JvmField
    val TABLE_PATTERN = ValkyrieElementType("TABLE_PATTERN")

    @JvmField
    val OBJECT_PATTERN = ValkyrieElementType("OBJECT_PATTERN")

    // 语句
    @JvmField
    val LET_STATEMENT = ValkyrieElementType("LET_STATEMENT")

    @JvmField
    val TYPE_ALIAS = ValkyrieElementType("TYPE_ALIAS")

    @JvmField
    val CLASS_STATEMENT = ValkyrieElementType("CLASS_STATEMENT")

    @JvmField
    val NEURAL_STATEMENT = ValkyrieElementType("NEURAL_STATEMENT")

    @JvmField
    val WIDGET_STATEMENT = ValkyrieElementType("WIDGET_STATEMENT")

    @JvmField
    val SINGLETON_STATEMENT = ValkyrieElementType("SINGLETON_STATEMENT")

    @JvmField
    val UNION_STATEMENT = ValkyrieElementType("UNION_STATEMENT")

    @JvmField
    val UNITY_STATEMENT = ValkyrieElementType("UNITY_STATEMENT")

    @JvmField
    val FLAGS_STATEMENT = ValkyrieElementType("FLAGS_STATEMENT")

    @JvmField
    val EIDOS_STATEMENT = ValkyrieElementType("ENUMS_STATEMENT")


    @JvmField
    val TRAIT_STATEMENT = ValkyrieElementType("TRAIT_STATEMENT")

    @JvmField
    val TRAIT_ALIAS = ValkyrieElementType("TRAIT_ALIAS")

    @JvmField
    val IMPLY_STATEMENT = ValkyrieElementType("IMPLY_STATEMENT")

    @JvmField
    val CONSTRUCTOR_DECLARATION = ValkyrieElementType("CONSTRUCTOR_DECLARATION")

    @JvmField
    val CONSTRUCTOR_BODY = ValkyrieElementType("CONSTRUCTOR_BODY")

    @JvmField
    val STRUCTURE_STATEMENT = ValkyrieElementType("STRUCTURE_STATEMENT")

    @JvmField
    val NAMESPACE_STATEMENT = ValkyrieElementType("NAMESPACE_STATEMENT")

    @JvmField
    val NAMESPACE_PATH = ValkyrieElementType("NAMESPACE_PATH")

    @JvmField
    val USING_STATEMENT = ValkyrieElementType("USING_STATEMENT")

    @JvmField
    val USING_BODY = ValkyrieElementType("USING_BODY")

    @JvmField
    val USING_ITEM = ValkyrieElementType("USING_ITEM")

    @JvmField
    val EXPRESSION_STATEMENT = ValkyrieElementType("EXPRESSION_STATEMENT")

    @JvmField
    val UNTIL_STATEMENT = ValkyrieElementType("UNTIL_STATEMENT")

    @JvmField
    val WHILE_STATEMENT = ValkyrieElementType("WHILE_STATEMENT")

    @JvmField
    val WHILE_LET_STATEMENT = ValkyrieElementType("WHILE_LET_STATEMENT")

    @JvmField
    val UNTIL_NOT_STATEMENT = ValkyrieElementType("UNTIL_NOT_STATEMENT")

    @JvmField
    val MATCH_STATEMENT = ValkyrieElementType("MATCH_STATEMENT")

    @JvmField
    val MATCH_BODY = ValkyrieElementType("MATCH_BODY")

    val WHEN_CLAUSE = ValkyrieElementType("WHEN_CLAUSE")
    val TYPE_CLAUSE = ValkyrieElementType("TYPE_CLAUSE")
    val CASE_CLAUSE = ValkyrieElementType("CASE_CLAUSE")
    val ELSE_CLAUSE = ValkyrieElementType("ELSE_CLAUSE")

    @JvmField
    val INTEGER_LITERAL = ValkyrieElementType("INTEGER_LITERAL")

    @JvmField
    val DECIMAL_LITERAL = ValkyrieElementType("DECIMAL_LITERAL")

    @JvmField
    val BOOLEAN_LITERAL = ValkyrieElementType("BOOLEAN_LITERAL")

    @JvmField
    val CATCH_STATEMENT = ValkyrieElementType("CATCH_STATEMENT")

    @JvmField
    val TRY_STATEMENT = ValkyrieElementType("TRY_STATEMENT")


    @JvmField
    val IF_STATEMENT = ValkyrieElementType("IF_STATEMENT")

    @JvmField
    val IF_MAIN_PART = ValkyrieElementType("IF_MAIN_PART")

    @JvmField
    val ELSE_IF_PART = ValkyrieElementType("ELSE_IF_PART")


    @JvmField
    val ELSE_PART = ValkyrieElementType("ELSE_PART")


    @JvmField
    val IF_LET_STATEMENT = ValkyrieElementType("IF_LET_STATEMENT")

    @JvmField
    val DECLARE_TESTS = ValkyrieElementType("DECLARE_TESTS")

    // 元编程相关元素类型
    @JvmField
    val DECLARE_MICRO = ValkyrieElementType("DECLARE_MICRO")

    @JvmField
    val ASSIGN_MICRO = ValkyrieElementType("ASSIGN_MICRO")

    @JvmField
    val DECLARE_MEZZO = ValkyrieElementType("DECLARE_MEZZO")

    @JvmField
    val ASSIGN_MEZZO = ValkyrieElementType("MEZZO_DECLARATION")

    @JvmField
    val DECLARE_MACRO = ValkyrieElementType("DECLARE_MACRO")

    @JvmField
    val ASSIGN_MACRO = ValkyrieElementType("ASSIGN_MACRO")

    @JvmField
    val COMPILE_TIME_BLOCK = ValkyrieElementType("COMPILE_TIME_BLOCK")

    @JvmField
    val TEMPLATE_BLOCK = ValkyrieElementType("TEMPLATE_BLOCK")

    @JvmField
    val TEMPLATE_IF = ValkyrieElementType("TEMPLATE_IF")

    @JvmField
    val TEMPLATE_IF_MARK = ValkyrieElementType("TEMPLATE_IF_MARK")

    @JvmField
    val TEMPLATE_ELSE_IF = ValkyrieElementType("TEMPLATE_ELSE_IF")

    @JvmField
    val TEMPLATE_ELSE_IF_MARK = ValkyrieElementType("TEMPLATE_ELSE_IF_MARK")

    @JvmField
    val TEMPLATE_ELSE = ValkyrieElementType("TEMPLATE_ELSE")

    @JvmField
    val TEMPLATE_ELSE_MARK = ValkyrieElementType("TEMPLATE_ELSE_MARK")

    @JvmField
    val TEMPLATE_FOR = ValkyrieElementType("TEMPLATE_FOR")

    @JvmField
    val TEMPLATE_WHILE = ValkyrieElementType("TEMPLATE_WHILE")

    @JvmField
    val TEMPLATE_MATCH = ValkyrieElementType("TEMPLATE_MATCH")

    @JvmField
    val TEMPLATE_END_MARK = ValkyrieElementType("TEMPLATE_END_MARK")

    @JvmField
    val TEMPLATE_TEXT = ValkyrieElementType("TEMPLATE_TEXT")

    @JvmField
    val BLOCK_STATEMENT = ValkyrieElementType("BLOCK_STATEMENT")

    // 专用的body类型
    @JvmField
    val OBJECT_BODY = ValkyrieElementType("OBJECT_BODY")

    @JvmField
    val UNION_BODY = ValkyrieElementType("UNION_BODY")

    @JvmField
    val FUNCTION_BODY = ValkyrieElementType("FUNCTION_BODY")

    // 表达式
    @JvmField
    val IDENTIFIER_NODE = ValkyrieElementType("IDENTIFIER_NODE")

    @JvmField
    val LITERAL_EXPRESSION = ValkyrieElementType("LITERAL_EXPRESSION")

    @JvmField
    val BINARY_EXPRESSION = ValkyrieElementType("BINARY_EXPRESSION")

    @JvmField
    val UNARY_EXPRESSION = ValkyrieElementType("UNARY_EXPRESSION")

    @JvmField
    val PARENTHESIZED_EXPRESSION = ValkyrieElementType("PARENTHESIZED_EXPRESSION")

    @JvmField
    val TUPLE_EXPRESSION = ValkyrieElementType("TUPLE_EXPRESSION")

    @JvmField
    val NAMED_TUPLE_EXPRESSION = ValkyrieElementType("NAMED_TUPLE_EXPRESSION")

    @JvmField
    val AS_EXPRESSION = ValkyrieElementType("AS_EXPRESSION")

    @JvmField
    val CALL_EXPRESSION = ValkyrieElementType("CALL_EXPRESSION")

    @JvmField
    val CALL_TYPE_ARGUMENT = ValkyrieElementType("GENERIC_CALL_EXPRESSION")

    @JvmField
    val POSTFIX_EXPRESSION = ValkyrieElementType("POSTFIX_EXPRESSION")

    @JvmField
    val DOT_EXPRESSION = ValkyrieElementType("DOT_EXPRESSION")

    @JvmField
    val PATH_EXPRESSION = ValkyrieElementType("PATH_EXPRESSION")

    @JvmField
    val TRAILING_CLOSURE_EXPRESSION = ValkyrieElementType("TRAILING_CLOSURE_EXPRESSION")

    @JvmField
    val ARRAY_EXPRESSION = ValkyrieElementType("ARRAY_EXPRESSION")

    @JvmField
    val TABLE_EXPRESSION = ValkyrieElementType("TABLE_EXPRESSION")

    @JvmField
    val TABLE_PAIR = ValkyrieElementType("TABLE_PAIR")

    @JvmField
    val SLICE_EXPRESSION = ValkyrieElementType("SLICE_EXPRESSION")

    @JvmField
    val SLICE_ITEM = ValkyrieElementType("SLICE_ITEM")

    @JvmField
    val INDEX_EXPRESSION = ValkyrieElementType("INDEX_EXPRESSION")

    @JvmField
    val LABEL_STATEMENT = ValkyrieElementType("LABEL_STATEMENT")

    @JvmField
    val RETURN_STATEMENT = ValkyrieElementType("RETURN_STATEMENT")

    @JvmField
    val ASSERT_STATEMENT = ValkyrieElementType("ASSERT_STATEMENT")

    @JvmField
    val DEBUG_STATEMENT = ValkyrieElementType("DEBUG_STATEMENT")

    @JvmField
    val BREAK_STATEMENT = ValkyrieElementType("BREAK_STATEMENT")

    @JvmField
    val CONTINUE_STATEMENT = ValkyrieElementType("CONTINUE_STATEMENT")

    @JvmField
    val FALLTHROUGH_STATEMENT = ValkyrieElementType("FALLTHROUGH_STATEMENT")

    @JvmField
    val YIELD_STATEMENT = ValkyrieElementType("YIELD_STATEMENT")

    @JvmField
    val RAISE_STATEMENT = ValkyrieElementType("RAISE_STATEMENT")

    @JvmField
    val RESUME_STATEMENT = ValkyrieElementType("RESUME_STATEMENT")

    @JvmField
    val SCOPE_STATEMENT = ValkyrieElementType("SCOPE_STATEMENT")

    // XML 和 Slot 相关节点
    @JvmField
    val XML_SLOT_EXPRESSION = ValkyrieElementType("XML_SLOT_EXPRESSION")

    @JvmField
    val XML_TEXT_NODE = ValkyrieElementType("XML_TEXT_NODE")

    @JvmField
    val XML_ELEMENT = ValkyrieElementType("XML_ELEMENT")

    @JvmField
    val XML_SLOT_L = ValkyrieTokenType("XML_SLOT_L")

    @JvmField
    val XML_SLOT_R = ValkyrieTokenType("XML_SLOT_R")

    // SFC (Single File Component) 相关节点
    @JvmField
    val SFC_TEMPLATE = ValkyrieElementType("SFC_TEMPLATE", valkyrie.language.dialect_sfc.ValkyrieSfcLanguage.INSTANCE)

    @JvmField
    val SFC_SCRIPT = ValkyrieElementType("SFC_SCRIPT", valkyrie.language.dialect_sfc.ValkyrieSfcLanguage.INSTANCE)

    @JvmField
    val SFC_STYLE = ValkyrieElementType("SFC_STYLE", valkyrie.language.dialect_sfc.ValkyrieSfcLanguage.INSTANCE)

    @JvmField
    val SFC_COMPONENT = ValkyrieElementType("SFC_COMPONENT", valkyrie.language.dialect_sfc.ValkyrieSfcLanguage.INSTANCE)

    @JvmField
    val SLOT_STATEMENT = ValkyrieElementType("SLOT_STATEMENT")

    @JvmField
    val EACH_STATEMENT = ValkyrieElementType("FOR_STATEMENT")
    val LOOP_STATEMENT = ValkyrieElementType("LOOP_STATEMENT")

    @JvmField
    val ASSIGN_STATEMENT = ValkyrieElementType("ASSIGN_STATEMENT")

    @JvmField
    val MUTABLE_PATTERN = ValkyrieElementType("MUTABLE_PATTERN")

    // 类型
    @JvmField
    val TYPE_REFERENCE = ValkyrieElementType("TYPE_REFERENCE")

    @JvmField
    val UNION_TYPE = ValkyrieElementType("UNION_TYPE")

    @JvmField
    val INTERSECTION_TYPE = ValkyrieElementType("INTERSECTION_TYPE")

    @JvmField
    val FUNCTION_TYPE = ValkyrieElementType("FUNCTION_TYPE")

    @JvmField
    val OPTIONAL_TYPE = ValkyrieElementType("OPTIONAL_TYPE")

    @JvmField
    val ARRAY_TYPE = ValkyrieElementType("ARRAY_TYPE")

    @JvmField
    val TABLE_TYPE = ValkyrieElementType("TABLE_TYPE")

    @JvmField
    val TYPE_TUPLE_LIST = ValkyrieElementType("TUPLE_TYPE")

    @JvmField
    val PARENTHESIZED_TYPE = ValkyrieElementType("PARENTHESIZED_TYPE")

    @JvmField
    val PRIMITIVE_TYPE = ValkyrieElementType("PRIMITIVE_TYPE")

    // 类型提示和默认值相关
    @JvmField
    val TYPE_HINT = ValkyrieElementType("TYPE_HINT")

    @JvmField
    val RETURN_TYPE = ValkyrieElementType("RETURN_TYPE")

    @JvmField
    val EFFECT_TYPE = ValkyrieElementType("EFFECT_TYPE")

    @JvmField
    val DEFAULT_TYPE = ValkyrieElementType("DEFAULT_TYPE")

    @JvmField
    val DEFAULT_VALUE = ValkyrieElementType("DEFAULT_VALUE")

    // Class 和 Union 内部结构
    @JvmField
    val INHERIT_LIST = ValkyrieElementType("CLASS_INHERIT")

    @JvmField
    val INHERIT_ITEM = ValkyrieElementType("INHERIT_ITEM")

    @JvmField
    val FIELD_DECLARATION = ValkyrieElementType("FIELD_DECLARATION")

    @JvmField
    val METHOD_DECLARATION = ValkyrieElementType("METHOD_DECLARATION")

    @JvmField
    val INSTANCE_METHOD_DECLARATION = ValkyrieElementType("INSTANCE_METHOD_DECLARATION")

    @JvmField
    val STATIC_METHOD_DECLARATION = ValkyrieElementType("STATIC_METHOD_DECLARATION")

    @JvmField
    val DOMAIN_DECLARATION = ValkyrieElementType("DOMAIN_DECLARATION")

    @JvmField
    val UNION_VARIANT = ValkyrieElementType("UNION_VARIANT")

    @JvmField
    val FLAGS_ITEM = ValkyrieElementType("FLAGS_ITEM")


    // 注解节点（统一管理attributes和modifiers）
    @JvmField
    val ANNOTATION_NODE = ValkyrieElementType("ANNOTATION_NODE")

    // 修饰符
    @JvmField
    val MODIFIER_NODE = ValkyrieElementType("MODIFIER_NODE")

    // 其他
    @JvmField
    val ATTRIBUTE = ValkyrieElementType("ATTRIBUTE")

    @JvmField
    val ATTRIBUTE_LIST = ValkyrieElementType("ATTRIBUTE_LIST")

    @JvmField
    val MACRO_CALL = ValkyrieElementType("MACRO_CALL")

    @JvmField
    val ATTRIBUTE_ARGS = ValkyrieElementType("ATTRIBUTE_ARGS")

    // 其他
    @JvmField
    val TERM_PARAMETER_LIST = ValkyrieElementType("PARAMETER_LIST")

    @JvmField
    val TERM_PARAMETER_ITEM = ValkyrieElementType("PARAMETER")

    @JvmField
    val ARGUMENT_LIST = ValkyrieElementType("ARGUMENT_LIST")

    @JvmField
    val GENERIC_PARAMETER_LIST = ValkyrieElementType("GENERIC_PARAMETER_LIST")

    @JvmField
    val GENERIC_PARAMETER_ITEM = ValkyrieElementType("GENERIC_PARAMETER")


    @JvmField
    val GENERIC_ARGUMENT_LIST = ValkyrieElementType("GENERIC_ARGUMENT_LIST")

    // 注释
    @JvmField
    val DOC_COMMENT = ValkyrieElementType("DOC_COMMENT")

    // 错误元素
    @JvmField
    val ERROR_ELEMENT = ValkyrieElementType("ERROR_ELEMENT")

}
