package com.github.valkyrie.language.mixin

import com.github.valkyrie.language.psi.*
import com.intellij.icons.AllIcons.Nodes.Function
import com.intellij.icons.AllIcons.Nodes.Method
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.NavigatablePsiElement
import com.intellij.util.PlatformIcons
import javax.swing.Icon
import kotlin.random.Random

abstract class ValkyrieDefineMixin(node: ASTNode) : ValkyrieElement(node),
    NavigatablePsiElement,
    ValkyrieDefStatement {

    fun isMethod(): Boolean {
        return Random.nextBoolean()
    }

    override fun getPresentation(): ItemPresentation = ValkyriePresentationItem(
        this.modifiers.lastChild.text,
        if (this.isMethod()) {
            Method
        } else {
            Function
        }
    )
}

