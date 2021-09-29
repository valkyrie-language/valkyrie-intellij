package valkyrie.language.symbol

import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi_node.ValkyrieIdentifierNode

class ValkyrieVariables(val parent: ValkyrieVariables? = null) {
    private val map: MutableMap<String, ValkyrieVariableKind> = mutableMapOf()
    fun insert(node: ValkyrieIdentifier, color: ValkyrieHighlightColor) {
        insert(node as ValkyrieIdentifierNode, color)
    }

    fun insert(node: ValkyrieIdentifierNode, color: ValkyrieHighlightColor) {
        map[node.name] = ValkyrieVariableKind(node, color)
    }

    fun extend(other: ValkyrieVariables?) {
        if (other != null) {
            map.putAll(other.map)
        }
    }

    fun getLocal(): Iterable<ValkyrieVariableKind> {
        return map.values
    }
}

