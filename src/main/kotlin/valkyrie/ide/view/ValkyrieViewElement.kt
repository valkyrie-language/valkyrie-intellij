package valkyrie.ide.view

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import org.antlr.intellij.adaptor.psi.ANTLRPsiNode
import javax.swing.Icon

class ValkyrieViewElement : StructureViewTreeElement, SortableTreeElement {
    private val self: NavigatablePsiElement
    val view: ItemPresentation;

    constructor(self: NavigatablePsiElement) {
        this.self = self
        this.view = self.presentation!!
    }

    constructor(self: NavigatablePsiElement, name: String, icon: Icon) {
        this.self = self
        this.view = PresentationData(name, "", icon, null)
    }

    override fun getValue(): Any = self

    override fun navigate(requestFocus: Boolean) = self.navigate(requestFocus)

    override fun canNavigate(): Boolean = self.canNavigate()

    override fun canNavigateToSource(): Boolean = self.canNavigateToSource()

    override fun getAlphaSortKey(): String = self.name ?: ""

    override fun getPresentation(): ItemPresentation = view

    override fun getChildren(): Array<out ValkyrieViewElement> {
        return findChildrenView(self)
    }

    // TODO: return object
    fun getVisibility(): Boolean = true

    companion object {
        fun findChildrenView(root: PsiElement): Array<ValkyrieViewElement> {
            val output = mutableListOf<ValkyrieViewElement>();
            var needSearch = root.children.toList();
            while (needSearch.isNotEmpty()) {
                val nextSearch = mutableListOf<PsiElement>();
                for (node in needSearch) {
                    if (node is NavigatablePsiElement) {
                        if (node.presentation != null) {
                            output.add(ValkyrieViewElement(node))
                        }
                    } else {
                        nextSearch.addAll(node.children);
                    }
                }
                needSearch = nextSearch
            }
            return output.toTypedArray()
        }
    }
}