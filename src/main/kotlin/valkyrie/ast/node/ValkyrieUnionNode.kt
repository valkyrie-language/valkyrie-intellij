package valkyrie.ast.node

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.psi.PsiElementVisitor
import valkyrie.ast.DeclareUnion
import valkyrie.ast.ParserMonad
import valkyrie.ast.ValkyrieVisitor
import valkyrie.cst.KW_UNION

class ValkyrieUnionNode(node: ASTNode) : ValkyrieMixtureNode(node) {
   override fun accept(visitor: PsiElementVisitor) {
       when (visitor) {
           is ValkyrieVisitor -> visitor.visitDeclareUnion(this)
           else -> visitor.visitElement(this)
       }
   }

   companion object : ParserMonad {
       override fun parse(builder: PsiBuilder): Boolean {
           return parseMixture(builder, ParseKeywords(KW_UNION), DeclareUnion, false)
       }
   }
}