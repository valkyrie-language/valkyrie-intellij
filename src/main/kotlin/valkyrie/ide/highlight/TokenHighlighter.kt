package valkyrie.ide.highlight


import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase.pack
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ParserDefinition
import valkyrie.psi.ParserExtension
import valkyrie.psi.ValkyrieLexer
import valkyrie.psi.ValkyrieTypes.*

class TokenHighlighter : SyntaxHighlighter {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): HighlightColor? {
        if (ParserExtension.Operators.contains(tokenType)) {
            return HighlightColor.OPERATION
        } else if (ParserExtension.Keywords.contains(tokenType)) {
            return HighlightColor.KEYWORD
        } else {
            return when (tokenType) {
                OP_BASE, OP_EXPONENT -> HighlightColor.KEYWORD
                // operations
                COLON, EQUAL, BIND, STAR, KW_THEN -> HighlightColor.OPERATION
                // literals
                STRING_L, STRING_TEXT, STRING_R -> HighlightColor.STRING
                ESCAPED -> HighlightColor.STRING_ESCAPED
                DECIMAL -> HighlightColor.DECIMAL
                INTEGER -> HighlightColor.INTEGER
//                KW_NEW, KW_OBJECT, KW_LAMBDA, DOLLAR -> HighlightColor.SYM_MACRO
                NUMBER_SUFFIX -> HighlightColor.SYM_MACRO
                TEMPLATE_L, TEMPLATE_R, KW_END -> HighlightColor.SYM_MACRO
                NUMBER_BASE -> HighlightColor.STRING
                NUMBER_EXPONENT -> HighlightColor.STRING_ESCAPED
                // comments
                COMMENT_LINE -> HighlightColor.COMMENT_LINE
                COMMENT_BLOCK -> HighlightColor.COMMENT_BLOCK
                // errors
//                TokenType.BAD_CHARACTER -> BAD_CHARACTER
                else -> null
            }
        }
    }
}
