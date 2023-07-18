package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDotMatchCall
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinMatchCall(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDotMatchCall {
    override val color: HighlightColor
        get() {
            for (modifier in this.modifierList) {
                if (modifier.text == "mut") {
                    return HighlightColor.SYM_LOCAL_MUT
                }
            }
            return HighlightColor.SYM_LOCAL
        }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}