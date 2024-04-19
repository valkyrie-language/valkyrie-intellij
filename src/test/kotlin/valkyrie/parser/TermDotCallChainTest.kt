package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

class TermDotCallChainTest : ParsingTestCase("testData/parser/dot_call_chain", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    fun testSimpleDotCall() = doTest(true, true)

    fun testChainedDotCall() = doTest(true, true)

    fun testTrailingClosure() = doTest(true, true)

    fun testComplexChainWithTrailingClosures() = doTest(true, true)
}