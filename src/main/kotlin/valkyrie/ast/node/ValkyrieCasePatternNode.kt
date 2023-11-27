package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.CasePattern
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.KW_CASE
import valkyrie.cst.OP_ARROW
import valkyrie.psi.ValkyrieElement

class ValkyrieCasePatternNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitCasePattern(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        /** ```vk
        case pattern => expression
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_CASE) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费 case 关键字
            

            // 解析模式
            if (!ValkyrieLetPatternNode.parse(builder)) {
                builder.error("Expected pattern")
                marker.drop()
                return false
            }
            

            // 解析箭头
            if (builder.tokenType != OP_ARROW) {
                builder.error("Expected '=>'")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费箭头
            

            // 解析表达式
            if (!ValkyrieValueNode.parse(builder)) {
                builder.error("Expected expression")
                marker.drop()
                return false
            }

            marker.done(CasePattern)
            return true
        }
    }
}