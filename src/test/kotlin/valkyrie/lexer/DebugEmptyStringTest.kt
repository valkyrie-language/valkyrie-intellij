package valkyrie.lexer

import org.junit.Test
import valkyrie.psi.lexers.ValkyrieStandardLexer

class DebugEmptyStringTest {

    @Test
    fun debugEmptyString() {
        val lexer = ValkyrieStandardLexer()
        
        // 测试空字符串 ""
        lexer.start("\"\"", 0, 2, 0)
        
        println("Input: \"\"")
        println("Buffer length: ${lexer.bufferEnd}")
        println("Current offset: ${lexer.tokenStart}")
        println("Token type: ${lexer.tokenType}")
        
        // 安全获取 tokenText
        val tokenText = try {
            lexer.tokenText
        } catch (e: Exception) {
            "<error: ${e.message}>"
        }
        println("Token text: '$tokenText'")
        println("Token start: ${lexer.tokenStart}")
        println("Token end: ${lexer.tokenEnd}")
        
        // 检查 peek 行为
        val testLexer = ValkyrieStandardLexer()
        testLexer.start("\"\"", 0, 2, 0)
        
        // 模拟 lexer 内部逻辑
        println("\n--- Debug peek behavior ---")
        println("Buffer: '${testLexer.bufferSequence}'")
        println("Buffer length: ${testLexer.bufferEnd}")
        
        // 手动检查 peek 逻辑
        val buffer = testLexer.bufferSequence
        val currentOffset = 0
        val endOffset = testLexer.bufferEnd
        
        println("Character at position 0: '${buffer[0]}'")
        if (currentOffset + 1 < endOffset) {
            println("Character at position 1: '${buffer[1]}'")
        } else {
            println("Position 1 is out of bounds")
        }
        
        if (currentOffset + 2 < endOffset) {
            println("Character at position 2: '${buffer[2]}'")
        } else {
            println("Position 2 is out of bounds")
        }
        
        // 检查三引号判断逻辑
        val ch = buffer[0]
        println("\n--- Triple quote check ---")
        println("ch == '\"': ${ch == '\"'}")
        
        fun peek(offset: Int): Char? {
            val pos = currentOffset + offset
            return if (pos < endOffset) buffer[pos] else null
        }
        
        println("peek(0): ${peek(0)}")
        println("peek(1): ${peek(1)}")
        println("peek(0) == '\"': ${peek(0) == '\"'}")
        println("peek(1) == '\"': ${peek(1) == '\"'}")
        println("Triple quote condition: ${peek(0) == '\"' && peek(1) == '\"'}")
    }
    
    @Test
    fun debugTripleQuoteString() {
        val lexer = ValkyrieStandardLexer()
        
        // 测试三引号字符串
        lexer.start("\"\"\"\"\"\"", 0, 6, 0)
        
        println("\n=== Triple Quote String Test ===")
        println("Input: \"\"\"\"\"\"")
        println("Token type: ${lexer.tokenType}")
        println("Token text: '${lexer.tokenText}'")
    }
}