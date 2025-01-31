package valkyrie.ide.navigation

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
//import valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.lang.Language
import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiElement
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieForStatement
import valkyrie.psi.node.ValkyrieForStatementNode
import valkyrie.psi.node.ValkyrieWhileStatementNode
import javax.swing.Action
import javax.swing.Icon

class ValkyrieBreadcrumbsProvider : BreadcrumbsProvider {
    override fun getLanguages(): Array<Language> {
        return arrayOf(ValkyrieLanguage)
    }

    override fun acceptElement(element: PsiElement) = when (element) {
        is ValkyrieDeclaration -> {
            true
        }

        is ValkyrieWhileStatementNode,
        is ValkyrieForStatementNode,
        -> {
            true
        }

        else -> {
            false
        }
    }

    override fun getElementInfo(element: PsiElement): String {
        return if (element is NavigationItem) {
            element.name ?: "[Missing]"
        } else if (element is ValkyrieForStatement) {
            "for-loop"
        } else {
            "[Unknown]"
        }
    }

    override fun getChildren(element: PsiElement): MutableList<PsiElement> {
        return super.getChildren(element)
    }

    override fun getParent(element: PsiElement): PsiElement? {
        return super.getParent(element)
    }

    override fun getElementIcon(element: PsiElement): Icon? {
        return element.getIcon(0)
    }

    override fun getContextActions(element: PsiElement): MutableList<out Action> {
        return super.getContextActions(element)
    }

    override fun getElementTooltip(element: PsiElement): String? {
        return super.getElementTooltip(element)
    }

}