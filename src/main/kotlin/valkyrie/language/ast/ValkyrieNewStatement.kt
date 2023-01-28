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
    override fun highlight(info: HighlightInfoHolder) {
        info.register(identifier, ValkyrieHighlightColor.SYM_CLASS)
        for (mod in modifiers) {
            info.register(mod, ValkyrieHighlightColor.MODIFIER)
        }
    }


}