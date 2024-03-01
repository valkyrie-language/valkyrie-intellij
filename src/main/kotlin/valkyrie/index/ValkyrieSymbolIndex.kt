package valkyrie.index

import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.openapi.application.ReadAction
import valkyrie.language.file.ValkyrieFileType
import valkyrie.psi.nodes.ValkyrieNamespaceDeclaration
import valkyrie.psi.nodes.ValkyrieUsingStatement
import valkyrie.psi.nodes.ValkyrieLetStatementNode
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.psi.nodes.ValkyrieUnionDeclaration
import valkyrie.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import com.intellij.psi.PsiElement
import valkyrie.project.ValkyrieProjectParser
import valkyrie.project.ValkyrieProjectManager

/**
 * Valkyrie 符号索引服务
 * 负责管理跨文件的 namespace 和 using 关系
 */
@Service(Service.Level.PROJECT)
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
        
        // 获取项目管理器
        val projectManager = ValkyrieProjectManager.getInstance(project)
        
        // 只索引workspace内的valkyrie项目文件
        val workspaces = projectManager.getAllWorkspaces()
        for (workspace in workspaces) {
            val projects = projectManager.getProjectsInWorkspace(workspace)
            for (valkyrieProject in projects) {
                indexValkyrieProject(valkyrieProject.root)
            }
        }
        
        // 索引外部库文件（通过ValkyrieLibraryRootsProvider提供）
         indexExternalLibraries()
     }
    
    /**
     * 索引单个valkyrie项目
     */
    private fun indexValkyrieProject(projectRoot: VirtualFile) {
        val valkyrieFiles = mutableListOf<VirtualFile>()
        collectValkyrieFiles(projectRoot, valkyrieFiles)
        
        for (file in valkyrieFiles) {
            indexFile(file)
        }
    }
    
    /**
     * 递归收集valkyrie文件
     */
    private fun collectValkyrieFiles(directory: VirtualFile, result: MutableList<VirtualFile>) {
        if (!directory.isDirectory) {
            if (directory.extension == "vk" || directory.extension == "valkyrie") {
                result.add(directory)
            }
            return
        }
        
        for (child in directory.children) {
            collectValkyrieFiles(child, result)
        }
    }
    
    /**
     * 索引外部库文件
     */
    private fun indexExternalLibraries() {
        ReadAction.compute<Unit, RuntimeException> {
            // 通过FileTypeIndex获取所有valkyrie文件，但只处理不在workspace内的文件
            val projectManager = ValkyrieProjectManager.getInstance(project)
            val allValkyrieFiles = FileTypeIndex.getFiles(
                ValkyrieFileType.INSTANCE,
                GlobalSearchScope.projectScope(project)
            )
        
            for (file in allValkyrieFiles) {
                // 检查文件是否在workspace内
                val workspace = projectManager.findWorkspaceForFile(file)
                val valkyrieProject = projectManager.findProjectForFile(file)
                
                // 只索引不在workspace内的文件（外部库）
                if (workspace == null && valkyrieProject == null) {
                    indexFile(file)
                }
            }
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
                ReadAction.run<RuntimeException> {
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
                            }
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
        return ReadAction.compute<VirtualFile?, RuntimeException> {
            for (child in packagesRoot.children) {
                if (child.isDirectory) {
                    val legionJson = child.findChild("legion.json")
                    if (legionJson != null) {
                        val projectParser = ValkyrieProjectParser()
                        val valkyrieProject = projectParser.parseProject(project, child)
                        if (valkyrieProject?.packageInfo?.name == packageName) {
                            return@compute child
                        }
                    }
                }
            }
            null
        }
    }
    
    /**
     * 从legion.json文件中获取包名
     */
    private fun getPackageNameFromLegionJson(file: VirtualFile): String? {
        return ReadAction.compute<String?, RuntimeException> {
            // 向上查找legion.json文件
            var currentDir = file.parent
            while (currentDir != null) {
                val legionJson = currentDir.findChild("legion.json")
                if (legionJson != null) {
                    val projectParser = ValkyrieProjectParser()
                    val valkyrieProject = projectParser.parseProject(project, currentDir)
                    return@compute valkyrieProject?.packageInfo?.name
                }
                currentDir = currentDir.parent
            }
            null
        }
    }
    
    /**
     * 索引单个文件
     */
    private fun indexFile(file: VirtualFile) {
        try {
            // 使用非阻塞的ReadAction，避免死锁
            val psiFile = ReadAction.compute<com.intellij.psi.PsiFile?, RuntimeException> {
                PsiManager.getInstance(project).findFile(file)
            } ?: return
            
            // 在ReadAction外部进行数据处理，减少锁定时间
            val (namespace, symbols) = ReadAction.compute<Pair<String, IndexData>, RuntimeException> {
                extractSymbolsFromFile(psiFile, file)
            }
            
            // 在ReadAction外部更新缓存，避免长时间持有锁
            updateCacheWithSymbols(file, namespace, symbols)
            
        } catch (e: Exception) {
            // 记录错误但不中断程序执行
            com.intellij.openapi.diagnostic.Logger.getInstance(ValkyrieSymbolIndex::class.java)
                .warn("Error indexing file ${file.path}: ${e.message}", e)
        }
    }
    
    private data class IndexData(
        val letStatements: List<ValkyrieLetStatementNode>,
        val classStatements: List<ValkyrieClassDeclaration>,
        val unionStatements: List<ValkyrieUnionDeclaration>,
        val functionStatements: List<ValkyrieMethodDeclaration>,
        val usingStatements: List<ValkyrieUsingStatement>
    )
    
    private fun extractSymbolsFromFile(psiFile: com.intellij.psi.PsiFile, file: VirtualFile): Pair<String, IndexData> {
        try {
            // 查找 namespace 声明
            val namespaceStatement = PsiTreeUtil.findChildOfType(psiFile, ValkyrieNamespaceDeclaration::class.java)
            var namespace = try {
                namespaceStatement?.getNamespaceName() ?: "default"
            } catch (e: Exception) {
                "default"
            }
            
            // 处理package关键词，将其替换为legion.json中的实际包名
            if (namespace.startsWith("package.")) {
                try {
                    val packageName = getPackageNameFromLegionJson(file)
                    if (packageName != null) {
                        namespace = namespace.replace("package", packageName)
                    }
                } catch (e: Exception) {
                    // 如果获取包名失败，保持原namespace
                }
            }
            
            val indexData = IndexData(
                letStatements = try { PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieLetStatementNode::class.java).toList() } catch (e: Exception) { emptyList() },
                classStatements = try { PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieClassDeclaration::class.java).toList() } catch (e: Exception) { emptyList() },
                unionStatements = try { PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieUnionDeclaration::class.java).toList() } catch (e: Exception) { emptyList() },
                functionStatements = try { PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieMethodDeclaration::class.java).toList() } catch (e: Exception) { emptyList() },
                usingStatements = try { PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieUsingStatement::class.java).toList() } catch (e: Exception) { emptyList() }
            )
            
            return namespace to indexData
        } catch (e: Exception) {
            // 如果整个方法失败，返回默认值
            return "default" to IndexData(emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
        }
    }
    
    private fun updateCacheWithSymbols(file: VirtualFile, namespace: String, symbols: IndexData) {
        // 记录命名空间信息
        val namespaceInfo = namespaceCache.getOrPut(namespace) {
            NamespaceInfo(namespace, file)
        }
        
        // 处理 let 语句（变量定义）
        for (letStatement in symbols.letStatements) {
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
        
        // 处理 class 语句（类型定义）
        for (classStatement in symbols.classStatements) {
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
        
        // 处理 union 语句（联合类型定义）
        for (unionStatement in symbols.unionStatements) {
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
        
        // 处理函数定义（micro函数）
        for (functionStatement in symbols.functionStatements) {
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
        
        // 处理 using 语句
        val fileUsingList = mutableListOf<UsingInfo>()
        
        for (usingStatement in symbols.usingStatements) {
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
            
            // 然后查找变量定义（let 语句）
            val letStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieLetStatementNode::class.java)
            for (letStatement in letStatements) {
                val name = letStatement.getIdentifier()?.text
                if (name == symbolName) {
                    results.add(SymbolInfo(name, currentNamespace, currentFile, letStatement))
                }
            }
            
            // 最后查找泛型参数定义
            val identifierNodes = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieIdentifierNode::class.java)
            for (identifierNode in identifierNodes) {
                val name = identifierNode.text
                if (name == symbolName && isGenericParameterContext(identifierNode)) {
                    results.add(SymbolInfo(name, currentNamespace, currentFile, identifierNode))
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
     * 判断标识符是否在泛型参数上下文中
     */
    private fun isGenericParameterContext(identifierNode: ValkyrieIdentifierNode): Boolean {
        val parent = identifierNode.parent
        val grandParent = parent?.parent
        
        // 检查是否在泛型参数列表中
        return parent?.node?.elementType?.toString()?.contains("GENERIC_PARAMETER") == true ||
               grandParent?.node?.elementType?.toString()?.contains("GENERIC_PARAMETER") == true
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
    
    /**
     * 查找指定命名空间中的所有类
     */
    fun findClassesInNamespace(namespace: String): List<ValkyrieClassDeclaration> {
        return symbolCache.values.flatten()
            .filter { it.namespace == namespace && it.element is ValkyrieClassDeclaration }
            .mapNotNull { it.element as? ValkyrieClassDeclaration }
    }
    
    /**
     * 查找指定命名空间中的所有函数
     */
    fun findFunctionsInNamespace(namespace: String): List<ValkyrieMethodDeclaration> {
        return symbolCache.values.flatten()
            .filter { it.namespace == namespace && it.element is ValkyrieMethodDeclaration }
            .mapNotNull { it.element as? ValkyrieMethodDeclaration }
    }
    
    companion object {
        fun getInstance(project: Project): ValkyrieSymbolIndex {
            return project.getService(ValkyrieSymbolIndex::class.java)
        }
    }
}