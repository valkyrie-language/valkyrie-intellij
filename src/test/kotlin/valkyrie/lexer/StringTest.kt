package valkyrie.lexer

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import valkyrie.language.dialect_std.ValkyrieStandardLexer

/**
 * 字符串词法分析测试
 * 包含所有字符串相关的测试用例
 */
class StringTest : LexerTestCase() {
    
    override fun createLexer(): Lexer {
        return ValkyrieStandardLexer()
    }
    
    override fun getDirPath(): String {
        return "testData/lexer/string"
    }
    
    // 基本字符串测试
    fun testDoubleQuoteString() {
        doTest("\"hello world\"")
    }
    
    fun testSingleQuoteString() {
        doTest("'hello world'")
    }
    
    fun testEmptyString() {
        doTest("\"\"")
    }
    
    fun testEmptySingleQuoteString() {
        doTest("''")
    }
    
    // 多行字符串测试
    fun testMultiQuoteString() {
        doTest("""This is a\nmultiline string""")
    }
    
    fun testTripleDoubleQuoteString() {
        doTest("\"\"\"\"\"This is a triple double quote string\"\"\"\"")
    }

    fun testQuadrupleDoubleQuoteString() {
        doTest("\"\"\"\"\"\"\"This is a quadruple double quote string\"\"\"\"\"\"")
    }

    // 转义字符测试
    fun testEscapeSequences() {
        doTest("\"\\n\\t\\r\\\\\\\"\"")
    }
    
    fun testUnicodeEscape() {
        doTest("\"\\u0041\"")
    }
    
    // 原始标识符测试（使用反引号）
    fun testRawIdentifier() {
        doTest("`raw_identifier`")
    }
    
    fun testRawIdentifierWithSpaces() {
        doTest("`identifier with spaces`")
    }
    
    // 字符串插值测试（如果支持）
    fun testStringInterpolation() {
        doTest("\"Hello {name}!\"")
    }
    
    fun testComplexInterpolation() {
        doTest("\"Result: {x + y * 2}\"")
    }
    
    // 特殊字符串测试
    fun testStringWithSpecialChars() {
        doTest("\"String with 中文 and émojis 🎉\"")
    }
    
    fun testStringWithNumbers() {
        doTest("\"Version 1.2.3\"")
    }
    
    // 错误情况测试
    fun testUnterminatedString() {
        doTest("\"unterminated string")
    }
    
    fun testUnterminatedSingleQuote() {
        doTest("'unterminated")
    }
    
    fun testInvalidEscape() {
        doTest("\"\\x\"")
    }
    
    // 字符串组合测试
    fun testMultipleStrings() {
        doTest("\"first\" + \"second\"")
    }
    
    fun testStringInExpression() {
        doTest("let message = \"Hello, \" + name")
    }
    
    // 长字符串测试
    fun testLongString() {
        doTest("\"This is a very long string that contains many words and should test the lexer's ability to handle longer text content properly\"")
    }
}