package valkyrie.language.ast

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon


class ValkyrieClassFieldNode(node: CompositeElement) : ValkyrieScopeNode(node), PsiNameIdentifierOwner {
    val field by lazy { ValkyrieModifiedNode.findIdentifier(this)!! }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };

    override fun getName(): String {
        return field.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return field
    }

    override fun getBaseIcon(): Icon {
       return ValkyrieIconProvider.Instance.Field
    }


    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(field, this.getIcon(0))
    }
}

