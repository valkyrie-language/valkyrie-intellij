package valkyrie.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.ViewableNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi_node.ValkyrieMacroListNode

open class MixinMacroList(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): ValkyrieMacroListNode {
        return this as ValkyrieMacroListNode
    }

    override fun getIcon(flags: Int) = ValkyrieIconProvider.MACRO

    override fun getNavigationElement(): PsiElement {
        return this.firstChild
    }

    override fun addAnnotationView(list: MutableList<ValkyrieViewElement>) {

    }
}



