package valkyrie.project

import com.intellij.openapi.components.Service
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.PsiManager
import com.intellij.json.psi.JsonFile
import com.intellij.json.psi.JsonObject
import com.intellij.openapi.application.ReadAction
import valkyrie.project.workspace.ValkyrieWorkspace
import valkyrie.project.workspace.ValkyrieWorkspaceParser
import java.util.concurrent.ConcurrentHashMap

/**
 * Valkyrie 包管理器服务
 * 负责包依赖解析、版本管理和跨包符号查找
 */
@Service(Service.Level.PROJECT)
class ValkyriePackageManager(private val project: Project) {

    companion object {
        fun getInstance(project: Project): ValkyriePackageManager {
            return project.getService(ValkyriePackageManager::class.java)
        }
    }

    private val workspaceParser = ValkyrieWorkspaceParser()
    private val projectParser = ValkyrieProjectParser()
    
    // 缓存已解析的包信息
    private val packageCache = ConcurrentHashMap<VirtualFile, ValkyrieProject?>()
    private val workspaceCache = ConcurrentHashMap<VirtualFile, ValkyrieWorkspace?>()
    
    // 包名到包目录的映射
    private val packageNameToDir = ConcurrentHashMap<String, VirtualFile>()
    
    // 依赖解析缓存
    private val dependencyResolutionCache = ConcurrentHashMap<String, ValkyriePackageDependency>()

    /**
     * 解析工作空间的依赖关系
     */
    fun resolveWorkspaceDependencies(workspace: ValkyrieWorkspace): Map<String, ValkyriePackageDependency> {
        val dependencies = workspace.packageDependencies.toMutableMap()
        
        // 为每个依赖解析包信息
        for ((name, dep) in dependencies) {
            val resolvedDep = resolveDependency(dep, workspace)
            dependencies[name] = resolvedDep
        }
        
        return dependencies
    }

    /**
     * 解析单个依赖
     */
    fun resolveDependency(dependency: ValkyriePackageDependency, workspace: ValkyrieWorkspace): ValkyriePackageDependency {
        // 检查缓存
        val cacheKey = "${dependency.name}@${dependency.version}"
        dependencyResolutionCache[cacheKey]?.let { return it }
        
        val resolved = when (val source = dependency.source) {
            is DependencySource.Local -> {
                // 本地路径依赖
                val packageDir = LocalFileSystem.getInstance().findFileByPath(source.path)
                if (packageDir != null) {
                    val valkyrieProject = parsePackageInfo(packageDir)
                    val packageInfo = valkyrieProject?.packageInfo
                    dependency.copy(packageInfo = packageInfo, packageDir = packageDir)
                } else {
                    dependency
                }
            }
            is DependencySource.External -> {
                // 外部依赖 - 从环境变量或全局包目录查找
                resolveExternalDependency(dependency)
            }
            is DependencySource.Git -> {
                // Git 依赖 - 暂不实现，返回原依赖
                dependency
            }
        }
        
        dependencyResolutionCache[cacheKey] = resolved
        return resolved
    }

    /**
     * 解析外部依赖
     */
    private fun resolveExternalDependency(dependency: ValkyriePackageDependency): ValkyriePackageDependency {
        // 从环境变量 VALKYRIE_HOME 查找
        val valkyrieHome = System.getenv("VALKYRIE_HOME")
        if (valkyrieHome != null) {
            val packagesRoot = LocalFileSystem.getInstance().findFileByPath("$valkyrieHome/packages")
            if (packagesRoot != null) {
                // 在 packages 目录下查找匹配的包
                val packageDir = findPackageByName(packagesRoot, dependency.name)
                if (packageDir != null) {
                    val valkyrieProject = parsePackageInfo(packageDir)
                    val packageInfo = valkyrieProject?.packageInfo
                    return dependency.copy(packageInfo = packageInfo, packageDir = packageDir)
                }
            }
        }
        
        return dependency
    }

