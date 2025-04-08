package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.TUPLE
import valkyrie.ast.advanceIgnore
import valkyrie.cst.COMMA
import valkyrie.cst.PARENTHESIS_L
import valkyrie.cst.PARENTHESIS_R

class ValkyrieTupleNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ValkyrieTuple"
    }

    companion object {
        fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType !== PARENTHESIS_L) {
                return false
            }

            val marker = builder.mark()
            builder.advanceLexer() // 消费左括号
            builder.advanceIgnore()

            // 空元组 ()
            if (builder.tokenType === PARENTHESIS_R) {
                builder.advanceLexer() // 消费右括号
                marker.done(TUPLE)
                return true
            }

            // 解析第一个元素
            if (!ValkyrieArrayItemNode.parse(builder)) {
                marker.drop()
                return false
            }

            builder.advanceIgnore()

            // 单元素元组 (item,)
            if (builder.tokenType === COMMA) {
                builder.advanceLexer() // 消费逗号
                builder.advanceIgnore()
            }

            // 多元素元组 (item1, item2, ...)
            while (builder.tokenType !== PARENTHESIS_R) {
                if (builder.tokenType !== COMMA) {
                    builder.error("Expected comma or right parenthesis")
                    marker.drop()
                    return false
                }
                builder.advanceLexer() // 消费逗号
                builder.advanceIgnore()

                if (!ValkyrieArrayItemNode.parse(builder)) {
                    marker.drop()
                    return false
                }
                builder.advanceIgnore()
            }

            if (builder.tokenType !== PARENTHESIS_R) {
                builder.error("Expected right parenthesis")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费右括号

            marker.done(TUPLE)
            return true
        }
    }
}