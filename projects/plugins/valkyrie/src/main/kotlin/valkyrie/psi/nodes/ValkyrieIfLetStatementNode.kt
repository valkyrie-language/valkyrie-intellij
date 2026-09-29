package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * If let 语句 PSI 节点
 */
class ValkyrieIfLetStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取模式（pattern）
     */
    fun getPattern(): ValkyrieIdentifierNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieIdentifierNode::class.java)
    }
    
    /**
     * 获取匹配的表达式
     */
    fun getMatchExpression(): PsiElement? {
        // 查找 = 后面的表达式
        val children = this.children
        var foundAssign = false
        for (child in children) {
            if (foundAssign && child.node.elementType == ValkyrieTypes.EXPRESSION) {
                return child
            }
            if (child.text == "=") {
                foundAssign = true
            }
        }
        return null
    }
    
    /**
     * 获取 then 块
     */
    fun getThenBlock(): ValkyrieBlockStatementNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieBlockStatementNode::class.java)
    }
    
    /**
     * 获取 else 子句
     */
    fun getElseClause(): ValkyrieElseClauseNode? {
        return PsiTreeUtil.findChildOfType(this, ValkyrieElseClauseNode::class.java)
    }
    
    /**
     * 检查是否有 else 子句（if let 必须有 else）
     */
    fun hasElse(): Boolean {
        return getElseClause() != null
    }
}