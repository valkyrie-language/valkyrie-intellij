package von.surface.psi

import von.surface.file.VonLanguage
import com.intellij.psi.tree.IElementType

class VonElementType(debugName: String) : IElementType(debugName, VonLanguage.INSTANCE)
