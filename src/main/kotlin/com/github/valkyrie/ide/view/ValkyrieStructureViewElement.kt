package com.github.valkyrie.ide.view

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.json.psi.JsonFile
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil

class ValkyrieStructureViewElement(private val self: NavigatablePsiElement) :
    StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any = self

    override fun navigate(requestFocus: Boolean) = self.navigate(requestFocus)

    override fun canNavigate(): Boolean = self.canNavigate()

    override fun canNavigateToSource(): Boolean = self.canNavigateToSource()

    override fun getAlphaSortKey(): String = self.name ?: ""

    override fun getPresentation(): ItemPresentation = self.presentation ?: PresentationData()

    override fun getChildren(): Array<TreeElement> {
        val treeElements: MutableList<TreeElement> = ArrayList(1024)
//        if (myElement is JsonFile) {
//            value = (myElement as JsonFile).topLevelValue!!
//        }
        val properties: List<NavigatablePsiElement> = PsiTreeUtil.getChildrenOfTypeAsList(
            self,
            NavigatablePsiElement::class.java
        )
        for (property in properties) {
            treeElements.add(ValkyrieStructureViewElement(property))
        }
        return treeElements.toTypedArray()
    }

    // TODO: return object
    fun getVisibility(): Boolean = true
}