package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.parsePaired
import valkyrie.cst.ValkyrieCST

class ValkyrieAnnotationManyNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析多个注解
        fun parse(builder: PsiBuilder): Boolean {
            // 检查是否是 ↯ 符号
            if (builder.tokenType !== ValkyrieCST.Companion.OP_MACRO_LOWER) {
                return false
            }
            // 消费 ↯
            builder.advanceLexer()
            // 检查是否是 [ 符号
            if (builder.tokenType !== ValkyrieCST.Companion.LBRACK) {
                return false
            }
            // 使用 parsePaired 解析多个注解
            return builder.parsePaired(
                ValkyrieAST.Companion.ANNOTATION_MANY,
                ValkyrieCST.Companion.LBRACK,
                ValkyrieCST.Companion.RBRACK,
                ValkyrieCST.Companion.COMMA,
                ValkyrieAnnotationNode.Companion
            )
        }
    }
}