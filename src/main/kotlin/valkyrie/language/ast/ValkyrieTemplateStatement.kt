package valkyrie.language.ast

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.antlr.register
import valkyrie.language.psi.ValkyrieHighlightElement
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieTemplateStatement(node: CompositeElement) : ValkyrieScopeNode(node), ValkyrieHighlightElement {
    val parameters by lazy { ValkyrieIdentifierNode.findMany(this) }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) }
    override fun getBaseIcon(): Icon {
        return AllIcons.Actions.InlayRenameInNoCodeFilesActive
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("generic", null, this.baseIcon, null)
    }

    override fun on_highlight(e: HighlightInfoHolder) {
        for (mod in modifiers) {
            e.register(mod, ValkyrieHighlightColor.MODIFIER)
        }
        for (mod in parameters) {
            e.register(mod, ValkyrieHighlightColor.SYM_GENERIC)
        }
    }
}