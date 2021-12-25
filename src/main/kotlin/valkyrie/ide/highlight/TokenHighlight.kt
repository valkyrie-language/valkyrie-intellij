package valkyrie.ide.highlight


import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.lexer.ValkyrieProgramLexer
import valkyrie.language.psi.ValkyrieTokenType
import valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class TokenHighlight : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieProgramLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): ValkyrieHighlightColor? {
        return when {
            ValkyrieTokenType.isKeyword(tokenType) -> Color.KEYWORD
            ValkyrieTokenType.isOperator(tokenType) -> Color.OPERATION_SIGN
            ValkyrieProgramLexer.Integers.contains(tokenType) -> Color.INTEGER
            ValkyrieProgramLexer.Decimals.contains(tokenType) -> Color.DECIMAL
            else -> {
                when (tokenType) {
                    ValkyrieProgramLexer.CommentLine-> Color.LINE_COMMENT
                    ValkyrieProgramLexer.CommentBlock -> Color.BLOCK_COMMENT
                    //
//                    PARENTHESIS_L, PARENTHESIS_R -> Color.PARENTHESES
//                    BRACKET_L, BRACKET_R -> Color.BRACKETS
//                    BRACE_L, BRACE_R -> Color.BRACES
//                    COLON, OP_SET -> Color.ASSIGN
//                    OP_AT, OP_HASH -> Color.SYM_MACRO
                    // STAR -> Color.STAR
//                    COMMA -> Color.COMMA
                    // 原子类型
//                    BYTE -> Color.INTEGER
//                    COLOUR -> Color.INTEGER
//                    NUMBER_SUFFIX -> Color.OP_NUMBER
//                    STRING_START, STRING_TEXT, STRING_END -> Color.STRING
//                    SYMBOL_XID, SYMBOL_RAW -> Color.IDENTIFIER
                    // 错误
                    TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
                    else -> null
                }
            }
        }
    }
}
