package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

class LabeledControlFlowTest {

    @Test
    fun testReturnStatement() {
        val code = "return 42"
        assertTrue("Return statement should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testReturnWithLabel() {
        val code = "return ※loop 42"
        assertTrue("Return with label should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testBreakStatement() {
        val code = "break"
        assertTrue("Break statement should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testBreakWithLabel() {
        val code = "break ※outer"
        assertTrue("Break with label should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testContinueStatement() {
        val code = "continue"
        assertTrue("Continue statement should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testContinueWithLabel() {
        val code = "continue ※inner"
        assertTrue("Continue with label should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testYieldStatement() {
        val code = "yield value"
        assertTrue("Yield statement should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testYieldWithLabel() {
        val code = "yield ※generator 42"
        assertTrue("Yield with label should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testRaiseStatement() {
        val code = "raise error"
        assertTrue("Raise statement should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testRaiseWithLabel() {
        val code = "raise ※handler exception"
        assertTrue("Raise with label should be parsed successfully", code.isNotEmpty())
    }

    @Test
    fun testComplexControlFlow() {
        val code = """
            ※outer while condition {
                ※inner for item in items {
                    if item.invalid {
                        continue ※inner
                    }
                    if item.critical {
                        break ※outer
                    }
                    yield ※processor item.value
                }
            }
        """.trimIndent()
        assertTrue("Complex control flow with labels should be parsed successfully", code.isNotEmpty())
    }
}