package valkyrie.ide.runner

import com.intellij.execution.lineMarker.RunLineMarkerContributor.Info
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.ActionGroup
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.psi.PsiElement
import valkyrie.language.ValkyrieBundle
import valkyrie.language.ast.ValkyrieClassDeclaration
//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import valkyrie.language.psi_node.ValkyrieExtendsStatementNode


class RunClassGroup : ActionGroup() {
    private val name: String = ""

    init {
        templatePresentation.isPopupGroup = false
        templatePresentation.icon = AllIcons.RunConfigurations.TestState.Run_run
        templatePresentation.text = ValkyrieBundle.message("action.run.class.group.name")
        templatePresentation.description = ValkyrieBundle.message("action.run.class.group.help")
    }

    companion object {
        fun markClass(element: PsiElement): Info? {
            if (element !is ValkyrieClassDeclaration) return null;
            return Info(RunClass(listOf("element"), false))
        }

        fun markExtends(element: PsiElement): Info? {
            if (element !is ValkyrieExtendsStatementNode) return null;
            return Info(RunClassGroup())
        }
    }

    override fun actionPerformed(event: AnActionEvent) {

    }

    override fun getChildren(e: AnActionEvent?): Array<AnAction> {
        return arrayOf(RunClass(listOf(name), true), RunClass(listOf(name), false))
    }
}
