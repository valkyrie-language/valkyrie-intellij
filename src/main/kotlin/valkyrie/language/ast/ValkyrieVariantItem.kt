package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieVariantItem(node: CompositeElement) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner, ValkyrieScopeNode {
    private val _identifier by lazy { ValkyrieIdentifierNode.find(this)!! }
    override fun getName(): String {
        return _identifier.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return _identifier
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.VARIANT
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(_identifier, this.getIcon(0))
    }

    override fun getContext(): ScopeNode? {
        TODO("Not yet implemented")
    }



}