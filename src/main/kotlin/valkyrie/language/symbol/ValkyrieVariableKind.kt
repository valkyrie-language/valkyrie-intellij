package valkyrie.language.symbol

import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.mixin.MixinIdentifier


data class ValkyrieVariableKind(
    val identifier: MixinIdentifier,
    val color: HighlightColor,
)