package valkyrie.ide.view.hierarchy

import com.intellij.ide.hierarchy.HierarchyBrowser
import com.intellij.ide.hierarchy.HierarchyProvider
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.actionSystem.LangDataKeys
import com.intellij.psi.PsiElement

class TypeHierarchyProvider : HierarchyProvider {
    override fun getTarget(dataContext: DataContext): PsiElement? {
        val psi1 = LangDataKeys.PSI_ELEMENT.getData(dataContext)
        val psi2  = LangDataKeys.TARGET_PSI_ELEMENT.getData(dataContext)
        println("getTarget: ($psi1, $psi2)")
        return null
    }

    override fun createHierarchyBrowser(target: PsiElement): HierarchyBrowser {
        TODO("Not yet implemented")
    }

    override fun browserActivated(hierarchyBrowser: HierarchyBrowser) {
        TODO("Not yet implemented")
    }
}