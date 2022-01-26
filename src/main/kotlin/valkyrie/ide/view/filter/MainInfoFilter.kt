package valkyrie.ide.view.filter


import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import valkyrie.ide.view.ValkyrieViewElement
import valkyrie.ide.view.ValkyrieVisibility
import valkyrie.language.ValkyrieBundle


object MainInfoFilter : Filter {

    override fun getName() = "view.MainInfoFilter"

    override fun isReverted() = true
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        ValkyrieBundle.message(this.name),
        null,
        AllIcons.Nodes.Favorite
    )

    override fun isVisible(node: TreeElement): Boolean {
        return (node as? ValkyrieViewElement)?.visibility == ValkyrieVisibility.Public
    }
}
