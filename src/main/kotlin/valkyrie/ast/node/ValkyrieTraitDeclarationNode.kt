package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParseMonad
import valkyrie.ast.ValkyrieAST
import valkyrie.ast.advanceIgnore
import valkyrie.cst.ValkyrieCST

class ValkyrieTraitDeclarationNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ValkyrieTraitDeclaration"
    }
    companion object: ParseMonad {
      override  fun parse(builder: PsiBuilder): Boolean {
            // 解析注解和修饰符
            while (true) {
                builder.advanceIgnore()
                when (builder.tokenType) {
                    ValkyrieCST.Companion.OP_MACRO -> {
                        if (!ValkyrieAnnotationNode.parse(builder)) return false
                    }
                    ValkyrieCST.Companion.IDENTIFIER -> {
                        if (!ValkyrieModifierNode.parse(builder)) break
                    }
                    else -> break
                }
            }

            // 检查是否是trait关键字
            if (builder.tokenType !== ValkyrieCST.Companion.TRAIT) {
                return false
            }
            val marker = builder.mark()
            builder.advanceLexer() // 消费trait关键字

            builder.advanceIgnore()

            // 解析trait名称
            if (builder.tokenType !== ValkyrieCST.Companion.IDENTIFIER) {
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

            marker.done(ValkyrieAST.Companion.DefineTrait)
            return true
        }
    }
}
