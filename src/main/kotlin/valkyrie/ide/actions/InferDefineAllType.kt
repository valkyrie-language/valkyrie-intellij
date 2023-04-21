package valkyrie.ide.actions

import com.intellij.codeInspection.HintAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiFile
import valkyrie.language.file.ValkyrieIconProvider
import valkyrie.psi.node.ValkyrieDeclareFunctionNode
//import valkyrie.language.psi_node.ValkyrieDefineItemNode
import javax.swing.Icon

class InferDefineAllType(private val element: ValkyrieDeclareFunctionNode) : HintAction, Iconable {
    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getText(): String {
        return "Infer define parameter's type"
    }

    override fun getFamilyName(): String {
        return "getFamilyName"
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
        return ValkyrieIconProvider.Instance.Namespace
    }
}

