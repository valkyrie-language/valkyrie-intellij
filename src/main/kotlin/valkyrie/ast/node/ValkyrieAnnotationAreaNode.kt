package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.AnnotationArea
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceIgnore
import valkyrie.psi.ValkyrieElement

class ValkyrieAnnotationAreaNode(node: ASTNode) : ValkyrieElement(node) {
    override fun toString(): String {
        return "AnnotationArea"
    }

    companion object : ParserMonad {
        // 解析注解列表
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieAnnotationListNode.parse(builder)
            builder.advanceIgnore()
            ValkyrieModifierListNode.parse(builder)
            marker.done(AnnotationArea)
            return true
        }
    }
}