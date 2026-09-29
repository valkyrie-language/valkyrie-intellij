package valkyrie.surface.psi.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.surface.parser.ValkyrieElementNode
import valkyrie.surface.parser.ValkyrieTypes
import valkyrie.surface.traits.HasHighlighter
import valkyrie.editing.highlight.ValkyrieColor
import valkyrie.surface.file.ValkyrieIcons

/**
 * Domain 声明实现
 */
class ValkyrieDomainDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner, HasHighlighter {
    override val highlightColor: ValkyrieColor
        get() = ValkyrieColor.DOMAIN_DECLARATION
    
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

    fun getDomainName(): String? {
        return (findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_XID) ?: findChildByType<PsiElement>(ValkyrieTypes.SYMBOL_RAW))?.text
    }

    fun getModifierNodes(): List<ValkyrieModifierNode> {
        return findChildrenByClass(ValkyrieModifierNode::class.java).toList()
    }
    
    fun hasModifier(name: String): Boolean {
        return getModifierNodes().any { it.isModifier(name) }
    }
    
    fun isStatic(): Boolean {
        return hasModifier("static")
    }
    
    fun isMutable(): Boolean {
        return hasModifier("mut")
    }

    fun getDomainBody(): ValkyrieObjectBodyNode? {
        return findChildByClass(ValkyrieObjectBodyNode::class.java)
    }

    override fun getPresentation(): ItemPresentation {
        return PresentationData(
            "${name ?: "<anonymous-domain>"}",
            null,
            ValkyrieIcons.DOMAIN,
            ValkyrieColor.DOMAIN_DECLARATION.textAttributesKey
        )
    }
}