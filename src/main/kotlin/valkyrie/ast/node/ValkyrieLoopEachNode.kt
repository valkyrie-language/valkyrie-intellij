package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareMezzo
import valkyrie.ast.LoopEach
import valkyrie.ast.LoopInfinity
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.KW_EACH
import valkyrie.cst.KW_IN
import valkyrie.cst.KW_LOOP
import valkyrie.cst.KW_MEZZO
import valkyrie.cst.SYMBOL
import valkyrie.psi.ValkyrieElement

class ValkyrieLoopEachNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitLoopEach(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        loop a in b { ... }
        loop each a in b { ... } else { ... }
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_LOOP) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费 loop 关键字
            

            // 检查是否有 each 关键字
            val hasEach = builder.tokenType == KW_EACH
            if (hasEach) {
                builder.advanceLexer() // 消费 each 关键字
                
            }

            // 解析迭代变量名
            if (builder.tokenType != SYMBOL) {
                builder.error("Expected variable name")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费变量名
            

            // 解析 in 关键字
            if (builder.tokenType != KW_IN) {
                builder.error("Expected 'in' keyword")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费 in 关键字
            

            // 解析迭代对象表达式
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

            marker.done(LoopEach)
            return true
        }
    }
}