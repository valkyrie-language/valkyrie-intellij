package valkyrie.ide.highlight


import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.ide.matcher.ValkyrieBracketMatch
import valkyrie.language.antlr.ValkyrieLexer
import valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class TokenHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): ValkyrieHighlightColor? {
        return when {
            ValkyrieLexer.Keywords.contains(tokenType) -> Color.KEYWORD
            ValkyrieLexer.Operators.contains(tokenType) -> Color.OPERATION_SIGN
            ValkyrieLexer.Integers.contains(tokenType) -> Color.INTEGER
            ValkyrieLexer.Decimals.contains(tokenType) -> Color.DECIMAL
            ValkyrieLexer.Strings.contains(tokenType) -> Color.STRING
            else -> {
                when (tokenType) {
                    ValkyrieLexer.CommentLine -> Color.LINE_COMMENT
                    ValkyrieLexer.CommentBlock -> Color.BLOCK_COMMENT
                    ValkyrieBracketMatch.Instance.ParenthesisL, ValkyrieBracketMatch.Instance.ParenthesisR -> Color.PARENTHESES
                    ValkyrieBracketMatch.Instance.BracketL, ValkyrieBracketMatch.Instance.BracketR -> Color.BRACKETS
                    ValkyrieBracketMatch.Instance.BraceL, ValkyrieBracketMatch.Instance.BraceR -> Color.BRACES
                    //
//                    COLON, OP_SET -> Color.ASSIGN
//                    OP_AT, OP_HASH -> Color.SYM_MACRO
                    ValkyrieLexer.Comma -> Color.COMMA
                    ValkyrieLexer.Semicolon -> Color.SEMICOLON
                    // 原子类型
//                    BYTE -> Color.INTEGER
//                    COLOUR -> Color.INTEGER
//                    NUMBER_SUFFIX -> Color.OP_NUMBER
                    // 错误
                    TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
                    else -> null
                }
            }
        }
    }
}
