package valkyrie.project.workspace

import com.intellij.openapi.vfs.VirtualFile

/**
 * Valkyrie Workspace 数据类
 */
data class ValkyrieWorkspace(
    val root: VirtualFile,
    val name: String,
    val isPrivate: Boolean,
    val scripts: Map<String, String>,
    val packages: List<VirtualFile>
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
}