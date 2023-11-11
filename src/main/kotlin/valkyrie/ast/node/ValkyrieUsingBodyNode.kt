package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.DeclareNamespace
import valkyrie.ast.ParserMonad
import valkyrie.cst.KW_NAMESPACE
import valkyrie.psi.ValkyrieElement

class ValkyrieUsingBodyNode(node: ASTNode) : ValkyrieElement(node) {

    companion object : ParserMonad {
        /**
        ```vk
        .{a.b::{}}
        ```
         */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            if (builder.tokenType == KW_NAMESPACE) {
                marker.done(DeclareNamespace)
                return true
            } else {
                marker.drop()
                return false
            }
        }
    }
}