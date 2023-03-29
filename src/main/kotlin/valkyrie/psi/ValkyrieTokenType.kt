package valkyrie.psi

import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage

class ValkyrieTokenType(debugName: String) : IElementType(debugName, ValkyrieLanguage) {
    override fun toString(): String = "ValkyrieToken.${super.toString()}"
}