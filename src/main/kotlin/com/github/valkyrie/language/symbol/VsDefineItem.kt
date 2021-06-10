package com.github.valkyrie.language.symbol

import com.github.valkyrie.language.psi.ValkyrieIdentifier
import com.github.valkyrie.language.psi_node.ValkyrieIdentifierNode
import com.intellij.psi.PsiElement

@Suppress("UnstableApiUsage")
class VsDefineItem(override val target: ValkyrieIdentifierNode) : ValkyrieSymbol(target) {
    constructor(target: ValkyrieIdentifier) : this(target as ValkyrieIdentifierNode) {

    }
    override fun getDeclaringElement(): PsiElement {
        return super.getDeclaringElement()
    }
}
