package valkyrie.ide.codegen

import com.intellij.lang.LanguageCodeInsightActionHandler
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import valkyrie.language.ast.ValkyrieClassStatement
import valkyrie.language.ast.ValkyrieExtendsStatementNode
import valkyrie.language.ast.ValkyrieUnionStatementNode
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.caretElement

import javax.swing.Icon

class GenerateDelegates : LanguageCodeInsightActionHandler, ItemPresentation {
    override fun isValidFor(editor: Editor?, file: PsiFile?) = when (file.caretElement(editor)?.context) {
        is ValkyrieClassStatement -> true
        is ValkyrieUnionStatementNode -> true
        is ValkyrieExtendsStatementNode -> true
        else -> false
    }

    override fun invoke(project: Project, editor: Editor, file: PsiFile) {
        println("ValkyrieDelegateMethods.invoke($editor, $file)")
    }

    override fun getPresentableText(): String? {
        return "getPresentableText"
    }

    override fun getIcon(unused: Boolean): Icon? {
        return ValkyrieIconProvider.Instance.FIELD
    }


}