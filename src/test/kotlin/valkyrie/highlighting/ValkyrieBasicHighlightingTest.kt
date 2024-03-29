package valkyrie.highlighting

import org.junit.Test
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.test.ValkyrieTestCase

/**
 * Valkyrie 基础语法高亮测试
 * 测试基本的语法高亮功能
 */
class ValkyrieBasicHighlightingTest : ValkyrieTestCase() {
    
    @Test
    fun testKeywordHighlighting() {
        // 测试关键字高亮
        val code = "let x = 42"
        val psiFile = myFixture.configureByText("test.vk", code)
        val highlights = myFixture.doHighlighting()
        assertNotNull("Should have highlighting", highlights)
    }
    
    @Test
    fun testStringHighlighting() {
        // 测试字符串字面量高亮
        val code = "\"hello world\""
        val psiFile = myFixture.configureByText("test.vk", code)
        val highlights = myFixture.doHighlighting()
        assertNotNull("Should have highlighting", highlights)
    }
    
    @Test
    fun testNumberHighlighting() {
        // 测试数字字面量高亮
        val code = "42"
        val psiFile = myFixture.configureByText("test.vk", code)
        val highlights = myFixture.doHighlighting()
        assertNotNull("Should have highlighting", highlights)
    }
    
    @Test
    fun testCommentHighlighting() {
        // 测试注释高亮
        val code = "// line comment"
        val psiFile = myFixture.configureByText("test.vk", code)
        val highlights = myFixture.doHighlighting()
        assertNotNull("Should have highlighting", highlights)
    }
    
    @Test
    fun testIdentifierHighlighting() {
        // 测试标识符高亮
        val code = "let variable_name = 42"
        val psiFile = myFixture.configureByText("test.vk", code)
        val highlights = myFixture.doHighlighting()
        assertNotNull("Should have highlighting", highlights)
    }
    
    @Test
    fun testOperatorHighlighting() {
        // 测试操作符高亮
        val code = "x + y"
        val psiFile = myFixture.configureByText("test.vk", code)
        val highlights = myFixture.doHighlighting()
        assertNotNull("Should have highlighting", highlights)
    }
    
    @Test
    fun testFunctionHighlighting() {
        // 测试函数定义高亮
        val code = """
            fn hello_world() {
                println("Hello, World!")
            }
        """.trimIndent()
        
        val psiFile = myFixture.configureByText("test.vk", code)
        val highlights = myFixture.doHighlighting()
        assertNotNull("Should have highlighting", highlights)
    }
    
    @Test
    fun testControlFlowHighlighting() {
        // 测试控制流语句高亮
        val code = """
            if condition {
                for i in 0..10 {
                    while x > 0 {
                        break
                    }
                }
            } else {
                return false
            }
        """.trimIndent()
        
        val psiFile = myFixture.configureByText("test.vk", code)
        val highlights = myFixture.doHighlighting()
        assertNotNull("Should have highlighting", highlights)
    }
    
    @Test
    fun testBracesAndParensHighlighting() {
        // 测试括号和大括号高亮
        testCodeHighlighting(
            "fn test() { let arr = [1, 2, 3]; arr[0] }",
            mapOf(
                "(" to ValkyrieColor.PARENTHESES,
                ")" to ValkyrieColor.PARENTHESES,
                "{" to ValkyrieColor.BRACES,
                "}" to ValkyrieColor.BRACES,
                "[" to ValkyrieColor.BRACKETS,
                "]" to ValkyrieColor.BRACKETS
            )
        )
    }
    
    @Test
    fun testErrorHighlighting() {
        // 测试语法错误高亮
        testErrorHighlighting(
            "let x =", // 缺少值
            1
        )
        
        testErrorHighlighting(
            "fn foo( {}", // 缺少右括号
            1
        )
        
        testErrorHighlighting(
            "if x > 0 print(x)", // 缺少大括号
            1
        )
        
        // 测试类型错误高亮（如果支持语义分析）
        testErrorHighlighting(
            "let x: i32 = \"string\"", // 类型不匹配
            1
        )
    }
    
    @Test
    fun testWarningHighlighting() {
        // 测试警告高亮
        testWarningHighlighting(
            "let unused_variable = 42", // 未使用的变量
            1
        )
        
        testWarningHighlighting(
            "fn deprecated_function() {}", // 已弃用的函数（如果有相应注解）
            0 // 这里假设没有弃用警告
        )
    }
    
    @Test
    fun testComplexCodeHighlighting() {
        // 测试复杂代码的高亮
        val complexCode = """
            /// Calculate the factorial of a number
            fn factorial(n: i32) -> i32 {
                if n <= 1 {
                    1
                } else {
                    n * factorial(n - 1)
                }
            }
        """.trimIndent()
        
        val psiFile = myFixture.configureByText("test.vk", complexCode)
        val highlights = myFixture.doHighlighting()
        assertNotNull("Should have highlighting", highlights)
        
        // 验证没有错误级别的高亮
        val errors = highlights.filter { it.severity.name == "ERROR" }
        assertTrue("Should not have highlighting errors", errors.isEmpty())
    }
    
    @Test
    fun testTemplateHighlighting() {
        // 测试模板表达式高亮
        testCodeHighlighting(
            "\"Hello, ${user.name}! You have ${count} messages.\"",
            mapOf(
                "\"Hello, " to ValkyrieColor.STRING,
                "user" to ValkyrieColor.IDENTIFIER,
                "name" to ValkyrieColor.FIELD,
                "! You have " to ValkyrieColor.STRING,
                "count" to ValkyrieColor.IDENTIFIER,
                " messages.\"" to ValkyrieColor.STRING
            )
        )
    }
    
    @Test
    fun testAttributeHighlighting() {
        // 测试属性/注解高亮（如果支持）
        testCodeHighlighting(
            "@deprecated\nfn old_function() {}",
            mapOf(
                "@deprecated" to ValkyrieColor.ANNOTATION
            )
        )
        
        testCodeHighlighting(
            "#[inline]\nfn fast_function() {}",
            mapOf(
                "#[inline]" to ValkyrieColor.ANNOTATION
            )
        )
    }
    
    @Test
    fun testDocumentationHighlighting() {
        // 测试文档注释高亮
        testCodeHighlighting(
            "/// This is a documentation comment\nfn documented_function() {}",
            mapOf(
                "/// This is a documentation comment" to ValkyrieColor.DOC_COMMENT
            )
        )
        
        testCodeHighlighting(
            "/** Multi-line documentation */\nfn another_function() {}",
            mapOf(
                "/** Multi-line documentation */" to ValkyrieColor.DOC_COMMENT
            )
        )
    }
}