package von.language.psi

import von.language.VonLanguage
import com.intellij.psi.tree.IElementType

class VonElementType(debugName: String) : IElementType(debugName, VonLanguage.INSTANCE)
