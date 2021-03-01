package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

abstract class ValkyrieClassMixin(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement,
    ValkyrieClassStatement {
    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        this.modifiers.lastChild.text,
        AllIcons.Nodes.Class
    )
}

