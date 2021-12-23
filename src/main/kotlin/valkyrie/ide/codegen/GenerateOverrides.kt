package valkyrie.ide.codegen

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.lang.LanguageCodeInsightActionHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.ast.ValkyrieClassDeclaration
import valkyrie.language.ast.ValkyrieExtendsStatementNode
import valkyrie.language.ast.ValkyrieUnionStatementNode
import valkyrie.language.psi.caretElement


class GenerateOverrides : LanguageCodeInsightActionHandler {
    override fun isValidFor(editor: Editor?, file: PsiFile?) = when (file.caretElement(editor)?.context) {
        is ValkyrieClassDeclaration -> true
        is ValkyrieUnionStatementNode -> true
        is ValkyrieExtendsStatementNode -> true
        else -> false
    }

    override fun invoke(project: Project, editor: Editor, file: PsiFile) {
        println("ValkyrieOverrideMark.invoke($editor, $file)")
    }


    override fun getElementToMakeWritable(currentFile: PsiFile): PsiElement? {
        return super.getElementToMakeWritable(currentFile)
    }
}