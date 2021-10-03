package valkyrie.ide.runner

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.DefaultActionGroup
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon

private val name = ValkyrieBundle.message("action.run.class.group.name");
private val help = ValkyrieBundle.message("action.run.class.group.help");

class RunClassGroup(icon: Icon) : DefaultActionGroup(name, help, icon) {
    override fun actionPerformed(event: AnActionEvent) {

    }
    override fun getChildren(e: AnActionEvent?): Array<AnAction> {
        return arrayOf(RunClassItem("action.run.class.part"), RunClassItem("action.run.class.full"))
    }

    override fun getActionUpdateThread(): ActionUpdateThread {
        return super.getActionUpdateThread()
    }

    override fun update(event: AnActionEvent) {
        val currentProject = event.project
        event.presentation.isEnabledAndVisible = currentProject != null
    }
}
