package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.tree.IElementType
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.advanceIgnore
import valkyrie.cst.COLON
import valkyrie.psi.ValkyrieElement

open class ValkyrieTypeExpressionNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTypeExpression(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseUnionIntersection(builder)
        }
    }
}

fun parseNamedTypeExpression(builder: PsiBuilder, type: IElementType): Boolean {
    val marker = builder.mark()
    // 解析可选的注解列表
    ValkyrieAnnotationAreaNode.parse(builder)
    builder.advanceIgnore()

    // 解析类名标识符
    if (ValkyrieIdentifierNode.parse(builder)) {
        builder.advanceIgnore()
    } else {
        builder.error("Expected 111 name")
        marker.drop()
        return false
    }
    if (builder.tokenType == COLON) {
        builder.advanceLexer()
        builder.advanceIgnore()
    } else {
        builder.error("Expected 222 name")
        marker.drop()
        return false
    }
    if (ValkyrieTypeExpressionNode.parse(builder)) {
        marker.done(type)
        return true
    } else {
        builder.error("Expected 333 name")
        marker.drop()
        return false
    }
}