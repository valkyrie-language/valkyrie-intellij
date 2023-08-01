package valkyrie.psi.mixin

import com.intellij.application.options.editor.GutterIconsConfigurable
import com.intellij.execution.console.GutterContentProvider
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieTypeExpression
import javax.swing.Icon

abstract class MixinTypeExpression(node: ASTNode) : ValkyrieElement(node), ValkyrieTypeExpression {
    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Type
    }

}
