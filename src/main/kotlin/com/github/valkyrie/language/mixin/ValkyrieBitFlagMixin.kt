package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.ValkyrieBitflagStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement

abstract class ValkyrieBitFlagMixin(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement,
    ValkyrieBitflagStatement {
    override fun getNavigationElement(): PsiElement = this.modifierSymbols.lastChild

    override fun getPresentation() = ValkyriePresentationItem(
        this.modifierSymbols.lastChild.text, AllIcons.Nodes.Enum
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

