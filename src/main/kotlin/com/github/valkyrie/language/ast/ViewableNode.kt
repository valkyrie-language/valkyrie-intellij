package com.github.valkyrie.language.ast


import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.mixin.ValkyrieElement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import javax.swing.Icon

abstract class ViewableNode(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement {
    var childrenView: MutableSet<ValkyrieViewElement> = mutableSetOf()
    abstract val viewName: String?
    abstract val viewIcon: Icon?

    override fun getPresentation() = ValkyriePresentationItem(viewName, viewIcon)

    fun getChildrenView(): Array<TreeElement> {
        childrenView.clear()
        this.addChildrenView()
        return childrenView.toTypedArray()
    }
    abstract fun addChildrenView();
}

