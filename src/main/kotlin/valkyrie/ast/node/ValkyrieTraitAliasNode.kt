package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ValkyrieVisitor
import valkyrie.psi.ValkyrieDeclaration

class ValkyrieTraitAliasNode(node: ASTNode) : ValkyrieDeclaration(node) {
    val keyword = findChildByClass(ValkyrieKeywordNode::class.java)!!
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)
    val typeExpression = findChildByClass(ValkyrieTypeExpressionNode::class.java)
    override fun getNameIdentifier(): ValkyrieIdentifierNode? {
        return identifier
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTraitAlias(this)
            else -> visitor.visitElement(this)
        }
    }
}