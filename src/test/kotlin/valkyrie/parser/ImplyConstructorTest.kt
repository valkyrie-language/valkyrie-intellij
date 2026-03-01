package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.parsers.ValkyrieParserDefinition

class ImplyConstructorTest : ParsingTestCase("testData/parser/imply", "txt", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun testConstructor() = doTest(true, true)

    override fun skipSpaces(): Boolean {
        return true
    }
}