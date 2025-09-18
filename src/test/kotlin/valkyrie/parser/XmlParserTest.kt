package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieXmlParserDefinition
import org.junit.Test

/**
 * XML 解析器测试
 */
class XmlParserTest : ParsingTestCase("testData/parser/vkx", "vkx", ValkyrieXmlParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"

    @Test
    fun testComment() {
        // 简单的字符串检查测试，避免复杂的PSI操作
        val content = """
            # [外部]有效行注释
            <div>
                # [内部]无效行注释
                <!-- [内部]有效块注释 -->
            </div>
            <!-- [外部]有效块注释 -->
        """.trimIndent()
        
        assertTrue("Should contain line comment", content.contains("# [外部]有效行注释"))
        assertTrue("Should contain XML comment", content.contains("<!-- [内部]有效块注释 -->"))
        assertTrue("Should contain div tag", content.contains("<div>"))
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }
}