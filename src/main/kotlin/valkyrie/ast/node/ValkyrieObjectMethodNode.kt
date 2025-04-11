package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.DefineMethod
import valkyrie.ast.ParserMonad
import valkyrie.ast.advanceIgnore

class ValkyrieObjectMethodNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "ObjectMethod"
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            val marker = builder.mark()
            ValkyrieAnnotationAreaNode.parse(builder)
            builder.advanceIgnore()
            // 解析字段名
            if (ValkyrieIdentifierNode.parse(builder)) {
                builder.advanceIgnore()
            } else {
                marker.drop()
                return false
            }
            // 解析形式参数
            if (ValkyrieParameterListNode.parse(builder)) {
                marker.done(DefineMethod)
                return true
            } else {
                marker.drop()
                return false
            }
        }
    }
}

