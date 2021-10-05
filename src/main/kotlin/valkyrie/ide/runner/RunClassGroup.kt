package valkyrie.ide.runner

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import valkyrie.language.ValkyrieBundle
import valkyrie.language.psi_node.ValkyrieClassStatementNode


class RunClassGroup(val element: ValkyrieClassStatementNode) : ActionGroup() {
    init {
        templatePresentation.icon = AllIcons.RunConfigurations.TestState.Run_run
        templatePresentation.text = ValkyrieBundle.message("action.run.class.group.name")
        templatePresentation.description = ValkyrieBundle.message("action.run.class.group.help")
    }

    override fun actionPerformed(event: AnActionEvent) {

    }

    override fun getChildren(e: AnActionEvent?): Array<AnAction> {
        return arrayOf(RunClass(element.fullNamepath, true), RunClass(element.fullNamepath, false))
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return super.getActionUpdateThread()
    }

    override fun update(event: AnActionEvent) {
        val currentProject = event.project
        event.presentation.isEnabledAndVisible = currentProject != null
    }
}
