package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ValkyrieAST
import valkyrie.cst.ValkyrieCST

class ValkyrieAtomicNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析类定义
        // 解析原子表达式
         fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            when (builder.tokenType) {
                ValkyrieCST.Companion.LBRACE -> {
                    ValkyrieObjectNode.parse(builder)
                }
                ValkyrieCST.Companion.LBRACK -> {
                    ValkyrieArrayNode.parse(builder)
                }
                ValkyrieCST.Companion.STRING,
                ValkyrieCST.Companion.NUMBER,
                ValkyrieCST.Companion.SYMBOL -> {
                    builder.advanceLexer() // 消费值
                }
                else -> {
                    marker.drop()
                    return false
                }
            }

            marker.done(ValkyrieAST.Companion.ATOMIC)
            return true
        }
    }
}