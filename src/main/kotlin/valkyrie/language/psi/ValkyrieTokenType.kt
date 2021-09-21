package valkyrie.language.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.elementType
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.psi.ValkyrieTypes.*

val keywords: TokenSet = TokenSet.create(
    KW_NAMESPACE, KW_EXTENSION, KW_IMPORT, OP_AS,
    KW_MACRO, KW_CLASS, KW_TRAIT, KW_TAGGED, KW_BITFLAG, KW_EXTENDS,
    KW_CONTINUE, KW_RETURN, KW_RESUME,
    KW_YIELD, KW_BREAK,
    KW_LET, KW_DEF,
    KW_TYPE,
    KW_MATCH, KW_CATCH, KW_CASE, KW_WITH,
    KW_IF, KW_ELSE,
    KW_LOOP, KW_WHILE,
    KW_FOR, OP_IN,
    OP_NOT, OP_IS_A, OP_NOT_A,
    KW_NEW, KW_OBJECT,
    OP_UNIMPLEMENTED, OP_QUOTE
)
val prefix: TokenSet = TokenSet.create(
//    OP_AT, OP_HASH,
)

val infix: TokenSet = TokenSet.create(
    OP_IS_A, OP_NOT_A, OP_NOT_IN,
    OP_LT, OP_LEQ, OP_LL, OP_LLL,
    OP_GT, OP_GEQ, OP_GG, OP_GGG,
    DOT3, DOT2, OP_SUB, OP_ADD, DOT_LESS, DOT_EQ,
    OP_EQ, OP_NE,
    OP_NOT, BANG, AMP, OP_QUESTION,
    OP_ARROW, OP_ARROW2
)
val suffix: TokenSet = TokenSet.create(
    OP_NOT, OP_QUESTION
)
val operators: TokenSet = TokenSet.orSet(prefix, infix, suffix)

class ValkyrieTokenType(debugName: String) : IElementType(debugName, ValkyrieLanguage) {
    companion object {
        fun isKeyword(type: PsiElement?): Boolean = keywords.contains(type.elementType)
        fun isKeyword(type: IElementType?): Boolean = keywords.contains(type)
        fun isOperator(type: PsiElement?): Boolean = operators.contains(type.elementType)
        fun isOperator(type: IElementType?): Boolean = operators.contains(type)
    }
//    override fun toString(): String = "ValkyrieTokenType.${super.toString()}"
}
