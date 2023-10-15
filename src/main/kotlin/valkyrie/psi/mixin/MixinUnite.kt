package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieIdentifierNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes.KW_UNITE
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareUnite
import javax.swing.Icon

abstract class MixinUnite(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareUnite {
    override fun getKeyword(): PsiElement {
        return findKeyword(KW_UNITE)
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifierSafe as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.AbstractClass
    }
}



