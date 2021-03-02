package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.ValkyrieModuleStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

abstract class ValkyrieModuleMixin(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement,
    ValkyrieModuleStatement {
    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        "modules",
        AllIcons.Nodes.Class
    )
}

