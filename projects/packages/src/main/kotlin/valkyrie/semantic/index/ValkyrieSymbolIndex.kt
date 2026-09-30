package valkyrie.semantic.index

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.components.Service
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiManager
import com.intellij.psi.SmartPointerManager
import com.intellij.psi.SmartPsiElementPointer
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.surface.file.ValkyrieSourceFiles
import valkyrie.surface.psi.nodes.ValkyrieNamespaceDeclaration
import valkyrie.surface.psi.nodes.ValkyrieUsingStatement
import valkyrie.surface.psi.nodes.ValkyrieLetStatementNode
import valkyrie.surface.psi.nodes.ValkyrieClassDeclaration
import valkyrie.surface.psi.nodes.ValkyrieUnionDeclaration
import valkyrie.surface.psi.nodes.ValkyrieMethodDeclaration
import valkyrie.surface.psi.nodes.ValkyrieIdentifierNode
import valkyrie.workspace.project.ValkyrieProjectParser
import valkyrie.workspace.project.ValkyrieProjectManager
import valkyrie.workspace.project.ValkyriePackageManager
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Valkyrie 符号索引服务
 * 负责管理跨文件的 namespace 和 using 关系
 */
@Service(Service.Level.PROJECT)
class ValkyrieSymbolIndex(private val project: Project) {

    companion object {
        private val LOG = Logger.getInstance(ValkyrieSymbolIndex::class.java)
        private val valkyrieHomeWarned = AtomicBoolean(false)

        fun getInstance(project: Project): ValkyrieSymbolIndex {
            return project.getService(ValkyrieSymbolIndex::class.java)
        }
    }
    
    // 符号信息数据类
    data class SymbolInfo(
        val name: String,
        val namespace: String,
        val file: VirtualFile?, // 允许为 null，用于内置类型
        private val elementPointer: SmartPsiElementPointer<PsiElement>? = null,
    ) {
        val element: PsiElement?
            get() = elementPointer?.element
    }
    
    // 命名空间信息数据类
    data class NamespaceInfo(
        val name: String,
        val file: VirtualFile,
        val symbols: MutableSet<String> = mutableSetOf()
    )
    
    // Using 语句信息数据类（增强版本，支持别名）
    data class UsingInfo(
        val qualifiedName: String,
        val namespace: String,
        val symbolName: String,
        val file: VirtualFile,
        val alias: String? = null,     // 导入别名
        val sourcePackage: String? = null // 源包名
    )

    private val symbolCache = mutableMapOf<String, MutableList<SymbolInfo>>()
    private val namespaceCache = mutableMapOf<String, NamespaceInfo>()
    private val usingCache = mutableMapOf<VirtualFile, MutableList<UsingInfo>>()
    
    // 新增：包别名和命名空间缓存（增强功能）
    private val packageAliasCache = mutableMapOf<String, String>()
    private val packageNamespaceCache = mutableMapOf<String, String>()
    
    // 延迟初始化标志
    @Volatile
    private var isIndexBuilt = false

    @Volatile
    private var isIndexBuilding = false

    private val indexedFiles = mutableSetOf<VirtualFile>()

    private val legionPackageNameCache = mutableMapOf<String, String?>()

    /**
     * 确保索引已构建，如果未构建则构建索引
     */
    private fun ensureIndexBuilt() {
        if (isIndexBuilt || isIndexBuilding) {
            return
        }
        synchronized(this) {
            if (isIndexBuilt || isIndexBuilding) {
                return
            }
            isIndexBuilding = true
            ApplicationManager.getApplication().executeOnPooledThread {
                ReadAction.run<RuntimeException> {
                    try {
                        rebuildIndex()
                    } finally {
                        isIndexBuilt = true
                        isIndexBuilding = false
                    }
                }
            }
        }
    }

    private fun ensureFileIndexed(file: VirtualFile) {
        if (!ValkyrieSourceFiles.isSourceFile(file) || file in indexedFiles) {
            return
        }
        indexedFiles.add(file)
        indexFile(file)
    }

