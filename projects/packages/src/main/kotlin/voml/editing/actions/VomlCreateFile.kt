package voml.editing.actions

import voml.editing.icons.VomlIcons
import voml.surface.file.VomlBundle
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class VomlCreateFile : CreateFileFromTemplateAction(NAME, "Create new Voml file", VomlIcons.FILE) {
    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder
            .setTitle(NAME)
            .addKind("Empty file", VomlIcons.FILE, "Voml File")
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = NAME

    companion object {
        private val NAME = VomlBundle.message("filetype.voml.create")
    }
}
