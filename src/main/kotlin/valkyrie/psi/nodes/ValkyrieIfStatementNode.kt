package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieElementTypes

/**
 * If 语句 PSI 节点
 */
class ValkyrieIfStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取条件表达式
     */
    fun getCondition(): PsiElement? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieElementNode::class.java)
    }
    
    /**
     * 获取 then 块
     */
    fun getThenBlock(): ValkyrieBlockStatementNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieBlockStatementNode::class.java)
    }
    
    /**
     * 获取所有 else 子句
     */
    fun getElseClauses(): List<ValkyrieElseClauseNode> {
        return PsiTreeUtil.findChildrenOfType(this, ValkyrieElseClauseNode::class.java).toList()
    }
    
    /**
     * 获取最终的 else 子句（非 else if）
     */
    fun getFinalElseClause(): ValkyrieElseClauseNode? {
        return getElseClauses().lastOrNull { !it.isElseIf() }
    }
    
    /**
     * 检查是否有 else 子句
     */
    fun hasElse(): Boolean {
        return getElseClauses().isNotEmpty()
    }
}