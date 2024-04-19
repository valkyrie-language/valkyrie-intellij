package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import valkyrie.psi.ValkyrieParserDefinition

/**
 * 元编程功能测试
 * 验证 micro、mezzo、macro 三个元层级的解析功能
 */
class MetaProgrammingTest : ParsingTestCase("testData/parser/meta_programming", "vk", ValkyrieParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"


    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }

    @Test
    fun testMicroFunctionDeclaration() = doTest(true, true)

    @Test
    fun testMezzoFunctionDeclaration() = doTest(true, true)

    @Test
    fun testMacroFunctionDeclaration() = doTest(true, true)

    @Test
    fun testCompileTimeExpressionBlock() = doTest(true, true)

    @Test
    fun testTemplateInterpolation() = doTest(true, true)

    @Test
    fun testTemplateConditional() = doTest(true, true)

    @Test
    fun testTemplateElseIfConditional() = doTest(true, true)

    @Test
    fun testTemplateLoop() = doTest(true, true)

    @Test
    fun testTemplateMatch() = doTest(true, true)

    @Test
    fun testComplexMetaProgrammingExample() = doTest(true, true)

    @Test
    fun testMetaFunctionTypes() = doTest(true, true)
}