package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

class TypeExpressionTest : ParsingTestCase("testData/parser/type_expression", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"
    fun testClassTyping() = doTest(true)
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
    override fun skipSpaces(): Boolean {
        return true
    }
}