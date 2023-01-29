package valkyrie.language.ast.calls

import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.formatter.ValkyrieRewriter
import valkyrie.ide.view.IdentifierPresentation
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieRewritableElement
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

// must = must use `::`
class ValkyrieCallGeneric(node: CompositeElement, must: Boolean) : ValkyrieScopeNode(node), ValkyrieRewritableElement {
    private val _identifier by lazy { ValkyrieIdentifierNode.find(this) }
    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.CLASS
    }

    override fun getPresentation(): ItemPresentation {
        return IdentifierPresentation(_identifier, this.baseIcon)
    }

    override fun on_rewrite(e: ValkyrieRewriter) {
        e.rewriteGeneric(this)
    }
}