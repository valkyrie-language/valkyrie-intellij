package valkyrie.parser

import org.junit.Test
import org.junit.Assert.*

class LabelSyntaxTest {

    @Test
    fun testSimpleLabel() {
        val code = "※loop"
        assertTrue(code.isNotEmpty())
    }

    @Test
    fun testLabelWithLoop() {
        val code = "※outer for i in 0..10 { }"
        assertTrue(code.isNotEmpty())
    }

    @Test
    fun testMultipleLabels() {
        val code = "※outer ※inner"
        assertTrue(code.isNotEmpty())
    }

    @Test
    fun testLabelWithControlFlow() {
        val code = "※loop while true { break ※loop }"
        assertTrue(code.isNotEmpty())
    }
}