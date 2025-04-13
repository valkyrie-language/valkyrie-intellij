package valkyrie.ide.hierarchy

import com.intellij.ide.hierarchy.HierarchyNodeDescriptor
import com.intellij.ide.util.treeView.NodeDescriptor
import valkyrie.ast.node.ValkyrieTraitNode

class HierarchyTraitNode : HierarchyNodeDescriptor {
    val node: ValkyrieTraitNode

    constructor(node: ValkyrieTraitNode) : super(node.project, null, node, false) {
        this.node = node
    }

    override fun getParentDescriptor(): NodeDescriptor<*> {
        return this
    }


    override fun toString(): String {
        return node.name ?: ""
    }
}


