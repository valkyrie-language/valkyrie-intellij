package valkyrie.language.ast.pattern_match

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieMatchCall(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    val bind = ValkyrieIdentifierNode.find(this)
    override fun on_highlight(e: NodeHighlighter) {
        if (bind != null) {
            e.register(bind, ValkyrieHighlightColor.SYM_LOCAL)
        }
    }
}


