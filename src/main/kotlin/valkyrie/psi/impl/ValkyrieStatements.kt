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

/**
 * Namespace 语句实现
 */
class ValkyrieNamespaceStatementImpl(node: ASTNode) : ValkyrieElementImpl(node) {
    
    fun getNamespaceIdentifier(): PsiElement? {
        return findChildByType(ValkyrieTokenTypes.IDENTIFIER)
    }
    
    fun getNamespaceName(): String? {
        return getNamespaceIdentifier()?.text
    }
}

/**
 * Using 语句实现
 */
class ValkyrieUsingStatementImpl(node: ASTNode) : ValkyrieElementImpl(node) {
    
    fun getQualifiedName(): ValkyrieQualifiedNameImpl? {
        return findChildByClass(ValkyrieQualifiedNameImpl::class.java)
    }
    
    fun getImportedName(): String? {
        return getQualifiedName()?.text
    }
}

/**
 * 限定名实现
 */
class ValkyrieQualifiedNameImpl(node: ASTNode) : ValkyrieElementImpl(node) {
    
    fun getIdentifiers(): List<PsiElement> {
        return findChildrenByType(ValkyrieTokenTypes.IDENTIFIER)
    }
    
    fun getQualifier(): String? {
        val identifiers = getIdentifiers()
        return if (identifiers.size > 1) {
            identifiers.dropLast(1).joinToString(".") { it.text }
        } else null
    }
    
    fun getReferenceName(): String? {
        val identifiers = getIdentifiers()
        return identifiers.lastOrNull()?.text
    }
}