package valkyrie.ide.project.`package`

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.projectImport.ProjectOpenProcessor

class OpenProject : ProjectOpenProcessor() {
    override val name: String
        get() = "OpenProject.name"

    override fun canOpenProject(file: VirtualFile): Boolean {
        TODO("Not yet implemented")
    }

    override fun doOpenProject(virtualFile: VirtualFile, projectToClose: Project?, forceOpenInNewFrame: Boolean): Project? {
        TODO("Not yet implemented")
    }
}