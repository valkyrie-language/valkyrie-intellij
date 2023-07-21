package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieCasePatternRoot
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinCasePatternRoot(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieCasePatternRoot {
    override val color = HighlightColor.SYM_ARG

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Field
    }
}