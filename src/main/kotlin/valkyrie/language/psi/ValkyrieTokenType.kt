package valkyrie.language.psi

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.elementType
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.lexer.ValkyrieProgramLexer

val prefix: TokenSet = TokenSet.create(
//    OP_AT, OP_HASH,
)

val infix: TokenSet = TokenSet.create(

)
val suffix: TokenSet = TokenSet.create(

)
val operators: TokenSet = TokenSet.orSet(prefix, infix, suffix)

@Deprecated("To be deleted")
class ValkyrieTokenType(debugName: String) : IElementType(debugName, ValkyrieLanguage) {
    companion object {
        fun isKeyword(type: IElementType?): Boolean = ValkyrieProgramLexer.Keywords.contains(type)
        fun isOperator(type: PsiElement?): Boolean = operators.contains(type.elementType)
        fun isOperator(type: IElementType?): Boolean = operators.contains(type)

        fun isValkyrieBlock(type: PsiElement?): Boolean {
            if (type == null) return false
            return when (type) {
//                is ValkyrieImportBlock,
//                is ValkyrieForallBlock,
//                is ValkyrieIffBlock,
//                is ValkyrieClassBlock, is ValkyrieUnionBlock, is ValkyrieBitflagBlock,
//                is ValkyrieDefineBlock, is ValkyrieDefineTuple,
//                is ValkyrieNormalBlock, is ValkyrieNewBlock, is ValkyrieTuple,
//                is ValkyrieMacroBlock,
//                is ValkyrieMatchBlock,
//                is ValkyrieCaseBlock,
//                is ValkyrieList, is ValkyrieObject,
//                -> true

                else -> false
            }
        }
    }

    override fun toString(): String = "ValkyrieTokenType.${super.toString()}"
}
