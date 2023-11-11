package valkyrie.ast.node

import com.intellij.lang.ASTNode
import valkyrie.psi.ValkyrieElement

class ValkyrieKeywordNode(node: ASTNode) : ValkyrieElement(node) {
    override fun getName(): String {
        return "Keyword"
    }

    override fun toString(): String {
        return "Keyword<${node.text}>"
    }
}

