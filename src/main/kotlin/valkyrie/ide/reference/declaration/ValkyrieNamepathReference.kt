package valkyrie.ide.reference.declaration

import com.intellij.codeInsight.daemon.EmptyResolveMessageProvider
import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.util.endOffset
import com.intellij.psi.util.startOffset


import valkyrie.ide.highlight.NodeHighlighter
import valkyrie.language.file.ValkyrieFileNode
import valkyrie.language.file.ValkyrieFileNode.Companion.definitions
import valkyrie.psi.ValkyrieDeclaration
import valkyrie.psi.mixin.MixinIdentifier
import valkyrie.psi.mixin.MixinNamepath




class ValkyrieNamepathReference : PsiPolyVariantReference, EmptyResolveMessageProvider {
    private var origin: MixinNamepath
    private var index: Int = 0
    private val target: MixinIdentifier
        get() = origin.namepath[index]

    constructor(origin: MixinNamepath, index: Int) {
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

    private fun resolveSequence(): Sequence<ValkyrieDeclaration> {
        val file = element.containingFile as? ValkyrieFileNode
        return sequence {
            for (definition in file.definitions) {
                if (definition.name == target.name) {
                    yield(definition)
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
        fun fromList(node: MixinNamepath): Array<ValkyrieNamepathReference> {
            return List(node.namepath.size) { index -> ValkyrieNamepathReference(node, index) }.toTypedArray()
        }
    }

    override fun getUnresolvedMessagePattern(): String {
        return "getUnresolvedMessagePattern"
    }
}



