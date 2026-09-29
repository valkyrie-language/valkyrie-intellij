package vos.intellij.ide.view.filter


import vos.intellij.ide.view.ViewElement
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.ActionPresentation
import com.intellij.ide.util.treeView.smartTree.ActionPresentationData
import com.intellij.ide.util.treeView.smartTree.Filter
import com.intellij.ide.util.treeView.smartTree.TreeElement
import vos.intellij.language.file.MessageBundle


object PublicElementsFilter : Filter {

    override fun getName() = "action.view.filter.public"

    override fun isReverted() = true
    override fun getPresentation(): ActionPresentation = ActionPresentationData(
        MessageBundle.message(name),
        null,
        AllIcons.Nodes.Public
    )
    override fun isVisible(treeNode: TreeElement): Boolean {
        return (treeNode as? ViewElement)?.getVisibility() ?: true
    }
}
