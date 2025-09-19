package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.lexers.ValkyrieTokenTypes

class ValkyrieDebugStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getExpression(): PsiElement? {
        val debugKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.DEBUG)
        return debugKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    override fun toString(): String = "ValkyrieDebugStatement"
}
