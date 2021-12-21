package valkyrie.ide.codegen

import com.intellij.lang.LanguageCodeInsightActionHandler
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.actionSystem.Presentation
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import valkyrie.language.ast.ValkyrieClassDeclaration
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.language.psi.caretElement
import valkyrie.language.psi.valkyrieContext

import valkyrie.language.psi_node.ValkyrieExtendsStatementNode
import valkyrie.language.psi_node.ValkyrieUnionStatementNode
import javax.swing.Icon

class GenerateDelegates : LanguageCodeInsightActionHandler, ItemPresentation {
    override fun isValidFor(editor: Editor?, file: PsiFile?) = when (file.caretElement(editor).valkyrieContext()) {
//        is ValkyrieClassDeclaration -> true
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
        return ValkyrieIconProvider.FIELD
    }


}