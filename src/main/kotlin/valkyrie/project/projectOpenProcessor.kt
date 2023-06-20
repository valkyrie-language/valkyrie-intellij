package valkyrie.project

import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.projectImport.ProjectOpenProcessor
import javax.swing.Icon

class projectOpenProcessor : ProjectOpenProcessor() {
    override val name: String
        get() = "projectOpenProcessor"

    override fun canOpenProject(file: VirtualFile): Boolean {
        return true
    }

    override fun doOpenProject(virtualFile: VirtualFile, projectToClose: Project?, forceOpenInNewFrame: Boolean): Project? {
        return null
    }

    override fun getIcon(file: VirtualFile): Icon? {
        return super.getIcon(file)
    }

    override fun askConfirmationForOpeningProject(file: VirtualFile, project: Project?): Int {
        return super.askConfirmationForOpeningProject(file, project)
    }


}
