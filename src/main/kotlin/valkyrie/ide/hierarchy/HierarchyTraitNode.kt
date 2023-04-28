package valkyrie.ide.view.hierarchy

import com.intellij.ide.hierarchy.HierarchyNodeDescriptor
import com.intellij.ide.util.treeView.NodeDescriptor
import valkyrie.psi.node.ValkyrieDeclareTraitNode

class HierarchyTraitNode : HierarchyNodeDescriptor {
    val node: ValkyrieDeclareTraitNode

    constructor(node: ValkyrieDeclareTraitNode) : super(node.project, null, node, false) {
        this.node = node
    }

    override fun getParentDescriptor(): NodeDescriptor<*> {
        return this
    }


    override fun toString(): String {
        return node.name ?: ""
    }
}


