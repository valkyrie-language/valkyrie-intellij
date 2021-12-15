package valkyrie.ide.highlight


import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieLexer
import valkyrie.language.psi.ValkyrieTokenType
import valkyrie.language.psi.ValkyrieTypes.*
import valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class TokenHighlight : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        val lexer = ValkyrieLexer(null)
        return ANTLRLexerAdaptor(ValkyrieLanguage, lexer)
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): ValkyrieHighlightColor? {
        return when {
            ValkyrieTokenType.isKeyword(tokenType) -> Color.KEYWORD
            ValkyrieTokenType.isOperator(tokenType) -> Color.OPERATION_SIGN
            else -> {
                when (tokenType) {
                    //
                    PARENTHESIS_L, PARENTHESIS_R -> Color.PARENTHESES
                    BRACKET_L, BRACKET_R -> Color.BRACKETS
                    BRACE_L, BRACE_R -> Color.BRACES
                    COLON, OP_SET -> Color.SET
                    OP_AT, OP_HASH -> Color.SYM_MACRO
                    // STAR -> Color.STAR
                    COMMA -> Color.COMMA
                    // 原子类型
                    INTEGER -> Color.INTEGER
                    BYTE -> Color.INTEGER
                    DECIMAL -> Color.DECIMAL
                    COLOUR -> Color.INTEGER
                    NUMBER_SUFFIX -> Color.OP_NUMBER
                    STRING_START, STRING_TEXT, STRING_END -> Color.STRING
                    SYMBOL_XID, SYMBOL_RAW -> Color.IDENTIFIER
                    // 注释
                    COMMENT_LINE, COMMENT_BLOCK -> Color.BLOCK_COMMENT
                    // 错误
                    TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
                    else -> null
                }
            }
        }
    }
}
