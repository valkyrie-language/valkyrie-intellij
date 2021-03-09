package com.github.valkyrie.ide.reference

import com.github.valkyrie.language.psi.ValkyrieClassStatement
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.PsiReferenceProvider
import com.intellij.util.ProcessingContext

class StructReferenceProvider : PsiReferenceProvider() {
    override fun getReferencesByElement(element: PsiElement, context: ProcessingContext): Array<PsiReference> {
        val element = element as ValkyrieClassStatement
        return arrayOf(
            ValkyrieReference(
                element.modifierSymbols.lastChild,
                element.modifierSymbols.lastChild.textRange
            )
        )
    }
}