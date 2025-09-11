package valkyrie.reference

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.ValkyrieIdentifierNode

/**
 * Valkyrie Goto Declaration Handler
 * 处理跳转到定义功能
 */
class ValkyrieGotoDeclarationHandler : GotoDeclarationHandler {
    
    override fun getGotoDeclarationTargets(
        sourceElement: PsiElement?,
        offset: Int,
        editor: Editor?
    ): Array<PsiElement>? {
        if (sourceElement !is ValkyrieIdentifierNode) {
            return null
        }
        
        // 使用现有的引用解析机制
        val references = sourceElement.references
        val targets = mutableListOf<PsiElement>()
        
        for (reference in references) {
            val resolved = reference.resolve()
            if (resolved != null) {
                targets.add(resolved)
            }
        }
        
        return if (targets.isNotEmpty()) targets.toTypedArray() else null
    }
}