package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Resume 语句节点
 */
class ValkyrieResumeStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getLabel(): PsiElement? {
        val resumeKeyword = findChildByType<PsiElement>(ValkyrieTypes.RESUME)
        return resumeKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    fun getExpression(): PsiElement? {
        return children.lastOrNull { it.node.elementType == ValkyrieTypes.EXPRESSION }
    }

    override fun toString(): String = "ValkyrieResumeStatement"
}