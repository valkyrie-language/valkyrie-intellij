package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Operator
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.advanceIgnore

class ValkyrieOperatorNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val mark = builder.mark()
            
            builder.advanceLexer()
            
            mark.done(Operator)
            return true
        }
    }
}