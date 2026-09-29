package valkyrie.parser

import valkyrie.test.ValkyrieParsingTestCase

class TypeExpressionTest : ValkyrieParsingTestCase("testData/parser/type_expression") {
    fun testClassTyping() = doTest(true)
    fun testMicroCallableType() = doTest(true, true)
    fun testRefType() = doTest(true, true)

    override fun skipSpaces(): Boolean = true
}
