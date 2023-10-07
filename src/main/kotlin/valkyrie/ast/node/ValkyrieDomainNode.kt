package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.DefineDomain
import valkyrie.ast.advanceIgnore
import valkyrie.cst.LBRACE
import valkyrie.cst.OP_MACRO
import valkyrie.cst.SYMBOL

class ValkyrieDomainNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ValkyrieDomain"
    }

    companion object {
        fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()

            // 解析注解和修饰符
            while (builder.tokenType === OP_MACRO || builder.tokenType === SYMBOL) {
                if (builder.tokenType === OP_MACRO) {
                    // TODO: 解析注解
                    builder.advanceLexer()
                } else {
                    // TODO: 解析修饰符
                    builder.advanceLexer()
                }
                builder.advanceIgnore()
            }

            // 解析域名
            if (builder.tokenType !== SYMBOL) {
                builder.error("Expected domain name")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费域名
            builder.advanceIgnore()

            // 解析域体
            if (builder.tokenType !== LBRACE) {
                builder.error("Expected '{'")
                marker.drop()
                return false
            }
            ValkyrieObjectNode.parse(builder)

            marker.done(DefineDomain)
            return true
        }
    }
}