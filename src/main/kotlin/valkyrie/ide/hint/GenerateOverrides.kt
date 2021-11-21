package valkyrie.ide.hint

import com.intellij.codeInsight.generation.actions.PresentableLanguageCodeInsightActionHandler
import com.intellij.openapi.actionSystem.Presentation
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.ast.ValkyrieASTBase
import valkyrie.language.psi.caretElement


class GenerateOverrides : PresentableLanguageCodeInsightActionHandler {
    override fun isValidFor(editor: Editor?, file: PsiFile?): Boolean {
        val psi = file.caretElement(editor)
        if (psi is ValkyrieASTBase) {
            println("ValkyrieOverrideMark.isValidFor($psi)")
            return true
        }
        return false
    }

    override fun invoke(project: Project, editor: Editor, file: PsiFile) {
        println("ValkyrieOverrideMark.invoke($editor, $file)")
    }

    override fun update(editor: Editor, file: PsiFile, presentation: Presentation?) {
        println("ValkyrieOverrideMark.invoke($editor, $file, $presentation)")
    }

    override fun getElementToMakeWritable(currentFile: PsiFile): PsiElement? {
        return super.getElementToMakeWritable(currentFile)
    }
}