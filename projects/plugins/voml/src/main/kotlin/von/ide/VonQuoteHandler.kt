package von.ide

import von.language.psi.VonTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class VonQuoteHandler : SimpleTokenSetQuoteHandler(VonTypes.STRING_INLINE)
