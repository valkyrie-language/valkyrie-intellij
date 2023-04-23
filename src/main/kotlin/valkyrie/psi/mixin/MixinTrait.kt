package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclareElement
import valkyrie.psi.node.ValkyrieDeclareTrait
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon


abstract class MixinTrait(node: ASTNode) : ValkyrieDeclareElement(node), ValkyrieDeclareTrait {
    val traitItems = classBody?.classItemList?.map { it.firstChild } ?: listOf();
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Trait
    }
}


