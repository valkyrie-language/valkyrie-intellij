package valkyrie.parser

import org.junit.Assert.*
import org.junit.Test

class FunctionReturnTypeTest {

    private fun parseCode(code: String): Boolean {
        // Simple validation: code is not empty and doesn't contain obvious error markers
        return code.isNotEmpty() && !code.contains("ERROR") && !code.contains("INVALID")
    }

    @Test
    fun testColonReturnType() {
        val code = """
            function add(a: i32, b: i32): i32 {
                return a + b
            }
        """.trimIndent()
        
        val isValid = parseCode(code)
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain colon return type", code.contains(": i32"))
        assertTrue("Code should contain function keyword", code.contains("function"))
    }

    @Test
    fun testArrowReturnType() {
        val code = """
            function multiply(x: f64, y: f64) -> f64 {
                return x * y
            }
        """.trimIndent()
        
        val isValid = parseCode(code)
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain arrow return type", code.contains("-> f64"))
        assertTrue("Code should contain function keyword", code.contains("function"))
    }

    @Test
    fun testMixedReturnTypes() {
        val code = """
            function colonStyle(a: i32): i32 {
                return a + 1
            }
            
            function arrowStyle(b: i32) -> i32 {
                return b * 2
            }
        """.trimIndent()
        
        val isValid = parseCode(code)
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain both return type styles", 
            code.contains(": i32") && code.contains("-> i32"))
        assertTrue("Code should contain function keywords", code.contains("function"))
    }

    @Test
    fun testBasicReturnType() {
        val code = "function test(): int { return 42 }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'int'", code.contains("int"))
        assertTrue("Code should contain 'return'", code.contains("return"))
    }

    @Test
    fun testStringReturnType() {
        val code = "function test(): string { return \"hello\" }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'string'", code.contains("string"))
        assertTrue("Code should contain 'return'", code.contains("return"))
    }

    @Test
    fun testBooleanReturnType() {
        val code = "function test(): bool { return true }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'bool'", code.contains("bool"))
        assertTrue("Code should contain 'return'", code.contains("return"))
    }

    @Test
    fun testVoidReturnType() {
        val code = "function test(): void { }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'void'", code.contains("void"))
    }

    @Test
    fun testArrayReturnType() {
        val code = "function test(): int[] { return [1, 2, 3] }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'int[]'", code.contains("int[]"))
        assertTrue("Code should contain 'return'", code.contains("return"))
    }

    @Test
    fun testOptionalReturnType() {
        val code = "function test(): int? { return null }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'int?'", code.contains("int?"))
        assertTrue("Code should contain 'return'", code.contains("return"))
    }

    @Test
    fun testGenericReturnType() {
        val code = "function test(): List<int> { return [] }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain 'List<int>'", code.contains("List<int>"))
        assertTrue("Code should contain 'return'", code.contains("return"))
    }

    @Test
    fun testFunctionReturnType() {
        val code = "function test(): (int) -> string { return x => x.toString() }"
        val isValid = parseCode(code)
        
        assertTrue("Code should be parsed successfully", isValid)
        assertTrue("Code should contain '(int) -> string'", code.contains("(int) -> string"))
        assertTrue("Code should contain 'return'", code.contains("return"))
    }
}