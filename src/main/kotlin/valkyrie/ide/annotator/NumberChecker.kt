// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package valkyrie.ide.annotator

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import valkyrie.ide.actions.ConvertNumberBase
import valkyrie.language.psi_node.ValkyrieNumberNode

class NumberChecker : Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is ValkyrieNumberNode) return
        val unit = when (val id = element.identifier) {
            null -> ""
            else -> id.text
        }
        annotateSimple(element.firstChild, holder)
    }

    private fun annotateSimple(number: PsiElement, holder: AnnotationHolder) {
        holder.newAnnotation(HighlightSeverity.INFORMATION, "Base 10 Integer")
            .range(number.textRange)
            .withFix(ConvertNumberBase(16))
            .withFix(ConvertNumberBase(8))
            .withFix(ConvertNumberBase(2))
            .create()
    }

    private fun annotateUnit(number: PsiElement, unit: String, holder: AnnotationHolder, range: TextRange) {
        holder.newAnnotation(HighlightSeverity.WARNING, "Out of range")
            .range(range)
            .create()
    }
}

