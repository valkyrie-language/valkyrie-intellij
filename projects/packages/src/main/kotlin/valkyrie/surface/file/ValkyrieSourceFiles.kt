package valkyrie.surface.file

import com.intellij.openapi.vfs.VirtualFile

object ValkyrieSourceFiles {
    val EXTENSIONS: Set<String> = setOf("v", "vk", "valkyrie")

    fun isSourceFile(file: VirtualFile): Boolean = file.extension in EXTENSIONS
}
