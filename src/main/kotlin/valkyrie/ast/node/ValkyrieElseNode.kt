package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.LoopElse
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.parser.ParserMonad
import valkyrie.cst.KW_ELSE
import valkyrie.psi.ValkyrieElement

class ValkyrieElseNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitElseStatement(this)
            else -> visitor.visitElement(this)
        }
    }


    companion object : ParserMonad {
        /** ```vk
        else { ... }
        ``` */
        override fun parse(builder: PsiBuilder): Boolean {
            if (builder.tokenType != KW_ELSE) {
                return false
            }
            val marker = builder.mark();
            builder.advanceLexer()

            if (!ValkyrieFunctionBodyNode.parse(builder)) {
                builder.error("Missing else block")
            }

            marker.done(LoopElse)
            return true
        }
    }
}