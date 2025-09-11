package valkyrie.ide.hierarchy

import com.intellij.ide.hierarchy.HierarchyNodeDescriptor
import com.intellij.ide.hierarchy.HierarchyTreeStructure
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.util.ArrayUtil
import valkyrie.psi.nodes.ValkyrieClassDeclaration
import valkyrie.index.ValkyrieSymbolIndex

/**
 * Valkyrie 类型层次结构节点描述符
 */
class ValkyrieTypeHierarchyNodeDescriptor(
    project: Project,
    parentDescriptor: HierarchyNodeDescriptor?,
    element: PsiElement,
    private val isBase: Boolean = false
) : HierarchyNodeDescriptor(project, parentDescriptor, element, isBase) {
    
    override fun update(): Boolean {
        val element = psiElement
        if (element is ValkyrieClassDeclaration) {
            val name = element.name ?: "<unnamed>"
            val inheritanceInfo = if (element.hasRenamedInheritance()) {
                val renameMapping = element.getRenameMapping()
                val renameInfo = renameMapping.entries.joinToString(", ") { "${it.key}: ${it.value}" }
                " ($renameInfo)"
            } else {
                ""
            }
            
            myName = "$name$inheritanceInfo"
            myColor = null
            return true
        }
        return false
    }
}

/**
 * 父类层次结构树
 */
class ValkyrieSupertypeHierarchyTreeStructure(
    project: Project,
    private val baseClass: ValkyrieClassDeclaration
) : HierarchyTreeStructure(project, ValkyrieTypeHierarchyNodeDescriptor(project, null, baseClass, true)) {
    
    override fun buildChildren(descriptor: HierarchyNodeDescriptor): Array<Any> {
        val element = descriptor.psiElement
        if (element is ValkyrieClassDeclaration) {
            val parentClasses = findParentClasses(element)
            return parentClasses.map { 
                ValkyrieTypeHierarchyNodeDescriptor(myProject, descriptor, it)
            }.toTypedArray()
        }
        return ArrayUtil.EMPTY_OBJECT_ARRAY
    }
    
    private fun findParentClasses(classDecl: ValkyrieClassDeclaration): List<ValkyrieClassDeclaration> {
        val symbolIndex = ValkyrieSymbolIndex.getInstance(myProject)
        val parentNames = classDecl.getParentClasses()
        return parentNames.mapNotNull { parentName ->
            symbolIndex.findClassByName(parentName)
        }
    }
}

/**
 * 子类层次结构树
 */
class ValkyrieSubtypeHierarchyTreeStructure(
    project: Project,
    private val baseClass: ValkyrieClassDeclaration
) : HierarchyTreeStructure(project, ValkyrieTypeHierarchyNodeDescriptor(project, null, baseClass, true)) {
    
    override fun buildChildren(descriptor: HierarchyNodeDescriptor): Array<Any> {
        val element = descriptor.psiElement
        if (element is ValkyrieClassDeclaration) {
            val childClasses = findChildClasses(element)
            return childClasses.map { 
                ValkyrieTypeHierarchyNodeDescriptor(myProject, descriptor, it)
            }.toTypedArray()
        }
        return ArrayUtil.EMPTY_OBJECT_ARRAY
    }
    
    private fun findChildClasses(classDecl: ValkyrieClassDeclaration): List<ValkyrieClassDeclaration> {
        val symbolIndex = ValkyrieSymbolIndex.getInstance(myProject)
        val className = classDecl.name ?: return emptyList()
        return symbolIndex.findClassesThatInheritFrom(className)
    }
}

/**
 * 完整类型层次结构树
 */
class ValkyrieTypeHierarchyTreeStructure(
    project: Project,
    private val baseClass: ValkyrieClassDeclaration
) : HierarchyTreeStructure(project, ValkyrieTypeHierarchyNodeDescriptor(project, null, baseClass, true)) {
    
    override fun buildChildren(descriptor: HierarchyNodeDescriptor): Array<Any> {
        val element = descriptor.psiElement
        if (element is ValkyrieClassDeclaration) {
            val symbolIndex = ValkyrieSymbolIndex.getInstance(myProject)
            val className = element.name ?: return ArrayUtil.EMPTY_OBJECT_ARRAY
            
            // 获取父类和子类
            val parentClasses = element.getParentClasses().mapNotNull { parentName ->
                symbolIndex.findClassByName(parentName)
            }
            val childClasses = symbolIndex.findClassesThatInheritFrom(className)
            
            val allClasses = (parentClasses + childClasses).distinct()
            return allClasses.map { 
                ValkyrieTypeHierarchyNodeDescriptor(myProject, descriptor, it)
            }.toTypedArray()
        }
        return ArrayUtil.EMPTY_OBJECT_ARRAY
    }
}