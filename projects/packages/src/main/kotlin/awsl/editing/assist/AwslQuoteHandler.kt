package awsl.editing.assist

import awsl.surface.file.AwslParserDefinition
import awsl.surface.psi.AwslTypes
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler

class AwslQuoteHandler : SimpleTokenSetQuoteHandler(AwslParserDefinition.STRING_LITERALS)
