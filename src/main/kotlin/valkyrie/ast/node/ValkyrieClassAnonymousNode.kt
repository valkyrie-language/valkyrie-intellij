package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareClass
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_CLASS


class ValkyrieClassAnonymousNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitNewObject(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object {
        fun parse(builder: PsiBuilder): Boolean {
            return parseClass(builder, ParseKeywords(KW_CLASS), DeclareClass, true)
        }
    }
}
