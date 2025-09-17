package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

class LiteralObjectDeclarationTest : ParsingTestCase("testData/parser/object", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun testDomain() = doTest(true)
    fun testField() = doTest(true)
    fun testMethod() = doTest(true)
}