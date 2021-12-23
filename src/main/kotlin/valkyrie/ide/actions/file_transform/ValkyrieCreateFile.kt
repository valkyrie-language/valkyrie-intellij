package valkyrie.ide.actions.file_transform

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog.Builder
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider

class ValkyrieCreateFile :
    CreateFileFromTemplateAction(name, description, ValkyrieIconProvider.Valkyrie) {
    companion object {
        private val name = ValkyrieBundle.message("action.create_file")
        private val description = ValkyrieBundle.message("action.create_file.description")
        // See [resources/colors/fileTemplate]
        private const val templatePath = "Valkyrie File";
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: Builder) {
        builder.setTitle(name).addKind("Empty file", ValkyrieIconProvider.Valkyrie, templatePath)
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = name
}
