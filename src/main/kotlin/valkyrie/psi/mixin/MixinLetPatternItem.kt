package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieIdentifierNode
import valkyrie.psi.node.ValkyrieLetPatternItem
import javax.swing.Icon

abstract class MixinLetPatternItem(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieLetPatternItem {

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}

fun ValkyrieLetPatternItem.getHighlightColor(): HighlightColor {
    for (modifier in this.modifierList) {
        if (modifier.text == "mut") {
            return HighlightColor.SYM_LOCAL_MUT
        }
    }
    return HighlightColor.SYM_LOCAL
}