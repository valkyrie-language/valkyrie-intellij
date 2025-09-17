package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieXmlParserDefinition

/**
 * XML 解析器测试
 */
class ValkyrieXmlParserTest : ParsingTestCase("testData/parser/xml", "vk", ValkyrieXmlParserDefinition()) {

    fun testSimpleXmlElement() {
        doTest(true)
    }

    fun testXmlElementWithAttributes() {
        doTest(true)
    }

    fun testXmlElementWithContent() {
        doTest(true)
    }

    fun testXmlElementWithSlotExpression() {
        doTest(true)
    }

    fun testNestedXmlElements() {
        doTest(true)
    }

    fun testSelfClosingXmlElement() {
        doTest(true)
    }

    fun testXmlWithMixedContent() {
        doTest(true)
    }

    override fun getTestDataPath(): String {
        return "src/test/resources"
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}