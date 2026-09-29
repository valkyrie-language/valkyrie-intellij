package voml.language.psi

import voml.language.VomlLanguage
import com.intellij.psi.tree.IElementType

class VomlTokenType(debugName: String) : IElementType(debugName, VomlLanguage.INSTANCE) {
    override fun toString(): String = "VomlTokenType.${super.toString()}"
}


