package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareNamespace
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinNamespace(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareNamespace {
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.namepathFree?.lastChild as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Namespace
    }
}

