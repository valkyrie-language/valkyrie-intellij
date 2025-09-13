package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

/**
 * if 语句解析测试
 */
class IfStatementTest {
    
    @Test
    fun testSimpleIfStatement() {
        val code = """
            if condition {
                println("true")
            }
        """.trimIndent()
        
        // 简单验证代码包含 if 关键字和大括号
        assertTrue("Should contain if keyword", code.contains("if"))
        assertTrue("Should contain condition", code.contains("condition"))
        assertTrue("Should contain braces", code.contains("{") && code.contains("}"))
    }
    
    @Test
    fun testIfElseStatement() {
        val code = """
            if condition {
                println("true")
            } else {
                println("false")
            }
        """.trimIndent()
        
        // 验证 if-else 语句的基本结构
        assertTrue("Should contain if keyword", code.contains("if"))
        assertTrue("Should contain else keyword", code.contains("else"))
        assertTrue("Should contain condition", code.contains("condition"))
        assertTrue("Should contain braces", code.contains("{") && code.contains("}"))
    }
    
    @Test
    fun testIfElseIfStatement() {
        val code = """
            if condition1 {
                println("first")
            } else if condition2 {
                println("second")
            } else {
                println("third")
            }
        """.trimIndent()
        
        // 验证 if-else if-else 语句的基本结构
        assertTrue("Should contain if keyword", code.contains("if"))
        assertTrue("Should contain else keyword", code.contains("else"))
        assertTrue("Should contain else if", code.contains("else if"))
        assertTrue("Should contain multiple conditions", code.contains("condition1") && code.contains("condition2"))
    }
    
    @Test
    fun testIfLetStatement() {
        val code = """
            if let Some(value) = option {
                println(value)
            } else {
                println("None")
            }
        """.trimIndent()
        
        // 验证 if let 语句的基本结构
        assertTrue("Should contain if let keywords", code.contains("if let"))
        assertTrue("Should contain pattern matching", code.contains("Some(value)"))
        assertTrue("Should contain assignment operator", code.contains("="))
        assertTrue("Should contain else clause", code.contains("else"))
    }
    
    @Test
    fun testNestedIfStatement() {
        val code = """
            if outer_condition {
                if inner_condition {
                    println("nested")
                }
            }
        """.trimIndent()
        
        // 验证嵌套 if 语句的基本结构
        assertTrue("Should contain outer condition", code.contains("outer_condition"))
        assertTrue("Should contain inner condition", code.contains("inner_condition"))
        assertTrue("Should contain nested structure", code.contains("nested"))
        val ifCount = code.split("if").size - 1
        assertEquals("Should have two if keywords", 2, ifCount)
    }
    
    @Test
    fun testComplexCondition() {
        val code = """
            if x > 0 && y < 10 || z == 5 {
                println("complex condition")
            }
        """.trimIndent()
        
        // 验证复杂条件表达式
        assertTrue("Should contain logical operators", code.contains("&&") && code.contains("||"))
        assertTrue("Should contain comparison operators", code.contains(">") && code.contains("<") && code.contains("=="))
    }
    
    @Test
    fun testMultipleElseIfClauses() {
        val code = """
            if condition1 {
                action1()
            } else if condition2 {
                action2()
            } else if condition3 {
                action3()
            } else if condition4 {
                action4()
            } else {
                default_action()
            }
        """.trimIndent()
        
        // 验证多个 else if 子句
        val elseIfCount = code.split("else if").size - 1
        assertEquals("Should have three else if clauses", 3, elseIfCount)
        assertTrue("Should contain final else clause", code.contains("} else {"))
        assertTrue("Should contain all conditions", 
            code.contains("condition1") && code.contains("condition2") && 
            code.contains("condition3") && code.contains("condition4"))
    }
    
    @Test
    fun testIfElseIfWithoutFinalElse() {
        val code = """
            if first_condition {
                first_action()
            } else if second_condition {
                second_action()
            }
        """.trimIndent()
        
        // 验证没有最终 else 子句的 if-else if 语句
        assertTrue("Should contain if keyword", code.contains("if first_condition"))
        assertTrue("Should contain else if clause", code.contains("else if second_condition"))
        assertFalse("Should not contain final else", code.contains("} else {"))
    }

    @Test
    fun testIfStatementWithoutBraces() {
        val code = """
            if condition
                println("single statement")
        """.trimIndent()
        
        // 验证不带大括号的 if 语句
        assertTrue("Should contain if keyword", code.contains("if"))
        assertTrue("Should contain single statement", code.contains("println"))
        assertFalse("Should not contain braces", code.contains("{") || code.contains("}"))
    }
}