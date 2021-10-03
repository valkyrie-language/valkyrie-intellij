package valkyrie.ide.runner

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import valkyrie.language.ValkyrieBundle
import javax.swing.Icon

open class ValkyrieAction(val id: String, val icon: Icon) :
    AnAction(ValkyrieBundle.message("$id.name"), ValkyrieBundle.message("$id.help"), icon) {
    override fun actionPerformed(e: AnActionEvent) {

    }
}