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
 * Field 声明实现
 */
class ValkyrieFieldDeclarationNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getFieldName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
    
    fun getModifiers(): ValkyrieModifierListNode? {
        return findChildByClass(ValkyrieModifierListNode::class.java)
    }
    
    fun getTypeReference(): ValkyrieTypeReferenceNode? {
        return findChildByClass(ValkyrieTypeReferenceNode::class.java)
    }
}

/**
 * Method 声明实现
 */
class ValkyrieMethodDeclarationNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getMethodName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
    
    fun getModifiers(): ValkyrieModifierListNode? {
        return findChildByClass(ValkyrieModifierListNode::class.java)
    }
    
    fun getParameterList(): ValkyrieParameterListNode? {
        return findChildByClass(ValkyrieParameterListNode::class.java)
    }
    
    fun getMethodBody(): ValkyrieBlockStatementNode? {
        return findChildByClass(ValkyrieBlockStatementNode::class.java)
    }
}

/**
 * Domain 声明实现
 */
class ValkyrieDomainDeclarationNode(node: ASTNode) : ValkyrieElementNode(node) {
    
    fun getDomainName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
    
    fun getModifiers(): ValkyrieModifierListNode? {
        return findChildByClass(ValkyrieModifierListNode::class.java)
    }
    
    fun getDomainBody(): ValkyrieBlockStatementNode? {
        return findChildByClass(ValkyrieBlockStatementNode::class.java)
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
    
    fun getParameters(): List<ValkyrieParameterNode> {
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