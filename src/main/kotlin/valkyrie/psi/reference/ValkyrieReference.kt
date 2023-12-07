package valkyrie.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException
import valkyrie.psi.nodes.ValkyrieIdentifierPatternNode
import valkyrie.psi.nodes.ValkyrieIdentifierExpressionNode

/**
 * Valkyrie 变量引用解析
 */
class ValkyrieReference(private val element: ValkyrieIdentifierExpressionNode) : PsiReferenceBase<ValkyrieIdentifierExpressionNode>(element) {
    
    override fun resolve(): PsiElement? {
        val name = element.name ?: return null
        
        // 在当前作用域中查找变量定义
        var context: PsiElement? = element.parent
        while (context != null) {
            // 查找 let 语句中的变量定义
            val definitions = PsiTreeUtil.findChildrenOfType(context, ValkyrieIdentifierPatternNode::class.java)
            for (definition in definitions) {
                if (definition.name == name && definition.textOffset < element.textOffset) {
                    return definition
                }
            }
            context = context.parent
        }
        
        return null
    }
    
    override fun getVariants(): Array<Any> {
        val variants = mutableListOf<PsiElement>()
        
        // 收集当前作用域中的所有变量定义
        var context: PsiElement? = element.parent
        while (context != null) {
            val definitions = PsiTreeUtil.findChildrenOfType(context, ValkyrieIdentifierPatternNode::class.java)
            for (definition in definitions) {
                if (definition.textOffset < element.textOffset) {
                    variants.add(definition)
                }
            }
            context = context.parent
        }
        
        return variants.toTypedArray()
    }
    
    override fun handleElementRename(newElementName: String): PsiElement {
        throw IncorrectOperationException("Rename not implemented")
    }
    
    override fun getRangeInElement(): TextRange {
        val nameIdentifier = element.getNameIdentifier() ?: return TextRange.EMPTY_RANGE
        val startOffset = nameIdentifier.startOffsetInParent
        return TextRange(startOffset, startOffset + nameIdentifier.textLength)
    }
}