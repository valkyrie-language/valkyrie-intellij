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
            ValkyrieTokenTypes.MUT,
            ValkyrieTokenTypes.REF,
            ValkyrieTokenTypes.IF,
            ValkyrieTokenTypes.ELSE,
            ValkyrieTokenTypes.WHILE,
            ValkyrieTokenTypes.FOR,
            ValkyrieTokenTypes.FUNCTION,
            ValkyrieTokenTypes.CLASS,
            ValkyrieTokenTypes.UNION,
            ValkyrieTokenTypes.TRAIT,
            ValkyrieTokenTypes.BREAK,
            ValkyrieTokenTypes.CONTINUE,
            ValkyrieTokenTypes.YIELD,
            ValkyrieTokenTypes.RAISE,
            ValkyrieTokenTypes.RETURN
                -> ValkyrieColor.KEYWORD

            ValkyrieTokenTypes.LPAREN, ValkyrieTokenTypes.RPAREN -> ValkyrieColor.PARENTHESES
            ValkyrieTokenTypes.LBRACKET, ValkyrieTokenTypes.RBRACKET -> ValkyrieColor.BRACKETS
            ValkyrieTokenTypes.LBRACE, ValkyrieTokenTypes.RBRACE -> ValkyrieColor.BRACES
            ValkyrieTokenTypes.COLON, ValkyrieTokenTypes.ASSIGN -> ValkyrieColor.OPERATION
            ValkyrieTokenTypes.AT -> ValkyrieColor.OPERATION

            ValkyrieTokenTypes.COMMA -> ValkyrieColor.COMMA
            // 数字和字面量
            ValkyrieTokenTypes.INTEGER, ValkyrieTokenTypes.DECIMAL -> ValkyrieColor.NUMBER
            ValkyrieTokenTypes.STRING -> ValkyrieColor.STRING
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