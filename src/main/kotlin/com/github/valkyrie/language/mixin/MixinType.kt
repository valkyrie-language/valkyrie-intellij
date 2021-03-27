package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieElement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.github.valkyrie.language.psi.ValkyrieTypeStatement
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

abstract class MixinType(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    ValkyrieTypeStatement {
    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        this.identifier.text,
        AllIcons.Nodes.Type
    )
}

