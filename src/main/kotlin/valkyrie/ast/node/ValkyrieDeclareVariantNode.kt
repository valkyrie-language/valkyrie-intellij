package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DefineDomain
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.advanceIgnore

class ValkyrieDeclareVariantNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    val identifier = findChildByClass(ValkyrieIdentifierNode::class.java)!!

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareVariant(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "ObjectDomain"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieAnnotationAreaNode.parse(builder)
            builder.advanceIgnore()
            // 解析字段名
            if (ValkyrieIdentifierNode.parse(builder)) {
                builder.advanceIgnore()
            } else {
                marker.drop()
                return false
            }
            // 解析形式参数
            if (ValkyrieObjectNode.parse(builder)) {
                marker.done(DefineDomain)
                return true
            } else {
                marker.drop()
                return false
            }
        }
    }
}