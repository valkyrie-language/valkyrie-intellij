package valkyrie.project

import com.intellij.openapi.vfs.VirtualFile

/**
 * 入口点数据类
 */
data class ValkyrieEntryPoints(
    val library: VirtualFile?,
    val binaries: List<VirtualFile>
)