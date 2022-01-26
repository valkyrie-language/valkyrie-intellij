package valkyrie.ide.view.hierarchy

import com.intellij.ide.hierarchy.HierarchyNodeDescriptor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement

class HierarchyLeaf : HierarchyNodeDescriptor {
    constructor(project: Project, element: PsiElement) : super(project, null, element, true)
    constructor(parent: HierarchyNode) : this(parent.project, parent.node) {

    }
}