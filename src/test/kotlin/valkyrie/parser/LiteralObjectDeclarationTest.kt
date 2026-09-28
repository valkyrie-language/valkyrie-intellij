package valkyrie.parser

import valkyrie.test.ValkyrieParsingTestCase

class LiteralObjectDeclarationTest : ValkyrieParsingTestCase("testData/parser/object") {
    fun testDomain() = doTest(true, true)
    fun testField() = doTest(true, true)
    fun testMethod() = doTest(true, true)
}