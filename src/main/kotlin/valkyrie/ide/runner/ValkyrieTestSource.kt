package valkyrie.ide.runner

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.TestSourcesFilter
import com.intellij.openapi.vfs.VirtualFile
import valkyrie.language.file.ValkyrieFileType

class ValkyrieTestSource : TestSourcesFilter() {
    override fun isTestSource(file: VirtualFile, project: Project): Boolean {
        println("file: $file")
        println("project: $project")
        TODO("Not yet implemented")
    }
}