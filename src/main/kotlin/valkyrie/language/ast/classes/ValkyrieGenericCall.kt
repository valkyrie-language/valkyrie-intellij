package valkyrie.language.ast.classes

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.formatter.ValkyrieRewriter
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.psi.ValkyrieRewritableElement

// must = must use `::`
class ValkyrieGenericCall(node: CompositeElement, must: Boolean) : ASTWrapperPsiElement(node), ValkyrieRewritableElement {
    private val _identifier by lazy { ValkyrieIdentifierNode.find(this) }
//    override fun getBaseIcon(): Icon {
//        return ValkyrieIconProvider.Instance.CLASS
//    }

//    override fun getPresentation(): ItemPresentation {
//        return IdentifierPresentation(_identifier, this.baseIcon)
//    }

    override fun on_rewrite(e: ValkyrieRewriter) {
        e.replace_generic(this)
    }
}