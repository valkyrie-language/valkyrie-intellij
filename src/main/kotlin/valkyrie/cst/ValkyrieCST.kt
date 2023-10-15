package valkyrie.cst

import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage

// leaf node of the lexer stream
class ValkyrieCST(show: String) : IElementType(show, ValkyrieLanguage) {
    override fun toString(): String = "CST<${super.toString()}>"
}

// 括号
val LBRACE = ValkyrieCST("{")
val RBRACE = ValkyrieCST("}")
val BRACKET_L = ValkyrieCST("[")
val BRACKET_R = ValkyrieCST("]")
val PARENTHESIS_L = ValkyrieCST("(")
val PARENTHESIS_R = ValkyrieCST(")")

// 分隔符
val COLON = ValkyrieCST(":")
val COMMA = ValkyrieCST(",")
val OP_MACRO_UPPER = ValkyrieCST("◤")
val OP_MACRO_LOWER = ValkyrieCST("↯")
val OP_MACRO = ValkyrieCST("@")
val OP_LEQ = ValkyrieCST("⩽")
val OP_LE = ValkyrieCST("<")
val OP_GEQ = ValkyrieCST("⩾")
val OP_GE = ValkyrieCST(">")
val DOT = ValkyrieCST(".")
val EQ = ValkyrieCST("=")
val SEMICOLON = ValkyrieCST(";")

// 软关键字
val KW_CLASS = ValkyrieCST("CLASS")
val KW_TRAIT = ValkyrieCST("TRAIT")
val KW_UNION = ValkyrieCST("UNION")
val KW_UNITE = ValkyrieCST("UNITE")
val KW_NEURAL = ValkyrieCST("NEURAL")
val KW_SINGLETON = ValkyrieCST("SINGLETON")
val KW_COMPONENT = ValkyrieCST("COMPONENT")
val KW_ENUMERATE = ValkyrieCST("ENUMERATE")
val KW_FLAGS = ValkyrieCST("FLAGS")


val KW_MICRO = ValkyrieCST("MICRO")
val KW_MEZZO = ValkyrieCST("MEZZO")
val KW_MACRO = ValkyrieCST("MACRO")

//
val KW_FROM = ValkyrieCST("FROM")

// 基本类型
val STRING = ValkyrieCST("STRING")
val NUMBER = ValkyrieCST("NUMBER")
val SYMBOL = ValkyrieCST("SYMBOL")
val SYMBOL_RAW = ValkyrieCST("SYMBOL<RAW>")

// 其他
val COMMENT_LINE_HEAD = ValkyrieCST("COMMENT_#")
val COMMENT_LINE_TEXT = ValkyrieCST("COMMENT_LINE_TEXT")
val COMMENT_BLOCK = ValkyrieCST("COMMENT<BLOCK>")

// 终止符
val EOF = ValkyrieCST("EOF")