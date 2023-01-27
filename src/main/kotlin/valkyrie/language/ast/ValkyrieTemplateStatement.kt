package valkyrie.language.ast

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieTemplateStatement(node: CompositeElement) : ValkyrieScopeNode(node) {
    val parameters by lazy { ValkyrieIdentifierNode.findMany(this) }
    val modifiers by lazy { ValkyrieModifiedNode.findModifiers(this) }
    override fun getBaseIcon(): Icon {
        return AllIcons.Actions.InlayRenameInNoCodeFilesActive
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("generic", null, this.baseIcon, null)
    }
}