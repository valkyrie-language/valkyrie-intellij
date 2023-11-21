package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.advanceChoice

class ValkyrieValueNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParserMonad {
        // 解析值（字符串、数字、标识符、对象或数组）
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            builder.advanceChoice(
                ValkyrieObjectBodyNode.Companion,
                ValkyrieArrayNode.Companion,
            )
            marker.done(valkyrie.ast.VALUE)
            return true
        }
    }
}
