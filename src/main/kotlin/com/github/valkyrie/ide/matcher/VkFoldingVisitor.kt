package com.github.valkyrie.ide.matcher


import com.github.valkyrie.language.psi.*
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.psi.PsiElement

class VkFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : FluentRecursiveVisitor() {

//    override fun visitInlinePlaceable(o: FluentInlinePlaceable) {
//        descriptors += FoldingDescriptor(o.node, TextRange(o.firstChild.endOffset, o.lastChild.startOffset))
//        super.visitInlinePlaceable(o)
//    }
//
//    override fun visitMessage(o: FluentMessage) {
//        //TODO: folding end of =
//        super.visitMessage(o)
//    }



    private fun fold(element: PsiElement) {
        descriptors += FoldingDescriptor(element.node, element.textRange)
    }
}
