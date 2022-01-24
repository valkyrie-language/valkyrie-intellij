package valkyrie.language.ast

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.PsiTreeUtil
import org.antlr.intellij.adaptor.psi.IdentifierDefSubtree


class ValkyrieNamepathNode(node: ASTNode, type: IElementType, val free: Boolean = false) : IdentifierDefSubtree(node, type) {
    val identifiers = findChildrenByClass(ValkyrieIdentifierNode::class.java)

    override fun getName(): String {
        return nameIdentifier.name
    }

    override fun getNameIdentifier(): ValkyrieIdentifierNode {
        return identifiers.last()
    }

    val parentIdentifier: Array<ValkyrieIdentifierNode> = identifiers.dropLast(1).toTypedArray()
    val namespace: String = parentIdentifier.joinToString(".") { it.text }

    companion object {
        fun find(node: PsiElement): ValkyrieNamepathNode? {
            return PsiTreeUtil.getChildOfType(node, ValkyrieNamepathNode::class.java)
        }
    }
}