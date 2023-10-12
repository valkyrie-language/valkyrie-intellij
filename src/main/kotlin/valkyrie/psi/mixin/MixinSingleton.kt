package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieIdentifierNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes.KW_SINGLETON
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareComponent
import javax.swing.Icon

abstract class MixinSingleton(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareComponent {
    override fun getKeyword(): PsiElement {
        return findKeyword(KW_SINGLETON)
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifierSafe as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Singleton
    }
}