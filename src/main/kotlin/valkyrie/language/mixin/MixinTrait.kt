package valkyrie.language.mixin

import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.language.ast.DeclareNode
import valkyrie.language.psi_node.ValkyrieIdentifierNode
import valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.StubBasedPsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.psi.ValkyrieContext
import javax.swing.Icon


open class MixinTrait(node: ASTNode) : DeclareNode(node), ValkyrieContext {
    override fun getOriginalElement(): ValkyrieTraitStatementNode {
        return this as ValkyrieTraitStatementNode
    }
    override fun getNameIdentifier() = originalElement.identifier
    override fun getIcon(flags: Int): Icon = ValkyrieIconProvider.TRAIT

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getChildrenView(): Array<ValkyrieViewElement> {
        val childrenView: MutableList<ValkyrieViewElement> = mutableListOf()
        originalElement.modifiers.forEach {
            childrenView.add(ValkyrieViewElement(it, it.text, ValkyrieIconProvider.MODIFIER))
        }
        PsiTreeUtil.getChildrenOfTypeAsList(originalElement.classBlock, NavigatablePsiElement::class.java).forEach {
            childrenView.add(ValkyrieViewElement(it))
        }
        return childrenView.toTypedArray()
    }

    fun getViewName(): String {
        val name = originalElement
        val ty = originalElement.typeExpression;
        return when {
            ty != null -> "${name}: ${ty.text}"
            else -> name.text
        }
    }
}

