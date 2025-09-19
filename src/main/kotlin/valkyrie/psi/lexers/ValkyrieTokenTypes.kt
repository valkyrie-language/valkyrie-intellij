package valkyrie.psi.lexers

import com.intellij.psi.tree.TokenSet
import com.intellij.psi.xml.XmlTokenType

/**
 * Valkyrie 所有 Token 类型
 */
object ValkyrieTokenTypes {


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

    @JvmField
    val MICRO = ValkyrieTokenType("micro")

    @JvmField
    val MEZZO = ValkyrieTokenType("mezzo")

    @JvmField
    val MACRO = ValkyrieTokenType("macro")

    @JvmField
    val CLASS = ValkyrieTokenType("class")

    @JvmField
    val NEURAL = ValkyrieTokenType("neural")

    @JvmField
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
    val TESTS = ValkyrieTokenType("tests")

    @JvmField
    val TRY = ValkyrieTokenType("try")

    @JvmField
    val MATCH = ValkyrieTokenType("match")

    @JvmField
    val CATCH = ValkyrieTokenType("catch")

    @JvmField
    val CASE = ValkyrieTokenType("case")


    @JvmField
    val WHEN = ValkyrieTokenType("when")

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
    val SYMBOL_XID = ValkyrieTokenType("SYMBOL.STD")

    @JvmField
    val SYMBOL_RAW = ValkyrieTokenType("SYMBOL.RAW")

    @JvmField
    val BOOLEAN = ValkyrieTokenType("BOOLEAN")

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
    val TEMPLATE_TEXT = ValkyrieTokenType("TEMPLATE_TEXT")


    // Mark 方言相关 Token
    @JvmField
    val MARK_TEXT = ValkyrieTokenType("MARK_TEXT")

    // Vue 方言相关 Token
    @JvmField
    val SCRIPT_CONTENT = ValkyrieTokenType("SCRIPT_CONTENT")

    @JvmField
    val STYLE_CONTENT = ValkyrieTokenType("STYLE_CONTENT")

    @JvmField
    val END = ValkyrieTokenType("end")

    @JvmField
    val XML_STYLE = ValkyrieTokenType("XML_KEYWORD_STYLE")

    @JvmField
    val XML_SCRIPT = ValkyrieTokenType("XML_KEYWORD_SCRIPT")

    @JvmField
    val XML_TEMPLATE = ValkyrieTokenType("XML_KEYWORD_TEMPLATE")

    val XML_SLOT_L = XmlTokenType.XML_ATTRIBUTE_VALUE_START_DELIMITER
    val XML_SLOT_R = XmlTokenType.XML_ATTRIBUTE_VALUE_END_DELIMITER

    val XML_TEXT = ValkyrieTokenType("XML_TEXT")

    val SFC_PROPERTY = ValkyrieTokenType("SFC_PROPS")
    val SFC_EMITS = ValkyrieTokenType("SFC_EMITS")
}