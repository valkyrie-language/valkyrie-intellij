package valkyrie.ide.navigation

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
//import valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider
import valkyrie.language.ValkyrieLanguage
import valkyrie.language.ast.ValkyrieExtendsStatement
import valkyrie.language.psi.ValkyrieContext
import javax.swing.Action
import javax.swing.Icon

class ValkyrieBreadcrumbsProvider : BreadcrumbsProvider {
    override fun getLanguages(): Array<Language> {
        return arrayOf(ValkyrieLanguage)
    }

    override fun acceptElement(element: PsiElement): Boolean {
        return element is ValkyrieContext
    }

    override fun getElementInfo(element: PsiElement): String {
        return when (element) {
//            is DeclareNode -> element.name
            is ValkyrieExtendsStatement -> "${element.name}"
            else -> "unknown ${element.elementType}"
        }
    }

    override fun getChildren(element: PsiElement): MutableList<PsiElement> {
        return super.getChildren(element)
    }

    override fun getParent(element: PsiElement): PsiElement? {
        return super.getParent(element)
    }

    override fun getElementIcon(element: PsiElement): Icon? {
        return when (element) {
//            is ValkyrieASTBase -> element.getIcon(0)
            else -> null
        }
    }

    override fun getContextActions(element: PsiElement): MutableList<out Action> {
        return super.getContextActions(element)
    }

    override fun getElementTooltip(element: PsiElement): String? {
        return super.getElementTooltip(element)
    }

}