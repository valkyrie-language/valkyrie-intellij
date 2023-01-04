package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import valkyrie.language.psi.ValkyrieScopeNode

class ValkyrieIfStatementNode(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ValkyrieScopeNode {

}