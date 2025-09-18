package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.parsers.ValkyrieParserDefinition

class LiteralObjectDeclarationTest : ParsingTestCase("testData/parser/object", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun testDomain() = doTest(true, true)
    fun testField() = doTest(true, true)
    fun testMethod() = doTest(true, true)
}