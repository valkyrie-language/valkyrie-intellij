package valkyrie.ide.runner

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages
import valkyrie.language.ValkyrieBundle


class RunFunction : AnAction() {
    private var path: String = "";
    init {
        templatePresentation.text = ValkyrieBundle.message("action.run.class.full.name")
        templatePresentation.description = ValkyrieBundle.message("action.run.class.full.help")
    }
    companion object {
//        fun markTest(element: ValkyrieClassMethodNode): Info? {
//            ModuleManager.getInstance(element.project).modules.forEach {
//                ModuleRootManager.getInstance(it).contentRoots.forEach {
//                    println(it.path)
//                }
//            }
//
//            return null;
//            val runner = RunFunction()
//            runner.path = element.nameIdentifier.name;
//            runner.templatePresentation.icon = AllIcons.RunConfigurations.TestState.Red2
//            return Info(runner)
//        }
//
//        fun markTest(element: ValkyrieDefineStatementNode): Info? {
//            return null
//            val runner = RunFunction()
//            runner.path = element.nameIdentifier.name;
//            runner.templatePresentation.icon = AllIcons.RunConfigurations.TestState.Yellow2
//            return Info(runner)
//        }
    }

    override fun actionPerformed(event: AnActionEvent) {
        val message = StringBuilder(event.presentation.text + " Selected!")
        val selectedElement = event.getData(CommonDataKeys.NAVIGATABLE)
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement)
        }
        Messages.showMessageDialog(
            event.project,
            message.toString(),
            path,
            Messages.getErrorIcon()
        )
    }

    override fun displayTextInToolbar(): Boolean {
        return true
    }

}