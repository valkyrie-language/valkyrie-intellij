package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Atomic
import valkyrie.ast.Binary
import valkyrie.ast.ParserMonad
import valkyrie.ast.Unary
import valkyrie.cst.*

open class ValkyrieTermExpressionNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseAdditive(builder)
        }
    }
}

class ValkyrieTermBinaryNode(node: ASTNode) : ValkyrieTermExpressionNode(node) {
    val operator = findChildByClass(ValkyrieOperatorNode::class.java)
    val lhs = findChildByClass(ValkyrieTermExpressionNode::class.java)
    val rhs = findChildByClass(ValkyrieTermExpressionNode::class.java)

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseAdditive(builder)
        }
    }
}

class ValkyrieTermUnaryNode(node: ASTNode) : ValkyrieTermExpressionNode(node) {
    val operator = findChildByClass(ValkyrieOperatorNode::class.java)
    val base = findChildByClass(ValkyrieTermExpressionNode::class.java)

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            // 处理前缀一元运算符
            when (builder.tokenType) {
                OP_PLUS, OP_MINUS -> {
                    builder.advanceLexer() // 消费运算符
                    if (!parseAdditive(builder)) {
                        marker.error("Expected expression after unary operator")
                        return true
                    }
                    marker.done(Unary)
                    return true
                }
            }

            marker.drop()
            return false
        }
    }
}

class ValkyrieTermAtomicNode(node: ASTNode) : ValkyrieTermExpressionNode(node) {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            when (builder.tokenType) {
                BRACE_L -> {
                    ValkyrieObjectNode.parse(builder)
                }

                BRACKET_L -> {
                    ValkyrieArrayNode.parse(builder)
                }

                STRING, NUMBER, SYMBOL -> {
                    builder.advanceLexer() // 消费值
                }

                else -> {
                    marker.drop()
                    return false
                }
            }

            // 处理后缀方法调用
            while (builder.tokenType === DOT) {
                builder.advanceLexer() // 消费点号
                if (builder.tokenType !== SYMBOL) {
                    marker.error("Expected method name")
                    return true
                }
                builder.advanceLexer() // 消费方法名

                // 处理参数列表
                if (builder.tokenType === PARENTHESIS_L) {
                    builder.advanceLexer() // 消费左括号
                    // TODO: 解析参数列表
                    while (!builder.eof() && builder.tokenType !== PARENTHESIS_R) {
                        if (!parseAdditive(builder)) {
                            marker.error("Invalid argument")
                            return true
                        }
                        if (builder.tokenType === COMMA) {
                            builder.advanceLexer() // 消费逗号
                        } else {
                            break
                        }
                    }
                    if (builder.tokenType === PARENTHESIS_R) {
                        builder.advanceLexer() // 消费右括号
                    } else {
                        marker.error("Expected closing parenthesis")
                        return true
                    }
                }
            }

            marker.done(Atomic)
            return true
        }
    }
}

class ValkyrieOperatorNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    // 不需要解析
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
        if (operatorType !in setOf(OP_PLUS, OP_MINUS)) {
            break
        }

        builder.advanceLexer() // 消费运算符

        if (!parseMultiplicative(builder)) {
            builder.error("Expected expression after operator")
            break
        }

        marker.done(Binary)
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
        if (operatorType !in setOf(OP_TIMES, OP_DIVIDE)) {
            break
        }

        builder.advanceLexer() // 消费运算符

        if (!parsePower(builder)) {
            builder.error("Expected expression after operator")
            break
        }

        marker.done(Binary)
        marker = marker.precede()
    }

    marker.drop()
    return true
}

// 解析幂运算表达式（右结合）
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
        marker.done(Unary)
        return true
    }
    return ValkyrieTermAtomicNode.parse(builder)
}

private fun parsePower(builder: PsiBuilder): Boolean {
    var marker = builder.mark()

    if (!parsePrimary(builder)) {
        marker.drop()
        return false
    }

    // 处理连续的幂运算
    while (builder.tokenType === OP_POWER) {
        builder.advanceLexer() // 消费运算符

        val rightMarker = builder.mark()
        if (!parsePrimary(builder)) {
            builder.error("Expected expression after power operator")
            rightMarker.drop()
            marker.drop()
            return true
        }

        // 继续检查是否还有幂运算
        while (builder.tokenType === OP_POWER) {
            builder.advanceLexer() // 消费运算符
            if (!parsePrimary(builder)) {
                builder.error("Expected expression after power operator")
                rightMarker.drop()
                marker.drop()
                return true
            }
            rightMarker.done(Binary)
        }

        marker.done(Binary)
        marker = marker.precede()
    }

    marker.drop()
    return true
}