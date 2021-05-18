package com.github.valkyrie.ide.view

import com.github.valkyrie.ide.file.ValkyrieFileNode
import com.github.valkyrie.language.ast.ValkyrieASTBase
import com.intellij.ide.projectView.PresentationData
import com.intellij.ide.structureView.StructureViewTreeElement
import com.intellij.ide.util.treeView.smartTree.SortableTreeElement
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import javax.swing.Icon

class ValkyrieViewElement : StructureViewTreeElement, SortableTreeElement {
    private val self: NavigatablePsiElement
    var view: ItemPresentation? = null

    constructor(self: NavigatablePsiElement) {
        this.self = self
    }

    constructor(self: NavigatablePsiElement, view: ItemPresentation) {
        this.self = self
        this.view = view
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

    override fun getPresentation(): ItemPresentation = when {
        view != null -> view!!
        self.presentation != null -> self.presentation!!
        else -> PresentationData()
    }

    override fun getChildren(): Array<out TreeElement> = when (self) {
        is ValkyrieFileNode -> self.getChildrenView()
        is ValkyrieASTBase -> self.getChildrenView()
        else -> arrayOf()
    }

    // TODO: return object
    fun getVisibility(): Boolean = true
}