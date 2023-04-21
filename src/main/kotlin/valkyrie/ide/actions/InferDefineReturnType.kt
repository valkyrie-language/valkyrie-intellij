package valkyrie.ide.actions

//import valkyrie.language.psi_node.ValkyrieDefineItemNode
import com.intellij.codeInspection.HintAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Iconable
import com.intellij.psi.PsiFile
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieIconProvider
import javax.swing.Icon

/// Add or fix return type
class InferDefineReturnType(private val element: ValkyrieFileNode) : HintAction, Iconable {
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
        return ValkyrieIconProvider.Instance.File
    }
}

