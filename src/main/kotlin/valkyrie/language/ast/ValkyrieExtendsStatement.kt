package valkyrie.language.ast

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.view.NamepathPresentation
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieExtendsStatement(node: CompositeElement) : ValkyrieScopeNode(node) {
    private val _identifier by lazy { ValkyrieNamepathNode.find(this)!! }

    override fun getName(): String {
        return _identifier.name
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.TRAIT
    }

    override fun getPresentation(): ItemPresentation {
        return NamepathPresentation(_identifier, getIcon(0))
    }




}