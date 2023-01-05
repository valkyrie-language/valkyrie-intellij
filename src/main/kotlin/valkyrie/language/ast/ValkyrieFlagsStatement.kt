package valkyrie.language.ast

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.tree.IElementType
import valkyrie.ide.view.NamepathPresentation
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieFlagsStatement(node: CompositeElement, type: IElementType) : ValkyrieScopeNode(node), PsiNameIdentifierOwner {
    private val _identifier: ValkyrieNamepathNode = findChildByClass(ValkyrieNamepathNode::class.java)!!;

    override fun getName(): String {
        return _identifier.name
    }

    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): ValkyrieNamepathNode {
        return _identifier
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.CLASS
    }

    override fun getPresentation(): ItemPresentation {
        return NamepathPresentation(_identifier, this.getIcon(0))
    }


}

