package valkyrie.ide.refactor

import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.refactoring.rename.RenameHandler
import valkyrie.psi.nodes.ValkyrieIdentifierNode

/**
 * Valkyrie 重命名处理器
 * 处理变量、函数、类等标识符的重命名操作
 */
class ValkyrieRenameHandler : RenameHandler {
    
    override fun isAvailableOnDataContext(dataContext: com.intellij.openapi.actionSystem.DataContext): Boolean {
        return true
    }
    
    override fun isRenaming(dataContext: com.intellij.openapi.actionSystem.DataContext): Boolean {
        val element = com.intellij.openapi.actionSystem.CommonDataKeys.PSI_ELEMENT.getData(dataContext)
        return element is ValkyrieIdentifierNode
    }
    
    override fun invoke(project: com.intellij.openapi.project.Project, editor: Editor?, file: PsiFile?, dataContext: com.intellij.openapi.actionSystem.DataContext) {
        val element = com.intellij.openapi.actionSystem.CommonDataKeys.PSI_ELEMENT.getData(dataContext)
        if (element is ValkyrieIdentifierNode) {
            val renameProcessor = com.intellij.refactoring.rename.RenameProcessor(project, element, "", false, false)
            renameProcessor.run()
        }
    }
    
    override fun invoke(project: com.intellij.openapi.project.Project, elements: Array<out PsiElement>, dataContext: com.intellij.openapi.actionSystem.DataContext) {
        if (elements.isNotEmpty() && elements[0] is ValkyrieIdentifierNode) {
            val renameProcessor = com.intellij.refactoring.rename.RenameProcessor(project, elements[0], "", false, false)
            renameProcessor.run()
        }
    }
}