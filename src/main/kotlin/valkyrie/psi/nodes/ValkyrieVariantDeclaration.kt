package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.NlsSafe
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.traits.HasHighlighter
import valkyrie.ide.highlight.ValkyrieColor

/**
 * Union Variant 实现
 */
class ValkyrieVariantDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner, HasHighlighter {
    override val highlightColor: ValkyrieColor
        get() = ValkyrieColor.VARIANT_DECLARATION
    
    override val highlightElement: PsiElement?
        get() = nameIdentifier
    override fun getNameIdentifier(): PsiElement? {
        return findChildByClass(ValkyrieIdentifierNode::class.java)
    }

    override fun getNavigationElement(): PsiElement {
        return nameIdentifier ?: this
    }

    override fun getName(): String? {
        return nameIdentifier?.text
    }

    override fun setName(name: String): PsiElement {
        val nameIdentifier = getNameIdentifier()
        if (nameIdentifier is ValkyrieIdentifierNode) {
            return nameIdentifier.setName(name)
        }
        return this
    }

    fun getVariantBody(): ValkyrieObjectBodyNode? {
        return findChildByClass(ValkyrieObjectBodyNode::class.java)
    }
}