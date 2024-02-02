package valkyrie.index

import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.LocalFileSystem
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
import valkyrie.psi.nodes.ValkyrieMethodDeclaration
import com.intellij.psi.PsiElement
import valkyrie.project.ValkyrieProjectParser

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
        val file: VirtualFile?, // 允许为 null，用于内置类型
        val element: PsiElement? // 允许为 null，用于内置类型
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
        
        // 添加内置类型到符号索引
        addBuiltinTypes()
        
        val valkyrieFiles = FileTypeIndex.getFiles(
            ValkyrieFileType.INSTANCE,
            GlobalSearchScope.projectScope(project)
        )
        
        for (file in valkyrieFiles) {
            indexFile(file)
        }
    }
    
    /**
     * 添加内置类型到符号索引
     */
    private fun addBuiltinTypes() {
        // 内置类型到包文件的映射
        val builtinTypeFiles = mapOf(
            "i8" to Pair("valkyrie-standard", "library/primitive/i8.valkyrie"),
            "i16" to Pair("valkyrie-standard", "library/primitive/i16.valkyrie"),
            "i32" to Pair("valkyrie-standard", "library/primitive/i32.valkyrie"),
            "i64" to Pair("valkyrie-standard", "library/primitive/i64.valkyrie"),
            "u8" to Pair("valkyrie-standard", "library/primitive/u8.valkyrie"),
            "u16" to Pair("valkyrie-standard", "library/primitive/u16.valkyrie"),
            "u32" to Pair("valkyrie-standard", "library/primitive/u32.valkyrie"),
            "f32" to Pair("valkyrie-standard", "source/number/Float32.valkyrie"),
            "Integer32" to Pair("valkyrie-standard", "source/number/Integer32.valkyrie"),
            "Unicode" to Pair("valkyrie-standard", "source/text/Unicode.valkyrie")
        )
        
        for ((typeName, packageInfo) in builtinTypeFiles) {
            val (packageName, relativePath) = packageInfo
            // 根据包名和相对路径查找文件
            val packageFile = findPackageFile(packageName, relativePath)
            if (packageFile != null) {
                // 解析文件中的类定义
                val psiFile = PsiManager.getInstance(project).findFile(packageFile)
                if (psiFile != null) {
                    val classDeclarations = PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieClassDeclaration::class.java)
                    for (classDecl in classDeclarations) {
                        if (classDecl.name == typeName) {
                            // 获取包的实际名称
                            val actualPackageName = getPackageNameFromLegionJson(packageFile) ?: packageName
                            val symbolInfo = SymbolInfo(
                                name = typeName,
                                namespace = "$actualPackageName.primitive",
                                file = packageFile,
                                element = classDecl
                            )
                            symbolCache.getOrPut(typeName) { mutableListOf() }.add(symbolInfo)
                            break
                        }
                    }
                }
            }
        }
    }
    
    /**
     * 根据包名和文件路径查找包文件
     */
    private fun findPackageFile(packageName: String, relativePath: String): VirtualFile? {
        // 从环境变量VALKYRIE_HOME获取包路径
        val valkyrieHome = System.getenv("VALKYRIE_HOME")
        if (valkyrieHome != null) {
            val packagesRoot = LocalFileSystem.getInstance().findFileByPath("$valkyrieHome/packages")
            if (packagesRoot != null) {
                // 在packages目录下查找匹配的包
                val packageDir = findPackageByName(packagesRoot, packageName)
                if (packageDir != null) {
                    val fullPath = "${packageDir.path}/$relativePath"
                    return LocalFileSystem.getInstance().findFileByPath(fullPath)
                }
            }
        } else {
            // 环境变量不存在时记录警告信息
            println("警告: 未找到VALKYRIE_HOME环境变量，请安装Valkyrie环境。Valkyrie安装后会自动设置此环境变量。")
        }
        
        return null
    }
    
    /**
     * 在packages目录下根据包名查找包目录
     */
    private fun findPackageByName(packagesRoot: VirtualFile, packageName: String): VirtualFile? {
        for (child in packagesRoot.children) {
            if (child.isDirectory) {
                val legionJson = child.findChild("legion.json")
                if (legionJson != null) {
                    val projectParser = ValkyrieProjectParser()
                    val valkyrieProject = projectParser.parseProject(project, child)
                    if (valkyrieProject?.packageInfo?.name == packageName) {
                        return child
                    }
                }
            }
        }
        return null
    }
    
    /**
     * 从legion.json文件中获取包名
     */
    private fun getPackageNameFromLegionJson(file: VirtualFile): String? {
        // 向上查找legion.json文件
        var currentDir = file.parent
        while (currentDir != null) {
            val legionJson = currentDir.findChild("legion.json")
            if (legionJson != null) {
                val projectParser = ValkyrieProjectParser()
                val valkyrieProject = projectParser.parseProject(project, currentDir)
                return valkyrieProject?.packageInfo?.name
            }
            currentDir = currentDir.parent
        }
        return null
    }
    
    /**
     * 索引单个文件
     */
    private fun indexFile(file: VirtualFile) {
        val psiFile = PsiManager.getInstance(project).findFile(file) ?: return
        
        // 查找 namespace 声明
        val namespaceStatement = PsiTreeUtil.findChildOfType(psiFile, ValkyrieNamespaceDeclaration::class.java)
        var namespace = namespaceStatement?.getNamespaceName() ?: "default"
        
        // 处理package关键词，将其替换为legion.json中的实际包名
        if (namespace.startsWith("package.")) {
            val packageName = getPackageNameFromLegionJson(file)
            if (packageName != null) {
                namespace = namespace.replace("package", packageName)
            }
        }
        
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
        
        // 查找所有函数定义（micro函数）
        val functionStatements = PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieMethodDeclaration::class.java)
        for (functionStatement in functionStatements) {
            val symbolName = functionStatement.name ?: continue
            
            val symbolInfo = SymbolInfo(
                name = symbolName,
                namespace = namespace,
                file = file,
                element = functionStatement
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
        val allDefinitions = findAllSymbolDefinitions(symbolName, currentFile)
        return allDefinitions.firstOrNull()
    }
    
    /**
     * 查找所有符号定义（用于处理多个同名符号的情况）
     */
    fun findAllSymbolDefinitions(symbolName: String, currentFile: VirtualFile): List<SymbolInfo> {
        val results = mutableListOf<SymbolInfo>()
        val currentPsiFile = PsiManager.getInstance(project).findFile(currentFile)
        val currentNamespace = PsiTreeUtil.findChildOfType(currentPsiFile, ValkyrieNamespaceDeclaration::class.java)
            ?.getNamespaceName() ?: "default"
        
        // 首先检查是否为内置类型（在package.primitive namespace中）
        // 需要将package替换为实际的包名
        val packageName = getPackageNameFromLegionJson(currentFile)
        val primitiveNamespace = if (packageName != null) {
            "$packageName.primitive"
        } else {
            "package.primitive"
        }
        symbolCache[symbolName]?.find { it.namespace == primitiveNamespace }?.let { results.add(it) }
        
        // 然后在当前文件中直接查找（优先级最高）
        if (currentPsiFile != null) {
            // 优先查找类型定义（class, union）
            val classStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieClassDeclaration::class.java)
            for (classStatement in classStatements) {
                val name = classStatement.name
                if (name == symbolName) {
                    results.add(SymbolInfo(name, currentNamespace, currentFile, classStatement))
                }
            }
            
            val unionStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieUnionDeclaration::class.java)
            for (unionStatement in unionStatements) {
                val name = unionStatement.name
                if (name == symbolName) {
                    results.add(SymbolInfo(name, currentNamespace, currentFile, unionStatement))
                }
            }
            
            // 然后查找函数定义
            val functionStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieMethodDeclaration::class.java)
            for (functionStatement in functionStatements) {
                val name = functionStatement.name
                if (name == symbolName) {
                    results.add(SymbolInfo(name, currentNamespace, currentFile, functionStatement))
                }
            }
            
            // 最后查找变量定义（let 语句）
            val letStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieLetStatementNode::class.java)
            for (letStatement in letStatements) {
                val name = letStatement.getIdentifier()?.text
                if (name == symbolName) {
                    results.add(SymbolInfo(name, currentNamespace, currentFile, letStatement))
                }
            }
        }
        
        // 然后在当前命名空间的其他文件中查找
        symbolCache[symbolName]?.filter { it.namespace == currentNamespace && it.file != currentFile }?.let { results.addAll(it) }
        
        // 最后在 using 导入中查找
        val usingList = usingCache[currentFile] ?: emptyList()
        for (usingInfo in usingList) {
            if (usingInfo.symbolName == symbolName) {
                symbolCache[symbolName]?.filter { it.namespace == usingInfo.namespace }?.let { results.addAll(it) }
            }
        }
        
        return results
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