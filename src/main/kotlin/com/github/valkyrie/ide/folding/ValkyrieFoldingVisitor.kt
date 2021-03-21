package com.github.valkyrie.ide.folding

import com.github.valkyrie.language.psi.ValkyrieRecursiveVisitor
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement

class ValkyrieFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : ValkyrieRecursiveVisitor() {

    override fun visitInlinePlaceable(o: FluentInlinePlaceable) {
        descriptors += FoldingDescriptor(o.node, TextRange(o.firstChild.endOffset, o.lastChild.startOffset))
        super.visitInlinePlaceable(o)
    }

    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
}