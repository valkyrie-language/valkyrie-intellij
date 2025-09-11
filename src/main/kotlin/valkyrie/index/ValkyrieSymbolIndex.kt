package valkyrie.index

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.file.ValkyrieFileType
import valkyrie.psi.nodes.ValkyrieNamespaceDeclaration
import valkyrie.psi.nodes.ValkyrieUsingStatementNode
import valkyrie.psi.nodes.ValkyrieLetStatementNode
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieUnionDeclaration
import com.intellij.psi.PsiElement

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
        val element: PsiElement // 改为 PsiElement 以支持多种类型的符号定义
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
        val namespaceStatement = PsiTreeUtil.findChildOfType(psiFile, ValkyrieNamespaceDeclaration::class.java)
        val namespace = namespaceStatement?.getNamespaceName() ?: "default"
        
        // 记录命名空间信息
        val namespaceInfo = namespaceCache.getOrPut(namespace) {
            NamespaceInfo(namespace, file)
        }
        
        // 查找所有 let 语句（变量定义）
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
        
        // 查找所有 class 语句（类型定义）
        val classStatements = PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieClassDeclaration::class.java)
        for (classStatement in classStatements) {
            val symbolName = classStatement.name ?: continue
            
            val symbolInfo = SymbolInfo(
                name = symbolName,
                namespace = namespace,
                file = file,
                element = classStatement
            )
            
            symbolCache.getOrPut(symbolName) { mutableListOf() }.add(symbolInfo)
            namespaceInfo.symbols.add(symbolName)
        }
        
        // 查找所有 union 语句（联合类型定义）
        val unionStatements = PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieUnionDeclaration::class.java)
        for (unionStatement in unionStatements) {
            val symbolName = unionStatement.name ?: continue
            
            val symbolInfo = SymbolInfo(
                name = symbolName,
                namespace = namespace,
                file = file,
                element = unionStatement
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
        val currentPsiFile = PsiManager.getInstance(project).findFile(currentFile)
        val currentNamespace = PsiTreeUtil.findChildOfType(currentPsiFile, ValkyrieNamespaceDeclaration::class.java)
            ?.getNamespaceName() ?: "default"
        
        // 首先在当前文件中直接查找（优先级最高）
        if (currentPsiFile != null) {
            // 查找 let 语句中的变量定义
            val letStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieLetStatementNode::class.java)
            for (letStatement in letStatements) {
                val name = letStatement.getIdentifier()?.text
                if (name == symbolName) {
                    return SymbolInfo(name, currentNamespace, currentFile, letStatement)
                }
            }
            
            // 查找 class 语句中的类型定义
            val classStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieClassDeclaration::class.java)
            for (classStatement in classStatements) {
                val name = classStatement.name
                if (name == symbolName) {
                    return SymbolInfo(name, currentNamespace, currentFile, classStatement)
                }
            }
            
            // 查找 union 语句中的联合类型定义
            val unionStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieUnionDeclaration::class.java)
            for (unionStatement in unionStatements) {
                val name = unionStatement.name
                if (name == symbolName) {
                    return SymbolInfo(name, currentNamespace, currentFile, unionStatement)
                }
            }
        }
        
        // 然后在当前命名空间的其他文件中查找
        symbolCache[symbolName]?.find { it.namespace == currentNamespace && it.file != currentFile }?.let { return it }
        
        // 最后在 using 导入中查找
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
    
    /**
     * 根据名称查找类声明
     */
    fun findClassByName(className: String): ValkyrieClassDeclaration? {
        val symbolInfo = symbolCache[className]?.firstOrNull { it.element is ValkyrieClassDeclaration }
        return symbolInfo?.element as? ValkyrieClassDeclaration
    }
    
    /**
     * 查找继承自指定类的所有子类
     */
    fun findClassesThatInheritFrom(parentClassName: String): List<ValkyrieClassDeclaration> {
        val result = mutableListOf<ValkyrieClassDeclaration>()
        
        // 遍历所有类符号
        symbolCache.values.flatten()
            .filter { it.element is ValkyrieClassDeclaration }
            .forEach { symbolInfo ->
                val classDecl = symbolInfo.element as ValkyrieClassDeclaration
                if (classDecl.getParentClasses().contains(parentClassName)) {
                    result.add(classDecl)
                }
            }
        
        return result
    }
    
    /**
     * 获取类的完整继承链
     */
    fun getInheritanceChain(classDecl: ValkyrieClassDeclaration): List<ValkyrieClassDeclaration> {
        val chain = mutableListOf<ValkyrieClassDeclaration>()
        val visited = mutableSetOf<String>()
        
        fun collectParents(current: ValkyrieClassDeclaration) {
            val className = current.name ?: return
            if (className in visited) return // 避免循环继承
            
            visited.add(className)
            current.getParentClasses().forEach { parentName ->
                findClassByName(parentName)?.let { parentClass ->
                    chain.add(parentClass)
                    collectParents(parentClass)
                }
            }
        }
        
        collectParents(classDecl)
        return chain.distinct()
    }
    
    companion object {
        fun getInstance(project: Project): ValkyrieSymbolIndex {
            return project.getService(ValkyrieSymbolIndex::class.java)
        }
    }
}