package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Loop 语句节点
 */
class ValkyrieControlFlowNodes(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getBody(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.BRACE_L)?.let { lbrace ->
            PsiTreeUtil.getNextSiblingOfType(lbrace, ValkyrieElementNode::class.java)
        }
    }
    
    fun getLabel(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)
    }
    
    override fun toString(): String = "ValkyrieLoopStatement"
}

