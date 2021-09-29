package valkyrie.language.symbol

import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.psi_node.ValkyrieIdentifierNode

data class ValkyrieVariableKind(
    val identifier: ValkyrieIdentifierNode,
    val color: ValkyrieHighlightColor,
)