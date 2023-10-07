package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.EXPRESSION
import valkyrie.ast.ParserMonad

class ValkyrieExpressionNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object:ParserMonad {
      override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            // 尝试解析二元表达式
            if (ValkyrieBinaryNode.parse(builder)) {
                marker.done(EXPRESSION)
                return true
            }

            // 如果不是二元表达式，尝试解析原子表达式
            if (!ValkyrieAtomicNode.parse(builder)) {
                marker.drop()
                return false
            }

            marker.done(EXPRESSION)
            return true
        }
    }
}