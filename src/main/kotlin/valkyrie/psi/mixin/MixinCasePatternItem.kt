package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieCasePatternItem
import valkyrie.psi.node.ValkyrieCasePatternTop

import javax.swing.Icon

abstract class MixinCasePatternItem(node: ASTNode) : ValkyrieDeclaration(node) {
    override val color = HighlightColor.SYM_ARG
    override fun getNameIdentifier(): MixinIdentifier? {
        return when (this) {
            is ValkyrieCasePatternItem -> this.identifierSafe as? MixinIdentifier
            is ValkyrieCasePatternTop -> this.identifierSafe as? MixinIdentifier
            else -> null
        }
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}


