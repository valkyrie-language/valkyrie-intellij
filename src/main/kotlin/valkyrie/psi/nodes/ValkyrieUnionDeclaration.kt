package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Union 语句实现
 */
class ValkyrieUnionDeclaration(node: ASTNode) : ValkyrieElementNode(node) {

    fun getUnionName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }

    fun getUnionBody(): ValkyrieObjectBodyNode? {
        return findChildByClass(ValkyrieObjectBodyNode::class.java)
    }
}