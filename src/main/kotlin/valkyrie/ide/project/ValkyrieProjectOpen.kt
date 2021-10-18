package valkyrie.ide.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.projectImport.ProjectOpenProcessor

class ValkyrieProjectOpen : ProjectOpenProcessor() {
    override val name: String get() = TODO("Not yet implemented")

    override fun canOpenProject(file: VirtualFile): Boolean {
        TODO("Not yet implemented")
    }

    override fun doOpenProject(virtualFile: VirtualFile, projectToClose: Project?, forceOpenInNewFrame: Boolean): Project? {
        TODO("Not yet implemented")
    }
}