package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.advanceIgnore
import valkyrie.ast.advanceRepeat

class ValkyrieRootNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析根节点，支持多个语句和EOF
        fun parse(builder: PsiBuilder): Boolean {
            builder.advanceIgnore()
            return builder.advanceRepeat(ValkyrieStatementNode.Companion)
        }
    }
}