package valkyrie.ide.runner

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnActionEvent


class RunClassItem(id: String) : ValkyrieAction(id, AllIcons.RunConfigurations.TestState.Run) {
    override fun actionPerformed(e: AnActionEvent) {

    }

    override fun displayTextInToolbar(): Boolean {
        return true
    }

    override fun getTemplateText(): String? {
        return "RunFile.getTemplateText"
    }
}