package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.extapi.psi.ASTWrapperPsiElement
import valkyrie.ast.ParseMonad
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.advanceIgnore
import valkyrie.cst.ValkyrieCST

class ValkyrieArrayItemNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object: ParseMonad {
      override  fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            // 检查是否有键值对形式
            val hasKey = builder.tokenType === ValkyrieCST.Companion.SYMBOL
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
                if (builder.tokenType !== ValkyrieCST.Companion.COLON) {
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
            
            marker.done(ValkyrieAST.ArrayItem)
            return true
        }
    }
}