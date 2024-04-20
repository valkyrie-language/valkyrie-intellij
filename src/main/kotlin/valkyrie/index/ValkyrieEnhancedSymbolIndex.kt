package valkyrie.index

import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.openapi.application.ReadAction
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.*
import valkyrie.project.ValkyrieProjectManager
import valkyrie.project.ValkyriePackageManager
import valkyrie.project.workspace.ValkyrieWorkspace
import java.util.concurrent.ConcurrentHashMap

/**
 * Valkyrie 增强符号索引服务
 * 支持跨包符号解析、包别名和命名空间管理
 */
@Service(Service.Level.PROJECT)
class ValkyrieEnhancedSymbolIndex(private val project: Project) {

    // 增强的符号信息数据类
    data class EnhancedSymbolInfo(
        val name: String,
        val namespace: String,
        val file: VirtualFile?,
        val element: PsiElement?,
        val packageName: String?,      // 所属包名
        val isExported: Boolean = true // 是否导出
    )

    // 增强的命名空间信息
    data class EnhancedNamespaceInfo(
        val name: String,
        val file: VirtualFile,
        val symbols: MutableSet<String> = mutableSetOf(),
        val packageName: String,       // 所属包名
        val isPublic: Boolean = true   // 是否公开
    )

    // 增强的 Using 信息
    data class EnhancedUsingInfo(
        val qualifiedName: String,
        val namespace: String,
        val symbolName: String,
        val file: VirtualFile,
        val alias: String? = null,     // 导入别名
        val sourcePackage: String?     // 源包名
    )

    // 符号缓存：符号名 -> 符号信息列表（支持重载）
    private val symbolCache = ConcurrentHashMap<String, MutableList<EnhancedSymbolInfo>>()
    
    // 命名空间缓存
    private val namespaceCache = ConcurrentHashMap<String, EnhancedNamespaceInfo>()
    
    // Using 缓存：文件 -> using 列表
    private val usingCache = ConcurrentHashMap<VirtualFile, MutableList<EnhancedUsingInfo>>()
    
    // 包别名缓存：别名 -> 实际包名
    private val packageAliasCache = ConcurrentHashMap<String, String>()
    
    // 包命名空间映射：包名 -> 命名空间
    private val packageNamespaceCache = ConcurrentHashMap<String, String>()

    @Volatile
    private var isIndexBuilt = false

    /**
     * 确保索引已构建
     */
    private fun ensureIndexBuilt() {
        if (!isIndexBuilt) {
            synchronized(this) {
                if (!isIndexBuilt) {
                    rebuildIndex()
                    isIndexBuilt = true
                }
            }
        }
    }

    /**
     * 重建索引 - 增强版本，支持跨包
     */
    fun rebuildIndex() {
        symbolCache.clear()
        namespaceCache.clear()
        usingCache.clear()
        packageAliasCache.clear()
        packageNamespaceCache.clear()

        // 添加内置类型
        addBuiltinTypes()

        // 获取项目管理器和包管理器
        val projectManager = ValkyrieProjectManager.getInstance(project)
        val packageManager = ValkyriePackageManager.getInstance(project)

        // 索引所有工作空间
        val workspaces = projectManager.getAllWorkspaces()
        for (workspace in workspaces) {
            indexWorkspace(workspace, packageManager)
        }
    }

