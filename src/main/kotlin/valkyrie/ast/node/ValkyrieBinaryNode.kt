package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder

class ValkyrieBinaryNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        // 解析二元表达式
        // 注意：当前实现仅为占位，未实现实际的二元表达式解析逻辑
        fun parse(builder: PsiBuilder): Boolean {
            // 这里应该实现二元表达式的解析逻辑
            // 例如：a + b, a * b 等
            // 暂时返回false，表示不支持二元表达式
            return false
        }
    }
}