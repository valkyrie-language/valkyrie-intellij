package valkyrie.language.ast

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.impl.source.tree.CompositeElement
import org.antlr.intellij.adaptor.psi.ScopeNode

class ValkyrieExtendsStatementNode(node: CompositeElement) : ASTWrapperPsiElement(node), ScopeNode {


    override fun getName(): String {
        return findChildByClass(ValkyrieNamepathNode::class.java)!!.name
    }


    override fun getContext(): ScopeNode? {
        return findScopeContext();
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }

}