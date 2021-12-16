package valkyrie.language.mixin

import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.ast.addChildrenView
import valkyrie.language.psi_node.ValkyrieDefineItemNode
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.util.PsiTreeUtil
import javax.swing.Icon

open class MixinDefineItem(node: ASTNode) : ValkyrieASTBase(node), PsiNameIdentifierOwner {
    override fun getOriginalElement(): ValkyrieDefineItemNode {
        return this as ValkyrieDefineItemNode
    }

    override fun getNameIdentifier(): PsiElement? {
        val id = originalElement.identifier;
        return when {
            id == null -> null
            id.text == "self" -> null
            else -> id
        }
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getTextOffset(): Int = when (val id = originalElement.identifier) {
        null -> super.getTextOffset()
        else -> id.textOffset
    }

    override fun getIcon(flags: Int): Icon = AllIcons.Nodes.Parameter
    override fun getName(): String? {
        return originalElement.identifier?.text ?: this.text
    }
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    fun hasMutable(): Boolean {
        return false
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, null, getIcon(0), null)
    }

}

