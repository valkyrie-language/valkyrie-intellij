package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Array
import valkyrie.ast.ParserMonad
import valkyrie.ast.parsePaired
import valkyrie.cst.LBRACK
import valkyrie.cst.RBRACK
import valkyrie.cst.ValkyrieCST

class ValkyrieArrayNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object: ParserMonad {
        // 解析数组，支持结尾逗号可选
        override fun parse(builder: PsiBuilder): Boolean {
          return  builder.parsePaired(
              Array,
              LBRACK,
              RBRACK,
                ValkyrieCST.Companion.COMMA,
              ValkyrieArrayItemNode.Companion,
            )
        }
    }
}


