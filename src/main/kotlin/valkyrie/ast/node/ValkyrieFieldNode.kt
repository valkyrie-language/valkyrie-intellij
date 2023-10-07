package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.DefineField
import valkyrie.ast.advanceIgnore
import valkyrie.cst.ValkyrieCST

class ValkyrieFieldNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ValkyrieField"
    }

    companion object {
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            // 解析注解和修饰符
            while (builder.tokenType === ValkyrieCST.Companion.OP_MACRO || builder.tokenType === ValkyrieCST.Companion.SYMBOL) {
                if (builder.tokenType === ValkyrieCST.Companion.OP_MACRO) {
                    // TODO: 解析注解
                    builder.advanceLexer()
                } else {
                    // TODO: 解析修饰符
                    builder.advanceLexer()
                }
                builder.advanceIgnore()
            }

            // 解析字段名
            if (builder.tokenType !== ValkyrieCST.Companion.SYMBOL) {
                builder.error("Expected field name")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费字段名
            builder.advanceIgnore()

            // 解析类型声明
            if (builder.tokenType === ValkyrieCST.Companion.COLON) {
                builder.advanceLexer() // 消费冒号
                builder.advanceIgnore()
                // TODO: 解析类型表达式
                if (builder.tokenType !== ValkyrieCST.Companion.SYMBOL) {
                    builder.error("Expected type expression")
                    marker.drop()
                    return false
                }
                builder.advanceLexer() // 消费类型
                builder.advanceIgnore()
            }

            // 解析默认值
            if (builder.tokenType === ValkyrieCST.Companion.EQ) {
                builder.advanceLexer() // 消费等号
                builder.advanceIgnore()
                ValkyrieValueNode.parse(builder)
            }

            marker.done(DefineField)
            return true
        }
    }
}