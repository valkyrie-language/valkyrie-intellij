package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieTokenTypes

/**
 * 类型引用实现
 */
class ValkyrieTypeReferenceNode(node: ASTNode) : ValkyrieTypeExpression(node) {
    
    fun getTypeName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER)?.text
    }
}