package vos.intellij.ide.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import vos.intellij.language.psi.JssLexerAdapter
import vos.intellij.language.psi.VosTypes.*


class HighlightToken : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return JssLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): VosColor? {
        return when (tokenType) {
            //
            KW_NAMESPACE, KW_LET, KW_DEFINE, KW_CLASS, KW_UNION -> VosColor.KEYWORD
            //
            ANGLE_L, ANGLE_R , LEQ , GEQ , EQ -> VosColor.OPERATOR
            ANNOTATION_MARK -> VosColor.SYM_ANNO
            PARENTHESIS_L, PARENTHESIS_R -> VosColor.PARENTHESES
            BRACKET_L, BRACKET_R -> VosColor.BRACKETS
            BRACE_L, BRACE_R -> VosColor.BRACES
            COLON -> VosColor.SET
            COMMA -> VosColor.COMMA
            // atom
            INTEGER -> VosColor.INTEGER
            DECIMAL -> VosColor.DECIMAL
            URL -> VosColor.URL
            STRING -> VosColor.STRING
            SYMBOL -> VosColor.IDENTIFIER
            // 注释
            COMMENT -> VosColor.LINE_COMMENT
            COMMENT_BLOCK -> VosColor.BLOCK_COMMENT
            COMMENT_DOCUMENT -> VosColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> VosColor.BAD_CHARACTER
            else -> null
        }
    }
}
