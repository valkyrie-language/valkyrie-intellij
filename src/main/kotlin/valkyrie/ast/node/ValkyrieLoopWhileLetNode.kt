package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.LoopWhileLet
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.*
import valkyrie.psi.ValkyrieElement

class ValkyrieLoopWhileLetNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitLoopWhileLet(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        loop while let a = <EXPR_INLINE> { ... } else { ... }
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_LOOP) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费 loop 关键字


            if (builder.tokenType != KW_WHILE) {
                builder.error("Expected 'while' keyword")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费 while 关键字


            if (builder.tokenType != KW_LET) {
                builder.error("Expected 'let' keyword")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费 let 关键字


            // 解析变量名
            if (builder.tokenType != SYMBOL) {
                builder.error("Expected variable name")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费变量名


            // 解析等号
            if (builder.tokenType != BIND) {
                builder.error("Expected '='")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费等号


            // 解析表达式
            if (!ValkyrieValueNode.parse(builder)) {
                builder.error("Expected expression")
                marker.drop()
                return false
            }


            // 解析函数体
            if (!ValkyrieFunctionBodyNode.parse(builder)) {
                builder.error("Missing block")
                marker.drop()
                return false
            }

            // 解析可选的 else 分支
            ValkyrieElseNode.parse(builder)

            marker.done(LoopWhileLet)
            return true
        }
    }
}