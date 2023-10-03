package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ValkyrieAST
import valkyrie.cst.ValkyrieCST

open class ValkyrieIdentifierNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析修饰符
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            when {
                builder.tokenType == ValkyrieCST.Companion.SYMBOL -> {
                    builder.advanceLexer()
                    marker.done(ValkyrieAST.Companion.Identifier)
                    return true
                }
                builder.tokenType == ValkyrieCST.Companion.SYMBOL_RAW -> {
                    builder.advanceLexer()
                    marker.done(ValkyrieAST.Companion.Identifier)
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