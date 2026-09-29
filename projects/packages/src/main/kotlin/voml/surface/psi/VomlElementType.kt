package voml.surface.psi

import voml.surface.file.VomlLanguage
import com.intellij.psi.tree.IElementType

class VomlElementType(debugName: String) : IElementType(debugName, VomlLanguage.INSTANCE)
