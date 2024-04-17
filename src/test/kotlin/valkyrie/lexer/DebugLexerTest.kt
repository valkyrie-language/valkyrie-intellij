package valkyrie.lexer

import org.junit.Test
import valkyrie.psi.lexers.ValkyrieStandardLexer
import valkyrie.psi.lexers.ValkyrieTokenTypes

class DebugLexerTest {

    @Test
    fun testDebugEmptyString() {
        val lexer = ValkyrieStandardLexer()

        // 测试空字符串
        lexer.start("\"\"", 0, 2, 0)
        lexer.advance()

        println("Token type: ${lexer.tokenType}")
        if (lexer.tokenType != null) {
            println("Token text: '${lexer.tokenText}'")
            println("Token start: ${lexer.tokenStart}")
            println("Token end: ${lexer.tokenEnd}")
        }
        println("Expected: ${ValkyrieTokenTypes.STRING_DQ}")
        println("Actual equals expected: ${lexer.tokenType == ValkyrieTokenTypes.STRING_DQ}")
    }

    @Test
    fun testDebugStringWithContent() {
        val lexer = ValkyrieStandardLexer()

        // 测试空字符串
        lexer.start("\"\"", 0, 2, 0)
        lexer.advance()

        println("Token type: ${lexer.tokenType}")
        if (lexer.tokenType != null) {
            println("Token text: '${lexer.tokenText}'")
            println("Token start: ${lexer.tokenStart}")
            println("Token end: ${lexer.tokenEnd}")
        }
        println("Expected: ${ValkyrieTokenTypes.STRING_DQ}")
        println("Actual equals expected: ${lexer.tokenType == ValkyrieTokenTypes.STRING_DQ}")
    }

    @Test
    fun debugMultipleTokens() {
        val text = "let empty = \"\""
        val lexer = ValkyrieStandardLexer()
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