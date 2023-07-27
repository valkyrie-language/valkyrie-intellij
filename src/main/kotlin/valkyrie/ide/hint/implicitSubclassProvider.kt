package valkyrie.ide.hint

import com.intellij.codeInspection.inheritance.ImplicitSubclassProvider
import com.intellij.psi.PsiClass

class implicitSubclassProvider : ImplicitSubclassProvider() {
    override fun getSubclassingInfo(psiClass: PsiClass): SubclassingInfo? {
        return null
    }

    override fun isApplicableTo(psiClass: PsiClass): Boolean {
        return false
    }
}
