package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Array
import valkyrie.ast.ParserMonad
import valkyrie.ast.parsePaired
import valkyrie.cst.BRACKET_L
import valkyrie.cst.BRACKET_R
import valkyrie.cst.COMMA

class ValkyrieArrayNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParserMonad {
        // 解析数组，支持结尾逗号可选
        override fun parse(builder: PsiBuilder): Boolean {
            return builder.parsePaired(
                Array,
                BRACKET_L,
                BRACKET_R,
                COMMA,
                ValkyrieArrayItemNode.Companion,
            )
        }
    }
}


