package valkyrie.ide.view

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.SearchableTextProvider
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

class ValkyrieStructureItem : SearchableTextProvider, SortableTreeElement {
    private val psi: NavigatablePsiElement

    constructor(psi: NavigatablePsiElement) {
        this.psi = psi
    }

    override fun getValue(): NavigatablePsiElement = psi

    override fun getSearchableText(): String? {
        return psi.name
    }

    override fun navigate(requestFocus: Boolean) = psi.navigate(requestFocus)

    override fun canNavigate(): Boolean = psi.canNavigate()

    override fun canNavigateToSource(): Boolean = psi.canNavigateToSource()

    override fun getAlphaSortKey(): String = psi.name ?: ""
    override fun getPresentation(): ItemPresentation {
        return psi.presentation ?: PresentationData()
    }

    override fun getChildren(): Array<TreeElement> {
        val visitor = ValkyrieStructureItemVisitor()
        psi.accept(visitor)
        return visitor.items.toTypedArray()
    }

    fun getVisibility(): ValkyrieVisibility {
        return ValkyrieVisibility.Public
    }
}