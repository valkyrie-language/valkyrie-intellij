package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DefineField
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.psi.ValkyrieElement

class ValkyrieObjectFieldNode(node: ASTNode) : ValkyrieElement(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)!!

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitObjectField(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "ObjectField"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieAnnotationAreaNode.parse(builder)

            // 解析字段名
            if (ValkyrieIdentifierNode.parse(builder)) {
                marker.done(DefineField)
                return true
            } else {
                marker.drop()
                return false
            }
        }
    }
}