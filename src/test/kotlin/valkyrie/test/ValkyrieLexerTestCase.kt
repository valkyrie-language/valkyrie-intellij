package valkyrie.test

import com.intellij.lexer.Lexer
import com.intellij.psi.tree.IElementType
import com.intellij.testFramework.LexerTestCase
import valkyrie.psi.lexers.ValkyrieStandardLexer
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * Valkyrie 词法分析器测试基类
 * 基于 JetBrains LexerTestCase 模式实现 <mcreference link="https://plugins.jetbrains.com/docs/intellij/parsing-test.html" index="1">1</mcreference>
 */
abstract class ValkyrieLexerTestCase : LexerTestCase() {
    
    override fun createLexer(): Lexer {
        return ValkyrieStandardLexer()
    }
    
    override fun getDirPath(): String {
        return "src/test/resources/testData/lexer"
    }
    
    /**
     * 测试单个 token 的词法分析
     * @param input 输入文本
     * @param expectedTokenType 期望的 token 类型
     */
    protected fun testSingleToken(input: String, expectedTokenType: IElementType) {
        val lexer = createLexer()
        lexer.start(input, 0, input.length, 0)
        
        assertEquals(
            "Token type should match for input: '$input'",
            expectedTokenType,
            lexer.tokenType
        )
        
        assertEquals(
            "Token start should be 0",
            0,
            lexer.tokenStart
        )
        
        assertEquals(
            "Token end should match input length",
            input.length,
            lexer.tokenEnd
        )
    }
    
    /**
     * 测试多个 token 的词法分析序列
     * @param input 输入文本
     * @param expectedTokens 期望的 token 类型序列
     */
    protected fun testTokenSequence(input: String, expectedTokens: List<IElementType>) {
        val lexer = createLexer()
        lexer.start(input, 0, input.length, 0)
        
        val actualTokens = mutableListOf<IElementType>()
        
        while (lexer.tokenType != null) {
            actualTokens.add(lexer.tokenType!!)
            lexer.advance()
        }
        
        assertEquals(
            "Token sequence should match for input: '$input'",
            expectedTokens,
            actualTokens
        )
    }
    
    /**
     * 测试 token 的文本内容
     * @param input 输入文本
     * @param expectedTexts 期望的 token 文本序列
     */
    protected fun testTokenTexts(input: String, expectedTexts: List<String>) {
        val lexer = createLexer()
        lexer.start(input, 0, input.length, 0)
        
        val actualTexts = mutableListOf<String>()
        
        while (lexer.tokenType != null) {
            actualTexts.add(lexer.tokenText.toString())
            lexer.advance()
        }
        
        assertEquals(
            "Token texts should match for input: '$input'",
            expectedTexts,
            actualTexts
        )
    }
    
    /**
     * 测试关键字识别
     * @param keyword 关键字
     * @param expectedTokenType 期望的 token 类型
     */
    protected fun testKeyword(keyword: String, expectedTokenType: IElementType) {
        testSingleToken(keyword, expectedTokenType)
    }
    
    /**
     * 测试标识符识别
     * @param identifier 标识符
     */
    protected fun testIdentifier(identifier: String) {
        testSingleToken(identifier, ValkyrieTokenTypes.SYMBOL_XID)
    }
    
    /**
     * 测试数字字面量识别
     * @param number 数字字面量
     * @param expectedTokenType 期望的 token 类型
     */
    protected fun testNumber(number: String, expectedTokenType: IElementType) {
        testSingleToken(number, expectedTokenType)
    }
    
    /**
     * 测试字符串字面量识别
     * @param string 字符串字面量
     * @param expectedTokenType 期望的 token 类型
     */
    protected fun testString(string: String, expectedTokenType: IElementType) {
        testSingleToken(string, expectedTokenType)
    }
    
    /**
     * 测试操作符识别
     * @param operator 操作符
     * @param expectedTokenType 期望的 token 类型
     */
    protected fun testOperator(operator: String, expectedTokenType: IElementType) {
        testSingleToken(operator, expectedTokenType)
    }
    
    /**
     * 测试注释识别
     * @param comment 注释
     * @param expectedTokenType 期望的 token 类型
     */
    protected fun testComment(comment: String, expectedTokenType: IElementType) {
        testSingleToken(comment, expectedTokenType)
    }
    
    /**
     * 打印词法分析结果（用于调试）
     */
    protected fun printLexerOutput(input: String) {
        val lexer = createLexer()
        lexer.start(input, 0, input.length, 0)
        
        println("Lexer output for: '$input'")
        var tokenIndex = 0
        
        while (lexer.tokenType != null) {
            println("  [$tokenIndex] ${lexer.tokenType} '${lexer.tokenText}' (${lexer.tokenStart}-${lexer.tokenEnd})")
            lexer.advance()
            tokenIndex++
        }
    }
}