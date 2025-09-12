package valkyrie.reference

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import valkyrie.psi.nodes.ValkyrieIdentifierNode
import valkyrie.index.ValkyrieSymbolIndex

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
        
        val symbolName = sourceElement.name ?: return null
        val currentFile = sourceElement.containingFile.virtualFile ?: return null
        val project = sourceElement.project
        
        // 使用符号索引查找所有定义
        val symbolIndex = ValkyrieSymbolIndex.getInstance(project)
        val allDefinitions = symbolIndex.findAllSymbolDefinitions(symbolName, currentFile)
        
        val targets = mutableListOf<PsiElement>()
        
        for (symbolInfo in allDefinitions) {
            // 跳过内置类型（它们没有对应的 PSI 元素）
            if (symbolInfo.namespace == "builtin" || symbolInfo.element == null) {
                continue
            }
            targets.add(symbolInfo.element!!)
        }
        
        // 如果没有找到符号索引中的定义，回退到引用解析机制
        if (targets.isEmpty()) {
            val references = sourceElement.references
            for (reference in references) {
                val resolved = reference.resolve()
                if (resolved != null) {
                    targets.add(resolved)
                }
            }
        }
        
        return if (targets.isNotEmpty()) targets.toTypedArray() else null
    }
}