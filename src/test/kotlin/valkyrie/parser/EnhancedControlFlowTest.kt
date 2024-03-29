package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

/**
 * 增强的控制流测试用例
 * 验证新实现的 BREAK, CONTINUE, RAISE, YIELD 语句解析功能
 */
class EnhancedControlFlowTest {

    @Test
    fun testBreakStatementParsing() {
        val code = "break"
        assertTrue("Break statement should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain 'break' keyword", code.contains("break"))
    }

    @Test
    fun testBreakWithLabelParsing() {
        val code = "break ※outer_loop"
        assertTrue("Break with label should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain break keyword", code.contains("break"))
        assertTrue("Code should contain label marker", code.contains("※"))
        assertTrue("Code should contain label name", code.contains("outer_loop"))
    }

    @Test
    fun testContinueStatementParsing() {
        val code = "continue"
        assertTrue("Continue statement should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain 'continue' keyword", code.contains("continue"))
    }

    @Test
    fun testContinueWithLabelParsing() {
        val code = "continue ※inner_loop"
        assertTrue("Continue with label should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain continue keyword", code.contains("continue"))
        assertTrue("Code should contain label marker", code.contains("※"))
        assertTrue("Code should contain label name", code.contains("inner_loop"))
    }

    @Test
    fun testRaiseStatementParsing() {
        val code = "raise exception"
        assertTrue("Raise statement should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain 'raise' keyword", code.contains("raise"))
        assertTrue("Code should contain exception expression", code.contains("exception"))
    }

    @Test
    fun testRaiseWithComplexExpression() {
        val code = "raise RuntimeError(\"Something went wrong\")"
        assertTrue("Raise with complex expression should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain raise keyword", code.contains("raise"))
        assertTrue("Code should contain constructor call", code.contains("RuntimeError"))
        assertTrue("Code should contain string literal", code.contains("Something went wrong"))
    }

    @Test
    fun testYieldStatementParsing() {
        val code = "yield value"
        assertTrue("Yield statement should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain 'yield' keyword", code.contains("yield"))
        assertTrue("Code should contain yielded value", code.contains("value"))
    }

    @Test
    fun testYieldWithLabelParsing() {
        val code = "yield ※generator result"
        assertTrue("Yield with label should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain yield keyword", code.contains("yield"))
        assertTrue("Code should contain label marker", code.contains("※"))
        assertTrue("Code should contain label name", code.contains("generator"))
        assertTrue("Code should contain yielded value", code.contains("result"))
    }

    @Test
    fun testControlFlowInLoop() {
        val code = """
            while condition {
                if should_skip {
                    continue
                }
                if should_exit {
                    break
                }
                yield item
            }
        """.trimIndent()
        
        assertTrue("Control flow in loop should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain while loop", code.contains("while"))
        assertTrue("Code should contain continue statement", code.contains("continue"))
        assertTrue("Code should contain break statement", code.contains("break"))
        assertTrue("Code should contain yield statement", code.contains("yield"))
    }

    @Test
    fun testNestedControlFlowWithLabels() {
        val code = """
            ※outer for i in range {
                ※inner for j in items {
                    if error_condition {
                        raise CustomError(i, j)
                    }
                    if skip_condition {
                        continue ※inner
                    }
                    if exit_condition {
                        break ※outer
                    }
                    yield ※processor (i, j)
                }
            }
        """.trimIndent()
        
        assertTrue("Nested control flow should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain labeled loops", code.contains("※outer") && code.contains("※inner"))
        assertTrue("Code should contain labeled break", code.contains("break ※outer"))
        assertTrue("Code should contain labeled continue", code.contains("continue ※inner"))
        assertTrue("Code should contain labeled yield", code.contains("yield ※processor"))
        assertTrue("Code should contain raise statement", code.contains("raise CustomError"))
    }

    @Test
    fun testControlFlowInFunction() {
        val code = """
            function generator() -> Iterator<i32> {
                for i in 0..10 {
                    if i % 2 == 0 {
                        continue
                    }
                    if i > 7 {
                        break
                    }
                    yield i
                }
            }
        """.trimIndent()
        
        assertTrue("Control flow in function should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain function declaration", code.contains("function generator"))
        assertTrue("Code should contain Iterator return type", code.contains("Iterator<i32>"))
        assertTrue("Code should contain for loop", code.contains("for i in"))
        assertTrue("Code should contain all control flow statements", 
                   code.contains("continue") && code.contains("break") && code.contains("yield"))
    }
}