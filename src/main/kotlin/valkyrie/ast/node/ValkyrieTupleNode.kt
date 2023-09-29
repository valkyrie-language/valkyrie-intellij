package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.advanceIgnore
import valkyrie.cst.ValkyrieCST

class ValkyrieTupleNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ValkyrieTuple"
    }

    companion object {
        fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType !== ValkyrieCST.Companion.PARENTHESIS_L) {
                return false
            }

            val marker = builder.mark()
            builder.advanceLexer() // 消费左括号
            builder.advanceIgnore()

            // 空元组 ()
            if (builder.tokenType === ValkyrieCST.Companion.PARENTHESIS_R) {
                builder.advanceLexer() // 消费右括号
                marker.done(ValkyrieAST.Companion.TUPLE)
                return true
            }

            // 解析第一个元素
            if (!ValkyrieArrayItemNode.parse(builder)) {
                marker.drop()
                return false
            }

            builder.advanceIgnore()

            // 单元素元组 (item,)
            if (builder.tokenType === ValkyrieCST.Companion.COMMA) {
                builder.advanceLexer() // 消费逗号
                builder.advanceIgnore()
            }

            // 多元素元组 (item1, item2, ...)
            while (builder.tokenType !== ValkyrieCST.Companion.PARENTHESIS_R) {
                if (builder.tokenType !== ValkyrieCST.Companion.COMMA) {
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

            if (builder.tokenType !== ValkyrieCST.Companion.PARENTHESIS_R) {
                builder.error("Expected right parenthesis")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费右括号

            marker.done(ValkyrieAST.Companion.TUPLE)
            return true
        }
    }
}