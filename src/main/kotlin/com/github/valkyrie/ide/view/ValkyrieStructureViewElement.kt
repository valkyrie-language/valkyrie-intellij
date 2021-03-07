package com.github.valkyrie.ide.view

import com.github.valkyrie.language.psi_node.ValkyrieClassStatementNode
import com.github.valkyrie.language.psi_node.ValkyrieTraitStatementNode
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.map2Array

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
        return when (self) {
            is ValkyrieTraitStatementNode -> self.getChildrenView()
            is ValkyrieClassStatementNode -> self.getChildrenView()
            else -> {
                val properties: List<NavigatablePsiElement> = PsiTreeUtil.getChildrenOfTypeAsList(
                    self,
                    NavigatablePsiElement::class.java
                )
                properties.map2Array {
                    ValkyrieStructureViewElement(it)
                }
            }
        }
    }

    // TODO: return object
    fun getVisibility(): Boolean = true
}