package valkyrie.ide.runner

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import valkyrie.language.ValkyrieBundle

class RunClassGroup : ActionGroup() {
    private val name: String = ""

    init {
        templatePresentation.isPopupGroup = false
        templatePresentation.icon = AllIcons.RunConfigurations.TestState.Run_run
        templatePresentation.text = ValkyrieBundle.message("action.run.class.group.name")
        templatePresentation.description = ValkyrieBundle.message("action.run.class.group.help")
    }

    override fun actionPerformed(event: AnActionEvent) {

    }

    override fun getChildren(e: AnActionEvent?): Array<AnAction> {
        return arrayOf(RunClass(listOf(name), true), RunClass(listOf(name), false))
    }
}