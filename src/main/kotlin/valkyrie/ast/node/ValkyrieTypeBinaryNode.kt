package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ParserMonad
import valkyrie.ast.TypeBinary
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.OP_AND
import valkyrie.cst.OP_ARROW
import valkyrie.cst.OP_OR
import valkyrie.cst.OP_ADD
import valkyrie.cst.OP_SUB

class ValkyrieTypeBinaryNode(node: ASTNode) : ValkyrieTypeExpressionNode(node) {
    val left = findChildByClass(ValkyrieTypeExpressionNode::class.java)
    val operator = findChildByClass(ValkyrieOperatorNode::class.java)
    val right = findChildByClass(ValkyrieTypeExpressionNode::class.java)

    override fun getName(): String {
        return "BinaryType<${operator?.text}>"
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTypeBinary(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseUnionIntersection(builder)
        }
    }
}

// 解析 | 和 & 运算符，最低优先级
 fun parseUnionIntersection(builder: PsiBuilder): Boolean {
    var marker = builder.mark()
    if (!parseAddSub(builder)) {
        marker.drop()
        return false
    }

    while (!builder.eof() && (builder.tokenType == OP_OR || builder.tokenType == OP_AND)) {
        val operator = builder.tokenType
        builder.advanceLexer() // 消费运算符
        if (!parseAddSub(builder)) {
            marker.error("Expected type after ${if (operator == OP_OR) "|" else "&"} operator")
            return false
        }
        marker.done(TypeBinary)
        marker = builder.mark()
    }

    marker.drop()
    return true
}

// 解析 + 和 - 运算符，中等优先级
private fun parseAddSub(builder: PsiBuilder): Boolean {
    var marker = builder.mark()
    if (!parseArrow(builder)) {
        marker.drop()
        return false
    }

    while (!builder.eof() && (builder.tokenType == OP_ADD || builder.tokenType == OP_SUB)) {
        val operator = builder.tokenType
        builder.advanceLexer() // 消费运算符
        if (!parseArrow(builder)) {
            marker.error("Expected type after ${if (operator == OP_ADD) "+" else "-"} operator")
            return false
        }
        marker.done(TypeBinary)
        marker = builder.mark()
    }

    marker.drop()
    return true
}

// 解析 -> 运算符，最高优先级
private fun parseArrow(builder: PsiBuilder): Boolean {
    var marker = builder.mark()
    if (!parseUnary(builder)) {
        marker.drop()
        return false
    }

    while (!builder.eof() && builder.tokenType == OP_ARROW) {
        builder.advanceLexer() // 消费 -> 运算符
        if (!parseUnary(builder)) {
            marker.error("Expected type after -> operator")
            return false
        }
        marker.done(TypeBinary)
        marker = builder.mark()
    }

    marker.drop()
    return true
}

// 解析一元运算符和原子类型
private fun parseUnary(builder: PsiBuilder): Boolean {
    return ValkyrieTypeUnaryNode.parse(builder) || ValkyrieTypeAtomicNode.parse(builder)
}