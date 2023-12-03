package valkyrie.reference

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.index.ValkyrieSymbolIndex
import valkyrie.psi.impl.ValkyrieIdentifierExpressionImpl
import valkyrie.psi.impl.ValkyrieLetStatementImpl
import valkyrie.psi.impl.ValkyrieNamespaceStatementImpl

/**
 * 跨文件引用解析器
 */
class ValkyrieCrossFileReference(
    element: ValkyrieIdentifierExpressionImpl,
    textRange: TextRange
) : PsiReferenceBase<ValkyrieIdentifierExpressionImpl>(element, textRange) {
    
    override fun resolve(): PsiElement? {
        val symbolName = element.text
        val currentFile = element.containingFile.virtualFile ?: return null
        val project = element.project
        
        // 获取符号索引服务
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        
        // 首先尝试在当前文件中查找
        val localDefinition = findLocalDefinition(symbolName)
        if (localDefinition != null) {
            return localDefinition
        }
        
        // 然后尝试跨文件查找
        val symbolInfo = symbolIndex.findSymbolDefinition(symbolName, currentFile)
        return symbolInfo?.element
    }
    
    /**
     * 在当前文件中查找符号定义
     */
    private fun findLocalDefinition(symbolName: String): PsiElement? {
        val file = element.containingFile
        
        // 查找所有 let 语句
        val letStatements = PsiTreeUtil.findChildrenOfType(file, ValkyrieLetStatementImpl::class.java)
        
        for (letStatement in letStatements) {
            val identifier = letStatement.getIdentifier()
            if (identifier?.text == symbolName) {
                return identifier
            }
        }
        
        return null
    }
    
    override fun getVariants(): Array<Any> {
        val currentFile = element.containingFile.virtualFile ?: return emptyArray()
        val project = element.project
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        
        val variants = mutableListOf<String>()
        
        // 获取当前命名空间
        val currentNamespace = PsiTreeUtil.findChildOfType(
            element.containingFile, 
            ValkyrieNamespaceStatementImpl::class.java
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

/**
 * 跨文件引用提供者
 */
class ValkyrieCrossFileReferenceProvider : PsiReferenceProvider() {
    
    override fun getReferencesByElement(
        element: PsiElement,
        context: ProcessingContext
    ): Array<PsiReference> {
        if (element is ValkyrieIdentifierExpressionImpl) {
            val textRange = TextRange(0, element.textLength)
            return arrayOf(ValkyrieCrossFileReference(element, textRange))
        }
        return emptyArray()
    }
}