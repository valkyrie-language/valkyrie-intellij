package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Let 语句实现
 */
class ValkyrieLetStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getIdentifier(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)
    }
    
    fun getExpression(): PsiElement? {
        // 找到 = 后面的表达式
        val assign = findChildByType<PsiElement>(ValkyrieTokenTypes.ASSIGN)
        return assign?.let { assignElement ->
            PsiTreeUtil.getNextSiblingOfType(assignElement, ValkyrieElementNode::class.java)
        }
    }
}

