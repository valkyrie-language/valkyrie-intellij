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
            KW_FUNCTION, KW_LAMBDA,
            KW_LET,
            // conditional
            KW_IF, KW_ELSE,
            // control flow
            KW_WHILE,
            KW_FOR, KW_IN,
            // pattern match
            KW_MATCH, KW_WITCH,
            KW_WITH, KW_WHEN,
            // control keywords
            RETURN, RESUME,
            YIELD,
            BREAK, CONTINUE,
            RAISE,
            //
            SPECIAL,
            OP_THROW
        )
        val OperatorPrefix: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            OP_NOT,
        )
        val OperatorInfix: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            OP_EQ, OP_NE,
            OP_ADD, OP_SUB,
            OP_MUL, OP_DIV,
            LOGIC_OR, LOGIC_AND,
            OP_LEQ, OP_LL, OP_LLL,
            OP_GEQ, OP_GG, OP_GGG,
        )
        val OperatorSuffix: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            OP_TEMPERATURE,
        )
        val Operators = TokenSet.orSet(OperatorPrefix, OperatorInfix, OperatorSuffix);

        val Comma = TokenIElementType(COMMA, ",", ValkyrieLanguage);
        val Semicolon = TokenIElementType(SEMICOLON, ",", ValkyrieLanguage);
        val Dot = TokenIElementType(DOT, ".", ValkyrieLanguage);
        val Proportion = TokenIElementType(OP_PROPORTION, ".", ValkyrieLanguage);
        val Integers: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, INTEGER);
        val Decimals: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, DECIMAL);
        val Identifiers: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, UNICODE_ID);

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
