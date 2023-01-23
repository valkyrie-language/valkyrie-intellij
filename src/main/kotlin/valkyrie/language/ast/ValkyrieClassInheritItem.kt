package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.view.IdentifierPresentation
import javax.swing.Icon

class ValkyrieClassInheritItem(node: CompositeElement) : ASTWrapperPsiElement(node) {
    val inherit by lazy { ValkyrieModifiedNode.findIdentifier(this)!! }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };


    public override fun getBaseIcon(): Icon {
        return AllIcons.Gutter.OverridingMethod
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(inherit, this.baseIcon)
    }
}