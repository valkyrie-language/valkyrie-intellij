package von.editing.assist

import von.surface.psi.VonTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class VonQuoteHandler : SimpleTokenSetQuoteHandler(VonTypes.STRING_INLINE)
