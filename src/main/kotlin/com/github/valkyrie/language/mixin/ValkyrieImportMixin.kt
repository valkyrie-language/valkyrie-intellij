package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieElement
import com.github.valkyrie.language.psi.ValkyrieImportStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement

abstract class ValkyrieImportMixin(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement,
    ValkyrieImportStatement {
    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        "imports",
        AllIcons.Nodes.Class
    )
}

