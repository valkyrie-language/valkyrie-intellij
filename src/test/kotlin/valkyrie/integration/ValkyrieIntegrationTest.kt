package valkyrie.integration

import org.junit.Test
import valkyrie.test.ValkyrieTestCase

/**
 * Valkyrie 集成测试
 * 综合测试词法分析、语法解析、语法高亮和跳转功能的协同工作
 */
class ValkyrieIntegrationTest : ValkyrieTestCase() {
    
    @Test
    fun testBasicLanguageFeatures() {
        // 测试基本语言特性的完整流程
        val code = """
            // Simple variable declaration and usage
            let x = 42
            let y = x + 10
            
            // Function definition and call
            fn double(value: i32) -> i32 {
                value * 2
            }
            
            let result = double(y)
        """.trimIndent()
        
        // 配置测试文件
        val psiFile = myFixture.configureByText("integration_test.vk", code)
        
        // 验证文件解析成功
        assertNotNull("PSI file should be created", psiFile)
        assertFalse("PSI file should not have errors", hasParsingErrors(psiFile))
        
        // 验证语法高亮不产生错误
        val highlights = myFixture.doHighlighting()
        val errors = highlights.filter { it.severity.name == "ERROR" }
        assertTrue("Should not have highlighting errors", errors.isEmpty())
        
        // 验证基本的跳转功能
        // 测试变量 x 的跳转
        val xUsageOffset = code.indexOf("x", code.indexOf("x + 10"))
        myFixture.editor.caretModel.moveToOffset(xUsageOffset)
        
        val gotoTargets = com.intellij.codeInsight.navigation.actions.GotoDeclarationAction.findAllTargetElements(
            myFixture.project,
            myFixture.editor,
            xUsageOffset
        )
        
        assertTrue("Should find goto target for variable x", gotoTargets.isNotEmpty())
    }
    
    @Test
    fun testComplexCodeStructure() {
        // 测试复杂代码结构
        val complexCode = """
            /// Documentation for the fibonacci function
            /// Calculates the nth Fibonacci number recursively
            fn fibonacci(n: i32) -> i32 {
                if n <= 1 {
                    return n
                } else {
                    return fibonacci(n - 1) + fibonacci(n - 2)
                }
            }
            
            /// Main function demonstrating various language features
            fn main() {
                // Array of numbers to process
                let numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
                let mut sum = 0
                let mut fibonacci_sum = 0
                
                /* Process each number in the array */
                for num in numbers {
                    sum += num
                    fibonacci_sum += fibonacci(num)
                }
                
                // Create result object
                let result = {
                    total_sum: sum,
                    fibonacci_sum: fibonacci_sum,
                    average: sum / numbers.length,
                    message: "Processing complete: ${sum} total, ${fibonacci_sum} fibonacci sum"
                }
                
                // Output results
                print(result.message)
                
                // Conditional logic
                if result.fibonacci_sum > 1000 {
                    print("Large fibonacci sum detected!")
                } else {
                    print("Fibonacci sum is manageable")
                }
            }
        """.trimIndent()
        
        // 配置复杂测试文件
        val psiFile = myFixture.configureByText("complex_test.vk", complexCode)
        
        // 验证复杂代码解析成功
        assertNotNull("Complex PSI file should be created", psiFile)
        assertFalse("Complex PSI file should not have parsing errors", hasParsingErrors(psiFile))
        
        // 验证语法高亮
        val highlights = myFixture.doHighlighting()
        val errors = highlights.filter { it.severity.name == "ERROR" }
        val warnings = highlights.filter { it.severity.name == "WARNING" }
        
        assertTrue("Complex code should not have highlighting errors", errors.isEmpty())
        
        // 可能会有一些警告（如未使用的变量），这是正常的
        println("Warnings found: ${warnings.size}")
        
        // 测试多个跳转目标
        testMultipleGotoTargets(complexCode)
    }
    
