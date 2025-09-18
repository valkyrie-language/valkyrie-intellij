package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.parsers.ValkyrieXmlParserDefinition

/**
 * XML 解析器测试
 */
class XmlParserTest : ParsingTestCase("testData/parser/x_grammar", "vkx", ValkyrieXmlParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"

    fun testComment() = doTest(true, true)

    override fun skipSpaces(): Boolean {
        return true
    }
}