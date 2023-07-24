package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.ide.highlight.HighlightColor
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieIdentifierNode
import valkyrie.psi.node.ValkyrieTraitAlias
import javax.swing.Icon

abstract class MixinTraitAlias(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieTraitAlias {
    override val color: HighlightColor = HighlightColor.SYM_TRAIT
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getName(): String {
        return nameIdentifier?.name ?: "⟪anonymous alias⟫"
    }


    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Trait
    }

}