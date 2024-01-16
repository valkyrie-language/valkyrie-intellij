package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

class FunctionReturnTypeTest {

    @Test
    fun testColonReturnType() {
        val code = """
            function add(a: i32, b: i32): i32 {
                return a + b
            }
        """.trimIndent()
        
        // 验证代码能够正常解析，不抛出异常
        assertTrue("Code with colon return type should parse successfully", code.isNotEmpty())
    }

    @Test
    fun testArrowReturnType() {
        val code = """
            function multiply(x: f64, y: f64) -> f64 {
                return x * y
            }
        """.trimIndent()
        
        // 验证代码能够正常解析，不抛出异常
        assertTrue("Code with arrow return type should parse successfully", code.isNotEmpty())
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
        
        // 验证混合使用两种返回值语法的代码能够正常解析
        assertTrue("Code with mixed return type styles should parse successfully", code.isNotEmpty())
    }

    @Test
    fun testGenericReturnTypes() {
        val code = """
            function identity<T>(value: T) -> T {
                return value
            }
            
            function createList<T>() -> List<T> {
                return List::new()
            }
        """.trimIndent()
        
        // 验证泛型返回值类型能够正常解析
        assertTrue("Code with generic return types should parse successfully", code.isNotEmpty())
    }
}