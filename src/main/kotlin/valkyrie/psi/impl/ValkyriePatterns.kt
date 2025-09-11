package valkyrie.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.util.IncorrectOperationException
import valkyrie.psi.ValkyrieTokenTypes

/**
 * 标识符模式实现 - 变量定义
 */
class ValkyrieIdentifierPatternNode(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner {
    
    override fun getName(): String? {
        return nameIdentifier?.text
    }
    
    override fun setName(name: String): PsiElement {
        throw IncorrectOperationException("Not implemented")
    }
    
    override fun getNameIdentifier(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)
    }
}

/**
 * 类型引用实现
 */
class ValkyrieTypeReferenceNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getTypeName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
}