package valkyrie.language.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ViewableNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi_node.ValkyrieModifiersNode
import javax.swing.Icon

open class MixinModifier(node: ASTNode) : ViewableNode(node) {
    override fun getOriginalElement(): ValkyrieModifiersNode {
        return this as ValkyrieModifiersNode
    }
    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.MODIFIER
    override fun getNavigationElement(): PsiElement = this
    fun hasMutable(): Boolean {
        for (i in originalElement.children) {
            if (i.text == "mutable" || i.text == "mut") {
                return true
            }
        }
        return false
    }

    override fun getPresentation(): PresentationData {
        return PresentationData("[MODIFIERS]", "", this.getIcon(0), null)
    }

}

