package voml.language.psi

import voml.language.VomlLanguage
import com.intellij.psi.tree.IElementType

class VomlElementType(debugName: String) : IElementType(debugName, VomlLanguage.INSTANCE)
