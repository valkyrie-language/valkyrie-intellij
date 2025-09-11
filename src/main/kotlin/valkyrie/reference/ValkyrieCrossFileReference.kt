package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReferenceBase
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.index.ValkyrieSymbolIndex
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.psi.nodes.ValkyrieNamespaceDeclaration

/**
 * 跨文件引用解析器
 */
class ValkyrieCrossFileReference(
    element: ValkyrieIdentifierNode,
    textRange: TextRange
) : PsiReferenceBase<ValkyrieIdentifierNode>(element, textRange) {

    override fun resolve(): PsiElement? {
        val symbolName = element.text
        val currentFile = element.containingFile.virtualFile ?: return null
        val project = element.project

        // 获取符号索引服务
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)

        // 使用符号索引统一查找，避免重复查找
        // findSymbolDefinition 内部已经包含了本地查找逻辑
        val symbolInfo = symbolIndex.findSymbolDefinition(symbolName, currentFile)
        return symbolInfo?.element
    }

    // 移除 findLocalDefinition 方法，避免与 ValkyrieSymbolIndex.findSymbolDefinition 重复查找

    override fun getVariants(): Array<Any> {
        val currentFile = element.containingFile.virtualFile ?: return emptyArray()
        val project = element.project
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)

        val variants = mutableListOf<String>()

        // 获取当前命名空间
        val currentNamespace = PsiTreeUtil.findChildOfType(
            element.containingFile,
            ValkyrieNamespaceDeclaration::class.java
        )?.getNamespaceName() ?: "default"

        // 添加当前命名空间的符号
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

