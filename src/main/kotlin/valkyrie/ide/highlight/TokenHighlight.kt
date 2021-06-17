package valkyrie.ide.highlight


import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import valkyrie.language.lexer.ValkyrieLexerAdapter
import valkyrie.language.psi.ValkyrieTypes.*
import valkyrie.ide.highlight.ValkyrieHighlightColor as Color

class TokenHighlight : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return ValkyrieLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType)?.textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType): Color? {
        return when (tokenType) {
            // Keywords
            KW_NAMESPACE, KW_EXTENSION, KW_IMPORT, OP_AS -> Color.KEYWORD
            KW_CLASS, KW_TRAIT, KW_TAGGED, KW_BITFLAG, KW_EXTENDS -> Color.KEYWORD
            KW_CONTROL -> Color.KEYWORD
            KW_LET, KW_DEF -> Color.KEYWORD
            KW_TYPE -> Color.KEYWORD
            KW_MATCH, KW_CATCH, KW_CASE -> Color.KEYWORD
            KW_IF, KW_FOR, KW_WHILE, KW_LOOP -> Color.KEYWORD
            OP_NOT, OP_IN, OP_NOT_IN, OP_IS_A, OP_NOT_A -> Color.KEYWORD
            KW_MACRO -> Color.SYM_MACRO
            //
            PARENTHESIS_L, PARENTHESIS_R -> Color.PARENTHESES
            BRACKET_L, BRACKET_R -> Color.BRACKETS
            BRACE_L, BRACE_R -> Color.BRACES
            COLON, OP_SET -> Color.SET
            // STAR -> Color.STAR
            COMMA -> Color.COMMA
            OP_IS_A, OP_NOT_A, OP_NOT_IN -> Color.OPERATION_SIGN
            OP_LT, OP_LEQ, OP_LL, OP_LLL -> Color.OPERATION_SIGN
            OP_GT, OP_GEQ, OP_GG, OP_GGG -> Color.OPERATION_SIGN
            DOT3, DOT2, OP_SUB, OP_ADD, DOT_LESS, DOT_EQ -> Color.OPERATION_SIGN
            OP_EQ, OP_NE -> Color.OPERATION_SIGN
            OP_NOT, BANG, AMP, QUESTION -> Color.OPERATION_SIGN
            OP_ARROW, OP_ARROW2 -> Color.OPERATION_SIGN
            // 原子类型
            INTEGER -> Color.INTEGER
            BYTE -> Color.INTEGER
            DECIMAL -> Color.DECIMAL
            STRING_START, STRING_TEXT, STRING_END -> Color.STRING
            SYMBOL_XID, SYMBOL_RAW -> Color.IDENTIFIER
            // 注释
            COMMENT -> Color.BLOCK_COMMENT
            // 错误
            TokenType.BAD_CHARACTER -> Color.BAD_CHARACTER
            else -> null
        }
    }
}
