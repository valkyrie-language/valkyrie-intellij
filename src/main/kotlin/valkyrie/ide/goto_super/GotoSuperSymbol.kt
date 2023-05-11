package valkyrie.ide.goto_super

import com.intellij.codeInsight.navigation.GotoTargetHandler
import com.intellij.codeInsight.navigation.GotoTargetHandler.GotoData
import com.intellij.codeInsight.navigation.actions.GotoSuperAction
import com.intellij.openapi.editor.Editor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import valkyrie.psi.ValkyrieDeclareElement
import valkyrie.psi.node.ValkyrieVisitor

class GotoSuperSymbol : GotoTargetHandler() {
    override fun getFeatureUsedKey() = GotoSuperAction.FEATURE_ID
    override fun getSourceAndTargetElements(editor: Editor, file: PsiFile): GotoData? {
        val element = ValkyrieDeclareElement.getCaretDeclaration(editor, file)
        println("getSourceAndTargetElements: ${element}")
        val visitor = GotoSuperVisitor()
        element?.accept(visitor)
        return visitor.target
    }

    override fun getChooserTitle(sourceElement: PsiElement, name: String?, length: Int, finished: Boolean) = "GetChooserTitle"

    override fun getNotFoundMessage(project: Project, editor: Editor, file: PsiFile) = "GetNotFoundMessage"

}


private class GotoSuperVisitor : ValkyrieVisitor() {
    val target: GotoData? = null


}