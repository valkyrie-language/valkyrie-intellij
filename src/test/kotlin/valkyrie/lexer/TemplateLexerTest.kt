package valkyrie.lexer

import org.junit.Test
import org.junit.Assert.assertEquals
import valkyrie.psi.lexers.ValkyrieLexer
import valkyrie.psi.lexers.ValkyrieTokenTypes

class TemplateLexerTest {
    
    @Test
    fun testTemplateStartToken() {
        val lexer = ValkyrieLexer()
        lexer.start("<$", 0, 2, 0)
        
        assertEquals("Template start should be recognized as TEMPLATE_START", 
                    ValkyrieTokenTypes.TEMPLATE_L, lexer.tokenType)
        assertEquals("Token text should be '<$'", "<$", lexer.tokenText)
        assertEquals("Token start should be 0", 0, lexer.tokenStart)
        assertEquals("Token end should be 2", 2, lexer.tokenEnd)
    }
    
    @Test
    fun testTemplateEndToken() {
        val lexer = ValkyrieLexer()
        lexer.start("$>", 0, 2, 0)
        
        assertEquals("Template end should be recognized as TEMPLATE_END", 
                    ValkyrieTokenTypes.TEMPLATE_R, lexer.tokenType)
        assertEquals("Token text should be '$>'", "$>", lexer.tokenText)
        assertEquals("Token start should be 0", 0, lexer.tokenStart)
        assertEquals("Token end should be 2", 2, lexer.tokenEnd)
    }
    
    @Test
    fun testSimpleTemplateBlock() {
        val lexer = ValkyrieLexer()
        lexer.start("<$ if a > 0 $>", 0, 14, 0)
        
        // 第一个 token 应该是 TEMPLATE_START
        assertEquals("First token should be TEMPLATE_START", 
                    ValkyrieTokenTypes.TEMPLATE_L, lexer.tokenType)
        assertEquals("First token text should be '<$'", "<$", lexer.tokenText)
        
        // 前进到下一个 token
        lexer.advance()
        
        // 应该是空白符
        assertEquals("Second token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // 前进到 if
        lexer.advance()
        assertEquals("Third token should be IF", 
                    ValkyrieTokenTypes.IF, lexer.tokenType)
        assertEquals("Third token text should be 'if'", "if", lexer.tokenText)
    }
}