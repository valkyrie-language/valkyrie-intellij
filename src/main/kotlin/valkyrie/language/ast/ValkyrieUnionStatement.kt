package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.impl.source.tree.CompositeElement
import org.antlr.intellij.adaptor.psi.ScopeNode

class ValkyrieUnionStatement(node: CompositeElement) : ASTWrapperPsiElement(node), PsiNameIdentifierOwner, ScopeNode {
    override fun setName(name: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun getNameIdentifier(): PsiElement {
        return findChildByClass(ValkyrieNamepathNode::class.java)!!;
    }

    override fun getContext(): ScopeNode? {
        return parentScope
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

}