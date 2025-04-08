package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParseMonad
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.advanceChoice
import valkyrie.cst.ValkyrieCST

class ValkyrieValueNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object: ParseMonad {
    // 解析值（字符串、数字、标识符、对象或数组）
    override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            builder.advanceChoice(
                ValkyrieObjectNode.Companion,
                ValkyrieArrayNode.Companion,
            )
            marker.done(ValkyrieAST.Companion.VALUE)
            return true
        }
    }
}
