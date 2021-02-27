package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.util.PlatformIcons

abstract class ValkyrieClassMixin(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement,
    ValkyrieClassStatement {
    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        this.modifiers.lastChild.text,
        PlatformIcons.CLASS_ICON
    )
}

