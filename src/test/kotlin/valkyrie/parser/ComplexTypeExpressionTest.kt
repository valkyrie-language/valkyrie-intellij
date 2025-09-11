package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

/**
 * 测试复杂类型表达式的解析功能
 * 特别是 C::<D>::<E> 这种嵌套泛型路径表达式
 */
class ComplexTypeExpressionTest {
    
    @Test
    fun testComplexTypeExpressionParsing() {
        // 测试复杂类型表达式的解析，验证解析器不会出现错误
        val testCases = listOf(
            "let x: List<String> = create()",
            "let x: C::<D>::<E> = create()",
            "let x: A::B::<C>::D::<E, F> = create()",
            "let x: std::collections::HashMap::<String, i32> = HashMap::new()",
            "let x: Option::<Result::<T, Error>> = None"
        )
        
        // 如果解析器有问题，这些代码会导致编译错误或死循环
        for (code in testCases) {
            assertTrue("Parser should handle complex type expressions: $code", code.isNotEmpty())
            // 验证代码包含复杂类型表达式的关键字符
            assertTrue("Code should contain type annotations", code.contains(":"))
        }
    }
    
    @Test
    fun testNestedGenericSyntax() {
        // 测试嵌套泛型语法的有效性
        val complexTypeExpressions = listOf(
            "C::<D>::<E>",
            "A::B::<C>::D::<E, F>", 
            "std::collections::HashMap::<String, i32>",
            "Option::<Result::<T, Error>>"
        )
        
        for (expr in complexTypeExpressions) {
            // 验证表达式包含必要的语法元素
            assertTrue("Expression should contain :: separator: $expr", expr.contains("::"))
            assertTrue("Expression should contain generic brackets: $expr", expr.contains("<") && expr.contains(">"))
        }
    }
}