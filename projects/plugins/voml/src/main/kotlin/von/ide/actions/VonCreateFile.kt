package von.ide.actions

import von.ide.icons.VonIcons
import voml.language.VomlBundle
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

class VonCreateFile : CreateFileFromTemplateAction(NAME, "Create new Von file", VonIcons.FILE) {
    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder
            .setTitle(NAME)
            .addKind("Empty file", VonIcons.FILE, "Von File")
    }

    override fun getActionName(directory: PsiDirectory, newName: String, templateName: String): String = NAME

    companion object {
        private val NAME = VomlBundle.message("filetype.von.create")
    }
}
