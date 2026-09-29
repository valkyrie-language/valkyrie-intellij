package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Yield 语句节点
 */
class ValkyrieYieldStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getExpression(): PsiElement? {
        val yieldKeyword = findChildByType<PsiElement>(ValkyrieTypes.YIELD)
        return yieldKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    override fun toString(): String = "ValkyrieYieldStatement"
}