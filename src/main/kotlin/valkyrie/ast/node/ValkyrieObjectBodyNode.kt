package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ObjectBody
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parseBraceItems
import valkyrie.cst.COMMA
import valkyrie.cst.SEMICOLON
import valkyrie.psi.ValkyrieElement


class ValkyrieObjectBodyNode(node: ASTNode) : ValkyrieElement(node) {
    val fields get() = findChildrenByClass(ValkyrieObjectFieldNode::class.java)
    val methods get() = findChildrenByClass(ValkyrieObjectMethodNode::class.java)
    val domains get() = findChildrenByClass(ValkyrieObjectDomainNode::class.java)


    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitObjectBody(this)
            else -> visitor.visitElement(this)
        }
    }


    override fun toString(): String {
        return "ObjectBody"
    }

    companion object : ParserMonad {
        //
        override fun parse(builder: PsiBuilder): Boolean {
            return parseBraceItems(
                builder,
                ObjectBody,
                SkipSeparator(COMMA, SEMICOLON),
                ValkyrieObjectDomainNode,
                ValkyrieObjectMethodNode,
                ValkyrieObjectFieldNode,
            )
        }
    }
}

