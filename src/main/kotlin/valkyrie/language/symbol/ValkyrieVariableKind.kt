package valkyrie.language.symbol

import valkyrie.ide.highlight.HighlightColor
import valkyrie.psi.node.ValkyrieIdentifierNode

data class ValkyrieVariableKind(
    val identifier: ValkyrieIdentifierNode,
    val color: HighlightColor,
)