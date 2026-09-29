package valkyrie.surface.psi.nodes

import com.intellij.ide.projectView.PresentationData
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNameIdentifierOwner
import valkyrie.surface.parser.ValkyrieElementNode
import valkyrie.surface.traits.HasAnnotation
import valkyrie.surface.traits.HasObjectBody
import valkyrie.surface.traits.HasHighlighter
import valkyrie.editing.highlight.ValkyrieColor
import valkyrie.surface.file.ValkyrieIcons

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