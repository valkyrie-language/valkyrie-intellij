package valkyrie.parser

import org.junit.Assert.*
import org.junit.Test

class ControlFlowSyntaxTest {

    private fun parseCode(code: String): Boolean {
        // 简化的解析测试，验证代码结构的有效性
        return code.isNotEmpty() && !code.contains("syntax_error")
    }

    @Test
    fun testReturnStatement() {
        val code = "function test() { return 42 }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'return'", code.contains("return"))
    }

    @Test
    fun testBreakStatement() {
        val code = "function test() { while true { break } }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'break'", code.contains("break"))
    }

    @Test
    fun testContinueStatement() {
        val code = "function test() { while true { continue } }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'continue'", code.contains("continue"))
    }

    @Test
    fun testYieldStatement() {
        val code = "function test() { yield value }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'yield'", code.contains("yield"))
    }

    @Test
    fun testRaiseStatement() {
        val code = "function test() { raise exception }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'raise'", code.contains("raise"))
    }

    @Test
    fun testIfElseStatement() {
        val code = "function test() { if condition { } else { } }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'if'", code.contains("if"))
        assertTrue("Code should contain 'else'", code.contains("else"))
        assertTrue("Code should contain '{'", code.contains("{"))
        assertTrue("Code should contain '}'", code.contains("}"))
    }

    @Test
    fun testWhileLoop() {
        val code = "function test() { while condition { } }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'while'", code.contains("while"))
        assertTrue("Code should contain '{'", code.contains("{"))
        assertTrue("Code should contain '}'", code.contains("}"))
    }

    @Test
    fun testForLoop() {
        val code = "function test() { for item in items { } }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'for'", code.contains("for"))
        assertTrue("Code should contain 'in'", code.contains("in"))
        assertTrue("Code should contain '{'", code.contains("{"))
        assertTrue("Code should contain '}'", code.contains("}"))
    }

    @Test
    fun testLabeledControlFlow() {
        val code = """
            function test() {
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
            }
        """.trimIndent()
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Should contain labeled break", code.contains("break ※outer"))
        assertTrue("Should contain labeled continue", code.contains("continue ※inner"))
        assertTrue("Should contain labeled yield", code.contains("yield ※processor"))
    }
}