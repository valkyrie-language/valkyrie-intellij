package vos.intellij.language.psi

import com.intellij.psi.tree.IElementType
import vos.intellij.language.VosLanguage

class VosTokenType(debugName: String) : IElementType(debugName, VosLanguage) {
    override fun toString(): String = "VosTokenType.${super.toString()}"
}
