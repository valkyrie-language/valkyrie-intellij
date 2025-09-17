package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieSfcParserDefinition

/**
 * SFC 解析器测试
 */
class ValkyrieSfcParserTest : ParsingTestCase("testData/parser/sfc", "vkc", ValkyrieSfcParserDefinition()) {

    fun testSfcWithTemplate() {
        doTest(true)
    }

    fun testSfcWithScript() {
        doTest(true)
    }

    fun testSfcWithStyle() {
        doTest(true)
    }

    fun testSfcWithAllSections() {
        doTest(true)
    }

    fun testSfcWithMultipleStyles() {
        doTest(true)
    }

    fun testSfcWithNestedElements() {
        doTest(true)
    }

    fun testSfcWithExpressions() {
        doTest(true)
    }

    fun testSfcWithVoidTags() {
        doTest(true)
    }

    fun testSfcWithAttributes() {
        doTest(true)
    }

    fun testSfcEmpty() {
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