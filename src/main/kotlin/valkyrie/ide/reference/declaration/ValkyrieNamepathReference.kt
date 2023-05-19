package valkyrie.ide.reference.declaration

import com.intellij.codeInsight.daemon.EmptyResolveMessageProvider
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.node.ValkyrieIdentifier
import valkyrie.psi.node.ValkyrieIdentifierNode


class ValkyrieNamepathReference : PsiPolyVariantReference, EmptyResolveMessageProvider {
    private var origin: PsiElement
    private var parts: Array<ValkyrieIdentifierNode> = arrayOf()
    private var index: Int = 0
    private val target: ValkyrieIdentifierNode
        get() {
            return parts[index]
        }

    constructor(origin: PsiElement, parts: List<ValkyrieIdentifier>, index: Int) {
        this.parts = parts.map { it as ValkyrieIdentifierNode }.toTypedArray()
        this.index = index
        this.origin = origin
    }

    override fun getElement(): PsiElement {
        return origin
    }


    override fun getRangeInElement(): TextRange {
        return TextRange(target.startOffset - origin.startOffset, target.endOffset - origin.startOffset)
    }

    override fun resolve(): PsiElement? {
        return null
    }


    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        return resolveSequence().map { PsiElementResolveResult(it) }.toList().toTypedArray()
    }

    private fun resolveSequence() = sequence {
        for (child in target.containingFile.children) {
            when (child) {
                is ValkyrieDeclaration -> {
                    if (target.name == child.name) {
                        yield(child)
                    }
                }
            }
        }
    }


    override fun getCanonicalText(): String {
        return "getCanonicalText"
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
        return false
    }


    fun highlight(highlighter: NodeHighlighter) {
        when (val raw = this.resolveSequence().firstOrNull()) {
            is ValkyrieDeclaration -> raw.color?.let { highlighter.highlight(this.target, it) }
            else -> {}
        }
    }

    companion object {
        fun fromList(node: PsiElement, children: List<ValkyrieIdentifier>): Array<ValkyrieNamepathReference> {
            return List(children.size) { index -> ValkyrieNamepathReference(node, children, index) }.toTypedArray()
        }
    }

    override fun getUnresolvedMessagePattern(): String {
        return "getUnresolvedMessagePattern"
    }
}



