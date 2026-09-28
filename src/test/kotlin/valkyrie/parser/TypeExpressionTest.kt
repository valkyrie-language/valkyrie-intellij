package valkyrie.parser

import valkyrie.test.ValkyrieParsingTestCase

class TypeExpressionTest : ValkyrieParsingTestCase("testData/parser/type_expression") {
    fun testClassTyping() = doTest(true)

    override fun skipSpaces(): Boolean = true
}
