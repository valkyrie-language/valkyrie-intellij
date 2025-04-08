package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ANNOTATION_MANY
import valkyrie.ast.parsePaired
import valkyrie.cst.COMMA
import valkyrie.cst.LBRACK
import valkyrie.cst.OP_MACRO_LOWER
import valkyrie.cst.RBRACK

class ValkyrieAnnotationManyNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析多个注解
        fun parse(builder: PsiBuilder): Boolean {
            // 检查是否是 ↯ 符号
            if (builder.tokenType !== OP_MACRO_LOWER) {
                return false
            }
            // 消费 ↯
            builder.advanceLexer()
            // 检查是否是 [ 符号
            if (builder.tokenType !== LBRACK) {
                return false
            }
            // 使用 parsePaired 解析多个注解
            return builder.parsePaired(
                ANNOTATION_MANY,
                LBRACK,
                RBRACK,
                COMMA,
                ValkyrieAnnotationNode.Companion
            )
        }
    }
}