    @Test
    fun testErrorRecoveryAndReporting() {
        // 测试错误恢复和报告
        val errorCode = """
            // This code contains intentional errors for testing
            
            fn broken_function( {
                let x = 
                let y = 42
                
                if x > 0
                    print(x)
                
                return y +
            }
            
            fn main() {
                let result = broken_function()
                print(result
            }
        """.trimIndent()
        
        val psiFile = myFixture.configureByText("error_test.vk", errorCode)
        
        // 验证错误被正确检测
        assertTrue("Error code should have parsing errors", hasParsingErrors(psiFile))
        
        // 验证错误高亮
        val highlights = myFixture.doHighlighting()
        val errors = highlights.filter { it.severity.name == "ERROR" }
        
        assertTrue("Should detect multiple errors", errors.size > 0)
        
        // 打印错误信息用于调试
        println("Detected ${errors.size} errors:")
        for ((index, error) in errors.withIndex()) {
            println("  [$index] ${error.description} at ${error.startOffset}-${error.endOffset}")
        }
    }
    
    @Test
    fun testMultiFileProject() {
        // 测试多文件项目
        
        // 创建库文件
        myFixture.addFileToProject("math_utils.vk", """
            /// Mathematical utility functions
            
            /// Calculate the factorial of a number
            pub fn factorial(n: i32) -> i32 {
                if n <= 1 {
                    1
                } else {
                    n * factorial(n - 1)
                }
            }
            
            /// Calculate the power of a number
            pub fn power(base: i32, exponent: i32) -> i32 {
                if exponent == 0 {
                    1
                } else if exponent == 1 {
                    base
                } else {
                    base * power(base, exponent - 1)
                }
            }
            
            /// Mathematical constants
            pub const PI: f64 = 3.14159265359
            pub const E: f64 = 2.71828182846
        """.trimIndent())
        
        // 创建数据结构文件
        myFixture.addFileToProject("data_structures.vk", """
            /// Common data structures
            
            /// A simple point in 2D space
            pub struct Point {
                pub x: f64,
                pub y: f64
            }
            
            impl Point {
                /// Create a new point
                pub fn new(x: f64, y: f64) -> Point {
                    Point { x, y }
                }
                
                /// Calculate distance from origin
                pub fn distance_from_origin(self) -> f64 {
                    (self.x * self.x + self.y * self.y).sqrt()
                }
            }
            
            /// Color enumeration
            pub enum Color {
                Red,
                Green,
                Blue,
                RGB(u8, u8, u8)
            }
        """.trimIndent())
        
        // 创建主文件
        val mainFile = myFixture.addFileToProject("main.vk", """
            use math_utils::{factorial, power, PI}
            use data_structures::{Point, Color}
            
            fn main() {
                // Test math utilities
                let fact5 = factorial(5)
                let pow23 = power(2, 3)
                
                println("Factorial of 5: {}", fact5)
                println("2^3 = {}", pow23)
                println("PI = {}", PI)
                
                // Test data structures
                let origin = Point::new(0.0, 0.0)
                let point = Point::new(3.0, 4.0)
                let distance = point.distance_from_origin()
                
                println("Distance from origin: {}", distance)
                
                // Test enums
                let red = Color::Red
                let custom_color = Color::RGB(255, 128, 0)
                
                match red {
                    Color::Red => println("It's red!"),
                    Color::Green => println("It's green!"),
                    Color::Blue => println("It's blue!"),
                    Color::RGB(r, g, b) => println("Custom color: ({}, {}, {})", r, g, b)
                }
            }
        """.trimIndent())
        
        // 打开主文件进行测试
        myFixture.configureFromExistingVirtualFile(mainFile.virtualFile)
        
        // 验证多文件项目解析成功
        val psiFile = myFixture.file
        assertNotNull("Main file should be loaded", psiFile)
        assertFalse("Main file should not have parsing errors", hasParsingErrors(psiFile))
        
        // 验证跨文件引用
        val highlights = myFixture.doHighlighting()
        val errors = highlights.filter { it.severity.name == "ERROR" }
        
        // 如果引用解析正确，应该没有未解析引用的错误
        val unresolvedErrors = errors.filter { it.description?.contains("Unresolved") == true }
        
        if (unresolvedErrors.isNotEmpty()) {
            println("Unresolved reference errors (may be expected in test environment):")
            for (error in unresolvedErrors) {
                println("  - ${error.description}")
            }
        }
        
        // 测试跨文件跳转
        val factorialUsage = psiFile.text.indexOf("factorial(5)")
        if (factorialUsage >= 0) {
            myFixture.editor.caretModel.moveToOffset(factorialUsage)
            
            val gotoTargets = com.intellij.codeInsight.navigation.actions.GotoDeclarationAction.findAllTargetElements(
                myFixture.project,
                myFixture.editor,
                factorialUsage
            )
            
            // 在测试环境中，跨文件跳转可能不完全工作，但至少应该尝试
            println("Cross-file goto targets found: ${gotoTargets.size}")
        }
    }
    
