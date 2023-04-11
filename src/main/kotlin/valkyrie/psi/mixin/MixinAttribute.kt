package valkyrie.psi.mixin

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.ValkyrieElement
import valkyrie.psi.node.ValkyrieAttribute
import valkyrie.psi.node.ValkyrieIdentifier
import javax.swing.Icon

abstract class MixinAttribute(node: ASTNode) : ValkyrieElement(node), ValkyrieAttribute {
    val identifiers: List<ValkyrieIdentifier> = this.namepath?.identifierList ?: listOf()

    override fun getName(): String {
        return identifiers.lastOrNull()?.text ?: ""
    }

    override fun highlight(visitor: NodeHighlighter) {

    }

    override fun getBaseIcon(): Icon {
        return ValkyrieIconProvider.Instance.Attribute
    }

    override fun getPresentation(): ItemPresentation? {
        return PresentationData(name, "", baseIcon, null)
    }
}

