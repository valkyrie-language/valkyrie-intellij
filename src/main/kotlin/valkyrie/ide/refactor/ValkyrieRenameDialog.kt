package valkyrie.ide.refactor

import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.refactoring.rename.RenamePsiElementProcessorBase
import com.intellij.refactoring.rename.RenameRefactoringDialog
import com.intellij.refactoring.rename.RenameRefactoringDialogProvider
import com.intellij.refactoring.rename.RenameWithOptionalReferencesDialog

class ValkyrieRenameDialog : RenameRefactoringDialogProvider() {
    override fun createDialog(
        project: Project,
        element: PsiElement,
        nameSuggestionContext: PsiElement?,
        editor: Editor?,
    ): RenameRefactoringDialog {
        return ValkyrieRenameRefactoringDialog(project, element, nameSuggestionContext, editor)
    }

    override fun isApplicable(processor: RenamePsiElementProcessorBase?): Boolean {
//        print(processor.toString())
        return true
    }
}

private class ValkyrieRenameRefactoringDialog : RenameWithOptionalReferencesDialog {
    private var searchForReferences = false

    constructor(project: Project, psiElement: PsiElement, nameSuggestionContext: PsiElement?, editor: Editor?) : super(
        project,
        psiElement,
        nameSuggestionContext,
        editor
    )

    override fun getSearchForReferences(): Boolean {
        return searchForReferences
    }

    override fun setSearchForReferences(value: Boolean) {
        searchForReferences = value
    }
}

