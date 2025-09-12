package valkyrie.project

import com.intellij.openapi.vfs.VirtualFile
import valkyrie.project.workspace.ValkyrieWorkspace

/**
 * Valkyrie 文件上下文信息
 */
data class ValkyrieFileContext(
    val file: VirtualFile,
    val workspace: ValkyrieWorkspace?,
    val project: ValkyrieProject?,
    val isInWorkspace: Boolean,
    val isInProject: Boolean
) {

    /**
     * 获取相对于项目根的路径
     */
    fun getRelativePathToProject(): String? {
        val projectRoot = project?.root ?: return null
        return file.path.removePrefix(projectRoot.path).removePrefix("/")
    }

    /**
     * 获取相对于 workspace 根的路径
     */
    fun getRelativePathToWorkspace(): String? {
        val workspaceRoot = workspace?.root ?: return null
        return file.path.removePrefix(workspaceRoot.path).removePrefix("/")
    }
}