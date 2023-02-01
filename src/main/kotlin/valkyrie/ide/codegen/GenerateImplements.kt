package valkyrie.ide.codegen

//import valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.intellij.codeInsight.intention.FileModifier
import com.intellij.lang.LanguageCodeInsightActionHandler
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.language.ast.classes.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieExtendsStatement
import valkyrie.language.ast.unions.ValkyrieUnionStatement
import valkyrie.language.antlr.caretElement


class GenerateImplements : LanguageCodeInsightActionHandler {
    override fun isValidFor(editor: Editor?, file: PsiFile?) = when (file.caretElement(editor)?.context) {
        is ValkyrieClassStatement -> true
        is ValkyrieUnionStatement -> true
        is ValkyrieExtendsStatement -> true
        else -> false
    }
    override fun invoke(project: Project, editor: Editor, file: PsiFile) {
        println("ValkyrieImplementMark.invoke($editor, $file)")
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