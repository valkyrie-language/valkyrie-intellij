package valkyrie.language.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.elementType
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.lexer.ValkyrieParserDefinition
import valkyrie.language.lexer.ValkyrieProgramLexer
import valkyrie.language.psi.ValkyrieTypes.*

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
    OP_ARROW, OP_ARROW2,
)
val suffix: TokenSet = TokenSet.create(
    OP_NOT, OP_QUESTION, OP_TEMPERATURE
)
val operators: TokenSet = TokenSet.orSet(prefix, infix, suffix)

class ValkyrieTokenType(debugName: String) : IElementType(debugName, ValkyrieLanguage) {
    companion object {
        fun isKeyword(type: PsiElement?): Boolean = ValkyrieProgramLexer.Keywords.contains(type.elementType)
        fun isKeyword(type: IElementType?): Boolean = ValkyrieProgramLexer.Keywords.contains(type)
        fun isOperator(type: PsiElement?): Boolean = operators.contains(type.elementType)
        fun isOperator(type: IElementType?): Boolean = operators.contains(type)
        fun isValkyrieBlock(type: PsiElement?): Boolean {
            if (type == null) return false
            return when (type) {
                is ValkyrieImportBlock,
                is ValkyrieForallBlock,
                is ValkyrieIffBlock,
                is ValkyrieClassBlock, is ValkyrieUnionBlock, is ValkyrieBitflagBlock,
                is ValkyrieDefineBlock, is ValkyrieDefineTuple,
                is ValkyrieNormalBlock, is ValkyrieNewBlock, is ValkyrieTuple,
                is ValkyrieMacroBlock,
                is ValkyrieMatchBlock,
                is ValkyrieCaseBlock,
                is ValkyrieList, is ValkyrieObject,
                -> true

                else -> false
            }
        }
    }

    override fun toString(): String = "ValkyrieTokenType.${super.toString()}"
}
