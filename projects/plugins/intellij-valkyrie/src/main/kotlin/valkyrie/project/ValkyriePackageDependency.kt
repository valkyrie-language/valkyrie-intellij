package valkyrie.project

import com.intellij.openapi.vfs.VirtualFile

/**
 * 包依赖关系数据类
 * 支持版本约束和别名
 */
data class ValkyriePackageDependency(
    val name: String,                    // 依赖包名（在using语句中使用）
    val version: String,                 // 版本约束
    val source: DependencySource,       // 依赖来源
    val alias: String? = null,          // 可选的别名
    val packageInfo: ValkyriePackageInfo? = null, // 解析后的包信息
    val packageDir: VirtualFile? = null // 包目录路径
) {
    /**
     * 获取实际使用的名称（别名优先）
     */
    fun getEffectiveName(): String {
        return alias ?: name
    }
    
    /**
     * 检查是否为本地依赖
     */
    fun isLocal(): Boolean {
        return source is DependencySource.Local
    }
    
    /**
     * 检查是否为外部依赖
     */
    fun isExternal(): Boolean {
        return source is DependencySource.External
    }
}

/**
 * 依赖来源
 */
sealed class DependencySource {
    /**
     * 本地路径依赖
     */
    data class Local(val path: String) : DependencySource()
    
    /**
     * 外部注册表依赖
     */
    data class External(val registry: String = "default") : DependencySource()
    
    /**
     * Git 依赖
     */
    data class Git(val url: String, val branch: String? = null, val tag: String? = null) : DependencySource()
}