package valkyrie.ide.codegen

import com.intellij.lang.LanguageCodeInsightActionHandler
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.caretElement
import valkyrie.psi.node.ValkyrieDeclareClassNode
import valkyrie.psi.node.ValkyrieDeclareImplyNode
import valkyrie.psi.node.ValkyrieDeclareTraitNode
import javax.swing.Icon

class GenerateDelegates : LanguageCodeInsightActionHandler, ItemPresentation {
    override fun isValidFor(editor: Editor?, file: PsiFile?) = when (file.caretElement(editor)?.context) {
        is ValkyrieDeclareClassNode -> true
        is ValkyrieDeclareTraitNode -> true
        is ValkyrieDeclareImplyNode -> true
        else -> false
    }

    override fun invoke(project: Project, editor: Editor, file: PsiFile) {
        println("ValkyrieDelegateMethods.invoke($editor, $file)")
    }

    override fun getPresentableText(): String {
        return "getPresentableText"
    }

    override fun getIcon(unused: Boolean): Icon {
        return ValkyrieIconProvider.Instance.Namespace
    }
}