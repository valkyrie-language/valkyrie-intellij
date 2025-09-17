package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import valkyrie.psi.ValkyrieParserDefinition

/**
 * ValkyrieImplyStatement 测试用例
 * 验证 impl 语句的解析和功能
 */
class ImplyStatementTest : ParsingTestCase("testData/parser/imply", "vk", ValkyrieParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"

    @Test
    fun testBasicImplyStatement() = doTest(true, true)

    @Test
    fun testImplyStatementWithMethods() = doTest(true, true)

    @Test
    fun testImplyStatementWithGenerics() = doTest(true, true)

    @Test
    fun testImplyStatementWithComplexTypes() = doTest(true, true)

    @Test
    fun testImplyStatementWithTraitBounds() = doTest(true, true)

    @Test
    fun testMultipleImplyStatements() = doTest(true, true)
}