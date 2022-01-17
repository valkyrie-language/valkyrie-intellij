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
import valkyrie.language.antlr.ValkyrieLexer.*

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
            KW_NAMESPACE, KW_IMPORT,
            KW_CLASS, KW_TYPE,
            KW_UNION, KW_BITFLAGS,
            KW_TRAIT, KW_EXTENDS,
            KW_FUNCTION,
            KW_LET,
            // conditional
            KW_IF, KW_ELSE,
            // control flow
            KW_WHILE,
            KW_FOR, KW_IN,
            // pattern match
            KW_WITCH,
            // control keywords
            RETURN, RESUME,
            YIELD,
            BREAK, CONTINUE,
            RAISE, CATCH,
            //
            SPECIAL
        )
        val OperatorInfix: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            OP_EQ, OP_NE,
            OP_ADD, OP_SUB,
            OP_MUL, OP_DIV,
            LOGIC_OR, LOGIC_AND,
            OP_LE, OP_LEQ, OP_LL, OP_LLL,
            OP_GE, OP_GEQ, OP_GG, OP_GGG,
        )
        val Operators = TokenSet.orSet(OperatorInfix);

        val Integers: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, INTEGER);
        val Decimals: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, DECIMAL);
        val Identifiers: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, UNICODE_ID);
        val BraceL = TokenIElementType(BRACE_L, "{", ValkyrieLanguage);
        val BraceR = TokenIElementType(BRACE_R, "}", ValkyrieLanguage);
        val BracketL = TokenIElementType(BRACKET_L, "[", ValkyrieLanguage);
        val BracketR = TokenIElementType(BRACKET_R, "]", ValkyrieLanguage);
        val ParenthesisL = TokenIElementType(PARENTHESES_L, ")", ValkyrieLanguage);
        val ParenthesisR = TokenIElementType(PARENTHESES_R, "(", ValkyrieLanguage);
        val CommentLine = TokenIElementType(LINE_COMMENT, "CommentLine", ValkyrieLanguage);
        val CommentBlock = TokenIElementType(BLOCK_COMMENT, "CommentBlock", ValkyrieLanguage);
        val Comments = TokenSet.create(CommentBlock, CommentLine);
        val CompletionWords: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            KW_IF,
            KW_ELSE,
            KW_TRAIT,
            UNICODE_ID,
        )

    }
}
