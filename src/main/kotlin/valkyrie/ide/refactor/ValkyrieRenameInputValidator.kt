package valkyrie.ide.refactor

import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.refactoring.rename.RenameInputValidator
import com.intellij.util.ProcessingContext
import valkyrie.language.ValkyrieLanguage

class ValkyrieRenameInputValidator : RenameInputValidator {
    override fun getPattern(): ElementPattern<out PsiElement> {
        return PlatformPatterns.psiElement(LeafPsiElement::class.java).withLanguage(ValkyrieLanguage);
    }

    override fun isInputValid(newName: String, element: PsiElement, context: ProcessingContext): Boolean {
        return true;
    }
}