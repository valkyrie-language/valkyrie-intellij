package valkyrie.psi.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.psi.ValkyrieElementNode
import valkyrie.psi.traits.HasAnnotation
import valkyrie.psi.traits.HasObjectBody
import valkyrie.psi.traits.HasHighlighter
import valkyrie.ide.highlight.ValkyrieColor
import valkyrie.language.ValkyrieIcons

class ValkyrieTraitDeclaration(node: ASTNode) : ValkyrieElementNode(node), PsiNameIdentifierOwner, HasAnnotation, HasObjectBody, HasHighlighter {
    override val highlightColor: ValkyrieColor
        get() = ValkyrieColor.TRAIT_DECLARATION
    
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

    override fun getPresentation(): ItemPresentation {
        return PresentationData(
            "${name ?: "<anonymous-trait>"}",
            null,
            ValkyrieIcons.TRAIT,
            ValkyrieColor.TRAIT_DECLARATION.textAttributesKey
        )
    }
}