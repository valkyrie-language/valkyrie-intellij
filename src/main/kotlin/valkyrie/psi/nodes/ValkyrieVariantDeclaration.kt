package valkyrie.psi.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.parsers.ValkyrieElementNode
import valkyrie.psi.traits.HasHighlighter
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.language.ValkyrieIcons

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

    override fun getPresentation(): ItemPresentation {
        val hasBody = getVariantBody() != null
        val locationText = if (hasBody) "with body" else "simple variant"
        
        return PresentationData(
            "${name ?: "<anonymous-variant>"}",
            locationText,
            ValkyrieIcons.VARIANT,
            ValkyrieColor.VARIANT_DECLARATION.textAttributesKey
        )
    }
}