package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.impl.source.tree.CompositeElement
import org.antlr.intellij.adaptor.psi.ScopeNode

class ValkyrieExtendsStatement(node: CompositeElement) : ASTWrapperPsiElement(node), ScopeNode {
    private val _identifier by lazy { ValkyrieNamepathNode.find(this)!! }

    override fun getName(): String {
        return _identifier.name
    }


    override fun getContext(): ScopeNode? {
        return parentScope;
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

}