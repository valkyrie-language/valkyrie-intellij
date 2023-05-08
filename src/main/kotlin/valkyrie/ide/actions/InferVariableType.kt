package valkyrie.ide.actions

import com.intellij.codeInspection.HintAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.node.ValkyrieDeclareVariable
import valkyrie.psi.node.ValkyrieDeclareVariableNode
import javax.swing.Icon

class InferVariableType : HintAction, Iconable {
    private val element: ValkyrieDeclareVariableNode

    constructor(element: ValkyrieDeclareVariable) {
        this.element = element as ValkyrieDeclareVariableNode
    }

    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getFamilyName(): String {
        return "GetFamilyName"
    }

    override fun isAvailable(project: Project, editor: Editor?, file: PsiFile?): Boolean {
        return true
    }

    override fun invoke(project: Project, editor: Editor?, file: PsiFile?) {

    }

    override fun showHint(editor: Editor): Boolean {
        return true
    }

    override fun getIcon(flags: Int): Icon {
        return ValkyrieIconProvider.Instance.Untyped
    }

    override fun getText(): String {
        return ValkyrieBundle.message("action.infer.variable")
    }
}