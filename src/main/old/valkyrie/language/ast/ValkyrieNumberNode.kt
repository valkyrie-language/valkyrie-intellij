package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.util.PsiTreeUtil
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.psi.ValkyrieHighlightElement

class ValkyrieNumberNode(node: ASTNode) : ANTLRPsiNode(node), ValkyrieHighlightElement {
    val handler by lazy {
        PsiTreeUtil.getChildOfType(this, ValkyrieIdentifierNode::class.java)
    }

    override fun on_highlight(e: NodeHighlighter) {
        e.register(handler, ValkyrieHighlightColor.SYM_MACRO)
    }
}