package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Continue 语句节点
 */
class ValkyrieContinueStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getLabel(): PsiElement? {
        val continueKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.CONTINUE)
        return continueKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    override fun toString(): String = "ValkyrieContinueStatement"
}