package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.parsers.ValkyrieTypes

/**
 * 赋值语句节点
 */
class ValkyrieAssignStatement(node: ASTNode) : ValkyrieElementNode(node) {

    fun getLeftExpression(): PsiElement? {
        return children.firstOrNull { it.node.elementType == ValkyrieTypes.EXPRESSION }
    }

    fun getRightExpression(): PsiElement? {
        return children.lastOrNull { it.node.elementType == ValkyrieTypes.EXPRESSION }
    }

    fun getAssignOperator(): PsiElement? {
        return findChildByType<PsiElement>(ValkyrieTypes.ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTypes.PLUS_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTypes.MINUS_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTypes.MULTIPLY_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTypes.DIVIDE_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTypes.MODULO_ASSIGN) ?:
               findChildByType<PsiElement>(ValkyrieTypes.POWER_ASSIGN)
    }

    override fun toString(): String = "ValkyrieAssignStatement"
}