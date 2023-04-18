package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclareElement
import valkyrie.psi.node.ValkyrieDeclareFlags
import valkyrie.psi.node.ValkyrieEnumerateItem
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinFlags(node: ASTNode) : ValkyrieDeclareElement(node), ValkyrieDeclareFlags {
    val flagItems = enumerateBody?.enumerateItemList?.map { it.firstChild } ?: listOf();

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Flags
    }


    fun flagItems(): List<ValkyrieEnumerateItem> {
        return this.enumerateBody?.enumerateItemList ?: listOf()
    }
}