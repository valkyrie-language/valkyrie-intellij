package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Keyword
import valkyrie.ast.ParserMonad
import valkyrie.psi.ValkyrieElement

class ValkyrieKeywordNode(node: ASTNode) : ValkyrieElement(node) {
    override fun getName(): String {
        return "Keyword"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            builder.advanceLexer()
            marker.done(Keyword)
            return true
        }
    }
}