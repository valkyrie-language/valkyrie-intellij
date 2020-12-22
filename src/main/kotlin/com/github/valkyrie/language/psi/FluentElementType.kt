package com.github.valkyrie.language.psi

import com.github.valkyrie.VkLanguage
import com.intellij.psi.tree.IElementType

class FluentElementType(debugName: String) : IElementType(debugName, VkLanguage.INSTANCE)
