package valkyrie.language.ast

import com.intellij.icons.AllIcons
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import org.jetbrains.annotations.Unmodifiable
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieForStatement(node: CompositeElement) : ValkyrieScopeNode(node) {
    val parameters by lazy { findParameters() };

    override fun getBaseIcon(): Icon {
        return AllIcons.Actions.InlayRenameInNoCodeFilesActive
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("for", null, this.baseIcon, null)
    }

    private fun findParameters(): @Unmodifiable MutableList<ValkyrieLetParameter> {
        val pattern = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_for_pattern);
        return PsiTreeUtil.getChildrenOfTypeAsList(pattern, ValkyrieLetParameter::class.java);
    }
}
