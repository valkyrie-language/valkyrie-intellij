package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareFlags
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinFlags(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareFlags {

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Flags
    }
}