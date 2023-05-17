package valkyrie.ide.view

import com.intellij.ide.projectView.TreeStructureProvider
import com.intellij.ide.projectView.ViewSettings
import com.intellij.ide.util.treeView.AbstractTreeNode

class ProjectViewModifier : TreeStructureProvider {
    // hide something in project view
    override fun modify(
        parent: AbstractTreeNode<*>,
        children: MutableCollection<AbstractTreeNode<*>>,
        settings: ViewSettings?,
    ): MutableCollection<AbstractTreeNode<*>> {

        return children
    }

}