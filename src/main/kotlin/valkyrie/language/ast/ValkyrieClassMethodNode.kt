package valkyrie.language.ast

import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon


class ValkyrieClassMethodNode(node: CompositeElement) : ValkyrieScopeNode(node), PsiNameIdentifierOwner {
    val method by lazy { ValkyrieModifiedNode.findIdentifier(this)!! }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };
    override fun getName(): String {
        return method.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }


    override fun getBaseIcon(): Icon {
        if (method.name == "constructor") {
            return AllIcons.Gutter.ImplementingMethod
        }
        for (m in modifiers) {
            if (m.name == "get" || m.name == "set") {
                return AllIcons.Nodes.Property
            }
        }
        return ValkyrieIconProvider.Instance.Method
    }


    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(method, this.baseIcon)
    }

    override fun getNameIdentifier(): PsiElement {
        return method
    }
}