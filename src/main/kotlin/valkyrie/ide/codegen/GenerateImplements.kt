package valkyrie.ide.codegen

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.generation.actions.PresentableLanguageCodeInsightActionHandler
import com.intellij.codeInsight.intention.FileModifier
import com.intellij.openapi.actionSystem.Presentation
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.psi.caretElement
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieDeclareImplyNode
import valkyrie.psi.node.ValkyrieDeclareTraitNode


class GenerateImplements : PresentableLanguageCodeInsightActionHandler {
    override fun isValidFor(editor: Editor?, file: PsiFile?) = when (file.caretElement(editor)?.context) {
        is ValkyrieDeclareClassNode -> true
        is ValkyrieDeclareTraitNode -> true
        is ValkyrieDeclareImplyNode -> true
        else -> false
    }

    override fun invoke(project: Project, editor: Editor, file: PsiFile) {
        println("ValkyrieImplementMark.invoke($editor, $file)")
    }

    override fun update(editor: Editor, file: PsiFile, presentation: Presentation?) {

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