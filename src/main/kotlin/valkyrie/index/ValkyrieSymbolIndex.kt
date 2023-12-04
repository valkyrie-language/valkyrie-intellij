package valkyrie.index

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.file.ValkyrieFileType
import valkyrie.psi.impl.ValkyrieNamespaceStatementNode
import valkyrie.psi.impl.ValkyrieUsingStatementNode
import valkyrie.psi.impl.ValkyrieLetStatementNode

/**
 * Valkyrie 符号索引服务
 * 负责管理跨文件的 namespace 和 using 关系
 */
class ValkyrieSymbolIndex(private val project: Project) {
    
    /**
     * 符号信息
     */
    data class SymbolInfo(
        val name: String,
        val namespace: String,
        val file: VirtualFile,
        val element: ValkyrieLetStatementNode
    )
    
    /**
     * 命名空间信息
     */
    data class NamespaceInfo(
        val name: String,
        val file: VirtualFile,
        val symbols: MutableSet<String> = mutableSetOf()
    )
    
    /**
     * Using 导入信息
     */
    data class UsingInfo(
        val qualifiedName: String,
        val namespace: String,
        val symbolName: String,
        val file: VirtualFile
    )
    
    private val symbolCache = mutableMapOf<String, MutableList<SymbolInfo>>()
    private val namespaceCache = mutableMapOf<String, NamespaceInfo>()
    private val usingCache = mutableMapOf<VirtualFile, MutableList<UsingInfo>>()
    
    /**
     * 重建索引
     */
    fun rebuildIndex() {
        symbolCache.clear()
        namespaceCache.clear()
        usingCache.clear()
        
        val valkyrieFiles = FileTypeIndex.getFiles(
            ValkyrieFileType.INSTANCE,
            GlobalSearchScope.projectScope(project)
        )
        
        for (file in valkyrieFiles) {
            indexFile(file)
        }
    }
    
    /**
     * 索引单个文件
     */
    private fun indexFile(file: VirtualFile) {
        val psiFile = PsiManager.getInstance(project).findFile(file) ?: return
        
        // 查找 namespace 声明
        val namespaceStatement = PsiTreeUtil.findChildOfType(psiFile, ValkyrieNamespaceStatementNode::class.java)
        val namespace = namespaceStatement?.getNamespaceName() ?: "default"
        
        // 记录命名空间信息
        val namespaceInfo = namespaceCache.getOrPut(namespace) {
            NamespaceInfo(namespace, file)
        }
        
        // 查找所有 let 语句（符号定义）
        val letStatements = PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieLetStatementNode::class.java)
        for (letStatement in letStatements) {
            val symbolName = letStatement.getIdentifier()?.text ?: continue
            
            val symbolInfo = SymbolInfo(
                name = symbolName,
                namespace = namespace,
                file = file,
                element = letStatement
            )
            
            symbolCache.getOrPut(symbolName) { mutableListOf() }.add(symbolInfo)
            namespaceInfo.symbols.add(symbolName)
        }
        
        // 查找所有 using 语句
        val usingStatements = PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieUsingStatementNode::class.java)
        val fileUsingList = mutableListOf<UsingInfo>()
        
        for (usingStatement in usingStatements) {
            val qualifiedName = usingStatement.getImportedName() ?: continue
            val parts = qualifiedName.split(".")
            
            if (parts.size >= 2) {
                val targetNamespace = parts.dropLast(1).joinToString(".")
                val symbolName = parts.last()
                
                val usingInfo = UsingInfo(
                    qualifiedName = qualifiedName,
                    namespace = targetNamespace,
                    symbolName = symbolName,
                    file = file
                )
                
                fileUsingList.add(usingInfo)
            }
        }
        
        usingCache[file] = fileUsingList
    }
    
    /**
     * 查找符号定义
     */
    fun findSymbolDefinition(symbolName: String, currentFile: VirtualFile): SymbolInfo? {
        // 首先在当前文件的命名空间中查找
        val currentPsiFile = PsiManager.getInstance(project).findFile(currentFile)
        val currentNamespace = PsiTreeUtil.findChildOfType(currentPsiFile, ValkyrieNamespaceStatementNode::class.java)
            ?.getNamespaceName() ?: "default"
        
        // 在当前命名空间中查找
        symbolCache[symbolName]?.find { it.namespace == currentNamespace }?.let { return it }
        
        // 在 using 导入中查找
        val usingList = usingCache[currentFile] ?: emptyList()
        for (usingInfo in usingList) {
            if (usingInfo.symbolName == symbolName) {
                symbolCache[symbolName]?.find { it.namespace == usingInfo.namespace }?.let { return it }
            }
        }
        
        return null
    }
    
    /**
     * 获取符号的所有引用
     */
    fun findSymbolReferences(symbolName: String, namespace: String): List<SymbolInfo> {
        return symbolCache[symbolName]?.filter { it.namespace == namespace } ?: emptyList()
    }
    
    /**
     * 获取命名空间中的所有符号
     */
    fun getNamespaceSymbols(namespace: String): Set<String> {
        return namespaceCache[namespace]?.symbols ?: emptySet()
    }
    
    /**
     * 获取文件的 using 导入
     */
    fun getFileUsings(file: VirtualFile): List<UsingInfo> {
        return usingCache[file] ?: emptyList()
    }
    
    companion object {
        fun getInstance(project: Project): ValkyrieSymbolIndex {
            return ValkyrieProjectService.getInstance(project).getSymbolIndex()
        }
    }
}