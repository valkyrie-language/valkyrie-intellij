package valkyrie.lexer

import org.junit.Test
import org.junit.Assert.assertEquals
import valkyrie.psi.lexers.ValkyrieStringLexer
import valkyrie.psi.lexers.ValkyrieTokenTypes

class ValkyrieStringLexerTest {
    
    @Test
    fun testBasicStringText() {
        val lexer = ValkyrieStringLexer()
        lexer.start("Hello, World!", 0, 13, 0)
        
        // 第一个 token 应该是 STRING_TEXT
        assertEquals("First token should be STRING_TEXT", 
                    ValkyrieTokenTypes.STRING_TEXT, lexer.tokenType)
        assertEquals("String text should be 'Hello, World!'", "Hello, World!", lexer.tokenText)
        assertEquals("Token start should be 0", 0, lexer.tokenStart)
        assertEquals("Token end should be 13", 13, lexer.tokenEnd)
    }
    
    @Test
    fun testSimpleInterpolation() {
        val lexer = ValkyrieStringLexer()
        lexer.start("Hello, {name}!", 0, 14, 0)
        
        // 第一个 token 应该是 STRING_TEXT "Hello, "
        assertEquals("First token should be STRING_TEXT", 
                    ValkyrieTokenTypes.STRING_TEXT, lexer.tokenType)
        assertEquals("First text should be 'Hello, '", "Hello, ", lexer.tokenText)
        
        // 前进到下一个 token
        lexer.advance()
        
        // 应该是 BRACE_L
        assertEquals("Second token should be BRACE_L", 
                    ValkyrieTokenTypes.BRACE_L, lexer.tokenType)
        assertEquals("Brace text should be '{'", "{", lexer.tokenText)
        
        // 前进到变量名
        lexer.advance()
        assertEquals("Third token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Variable name should be 'name'", "name", lexer.tokenText)
        
        // 前进到 BRACE_R
        lexer.advance()
        assertEquals("Fourth token should be BRACE_R", 
                    ValkyrieTokenTypes.BRACE_R, lexer.tokenType)
        assertEquals("Closing brace text should be '}'", "}", lexer.tokenText)
        
        // 前进到剩余文本
        lexer.advance()
        assertEquals("Fifth token should be STRING_TEXT", 
                    ValkyrieTokenTypes.STRING_TEXT, lexer.tokenType)
        assertEquals("Remaining text should be '!'", "!", lexer.tokenText)
    }
    
