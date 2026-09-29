package valkyrie.parser

import valkyrie.test.ValkyrieParsingTestCase

class ModuleParserTest : ValkyrieParsingTestCase("testData/parser/module") {
    fun testUsingBang() = doTest(true, true)

    override fun skipSpaces(): Boolean = true
}
