package valkyrie.psi.impl

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Let 语句实现
 */
class ValkyrieLetStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getIdentifier(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)
    }
    
    fun getExpression(): PsiElement? {
        // 找到 = 后面的表达式
        val assign = findChildByType<PsiElement>(ValkyrieTokenTypes.ASSIGN)
        return assign?.let { assignElement ->
            PsiTreeUtil.getNextSiblingOfType(assignElement, ValkyrieElementNode::class.java)
        }
    }
}

/**
 * 表达式语句实现
 */
class ValkyrieExpressionStatementNode(node: ASTNode) : ValkyrieElementNode(node)

/**
 * 块语句实现
 */
class ValkyrieBlockStatementNode(node: ASTNode) : ValkyrieElementNode(node)

/**
 * Namespace 语句实现
 */
class ValkyrieNamespaceStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getNamespaceIdentifier(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)
    }
    
    fun getNamespaceName(): String? {
        return getNamespaceIdentifier()?.text
    }
}

/**
 * Using 语句实现
 */
class ValkyrieUsingStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getQualifiedName(): ValkyrieQualifiedNameNode? {
        return findChildByClass(ValkyrieQualifiedNameNode::class.java)
    }
    
    fun getImportedName(): String? {
        return getQualifiedName()?.text
    }
}

/**
 * Class 语句实现
 */
class ValkyrieClassStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getClassName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
    
    fun getClassBody(): ValkyrieBlockStatementNode? {
        return findChildByClass(ValkyrieBlockStatementNode::class.java)
    }
}

/**
 * Union 语句实现
 */
class ValkyrieUnionStatementNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getUnionName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
    
    fun getUnionBody(): ValkyrieBlockStatementNode? {
        return findChildByClass(ValkyrieBlockStatementNode::class.java)
    }
}

/**
 * 限定名实现
 */
class ValkyrieQualifiedNameNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getIdentifiers(): List<PsiElement> {
        return findChildrenByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)
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