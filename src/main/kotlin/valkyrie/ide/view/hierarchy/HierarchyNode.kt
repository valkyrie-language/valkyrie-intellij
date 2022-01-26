package valkyrie.ide.view.hierarchy

import com.intellij.ide.hierarchy.HierarchyNodeDescriptor
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import valkyrie.language.ast.ValkyrieClassStatement

class HierarchyNode : HierarchyNodeDescriptor {
    val node: PsiElement

    constructor(project: Project, node: ValkyrieClassStatement) : super(project, null, node, true) {
        this.node = node
    }

}


