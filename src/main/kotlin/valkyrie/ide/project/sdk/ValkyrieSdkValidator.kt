package valkyrie.ide.project.sdk

import com.intellij.codeInsight.daemon.ProjectSdkSetupValidator
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ProjectRootManager
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiFile
import com.intellij.ui.EditorNotificationPanel
import com.intellij.ui.EditorNotificationPanel.ActionHandler
import valkyrie.language.file.ValkyrieFileType
import javax.swing.event.HyperlinkEvent

class ValkyrieSdkValidator : ProjectSdkSetupValidator {
    override fun isApplicableFor(project: Project, file: VirtualFile): Boolean {
        return file.fileType is ValkyrieFileType
    }

    override fun getErrorMessage(project: Project, file: VirtualFile): String? {
        val sdk = ProjectRootManager.getInstance(project).projectSdk;
        if (sdk != null) {
            return "Missing Valkyrie SDK"
        }
        return "Invalid Valkyrie SDK"
    }

    override fun getFixHandler(project: Project, file: VirtualFile): ActionHandler {
        return SdkFixer(project, file)
    }
}

private class SdkFixer(val project: Project, val file: VirtualFile) : ActionHandler {
    override fun handlePanelActionClick(panel: EditorNotificationPanel, event: HyperlinkEvent) {

    }

    override fun handleQuickFixClick(editor: Editor, psiFile: PsiFile) {

    }
}