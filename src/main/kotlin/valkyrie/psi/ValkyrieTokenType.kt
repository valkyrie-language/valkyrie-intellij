package valkyrie.psi

import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage

/**
 * Valkyrie Token 类型定义
 */
class ValkyrieTokenType(debugName: String) : IElementType(debugName, ValkyrieLanguage.INSTANCE) {
    override fun toString(): String = "ValkyrieTokenType." + super.toString()
}

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
    val FOR = ValkyrieTokenType("for")

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
    val EIDOS = ValkyrieTokenType("enums")

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
    val RETURN = ValkyrieTokenType("return")

    @JvmField
    val TESTS = ValkyrieTokenType("tests")

    @JvmField
    val MATCH = ValkyrieTokenType("match")

    @JvmField
    val CASE = ValkyrieTokenType("case")

    @JvmField
    val CATCH = ValkyrieTokenType("catch")

    @JvmField
    val TRY = ValkyrieTokenType("try")

    @JvmField
    val WHEN = ValkyrieTokenType("when")

    @JvmField
    val FALLTHROUGH = ValkyrieTokenType("fallthrough")

    // 中缀运算符
    @JvmField
    val IN = ValkyrieTokenType("in")

    @JvmField
    val NOT_IN = ValkyrieTokenType("not in")

    @JvmField
    val IS = ValkyrieTokenType("is")

    @JvmField
    val IS_NOT = ValkyrieTokenType("is not")

    @JvmField
    val AS = ValkyrieTokenType("as")

    // 标识符和字面量
    @JvmField
    val IDENTIFIER_STD = ValkyrieTokenType("IDENTIFIER.STD")

    @JvmField
    val IDENTIFIER_RAW = ValkyrieTokenType("IDENTIFIER.RAW")

    @JvmField
    val BOOLEAN = ValkyrieTokenType("BOOLEAN")

    @JvmField
    val INTEGER = ValkyrieTokenType("INTEGER")

    @JvmField
    val DECIMAL = ValkyrieTokenType("DECIMAL")

    @JvmField
    val UNIT_NUMBER = ValkyrieTokenType("NUMBER_UNIT")

    @JvmField
    val STRING = ValkyrieTokenType("STRING")

    @JvmField
    val MULTI_QUOTE_STRING = ValkyrieTokenType("MULTI_QUOTE_STRING")

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
    val LESS = ValkyrieTokenType("LESS")    // <

    @JvmField
    val GREATER = ValkyrieTokenType("GREATER") // >

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
    val ARROW = ValkyrieTokenType("->")

    @JvmField
    val DOUBLE_ARROW = ValkyrieTokenType("=>")

    // 括号
    @JvmField
    val LPAREN = ValkyrieTokenType("(")

    @JvmField
    val RPAREN = ValkyrieTokenType(")")

    @JvmField
    val LBRACE = ValkyrieTokenType("{")

    @JvmField
    val RBRACE = ValkyrieTokenType("}")

    @JvmField
    val LBRACKET = ValkyrieTokenType("[")

    @JvmField
    val RBRACKET = ValkyrieTokenType("]")

    // 泛型符号
    @JvmField
    val ANGLE_L = ValkyrieTokenType("⟨")

    @JvmField
    val ANGLE_R = ValkyrieTokenType("⟩")

    @JvmField
    val DOUBLE_COLON = ValkyrieTokenType("::")

    // 注释
    @JvmField
    val COMMENT_REST = ValkyrieTokenType("#")


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


    // 特殊标识符
    @JvmField
    val BACKTICK = ValkyrieTokenType("`")

    // 元编程模板语法 tokens
    @JvmField
    val COMPILE_TIME_BLOCK_START = ValkyrieTokenType("<{")

    @JvmField
    val COMPILE_TIME_BLOCK_END = ValkyrieTokenType("}>")

    @JvmField
    val TEMPLATE_START = ValkyrieTokenType("<$")

    @JvmField
    val TEMPLATE_END = ValkyrieTokenType("$>")

    @JvmField
    val WHITESPACE = ValkyrieTokenType("WHITESPACE")

    @JvmField
    val NEWLINE = ValkyrieTokenType("NEWLINE")

    // 错误 token
    @JvmField
    val BAD_CHARACTER = ValkyrieTokenType("BAD_CHARACTER")
}