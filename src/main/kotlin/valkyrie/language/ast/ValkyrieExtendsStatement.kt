package valkyrie.language.ast

import com.intellij.icons.AllIcons
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.view.NamepathPresentation
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieExtendsStatement(node: CompositeElement) : ValkyrieScopeNode(node) {
    private val _identifier by lazy { ValkyrieNamepathNode.find(this)!! }

    override fun getName(): String {
        return _identifier.name
    }

    override fun getBaseIcon(): Icon {
        return AllIcons.Nodes.Enum
    }

    override fun getPresentation(): ItemPresentation {
        return NamepathPresentation(_identifier, this.baseIcon)
    }
}