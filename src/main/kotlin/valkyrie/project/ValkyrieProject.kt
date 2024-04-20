package valkyrie.project

import com.intellij.openapi.vfs.VirtualFile

/**
 * Valkyrie 项目数据类
 */
data class ValkyrieProject(
    val root: VirtualFile,
    val packageInfo: ValkyriePackageInfo,
    val projectType: String,
    val features: Map<String, List<String>>,
    val dependencies: Map<String, String>,
    val buildDependencies: Map<String, String>,
    val devDependencies: Map<String, String>,
    val entryPoints: ValkyrieEntryPoints
) {

    /**
     * 检查是否为库项目
     */
    fun isLibrary(): Boolean = projectType == "library" || entryPoints.library != null

    /**
     * 检查是否为应用项目
     */
    fun isApplication(): Boolean = projectType == "application" || entryPoints.binaries.isNotEmpty()

    /**
     * 获取所有二进制目标名称
     */
    fun getBinaryNames(): List<String> {
        return entryPoints.binaries.map { binary ->
            when {
                binary.name == ValkyrieProjectParser.Companion.ENTRY_FILE || binary.name == ValkyrieProjectParser.Companion.ENTRY_FILE_ALT ->
                    binary.parent?.name ?: "main"
                binary.name.endsWith(".valkyrie") ->
                    binary.name.removeSuffix(".valkyrie")
                else -> binary.name
            }
        }
    }
}