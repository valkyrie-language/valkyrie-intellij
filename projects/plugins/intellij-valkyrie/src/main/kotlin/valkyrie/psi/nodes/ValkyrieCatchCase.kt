package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Catch Case 节点
 */
class ValkyrieCatchCase(node: ASTNode) : ValkyrieElementNode(node) {

    fun getPattern(): PsiElement? {
        val catchKeyword = findChildByType<PsiElement>(ValkyrieTypes.CATCH)
        return catchKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    fun getBody(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTypes.BRACE_L)?.let { lbrace ->
            PsiTreeUtil.getNextSiblingOfType(lbrace, ValkyrieElementNode::class.java)
        }
    }

    override fun toString(): String = "ValkyrieCatchCase"
}