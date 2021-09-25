package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.ValkyrieTypes

// PsiReference
open class MixinNumber(node: ASTNode) : ValkyrieASTBase(node) {
    val number: PsiElement
        get() {
            return this.firstChild
        }
    val unit: PsiElement?
        get() {
            val last = this.lastChild;
            return when (last.elementType) {
                ValkyrieTypes.NUMBER_SUFFIX -> {
                    last
                }
                else -> {
                    null
                }
            }
        }

}

