package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Catch Case 节点
 */
class ValkyrieCatchCase(node: ASTNode) : ValkyrieElementNode(node) {

    fun getPattern(): PsiElement? {
        val catchKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.CATCH)
        return catchKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    fun getBody(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.BRACE_L)?.let { lbrace ->
            PsiTreeUtil.getNextSiblingOfType(lbrace, ValkyrieElementNode::class.java)
        }
    }

    override fun toString(): String = "ValkyrieCatchCase"
}