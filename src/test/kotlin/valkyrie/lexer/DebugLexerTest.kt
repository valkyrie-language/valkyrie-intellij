package valkyrie.lexer

import org.junit.Test
import valkyrie.psi.ValkyrieLexer
import valkyrie.psi.ValkyrieTokenTypes

class DebugLexerTest {

    @Test
    fun debugEmptyString() {
        val lexer = ValkyrieLexer()

        // 测试空字符串
        lexer.start("\"\"", 0, 2, 0)
        lexer.advance()

        println("Token type: ${lexer.tokenType}")
        if (lexer.tokenType != null) {
            println("Token text: '${lexer.tokenText}'")
            println("Token start: ${lexer.tokenStart}")
            println("Token end: ${lexer.tokenEnd}")
        }
        println("Expected: ${ValkyrieTokenTypes.STRING}")
        println("Actual equals expected: ${lexer.tokenType == ValkyrieTokenTypes.STRING}")
    }

    @Test
    fun debugMultipleTokens() {
        val text = "let empty = \"\""
        val lexer = ValkyrieLexer()
        lexer.start(text, 0, text.length, 0)

        var tokenCount = 0
        lexer.advance() // 先调用一次 advance
        while (lexer.tokenType != null) {
            tokenCount++
            val tokenType = lexer.tokenType
            val start = lexer.tokenStart
            val end = lexer.tokenEnd
            // 检查边界以避免 StringIndexOutOfBoundsException
            val tokenText = if (start >= 0 && end <= text.length && start <= end) {
                lexer.tokenText
            } else {
                "<invalid range>"
            }
            println("Token $tokenCount: type=$tokenType, text='$tokenText', start=$start, end=$end")
            lexer.advance()
            if (tokenCount > 10) break // 防止无限循环
        }
    }
}