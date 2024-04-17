package valkyrie.lexer

import org.junit.Test
import org.junit.Assert.assertEquals
import valkyrie.psi.lexers.ValkyrieComponentLexer
import valkyrie.psi.lexers.ValkyrieTokenTypes

class ValkyrieComponentLexerTest {
    
    @Test
    fun testBasicXmlTag() {
        val lexer = ValkyrieComponentLexer()
        lexer.start("<div>", 0, 5, 0)
        
        // 第一个 token 应该是 ANGLE_L
        assertEquals("First token should be ANGLE_L", 
                    ValkyrieTokenTypes.ANGLE_L, lexer.tokenType)
        assertEquals("First token text should be '<'", "<", lexer.tokenText)
        
        // 前进到下一个 token
        lexer.advance()
        
        // 应该是标识符 div
        assertEquals("Second token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Second token text should be 'div'", "div", lexer.tokenText)
        
        // 前进到下一个 token
        lexer.advance()
        
        // 应该是 ANGLE_R
        assertEquals("Third token should be ANGLE_R", 
                    ValkyrieTokenTypes.ANGLE_R, lexer.tokenType)
        assertEquals("Third token text should be '>'", ">", lexer.tokenText)
    }
    
    @Test
    fun testVoidTag() {
        val lexer = ValkyrieComponentLexer()
        lexer.start("<br/>", 0, 5, 0)
        
        // 第一个 token 应该是 ANGLE_L
        assertEquals("First token should be ANGLE_L", 
                    ValkyrieTokenTypes.ANGLE_L, lexer.tokenType)
        
        // 前进到 br
        lexer.advance()
        assertEquals("Second token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Second token text should be 'br'", "br", lexer.tokenText)
        
        // 前进到 /
        lexer.advance()
        assertEquals("Third token should be SLASH", 
                    ValkyrieTokenTypes.SLASH, lexer.tokenType)
        
        // 前进到 >
        lexer.advance()
        assertEquals("Fourth token should be ANGLE_R", 
                    ValkyrieTokenTypes.ANGLE_R, lexer.tokenType)
    }
    
    @Test
    fun testTagWithAttributes() {
        val lexer = ValkyrieComponentLexer()
        lexer.start("<div class=\"container\">", 0, 23, 0)
        
        // <
        assertEquals("First token should be ANGLE_L", 
                    ValkyrieTokenTypes.ANGLE_L, lexer.tokenType)
        
        // div
        lexer.advance()
        assertEquals("Second token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Tag name should be 'div'", "div", lexer.tokenText)
        
        // 空白符
        lexer.advance()
        assertEquals("Third token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // class
        lexer.advance()
        assertEquals("Fourth token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Attribute name should be 'class'", "class", lexer.tokenText)
        
        // =
        lexer.advance()
        assertEquals("Fifth token should be ASSIGN", 
                    ValkyrieTokenTypes.ASSIGN, lexer.tokenType)
        
        // "container"
        lexer.advance()
        assertEquals("Sixth token should be STRING", 
                    ValkyrieTokenTypes.STRING, lexer.tokenType)
        assertEquals("String value should be '\"container\"'", "\"container\"", lexer.tokenText)
        
        // >
        lexer.advance()
        assertEquals("Seventh token should be ANGLE_R", 
                    ValkyrieTokenTypes.ANGLE_R, lexer.tokenType)
    }
    
    @Test
    fun testTagWithInterpolation() {
        val lexer = ValkyrieComponentLexer()
        lexer.start("<div>{title}</div>", 0, 18, 0)
        
        // <div>
        assertEquals("First token should be ANGLE_L", 
                    ValkyrieTokenTypes.ANGLE_L, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Second token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Tag name should be 'div'", "div", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Third token should be ANGLE_R", 
                    ValkyrieTokenTypes.ANGLE_R, lexer.tokenType)
        
        // {
        lexer.advance()
        assertEquals("Fourth token should be BRACE_L", 
                    ValkyrieTokenTypes.BRACE_L, lexer.tokenType)
        
        // title
        lexer.advance()
        assertEquals("Fifth token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Variable name should be 'title'", "title", lexer.tokenText)
        
        // }
        lexer.advance()
        assertEquals("Sixth token should be BRACE_R", 
                    ValkyrieTokenTypes.BRACE_R, lexer.tokenType)
        
        // </div>
        lexer.advance()
        assertEquals("Seventh token should be ANGLE_L", 
                    ValkyrieTokenTypes.ANGLE_L, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Eighth token should be SLASH", 
                    ValkyrieTokenTypes.SLASH, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Ninth token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Closing tag name should be 'div'", "div", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Tenth token should be ANGLE_R", 
                    ValkyrieTokenTypes.ANGLE_R, lexer.tokenType)
    }
    
    @Test
    fun testNestedTags() {
        val lexer = ValkyrieComponentLexer()
        lexer.start("<div><span>text</span></div>", 0, 28, 0)
        
        // <div>
        assertEquals("First token should be ANGLE_L", 
                    ValkyrieTokenTypes.ANGLE_L, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Second token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Outer tag name should be 'div'", "div", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Third token should be ANGLE_R", 
                    ValkyrieTokenTypes.ANGLE_R, lexer.tokenType)
        
        // <span>
        lexer.advance()
        assertEquals("Fourth token should be ANGLE_L", 
                    ValkyrieTokenTypes.ANGLE_L, lexer.tokenType)
        
        lexer.advance()
        assertEquals("Fifth token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Inner tag name should be 'span'", "span", lexer.tokenText)
        
        lexer.advance()
        assertEquals("Sixth token should be ANGLE_R", 
                    ValkyrieTokenTypes.ANGLE_R, lexer.tokenType)
        
        // text (应该被识别为 XML_TEXT)
        lexer.advance()
        assertEquals("Seventh token should be XML_TEXT", 
                    ValkyrieTokenTypes.XML_TEXT, lexer.tokenType)
        assertEquals("Text content should be 'text'", "text", lexer.tokenText)
    }
}