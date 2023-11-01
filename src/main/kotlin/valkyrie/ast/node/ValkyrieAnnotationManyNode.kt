package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.TokenSet
import valkyrie.ast.ANNOTATION_MANY
import valkyrie.ast.parsePaired
import valkyrie.cst.BRACKET_L
import valkyrie.cst.BRACKET_R
import valkyrie.cst.COMMA
import valkyrie.cst.OP_MACRO_LOWER

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
            if (builder.tokenType !== BRACKET_L) {
                return false
            }
            // 使用 parsePaired 解析多个注解
            return builder.parsePaired(
                ANNOTATION_MANY,
                BRACKET_L,
                BRACKET_R,
                TokenSet.create(COMMA),
                ValkyrieAnnotationNode
            )
        }
    }
}