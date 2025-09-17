package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieSfcParserDefinition

/**
 * SFC 解析器测试
 */
class SfcParserTest : ParsingTestCase("testData/parser/sfc", "vkc", ValkyrieSfcParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"


    fun testSfcWithTemplate() = doTest(true, true)

    fun testSfcWithScript() = doTest(true, true)

    fun testSfcWithStyle() = doTest(true, true)

    fun testSfcWithAllSections() = doTest(true, true)

    fun testSfcWithMultipleStyles() = doTest(true, true)

    fun testSfcWithNestedElements() = doTest(true, true)

    fun testSfcWithExpressions() = doTest(true, true)

    fun testSfcWithVoidTags() = doTest(true, true)

    fun testSfcWithAttributes() = doTest(true, true)

    fun testSfcEmpty() = doTest(true, true)


    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}