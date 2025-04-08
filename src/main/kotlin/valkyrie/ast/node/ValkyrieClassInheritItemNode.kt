package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.InheritItem
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceIgnore
import valkyrie.cst.SYMBOL

class ValkyrieClassInheritItemNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object : ParserMonad {
        /** `class A(named: BaseClass, BaseClass)` */
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            // 解析可选的注解列表
            ValkyrieAnnotationAreaNode.parse(builder)
            builder.advanceIgnore()

            // 解析类名标识符
            if (builder.tokenType !== SYMBOL) {
                builder.error("Expected class name")
                marker.drop()
                return false
            }
            builder.advanceLexer()

            marker.done(InheritItem)
            return true
        }
    }
}