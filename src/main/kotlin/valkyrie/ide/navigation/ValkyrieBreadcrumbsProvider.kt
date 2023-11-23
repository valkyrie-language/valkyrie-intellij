package valkyrie.ide.navigation

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
//import valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.lang.Language
import com.intellij.navigation.NavigationItem
import com.intellij.psi.PsiElement
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider
import valkyrie.ast.node.ValkyrieLoopInfinityNode
import valkyrie.language.ValkyrieLanguage
import valkyrie.psi.ValkyrieDeclaration
import javax.swing.Icon

class ValkyrieBreadcrumbsProvider : BreadcrumbsProvider {
    override fun getLanguages(): Array<Language> {
        return arrayOf(ValkyrieLanguage)
    }

    override fun acceptElement(element: PsiElement) = when (element) {
        is ValkyrieDeclaration -> {
            true
        }

        is ValkyrieLoopInfinityNode,
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
        } else if (element is ValkyrieLoopInfinityNode) {
            "for-loop"
        } else {
            "[Unknown]"
        }
    }

    override fun getElementIcon(element: PsiElement): Icon? {
        return element.getIcon(0)
    }

}