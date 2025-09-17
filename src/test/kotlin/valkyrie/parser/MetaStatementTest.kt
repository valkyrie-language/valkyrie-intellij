package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import valkyrie.psi.ValkyrieParserDefinition

/**
 * ValkyrieMetaStatement 测试用例
 * 验证元编程语句 (micro, mezzo, macro) 的解析和功能
 */
class MetaStatementTest : ParsingTestCase("testData/parser/meta", "vk", ValkyrieParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"

    @Test
    fun testMicroFunction() = doTest(true, true)

    @Test
    fun testMezzoFunction() = doTest(true, true)

    @Test
    fun testMacroFunction() = doTest(true, true)

    @Test
    fun testMicroWithComplexLogic() = doTest(true, true)

    @Test
    fun testMezzoWithGenerics() = doTest(true, true)

    @Test
    fun testMacroWithTemplateGeneration() = doTest(true, true)

    @Test
    fun testMultipleMetaFunctions() = doTest(true, true)
}