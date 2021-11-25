package valkyrie.ide.navigation

import com.intellij.lang.Language
import com.intellij.psi.PsiElement
import com.intellij.ui.breadcrumbs.BreadcrumbsProvider
import valkyrie.language.ValkyrieLanguage

class breadcrumbsInfoProvider : BreadcrumbsProvider {
    override fun getLanguages(): Array<Language> {
       return arrayOf(ValkyrieLanguage)
    }

    override fun acceptElement(element: PsiElement): Boolean {
        TODO("Not yet implemented")
    }

    override fun getElementInfo(element: PsiElement): String {
        TODO("Not yet implemented")
    }
}