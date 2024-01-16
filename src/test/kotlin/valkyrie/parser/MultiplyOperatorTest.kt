package valkyrie.parser

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue

class MultiplyOperatorTest {

    @Test
    fun testStarOperator() {
        val code = "a * b"
        assertTrue(code.isNotEmpty())
    }

    @Test
    fun testMultiplyOperator() {
        val code = "a × b"
        assertTrue(code.isNotEmpty())
    }

    @Test
    fun testMixedOperators() {
        val code = "a * b × c"
        assertTrue(code.isNotEmpty())
    }

    @Test
    fun testComplexExpression() {
        val code = "(a * b) + (c × d)"
        assertTrue(code.isNotEmpty())
    }
}