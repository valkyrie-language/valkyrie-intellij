package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.LetStatement
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.COLON
import valkyrie.cst.SYMBOL
import valkyrie.psi.ValkyrieElement

class ValkyrieLetPatternNode(node: ASTNode) : ValkyrieElement(node) {
//    override fun accept(visitor: PsiElementVisitor) {
//        when (visitor) {
//            is ValkyrieVisitor -> visitor.visitTermPattern(this)
//            else -> visitor.visitElement(this)
//        }
//    }

    companion object : ParserMonad {
        /** ```vk
        pattern := identifier [: type]
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            // 解析标识符
            if (builder.tokenType != SYMBOL) {
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费标识符


            // 解析可选的类型约束
            if (builder.tokenType == COLON) {
                builder.advanceLexer() // 消费冒号


                if (!ValkyrieTypeExpressionNode.parse(builder)) {
                    builder.error("Expected type expression")
                    marker.drop()
                    return false
                }
            }

            marker.done(LetStatement)
            return true
        }
    }
}