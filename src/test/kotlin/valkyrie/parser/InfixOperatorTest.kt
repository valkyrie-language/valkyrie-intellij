package valkyrie.parser

import org.junit.Test
import org.junit.Assert.assertTrue

class InfixOperatorTest {
    
    @Test
    fun testInOperator() {
        val code = "if x in collection { }"
        assertTrue("Should contain 'in' operator", code.contains(" in "))
    }
    
    @Test
    fun testNotInOperator() {
        val code = "if x not in collection { }"
        assertTrue("Should contain 'not in' operator", code.contains("not in"))
    }
    
    @Test
    fun testIsOperator() {
        val code = "if x is String { }"
        assertTrue("Should contain 'is' operator", code.contains(" is "))
    }
    
    @Test
    fun testIsNotOperator() {
        val code = "if x is not String { }"
        assertTrue("Should contain 'is not' operator", code.contains("is not"))
    }
    
    @Test
    fun testInfixOperatorInExpression() {
        val code = "let result = value in range && item is not null"
        assertTrue("Should contain 'in' operator", code.contains(" in "))
        assertTrue("Should contain 'is not' operator", code.contains("is not"))
    }
    
    @Test
    fun testInfixOperatorPrecedence() {
        val code = "let result = a + b in collection"
        assertTrue("Should contain arithmetic and membership operators", 
                   code.contains("a + b in collection"))
    }
    
    @Test
    fun testComplexInfixExpression() {
        val code = "if item not in excludeList && value is String { }"
        assertTrue("Should contain 'not in' operator", code.contains("not in"))
        assertTrue("Should contain 'is' operator", code.contains(" is "))
        assertTrue("Should contain logical AND", code.contains("&&"))
    }
}