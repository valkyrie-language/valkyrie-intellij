package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import valkyrie.psi.ValkyrieParserDefinition

/**
 * 测试 table 和 slice 表达式的解析功能
 * 包括 table 字面量、slice 操作和相关类型表达式
 */
class TableAndSliceTest : ParsingTestCase("testData/parser/table_and_slice", "vk", ValkyrieParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"


    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }

    @Test
    fun testTableLiteralParsing() = doTest(true, true)

    @Test
    fun testSliceExpressionParsing() = doTest(true, true)

    @Test
    fun testTableTypeParsing() = doTest(true, true)

    @Test
    fun testComplexTableAndSliceExpressions() = doTest(true, true)

    @Test
    fun testTableAndArrayDistinction() = doTest(true, true)

    @Test
    fun testSliceWithVariousStepSyntax() = doTest(true, true)
}