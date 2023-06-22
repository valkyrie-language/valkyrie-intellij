package valkyrie.project.facet

import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.GeneratedSourcesFilter
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiElement

class generatedSourcesFilter : GeneratedSourcesFilter() {
    override fun isGeneratedSource(file: VirtualFile, project: Project): Boolean {
        return false
    }

    override fun getOriginalElements(element: PsiElement): MutableList<out PsiElement> {
        return super.getOriginalElements(element)
    }

    override fun getNotificationText(file: VirtualFile, project: Project): String? {
        return super.getNotificationText(file, project)
    }
}
