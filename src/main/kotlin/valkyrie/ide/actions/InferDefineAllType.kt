package valkyrie.ide.actions

import com.intellij.codeInspection.HintAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import valkyrie.language.psi_node.ValkyrieClassFieldNode
import valkyrie.language.psi_node.ValkyrieDefineItemNode

class InferDefineAllType(private val element: ValkyrieDefineItemNode) : HintAction {
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
}

