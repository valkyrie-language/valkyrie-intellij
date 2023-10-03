package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElement
import javax.swing.Icon

abstract class MixinTermExpression(node: ASTNode) : ValkyrieElement(node) {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Console
    }
}