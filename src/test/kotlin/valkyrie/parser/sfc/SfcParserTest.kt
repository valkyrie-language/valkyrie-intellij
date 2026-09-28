package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.parsers.ValkyrieSfcParserDefinition
import java.nio.file.Path

/**
 * SFC 解析器测试
 */
class SfcParserTest : ParsingTestCase("testData/parser/sfc_grammar", "vx", ValkyrieSfcParserDefinition()) {
    override fun getTestDataPath(): String =
        Path.of("src/test/resources").toAbsolutePath().normalize().toString()

    fun testTemplateEmpty() = doTest(true, false)
    fun testTemplateContent() = doTest(true, false)
    fun testStyleEmpty() = doTest(true, false)
    fun testStyleContent() = doTest(true, false)
    fun testStyleWithStylus() = doTest(true, false)
    fun testScriptEmpty() = doTest(true, false)
    fun testSfcEmpty() = doTest(true, false)
    fun testSfcWithScriptXmlTags() = doTest(true, false)
    fun testMinimalTest() = doTest(true, false)
    fun testPlaceHolders() = doTest(true, false)

    override fun skipSpaces(): Boolean {
        return false
    }
}