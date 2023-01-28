package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.language.psi.ValkyrieRewritableElement
import valkyrie.ide.formatter.ValkyrieRewriter

class ValkyrieGenericStatement(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieRewritableElement {
    override fun rewrite(w: ValkyrieRewriter) {
        w.rewriteGeneric(this)
    }

}