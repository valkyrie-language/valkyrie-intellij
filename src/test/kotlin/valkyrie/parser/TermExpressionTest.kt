package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

class TermExpressionTest : ParsingTestCase(
    "TermExpression",
    "vk",
    ValkyrieParserDefinition()
) {
    override fun getTestDataPath() = "src/test/resources/testData/parser"

    fun testNumberLiterals() = doTest(true)
    fun testBooleanLiterals() = doTest(true)
    fun testIdentifierExpressions() = doTest(true)
    fun testPrefixExpressions() = doTest(true)
    fun testInfixExpressions() = doTest(true)
    fun testPostfixExpressions() = doTest(true)
    fun testParenthesizedExpressions() = doTest(true)
    fun testStringLiterals() = doTest(true)
    fun testArrayExpressions() = doTest(true)
    fun testObjectExpressions() = doTest(true)
    fun testSpecialValues() = doTest(true)
}