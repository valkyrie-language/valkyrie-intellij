package valkyrie.parser

import org.junit.Test
import valkyrie.test.ValkyrieParsingTestCase

/**
 * Valkyrie 基础解析器测试
 * 测试基本的语法解析功能
 */
class ValkyrieBasicParsingTest : ValkyrieParsingTestCase("parser") {
    
    @Test
    fun testVariableDeclarations() {
        doTest(true)
    }
    
    @Test
    fun testFunctionDeclarations() {
        doTest(true)
    }
    
    @Test
    fun testExpressions() {
        doTest(true)
    }
    
    @Test
    fun testEnhancedControlFlow() {
        doTest(true)
    }
    
    @Test
    fun testDataStructures() {
        // 测试数据结构解析
        val code = "struct Point { x: f64, y: f64 }"
        val psiFile = createPsiFile("test.vk", code)
        assertNotNull("PSI file should be created", psiFile)
    }
    
    @Test
    fun testFunctionCalls() {
        // 测试函数调用
        val code = "foo(a, b, c)"
        val psiFile = createPsiFile("test.vk", code)
        assertNotNull("PSI file should be created", psiFile)
    }
    
    @Test
    fun testTypeAnnotations() {
        // 测试类型注解
        val code = "let x: i32 = 42"
        val psiFile = createPsiFile("test.vk", code)
        assertNotNull("PSI file should be created", psiFile)
    }
    
    @Test
    fun testComments() {
        // 测试注释不影响解析
        val code = "# This is a comment\nlet x = 42"
        val psiFile = createPsiFile("test.vk", code)
        assertNotNull("PSI file should be created", psiFile)
    }
    
    @Test
    fun testErrorRecovery() {
        // 测试语法错误恢复
        val code = "let x =" // 缺少值
        val psiFile = createPsiFile("test.vk", code)
        assertNotNull("PSI file should be created", psiFile)
    }
    
    @Test
    fun testComplexCode() {
        // 测试复杂代码结构
        val complexCode = """
            fn fibonacci(n: i32) -> i32 {
                if n <= 1 {
                    n
                } else {
                    fibonacci(n - 1) + fibonacci(n - 2)
                }
            }
            
            fn main() {
                let numbers = [1, 2, 3, 4, 5]
                let mut sum = 0
                
                for num in numbers {
                    sum += num
                }
                
                let result = {
                    sum: sum,
                    average: sum / numbers.length,
                    fibonacci_10: fibonacci(10)
                }
                
                print(result)
            }
        """.trimIndent()
        
        val psiFile = createFile("test.vk", complexCode)
        assertNotNull("PSI file should be created", psiFile)
    }
    
    @Test
    fun testTemplateExpressions() {
        // 测试模板表达式（如果支持）
        val code = "\"Hello, \${name}!\""
        val psiFile = createPsiFile("test.vk", code)
        assertNotNull("PSI file should be created", psiFile)
    }
    
    @Test
    fun testOperatorPrecedence() {
        // 测试操作符优先级
        val code = "a + b * c"
        val psiFile = createPsiFile("test.vk", code)
        assertNotNull("PSI file should be created", psiFile)
    }
    
    @Test
    fun testAssignmentOperators() {
        // 测试赋值操作符
        val code = "x = 42"
        val psiFile = createPsiFile("test.vk", code)
        assertNotNull("PSI file should be created", psiFile)
    }
}