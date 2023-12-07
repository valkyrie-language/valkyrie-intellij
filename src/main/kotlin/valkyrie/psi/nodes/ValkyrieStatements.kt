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
 * Union Variant 实现
 */
class ValkyrieUnionVariantNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getVariantName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
    
    fun getVariantBody(): ValkyrieBlockStatementNode? {
        return findChildByClass(ValkyrieBlockStatementNode::class.java)
    }
}

/**
 * Modifier List 实现
 */
class ValkyrieModifierListNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getModifiers(): List<String> {
        return findChildrenByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)
            .mapNotNull { it.text }
    }
}

/**
 * Parameter List 实现
 */
class ValkyrieParameterListNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getParameters(): Array<out ValkyrieParameterNode?> {
        return findChildrenByClass(ValkyrieParameterNode::class.java)
    }
}

/**
 * Parameter 实现
 */
class ValkyrieParameterNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getParameterName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
    
    fun getTypeReference(): ValkyrieTypeReferenceNode? {
        return findChildByClass(ValkyrieTypeReferenceNode::class.java)
    }
}

