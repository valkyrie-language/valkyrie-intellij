package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import valkyrie.index.ValkyrieSymbolIndex
import valkyrie.psi.nodes.ValkyrieTypeReferenceNode

/**
 * 类型引用解析器
 * 专门处理类型引用的跳转，确保跳转到类型定义而非其他usage
 */
class ValkyrieTypeReference(
    element: ValkyrieTypeReferenceNode,
    textRange: TextRange
) : PsiReferenceBase<ValkyrieTypeReferenceNode>(element, textRange) {

    override fun resolve(): PsiElement? {
        val typeName = element.getTypeName() ?: return null
        val currentFile = element.containingFile.virtualFile ?: return null
        val project = element.project

        // 获取符号索引服务
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)

        // 查找所有符号定义
        val allDefinitions = symbolIndex.findAllSymbolDefinitions(typeName, currentFile)
        
        // 优先返回类型定义（class、union等），而不是变量定义
        for (symbolInfo in allDefinitions) {
            val element = symbolInfo.element
            // 检查是否为类型定义（class、union等）
            if (element != null && isTypeDefinition(element)) {
                return element
            }
        }
        
        // 如果没有找到类型定义，返回第一个定义
        return allDefinitions.firstOrNull()?.element
    }
    
    /**
     * 判断元素是否为类型定义
     */
    private fun isTypeDefinition(element: PsiElement): Boolean {
        val className = element.javaClass.simpleName
        return className.contains("Class") || 
               className.contains("Union") || 
               className.contains("Type") ||
               className.contains("Struct") ||
               className.contains("Generic") ||
               className.contains("Parameter")
    }
}