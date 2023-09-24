package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieDeclareTests
import javax.swing.Icon

abstract class MixinDeclareTests(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareTests {
    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierFree?.lastChild as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Namespace
    }
}