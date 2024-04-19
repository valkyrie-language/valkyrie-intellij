package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import valkyrie.psi.ValkyrieParserDefinition

class TestsStatementTest : ParsingTestCase("", "v", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"


    @Test
    fun testSimpleTestsBlock() = doTest(true, true)

    @Test
    fun testTestFunction() = doTest(true, true)

    @Test
    fun testBenchmarkDSL() = doTest(true, true)

    @Test
    fun testNestedTestsBlocks() = doTest(true, true)

    @Test
    fun testTestsWithModifiers() = doTest(true, true)

    @Test
    fun testTestsInClassBody() = doTest(true, true)
}