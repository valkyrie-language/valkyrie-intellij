package com.github.valkyrie.ide.reference

import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.github.valkyrie.language.psi.ValkyrieTaggedStatement
import com.github.valkyrie.language.psi_node.ValkyrieTaggedStatementNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext

class EnumReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        val e = element as ValkyrieTaggedStatementNode
        return arrayOf(
            ValkyrieReference(
                e.modifierSymbols.lastChild,
                e.modifierSymbols.lastChild.textRange
            )
        )
    }
}