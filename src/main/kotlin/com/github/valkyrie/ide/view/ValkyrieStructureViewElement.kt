package com.github.valkyrie.ide.view

import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

class ValkyrieStructureViewElement(private val myElement: NavigatablePsiElement) :
    StructureViewTreeElement,
    SortableTreeElement {
    override fun getValue(): Any {
        return myElement
    }

    override fun navigate(requestFocus: Boolean) {
        myElement.navigate(requestFocus)
    }

    override fun canNavigate(): Boolean {
        return myElement.canNavigate()
    }

    override fun canNavigateToSource(): Boolean {
        return myElement.canNavigateToSource()
    }

    override fun getAlphaSortKey(): String {
        val name = myElement.name
        return name ?: ""
    }

    override fun getPresentation(): ItemPresentation {
        val presentation = myElement.presentation
        return presentation ?: PresentationData()
    }

    override fun getChildren(): Array<TreeElement> {
//        if (myElement is VkFile) {
//            val properties: List<FluentMessage> = PsiTreeUtil.getChildrenOfTypeAsList(
//                myElement,
//                FluentMessage::class.java
//            )
//            val treeElements: MutableList<TreeElement> = ArrayList(properties.size)
//            for (property in properties) {
//                treeElements.add(FluentStructureViewElement(property as NavigatablePsiElement))
//            }
//            return treeElements.toTypedArray()
//        }
        return TreeElement.EMPTY_ARRAY
    }
}