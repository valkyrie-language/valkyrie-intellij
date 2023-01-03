package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.ide.projectView.PresentationData
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.impl.source.tree.CompositeElement
import com.intellij.psi.util.PsiTreeUtil
import org.antlr.intellij.adaptor.psi.ScopeNode
import org.jetbrains.annotations.Unmodifiable
import valkyrie.language.antlr.ValkyrieAntlrParser
import valkyrie.language.antlr.ValkyrieParser
import valkyrie.language.antlr.parentScope
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.ValkyrieScopeNode
import javax.swing.Icon

class ValkyrieForStatement(node: CompositeElement) : ASTWrapperPsiElement(node), ValkyrieScopeNode {
    val parameters by lazy { findParameters() };
    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.Operator
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData("for", null, getIcon(0), null)
    }

    override fun getContext(): ScopeNode? {
        return parentScope
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

    private fun findParameters(): @Unmodifiable MutableList<ValkyrieForParameter> {
        val pattern = ValkyrieParser.getChildOfType(this, ValkyrieAntlrParser.RULE_for_pattern);
        return PsiTreeUtil.getChildrenOfTypeAsList(pattern, ValkyrieForParameter::class.java);
    }
}

