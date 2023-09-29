package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ValkyrieAST
import valkyrie.cst.ValkyrieCST

class ValkyrieModifierNode(node: ASTNode) : ValkyrieIdentifierNode(node) {
    companion object {
        // 解析修饰符
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            when {
                builder.tokenType == ValkyrieCST.Companion.IDENTIFIER -> {
                    builder.advanceLexer()
                    marker.done(ValkyrieAST.Companion.MODIFIER)
                    return true
                }

                builder.tokenType == ValkyrieCST.Companion.IDENTIFIER_RAW -> {
                    builder.advanceLexer()
                    marker.done(ValkyrieAST.Companion.MODIFIER)
                    return true
                }

                else -> {
                    marker.drop()
                    return false
                }
            }
        }
    }
}

