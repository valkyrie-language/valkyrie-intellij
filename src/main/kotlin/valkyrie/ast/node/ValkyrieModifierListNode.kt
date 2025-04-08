package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.advanceIgnore
import valkyrie.cst.ValkyrieCST

class ValkyrieModifierListNode(node: ASTNode) : ASTWrapperPsiElement(node) {
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

            if (builder.latestDoneMarker == ValkyrieCST.SYMBOL) {
                marker.rollbackTo()
            }
            marker.drop()

            return true
        }
    }
}