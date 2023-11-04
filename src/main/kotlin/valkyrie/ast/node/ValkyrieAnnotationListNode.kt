package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.ParserMonad

class ValkyrieAnnotationListNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun toString(): String {
        return "AnnotationList"
    }

    companion object : ParserMonad {
        // 解析注解列表
        override fun parse(builder: PsiBuilder): Boolean {
//            while (builder.tokenType === OP_MACRO_LOWER) {
//                hasAnnotation = true
//                val annotationMarker = builder.mark()
//                // 尝试解析多注解
//                if (!ValkyrieAnnotationManyNode.parse(builder)) {
//                    // 如果不是多注解，尝试解析单个注解
//                    if (!ValkyrieAnnotationNode.parse(builder)) {
//                        annotationMarker.error("Expected annotation")
//                        // 确保前进到下一个token，避免无限循环
//                        builder.advanceLexer()
//                        continue
//                    }
//                    annotationMarker.drop()
//                } else {
//                    annotationMarker.drop()
//                }
//                builder.advanceIgnore()
//            }

            return true
        }
    }
}