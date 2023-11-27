package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.MatchExpression
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.BRACE_L
import valkyrie.cst.BRACE_R
import valkyrie.cst.KW_CASE
import valkyrie.cst.KW_MATCH
import valkyrie.psi.ValkyrieElement

class ValkyrieMatchNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitMatchStatement(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        /** ```vk
        match expression {
        case pattern => expression
        case pattern => expression
        ...
        }
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_MATCH) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费 match 关键字


            // 解析匹配的表达式
            if (!ValkyrieValueNode.parse(builder)) {
                builder.error("Expected expression")
                marker.drop()
                return false
            }


            // 解析左大括号
            if (builder.tokenType != BRACE_L) {
                builder.error("Expected '{'")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费左大括号


            // 解析多个 case 分支
            var hasCase = false
            while (builder.tokenType == KW_CASE) {
                if (!ValkyrieCasePatternNode.parse(builder)) {
                    builder.error("Invalid case pattern")
                    marker.drop()
                    return false
                }
                hasCase = true

            }

            if (!hasCase) {
                builder.error("Expected at least one case pattern")
                marker.drop()
                return false
            }

            // 解析右大括号
            if (builder.tokenType != BRACE_R) {
                builder.error("Expected '}'")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费右大括号

            marker.done(MatchExpression)
            return true
        }
    }
}