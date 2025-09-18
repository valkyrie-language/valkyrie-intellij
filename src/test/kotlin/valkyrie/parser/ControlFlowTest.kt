package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.ValkyrieParserDefinition

/**
 * 控制流语法解析测试
 */
class ControlFlowTest : ParsingTestCase("testData/parser/control_flow", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"
    fun testContinue() = doTest(true, true)
    fun testBreak() = doTest(true, true)
    fun testFallthrough() = doTest(true, true)
    fun testFor() = doTest(true, true)
    fun testForIn() = doTest(true, true)
    fun testLoop() = doTest(true, true)
    fun testLoopIn() = doTest(true, true)
    fun testRaise() = doTest(true, true)
    fun testResume() = doTest(true, true)
    fun testReturn() = doTest(true, true)
    fun testUntil() = doTest(true, true)
    fun testUntilNot() = doTest(true, true)
    fun testWhile() = doTest(true, true)
    fun testWhileLet() = doTest(true, true)
    fun testYield() = doTest(true, true)

    override fun skipSpaces(): Boolean {
        return true
    }

    override fun includeRanges(): Boolean {
        return true
    }
}