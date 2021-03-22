package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.ast.ValkyrieElement
import com.github.valkyrie.language.psi.ValkyrieDefStatement
import com.github.valkyrie.language.psi.ValkyriePresentationItem
import com.intellij.icons.AllIcons.Nodes.Function
import com.intellij.icons.AllIcons.Nodes.Method
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.NavigatablePsiElement
import com.intellij.psi.PsiElement
import kotlin.random.Random

abstract class ValkyrieDefineMixin(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    ValkyrieDefStatement {
    override fun getNavigationElement(): PsiElement = this.modifierSymbols.lastChild

    override fun getPresentation(): ItemPresentation {
        return ValkyriePresentationItem(
            this.modifierSymbols.lastChild.text,
            if (this.isMethod()) {
                Method
            } else {
                Function
            }
        )
    }

    fun isMethod(): Boolean {
        return Random.nextBoolean()
    }
}