    /**
     * Incrementally refresh one source file after VFS changes.
     */
    fun reindexFile(file: VirtualFile) {
        if (!ValkyrieSourceFiles.isSourceFile(file)) {
            return
        }
        removeFileFromIndex(file)
        if (file.isValid) {
            indexFile(file)
        }
    }

    /**
     * Drop all cached symbols that came from [file].
     */
    fun removeFileFromIndex(file: VirtualFile) {
        usingCache.remove(file)
        indexedFiles.remove(file)

        val staleNames = mutableListOf<String>()
        for ((name, symbols) in symbolCache) {
            symbols.removeAll { it.file == file }
            if (symbols.isEmpty()) {
                staleNames.add(name)
            }
        }
        for (name in staleNames) {
            symbolCache.remove(name)
        }

        val staleNamespaces = namespaceCache.values.filter { it.file == file }.map { it.name }
        for (namespace in staleNamespaces) {
            namespaceCache.remove(namespace)
        }
    }

    private fun pointerOf(element: PsiElement?): SmartPsiElementPointer<PsiElement>? {
        if (element == null || !element.isValid) {
            return null
        }
        return SmartPointerManager.getInstance(project).createSmartPsiElementPointer(element)
    }
    
    /**
     * 重建索引（增强版本，支持跨包）
     */
    fun rebuildIndex() {
        symbolCache.clear()
        namespaceCache.clear()
        usingCache.clear()
        packageAliasCache.clear()
        packageNamespaceCache.clear()
        indexedFiles.clear()
        
        // 添加内置类型到符号索引
        addBuiltinTypes()
        
        // 获取项目管理器和包管理器
        val projectManager = ValkyrieProjectManager.getInstance(project)
        val packageManager = ValkyriePackageManager.getInstance(project)
        
        // 只索引workspace内的valkyrie项目文件
        val workspaces = projectManager.getAllWorkspaces()
        for (workspace in workspaces) {
            // 缓存包别名和命名空间映射
            for ((alias, realName) in workspace.packageAliases) {
                packageAliasCache[alias] = realName
            }
            
            val projects = projectManager.getProjectsInWorkspace(workspace)
            for (valkyrieProject in projects) {
                val packageName = valkyrieProject.packageInfo.name
                val namespace = valkyrieProject.packageInfo.getEffectiveNamespace()
                
                // 缓存包命名空间
                packageNamespaceCache[packageName] = namespace
                valkyrieProject.packageInfo.alias?.let { alias ->
                    packageNamespaceCache[alias] = namespace
                }
                
                indexValkyrieProject(valkyrieProject.root)
            }
            
            // 索引工作空间的依赖包
            val dependencies = packageManager.resolveWorkspaceDependencies(workspace)
            for ((depName, dep) in dependencies) {
                if (dep.packageDir != null && dep.packageInfo != null) {
                    val depNamespace = dep.packageInfo.getEffectiveNamespace()
                    packageNamespaceCache[depName] = depNamespace
                    dep.alias?.let { alias ->
                        packageNamespaceCache[alias] = depNamespace
                    }
                    
                    // 索引依赖包内容
                    indexValkyrieProject(dep.packageDir)
                }
            }
        }
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
            if (ValkyrieSourceFiles.isSourceFile(directory)) {
                result.add(directory)
            }
            return
        }
        
        // 跳过常见的非代码目录，提高扫描性能
        val name = directory.name
        if (name == ".git" || name == ".idea" || name == "node_modules" || name == "target" || name == "build" || name == "out") {
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
        // 避免使用 FileTypeIndex 以防止与 IntelliJ 索引系统冲突
        // 改为通过项目根目录遍历查找 .vk 文件
        ReadAction.compute<Unit, RuntimeException> {
            val projectManager = ValkyrieProjectManager.getInstance(project)
            val projectBaseDir = project.baseDir ?: return@compute
            
            val externalValkyrieFiles = mutableListOf<VirtualFile>()
            collectExternalValkyrieFiles(projectBaseDir, projectManager, externalValkyrieFiles)
            
            for (file in externalValkyrieFiles) {
                indexFile(file)
            }
        }
    }
    
