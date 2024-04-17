package valkyrie.lexer

import org.junit.Test
import valkyrie.test.ValkyrieLexerTestCase
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * Valkyrie 基础词法分析器测试
 * 测试基本的 token 识别功能
 */
class ValkyrieBasicLexerTest : ValkyrieLexerTestCase() {
    
    @Test
    fun testKeywords() {
        // 测试关键字识别
        val lexer = createLexer()
        lexer.start("let", 0, 3, 0)
        assertEquals(ValkyrieTokenTypes.LET, lexer.tokenType)
    }
    
    @Test
    fun testIdentifiers() {
        // 测试标识符识别
        val lexer = createLexer()
        lexer.start("variable", 0, 8, 0)
        assertEquals(ValkyrieTokenTypes.SYMBOL_XID, lexer.tokenType)
    }
    
    @Test
    fun testNumbers() {
        // 测试数字字面量
        val lexer = createLexer()
        lexer.start("123", 0, 3, 0)
        assertEquals(ValkyrieTokenTypes.INTEGER, lexer.tokenType)
    }
    
    @Test
    fun testStrings() {
        // 测试字符串字面量
        val lexer = createLexer()
        lexer.start("\"hello\"", 0, 7, 0)
        assertEquals(ValkyrieTokenTypes.STRING_START, lexer.tokenType)
    }
    
    @Test
    fun testOperators() {
        // 测试操作符
        val lexer = createLexer()
        lexer.start("+", 0, 1, 0)
        assertEquals(ValkyrieTokenTypes.PLUS, lexer.tokenType)
    }
    
    @Test
    fun testPunctuation() {
        // 测试标点符号
        val lexer = createLexer()
        lexer.start("(", 0, 1, 0)
        assertEquals(ValkyrieTokenTypes.PARENTHESIS_L, lexer.tokenType)
    }
    
    @Test
    fun testComments() {
        // 测试注释 - Valkyrie使用#作为行注释
        val lexer = createLexer()
        lexer.start("# comment", 0, 9, 0)
        assertEquals(ValkyrieTokenTypes.COMMENT_LINE, lexer.tokenType)
    }
    
    @Test
    fun testTokenSequences() {
        // 测试简单表达式的 token 序列
        val input = "let x = 42"
        val lexer = createLexer()
        lexer.start(input, 0, input.length, 0)
        
        // 验证第一个 token 是 let
        assertEquals(ValkyrieTokenTypes.LET, lexer.tokenType)
    }
    
    @Test
    fun testTokenTexts() {
        // 测试 token 文本内容
        val input = "hello"
        val lexer = createLexer()
        lexer.start(input, 0, input.length, 0)
        
        assertEquals(ValkyrieTokenTypes.SYMBOL_XID, lexer.tokenType)
        assertEquals("hello", lexer.tokenText)
    }
    
    @Test
    fun testComplexExpression() {
        // 测试复杂表达式
        val code = "fn factorial(n: i32) -> i32 { if n <= 1 { 1 } else { n * factorial(n - 1) } }"
        val lexer = createLexer()
        lexer.start(code, 0, code.length, 0)
        
        // 验证第一个 token 是 fn
        assertEquals(ValkyrieTokenTypes.MICRO, lexer.tokenType)
        lexer.advance()
        
        // 跳过空白
        while (lexer.tokenType != null && lexer.tokenType.toString().contains("WHITE_SPACE")) {
            lexer.advance()
        }
        
        // 验证第二个 token 是标识符
        assertEquals(ValkyrieTokenTypes.SYMBOL_XID, lexer.tokenType)
    }
}