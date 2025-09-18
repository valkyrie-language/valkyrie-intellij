package valkyrie.parser

import com.intellij.testFramework.ParsingTestCase
import valkyrie.psi.parsers.ValkyrieParserDefinition

/**
 * 控制流语法解析测试
 */
class ControlFlowTest : ParsingTestCase("testData/parser/control_flow", "vk", ValkyrieParserDefinition()) {
    override fun getTestDataPath(): String = "src/test/resources"

    // If statement tests
    fun testIf() = doTest(true, true)
    fun testIfLet() = doTest(true, true)

    // Match statement tests
    fun testMatch() = doTest(true, true)

    // Control flow tests
    fun testContinue() = doTest(true, true)
    fun testBreak() = doTest(true, true)
    fun testFallthrough() = doTest(true, true)
    fun testRaise() = doTest(true, true)
    fun testResume() = doTest(true, true)
    fun testReturn() = doTest(true, true)
    fun testYield() = doTest(true, true)

    fun testAssert() = doTest(true, true)
    fun testDebug() = doTest(true, true)

    // looping tests
    fun testLoop() = doTest(true, true)
    fun testForIn() = doTest(true, true)
    fun testWhile() = doTest(true, true)
    fun testWhileLet() = doTest(true, true)
    fun testUntil() = doTest(true, true)
    fun testUntilNot() = doTest(true, true)

    // error handling tests
    fun testTry() = doTest(true, true)
    fun testCatch() = doTest(true, true)
    override fun skipSpaces(): Boolean {
        return true
    }
}

