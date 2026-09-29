package awsl.surface.file

import awsl.surface.lexer.AwslLexer
import com.intellij.lexer.LexerBase

/**
 * AWSL 词法分析器适配器
 *
 * 使用手动实现的 AwslLexer
 */
class AwslLexerAdapter : LexerBase() {

    private val lexer = AwslLexer()

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        lexer.start(buffer, startOffset, endOffset, initialState)
    }

    override fun getState(): Int = lexer.state

    override fun getTokenType() = lexer.tokenType

    override fun getTokenStart(): Int = lexer.tokenStart

    override fun getTokenEnd(): Int = lexer.tokenEnd

    override fun advance() {
        lexer.advance()
    }

    override fun getBufferSequence(): CharSequence = lexer.bufferSequence

    override fun getBufferEnd(): Int = lexer.bufferEnd
}
