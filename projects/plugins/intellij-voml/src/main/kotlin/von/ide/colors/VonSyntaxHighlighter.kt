package von.ide.colors

import von.language.lexer.VonLexer
import von.language.psi.VonTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class VonSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return VonLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): VonColor? {
        return when (tokenType) {
            VonTypes.INCLUDE, VonTypes.INHERIT, VonTypes.AS -> VonColor.KEYWORD
            VonTypes.ANNOTATION, VonTypes.ANNOTATION_MARK -> VonColor.ANNOTATION
            VonTypes.PREDEFINED_SYMBOL -> VonColor.PREDEFINED
            VonTypes.STRING_PREFIX -> VonColor.STRING_HINT
            VonTypes.NUMBER_SUFFIX -> VonColor.NUMBER_HINT
            VonTypes.TYPE_HINT -> VonColor.TYPE_HINT
            VonTypes.BACK_TOP, VonTypes.ANGLE_L, VonTypes.ANGLE_R, VonTypes.ACCENT -> VonColor.SCOPE_MARK
            VonTypes.INSERT_DOT, VonTypes.INSERT_STAR -> VonColor.INSERT_MARK
            VonTypes.PARENTHESIS_L, VonTypes.PARENTHESIS_R -> VonColor.PARENTHESES
            VonTypes.BRACKET_L, VonTypes.BRACKET_R -> VonColor.BRACKETS
            VonTypes.BRACE_L, VonTypes.BRACE_R -> VonColor.BRACES
            VonTypes.COLON, VonTypes.EQ -> VonColor.SET
            VonTypes.COMMA -> VonColor.COMMA
            VonTypes.NULL -> VonColor.NULL
            VonTypes.BOOLEAN -> VonColor.BOOLEAN
            VonTypes.INTEGER -> VonColor.INTEGER
            VonTypes.DECIMAL, VonTypes.DECIMAL_BAD -> VonColor.DECIMAL
            VonTypes.STRING, VonTypes.STRING_INLINE, VonTypes.STRING_MULTI -> VonColor.STRING
            VonTypes.SYMBOL -> getSymbolColor(tokenType)
            VonTypes.COMMENT -> VonColor.LINE_COMMENT
            VonTypes.BLOCK_COMMENT -> VonColor.BLOCK_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> VonColor.BAD_CHARACTER
            else -> null
        }
    }

    private fun getSymbolColor(symbol: IElementType): VonColor? {
        return null
    }
}
