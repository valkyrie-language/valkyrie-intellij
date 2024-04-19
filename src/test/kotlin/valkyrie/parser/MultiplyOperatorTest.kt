package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import org.junit.Test
import valkyrie.psi.ValkyrieParserDefinition

class MultiplyOperatorTest : ParsingTestCase("testData/parser/multiply_operator", "vk", ValkyrieParserDefinition()) {

    override fun getTestDataPath(): String = "src/test/resources"


    override fun skipSpaces(): Boolean {
        return false
    }

    override fun includeRanges(): Boolean {
        return true
    }

    @Test
    fun testStarOperator() = doTest(true, true)

    @Test
    fun testMultiplyOperator() = doTest(true, true)

    @Test
    fun testMixedOperators() = doTest(true, true)

    @Test
    fun testComplexExpression() = doTest(true, true)
}