package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParseMonad
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.parsePaired
import valkyrie.cst.ValkyrieCST

class ValkyrieArrayNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object: ParseMonad {
        // 解析数组，支持结尾逗号可选
        override fun parse(builder: PsiBuilder): Boolean {
          return  builder.parsePaired(
                ValkyrieAST.Array,
                ValkyrieCST.Companion.LBRACK,
                ValkyrieCST.Companion.RBRACK,
                ValkyrieCST.Companion.COMMA,
              ValkyrieArrayItemNode.Companion,
            )
        }
    }
}


