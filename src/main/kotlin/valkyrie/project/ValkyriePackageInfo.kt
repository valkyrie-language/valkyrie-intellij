package valkyrie.project

/**
 * 包信息数据类
 * 支持命名空间和模块导出配置
 */
data class ValkyriePackageInfo(
    val name: String,
    val version: String,
    val description: String?,
    val authors: List<String>,
    val repository: String?,
    val documentation: String?,
    val edition: String?,
    val license: String?,
    val readme: String?,
    val publish: Boolean,
    
    // 新增字段：包的命名空间（用于符号解析）
    val namespace: String? = null,
    
    // 新增字段：导出的模块列表
    val exports: List<String> = emptyList(),
    
    // 新增字段：包的别名（用于工作空间中的重命名）
    val alias: String? = null
) {
    /**
     * 获取实际的命名空间，如果未指定则使用包名
     */
    fun getEffectiveNamespace(): String {
        return namespace ?: name.replace("-", "_")
    }
    
    /**
     * 检查指定模块是否被导出
     */
    fun isExported(module: String): Boolean {
        return exports.isEmpty() || exports.contains(module)
    }
    
    /**
     * 获取包的完整限定名（包含版本）
     */
    fun getFullName(): String {
        return "$name@$version"
    }
}