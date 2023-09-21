package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieBarePatternItem

import javax.swing.Icon

abstract class MixinLetPatternItem(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieBarePatternItem {
    override val color = HighlightColor.SYM_ARG
    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}