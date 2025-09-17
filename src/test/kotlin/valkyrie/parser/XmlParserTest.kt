package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieXmlParserDefinition

/**
 * XML 解析器测试
 */
class XmlParserTest : ParsingTestCase("testData/parser/xml", "vkx", ValkyrieXmlParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"

    fun testEmpty() = doTest(true, true)

    fun testHelloWorld() = doTest(true, true)

    fun testMixedComment() = doTest(true, true)

    fun testMixedContent() = doTest(true, true)

    fun testNestedElements() = doTest(true, true)

    fun testPureValkyrie() = doTest(true, true)

    fun testSelfClosed() = doTest(true, true)

    fun testWithAttributes() = doTest(true, true)

    fun testWithContent() = doTest(true, true)

    fun testWithSlotExpression() = doTest(true, true)

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}