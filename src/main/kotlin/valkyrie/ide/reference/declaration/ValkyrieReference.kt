package valkyrie.ide.reference.declaration

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiQualifiedReference
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.highlight.NodeHighlighter
import yggdrasil.psi.node.ValkyrieDeclareClass
import yggdrasil.psi.node.ValkyrieDeclareUnion
import yggdrasil.psi.node.ValkyrieDeclareUnite
import yggdrasil.psi.node.ValkyrieIdentifierNode

open class ValkyrieReference : PsiQualifiedReference {
    private val _element: ValkyrieIdentifierNode

    constructor(element: ValkyrieIdentifierNode) {
        this._element = element
    }

    override fun getElement(): ValkyrieIdentifierNode {
        return _element
    }

    override fun getRangeInElement(): TextRange {
        return TextRange(0, _element.text.length)
    }

    override fun resolve(): PsiElement? {
        return _element.containingFile.definitions.find(_element)
    }

    override fun getCanonicalText(): String {
        TODO("Not yet implemented")
    }

    override fun handleElementRename(newElementName: String): PsiElement {
        TODO("Not yet implemented")
    }

    override fun bindToElement(element: PsiElement): PsiElement {
        TODO("Not yet implemented")
    }

    override fun isReferenceTo(element: PsiElement): Boolean {
        return resolve() == element
    }

    override fun isSoft(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getQualifier(): PsiElement? {
        TODO("Not yet implemented")
    }

    override fun getReferenceName(): String? {
        TODO("Not yet implemented")
    }

    fun highlight(highlighter: NodeHighlighter) {
        return when (this.resolve()) {
            is ValkyrieDeclareClass -> highlighter.highlight(_element, HighlightColor.SYM_STRUCTURE)
            is ValkyrieDeclareUnion -> highlighter.highlight(_element, HighlightColor.SYM_STRUCTURE)
            is ValkyrieDeclareUnite -> highlighter.highlight(_element, HighlightColor.SYM_CONSTANT)
            else -> {

            }
        }
    }
}