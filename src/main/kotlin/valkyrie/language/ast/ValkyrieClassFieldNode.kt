package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.psi.tree.IElementType
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree
import org.antlr.intellij.adaptor.psi.ScopeNode

class ValkyrieClassFieldNode(node: ASTNode, type: IElementType) : IdentifierDefSubtree(node, type), ScopeNode {
    val field: ValkyrieIdentifierNode;
    val modifiers: Array<ValkyrieIdentifierNode>;

    init {
        val fields = findChildrenByClass(ValkyrieIdentifierNode::class.java);
        field = fields.last()
        modifiers = fields.dropLast(1).toTypedArray()
    }

    override fun getName(): String {
        return field.name
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return field
    }

    override fun resolve(element: PsiNamedElement?): PsiElement? {
        TODO("Not yet implemented")
    }
}

