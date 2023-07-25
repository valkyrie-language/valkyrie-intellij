package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes.KW_UNITE
import valkyrie.psi.node.ValkyrieDeclareUnite
import valkyrie.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon

abstract class MixinUnite(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareUnite {
    val keyword: PsiElement = findKeyword(KW_UNITE)
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifier as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.AbstractClass
    }
}



