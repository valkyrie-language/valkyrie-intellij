package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Raise 语句节点
 */
class ValkyrieRaiseStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getExpression(): PsiElement? {
        val raiseKeyword = findChildByType<PsiElement>(ValkyrieTypes.RAISE)
        return raiseKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    override fun toString(): String = "ValkyrieRaiseStatement"
}