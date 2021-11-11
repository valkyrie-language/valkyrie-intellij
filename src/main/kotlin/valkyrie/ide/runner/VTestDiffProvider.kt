package valkyrie.ide.runner

import com.intellij.execution.testframework.actions.TestDiffProvider
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement

class VTestDiffProvider : TestDiffProvider {
    override fun findExpected(project: Project, stackTrace: String): PsiElement? {
        TODO("Not yet implemented")
    }
}