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


internal object AntlrLexerFactory {
    init {
        PSIElementTypeFactory.defineLanguageIElementTypes(
            ValkyrieLanguage,
            ValkyrieAntlrParser.tokenNames,
            ValkyrieAntlrParser.ruleNames
        )
    }

    fun createLexer(lexer: org.antlr.v4.runtime.Lexer?): ANTLRLexerAdaptor {
        return ANTLRLexerAdaptor(ValkyrieLanguage, lexer)
    }
}

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

        val Keywords: TokenSet = ValkyrieLanguage.createTokenSet(

            // declare keywords
            KW_NAMESPACE, KW_IMPORT, KW_AS,
            KW_CLASS, KW_TYPE,
            KW_UNION, KW_FLAGS,
            KW_TRAIT, KW_EXTENDS,
            KW_FUNCTION, KW_LAMBDA,
            KW_LET, OP_BIND,
            //
            KW_TEMPLATE,
            KW_IMPLEMENTS, KW_WHERE,
            // conditional
            KW_IF, KW_ELSE, LAMBDA_SLOT,
            // control flow
            KW_WHILE,
            KW_FOR, KW_IN,
            // which/match/catch
            KW_MATCH,
            KW_WITH, KW_WHEN, KW_CASE,
            KW_TRY,
            // control keywords
            RETURN, RESUME,
            YIELD,
            BREAK, CONTINUE, FALL_THROUGH,
            RAISE,
            // monadic
            OP_AND_THEN, OP_OR_ELSE, OP_OR_DEFAULT,
            //
            KW_NEW, KW_OBJECT,
            KW_NOT, KW_IS,
            // special
            OP_LAST, SPECIAL,
        )
        val OperatorPrefix: TokenSet = ValkyrieLanguage.createTokenSet(

            OP_NOT, OP_DOT2, OP_DOT3, OP_REFERENCE, MAIN_PREFIX
        )
        val OperatorInfix: TokenSet = ValkyrieLanguage.createTokenSet(

            OP_ADD, OP_SUB,
            OP_MUL,
            OP_DIV, OP_REM, OP_DIV_REM,
            OP_POW,
            LOGIC_OR, LOGIC_AND, LOGIC_XOR, LOGIC_NOR, LOGIC_NAND, LOGIC_XAND,
            OP_OR, OP_AND,
            OP_EQ, OP_NE, OP_EEE, OP_NEE,
            OP_LT, OP_LEQ, OP_LL, OP_LLL,
            OP_GT, OP_GEQ, OP_GG, OP_GGG,
            OP_LLE, OP_GGE,
            OP_UNTIL,
            OP_IN, OP_NOT_IN,
            OP_IS, OP_IS_NOT,
            OP_MAP, OP_APPLY2, OP_APPLY3,
            OP_ARROW,
            //
            OP_ASSIGN, OP_MAY_ASSIGN,
            OP_ADD_ASSIGN, OP_SUB_ASSIGN, OP_DIV_ASSIGN, OP_MUL_ASSIGN
        )
        val OperatorSuffix: TokenSet = ValkyrieLanguage.createTokenSet(

            MAIN_SUFFIX, OP_PERCENT, OP_TRANSPOSE
        )
        val Operators = TokenSet.orSet(OperatorPrefix, OperatorInfix, OperatorSuffix);
        val MacroOperators = ValkyrieLanguage.createTokenSet(OP_HASH, OP_AT, OP_UNIMPLEMENTED);

        val Comma: TokenSet = ValkyrieLanguage.createTokenSet(COMMA);
        val Semicolon: TokenSet = ValkyrieLanguage.createTokenSet(SEMICOLON);
        val Dot = TokenIElementType(DOT, ".", ValkyrieLanguage);
        val Proportion = TokenIElementType(OP_PROPORTION, ".", ValkyrieLanguage);
        val Integers: TokenSet = ValkyrieLanguage.createTokenSet(INTEGER);
        val Decimals: TokenSet = ValkyrieLanguage.createTokenSet(DECIMAL);
        val Strings: TokenSet = ValkyrieLanguage.createTokenSet(STRING_START, STRING_END, STRING_TEXT);
        val Identifiers: TokenSet = ValkyrieLanguage.createTokenSet(UNICODE_ID);

        val CommentLine = TokenIElementType(LINE_COMMENT, "CommentLine", ValkyrieLanguage);
        val CommentBlock = TokenIElementType(BLOCK_COMMENT, "CommentBlock", ValkyrieLanguage);
        val Comments: TokenSet = ValkyrieLanguage.createTokenSet(LINE_COMMENT, BLOCK_COMMENT);
        val CompletionWords: TokenSet = ValkyrieLanguage.createTokenSet(
            KW_IF,
            KW_ELSE,
            KW_TRAIT,
            UNICODE_ID,
        )
    }
}
