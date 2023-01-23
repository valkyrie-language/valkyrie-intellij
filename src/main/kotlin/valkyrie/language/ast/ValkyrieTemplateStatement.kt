package valkyrie.language.ast

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieTemplateStatement(node: CompositeElement) : ValkyrieScopeNode(node) {
    private val _identifiers by lazy { PsiTreeUtil.getChildrenOfType(this, ValkyrieIdentifierNode::class.java) }
    override fun getBaseIcon(): Icon {
        return AllIcons.Actions.InlayRenameInNoCodeFilesActive
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("generic", null, this.baseIcon, null)
    }
}