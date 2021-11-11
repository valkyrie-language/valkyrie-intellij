package valkyrie.ide.runner

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.testIntegration.TestCreator

class CreateTests : TestCreator {
    override fun isAvailable(project: Project?, editor: Editor?, file: PsiFile?): Boolean {
        TODO("Not yet implemented")
    }

    override fun createTest(project: Project?, editor: Editor?, file: PsiFile?) {
        TODO("Not yet implemented")
    }
}