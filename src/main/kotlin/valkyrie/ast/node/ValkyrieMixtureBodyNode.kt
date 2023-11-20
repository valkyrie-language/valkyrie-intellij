package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ValkyrieVisitor
import valkyrie.psi.ValkyrieElement


class ValkyrieMixtureBodyNode(node: ASTNode) : ValkyrieElement(node) {
    val fields get() = findChildrenByClass(ValkyrieObjectFieldNode::class.java)
    val methods get() = findChildrenByClass(ValkyrieObjectMethodNode::class.java)
    val domains get() = findChildrenByClass(ValkyrieObjectDomainNode::class.java)


    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitMixtureBody(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "MixtureBody"
    }
}