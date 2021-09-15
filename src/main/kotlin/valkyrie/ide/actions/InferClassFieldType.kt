package valkyrie.ide.actions

import com.intellij.codeInspection.HintAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.util.elementType
import valkyrie.language.psi.ValkyrieTypes
import valkyrie.language.psi.childrenWithLeaves
import valkyrie.language.psi_node.ValkyrieClassFieldNode
import valkyrie.language.psi_node.ValkyrieLetStatementNode

class InferClassFieldType(private val element: ValkyrieClassFieldNode) : HintAction {
    override fun startInWriteAction(): Boolean {
        return true
    }

    override fun getText(): String {
        return "Infer class field's type"
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

