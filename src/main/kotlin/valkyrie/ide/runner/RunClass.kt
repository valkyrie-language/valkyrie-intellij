package valkyrie.ide.runner

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import valkyrie.language.ValkyrieBundle


class RunClass(val classPath: List<String>, private val full: Boolean) : AnAction() {
    init {
        if (full) {
            templatePresentation.text = ValkyrieBundle.message("action.run.class.full.name")
            templatePresentation.description = ValkyrieBundle.message("action.run.class.full.help")
        } else {
            templatePresentation.text = ValkyrieBundle.message("action.run.class.part.name")
            templatePresentation.description = ValkyrieBundle.message("action.run.class.part.help")
        }
        templatePresentation.icon = AllIcons.RunConfigurations.TestState.Run_run
    }

    override fun actionPerformed(e: AnActionEvent) {

    }

    override fun displayTextInToolbar(): Boolean {
        return true
    }

    override fun getTemplateText(): String? {
        return "RunFile.getTemplateText"
    }
}