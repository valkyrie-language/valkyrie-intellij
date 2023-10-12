package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ast.node.ValkyrieIdentifierNode
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes.KW_NEURAL
import valkyrie.psi.ValkyrieTypes.KW_SINGLETON
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareComponent

import javax.swing.Icon

abstract class MixinNeural(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareComponent {
    override fun getKeyword(): PsiElement {
        return findKeyword(KW_NEURAL)
    }
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifierSafe as? ValkyrieIdentifierNode
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Function
    }
}

