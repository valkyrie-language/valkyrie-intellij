package valkyrie.ide.highlight


import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase.pack
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ParserDefinition
import valkyrie.psi.ValkyrieTypes.*

class TokenHighlighter : SyntaxHighlighter {
    override fun getHighlightingLexer(): Lexer {
        return ParserDefinition.Instance.lexer()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): HighlightColor? {
        return when (tokenType) {
            KW_NAMESPACE, KW_USING, KW_AS, KW_EXCLUDE,
            KW_TYPE,
            KW_ENUMERATE, KW_FLAGS,
            KW_CLASS, KW_COMPONENT, KW_UNION,
            KW_UNITE,
            KW_TRAIT, KW_IMPLY, KW_FROM,
            KW_FUNCTION, KW_MACRO, KW_LET, KW_LAMBDA, KW_NEW, KW_OBJECT,
            -> HighlightColor.KEYWORD

            KW_IF, KW_ELSE, KW_THROUGH,
            KW_LOOP, KW_WHILE, KW_UNTIL,
            KW_FOR, KW_IN,
            KW_RETURN, KW_RESUME, KW_BREAK, KW_CONTINUE, KW_YIELD, KW_RAISE,
            KW_TRY, KW_MATCH, KW_WITH, KW_CASE, KW_WHEN,
            KW_IS, KW_NOT,
            KW_BOOLEAN, KW_NULL, KW_NIL,
            -> HighlightColor.KEYWORD
            // operations
            COLON, EQUAL, BIND, STAR,
            OP_OR, OP_UNTIL,
            OP_EE, OP_NE,
            OP_PLUS, OP_AND_THEN,
            OP_CELSIUS, OP_FAHRENHEIT,
            -> HighlightColor.OPERATION
            // literals
            STRING_L, STRING_TEXT, STRING_R -> HighlightColor.STRING
            ESCAPED -> HighlightColor.STRING_ESCAPED
            INTEGER -> HighlightColor.INTEGER
            // comments
            COMMENT_LINE -> HighlightColor.COMMENT_LINE
            COMMENT_BLOCK -> HighlightColor.COMMENT_BLOCK
            // errors
//            TokenType.BAD_CHARACTER -> YggdrasilHighlightColor.BAD_CHARACTER

            else -> null
        }
    }
}
