package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ATOMIC
import valkyrie.cst.LBRACE
import valkyrie.cst.LBRACK
import valkyrie.cst.NUMBER
import valkyrie.cst.STRING
import valkyrie.cst.SYMBOL

class ValkyrieAtomicNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析类定义
        // 解析原子表达式
         fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            when (builder.tokenType) {
                LBRACE -> {
                    ValkyrieObjectNode.parse(builder)
                }
                LBRACK -> {
                    ValkyrieArrayNode.parse(builder)
                }
                STRING,
                NUMBER,
                SYMBOL
                    -> {
                    builder.advanceLexer() // 消费值
                }
                else -> {
                    marker.drop()
                    return false
                }
            }

            marker.done(ATOMIC)
            return true
        }
    }
}