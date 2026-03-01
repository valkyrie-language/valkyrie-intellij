package valkyrie.lexer

import com.intellij.lexer.Lexer
import com.intellij.testFramework.LexerTestCase
import valkyrie.language.ValkyrieLanguageConfig
import valkyrie.psi.lexers.ValkyrieLexer

/**
 * 数字词法分析测试
 * 包含所有数字相关的测试用例
 */
class NumberTest : LexerTestCase() {

    override fun createLexer(): Lexer {
        return ValkyrieLexer(ValkyrieLanguageConfig())
    }

    override fun getDirPath(): String {
        return "testData/lexer/number"
    }

    // 整数测试
    fun testIntegerLiteral() {
        doTest("123")
    }

    fun testNegativeInteger() {
        doTest("-456")
    }

    fun testZero() {
        doTest("0")
    }

    // 浮点数测试
    fun testFloatLiteral() {
        doTest("3.14")
    }

    fun testNegativeFloat() {
        doTest("-2.71")
    }

    fun testFloatWithoutIntegerPart() {
        doTest(".5")
    }

    fun testFloatWithoutFractionalPart() {
        doTest("5.")
    }

    // 科学计数法测试
    fun testScientificNotation() {
        doTest("1.23e4")
    }

    fun testScientificNotationNegativeExponent() {
        doTest("1.23e-4")
    }

    fun testScientificNotationPositiveExponent() {
        doTest("1.23e+4")
    }

    // 十六进制测试
    fun testHexadecimalLiteral() {
        doTest("0xFF")
    }

    fun testHexadecimalLowercase() {
        doTest("0xabc")
    }

    // 二进制测试
    fun testBinaryLiteral() {
        doTest("0b1010")
    }

    // 八进制测试
    fun testOctalLiteral() {
        doTest("0o777")
    }

    // 数字分隔符测试
    fun testNumberWithSeparator() {
        doTest("1_000_000")
    }

    fun testFloatWithSeparator() {
        doTest("3.141_592")
    }

    // 错误情况测试
    fun testInvalidNumber() {
        doTest("123abc")
    }

    fun testDoubleDecimalPoint() {
        doTest("3.14.15")
    }

    fun testNumberWithUnit() {
        doTest("123mm")
    }

    fun testNumberWithUnitAndSeparator() {
        doTest("123_kg")
    }
}