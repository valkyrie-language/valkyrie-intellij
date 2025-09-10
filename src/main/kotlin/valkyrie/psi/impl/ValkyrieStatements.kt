package valkyrie.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Let 语句实现
 */
class ValkyrieLetStatementImpl(node: ASTNode) : ValkyrieElementImpl(node) {
    
    fun getIdentifier(): PsiElement? {
        return findChildByType(ValkyrieTokenTypes.IDENTIFIER)
    }
    
    fun getExpression(): PsiElement? {
        // 找到 = 后面的表达式
        val assign = findChildByType(ValkyrieTokenTypes.ASSIGN)
        return assign?.nextSibling?.let { sibling ->
            PsiTreeUtil.getNextSiblingOfType(sibling, ValkyrieElementImpl::class.java)
        }
    }
}

/**
 * 表达式语句实现
 */
class ValkyrieExpressionStatementImpl(node: ASTNode) : ValkyrieElementImpl(node)

/**
 * 块语句实现
 */
class ValkyrieBlockStatementImpl(node: ASTNode) : ValkyrieElementImpl(node)