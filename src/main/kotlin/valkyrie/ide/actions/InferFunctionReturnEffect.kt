package valkyrie.ide.actions

import com.intellij.codeInspection.HintAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiFile
import valkyrie.language.ValkyrieBundle
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.node.ValkyrieDeclareFunction
import valkyrie.psi.node.ValkyrieDeclareFunctionNode
import javax.swing.Icon

class InferFunctionReturnEffect : HintAction, Iconable {
    private val element: ValkyrieDeclareFunctionNode

    constructor(element: ValkyrieDeclareFunction) {
        this.element = element as ValkyrieDeclareFunctionNode
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
        return ValkyrieIconProvider.Instance.Effect
    }

    override fun getText(): String {
        return ValkyrieBundle.message("action.infer.function.return.effect")
    }
}

