package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode

class ValkyrieClassMethodNode(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ScopeNode {
    val field by lazy { ModifiedNamepath.findIdentifier(this) }
    val modifiers by lazy { ModifiedNamepath.findModifiers(this) };
    override fun getName(): String {
        return super.getName()!!
    }

    override fun getNameIdentifier(): PsiElement {
        return super.getNameIdentifier()!!
    }


    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }


}