package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.reference.ValkyrieTypeReference

/**
 * 类型引用实现
 */
class ValkyrieTypeReferenceNode(node: ASTNode) : ValkyrieTypeExpression(node) {
    
    fun getTypeName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)?.text
    }
    
    /**
     * 获取类型引用，支持跳转到类型定义
     */
    override fun getReference(): PsiReference? {
        val identifier = findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)
        if (identifier != null) {
            val textRange = TextRange(identifier.startOffsetInParent, identifier.startOffsetInParent + identifier.textLength)
            return ValkyrieTypeReference(this, textRange)
        }
        return null
    }
}