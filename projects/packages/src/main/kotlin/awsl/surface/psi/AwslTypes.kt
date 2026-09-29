package awsl.surface.psi

import awsl.surface.psi.nodes.*
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType

/**
 * AWSL 语言的 Token 和 PSI 元素类型定义
 */
object AwslTypes {

    // PSI Element Types
    val BRACE_BLOCK = AwslElementType("BRACE_BLOCK")
    val DICT = AwslElementType("DICT")
    val ELSE_STATEMENT = AwslElementType("ELSE_STATEMENT")
    val FOR_STATEMENT = AwslElementType("FOR_STATEMENT")
    val GENERIC = AwslElementType("GENERIC")
    val GENERIC_ITEM = AwslElementType("GENERIC_ITEM")
    val HTML_CODE = AwslElementType("HTML_CODE")
    val HTML_END = AwslElementType("HTML_END")
    val HTML_ESCAPE = AwslElementType("HTML_ESCAPE")
    val HTML_KEY = AwslElementType("HTML_KEY")
    val HTML_KV = AwslElementType("HTML_KV")
    val HTML_SELF_CLOSE = AwslElementType("HTML_SELF_CLOSE")
    val HTML_START_CODE = AwslElementType("HTML_START_CODE")
    val HTML_START_TEXT = AwslElementType("HTML_START_TEXT")
    val HTML_STRING = AwslElementType("HTML_STRING")
    val HTML_TAG = AwslElementType("HTML_TAG")
    val HTML_TEXT = AwslElementType("HTML_TEXT")
    val HTML_DIRECTIVE_COND = AwslElementType("HTML_DIRECTIVE_COND")
    val IF_STATEMENT = AwslElementType("IF_STATEMENT")
    val KEY = AwslElementType("KEY")
    val LIST = AwslElementType("LIST")
    val NUMBER_LITERAL = AwslElementType("NUMBER_LITERAL")
    val PAIR = AwslElementType("PAIR")
    val PATTERN = AwslElementType("PATTERN")
    val STRING_LITERAL = AwslElementType("STRING_LITERAL")
    val VALUE = AwslElementType("VALUE")

    // Token Types
    val ACCENT = AwslTokenType("^")
    val AT = AwslTokenType("@")
    val BRACE_L = AwslTokenType("{")
    val BRACE_R = AwslTokenType("}")
    val BRACKET_L = AwslTokenType("[")
    val BRACKET_R = AwslTokenType("]")
    val COLON = AwslTokenType(":")
    val COMMA = AwslTokenType(",")
    val COMMENT_BLOCK = AwslTokenType("Comment Block")
    val COMMENT_DOCUMENT = AwslTokenType("Comment Document")
    val COMMENT_HTML = AwslTokenType("Comment in HTML")
    val COMMENT_LINE = AwslTokenType("Comment Line")
    val DECIMAL = AwslTokenType("DECIMAL")
    val DOLLAR = AwslTokenType("$")
    val DOT = AwslTokenType(".")
    val ELSE = AwslTokenType("ELSE")
    val EQ = AwslTokenType("=")
    val FOR = AwslTokenType("Keyword for")
    val GENERIC_L = AwslTokenType("<")
    val GENERIC_R = AwslTokenType(">")
    val HTML_END_L = AwslTokenType("HTML_END_L")
    val HTML_END_R = AwslTokenType("HTML_END_R")
    val HTML_ESCAPE_TOKEN = AwslTokenType("HTML_ESCAPE_TOKEN")
    val HTML_SELF_END_R = AwslTokenType("HTML_SELF_END_R")
    val HTML_START_CODE_L = AwslTokenType("HTML_START_CODE_L")
    val HTML_START_R = AwslTokenType("HTML_START_R")
    val HTML_START_TEXT_L = AwslTokenType("HTML_START_TEXT_L")
    val HTML_STRING_TOKEN = AwslTokenType("HTML_STRING_TOKEN")
    val HTML_TAG_DIRECTIVE = AwslTokenType("HTML_TAG_DIRECTIVE")
    val HTML_TAG_RAW = AwslTokenType("HTML_TAG_RAW")
    val HTML_TAG_SCRIPT = AwslTokenType("HTML_TAG_SCRIPT")
    val HTML_TAG_SYMBOL = AwslTokenType("HTML_TAG_SYMBOL")
    val BOOLEAN = AwslTokenType("BOOLEAN")
    val BANG = AwslTokenType("!")
    val LT = AwslTokenType("<")
    val GT = AwslTokenType(">")
    val OR_OR = AwslTokenType("||")
    val AND_AND = AwslTokenType("&&")
    val IF = AwslTokenType("IF")
    val IN = AwslTokenType("Keyword in")
    val INTEGER = AwslTokenType("INTEGER")
    val MINUS = AwslTokenType("-")
    val NAME_JOIN = AwslTokenType("::")
    val NUMBER_UNIT = AwslTokenType("NUMBER_UNIT")
    val PARENTHESIS_L = AwslTokenType("(")
    val PARENTHESIS_R = AwslTokenType(")")
    val SEMICOLON = AwslTokenType(";")
    val STAR = AwslTokenType("*")
    val STRING = AwslTokenType("STRING")
    val SYMBOL = AwslTokenType("Symbol")
    val WHILE = AwslTokenType("Keyword while")

    /**
     * PSI 元素工厂
     */
    object Factory {
        @JvmStatic
        fun createElement(node: ASTNode): PsiElement {
            val type = node.elementType
            return when (type) {
                BRACE_BLOCK -> AwslBraceBlockNode(node)
                DICT -> AwslDictNode(node)
                ELSE_STATEMENT -> AwslElseStatementNode(node)
                FOR_STATEMENT -> AwslForStatementNode(node)
                GENERIC -> AwslGenericNode(node)
                GENERIC_ITEM -> AwslGenericItemNode(node)
                HTML_CODE -> AwslHtmlCodeNode(node)
                HTML_END -> AwslHtmlEndNode(node)
                HTML_ESCAPE -> AwslHtmlEscapeNode(node)
                HTML_KEY -> AwslHtmlKeyNode(node)
                HTML_KV -> AwslHtmlKvNode(node)
                HTML_SELF_CLOSE -> AwslHtmlSelfCloseNode(node)
                HTML_START_CODE -> AwslHtmlStartCodeNode(node)
                HTML_START_TEXT -> AwslHtmlStartTextNode(node)
                HTML_DIRECTIVE_COND -> AwslHtmlDirectiveCondNode(node)
                HTML_STRING -> AwslHtmlStringNode(node)
                HTML_TAG -> AwslHtmlTagNode(node)
                HTML_TEXT -> AwslHtmlTextNode(node)
                IF_STATEMENT -> AwslIfStatementNode(node)
                KEY -> AwslKeyNode(node)
                LIST -> AwslListNode(node)
                NUMBER_LITERAL -> AwslNumberLiteralNode(node)
                PAIR -> AwslPairNode(node)
                PATTERN -> AwslPatternNode(node)
                STRING_LITERAL -> AwslStringLiteralNode(node)
                VALUE -> AwslValueNode(node)
                else -> throw AssertionError("Unknown element type: $type")
            }
        }
    }
}
