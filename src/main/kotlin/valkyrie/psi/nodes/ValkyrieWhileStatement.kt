package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * While 语句节点
 */
class ValkyrieWhileStatement(node: ASTNode) : ValkyrieElementNode(node) {
    
    /**
     * 获取条件表达式
     */
    fun getCondition(): PsiElement? {
        val whileKeyword = findChildByType<PsiElement>(ValkyrieTypes.WHILE)
        return whileKeyword?.let { keyword ->
            PsiTreeUtil.getNextSiblingOfType(keyword, ValkyrieElementNode::class.java)
        }
    }
    
    /**
     * 获取循环体
     */
    fun getBody(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTypes.BRACE_L)?.let { lbrace ->
            PsiTreeUtil.getNextSiblingOfType(lbrace, ValkyrieElementNode::class.java)
        }
    }
    
    /**
     * 获取标签（如果有）
     */
    fun getLabel(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_XID) ?: findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_RAW)
    }
    
    override fun toString(): String = "ValkyrieWhileStatement"
}