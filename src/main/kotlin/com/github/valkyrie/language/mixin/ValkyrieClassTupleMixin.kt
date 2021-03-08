package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.ValkyrieBitflagStatement
import com.github.valkyrie.language.psi.ValkyrieClassTupleItem
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons
import com.intellij.lang.ASTNode
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement

abstract class ValkyrieClassTupleMixin(node: ASTNode) : ValkyrieElement(node),
    ValkyrieClassTupleItem {
}

