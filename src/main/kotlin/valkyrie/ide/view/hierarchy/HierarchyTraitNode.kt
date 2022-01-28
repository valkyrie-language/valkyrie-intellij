package valkyrie.ide.view.hierarchy

import com.intellij.ide.hierarchy.HierarchyNodeDescriptor
import com.intellij.ide.util.treeView.NodeDescriptor
import valkyrie.language.ast.ValkyrieTraitStatement

class HierarchyTraitNode : HierarchyNodeDescriptor {
    val node: ValkyrieTraitStatement

    constructor(node: ValkyrieTraitStatement) : super(node.project, null, node, false) {
        this.node = node
    }

    override fun getParentDescriptor(): NodeDescriptor<*> {
        return this
    }


    override fun toString(): String {
        return node.name
    }
}


