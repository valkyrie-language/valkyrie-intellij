package valkyrie.parser

import valkyrie.test.ValkyrieParsingTestCase

class ImplyConstructorTest : ValkyrieParsingTestCase("testData/parser/imply") {
    fun testConstructor() = doTest(true, true)

    override fun skipSpaces(): Boolean {
        return true
    }
}