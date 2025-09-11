package valkyrie.ide.hierarchy

import com.intellij.ide.hierarchy.HierarchyNodeDescriptor
import com.intellij.ide.hierarchy.HierarchyTreeStructure
import com.intellij.ide.hierarchy.TypeHierarchyBrowserBase
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.searches.ReferencesSearch
import valkyrie.psi.nodes.ValkyrieClassDeclaration

/**
 * Valkyrie 类型层次结构浏览器
 */
class ValkyrieTypeHierarchyBrowser(
    project: Project,
    element: PsiElement
) : TypeHierarchyBrowserBase(project, element) {
    
    override fun createTreeStructure(type: String, psiElement: PsiElement): HierarchyTreeStructure? {
        return when (type) {
            getSupertypesHierarchyType() -> ValkyrieSupertypeHierarchyTreeStructure(myProject, psiElement as ValkyrieClassDeclaration)
            getSubtypesHierarchyType() -> ValkyrieSubtypeHierarchyTreeStructure(myProject, psiElement as ValkyrieClassDeclaration)
            getTypeHierarchyType() -> ValkyrieTypeHierarchyTreeStructure(myProject, psiElement as ValkyrieClassDeclaration)
            else -> null
        }
    }
    
    override fun isApplicableElement(element: PsiElement): Boolean {
        return element is ValkyrieClassDeclaration
    }
    
    override fun getElementFromDescriptor(descriptor: HierarchyNodeDescriptor): PsiElement? {
        return if (descriptor is ValkyrieTypeHierarchyNodeDescriptor) {
            descriptor.psiElement
        } else {
            null
        }
    }
    
    override fun isInterface(psiElement: PsiElement): Boolean {
        // Valkyrie 中可以根据需要定义接口判断逻辑
        return false
    }
    
    override fun canBeDeleted(psiElement: PsiElement): Boolean {
        return true
    }
    
    override fun getQualifiedName(psiElement: PsiElement): String? {
        return if (psiElement is ValkyrieClassDeclaration) {
            psiElement.name
        } else {
            null
        }
    }
}