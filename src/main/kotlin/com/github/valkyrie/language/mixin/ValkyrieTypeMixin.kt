package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieTypeStatement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

abstract class ValkyrieTypeMixin(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    ValkyrieTypeStatement {
    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        this.symbol.text,
        AllIcons.Nodes.Type
    )
}

