package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * Loop 语句节点
 */
class ValkyrieControlFlowNodes(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getBody(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTypes.BRACE_L)?.let { lbrace ->
            PsiTreeUtil.getNextSiblingOfType(lbrace, ValkyrieElementNode::class.java)
        }
    }
    
    fun getLabel(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_XID) ?: findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_RAW)
    }
    
    override fun toString(): String = "ValkyrieLoopStatement"
}

