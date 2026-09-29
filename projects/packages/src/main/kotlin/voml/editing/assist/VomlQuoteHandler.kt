package voml.editing.assist

import voml.surface.psi.VomlTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class VomlQuoteHandler : SimpleTokenSetQuoteHandler(VomlTypes.STRING_INLINE)
