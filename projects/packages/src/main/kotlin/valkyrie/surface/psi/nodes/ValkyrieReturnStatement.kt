package valkyrie.surface.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.surface.parser.ValkyrieElementNode
import valkyrie.surface.parser.ValkyrieTypes

/**
 * Return 语句节点
 */
class ValkyrieReturnStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getExpression(): PsiElement? {
        val returnKeyword = findChildByType<PsiElement>(ValkyrieTypes.RETURN)
        return returnKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    override fun toString(): String = "ValkyrieReturnStatement"
}