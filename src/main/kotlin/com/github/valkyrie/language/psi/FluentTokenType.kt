package com.github.valkyrie.language.psi

import com.intellij.psi.tree.IElementType

class FluentTokenType(debugName: String) : IElementType(debugName, com.github.valkyrie.VkLanguage.INSTANCE) {
    override fun toString(): String = "FluentTokenType.${super.toString()}"
}