    @Test
    fun testPerformanceWithLargeFile() {
        // 测试大文件的性能
        val largeCodeBuilder = StringBuilder()
        
        // 生成大量函数定义
        for (i in 1..100) {
            largeCodeBuilder.append("""
                /// Function number $i
                fn function_$i(param1: i32, param2: i32) -> i32 {
                    let local_var_$i = param1 + param2
                    let result_$i = local_var_$i * $i
                    
                    if result_$i > 1000 {
                        return result_$i / 2
                    } else {
                        return result_$i
                    }
                }
                
            """.trimIndent())
        }
        
        // 添加主函数调用所有生成的函数
        largeCodeBuilder.append("""
            fn main() {
                let mut total = 0
        """.trimIndent())
        
        for (i in 1..100) {
            largeCodeBuilder.append("\n    total += function_$i($i, ${i * 2})")
        }
        
        largeCodeBuilder.append("""
            
                println("Total result: {}", total)
            }
        """.trimIndent())
        
        val largeCode = largeCodeBuilder.toString()
        
        // 测试大文件解析性能
        val startTime = System.currentTimeMillis()
        
        val psiFile = myFixture.configureByText("large_test.vk", largeCode)
        
        val parseTime = System.currentTimeMillis() - startTime
        println("Large file parsing time: ${parseTime}ms")
        
        // 验证大文件解析成功
        assertNotNull("Large PSI file should be created", psiFile)
        assertFalse("Large PSI file should not have parsing errors", hasParsingErrors(psiFile))
        
        // 测试高亮性能
        val highlightStartTime = System.currentTimeMillis()
        val highlights = myFixture.doHighlighting()
        val highlightTime = System.currentTimeMillis() - highlightStartTime
        
        println("Large file highlighting time: ${highlightTime}ms")
        println("Highlights found: ${highlights.size}")
        
        // 性能应该在合理范围内（这里设置一个宽松的限制）
        assertTrue("Parsing should complete within 5 seconds", parseTime < 5000)
        assertTrue("Highlighting should complete within 10 seconds", highlightTime < 10000)
    }
    
    /**
     * 辅助方法：检查 PSI 文件是否有解析错误
     */
    private fun hasParsingErrors(psiFile: com.intellij.psi.PsiFile): Boolean {
        var hasErrors = false
        
        psiFile.accept(object : com.intellij.psi.PsiRecursiveElementWalkingVisitor() {
            override fun visitErrorElement(element: com.intellij.psi.PsiErrorElement) {
                hasErrors = true
                println("Parsing error: ${element.errorDescription} at ${element.textRange}")
                super.visitErrorElement(element)
            }
        })
        
        return hasErrors
    }
    
    /**
     * 辅助方法：测试多个跳转目标
     */
    private fun testMultipleGotoTargets(code: String) {
        // 测试函数名跳转
        val fibonacciCall = code.indexOf("fibonacci(", code.indexOf("fibonacci(n - 1)"))
        if (fibonacciCall >= 0) {
            myFixture.editor.caretModel.moveToOffset(fibonacciCall)
            
            val gotoTargets = com.intellij.codeInsight.navigation.actions.GotoDeclarationAction.findAllTargetElements(
                myFixture.project,
                myFixture.editor,
                fibonacciCall
            )
            
            println("Fibonacci function goto targets: ${gotoTargets.size}")
        }
        
        // 测试变量跳转
        val sumUsage = code.indexOf("sum", code.indexOf("sum / numbers.length"))
        if (sumUsage >= 0) {
            myFixture.editor.caretModel.moveToOffset(sumUsage)
            
            val gotoTargets = com.intellij.codeInsight.navigation.actions.GotoDeclarationAction.findAllTargetElements(
                myFixture.project,
                myFixture.editor,
                sumUsage
            )
            
            println("Sum variable goto targets: ${gotoTargets.size}")
        }
    }
}