    /**
     * 在指定目录下根据包名查找包目录
     */
    private fun findPackageByName(root: VirtualFile, packageName: String): VirtualFile? {
        return ReadAction.compute<VirtualFile?, RuntimeException> {
            for (child in root.children) {
                if (child.isDirectory) {
                    val legionJson = child.findChild(ValkyrieProjectParser.LEGION_JSON)
                    if (legionJson != null) {
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
     * 解析包信息
     */
    private fun parsePackageInfo(packageDir: VirtualFile): ValkyrieProject? {
        return packageCache.computeIfAbsent(packageDir) { dir ->
            try {
                projectParser.parseProject(project, dir)
            } catch (e: Exception) {
                null
            }
        }
    }

    /**
     * 根据包名或别名查找包目录
     */
    fun findPackageDirectory(nameOrAlias: String, workspace: ValkyrieWorkspace): VirtualFile? {
        // 先尝试作为别名解析
        val realName = workspace.resolveAlias(nameOrAlias) ?: nameOrAlias
        
        // 在工作空间的包中查找
        workspace.findPackage(realName)?.let { return it }
        
        // 在缓存的包名映射中查找
        packageNameToDir[realName]?.let { return it }
        
        // 在外部依赖中查找
        val dependency = workspace.packageDependencies[realName]
        if (dependency != null) {
            val resolved = resolveDependency(dependency, workspace)
            return resolved.packageDir
        }
        
        return null
    }

    /**
     * 获取包的命名空间
     */
    fun getPackageNamespace(packageName: String, workspace: ValkyrieWorkspace): String? {
        val packageDir = findPackageDirectory(packageName, workspace) ?: return null
        val projectInfo = parsePackageInfo(packageDir) ?: return null
        
        return projectInfo.packageInfo.getEffectiveNamespace()
    }

    /**
     * 检查包是否导出指定模块
     */
    fun isModuleExported(packageName: String, module: String, workspace: ValkyrieWorkspace): Boolean {
        val packageDir = findPackageDirectory(packageName, workspace) ?: return false
        val projectInfo = parsePackageInfo(packageDir) ?: return false
        
        return projectInfo.packageInfo.isExported(module)
    }

    /**
     * 解析完整的符号路径
     * 支持：package::symbol 或 package::module::symbol
     */
    fun resolveSymbolPath(qualifiedPath: String, currentWorkspace: ValkyrieWorkspace): SymbolResolutionResult? {
        val parts = qualifiedPath.split("::")
        if (parts.size < 2) return null
        
        val packageName = parts[0]
        val remainingPath = parts.drop(1)
        
        // 查找包目录
        val packageDir = findPackageDirectory(packageName, currentWorkspace) ?: return null
        
        // 解析包信息
        val projectInfo = parsePackageInfo(packageDir) ?: return null
        
        // 构建完整的命名空间
        val baseNamespace = projectInfo.packageInfo.getEffectiveNamespace()
        val fullNamespace = if (remainingPath.size > 1) {
            "$baseNamespace.${remainingPath.dropLast(1).joinToString(".")}"
        } else {
            baseNamespace
        }
        
        val symbolName = remainingPath.last()
        
        return SymbolResolutionResult(
            packageName = packageName,
            packageDir = packageDir,
            namespace = fullNamespace,
            symbolName = symbolName,
            packageInfo = projectInfo.packageInfo
        )
    }

    /**
     * 验证工作空间配置
     */
    fun validateWorkspace(workspace: ValkyrieWorkspace): List<String> {
        val errors = mutableListOf<String>()
        
        // 使用验证器进行详细验证
        val validator = ValkyrieConfigValidator
        val validationErrors = validator.validateLegionsConfig(workspace, workspace.root)
        errors.addAll(validationErrors)
        
        // 检查循环依赖
        if (workspace.hasCircularDependency()) {
            errors.add("工作空间存在循环依赖")
        }
        
        // 检查所有依赖是否可解析
        for ((name, dep) in workspace.packageDependencies) {
            val resolved = resolveDependency(dep, workspace)
            if (resolved.packageDir == null) {
                errors.add("无法解析依赖: $name")
            }
            
            // 验证依赖配置
            val depErrors = validator.validateDependency(dep)
            errors.addAll(depErrors.map { "依赖 '$name': $it" })
        }
        
        // 检查包别名冲突
        val aliasCounts = workspace.packageAliases.keys.groupingBy { it }.eachCount()
        for ((alias, count) in aliasCounts) {
            if (count > 1) {
                errors.add("包别名冲突: $alias")
            }
        }
        
        return errors
    }

    /**
     * 刷新包缓存
     */
    fun refreshPackageCache(packageDir: VirtualFile) {
        packageCache.remove(packageDir)
        packageNameToDir.values.removeIf { it == packageDir }
    }

    /**
     * 清空所有缓存
     */
    fun clearCache() {
        packageCache.clear()
        workspaceCache.clear()
        packageNameToDir.clear()
        dependencyResolutionCache.clear()
    }
}

/**
 * 符号解析结果
 */
data class SymbolResolutionResult(
    val packageName: String,
    val packageDir: VirtualFile,
    val namespace: String,
    val symbolName: String,
    val packageInfo: ValkyriePackageInfo
)