package valkyrie.language.lexer

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.TokenIElementType
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
        val Keywords: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            // declare keywords
            ValkyrieLexer.KW_NAMESPACE, ValkyrieLexer.KW_IMPORT,
            ValkyrieLexer.KW_CLASS, ValkyrieLexer.KW_TYPE,
            ValkyrieLexer.KW_UNION, ValkyrieLexer.KW_BITFLAGS,
            ValkyrieLexer.KW_TRAIT, ValkyrieLexer.KW_EXTENDS,
            ValkyrieLexer.KW_FUNCTION,
            ValkyrieLexer.KW_LET,
            // conditional
            ValkyrieLexer.KW_IF, ValkyrieLexer.KW_ELSE,
            // control flow
            ValkyrieLexer.KW_FOR, ValkyrieLexer.KW_IN,
            // pattern match
            ValkyrieLexer.KW_WITCH,
            // control keywords
            ValkyrieLexer.RETURN, ValkyrieLexer.RESUME,
            ValkyrieLexer.YIELD,
            ValkyrieLexer.BREAK, ValkyrieLexer.CONTINUE,
            ValkyrieLexer.RAISE, ValkyrieLexer.CATCH,
            //
            ValkyrieLexer.SPECIAL
        )
        val OperatorInfix: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            ValkyrieLexer.OP_EQ, ValkyrieLexer.OP_NE,
            ValkyrieLexer.OP_ADD, ValkyrieLexer.OP_SUB,
            ValkyrieLexer.OP_MUL, ValkyrieLexer.OP_DIV,
            ValkyrieLexer.LOGIC_OR, ValkyrieLexer.LOGIC_AND
        )
        val Operators = TokenSet.orSet(OperatorInfix);

        val Integers: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.INTEGER);
        val Decimals: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.DECIMAL);
        val Identifiers: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, ValkyrieLexer.UNICODE_ID);
        val BraceL: TokenIElementType = TokenIElementType(ValkyrieLexer.BRACE_L, "{", ValkyrieLanguage);
        val BraceR: TokenIElementType = TokenIElementType(ValkyrieLexer.BRACE_R, "}", ValkyrieLanguage);
        val BracketL: TokenIElementType = TokenIElementType(ValkyrieLexer.BRACKET_L, "[", ValkyrieLanguage);
        val BracketR: TokenIElementType = TokenIElementType(ValkyrieLexer.BRACKET_R, "]", ValkyrieLanguage);
        val ParenthesisL: TokenIElementType = TokenIElementType(ValkyrieLexer.PARENTHESES_L, ")", ValkyrieLanguage);
        val ParenthesisR: TokenIElementType = TokenIElementType(ValkyrieLexer.PARENTHESES_R, "(", ValkyrieLanguage);
        val CommentLine: TokenIElementType = TokenIElementType(ValkyrieLexer.LINE_COMMENT, "CommentLine", ValkyrieLanguage);
        val CommentBlock: TokenIElementType = TokenIElementType(ValkyrieLexer.BLOCK_COMMENT, "CommentBlock", ValkyrieLanguage);
        val Comments = TokenSet.create(CommentBlock, CommentLine);
        val CompletionWords: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            ValkyrieLexer.KW_IF,
            ValkyrieLexer.KW_ELSE,
        )
    }
}
