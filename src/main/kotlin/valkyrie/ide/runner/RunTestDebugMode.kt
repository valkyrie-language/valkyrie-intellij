package valkyrie.ide.runner

import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.ui.Messages
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle

class RunTestDebugMode : AnAction {
    val element: PsiElement
    private var path: String = "";

    constructor(element: PsiElement) : super() {
        this.element = element
        templatePresentation.icon = AllIcons.Run.Restart
        templatePresentation.text = ValkyrieBundle.message("action.run.class.full.name")
        templatePresentation.description = ValkyrieBundle.message("action.run.class.full.help")
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

    override fun update(e: AnActionEvent) {
        super.update(e)
    }
}