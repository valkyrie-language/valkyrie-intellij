package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * Else 子句 PSI 节点
 */
class ValkyrieElseClauseNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 检查是否是 else if 子句
     */
    fun isElseIf(): Boolean {
        // 检查是否包含 if token
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IF) != null
    }
    
    /**
     * 获取条件表达式（仅对 else if 有效）
     */
    fun getCondition(): PsiElement? {
        if (!isElseIf()) return null
        
        // 查找 if 后面的表达式
        val children = this.children
        var foundIf = false
        for (child in children) {
            if (foundIf && child.node.elementType.toString().contains("EXPRESSION")) {
                return child
            }
            if (child.node.elementType == ValkyrieTokenTypes.IF) {
                foundIf = true
            }
        }
        return null
    }
    
    /**
     * 获取块语句
     */
    fun getBlock(): ValkyrieBlockStatementNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieBlockStatementNode::class.java)
    }
    
    /**
     * 检查是否有块语句
     */
    fun hasBlock(): Boolean {
        return getBlock() != null
    }
}