package awsl.surface.psi

import awsl.surface.file.AwslLanguage
import com.intellij.psi.tree.IElementType

class AwslElementType(debugName: String) : IElementType(debugName, awsl.surface.file.AwslLanguage.INSTANCE)
