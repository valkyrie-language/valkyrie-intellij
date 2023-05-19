package valkyrie.ide.view.sorter

import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Sorter
import valkyrie.language.ValkyrieBundle

private val title = ValkyrieBundle.message("view.PropertiesGrouper");
private val text = ValkyrieBundle.message("view.PropertiesGrouper");
private val description = ValkyrieBundle.message("view.PropertiesGrouper");

object PublicElementsSorter : Sorter {
    override fun getPresentation(): ActionPresentation {
        return ActionPresentationData(
            title,
            description,
            AllIcons.Nodes.Favorite
        )
    }

    override fun getName(): String {
        return "PublicElementsFilter"
    }

    override fun getComparator(): Sort {
        return Sort()
    }

    override fun isVisible(): Boolean {
        TODO("Not yet implemented")
    }

    class Sort : Comparator<Any> {
        override fun compare(o1: Any?, o2: Any?): Int {
            return 0
        }
    }
}

