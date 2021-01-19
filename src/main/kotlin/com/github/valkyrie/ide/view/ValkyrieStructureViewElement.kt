package com.github.valkyrie.ide.view

import com.github.valkyrie.language.psi.ValkyrieBitflagStatement
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

class ValkyrieStructureViewElement(private val self: NavigatablePsiElement) :
    StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any {
        return self
    }

    override fun navigate(requestFocus: Boolean) {
        self.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return self.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return self.canNavigateToSource()
    }

    override fun getAlphaSortKey(): String {
        return self.name ?: ""
    }

    override fun getPresentation(): ItemPresentation {
        val presentation = self.presentation
        return presentation ?: PresentationData()
    }

    override fun getChildren(): Array<TreeElement> {
        if (self is ValkyrieFile) {
            val treeElements: MutableList<TreeElement> = ArrayList(1024)
            val properties = PsiTreeUtil.getChildrenOfTypeAsList(
                self,
                NavigatablePsiElement::class.java
            )
            for (property in properties) {
                treeElements.add(ValkyrieStructureViewElement(property))
            }
            return treeElements.toTypedArray()
        }
        return TreeElement.EMPTY_ARRAY
    }
}