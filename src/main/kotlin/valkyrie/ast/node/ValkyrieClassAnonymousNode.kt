package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.DeclareClass
import valkyrie.cst.KW_CLASS


class ValkyrieClassAnonymousNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    companion object {
        fun parse(builder: PsiBuilder): Boolean {
            return parseClass(builder, ParseKeywords(KW_CLASS), DeclareClass, true)
        }
    }
}
