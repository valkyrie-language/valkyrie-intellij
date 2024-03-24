package valkyrie.psi.nodes

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.ValkyrieTokenTypes
import valkyrie.psi.traits.HasHighlighter

/**
 * Field 声明实现
 */
class ValkyrieFieldDeclaration(node: ASTNode) : ValkyrieElementNode(node),
    PsiNameIdentifierOwner,
    HasHighlighter  //
{
    override val highlightColor: ValkyrieColor
        get() = ValkyrieColor.FIELD_DECLARATION

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

    fun getFieldName(): String? {
        return findChildByType<PsiElement>(ValkyrieTokenTypes.IDENTIFIER_STD)?.text
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

    fun getTypeReference(): ValkyrieTypeReferenceNode? {
        return findChildByClass(ValkyrieTypeReferenceNode::class.java)
    }
}