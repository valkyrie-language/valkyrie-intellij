package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.DeclareTrait
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceIgnore
import valkyrie.cst.KW_TRAIT
import valkyrie.cst.OP_MACRO
import valkyrie.cst.SYMBOL

class ValkyrieTraitDeclarationNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ValkyrieTraitDeclaration"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            // 解析注解和修饰符
            while (true) {
                builder.advanceIgnore()
                when (builder.tokenType) {
                    OP_MACRO -> {
                        if (!ValkyrieAnnotationNode.parse(builder)) return false
                    }

                    SYMBOL -> {
                        if (!ValkyrieModifierNode.parse(builder)) break
                    }

                    else -> break
                }
            }

            // 检查是否是trait关键字
            if (builder.tokenType !== KW_TRAIT) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费trait关键字

            builder.advanceIgnore()

            // 解析trait名称
            if (builder.tokenType !== SYMBOL) {
                builder.error("Expected trait name")
                marker.drop()
                return false
            }
            builder.advanceLexer() // 消费trait名称

            builder.advanceIgnore()

            // 解析trait主体
            if (!ValkyrieObjectNode.parse(builder)) {
                marker.drop()
                return false
            }

            marker.done(DeclareTrait)
            return true
        }
    }
}
