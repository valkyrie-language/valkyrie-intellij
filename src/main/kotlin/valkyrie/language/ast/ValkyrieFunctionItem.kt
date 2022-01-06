package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode

class ValkyrieFunctionItem(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ScopeNode {
    private val _identifier = findChildByClass(ValkyrieIdentifierNode::class.java)!!;

    override fun getName(): String {
        return _identifier.text
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return _identifier
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }
}


