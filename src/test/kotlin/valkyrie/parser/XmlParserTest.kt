package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieXmlParserDefinition

/**
 * XML 解析器测试
 */
class XmlParserTest : ParsingTestCase("testData/parser/vkx", "vkx", ValkyrieXmlParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"

    override fun skipSpaces(): Boolean {
        return true
    }
}