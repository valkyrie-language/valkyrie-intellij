package valkyrie.ide.highlight

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ValkyrieParserDefinition
import valkyrie.psi.ValkyrieTokenTypes

class ValkyrieSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieParserDefinition().createLexer(null)
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): ValkyrieColor? {
        return when (tokenType) {
            ValkyrieTokenTypes.NAMESPACE,
            ValkyrieTokenTypes.USING,
            ValkyrieTokenTypes.LET,
            ValkyrieTokenTypes.IF,
            ValkyrieTokenTypes.ELSE,
            ValkyrieTokenTypes.WHILE,
            ValkyrieTokenTypes.UNTIL,
            ValkyrieTokenTypes.FOR,
            ValkyrieTokenTypes.LOOP,
            ValkyrieTokenTypes.FUNCTION,
            ValkyrieTokenTypes.CLASS,
            ValkyrieTokenTypes.NEURAL,
            ValkyrieTokenTypes.WIDGET,
            ValkyrieTokenTypes.UNION,
            ValkyrieTokenTypes.UNITY,
            ValkyrieTokenTypes.TRAIT,
            ValkyrieTokenTypes.IMPLY,
            ValkyrieTokenTypes.STRUCTURE,
            ValkyrieTokenTypes.SINGLETON,
            ValkyrieTokenTypes.FLAGS,
            ValkyrieTokenTypes.BREAK,
            ValkyrieTokenTypes.CONTINUE,
            ValkyrieTokenTypes.YIELD,
            ValkyrieTokenTypes.RAISE,
            ValkyrieTokenTypes.RESUME,
            ValkyrieTokenTypes.RETURN,
            ValkyrieTokenTypes.TESTS,
            ValkyrieTokenTypes.TEST,
            ValkyrieTokenTypes.MICRO,
            ValkyrieTokenTypes.MEZZO,
            ValkyrieTokenTypes.MACRO,
            ValkyrieTokenTypes.MATCH,
            ValkyrieTokenTypes.CASE,
            ValkyrieTokenTypes.WHEN,
            ValkyrieTokenTypes.FALLTHROUGH,
            ValkyrieTokenTypes.TRY,
            ValkyrieTokenTypes.CATCH,
            ValkyrieTokenTypes.IN,
            ValkyrieTokenTypes.AS
                -> ValkyrieColor.KEYWORD

            // 操作符
            ValkyrieTokenTypes.IS,
            ValkyrieTokenTypes.IS_NOT,
            ValkyrieTokenTypes.NOT_IN
                -> ValkyrieColor.OPERATION

            ValkyrieTokenTypes.LPAREN, ValkyrieTokenTypes.RPAREN -> ValkyrieColor.PARENTHESES
            ValkyrieTokenTypes.LBRACKET, ValkyrieTokenTypes.RBRACKET -> ValkyrieColor.BRACKETS
            ValkyrieTokenTypes.LBRACE, ValkyrieTokenTypes.RBRACE -> ValkyrieColor.BRACES
            ValkyrieTokenTypes.COMPILE_TIME_BLOCK_START, ValkyrieTokenTypes.COMPILE_TIME_BLOCK_END -> ValkyrieColor.COMPILE_TIME_BLOCK
            ValkyrieTokenTypes.TEMPLATE_START, ValkyrieTokenTypes.TEMPLATE_END -> ValkyrieColor.TEMPLATE_BLOCK
            ValkyrieTokenTypes.COLON, ValkyrieTokenTypes.ASSIGN -> ValkyrieColor.OPERATION
            ValkyrieTokenTypes.DOT_DOT, ValkyrieTokenTypes.ELLIPSIS, ValkyrieTokenTypes.DOT_DOT_EQUAL, ValkyrieTokenTypes.DOT_DOT_LESS -> ValkyrieColor.OPERATION
            ValkyrieTokenTypes.AT -> ValkyrieColor.OPERATION
            ValkyrieTokenTypes.LABEL_MARK -> ValkyrieColor.OPERATION

            ValkyrieTokenTypes.COMMA -> ValkyrieColor.COMMA
            // 数字和字面量
            ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL, ValkyrieTokenTypes.UNIT_NUMBER -> ValkyrieColor.NUMBER
            ValkyrieTokenTypes.STRING, ValkyrieTokenTypes.MULTI_QUOTE_STRING -> ValkyrieColor.STRING
            ValkyrieTokenTypes.BOOLEAN -> ValkyrieColor.KEYWORD

            ValkyrieTokenTypes.IDENTIFIER_STD -> ValkyrieColor.IDENTIFIER
            // 注释
            ValkyrieTokenTypes.COMMENT_REST -> ValkyrieColor.LINE_COMMENT
            ValkyrieTokenTypes.COMMENT_RANGE -> ValkyrieColor.BLOCK_COMMENT
            ValkyrieTokenTypes.COMMENT_DOCUMENT -> ValkyrieColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> ValkyrieColor.BAD_CHARACTER
            else -> null
        }
    }
}