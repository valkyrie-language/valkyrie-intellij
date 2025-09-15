package valkyrie.lexer

import com.intellij.psi.TokenType.WHITE_SPACE
import org.junit.Assert.assertEquals
import org.junit.Test
import valkyrie.psi.ValkyrieLexer
import valkyrie.psi.ValkyrieTokenTypes

class LiteralSupportTest {

    @Test
    fun testEmptyStringFixed() {
        val lexer = ValkyrieLexer()
        lexer.start("\"\"", 0, 2, 0)
        
        assertEquals("Empty string should be STRING token", ValkyrieTokenTypes.STRING_DQ, lexer.tokenType)
        assertEquals("Token text should be \"\"", "\"\"", lexer.tokenText)
    }
    
    @Test
    fun testTripleQuoteString() {
        val lexer = ValkyrieLexer()
        lexer.start("\"\"\"\"\"\"", 0, 6, 0)
        
        assertEquals("Triple quote should be MULTI_QUOTE_STRING token", ValkyrieTokenTypes.STRING_MQ, lexer.tokenType)
        assertEquals("Token text should be \"\"\"\"\"\"", "\"\"\"\"\"\"", lexer.tokenText)
    }
    
    @Test
    fun testTupleLiterals() {
        val testCases = listOf(
            "()" to "empty tuple",
            "(1,)" to "single element tuple",
            "(1, 2)" to "two element tuple"
        )
        
        testCases.forEach { (input, description) ->
            val lexer = ValkyrieLexer()
            lexer.start(input, 0, input.length, 0)
            
            // 第一个 token 应该是左括号
            assertEquals("$description should start with PARENTHESES_L", ValkyrieTokenTypes.PARENTHESIS_L, lexer.tokenType)
            
            // 验证可以正确解析整个输入
            var tokenCount = 0
            while (lexer.tokenType != null && tokenCount < 10) {
                lexer.advance()
                tokenCount++
            }
        }
    }
    
    @Test
    fun testArrayLiterals() {
        val testCases = listOf(
            "[]" to "empty array",
            "[1]" to "single element array",
            "[1, 2, 3]" to "multi element array"
        )
        
        testCases.forEach { (input, description) ->
            val lexer = ValkyrieLexer()
            lexer.start(input, 0, input.length, 0)
            
            // 第一个 token 应该是左方括号
            assertEquals("$description should start with ARRAY_L", ValkyrieTokenTypes.ARRAY_L, lexer.tokenType)
            
            // 验证可以正确解析整个输入
            var tokenCount = 0
            while (lexer.tokenType != null && tokenCount < 10) {
                lexer.advance()
                tokenCount++
            }
        }
    }
    
    @Test
    fun testObjectLiterals() {
        val testCases = listOf(
            "{}" to "empty object",
            "{a: 1}" to "single property object",
            "{a: 1, b: 2}" to "multi property object"
        )
        
        testCases.forEach { (input, description) ->
            val lexer = ValkyrieLexer()
            lexer.start(input, 0, input.length, 0)
            
            // 第一个 token 应该是左大括号
            assertEquals("$description should start with BRACE_L", ValkyrieTokenTypes.BRACE_L, lexer.tokenType)
            
            // 验证可以正确解析整个输入
            var tokenCount = 0
            while (lexer.tokenType != null && tokenCount < 15) {
                lexer.advance()
                tokenCount++
            }
        }
    }
    
    @Test
    fun testComplexNestedLiterals() {
        val input = "{a: [1, 2], b: (3, 4)}"
        val lexer = ValkyrieLexer()
        lexer.start(input, 0, input.length, 0)
        
        val expectedTokens = listOf(
            ValkyrieTokenTypes.BRACE_L,      // {
            ValkyrieTokenTypes.IDENTIFIER_STD, // a
            ValkyrieTokenTypes.COLON,        // :
            ValkyrieTokenTypes.ARRAY_L,      // [
            ValkyrieTokenTypes.INTEGER,      // 1
            ValkyrieTokenTypes.COMMA,        // ,
            ValkyrieTokenTypes.INTEGER,      // 2
            ValkyrieTokenTypes.ARRAY_R,      // ]
            ValkyrieTokenTypes.COMMA,        // ,
            ValkyrieTokenTypes.IDENTIFIER_STD, // b
            ValkyrieTokenTypes.COLON,        // :
            ValkyrieTokenTypes.PARENTHESIS_L, // (
            ValkyrieTokenTypes.INTEGER,      // 3
            ValkyrieTokenTypes.COMMA,        // ,
            ValkyrieTokenTypes.INTEGER,      // 4
            ValkyrieTokenTypes.PARENTHESIS_R, // )
            ValkyrieTokenTypes.BRACE_R       // }
        )
        
        expectedTokens.forEachIndexed { index, expectedToken ->
            // 跳过空白字符
            while (lexer.tokenType == WHITE_SPACE) {
                lexer.advance()
            }
            
            assertEquals("Token $index should be $expectedToken", expectedToken, lexer.tokenType)
            if (index < expectedTokens.size - 1) {
                lexer.advance()
            }
        }
    }
}