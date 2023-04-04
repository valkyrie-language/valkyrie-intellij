package valkyrie.psi.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieElement
import yggdrasil.psi.node.ValkyrieAttribute
import javax.swing.Icon

abstract class MixinAttribute(node: ASTNode) : ValkyrieElement(node), ValkyrieAttribute {

    override fun getName(): String {
        val ids = this.namepath?.identifierList ?: listOf()
        return ids.lastOrNull()?.text ?: ""
    }

    override fun highlight(visitor: NodeHighlighter) {
        visitor.highlight(this.firstChild, HighlightColor.SYM_MACRO)
        val ids = this.namepath?.identifierList ?: listOf()
        for (id in ids) {
            visitor.highlight(id, HighlightColor.SYM_MACRO)
        }
    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Attribute
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }
}

