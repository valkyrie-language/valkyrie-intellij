package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.LoopWhile
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.KW_LOOP
import valkyrie.cst.KW_WHILE
import valkyrie.psi.ValkyrieElement

class ValkyrieLoopWhileNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitLoopWhile(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        loop while <EXPR_INLINE> { ... } else { ... }
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

            // 解析条件表达式
            if (!ValkyrieValueNode.parse(builder)) {
                builder.error("Expected condition expression")
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

            marker.done(LoopWhile)
            return true
        }
    }
}

