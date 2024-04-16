package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieElementTypes
import valkyrie.psi.lexers.ValkyrieTokenTypes

/**
 * 赋值语句节点
 */
class ValkyrieAssignStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getLeftExpression(): PsiElement? {
        return children.firstOrNull { it.node.elementType == ValkyrieElementTypes.EXPRESSION }
    }

    fun getRightExpression(): PsiElement? {
        return children.lastOrNull { it.node.elementType == ValkyrieElementTypes.EXPRESSION }
    }

    fun getAssignOperator(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.PLUS_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.MINUS_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.MULTIPLY_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.DIVIDE_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.MODULO_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTokenTypes.POWER_ASSIGN)
    }

    override fun toString(): String = "ValkyrieAssignStatement"
}