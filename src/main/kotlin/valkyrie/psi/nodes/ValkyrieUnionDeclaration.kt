package valkyrie.psi.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.language.ValkyrieIcons
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.HasHighlighter

/**
 * Union 语句实现
 */
class ValkyrieUnionDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner, HasHighlighter {
    override val highlightColor: ValkyrieColor
        get() = ValkyrieColor.UNION_DECLARATION
    
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

    fun getUnionBody(): ValkyrieUnionBodyNode? {
        return findChildByClass(ValkyrieUnionBodyNode::class.java)
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData(
            "${name ?: "<anonymous-union>"}",
            null,
            ValkyrieIcons.UNION,
            ValkyrieColor.UNION_DECLARATION.textAttributesKey
        )
    }
}