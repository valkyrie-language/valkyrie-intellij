package valkyrie.cst

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import valkyrie.language.ValkyrieLanguage

// leaf node of the lexer stream
class ValkyrieCST(show: String) : IElementType(show, ValkyrieLanguage) {
    override fun toString(): String = "${ValkyrieCST::class.simpleName}<${super.toString()}>"

    companion object {
        val COLON = ValkyrieCST(":")
        val COMMA = ValkyrieCST(",")
        val OP_MACRO_UPPER = ValkyrieCST("◤")
        val OP_MACRO_LOWER = ValkyrieCST("↯")
        val OP_MACRO = ValkyrieCST("@")
        val DOT = ValkyrieCST(".")
        val EQ = ValkyrieCST("=")
        val SEMICOLON = ValkyrieCST(";")

        // 基本类型
        val STRING = ValkyrieCST("STRING")
        val NUMBER = ValkyrieCST("NUMBER")
        val SYMBOL = ValkyrieCST("SYMBOL")
        val SYMBOL_RAW = ValkyrieCST("SYMBOL<RAW>")

        // 其他
        val WHITE_SPACE = ValkyrieCST("WHITE_SPACE")
        val BAD_CHARACTER = ValkyrieCST("BAD_CHARACTER")
        val COMMENT_LINE = ValkyrieCST("COMMENT<LINE>")
        val COMMENT_BLOCK = ValkyrieCST("COMMENT<BLOCK>")
        val EOF = ValkyrieCST("EOF")


        //
        val DOMAIN = ValkyrieCST("DOMAIN")
        val FIELD = ValkyrieCST("FIELD")
        val METHOD = ValkyrieCST("METHOD")
        val OBJECT = ValkyrieCST("OBJECT")

        // 词法单元集合
        val Comments = TokenSet.create(COMMENT_LINE, COMMENT_BLOCK)
        val WhiteSpaces = TokenSet.create(WHITE_SPACE)
        val STRING_LITERALS = TokenSet.create(STRING)
        val IDENTIFIERS = TokenSet.create(SYMBOL, SYMBOL_RAW)
        val KEYWORDS = TokenSet.create(KW_TRAIT, KW_CLASS, OBJECT) // 软关键字集合
    }
}

// 标点符号
val LBRACE = ValkyrieCST("{")
val RBRACE = ValkyrieCST("}")
val LBRACK = ValkyrieCST("[")
val RBRACK = ValkyrieCST("]")
val PARENTHESIS_L = ValkyrieCST("(")
val PARENTHESIS_R = ValkyrieCST(")")

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
//
val KW_FROM = ValkyrieCST("FROM")
