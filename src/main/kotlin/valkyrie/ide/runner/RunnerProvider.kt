package valkyrie.ide.runner

import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class RunnerProvider : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        // Token needs to be determined, very difficult to use
        return null
    }

    override fun getSlowInfo(element: PsiElement): Info? {
        return null
    }

    override fun producesAllPossibleConfigurations(file: PsiFile): Boolean {
        return super.producesAllPossibleConfigurations(file)
    }
}


