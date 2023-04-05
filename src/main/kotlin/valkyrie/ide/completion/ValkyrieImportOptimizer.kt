package valkyrie.ide.completion

import com.intellij.lang.ImportOptimizer
import com.intellij.psi.PsiFile
import valkyrie.language.file.ValkyrieFileNode

class ValkyrieImportOptimizer : ImportOptimizer {
    override fun supports(file: PsiFile): Boolean {
        return file is ValkyrieFileNode
    }

    override fun processFile(file: PsiFile): Runnable {
        return Runnable { }
    }
}