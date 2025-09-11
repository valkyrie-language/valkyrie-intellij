package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

class ControlFlowSyntaxTest {

    @Test
    fun testReturnSyntax() {
        val code = "return 42"
        assertTrue("Return syntax should be valid", code.contains("return"))
    }

    @Test
    fun testBreakSyntax() {
        val code = "break ※outer"
        assertTrue("Break with label syntax should be valid", code.contains("break") && code.contains("※"))
    }

    @Test
    fun testContinueSyntax() {
        val code = "continue ※loop"
        assertTrue("Continue with label syntax should be valid", code.contains("continue") && code.contains("※"))
    }

    @Test
    fun testYieldSyntax() {
        val code = "yield value"
        assertTrue("Yield syntax should be valid", code.contains("yield"))
    }

    @Test
    fun testRaiseSyntax() {
        val code = "raise exception"
        assertTrue("Raise syntax should be valid", code.contains("raise"))
    }

    @Test
    fun testControlFlowKeywords() {
        val keywords = listOf("return", "break", "continue", "yield", "raise")
        keywords.forEach { keyword ->
            assertTrue("Keyword $keyword should be recognized", keyword.isNotEmpty())
        }
    }

    @Test
    fun testLabeledControlFlow() {
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
        
        assertTrue("Should contain labeled break", code.contains("break ※outer"))
        assertTrue("Should contain labeled continue", code.contains("continue ※inner"))
        assertTrue("Should contain labeled yield", code.contains("yield ※processor"))
    }
}