package valkyrie.ide.actions.file_transform

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.Builder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import valkyrie.language.YggdrasilBundle
import yggdrasil.language.file.YggdrasilIconProvider

class ValkyrieCreateFile :
    CreateFileFromTemplateAction(name, description, YggdrasilIconProvider.Instance.File) {
    companion object {
        private val name = YggdrasilBundle.message("action.create_file")
        private val description = YggdrasilBundle.message("action.create_file.description")

        // See [resources/colors/fileTemplate]
        private const val templatePath = "Valkyrie File";
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder.setTitle(name).addKind("Empty file", YggdrasilIconProvider.Instance.File, templatePath)
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
