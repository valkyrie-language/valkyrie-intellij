package valkyrie.semantic.resolve

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import valkyrie.surface.psi.nodes.ValkyrieIdentifierNode

/**
 * Goto declaration for Valkyrie identifiers via the unified resolver.
 */
class ValkyrieGotoDeclarationHandler : GotoDeclarationHandler {

    override fun getGotoDeclarationTargets(
        sourceElement: PsiElement?,
        offset: Int,
        editor: Editor?,
    ): Array<PsiElement>? {
        if (sourceElement !is ValkyrieIdentifierNode) {
            return null
        }
        if (!ValkyrieReferenceContext.isResolvableUsage(sourceElement)) {
            return null
        }

        val resolved = ValkyrieSymbolResolver.resolve(sourceElement) ?: return null
        return arrayOf(resolved)
    }
}
