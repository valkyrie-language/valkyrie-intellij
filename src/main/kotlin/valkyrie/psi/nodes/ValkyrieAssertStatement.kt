package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

class ValkyrieAssertStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getCondition(): PsiElement? {
        val assertKeyword = findChildByType<PsiElement>(ValkyrieTypes.ASSERT)
        return assertKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    fun getMessage(): PsiElement? {
        val exprs = children.filter { it.node.elementType == ValkyrieTypes.EXPRESSION }
        return exprs.drop(1).firstOrNull()
    }

    override fun toString(): String = "ValkyrieAssertStatement"
}
