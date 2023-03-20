package valkyrie.language.ast.calls

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.language.antlr.childrenWithLeaves
import valkyrie.language.ast.ValkyrieNamepathNode
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieAttributeItem(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    override fun on_highlight(e: NodeHighlighter) {
        val id = this.findChildByClass(ValkyrieNamepathNode::class.java) ?: return;
        for (node in id.childrenWithLeaves) {
            e.register_macro(node)
        }
    }
}

