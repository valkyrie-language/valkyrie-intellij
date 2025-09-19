package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import valkyrie.psi.lexers.ValkyrieTokenTypes
import valkyrie.reference.ValkyrieTypeReference

/**
 * 类型引用实现
 */
class ValkyrieTypeReferenceNode(node: ASTNode) : ValkyrieTypeExpression(node) {
    
    fun getTypeName(): String? {
        return (findChildByType<PsiElement>(ValkyrieTokenTypes.SYMBOL_XID) ?: findChildByType<PsiElement>(ValkyrieTokenTypes.SYMBOL_RAW))?.text
    }
    
    /**
     * 获取类型引用，支持跳转到类型定义
     */
    override fun getReference(): PsiReference? {
        val identifier = findChildByType<PsiElement>(ValkyrieTokenTypes.SYMBOL_XID) ?: findChildByType<PsiElement>(ValkyrieTokenTypes.SYMBOL_RAW)
        if (identifier != null) {
            // 使用相对于identifier在当前节点中的范围
            val textRange = TextRange(identifier.startOffsetInParent, identifier.startOffsetInParent + identifier.textLength)
            return ValkyrieTypeReference(this, textRange)
        }
        return null
    }
}