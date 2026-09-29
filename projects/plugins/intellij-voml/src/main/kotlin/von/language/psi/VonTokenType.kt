package von.language.psi

import von.language.VonLanguage
import com.intellij.psi.tree.IElementType

class VonTokenType(debugName: String) : IElementType(debugName, VonLanguage.INSTANCE) {
    override fun toString(): String = "VonTokenType.${super.toString()}"
}


