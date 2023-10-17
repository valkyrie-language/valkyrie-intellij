package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import valkyrie.ast.BINARY
import valkyrie.ast.*

class ValkyrieBinaryNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析二元表达式
        fun parse(builder: PsiBuilder): Boolean {
            val result = parseAdditive(builder)
            return result
        }

        // 解析加法表达式
        private fun parseAdditive(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            if (!parseMultiplicative(builder)) {
                marker.drop()
                return false
            }

            while (!builder.eof()) {
                val operatorType = builder.tokenType
                if (operatorType !in setOf(PLUS, MINUS)) {
                    break
                }

                builder.advanceLexer() // 消费运算符

                if (!parseMultiplicative(builder)) {
                    builder.error("Expected expression after operator")
                    break
                }

                marker.done(BINARY)
                marker = marker.precede()
            }

            marker.drop()
            return true
        }

        // 解析乘法表达式
        private fun parseMultiplicative(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            if (!parsePower(builder)) {
                marker.drop()
                return false
            }

            while (!builder.eof()) {
                val operatorType = builder.tokenType
                if (operatorType !in setOf(TIMES, DIVIDE)) {
                    break
                }

                builder.advanceLexer() // 消费运算符

                if (!parsePower(builder)) {
                    builder.error("Expected expression after operator")
                    break
                }

                marker.done(BINARY)
                marker = marker.precede()
            }

            marker.drop()
            return true
        }

        // 解析幂运算表达式（右结合）
        private fun parsePower(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            if (!ValkyrieAtomicNode.parse(builder)) {
                marker.drop()
                return false
            }

            val operatorType = builder.tokenType
            if (operatorType !in setOf(POWER)) {
                marker.drop()
                return true
            }

            builder.advanceLexer() // 消费运算符

            if (!parsePower(builder)) { // 递归处理右操作数，实现右结合
                builder.error("Expected expression after power operator")
                marker.drop()
                return true
            }

            marker.done(BINARY)
            return true
        }
    }
}