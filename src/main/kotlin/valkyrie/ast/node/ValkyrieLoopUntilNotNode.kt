package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareMezzo
import valkyrie.ast.LoopInfinity
import valkyrie.ast.LoopUntilNot
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.KW_LOOP
import valkyrie.cst.KW_MEZZO
import valkyrie.cst.KW_NOT
import valkyrie.cst.KW_UNTIL
import valkyrie.psi.ValkyrieElement

class ValkyrieLoopUntilNotNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitLoopUntilNot(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        loop untile not <TYPE_PATTERN> { ... } else { ... }
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_LOOP) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费 loop 关键字
            

            if (builder.tokenType != KW_UNTIL) {
                builder.error("Expected 'until' keyword")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费 until 关键字
            

            if (builder.tokenType != KW_NOT) {
                builder.error("Expected 'not' keyword")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费 not 关键字
            

            // 解析类型模式
            if (!ValkyrieTypeExpressionNode.parse(builder)) {
                builder.error("Expected type pattern")
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

            marker.done(LoopUntilNot)
            return true
        }
    }
}

