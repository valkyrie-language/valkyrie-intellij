package valkyrie.ide.highlight


import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import valkyrie.language.lexer.ValkyrieLexerAdapter
import valkyrie.language.psi.ValkyrieTokenType
import valkyrie.language.psi.ValkyrieTypes.*
import valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class TokenHighlight : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType) = when {
        ValkyrieTokenType.isKeyword(tokenType) -> Color.KEYWORD
        ValkyrieTokenType.isOperator(tokenType) -> Color.OPERATION_SIGN
        else -> {
            when (tokenType) {
                //
                PARENTHESIS_L, PARENTHESIS_R -> Color.PARENTHESES
                BRACKET_L, BRACKET_R -> Color.BRACKETS
                BRACE_L, BRACE_R -> Color.BRACES
                COLON, OP_SET -> Color.SET
                // STAR -> Color.STAR
                COMMA -> Color.COMMA
                // 原子类型
                INTEGER -> Color.INTEGER
                BYTE -> Color.INTEGER
                DECIMAL -> Color.DECIMAL
                STRING_START, STRING_TEXT, STRING_END -> Color.STRING
                SYMBOL_XID, SYMBOL_RAW -> Color.IDENTIFIER
                // 注释
                COMMENT -> Color.BLOCK_COMMENT
                // 错误
                TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
                else -> null

            }
        }
    }
}
