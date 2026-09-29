package valkyrie.parser

import valkyrie.test.ValkyrieParsingTestCase

class StdlibParserTest : ValkyrieParsingTestCase("testData/parser/stdlib") {
    fun testOption() = doTest(true, true)
    fun testOptionFull() = doTest(true, true)
    fun testUnionTaggedVariant() = doTest(true, true)
    fun testValidation() = doTest(true, true)

    override fun skipSpaces(): Boolean = true
}
