package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration

import valkyrie.psi.node.ValkyrieMatchStatement
import javax.swing.Icon

abstract class MixinMatchStatement(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieMatchStatement {
    override val color: HighlightColor
        get() {
            for (modifier in matchBind?.modifierList ?: emptyList()) {
                if (modifier.text == "mut") {
                    return HighlightColor.SYM_LOCAL_MUT
                }
            }
            return HighlightColor.SYM_LOCAL
        }

    override fun getNameIdentifier(): MixinIdentifier? {
        return this.matchBind?.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}