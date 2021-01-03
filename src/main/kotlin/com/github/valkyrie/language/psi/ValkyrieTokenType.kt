package com.github.valkyrie.language.psi

import com.github.valkyrie.VkLanguage
import com.intellij.psi.tree.IElementType

class ValkyrieTokenType(debugName: String) : IElementType(debugName, VkLanguage.INSTANCE) {
    override fun toString(): String = "ValkyrieTokenType.${super.toString()}"
}

