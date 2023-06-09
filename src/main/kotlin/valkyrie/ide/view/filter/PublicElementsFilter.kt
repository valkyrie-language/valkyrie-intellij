package valkyrie.ide.view.filter


import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import valkyrie.language.ValkyrieBundle


object PublicElementsFilter : Filter {

    override fun getName() = "view.PublicElementsFilter"

    override fun isReverted() = false
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        ValkyrieBundle.message(name),
        null,
        AllIcons.Nodes.Public
    )

    override fun isVisible(node: TreeElement): Boolean {
        return true
    }
}
