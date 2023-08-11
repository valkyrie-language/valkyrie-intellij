package valkyrie.psi.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes.KW_SINGLETON
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareComponent
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinSingleton(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareComponent {
    val keyword: PsiElement = findKeyword(KW_SINGLETON)
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Singleton
    }
}