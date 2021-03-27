package com.github.valkyrie.language.ast


import com.github.valkyrie.ide.view.ValkyrieViewElement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import javax.swing.Icon

abstract class ViewableNode(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement {
    abstract val viewIcon: Icon?
    abstract override fun getNavigationElement(): PsiElement;

    override fun getPresentation() = ValkyriePresentationItem(this.getViewName(), viewIcon)
    open fun getViewName(): String = this.navigationElement.text
    open fun getChildrenView(): Array<TreeElement> {
        val children = mutableSetOf<ValkyrieViewElement>()
        this.addChildrenView(children)
        return children.toTypedArray()
    }
    open fun addChildrenView(childrenView: MutableSet<ValkyrieViewElement>) {}
}

