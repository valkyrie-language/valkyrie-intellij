package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.LoopInfinity
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.KW_LOOP

class ValkyrieLoopWhileNode(node: ASTNode) : ValkyrieFunctionDeclareNode(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitLoopWhile(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        loop while <EXPR_INLINE> else { ... }
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_LOOP) {
                return false
            }
            val marker = builder.mark();
            builder.advanceLexer()

            if (!ValkyrieFunctionBodyNode.parse(builder)) {
                builder.error("Missing block")
            }
            ValkyrieElseNode.parse(builder)
            marker.done(LoopInfinity)
            return true
        }
    }
}

