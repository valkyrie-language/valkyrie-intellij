package valkyrie.psi.mixin

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieAttribute

abstract class MixinAttribute(node: ASTNode) : ValkyrieElement(node), ValkyrieAttribute {

    override fun getName(): String {
        return ""
    }

    override fun highlight(visitor: NodeHighlighter) {
        visitor.highlight(this.firstChild, HighlightColor.SYM_MACRO)
        val ids = this.namepath?.identifierList ?: listOf()
        for (id in ids) {
            visitor.highlight(id, HighlightColor.SYM_MACRO)
        }
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData("@${name}", "", AllIcons.Nodes.Annotationtype, null)
    }
}

