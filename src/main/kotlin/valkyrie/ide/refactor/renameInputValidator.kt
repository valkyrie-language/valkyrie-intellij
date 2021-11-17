package valkyrie.ide.refactor

import com.intellij.patterns.ElementPattern
import com.intellij.psi.PsiElement
import com.intellij.refactoring.rename.RenameInputValidator
import com.intellij.util.ProcessingContext

class renameInputValidator : RenameInputValidator {
    override fun getPattern(): ElementPattern<out PsiElement> {
        TODO("Not yet implemented")
    }

    override fun isInputValid(newName: String, element: PsiElement, context: ProcessingContext): Boolean {
        TODO("Not yet implemented")
    }
}