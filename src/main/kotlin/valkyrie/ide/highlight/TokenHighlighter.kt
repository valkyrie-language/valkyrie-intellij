package valkyrie.ide.highlight


import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import valkyrie.ide.matcher.ValkyrieBracketMatch
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrLexer
import valkyrie.language.antlr.ValkyrieLexer


class TokenHighlighter : SyntaxHighlighter {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        val key = getTokenColor(tokenType);
        return if (key == null) {
            TextAttributesKey.EMPTY_ARRAY
        } else {
            arrayOf(key)
        }
    }

    private fun getTokenColor(tokenType: IElementType): TextAttributesKey? {
        val hash = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieAntlrLexer.OP_HASH, ValkyrieAntlrLexer.OP_AT);
        return when {
            ValkyrieLexer.Keywords.contains(tokenType) -> ValkyrieHighlightColor.KEYWORD.textAttributesKey
            ValkyrieLexer.Operators.contains(tokenType) -> DefaultLanguageHighlighterColors.OPERATION_SIGN
            ValkyrieLexer.MacroOperators.contains(tokenType) -> ValkyrieHighlightColor.SYM_MACRO.textAttributesKey
            ValkyrieLexer.Integers.contains(tokenType) -> ValkyrieHighlightColor.INTEGER.textAttributesKey
            ValkyrieLexer.Decimals.contains(tokenType) -> ValkyrieHighlightColor.DECIMAL.textAttributesKey
            ValkyrieLexer.Strings.contains(tokenType) -> ValkyrieHighlightColor.STRING.textAttributesKey
            ValkyrieLexer.Comments.contains(tokenType) -> DefaultLanguageHighlighterColors.LINE_COMMENT
            // inherit
            ValkyrieLexer.Comma.contains(tokenType) -> DefaultLanguageHighlighterColors.COMMA
            ValkyrieLexer.Semicolon.contains(tokenType) -> DefaultLanguageHighlighterColors.SEMICOLON

            else -> {
                when (tokenType) {
                    ValkyrieBracketMatch.Instance.ParenthesisL, ValkyrieBracketMatch.Instance.ParenthesisR -> DefaultLanguageHighlighterColors.PARENTHESES
                    ValkyrieBracketMatch.Instance.BracketL, ValkyrieBracketMatch.Instance.BracketR -> DefaultLanguageHighlighterColors.BRACKETS
                    ValkyrieBracketMatch.Instance.BraceL, ValkyrieBracketMatch.Instance.BraceR -> DefaultLanguageHighlighterColors.BRACES
                    //
//                    COLON, OP_SET -> ValkyrieHighlightColor.ASSIGN
                    // 原子类型
//                    BYTE -> ValkyrieHighlightColor.INTEGER
//                    COLOUR -> ValkyrieHighlightColor.INTEGER
//                    NUMBER_SUFFIX -> ValkyrieHighlightColor.OP_NUMBER
                    // 错误
                    TokenType.BAD_CHARACTER -> com.intellij.openapi.editor.HighlighterColors.BAD_CHARACTER
                    else -> null
                }
            }
        }
    }
}
