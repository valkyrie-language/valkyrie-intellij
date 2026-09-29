package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Break 语句节点
 */
class ValkyrieBreakStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getLabel(): PsiElement? {
        val breakKeyword = findChildByType<PsiElement>(ValkyrieTypes.BREAK)
        return breakKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    override fun toString(): String = "ValkyrieBreakStatement"
}