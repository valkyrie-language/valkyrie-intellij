package valkyrie.project.workspace

import com.intellij.openapi.vfs.VirtualFile
import valkyrie.project.ValkyriePackageDependency

/**
 * Valkyrie Workspace 数据类
 * 支持多项目组织和包别名
 */
data class ValkyrieWorkspace(
    val root: VirtualFile,
    val name: String,
    val isPrivate: Boolean,
    val scripts: Map<String, String>,
    val packages: List<VirtualFile>,
    
    // 新增：包依赖映射（名称 -> 依赖配置）
    val packageDependencies: Map<String, ValkyriePackageDependency> = emptyMap(),
    
    // 新增：包别名映射（别名 -> 实际包名）
    val packageAliases: Map<String, String> = emptyMap()
) {

    /**
     * 获取所有包的名称
     */
    fun getPackageNames(): List<String> {
        return packages.map { it.name }
    }

    /**
     * 根据名称查找包
     */
    fun findPackage(name: String): VirtualFile? {
        return packages.find { it.name == name }
    }

    /**
     * 检查是否包含指定的包
     */
    fun containsPackage(packageDir: VirtualFile): Boolean {
        return packages.contains(packageDir)
    }
    
    /**
     * 根据别名查找实际包名
     */
    fun resolveAlias(alias: String): String? {
        return packageAliases[alias]
    }
    
    /**
     * 获取所有包别名
     */
    fun getAllAliases(): Map<String, String> {
        return packageAliases
    }
    
    /**
     * 根据名称或别名查找包目录
     */
    fun findPackageByNameOrAlias(nameOrAlias: String): VirtualFile? {
        // 先尝试作为别名解析
        val realName = packageAliases[nameOrAlias] ?: nameOrAlias
        return findPackage(realName)
    }
    
    /**
     * 获取包的依赖配置
     */
    fun getPackageDependency(packageName: String): ValkyriePackageDependency? {
        return packageDependencies[packageName]
    }
    
    /**
     * 检查是否存在循环依赖
     */
    fun hasCircularDependency(): Boolean {
        val visited = mutableSetOf<String>()
        val recursionStack = mutableSetOf<String>()
        
        fun dfs(packageName: String): Boolean {
            if (recursionStack.contains(packageName)) return true
            if (visited.contains(packageName)) return false
            
            visited.add(packageName)
            recursionStack.add(packageName)
            
            val dependency = packageDependencies[packageName]
            dependency?.packageInfo?.name?.let { depName ->
                if (dfs(depName)) return true
            }
            
            recursionStack.remove(packageName)
            return false
        }
        
        return packageDependencies.keys.any { dfs(it) }
    }
}