package valkyrie.ide.hierarchy

import com.intellij.ide.hierarchy.HierarchyBrowser
import com.intellij.ide.hierarchy.HierarchyProvider
import com.intellij.ide.hierarchy.TypeHierarchyBrowserBase
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import valkyrie.psi.nodes.ValkyrieClassDeclaration

/**
 * Valkyrie 类型层次结构提供者
 * 支持显示类继承树和重命名继承关系
 */
class ValkyrieTypeHierarchyProvider : HierarchyProvider {
    
    override fun getTarget(dataContext: DataContext): PsiElement? {
        val editor = CommonDataKeys.EDITOR.getData(dataContext)
        val psiFile = CommonDataKeys.PSI_FILE.getData(dataContext)
        
        if (editor == null || psiFile == null) return null
        
        val element = psiFile.findElementAt(editor.caretModel.offset)
        return element?.let { PsiTreeUtil.getParentOfType(it, ValkyrieClassDeclaration::class.java) }
    }
    
    override fun createHierarchyBrowser(target: PsiElement): HierarchyBrowser {
        return ValkyrieTypeHierarchyBrowser(target.project, target as ValkyrieClassDeclaration)
    }
    
    override fun browserActivated(hierarchyBrowser: HierarchyBrowser) {
        // 激活浏览器时的处理
    }
}