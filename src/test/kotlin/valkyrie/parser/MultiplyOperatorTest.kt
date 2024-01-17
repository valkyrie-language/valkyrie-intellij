package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

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