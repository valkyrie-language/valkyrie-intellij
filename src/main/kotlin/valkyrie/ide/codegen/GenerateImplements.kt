package valkyrie.ide.codegen

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.generation.actions.PresentableLanguageCodeInsightActionHandler
import com.intellij.openapi.actionSystem.Presentation
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import valkyrie.ast.node.ValkyrieClassNode
import valkyrie.ast.node.ValkyrieDeclareImplyNode
import valkyrie.ast.node.ValkyrieTraitNode
import valkyrie.psi.caretElement


class GenerateImplements : PresentableLanguageCodeInsightActionHandler {
    override fun isValidFor(editor: Editor?, file: PsiFile?) = when (file.caretElement(editor)?.context) {
        is ValkyrieClassNode -> true
        is ValkyrieTraitNode -> true
        is ValkyrieDeclareImplyNode -> true
        else -> false
    }

    override fun invoke(project: Project, editor: Editor, file: PsiFile) {
        println("ValkyrieImplementMark.invoke($editor, $file)")
    }

    override fun update(editor: Editor, file: PsiFile, presentation: Presentation?) {

    }


}