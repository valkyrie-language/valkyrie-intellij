package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

class ValkyrieAssertStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getCondition(): PsiElement? {
        val assertKeyword = findChildByType<PsiElement>(ValkyrieTokenTypes.ASSERT)
        return assertKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }

    fun getMessage(): PsiElement? {
        val exprs = children.filter { it.node.elementType == ValkyrieElementTypes.EXPRESSION }
        return exprs.drop(1).firstOrNull()
    }

    override fun toString(): String = "ValkyrieAssertStatement"
}
