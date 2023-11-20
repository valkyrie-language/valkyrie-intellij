package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareEnums
import valkyrie.ast.DeclareMicro
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_ENUMERATE
import valkyrie.cst.KW_UNION

class ValkyrieEnumsNode(node: ASTNode) : ValkyrieMixtureNode(node) {
    override fun accept(visitor: PsiElementVisitor) {
        when (visitor) {
            is ValkyrieVisitor -> visitor.visitDeclareEnums(this)
            else -> visitor.visitElement(this)
        }
    }

    companion object : ParserMonad {
        override fun parse(builder: PsiBuilder): Boolean {
            return parseMixture(builder, ParseKeywords(KW_ENUMERATE), DeclareEnums, false)
        }
    }
}