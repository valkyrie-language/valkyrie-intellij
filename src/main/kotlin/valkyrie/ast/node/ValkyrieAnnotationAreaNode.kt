package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.AnnotationArea
import valkyrie.ast.parser.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.ast.advanceIgnore
import valkyrie.psi.ValkyrieElement

class ValkyrieAnnotationAreaNode(node: ASTNode) : ValkyrieElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitAnnotationArea(this)
            else -> visitor.visitElement(this)
        }
    }

    override fun toString(): String {
        return "AnnotationArea"
    }

    companion object : ParserMonad {
        // 解析注解列表
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieAnnotationList.parse(builder)
            builder.advanceIgnore()
            ValkyrieModifierListNode.parse(builder)
            marker.done(AnnotationArea)
            return true
        }
    }
}


