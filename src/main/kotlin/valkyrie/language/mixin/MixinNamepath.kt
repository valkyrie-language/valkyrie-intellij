package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.ValkyrieTypes
import valkyrie.language.psi_node.ValkyrieIdentifierNode

open class MixinNamepath(node: ASTNode) : ValkyrieASTBase(node) {
    override fun getNavigationElement(): ValkyrieIdentifierNode {
        return lastChild as ValkyrieIdentifierNode
    }

    override fun getName(): String? {
        return children
            .filterIsInstance<ValkyrieIdentifierNode>()
            .joinToString("∷") { it.name }
    }

    fun highlightHead(): ValkyrieIdentifierNode? {
        firstChild.let {
            it as ValkyrieIdentifierNode
            if (it.name == "package" || it.name == "module") {
                return it
            }
        }
        return null
    }

    fun delimiterList(): List<PsiElement> {
        return this.children.filter {
            it.elementType == ValkyrieTypes.DOT || it.elementType == ValkyrieTypes.OP_PROPORTION
        }
    }
}

