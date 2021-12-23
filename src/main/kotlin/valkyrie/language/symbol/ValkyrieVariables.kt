package valkyrie.language.symbol

import valkyrie.ide.highlight.ValkyrieHighlightColor
import valkyrie.language.ast.ValkyrieIdentifierAstNode
import valkyrie.language.ast.ValkyrieIdentifierNode
import valkyrie.language.psi.ValkyrieIdentifier
import valkyrie.language.psi_node.ValkyrieIdentifierNode

class ValkyrieVariables(val parent: ValkyrieVariables? = null) {
    private val map: MutableMap<String, ValkyrieVariableKind> = mutableMapOf()
    fun insert(node: ValkyrieIdentifierNode, color: ValkyrieHighlightColor) {
        insert(node as ValkyrieIdentifierAstNode, color)
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

