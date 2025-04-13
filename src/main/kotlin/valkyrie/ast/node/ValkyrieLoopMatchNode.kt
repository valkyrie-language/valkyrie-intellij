package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareMezzo
import valkyrie.ast.LoopInfinity
import valkyrie.ast.LoopMatch
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.KW_LOOP
import valkyrie.cst.KW_MATCH
import valkyrie.cst.KW_MEZZO
import valkyrie.psi.ValkyrieElement

class ValkyrieLoopMatchNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitLoopMatch(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        loop match { ... } else { ... }
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_LOOP) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费 loop 关键字
            

            if (builder.tokenType != KW_MATCH) {
                builder.error("Expected 'match' keyword")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费 match 关键字
            

            // 解析函数体
            if (!ValkyrieFunctionBodyNode.parse(builder)) {
                builder.error("Missing block")
                marker.drop()
                return false
            }

            // 解析可选的 else 分支
            ValkyrieElseNode.parse(builder)

            marker.done(LoopMatch)
            return true
        }
    }
}

