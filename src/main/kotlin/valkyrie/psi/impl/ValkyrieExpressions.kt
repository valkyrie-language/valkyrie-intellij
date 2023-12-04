package valkyrie.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiReference
import com.intellij.util.IncorrectOperationException
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.reference.ValkyrieReference

/**
 * 标识符表达式实现 - 支持引用解析
 */
class ValkyrieIdentifierExpressionNode(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {
    
    override fun getName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
    
    override fun setName(name: String): PsiElement {
        throw IncorrectOperationException("Not implemented")
    }
    
    override fun getNameIdentifier(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)
    }
    
    override fun getReference(): PsiReference? {
        return ValkyrieReference(this)
    }
}

/**
 * 字面量表达式实现
 */
class ValkyrieLiteralExpressionNode(node: ASTNode) : ValkyrieElementNode(node)

/**
 * 二元表达式实现
 */
class ValkyrieBinaryExpressionNode(node: ASTNode) : ValkyrieElementNode(node)

/**
 * 一元表达式实现
 */
class ValkyrieUnaryExpressionNode(node: ASTNode) : ValkyrieElementNode(node)

/**
 * 括号表达式实现
 */
class ValkyrieParenthesizedExpressionNode(node: ASTNode) : ValkyrieElementNode(node)