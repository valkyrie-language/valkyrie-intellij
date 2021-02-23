package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.*
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement

abstract class ValkyrieTraitMixin(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    ValkyrieTraitStatement {
    fun getTraitName(): String {
        return this.modifiers.lastChild.text
    }
}