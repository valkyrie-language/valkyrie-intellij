package valkyrie.language.lexer

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieLexer

class ValkyrieProgramLexer : Lexer() {
    private var adaptor: ANTLRLexerAdaptor

    init {
        val lexer = ValkyrieLexer(null)
        this.adaptor = ANTLRLexerAdaptor(ValkyrieLanguage, lexer)
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        return adaptor.start(buffer, startOffset, endOffset, initialState)
    }

    override fun getState(): Int {
        return adaptor.state
    }

    override fun getTokenType(): IElementType? {
        return adaptor.tokenType
    }

    override fun getTokenStart(): Int {
        return adaptor.tokenStart
    }

    override fun getTokenEnd(): Int {
        return adaptor.tokenEnd
    }

    override fun advance() {
        adaptor.advance()
    }

    override fun getCurrentPosition(): LexerPosition {
        return adaptor.currentPosition
    }

    override fun restore(position: LexerPosition) {
        adaptor.restore(position)
    }

    override fun getBufferSequence(): CharSequence {
        return adaptor.bufferSequence
    }

    override fun getBufferEnd(): Int {
        return adaptor.bufferEnd
    }

    companion object {
        val Keywords: TokenSet = getKeywords();
        val Integers: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.INTEGER);
        val Decimals: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.DECIMAL);
        val CommentLine: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.LINE_COMMENT);
        val CommentBlock: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.COMMENT);
    }
}
// PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.COMMENT, ValkyrieLexer.LINE_COMMENT)
private fun getKeywords(): TokenSet {
    return PSIElementTypeFactory.createTokenSet(
        ValkyrieLanguage,
        // declare keywords
        ValkyrieLexer.KW_NAMESPACE,
        ValkyrieLexer.KW_CLASS,
        ValkyrieLexer.KW_TRAIT,
        ValkyrieLexer.KW_FUNCTION,
        ValkyrieLexer.KW_LET,
        // control keywords
        ValkyrieLexer.RETURN,
        ValkyrieLexer.RESUME,
        ValkyrieLexer.YIELD,
        ValkyrieLexer.BREAK,
        ValkyrieLexer.CONTINUE,
        ValkyrieLexer.RAISE,
        ValkyrieLexer.CATCH,
        //
    )
}
