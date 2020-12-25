package com.github.valkyrie.ide.highlight


import com.github.valkyrie.language.psi.ValkyrieLexerAdapter
import com.github.valkyrie.language.psi.FluentTypes.*
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.github.valkyrie.ide.highlight.VkHighlightColor as VColor

class FluentSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): VColor? {
        return when (tokenType) {
            //
            IF, ELSE, FOR, IN, WHILE -> VColor.KEYWORD
            // ANNOTATION -> JssColor.ANNOTATION
            //
            PARENTHESIS_L, PARENTHESIS_R -> VColor.PARENTHESES
            BRACKET_L, BRACKET_R -> VColor.BRACKETS
            BRACE_L, BRACE_R -> VColor.BRACES
            COLON, EQ -> VColor.SET
            STAR -> VColor.STAR
            COMMA -> VColor.COMMA
            // atom
            INTEGER -> VColor.INTEGER
            DECIMAL -> VColor.DECIMAL

            STRING_QUOTE, STRING_CHAR -> VColor.STRING
            STRING_ESCAPE -> VColor.STRING_ESCAPED
//            STRING -> AwslColor.STRING
            SYMBOL -> VColor.IDENTIFIER
            // 注释
            COMMENT_LINE -> VColor.LINE_COMMENT
//            COMMENT_BLOCK -> AwslColor.BLOCK_COMMENT
//            COMMENT_DOCUMENT -> AwslColor.DOC_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> VColor.BAD_CHARACTER
            else -> null
        }
    }
}
