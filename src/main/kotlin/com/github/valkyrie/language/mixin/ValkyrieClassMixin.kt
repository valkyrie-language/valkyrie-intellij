package com.github.valkyrie.language.mixin

import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement

open class ValkyrieClassMixin(node: ASTNode) : ValkyrieElement(node), NavigatablePsiElement {

}