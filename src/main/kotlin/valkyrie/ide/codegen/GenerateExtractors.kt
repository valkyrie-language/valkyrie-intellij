package valkyrie.ide.codegen

import com.intellij.icons.ExpUiIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import valkyrie.language.ValkyrieBundle

private val name = ValkyrieBundle.message("action.generate.operators.name")
private val description = ValkyrieBundle.message("action.generate.operators.help")


class GenerateExtractors : AnAction(name, description, ExpUiIcons.FileTypes.Patch) {
    override fun actionPerformed(e: AnActionEvent) {

    }
}