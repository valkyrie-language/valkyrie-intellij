package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieGroup
import yggdrasil.psi.node.ValkyrieGroupItemNode
import yggdrasil.psi.node.ValkyrieIdentifierNode
import javax.swing.Icon


abstract class MixinGroup(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    PsiNameIdentifierOwner,
    ValkyrieGroup {


    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return this.identifierFree as? ValkyrieIdentifierNode
    }

    override fun getName(): String? {
        return nameIdentifier?.name ?: "⟪anonymous⟫"
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }


    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.ModuleGroup
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }

    override fun getTokenList(): MutableList<ValkyrieGroupItemNode> {
        if (groupBody == null) {
            return mutableListOf()
        }
        val items = mutableListOf<ValkyrieGroupItemNode>()
        for (item in groupBody!!.groupTermList) {
            val inner = item.groupItem as? ValkyrieGroupItemNode;
            if (inner != null) {
                items.add(inner)
            }
        }
        return items;
    }

}

