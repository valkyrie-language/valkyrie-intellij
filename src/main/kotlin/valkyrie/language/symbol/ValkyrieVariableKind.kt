package yggdrasil.language.symbol

import valkyrie.ide.highlight.HighlightColor
import yggdrasil.psi.node.ValkyrieIdentifierNode

data class ValkyrieVariableKind(
    val identifier: ValkyrieIdentifierNode,
    val color: HighlightColor,
)