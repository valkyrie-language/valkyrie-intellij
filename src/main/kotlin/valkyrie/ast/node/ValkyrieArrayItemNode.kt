package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ArrayItem
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceIgnore
import valkyrie.cst.COLON
import valkyrie.cst.SYMBOL

class ValkyrieArrayItemNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            // 检查是否有键值对形式
            val hasKey = builder.tokenType === SYMBOL
            if (hasKey) {
                // 解析可选的注解列表
                ValkyrieAnnotationAreaNode.parse(builder)
                builder.advanceIgnore()

                // 解析可选的修饰符列表
                ValkyrieModifierListNode.parse(builder)
                builder.advanceIgnore()
                // 消费标识符
                builder.advanceLexer()
                builder.advanceIgnore()

                // 检查并消费冒号
                if (builder.tokenType !== COLON) {
                    builder.error("Expected colon")
                    marker.drop()
                    return false
                }
                builder.advanceLexer()
                builder.advanceIgnore()
            }

            // 解析表达式值
            if (!ValkyrieValueNode.parse(builder)) {
                builder.error("Expected expression")
                marker.drop()
                return false
            }

            marker.done(ArrayItem)
            return true
        }
    }
}