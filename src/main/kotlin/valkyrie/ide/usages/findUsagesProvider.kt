package valkyrie.ide.usages

import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement

class findUsagesProvider : FindUsagesProvider {
    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return false
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return null
    }

    override fun getType(element: PsiElement): String {
        return "getType"
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return "getDescriptiveName"
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return "element"
    }
}
