package com.github.valkyrie.ide.highlight


import com.github.valkyrie.language.psi.ValkyrieLexerAdapter
import com.github.valkyrie.language.psi.FluentTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class FluentSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): VkHighlightColor? {
        return when (tokenType) {
            //
            IF, ELSE -> VkHighlightColor.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            //
            PARENTHESIS_L, PARENTHESIS_R -> VkHighlightColor.PARENTHESES
            BRACKET_L, BRACKET_R -> VkHighlightColor.BRACKETS
            BRACE_L, BRACE_R -> VkHighlightColor.BRACES
            COLON, EQ -> VkHighlightColor.SET
            STAR -> VkHighlightColor.STAR
            COMMA -> VkHighlightColor.COMMA
            // atom
            INTEGER -> VkHighlightColor.INTEGER
            DECIMAL -> VkHighlightColor.DECIMAL

            STRING_QUOTE, STRING_CHAR -> VkHighlightColor.STRING
            STRING_ESCAPE -> VkHighlightColor.STRING_ESCAPED
//            STRING -> AwslColor.STRING
            SYMBOL -> VkHighlightColor.IDENTIFIER
            // 注释
            COMMENT_LINE -> VkHighlightColor.LINE_COMMENT
//            COMMENT_BLOCK -> AwslColor.BLOCK_COMMENT
//            COMMENT_DOCUMENT -> AwslColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> VkHighlightColor.BAD_CHARACTER
            else -> null
        }
    }
}
