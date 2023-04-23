package valkyrie.ide.reference.declaration

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.impl.source.resolve.reference.impl.PsiPolyVariantCachingReference
import valkyrie.ide.highlight.HighlightColor
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.psi.node.*

open class ValkyrieReference : PsiPolyVariantCachingReference {
    private val namepath: ValkyrieNamepathNode

    constructor(element: ValkyrieNamepathNode) {
        this.namepath = element
    }


    override fun getElement(): ValkyrieIdentifierNode {
        return namepath.lastChild as ValkyrieIdentifierNode
    }

    override fun getRangeInElement(): TextRange {
        return TextRange(0, namepath.text.length)
    }

    override fun getAbsoluteRange(): TextRange {
        return super.getAbsoluteRange()
    }

    override fun resolve(): PsiElement? {
//        return null
        return namepath.containingFile.definitions.find(element)
    }


    override fun resolveInner(incompleteCode: Boolean, containingFile: PsiFile): Array<ResolveResult> {
        if (containingFile !is ValkyrieFileNode) return arrayOf()
        val list: MutableList<ResolveResult> = mutableListOf()
        for (mutableEntry in containingFile.definitions.getCache()) {
            list.add(PsiElementResolveResult(mutableEntry.value))
        }
        return list.toTypedArray()
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
        return when (element) {
            is PsiNameIdentifierOwner -> true
            else -> false
        }
    }


    override fun isSoft(): Boolean {
        TODO("Not yet implemented")
    }


    fun highlight(highlighter: NodeHighlighter) {
        return when (this.resolve()) {
            is ValkyrieDeclareClass -> highlighter.highlight(namepath, HighlightColor.SYM_CLASS)
            is ValkyrieDeclareUnion -> highlighter.highlight(namepath, HighlightColor.SYM_CLASS)
            is ValkyrieDeclareUnite -> highlighter.highlight(namepath, HighlightColor.SYM_CONSTANT)
            else -> {

            }
        }
    }
}



