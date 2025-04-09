package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.ParserMonad
import valkyrie.ast.TermAtomic
import valkyrie.ast.TermBinary
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.*

class ValkyrieTermBinaryNode(node: ASTNode) : ValkyrieTermExpressionNode(node) {
    val operator = findChildByClass(ValkyrieOperatorNode::class.java)
    val lhs = findChildByClass(ValkyrieTermExpressionNode::class.java)
    val rhs = findChildByClass(ValkyrieTermExpressionNode::class.java)

    override fun getName(): String {
        return "BinaryTerm<${operator?.text}>"
    }

    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitTermBinary(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseAdditive(builder)
        }
    }
}


// 解析加法表达式
private fun parseAdditive(builder: PsiBuilder): Boolean {
    var marker = builder.mark()

    if (!parseMultiplicative(builder)) {
        marker.drop()
        return false
    }

    while (!builder.eof()) {
        val operatorType = builder.tokenType
        if (operatorType !in setOf(OP_ADD, OP_SUB)) {
            break
        }

        ValkyrieOperatorNode.parse(builder)

        if (!parseMultiplicative(builder)) {
            builder.error("Expected expression after operator")
            break
        }

        marker.done(TermBinary)
        marker = marker.precede()
    }

    marker.drop()
    return true
}

// 解析乘法表达式
private fun parseMultiplicative(builder: PsiBuilder): Boolean {
    var marker = builder.mark()

    if (!parsePower(builder)) {
        marker.drop()
        return false
    }

    while (!builder.eof()) {
        val operatorType = builder.tokenType
        if (operatorType !in setOf(OP_MUL, OP_DIV)) {
            break
        }

        ValkyrieOperatorNode.parse(builder)

        if (!parsePower(builder)) {
            builder.error("Expected expression after operator")
            break
        }

        marker.done(TermBinary)
        marker = marker.precede()
    }

    marker.drop()
    return true
}

// 解析幂运算表达式（右结合）


private fun parsePower(builder: PsiBuilder): Boolean {
    var marker = builder.mark()

    if (!parsePrimary(builder)) {
        marker.drop()
        return false
    }

    // 处理幂运算，右结合
    if (builder.tokenType === OP_POW) {
        ValkyrieOperatorNode.parse(builder)

        if (!parsePower(builder)) { // 递归处理右侧表达式
            builder.error("Expected expression after power operator")
            marker.drop()
            return true
        }

        marker.done(TermBinary)
        return true
    }

    marker.drop()
    return true
}

private fun parsePrimary(builder: PsiBuilder): Boolean {
    if (builder.tokenType === PARENTHESIS_L) {
        val marker = builder.mark()
        builder.advanceLexer() // 消费左括号
        if (!parseAdditive(builder)) {
            marker.error("Expected expression in parentheses")
            return true
        }
        if (builder.tokenType !== PARENTHESIS_R) {
            marker.error("Expected closing parenthesis")
            return true
        }
        builder.advanceLexer() // 消费右括号
        marker.done(TermAtomic)
        return true
    }
    return ValkyrieTermAtomicNode.parse(builder)
}