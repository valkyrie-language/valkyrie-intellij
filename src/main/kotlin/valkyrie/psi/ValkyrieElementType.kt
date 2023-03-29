package valkyrie.psi

import com.intellij.psi.tree.IElementType
import valkyrie.language.ValkyrieLanguage

class ValkyrieElementType(debugName: String) : IElementType(debugName, ValkyrieLanguage) {
    override fun toString(): String = "ValkyrieElement.${super.toString()}"
}