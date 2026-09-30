package awsl.editing.actions

import awsl.editing.structure.AwslIconProvider
import awsl.surface.file.AwslBundle
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.Builder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class AwslCreateFile :
    CreateFileFromTemplateAction(
        { AwslBundle.message("action.create_file") },
        { AwslBundle.message("action.create_file.description") },
        AwslIconProvider.AwslFile,
    ) {
    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder
            .setTitle(AwslBundle.message("action.create_file"))
            .addKind("Empty file", AwslIconProvider.AwslFile, "Awsl File")
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String =
        AwslBundle.message("action.create_file")
}
