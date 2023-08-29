package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieCasePatternItem
import valkyrie.psi.node.ValkyrieCasePatternTop
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinCasePatternItem(node: ASTNode) : ValkyrieDeclaration(node) {
    override val color = HighlightColor.SYM_ARG
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return when (this) {
            is ValkyrieCasePatternItem -> {
                this.identifier as? ValkyrieIdentifierNode
            }

            is ValkyrieCasePatternTop -> {
                this.identifier as? ValkyrieIdentifierNode
            }

            else -> {
                null
            }
        }

    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}