    /**
     * 索引单个工作空间
     */
    private fun indexWorkspace(workspace: ValkyrieWorkspace, packageManager: ValkyriePackageManager) {
        // 缓存包别名和命名空间映射
        for ((alias, realName) in workspace.packageAliases) {
            packageAliasCache[alias] = realName
        }

        // 索引工作空间内的所有包
        val projects = ValkyrieProjectManager.getInstance(project).getProjectsInWorkspace(workspace)
        for (valkyrieProject in projects) {
            val packageName = valkyrieProject.packageInfo.name
            val namespace = valkyrieProject.packageInfo.getEffectiveNamespace()
            
            // 缓存包命名空间
            packageNamespaceCache[packageName] = namespace
            valkyrieProject.packageInfo.alias?.let { alias ->
                packageNamespaceCache[alias] = namespace
            }

            // 索引包内容
            indexValkyrieProject(valkyrieProject.root, packageName, namespace)
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
                indexValkyrieProject(dep.packageDir, depName, depNamespace, isExported = true)
            }
        }
    }

    /**
     * 索引单个 Valkyrie 项目
     */
    private fun indexValkyrieProject(
        projectRoot: VirtualFile, 
        packageName: String,
        baseNamespace: String,
        isExported: Boolean = true
    ) {
        val valkyrieFiles = mutableListOf<VirtualFile>()
        collectValkyrieFiles(projectRoot, valkyrieFiles)

        for (file in valkyrieFiles) {
            indexFile(file, packageName, baseNamespace, isExported)
        }
    }

    /**
     * 索引单个文件
     */
    private fun indexFile(
        file: VirtualFile, 
        packageName: String,
        baseNamespace: String,
        isExported: Boolean = true
    ) {
        try {
            val psiFile = ReadAction.compute<com.intellij.psi.PsiFile?, RuntimeException> {
                PsiManager.getInstance(project).findFile(file)
            } ?: return

            val (namespace, symbols) = ReadAction.compute<Pair<String, IndexData>, RuntimeException> {
                extractSymbolsFromFile(psiFile, file, baseNamespace)
            }

            updateEnhancedCacheWithSymbols(file, namespace, symbols, packageName, isExported)

        } catch (e: Exception) {
            // 记录错误但不中断执行
            com.intellij.openapi.diagnostic.Logger.getInstance(ValkyrieEnhancedSymbolIndex::class.java)
                .warn("Error indexing file ${file.path}: ${e.message}", e)
        }
    }

    /**
     * 从文件中提取符号（增强版本）
     */
    private fun extractSymbolsFromFile(
        psiFile: com.intellij.psi.PsiFile, 
        file: VirtualFile,
        baseNamespace: String
    ): Pair<String, IndexData> {
        try {
            // 查找 namespace 声明
            val namespaceStatement = PsiTreeUtil.findChildOfType(psiFile, ValkyrieNamespaceDeclaration::class.java)
            var namespace = try {
                namespaceStatement?.getNamespaceName() ?: baseNamespace
            } catch (e: Exception) {
                baseNamespace
            }

            // 处理 package 关键字替换
            if (namespace.startsWith("package.")) {
                namespace = namespace.replace("package", baseNamespace)
            }

            val indexData = IndexData(
                letStatements = try { 
                    PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieLetStatementNode::class.java).toList() 
                } catch (e: Exception) { emptyList() },
                classStatements = try { 
                    PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieClassDeclaration::class.java).toList() 
                } catch (e: Exception) { emptyList() },
                unionStatements = try { 
                    PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieUnionDeclaration::class.java).toList() 
                } catch (e: Exception) { emptyList() },
                functionStatements = try { 
                    PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieMethodDeclaration::class.java).toList() 
                } catch (e: Exception) { emptyList() },
                usingStatements = try { 
                    PsiTreeUtil.findChildrenOfType(psiFile, ValkyrieUsingStatement::class.java).toList() 
                } catch (e: Exception) { emptyList() }
            )

            return namespace to indexData
        } catch (e: Exception) {
            return baseNamespace to IndexData(emptyList(), emptyList(), emptyList(), emptyList(), emptyList())
        }
    }

    /**
     * 更新增强缓存
     */
    private fun updateEnhancedCacheWithSymbols(
        file: VirtualFile,
        namespace: String,
        symbols: IndexData,
        packageName: String,
        isExported: Boolean
    ) {
        // 记录命名空间信息
        val namespaceInfo = namespaceCache.getOrPut(namespace) {
            EnhancedNamespaceInfo(namespace, file, packageName = packageName)
        }

        // 处理 let 语句
        for (letStatement in symbols.letStatements) {
            val symbolName = letStatement.getIdentifier()?.text ?: continue
            addSymbolToCache(symbolName, namespace, file, letStatement, packageName, isExported)
            namespaceInfo.symbols.add(symbolName)
        }

        // 处理 class 语句
        for (classStatement in symbols.classStatements) {
            val symbolName = classStatement.name ?: continue
            addSymbolToCache(symbolName, namespace, file, classStatement, packageName, isExported)
            namespaceInfo.symbols.add(symbolName)
        }

        // 处理 union 语句
        for (unionStatement in symbols.unionStatements) {
            val symbolName = unionStatement.name ?: continue
            addSymbolToCache(symbolName, namespace, file, unionStatement, packageName, isExported)
            namespaceInfo.symbols.add(symbolName)
        }

        // 处理函数定义
        for (functionStatement in symbols.functionStatements) {
            val symbolName = functionStatement.name ?: continue
            addSymbolToCache(symbolName, namespace, file, functionStatement, packageName, isExported)
            namespaceInfo.symbols.add(symbolName)
        }

        // 处理 using 语句（增强版本）
        val fileUsingList = mutableListOf<EnhancedUsingInfo>()

        for (usingStatement in symbols.usingStatements) {
            val qualifiedName = usingStatement.getImportedName() ?: continue
            val parts = qualifiedName.split("::")

            if (parts.size >= 2) {
                val targetNamespace = parts.dropLast(1).joinToString(".")
                val symbolName = parts.last()
                
                // 处理包别名
                val sourcePackage = resolvePackageFromNamespace(targetNamespace)
                val alias = extractAliasFromUsing(usingStatement)

                val usingInfo = EnhancedUsingInfo(
                    qualifiedName = qualifiedName,
                    namespace = targetNamespace,
                    symbolName = symbolName,
                    file = file,
                    alias = alias,
                    sourcePackage = sourcePackage
                )

                fileUsingList.add(usingInfo)
            }
        }

        usingCache[file] = fileUsingList
    }

    /**
     * 向符号缓存添加符号
     */
    private fun addSymbolToCache(
        name: String,
        namespace: String,
        file: VirtualFile,
        element: PsiElement,
        packageName: String,
        isExported: Boolean
    ) {
        val symbolInfo = EnhancedSymbolInfo(
            name = name,
            namespace = namespace,
            file = file,
            element = element,
            packageName = packageName,
            isExported = isExported
        )

        symbolCache.getOrPut(name) { mutableListOf() }.add(symbolInfo)
    }

    /**
     * 从命名空间解析包名
     */
    private fun resolvePackageFromNamespace(namespace: String): String? {
        // 查找匹配该命名空间的包
        for ((pkgName, pkgNamespace) in packageNamespaceCache) {
            if (pkgNamespace == namespace) {
                return pkgName
            }
        }
        return null
    }

    /**
     * 从 using 语句中提取别名
     */
    private fun extractAliasFromUsing(usingStatement: ValkyrieUsingStatement): String? {
        // 检查是否有 as 关键字
        val text = usingStatement.text
        if (text.contains(" as ")) {
            val parts = text.split(" as ")
            if (parts.size == 2) {
                return parts[1].trim().removeSuffix(";").trim()
            }
        }
        return null
    }

    /**
     * 增强的符号查找 - 支持跨包解析
     */
    fun findSymbolDefinition(symbolName: String, currentFile: VirtualFile): EnhancedSymbolInfo? {
        ensureIndexBuilt()
        return findAllSymbolDefinitions(symbolName, currentFile).firstOrNull()
    }

    /**
     * 查找所有符号定义（增强版本）
     */
    fun findAllSymbolDefinitions(symbolName: String, currentFile: VirtualFile): List<EnhancedSymbolInfo> {
        ensureIndexBuilt()
        val results = mutableListOf<EnhancedSymbolInfo>()
        
        val currentPsiFile = PsiManager.getInstance(project).findFile(currentFile)
        val currentNamespace = PsiTreeUtil.findChildOfType(currentPsiFile, ValkyrieNamespaceDeclaration::class.java)
            ?.getNamespaceName() ?: "default"

        // 1. 首先检查内置类型
        val packageName = getPackageNameFromFile(currentFile)
        val primitiveNamespace = if (packageName != null) {
            val pkgNamespace = packageNamespaceCache[packageName] ?: packageName.replace("-", "_")
            "$pkgNamespace.primitive"
        } else {
            "package.primitive"
        }
        symbolCache[symbolName]?.find { it.namespace == primitiveNamespace }?.let { results.add(it) }

        // 2. 在当前文件中直接查找（优先级最高）
        if (currentPsiFile != null) {
            // 查找类型定义
            val classStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieClassDeclaration::class.java)
            for (classStatement in classStatements) {
                if (classStatement.name == symbolName) {
                    results.add(EnhancedSymbolInfo(
                        name = symbolName,
                        namespace = currentNamespace,
                        file = currentFile,
                        element = classStatement,
                        packageName = packageName,
                        isExported = true
                    ))
                }
            }

            val unionStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieUnionDeclaration::class.java)
            for (unionStatement in unionStatements) {
                if (unionStatement.name == symbolName) {
                    results.add(EnhancedSymbolInfo(
                        name = symbolName,
                        namespace = currentNamespace,
                        file = currentFile,
                        element = unionStatement,
                        packageName = packageName,
                        isExported = true
                    ))
                }
            }

            // 查找函数定义
            val functionStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieMethodDeclaration::class.java)
            for (functionStatement in functionStatements) {
                if (functionStatement.name == symbolName) {
                    results.add(EnhancedSymbolInfo(
                        name = symbolName,
                        namespace = currentNamespace,
                        file = currentFile,
                        element = functionStatement,
                        packageName = packageName,
                        isExported = true
                    ))
                }
            }

            // 查找变量定义
            val letStatements = PsiTreeUtil.findChildrenOfType(currentPsiFile, ValkyrieLetStatementNode::class.java)
            for (letStatement in letStatements) {
                if (letStatement.getIdentifier()?.text == symbolName) {
                    results.add(EnhancedSymbolInfo(
                        name = symbolName,
                        namespace = currentNamespace,
                        file = currentFile,
                        element = letStatement,
                        packageName = packageName,
                        isExported = true
                    ))
                }
            }
        }

        // 3. 在当前命名空间的其他文件中查找
        symbolCache[symbolName]?.filter { 
            it.namespace == currentNamespace && it.file != currentFile 
        }?.let { results.addAll(it) }

        // 4. 在 using 导入中查找（增强版本，支持别名）
        val usingList = usingCache[currentFile] ?: emptyList()
        for (usingInfo in usingList) {
            // 处理别名匹配
            val targetSymbolName = usingInfo.alias ?: usingInfo.symbolName
            if (targetSymbolName == symbolName) {
                // 查找匹配命名空间的符号
                val symbols = symbolCache[usingInfo.symbolName] ?: emptyList()
                for (symbol in symbols) {
                    if (symbol.namespace == usingInfo.namespace) {
                        // 检查导出状态（只允许访问导出的符号）
                        if (symbol.isExported || symbol.packageName == packageName) {
                            results.add(symbol)
                        }
                    }
                }
            }
        }

        // 5. 支持包名限定的查找：package::symbol
        if (symbolName.contains("::")) {
            val parts = symbolName.split("::")
            if (parts.size == 2) {
                val pkgNameOrAlias = parts[0]
                val realPkgName = packageAliasCache[pkgNameOrAlias] ?: pkgNameOrAlias
                val actualSymbolName = parts[1]
                
                val pkgNamespace = packageNamespaceCache[realPkgName]
                if (pkgNamespace != null) {
                    symbolCache[actualSymbolName]?.filter { 
                        it.namespace.startsWith(pkgNamespace) && it.isExported 
                    }?.let { results.addAll(it) }
                }
            }
        }

        return results.distinct()
    }

    /**
     * 获取文件所属的包名
     */
    private fun getPackageNameFromFile(file: VirtualFile): String? {
        // 向上查找 legion.json 文件
        var currentDir = if (file.isDirectory) file else file.parent
        while (currentDir != null) {
            val legionJson = currentDir.findChild("legion.json")
            if (legionJson != null) {
                val projectParser = valkyrie.project.ValkyrieProjectParser()
                val valkyrieProject = projectParser.parseProject(project, currentDir)
                return valkyrieProject?.packageInfo?.name
            }
            currentDir = currentDir.parent
        }
        return null
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
    fun getFileUsings(file: VirtualFile): List<EnhancedUsingInfo> {
        ensureIndexBuilt()
        return usingCache[file] ?: emptyList()
    }

    /**
     * 解析包别名
     */
    fun resolvePackageAlias(alias: String): String? {
        ensureIndexBuilt()
        return packageAliasCache[alias]
    }

    /**
     * 获取包的命名空间
     */
    fun getPackageNamespace(packageName: String): String? {
        ensureIndexBuilt()
        return packageNamespaceCache[packageName]
    }

    /**
     * 添加内置类型（增强版本）
     */
    private fun addBuiltinTypes() {
        // 内置类型映射
        val builtinTypes = listOf("i8", "i16", "i32", "i64", "u8", "u16", "u32", "f32", "Integer32", "Unicode")
        
        for (typeName in builtinTypes) {
            val symbolInfo = EnhancedSymbolInfo(
                name = typeName,
                namespace = "valkyrie.standard.primitive",
                file = null,
                element = null,
                packageName = "valkyrie-standard",
                isExported = true
            )
            symbolCache.getOrPut(typeName) { mutableListOf() }.add(symbolInfo)
        }
    }

    /**
     * 收集 Valkyrie 文件
     */
    private fun collectValkyrieFiles(directory: VirtualFile, result: MutableList<VirtualFile>) {
        if (!directory.isDirectory) {
            if (directory.extension == "vk" || directory.extension == "valkyrie") {
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
     * 索引外部库（增强版本）
     */
    private fun indexExternalLibraries(packageManager: ValkyriePackageManager) {
        ReadAction.compute<Unit, RuntimeException> {
            val projectBaseDir = project.baseDir ?: return@compute

            val externalValkyrieFiles = mutableListOf<VirtualFile>()
            collectExternalValkyrieFiles(projectBaseDir, packageManager, externalValkyrieFiles)

            for (file in externalValkyrieFiles) {
                // 获取文件的包信息
                val packageName = getPackageNameFromFile(file)
                if (packageName != null) {
                    val pkgNamespace = packageNamespaceCache[packageName] ?: packageName.replace("-", "_")
                    indexFile(file, packageName, pkgNamespace, true)
                }
            }
        }
    }

    /**
     * 收集外部库的 Valkyrie 文件
     */
    private fun collectExternalValkyrieFiles(
        directory: VirtualFile,
        packageManager: ValkyriePackageManager,
        result: MutableList<VirtualFile>
    ) {
        if (!directory.isDirectory) return

        val projectManager = ValkyrieProjectManager.getInstance(project)

        for (child in directory.children) {
            if (child.isDirectory) {
                // 检查是否为 workspace 或 project
                val isWorkspace = projectManager.isValkyrieWorkspace(child)
                val isProject = projectManager.isValkyrieProject(child)

                if (!isWorkspace && !isProject) {
                    // 继续递归扫描
                    collectExternalValkyrieFiles(child, packageManager, result)
                }
            } else if (child.extension == "vk") {
                // 检查文件是否在 workspace 内
                val workspace = projectManager.findWorkspaceForFile(child)
                val valkyrieProject = projectManager.findProjectForFile(child)

                // 只收集不在 workspace 内的文件（外部库）
                if (workspace == null && valkyrieProject == null) {
                    result.add(child)
                }
            }
        }
    }

    companion object {
        fun getInstance(project: Project): ValkyrieEnhancedSymbolIndex {
            return project.getService(ValkyrieEnhancedSymbolIndex::class.java)
        }
    }
}

// 内部数据结构
private data class IndexData(
    val letStatements: List<ValkyrieLetStatementNode>,
    val classStatements: List<ValkyrieClassDeclaration>,
    val unionStatements: List<ValkyrieUnionDeclaration>,
    val functionStatements: List<ValkyrieMethodDeclaration>,
    val usingStatements: List<ValkyrieUsingStatement>
)