package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.Identifier
import valkyrie.cst.SYMBOL
import valkyrie.cst.SYMBOL_RAW

open class ValkyrieIdentifierNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析修饰符
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            when {
                builder.tokenType == SYMBOL -> {
                    builder.advanceLexer()
                    marker.done(Identifier)
                    return true
                }
                builder.tokenType == SYMBOL_RAW -> {
                    builder.advanceLexer()
                    marker.done(Identifier)
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