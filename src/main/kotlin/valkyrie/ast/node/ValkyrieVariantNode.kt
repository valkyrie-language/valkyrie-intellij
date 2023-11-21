package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DefineDomain
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.ValkyrieVisitor

class ValkyrieVariantNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)!!

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareVariant(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "Variant"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieAnnotationAreaNode.parse(builder)
            // 解析字段名
            if (!ValkyrieIdentifierNode.parse(builder)) {
                marker.rollbackTo()
                return false
            }
            // 解析结构体
            ValkyrieObjectBodyNode.parse(builder)
            marker.done(DefineDomain)
            return true
        }
    }
}