package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.parser.ParserMonad
import valkyrie.psi.ValkyrieDeclaration

class ValkyrieParameterItemNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)
    val typeHint = findChildByClass(ValkyrieTypeExpressionNode::class.java)

    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }

    override fun toString(): String {
        return "ParameterItem"
    }


    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return ValkyrieIdentifierNode.parse(builder)
        }
    }
}