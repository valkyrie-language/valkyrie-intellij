package valkyrie.ide.runner

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent

class RunFile : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {

    }

    override fun displayTextInToolbar(): Boolean {
        return true
    }

    override fun getTemplateText(): String? {
        return "RunFile.getTemplateText"
    }
}