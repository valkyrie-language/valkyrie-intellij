package valkyrie.ide.project.sdk

import com.intellij.codeInsight.daemon.ProjectSdkSetupValidator
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.ui.EditorNotificationPanel
import valkyrie.language.file.ValkyrieFileType

class ValkyrieSdkValidator : ProjectSdkSetupValidator {
    override fun isApplicableFor(project: Project, file: VirtualFile): Boolean {
        //        return file.getPsiFile(project).fileType is ValkyrieFileType
        return file.fileType is ValkyrieFileType
    }

    override fun getErrorMessage(project: Project, file: VirtualFile): String? {
        return "Invalid Valkyrie SDK"
    }

    override fun getFixHandler(project: Project, file: VirtualFile): EditorNotificationPanel.ActionHandler {
        return super.getFixHandler(project, file)
    }
}