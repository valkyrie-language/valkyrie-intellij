package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Annotation
import valkyrie.ast.ParserMonad
import valkyrie.cst.*

class ValkyrieAnnotationNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "AnnotationItem"
    }

    companion object : ParserMonad {
        // 解析注解
        override fun parse(builder: PsiBuilder): Boolean {
            // 检查是否是 ↯ 符号，如果在多注解中调用时已经消费了 ↯
            if (builder.tokenType === OP_MACRO_LOWER) {
                builder.advanceLexer() // 消费 ↯
            }
            val marker = builder.mark()
            // 解析名称路径
            if (builder.tokenType !== SYMBOL) {
                marker.error("Expected identifier")
                return true
            }
            builder.advanceLexer() // 消费标识符
            // 检查是否有名称分隔符
            while (builder.tokenType === COLON && builder.lookAhead(1) === COLON ||
                builder.tokenType === DOT
            ) {
                builder.advanceLexer() // 消费分隔符
                if (builder.tokenType === COLON) {
                    builder.advanceLexer() // 消费第二个冒号
                }
                if (builder.tokenType !== SYMBOL) {
                    marker.error("Expected identifier")
                    return true
                }
                builder.advanceLexer() // 消费标识符
            }
            // 检查是否有参数
            if (builder.tokenType === PARENTHESIS_L) {
                builder.advanceLexer() // 消费 (
                // TODO: 解析参数列表
                while (!builder.eof() && builder.tokenType !== PARENTHESIS_R) {
                    builder.advanceLexer()
                }
                if (builder.tokenType === PARENTHESIS_R) {
                    builder.advanceLexer() // 消费 )
                } else {
                    marker.error("Expected )")
                    return true
                }
            }
            marker.done(Annotation)
            return true
        }
    }
}