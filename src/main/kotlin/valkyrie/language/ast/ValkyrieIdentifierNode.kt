package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree

class ValkyrieIdentifierNode(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type) {
    override fun getName(): String {
        return text
    }
}

