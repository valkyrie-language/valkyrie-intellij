package valkyrie.lexer

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import valkyrie.psi.ValkyrieLexer
import valkyrie.psi.ValkyrieTokenTypes

class EmptyStringTest : BasePlatformTestCase() {
    
    fun testEmptyStringLiteral() {
        val lexer = ValkyrieLexer()
        
        // 测试空字符串
        lexer.start("\"\"", 0, 2, 0)
        lexer.advance()
        
        assertEquals("Empty string should be recognized as STRING token", 
                    ValkyrieTokenTypes.STRING, lexer.tokenType)
        assertEquals("Token text should be \"\"", "\"\"", lexer.tokenText)
        assertEquals("Token start should be 0", 0, lexer.tokenStart)
        assertEquals("Token end should be 2", 2, lexer.tokenEnd)
    }
    
    fun testEmptyCharLiteral() {
        val lexer = ValkyrieLexer()
        
        // 测试空字符字面量
        lexer.start("''", 0, 2, 0)
        lexer.advance()
        
        assertEquals("Empty char literal should be recognized as STRING token", 
                    ValkyrieTokenTypes.STRING, lexer.tokenType)
        assertEquals("Token text should be ''", "''", lexer.tokenText)
        assertEquals("Token start should be 0", 0, lexer.tokenStart)
        assertEquals("Token end should be 2", 2, lexer.tokenEnd)
    }
    
    fun testStringWithContent() {
        val lexer = ValkyrieLexer()
        
        // 测试有内容的字符串
        lexer.start("\"hello\"", 0, 7, 0)
        lexer.advance()
        
        assertEquals("String with content should be recognized as STRING token", 
                    ValkyrieTokenTypes.STRING, lexer.tokenType)
        assertEquals("Token text should be \"hello\"", "\"hello\"", lexer.tokenText)
        assertEquals("Token start should be 0", 0, lexer.tokenStart)
        assertEquals("Token end should be 7", 7, lexer.tokenEnd)
    }
    
    fun testMultipleTokens() {
        val lexer = ValkyrieLexer()
        
        // 测试多个token：let empty = "";
        lexer.start("let empty = \"\"", 0, 14, 0)
        
        // 第一个token: let
        lexer.advance()
        assertEquals(ValkyrieTokenTypes.LET, lexer.tokenType)
        
        // 跳过空白
        lexer.advance()
        assertEquals(ValkyrieTokenTypes.WHITESPACE, lexer.tokenType)
        
        // 第二个token: empty
        lexer.advance()
        assertEquals(ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("empty", lexer.tokenText)
        
        // 跳过空白
        lexer.advance()
        assertEquals(ValkyrieTokenTypes.WHITESPACE, lexer.tokenType)
        
        // 第三个token: =
        lexer.advance()
        assertEquals(ValkyrieTokenTypes.ASSIGN, lexer.tokenType)
        
        // 跳过空白
        lexer.advance()
        assertEquals(ValkyrieTokenTypes.WHITESPACE, lexer.tokenType)
        
        // 第四个token: ""
        lexer.advance()
        assertEquals("Empty string should be recognized as STRING token", 
                    ValkyrieTokenTypes.STRING, lexer.tokenType)
        assertEquals("Token text should be \"\"", "\"\"", lexer.tokenText)
    }
}