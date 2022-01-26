package valkyrie.ide.view.hierarchy

import com.intellij.ide.hierarchy.HierarchyNodeDescriptor
import com.intellij.ide.hierarchy.HierarchyTreeStructure
import com.intellij.openapi.project.Project

class TypeHierarchyTree : HierarchyTreeStructure {
    constructor(project: Project, descriptor: HierarchyNodeDescriptor) : super(project, descriptor) {

    }

    override fun buildChildren(parent: HierarchyNodeDescriptor): Array<Any> {
        if (parent is HierarchyNode) {
            return arrayOf(HierarchyLeaf(parent), parent)
        } else {
            return arrayOf()
        }
    }

    override fun isAlwaysShowPlus(): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: Any): Boolean {
        return false
    }

    override fun formatBaseElementText(): String {
        return super.formatBaseElementText()
    }

}