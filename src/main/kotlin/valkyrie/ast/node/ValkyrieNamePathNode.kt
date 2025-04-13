package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.NamePath
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.advanceRepeat
import valkyrie.psi.ValkyrieElement

class ValkyrieNamePathNode(node: ASTNode) : ValkyrieElement(node) {
    val identifiers by lazy { findChildrenByClass(ValkyrieIdentifierNode::class.java) }
    val identifier = identifiers.lastOrNull()
    val namespace = identifiers.take(identifiers.size - 1)

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitNamePath(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "NamePath"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            if (ValkyrieIdentifierNode.parse(builder)) {
                builder.advanceRepeat(ValkyrieNameJoin, 0, 1024)
//                ValkyrieNameJoin.parse(builder)
                marker.done(NamePath)
                return true
            } else {
                marker.drop()
                return false
            }
        }
    }
}