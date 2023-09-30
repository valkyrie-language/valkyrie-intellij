package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.ValkyrieTypes.KW_COMPONENT
import valkyrie.psi.findKeyword
import valkyrie.psi.node.ValkyrieDeclareComponent

import javax.swing.Icon

abstract class MixinComponent(node: ASTNode) : ValkyrieDeclaration(node), ValkyrieDeclareComponent {
    override fun getKeyword(): PsiElement {
        return findKeyword(KW_COMPONENT)
    }
    override fun getNameIdentifier(): MixinIdentifier? {
        return this.identifierSafe as? MixinIdentifier
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Function
    }
}

