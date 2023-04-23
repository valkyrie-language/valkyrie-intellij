package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclareElement
import valkyrie.psi.node.ValkyrieIdentifierNode
import valkyrie.psi.node.ValkyrieTraitAlias
import javax.swing.Icon

abstract class MixinTraitAlias(node: ASTNode) : ValkyrieDeclareElement(node), ValkyrieTraitAlias {

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getName(): String {
        return nameIdentifier?.name ?: "⟪anonymous trait⟫"
    }


    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Trait
    }

}