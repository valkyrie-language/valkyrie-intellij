package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieSymbol
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement

abstract class ValkyrieIdentifierMixin(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    ValkyrieSymbol {
    override fun getNavigationElement(): PsiElement = this

    override fun getPresentation() = ValkyriePresentationItem(
        this.text, AllIcons.Nodes.Variable
    )

//    fun getChildrenView(): Array<TreeElement> {
//        val properties: List<NavigatablePsiElement> = PsiTreeUtil.getChildrenOfTypeAsList(
//            this.traitBlock, NavigatablePsiElement::class.java
//        )
//        return properties.map2Array {
//            ValkyrieStructureViewElement(it)
//        }
//    }
}