    @Test
    fun testNestedInterpolation() {
        val lexer = ValkyrieStringLexer()
        lexer.start("Result: {calculate(a, {b + c})}", 0, 32, 0)
        
        // "Result: "
        assertEquals("First token should be STRING_TEXT", 
                    ValkyrieTokenTypes.STRING_TEXT, lexer.tokenType)
        assertEquals("First text should be 'Result: '", "Result: ", lexer.tokenText)
        
        // {
        lexer.advance()
        assertEquals("Second token should be BRACE_L", 
                    ValkyrieTokenTypes.BRACE_L, lexer.tokenType)
        
        // calculate
        lexer.advance()
        assertEquals("Third token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Function name should be 'calculate'", "calculate", lexer.tokenText)
        
        // (
        lexer.advance()
        assertEquals("Fourth token should be PARENTHESIS_L", 
                    ValkyrieTokenTypes.PARENTHESIS_L, lexer.tokenType)
        
        // a
        lexer.advance()
        assertEquals("Fifth token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("First parameter should be 'a'", "a", lexer.tokenText)
        
        // ,
        lexer.advance()
        assertEquals("Sixth token should be COMMA", 
                    ValkyrieTokenTypes.COMMA, lexer.tokenType)
        
        // 空白符
        lexer.advance()
        assertEquals("Seventh token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // 内层 {
        lexer.advance()
        assertEquals("Eighth token should be BRACE_L", 
                    ValkyrieTokenTypes.BRACE_L, lexer.tokenType)
        
        // b
        lexer.advance()
        assertEquals("Ninth token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Variable b should be 'b'", "b", lexer.tokenText)
        
        // 空白符
        lexer.advance()
        assertEquals("Tenth token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // +
        lexer.advance()
        assertEquals("Eleventh token should be PLUS", 
                    ValkyrieTokenTypes.PLUS, lexer.tokenType)
        
        // 空白符
        lexer.advance()
        assertEquals("Twelfth token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // c
        lexer.advance()
        assertEquals("Thirteenth token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Variable c should be 'c'", "c", lexer.tokenText)
        
        // 内层 }
        lexer.advance()
        assertEquals("Fourteenth token should be BRACE_R", 
                    ValkyrieTokenTypes.BRACE_R, lexer.tokenType)
        
        // )
        lexer.advance()
        assertEquals("Fifteenth token should be PARENTHESIS_R", 
                    ValkyrieTokenTypes.PARENTHESIS_R, lexer.tokenType)
        
        // 外层 }
        lexer.advance()
        assertEquals("Sixteenth token should be BRACE_R", 
                    ValkyrieTokenTypes.BRACE_R, lexer.tokenType)
    }
    
    @Test
    fun testComplexExpression() {
        val lexer = ValkyrieStringLexer()
        lexer.start("Items: {items.map(item => \"Item: {item.name}\")}", 0, 48, 0)
        
        // "Items: "
        assertEquals("First token should be STRING_TEXT", 
                    ValkyrieTokenTypes.STRING_TEXT, lexer.tokenType)
        assertEquals("First text should be 'Items: '", "Items: ", lexer.tokenText)
        
        // {
        lexer.advance()
        assertEquals("Second token should be BRACE_L", 
                    ValkyrieTokenTypes.BRACE_L, lexer.tokenType)
        
        // items
        lexer.advance()
        assertEquals("Third token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Object name should be 'items'", "items", lexer.tokenText)
        
        // .
        lexer.advance()
        assertEquals("Fourth token should be DOT", 
                    ValkyrieTokenTypes.DOT, lexer.tokenType)
        
        // map
        lexer.advance()
        assertEquals("Fifth token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Method name should be 'map'", "map", lexer.tokenText)
        
        // (
        lexer.advance()
        assertEquals("Sixth token should be PARENTHESIS_L", 
                    ValkyrieTokenTypes.PARENTHESIS_L, lexer.tokenType)
        
        // item
        lexer.advance()
        assertEquals("Seventh token should be IDENTIFIER", 
                    ValkyrieTokenTypes.IDENTIFIER, lexer.tokenType)
        assertEquals("Parameter name should be 'item'", "item", lexer.tokenText)
        
        // 空白符
        lexer.advance()
        assertEquals("Eighth token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // =>
        lexer.advance()
        assertEquals("Ninth token should be ARROW", 
                    ValkyrieTokenTypes.ARROW, lexer.tokenType)
        
        // 空白符
        lexer.advance()
        assertEquals("Tenth token should be WHITE_SPACE", 
                    com.intellij.psi.TokenType.WHITE_SPACE, lexer.tokenType)
        
        // "Item: {item.name}"
        lexer.advance()
        assertEquals("Eleventh token should be STRING", 
                    ValkyrieTokenTypes.STRING, lexer.tokenType)
        assertEquals("String literal should contain nested interpolation", 
                    "\"Item: {item.name}\"", lexer.tokenText)
    }
    
    @Test
    fun testEmptyInterpolation() {
        val lexer = ValkyrieStringLexer()
        lexer.start("Before{}After", 0, 13, 0)
        
        // "Before"
        assertEquals("First token should be STRING_TEXT", 
                    ValkyrieTokenTypes.STRING_TEXT, lexer.tokenType)
        assertEquals("First text should be 'Before'", "Before", lexer.tokenText)
        
        // {
        lexer.advance()
        assertEquals("Second token should be BRACE_L", 
                    ValkyrieTokenTypes.BRACE_L, lexer.tokenType)
        
        // }
        lexer.advance()
        assertEquals("Third token should be BRACE_R", 
                    ValkyrieTokenTypes.BRACE_R, lexer.tokenType)
        
        // "After"
        lexer.advance()
        assertEquals("Fourth token should be STRING_TEXT", 
                    ValkyrieTokenTypes.STRING_TEXT, lexer.tokenType)
        assertEquals("Last text should be 'After'", "After", lexer.tokenText)
    }
}