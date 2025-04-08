package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.MODIFIER
import valkyrie.cst.ValkyrieCST

class ValkyrieModifierNode(node: ASTNode) : ValkyrieIdentifierNode(node) {
    companion object {
        // 解析修饰符
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            when {
                builder.tokenType == ValkyrieCST.Companion.SYMBOL -> {
                    builder.advanceLexer()
                    marker.done(MODIFIER)
                    return true
                }

                builder.tokenType == ValkyrieCST.Companion.SYMBOL_RAW -> {
                    builder.advanceLexer()
                    marker.done(MODIFIER)
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

