package valkyrie.language.mixin

import valkyrie.ide.reference.ValkyrieReference
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.ast.ViewableNode
import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi_node.ValkyrieMacroListNode
import valkyrie.language.psi_node.ValkyrieTermNode
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import javax.swing.Icon

open class MixinMacroList(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): ValkyrieMacroListNode {
        return this as ValkyrieMacroListNode
    }

    override fun getIcon(flags: Int): Icon {
        TODO("Not yet implemented")
    }

    override fun getNavigationElement(): PsiElement {
        return this.firstChild
    }

    override fun addAnnotationView(list: MutableList<ValkyrieViewElement>) {

    }
}



