package valkyrie.language.ast

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.antlr.register
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieCallArgument(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    val key by lazy { ValkyrieIdentifierNode.find(this) }
    override fun on_highlight(e: HighlightInfoHolder) {
        e.register(key, ValkyrieHighlightColor.SYM_ARG)
    }

}