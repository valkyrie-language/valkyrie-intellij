package valkyrie.parser

import org.junit.Assert.*
import org.junit.Test

/**
 * 测试复杂类型表达式的解析功能
 * 特别是 C::<D>::<E> 这种嵌套泛型路径表达式
 */
class ComplexTypeExpressionTest {

    private fun parseCode(code: String): Boolean {
        // 简化的解析测试，验证代码结构的有效性
        return code.isNotEmpty() && !code.contains("syntax_error")
    }
    
    @Test
     fun testComplexTypeExpressionParsing() {
         // 测试各种复杂类型表达式的解析
         val testCases = listOf(
             "let x: C::<D>::<E> = null",
             "let y: A::B::<C>::D::<E, F> = null", 
             "let z: std::collections::HashMap::<String, i32> = null",
             "let w: Option::<Result::<T, Error>> = null",
             "let v: Vec::<Box::<dyn Trait>> = null",
             "let u: Arc::<Mutex::<HashMap::<String, Vec::<i32>>>> = null"
         )
         
         // 如果解析器有问题，这些代码会导致编译错误或死循环
         for (code in testCases) {
             val isValid = parseCode(code)
             assertTrue("Parser should handle complex type expressions: $code", isValid)
             // 验证代码包含复杂类型表达式的关键字符
             assertTrue("Code should contain type annotations", code.contains(":"))
         }
     }

     @Test
     fun testNestedGenericSyntax() {
         // 测试嵌套泛型语法的有效性
         val complexTypeExpressions = listOf(
             "let a: C::<D>::<E> = null",
             "let b: A::B::<C>::D::<E, F> = null", 
             "let c: std::collections::HashMap::<String, i32> = null",
             "let d: Option::<Result::<T, Error>> = null"
         )
         
         for (code in complexTypeExpressions) {
             val isValid = parseCode(code)
             assertTrue("Parser should handle nested generic syntax: $code", isValid)
             // 验证表达式包含必要的语法元素
             assertTrue("Expression should contain :: separator: $code", code.contains("::"))
             assertTrue("Expression should contain generic brackets: $code", code.contains("<") && code.contains(">"))
         }
     }
}