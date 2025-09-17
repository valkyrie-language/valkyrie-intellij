package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieSfcParserDefinition

/**
 * SFC 解析器测试
 */
class SfcParserTest : ParsingTestCase("testData/parser/sfc", "vkc", ValkyrieSfcParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun testTemplateEmpty() = doTest(true, true)
    fun testTemplateContent() = doTest(true, true)
    fun testStyleEmpty() = doTest(true, true)
    fun testStyleContent() = doTest(true, true)
    fun testStyleWithStylus() = doTest(true, true)
    fun testEmptyScript() = doTest(true, true)
    fun testSfcEmpty() = doTest(true, true)
    fun testSfcWithScriptXmlTags() = doTest(true, true)

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}