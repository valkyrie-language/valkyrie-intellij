package valkyrie.ast.node

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import valkyrie.ast.InheritItem
import valkyrie.ast.ParserMonad
import valkyrie.ast.parseNamedTypeExpression

class ValkyrieInheritItemNode(node: ASTNode) : ASTWrapperPsiElement(node) {
    override fun getName(): String? {
        return "InheritItem"
    }

    companion object : ParserMonad {
        /** `named: BaseClass */
        override fun parse(builder: PsiBuilder): Boolean {
            return parseNamedTypeExpression(builder, InheritItem)
        }
    }
}

