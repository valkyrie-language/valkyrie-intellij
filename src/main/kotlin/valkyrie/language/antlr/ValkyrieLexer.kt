package valkyrie.language.antlr

import com.intellij.lexer.Lexer
import com.intellij.lexer.LexerPosition
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import org.antlr.intellij.adaptor.lexer.ANTLRLexerAdaptor
import org.antlr.intellij.adaptor.lexer.PSIElementTypeFactory
import org.antlr.intellij.adaptor.lexer.TokenIElementType
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.antlr.ValkyrieAntlrLexer.*

class ValkyrieLexer : Lexer() {
    private var adaptor: ANTLRLexerAdaptor

    init {
        val lexer = ValkyrieAntlrLexer(null)
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
            KW_NAMESPACE, KW_IMPORT, KW_AS,
            KW_CLASS, KW_TYPE,
            KW_UNION, KW_BITFLAGS,
            KW_TRAIT, KW_EXTENDS,
            KW_FUNCTION, KW_LAMBDA,
            KW_LET,
            //
            KW_TEMPLATE, KW_WHERE,
            // conditional
            KW_IF, KW_ELSE,
            // control flow
            KW_WHILE,
            KW_FOR, KW_IN,
            // which/match/catch
            KW_WITCH, KW_MATCH, KW_CATCH,
            KW_WITH, KW_WHEN, KW_CASE,
            KW_TRY,
            // control keywords
            RETURN, RESUME,
            YIELD,
            BREAK, CONTINUE,
            RAISE,
            //
            KW_NEW, KW_OBJECT,
            SPECIAL,
            OP_AND_THEN, OP_OR_ELSE, OP_OR_DEFAULT, KW_NOT, KW_IS,
        )
        val OperatorPrefix: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            OP_NOT, OP_DECONSTRUCT, OP_REFERENCE, OP_INVERSE, OP_ROOT3, OP_ROOT4
        )
        val OperatorInfix: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            OP_ADD, OP_SUB,
            OP_MUL,
            OP_DIV, OP_REM, OP_DIV_REM,
            OP_POW,
            LOGIC_OR, LOGIC_AND, LOGIC_XOR, LOGIC_NOR, LOGIC_NAND, LOGIC_XAND,
            OP_OR, OP_AND, OP_BIND,
            OP_EQ, OP_NE, OP_EEE, OP_NEE,
            OP_LT, OP_LEQ, OP_LL, OP_LLL,
            OP_GT, OP_GEQ, OP_GG, OP_GGG,
            OP_LLE, OP_GGE,
            OP_UNTIL,
            OP_IN, OP_NOT_IN,
            OP_IS, OP_IS_NOT,
            OP_MAP, OP_APPLY2, OP_APPLY3
        )
        val OperatorSuffix: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            OP_TEMPERATURE, OP_PERCENT, OP_TRANSPOSE
        )
        val Operators = TokenSet.orSet(OperatorPrefix, OperatorInfix, OperatorSuffix);
        val MacroOperators = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, OP_HASH, OP_AT);

        val Comma: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, COMMA);
        val Semicolon: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, SEMICOLON);
        val Dot = TokenIElementType(DOT, ".", ValkyrieLanguage);
        val Proportion = TokenIElementType(OP_PROPORTION, ".", ValkyrieLanguage);
        val Integers: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, INTEGER);
        val Decimals: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, DECIMAL);
        val Strings: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, STRING_SINGLE, STRING_DOUBLE);
        val Identifiers: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, UNICODE_ID);

        val CommentLine = TokenIElementType(LINE_COMMENT, "CommentLine", ValkyrieLanguage);
        val CommentBlock = TokenIElementType(BLOCK_COMMENT, "CommentBlock", ValkyrieLanguage);
        val Comments: TokenSet = PSIElementTypeFactory.createTokenSet(ValkyrieLanguage, LINE_COMMENT, BLOCK_COMMENT);
        val CompletionWords: TokenSet = PSIElementTypeFactory.createTokenSet(
            ValkyrieLanguage,
            KW_IF,
            KW_ELSE,
            KW_TRAIT,
            UNICODE_ID,
        )
    }
}
