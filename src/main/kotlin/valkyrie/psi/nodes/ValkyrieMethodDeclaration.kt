package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes

/**
 * Method 声明实现
 */
class ValkyrieMethodDeclaration(node: ASTNode) : ValkyrieElementNode(node) {

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