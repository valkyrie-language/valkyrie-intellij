package valkyrie.highlighting

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import valkyrie.psi.ValkyrieLexer
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Valkyrie 语法高亮器
 */
class ValkyrieSyntaxHighlighter : SyntaxHighlighterBase() {
    
    companion object {
        // 定义高亮颜色
        val KEYWORD = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD
        )
        
        val STRING = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_STRING",
            DefaultLanguageHighlighterColors.STRING
        )
        
        val NUMBER = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER
        )
        
        val COMMENT = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT
        )
        
        val IDENTIFIER = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_IDENTIFIER",
            DefaultLanguageHighlighterColors.IDENTIFIER
        )
        
        val OPERATOR = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_OPERATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN
        )
        
        val PARENTHESES = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_PARENTHESES",
            DefaultLanguageHighlighterColors.PARENTHESES
        )
        
        val BRACES = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_BRACES",
            DefaultLanguageHighlighterColors.BRACES
        )
        
        val BRACKETS = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_BRACKETS",
            DefaultLanguageHighlighterColors.BRACKETS
        )
        
        val SEMICOLON = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_SEMICOLON",
            DefaultLanguageHighlighterColors.SEMICOLON
        )
        
        val COMMA = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_COMMA",
            DefaultLanguageHighlighterColors.COMMA
        )
        
        val DOT = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_DOT",
            DefaultLanguageHighlighterColors.DOT
        )
        
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey(
            "VALKYRIE_BAD_CHARACTER",
            HighlighterColors.BAD_CHARACTER
        )
    }
    
    override fun getHighlightingLexer(): Lexer = ValkyrieLexer()
    
    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            // 关键字
            ValkyrieTokenTypes.KW_LET,
            ValkyrieTokenTypes.KW_IF,
            ValkyrieTokenTypes.KW_ELSE,
            ValkyrieTokenTypes.KW_WHILE,
            ValkyrieTokenTypes.KW_FOR,
            ValkyrieTokenTypes.KW_FUNCTION,
            ValkyrieTokenTypes.KW_RETURN,
            ValkyrieTokenTypes.KW_TRUE,
            ValkyrieTokenTypes.KW_FALSE,
            ValkyrieTokenTypes.KW_NULL -> arrayOf(KEYWORD)
            
            // 字符串
            ValkyrieTokenTypes.STRING -> arrayOf(STRING)
            
            // 数字
            ValkyrieTokenTypes.INTEGER,
            ValkyrieTokenTypes.DECIMAL -> arrayOf(NUMBER)
            
            // 注释
            ValkyrieTokenTypes.LINE_COMMENT,
            ValkyrieTokenTypes.BLOCK_COMMENT -> arrayOf(COMMENT)
            
            // 标识符
            ValkyrieTokenTypes.IDENTIFIER -> arrayOf(IDENTIFIER)
            
            // 操作符
            ValkyrieTokenTypes.PLUS,
            ValkyrieTokenTypes.MINUS,
            ValkyrieTokenTypes.MULTIPLY,
            ValkyrieTokenTypes.DIVIDE,
            ValkyrieTokenTypes.MODULO,
            ValkyrieTokenTypes.ASSIGN,
            ValkyrieTokenTypes.EQUAL,
            ValkyrieTokenTypes.NOT_EQUAL,
            ValkyrieTokenTypes.LESS_THAN,
            ValkyrieTokenTypes.GREATER_THAN,
            ValkyrieTokenTypes.LESS_EQUAL,
            ValkyrieTokenTypes.GREATER_EQUAL,
            ValkyrieTokenTypes.LOGICAL_AND,
            ValkyrieTokenTypes.LOGICAL_OR,
            ValkyrieTokenTypes.LOGICAL_NOT -> arrayOf(OPERATOR)
            
            // 括号
            ValkyrieTokenTypes.LEFT_PAREN,
            ValkyrieTokenTypes.RIGHT_PAREN -> arrayOf(PARENTHESES)
            
            // 大括号
            ValkyrieTokenTypes.LEFT_BRACE,
            ValkyrieTokenTypes.RIGHT_BRACE -> arrayOf(BRACES)
            
            // 方括号
            ValkyrieTokenTypes.LEFT_BRACKET,
            ValkyrieTokenTypes.RIGHT_BRACKET -> arrayOf(BRACKETS)
            
            // 分号
            ValkyrieTokenTypes.SEMICOLON -> arrayOf(SEMICOLON)
            
            // 逗号
            ValkyrieTokenTypes.COMMA -> arrayOf(COMMA)
            
            // 点
            ValkyrieTokenTypes.DOT -> arrayOf(DOT)
            
            // 错误字符
            TokenType.BAD_CHARACTER -> arrayOf(BAD_CHARACTER)
            
            else -> emptyArray()
        }
    }
}