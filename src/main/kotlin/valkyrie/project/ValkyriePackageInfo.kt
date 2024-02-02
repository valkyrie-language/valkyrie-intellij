package valkyrie.project

/**
 * 包信息数据类
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
    val publish: Boolean
)