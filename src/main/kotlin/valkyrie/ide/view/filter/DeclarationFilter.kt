package valkyrie.ide.view.filter


import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import valkyrie.ide.view.ValkyrieStructureItem
import valkyrie.language.ValkyrieBundle
import valkyrie.psi.ValkyrieDeclaration


private val title = ValkyrieBundle.message("view.filter.declaration")

object DeclarationFilter : Filter {
    override fun getName(): String = title

    override fun isReverted() = false
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        name,
        null,
        AllIcons.Nodes.Favorite
    )

    override fun isVisible(node: TreeElement): Boolean {
        return when (node) {
            is ValkyrieStructureItem -> {
                node.value is ValkyrieDeclaration
            }

            else -> {
                true;
            }
        }
    }
}
