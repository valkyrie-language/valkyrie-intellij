package com.github.valkyrie.language.mixin

import com.github.valkyrie.ide.view.ValkyrieStructureViewElement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieTraitStatement
import com.intellij.icons.AllIcons
import com.intellij.ide.util.treeView.smartTree.TreeElement
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.map2Array

abstract class ValkyrieTraitMixin(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement,
    ValkyrieTraitStatement {
    override fun getNavigationElement(): PsiElement = this.modifiers.lastChild

    override fun getPresentation() = ValkyriePresentationItem(
        this.getDetailName(), AllIcons.Nodes.Interface
    )

    private fun getDetailName(): String {
        val name = this.modifiers.lastChild.text;
        val ty = this.typeExpression;
        return when {
            ty != null -> "${name}: ${ty.text}"
            else -> name
        }
    }

    fun getChildrenView(): Array<TreeElement> {


        val properties: List<NavigatablePsiElement> = PsiTreeUtil.getChildrenOfTypeAsList(
            this.traitBlock, NavigatablePsiElement::class.java
        )
        return properties.map2Array {
            ValkyrieStructureViewElement(it)
        }
    }
}

