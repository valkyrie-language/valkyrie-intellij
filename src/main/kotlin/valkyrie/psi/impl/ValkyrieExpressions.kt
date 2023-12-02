package valkyrie.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.PsiReference
import com.intellij.util.IncorrectOperationException
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.reference.ValkyrieReference

/**
 * 标识符表达式实现 - 支持引用解析
 */
class ValkyrieIdentifierExpressionImpl(node: ASTNode) : ValkyrieElementImpl(node), PsiNamedElement {
    
    override fun getName(): String? {
        return findChildByType(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
    
    override fun setName(name: String): PsiElement {
        throw IncorrectOperationException("Not implemented")
    }
    
    override fun getNameIdentifier(): PsiElement? {
        return findChildByType(ValkyrieTokenTypes.IDENTIFIER)
    }
    
    override fun getReference(): PsiReference? {
        return ValkyrieReference(this)
    }
}

/**
 * 字面量表达式实现
 */
class ValkyrieLiteralExpressionImpl(node: ASTNode) : ValkyrieElementImpl(node)

/**
 * 二元表达式实现
 */
class ValkyrieBinaryExpressionImpl(node: ASTNode) : ValkyrieElementImpl(node)

/**
 * 一元表达式实现
 */
class ValkyrieUnaryExpressionImpl(node: ASTNode) : ValkyrieElementImpl(node)

/**
 * 括号表达式实现
 */
class ValkyrieParenthesizedExpressionImpl(node: ASTNode) : ValkyrieElementImpl(node)