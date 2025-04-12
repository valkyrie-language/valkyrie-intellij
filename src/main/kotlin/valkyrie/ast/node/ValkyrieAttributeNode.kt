package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.Annotation
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.advanceIgnore
import valkyrie.cst.OP_MACRO_UPPER

class ValkyrieAttributeNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    val namepath = findChildByClass(ValkyrieNamePathNode::class.java)

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitAttribute(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "AttributeItem"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            // 匹配 ↯
            if (builder.tokenType === OP_MACRO_UPPER) {
                builder.advanceLexer()
                builder.advanceIgnore()
            } else {
                marker.drop()
                return false
            }
            // 解析名称路径
            if (ValkyrieNamePathNode.parse(builder)) {
                builder.advanceIgnore()
            } else {
                builder.error("Expected identifier")
                marker.done(Annotation)
                return true
            }
            ValkyrieParameterListNode.parse(builder)
            builder.advanceIgnore()
            ValkyrieObjectNode.parse(builder)
            marker.done(Annotation)
            return true
        }
    }
}