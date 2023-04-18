package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclareElement
import valkyrie.psi.node.ValkyrieDeclareEnumerate
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinEnumerate(node: ASTNode) : ValkyrieDeclareElement(node), ValkyrieDeclareEnumerate {
    val enumerateItems = this.enumerateBody?.enumerateItemList?.map { it.firstChild } ?: listOf()

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Enumeration
    }
}

