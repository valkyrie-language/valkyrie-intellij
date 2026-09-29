package awsl.editing.highlight

import awsl.surface.file.AwslLexerAdapter
import awsl.surface.psi.AwslTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import awsl.editing.highlight.AwslHighlightColor as Color

class AwslHighlightToken : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return awsl.surface.file.AwslLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    /// only TOKEN works!!!
    private fun getTokenColor(tokenType: IElementType): Color? {
        return when (tokenType) {
            //
            // AS, SCHEMA, PROP -> JssColor.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            AwslTypes.FOR, AwslTypes.IN, AwslTypes.IF, AwslTypes.ELSE -> Color.KEYWORD
            AwslTypes.HTML_TAG_RAW, AwslTypes.HTML_TAG_SCRIPT, AwslTypes.HTML_TAG_DIRECTIVE -> Color.KEYWORD_TAG
            AwslTypes.BOOLEAN -> Color.BOOLEAN
            //
            AwslTypes.PARENTHESIS_L, AwslTypes.PARENTHESIS_R -> Color.PARENTHESES
            AwslTypes.BRACKET_L, AwslTypes.BRACKET_R -> Color.BRACKETS
            AwslTypes.BRACE_L, AwslTypes.BRACE_R -> Color.BRACES
            AwslTypes.COLON, AwslTypes.EQ -> Color.SET
            AwslTypes.COMMA -> Color.COMMA
            // atom
            AwslTypes.INTEGER -> Color.INTEGER
            AwslTypes.DECIMAL -> Color.DECIMAL
            AwslTypes.NUMBER_UNIT -> Color.NUM_HINT
            //URL -> JssColor.URL
            AwslTypes.STRING -> Color.STRING
            AwslTypes.SYMBOL -> Color.IDENTIFIER
            // 模板
            AwslTypes.HTML_END_L, AwslTypes.HTML_START_CODE_L, AwslTypes.HTML_START_TEXT_L -> Color.HTML_BEGIN
            AwslTypes.HTML_END_R, AwslTypes.HTML_START_R, AwslTypes.HTML_SELF_END_R -> Color.HTML_END
            AwslTypes.HTML_TAG_SYMBOL -> Color.HTML_TAG
            AwslTypes.HTML_STRING, AwslTypes.HTML_STRING_TOKEN -> Color.HTML_TEXT
            AwslTypes.HTML_ESCAPE_TOKEN -> Color.HTML_ESCAPE
            // 注释
            AwslTypes.COMMENT_LINE -> Color.LINE_COMMENT
            AwslTypes.COMMENT_BLOCK -> Color.BLOCK_COMMENT
            AwslTypes.COMMENT_DOCUMENT -> Color.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
            else -> null
        }
    }
}
