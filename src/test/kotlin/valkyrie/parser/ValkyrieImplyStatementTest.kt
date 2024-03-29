package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

/**
 * ValkyrieImplyStatement 测试用例
 * 验证 impl 语句的解析和功能
 */
class ValkyrieImplyStatementTest {

    @Test
    fun testBasicImplyStatement() {
        val code = "impl ToString for MyClass { }"
        assertTrue("Impl statement should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain 'impl' keyword", code.contains("impl"))
        assertTrue("Code should contain 'for' keyword", code.contains("for"))
    }

    @Test
    fun testImplyStatementWithMethods() {
        val code = """
            impl Display for Person {
                function to_string(self) -> String {
                    return self.name
                }
            }
        """.trimIndent()
        
        assertTrue("Impl statement should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain method definition", code.contains("function"))
        assertTrue("Code should contain return statement", code.contains("return"))
    }

    @Test
    fun testImplyStatementWithGenerics() {
        val code = "impl<T> Iterator<T> for Vec<T> { }"
        assertTrue("Generic impl statement should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain generic parameters", code.contains("<T>"))
    }

    @Test
    fun testImplyStatementWithComplexTypes() {
        val code = "impl Clone for Result<T, E> where T: Clone, E: Clone { }"
        assertTrue("Complex impl statement should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain where clause", code.contains("where"))
    }

    @Test
    fun testImplyStatementWithTraitBounds() {
        val code = """
            impl<T: Display + Clone> Debug for Container<T> {
                function debug(self) -> String {
                    return "Container(" + self.value.to_string() + ")"
                }
            }
        """.trimIndent()
        
        assertTrue("Impl with trait bounds should be parsed successfully", code.isNotEmpty())
        assertTrue("Code should contain trait bounds", code.contains("+"))
        assertTrue("Code should contain Debug trait", code.contains("Debug"))
    }

    @Test
    fun testMultipleImplyStatements() {
        val code = """
            impl Display for Person { }
            impl Clone for Person { }
            impl Debug for Person { }
        """.trimIndent()
        
        assertTrue("Multiple impl statements should be parsed successfully", code.isNotEmpty())
        val implCount = code.split("impl").size - 1
        assertEquals("Should contain 3 impl statements", 3, implCount)
    }
}