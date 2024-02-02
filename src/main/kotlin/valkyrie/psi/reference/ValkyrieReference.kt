package valkyrie.psi.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.IncorrectOperationException
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.index.ValkyrieSymbolIndex

/**
 * Valkyrie 变量引用解析
 */
class ValkyrieReference(private val element: ValkyrieIdentifierNode) : PsiReferenceBase<ValkyrieIdentifierNode>(element) {
    
    override fun resolve(): PsiElement? {
        val name = element.name ?: return null
        
        // 首先在当前作用域中查找局部变量定义
        var context: PsiElement? = element.parent
        while (context != null) {
            // 查找 let 语句中的变量定义
            val definitions = PsiTreeUtil.findChildrenOfType(context, ValkyrieIdentifierNode::class.java)
            for (definition in definitions) {
                if (definition.name == name && definition.textOffset < element.textOffset) {
                    return definition
                }
            }
            context = context.parent
        }
        
        // 如果在局部作用域中没有找到，使用符号索引查找全局定义（类、函数等）
        val currentFile = element.containingFile.virtualFile ?: return null
        val project = element.project
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        
        val symbolInfo = symbolIndex.findSymbolDefinition(name, currentFile)
        return symbolInfo?.element
    }
    
    override fun getVariants(): Array<Any> {
        val variants = mutableListOf<PsiElement>()
        
        // 收集当前作用域中的所有变量定义
        var context: PsiElement? = element.parent
        while (context != null) {
            val definitions = PsiTreeUtil.findChildrenOfType(context, ValkyrieIdentifierNode::class.java)
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
        val nameIdentifier = element ?: return TextRange.EMPTY_RANGE
        val startOffset = nameIdentifier.startOffsetInParent
        return TextRange(startOffset, startOffset + nameIdentifier.textLength)
    }
}