package valkyrie.ide.runner

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.testIntegration.TestCreator
import valkyrie.language.file.ValkyrieFileNode

class CreateTests : TestCreator {
    override fun isAvailable(project: Project?, editor: Editor?, file: PsiFile?): Boolean {
        if (file !is ValkyrieFileNode || editor == null) {
            return false
        }
        return true
    }

    override fun createTest(project: Project?, editor: Editor?, file: PsiFile?) {
        if (file !is ValkyrieFileNode || editor == null) {
            return
        }


    }
}