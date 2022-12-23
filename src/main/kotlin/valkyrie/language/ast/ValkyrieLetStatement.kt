package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import org.antlr.intellij.adaptor.psi.ScopeNode
import valkyrie.language.antlr.parentScope

class ValkyrieLetStatement(node: ASTNode) : ASTWrapperPsiElement(node), ScopeNode {

    override fun getContext(): ScopeNode? {
        return parentScope
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }
}


