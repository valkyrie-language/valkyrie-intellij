package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import valkyrie.index.ValkyrieSymbolIndex
import valkyrie.psi.nodes.ValkyrieIdentifierNode

/**
 * 函数调用引用解析器
 * 专门处理函数调用中的函数名引用解析
 */
class ValkyrieFunctionCallReference(
    element: ValkyrieIdentifierNode,
    textRange: TextRange
) : PsiReferenceBase<ValkyrieIdentifierNode>(element, textRange) {

    override fun resolve(): PsiElement? {
        val functionName = element.text
        val currentFile = element.containingFile.virtualFile ?: return null
        val project = element.project

        // 获取符号索引服务
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)

        // 查找函数定义
        val symbolInfo = symbolIndex.findSymbolDefinition(functionName, currentFile)
        return symbolInfo?.element
    }

    override fun getVariants(): Array<Any> {
        val currentFile = element.containingFile.virtualFile ?: return emptyArray()
        val project = element.project
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)

        val variants = mutableListOf<String>()

        // 获取当前命名空间的所有符号（包括函数）
        val currentNamespace = "default" // 简化处理，实际应该获取当前命名空间
        variants.addAll(symbolIndex.getNamespaceSymbols(currentNamespace))

        // 添加通过 using 导入的符号
        val usingList = symbolIndex.getFileUsings(currentFile)
        for (usingInfo in usingList) {
            variants.add(usingInfo.symbolName)
        }

        return variants.toTypedArray()
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        // 重命名处理
        return element
    }
}