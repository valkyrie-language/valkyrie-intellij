package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Parameter 实现
 */
class ValkyrieParameterNode(node: ASTNode) : ValkyrieElementNode(node) {

    fun getParameterName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }

    fun getTypeReference(): ValkyrieTypeReferenceNode? {
        return findChildByClass(ValkyrieTypeReferenceNode::class.java)
    }
}