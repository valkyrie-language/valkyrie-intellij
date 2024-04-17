package valkyrie.lexer

import org.junit.Test
import valkyrie.psi.lexers.ValkyrieStandardLexer

class DetailedDebugTest {
    
    @Test
    fun detailedDebugEmptyString() {
        val lexer = ValkyrieStandardLexer()
        val text = "\"\""
        
        println("Testing text: '$text'")
        println("Text length: ${text.length}")
        
        lexer.start(text, 0, text.length, 0)
        
        println("After start():")
        println("  tokenType: ${lexer.tokenType}")
        println("  tokenStart: ${lexer.tokenStart}")
        println("  tokenEnd: ${lexer.tokenEnd}")
        println("  bufferEnd: ${lexer.bufferEnd}")
        
        lexer.advance()
        
        println("After advance():")
        println("  tokenType: ${lexer.tokenType}")
        println("  tokenStart: ${lexer.tokenStart}")
        println("  tokenEnd: ${lexer.tokenEnd}")
        
        if (lexer.tokenType != null) {
            try {
                println("  tokenText: '${lexer.tokenText}'")
            } catch (e: Exception) {
                println("  tokenText: ERROR - ${e.message}")
            }
        }
    }
    
    @Test
    fun detailedDebugStringWithContent() {
        val lexer = ValkyrieStandardLexer()
        val text = "''"
        
        println("Testing char literal: '$text'")
        println("Text length: ${text.length}")
        
        lexer.start(text, 0, text.length, 0)
        
        println("After start():")
        println("  tokenType: ${lexer.tokenType}")
        
        lexer.advance()
        
        println("After advance():")
        println("  tokenType: ${lexer.tokenType}")
        println("  tokenStart: ${lexer.tokenStart}")
        println("  tokenEnd: ${lexer.tokenEnd}")
        
        if (lexer.tokenType != null) {
            try {
                println("  tokenText: '${lexer.tokenText}'")
            } catch (e: Exception) {
                println("  tokenText: ERROR - ${e.message}")
            }
        }
    }
}