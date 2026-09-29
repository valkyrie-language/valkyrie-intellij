package valkyrie.parser

import valkyrie.test.ValkyrieParsingTestCase

class TermExpressionTest : ValkyrieParsingTestCase("testData/parser/term_expression") {
    fun testNumberLiterals() = doTest(true)
    fun testBooleanLiterals() = doTest(true)
    fun testIdentifierExpressions() = doTest(true)
    fun testPrefixExpressions() = doTest(true)
    fun testInfixExpressions() = doTest(true)
    fun testPostfixExpressions() = doTest(true)
    fun testIndexExpressions() = doTest(true)
    fun testParenthesizedExpressions() = doTest(true)
    fun testStringLiterals() = doTest(true)
    fun testIndexQuillBrackets() = doTest(true, true)
    fun testTurbofishGenericCall() = doTest(true, true)
    fun testStringBacktickContent() = doTest(true, true)
    fun testArrayExpressions() = doTest(true)
    fun testObjectExpressions() = doTest(true)
    fun testSpecialValues() = doTest(true)
    override fun skipSpaces(): Boolean {
        return true
    }
}