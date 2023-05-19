package valkyrie.ide.lint

import com.intellij.ide.actions.QualifiedNameProvider
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement

class ValkyrieNameQualifier : QualifiedNameProvider {
    override fun adjustElementToCopy(element: PsiElement): PsiElement? {
        return null
    }

    override fun getQualifiedName(element: PsiElement): String? {
        return null
    }

    override fun qualifiedNameToElement(fqn: String, project: Project): PsiElement? {
        return null
    }
}
