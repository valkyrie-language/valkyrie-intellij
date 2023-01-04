package valkyrie.language.ast

import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import org.jetbrains.annotations.Unmodifiable
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieForStatement(node: CompositeElement) : ValkyrieScopeNode(node) {
    val parameters by lazy { findParameters() };
    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.Operator
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("for", null, getIcon(0), null)
    }




    private fun findParameters(): @Unmodifiable MutableList<ValkyrieForParameter> {
        val pattern = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_for_pattern);
        return PsiTreeUtil.getChildrenOfTypeAsList(pattern, ValkyrieForParameter::class.java);
    }
}

