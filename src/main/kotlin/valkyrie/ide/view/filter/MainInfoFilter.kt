package valkyrie.ide.view.filter


import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import valkyrie.ide.view.ValkyrieStructureItem
import valkyrie.language.ValkyrieBundle
import valkyrie.psi.node.ValkyrieDeclareClassNode

class MainInfoFilter : Filter {
    override fun getName() = "view.MainInfoFilter"

    override fun isReverted() = false
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        ValkyrieBundle.message(this.name),
        null,
        AllIcons.Nodes.Favorite
    )

    override fun isVisible(node: TreeElement): Boolean {
        if (node is ValkyrieStructureItem) {
            when (node.node) {
                // class
                is ValkyrieDeclareClassNode -> return true
//                is ValkyrieClassFieldNode -> return true
//                is ValkyrieClassMethodNode -> return true
                // union
//                is ValkyrieUnionStatement -> return true
//                is ValkyrieUnionStatementItem -> return true
                // trait
//                is ValkyrieTraitStatement -> return true
//                is ValkyrieExtendsStatement -> return true
            }
        }
        return false;
    }
}
