package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieNewStatement(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    val identifier by lazy { ValkyrieModifiedNode.findIdentifier(this) };
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) };

    override fun on_highlight(e: NodeHighlighter) {
        e.register(identifier, ValkyrieHighlightColor.SYM_CLASS)
        e.register_modifiers(modifiers)
    }


}


