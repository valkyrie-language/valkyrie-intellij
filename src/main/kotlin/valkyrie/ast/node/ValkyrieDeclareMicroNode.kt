package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.advanceIgnore
import valkyrie.cst.SYMBOL

class ValkyrieDeclareMicroNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    // 命名函数定义节点
    // 语法: @.annotations modifiers function name(args): returnType { functionBody }
    // 或者: @.annotations modifiers function name(args) -> returnType { functionBody }
    // 函数体是可选的
    companion object {
        // 解析修饰符列表
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            // 吃掉所有的 id
            while (true) {
                builder.advanceIgnore()
                if (!ValkyrieModifierNode.parse(builder)) {
                    break
                }
            }

            if (builder.latestDoneMarker == SYMBOL) {
                marker.rollbackTo()
            }
            marker.drop()

            return true
        }
    }
}