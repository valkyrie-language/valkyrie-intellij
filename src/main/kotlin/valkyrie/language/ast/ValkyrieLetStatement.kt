package valkyrie.language.ast

import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import valkyrie.language.psi.ValkyrieHighlightElement
import javax.swing.Icon

class ValkyrieLetStatement(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieHighlightElement {
    override fun getBaseIcon(): Icon {
        return AllIcons.Actions.InlayRenameInNoCodeFilesActive
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("let", null, this.baseIcon, null)
    }

    override fun on_highlight(e: HighlightInfoHolder) {

    }
}


