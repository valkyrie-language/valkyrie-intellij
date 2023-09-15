package valkyrie.ide.reference.declaration

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import valkyrie.psi.ValkyrieTypes

class ValkyrieGotoDeclarationHandler : GotoDeclarationHandler {
    override fun getGotoDeclarationTargets(sourceElement: PsiElement?, offset: Int, editor: Editor?): Array<PsiElement> {
        return when (sourceElement?.elementType) {
            ValkyrieTypes.SYMBOL, ValkyrieTypes.SYMBOL_RAW -> {
                arrayOf()
            }

            else -> {
                arrayOf()
            }
        }
    }

    override fun getActionText(context: DataContext): String? {
        return super.getActionText(context)
    }
}
