package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.index.ValkyrieEnhancedSymbolIndex
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.psi.nodes.ValkyrieNamespaceDeclaration

/**
 * 跨文件引用解析器（增强版本）
 * 支持跨包解析和包别名
 */
class ValkyrieCrossFileReference(
    element: ValkyrieIdentifierNode,
    textRange: TextRange
) : PsiReferenceBase<ValkyrieIdentifierNode>(element, textRange) {

    override fun resolve(): PsiElement? {
        val symbolName = element.text
        val currentFile = element.containingFile.virtualFile ?: return null
        val project = element.project

        // 使用增强的符号索引服务
        val symbolIndex = ValkyrieEnhancedSymbolIndex.getInstance(project)

        // 支持包名限定的查找：package::symbol
        if (symbolName.contains("::")) {
            val symbolInfo = symbolIndex.findSymbolDefinition(symbolName, currentFile)
            return symbolInfo?.element
        }

        // 普通符号查找
        val symbolInfo = symbolIndex.findSymbolDefinition(symbolName, currentFile)
        return symbolInfo?.element
    }

    override fun getVariants(): Array<Any> {
        val currentFile = element.containingFile.virtualFile ?: return emptyArray()
        val project = element.project
        val symbolIndex = ValkyrieEnhancedSymbolIndex.getInstance(project)

        val variants = mutableListOf<String>()

        // 获取当前命名空间
        val currentNamespace = PsiTreeUtil.findChildOfType(
            element.containingFile,
            ValkyrieNamespaceDeclaration::class.java
        )?.getNamespaceName() ?: "default"

        // 添加当前命名空间的符号
        variants.addAll(symbolIndex.getNamespaceSymbols(currentNamespace))

        // 添加通过 using 导入的符号（支持别名）
        val usingList = symbolIndex.getFileUsings(currentFile)
        for (usingInfo in usingList) {
            // 使用别名或原始符号名
            variants.add(usingInfo.alias ?: usingInfo.symbolName)
        }

        // 添加包名限定的符号（package::symbol）
        // 这里可以添加包名作为前缀提示
        // 实际实现中可能需要更复杂的处理

        return variants.toTypedArray()
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        // 重命名处理 - 保持原有逻辑
        return element
    }
}

