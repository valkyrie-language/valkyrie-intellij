package valkyrie.language.ast

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.antlr.register
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieNewStatement(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    val identifier by lazy { ValkyrieModifiedNode.findIdentifier(this) };
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };
    override fun on_highlight(e: HighlightInfoHolder) {
        e.register(identifier, ValkyrieHighlightColor.SYM_CLASS)
        for (mod in modifiers) {
            e.register(mod, ValkyrieHighlightColor.MODIFIER)
        }
    }


}


