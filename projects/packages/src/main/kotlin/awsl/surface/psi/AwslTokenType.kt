package awsl.surface.psi

import awsl.surface.file.AwslLanguage
import com.intellij.psi.tree.IElementType

class AwslTokenType(debugName: String) : IElementType(debugName, awsl.surface.file.AwslLanguage.INSTANCE) {
    override fun toString(): String = "AwslToken.${super.toString()}"
}

