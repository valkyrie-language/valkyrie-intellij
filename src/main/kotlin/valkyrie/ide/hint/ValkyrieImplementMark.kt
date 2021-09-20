package valkyrie.ide.hint

import com.intellij.codeInsight.generation.actions.PresentableLanguageCodeInsightActionHandler
import com.intellij.codeInsight.intention.FileModifier
import com.intellij.openapi.actionSystem.Presentation
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class ValkyrieImplementMark : PresentableLanguageCodeInsightActionHandler {
    override fun invoke(project: Project, editor: Editor, file: PsiFile) {

    }

    override fun update(editor: Editor, file: PsiFile, presentation: Presentation?) {

    }

    override fun isValidFor(editor: Editor?, file: PsiFile?): Boolean {
        return true
    }

    override fun startInWriteAction(): Boolean {
        return super.startInWriteAction()
    }

    override fun getElementToMakeWritable(currentFile: PsiFile): PsiElement? {
        return super.getElementToMakeWritable(currentFile)
    }

    override fun getFileModifierForPreview(target: PsiFile): FileModifier? {
        return super.getFileModifierForPreview(target)
    }
}