    /**
     * 收集外部库的 Valkyrie 文件
     */
    private fun collectExternalValkyrieFiles(
        directory: VirtualFile, 
        projectManager: ValkyrieProjectManager, 
        result: MutableList<VirtualFile>
    ) {
        if (!directory.isDirectory) return
        
        for (child in directory.children) {
            if (child.isDirectory) {
                collectExternalValkyrieFiles(child, projectManager, result)
            } else if (ValkyrieSourceFiles.isSourceFile(child)) {
                // 检查文件是否在workspace内
                val workspace = projectManager.findWorkspaceForFile(child)
                val valkyrieProject = projectManager.findProjectForFile(child)
                
                // 只收集不在workspace内的文件（外部库）
                if (workspace == null && valkyrieProject == null) {
                    result.add(child)
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
                                    elementPointer = pointerOf(classDecl),
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
        } else if (valkyrieHomeWarned.compareAndSet(false, true)) {
            LOG.warn("VALKYRIE_HOME is not set. Standard library packages will not be indexed.")
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
            var currentDir = file.parent
            while (currentDir != null) {
                legionPackageNameCache[currentDir.path]?.let { return@compute it }
                val legionJson = currentDir.findChild("legion.json")
                if (legionJson != null) {
                    val projectParser = ValkyrieProjectParser()
                    val valkyrieProject = projectParser.parseProject(project, currentDir)
                    val packageName = valkyrieProject?.packageInfo?.name
                    legionPackageNameCache[currentDir.path] = packageName
                    return@compute packageName
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
            indexedFiles.add(file)

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
                elementPointer = pointerOf(letStatement),
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
                elementPointer = pointerOf(classStatement),
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
                elementPointer = pointerOf(unionStatement),
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
                elementPointer = pointerOf(functionStatement),
            )
            
            symbolCache.getOrPut(symbolName) { mutableListOf() }.add(symbolInfo)
            namespaceInfo.symbols.add(symbolName)
        }
        
        // 处理 using 语句（增强版本，支持 :: 和别名）
        val fileUsingList = mutableListOf<UsingInfo>()
        
        for (usingStatement in symbols.usingStatements) {
            val qualifiedName = usingStatement.getImportedName() ?: continue
            
            // 支持包名限定语法：package::symbol 或 package::module::symbol
            if (qualifiedName.contains("::")) {
                val parts = qualifiedName.split("::")
                if (parts.size >= 2) {
                    val pkgNameOrAlias = parts[0]
                    val remainingPath = parts.drop(1)
                    
                    // 解析包别名
                    val realPkgName = resolvePackageAlias(pkgNameOrAlias) ?: pkgNameOrAlias
                    val pkgNamespace = getPackageNamespace(realPkgName)
                    
                    if (pkgNamespace != null) {
                        val targetNamespace = if (remainingPath.size > 1) {
                            "$pkgNamespace.${remainingPath.dropLast(1).joinToString(".")}"
                        } else {
                            pkgNamespace
                        }
                        val symbolName = remainingPath.last()
                        
                        // 检查是否有别名（using package::symbol as alias）
                        val alias = extractAliasFromUsing(qualifiedName, usingStatement.text)
                        
                        val usingInfo = UsingInfo(
                            qualifiedName = qualifiedName,
                            namespace = targetNamespace,
                            symbolName = symbolName,
                            file = file,
                            alias = alias,
                            sourcePackage = realPkgName
                        )
                        
                        fileUsingList.add(usingInfo)
                    }
                }
            } else {
                // 传统的点分隔语法：package.module.symbol
                val parts = qualifiedName.split(".")
                if (parts.size >= 2) {
                    val targetNamespace = parts.dropLast(1).joinToString(".")
                    val symbolName = parts.last()
                    
                    // 检查是否有别名
                    val alias = extractAliasFromUsing(qualifiedName, usingStatement.text)
                    
                    val usingInfo = UsingInfo(
                        qualifiedName = qualifiedName,
                        namespace = targetNamespace,
                        symbolName = symbolName,
                        file = file,
                        alias = alias
                    )
                    
                    fileUsingList.add(usingInfo)
                }
            }
        }
        
        usingCache[file] = fileUsingList
    }
    
    /**
     * 查找符号定义
     */
    fun findSymbolDefinition(symbolName: String, currentFile: VirtualFile): SymbolInfo? {
        ensureIndexBuilt()
        return findAllSymbolDefinitions(symbolName, currentFile).firstOrNull()
    }
    
    /**
     * 查找所有符号定义（增强版本，支持跨包解析和包别名）
     */
    fun findAllSymbolDefinitions(symbolName: String, currentFile: VirtualFile): List<SymbolInfo> {
        ensureIndexBuilt()
        ensureFileIndexed(currentFile)
        val results = mutableListOf<SymbolInfo>()
        val currentPsiFile = PsiManager.getInstance(project).findFile(currentFile)
        val currentNamespace = PsiTreeUtil.findChildOfType(currentPsiFile, ValkyrieNamespaceDeclaration::class.java)
            ?.getNamespaceName() ?: "default"
        
        // 1. 支持包名限定的查找：package::symbol
        if (symbolName.contains("::")) {
            val parts = symbolName.split("::")
            if (parts.size == 2) {
                val pkgNameOrAlias = parts[0]
                val actualSymbolName = parts[1]
                
                // 解析包别名
                val realPkgName = resolvePackageAlias(pkgNameOrAlias) ?: pkgNameOrAlias
                val pkgNamespace = getPackageNamespace(realPkgName)
                
                if (pkgNamespace != null) {
                    val namespaceSymbols = symbolCache[actualSymbolName] ?: emptyList()
                    for (symbol in namespaceSymbols) {
                        if (symbol.namespace.startsWith(pkgNamespace)) {
                            results.add(symbol)
                        }
                    }
                }
            }
        }

        // 2. 首先检查是否为内置类型（在package.primitive namespace中）
        val packageName = getPackageNameFromLegionJson(currentFile)
        val primitiveNamespace = if (packageName != null) {
            "$packageName.primitive"
        } else {
            "package.primitive"
        }
        symbolCache[symbolName]?.find { it.namespace == primitiveNamespace }?.let { results.add(it) }
        
        // 3. 当前文件定义（来自按需索引缓存）
        symbolCache[symbolName]
            ?.filter { it.file == currentFile }
            ?.let { results.addAll(it) }

        // 4. 然后在当前命名空间的其他文件中查找
        symbolCache[symbolName]?.filter { it.namespace == currentNamespace && it.file != currentFile }?.let { results.addAll(it) }
        
        // 5. 最后在 using 导入中查找（支持别名）
        val usingList = usingCache[currentFile] ?: emptyList()
        for (usingInfo in usingList) {
            // 处理别名匹配
            val targetSymbolName = usingInfo.alias ?: usingInfo.symbolName
            if (targetSymbolName == symbolName) {
                symbolCache[usingInfo.symbolName]?.filter { it.namespace == usingInfo.namespace }?.let { results.addAll(it) }
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
     * 从 using 语句中提取别名
     * 支持：using package::symbol as alias
     */
    private fun extractAliasFromUsing(qualifiedName: String, usingText: String): String? {
        // 检查是否有 as 关键字
        if (usingText.contains(" as ")) {
            val parts = usingText.split(" as ")
            if (parts.size == 2) {
                return parts[1].trim().removeSuffix(";").trim()
            }
        }
        return null
    }

    /**
     * 获取符号的所有引用
     */
    fun findSymbolReferences(symbolName: String, namespace: String): List<SymbolInfo> {
        ensureIndexBuilt()
        return symbolCache[symbolName]?.filter { it.namespace == namespace } ?: emptyList()
    }
    
    /**
     * 获取命名空间中的所有符号
     */
    fun getNamespaceSymbols(namespace: String): Set<String> {
        ensureIndexBuilt()
        return namespaceCache[namespace]?.symbols ?: emptySet()
    }
    
    /**
     * 获取文件的 using 导入
     */
    fun getFileUsings(file: VirtualFile): List<UsingInfo> {
        ensureIndexBuilt()
        return usingCache[file] ?: emptyList()
    }
    
    /**
     * 根据名称查找类声明
     */
    fun findClassByName(className: String): ValkyrieClassDeclaration? {
        ensureIndexBuilt()
        val symbolInfo = symbolCache[className]?.firstOrNull { it.element is ValkyrieClassDeclaration }
        return symbolInfo?.element as? ValkyrieClassDeclaration
    }
    
    /**
     * 查找继承自指定类的所有子类
     */
    fun findClassesThatInheritFrom(parentClassName: String): List<ValkyrieClassDeclaration> {
        ensureIndexBuilt()
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
        ensureIndexBuilt()
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
        ensureIndexBuilt()
        return symbolCache.values.flatten()
            .filter { it.namespace == namespace && it.element is ValkyrieClassDeclaration }
            .mapNotNull { it.element as? ValkyrieClassDeclaration }
    }
    
    /**
     * 查找指定命名空间中的所有函数
     */
    fun findFunctionsInNamespace(namespace: String): List<ValkyrieMethodDeclaration> {
        ensureIndexBuilt()
        return symbolCache.values.flatten()
            .filter { it.namespace == namespace && it.element is ValkyrieMethodDeclaration }
            .mapNotNull { it.element as? ValkyrieMethodDeclaration }
    }

    /**
     * 解析包别名（增强版本，支持工作空间配置）
     */
    fun resolvePackageAlias(alias: String): String? {
        ensureIndexBuilt()
        
        // 首先检查工作空间配置的别名
        val projectManager = ValkyrieProjectManager.getInstance(project)
        val workspaces = projectManager.getAllWorkspaces()
        
        for (workspace in workspaces) {
            val realName = workspace.resolveAlias(alias)
            if (realName != null) {
                return realName
            }
        }
        
        // 检查包管理器中的别名缓存
        val packageManager = ValkyriePackageManager.getInstance(project)
        // 这里可以添加包管理器的别名解析逻辑
        
        return null
    }

    /**
     * 获取包的命名空间（增强版本）
     */
    fun getPackageNamespace(packageName: String): String? {
        ensureIndexBuilt()
        
        // 首先检查缓存
        val cachedNamespace = packageNamespaceCache[packageName]
        if (cachedNamespace != null) {
            return cachedNamespace
        }
        
        // 通过包管理器解析
        val projectManager = ValkyrieProjectManager.getInstance(project)
        val packageManager = ValkyriePackageManager.getInstance(project)
        
        // 在工作空间中查找包
        for (workspace in projectManager.getAllWorkspaces()) {
            val packageDir = packageManager.findPackageDirectory(packageName, workspace)
            if (packageDir != null) {
                val projectInfo = projectManager.findProjectForFile(packageDir)
                val namespace = projectInfo?.packageInfo?.getEffectiveNamespace() ?: packageName.replace("-", "_")
                
                // 缓存结果
                packageNamespaceCache[packageName] = namespace
                return namespace
            }
        }
        
        return null
    }

    /**
     * 检查包是否导出指定模块
     */
    fun isModuleExported(packageName: String, module: String): Boolean {
        ensureIndexBuilt()
        
        val projectManager = ValkyrieProjectManager.getInstance(project)
        val packageManager = ValkyriePackageManager.getInstance(project)
        
        for (workspace in projectManager.getAllWorkspaces()) {
            val packageDir = packageManager.findPackageDirectory(packageName, workspace)
            if (packageDir != null) {
                val projectInfo = projectManager.findProjectForFile(packageDir)
                return projectInfo?.packageInfo?.isExported(module) ?: true
            }
        }
        
        return true // 默认导出
    }

    /**
     * 获取文件所属的包名（增强版本，支持工作空间）
     */
    fun getPackageNameFromFile(file: VirtualFile): String? {
        val projectManager = ValkyrieProjectManager.getInstance(project)
        val valkyrieProject = projectManager.findProjectForFile(file)
        return valkyrieProject?.packageInfo?.name
    }

    /**
     * 获取工作空间的包别名映射
     */
    fun getWorkspacePackageAliases(): Map<String, String> {
        ensureIndexBuilt()
        
        val aliases = mutableMapOf<String, String>()
        val projectManager = ValkyrieProjectManager.getInstance(project)
        
        for (workspace in projectManager.getAllWorkspaces()) {
            aliases.putAll(workspace.getAllAliases())
        }
        
        return aliases
    }
}